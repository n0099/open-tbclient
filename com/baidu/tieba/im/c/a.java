package com.baidu.tieba.im.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.x;
import com.baidu.tieba.im.j;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PingMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.UpdateClientInfoMessage;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.y;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1475a = null;
    private static int g = 30000;
    private static int o = 60000;
    private static int p = VersionUtils.CUR_DEVELOPMENT;
    private static int q = 180000;
    private PublicKey z;
    private int b = 180000;
    private int c = 900000;
    private int d = 180000;
    private int e = 900000;
    private int f = 360000;
    private int h = 30000;
    private UpdateClientInfoMessage i = null;
    private int j = this.d;
    private int k = this.f;
    private int l = 0;
    private boolean m = false;
    private boolean n = false;
    private boolean r = false;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private long v = 0;
    private LinkedList<GroupMidData> w = new LinkedList<>();
    private int x = 0;
    private String y = "";
    private SecretKey A = null;
    private byte[] B = new byte[0];
    private int C = 0;
    private Handler D = new g(null);
    private e E = new e(this, null);
    private com.baidu.tieba.im.net.link.a F = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Long, Long> a(Message message) {
        boolean z;
        List<ChatMessage> a2;
        if (message instanceof ResponsePullMessage) {
            ResponsePullMessage responsePullMessage = (ResponsePullMessage) message;
            StringBuilder sb = new StringBuilder(200);
            if (responsePullMessage.hasError()) {
                Iterator<GroupMidData> it = this.w.iterator();
                while (it.hasNext()) {
                    GroupMidData next = it.next();
                    sb.append(next.getGroupId());
                    sb.append("-");
                    sb.append(next.getLastMsgId());
                    sb.append("|");
                }
                y.a(202003, 0, this.y, "MessageSync-receive-pullmsg", "fail", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.v, 0, sb.toString());
                return null;
            } else if (responsePullMessage.getGroupMsg() == null || responsePullMessage.getGroupMsg().size() == 0) {
                y.a(202003, 0, this.y, "MessageSync-receive-pullmsg", "succ-empty", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.v, 0, "");
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (GroupMsgData groupMsgData : responsePullMessage.getGroupMsg()) {
                    if (groupMsgData != null) {
                        long groupId = groupMsgData.getGroupInfo() != null ? groupMsgData.getGroupInfo().getGroupId() : 0L;
                        long msgId = (groupMsgData.getListMessage() == null || (a2 = groupMsgData.getListMessage().a()) == null || a2.size() <= 0) ? 0L : a2.get(a2.size() - 1).getMsgId();
                        if (groupId > 0 && msgId > 0) {
                            hashMap.put(Long.valueOf(groupId), Long.valueOf(msgId));
                        }
                    }
                }
                Iterator<GroupMidData> it2 = this.w.iterator();
                while (it2.hasNext()) {
                    GroupMidData next2 = it2.next();
                    sb.append(next2.getGroupId());
                    sb.append("-");
                    sb.append(next2.getLastMsgId());
                    sb.append("-");
                    Iterator<GroupMsgData> it3 = responsePullMessage.getGroupMsg().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        GroupMsgData next3 = it3.next();
                        if (next3 != null && next3.getGroupInfo() != null && next3.getGroupInfo().getGroupId() == next2.getGroupId() && next3.getListMessage() != null && next3.getListMessage().a() != null) {
                            z = true;
                            sb.append(next3.getListMessage().a().size());
                            break;
                        }
                    }
                    if (!z) {
                        sb.append(0);
                    }
                    sb.append("|");
                }
                y.a(202003, 0, this.y, "MessageSync-receive-pullmsg", "succ", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.v, 0, sb.toString());
                return hashMap;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.r) {
            h();
            this.r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<Long, Long> map) {
        x.a().a(new c(this, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.D.removeMessages(1);
    }

    private void p() {
        this.D.removeMessages(1);
        this.D.removeMessages(3);
        this.D.removeMessages(2);
        this.D.removeMessages(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i == 1001) {
            this.l++;
            this.m = false;
            this.n = false;
            if (this.l >= 3) {
                com.baidu.tieba.im.messageCenter.f.a().b();
            } else {
                this.D.sendMessageDelayed(this.D.obtainMessage(4), this.h);
            }
        } else if (i == 1003) {
            com.baidu.adp.lib.h.d.c("----ping error . reconnection...");
            y.a(1003, 0, "receive ping", "MessageSync-receive-ping", "fail", i2, "ping err", System.currentTimeMillis() - this.t, 0, "ping error. restartReconnStra");
            p();
            TiebaSocketLinkService.b();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1475a == null) {
                f1475a = new a();
            }
            aVar = f1475a;
        }
        return aVar;
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        s();
        com.baidu.tieba.im.messageCenter.f.a().a(-11, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(this.F);
        com.baidu.tieba.im.messageCenter.f.a().a(1003, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(1001, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(-111, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(-112, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(202003, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(202101, this.E);
        com.baidu.tieba.im.messageCenter.f.a().a(-12, this.E);
        b();
    }

    public void b() {
        int[] aX = TiebaApplication.g().aX();
        if (aX.length == 2) {
            a(aX[0] * LocationClientOption.MIN_SCAN_SPAN);
            b(aX[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
        int[] aY = TiebaApplication.g().aY();
        if (aY.length == 2) {
            c(aY[0] * LocationClientOption.MIN_SCAN_SPAN);
            d(aY[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
        int[] aZ = TiebaApplication.g().aZ();
        if (aZ.length > 0) {
            e(aZ[0] * LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    public boolean c() {
        return this.n;
    }

    public void d() {
        this.n = false;
        this.m = false;
        this.r = false;
        com.baidu.tieba.im.messageCenter.f.a().a(true);
        this.x = 3;
        i();
        o();
        this.D.sendMessageDelayed(a().D.obtainMessage(1), a().j);
        com.baidu.tieba.im.messageCenter.f.a().b(false);
    }

    public void e() {
        this.n = false;
        this.m = false;
        this.r = false;
        com.baidu.adp.lib.h.d.c("----msg sync stop");
        p();
        com.baidu.tieba.im.messageCenter.f.a().a(false);
        com.baidu.tieba.im.messageCenter.f.a().b(false);
    }

    public void f() {
        this.D.removeMessages(5);
        this.j = this.d;
        this.k = this.f;
        com.baidu.adp.lib.h.d.c("----switchToForeground");
        if (System.currentTimeMillis() - this.u > this.j && UtilHelper.b()) {
            com.baidu.tieba.im.messageCenter.f.a().b(true);
            y.a(1003, 0, "switchToForeground", "MessageSync-send-ping", "succ", 0, "", 0L, 0, "" + (System.currentTimeMillis() - this.u));
        }
    }

    public void g() {
        this.D.sendMessageDelayed(this.D.obtainMessage(5), this.b);
    }

    public void a(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public void c(int i) {
        if (i > 0) {
            this.f = i;
        }
    }

    public void d(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public void e(int i) {
        if (i > 0) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(IDuplicateProcess.RemoveState removeState, int i) {
        this.t = System.currentTimeMillis();
        this.u = System.currentTimeMillis();
        com.baidu.adp.lib.h.d.c("----sendPing");
        y.a(1003, 0, "send ping", "MessageSync-send-ping", "succ", 0, "", System.currentTimeMillis() - this.t, 0, "" + removeState);
        PingMessage pingMessage = new PingMessage();
        pingMessage.setRemoveState(removeState);
        com.baidu.tieba.im.messageCenter.f.a().a(pingMessage, true, -3, 1, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        PushCountMessage pushCountMessage = new PushCountMessage();
        pushCountMessage.setPusherCount(this.C);
        pushCountMessage.setUpFlowSize(l.a().h());
        pushCountMessage.setDownFlowSize(l.a().j());
        pushCountMessage.setEnterForeCount(TiebaApplication.g().aE());
        com.baidu.tieba.im.messageCenter.f.a().a(pushCountMessage);
        this.C = 0;
        l.a().i();
        l.a().g();
        TiebaApplication.g().aF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageSyncMessage r() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(new ArrayList());
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        if (d != null) {
            messageSyncMessage.setWidth(d.width);
            messageSyncMessage.setHeight(d.height);
        }
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        if (c != null) {
            messageSyncMessage.setSmallHeight(c.height);
            messageSyncMessage.setSmallWidth(c.width);
        }
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3) {
        this.C++;
        a(j, j2, j3, false);
    }

    public synchronized void h() {
        a(0L, 0L, 0L, true);
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        if (TiebaApplication.B()) {
            this.r = com.baidu.tieba.im.messageCenter.f.a().b(202003);
            if (!this.r) {
                if (!z) {
                    this.D.removeMessages(3);
                    a().D.sendMessageDelayed(a().D.obtainMessage(3), a().k);
                }
                com.baidu.adp.lib.h.d.c("----begin pullMessageForNewRemind");
                x.a().a(new d(this, j, j2, z));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap, long j) {
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return null;
        }
        return concurrentHashMap.get(String.valueOf(j));
    }

    private void s() {
        try {
            this.z = com.baidu.tieba.im.d.d.a(j.a());
            String a2 = com.baidu.tieba.im.d.d.a(32);
            byte[] bArr = new byte[a2.length()];
            for (int i = 0; i < a2.length(); i++) {
                bArr[i] = (byte) a2.charAt(i);
            }
            this.A = com.baidu.tieba.im.d.d.a(a2);
            this.B = com.baidu.tieba.im.d.d.a(this.z, bArr);
            com.baidu.tieba.im.codec.c.b().a(this.A);
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("heartbeat", "----failed to load public key.", e);
            com.baidu.tieba.im.codec.c.b().a((SecretKey) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        com.baidu.adp.lib.h.d.c("----online ing");
        if (!this.m) {
            this.m = true;
            if (z) {
                this.l = 0;
            }
            this.s = System.currentTimeMillis();
            this.i = u();
            y.a(1001, 0, t(), "MessageSync-send-online", "succ", 0, "", System.currentTimeMillis() - this.s, 0, "");
            com.baidu.tieba.im.messageCenter.f.a().a(this.i, true, -3, 1, o);
        }
    }

    private String t() {
        if (this.x == 3) {
            return "SOCKET_CONNECT";
        }
        if (this.x == 2) {
            return "SERVER_RESPONSE";
        }
        if (this.x != 1) {
            return "";
        }
        return "LOCAL_REQUEST";
    }

    public synchronized void i() {
        if (!this.n) {
            a(true);
        }
    }

    public synchronized void j() {
        this.n = false;
        com.baidu.tieba.im.messageCenter.f.a().a(true);
        a(true);
    }

    private UpdateClientInfoMessage u() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.g().p() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TiebaApplication.g().p());
        }
        String N = TiebaApplication.N();
        if (N != null) {
            updateClientInfoMessage.addUserInfo("_client_id", N);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", y);
        }
        String f = new ap().f();
        if (f != null) {
            updateClientInfoMessage.addUserInfo("net_type", f);
        }
        String o2 = TiebaApplication.g().o();
        if (o2 != null) {
            updateClientInfoMessage.addUserInfo(SocialConstants.PARAM_CUID, o2);
        }
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (TiebaApplication.g().P() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", SocialConstants.FALSE);
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", SocialConstants.TRUE);
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TiebaApplication.g().aj()));
        if (TiebaApplication.B()) {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.D());
            if (b != null) {
                updateClientInfoMessage.setBduss(b.mBduss);
            } else {
                updateClientInfoMessage.setBduss(TiebaApplication.D());
            }
        }
        int a2 = UtilHelper.a((Context) TiebaApplication.a(), 70.0f);
        updateClientInfoMessage.setHeight(UtilHelper.a((Context) TiebaApplication.a(), 70.0f));
        updateClientInfoMessage.setWidth(a2);
        updateClientInfoMessage.setSecretKey(this.B);
        return updateClientInfoMessage;
    }
}

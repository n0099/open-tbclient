package com.baidu.tieba.im.d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.j;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.UpdateClientInfoMessage;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.log.i;
import com.baidu.tieba.util.am;
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
    private static a f1639a = null;
    private PublicKey m;
    private boolean u;
    private long v;
    private long w;
    private int b = 900000;
    private int c = 360000;
    private UpdateClientInfoMessage d = null;
    private int e = this.c;
    private boolean f = false;
    private long g = 0;
    private LinkedList<GroupMidData> h = new LinkedList<>();
    private String i = "";
    private long j = 0;
    private int k = 0;
    private long l = 0;
    private SecretKey n = null;
    private byte[] o = new byte[0];
    private int p = 0;
    private long q = 0;
    private Handler r = new g(null);
    private e s = new e(this, null);
    private com.baidu.tieba.im.net.a t = new b(this);
    private com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> x = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(a aVar) {
        int i = aVar.k;
        aVar.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Long, Long> a(Message message) {
        boolean z;
        List<ChatMessage> a2;
        if (message instanceof ResponsePullMessage) {
            ResponsePullMessage responsePullMessage = (ResponsePullMessage) message;
            StringBuilder sb = new StringBuilder(200);
            if (responsePullMessage.hasError()) {
                Iterator<GroupMidData> it = this.h.iterator();
                while (it.hasNext()) {
                    GroupMidData next = it.next();
                    sb.append(next.getGroupId());
                    sb.append("-");
                    sb.append(next.getLastMsgId());
                    sb.append("|");
                }
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "fail", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.g, 0, sb.toString()));
                return null;
            } else if (responsePullMessage.getGroupMsg() == null || responsePullMessage.getGroupMsg().size() == 0) {
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ-empty", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.g, 0, ""));
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
                Iterator<GroupMidData> it2 = this.h.iterator();
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
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ", responsePullMessage.getErrNo(), responsePullMessage.getErrMsg(), System.currentTimeMillis() - this.g, 0, sb.toString()));
                return hashMap;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f) {
            g();
            this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<Long, Long> map) {
        ad.a().a(new d(this, map));
    }

    private void i() {
        this.r.removeMessages(3);
        this.r.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        TiebaSocketLinkService.a(8, "online error = " + i2);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1639a == null) {
                f1639a = new a();
            }
            aVar = f1639a;
        }
        return aVar;
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        l();
        com.baidu.tieba.im.messageCenter.e.a().a(-11, this.s);
        com.baidu.tieba.im.messageCenter.e.a().a(this.t);
        com.baidu.tieba.im.messageCenter.e.a().a(1003, this.s);
        com.baidu.tieba.im.messageCenter.e.a().a(1001, this.s);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.s);
        com.baidu.tieba.im.messageCenter.e.a().a(202101, this.s);
        b();
    }

    public void b() {
        int[] ba = TiebaApplication.h().ba();
        if (ba.length == 2) {
            a(ba[0] * LocationClientOption.MIN_SCAN_SPAN);
            b(ba[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    public void c() {
        this.f = false;
        m();
    }

    public void d() {
        this.f = false;
        com.baidu.adp.lib.h.e.c("----msg sync stop");
        i();
    }

    public void e() {
        com.baidu.adp.lib.h.e.c("----switchToForeground");
        this.e = this.c;
        if (this.k > 0) {
            g();
        }
    }

    public void f() {
        com.baidu.adp.lib.h.e.c("----switchToBackground");
        this.l = System.currentTimeMillis();
        a().e = a().b;
    }

    public void a(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (System.currentTimeMillis() - this.q >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.p);
            pushCountMessage.setUpFlowSize(m.a().h());
            pushCountMessage.setDownFlowSize(m.a().j());
            pushCountMessage.setEnterForeCount(TiebaApplication.h().aF());
            com.baidu.tieba.im.messageCenter.e.a().a(pushCountMessage);
            this.q = System.currentTimeMillis();
            this.p = 0;
            m.a().i();
            m.a().g();
            TiebaApplication.h().aG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageSyncMessage k() {
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
        this.p++;
        a(j, j2, j3, false);
    }

    public synchronized void g() {
        a(0L, 0L, 0L, true);
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        if (TiebaApplication.C()) {
            this.u = z;
            this.v = j;
            this.w = j2;
            if (!z) {
                this.r.removeMessages(3);
                a().r.sendMessageDelayed(a().r.obtainMessage(3), a().e);
            }
            com.baidu.adp.lib.h.e.c("----begin pullMessageForNewRemind");
            ad.a().a(this.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap, long j) {
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return null;
        }
        return concurrentHashMap.get(String.valueOf(j));
    }

    private void l() {
        try {
            this.m = com.baidu.tieba.im.e.e.a(j.a());
            String a2 = com.baidu.tieba.im.e.e.a(32);
            byte[] bArr = new byte[a2.length()];
            for (int i = 0; i < a2.length(); i++) {
                bArr[i] = (byte) a2.charAt(i);
            }
            this.n = com.baidu.tieba.im.e.e.a(a2);
            this.o = com.baidu.tieba.im.e.e.a(this.m, bArr);
            com.baidu.tieba.im.b.c.b().a(this.n);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("heartbeat", "----failed to load public key.", e);
            com.baidu.tieba.im.b.c.b().a((SecretKey) null);
        }
    }

    private synchronized void m() {
        com.baidu.adp.lib.h.e.c("start online");
        com.baidu.tieba.log.a.b(i.a(1001, 0, "on connect", "start online", null, 0, null));
        this.d = n();
        com.baidu.tieba.im.messageCenter.e.a().a(this.d, -3, 0, false);
    }

    private UpdateClientInfoMessage n() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.h().q() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TiebaApplication.h().q());
        }
        String L = TiebaApplication.L();
        if (L != null) {
            updateClientInfoMessage.addUserInfo("_client_id", L);
        }
        String z = TiebaApplication.z();
        if (z != null && z.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", z);
        }
        String h = new am().h();
        if (h != null) {
            updateClientInfoMessage.addUserInfo("net_type", h);
        }
        String p = TiebaApplication.h().p();
        if (p != null) {
            updateClientInfoMessage.addUserInfo(SocialConstants.PARAM_CUID, p);
        }
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (TiebaApplication.h().N() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", SocialConstants.FALSE);
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", SocialConstants.TRUE);
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TiebaApplication.h().ah()));
        if (TiebaApplication.C()) {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.E());
            if (b != null) {
                updateClientInfoMessage.setBduss(b.mBduss);
            } else {
                updateClientInfoMessage.setBduss(TiebaApplication.E());
            }
        }
        int a2 = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f));
        updateClientInfoMessage.setWidth(a2);
        updateClientInfoMessage.setSecretKey(this.o);
        return updateClientInfoMessage;
    }
}

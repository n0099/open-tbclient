package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static a h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    private static boolean l;
    private static boolean m;
    private static boolean n;
    NotificationManager a = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private com.baidu.tbadk.coreExtra.b.c i = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] o = new int[10];
    private final Context b = TbadkApplication.m252getInst().getApp();

    static {
        MessageManager.getInstance().registerListener(new b(2010004));
        MessageManager.getInstance().registerListener(new c(2010005));
        MessageManager.getInstance().registerListener(new d(2010018));
    }

    public static a a() {
        if (h == null) {
            h = new a();
        }
        return h;
    }

    public void b() {
        this.a = (NotificationManager) this.b.getSystemService("notification");
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i == this.c && i2 == this.d && i3 == this.e && i4 == this.f && i5 == this.g) {
            BdLog.i("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
            return;
        }
        int i6 = 0;
        if (i > this.c || i2 > this.d || i3 > this.e || i4 > this.f || i5 > this.g) {
            i6 = 1;
        } else if (i < this.c || i2 < this.d || i3 < this.e || i5 < this.g) {
            i6 = 2;
        }
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        int i7 = q() > 0 ? i6 : 2;
        if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
            j();
            a(i7, 16);
            a(i7, 17);
            a(i7, 11);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i != this.c || i2 != this.d || i3 != this.e || i4 != this.f) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            j();
            if (q() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean c() {
        TbadkApplication m252getInst = TbadkApplication.m252getInst();
        if (j == null) {
            j = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - j.getTime() < 10000) {
                j = date;
                return true;
            }
            j = date;
        }
        if (m252getInst.isNoDisturbOn()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = m252getInst.getNoDisturbStartTime().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = m252getInst.getNoDisturbEndTime().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt < parseInt2) {
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            } else if (parseInt > parseInt2) {
                if (i >= parseInt && i <= 1439) {
                    return true;
                }
                if (i >= 0 && i <= parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(int i, int i2) {
        if (this.a != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        int i3 = this.c + this.d;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.b.getString(y.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(y.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(y.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 != 16 && TbadkApplication.m252getInst().isGroupMsgOn()) {
                        TbadkApplication.m252getInst().getMsgFrequency();
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                BdLog.e(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0225 A[Catch: Exception -> 0x006b, TryCatch #0 {Exception -> 0x006b, blocks: (B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x0020, B:15:0x0024, B:17:0x002b, B:18:0x003d, B:20:0x0041, B:21:0x0055, B:26:0x0081, B:28:0x008b, B:30:0x0095, B:31:0x009f, B:33:0x00ab, B:35:0x00b5, B:39:0x00c2, B:41:0x00c8, B:44:0x00f1, B:46:0x00fb, B:47:0x0103, B:49:0x0109, B:50:0x0127, B:52:0x0130, B:55:0x013d, B:57:0x0146, B:60:0x016f, B:62:0x017d, B:63:0x019b, B:64:0x01a2, B:66:0x01ac, B:68:0x01b6, B:70:0x01c1, B:72:0x01c7, B:74:0x01cd, B:76:0x01dd, B:77:0x01f8, B:79:0x01fe, B:82:0x0206, B:84:0x0225, B:86:0x0231, B:95:0x0274, B:92:0x026c, B:87:0x023e, B:89:0x0244, B:91:0x024a, B:98:0x0295), top: B:105:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0231 A[Catch: Exception -> 0x006b, TryCatch #0 {Exception -> 0x006b, blocks: (B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x0020, B:15:0x0024, B:17:0x002b, B:18:0x003d, B:20:0x0041, B:21:0x0055, B:26:0x0081, B:28:0x008b, B:30:0x0095, B:31:0x009f, B:33:0x00ab, B:35:0x00b5, B:39:0x00c2, B:41:0x00c8, B:44:0x00f1, B:46:0x00fb, B:47:0x0103, B:49:0x0109, B:50:0x0127, B:52:0x0130, B:55:0x013d, B:57:0x0146, B:60:0x016f, B:62:0x017d, B:63:0x019b, B:64:0x01a2, B:66:0x01ac, B:68:0x01b6, B:70:0x01c1, B:72:0x01c7, B:74:0x01cd, B:76:0x01dd, B:77:0x01f8, B:79:0x01fe, B:82:0x0206, B:84:0x0225, B:86:0x0231, B:95:0x0274, B:92:0x026c, B:87:0x023e, B:89:0x0244, B:91:0x024a, B:98:0x0295), top: B:105:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.b.c cVar) {
        boolean z;
        long j2;
        String o;
        String n2;
        boolean z2 = false;
        boolean z3 = true;
        if (this.a != null && cVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        int i3 = this.c + this.d;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.b.getString(y.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(y.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(y.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16) {
                        int c = (!TbadkApplication.m252getInst().isGroupMsgOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) ? 0 : cVar.c() - cVar.l();
                        if (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
                            j2 = 0;
                        } else {
                            j2 = cVar.w();
                        }
                        boolean z4 = j2 > 0;
                        long j3 = c + j2;
                        if (j3 > 1) {
                            stringBuffer.append(String.format(this.b.getString(y.notify_chat), Long.valueOf(j3)));
                            a(16, (String) null, stringBuffer.toString(), z4);
                        } else if (j3 == 1) {
                            cVar.z();
                            cVar.x();
                            if (j2 == 1) {
                                o = cVar.z();
                                n2 = cVar.x();
                            } else if (c == 1) {
                                o = cVar.o();
                                n2 = cVar.n();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(n2)) {
                                n2 = stringBuffer.append(String.format(this.b.getString(y.notify_chat), Long.valueOf(j3))).toString();
                            }
                            a(16, o, n2, z4);
                        }
                    } else if (i2 == 19) {
                        long g = cVar.g();
                        if (g > 1) {
                            stringBuffer.append(String.format(this.b.getString(y.notify_official_message), Long.valueOf(g)));
                            a(19, (String) null, stringBuffer.toString());
                        } else if (g == 1) {
                            String j4 = cVar.j();
                            String k2 = cVar.k();
                            if (TextUtils.isEmpty(k2)) {
                                k2 = stringBuffer.append(String.format(this.b.getString(y.notify_official_message), Long.valueOf(g))).toString();
                            }
                            a(19, j4, k2);
                        }
                    } else if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                        if (cVar.d() + cVar.f() > 0) {
                            if (cVar.d() > 0 && !w()) {
                                long d = cVar.d() - cVar.e();
                                if (d > 0) {
                                    stringBuffer.append(String.format(this.b.getString(y.notify_updates), Long.valueOf(d)));
                                    z = false;
                                    z2 = true;
                                } else if (cVar.e() > 0) {
                                    z = true;
                                }
                                if (cVar.f() > 0 || v()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.b.getString(y.notify_validate), Integer.valueOf(cVar.f())));
                                } else {
                                    stringBuffer.append(String.format(this.b.getString(y.notify_validate_1), Integer.valueOf(cVar.f())));
                                }
                                if (z3) {
                                    a(17, (String) null, stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, cVar.q(), cVar.r());
                                }
                            }
                            z = false;
                            if (cVar.f() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (cVar.A() > 0 && !x()) {
                            a(21, (String) null, String.format(this.b.getString(y.notify_live), Integer.valueOf(cVar.A())));
                        }
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                BdLog.e(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private Notification t() {
        return new Notification(u.icon, this.b.getString(y.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    private void a(int i, String str, String str2, boolean z) {
        Intent a;
        Notification notification = new Notification(u.icon_notify, this.b.getString(y.notify_text), System.currentTimeMillis());
        if (this.a != null) {
            this.a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            a = h(i);
        } else if (i == 18) {
            a = u();
        } else {
            a = a(i, z);
        }
        a.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, a, 134217728);
        int i2 = 0;
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            i2 = field.getInt(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            notification = t();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            notification = t();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            notification = t();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            notification = t();
        } catch (SecurityException e5) {
            e5.printStackTrace();
            notification = t();
        }
        if (be.c(str) || (i != 16 && i != 18)) {
            notification.setLatestEventInfo(this.b, this.b.getString(y.app_name), str2, service);
        } else {
            notification.setLatestEventInfo(this.b, str, str2, service);
        }
        if (i2 != 0 && notification.contentView != null) {
            notification.contentView.setImageViewResource(i2, u.icon);
        }
        notification.defaults = -1;
        notification.flags = 16;
        if (c()) {
            notification.defaults &= -2;
            notification.defaults &= -3;
        } else {
            if (!TbadkApplication.m252getInst().isMsgVibrateOn()) {
                notification.defaults &= -3;
            }
            if (!TbadkApplication.m252getInst().isMsgToneOn()) {
                notification.defaults &= -2;
            } else {
                notification.audioStreamType = 5;
            }
        }
        if (this.a != null) {
            this.a.notify(i, notification);
        }
    }

    private Intent h(int i) {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 10);
        intent.putExtra("KeyOfNotiId", i);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String currentAccountName = TbadkApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    private Intent a(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.i.y().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.d);
        intent.putExtra("reply_me", this.c);
        intent.putExtra("fans", this.e);
        intent.putExtra("chat", n());
        intent.putExtra("group_msg", this.i.c() - this.i.l());
        intent.putExtra("group_msg_validate", this.i.f());
        intent.putExtra("group_msg_updates", this.i.d());
        intent.putExtra("live_notify_msg_updates", this.i.A());
        intent.putExtra("officialbar_msg", this.i.g());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent u() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.i.e());
        return intent;
    }

    public void d() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
            this.a.cancel(15);
            this.a.cancel(13);
            this.a.cancel(12);
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.cancel(16);
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.cancel(19);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c s = s();
        if (s == null) {
            e();
            return;
        }
        HashMap<String, String> s2 = s.s();
        if (s2 == null || s2.isEmpty()) {
            e();
        } else if (s2.containsKey(str)) {
            e();
        }
    }

    private boolean v() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2010004));
        return l;
    }

    private boolean w() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2010005));
        return m;
    }

    private boolean x() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2010018));
        return n;
    }

    public void g() {
        if (this.a != null) {
            this.a.cancel(17);
        }
    }

    public void a(int i) {
        com.baidu.tbadk.coreExtra.b.c s = s();
        if (s == null) {
            g();
        } else if (1 == i) {
            if (s.d() <= 0) {
                g();
            }
        } else if (2 == i) {
            if (s.f() <= 0) {
                g();
            }
        } else if (3 == i && s.A() <= 0 && this.a != null) {
            this.a.cancel(21);
        }
    }

    public void h() {
        if (this.a != null) {
            this.a.cancel(18);
        }
    }

    public void i() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
        }
    }

    public void j() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(l());
        newsNotifyMessage.setMsgBookmark(p());
        newsNotifyMessage.setMsgChat(o());
        newsNotifyMessage.setMsgFans(m());
        newsNotifyMessage.setMsgReplyme(k());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(l());
            newsNotifyMessage.setMsgBookmark(p());
            newsNotifyMessage.setMsgChat(((cVar.w() + cVar.c()) + cVar.g()) - cVar.l());
            newsNotifyMessage.setMsgFans(m());
            newsNotifyMessage.setMsgReplyme(k());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int k() {
        return this.c;
    }

    public void b(int i) {
        if (i >= 0) {
            a(i, this.d, this.e, this.f, this.g);
        }
    }

    public int l() {
        return this.d;
    }

    public void c(int i) {
        if (i >= 0) {
            a(this.c, i, this.e, this.f, this.g);
        }
    }

    public int m() {
        return this.e;
    }

    public void d(int i) {
        if (i >= 0) {
            a(this.c, this.d, i, this.f, this.g);
        }
    }

    public int n() {
        return this.f;
    }

    public int o() {
        return ((this.i.w() + this.i.c()) + this.i.g()) - this.i.l();
    }

    public void e(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, i, this.g);
        }
    }

    public int p() {
        return this.g;
    }

    public void f(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, this.f, i);
        }
    }

    public void a(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0);
            return;
        }
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public int q() {
        return this.c + this.d + this.e + this.f;
    }

    public int g(int i) {
        return this.o[i];
    }

    public void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            this.i = cVar;
            this.f = (cVar.c() - cVar.l()) + cVar.w() + cVar.g();
            BdLog.d("groupMsgName" + cVar.o());
            BdLog.d("privateMsgName" + cVar.z());
            a(cVar);
            BdLog.d("result.isShowInNotifyBar():" + cVar.m() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (cVar.m()) {
                if (currentTimeMillis - k < TbConfig.NOTIFY_SOUND_INTERVAL) {
                    BdLog.d(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (cVar.m()) {
                int i = 0;
                if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                    i = cVar.c() - cVar.l();
                }
                long w = (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) ? 0L : cVar.w();
                if ((i > 0 || w > 0) && i + w > cVar.p() + cVar.h()) {
                    a(1, 16, cVar);
                }
                int g = cVar.g();
                if (g > 0 && g > cVar.v()) {
                    a(1, 19, cVar);
                }
                if (cVar.d() > cVar.t() || cVar.f() > cVar.u()) {
                    if (cVar.d() <= cVar.t() || cVar.f() != cVar.u() || !w()) {
                        if (cVar.d() != cVar.t() || cVar.f() <= cVar.u() || !v()) {
                            a(1, 17, cVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (cVar.A() > cVar.B() && !x()) {
                    a(1, 21, cVar);
                }
            }
        }
    }

    public int r() {
        if (this.i == null) {
            return 0;
        }
        return this.i.c();
    }

    public com.baidu.tbadk.coreExtra.b.c s() {
        return this.i;
    }

    public void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.i = cVar;
    }
}

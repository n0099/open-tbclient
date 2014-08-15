package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.x;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static a g;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    private static Handler l = new b();
    private static boolean m;
    private static boolean n;
    private static boolean o;
    private com.baidu.tbadk.coreExtra.b.c i;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.baidu.tbadk.coreExtra.b.c h = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] p = new int[10];
    private final Context a = TbadkApplication.m252getInst().getApp();

    static {
        if (TbadkApplication.m252getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(new c(2008004));
            MessageManager.getInstance().registerListener(new d(2008005));
            MessageManager.getInstance().registerListener(new e(2008018));
        }
    }

    public static a a() {
        if (g == null) {
            g = new a();
        }
        return g;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.b || i2 != this.c || i3 != this.d || i4 != this.f || i5 != this.e) {
            int i6 = 0;
            if (i > this.b || i2 > this.c || i3 > this.d || i4 > this.f || i5 > this.e) {
                i6 = 1;
            } else if (i < this.b || i2 < this.c) {
                i6 = 2;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.f = i4;
            this.e = i5;
            int i7 = s() > 0 ? i6 : 2;
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
                l();
                a(i7, 16);
                a(i7, 17);
                a(i7, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i != this.b || i2 != this.c || i3 != this.d || i4 != this.f) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.f = i4;
            l();
            if (s() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean b() {
        if (j == null) {
            j = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - j.getTime() < 10000) {
                j = date;
                return false;
            }
            j = date;
        }
        return true;
    }

    public static boolean c() {
        TbadkApplication m252getInst = TbadkApplication.m252getInst();
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
        try {
            if (i == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 11 && (this.b > 0 || this.c > 0 || this.f > 0)) {
                    int i3 = this.b + this.c;
                    if (i3 > 0) {
                        stringBuffer.append(String.valueOf(i3));
                        stringBuffer.append(this.a.getString(x.notify_msg));
                    }
                    if (this.f > 0) {
                        stringBuffer.append(String.valueOf(this.f));
                        stringBuffer.append(this.a.getString(x.notify_fans));
                    }
                    stringBuffer.append(this.a.getString(x.notify_click));
                    a(11, (String) null, stringBuffer.toString());
                } else if (i2 != 16 && TbadkApplication.m252getInst().isGroupMsgOn()) {
                    TbadkApplication.m252getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                ap.a(this.a, 11);
                ap.a(this.a, 16);
                ap.a(this.a, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0216 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0027, B:17:0x0039, B:19:0x003d, B:20:0x0051, B:25:0x0072, B:27:0x007c, B:29:0x0086, B:30:0x0090, B:32:0x009c, B:34:0x00a6, B:38:0x00b3, B:40:0x00b9, B:43:0x00e2, B:45:0x00ec, B:46:0x00f4, B:48:0x00fa, B:49:0x0118, B:51:0x0121, B:54:0x012e, B:56:0x0137, B:59:0x0160, B:61:0x016e, B:62:0x018c, B:63:0x0193, B:65:0x019d, B:67:0x01a7, B:69:0x01b2, B:71:0x01b8, B:73:0x01be, B:75:0x01ce, B:76:0x01e9, B:78:0x01ef, B:81:0x01f7, B:83:0x0216, B:85:0x0222, B:94:0x0265, B:91:0x025d, B:86:0x022f, B:88:0x0235, B:90:0x023b, B:97:0x0286), top: B:104:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0027, B:17:0x0039, B:19:0x003d, B:20:0x0051, B:25:0x0072, B:27:0x007c, B:29:0x0086, B:30:0x0090, B:32:0x009c, B:34:0x00a6, B:38:0x00b3, B:40:0x00b9, B:43:0x00e2, B:45:0x00ec, B:46:0x00f4, B:48:0x00fa, B:49:0x0118, B:51:0x0121, B:54:0x012e, B:56:0x0137, B:59:0x0160, B:61:0x016e, B:62:0x018c, B:63:0x0193, B:65:0x019d, B:67:0x01a7, B:69:0x01b2, B:71:0x01b8, B:73:0x01be, B:75:0x01ce, B:76:0x01e9, B:78:0x01ef, B:81:0x01f7, B:83:0x0216, B:85:0x0222, B:94:0x0265, B:91:0x025d, B:86:0x022f, B:88:0x0235, B:90:0x023b, B:97:0x0286), top: B:104:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.b.c cVar) {
        boolean z;
        long j2;
        String o2;
        String n2;
        boolean z2 = false;
        boolean z3 = true;
        if (cVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.b > 0 || this.c > 0 || this.f > 0)) {
                        int i3 = this.b + this.c;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.a.getString(x.notify_msg));
                        }
                        if (this.f > 0) {
                            stringBuffer.append(String.valueOf(this.f));
                            stringBuffer.append(this.a.getString(x.notify_fans));
                        }
                        stringBuffer.append(this.a.getString(x.notify_click));
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
                            stringBuffer.append(String.format(this.a.getString(x.notify_chat), Long.valueOf(j3)));
                            a(16, (String) null, stringBuffer.toString(), z4);
                        } else if (j3 == 1) {
                            cVar.z();
                            cVar.x();
                            if (j2 == 1) {
                                o2 = cVar.z();
                                n2 = cVar.x();
                            } else if (c == 1) {
                                o2 = cVar.o();
                                n2 = cVar.n();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(n2)) {
                                n2 = stringBuffer.append(String.format(this.a.getString(x.notify_chat), Long.valueOf(j3))).toString();
                            }
                            a(16, o2, n2, z4);
                        }
                    } else if (i2 == 19) {
                        long g2 = cVar.g();
                        if (g2 > 1) {
                            stringBuffer.append(String.format(this.a.getString(x.notify_official_message), Long.valueOf(g2)));
                            a(19, (String) null, stringBuffer.toString());
                        } else if (g2 == 1) {
                            String j4 = cVar.j();
                            String k2 = cVar.k();
                            if (TextUtils.isEmpty(k2)) {
                                k2 = stringBuffer.append(String.format(this.a.getString(x.notify_official_message), Long.valueOf(g2))).toString();
                            }
                            a(19, j4, k2);
                        }
                    } else if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                        if (cVar.d() + cVar.f() > 0) {
                            if (cVar.d() > 0 && !y()) {
                                long d = cVar.d() - cVar.e();
                                if (d > 0) {
                                    stringBuffer.append(String.format(this.a.getString(x.notify_updates), Long.valueOf(d)));
                                    z = false;
                                    z2 = true;
                                } else if (cVar.e() > 0) {
                                    z = true;
                                }
                                if (cVar.f() > 0 || x()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.a.getString(x.notify_validate), Integer.valueOf(cVar.f())));
                                } else {
                                    stringBuffer.append(String.format(this.a.getString(x.notify_validate_1), Integer.valueOf(cVar.f())));
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
                        if (cVar.A() > 0 && !z()) {
                            a(21, (String) null, String.format(this.a.getString(x.notify_live), Integer.valueOf(cVar.A())));
                        }
                    }
                } else if (i == 2) {
                    ap.a(this.a, 11);
                    ap.a(this.a, 16);
                    ap.a(this.a, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    private void a(int i, String str, String str2, boolean z) {
        Intent a;
        if (i == 11 && this.f > 0 && this.b == 0 && this.c == 0) {
            a = g(i);
        } else if (i == 18) {
            a = w();
        } else {
            a = a(i, z);
        }
        a.setFlags(268435456);
        ap.a(this.a, i, str, str2, str2, PendingIntent.getService(this.a, i, a, 134217728), false);
    }

    private Intent g(int i) {
        Intent intent = new Intent(this.a, DealIntentService.class);
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
            Set<String> keySet = this.h.y().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.a, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.c);
        intent.putExtra("reply_me", this.b);
        intent.putExtra("fans", this.f);
        intent.putExtra("chat", o());
        intent.putExtra("group_msg", this.h.c() - this.h.l());
        intent.putExtra("group_msg_validate", this.h.f());
        intent.putExtra("group_msg_updates", this.h.d());
        intent.putExtra("live_notify_msg_updates", this.h.A());
        intent.putExtra("officialbar_msg", this.h.g());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent w() {
        Intent intent = new Intent(this.a, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.h.e());
        return intent;
    }

    public void d() {
        ap.a(this.a, 11);
        ap.a(this.a, 16);
        ap.a(this.a, 17);
        ap.a(this.a, 15);
        ap.a(this.a, 13);
        ap.a(this.a, 12);
    }

    public void e() {
        ap.a(this.a, 16);
    }

    public void f() {
        ap.a(this.a, 19);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c u = u();
        if (u == null) {
            e();
            return;
        }
        HashMap<String, String> s = u.s();
        if (s == null || s.isEmpty()) {
            e();
        } else if (s.containsKey(str)) {
            e();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c u = u();
        if (u == null) {
            e();
            return;
        }
        HashMap<String, String> y = u.y();
        if (y == null || y.isEmpty()) {
            e();
        } else if (y.containsKey(str)) {
            e();
        }
    }

    private boolean x() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return m;
    }

    private boolean y() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return n;
    }

    private boolean z() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return o;
    }

    public void g() {
        ap.a(this.a, 17);
    }

    public void a(int i) {
        com.baidu.tbadk.coreExtra.b.c u = u();
        if (u == null) {
            g();
        } else if (1 == i) {
            if (u.d() <= 0) {
                g();
            }
        } else if (2 == i) {
            if (u.f() <= 0) {
                g();
            }
        } else if (3 == i && u.A() <= 0) {
            ap.a(this.a, 21);
        }
    }

    public void h() {
        ap.a(this.a, 18);
    }

    public void i() {
        ap.a(this.a, 11);
        ap.a(this.a, 16);
        ap.a(this.a, 17);
    }

    public void j() {
        ap.a(this.a, 21);
        ap.a(this.a, 17);
        ap.a(this.a, 19);
        ap.a(this.a, 16);
        ap.a(this.a, 18);
    }

    public void k() {
        ap.a(this.a, 11);
    }

    public void l() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(n());
        newsNotifyMessage.setMsgBookmark(r());
        newsNotifyMessage.setMsgChat(p());
        newsNotifyMessage.setMsgFans(q());
        newsNotifyMessage.setMsgReplyme(m());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(n());
            newsNotifyMessage.setMsgBookmark(r());
            newsNotifyMessage.setMsgChat(((cVar.w() + cVar.c()) + cVar.C()) - cVar.l());
            newsNotifyMessage.setMsgFans(q());
            newsNotifyMessage.setMsgReplyme(m());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int m() {
        return this.b;
    }

    public int n() {
        return this.c;
    }

    public void b(int i) {
        if (i >= 0) {
            a(this.b, i, this.d, this.f, this.e);
        }
    }

    public int o() {
        return this.d;
    }

    public int p() {
        return ((this.h.w() + this.h.c()) + this.h.C()) - this.h.l();
    }

    public int q() {
        return this.f;
    }

    public void c(int i) {
        if (i >= 0) {
            a(this.b, this.c, this.d, i, this.e);
        }
    }

    public void d(int i) {
        if (i >= 0) {
            a(this.b, this.c, i, this.f, this.e);
        }
    }

    public int r() {
        return this.e;
    }

    public void e(int i) {
        if (i >= 0) {
            a(this.b, this.c, this.d, this.f, i);
        }
    }

    public void a(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0);
            return;
        }
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
    }

    public int s() {
        return this.b + this.c + this.d + this.f;
    }

    public int f(int i) {
        return this.p[i];
    }

    public void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.h = cVar;
            this.d = (cVar.c() - cVar.l()) + cVar.w() + cVar.C();
            a(cVar);
            if (cVar.m()) {
                k = System.currentTimeMillis();
                this.i = null;
                l.removeMessages(0);
            }
            if (cVar.m()) {
                if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                    i = cVar.c() - cVar.l();
                }
                long w = (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) ? 0L : cVar.w();
                if ((i > 0 || w > 0) && ((i > cVar.p() - cVar.l() && i > 0) || w > cVar.h())) {
                    a(1, 16, cVar);
                }
                int g2 = cVar.g();
                if (g2 > 0 && g2 > cVar.v()) {
                    a(1, 19, cVar);
                }
                if (cVar.d() > cVar.t() || cVar.f() > cVar.u()) {
                    if (cVar.d() <= cVar.t() || cVar.f() != cVar.u() || !y()) {
                        if (cVar.d() != cVar.t() || cVar.f() <= cVar.u() || !x()) {
                            a(1, 17, cVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (cVar.A() > cVar.B() && !z()) {
                    a(1, 21, cVar);
                }
            }
        }
    }

    public int t() {
        if (this.h == null) {
            return 0;
        }
        return this.h.c();
    }

    public com.baidu.tbadk.coreExtra.b.c u() {
        return this.h;
    }

    public void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.h = cVar;
    }

    public com.baidu.tbadk.coreExtra.b.c v() {
        return this.i;
    }
}

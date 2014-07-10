package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.y;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static a f;
    private static Date h = null;
    private static long i = System.currentTimeMillis();
    private static boolean j;
    private static boolean k;
    private static boolean l;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private com.baidu.tbadk.coreExtra.b.c g = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] m = new int[10];
    private final Context a = TbadkApplication.m252getInst().getApp();

    static {
        if (TbadkApplication.m252getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(new b(2008004));
            MessageManager.getInstance().registerListener(new c(2008005));
            MessageManager.getInstance().registerListener(new d(2008018));
        }
    }

    public static a a() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    private a() {
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i2 != this.b || i3 != this.c || i4 != this.d || i5 != this.e) {
            int i6 = 0;
            if (i2 > this.b || i3 > this.c || i4 > this.d || i5 > this.e) {
                i6 = 1;
            } else if (i2 < this.b || i3 < this.c || i5 < this.e) {
                i6 = 2;
            }
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            int i7 = p() > 0 ? i6 : 2;
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
                j();
                a(i7, 16);
                a(i7, 17);
                a(i7, 11);
            }
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i2 != this.b || i3 != this.c || i4 != this.d) {
            this.b = i2;
            this.c = i3;
            this.d = i4;
            j();
            if (p() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean b() {
        TbadkApplication m252getInst = TbadkApplication.m252getInst();
        if (h == null) {
            h = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - h.getTime() < 10000) {
                h = date;
                return true;
            }
            h = date;
        }
        if (m252getInst.isNoDisturbOn()) {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = m252getInst.getNoDisturbStartTime().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = m252getInst.getNoDisturbEndTime().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt < parseInt2) {
                if (i2 >= parseInt && i2 <= parseInt2) {
                    return true;
                }
            } else if (parseInt > parseInt2) {
                if (i2 >= parseInt && i2 <= 1439) {
                    return true;
                }
                if (i2 >= 0 && i2 <= parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(int i2, int i3) {
        try {
            if (i2 == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i3 == 11 && (this.b > 0 || this.c > 0)) {
                    int i4 = this.b + this.c;
                    if (i4 > 0) {
                        stringBuffer.append(String.valueOf(i4));
                        stringBuffer.append(this.a.getString(y.notify_msg));
                    }
                    stringBuffer.append(this.a.getString(y.notify_click));
                    a(11, (String) null, stringBuffer.toString());
                } else if (i3 != 16 && TbadkApplication.m252getInst().isGroupMsgOn()) {
                    TbadkApplication.m252getInst().getMsgFrequency();
                }
            } else if (i2 == 2) {
                bb.a(this.a, 11);
                bb.a(this.a, 16);
                bb.a(this.a, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01fa A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x001c, B:14:0x0023, B:15:0x0035, B:20:0x0056, B:22:0x0060, B:24:0x006a, B:25:0x0074, B:27:0x0080, B:29:0x008a, B:33:0x0097, B:35:0x009d, B:38:0x00c6, B:40:0x00d0, B:41:0x00d8, B:43:0x00de, B:44:0x00fc, B:46:0x0105, B:49:0x0112, B:51:0x011b, B:54:0x0144, B:56:0x0152, B:57:0x0170, B:58:0x0177, B:60:0x0181, B:62:0x018b, B:64:0x0196, B:66:0x019c, B:68:0x01a2, B:70:0x01b2, B:71:0x01cd, B:73:0x01d3, B:76:0x01db, B:78:0x01fa, B:80:0x0206, B:89:0x0249, B:86:0x0241, B:81:0x0213, B:83:0x0219, B:85:0x021f, B:92:0x026a), top: B:99:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0206 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x001c, B:14:0x0023, B:15:0x0035, B:20:0x0056, B:22:0x0060, B:24:0x006a, B:25:0x0074, B:27:0x0080, B:29:0x008a, B:33:0x0097, B:35:0x009d, B:38:0x00c6, B:40:0x00d0, B:41:0x00d8, B:43:0x00de, B:44:0x00fc, B:46:0x0105, B:49:0x0112, B:51:0x011b, B:54:0x0144, B:56:0x0152, B:57:0x0170, B:58:0x0177, B:60:0x0181, B:62:0x018b, B:64:0x0196, B:66:0x019c, B:68:0x01a2, B:70:0x01b2, B:71:0x01cd, B:73:0x01d3, B:76:0x01db, B:78:0x01fa, B:80:0x0206, B:89:0x0249, B:86:0x0241, B:81:0x0213, B:83:0x0219, B:85:0x021f, B:92:0x026a), top: B:99:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, int i3, com.baidu.tbadk.coreExtra.b.c cVar) {
        boolean z;
        long j2;
        String o;
        String n;
        boolean z2 = false;
        boolean z3 = true;
        if (cVar != null) {
            try {
                if (i2 == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i3 == 11 && (this.b > 0 || this.c > 0)) {
                        int i4 = this.b + this.c;
                        if (i4 > 0) {
                            stringBuffer.append(String.valueOf(i4));
                            stringBuffer.append(this.a.getString(y.notify_msg));
                        }
                        stringBuffer.append(this.a.getString(y.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i3 == 16) {
                        int c = (!TbadkApplication.m252getInst().isGroupMsgOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) ? 0 : cVar.c() - cVar.l();
                        if (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
                            j2 = 0;
                        } else {
                            j2 = cVar.w();
                        }
                        boolean z4 = j2 > 0;
                        long j3 = c + j2;
                        if (j3 > 1) {
                            stringBuffer.append(String.format(this.a.getString(y.notify_chat), Long.valueOf(j3)));
                            a(16, (String) null, stringBuffer.toString(), z4);
                        } else if (j3 == 1) {
                            cVar.z();
                            cVar.x();
                            if (j2 == 1) {
                                o = cVar.z();
                                n = cVar.x();
                            } else if (c == 1) {
                                o = cVar.o();
                                n = cVar.n();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(n)) {
                                n = stringBuffer.append(String.format(this.a.getString(y.notify_chat), Long.valueOf(j3))).toString();
                            }
                            a(16, o, n, z4);
                        }
                    } else if (i3 == 19) {
                        long g = cVar.g();
                        if (g > 1) {
                            stringBuffer.append(String.format(this.a.getString(y.notify_official_message), Long.valueOf(g)));
                            a(19, (String) null, stringBuffer.toString());
                        } else if (g == 1) {
                            String j4 = cVar.j();
                            String k2 = cVar.k();
                            if (TextUtils.isEmpty(k2)) {
                                k2 = stringBuffer.append(String.format(this.a.getString(y.notify_official_message), Long.valueOf(g))).toString();
                            }
                            a(19, j4, k2);
                        }
                    } else if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                        if (cVar.d() + cVar.f() > 0) {
                            if (cVar.d() > 0 && !u()) {
                                long d = cVar.d() - cVar.e();
                                if (d > 0) {
                                    stringBuffer.append(String.format(this.a.getString(y.notify_updates), Long.valueOf(d)));
                                    z = false;
                                    z2 = true;
                                } else if (cVar.e() > 0) {
                                    z = true;
                                }
                                if (cVar.f() > 0 || t()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.a.getString(y.notify_validate), Integer.valueOf(cVar.f())));
                                } else {
                                    stringBuffer.append(String.format(this.a.getString(y.notify_validate_1), Integer.valueOf(cVar.f())));
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
                        if (cVar.A() > 0 && !v()) {
                            a(21, (String) null, String.format(this.a.getString(y.notify_live), Integer.valueOf(cVar.A())));
                        }
                    }
                } else if (i2 == 2) {
                    bb.a(this.a, 11);
                    bb.a(this.a, 16);
                    bb.a(this.a, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i2, String str, String str2) {
        a(i2, str, str2, false);
    }

    private void a(int i2, String str, String str2, boolean z) {
        Intent a;
        if (i2 == 18) {
            a = s();
        } else {
            a = a(i2, z);
        }
        a.setFlags(268435456);
        bb.a(this.a, i2, str, str2, str2, PendingIntent.getService(this.a, i2, a, 134217728), false);
    }

    private Intent a(int i2, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.g.y().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.a, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i2);
        intent.putExtra("at_me", this.c);
        intent.putExtra("reply_me", this.b);
        intent.putExtra("chat", m());
        intent.putExtra("group_msg", this.g.c() - this.g.l());
        intent.putExtra("group_msg_validate", this.g.f());
        intent.putExtra("group_msg_updates", this.g.d());
        intent.putExtra("live_notify_msg_updates", this.g.A());
        intent.putExtra("officialbar_msg", this.g.g());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent s() {
        Intent intent = new Intent(this.a, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.g.e());
        return intent;
    }

    public void c() {
        bb.a(this.a, 11);
        bb.a(this.a, 16);
        bb.a(this.a, 17);
        bb.a(this.a, 15);
        bb.a(this.a, 13);
        bb.a(this.a, 12);
    }

    public void d() {
        bb.a(this.a, 16);
    }

    public void e() {
        bb.a(this.a, 19);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            d();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c r = r();
        if (r == null) {
            d();
            return;
        }
        HashMap<String, String> s = r.s();
        if (s == null || s.isEmpty()) {
            d();
        } else if (s.containsKey(str)) {
            d();
        }
    }

    private boolean t() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return j;
    }

    private boolean u() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return k;
    }

    private boolean v() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return l;
    }

    public void f() {
        bb.a(this.a, 17);
    }

    public void a(int i2) {
        com.baidu.tbadk.coreExtra.b.c r = r();
        if (r == null) {
            f();
        } else if (1 == i2) {
            if (r.d() <= 0) {
                f();
            }
        } else if (2 == i2) {
            if (r.f() <= 0) {
                f();
            }
        } else if (3 == i2 && r.A() <= 0) {
            bb.a(this.a, 21);
        }
    }

    public void g() {
        bb.a(this.a, 18);
    }

    public void h() {
        bb.a(this.a, 11);
        bb.a(this.a, 16);
        bb.a(this.a, 17);
    }

    public void i() {
        bb.a(this.a, 11);
    }

    public void j() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(l());
        newsNotifyMessage.setMsgBookmark(o());
        newsNotifyMessage.setMsgChat(n());
        newsNotifyMessage.setMsgReplyme(k());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(l());
            newsNotifyMessage.setMsgBookmark(o());
            newsNotifyMessage.setMsgChat(((cVar.w() + cVar.c()) + cVar.g()) - cVar.l());
            newsNotifyMessage.setMsgReplyme(k());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int k() {
        return this.b;
    }

    public void b(int i2) {
        if (i2 >= 0) {
            a(i2, this.c, this.d, this.e);
        }
    }

    public int l() {
        return this.c;
    }

    public void c(int i2) {
        if (i2 >= 0) {
            a(this.b, i2, this.d, this.e);
        }
    }

    public int m() {
        return this.d;
    }

    public int n() {
        return ((this.g.w() + this.g.c()) + this.g.g()) - this.g.l();
    }

    public void d(int i2) {
        if (i2 >= 0) {
            a(this.b, this.c, i2, this.e);
        }
    }

    public int o() {
        return this.e;
    }

    public void e(int i2) {
        if (i2 >= 0) {
            a(this.b, this.c, this.d, i2);
        }
    }

    public void a(boolean z) {
        if (z) {
            a(0, 0, 0, 0);
            return;
        }
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public int p() {
        return this.b + this.c + this.d;
    }

    public int f(int i2) {
        return this.m[i2];
    }

    public void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            this.g = cVar;
            this.d = (cVar.c() - cVar.l()) + cVar.w() + cVar.g();
            a(cVar);
            long currentTimeMillis = System.currentTimeMillis();
            if (cVar.m()) {
                if (currentTimeMillis - i >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    i = System.currentTimeMillis();
                } else {
                    return;
                }
            }
            if (cVar.m()) {
                int i2 = 0;
                if (TbadkApplication.m252getInst().isGroupMsgOn() && TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                    i2 = cVar.c() - cVar.l();
                }
                long w = (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) ? 0L : cVar.w();
                if ((i2 > 0 || w > 0) && i2 + w > (cVar.p() - cVar.l()) + cVar.h()) {
                    a(1, 16, cVar);
                }
                int g = cVar.g();
                if (g > 0 && g > cVar.v()) {
                    a(1, 19, cVar);
                }
                if (cVar.d() > cVar.t() || cVar.f() > cVar.u()) {
                    if (cVar.d() <= cVar.t() || cVar.f() != cVar.u() || !u()) {
                        if (cVar.d() != cVar.t() || cVar.f() <= cVar.u() || !t()) {
                            a(1, 17, cVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (cVar.A() > cVar.B() && !v()) {
                    a(1, 21, cVar);
                }
            }
        }
    }

    public int q() {
        if (this.g == null) {
            return 0;
        }
        return this.g.c();
    }

    public com.baidu.tbadk.coreExtra.b.c r() {
        return this.g;
    }

    public void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.g = cVar;
    }
}

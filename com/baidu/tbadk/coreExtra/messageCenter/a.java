package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.i;
import com.baidu.tbadk.l;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {
    private static a h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    private static boolean l;
    private static boolean m;
    NotificationManager a = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private com.baidu.tbadk.coreExtra.b.c i = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] n = new int[10];
    private final Context b = TbadkApplication.j().b();

    static {
        com.baidu.adp.framework.c.a().a(new b(2008004));
        com.baidu.adp.framework.c.a().a(new c(2008005));
    }

    public static a a() {
        if (h == null) {
            h = new a();
        }
        return h;
    }

    public final void b() {
        this.a = (NotificationManager) this.b.getSystemService("notification");
    }

    private a() {
    }

    public final void a(int i, int i2, int i3, int i4, int i5) {
        if (i == this.c && i2 == this.d && i3 == this.e && i4 == this.f && i5 == this.g) {
            f.d("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
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
        int i7 = w() > 0 ? i6 : 2;
        if (TbadkApplication.E() != null && TbadkApplication.E().length() > 0) {
            h();
            a(i7, 16);
            a(i7, 17);
            a(i7, 11);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i != this.c || i2 != this.d || i3 != this.e || i4 != this.f) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            h();
            if (w() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean c() {
        boolean z = false;
        TbadkApplication j2 = TbadkApplication.j();
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
        if (j2.as()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = j2.at().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = j2.au().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt >= parseInt2 ? !(parseInt <= parseInt2 || ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2))) : !(i < parseInt || i > parseInt2)) {
                z = true;
            }
        }
        return z;
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
                            stringBuffer.append(this.b.getString(l.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(l.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(l.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 != 16) {
                        TbadkApplication.j();
                        if (TbadkApplication.af()) {
                            TbadkApplication.j().ai();
                        }
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                f.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0220 A[Catch: Exception -> 0x0069, TryCatch #0 {Exception -> 0x0069, blocks: (B:6:0x000d, B:8:0x0016, B:10:0x001a, B:12:0x001e, B:14:0x0022, B:16:0x0029, B:17:0x003b, B:19:0x003f, B:20:0x0053, B:25:0x007e, B:27:0x0087, B:29:0x0091, B:30:0x009b, B:32:0x00a7, B:34:0x00b1, B:38:0x00be, B:40:0x00c4, B:43:0x00ed, B:45:0x00f7, B:46:0x00ff, B:48:0x0105, B:49:0x0123, B:51:0x012c, B:54:0x0139, B:56:0x0142, B:59:0x016b, B:61:0x0179, B:62:0x0197, B:63:0x019e, B:65:0x01a7, B:67:0x01b1, B:69:0x01bc, B:71:0x01c2, B:73:0x01c8, B:75:0x01d8, B:76:0x01f3, B:78:0x01f9, B:81:0x0201, B:83:0x0220, B:85:0x022c, B:89:0x0243, B:86:0x023b), top: B:96:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022c A[Catch: Exception -> 0x0069, TryCatch #0 {Exception -> 0x0069, blocks: (B:6:0x000d, B:8:0x0016, B:10:0x001a, B:12:0x001e, B:14:0x0022, B:16:0x0029, B:17:0x003b, B:19:0x003f, B:20:0x0053, B:25:0x007e, B:27:0x0087, B:29:0x0091, B:30:0x009b, B:32:0x00a7, B:34:0x00b1, B:38:0x00be, B:40:0x00c4, B:43:0x00ed, B:45:0x00f7, B:46:0x00ff, B:48:0x0105, B:49:0x0123, B:51:0x012c, B:54:0x0139, B:56:0x0142, B:59:0x016b, B:61:0x0179, B:62:0x0197, B:63:0x019e, B:65:0x01a7, B:67:0x01b1, B:69:0x01bc, B:71:0x01c2, B:73:0x01c8, B:75:0x01d8, B:76:0x01f3, B:78:0x01f9, B:81:0x0201, B:83:0x0220, B:85:0x022c, B:89:0x0243, B:86:0x023b), top: B:96:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.b.c cVar) {
        boolean z;
        long j2;
        String o;
        String n;
        boolean z2 = false;
        boolean z3 = true;
        if (this.a != null && cVar != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                    int i3 = this.c + this.d;
                    if (i3 > 0) {
                        stringBuffer.append(String.valueOf(i3));
                        stringBuffer.append(this.b.getString(l.notify_msg));
                    }
                    if (this.e > 0) {
                        stringBuffer.append(String.valueOf(this.e));
                        stringBuffer.append(this.b.getString(l.notify_fans));
                    }
                    stringBuffer.append(this.b.getString(l.notify_click));
                    a(11, (String) null, stringBuffer.toString());
                } else if (i2 == 16) {
                    TbadkApplication.j();
                    int c = (!TbadkApplication.af() || TbadkApplication.j().ai() <= 0) ? 0 : cVar.c() - cVar.l();
                    if (!TbadkApplication.j().ag() || TbadkApplication.j().ai() <= 0) {
                        j2 = 0;
                    } else {
                        j2 = cVar.w();
                    }
                    boolean z4 = j2 > 0;
                    long j3 = c + j2;
                    if (j3 > 1) {
                        stringBuffer.append(String.format(this.b.getString(l.notify_chat), Long.valueOf(j3)));
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
                            n = stringBuffer.append(String.format(this.b.getString(l.notify_chat), Long.valueOf(j3))).toString();
                        }
                        a(16, o, n, z4);
                    }
                } else if (i2 == 19) {
                    long g = cVar.g();
                    if (g > 1) {
                        stringBuffer.append(String.format(this.b.getString(l.notify_official_message), Long.valueOf(g)));
                        a(19, (String) null, stringBuffer.toString());
                    } else if (g == 1) {
                        String j4 = cVar.j();
                        String k2 = cVar.k();
                        if (TextUtils.isEmpty(k2)) {
                            k2 = stringBuffer.append(String.format(this.b.getString(l.notify_official_message), Long.valueOf(g))).toString();
                        }
                        a(19, j4, k2);
                    }
                } else {
                    TbadkApplication.j();
                    if (TbadkApplication.af() && TbadkApplication.j().ai() > 0 && cVar.d() + cVar.f() > 0) {
                        if (cVar.d() > 0 && !u()) {
                            long d = cVar.d() - cVar.e();
                            if (d > 0) {
                                stringBuffer.append(String.format(this.b.getString(l.notify_updates), Long.valueOf(d)));
                                z = false;
                                z2 = true;
                            } else if (cVar.e() > 0) {
                                z = true;
                            }
                            if (cVar.f() > 0 || t()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.b.getString(l.notify_validate), Integer.valueOf(cVar.f())));
                            } else {
                                stringBuffer.append(String.format(this.b.getString(l.notify_validate_1), Integer.valueOf(cVar.f())));
                            }
                            if (z3) {
                                a(17, (String) null, stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, cVar.q(), cVar.r());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (cVar.f() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                }
            } catch (Exception e) {
                f.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private Notification q() {
        return new Notification(i.icon, this.b.getString(l.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    private void a(int i, String str, String str2, boolean z) {
        Intent intent;
        Notification q;
        Notification notification = new Notification(i.icon_notify, this.b.getString(l.notify_text), System.currentTimeMillis());
        if (this.a != null) {
            this.a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            intent = new Intent(this.b, DealIntentService.class);
            intent.putExtra("class", 10);
            intent.putExtra("KeyOfNotiId", i);
            String E = TbadkApplication.E();
            String O = TbadkApplication.O();
            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(O)) {
                intent.putExtra("un", E);
                intent.putExtra("name", O);
            }
        } else if (i == 18) {
            intent = r();
        } else if (i == 18) {
            intent = r();
        } else {
            String str3 = "";
            if (z) {
                Set<String> keySet = this.i.y().keySet();
                if (keySet.iterator().hasNext()) {
                    str3 = keySet.iterator().next();
                }
            }
            Intent intent2 = new Intent(this.b, DealIntentService.class);
            intent2.putExtra("class", 5);
            intent2.putExtra("KeyOfNotiId", i);
            intent2.putExtra("at_me", this.d);
            intent2.putExtra("reply_me", this.c);
            intent2.putExtra("fans", this.e);
            intent2.putExtra("chat", this.f);
            intent2.putExtra("group_msg", this.i.c() - this.i.l());
            intent2.putExtra("group_msg_validate", this.i.f());
            intent2.putExtra("group_msg_updates", this.i.d());
            intent2.putExtra("officialbar_msg", this.i.g());
            intent2.putExtra("privateGid", str3);
            intent = intent2;
        }
        intent.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, intent, 134217728);
        int i2 = 0;
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            i2 = field.getInt(null);
            q = notification;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            q = q();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            q = q();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            q = q();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            q = q();
        } catch (SecurityException e5) {
            e5.printStackTrace();
            q = q();
        }
        if (bc.c(str) || (i != 16 && i != 18)) {
            q.setLatestEventInfo(this.b, this.b.getString(l.app_name), str2, service);
        } else {
            q.setLatestEventInfo(this.b, str, str2, service);
        }
        if (i2 != 0 && q.contentView != null) {
            q.contentView.setImageViewResource(i2, i.icon);
        }
        q.defaults = -1;
        q.flags = 16;
        if (c()) {
            q.defaults &= -2;
            q.defaults &= -3;
        } else {
            if (!TbadkApplication.j().aq()) {
                q.defaults &= -3;
            }
            if (!TbadkApplication.j().ar()) {
                q.defaults &= -2;
            } else {
                q.audioStreamType = 5;
            }
        }
        if (this.a != null) {
            this.a.notify(i, q);
        }
    }

    private Intent r() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.i.e());
        return intent;
    }

    public final void d() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
            this.a.cancel(15);
            this.a.cancel(13);
            this.a.cancel(12);
        }
    }

    private void s() {
        if (this.a != null) {
            this.a.cancel(16);
        }
    }

    public final void e() {
        if (this.a != null) {
            this.a.cancel(19);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            s();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c cVar = this.i;
        if (cVar == null) {
            s();
            return;
        }
        HashMap<String, String> s = cVar.s();
        if (s == null || s.isEmpty()) {
            s();
        } else if (s.containsKey(str)) {
            s();
        }
    }

    private static boolean t() {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008004));
        return l;
    }

    private static boolean u() {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008005));
        return m;
    }

    private void v() {
        if (this.a != null) {
            this.a.cancel(17);
        }
    }

    public final void a(int i) {
        com.baidu.tbadk.coreExtra.b.c cVar = this.i;
        if (cVar == null) {
            v();
        } else if (1 == i) {
            if (cVar.d() <= 0) {
                v();
            }
        } else if (2 == i && cVar.f() <= 0) {
            v();
        }
    }

    public final void f() {
        if (this.a != null) {
            this.a.cancel(18);
        }
    }

    public final void g() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
        }
    }

    public final void h() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.c(this.d);
        newsNotifyMessage.f(this.g);
        newsNotifyMessage.e(m());
        newsNotifyMessage.d(this.e);
        newsNotifyMessage.b(this.c);
        com.baidu.adp.framework.c.a().b(newsNotifyMessage);
    }

    public final int i() {
        return this.c;
    }

    public final void b(int i) {
        a(0, this.d, this.e, this.f, this.g);
    }

    public final int j() {
        return this.d;
    }

    public final void c(int i) {
        a(this.c, 0, this.e, this.f, this.g);
    }

    public final int k() {
        return this.e;
    }

    public final void d(int i) {
        a(this.c, this.d, 0, this.f, this.g);
    }

    public final int l() {
        return this.f;
    }

    public final int m() {
        return ((this.i.w() + this.i.c()) + this.i.g()) - this.i.l();
    }

    public final void e(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, i, this.g);
        }
    }

    public final int n() {
        return this.g;
    }

    public final void f(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, this.f, i);
        }
    }

    public final void a(boolean z) {
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

    private int w() {
        return this.c + this.d + this.e + this.f;
    }

    public final int g(int i) {
        return this.n[i];
    }

    public final void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            this.i = cVar;
            this.f = (cVar.c() - cVar.l()) + cVar.w() + cVar.g();
            f.e("groupMsgName" + cVar.o());
            f.e("privateMsgName" + cVar.z());
            if (cVar != null) {
                NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
                newsNotifyMessage.c(this.d);
                newsNotifyMessage.f(this.g);
                newsNotifyMessage.e(((cVar.w() + cVar.c()) + cVar.g()) - cVar.l());
                newsNotifyMessage.d(this.e);
                newsNotifyMessage.b(this.c);
                com.baidu.adp.framework.c.a().b(newsNotifyMessage);
            }
            f.e("result.isShowInNotifyBar():" + cVar.m() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (cVar.m()) {
                if (currentTimeMillis - k < 5000) {
                    f.e(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (cVar.m()) {
                int i = 0;
                TbadkApplication.j();
                if (TbadkApplication.af() && TbadkApplication.j().ai() > 0) {
                    i = cVar.c() - cVar.l();
                }
                long w = (!TbadkApplication.j().ag() || TbadkApplication.j().ai() <= 0) ? 0L : cVar.w();
                if ((i > 0 || w > 0) && i + w > cVar.p() + cVar.h()) {
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
                        }
                    }
                }
            }
        }
    }

    public final int o() {
        if (this.i == null) {
            return 0;
        }
        return this.i.c();
    }

    public final com.baidu.tbadk.coreExtra.b.c p() {
        return this.i;
    }

    public final void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.i = cVar;
    }
}

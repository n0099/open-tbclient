package com.baidu.tieba.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bc;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1023a = com.baidu.tieba.data.h.f1248a + "c/f/pb/page";
    private am b = null;

    public String a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, boolean z3, long j, boolean z4, ao aoVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.b = new am(f1023a);
        this.b.a("kz", str);
        this.b.a("rn", String.valueOf(30));
        this.b.a("with_floor", SocialConstants.TRUE);
        int b = com.baidu.adp.lib.h.g.b(TiebaApplication.h());
        int c = com.baidu.adp.lib.h.g.c(TiebaApplication.h());
        float f = TiebaApplication.h().getResources().getDisplayMetrics().density;
        int i6 = 1;
        if (bc.a().d().equals("80")) {
            i6 = 2;
        }
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        this.b.a("q_type", String.valueOf(i6));
        if (!z) {
            this.b.a("r", SocialConstants.TRUE);
        }
        if (z2) {
            this.b.a("lz", SocialConstants.TRUE);
        }
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        if (z3) {
            this.b.a("msg_click", SocialConstants.TRUE);
            this.b.a("message_id", String.valueOf(j));
        }
        if (aoVar != null) {
            aoVar.a(this.b);
        }
        switch (i3) {
            case 1:
                this.b.a("back", SocialConstants.FALSE);
                if (!z4) {
                    if (!z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                } else if (!z) {
                    this.b.a("last", SocialConstants.TRUE);
                    break;
                }
                break;
            case 2:
                this.b.a("back", SocialConstants.TRUE);
                if (!z4) {
                    if (z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                }
                break;
            case 3:
                this.b.a("back", SocialConstants.FALSE);
                if (z) {
                    this.b.a("pn", SocialConstants.TRUE);
                } else {
                    this.b.a("last", SocialConstants.TRUE);
                }
                if (z4) {
                    this.b.a("st_type", "store_thread");
                    break;
                }
                break;
            case 4:
                this.b.a("st_type", "store_thread");
                this.b.a("mark", SocialConstants.TRUE);
                this.b.a("pid", str3);
                this.b.a("back", SocialConstants.FALSE);
                break;
            case 5:
                this.b.a("back", SocialConstants.FALSE);
                this.b.a("pn", String.valueOf(i4));
                break;
            case 6:
                this.b.a("mark", SocialConstants.TRUE);
                this.b.a("pid", str3);
                this.b.a("back", SocialConstants.FALSE);
                break;
        }
        return this.b.l();
    }

    public void a() {
        if (this.b != null) {
            this.b.j();
        }
    }

    public boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return this.b.d();
    }

    public int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.b();
    }

    public String e() {
        if (this.b == null) {
            return null;
        }
        return this.b.i();
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e();
    }
}

package com.baidu.tieba.b;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.an;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bv;
/* loaded from: classes.dex */
public class f {
    private static final String a = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/pb/page";
    private ba b = null;

    public String a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, boolean z3, long j, boolean z4, an anVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.b = new ba(a);
        this.b.a("kz", str);
        this.b.a("rn", String.valueOf(30));
        this.b.a("with_floor", SocialConstants.TRUE);
        int b = BdUtilHelper.b(TiebaApplication.g().b());
        int c = BdUtilHelper.c(TiebaApplication.g().b());
        float f = TiebaApplication.g().b().getResources().getDisplayMetrics().density;
        int i6 = 1;
        if (bv.a().d().equals("80")) {
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
        if (anVar != null) {
            anVar.a(this.b);
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
        return this.b.m();
    }

    public void a() {
        if (this.b != null) {
            this.b.k();
        }
    }

    public boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.d();
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return this.b.e();
    }

    public int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.c();
    }

    public String e() {
        if (this.b == null) {
            return null;
        }
        return this.b.j();
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.f();
    }
}

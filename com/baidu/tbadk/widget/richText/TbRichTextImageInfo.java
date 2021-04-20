package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.wallet.core.Domains;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13969e;

    /* renamed from: f  reason: collision with root package name */
    public String f13970f;

    /* renamed from: g  reason: collision with root package name */
    public String f13971g;

    /* renamed from: h  reason: collision with root package name */
    public int f13972h;
    public int i;
    public boolean j;
    public boolean k;
    public String l;
    public long m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    public TbRichTextImageInfo() {
        this.f13969e = null;
        this.f13970f = null;
        this.f13971g = null;
        this.f13972h = 1;
        this.i = 1;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = false;
        this.q = null;
    }

    public boolean A() {
        return this.o;
    }

    public boolean B() {
        return this.n;
    }

    public void C(boolean z) {
        this.o = z;
    }

    public void D(String str) {
        this.l = str;
    }

    public void E(String str) {
        this.f13969e = str;
    }

    public int getHeight() {
        return this.i;
    }

    public long getOriginalSize() {
        return this.m;
    }

    public int getWidth() {
        return this.f13972h;
    }

    public String s() {
        return this.f13971g;
    }

    public void setHeight(int i) {
        this.i = i;
    }

    public void setWidth(int i) {
        this.f13972h = i;
    }

    public String t() {
        return this.q;
    }

    public String u() {
        return this.f13970f;
    }

    public String v() {
        return this.p;
    }

    public String w() {
        return this.l;
    }

    public String x() {
        return this.f13969e;
    }

    public boolean y() {
        return this.k;
    }

    public boolean z() {
        return this.j;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.f13969e = null;
        this.f13970f = null;
        this.f13971g = null;
        this.f13972h = 1;
        this.i = 1;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = false;
        this.q = null;
        if (pbContent == null) {
            return;
        }
        this.f13969e = pbContent.src;
        String str = pbContent.cdn_src;
        this.f13970f = str;
        if (str == null || str.length() == 0) {
            this.f13970f = this.f13969e;
        }
        String str2 = pbContent.big_cdn_src;
        this.f13971g = str2;
        this.q = pbContent.big_src;
        if (StringUtils.isNull(str2)) {
            this.f13971g = this.q;
        }
        String str3 = pbContent.bsize;
        if (str3 != null) {
            try {
                String[] split = str3.split(",");
                this.f13972h = Integer.valueOf(split[0]).intValue();
                this.i = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13972h <= 0) {
            this.f13972h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        String str4 = this.f13970f;
        if (str4 != null && str4.indexOf(Domains.BAIDU) != -1) {
            this.j = true;
        }
        this.l = pbContent.origin_src;
        this.m = pbContent.origin_size.intValue();
        this.n = pbContent.show_original_btn.intValue() == 1;
        this.o = pbContent.is_long_pic.intValue() == 1;
        this.p = pbContent.cdn_src_active;
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        this.f13969e = null;
        this.f13970f = null;
        this.f13971g = null;
        this.f13972h = 1;
        this.i = 1;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = false;
        this.q = null;
        if (jSONObject == null) {
            return;
        }
        this.f13969e = jSONObject.optString(UserAccountActionItem.KEY_SRC);
        String optString = jSONObject.optString("cdn_src", "");
        this.f13970f = optString;
        if (optString == null || optString.length() == 0) {
            this.f13970f = this.f13969e;
        }
        this.f13971g = jSONObject.optString("big_cdn_src", null);
        try {
            String[] split = jSONObject.optString("bsize").split(",");
            this.f13972h = Integer.valueOf(split[0]).intValue();
            this.i = Integer.valueOf(split[1]).intValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f13972h <= 0) {
            this.f13972h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        String str = this.f13970f;
        if (str == null || str.indexOf(Domains.BAIDU) == -1) {
            return;
        }
        this.j = true;
    }
}

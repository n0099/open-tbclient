package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.wallet.core.Domains;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13322e;

    /* renamed from: f  reason: collision with root package name */
    public String f13323f;

    /* renamed from: g  reason: collision with root package name */
    public String f13324g;

    /* renamed from: h  reason: collision with root package name */
    public int f13325h;

    /* renamed from: i  reason: collision with root package name */
    public int f13326i;
    public boolean j;
    public boolean k;
    public String l;
    public long m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    public TbRichTextImageInfo() {
        this.f13322e = null;
        this.f13323f = null;
        this.f13324g = null;
        this.f13325h = 1;
        this.f13326i = 1;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = 0L;
        this.n = false;
        this.o = false;
        this.q = null;
    }

    public String A() {
        return this.l;
    }

    public String B() {
        return this.f13322e;
    }

    public boolean C() {
        return this.k;
    }

    public boolean D() {
        return this.j;
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        return this.n;
    }

    public void G(boolean z) {
        this.o = z;
    }

    public void H(String str) {
        this.l = str;
    }

    public void I(String str) {
        this.f13322e = str;
    }

    public int getHeight() {
        return this.f13326i;
    }

    public long getOriginalSize() {
        return this.m;
    }

    public int getWidth() {
        return this.f13325h;
    }

    public void setHeight(int i2) {
        this.f13326i = i2;
    }

    public void setWidth(int i2) {
        this.f13325h = i2;
    }

    public String w() {
        return this.f13324g;
    }

    public String x() {
        return this.q;
    }

    public String y() {
        return this.f13323f;
    }

    public String z() {
        return this.p;
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        this.f13322e = null;
        this.f13323f = null;
        this.f13324g = null;
        this.f13325h = 1;
        this.f13326i = 1;
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
        this.f13322e = pbContent.src;
        String str = pbContent.cdn_src;
        this.f13323f = str;
        if (str == null || str.length() == 0) {
            this.f13323f = this.f13322e;
        }
        String str2 = pbContent.big_cdn_src;
        this.f13324g = str2;
        this.q = pbContent.big_src;
        if (StringUtils.isNull(str2)) {
            this.f13324g = this.q;
        }
        String str3 = pbContent.bsize;
        if (str3 != null) {
            try {
                String[] split = str3.split(",");
                this.f13325h = Integer.valueOf(split[0]).intValue();
                this.f13326i = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13325h <= 0) {
            this.f13325h = 1;
        }
        if (this.f13326i <= 0) {
            this.f13326i = 1;
        }
        String str4 = this.f13323f;
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
        this.f13322e = null;
        this.f13323f = null;
        this.f13324g = null;
        this.f13325h = 1;
        this.f13326i = 1;
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
        this.f13322e = jSONObject.optString("src");
        String optString = jSONObject.optString("cdn_src", "");
        this.f13323f = optString;
        if (optString == null || optString.length() == 0) {
            this.f13323f = this.f13322e;
        }
        this.f13324g = jSONObject.optString("big_cdn_src", null);
        try {
            String[] split = jSONObject.optString("bsize").split(",");
            this.f13325h = Integer.valueOf(split[0]).intValue();
            this.f13326i = Integer.valueOf(split[1]).intValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f13325h <= 0) {
            this.f13325h = 1;
        }
        if (this.f13326i <= 0) {
            this.f13326i = 1;
        }
        String str = this.f13323f;
        if (str == null || str.indexOf(Domains.BAIDU) == -1) {
            return;
        }
        this.j = true;
    }
}

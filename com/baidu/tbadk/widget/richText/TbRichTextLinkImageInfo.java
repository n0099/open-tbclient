package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13977e;

    /* renamed from: f  reason: collision with root package name */
    public int f13978f;

    /* renamed from: g  reason: collision with root package name */
    public String f13979g;

    /* renamed from: h  reason: collision with root package name */
    public String f13980h;
    public boolean i;

    public TbRichTextLinkImageInfo() {
        this.f13977e = 1;
        this.f13978f = 1;
        this.f13979g = null;
        this.f13980h = null;
        this.i = true;
    }

    public int getHeight() {
        return this.f13978f;
    }

    public String getLink() {
        return this.f13980h;
    }

    public int getWidth() {
        return this.f13977e;
    }

    public String s() {
        return this.f13979g;
    }

    public boolean t() {
        return this.i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13977e = 1;
        this.f13978f = 1;
        this.f13979g = null;
        this.f13980h = null;
        this.i = true;
        this.f13979g = pbContent.cdn_src;
        this.f13980h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13977e = Integer.valueOf(split[0]).intValue();
                this.f13978f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13977e <= 0) {
            this.f13977e = 1;
        }
        if (this.f13978f <= 0) {
            this.f13978f = 1;
        }
        String str2 = this.f13979g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13985e;

    /* renamed from: f  reason: collision with root package name */
    public int f13986f;

    /* renamed from: g  reason: collision with root package name */
    public String f13987g;

    /* renamed from: h  reason: collision with root package name */
    public String f13988h;
    public boolean i;

    public TbRichTextLinkImageInfo() {
        this.f13985e = 1;
        this.f13986f = 1;
        this.f13987g = null;
        this.f13988h = null;
        this.i = true;
    }

    public int getHeight() {
        return this.f13986f;
    }

    public String getLink() {
        return this.f13988h;
    }

    public int getWidth() {
        return this.f13985e;
    }

    public String s() {
        return this.f13987g;
    }

    public boolean t() {
        return this.i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13985e = 1;
        this.f13986f = 1;
        this.f13987g = null;
        this.f13988h = null;
        this.i = true;
        this.f13987g = pbContent.cdn_src;
        this.f13988h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13985e = Integer.valueOf(split[0]).intValue();
                this.f13986f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13985e <= 0) {
            this.f13985e = 1;
        }
        if (this.f13986f <= 0) {
            this.f13986f = 1;
        }
        String str2 = this.f13987g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

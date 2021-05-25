package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13267e;

    /* renamed from: f  reason: collision with root package name */
    public int f13268f;

    /* renamed from: g  reason: collision with root package name */
    public String f13269g;

    /* renamed from: h  reason: collision with root package name */
    public String f13270h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13271i;

    public TbRichTextLinkImageInfo() {
        this.f13267e = 1;
        this.f13268f = 1;
        this.f13269g = null;
        this.f13270h = null;
        this.f13271i = true;
    }

    public int getHeight() {
        return this.f13268f;
    }

    public String getLink() {
        return this.f13270h;
    }

    public int getWidth() {
        return this.f13267e;
    }

    public String s() {
        return this.f13269g;
    }

    public boolean t() {
        return this.f13271i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13267e = 1;
        this.f13268f = 1;
        this.f13269g = null;
        this.f13270h = null;
        this.f13271i = true;
        this.f13269g = pbContent.cdn_src;
        this.f13270h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13267e = Integer.valueOf(split[0]).intValue();
                this.f13268f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13267e <= 0) {
            this.f13267e = 1;
        }
        if (this.f13268f <= 0) {
            this.f13268f = 1;
        }
        String str2 = this.f13269g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

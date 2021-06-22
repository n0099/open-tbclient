package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13414e;

    /* renamed from: f  reason: collision with root package name */
    public int f13415f;

    /* renamed from: g  reason: collision with root package name */
    public String f13416g;

    /* renamed from: h  reason: collision with root package name */
    public String f13417h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13418i;

    public TbRichTextLinkImageInfo() {
        this.f13414e = 1;
        this.f13415f = 1;
        this.f13416g = null;
        this.f13417h = null;
        this.f13418i = true;
    }

    public int getHeight() {
        return this.f13415f;
    }

    public String getLink() {
        return this.f13417h;
    }

    public int getWidth() {
        return this.f13414e;
    }

    public String w() {
        return this.f13416g;
    }

    public boolean x() {
        return this.f13418i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13414e = 1;
        this.f13415f = 1;
        this.f13416g = null;
        this.f13417h = null;
        this.f13418i = true;
        this.f13416g = pbContent.cdn_src;
        this.f13417h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13414e = Integer.valueOf(split[0]).intValue();
                this.f13415f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13414e <= 0) {
            this.f13414e = 1;
        }
        if (this.f13415f <= 0) {
            this.f13415f = 1;
        }
        String str2 = this.f13416g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

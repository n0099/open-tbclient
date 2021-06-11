package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13332e;

    /* renamed from: f  reason: collision with root package name */
    public int f13333f;

    /* renamed from: g  reason: collision with root package name */
    public String f13334g;

    /* renamed from: h  reason: collision with root package name */
    public String f13335h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13336i;

    public TbRichTextLinkImageInfo() {
        this.f13332e = 1;
        this.f13333f = 1;
        this.f13334g = null;
        this.f13335h = null;
        this.f13336i = true;
    }

    public int getHeight() {
        return this.f13333f;
    }

    public String getLink() {
        return this.f13335h;
    }

    public int getWidth() {
        return this.f13332e;
    }

    public String w() {
        return this.f13334g;
    }

    public boolean x() {
        return this.f13336i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13332e = 1;
        this.f13333f = 1;
        this.f13334g = null;
        this.f13335h = null;
        this.f13336i = true;
        this.f13334g = pbContent.cdn_src;
        this.f13335h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13332e = Integer.valueOf(split[0]).intValue();
                this.f13333f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13332e <= 0) {
            this.f13332e = 1;
        }
        if (this.f13333f <= 0) {
            this.f13333f = 1;
        }
        String str2 = this.f13334g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

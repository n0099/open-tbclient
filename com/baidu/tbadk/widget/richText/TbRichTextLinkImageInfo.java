package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13359e;

    /* renamed from: f  reason: collision with root package name */
    public int f13360f;

    /* renamed from: g  reason: collision with root package name */
    public String f13361g;

    /* renamed from: h  reason: collision with root package name */
    public String f13362h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13363i;

    public TbRichTextLinkImageInfo() {
        this.f13359e = 1;
        this.f13360f = 1;
        this.f13361g = null;
        this.f13362h = null;
        this.f13363i = true;
    }

    public int getHeight() {
        return this.f13360f;
    }

    public String getLink() {
        return this.f13362h;
    }

    public int getWidth() {
        return this.f13359e;
    }

    public String s() {
        return this.f13361g;
    }

    public boolean t() {
        return this.f13363i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f13359e = 1;
        this.f13360f = 1;
        this.f13361g = null;
        this.f13362h = null;
        this.f13363i = true;
        this.f13361g = pbContent.cdn_src;
        this.f13362h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f13359e = Integer.valueOf(split[0]).intValue();
                this.f13360f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13359e <= 0) {
            this.f13359e = 1;
        }
        if (this.f13360f <= 0) {
            this.f13360f = 1;
        }
        String str2 = this.f13361g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

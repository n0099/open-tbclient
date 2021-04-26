package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14023e;

    /* renamed from: f  reason: collision with root package name */
    public int f14024f;

    /* renamed from: g  reason: collision with root package name */
    public String f14025g;

    /* renamed from: h  reason: collision with root package name */
    public String f14026h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14027i;

    public TbRichTextLinkImageInfo() {
        this.f14023e = 1;
        this.f14024f = 1;
        this.f14025g = null;
        this.f14026h = null;
        this.f14027i = true;
    }

    public int getHeight() {
        return this.f14024f;
    }

    public String getLink() {
        return this.f14026h;
    }

    public int getWidth() {
        return this.f14023e;
    }

    public String s() {
        return this.f14025g;
    }

    public boolean t() {
        return this.f14027i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f14023e = 1;
        this.f14024f = 1;
        this.f14025g = null;
        this.f14026h = null;
        this.f14027i = true;
        this.f14025g = pbContent.cdn_src;
        this.f14026h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f14023e = Integer.valueOf(split[0]).intValue();
                this.f14024f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f14023e <= 0) {
            this.f14023e = 1;
        }
        if (this.f14024f <= 0) {
            this.f14024f = 1;
        }
        String str2 = this.f14025g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

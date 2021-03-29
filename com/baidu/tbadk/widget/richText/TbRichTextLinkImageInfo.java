package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkImageInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14301e;

    /* renamed from: f  reason: collision with root package name */
    public int f14302f;

    /* renamed from: g  reason: collision with root package name */
    public String f14303g;

    /* renamed from: h  reason: collision with root package name */
    public String f14304h;
    public boolean i;

    public TbRichTextLinkImageInfo() {
        this.f14301e = 1;
        this.f14302f = 1;
        this.f14303g = null;
        this.f14304h = null;
        this.i = true;
    }

    public int getHeight() {
        return this.f14302f;
    }

    public String getLink() {
        return this.f14304h;
    }

    public int getWidth() {
        return this.f14301e;
    }

    public String s() {
        return this.f14303g;
    }

    public boolean t() {
        return this.i;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        this.f14301e = 1;
        this.f14302f = 1;
        this.f14303g = null;
        this.f14304h = null;
        this.i = true;
        this.f14303g = pbContent.cdn_src;
        this.f14304h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f14301e = Integer.valueOf(split[0]).intValue();
                this.f14302f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f14301e <= 0) {
            this.f14301e = 1;
        }
        if (this.f14302f <= 0) {
            this.f14302f = 1;
        }
        String str2 = this.f14303g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

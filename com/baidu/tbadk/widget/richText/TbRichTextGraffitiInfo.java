package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextGraffitiInfo extends OrmObject {
    static final int aQG = k.f(TbadkCoreApplication.getInst(), d.f.ds360);
    static final int aQH = k.f(TbadkCoreApplication.getInst(), d.f.ds300);
    public long gid;
    public String url;
    public int width = aQH;
    public int height = this.width;

    public void a(PbContent pbContent) {
        String[] split;
        if (pbContent != null && pbContent.graffiti_info != null) {
            this.url = pbContent.graffiti_info.url;
            this.gid = pbContent.graffiti_info.gid.longValue();
            String str = pbContent.bsize;
            if (str != null && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length == 2) {
                this.width = com.baidu.adp.lib.g.b.g(split[0], 0);
                this.height = com.baidu.adp.lib.g.b.g(split[1], 0);
            }
        }
    }

    public void fA(int i) {
        if (i == 1) {
            this.width = aQG;
            this.height = this.width;
        } else if (this.width != this.height || this.width <= 0 || this.width > aQH) {
            this.width = aQH;
            this.height = this.width;
        }
    }
}

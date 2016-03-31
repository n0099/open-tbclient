package com.baidu.tbadk.widget.richText;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.b.a.a.i {
    static final int aIq = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds360);
    static final int aIr = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds300);
    public long gid;
    public String url;
    public int width = aIr;
    public int height = this.width;

    public void a(PbContent pbContent) {
        String[] split;
        if (pbContent != null && pbContent.graffiti_info != null) {
            this.url = pbContent.graffiti_info.url;
            this.gid = pbContent.graffiti_info.gid.longValue();
            String str = pbContent.bsize;
            if (str != null && (split = str.split(",")) != null && split.length == 2) {
                this.width = com.baidu.adp.lib.h.b.g(split[0], 0);
                this.height = com.baidu.adp.lib.h.b.g(split[1], 0);
            }
        }
    }

    public void fx(int i) {
        if (i == 1) {
            this.width = aIq;
            this.height = this.width;
        } else if (this.width != this.height || this.width <= 0 || this.width > aIr) {
            this.width = aIr;
            this.height = this.width;
        }
    }
}

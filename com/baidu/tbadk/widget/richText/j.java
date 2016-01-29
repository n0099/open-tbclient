package com.baidu.tbadk.widget.richText;

import tbclient.PbContent;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.b.a.a.i {
    public int aFH;
    public String link;

    public j(PbContent pbContent) {
        if (pbContent != null) {
            this.aFH = pbContent.btn_type.intValue();
            this.link = pbContent.link;
        }
    }

    public String getLink() {
        return this.link;
    }
}

package com.baidu.tbadk.widget.richText;

import tbclient.PbContent;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.a.b.a.a.i {
    public int aJu;
    public String link;

    public k(PbContent pbContent) {
        if (pbContent != null) {
            this.aJu = pbContent.btn_type.intValue();
            this.link = pbContent.link;
        }
    }

    public String getLink() {
        return this.link;
    }
}

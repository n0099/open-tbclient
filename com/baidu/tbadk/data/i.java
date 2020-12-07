package com.baidu.tbadk.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private String link;
    private TbPageContext pageContext;

    public i() {
    }

    public i(TbPageContext tbPageContext, String str) {
        this.pageContext = tbPageContext;
        this.link = str;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public String getLink() {
        return this.link;
    }
}

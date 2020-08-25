package com.baidu.tbadk.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class h {
    private String link;
    private TbPageContext pageContext;

    public h() {
    }

    public h(TbPageContext tbPageContext, String str) {
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

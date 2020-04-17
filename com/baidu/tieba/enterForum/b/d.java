package com.baidu.tieba.enterForum.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
/* loaded from: classes9.dex */
public class d {
    private RecommendForumHorizontalView gKn;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gKn = new RecommendForumHorizontalView(tbPageContext);
        this.gKn.setShowMore(true);
        this.gKn.setSquareEntranceAtStart(true);
        this.gKn.setTabName(null);
        this.gKn.setFrom(0);
    }

    public RecommendForumHorizontalView bKt() {
        return this.gKn;
    }

    public void c(l lVar) {
        this.gKn.b(lVar);
    }
}

package com.baidu.tieba.enterForum.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
/* loaded from: classes9.dex */
public class d {
    private RecommendForumHorizontalView gZq;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gZq = new RecommendForumHorizontalView(tbPageContext);
        this.gZq.setShowMore(true);
        this.gZq.setSquareEntranceAtStart(true);
        this.gZq.setTabName(null);
        this.gZq.setFrom(0);
    }

    public RecommendForumHorizontalView bQP() {
        return this.gZq;
    }

    public void c(l lVar) {
        this.gZq.b(lVar);
    }
}

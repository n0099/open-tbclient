package com.baidu.tieba.enterForum.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
/* loaded from: classes9.dex */
public class d {
    private RecommendForumHorizontalView gZf;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gZf = new RecommendForumHorizontalView(tbPageContext);
        this.gZf.setShowMore(true);
        this.gZf.setSquareEntranceAtStart(true);
        this.gZf.setTabName(null);
        this.gZf.setFrom(0);
    }

    public RecommendForumHorizontalView bQN() {
        return this.gZf;
    }

    public void c(l lVar) {
        this.gZf.b(lVar);
    }
}

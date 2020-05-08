package com.baidu.tieba.enterForum.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
/* loaded from: classes9.dex */
public class d {
    private RecommendForumHorizontalView gKt;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gKt = new RecommendForumHorizontalView(tbPageContext);
        this.gKt.setShowMore(true);
        this.gKt.setSquareEntranceAtStart(true);
        this.gKt.setTabName(null);
        this.gKt.setFrom(0);
    }

    public RecommendForumHorizontalView bKr() {
        return this.gKt;
    }

    public void c(l lVar) {
        this.gKt.b(lVar);
    }
}

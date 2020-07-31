package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes16.dex */
public class d {
    private RecommendForumLayout hrn;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener hoX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a ajj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.c.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bog() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f agN = new com.baidu.tbadk.h.f<bh>() { // from class: com.baidu.tieba.enterForum.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bh bhVar, int i, long j) {
            if (bhVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = bhVar.getForumName();
            if (as.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bh bhVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hrn = new RecommendForumLayout(tbPageContext);
        this.hrn.setShowMore(true);
        this.hrn.setSquareEntranceAtStart(true);
        this.hrn.setTabName(null);
        this.hrn.setFrom(0);
        this.hrn.setOnClickRightArrowListener(this.hoX);
        this.hrn.setOnRullOkCallbackr(this.ajj);
        this.hrn.setOnItemCoverListener(this.agN);
    }

    public RecommendForumLayout bXf() {
        return this.hrn;
    }

    public void d(bi biVar) {
        this.hrn.b(biVar);
    }
}

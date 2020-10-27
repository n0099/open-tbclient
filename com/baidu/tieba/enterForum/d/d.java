package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes22.dex */
public class d {
    private RecommendForumLayout imI;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener ikr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a alt = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.d.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bCG() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f aiM = new com.baidu.tbadk.h.f<bi>() { // from class: com.baidu.tieba.enterForum.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = biVar.getForumName();
            if (at.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bi biVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.imI = new RecommendForumLayout(tbPageContext);
        this.imI.setShowMore(true);
        this.imI.setSquareEntranceAtStart(true);
        this.imI.setTabName(null);
        this.imI.setFrom(0);
        this.imI.setOnClickRightArrowListener(this.ikr);
        this.imI.setOnRullOkCallbackr(this.alt);
        this.imI.setOnItemCoverListener(this.aiM);
    }

    public RecommendForumLayout crl() {
        return this.imI;
    }

    public void d(bj bjVar) {
        this.imI.b(bjVar);
    }
}

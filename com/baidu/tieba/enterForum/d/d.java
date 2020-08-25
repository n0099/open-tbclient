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
/* loaded from: classes16.dex */
public class d {
    private RecommendForumLayout hEe;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener hBO = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a aky = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.d.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bwT() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f ahW = new com.baidu.tbadk.h.f<bi>() { // from class: com.baidu.tieba.enterForum.d.d.3
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
        this.hEe = new RecommendForumLayout(tbPageContext);
        this.hEe.setShowMore(true);
        this.hEe.setSquareEntranceAtStart(true);
        this.hEe.setTabName(null);
        this.hEe.setFrom(0);
        this.hEe.setOnClickRightArrowListener(this.hBO);
        this.hEe.setOnRullOkCallbackr(this.aky);
        this.hEe.setOnItemCoverListener(this.ahW);
    }

    public RecommendForumLayout chs() {
        return this.hEe;
    }

    public void d(bj bjVar) {
        this.hEe.b(bjVar);
    }
}

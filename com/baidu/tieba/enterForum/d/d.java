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
    private RecommendForumLayout isG;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener iqq = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a alt = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.d.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bFf() {
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
        this.isG = new RecommendForumLayout(tbPageContext);
        this.isG.setShowMore(true);
        this.isG.setSquareEntranceAtStart(true);
        this.isG.setTabName(null);
        this.isG.setFrom(0);
        this.isG.setOnClickRightArrowListener(this.iqq);
        this.isG.setOnRullOkCallbackr(this.alt);
        this.isG.setOnItemCoverListener(this.aiM);
    }

    public RecommendForumLayout ctM() {
        return this.isG;
    }

    public void d(bj bjVar) {
        this.isG.b(bjVar);
    }
}

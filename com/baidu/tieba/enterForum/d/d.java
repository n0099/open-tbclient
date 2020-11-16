package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes21.dex */
public class d {
    private RecommendForumLayout itu;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener ire = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a alx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.d.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bEy() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f aiR = new com.baidu.tbadk.h.f<bj>() { // from class: com.baidu.tieba.enterForum.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bj bjVar, int i, long j) {
            if (bjVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = bjVar.getForumName();
            if (au.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bj bjVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.itu = new RecommendForumLayout(tbPageContext);
        this.itu.setShowMore(true);
        this.itu.setSquareEntranceAtStart(true);
        this.itu.setTabName(null);
        this.itu.setFrom(0);
        this.itu.setOnClickRightArrowListener(this.ire);
        this.itu.setOnRullOkCallbackr(this.alx);
        this.itu.setOnItemCoverListener(this.aiR);
    }

    public RecommendForumLayout ctp() {
        return this.itu;
    }

    public void d(bk bkVar) {
        this.itu.b(bkVar);
    }
}

package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes2.dex */
public class d {
    private RecommendForumLayout iRB;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener iPl = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a alZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.c.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bGW() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f ajq = new com.baidu.tbadk.h.f<bn>() { // from class: com.baidu.tieba.enterForum.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bn bnVar, int i, long j) {
            if (bnVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = bnVar.getForumName();
            if (au.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bn bnVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iRB = new RecommendForumLayout(tbPageContext);
        this.iRB.setShowMore(true);
        this.iRB.setSquareEntranceAtStart(true);
        this.iRB.setTabName(null);
        this.iRB.setFrom(0);
        this.iRB.setOnClickRightArrowListener(this.iPl);
        this.iRB.setOnRullOkCallbackr(this.alZ);
        this.iRB.setOnItemCoverListener(this.ajq);
    }

    public RecommendForumLayout cxT() {
        return this.iRB;
    }

    public void d(bo boVar) {
        this.iRB.b(boVar);
    }
}

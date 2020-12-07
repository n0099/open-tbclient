package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes22.dex */
public class d {
    private RecommendForumLayout iEm;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener iBW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a amx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.d.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bHZ() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f ajQ = new com.baidu.tbadk.h.f<bk>() { // from class: com.baidu.tieba.enterForum.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bk bkVar, int i, long j) {
            if (bkVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = bkVar.getForumName();
            if (au.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bk bkVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iEm = new RecommendForumLayout(tbPageContext);
        this.iEm.setShowMore(true);
        this.iEm.setSquareEntranceAtStart(true);
        this.iEm.setTabName(null);
        this.iEm.setFrom(0);
        this.iEm.setOnClickRightArrowListener(this.iBW);
        this.iEm.setOnRullOkCallbackr(this.amx);
        this.iEm.setOnItemCoverListener(this.ajQ);
    }

    public RecommendForumLayout cxE() {
        return this.iEm;
    }

    public void d(bl blVar) {
        this.iEm.b(blVar);
    }
}

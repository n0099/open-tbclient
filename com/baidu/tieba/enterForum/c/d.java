package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes2.dex */
public class d {
    private RecommendForumLayout iQA;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener iOk = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a ana = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.c.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bKu() {
            com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f aks = new com.baidu.tbadk.h.f<bl>() { // from class: com.baidu.tieba.enterForum.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bl blVar, int i, long j) {
            if (blVar == null) {
                com.baidu.tieba.enterForum.b.d(d.this.mPageContext, null);
                return;
            }
            String forumName = blVar.getForumName();
            if (at.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bl blVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iQA = new RecommendForumLayout(tbPageContext);
        this.iQA.setShowMore(true);
        this.iQA.setSquareEntranceAtStart(true);
        this.iQA.setTabName(null);
        this.iQA.setFrom(0);
        this.iQA.setOnClickRightArrowListener(this.iOk);
        this.iQA.setOnRullOkCallbackr(this.ana);
        this.iQA.setOnItemCoverListener(this.aks);
    }

    public RecommendForumLayout cAz() {
        return this.iQA;
    }

    public void d(bm bmVar) {
        this.iQA.b(bmVar);
    }
}

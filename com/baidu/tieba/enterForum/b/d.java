package com.baidu.tieba.enterForum.b;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes9.dex */
public class d {
    private RecommendForumLayout hlB;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener hjp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.b(d.this.mPageContext, null);
        }
    };
    private PullLeftRefreshLayout.a ajo = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.b.d.2
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bkn() {
            com.baidu.tieba.enterForum.b.b(d.this.mPageContext, null);
        }
    };
    private com.baidu.tbadk.h.f agW = new com.baidu.tbadk.h.f<bg>() { // from class: com.baidu.tieba.enterForum.b.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bg bgVar, int i, long j) {
            if (bgVar == null) {
                com.baidu.tieba.enterForum.b.b(d.this.mPageContext, null);
                return;
            }
            String forumName = bgVar.getForumName();
            if (ar.isForumName(forumName)) {
                d.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bg bgVar, int i, long j) {
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hlB = new RecommendForumLayout(tbPageContext);
        this.hlB.setShowMore(true);
        this.hlB.setSquareEntranceAtStart(true);
        this.hlB.setTabName(null);
        this.hlB.setFrom(0);
        this.hlB.setOnClickRightArrowListener(this.hjp);
        this.hlB.setOnRullOkCallbackr(this.ajo);
        this.hlB.setOnItemCoverListener(this.agW);
    }

    public RecommendForumLayout bTM() {
        return this.hlB;
    }

    public void d(bh bhVar) {
        this.hlB.b(bhVar);
    }
}

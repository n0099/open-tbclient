package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ae;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<bo, ThreadCardViewHolder<bo>> implements com.baidu.tieba.a.f {
    private String ajx;
    private com.baidu.tbadk.h.f akI;
    private s anC;
    private View.OnClickListener anq;
    private PullLeftRefreshLayout.a anr;
    public BdUniqueId fIy;
    private String mClassName;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void cSh() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mPageContext.getPageActivity(), this.mClassName)));
        ar arVar = new ar("c13757");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.bsR();
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.anq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cSh();
            }
        };
        this.anr = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bHa() {
                a.this.cSh();
            }
        };
        this.akI = new com.baidu.tbadk.h.f<bn>() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bn bnVar, int i, long j) {
                if (bnVar == null) {
                    a.this.cSh();
                    return;
                }
                String forumName = bnVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.homepage.tabfeed.b.c("c13756", bnVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bn bnVar, int i, long j) {
                if (bnVar != null) {
                    com.baidu.tieba.homepage.tabfeed.b.b("c13756", bnVar, i + 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        ae aeVar = new ae(this.mPageContext, this.fIy);
        aeVar.setOnRullOkCallbackr(this.anr);
        aeVar.setOnClickRightArrowListener(this.anq);
        aeVar.setOnItemCoverListener(this.akI);
        aVar.c(aeVar);
        aVar.ti().bA(0);
        aVar.ti().bC(0);
        aVar.ti().bB(0);
        aVar.ti().by(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.anC));
        threadCardViewHolder.setPageId(this.fIy);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bo boVar, ThreadCardViewHolder<bo> threadCardViewHolder) {
        if (boVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.ajx);
        }
        this.mClassName = boVar.className;
        threadCardViewHolder.b((ThreadCardViewHolder<bo>) boVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}

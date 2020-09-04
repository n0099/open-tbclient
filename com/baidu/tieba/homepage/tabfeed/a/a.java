package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ad;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<bj, al<bj>> implements com.baidu.tieba.a.f {
    private String agJ;
    private com.baidu.tbadk.h.f ahY;
    private PullLeftRefreshLayout.a akA;
    private v akK;
    private View.OnClickListener akz;
    public BdUniqueId ePz;
    private String mClassName;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void cyL() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mPageContext.getPageActivity(), this.mClassName)));
        aq aqVar = new aq("c13757");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.bjn();
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cyL();
            }
        };
        this.akA = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bwU() {
                a.this.cyL();
            }
        };
        this.ahY = new com.baidu.tbadk.h.f<bi>() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bi biVar, int i, long j) {
                if (biVar == null) {
                    a.this.cyL();
                    return;
                }
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.homepage.tabfeed.b.c("c13756", biVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bi biVar, int i, long j) {
                if (biVar != null) {
                    com.baidu.tieba.homepage.tabfeed.b.b("c13756", biVar, i + 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.akK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        ad adVar = new ad(this.mPageContext, this.ePz);
        adVar.setOnRullOkCallbackr(this.akA);
        adVar.setOnClickRightArrowListener(this.akz);
        adVar.setOnItemCoverListener(this.ahY);
        aVar.c(adVar);
        aVar.tP().bv(0);
        aVar.tP().bx(0);
        aVar.tP().bw(0);
        aVar.tP().br(0);
        al alVar = new al(aVar.a(true, viewGroup, this.akK));
        alVar.setPageId(this.ePz);
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, al<bj> alVar) {
        if (bjVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.tR().setPosition(i);
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agJ);
        }
        this.mClassName = bjVar.className;
        alVar.b((al<bj>) bjVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}

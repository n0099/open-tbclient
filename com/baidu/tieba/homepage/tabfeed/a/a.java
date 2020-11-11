package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ae;
import com.baidu.card.ak;
import com.baidu.card.am;
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
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<bj, am<bj>> implements com.baidu.tieba.a.f {
    private String ahu;
    private com.baidu.tbadk.h.f aiM;
    private v alD;
    private View.OnClickListener als;
    private PullLeftRefreshLayout.a alt;
    public BdUniqueId fsQ;
    private String mClassName;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void cLJ() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mPageContext.getPageActivity(), this.mClassName)));
        aq aqVar = new aq("c13757");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.brk();
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.als = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cLJ();
            }
        };
        this.alt = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bFf() {
                a.this.cLJ();
            }
        };
        this.aiM = new com.baidu.tbadk.h.f<bi>() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bi biVar, int i, long j) {
                if (biVar == null) {
                    a.this.cLJ();
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
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        ae aeVar = new ae(this.mPageContext, this.fsQ);
        aeVar.setOnRullOkCallbackr(this.alt);
        aeVar.setOnClickRightArrowListener(this.als);
        aeVar.setOnItemCoverListener(this.aiM);
        aVar.c(aeVar);
        aVar.tU().bz(0);
        aVar.tU().bB(0);
        aVar.tU().bA(0);
        aVar.tU().bv(0);
        am amVar = new am(aVar.a(true, viewGroup, this.alD));
        amVar.setPageId(this.fsQ);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, am<bj> amVar) {
        if (bjVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahu);
        }
        this.mClassName = bjVar.className;
        amVar.b((am<bj>) bjVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}

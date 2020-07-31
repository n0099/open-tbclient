package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ac;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<bi, ak<bi>> implements com.baidu.tieba.a.f {
    private String afx;
    private com.baidu.tbadk.h.f agN;
    private View.OnClickListener aji;
    private PullLeftRefreshLayout.a ajj;
    private v ajt;
    public BdUniqueId eEU;
    private String mClassName;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mPageContext.getPageActivity(), this.mClassName)));
        ap apVar = new ap("c13757");
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.baO();
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aji = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cnR();
            }
        };
        this.ajj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bog() {
                a.this.cnR();
            }
        };
        this.agN = new com.baidu.tbadk.h.f<bh>() { // from class: com.baidu.tieba.homepage.tabfeed.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bh bhVar, int i, long j) {
                if (bhVar == null) {
                    a.this.cnR();
                    return;
                }
                String forumName = bhVar.getForumName();
                if (as.isForumName(forumName)) {
                    a.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.homepage.tabfeed.b.b("c13756", bhVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bh bhVar, int i, long j) {
                if (bhVar != null) {
                    com.baidu.tieba.homepage.tabfeed.b.c("c13756", bhVar, i + 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        ac acVar = new ac(this.mPageContext, this.eEU);
        acVar.setOnRullOkCallbackr(this.ajj);
        acVar.setOnClickRightArrowListener(this.aji);
        acVar.setOnItemCoverListener(this.agN);
        aVar.c(acVar);
        aVar.se().bq(0);
        aVar.se().bs(0);
        aVar.se().br(0);
        aVar.se().bm(0);
        ak akVar = new ak(aVar.a(true, viewGroup, this.ajt));
        akVar.setPageId(this.eEU);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, ak<bi> akVar) {
        if (biVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPosition(i);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        this.mClassName = biVar.className;
        akVar.b((ak<bi>) biVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}

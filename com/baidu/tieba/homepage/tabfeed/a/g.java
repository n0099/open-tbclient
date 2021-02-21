package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<ca, ThreadCardViewHolder<cb>> {
    private ab<cb> agg;
    private boolean akO;
    private s amk;
    public BdUniqueId fGZ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.agg = new ab<cb>() { // from class: com.baidu.tieba.homepage.tabfeed.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                t.csB().mG(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, cbVar, g.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.akO);
        aVar.c(yVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new w() { // from class: com.baidu.tieba.homepage.tabfeed.a.g.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eJQ;
                    cbVar.objType = 1;
                    if (g.this.agg != null) {
                        g.this.agg.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 2, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || caVar.eJQ == null) {
            return null;
        }
        caVar.eJQ.eOs = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.homepage.tabfeed.b.a(caVar, this.mTabName);
        y yVar = (y) threadCardViewHolder.tj().tc();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.ahs.alo.getLayoutParams();
        layoutParams.width = caVar.eQj;
        layoutParams.height = caVar.eQk;
        if (yVar.ahs.alo.getVisibility() != 8) {
            yVar.ahs.alo.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.getView();
    }
}

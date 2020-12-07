package com.baidu.tieba.homepage.video.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.k;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, am<k>> {
    private ab<k> agG;
    private v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<k>() { // from class: com.baidu.tieba.homepage.video.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.bmn() != null) {
                    c.this.c(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, k kVar) {
        if (kVar != null) {
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                com.baidu.tieba.homepage.video.c.a.p(kVar);
            } else if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                com.baidu.tieba.homepage.video.c.a.q(kVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        aVar.tY().bA(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        aVar.a(new m(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.amH);
        a2.setSourceForPb(19);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.video.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(kVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, am<k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.b((am<k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
    }
}

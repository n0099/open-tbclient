package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class k extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private ab<bw> afF;
    private v alD;
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                t.cor().lN(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, k.this.mTabName);
            }
        };
        this.fPf = new NEGFeedBackView.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.k.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(com.baidu.tbadk.core.util.l.a(arVar, k.this.mTabName));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str2, ar arVar) {
            }
        };
        this.mPageContext = tbPageContext;
        this.fsQ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.k.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.k.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (k.this.afF != null) {
                        k.this.afF.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.exA == null) {
            return null;
        }
        bvVar.exA.eBK = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.a(true, Align.ALIGN_RIGHT_TOP, this.fPf);
        amVar.b((am<bw>) bvVar.exA);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        return amVar.getView();
    }
}

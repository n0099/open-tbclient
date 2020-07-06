package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.adX = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    f.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        } else if (view instanceof TbImageView) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        wVar.setFromCDN(this.aik);
        aVar.c(wVar);
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(1);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.f.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (f.this.adX != null) {
                        f.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        com.baidu.tieba.card.s.bOB().e(kVar.DU("c12351"));
        akVar.se().setPosition(i);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.card.w wVar = (com.baidu.card.w) akVar.se().rX();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) wVar.aeV.aiS.getLayoutParams();
        layoutParams.width = kVar.dLj;
        layoutParams.height = kVar.dLk;
        if (wVar.aeV.aiS.getVisibility() != 8) {
            wVar.aeV.aiS.setLayoutParams(layoutParams);
        }
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}

package com.baidu.tieba.homepage.personalize.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes9.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> {
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> hix;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hix = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                super.a(view, (View) kVar);
                if (kVar != null && kVar.aPS() != null && !com.baidu.tbadk.core.util.w.isEmpty(kVar.aPS().aUx()) && kVar.aPS().aUx().get(0) != null) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (!TextUtils.isEmpty(kVar.aPS().aUx().get(0).linkUrl) && (currentActivity instanceof TbPageContextSupport)) {
                        bc.aWU().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{kVar.aPS().aUx().get(0).linkUrl});
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ae(this.mPageContext.getPageActivity()));
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(a);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    if (r.this.hix != null) {
                        r.this.hix.a(akVar2.getView(), kVar);
                    }
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
        akVar.se().setPosition(i);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }
}

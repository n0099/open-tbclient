package com.baidu.tieba.homepage.tabfeed.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.ae;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.widget.ListView.a<bt, ak<bu>> {
    private v ajy;
    public BdUniqueId eyE;
    private aa<com.baidu.tieba.card.data.k> hix;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hix = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                super.a(view, (View) kVar);
                if (kVar != null && kVar.aPS() != null && !w.isEmpty(kVar.aPS().aUx()) && kVar.aPS().aUx().get(0) != null) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (!TextUtils.isEmpty(kVar.aPS().aUx().get(0).linkUrl) && (currentActivity instanceof TbPageContextSupport)) {
                        bc.aWU().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{kVar.aPS().aUx().get(0).linkUrl});
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new ae(this.mPageContext.getPageActivity()));
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak<bu> akVar = new ak<>(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.m.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    if (m.this.hix != null) {
                        m.this.hix.a(akVar2.getView(), kVar);
                    }
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, ak<bu> akVar) {
        if (btVar == null || akVar == null || akVar.getView() == null || btVar.dLi == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        akVar.se().setPosition(i);
        akVar.b((ak<bu>) btVar.dLi);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }
}

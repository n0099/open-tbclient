package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.aw;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class p extends f<au, a> {
    private com.baidu.tieba.frs.view.c daS;

    public p(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.daS = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.daS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, au auVar, a aVar) {
        super.onFillViewHolder(i, view2, viewGroup, auVar, aVar);
        this.daS = aVar.daT;
        ArrayList<aw> rk = auVar.rk();
        if (rk.size() <= 0) {
            return null;
        }
        q qVar = new q();
        qVar.showTopDivider = true;
        qVar.mGroupTitle = auVar.getTitle();
        for (int i2 = 0; i2 != rk.size(); i2++) {
            aw awVar = rk.get(i2);
            if (awVar != null) {
                an anVar = new an();
                anVar.metaData.setUserId(awVar.getUid());
                anVar.metaData.setUserName(awVar.rp());
                anVar.metaData.setPortrait(awVar.getPortrait());
                anVar.metaData.getGodUserData().setIsLike(awVar.getIsLike() == 1);
                anVar.metaData.getGodUserData().setIntro(awVar.rq());
                qVar.a(anVar);
            }
        }
        this.daS.d(this.mPageContext, this.mSkinType);
        aVar.daT.a(qVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.frs.view.c daT;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.daT = cVar;
        }
    }
}

package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.ba;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class r extends h<ay, a> {
    private com.baidu.tieba.frs.view.d fxC;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fxC = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.fxC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ay ayVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, ayVar, aVar);
        this.fxC = aVar.fxD;
        ArrayList<ba> adG = ayVar.adG();
        if (adG.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = ayVar.getTitle();
        for (int i2 = 0; i2 != adG.size(); i2++) {
            ba baVar = adG.get(i2);
            if (baVar != null) {
                an anVar = new an();
                anVar.metaData.setUserId(baVar.getUid());
                anVar.metaData.setUserName(baVar.adL());
                anVar.metaData.setPortrait(baVar.getPortrait());
                anVar.metaData.getGodUserData().setIsLike(baVar.getIsLike() == 1);
                anVar.metaData.getGodUserData().setIntro(baVar.adM());
                sVar.a(anVar);
            }
        }
        this.fxC.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.fxD.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d fxD;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.fxD = dVar;
        }
    }
}

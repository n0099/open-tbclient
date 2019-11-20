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
    private com.baidu.tieba.frs.view.d fxM;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a b(ViewGroup viewGroup) {
        this.fxM = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.fxM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ay ayVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) ayVar, (ay) aVar);
        this.fxM = aVar.fxN;
        ArrayList<ba> ahM = ayVar.ahM();
        if (ahM.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = ayVar.getTitle();
        for (int i2 = 0; i2 != ahM.size(); i2++) {
            ba baVar = ahM.get(i2);
            if (baVar != null) {
                an anVar = new an();
                anVar.metaData.setUserId(baVar.getUid());
                anVar.metaData.setUserName(baVar.ahR());
                anVar.metaData.setPortrait(baVar.getPortrait());
                anVar.metaData.getGodUserData().setIsLike(baVar.getIsLike() == 1);
                anVar.metaData.getGodUserData().setIntro(baVar.ahS());
                sVar.a(anVar);
            }
        }
        this.fxM.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.fxN.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d fxN;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.fxN = dVar;
        }
    }
}

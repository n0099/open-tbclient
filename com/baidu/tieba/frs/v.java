package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class v extends h<bb, a> {
    private com.baidu.tieba.frs.view.c hqJ;

    public v(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public a b(ViewGroup viewGroup) {
        this.hqJ = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.hqJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) bbVar, (bb) aVar);
        this.hqJ = aVar.hqK;
        ArrayList<bd> aPH = bbVar.aPH();
        if (aPH.size() <= 0) {
            return null;
        }
        w wVar = new w();
        wVar.showTopDivider = true;
        wVar.mGroupTitle = bbVar.getTitle();
        for (int i2 = 0; i2 != aPH.size(); i2++) {
            bd bdVar = aPH.get(i2);
            if (bdVar != null) {
                at atVar = new at();
                atVar.metaData.setUserId(bdVar.getUid());
                atVar.metaData.setUserName(bdVar.aPL());
                atVar.metaData.setPortrait(bdVar.getPortrait());
                atVar.metaData.getGodUserData().setIsLike(bdVar.getIsLike() == 1);
                atVar.metaData.getGodUserData().setIntro(bdVar.aPM());
                wVar.a(atVar);
            }
        }
        this.hqJ.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.hqK.a(wVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends aa.a {
        public com.baidu.tieba.frs.view.c hqK;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.hqK = cVar;
        }
    }
}

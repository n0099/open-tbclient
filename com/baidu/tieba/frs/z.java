package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bo;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class z extends k<bm, a> {
    private com.baidu.tieba.frs.view.e iMb;

    public z(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a c(ViewGroup viewGroup) {
        this.iMb = new com.baidu.tieba.frs.view.e(this.mPageContext, this.mPageId);
        return new a(this.iMb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bm bmVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) bmVar, (bm) aVar);
        this.iMb = aVar.iMc;
        ArrayList<bo> bkJ = bmVar.bkJ();
        if (bkJ.size() <= 0) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.showTopDivider = true;
        aaVar.mGroupTitle = bmVar.getTitle();
        for (int i2 = 0; i2 != bkJ.size(); i2++) {
            bo boVar = bkJ.get(i2);
            if (boVar != null) {
                bb bbVar = new bb();
                bbVar.metaData.setUserId(boVar.getUid());
                bbVar.metaData.setUserName(boVar.bkN());
                bbVar.metaData.setPortrait(boVar.getPortrait());
                bbVar.metaData.getGodUserData().setIsLike(boVar.getIsLike() == 1);
                bbVar.metaData.getGodUserData().setIntro(boVar.bkO());
                aaVar.a(bbVar);
            }
        }
        this.iMb.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.iMc.a(aaVar);
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public class a extends af.a {
        public com.baidu.tieba.frs.view.e iMc;

        public a(com.baidu.tieba.frs.view.e eVar) {
            super(eVar.getView());
            this.iMc = eVar;
        }
    }
}

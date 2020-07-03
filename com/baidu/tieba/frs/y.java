package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class y extends j<bj, a> {
    private com.baidu.tieba.frs.view.e hDw;

    public y(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public a b(ViewGroup viewGroup) {
        this.hDw = new com.baidu.tieba.frs.view.e(this.mPageContext, this.mPageId);
        return new a(this.hDw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        this.hDw = aVar.hDx;
        ArrayList<bl> aRw = bjVar.aRw();
        if (aRw.size() <= 0) {
            return null;
        }
        z zVar = new z();
        zVar.showTopDivider = true;
        zVar.mGroupTitle = bjVar.getTitle();
        for (int i2 = 0; i2 != aRw.size(); i2++) {
            bl blVar = aRw.get(i2);
            if (blVar != null) {
                az azVar = new az();
                azVar.metaData.setUserId(blVar.getUid());
                azVar.metaData.setUserName(blVar.aRA());
                azVar.metaData.setPortrait(blVar.getPortrait());
                azVar.metaData.getGodUserData().setIsLike(blVar.getIsLike() == 1);
                azVar.metaData.getGodUserData().setIntro(blVar.aRB());
                zVar.a(azVar);
            }
        }
        this.hDw.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.hDx.a(zVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends ad.a {
        public com.baidu.tieba.frs.view.e hDx;

        public a(com.baidu.tieba.frs.view.e eVar) {
            super(eVar.getView());
            this.hDx = eVar;
        }
    }
}

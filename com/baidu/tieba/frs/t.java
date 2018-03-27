package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class t extends g<com.baidu.tbadk.core.data.au, a> {
    private com.baidu.tieba.frs.view.d dGT;

    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dGT = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.dGT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.au auVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, auVar, aVar);
        this.dGT = aVar.dGU;
        ArrayList<com.baidu.tbadk.core.data.aw> yG = auVar.yG();
        if (yG.size() <= 0) {
            return null;
        }
        u uVar = new u();
        uVar.showTopDivider = true;
        uVar.mGroupTitle = auVar.getTitle();
        for (int i2 = 0; i2 != yG.size(); i2++) {
            com.baidu.tbadk.core.data.aw awVar = yG.get(i2);
            if (awVar != null) {
                ar arVar = new ar();
                arVar.metaData.setUserId(awVar.getUid());
                arVar.metaData.setUserName(awVar.yL());
                arVar.metaData.setPortrait(awVar.getPortrait());
                arVar.metaData.getGodUserData().setIsLike(awVar.getIsLike() == 1);
                arVar.metaData.getGodUserData().setIntro(awVar.yM());
                uVar.a(arVar);
            }
        }
        this.dGT.d(this.mPageContext, this.mSkinType);
        aVar.dGU.a(uVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends r.a {
        public com.baidu.tieba.frs.view.d dGU;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.dGU = dVar;
        }
    }
}

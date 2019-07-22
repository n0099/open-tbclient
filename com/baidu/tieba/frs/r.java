package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.az;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class r extends h<ax, a> {
    private com.baidu.tieba.frs.view.d fxd;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fxd = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.fxd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, axVar, aVar);
        this.fxd = aVar.fxe;
        ArrayList<az> adF = axVar.adF();
        if (adF.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = axVar.getTitle();
        for (int i2 = 0; i2 != adF.size(); i2++) {
            az azVar = adF.get(i2);
            if (azVar != null) {
                an anVar = new an();
                anVar.metaData.setUserId(azVar.getUid());
                anVar.metaData.setUserName(azVar.adK());
                anVar.metaData.setPortrait(azVar.getPortrait());
                anVar.metaData.getGodUserData().setIsLike(azVar.getIsLike() == 1);
                anVar.metaData.getGodUserData().setIntro(azVar.adL());
                sVar.a(anVar);
            }
        }
        this.fxd.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.fxe.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d fxe;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.fxe = dVar;
        }
    }
}

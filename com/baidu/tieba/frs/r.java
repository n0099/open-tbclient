package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends h<com.baidu.tbadk.core.data.at, a> {
    private com.baidu.tieba.frs.view.c dEt;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dEt = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.dEt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, atVar, aVar);
        this.dEt = aVar.dEu;
        ArrayList<av> xT = atVar.xT();
        if (xT.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = atVar.getTitle();
        for (int i2 = 0; i2 != xT.size(); i2++) {
            av avVar = xT.get(i2);
            if (avVar != null) {
                ap apVar = new ap();
                apVar.metaData.setUserId(avVar.getUid());
                apVar.metaData.setUserName(avVar.xY());
                apVar.metaData.setPortrait(avVar.getPortrait());
                apVar.metaData.getGodUserData().setIsLike(avVar.getIsLike() == 1);
                apVar.metaData.getGodUserData().setIntro(avVar.xZ());
                sVar.a(apVar);
            }
        }
        this.dEt.d(this.mPageContext, this.mSkinType);
        aVar.dEu.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.frs.view.c dEu;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.dEu = cVar;
        }
    }
}

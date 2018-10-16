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
    private com.baidu.tieba.frs.view.c dDd;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dDd = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.dDd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, atVar, aVar);
        this.dDd = aVar.dDe;
        ArrayList<av> xM = atVar.xM();
        if (xM.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = atVar.getTitle();
        for (int i2 = 0; i2 != xM.size(); i2++) {
            av avVar = xM.get(i2);
            if (avVar != null) {
                ap apVar = new ap();
                apVar.metaData.setUserId(avVar.getUid());
                apVar.metaData.setUserName(avVar.xR());
                apVar.metaData.setPortrait(avVar.getPortrait());
                apVar.metaData.getGodUserData().setIsLike(avVar.getIsLike() == 1);
                apVar.metaData.getGodUserData().setIntro(avVar.xS());
                sVar.a(apVar);
            }
        }
        this.dDd.d(this.mPageContext, this.mSkinType);
        aVar.dDe.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.frs.view.c dDe;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.dDe = cVar;
        }
    }
}

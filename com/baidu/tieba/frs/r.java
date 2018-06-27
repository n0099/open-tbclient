package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aw;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class r extends h<com.baidu.tbadk.core.data.au, a> {
    private com.baidu.tieba.frs.view.c dmp;

    public r(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dmp = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.dmp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.au auVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, auVar, aVar);
        this.dmp = aVar.dmq;
        ArrayList<aw> uO = auVar.uO();
        if (uO.size() <= 0) {
            return null;
        }
        s sVar = new s();
        sVar.showTopDivider = true;
        sVar.mGroupTitle = auVar.getTitle();
        for (int i2 = 0; i2 != uO.size(); i2++) {
            aw awVar = uO.get(i2);
            if (awVar != null) {
                ap apVar = new ap();
                apVar.metaData.setUserId(awVar.getUid());
                apVar.metaData.setUserName(awVar.uT());
                apVar.metaData.setPortrait(awVar.getPortrait());
                apVar.metaData.getGodUserData().setIsLike(awVar.getIsLike() == 1);
                apVar.metaData.getGodUserData().setIntro(awVar.uU());
                sVar.a(apVar);
            }
        }
        this.dmp.d(this.mPageContext, this.mSkinType);
        aVar.dmq.a(sVar);
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        public com.baidu.tieba.frs.view.c dmq;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.dmq = cVar;
        }
    }
}

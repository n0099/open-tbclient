package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class s extends h<ba, a> {
    private com.baidu.tieba.frs.view.d grv;

    public s(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a b(ViewGroup viewGroup) {
        this.grv = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.grv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ba baVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) baVar, (ba) aVar);
        this.grv = aVar.grw;
        ArrayList<bc> aBy = baVar.aBy();
        if (aBy.size() <= 0) {
            return null;
        }
        t tVar = new t();
        tVar.showTopDivider = true;
        tVar.mGroupTitle = baVar.getTitle();
        for (int i2 = 0; i2 != aBy.size(); i2++) {
            bc bcVar = aBy.get(i2);
            if (bcVar != null) {
                ao aoVar = new ao();
                aoVar.metaData.setUserId(bcVar.getUid());
                aoVar.metaData.setUserName(bcVar.aBC());
                aoVar.metaData.setPortrait(bcVar.getPortrait());
                aoVar.metaData.getGodUserData().setIsLike(bcVar.getIsLike() == 1);
                aoVar.metaData.getGodUserData().setIntro(bcVar.aBD());
                tVar.a(aoVar);
            }
        }
        this.grv.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.grw.a(tVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d grw;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.grw = dVar;
        }
    }
}

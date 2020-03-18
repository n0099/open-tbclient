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
public class t extends h<ba, a> {
    private com.baidu.tieba.frs.view.d gss;

    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a b(ViewGroup viewGroup) {
        this.gss = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.gss);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ba baVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) baVar, (ba) aVar);
        this.gss = aVar.gst;
        ArrayList<bc> aBB = baVar.aBB();
        if (aBB.size() <= 0) {
            return null;
        }
        u uVar = new u();
        uVar.showTopDivider = true;
        uVar.mGroupTitle = baVar.getTitle();
        for (int i2 = 0; i2 != aBB.size(); i2++) {
            bc bcVar = aBB.get(i2);
            if (bcVar != null) {
                ap apVar = new ap();
                apVar.metaData.setUserId(bcVar.getUid());
                apVar.metaData.setUserName(bcVar.aBF());
                apVar.metaData.setPortrait(bcVar.getPortrait());
                apVar.metaData.getGodUserData().setIsLike(bcVar.getIsLike() == 1);
                apVar.metaData.getGodUserData().setIntro(bcVar.aBG());
                uVar.a(apVar);
            }
        }
        this.gss.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.gst.a(uVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d gst;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.gst = dVar;
        }
    }
}

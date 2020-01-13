package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class s extends h<ba, a> {
    private com.baidu.tieba.frs.view.d gps;

    public s(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a b(ViewGroup viewGroup) {
        this.gps = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new a(this.gps);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ba baVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) baVar, (ba) aVar);
        this.gps = aVar.gpt;
        ArrayList<bc> azf = baVar.azf();
        if (azf.size() <= 0) {
            return null;
        }
        t tVar = new t();
        tVar.showTopDivider = true;
        tVar.mGroupTitle = baVar.getTitle();
        for (int i2 = 0; i2 != azf.size(); i2++) {
            bc bcVar = azf.get(i2);
            if (bcVar != null) {
                ao aoVar = new ao();
                aoVar.metaData.setUserId(bcVar.getUid());
                aoVar.metaData.setUserName(bcVar.azk());
                aoVar.metaData.setPortrait(bcVar.getPortrait());
                aoVar.metaData.getGodUserData().setIsLike(bcVar.getIsLike() == 1);
                aoVar.metaData.getGodUserData().setIntro(bcVar.azl());
                tVar.a(aoVar);
            }
        }
        this.gps.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.gpt.a(tVar);
        return aVar.getView();
    }

    /* loaded from: classes7.dex */
    public class a extends v.a {
        public com.baidu.tieba.frs.view.d gpt;

        public a(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.gpt = dVar;
        }
    }
}

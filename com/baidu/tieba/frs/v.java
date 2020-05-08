package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class v extends h<ba, a> {
    private com.baidu.tieba.frs.view.c hbK;

    public v(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public a b(ViewGroup viewGroup) {
        this.hbK = new com.baidu.tieba.frs.view.c(this.mPageContext, this.mPageId);
        return new a(this.hbK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ba baVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) baVar, (ba) aVar);
        this.hbK = aVar.hbL;
        ArrayList<bc> aJM = baVar.aJM();
        if (aJM.size() <= 0) {
            return null;
        }
        w wVar = new w();
        wVar.showTopDivider = true;
        wVar.mGroupTitle = baVar.getTitle();
        for (int i2 = 0; i2 != aJM.size(); i2++) {
            bc bcVar = aJM.get(i2);
            if (bcVar != null) {
                at atVar = new at();
                atVar.metaData.setUserId(bcVar.getUid());
                atVar.metaData.setUserName(bcVar.aJQ());
                atVar.metaData.setPortrait(bcVar.getPortrait());
                atVar.metaData.getGodUserData().setIsLike(bcVar.getIsLike() == 1);
                atVar.metaData.getGodUserData().setIntro(bcVar.aJR());
                wVar.a(atVar);
            }
        }
        this.hbK.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.hbL.a(wVar);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.view.c hbL;

        public a(com.baidu.tieba.frs.view.c cVar) {
            super(cVar.getView());
            this.hbL = cVar;
        }
    }
}

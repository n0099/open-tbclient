package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bp;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class y extends k<bn, a> {
    private com.baidu.tieba.frs.view.e iWU;

    public y(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a c(ViewGroup viewGroup) {
        this.iWU = new com.baidu.tieba.frs.view.e(this.mPageContext, this.mPageId);
        return new a(this.iWU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bn bnVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) bnVar, (bn) aVar);
        this.iWU = aVar.iWV;
        ArrayList<bp> bnW = bnVar.bnW();
        if (bnW.size() <= 0) {
            return null;
        }
        z zVar = new z();
        zVar.showTopDivider = true;
        zVar.mGroupTitle = bnVar.getTitle();
        for (int i2 = 0; i2 != bnW.size(); i2++) {
            bp bpVar = bnW.get(i2);
            if (bpVar != null) {
                bb bbVar = new bb();
                bbVar.metaData.setUserId(bpVar.getUid());
                bbVar.metaData.setUserName(bpVar.boa());
                bbVar.metaData.setPortrait(bpVar.getPortrait());
                bbVar.metaData.getGodUserData().setIsLike(bpVar.getIsLike() == 1);
                bbVar.metaData.getGodUserData().setIntro(bpVar.bob());
                zVar.a(bbVar);
            }
        }
        this.iWU.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.iWV.a(zVar);
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        public com.baidu.tieba.frs.view.e iWV;

        public a(com.baidu.tieba.frs.view.e eVar) {
            super(eVar.getView());
            this.iWV = eVar;
        }
    }
}

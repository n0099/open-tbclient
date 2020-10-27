package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bn;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class z extends k<bl, a> {
    private com.baidu.tieba.frs.view.e iFr;

    public z(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a c(ViewGroup viewGroup) {
        this.iFr = new com.baidu.tieba.frs.view.e(this.mPageContext, this.mPageId);
        return new a(this.iFr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) blVar, (bl) aVar);
        this.iFr = aVar.iFs;
        ArrayList<bn> bjh = blVar.bjh();
        if (bjh.size() <= 0) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.showTopDivider = true;
        aaVar.mGroupTitle = blVar.getTitle();
        for (int i2 = 0; i2 != bjh.size(); i2++) {
            bn bnVar = bjh.get(i2);
            if (bnVar != null) {
                bb bbVar = new bb();
                bbVar.metaData.setUserId(bnVar.getUid());
                bbVar.metaData.setUserName(bnVar.bjl());
                bbVar.metaData.setPortrait(bnVar.getPortrait());
                bbVar.metaData.getGodUserData().setIsLike(bnVar.getIsLike() == 1);
                bbVar.metaData.getGodUserData().setIntro(bnVar.bjm());
                aaVar.a(bbVar);
            }
        }
        this.iFr.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.iFs.a(aaVar);
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        public com.baidu.tieba.frs.view.e iFs;

        public a(com.baidu.tieba.frs.view.e eVar) {
            super(eVar.getView());
            this.iFs = eVar;
        }
    }
}

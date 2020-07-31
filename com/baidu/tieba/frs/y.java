package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bm;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class y extends j<bk, a> {
    private com.baidu.tieba.frs.view.e hJu;

    public y(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        this.hJu = new com.baidu.tieba.frs.view.e(this.mPageContext, this.mPageId);
        return new a(this.hJu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) aVar);
        this.hJu = aVar.hJv;
        ArrayList<bm> aVs = bkVar.aVs();
        if (aVs.size() <= 0) {
            return null;
        }
        z zVar = new z();
        zVar.showTopDivider = true;
        zVar.mGroupTitle = bkVar.getTitle();
        for (int i2 = 0; i2 != aVs.size(); i2++) {
            bm bmVar = aVs.get(i2);
            if (bmVar != null) {
                az azVar = new az();
                azVar.metaData.setUserId(bmVar.getUid());
                azVar.metaData.setUserName(bmVar.aVw());
                azVar.metaData.setPortrait(bmVar.getPortrait());
                azVar.metaData.getGodUserData().setIsLike(bmVar.getIsLike() == 1);
                azVar.metaData.getGodUserData().setIntro(bmVar.aVx());
                zVar.a(azVar);
            }
        }
        this.hJu.onChangeSkinType(this.mPageContext, this.mSkinType);
        aVar.hJv.a(zVar);
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public class a extends ad.a {
        public com.baidu.tieba.frs.view.e hJv;

        public a(com.baidu.tieba.frs.view.e eVar) {
            super(eVar.getView());
            this.hJv = eVar;
        }
    }
}

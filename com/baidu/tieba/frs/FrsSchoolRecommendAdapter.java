package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bs;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsSchoolRecommendAdapter extends k<bq, FrsSchoolRecommendViewHolder> {
    private com.baidu.tieba.frs.view.d jkg;

    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public FrsSchoolRecommendViewHolder e(ViewGroup viewGroup) {
        this.jkg = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new FrsSchoolRecommendViewHolder(this.jkg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bq bqVar, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bqVar, (bq) frsSchoolRecommendViewHolder);
        this.jkg = frsSchoolRecommendViewHolder.jkh;
        ArrayList<bs> bmX = bqVar.bmX();
        if (bmX.size() <= 0) {
            return null;
        }
        x xVar = new x();
        xVar.showTopDivider = true;
        xVar.mGroupTitle = bqVar.getTitle();
        for (int i2 = 0; i2 != bmX.size(); i2++) {
            bs bsVar = bmX.get(i2);
            if (bsVar != null) {
                ay ayVar = new ay();
                ayVar.metaData.setUserId(bsVar.getUid());
                ayVar.metaData.setUserName(bsVar.bnb());
                ayVar.metaData.setPortrait(bsVar.getPortrait());
                ayVar.metaData.getGodUserData().setIsLike(bsVar.getIsLike() == 1);
                ayVar.metaData.getGodUserData().setIntro(bsVar.bnc());
                xVar.a(ayVar);
            }
        }
        this.jkg.onChangeSkinType(this.mPageContext, this.mSkinType);
        frsSchoolRecommendViewHolder.jkh.a(xVar);
        return frsSchoolRecommendViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.frs.view.d jkh;

        public FrsSchoolRecommendViewHolder(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.jkh = dVar;
        }
    }
}

package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bq;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsSchoolRecommendAdapter extends k<bo, FrsSchoolRecommendViewHolder> {
    private com.baidu.tieba.frs.view.d jez;

    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public FrsSchoolRecommendViewHolder e(ViewGroup viewGroup) {
        this.jez = new com.baidu.tieba.frs.view.d(this.mPageContext, this.mPageId);
        return new FrsSchoolRecommendViewHolder(this.jez);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bo boVar, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) boVar, (bo) frsSchoolRecommendViewHolder);
        this.jez = frsSchoolRecommendViewHolder.jeA;
        ArrayList<bq> bmE = boVar.bmE();
        if (bmE.size() <= 0) {
            return null;
        }
        x xVar = new x();
        xVar.showTopDivider = true;
        xVar.mGroupTitle = boVar.getTitle();
        for (int i2 = 0; i2 != bmE.size(); i2++) {
            bq bqVar = bmE.get(i2);
            if (bqVar != null) {
                ay ayVar = new ay();
                ayVar.metaData.setUserId(bqVar.getUid());
                ayVar.metaData.setUserName(bqVar.bmI());
                ayVar.metaData.setPortrait(bqVar.getPortrait());
                ayVar.metaData.getGodUserData().setIsLike(bqVar.getIsLike() == 1);
                ayVar.metaData.getGodUserData().setIntro(bqVar.bmJ());
                xVar.a(ayVar);
            }
        }
        this.jez.onChangeSkinType(this.mPageContext, this.mSkinType);
        frsSchoolRecommendViewHolder.jeA.a(xVar);
        return frsSchoolRecommendViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.frs.view.d jeA;

        public FrsSchoolRecommendViewHolder(com.baidu.tieba.frs.view.d dVar) {
            super(dVar.getView());
            this.jeA = dVar;
        }
    }
}

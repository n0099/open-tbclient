package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.f;
import com.baidu.tieba.ala.alasquare.widget.f;
/* loaded from: classes10.dex */
public class AlaSquareRecordAdapter extends a<f, SquareRecordViewHolder> {
    private int gAa;
    private boolean gAi;
    private boolean gAl;
    private boolean gAm;
    private f.a gAn;
    private TbPageContext<?> mPageContext;
    private int mTabIndex;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public SquareRecordViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.widget.f fVar = new com.baidu.tieba.ala.alasquare.widget.f(this.mPageContext);
        fVar.mP(this.gAl);
        fVar.mQ(this.gAm);
        fVar.mO(this.gAi);
        SquareRecordViewHolder squareRecordViewHolder = new SquareRecordViewHolder(fVar);
        fVar.a(this.gAn);
        return squareRecordViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.a.f fVar, SquareRecordViewHolder squareRecordViewHolder) {
        com.baidu.tieba.ala.alasquare.widget.f fVar2;
        if (squareRecordViewHolder == null || (fVar2 = squareRecordViewHolder.gAo) == null || fVar2.getView() == null) {
            return null;
        }
        if (fVar != null) {
            fVar.locate = i + 1;
        }
        fVar2.a(fVar);
        com.baidu.tieba.ala.alasquare.b.a.bVm().e(fVar.aA(bUl(), false));
        a(fVar);
        if (i == this.gAa) {
            fVar2.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return fVar2.getView();
    }

    private String bUl() {
        if (this.mTabIndex == 2) {
            return "c12127";
        }
        if (this.mTabIndex == 1) {
            return "c12479";
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public class SquareRecordViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.alasquare.widget.f gAo;

        public SquareRecordViewHolder(com.baidu.tieba.ala.alasquare.widget.f fVar) {
            super(fVar.getView());
            this.gAo = fVar;
        }
    }

    private void a(com.baidu.tieba.ala.alasquare.a.f fVar) {
        if (fVar != null && fVar.gAx != null && TextUtils.equals("c12479", bUl())) {
            aq aqVar = new aq("c12461");
            if (StringUtils.isNull(fVar.gAx.mRecomSource)) {
                aqVar.dX("obj_source", "0");
            } else {
                aqVar.dX("obj_source", "1");
            }
            if (StringUtils.isNull(fVar.gAx.mRecomAbTag)) {
                aqVar.dX("obj_locate", "0");
            } else {
                aqVar.dX("obj_locate", "1");
            }
            aqVar.dX("obj_type", "1");
            com.baidu.tieba.ala.alasquare.b.a.bVm().e(aqVar);
        }
    }
}

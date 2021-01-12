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
/* loaded from: classes9.dex */
public class AlaSquareRecordAdapter extends a<f, SquareRecordViewHolder> {
    private boolean gvB;
    private boolean gvE;
    private boolean gvF;
    private f.a gvG;
    private int gvt;
    private TbPageContext<?> mPageContext;
    private int mTabIndex;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public SquareRecordViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.widget.f fVar = new com.baidu.tieba.ala.alasquare.widget.f(this.mPageContext);
        fVar.mL(this.gvE);
        fVar.mM(this.gvF);
        fVar.mK(this.gvB);
        SquareRecordViewHolder squareRecordViewHolder = new SquareRecordViewHolder(fVar);
        fVar.a(this.gvG);
        return squareRecordViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.a.f fVar, SquareRecordViewHolder squareRecordViewHolder) {
        com.baidu.tieba.ala.alasquare.widget.f fVar2;
        if (squareRecordViewHolder == null || (fVar2 = squareRecordViewHolder.gvH) == null || fVar2.getView() == null) {
            return null;
        }
        if (fVar != null) {
            fVar.locate = i + 1;
        }
        fVar2.a(fVar);
        com.baidu.tieba.ala.alasquare.b.a.bRu().e(fVar.aA(bQt(), false));
        a(fVar);
        if (i == this.gvt) {
            fVar2.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return fVar2.getView();
    }

    private String bQt() {
        if (this.mTabIndex == 2) {
            return "c12127";
        }
        if (this.mTabIndex == 1) {
            return "c12479";
        }
        return null;
    }

    /* loaded from: classes9.dex */
    public class SquareRecordViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.alasquare.widget.f gvH;

        public SquareRecordViewHolder(com.baidu.tieba.ala.alasquare.widget.f fVar) {
            super(fVar.getView());
            this.gvH = fVar;
        }
    }

    private void a(com.baidu.tieba.ala.alasquare.a.f fVar) {
        if (fVar != null && fVar.gvQ != null && TextUtils.equals("c12479", bQt())) {
            aq aqVar = new aq("c12461");
            if (StringUtils.isNull(fVar.gvQ.mRecomSource)) {
                aqVar.dW("obj_source", "0");
            } else {
                aqVar.dW("obj_source", "1");
            }
            if (StringUtils.isNull(fVar.gvQ.mRecomAbTag)) {
                aqVar.dW("obj_locate", "0");
            } else {
                aqVar.dW("obj_locate", "1");
            }
            aqVar.dW("obj_type", "1");
            com.baidu.tieba.ala.alasquare.b.a.bRu().e(aqVar);
        }
    }
}

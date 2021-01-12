package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.widget.d;
/* loaded from: classes9.dex */
public class AlaSquareLiveAdapter extends a<e, SquareLiveViewHolder> {
    private boolean gvA;
    private boolean gvB;
    private int gvt;
    d gvu;
    private boolean gvz;
    private TbPageContext<?> mPageContext;
    private int mTabIndex;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public SquareLiveViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.widget.e eVar;
        if (this.mTabIndex == 1) {
            eVar = new com.baidu.tieba.ala.alasquare.widget.e(this.mPageContext, com.baidu.tieba.ala.alasquare.widget.a.bRX());
        } else {
            eVar = new com.baidu.tieba.ala.alasquare.widget.e(this.mPageContext);
        }
        eVar.mL(this.gvz);
        eVar.mM(this.gvA);
        eVar.mK(this.gvB);
        eVar.setFromPage(bQs());
        eVar.a(this.gvu);
        return new SquareLiveViewHolder(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, SquareLiveViewHolder squareLiveViewHolder) {
        com.baidu.tieba.ala.alasquare.widget.e eVar2;
        if (squareLiveViewHolder == null || (eVar2 = squareLiveViewHolder.gvC) == null || eVar2.getView() == null) {
            return null;
        }
        if (eVar != null) {
            eVar.locate = i + 1;
        }
        eVar2.a(eVar);
        com.baidu.tieba.ala.alasquare.b.a.bRu().e(eVar.aA(bQt(), false));
        if (i == this.gvt) {
            eVar2.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return squareLiveViewHolder.getView();
    }

    private String bQs() {
        if (this.mTabIndex == 0) {
            return "square_live";
        }
        if (this.mTabIndex == 2) {
            return "square_dynamic";
        }
        if (this.mTabIndex == 1) {
            return "square_recommend";
        }
        return null;
    }

    private String bQt() {
        if (this.mTabIndex == 0) {
            return "c12117";
        }
        if (this.mTabIndex == 2) {
            return "c12129";
        }
        if (this.mTabIndex == 1) {
            return "c12119";
        }
        return null;
    }

    /* loaded from: classes9.dex */
    public class SquareLiveViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.alasquare.widget.e gvC;

        public SquareLiveViewHolder(com.baidu.tieba.ala.alasquare.widget.e eVar) {
            super(eVar.getView());
            this.gvC = eVar;
        }
    }
}

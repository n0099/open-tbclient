package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.b;
import com.baidu.tieba.ala.alasquare.widget.c;
import com.baidu.tieba.ala.alasquare.widget.d;
/* loaded from: classes9.dex */
public class AlaSquareActiveAdapter extends a<b, SquareActiveViewHolder> {
    private int gvt;
    d gvu;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public SquareActiveViewHolder e(ViewGroup viewGroup) {
        c cVar = new c(this.mPageContext);
        cVar.a(this.gvu);
        return new SquareActiveViewHolder(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, SquareActiveViewHolder squareActiveViewHolder) {
        c cVar;
        if (squareActiveViewHolder == null || (cVar = squareActiveViewHolder.gvv) == null || cVar.getView() == null) {
            return null;
        }
        cVar.a(bVar);
        com.baidu.tieba.ala.alasquare.b.a.bRu().e(bVar.aA("c12249", false));
        if (i == this.gvt) {
            cVar.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return squareActiveViewHolder.getView();
    }

    /* loaded from: classes9.dex */
    public class SquareActiveViewHolder extends TypeAdapter.ViewHolder {
        public c gvv;

        public SquareActiveViewHolder(c cVar) {
            super(cVar.getView());
            this.gvv = cVar;
        }
    }
}

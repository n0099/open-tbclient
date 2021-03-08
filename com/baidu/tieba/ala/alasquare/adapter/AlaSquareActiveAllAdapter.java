package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.widget.b;
import com.baidu.tieba.ala.alasquare.widget.d;
/* loaded from: classes9.dex */
public class AlaSquareActiveAllAdapter extends a<c, SquareActiveAllViewHolder> {
    private int gAa;
    d gAb;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public SquareActiveAllViewHolder e(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext);
        bVar.a(this.gAb);
        return new SquareActiveAllViewHolder(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, SquareActiveAllViewHolder squareActiveAllViewHolder) {
        b bVar;
        if (squareActiveAllViewHolder == null || (bVar = squareActiveAllViewHolder.gAe) == null || bVar.getView() == null) {
            return null;
        }
        bVar.a(cVar);
        if (i == this.gAa) {
            bVar.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return squareActiveAllViewHolder.getView();
    }

    /* loaded from: classes9.dex */
    public class SquareActiveAllViewHolder extends TypeAdapter.ViewHolder {
        public b gAe;

        public SquareActiveAllViewHolder(b bVar) {
            super(bVar.getView());
            this.gAe = bVar;
        }
    }
}

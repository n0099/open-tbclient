package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
/* loaded from: classes9.dex */
public class ConcernTabRecommendTitleView extends com.baidu.tieba.card.b<g> {
    private ViewHolder gFx;

    public ConcernTabRecommendTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFx = new ViewHolder(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gFx.textView, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_recommend_title;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(g gVar) {
        if (this.gFx != null) {
            if (gVar.gEb) {
                this.gFx.devider.setVisibility(0);
            } else {
                this.gFx.devider.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public View devider;
        public View elg;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.elg = view;
            this.textView = (TextView) this.elg.findViewById(R.id.title);
            this.devider = this.elg.findViewById(R.id.divider);
        }
    }
}

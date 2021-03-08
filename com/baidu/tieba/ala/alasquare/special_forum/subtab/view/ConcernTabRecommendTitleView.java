package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
/* loaded from: classes9.dex */
public class ConcernTabRecommendTitleView extends com.baidu.tieba.card.b<g> {
    private ViewHolder gKe;

    public ConcernTabRecommendTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gKe = new ViewHolder(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gKe.textView, R.color.CAM_X0109);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_recommend_title;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(g gVar) {
        if (this.gKe != null) {
            if (gVar.gII) {
                this.gKe.devider.setVisibility(0);
            } else {
                this.gKe.devider.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public View devider;
        public View eoR;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.eoR = view;
            this.textView = (TextView) this.eoR.findViewById(R.id.title);
            this.devider = this.eoR.findViewById(R.id.divider);
        }
    }
}

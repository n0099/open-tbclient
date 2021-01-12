package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes9.dex */
public class AlaGameFrsGameLiveDoubleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private a gTC;
    private a gTD;

    public AlaGameFrsGameLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gTC.onChangeSkinType(tbPageContext, i);
        this.gTD.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gTC.a(aVar.gUu);
            this.gTD.a(aVar.gUv);
        }
    }

    public void c(g gVar) {
        this.gTC.d(gVar);
        this.gTD.d(gVar);
    }

    public void setLabelName(String str) {
        this.gTC.setLabelName(str);
        this.gTD.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gTC = new a(getTbPageContext());
        this.gTD = new a(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gTC.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gTD.getView());
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsGameLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsGameLiveDoubleView gTE;

        public AlaGameFrsGameLiveDoubleViewHolder(AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView) {
            super(alaGameFrsGameLiveDoubleView.getView());
            this.gTE = alaGameFrsGameLiveDoubleView;
        }
    }
}

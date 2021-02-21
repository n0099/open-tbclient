package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
/* loaded from: classes10.dex */
public class AlaGameFrsGameLiveDoubleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private a gWA;
    private a gWB;

    public AlaGameFrsGameLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gWA.onChangeSkinType(tbPageContext, i);
        this.gWB.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gWA.a(aVar.gXs);
            this.gWB.a(aVar.gXt);
        }
    }

    public void c(h hVar) {
        this.gWA.d(hVar);
        this.gWB.d(hVar);
    }

    public void setLabelName(String str) {
        this.gWA.setLabelName(str);
        this.gWB.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gWA = new a(getTbPageContext());
        this.gWB = new a(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gWA.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gWB.getView());
    }

    /* loaded from: classes10.dex */
    public static class AlaGameFrsGameLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsGameLiveDoubleView gWC;

        public AlaGameFrsGameLiveDoubleViewHolder(AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView) {
            super(alaGameFrsGameLiveDoubleView.getView());
            this.gWC = alaGameFrsGameLiveDoubleView;
        }
    }
}

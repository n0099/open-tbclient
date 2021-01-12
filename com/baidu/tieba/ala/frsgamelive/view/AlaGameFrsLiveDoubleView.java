package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveDoubleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private b gTO;
    private b gTP;

    public AlaGameFrsLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gTO.onChangeSkinType(tbPageContext, i);
        this.gTP.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gTO.a(aVar.gUu);
            this.gTP.a(aVar.gUv);
        }
    }

    public void c(g gVar) {
        this.gTO.d(gVar);
        this.gTP.d(gVar);
    }

    public void setLabelName(String str) {
        this.gTO.setLabelName(str);
        this.gTP.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gTO = new b(getTbPageContext());
        this.gTP = new b(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gTO.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gTP.getView());
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveDoubleView gTQ;

        public AlaGameFrsLiveDoubleViewHolder(AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView) {
            super(alaGameFrsLiveDoubleView.getView());
            this.gTQ = alaGameFrsLiveDoubleView;
        }
    }
}

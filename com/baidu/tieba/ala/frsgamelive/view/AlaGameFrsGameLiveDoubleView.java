package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes10.dex */
public class AlaGameFrsGameLiveDoubleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private a gYi;
    private a gYj;

    public AlaGameFrsGameLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gYi.onChangeSkinType(tbPageContext, i);
        this.gYj.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gYi.a(aVar.gZa);
            this.gYj.a(aVar.gZb);
        }
    }

    public void c(g gVar) {
        this.gYi.d(gVar);
        this.gYj.d(gVar);
    }

    public void setLabelName(String str) {
        this.gYi.setLabelName(str);
        this.gYj.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gYi = new a(getTbPageContext());
        this.gYj = new a(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gYi.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gYj.getView());
    }

    /* loaded from: classes10.dex */
    public static class AlaGameFrsGameLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsGameLiveDoubleView gYk;

        public AlaGameFrsGameLiveDoubleViewHolder(AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView) {
            super(alaGameFrsGameLiveDoubleView.getView());
            this.gYk = alaGameFrsGameLiveDoubleView;
        }
    }
}

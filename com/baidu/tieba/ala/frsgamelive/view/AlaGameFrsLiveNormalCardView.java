package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveNormalCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private b gTU;
    private TbPageContext mPageContext;

    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.gTU = new b(this.mPageContext);
        ((ViewGroup) getView()).addView(this.gTU.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gTU != null) {
            this.gTU.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(g gVar) {
        if (this.gTU != null) {
            this.gTU.d(gVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eHK != null && this.gTU != null) {
            this.gTU.a(cVar.eHK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveNormalCardView gTV;

        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.getView());
            this.gTV = alaGameFrsLiveNormalCardView;
        }
    }
}

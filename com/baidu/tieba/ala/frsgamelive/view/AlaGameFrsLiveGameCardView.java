package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes10.dex */
public class AlaGameFrsLiveGameCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gYx;
    private a gYy;

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gYx = tbPageContext;
        initView();
    }

    private void initView() {
        this.gYy = new a(this.gYx);
        ((ViewGroup) getView()).addView(this.gYy.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gYy != null) {
            this.gYy.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eMv != null && this.gYy != null) {
            this.gYy.a(cVar.eMv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(g gVar) {
        if (this.gYy != null) {
            this.gYy.d(gVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveGameCardView gYz;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.getView());
            this.gYz = alaGameFrsLiveGameCardView;
        }
    }
}

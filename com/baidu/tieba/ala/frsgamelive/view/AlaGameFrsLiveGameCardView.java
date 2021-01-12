package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.g;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveGameCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gTR;
    private a gTS;

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTR = tbPageContext;
        initView();
    }

    private void initView() {
        this.gTS = new a(this.gTR);
        ((ViewGroup) getView()).addView(this.gTS.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gTS != null) {
            this.gTS.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eHK != null && this.gTS != null) {
            this.gTS.a(cVar.eHK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(g gVar) {
        if (this.gTS != null) {
            this.gTS.d(gVar);
        }
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveGameCardView gTT;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.getView());
            this.gTT = alaGameFrsLiveGameCardView;
        }
    }
}

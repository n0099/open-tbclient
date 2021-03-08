package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveGameCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gYy;
    private a gYz;

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gYy = tbPageContext;
        initView();
    }

    private void initView() {
        this.gYz = new a(this.gYy);
        ((ViewGroup) getView()).addView(this.gYz.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gYz != null) {
            this.gYz.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eLr != null && this.gYz != null) {
            this.gYz.a(cVar.eLr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(h hVar) {
        if (this.gYz != null) {
            this.gYz.d(hVar);
        }
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveGameCardView gYA;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.getView());
            this.gYA = alaGameFrsLiveGameCardView;
        }
    }
}

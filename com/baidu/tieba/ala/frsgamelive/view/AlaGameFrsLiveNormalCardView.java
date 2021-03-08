package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveNormalCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private b gYB;
    private TbPageContext mPageContext;

    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.gYB = new b(this.mPageContext);
        ((ViewGroup) getView()).addView(this.gYB.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gYB != null) {
            this.gYB.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(h hVar) {
        if (this.gYB != null) {
            this.gYB.d(hVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eLr != null && this.gYB != null) {
            this.gYB.a(cVar.eLr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveNormalCardView gYC;

        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.getView());
            this.gYC = alaGameFrsLiveNormalCardView;
        }
    }
}

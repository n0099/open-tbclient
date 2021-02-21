package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
/* loaded from: classes10.dex */
public class AlaGameFrsLiveGameCardView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gWP;
    private a gWQ;

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gWP = tbPageContext;
        initView();
    }

    private void initView() {
        this.gWQ = new a(this.gWP);
        ((ViewGroup) getView()).addView(this.gWQ.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gWQ != null) {
            this.gWQ.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eJQ != null && this.gWQ != null) {
            this.gWQ.a(cVar.eJQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(h hVar) {
        if (this.gWQ != null) {
            this.gWQ.d(hVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveGameCardView gWR;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.getView());
            this.gWR = alaGameFrsLiveGameCardView;
        }
    }
}

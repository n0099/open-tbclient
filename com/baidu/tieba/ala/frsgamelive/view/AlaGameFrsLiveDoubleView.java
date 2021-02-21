package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.h;
/* loaded from: classes10.dex */
public class AlaGameFrsLiveDoubleView extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private b gWM;
    private b gWN;

    public AlaGameFrsLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gWM.onChangeSkinType(tbPageContext, i);
        this.gWN.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gWM.a(aVar.gXs);
            this.gWN.a(aVar.gXt);
        }
    }

    public void c(h hVar) {
        this.gWM.d(hVar);
        this.gWN.d(hVar);
    }

    public void setLabelName(String str) {
        this.gWM.setLabelName(str);
        this.gWN.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gWM = new b(getTbPageContext());
        this.gWN = new b(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gWM.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gWN.getView());
    }

    /* loaded from: classes10.dex */
    public static class AlaGameFrsLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public AlaGameFrsLiveDoubleView gWO;

        public AlaGameFrsLiveDoubleViewHolder(AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView) {
            super(alaGameFrsLiveDoubleView.getView());
            this.gWO = alaGameFrsLiveDoubleView;
        }
    }
}

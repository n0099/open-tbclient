package com.baidu.tieba.ala.gamelist.view;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.card.b;
/* loaded from: classes10.dex */
public class AlaSubListGameLiveDoubleView extends b<com.baidu.tieba.ala.gamelist.b.a> {
    private a gXC;
    private a gXD;

    /* loaded from: classes10.dex */
    public static class AlaSubListDoubleLiveViewHolder extends TypeAdapter.ViewHolder {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gXC.onChangeSkinType(tbPageContext, i);
        this.gXD.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gXC.a(aVar.gXs);
            this.gXD.a(aVar.gXt);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

package com.baidu.tieba.ala.gamelist.view;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.card.b;
/* loaded from: classes9.dex */
public class AlaSubListGameLiveDoubleView extends b<com.baidu.tieba.ala.gamelist.b.a> {
    private a gUE;
    private a gUF;

    /* loaded from: classes9.dex */
    public static class AlaSubListDoubleLiveViewHolder extends TypeAdapter.ViewHolder {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gUE.onChangeSkinType(tbPageContext, i);
        this.gUF.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gUE.a(aVar.gUu);
            this.gUF.a(aVar.gUv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

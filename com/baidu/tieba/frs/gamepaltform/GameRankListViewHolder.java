package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GameRankListViewHolder extends TypeAdapter.ViewHolder {
    public GameRankHorizontalLayout jyT;
    public TextView jyU;

    public GameRankListViewHolder(View view) {
        super(view);
        this.jyT = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.jyU = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

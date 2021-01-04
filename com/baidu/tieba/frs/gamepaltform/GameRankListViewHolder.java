package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GameRankListViewHolder extends TypeAdapter.ViewHolder {
    public GameRankHorizontalLayout jxT;
    public TextView jxU;

    public GameRankListViewHolder(View view) {
        super(view);
        this.jxT = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.jxU = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

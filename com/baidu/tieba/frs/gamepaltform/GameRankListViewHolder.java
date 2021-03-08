package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GameRankListViewHolder extends TypeAdapter.ViewHolder {
    public GameRankHorizontalLayout jAQ;
    public TextView jAR;

    public GameRankListViewHolder(View view) {
        super(view);
        this.jAQ = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.jAR = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

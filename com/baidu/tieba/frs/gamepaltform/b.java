package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends v.a {
    public GameRankHorizontalLayout gBk;
    public TextView gBl;

    public b(View view) {
        super(view);
        this.gBk = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.gBl = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends aa.a {
    public GameRankHorizontalLayout hBx;
    public TextView hBy;

    public b(View view) {
        super(view);
        this.hBx = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.hBy = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends y.a {
    public GameRankHorizontalLayout hlW;
    public TextView hlX;

    public b(View view) {
        super(view);
        this.hlW = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.hlX = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

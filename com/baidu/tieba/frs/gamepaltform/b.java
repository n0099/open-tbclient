package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends y.a {
    public GameRankHorizontalLayout hlQ;
    public TextView hlR;

    public b(View view) {
        super(view);
        this.hlQ = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.hlR = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

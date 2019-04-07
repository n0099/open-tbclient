package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends v.a {
    public GameRankHorizontalLayout flh;
    public TextView fli;

    public b(View view) {
        super(view);
        this.flh = (GameRankHorizontalLayout) view.findViewById(d.g.game_rank_list_viewpager);
        this.fli = (TextView) view.findViewById(d.g.close_game_rank_btn);
    }
}

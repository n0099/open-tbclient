package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends q.a {
    public GameRankHorizontalLayout dXm;
    public TextView dXn;

    public b(View view) {
        super(view);
        this.dXm = (GameRankHorizontalLayout) view.findViewById(e.g.game_rank_list_viewpager);
        this.dXn = (TextView) view.findViewById(e.g.close_game_rank_btn);
    }
}

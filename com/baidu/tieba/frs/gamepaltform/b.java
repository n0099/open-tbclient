package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public GameRankHorizontalLayout dvv;
    public TextView dvw;

    public b(View view) {
        super(view);
        this.dvv = (GameRankHorizontalLayout) view.findViewById(d.g.game_rank_list_viewpager);
        this.dvw = (TextView) view.findViewById(d.g.close_game_rank_btn);
    }
}

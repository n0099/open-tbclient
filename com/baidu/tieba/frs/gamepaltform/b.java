package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public GameRankHorizontalLayout dyi;
    public TextView dyj;

    public b(View view) {
        super(view);
        this.dyi = (GameRankHorizontalLayout) view.findViewById(d.g.game_rank_list_viewpager);
        this.dyj = (TextView) view.findViewById(d.g.close_game_rank_btn);
    }
}

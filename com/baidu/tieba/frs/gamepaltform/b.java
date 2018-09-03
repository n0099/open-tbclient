package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends q.a {
    public GameRankHorizontalLayout dyf;
    public TextView dyg;

    public b(View view) {
        super(view);
        this.dyf = (GameRankHorizontalLayout) view.findViewById(f.g.game_rank_list_viewpager);
        this.dyg = (TextView) view.findViewById(f.g.close_game_rank_btn);
    }
}

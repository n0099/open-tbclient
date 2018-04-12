package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public GameRankHorizontalLayout dhU;
    public TextView dhV;

    public b(View view2) {
        super(view2);
        this.dhU = (GameRankHorizontalLayout) view2.findViewById(d.g.game_rank_list_viewpager);
        this.dhV = (TextView) view2.findViewById(d.g.close_game_rank_btn);
    }
}

package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends r.a {
    public GameRankHorizontalLayout dPw;
    public TextView dPx;

    public b(View view) {
        super(view);
        this.dPw = (GameRankHorizontalLayout) view.findViewById(d.g.game_rank_list_viewpager);
        this.dPx = (TextView) view.findViewById(d.g.close_game_rank_btn);
    }
}

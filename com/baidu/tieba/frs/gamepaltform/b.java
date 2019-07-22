package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends v.a {
    public GameRankHorizontalLayout fGB;
    public TextView fGC;

    public b(View view) {
        super(view);
        this.fGB = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.fGC = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

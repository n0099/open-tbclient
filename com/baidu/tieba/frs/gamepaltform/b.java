package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends v.a {
    public GameRankHorizontalLayout fHF;
    public TextView fHG;

    public b(View view) {
        super(view);
        this.fHF = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.fHG = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

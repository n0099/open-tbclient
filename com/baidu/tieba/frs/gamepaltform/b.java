package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends af.a {
    public GameRankHorizontalLayout iiN;
    public TextView iiO;

    public b(View view) {
        super(view);
        this.iiN = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.iiO = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

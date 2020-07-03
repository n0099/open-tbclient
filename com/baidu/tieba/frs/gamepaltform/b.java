package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends ad.a {
    public GameRankHorizontalLayout hOF;
    public TextView hOG;

    public b(View view) {
        super(view);
        this.hOF = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.hOG = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

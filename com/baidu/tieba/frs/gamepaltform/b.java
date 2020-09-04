package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends af.a {
    public GameRankHorizontalLayout iiT;
    public TextView iiU;

    public b(View view) {
        super(view);
        this.iiT = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.iiU = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

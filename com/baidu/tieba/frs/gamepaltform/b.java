package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b extends af.a {
    public GameRankHorizontalLayout iXT;
    public TextView iXU;

    public b(View view) {
        super(view);
        this.iXT = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.iXU = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

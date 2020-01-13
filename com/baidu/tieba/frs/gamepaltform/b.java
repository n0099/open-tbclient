package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends v.a {
    public GameRankHorizontalLayout gzi;
    public TextView gzj;

    public b(View view) {
        super(view);
        this.gzi = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.gzj = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

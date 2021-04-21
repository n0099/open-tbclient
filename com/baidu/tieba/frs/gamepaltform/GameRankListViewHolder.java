package com.baidu.tieba.frs.gamepaltform;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class GameRankListViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GameRankHorizontalLayout f16035a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16036b;

    public GameRankListViewHolder(View view) {
        super(view);
        this.f16035a = (GameRankHorizontalLayout) view.findViewById(R.id.game_rank_list_viewpager);
        this.f16036b = (TextView) view.findViewById(R.id.close_game_rank_btn);
    }
}

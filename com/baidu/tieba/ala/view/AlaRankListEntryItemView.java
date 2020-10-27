package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.t.b {
    private TextView hFy;
    private TextView hFz;

    public AlaRankListEntryItemView(Context context) {
        super(context);
        initView();
    }

    public AlaRankListEntryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaRankListEntryItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_entry_item_layout, this);
        this.hFy = (TextView) findViewById(a.g.ala_rank_list_type);
        this.hFz = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.hFy.setText(str);
    }

    public void setRankListLevel(String str) {
        this.hFz.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.hFz.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.t.b
    public TextView getRankNameView() {
        return this.hFy;
    }

    @Override // com.baidu.live.t.b
    public TextView getRankLevelView() {
        return this.hFz;
    }

    @Override // com.baidu.live.t.b
    public View getRankItemRootView() {
        return this;
    }
}

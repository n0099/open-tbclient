package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.y.b {
    private TextView hVW;
    private TextView hVX;

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
        LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_entry_item_layout, this);
        this.hVW = (TextView) findViewById(a.f.ala_rank_list_type);
        this.hVX = (TextView) findViewById(a.f.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.hVW.setText(str);
    }

    public void setRankListLevel(String str) {
        this.hVX.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.hVX.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.y.b
    public TextView getRankNameView() {
        return this.hVW;
    }

    @Override // com.baidu.live.y.b
    public TextView getRankLevelView() {
        return this.hVX;
    }

    @Override // com.baidu.live.y.b
    public View getRankItemRootView() {
        return this;
    }
}

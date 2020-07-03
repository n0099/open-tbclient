package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.q.b {
    private TextView gHK;
    private TextView gHL;

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
        this.gHK = (TextView) findViewById(a.g.ala_rank_list_type);
        this.gHL = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.gHK.setText(str);
    }

    public void setRankListLevel(String str) {
        this.gHL.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.gHL.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.q.b
    public TextView getRankNameView() {
        return this.gHK;
    }

    @Override // com.baidu.live.q.b
    public TextView getRankLevelView() {
        return this.gHL;
    }

    @Override // com.baidu.live.q.b
    public View getRankItemRootView() {
        return this;
    }
}

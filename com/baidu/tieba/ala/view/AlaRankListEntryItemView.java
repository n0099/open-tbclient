package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.q.b {
    private TextView gNq;
    private TextView gNr;

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
        this.gNq = (TextView) findViewById(a.g.ala_rank_list_type);
        this.gNr = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.gNq.setText(str);
    }

    public void setRankListLevel(String str) {
        this.gNr.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.gNr.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.q.b
    public TextView getRankNameView() {
        return this.gNq;
    }

    @Override // com.baidu.live.q.b
    public TextView getRankLevelView() {
        return this.gNr;
    }

    @Override // com.baidu.live.q.b
    public View getRankItemRootView() {
        return this;
    }
}

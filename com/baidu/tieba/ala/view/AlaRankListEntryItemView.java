package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.l.b {
    private TextView fuF;
    private TextView fuG;

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

    public void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_entry_item_layout, this);
        this.fuF = (TextView) findViewById(a.g.ala_rank_list_type);
        this.fuG = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.fuF.setText(str);
    }

    public void setRankListLevel(String str) {
        this.fuG.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.fuG.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.l.b
    public TextView getRankNameView() {
        return this.fuF;
    }

    @Override // com.baidu.live.l.b
    public TextView getRankLevelView() {
        return this.fuG;
    }

    @Override // com.baidu.live.l.b
    public View getRankItemRootView() {
        return this;
    }
}

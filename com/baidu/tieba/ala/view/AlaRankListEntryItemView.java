package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.p.b {
    private TextView fAq;
    private TextView fAr;

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
        this.fAq = (TextView) findViewById(a.g.ala_rank_list_type);
        this.fAr = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.fAq.setText(str);
    }

    public void setRankListLevel(String str) {
        this.fAr.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.fAr.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.p.b
    public TextView getRankNameView() {
        return this.fAq;
    }

    @Override // com.baidu.live.p.b
    public TextView getRankLevelView() {
        return this.fAr;
    }

    @Override // com.baidu.live.p.b
    public View getRankItemRootView() {
        return this;
    }
}

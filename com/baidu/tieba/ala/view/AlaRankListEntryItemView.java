package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.h.b {
    private TextView eDa;
    private TextView eDb;

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
        this.eDa = (TextView) findViewById(a.g.ala_rank_list_type);
        this.eDb = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.eDa.setText(str);
    }

    public void setRankListLevel(String str) {
        this.eDb.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.eDb.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.h.b
    public TextView getRankNameView() {
        return this.eDa;
    }

    @Override // com.baidu.live.h.b
    public TextView getRankLevelView() {
        return this.eDb;
    }

    @Override // com.baidu.live.h.b
    public View getRankItemRootView() {
        return this;
    }
}

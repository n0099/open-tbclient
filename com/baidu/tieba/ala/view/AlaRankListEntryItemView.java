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
    private TextView guL;
    private TextView guM;

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
        this.guL = (TextView) findViewById(a.g.ala_rank_list_type);
        this.guM = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.guL.setText(str);
    }

    public void setRankListLevel(String str) {
        this.guM.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.guM.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.p.b
    public TextView getRankNameView() {
        return this.guL;
    }

    @Override // com.baidu.live.p.b
    public TextView getRankLevelView() {
        return this.guM;
    }

    @Override // com.baidu.live.p.b
    public View getRankItemRootView() {
        return this;
    }
}

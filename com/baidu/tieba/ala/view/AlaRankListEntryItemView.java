package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.s.b {
    private TextView htH;
    private TextView htI;

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
        this.htH = (TextView) findViewById(a.g.ala_rank_list_type);
        this.htI = (TextView) findViewById(a.g.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.htH.setText(str);
    }

    public void setRankListLevel(String str) {
        this.htI.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.htI.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.s.b
    public TextView getRankNameView() {
        return this.htH;
    }

    @Override // com.baidu.live.s.b
    public TextView getRankLevelView() {
        return this.htI;
    }

    @Override // com.baidu.live.s.b
    public View getRankItemRootView() {
        return this;
    }
}

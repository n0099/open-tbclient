package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.x.b {
    private TextView iiZ;
    private TextView ija;

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
        this.iiZ = (TextView) findViewById(a.f.ala_rank_list_type);
        this.ija = (TextView) findViewById(a.f.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.iiZ.setText(str);
    }

    public void setRankListLevel(String str) {
        this.ija.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.ija.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.x.b
    public TextView getRankNameView() {
        return this.iiZ;
    }

    @Override // com.baidu.live.x.b
    public TextView getRankLevelView() {
        return this.ija;
    }

    @Override // com.baidu.live.x.b
    public View getRankItemRootView() {
        return this;
    }
}

package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaRankListEntryItemView extends LinearLayout implements com.baidu.live.z.b {
    private TextView iiy;
    private TextView iiz;

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
        this.iiy = (TextView) findViewById(a.f.ala_rank_list_type);
        this.iiz = (TextView) findViewById(a.f.ala_rank_list_level);
    }

    public void setRankListName(String str) {
        this.iiy.setText(str);
    }

    public void setRankListLevel(String str) {
        this.iiz.setText(str);
    }

    public void setRankListLevelVisible(boolean z) {
        this.iiz.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.live.z.b
    public TextView getRankNameView() {
        return this.iiy;
    }

    @Override // com.baidu.live.z.b
    public TextView getRankLevelView() {
        return this.iiz;
    }

    @Override // com.baidu.live.z.b
    public View getRankItemRootView() {
        return this;
    }
}

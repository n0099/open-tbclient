package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList fGN;
    private int fGO = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bnA() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bnC;
        if (view instanceof TextView) {
            bnC = (TextView) view;
        } else {
            bnC = bnC();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.fGN, i);
        if (aVar != null) {
            bnC.setText(aVar.labelName);
        }
        c(bnC, this.fGO == i);
        return bnC;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bnB() {
        return v.getCount(this.fGN);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object re(int i) {
        return v.getItem(this.fGN, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long rf(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fGN = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bnC() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bnA());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        am.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void rg(int i) {
        this.fGO = i;
        this.fGN.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

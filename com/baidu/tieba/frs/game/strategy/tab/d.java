package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList hTM;
    private int hTN = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cfG() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cfI;
        if (view instanceof TextView) {
            cfI = (TextView) view;
        } else {
            cfI = cfI();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) x.getItem(this.hTM, i);
        if (aVar != null) {
            cfI.setText(aVar.labelName);
        }
        c(cfI, this.hTN == i);
        return cfI;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cfH() {
        return x.getCount(this.hTM);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object vD(int i) {
        return x.getItem(this.hTM, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long vE(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.hTM = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cfI() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cfG());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            ao.setViewTextColor(textView, R.color.cp_link_tip_a);
            ao.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ao.setViewTextColor(textView, R.color.cp_cont_f);
        ao.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void vF(int i) {
        this.hTN = i;
        this.hTM.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

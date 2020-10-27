package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hcc = 0;
    private LabelDataList iQt;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cAd() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cAf;
        if (view instanceof TextView) {
            cAf = (TextView) view;
        } else {
            cAf = cAf();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.iQt, i);
        if (aVar != null) {
            cAf.setText(aVar.labelName);
        }
        c(cAf, this.hcc == i);
        return cAf;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cAe() {
        return y.getCount(this.iQt);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zu(int i) {
        return y.getItem(this.iQt, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zv(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.iQt = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cAf() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cAd());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            ap.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
        ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void zw(int i) {
        this.hcc = i;
        this.iQt.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

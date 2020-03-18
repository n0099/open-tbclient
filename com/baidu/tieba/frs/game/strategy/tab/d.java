package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList gBC;
    private int gBD = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bHQ() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bHS;
        if (view instanceof TextView) {
            bHS = (TextView) view;
        } else {
            bHS = bHS();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.gBC, i);
        if (aVar != null) {
            bHS.setText(aVar.labelName);
        }
        c(bHS, this.gBD == i);
        return bHS;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bHR() {
        return v.getCount(this.gBC);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object tB(int i) {
        return v.getItem(this.gBC, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long tC(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.gBC = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bHS() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bHQ());
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
    public void tD(int i) {
        this.gBD = i;
        this.gBC.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

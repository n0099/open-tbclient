package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList hNN;
    private int hNO = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cch() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView ccj;
        if (view instanceof TextView) {
            ccj = (TextView) view;
        } else {
            ccj = ccj();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) w.getItem(this.hNN, i);
        if (aVar != null) {
            ccj.setText(aVar.labelName);
        }
        c(ccj, this.hNO == i);
        return ccj;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cci() {
        return w.getCount(this.hNN);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object vl(int i) {
        return w.getItem(this.hNN, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long vm(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.hNN = labelDataList;
        notifyDataSetChanged();
    }

    private TextView ccj() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cch());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            an.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            an.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        an.setViewTextColor(textView, (int) R.color.cp_cont_f);
        an.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void vn(int i) {
        this.hNO = i;
        this.hNN.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

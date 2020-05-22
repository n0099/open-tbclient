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
    private LabelDataList hzS;
    private int hzT = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bYJ() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bYL;
        if (view instanceof TextView) {
            bYL = (TextView) view;
        } else {
            bYL = bYL();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.hzS, i);
        if (aVar != null) {
            bYL.setText(aVar.labelName);
        }
        c(bYL, this.hzT == i);
        return bYL;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bYK() {
        return v.getCount(this.hzS);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object uE(int i) {
        return v.getItem(this.hzS, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long uF(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.hzS = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bYL() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bYJ());
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
    public void uG(int i) {
        this.hzT = i;
        this.hzS.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

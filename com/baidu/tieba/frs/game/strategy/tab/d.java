package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList gyq;
    private int gyr = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bFZ() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bGb;
        if (view instanceof TextView) {
            bGb = (TextView) view;
        } else {
            bGb = bGb();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.gyq, i);
        if (aVar != null) {
            bGb.setText(aVar.labelName);
        }
        c(bGb, this.gyr == i);
        return bGb;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bGa() {
        return v.getCount(this.gyq);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object tp(int i) {
        return v.getItem(this.gyq, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long tq(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.gyq = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bGb() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bFZ());
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
    public void tr(int i) {
        this.gyr = i;
        this.gyq.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

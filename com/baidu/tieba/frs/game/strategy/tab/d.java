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
    private LabelDataList hAF;
    private int hAG = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bYR() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bYT;
        if (view instanceof TextView) {
            bYT = (TextView) view;
        } else {
            bYT = bYT();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.hAF, i);
        if (aVar != null) {
            bYT.setText(aVar.labelName);
        }
        c(bYT, this.hAG == i);
        return bYT;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bYS() {
        return v.getCount(this.hAF);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object uG(int i) {
        return v.getItem(this.hAF, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long uH(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.hAF = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bYT() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bYR());
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
    public void uI(int i) {
        this.hAG = i;
        this.hAF.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

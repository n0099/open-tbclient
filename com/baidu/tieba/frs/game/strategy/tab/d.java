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
    private LabelDataList fGy;
    private int fGz = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bpL() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bpN;
        if (view instanceof TextView) {
            bpN = (TextView) view;
        } else {
            bpN = bpN();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fGy, i);
        if (aVar != null) {
            bpN.setText(aVar.labelName);
        }
        c(bpN, this.fGz == i);
        return bpN;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bpM() {
        return v.Z(this.fGy);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object si(int i) {
        return v.c(this.fGy, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long sj(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fGy = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bpN() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bpL());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.j(textView, R.color.cp_link_tip_a);
            am.k(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        am.j(textView, R.color.cp_cont_f);
        am.k(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void sk(int i) {
        this.fGz = i;
        this.fGy.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList dNb;
    private int dNc = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aCP() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView aCR;
        if (view instanceof TextView) {
            aCR = (TextView) view;
        } else {
            aCR = aCR();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.d(this.dNb, i);
        if (aVar != null) {
            aCR.setText(aVar.labelName);
        }
        c(aCR, this.dNc == i);
        return aCR;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aCQ() {
        return v.H(this.dNb);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object mt(int i) {
        return v.d(this.dNb, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long mu(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dNb = labelDataList;
        notifyDataSetChanged();
    }

    private TextView aCR() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0200e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(aCP());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            al.h(textView, e.d.cp_link_tip_a);
            al.i(textView, e.f.shape_frs_game_label_item_bg_s);
            return;
        }
        al.h(textView, e.d.cp_cont_f);
        al.i(textView, e.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void mv(int i) {
        this.dNc = i;
        this.dNb.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

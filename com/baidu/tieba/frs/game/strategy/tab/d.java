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
    private LabelDataList dXb;
    private int dXc = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aFN() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView aFP;
        if (view instanceof TextView) {
            aFP = (TextView) view;
        } else {
            aFP = aFP();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.d(this.dXb, i);
        if (aVar != null) {
            aFP.setText(aVar.labelName);
        }
        c(aFP, this.dXc == i);
        return aFP;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aFO() {
        return v.H(this.dXb);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object mX(int i) {
        return v.d(this.dXb, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long mY(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dXb = labelDataList;
        notifyDataSetChanged();
    }

    private TextView aFP() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(aFN());
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
    public void mZ(int i) {
        this.dXc = i;
        this.dXb.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

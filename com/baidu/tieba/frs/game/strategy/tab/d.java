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
    private LabelDataList dLX;
    private int dLY = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aDv() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView aDx;
        if (view instanceof TextView) {
            aDx = (TextView) view;
        } else {
            aDx = aDx();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.d(this.dLX, i);
        if (aVar != null) {
            aDx.setText(aVar.labelName);
        }
        c(aDx, this.dLY == i);
        return aDx;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aDw() {
        return v.I(this.dLX);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object mc(int i) {
        return v.d(this.dLX, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long md(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dLX = labelDataList;
        notifyDataSetChanged();
    }

    private TextView aDx() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0175e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(aDv());
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
    public void me(int i) {
        this.dLY = i;
        this.dLX.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList dhc;
    private int dhd = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int asA() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view2, ViewGroup viewGroup) {
        TextView asC;
        if (view2 instanceof TextView) {
            asC = (TextView) view2;
        } else {
            asC = asC();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.dhc, i);
        if (aVar != null) {
            asC.setText(aVar.labelName);
        }
        b(asC, this.dhd == i);
        return asC;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int asB() {
        return v.v(this.dhc);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object kG(int i) {
        return v.c(this.dhc, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long kH(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dhc = labelDataList;
        notifyDataSetChanged();
    }

    private TextView asC() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(asA());
        return textView;
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            ak.h(textView, d.C0126d.cp_link_tip_a);
            ak.i(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        ak.h(textView, d.C0126d.cp_cont_f);
        ak.i(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void kI(int i) {
        this.dhd = i;
        this.dhc.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

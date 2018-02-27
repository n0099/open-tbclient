package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList dOr;
    private int dOs = 0;
    private final int mContentHeight;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axT() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axV;
        if (view instanceof TextView) {
            axV = (TextView) view;
        } else {
            axV = axV();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.f(this.dOr, i);
        if (aVar != null) {
            axV.setText(aVar.labelName);
        }
        b(axV, this.dOs == i);
        return axV;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axU() {
        return v.D(this.dOr);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object nt(int i) {
        return v.f(this.dOr, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long nu(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dOr = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axV() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axT());
        return textView;
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            aj.r(textView, d.C0141d.cp_link_tip_a);
            aj.s(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        aj.r(textView, d.C0141d.cp_cont_f);
        aj.s(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void nv(int i) {
        this.dOs = i;
        this.dOr.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

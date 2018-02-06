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
    private LabelDataList dOD;
    private int dOE = 0;
    private final int mContentHeight;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axU() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axW;
        if (view instanceof TextView) {
            axW = (TextView) view;
        } else {
            axW = axW();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.f(this.dOD, i);
        if (aVar != null) {
            axW.setText(aVar.labelName);
        }
        b(axW, this.dOE == i);
        return axW;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axV() {
        return v.D(this.dOD);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object nt(int i) {
        return v.f(this.dOD, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long nu(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dOD = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axW() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axU());
        return textView;
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            aj.r(textView, d.C0140d.cp_link_tip_a);
            aj.s(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        aj.r(textView, d.C0140d.cp_cont_f);
        aj.s(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void nv(int i) {
        this.dOE = i;
        this.dOD.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

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
    private LabelDataList dOw;
    private int dOx = 0;
    private final int mContentHeight;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axV() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axX;
        if (view instanceof TextView) {
            axX = (TextView) view;
        } else {
            axX = axX();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.f(this.dOw, i);
        if (aVar != null) {
            axX.setText(aVar.labelName);
        }
        b(axX, this.dOx == i);
        return axX;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axW() {
        return v.D(this.dOw);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object nt(int i) {
        return v.f(this.dOw, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long nu(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dOw = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axX() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axV());
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
        this.dOx = i;
        this.dOw.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList duE;
    private int duF = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axj() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axl;
        if (view instanceof TextView) {
            axl = (TextView) view;
        } else {
            axl = axl();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) w.d(this.duE, i);
        if (aVar != null) {
            axl.setText(aVar.labelName);
        }
        c(axl, this.duF == i);
        return axl;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axk() {
        return w.z(this.duE);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object kR(int i) {
        return w.d(this.duE, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long kS(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.duE = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axl() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axj());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.h(textView, d.C0142d.cp_link_tip_a);
            am.i(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        am.h(textView, d.C0142d.cp_cont_f);
        am.i(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void kT(int i) {
        this.duF = i;
        this.duE.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

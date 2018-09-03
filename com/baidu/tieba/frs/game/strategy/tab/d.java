package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList dxo;
    private int dxp = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(f.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axM() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axO;
        if (view instanceof TextView) {
            axO = (TextView) view;
        } else {
            axO = axO();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) w.d(this.dxo, i);
        if (aVar != null) {
            axO.setText(aVar.labelName);
        }
        c(axO, this.dxp == i);
        return axO;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axN() {
        return w.y(this.dxo);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object lb(int i) {
        return w.d(this.dxo, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long lc(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dxo = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axO() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(f.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axM());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.h(textView, f.d.cp_link_tip_a);
            am.i(textView, f.C0146f.shape_frs_game_label_item_bg_s);
            return;
        }
        am.h(textView, f.d.cp_cont_f);
        am.i(textView, f.C0146f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void ld(int i) {
        this.dxp = i;
        this.dxo.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

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
    private LabelDataList dxr;
    private int dxs = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axO() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView axQ;
        if (view instanceof TextView) {
            axQ = (TextView) view;
        } else {
            axQ = axQ();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) w.d(this.dxr, i);
        if (aVar != null) {
            axQ.setText(aVar.labelName);
        }
        c(axQ, this.dxs == i);
        return axQ;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int axP() {
        return w.y(this.dxr);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object lc(int i) {
        return w.d(this.dxr, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long ld(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dxr = labelDataList;
        notifyDataSetChanged();
    }

    private TextView axQ() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(axO());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.h(textView, d.C0140d.cp_link_tip_a);
            am.i(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        am.h(textView, d.C0140d.cp_cont_f);
        am.i(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void le(int i) {
        this.dxs = i;
        this.dxr.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList drv;
    private int drw = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int awF() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView awH;
        if (view instanceof TextView) {
            awH = (TextView) view;
        } else {
            awH = awH();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) w.c(this.drv, i);
        if (aVar != null) {
            awH.setText(aVar.labelName);
        }
        b(awH, this.drw == i);
        return awH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int awG() {
        return w.y(this.drv);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object kK(int i) {
        return w.c(this.drv, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long kL(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.drv = labelDataList;
        notifyDataSetChanged();
    }

    private TextView awH() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(awF());
        return textView;
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            al.h(textView, d.C0141d.cp_link_tip_a);
            al.i(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        al.h(textView, d.C0141d.cp_cont_f);
        al.i(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void kM(int i) {
        this.drw = i;
        this.drv.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

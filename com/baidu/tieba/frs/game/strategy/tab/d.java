package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList fkq;
    private int fkr = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bgd() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bgf;
        if (view instanceof TextView) {
            bgf = (TextView) view;
        } else {
            bgf = bgf();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fkq, i);
        if (aVar != null) {
            bgf.setText(aVar.labelName);
        }
        c(bgf, this.fkr == i);
        return bgf;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bge() {
        return v.S(this.fkq);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object qG(int i) {
        return v.c(this.fkq, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long qH(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fkq = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bgf() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bgd());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            al.j(textView, d.C0277d.cp_link_tip_a);
            al.k(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        al.j(textView, d.C0277d.cp_cont_f);
        al.k(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void qI(int i) {
        this.fkr = i;
        this.fkq.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

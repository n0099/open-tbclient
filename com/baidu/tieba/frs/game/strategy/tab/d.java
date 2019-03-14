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
    private LabelDataList fkE;
    private int fkF = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bgf() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bgh;
        if (view instanceof TextView) {
            bgh = (TextView) view;
        } else {
            bgh = bgh();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fkE, i);
        if (aVar != null) {
            bgh.setText(aVar.labelName);
        }
        b(bgh, this.fkF == i);
        return bgh;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bgg() {
        return v.S(this.fkE);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object qK(int i) {
        return v.c(this.fkE, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long qL(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fkE = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bgh() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bgf());
        return textView;
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            al.j(textView, d.C0277d.cp_link_tip_a);
            al.k(textView, d.f.shape_frs_game_label_item_bg_s);
            return;
        }
        al.j(textView, d.C0277d.cp_cont_f);
        al.k(textView, d.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void qM(int i) {
        this.fkF = i;
        this.fkE.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

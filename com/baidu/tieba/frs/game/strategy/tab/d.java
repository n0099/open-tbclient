package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList fFK;
    private int fFL = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bpy() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bpA;
        if (view instanceof TextView) {
            bpA = (TextView) view;
        } else {
            bpA = bpA();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fFK, i);
        if (aVar != null) {
            bpA.setText(aVar.labelName);
        }
        c(bpA, this.fFL == i);
        return bpA;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bpz() {
        return v.Z(this.fFK);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object sg(int i) {
        return v.c(this.fFK, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long sh(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fFK = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bpA() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bpy());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.j(textView, R.color.cp_link_tip_a);
            am.k(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        am.j(textView, R.color.cp_cont_f);
        am.k(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void si(int i) {
        this.fFL = i;
        this.fFK.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

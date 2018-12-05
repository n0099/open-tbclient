package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList dTE;
    private int dTF = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aEB() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView aED;
        if (view instanceof TextView) {
            aED = (TextView) view;
        } else {
            aED = aED();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.d(this.dTE, i);
        if (aVar != null) {
            aED.setText(aVar.labelName);
        }
        c(aED, this.dTF == i);
        return aED;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aEC() {
        return v.H(this.dTE);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object mJ(int i) {
        return v.d(this.dTE, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long mK(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dTE = labelDataList;
        notifyDataSetChanged();
    }

    private TextView aED() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(aEB());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            al.h(textView, e.d.cp_link_tip_a);
            al.i(textView, e.f.shape_frs_game_label_item_bg_s);
            return;
        }
        al.h(textView, e.d.cp_cont_f);
        al.i(textView, e.f.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void mL(int i) {
        this.dTF = i;
        this.dTE.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

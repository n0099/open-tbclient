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
    private LabelDataList dDY;
    private int dDZ = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aAb() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView aAd;
        if (view instanceof TextView) {
            aAd = (TextView) view;
        } else {
            aAd = aAd();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.d(this.dDY, i);
        if (aVar != null) {
            aAd.setText(aVar.labelName);
        }
        c(aAd, this.dDZ == i);
        return aAd;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int aAc() {
        return v.y(this.dDY);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object lE(int i) {
        return v.d(this.dDY, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long lF(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.dDY = labelDataList;
        notifyDataSetChanged();
    }

    private TextView aAd() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0141e.fontsize26));
        textView.setGravity(17);
        textView.setHeight(aAb());
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
    public void lG(int i) {
        this.dDZ = i;
        this.dDY.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

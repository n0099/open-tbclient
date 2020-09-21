package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int gBW = 0;
    private LabelDataList ipe;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int ctz() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView ctB;
        if (view instanceof TextView) {
            ctB = (TextView) view;
        } else {
            ctB = ctB();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.ipe, i);
        if (aVar != null) {
            ctB.setText(aVar.labelName);
        }
        c(ctB, this.gBW == i);
        return ctB;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int ctA() {
        return y.getCount(this.ipe);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object yv(int i) {
        return y.getItem(this.ipe, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long yw(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.ipe = labelDataList;
        notifyDataSetChanged();
    }

    private TextView ctB() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(ctz());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            ap.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
        ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void yx(int i) {
        this.gBW = i;
        this.ipe.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

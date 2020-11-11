package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hhX = 0;
    private LabelDataList iWq;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cCE() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cCG;
        if (view instanceof TextView) {
            cCG = (TextView) view;
        } else {
            cCG = cCG();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.iWq, i);
        if (aVar != null) {
            cCG.setText(aVar.labelName);
        }
        c(cCG, this.hhX == i);
        return cCG;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cCF() {
        return y.getCount(this.iWq);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zH(int i) {
        return y.getItem(this.iWq, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zI(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.iWq = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cCG() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cCE());
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
    public void zJ(int i) {
        this.hhX = i;
        this.iWq.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

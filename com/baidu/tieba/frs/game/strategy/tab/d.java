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
    private int hrj = 0;
    private LabelDataList jkD;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHu() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cHw;
        if (view instanceof TextView) {
            cHw = (TextView) view;
        } else {
            cHw = cHw();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.jkD, i);
        if (aVar != null) {
            cHw.setText(aVar.labelName);
        }
        c(cHw, this.hrj == i);
        return cHw;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHv() {
        return y.getCount(this.jkD);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object AT(int i) {
        return y.getItem(this.jkD, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long AU(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jkD = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cHw() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cHu());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            ap.setViewTextColor(textView, (int) R.color.CAM_X0302);
            ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ap.setViewTextColor(textView, (int) R.color.CAM_X0106);
        ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void AV(int i) {
        this.hrj = i;
        this.jkD.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

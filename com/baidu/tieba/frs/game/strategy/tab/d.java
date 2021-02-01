package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hCK = 0;
    private LabelDataList jyc;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHQ() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cHS;
        if (view instanceof TextView) {
            cHS = (TextView) view;
        } else {
            cHS = cHS();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.jyc, i);
        if (aVar != null) {
            cHS.setText(aVar.labelName);
        }
        d(cHS, this.hCK == i);
        return cHS;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHR() {
        return y.getCount(this.jyc);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zJ(int i) {
        return y.getItem(this.jyc, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zK(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jyc = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cHS() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cHQ());
        return textView;
    }

    public void d(TextView textView, boolean z) {
        if (z) {
            ap.setViewTextColor(textView, R.color.CAM_X0302);
            ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ap.setViewTextColor(textView, R.color.CAM_X0106);
        ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void zL(int i) {
        this.hCK = i;
        this.jyc.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hDf = 0;
    private LabelDataList jxc;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cKv() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cKx;
        if (view instanceof TextView) {
            cKx = (TextView) view;
        } else {
            cKx = cKx();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) x.getItem(this.jxc, i);
        if (aVar != null) {
            cKx.setText(aVar.labelName);
        }
        c(cKx, this.hDf == i);
        return cKx;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cKw() {
        return x.getCount(this.jxc);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object Bf(int i) {
        return x.getItem(this.jxc, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long Bg(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jxc = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cKx() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cKv());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            ao.setViewTextColor(textView, R.color.CAM_X0302);
            ao.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ao.setViewTextColor(textView, R.color.CAM_X0106);
        ao.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void Bh(int i) {
        this.hDf = i;
        this.jxc.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

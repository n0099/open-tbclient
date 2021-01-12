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
    private int hyz = 0;
    private LabelDataList jsw;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cGD() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cGF;
        if (view instanceof TextView) {
            cGF = (TextView) view;
        } else {
            cGF = cGF();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) x.getItem(this.jsw, i);
        if (aVar != null) {
            cGF.setText(aVar.labelName);
        }
        c(cGF, this.hyz == i);
        return cGF;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cGE() {
        return x.getCount(this.jsw);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zz(int i) {
        return x.getItem(this.jsw, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zA(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jsw = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cGF() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cGD());
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
    public void zB(int i) {
        this.hyz = i;
        this.jsw.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

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
    private int hrh = 0;
    private LabelDataList jkB;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHt() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cHv;
        if (view instanceof TextView) {
            cHv = (TextView) view;
        } else {
            cHv = cHv();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.jkB, i);
        if (aVar != null) {
            cHv.setText(aVar.labelName);
        }
        c(cHv, this.hrh == i);
        return cHv;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cHu() {
        return y.getCount(this.jkB);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object AT(int i) {
        return y.getItem(this.jkB, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long AU(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jkB = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cHv() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cHt());
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
        this.hrh = i;
        this.jkB.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

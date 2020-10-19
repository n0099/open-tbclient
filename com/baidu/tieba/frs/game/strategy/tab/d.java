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
    private int gQp = 0;
    private LabelDataList iDX;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cwW() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cwY;
        if (view instanceof TextView) {
            cwY = (TextView) view;
        } else {
            cwY = cwY();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.iDX, i);
        if (aVar != null) {
            cwY.setText(aVar.labelName);
        }
        c(cwY, this.gQp == i);
        return cwY;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cwX() {
        return y.getCount(this.iDX);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zb(int i) {
        return y.getItem(this.iDX, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zc(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.iDX = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cwY() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cwW());
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
    public void zd(int i) {
        this.gQp = i;
        this.iDX.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

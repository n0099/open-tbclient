package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int gyH = 0;
    private LabelDataList ihW;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cql() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cqn;
        if (view instanceof TextView) {
            cqn = (TextView) view;
        } else {
            cqn = cqn();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.ihW, i);
        if (aVar != null) {
            cqn.setText(aVar.labelName);
        }
        c(cqn, this.gyH == i);
        return cqn;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cqm() {
        return y.getCount(this.ihW);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object xW(int i) {
        return y.getItem(this.ihW, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long xX(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.ihW = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cqn() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cql());
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
    public void xY(int i) {
        this.gyH = i;
        this.ihW.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

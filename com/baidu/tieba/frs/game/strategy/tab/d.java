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
    private int gyL = 0;
    private LabelDataList iic;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cqm() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cqo;
        if (view instanceof TextView) {
            cqo = (TextView) view;
        } else {
            cqo = cqo();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.iic, i);
        if (aVar != null) {
            cqo.setText(aVar.labelName);
        }
        c(cqo, this.gyL == i);
        return cqo;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cqn() {
        return y.getCount(this.iic);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object xW(int i) {
        return y.getItem(this.iic, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long xX(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.iic = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cqo() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cqm());
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
        this.gyL = i;
        this.iic.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

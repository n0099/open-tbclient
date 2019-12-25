package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList gvg;
    private int gvh = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bEX() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bEZ;
        if (view instanceof TextView) {
            bEZ = (TextView) view;
        } else {
            bEZ = bEZ();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.gvg, i);
        if (aVar != null) {
            bEZ.setText(aVar.labelName);
        }
        c(bEZ, this.gvh == i);
        return bEZ;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bEY() {
        return v.getCount(this.gvg);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object tk(int i) {
        return v.getItem(this.gvg, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long tl(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.gvg = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bEZ() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bEX());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        am.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void tm(int i) {
        this.gvh = i;
        this.gvg.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

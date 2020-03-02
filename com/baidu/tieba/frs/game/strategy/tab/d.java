package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList gAs;
    private int gAt = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bHD() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bHF;
        if (view instanceof TextView) {
            bHF = (TextView) view;
        } else {
            bHF = bHF();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.getItem(this.gAs, i);
        if (aVar != null) {
            bHF.setText(aVar.labelName);
        }
        c(bHF, this.gAt == i);
        return bHF;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bHE() {
        return v.getCount(this.gAs);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object tv(int i) {
        return v.getItem(this.gAs, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long tw(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.gAs = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bHF() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bHD());
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
    public void tx(int i) {
        this.gAt = i;
        this.gAs.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

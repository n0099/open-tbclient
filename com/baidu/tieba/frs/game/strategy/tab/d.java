package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList fAM;
    private int fAN = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bnx() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bnz;
        if (view instanceof TextView) {
            bnz = (TextView) view;
        } else {
            bnz = bnz();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fAM, i);
        if (aVar != null) {
            bnz.setText(aVar.labelName);
        }
        c(bnz, this.fAN == i);
        return bnz;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bny() {
        return v.Z(this.fAM);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object rO(int i) {
        return v.c(this.fAM, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long rP(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fAM = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bnz() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bnx());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            al.j(textView, R.color.cp_link_tip_a);
            al.k(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        al.j(textView, R.color.cp_cont_f);
        al.k(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void rQ(int i) {
        this.fAN = i;
        this.fAM.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

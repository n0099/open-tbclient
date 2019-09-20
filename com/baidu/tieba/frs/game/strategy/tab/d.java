package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private LabelDataList fIn;
    private int fIo = 0;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bqx() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView bqz;
        if (view instanceof TextView) {
            bqz = (TextView) view;
        } else {
            bqz = bqz();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) v.c(this.fIn, i);
        if (aVar != null) {
            bqz.setText(aVar.labelName);
        }
        c(bqz, this.fIo == i);
        return bqz;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int bqy() {
        return v.Z(this.fIn);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object sm(int i) {
        return v.c(this.fIn, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long sn(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.fIn = labelDataList;
        notifyDataSetChanged();
    }

    private TextView bqz() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(bqx());
        return textView;
    }

    public void c(TextView textView, boolean z) {
        if (z) {
            am.j(textView, R.color.cp_link_tip_a);
            am.k(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        am.j(textView, R.color.cp_cont_f);
        am.k(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void so(int i) {
        this.fIo = i;
        this.fIn.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

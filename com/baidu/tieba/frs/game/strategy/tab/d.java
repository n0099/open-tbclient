package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hhE = 0;
    private LabelDataList iXc;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cCi() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cCk;
        if (view instanceof TextView) {
            cCk = (TextView) view;
        } else {
            cCk = cCk();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.iXc, i);
        if (aVar != null) {
            cCk.setText(aVar.labelName);
        }
        c(cCk, this.hhE == i);
        return cCk;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cCj() {
        return y.getCount(this.iXc);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object Af(int i) {
        return y.getItem(this.iXc, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long Ag(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.iXc = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cCk() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cCi());
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
    public void Ah(int i) {
        this.hhE = i;
        this.iXc.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

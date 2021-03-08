package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.game.strategy.view.a {
    private int hEH = 0;
    private LabelDataList jzZ;
    private final int mContentHeight;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.mContentHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cId() {
        return this.mContentHeight;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public View c(int i, View view, ViewGroup viewGroup) {
        TextView cIf;
        if (view instanceof TextView) {
            cIf = (TextView) view;
        } else {
            cIf = cIf();
        }
        com.baidu.tieba.frs.game.strategy.data.a aVar = (com.baidu.tieba.frs.game.strategy.data.a) y.getItem(this.jzZ, i);
        if (aVar != null) {
            cIf.setText(aVar.labelName);
        }
        d(cIf, this.hEH == i);
        return cIf;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public int cIe() {
        return y.getCount(this.jzZ);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public Object zK(int i) {
        return y.getItem(this.jzZ, i);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public long zL(int i) {
        return i;
    }

    public void a(LabelDataList labelDataList) {
        this.jzZ = labelDataList;
        notifyDataSetChanged();
    }

    private TextView cIf() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize26));
        textView.setGravity(17);
        textView.setHeight(cId());
        return textView;
    }

    public void d(TextView textView, boolean z) {
        if (z) {
            ap.setViewTextColor(textView, R.color.CAM_X0302);
            ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
            return;
        }
        ap.setViewTextColor(textView, R.color.CAM_X0106);
        ap.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.a
    public void zM(int i) {
        this.hEH = i;
        this.jzZ.setSelectedIndex(i);
        notifyDataSetChanged();
    }
}

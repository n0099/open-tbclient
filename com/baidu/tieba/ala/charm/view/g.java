package com.baidu.tieba.ala.charm.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes2.dex */
public class g {
    public ViewGroup esX;
    public HeadImageView eta;
    public TextView etb;
    private ALALevelView etk;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.esX = (ViewGroup) view.findViewById(a.g.item_view);
        this.eta = (HeadImageView) view.findViewById(a.g.photo);
        this.eta.setIsRound(true);
        this.eta.setAutoChangeStyle(false);
        this.eta.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.etb = (TextView) view.findViewById(a.g.intro);
        this.etk = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.f fVar) {
        if (fVar != null && fVar.Wf != null) {
            this.esX.setTag(Integer.valueOf(i));
            this.etk.setData(fVar.Wf);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.etk.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(fVar.Wf.userName);
            if (!TextUtils.isEmpty(fVar.Wf.description)) {
                this.etb.setText(fVar.Wf.description);
            } else {
                this.etb.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.eta, fVar.Wf.portrait, true, false);
            this.esX.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.esX != null && onClickListener != null) {
            this.esX.setOnClickListener(onClickListener);
        }
    }
}

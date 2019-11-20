package com.baidu.tieba.ala.charm.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.j;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes6.dex */
public class g {
    public ViewGroup dFJ;
    public HeadImageView dFM;
    public TextView dFN;
    private ALALevelView dFV;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.dFJ = (ViewGroup) view.findViewById(a.g.item_view);
        this.dFM = (HeadImageView) view.findViewById(a.g.photo);
        this.dFM.setIsRound(true);
        this.dFM.setAutoChangeStyle(false);
        this.dFM.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.dFN = (TextView) view.findViewById(a.g.intro);
        this.dFV = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.d dVar) {
        if (dVar != null && dVar.OR != null) {
            this.dFJ.setTag(Integer.valueOf(i));
            this.dFV.setData(dVar.OR);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.dFV.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(dVar.OR.userName);
            if (!TextUtils.isEmpty(dVar.OR.description)) {
                this.dFN.setText(dVar.OR.description);
            } else {
                this.dFN.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            j.a(this.dFM, dVar.OR.portrait, true, false);
            this.dFJ.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.dFJ != null && onClickListener != null) {
            this.dFJ.setOnClickListener(onClickListener);
        }
    }
}

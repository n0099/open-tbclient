package com.baidu.tieba.ala.charm.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes3.dex */
public class g {
    public ViewGroup exS;
    public HeadImageView exV;
    public TextView exW;
    private ALALevelView eyf;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.exS = (ViewGroup) view.findViewById(a.g.item_view);
        this.exV = (HeadImageView) view.findViewById(a.g.photo);
        this.exV.setIsRound(true);
        this.exV.setAutoChangeStyle(false);
        this.exV.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.exW = (TextView) view.findViewById(a.g.intro);
        this.eyf = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.Ya != null) {
            this.exS.setTag(Integer.valueOf(i));
            this.eyf.setData(gVar.Ya);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.eyf.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(gVar.Ya.userName);
            if (!TextUtils.isEmpty(gVar.Ya.description)) {
                this.exW.setText(gVar.Ya.description);
            } else {
                this.exW.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.exV, gVar.Ya.portrait, true, false);
            this.exS.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exS != null && onClickListener != null) {
            this.exS.setOnClickListener(onClickListener);
        }
    }
}

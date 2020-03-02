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
    public ViewGroup exi;
    public HeadImageView exl;
    public TextView exm;
    private ALALevelView exv;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.exi = (ViewGroup) view.findViewById(a.g.item_view);
        this.exl = (HeadImageView) view.findViewById(a.g.photo);
        this.exl.setIsRound(true);
        this.exl.setAutoChangeStyle(false);
        this.exl.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.exm = (TextView) view.findViewById(a.g.intro);
        this.exv = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.XQ != null) {
            this.exi.setTag(Integer.valueOf(i));
            this.exv.setData(gVar.XQ);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.exv.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(gVar.XQ.userName);
            if (!TextUtils.isEmpty(gVar.XQ.description)) {
                this.exm.setText(gVar.XQ.description);
            } else {
                this.exm.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.exl, gVar.XQ.portrait, true, false);
            this.exi.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exi != null && onClickListener != null) {
            this.exi.setOnClickListener(onClickListener);
        }
    }
}

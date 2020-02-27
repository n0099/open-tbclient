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
    public ViewGroup exh;
    public HeadImageView exk;
    public TextView exl;
    private ALALevelView exu;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.exh = (ViewGroup) view.findViewById(a.g.item_view);
        this.exk = (HeadImageView) view.findViewById(a.g.photo);
        this.exk.setIsRound(true);
        this.exk.setAutoChangeStyle(false);
        this.exk.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.exl = (TextView) view.findViewById(a.g.intro);
        this.exu = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.XQ != null) {
            this.exh.setTag(Integer.valueOf(i));
            this.exu.setData(gVar.XQ);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.exu.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(gVar.XQ.userName);
            if (!TextUtils.isEmpty(gVar.XQ.description)) {
                this.exl.setText(gVar.XQ.description);
            } else {
                this.exl.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.exk, gVar.XQ.portrait, true, false);
            this.exh.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exh != null && onClickListener != null) {
            this.exh.setOnClickListener(onClickListener);
        }
    }
}

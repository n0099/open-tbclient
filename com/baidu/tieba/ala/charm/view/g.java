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
    public TextView exA;
    private ALALevelView exI;
    public ViewGroup exw;
    public HeadImageView exz;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.exw = (ViewGroup) view.findViewById(a.g.item_view);
        this.exz = (HeadImageView) view.findViewById(a.g.photo);
        this.exz.setIsRound(true);
        this.exz.setAutoChangeStyle(false);
        this.exz.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.exA = (TextView) view.findViewById(a.g.intro);
        this.exI = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.XQ != null) {
            this.exw.setTag(Integer.valueOf(i));
            this.exI.setData(gVar.XQ);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.exI.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(gVar.XQ.userName);
            if (!TextUtils.isEmpty(gVar.XQ.description)) {
                this.exA.setText(gVar.XQ.description);
            } else {
                this.exA.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.exz, gVar.XQ.portrait, true, false);
            this.exw.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exw != null && onClickListener != null) {
            this.exw.setOnClickListener(onClickListener);
        }
    }
}

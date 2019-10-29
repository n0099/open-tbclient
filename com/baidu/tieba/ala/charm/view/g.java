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
    public ViewGroup dGA;
    public HeadImageView dGD;
    public TextView dGE;
    private ALALevelView dGM;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.dGA = (ViewGroup) view.findViewById(a.g.item_view);
        this.dGD = (HeadImageView) view.findViewById(a.g.photo);
        this.dGD.setIsRound(true);
        this.dGD.setAutoChangeStyle(false);
        this.dGD.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.dGE = (TextView) view.findViewById(a.g.intro);
        this.dGM = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.d dVar) {
        if (dVar != null && dVar.Ps != null) {
            this.dGA.setTag(Integer.valueOf(i));
            this.dGM.setData(dVar.Ps);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.dGM.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(dVar.Ps.userName);
            if (!TextUtils.isEmpty(dVar.Ps.description)) {
                this.dGE.setText(dVar.Ps.description);
            } else {
                this.dGE.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            j.a(this.dGD, dVar.Ps.portrait, true, false);
            this.dGA.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.dGA != null && onClickListener != null) {
            this.dGA.setOnClickListener(onClickListener);
        }
    }
}

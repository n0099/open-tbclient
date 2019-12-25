package com.baidu.tieba.ala.charm.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes2.dex */
public class g {
    public ViewGroup erM;
    public HeadImageView erP;
    public TextView erQ;
    private ALALevelView erY;
    public TextView mName;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.erM = (ViewGroup) view.findViewById(a.g.item_view);
        this.erP = (HeadImageView) view.findViewById(a.g.photo);
        this.erP.setIsRound(true);
        this.erP.setAutoChangeStyle(false);
        this.erP.setClickable(false);
        this.mName = (TextView) view.findViewById(a.g.name);
        this.erQ = (TextView) view.findViewById(a.g.intro);
        this.erY = (ALALevelView) view.findViewById(a.g.level_view);
    }

    public void a(int i, com.baidu.live.data.f fVar) {
        if (fVar != null && fVar.VP != null) {
            this.erM.setTag(Integer.valueOf(i));
            this.erY.setData(fVar.VP);
            int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds7);
            int dimensionPixelSize2 = this.mRootView.getResources().getDimensionPixelSize(a.e.sdk_tbds12);
            this.erY.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.mName.setText(fVar.VP.userName);
            if (!TextUtils.isEmpty(fVar.VP.description)) {
                this.erQ.setText(fVar.VP.description);
            } else {
                this.erQ.setText(this.mRootView.getResources().getString(a.i.empty_intro));
            }
            k.a(this.erP, fVar.VP.portrait, true, false);
            this.erM.setBackgroundResource(a.f.sdk_list_item_selector_black);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.erM != null && onClickListener != null) {
            this.erM.setOnClickListener(onClickListener);
        }
    }
}

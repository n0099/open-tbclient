package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class g {
    private TbImageView fAI;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.fAI = (TbImageView) this.mRootView.findViewById(a.g.iv_scene_avatar);
        this.fAI.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fAI.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fAI.setIsRound(true);
        this.fAI.setAutoChangeStyle(false);
        this.fAI.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fAI.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.g.ll_content_container);
    }

    public void a(x xVar, boolean z, boolean z2) {
        if (xVar != null) {
            this.fAI.startLoad(xVar.imageUrl, 10, false);
            this.mTextView.setText(xVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, xVar.startColor, xVar.endColor, z2);
        }
    }
}

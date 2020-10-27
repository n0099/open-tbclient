package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.ae;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class g {
    private TbImageView fZA;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.fZA = (TbImageView) this.mRootView.findViewById(a.g.iv_scene_avatar);
        this.fZA.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fZA.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fZA.setIsRound(true);
        this.fZA.setAutoChangeStyle(false);
        this.fZA.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fZA.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.g.ll_content_container);
    }

    public void a(ae aeVar, boolean z, boolean z2) {
        if (aeVar != null) {
            this.fZA.startLoad(aeVar.imageUrl, 10, false);
            this.mTextView.setText(aeVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, aeVar.startColor, aeVar.endColor, z2);
        }
    }
}

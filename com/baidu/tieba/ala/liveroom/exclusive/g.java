package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class g {
    private TbImageView gnh;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.gnh = (TbImageView) this.mRootView.findViewById(a.f.iv_scene_avatar);
        this.gnh.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gnh.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gnh.setIsRound(true);
        this.gnh.setAutoChangeStyle(false);
        this.gnh.setScaleType(ImageView.ScaleType.FIT_XY);
        this.gnh.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.f.ll_content_container);
    }

    public void a(ah ahVar, boolean z, boolean z2) {
        if (ahVar != null) {
            this.gnh.startLoad(ahVar.imageUrl, 10, false);
            this.mTextView.setText(ahVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, ahVar.startColor, ahVar.endColor, z2);
        }
    }
}

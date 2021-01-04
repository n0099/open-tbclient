package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.aj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class g {
    private TbImageView gxG;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.gxG = (TbImageView) this.mRootView.findViewById(a.f.iv_scene_avatar);
        this.gxG.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gxG.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gxG.setIsRound(true);
        this.gxG.setAutoChangeStyle(false);
        this.gxG.setScaleType(ImageView.ScaleType.FIT_XY);
        this.gxG.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.f.ll_content_container);
    }

    public void a(aj ajVar, boolean z, boolean z2) {
        if (ajVar != null) {
            this.gxG.startLoad(ajVar.imageUrl, 10, false);
            this.mTextView.setText(ajVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, ajVar.startColor, ajVar.endColor, z2);
        }
    }
}

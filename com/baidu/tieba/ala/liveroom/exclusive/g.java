package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class g {
    private TbImageView fQh;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.fQh = (TbImageView) this.mRootView.findViewById(a.g.iv_scene_avatar);
        this.fQh.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fQh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fQh.setIsRound(true);
        this.fQh.setAutoChangeStyle(false);
        this.fQh.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fQh.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.g.ll_content_container);
    }

    public void a(ac acVar, boolean z, boolean z2) {
        if (acVar != null) {
            this.fQh.startLoad(acVar.imageUrl, 10, false);
            this.mTextView.setText(acVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, acVar.startColor, acVar.endColor, z2);
        }
    }
}

package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.af;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class g {
    private TbImageView gfs;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.gfs = (TbImageView) this.mRootView.findViewById(a.f.iv_scene_avatar);
        this.gfs.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gfs.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gfs.setIsRound(true);
        this.gfs.setAutoChangeStyle(false);
        this.gfs.setScaleType(ImageView.ScaleType.FIT_XY);
        this.gfs.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.f.ll_content_container);
    }

    public void a(af afVar, boolean z, boolean z2) {
        if (afVar != null) {
            this.gfs.startLoad(afVar.imageUrl, 10, false);
            this.mTextView.setText(afVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, afVar.startColor, afVar.endColor, z2);
        }
    }
}

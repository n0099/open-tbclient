package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class g {
    private TbImageView gvJ;
    private ViewGroup mContentView;
    private Context mContext;
    public View mRootView;
    private TextView mTextView;

    public g(View view) {
        this.mContext = view.getContext();
        this.mRootView = view;
        this.gvJ = (TbImageView) this.mRootView.findViewById(a.f.iv_scene_avatar);
        this.gvJ.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
        this.gvJ.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.gvJ.setIsRound(true);
        this.gvJ.setAutoChangeStyle(false);
        this.gvJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.gvJ.setDrawBorder(false);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.tv_scene_name);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.f.ll_content_container);
    }

    public void a(an anVar, boolean z, boolean z2) {
        if (anVar != null) {
            this.gvJ.startLoad(anVar.imageUrl, 10, false);
            this.mTextView.setText(anVar.getLabelName());
            c.a(this.mContext, this.mContentView, z, anVar.startColor, anVar.endColor, z2);
        }
    }
}

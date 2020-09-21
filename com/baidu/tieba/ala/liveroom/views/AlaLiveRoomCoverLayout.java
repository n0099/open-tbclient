package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class AlaLiveRoomCoverLayout extends FrameLayout {
    public TbImageView gPh;

    public AlaLiveRoomCoverLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_liveroom_cover_layout, (ViewGroup) this, true);
        this.gPh = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.gPh.setAutoChangeStyle(false);
        this.gPh.setDefaultResource(a.f.bg_live_cover_default);
        this.gPh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}

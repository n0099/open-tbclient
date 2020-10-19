package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class AlaLiveRoomCoverLayout extends FrameLayout {
    public SimpleDraweeView hee;

    public AlaLiveRoomCoverLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_liveroom_cover_layout, (ViewGroup) this, true);
        this.hee = (SimpleDraweeView) findViewById(a.g.ala_liveroom_background_img);
        this.hee.getHierarchy().a(a.f.bg_live_cover_default, p.b.nOZ);
    }
}

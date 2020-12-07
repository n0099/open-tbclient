package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.drawable.p;
/* loaded from: classes4.dex */
public class AlaLiveRoomCoverLayout extends FrameLayout {
    public SimpleDraweeView hFi;

    public AlaLiveRoomCoverLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_liveroom_cover_layout, (ViewGroup) this, true);
        this.hFi = (SimpleDraweeView) findViewById(a.f.ala_liveroom_background_img);
        this.hFi.getHierarchy().a(a.e.bg_live_cover_default, p.b.pgx);
    }
}

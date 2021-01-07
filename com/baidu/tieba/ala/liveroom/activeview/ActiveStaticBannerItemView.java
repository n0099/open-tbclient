package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.drawable.p;
/* loaded from: classes11.dex */
public class ActiveStaticBannerItemView extends FrameLayout implements c {
    private a hpr;
    private SimpleDraweeView hps;
    private View hpt;

    public ActiveStaticBannerItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hpr = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, x xVar, p pVar) {
        if (pVar != null) {
            this.hps.setImageURI(pVar.pic_url);
            if (pVar.aJX) {
                this.hpt.setVisibility(0);
            } else {
                this.hpt.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.hpr = null;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_active_view_item, (ViewGroup) this, true);
        this.hps = (SimpleDraweeView) findViewById(a.f.ala_live_active_view_img);
        this.hpt = findViewById(a.f.new_icon);
        com.facebook.drawee.generic.a hierarchy = this.hps.getHierarchy();
        hierarchy.a(a.e.sdk_transparent_bg, p.b.pxO);
        hierarchy.b(a.e.sdk_transparent_bg, p.b.pxO);
        hierarchy.b(p.b.pxK);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveStaticBannerItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActiveStaticBannerItemView.this.hpr != null) {
                    ActiveStaticBannerItemView.this.hpr.ccB();
                }
            }
        });
    }
}

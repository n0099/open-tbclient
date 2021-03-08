package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.data.ab;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.drawable.p;
/* loaded from: classes10.dex */
public class ActiveStaticBannerItemView extends FrameLayout implements c {
    private a hqU;
    private SimpleDraweeView hqV;
    private View hqW;

    public ActiveStaticBannerItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hqU = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, ab abVar, t tVar) {
        if (tVar != null) {
            this.hqV.setImageURI(tVar.pic_url);
            if (tVar.aJg) {
                this.hqW.setVisibility(0);
            } else {
                this.hqW.setVisibility(4);
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
        this.hqU = null;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_active_view_item, (ViewGroup) this, true);
        this.hqV = (SimpleDraweeView) findViewById(a.f.ala_live_active_view_img);
        this.hqW = findViewById(a.f.new_icon);
        com.facebook.drawee.generic.a hierarchy = this.hqV.getHierarchy();
        hierarchy.a(a.e.sdk_transparent_bg, p.b.pGb);
        hierarchy.b(a.e.sdk_transparent_bg, p.b.pGb);
        hierarchy.b(p.b.pFX);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveStaticBannerItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActiveStaticBannerItemView.this.hqU != null) {
                    ActiveStaticBannerItemView.this.hqU.bZT();
                }
            }
        });
    }
}

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
/* loaded from: classes10.dex */
public class ActiveStaticBannerItemView extends FrameLayout implements c {
    private a hkK;
    private SimpleDraweeView hkL;
    private View hkM;

    public ActiveStaticBannerItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hkK = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, x xVar, p pVar) {
        if (pVar != null) {
            this.hkL.setImageURI(pVar.pic_url);
            if (pVar.aFk) {
                this.hkM.setVisibility(0);
            } else {
                this.hkM.setVisibility(4);
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
        this.hkK = null;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_active_view_item, (ViewGroup) this, true);
        this.hkL = (SimpleDraweeView) findViewById(a.f.ala_live_active_view_img);
        this.hkM = findViewById(a.f.new_icon);
        com.facebook.drawee.generic.a hierarchy = this.hkL.getHierarchy();
        hierarchy.a(a.e.sdk_transparent_bg, p.b.ptm);
        hierarchy.b(a.e.sdk_transparent_bg, p.b.ptm);
        hierarchy.b(p.b.pti);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveStaticBannerItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActiveStaticBannerItemView.this.hkK != null) {
                    ActiveStaticBannerItemView.this.hkK.bYJ();
                }
            }
        });
    }
}

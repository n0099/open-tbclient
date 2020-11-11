package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class ActiveStaticBannerItemView extends FrameLayout implements c {
    private a gUI;
    private TbImageView gUJ;
    private View gUK;

    public ActiveStaticBannerItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.gUI = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, w wVar, o oVar) {
        if (oVar != null) {
            this.gUJ.startLoad(oVar.pic_url, 10, false);
            if (oVar.aIz) {
                this.gUK.setVisibility(0);
            } else {
                this.gUK.setVisibility(4);
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
        this.gUI = null;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_active_view_item, (ViewGroup) this, true);
        this.gUJ = (TbImageView) findViewById(a.f.ala_live_active_view_img);
        this.gUK = findViewById(a.f.new_icon);
        this.gUJ.setDefaultErrorResource(0);
        this.gUJ.setDefaultBgResource(a.c.sdk_transparent);
        this.gUJ.setAutoChangeStyle(false);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveStaticBannerItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActiveStaticBannerItemView.this.gUI != null) {
                    ActiveStaticBannerItemView.this.gUI.bWP();
                }
            }
        });
    }
}

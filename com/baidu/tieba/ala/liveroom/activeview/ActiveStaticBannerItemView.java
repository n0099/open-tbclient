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
    private a hdC;
    private TbImageView hdD;
    private View hdE;

    public ActiveStaticBannerItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hdC = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, w wVar, o oVar) {
        if (oVar != null) {
            this.hdD.startLoad(oVar.pic_url, 10, false);
            if (oVar.aJy) {
                this.hdE.setVisibility(0);
            } else {
                this.hdE.setVisibility(4);
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
        this.hdC = null;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_active_view_item, (ViewGroup) this, true);
        this.hdD = (TbImageView) findViewById(a.f.ala_live_active_view_img);
        this.hdE = findViewById(a.f.new_icon);
        this.hdD.setDefaultErrorResource(0);
        this.hdD.setDefaultBgResource(a.c.sdk_transparent);
        this.hdD.setAutoChangeStyle(false);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveStaticBannerItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActiveStaticBannerItemView.this.hdC != null) {
                    ActiveStaticBannerItemView.this.hdC.bZS();
                }
            }
        });
    }
}

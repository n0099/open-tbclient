package com.baidu.tieba.frs.videomiddlepage.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.video.g;
/* loaded from: classes3.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private TextView efw;
    private TextView efx;
    private TextView efy;
    private Runnable mHideRunnable;
    private int mSkinType;

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), e.h.video_network_state_tip, this);
        this.efw = (TextView) findViewById(e.g.play);
        this.efx = (TextView) findViewById(e.g.free_flow);
        this.efx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.efy = (TextView) findViewById(e.g.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean aHO() {
        return (hasAgreeToPlay() || g.bHQ().bHR() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.kX()) ? false : true;
    }

    public void aHP() {
        setVisibility(0);
        this.efw.setVisibility(0);
        this.efx.setVisibility(0);
        this.efy.setVisibility(8);
    }

    public void aHQ() {
        setVisibility(0);
        this.efw.setVisibility(8);
        this.efx.setVisibility(8);
        this.efy.setVisibility(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.mHideRunnable, 3000L);
    }

    public void hide() {
        setVisibility(8);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.efw.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.efw, e.d.cp_cont_i);
            al.i(this.efw, e.f.rectangle_background_alpha80);
            al.h(this.efx, e.d.cp_cont_i);
            al.i(this.efx, e.f.blue_rectangle_background);
            al.h(this.efy, e.d.cp_cont_i);
            al.i(this.efy, e.f.rectangle_background_alpha80);
        }
    }
}

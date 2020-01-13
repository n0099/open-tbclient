package com.baidu.tieba.ala.liveroom.attentionpop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaFollowRemindView extends LinearLayout {
    private TextView eMs;
    private TextView eMt;
    private ImageView eMu;
    private HeadImageView eMv;
    private LinearLayout eMw;
    private View mRootView;
    private TextView mTipView;

    public AlaFollowRemindView(Context context) {
        super(context);
        initView();
    }

    public AlaFollowRemindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaFollowRemindView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mRootView = View.inflate(getContext(), a.h.ala_follow_remind_view_layout, this);
        this.eMs = (TextView) findViewById(a.g.ala_liveroom_follow_remind_attention);
        this.eMv = (HeadImageView) findViewById(a.g.ala_liveroom_follow_remind_image);
        this.eMv.setIsRound(true);
        this.eMv.setAutoChangeStyle(false);
        this.eMt = (TextView) findViewById(a.g.ala_liveroom_follow_remind_hostname);
        this.eMu = (ImageView) findViewById(a.g.ala_liveroom_follow_remind_user_sex);
        this.mTipView = (TextView) findViewById(a.g.ala_liveroom_follow_remind_tip);
        this.eMw = (LinearLayout) findViewById(a.g.ala_liveroom_follow_remind_view);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eMs.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_selector);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eMs.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        } else {
            this.eMs.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.eMw;
    }

    public View getAttentionView() {
        return this.eMs;
    }

    public void setClickCallBack(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
        getAttentionView().setOnClickListener(onClickListener);
    }
}

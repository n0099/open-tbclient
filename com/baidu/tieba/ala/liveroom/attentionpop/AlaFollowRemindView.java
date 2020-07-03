package com.baidu.tieba.ala.liveroom.attentionpop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes3.dex */
public class AlaFollowRemindView extends LinearLayout {
    private TextView fUO;
    private TextView fUP;
    private ImageView fUQ;
    private HeadImageView fUR;
    private LinearLayout fUS;
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
        this.fUO = (TextView) findViewById(a.g.ala_liveroom_follow_remind_attention);
        this.fUR = (HeadImageView) findViewById(a.g.ala_liveroom_follow_remind_image);
        this.fUR.setIsRound(true);
        this.fUR.setAutoChangeStyle(false);
        this.fUP = (TextView) findViewById(a.g.ala_liveroom_follow_remind_hostname);
        this.fUQ = (ImageView) findViewById(a.g.ala_liveroom_follow_remind_user_sex);
        this.mTipView = (TextView) findViewById(a.g.ala_liveroom_follow_remind_tip);
        this.fUS = (LinearLayout) findViewById(a.g.ala_liveroom_follow_remind_view);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fUO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_selector);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fUO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        } else {
            this.fUO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.fUS;
    }

    public View getAttentionView() {
        return this.fUO;
    }

    public void setClickCallBack(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
        getAttentionView().setOnClickListener(onClickListener);
    }
}

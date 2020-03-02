package com.baidu.tieba.ala.liveroom.attentionpop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaFollowRemindView extends LinearLayout {
    private LinearLayout eQA;
    private TextView eQw;
    private TextView eQx;
    private ImageView eQy;
    private HeadImageView eQz;
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
        this.eQw = (TextView) findViewById(a.g.ala_liveroom_follow_remind_attention);
        this.eQz = (HeadImageView) findViewById(a.g.ala_liveroom_follow_remind_image);
        this.eQz.setIsRound(true);
        this.eQz.setAutoChangeStyle(false);
        this.eQx = (TextView) findViewById(a.g.ala_liveroom_follow_remind_hostname);
        this.eQy = (ImageView) findViewById(a.g.ala_liveroom_follow_remind_user_sex);
        this.mTipView = (TextView) findViewById(a.g.ala_liveroom_follow_remind_tip);
        this.eQA = (LinearLayout) findViewById(a.g.ala_liveroom_follow_remind_view);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eQw.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_selector);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eQw.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        } else {
            this.eQw.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.eQA;
    }

    public View getAttentionView() {
        return this.eQw;
    }

    public void setClickCallBack(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
        getAttentionView().setOnClickListener(onClickListener);
    }
}

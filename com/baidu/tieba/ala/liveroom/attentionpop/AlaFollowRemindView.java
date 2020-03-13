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
    private TextView eQJ;
    private TextView eQK;
    private ImageView eQL;
    private HeadImageView eQM;
    private LinearLayout eQN;
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
        this.eQJ = (TextView) findViewById(a.g.ala_liveroom_follow_remind_attention);
        this.eQM = (HeadImageView) findViewById(a.g.ala_liveroom_follow_remind_image);
        this.eQM.setIsRound(true);
        this.eQM.setAutoChangeStyle(false);
        this.eQK = (TextView) findViewById(a.g.ala_liveroom_follow_remind_hostname);
        this.eQL = (ImageView) findViewById(a.g.ala_liveroom_follow_remind_user_sex);
        this.mTipView = (TextView) findViewById(a.g.ala_liveroom_follow_remind_tip);
        this.eQN = (LinearLayout) findViewById(a.g.ala_liveroom_follow_remind_view);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eQJ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_selector);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eQJ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        } else {
            this.eQJ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_selector);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.eQN;
    }

    public View getAttentionView() {
        return this.eQJ;
    }

    public void setClickCallBack(View.OnClickListener onClickListener) {
        this.mRootView.setOnClickListener(onClickListener);
        getAttentionView().setOnClickListener(onClickListener);
    }
}

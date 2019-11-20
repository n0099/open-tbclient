package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation ayO;
    private ImageView cTq;
    private TextView crw;
    private TbImageView dvp;
    private View dvq;
    private HeadImageView dvr;
    private TextView dvs;
    private TextView dvt;
    private TextView dvu;
    private NoActiveStopAlaPlayAnimationView dvv;
    private ProgressBar dvw;
    private FrameLayout dvx;
    private boolean dvy;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.dvy = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvy = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvy = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.dvy = z;
        this.cTq.setVisibility(8);
        this.dvw.setVisibility(8);
        this.dvv.setVisibility(8);
        this.dvv.setFromSpecialForum(this.dvy);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ayO = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.dvx = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.dvp = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.dvp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dvp.setAutoChangeStyle(false);
        this.dvq = this.mRootView.findViewById(R.id.head_root_view);
        this.dvq.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.dvr = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.crw = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.dvs = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.dvr.setIsRound(true);
        this.dvr.setAutoChangeStyle(false);
        this.dvt = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.dvu = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.cTq = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.dvv = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.dvv.setFromSpecialForum(this.dvy);
        am.setImageResource(this.cTq, R.drawable.btn_icon_play_live_on_n);
        this.dvw = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        ask();
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiX() != null && bhVar.aiE() != null) {
            AlaInfoData aiX = bhVar.aiX();
            this.dvp.startLoad(aiX.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aiX.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.dvq.setVisibility(0);
                this.dvr.startLoad(alaUserInfoData.portrait, 10, false);
                this.crw.setText(bhVar.aiE().getName_show());
                this.dvs.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.dvq.setVisibility(8);
            }
            this.dvt.setText(bhVar.getTitle());
            this.dvu.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aiX.audience_count)));
            if (!this.dvy) {
                this.dvv.startPlayAnimation();
            }
        }
    }

    public void ask() {
        am.setViewTextColor(this.dvu, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.crw, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dvs, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dvt, (int) R.color.cp_cont_a);
    }

    public void aIX() {
        if (this.dvy) {
            this.cTq.setVisibility(8);
            this.dvw.setVisibility(8);
            this.dvv.setVisibility(8);
        }
        this.dvx.startAnimation(this.ayO);
    }

    public void aIY() {
        this.dvx.clearAnimation();
    }

    public void aIZ() {
        if (!this.dvy) {
            this.dvv.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.dvy) {
            this.dvv.vy();
        }
        this.dvx.clearAnimation();
    }
}

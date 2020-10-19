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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation bKh;
    private TextView eig;
    private TbImageView fST;
    private View fSU;
    private HeadImageView fSV;
    private TextView fSW;
    private TextView fSX;
    private TextView fSY;
    private NoActiveStopAlaPlayAnimationView fSZ;
    private ProgressBar fTa;
    private FrameLayout fTb;
    private boolean fTc;
    private ImageView frj;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fTc = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fTc = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTc = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fTc = z;
        this.frj.setVisibility(8);
        this.fTa.setVisibility(8);
        this.fSZ.setVisibility(8);
        this.fSZ.setFromSpecialForum(this.fTc);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bKh = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fTb = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fST = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fST.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fST.setAutoChangeStyle(false);
        this.fSU = this.mRootView.findViewById(R.id.head_root_view);
        this.fSU.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fSV = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eig = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fSW = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fSV.setIsRound(true);
        this.fSV.setAutoChangeStyle(false);
        this.fSX = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fSY = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.frj = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fSZ = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fSZ.setFromSpecialForum(this.fTc);
        ap.setImageResource(this.frj, R.drawable.btn_icon_play_live_on_n);
        this.fTa = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        btm();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.biB() != null && bwVar.bih() != null) {
            AlaInfoData biB = bwVar.biB();
            this.fST.startLoad(biB.cover, 10, false);
            AlaUserInfoData alaUserInfoData = biB.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fSU.setVisibility(0);
                this.fSV.startLoad(alaUserInfoData.portrait, 10, false);
                this.eig.setText(bwVar.bih().getName_show());
                this.fSW.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fSU.setVisibility(8);
            }
            this.fSX.setText(bwVar.getTitle());
            this.fSY.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(biB.audience_count)));
            if (!this.fTc) {
                this.fSZ.startPlayAnimation();
            }
        }
    }

    public void btm() {
        ap.setViewTextColor(this.fSY, R.color.cp_cont_a);
        ap.setViewTextColor(this.eig, R.color.cp_cont_a);
        ap.setViewTextColor(this.fSW, R.color.cp_cont_a);
        ap.setViewTextColor(this.fSX, R.color.cp_cont_a);
    }

    public void bJJ() {
        if (this.fTc) {
            this.frj.setVisibility(8);
            this.fTa.setVisibility(8);
            this.fSZ.setVisibility(8);
        }
        this.fTb.startAnimation(this.bKh);
    }

    public void bJK() {
        this.fTb.clearAnimation();
    }

    public void bJL() {
        if (!this.fTc) {
            this.fSZ.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fTc) {
            this.fSZ.PU();
        }
        this.fTb.clearAnimation();
    }
}

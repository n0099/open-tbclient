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
    private Animation bAi;
    private TextView dTU;
    private HeadImageView fDA;
    private TextView fDB;
    private TextView fDC;
    private TextView fDD;
    private NoActiveStopAlaPlayAnimationView fDE;
    private ProgressBar fDF;
    private FrameLayout fDG;
    private boolean fDH;
    private TbImageView fDy;
    private View fDz;
    private ImageView fcc;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fDH = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDH = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDH = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fDH = z;
        this.fcc.setVisibility(8);
        this.fDF.setVisibility(8);
        this.fDE.setVisibility(8);
        this.fDE.setFromSpecialForum(this.fDH);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bAi = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fDG = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fDy = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fDy.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fDy.setAutoChangeStyle(false);
        this.fDz = this.mRootView.findViewById(R.id.head_root_view);
        this.fDz.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fDA = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dTU = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fDB = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fDA.setIsRound(true);
        this.fDA.setAutoChangeStyle(false);
        this.fDC = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fDD = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fcc = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fDE = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fDE.setFromSpecialForum(this.fDH);
        ap.setImageResource(this.fcc, R.drawable.btn_icon_play_live_on_n);
        this.fDF = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bpI();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beY() != null && bwVar.beE() != null) {
            AlaInfoData beY = bwVar.beY();
            this.fDy.startLoad(beY.cover, 10, false);
            AlaUserInfoData alaUserInfoData = beY.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fDz.setVisibility(0);
                this.fDA.startLoad(alaUserInfoData.portrait, 10, false);
                this.dTU.setText(bwVar.beE().getName_show());
                this.fDB.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fDz.setVisibility(8);
            }
            this.fDC.setText(bwVar.getTitle());
            this.fDD.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(beY.audience_count)));
            if (!this.fDH) {
                this.fDE.startPlayAnimation();
            }
        }
    }

    public void bpI() {
        ap.setViewTextColor(this.fDD, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.dTU, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fDB, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fDC, (int) R.color.cp_cont_a);
    }

    public void bFH() {
        if (this.fDH) {
            this.fcc.setVisibility(8);
            this.fDF.setVisibility(8);
            this.fDE.setVisibility(8);
        }
        this.fDG.startAnimation(this.bAi);
    }

    public void bFI() {
        this.fDG.clearAnimation();
    }

    public void bFJ() {
        if (!this.fDH) {
            this.fDE.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fDH) {
            this.fDE.Om();
        }
        this.fDG.clearAnimation();
    }
}

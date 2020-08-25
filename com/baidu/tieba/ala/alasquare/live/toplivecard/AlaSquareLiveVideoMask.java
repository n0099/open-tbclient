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
    private Animation bAf;
    private TextView dTQ;
    private NoActiveStopAlaPlayAnimationView fDA;
    private ProgressBar fDB;
    private FrameLayout fDC;
    private boolean fDD;
    private TbImageView fDu;
    private View fDv;
    private HeadImageView fDw;
    private TextView fDx;
    private TextView fDy;
    private TextView fDz;
    private ImageView fbY;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fDD = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDD = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDD = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fDD = z;
        this.fbY.setVisibility(8);
        this.fDB.setVisibility(8);
        this.fDA.setVisibility(8);
        this.fDA.setFromSpecialForum(this.fDD);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bAf = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fDC = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fDu = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fDu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fDu.setAutoChangeStyle(false);
        this.fDv = this.mRootView.findViewById(R.id.head_root_view);
        this.fDv.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fDw = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dTQ = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fDx = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fDw.setIsRound(true);
        this.fDw.setAutoChangeStyle(false);
        this.fDy = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fDz = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fbY = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fDA = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fDA.setFromSpecialForum(this.fDD);
        ap.setImageResource(this.fbY, R.drawable.btn_icon_play_live_on_n);
        this.fDB = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bpH();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beY() != null && bwVar.beE() != null) {
            AlaInfoData beY = bwVar.beY();
            this.fDu.startLoad(beY.cover, 10, false);
            AlaUserInfoData alaUserInfoData = beY.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fDv.setVisibility(0);
                this.fDw.startLoad(alaUserInfoData.portrait, 10, false);
                this.dTQ.setText(bwVar.beE().getName_show());
                this.fDx.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fDv.setVisibility(8);
            }
            this.fDy.setText(bwVar.getTitle());
            this.fDz.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(beY.audience_count)));
            if (!this.fDD) {
                this.fDA.startPlayAnimation();
            }
        }
    }

    public void bpH() {
        ap.setViewTextColor(this.fDz, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.dTQ, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fDx, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fDy, (int) R.color.cp_cont_a);
    }

    public void bFG() {
        if (this.fDD) {
            this.fbY.setVisibility(8);
            this.fDB.setVisibility(8);
            this.fDA.setVisibility(8);
        }
        this.fDC.startAnimation(this.bAf);
    }

    public void bFH() {
        this.fDC.clearAnimation();
    }

    public void bFI() {
        if (!this.fDD) {
            this.fDA.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fDD) {
            this.fDA.Om();
        }
        this.fDC.clearAnimation();
    }
}

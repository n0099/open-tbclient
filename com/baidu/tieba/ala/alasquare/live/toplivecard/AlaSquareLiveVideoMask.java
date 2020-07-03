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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation btX;
    private TextView dEL;
    private ImageView eKW;
    private TbImageView fmQ;
    private View fmR;
    private HeadImageView fmS;
    private TextView fmT;
    private TextView fmU;
    private TextView fmV;
    private NoActiveStopAlaPlayAnimationView fmW;
    private ProgressBar fmX;
    private FrameLayout fmY;
    private boolean fmZ;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fmZ = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmZ = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmZ = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fmZ = z;
        this.eKW.setVisibility(8);
        this.fmX.setVisibility(8);
        this.fmW.setVisibility(8);
        this.fmW.setFromSpecialForum(this.fmZ);
    }

    private void init(Context context) {
        this.mContext = context;
        this.btX = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fmY = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fmQ = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fmQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fmQ.setAutoChangeStyle(false);
        this.fmR = this.mRootView.findViewById(R.id.head_root_view);
        this.fmR.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fmS = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dEL = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fmT = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fmS.setIsRound(true);
        this.fmS.setAutoChangeStyle(false);
        this.fmU = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fmV = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eKW = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fmW = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fmW.setFromSpecialForum(this.fmZ);
        an.setImageResource(this.eKW, R.drawable.btn_icon_play_live_on_n);
        this.fmX = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bdo();
    }

    public void setData(bu buVar) {
        if (buVar != null && buVar.aSJ() != null && buVar.aSp() != null) {
            AlaInfoData aSJ = buVar.aSJ();
            this.fmQ.startLoad(aSJ.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aSJ.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fmR.setVisibility(0);
                this.fmS.startLoad(alaUserInfoData.portrait, 10, false);
                this.dEL.setText(buVar.aSp().getName_show());
                this.fmT.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fmR.setVisibility(8);
            }
            this.fmU.setText(buVar.getTitle());
            this.fmV.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aSJ.audience_count)));
            if (!this.fmZ) {
                this.fmW.startPlayAnimation();
            }
        }
    }

    public void bdo() {
        an.setViewTextColor(this.fmV, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.dEL, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.fmT, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.fmU, (int) R.color.cp_cont_a);
    }

    public void btx() {
        if (this.fmZ) {
            this.eKW.setVisibility(8);
            this.fmX.setVisibility(8);
            this.fmW.setVisibility(8);
        }
        this.fmY.startAnimation(this.btX);
    }

    public void bty() {
        this.fmY.clearAnimation();
    }

    public void btz() {
        if (!this.fmZ) {
            this.fmW.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fmZ) {
            this.fmW.In();
        }
        this.fmY.clearAnimation();
    }
}

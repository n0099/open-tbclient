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
    private Animation bYm;
    private TextView ewx;
    private ImageView fFx;
    private TbImageView giM;
    private View giN;
    private HeadImageView giO;
    private TextView giP;
    private TextView giQ;
    private TextView giR;
    private NoActiveStopAlaPlayAnimationView giS;
    private ProgressBar giT;
    private FrameLayout giU;
    private boolean giV;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.giV = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.giV = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.giV = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.giV = z;
        this.fFx.setVisibility(8);
        this.giT.setVisibility(8);
        this.giS.setVisibility(8);
        this.giS.setFromSpecialForum(this.giV);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bYm = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.giU = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.giM = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.giM.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.giM.setAutoChangeStyle(false);
        this.giN = this.mRootView.findViewById(R.id.head_root_view);
        this.giN.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.giO = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.ewx = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.giP = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.giO.setIsRound(true);
        this.giO.setAutoChangeStyle(false);
        this.giQ = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.giR = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fFx = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.giS = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.giS.setFromSpecialForum(this.giV);
        ap.setImageResource(this.fFx, R.drawable.btn_icon_play_live_on_n);
        this.giT = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bxE();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bmU() != null && bwVar.bmA() != null) {
            AlaInfoData bmU = bwVar.bmU();
            this.giM.startLoad(bmU.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bmU.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.giN.setVisibility(0);
                this.giO.startLoad(alaUserInfoData.portrait, 10, false);
                this.ewx.setText(bwVar.bmA().getName_show());
                this.giP.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.giN.setVisibility(8);
            }
            this.giQ.setText(bwVar.getTitle());
            this.giR.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bmU.audience_count)));
            if (!this.giV) {
                this.giS.startPlayAnimation();
            }
        }
    }

    public void bxE() {
        ap.setViewTextColor(this.giR, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.ewx, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.giP, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.giQ, (int) R.color.cp_cont_a);
    }

    public void bOL() {
        if (this.giV) {
            this.fFx.setVisibility(8);
            this.giT.setVisibility(8);
            this.giS.setVisibility(8);
        }
        this.giU.startAnimation(this.bYm);
    }

    public void bOM() {
        this.giU.clearAnimation();
    }

    public void bON() {
        if (!this.giV) {
            this.giS.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.giV) {
            this.giS.Tx();
        }
        this.giU.clearAnimation();
    }
}

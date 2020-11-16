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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation bWC;
    private TextView euO;
    private ImageView fEZ;
    private ProgressBar giA;
    private FrameLayout giB;
    private boolean giC;
    private TbImageView git;
    private View giu;
    private HeadImageView giv;
    private TextView giw;
    private TextView gix;
    private TextView giy;
    private NoActiveStopAlaPlayAnimationView giz;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.giC = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.giC = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.giC = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.giC = z;
        this.fEZ.setVisibility(8);
        this.giA.setVisibility(8);
        this.giz.setVisibility(8);
        this.giz.setFromSpecialForum(this.giC);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bWC = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.giB = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.git = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.git.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.git.setAutoChangeStyle(false);
        this.giu = this.mRootView.findViewById(R.id.head_root_view);
        this.giu.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.giv = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.euO = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.giw = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.giv.setIsRound(true);
        this.giv.setAutoChangeStyle(false);
        this.gix = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.giy = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fEZ = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.giz = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.giz.setFromSpecialForum(this.giC);
        ap.setImageResource(this.fEZ, R.drawable.btn_icon_play_live_on_n);
        this.giA = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bwU();
    }

    public void setData(bx bxVar) {
        if (bxVar != null && bxVar.blW() != null && bxVar.blC() != null) {
            AlaInfoData blW = bxVar.blW();
            this.git.startLoad(blW.cover, 10, false);
            AlaUserInfoData alaUserInfoData = blW.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.giu.setVisibility(0);
                this.giv.startLoad(alaUserInfoData.portrait, 10, false);
                this.euO.setText(bxVar.blC().getName_show());
                this.giw.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.giu.setVisibility(8);
            }
            this.gix.setText(bxVar.getTitle());
            this.giy.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(blW.audience_count)));
            if (!this.giC) {
                this.giz.startPlayAnimation();
            }
        }
    }

    public void bwU() {
        ap.setViewTextColor(this.giy, R.color.CAM_X0101);
        ap.setViewTextColor(this.euO, R.color.CAM_X0101);
        ap.setViewTextColor(this.giw, R.color.CAM_X0101);
        ap.setViewTextColor(this.gix, R.color.CAM_X0101);
    }

    public void bOe() {
        if (this.giC) {
            this.fEZ.setVisibility(8);
            this.giA.setVisibility(8);
            this.giz.setVisibility(8);
        }
        this.giB.startAnimation(this.bWC);
    }

    public void bOf() {
        this.giB.clearAnimation();
    }

    public void bOg() {
        if (!this.giC) {
            this.giz.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.giC) {
            this.giz.SO();
        }
        this.giB.clearAnimation();
    }
}

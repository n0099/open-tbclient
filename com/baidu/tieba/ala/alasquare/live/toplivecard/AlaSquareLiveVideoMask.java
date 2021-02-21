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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation chX;
    private TextView eIO;
    private ImageView fTX;
    private NoActiveStopAlaPlayAnimationView gAa;
    private ProgressBar gAb;
    private FrameLayout gAc;
    private boolean gAd;
    private TbImageView gzU;
    private View gzV;
    private HeadImageView gzW;
    private TextView gzX;
    private TextView gzY;
    private TextView gzZ;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gAd = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAd = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAd = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gAd = z;
        this.fTX.setVisibility(8);
        this.gAb.setVisibility(8);
        this.gAa.setVisibility(8);
        this.gAa.setFromSpecialForum(this.gAd);
    }

    private void init(Context context) {
        this.mContext = context;
        this.chX = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gAc = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gzU = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gzU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gzU.setAutoChangeStyle(false);
        this.gzV = this.mRootView.findViewById(R.id.head_root_view);
        this.gzV.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gzW = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eIO = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gzX = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gzW.setIsRound(true);
        this.gzW.setAutoChangeStyle(false);
        this.gzY = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gzZ = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fTX = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gAa = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gAa.setFromSpecialForum(this.gAd);
        ap.setImageResource(this.fTX, R.drawable.btn_icon_play_live_on_n);
        this.gAb = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bzn();
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boj() != null && cbVar.bnQ() != null) {
            AlaInfoData boj = cbVar.boj();
            this.gzU.startLoad(boj.cover, 10, false);
            AlaUserInfoData alaUserInfoData = boj.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gzV.setVisibility(0);
                this.gzW.startLoad(alaUserInfoData.portrait, 10, false);
                this.eIO.setText(cbVar.bnQ().getName_show());
                this.gzX.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gzV.setVisibility(8);
            }
            this.gzY.setText(cbVar.getTitle());
            this.gzZ.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(boj.audience_count)));
            if (!this.gAd) {
                this.gAa.startPlayAnimation();
            }
        }
    }

    public void bzn() {
        ap.setViewTextColor(this.gzZ, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
        ap.setViewTextColor(this.gzX, R.color.CAM_X0101);
        ap.setViewTextColor(this.gzY, R.color.CAM_X0101);
    }

    public void bRm() {
        if (this.gAd) {
            this.fTX.setVisibility(8);
            this.gAb.setVisibility(8);
            this.gAa.setVisibility(8);
        }
        this.gAc.startAnimation(this.chX);
    }

    public void bRn() {
        this.gAc.clearAnimation();
    }

    public void bRo() {
        if (!this.gAd) {
            this.gAa.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gAd) {
            this.gAa.Uf();
        }
        this.gAc.clearAnimation();
    }
}

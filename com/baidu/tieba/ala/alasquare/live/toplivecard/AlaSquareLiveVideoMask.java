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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation bhz;
    private TextView cBd;
    private TbImageView eOO;
    private View eOP;
    private HeadImageView eOQ;
    private TextView eOR;
    private TextView eOS;
    private TextView eOT;
    private NoActiveStopAlaPlayAnimationView eOU;
    private ProgressBar eOV;
    private FrameLayout eOW;
    private boolean eOX;
    private ImageView emx;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.eOX = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOX = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOX = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.eOX = z;
        this.emx.setVisibility(8);
        this.eOV.setVisibility(8);
        this.eOU.setVisibility(8);
        this.eOU.setFromSpecialForum(this.eOX);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bhz = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.eOW = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.eOO = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.eOO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eOO.setAutoChangeStyle(false);
        this.eOP = this.mRootView.findViewById(R.id.head_root_view);
        this.eOP.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.eOQ = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cBd = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.eOR = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.eOQ.setIsRound(true);
        this.eOQ.setAutoChangeStyle(false);
        this.eOS = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.eOT = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.emx = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.eOU = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eOU.setFromSpecialForum(this.eOX);
        am.setImageResource(this.emx, R.drawable.btn_icon_play_live_on_n);
        this.eOV = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aVb();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKV() != null && bjVar.aKC() != null) {
            AlaInfoData aKV = bjVar.aKV();
            this.eOO.startLoad(aKV.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aKV.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.eOP.setVisibility(0);
                this.eOQ.startLoad(alaUserInfoData.portrait, 10, false);
                this.cBd.setText(bjVar.aKC().getName_show());
                this.eOR.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.eOP.setVisibility(8);
            }
            this.eOS.setText(bjVar.getTitle());
            this.eOT.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aKV.audience_count)));
            if (!this.eOX) {
                this.eOU.startPlayAnimation();
            }
        }
    }

    public void aVb() {
        am.setViewTextColor(this.eOT, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cBd, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eOR, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eOS, (int) R.color.cp_cont_a);
    }

    public void blc() {
        if (this.eOX) {
            this.emx.setVisibility(8);
            this.eOV.setVisibility(8);
            this.eOU.setVisibility(8);
        }
        this.eOW.startAnimation(this.bhz);
    }

    public void bld() {
        this.eOW.clearAnimation();
    }

    public void ble() {
        if (!this.eOX) {
            this.eOU.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.eOX) {
            this.eOU.Fj();
        }
        this.eOW.clearAnimation();
    }
}

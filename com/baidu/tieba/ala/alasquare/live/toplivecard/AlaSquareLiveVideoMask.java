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
    private Animation bSC;
    private TextView eqE;
    private ImageView fzH;
    private TbImageView gcW;
    private View gcX;
    private HeadImageView gcY;
    private TextView gcZ;
    private TextView gda;
    private TextView gdb;
    private NoActiveStopAlaPlayAnimationView gdc;
    private ProgressBar gdd;
    private FrameLayout gde;
    private boolean gdf;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gdf = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdf = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdf = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gdf = z;
        this.fzH.setVisibility(8);
        this.gdd.setVisibility(8);
        this.gdc.setVisibility(8);
        this.gdc.setFromSpecialForum(this.gdf);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bSC = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gde = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gcW = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gcW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gcW.setAutoChangeStyle(false);
        this.gcX = this.mRootView.findViewById(R.id.head_root_view);
        this.gcX.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gcY = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eqE = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gcZ = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gcY.setIsRound(true);
        this.gcY.setAutoChangeStyle(false);
        this.gda = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gdb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fzH = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gdc = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gdc.setFromSpecialForum(this.gdf);
        ap.setImageResource(this.fzH, R.drawable.btn_icon_play_live_on_n);
        this.gdd = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bvf();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bku() != null && bwVar.bka() != null) {
            AlaInfoData bku = bwVar.bku();
            this.gcW.startLoad(bku.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bku.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gcX.setVisibility(0);
                this.gcY.startLoad(alaUserInfoData.portrait, 10, false);
                this.eqE.setText(bwVar.bka().getName_show());
                this.gcZ.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gcX.setVisibility(8);
            }
            this.gda.setText(bwVar.getTitle());
            this.gdb.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bku.audience_count)));
            if (!this.gdf) {
                this.gdc.startPlayAnimation();
            }
        }
    }

    public void bvf() {
        ap.setViewTextColor(this.gdb, R.color.cp_cont_a);
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a);
        ap.setViewTextColor(this.gcZ, R.color.cp_cont_a);
        ap.setViewTextColor(this.gda, R.color.cp_cont_a);
    }

    public void bMl() {
        if (this.gdf) {
            this.fzH.setVisibility(8);
            this.gdd.setVisibility(8);
            this.gdc.setVisibility(8);
        }
        this.gde.startAnimation(this.bSC);
    }

    public void bMm() {
        this.gde.clearAnimation();
    }

    public void bMn() {
        if (!this.gdf) {
            this.gdc.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gdf) {
            this.gdc.QP();
        }
        this.gde.clearAnimation();
    }
}

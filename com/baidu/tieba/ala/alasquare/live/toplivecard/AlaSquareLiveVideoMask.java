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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation buu;
    private TextView dKI;
    private ImageView eRs;
    private TbImageView fsa;
    private View fsb;
    private HeadImageView fsc;
    private TextView fsd;
    private TextView fse;
    private TextView fsf;
    private NoActiveStopAlaPlayAnimationView fsg;
    private ProgressBar fsh;
    private FrameLayout fsi;
    private boolean fsj;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fsj = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsj = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fsj = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fsj = z;
        this.eRs.setVisibility(8);
        this.fsh.setVisibility(8);
        this.fsg.setVisibility(8);
        this.fsg.setFromSpecialForum(this.fsj);
    }

    private void init(Context context) {
        this.mContext = context;
        this.buu = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fsi = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fsa = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fsa.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fsa.setAutoChangeStyle(false);
        this.fsb = this.mRootView.findViewById(R.id.head_root_view);
        this.fsb.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fsc = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dKI = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fsd = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fsc.setIsRound(true);
        this.fsc.setAutoChangeStyle(false);
        this.fse = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fsf = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRs = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fsg = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fsg.setFromSpecialForum(this.fsj);
        ao.setImageResource(this.eRs, R.drawable.btn_icon_play_live_on_n);
        this.fsh = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bgV();
    }

    public void setData(bv bvVar) {
        if (bvVar != null && bvVar.aWF() != null && bvVar.aWl() != null) {
            AlaInfoData aWF = bvVar.aWF();
            this.fsa.startLoad(aWF.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aWF.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fsb.setVisibility(0);
                this.fsc.startLoad(alaUserInfoData.portrait, 10, false);
                this.dKI.setText(bvVar.aWl().getName_show());
                this.fsd.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fsb.setVisibility(8);
            }
            this.fse.setText(bvVar.getTitle());
            this.fsf.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aWF.audience_count)));
            if (!this.fsj) {
                this.fsg.startPlayAnimation();
            }
        }
    }

    public void bgV() {
        ao.setViewTextColor(this.fsf, R.color.cp_cont_a);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a);
        ao.setViewTextColor(this.fsd, R.color.cp_cont_a);
        ao.setViewTextColor(this.fse, R.color.cp_cont_a);
    }

    public void bwH() {
        if (this.fsj) {
            this.eRs.setVisibility(8);
            this.fsh.setVisibility(8);
            this.fsg.setVisibility(8);
        }
        this.fsi.startAnimation(this.buu);
    }

    public void bwI() {
        this.fsi.clearAnimation();
    }

    public void bwJ() {
        if (!this.fsj) {
            this.fsg.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fsj) {
            this.fsg.It();
        }
        this.fsi.clearAnimation();
    }
}

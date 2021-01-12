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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation cdP;
    private TextView eGI;
    private ImageView fRI;
    private TbImageView gwW;
    private View gwX;
    private HeadImageView gwY;
    private TextView gwZ;
    private TextView gxa;
    private TextView gxb;
    private NoActiveStopAlaPlayAnimationView gxc;
    private ProgressBar gxd;
    private FrameLayout gxe;
    private boolean gxf;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gxf = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxf = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxf = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gxf = z;
        this.fRI.setVisibility(8);
        this.gxd.setVisibility(8);
        this.gxc.setVisibility(8);
        this.gxc.setFromSpecialForum(this.gxf);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cdP = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gxe = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gwW = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gwW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gwW.setAutoChangeStyle(false);
        this.gwX = this.mRootView.findViewById(R.id.head_root_view);
        this.gwX.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gwY = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eGI = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gwZ = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gwY.setIsRound(true);
        this.gwY.setAutoChangeStyle(false);
        this.gxa = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gxb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fRI = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gxc = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gxc.setFromSpecialForum(this.gxf);
        ao.setImageResource(this.fRI, R.drawable.btn_icon_play_live_on_n);
        this.gxd = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        byV();
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.bnQ() != null && bzVar.bnx() != null) {
            AlaInfoData bnQ = bzVar.bnQ();
            this.gwW.startLoad(bnQ.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bnQ.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gwX.setVisibility(0);
                this.gwY.startLoad(alaUserInfoData.portrait, 10, false);
                this.eGI.setText(bzVar.bnx().getName_show());
                this.gwZ.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gwX.setVisibility(8);
            }
            this.gxa.setText(bzVar.getTitle());
            this.gxb.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bnQ.audience_count)));
            if (!this.gxf) {
                this.gxc.startPlayAnimation();
            }
        }
    }

    public void byV() {
        ao.setViewTextColor(this.gxb, R.color.CAM_X0101);
        ao.setViewTextColor(this.eGI, R.color.CAM_X0101);
        ao.setViewTextColor(this.gwZ, R.color.CAM_X0101);
        ao.setViewTextColor(this.gxa, R.color.CAM_X0101);
    }

    public void bQB() {
        if (this.gxf) {
            this.fRI.setVisibility(8);
            this.gxd.setVisibility(8);
            this.gxc.setVisibility(8);
        }
        this.gxe.startAnimation(this.cdP);
    }

    public void bQC() {
        this.gxe.clearAnimation();
    }

    public void bQD() {
        if (!this.gxf) {
            this.gxc.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gxf) {
            this.gxc.Sy();
        }
        this.gxe.clearAnimation();
    }
}

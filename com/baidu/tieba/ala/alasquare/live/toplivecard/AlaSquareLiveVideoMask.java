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
/* loaded from: classes9.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation cjy;
    private TextView eKp;
    private ImageView fVx;
    private TbImageView gBD;
    private View gBE;
    private HeadImageView gBF;
    private TextView gBG;
    private TextView gBH;
    private TextView gBI;
    private NoActiveStopAlaPlayAnimationView gBJ;
    private ProgressBar gBK;
    private FrameLayout gBL;
    private boolean gBM;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gBM = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBM = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBM = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gBM = z;
        this.fVx.setVisibility(8);
        this.gBK.setVisibility(8);
        this.gBJ.setVisibility(8);
        this.gBJ.setFromSpecialForum(this.gBM);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cjy = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gBL = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gBD = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gBD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gBD.setAutoChangeStyle(false);
        this.gBE = this.mRootView.findViewById(R.id.head_root_view);
        this.gBE.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gBF = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eKp = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gBG = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gBF.setIsRound(true);
        this.gBF.setAutoChangeStyle(false);
        this.gBH = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gBI = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fVx = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gBJ = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gBJ.setFromSpecialForum(this.gBM);
        ap.setImageResource(this.fVx, R.drawable.btn_icon_play_live_on_n);
        this.gBK = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bzq();
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.bol() != null && cbVar.bnS() != null) {
            AlaInfoData bol = cbVar.bol();
            this.gBD.startLoad(bol.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bol.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gBE.setVisibility(0);
                this.gBF.startLoad(alaUserInfoData.portrait, 10, false);
                this.eKp.setText(cbVar.bnS().getName_show());
                this.gBG.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gBE.setVisibility(8);
            }
            this.gBH.setText(cbVar.getTitle());
            this.gBI.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bol.audience_count)));
            if (!this.gBM) {
                this.gBJ.startPlayAnimation();
            }
        }
    }

    public void bzq() {
        ap.setViewTextColor(this.gBI, R.color.CAM_X0101);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0101);
        ap.setViewTextColor(this.gBG, R.color.CAM_X0101);
        ap.setViewTextColor(this.gBH, R.color.CAM_X0101);
    }

    public void bRs() {
        if (this.gBM) {
            this.fVx.setVisibility(8);
            this.gBK.setVisibility(8);
            this.gBJ.setVisibility(8);
        }
        this.gBL.startAnimation(this.cjy);
    }

    public void bRt() {
        this.gBL.clearAnimation();
    }

    public void bRu() {
        if (!this.gBM) {
            this.gBJ.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gBM) {
            this.gBJ.Ui();
        }
        this.gBL.clearAnimation();
    }
}

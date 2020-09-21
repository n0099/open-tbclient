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
    private Animation bDF;
    private TextView dWe;
    private TbImageView fGK;
    private View fGL;
    private HeadImageView fGM;
    private TextView fGN;
    private TextView fGO;
    private TextView fGP;
    private NoActiveStopAlaPlayAnimationView fGQ;
    private ProgressBar fGR;
    private FrameLayout fGS;
    private boolean fGT;
    private ImageView feV;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fGT = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGT = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGT = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fGT = z;
        this.feV.setVisibility(8);
        this.fGR.setVisibility(8);
        this.fGQ.setVisibility(8);
        this.fGQ.setFromSpecialForum(this.fGT);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bDF = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fGS = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fGK = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fGK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fGK.setAutoChangeStyle(false);
        this.fGL = this.mRootView.findViewById(R.id.head_root_view);
        this.fGL.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fGM = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dWe = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fGN = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fGM.setIsRound(true);
        this.fGM.setAutoChangeStyle(false);
        this.fGO = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fGP = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.feV = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fGQ = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fGQ.setFromSpecialForum(this.fGT);
        ap.setImageResource(this.feV, R.drawable.btn_icon_play_live_on_n);
        this.fGR = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bqC();
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bfS() != null && bwVar.bfy() != null) {
            AlaInfoData bfS = bwVar.bfS();
            this.fGK.startLoad(bfS.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bfS.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fGL.setVisibility(0);
                this.fGM.startLoad(alaUserInfoData.portrait, 10, false);
                this.dWe.setText(bwVar.bfy().getName_show());
                this.fGN.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fGL.setVisibility(8);
            }
            this.fGO.setText(bwVar.getTitle());
            this.fGP.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bfS.audience_count)));
            if (!this.fGT) {
                this.fGQ.startPlayAnimation();
            }
        }
    }

    public void bqC() {
        ap.setViewTextColor(this.fGP, R.color.cp_cont_a);
        ap.setViewTextColor(this.dWe, R.color.cp_cont_a);
        ap.setViewTextColor(this.fGN, R.color.cp_cont_a);
        ap.setViewTextColor(this.fGO, R.color.cp_cont_a);
    }

    public void bGX() {
        if (this.fGT) {
            this.feV.setVisibility(8);
            this.fGR.setVisibility(8);
            this.fGQ.setVisibility(8);
        }
        this.fGS.startAnimation(this.bDF);
    }

    public void bGY() {
        this.fGS.clearAnimation();
    }

    public void bGZ() {
        if (!this.fGT) {
            this.fGQ.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fGT) {
            this.fGQ.OP();
        }
        this.fGS.clearAnimation();
    }
}

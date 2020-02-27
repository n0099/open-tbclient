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
    private Animation aLx;
    private TextView cbJ;
    private ImageView dLX;
    private TbImageView ekF;
    private View ekG;
    private HeadImageView ekH;
    private TextView ekI;
    private TextView ekJ;
    private TextView ekK;
    private NoActiveStopAlaPlayAnimationView ekL;
    private ProgressBar ekM;
    private FrameLayout ekN;
    private boolean ekO;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.ekO = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekO = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ekO = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.ekO = z;
        this.dLX.setVisibility(8);
        this.ekM.setVisibility(8);
        this.ekL.setVisibility(8);
        this.ekL.setFromSpecialForum(this.ekO);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aLx = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.ekN = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.ekF = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.ekF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ekF.setAutoChangeStyle(false);
        this.ekG = this.mRootView.findViewById(R.id.head_root_view);
        this.ekG.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.ekH = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cbJ = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.ekI = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.ekH.setIsRound(true);
        this.ekH.setAutoChangeStyle(false);
        this.ekJ = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.ekK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dLX = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.ekL = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ekL.setFromSpecialForum(this.ekO);
        am.setImageResource(this.dLX, R.drawable.btn_icon_play_live_on_n);
        this.ekM = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aMz();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCF() != null && bjVar.aCm() != null) {
            AlaInfoData aCF = bjVar.aCF();
            this.ekF.startLoad(aCF.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aCF.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.ekG.setVisibility(0);
                this.ekH.startLoad(alaUserInfoData.portrait, 10, false);
                this.cbJ.setText(bjVar.aCm().getName_show());
                this.ekI.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.ekG.setVisibility(8);
            }
            this.ekJ.setText(bjVar.getTitle());
            this.ekK.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aCF.audience_count)));
            if (!this.ekO) {
                this.ekL.startPlayAnimation();
            }
        }
    }

    public void aMz() {
        am.setViewTextColor(this.ekK, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekI, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekJ, (int) R.color.cp_cont_a);
    }

    public void bcg() {
        if (this.ekO) {
            this.dLX.setVisibility(8);
            this.ekM.setVisibility(8);
            this.ekL.setVisibility(8);
        }
        this.ekN.startAnimation(this.aLx);
    }

    public void bch() {
        this.ekN.clearAnimation();
    }

    public void bci() {
        if (!this.ekO) {
            this.ekL.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.ekO) {
            this.ekL.Ad();
        }
        this.ekN.clearAnimation();
    }
}

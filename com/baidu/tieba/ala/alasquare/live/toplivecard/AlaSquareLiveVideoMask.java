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
/* loaded from: classes2.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation aHs;
    private TextView bXF;
    private ImageView dHS;
    private TbImageView egB;
    private View egC;
    private HeadImageView egD;
    private TextView egE;
    private TextView egF;
    private TextView egG;
    private NoActiveStopAlaPlayAnimationView egH;
    private ProgressBar egI;
    private FrameLayout egJ;
    private boolean egK;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.egK = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egK = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egK = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.egK = z;
        this.dHS.setVisibility(8);
        this.egI.setVisibility(8);
        this.egH.setVisibility(8);
        this.egH.setFromSpecialForum(this.egK);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aHs = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.egJ = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.egB = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.egB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.egB.setAutoChangeStyle(false);
        this.egC = this.mRootView.findViewById(R.id.head_root_view);
        this.egC.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.egD = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.bXF = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.egE = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.egD.setIsRound(true);
        this.egD.setAutoChangeStyle(false);
        this.egF = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.egG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dHS = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.egH = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.egH.setFromSpecialForum(this.egK);
        am.setImageResource(this.dHS, R.drawable.btn_icon_play_live_on_n);
        this.egI = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aKd();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aAq() != null && bjVar.azX() != null) {
            AlaInfoData aAq = bjVar.aAq();
            this.egB.startLoad(aAq.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aAq.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.egC.setVisibility(0);
                this.egD.startLoad(alaUserInfoData.portrait, 10, false);
                this.bXF.setText(bjVar.azX().getName_show());
                this.egE.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.egC.setVisibility(8);
            }
            this.egF.setText(bjVar.getTitle());
            this.egG.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aAq.audience_count)));
            if (!this.egK) {
                this.egH.startPlayAnimation();
            }
        }
    }

    public void aKd() {
        am.setViewTextColor(this.egG, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.bXF, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.egE, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.egF, (int) R.color.cp_cont_a);
    }

    public void aZQ() {
        if (this.egK) {
            this.dHS.setVisibility(8);
            this.egI.setVisibility(8);
            this.egH.setVisibility(8);
        }
        this.egJ.startAnimation(this.aHs);
    }

    public void aZR() {
        this.egJ.clearAnimation();
    }

    public void aZS() {
        if (!this.egK) {
            this.egH.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.egK) {
            this.egH.xM();
        }
        this.egJ.clearAnimation();
    }
}

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
    private Animation aLy;
    private TextView cbK;
    private ImageView dLY;
    private TbImageView ekG;
    private View ekH;
    private HeadImageView ekI;
    private TextView ekJ;
    private TextView ekK;
    private TextView ekL;
    private NoActiveStopAlaPlayAnimationView ekM;
    private ProgressBar ekN;
    private FrameLayout ekO;
    private boolean ekP;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.ekP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ekP = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.ekP = z;
        this.dLY.setVisibility(8);
        this.ekN.setVisibility(8);
        this.ekM.setVisibility(8);
        this.ekM.setFromSpecialForum(this.ekP);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aLy = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.ekO = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.ekG = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.ekG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ekG.setAutoChangeStyle(false);
        this.ekH = this.mRootView.findViewById(R.id.head_root_view);
        this.ekH.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.ekI = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cbK = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.ekJ = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.ekI.setIsRound(true);
        this.ekI.setAutoChangeStyle(false);
        this.ekK = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.ekL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dLY = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.ekM = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ekM.setFromSpecialForum(this.ekP);
        am.setImageResource(this.dLY, R.drawable.btn_icon_play_live_on_n);
        this.ekN = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aMB();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCH() != null && bjVar.aCo() != null) {
            AlaInfoData aCH = bjVar.aCH();
            this.ekG.startLoad(aCH.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aCH.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.ekH.setVisibility(0);
                this.ekI.startLoad(alaUserInfoData.portrait, 10, false);
                this.cbK.setText(bjVar.aCo().getName_show());
                this.ekJ.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.ekH.setVisibility(8);
            }
            this.ekK.setText(bjVar.getTitle());
            this.ekL.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aCH.audience_count)));
            if (!this.ekP) {
                this.ekM.startPlayAnimation();
            }
        }
    }

    public void aMB() {
        am.setViewTextColor(this.ekL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbK, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekJ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekK, (int) R.color.cp_cont_a);
    }

    public void bci() {
        if (this.ekP) {
            this.dLY.setVisibility(8);
            this.ekN.setVisibility(8);
            this.ekM.setVisibility(8);
        }
        this.ekO.startAnimation(this.aLy);
    }

    public void bcj() {
        this.ekO.clearAnimation();
    }

    public void bck() {
        if (!this.ekP) {
            this.ekM.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.ekP) {
            this.ekM.Af();
        }
        this.ekO.clearAnimation();
    }
}

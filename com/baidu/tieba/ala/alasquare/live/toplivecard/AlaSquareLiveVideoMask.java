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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation boX;
    private TextView dXU;
    private ImageView eBn;
    private TbImageView fbG;
    private View fbH;
    private HeadImageView fbI;
    private TextView fbJ;
    private TextView fbK;
    private TextView fbL;
    private NoActiveStopAlaPlayAnimationView fbM;
    private ProgressBar fbN;
    private FrameLayout fbO;
    private boolean fbP;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fbP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbP = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fbP = z;
        this.eBn.setVisibility(8);
        this.fbN.setVisibility(8);
        this.fbM.setVisibility(8);
        this.fbM.setFromSpecialForum(this.fbP);
    }

    private void init(Context context) {
        this.mContext = context;
        this.boX = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fbO = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fbG = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fbG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fbG.setAutoChangeStyle(false);
        this.fbH = this.mRootView.findViewById(R.id.head_root_view);
        this.fbH.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fbI = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dXU = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fbJ = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fbI.setIsRound(true);
        this.fbI.setAutoChangeStyle(false);
        this.fbK = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fbL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eBn = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fbM = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fbM.setFromSpecialForum(this.fbP);
        am.setImageResource(this.eBn, R.drawable.btn_icon_play_live_on_n);
        this.fbN = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bbm();
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQS() != null && bkVar.aQx() != null) {
            AlaInfoData aQS = bkVar.aQS();
            this.fbG.startLoad(aQS.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aQS.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fbH.setVisibility(0);
                this.fbI.startLoad(alaUserInfoData.portrait, 10, false);
                this.dXU.setText(bkVar.aQx().getName_show());
                this.fbJ.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fbH.setVisibility(8);
            }
            this.fbK.setText(bkVar.getTitle());
            this.fbL.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aQS.audience_count)));
            if (!this.fbP) {
                this.fbM.startPlayAnimation();
            }
        }
    }

    public void bbm() {
        am.setViewTextColor(this.fbL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fbJ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fbK, (int) R.color.cp_cont_a);
    }

    public void bqA() {
        if (this.fbP) {
            this.eBn.setVisibility(8);
            this.fbN.setVisibility(8);
            this.fbM.setVisibility(8);
        }
        this.fbO.startAnimation(this.boX);
    }

    public void bqB() {
        this.fbO.clearAnimation();
    }

    public void bqC() {
        if (!this.fbP) {
            this.fbM.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fbP) {
            this.fbM.Ha();
        }
        this.fbO.clearAnimation();
    }
}

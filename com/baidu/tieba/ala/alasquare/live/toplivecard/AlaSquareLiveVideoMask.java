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
    private Animation bhu;
    private TextView cAX;
    private TbImageView eOJ;
    private View eOK;
    private HeadImageView eOL;
    private TextView eOM;
    private TextView eON;
    private TextView eOO;
    private NoActiveStopAlaPlayAnimationView eOP;
    private ProgressBar eOQ;
    private FrameLayout eOR;
    private boolean eOS;
    private ImageView ems;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.eOS = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOS = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOS = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.eOS = z;
        this.ems.setVisibility(8);
        this.eOQ.setVisibility(8);
        this.eOP.setVisibility(8);
        this.eOP.setFromSpecialForum(this.eOS);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bhu = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.eOR = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.eOJ = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.eOJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eOJ.setAutoChangeStyle(false);
        this.eOK = this.mRootView.findViewById(R.id.head_root_view);
        this.eOK.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.eOL = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cAX = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.eOM = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.eOL.setIsRound(true);
        this.eOL.setAutoChangeStyle(false);
        this.eON = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.eOO = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ems = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.eOP = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eOP.setFromSpecialForum(this.eOS);
        am.setImageResource(this.ems, R.drawable.btn_icon_play_live_on_n);
        this.eOQ = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aVd();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKX() != null && bjVar.aKE() != null) {
            AlaInfoData aKX = bjVar.aKX();
            this.eOJ.startLoad(aKX.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aKX.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.eOK.setVisibility(0);
                this.eOL.startLoad(alaUserInfoData.portrait, 10, false);
                this.cAX.setText(bjVar.aKE().getName_show());
                this.eOM.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.eOK.setVisibility(8);
            }
            this.eON.setText(bjVar.getTitle());
            this.eOO.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aKX.audience_count)));
            if (!this.eOS) {
                this.eOP.startPlayAnimation();
            }
        }
    }

    public void aVd() {
        am.setViewTextColor(this.eOO, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cAX, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eOM, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eON, (int) R.color.cp_cont_a);
    }

    public void ble() {
        if (this.eOS) {
            this.ems.setVisibility(8);
            this.eOQ.setVisibility(8);
            this.eOP.setVisibility(8);
        }
        this.eOR.startAnimation(this.bhu);
    }

    public void blf() {
        this.eOR.clearAnimation();
    }

    public void blg() {
        if (!this.eOS) {
            this.eOP.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.eOS) {
            this.eOP.Fk();
        }
        this.eOR.clearAnimation();
    }
}

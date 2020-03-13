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
    private Animation aLz;
    private TextView cbL;
    private ImageView dMl;
    private TbImageView ekT;
    private View ekU;
    private HeadImageView ekV;
    private TextView ekW;
    private TextView ekX;
    private TextView ekY;
    private NoActiveStopAlaPlayAnimationView ekZ;
    private ProgressBar ela;
    private FrameLayout elb;
    private boolean elc;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.elc = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elc = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.elc = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.elc = z;
        this.dMl.setVisibility(8);
        this.ela.setVisibility(8);
        this.ekZ.setVisibility(8);
        this.ekZ.setFromSpecialForum(this.elc);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aLz = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.elb = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.ekT = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.ekT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ekT.setAutoChangeStyle(false);
        this.ekU = this.mRootView.findViewById(R.id.head_root_view);
        this.ekU.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.ekV = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cbL = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.ekW = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.ekV.setIsRound(true);
        this.ekV.setAutoChangeStyle(false);
        this.ekX = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.ekY = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dMl = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.ekZ = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ekZ.setFromSpecialForum(this.elc);
        am.setImageResource(this.dMl, R.drawable.btn_icon_play_live_on_n);
        this.ela = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aMC();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCH() != null && bjVar.aCo() != null) {
            AlaInfoData aCH = bjVar.aCH();
            this.ekT.startLoad(aCH.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aCH.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.ekU.setVisibility(0);
                this.ekV.startLoad(alaUserInfoData.portrait, 10, false);
                this.cbL.setText(bjVar.aCo().getName_show());
                this.ekW.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.ekU.setVisibility(8);
            }
            this.ekX.setText(bjVar.getTitle());
            this.ekY.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aCH.audience_count)));
            if (!this.elc) {
                this.ekZ.startPlayAnimation();
            }
        }
    }

    public void aMC() {
        am.setViewTextColor(this.ekY, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekW, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekX, (int) R.color.cp_cont_a);
    }

    public void bcj() {
        if (this.elc) {
            this.dMl.setVisibility(8);
            this.ela.setVisibility(8);
            this.ekZ.setVisibility(8);
        }
        this.elb.startAnimation(this.aLz);
    }

    public void bck() {
        this.elb.clearAnimation();
    }

    public void bcl() {
        if (!this.elc) {
            this.ekZ.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.elc) {
            this.ekZ.Af();
        }
        this.elb.clearAnimation();
    }
}

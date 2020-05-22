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
    private ImageView eBc;
    private TextView fbA;
    private NoActiveStopAlaPlayAnimationView fbB;
    private ProgressBar fbC;
    private FrameLayout fbD;
    private boolean fbE;
    private TbImageView fbv;
    private View fbw;
    private HeadImageView fbx;
    private TextView fby;
    private TextView fbz;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.fbE = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbE = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbE = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.fbE = z;
        this.eBc.setVisibility(8);
        this.fbC.setVisibility(8);
        this.fbB.setVisibility(8);
        this.fbB.setFromSpecialForum(this.fbE);
    }

    private void init(Context context) {
        this.mContext = context;
        this.boX = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.fbD = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.fbv = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.fbv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fbv.setAutoChangeStyle(false);
        this.fbw = this.mRootView.findViewById(R.id.head_root_view);
        this.fbw.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.fbx = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.dXU = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.fby = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.fbx.setIsRound(true);
        this.fbx.setAutoChangeStyle(false);
        this.fbz = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.fbA = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eBc = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.fbB = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fbB.setFromSpecialForum(this.fbE);
        am.setImageResource(this.eBc, R.drawable.btn_icon_play_live_on_n);
        this.fbC = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bbl();
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQS() != null && bkVar.aQx() != null) {
            AlaInfoData aQS = bkVar.aQS();
            this.fbv.startLoad(aQS.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aQS.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.fbw.setVisibility(0);
                this.fbx.startLoad(alaUserInfoData.portrait, 10, false);
                this.dXU.setText(bkVar.aQx().getName_show());
                this.fby.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.fbw.setVisibility(8);
            }
            this.fbz.setText(bkVar.getTitle());
            this.fbA.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aQS.audience_count)));
            if (!this.fbE) {
                this.fbB.startPlayAnimation();
            }
        }
    }

    public void bbl() {
        am.setViewTextColor(this.fbA, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fby, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fbz, (int) R.color.cp_cont_a);
    }

    public void bqy() {
        if (this.fbE) {
            this.eBc.setVisibility(8);
            this.fbC.setVisibility(8);
            this.fbB.setVisibility(8);
        }
        this.fbD.startAnimation(this.boX);
    }

    public void bqz() {
        this.fbD.clearAnimation();
    }

    public void bqA() {
        if (!this.fbE) {
            this.fbB.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.fbE) {
            this.fbB.Ha();
        }
        this.fbD.clearAnimation();
    }
}

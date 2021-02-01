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
/* loaded from: classes10.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation chX;
    private TextView eIO;
    private ImageView fTX;
    private TbImageView gzG;
    private View gzH;
    private HeadImageView gzI;
    private TextView gzJ;
    private TextView gzK;
    private TextView gzL;
    private NoActiveStopAlaPlayAnimationView gzM;
    private ProgressBar gzN;
    private FrameLayout gzO;
    private boolean gzP;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gzP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzP = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzP = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gzP = z;
        this.fTX.setVisibility(8);
        this.gzN.setVisibility(8);
        this.gzM.setVisibility(8);
        this.gzM.setFromSpecialForum(this.gzP);
    }

    private void init(Context context) {
        this.mContext = context;
        this.chX = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gzO = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gzG = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gzG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gzG.setAutoChangeStyle(false);
        this.gzH = this.mRootView.findViewById(R.id.head_root_view);
        this.gzH.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gzI = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eIO = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gzJ = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gzI.setIsRound(true);
        this.gzI.setAutoChangeStyle(false);
        this.gzK = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gzL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fTX = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gzM = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gzM.setFromSpecialForum(this.gzP);
        ap.setImageResource(this.fTX, R.drawable.btn_icon_play_live_on_n);
        this.gzN = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bzn();
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boj() != null && cbVar.bnQ() != null) {
            AlaInfoData boj = cbVar.boj();
            this.gzG.startLoad(boj.cover, 10, false);
            AlaUserInfoData alaUserInfoData = boj.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gzH.setVisibility(0);
                this.gzI.startLoad(alaUserInfoData.portrait, 10, false);
                this.eIO.setText(cbVar.bnQ().getName_show());
                this.gzJ.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gzH.setVisibility(8);
            }
            this.gzK.setText(cbVar.getTitle());
            this.gzL.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(boj.audience_count)));
            if (!this.gzP) {
                this.gzM.startPlayAnimation();
            }
        }
    }

    public void bzn() {
        ap.setViewTextColor(this.gzL, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
        ap.setViewTextColor(this.gzJ, R.color.CAM_X0101);
        ap.setViewTextColor(this.gzK, R.color.CAM_X0101);
    }

    public void bRf() {
        if (this.gzP) {
            this.fTX.setVisibility(8);
            this.gzN.setVisibility(8);
            this.gzM.setVisibility(8);
        }
        this.gzO.startAnimation(this.chX);
    }

    public void bRg() {
        this.gzO.clearAnimation();
    }

    public void bRh() {
        if (!this.gzP) {
            this.gzM.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gzP) {
            this.gzM.Uf();
        }
        this.gzO.clearAnimation();
    }
}

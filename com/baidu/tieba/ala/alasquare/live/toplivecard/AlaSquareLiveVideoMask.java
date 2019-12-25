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
    private Animation aGA;
    private TextView bXt;
    private ImageView dHJ;
    private boolean egA;
    private TbImageView egr;
    private View egs;
    private HeadImageView egt;
    private TextView egu;
    private TextView egv;
    private TextView egw;
    private NoActiveStopAlaPlayAnimationView egx;
    private ProgressBar egy;
    private FrameLayout egz;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.egA = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egA = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egA = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.egA = z;
        this.dHJ.setVisibility(8);
        this.egy.setVisibility(8);
        this.egx.setVisibility(8);
        this.egx.setFromSpecialForum(this.egA);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aGA = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.egz = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.egr = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.egr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.egr.setAutoChangeStyle(false);
        this.egs = this.mRootView.findViewById(R.id.head_root_view);
        this.egs.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.egt = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.bXt = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.egu = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.egt.setIsRound(true);
        this.egt.setAutoChangeStyle(false);
        this.egv = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.egw = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dHJ = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.egx = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.egx.setFromSpecialForum(this.egA);
        am.setImageResource(this.dHJ, R.drawable.btn_icon_play_live_on_n);
        this.egy = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aJJ();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.azX() != null && bjVar.azE() != null) {
            AlaInfoData azX = bjVar.azX();
            this.egr.startLoad(azX.cover, 10, false);
            AlaUserInfoData alaUserInfoData = azX.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.egs.setVisibility(0);
                this.egt.startLoad(alaUserInfoData.portrait, 10, false);
                this.bXt.setText(bjVar.azE().getName_show());
                this.egu.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.egs.setVisibility(8);
            }
            this.egv.setText(bjVar.getTitle());
            this.egw.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(azX.audience_count)));
            if (!this.egA) {
                this.egx.startPlayAnimation();
            }
        }
    }

    public void aJJ() {
        am.setViewTextColor(this.egw, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.bXt, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.egu, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.egv, (int) R.color.cp_cont_a);
    }

    public void aZv() {
        if (this.egA) {
            this.dHJ.setVisibility(8);
            this.egy.setVisibility(8);
            this.egx.setVisibility(8);
        }
        this.egz.startAnimation(this.aGA);
    }

    public void aZw() {
        this.egz.clearAnimation();
    }

    public void aZx() {
        if (!this.egA) {
            this.egx.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.egA) {
            this.egx.xw();
        }
        this.egz.clearAnimation();
    }
}

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
    private Animation aLN;
    private TextView cbW;
    private ImageView dMB;
    private TbImageView elj;
    private View elk;
    private HeadImageView ell;
    private TextView elm;
    private TextView eln;
    private TextView elo;
    private NoActiveStopAlaPlayAnimationView elp;
    private ProgressBar elq;
    private FrameLayout elr;
    private boolean els;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.els = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.els = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.els = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.els = z;
        this.dMB.setVisibility(8);
        this.elq.setVisibility(8);
        this.elp.setVisibility(8);
        this.elp.setFromSpecialForum(this.els);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aLN = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.elr = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.elj = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.elj.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.elj.setAutoChangeStyle(false);
        this.elk = this.mRootView.findViewById(R.id.head_root_view);
        this.elk.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.ell = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.cbW = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.elm = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.ell.setIsRound(true);
        this.ell.setAutoChangeStyle(false);
        this.eln = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.elo = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dMB = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.elp = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.elp.setFromSpecialForum(this.els);
        am.setImageResource(this.dMB, R.drawable.btn_icon_play_live_on_n);
        this.elq = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        aMG();
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCK() != null && bjVar.aCr() != null) {
            AlaInfoData aCK = bjVar.aCK();
            this.elj.startLoad(aCK.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aCK.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.elk.setVisibility(0);
                this.ell.startLoad(alaUserInfoData.portrait, 10, false);
                this.cbW.setText(bjVar.aCr().getName_show());
                this.elm.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.elk.setVisibility(8);
            }
            this.eln.setText(bjVar.getTitle());
            this.elo.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aCK.audience_count)));
            if (!this.els) {
                this.elp.startPlayAnimation();
            }
        }
    }

    public void aMG() {
        am.setViewTextColor(this.elo, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbW, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.elm, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eln, (int) R.color.cp_cont_a);
    }

    public void bcn() {
        if (this.els) {
            this.dMB.setVisibility(8);
            this.elq.setVisibility(8);
            this.elp.setVisibility(8);
        }
        this.elr.startAnimation(this.aLN);
    }

    public void bco() {
        this.elr.clearAnimation();
    }

    public void bcp() {
        if (!this.els) {
            this.elp.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.els) {
            this.elp.Am();
        }
        this.elr.clearAnimation();
    }
}

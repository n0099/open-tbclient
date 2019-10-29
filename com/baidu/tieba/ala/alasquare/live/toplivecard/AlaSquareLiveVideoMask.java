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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation azg;
    private ImageView cUh;
    private TextView csn;
    private TbImageView dwg;
    private View dwh;
    private HeadImageView dwi;
    private TextView dwj;
    private TextView dwk;
    private TextView dwl;
    private NoActiveStopAlaPlayAnimationView dwm;
    private ProgressBar dwn;
    private FrameLayout dwo;
    private boolean dwp;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.dwp = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwp = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwp = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.dwp = z;
        this.cUh.setVisibility(8);
        this.dwn.setVisibility(8);
        this.dwm.setVisibility(8);
        this.dwm.setFromSpecialForum(this.dwp);
    }

    private void init(Context context) {
        this.mContext = context;
        this.azg = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.dwo = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.dwg = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.dwg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dwg.setAutoChangeStyle(false);
        this.dwh = this.mRootView.findViewById(R.id.head_root_view);
        this.dwh.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.dwi = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.csn = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.dwj = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.dwi.setIsRound(true);
        this.dwi.setAutoChangeStyle(false);
        this.dwk = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.dwl = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.cUh = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.dwm = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.dwm.setFromSpecialForum(this.dwp);
        am.setImageResource(this.cUh, R.drawable.btn_icon_play_live_on_n);
        this.dwn = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        asm();
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiZ() != null && bhVar.aiG() != null) {
            AlaInfoData aiZ = bhVar.aiZ();
            this.dwg.startLoad(aiZ.cover, 10, false);
            AlaUserInfoData alaUserInfoData = aiZ.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.dwh.setVisibility(0);
                this.dwi.startLoad(alaUserInfoData.portrait, 10, false);
                this.csn.setText(bhVar.aiG().getName_show());
                this.dwj.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.dwh.setVisibility(8);
            }
            this.dwk.setText(bhVar.getTitle());
            this.dwl.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(aiZ.audience_count)));
            if (!this.dwp) {
                this.dwm.startPlayAnimation();
            }
        }
    }

    public void asm() {
        am.setViewTextColor(this.dwl, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.csn, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dwj, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dwk, (int) R.color.cp_cont_a);
    }

    public void aIZ() {
        if (this.dwp) {
            this.cUh.setVisibility(8);
            this.dwn.setVisibility(8);
            this.dwm.setVisibility(8);
        }
        this.dwo.startAnimation(this.azg);
    }

    public void aJa() {
        this.dwo.clearAnimation();
    }

    public void aJb() {
        if (!this.dwp) {
            this.dwm.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.dwp) {
            this.dwm.vx();
        }
        this.dwo.clearAnimation();
    }
}

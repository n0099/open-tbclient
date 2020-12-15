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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaSquareLiveVideoMask extends FrameLayout {
    private Animation cbR;
    private TextView eBQ;
    private ImageView fML;
    private TbImageView gqE;
    private View gqF;
    private HeadImageView gqG;
    private TextView gqH;
    private TextView gqI;
    private TextView gqJ;
    private NoActiveStopAlaPlayAnimationView gqK;
    private ProgressBar gqL;
    private FrameLayout gqM;
    private boolean gqN;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gqN = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqN = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqN = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gqN = z;
        this.fML.setVisibility(8);
        this.gqL.setVisibility(8);
        this.gqK.setVisibility(8);
        this.gqK.setFromSpecialForum(this.gqN);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cbR = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gqM = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gqE = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gqE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gqE.setAutoChangeStyle(false);
        this.gqF = this.mRootView.findViewById(R.id.head_root_view);
        this.gqF.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gqG = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eBQ = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gqH = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gqG.setIsRound(true);
        this.gqG.setAutoChangeStyle(false);
        this.gqI = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gqJ = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fML = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gqK = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gqK.setFromSpecialForum(this.gqN);
        ap.setImageResource(this.fML, R.drawable.btn_icon_play_live_on_n);
        this.gqL = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bAu();
    }

    public void setData(by byVar) {
        if (byVar != null && byVar.bpj() != null && byVar.boP() != null) {
            AlaInfoData bpj = byVar.bpj();
            this.gqE.startLoad(bpj.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bpj.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gqF.setVisibility(0);
                this.gqG.startLoad(alaUserInfoData.portrait, 10, false);
                this.eBQ.setText(byVar.boP().getName_show());
                this.gqH.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gqF.setVisibility(8);
            }
            this.gqI.setText(byVar.getTitle());
            this.gqJ.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bpj.audience_count)));
            if (!this.gqN) {
                this.gqK.startPlayAnimation();
            }
        }
    }

    public void bAu() {
        ap.setViewTextColor(this.gqJ, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.eBQ, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gqH, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gqI, (int) R.color.CAM_X0101);
    }

    public void bRQ() {
        if (this.gqN) {
            this.fML.setVisibility(8);
            this.gqL.setVisibility(8);
            this.gqK.setVisibility(8);
        }
        this.gqM.startAnimation(this.cbR);
    }

    public void bRR() {
        this.gqM.clearAnimation();
    }

    public void bRS() {
        if (!this.gqN) {
            this.gqK.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gqN) {
            this.gqK.Vo();
        }
        this.gqM.clearAnimation();
    }
}

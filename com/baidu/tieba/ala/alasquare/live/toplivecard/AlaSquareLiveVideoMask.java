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
    private TbImageView gqC;
    private View gqD;
    private HeadImageView gqE;
    private TextView gqF;
    private TextView gqG;
    private TextView gqH;
    private NoActiveStopAlaPlayAnimationView gqI;
    private ProgressBar gqJ;
    private FrameLayout gqK;
    private boolean gqL;
    private Context mContext;
    private View mRootView;

    public AlaSquareLiveVideoMask(Context context) {
        super(context);
        this.gqL = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqL = false;
        init(context);
    }

    public AlaSquareLiveVideoMask(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqL = false;
        init(context);
    }

    public void setFromSpecialForum(boolean z) {
        this.gqL = z;
        this.fML.setVisibility(8);
        this.gqJ.setVisibility(8);
        this.gqI.setVisibility(8);
        this.gqI.setFromSpecialForum(this.gqL);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cbR = AnimationUtils.loadAnimation(this.mContext, R.anim.video_cover_fade_out);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.new_square_top_live_card_mask, this);
        this.gqK = (FrameLayout) this.mRootView.findViewById(R.id.fade_out_view_root);
        this.gqC = (TbImageView) this.mRootView.findViewById(R.id.live_cover);
        this.gqC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gqC.setAutoChangeStyle(false);
        this.gqD = this.mRootView.findViewById(R.id.head_root_view);
        this.gqD.setBackgroundResource(R.drawable.round_host_header_bg_n);
        this.gqE = (HeadImageView) this.mRootView.findViewById(R.id.hostheader_image);
        this.eBQ = (TextView) this.mRootView.findViewById(R.id.hostheader_name);
        this.gqF = (TextView) this.mRootView.findViewById(R.id.hostheader_id);
        this.gqE.setIsRound(true);
        this.gqE.setAutoChangeStyle(false);
        this.gqG = (TextView) this.mRootView.findViewById(R.id.tvSquareTitle);
        this.gqH = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fML = (ImageView) this.mRootView.findViewById(R.id.image_video_play);
        this.gqI = (NoActiveStopAlaPlayAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gqI.setFromSpecialForum(this.gqL);
        ap.setImageResource(this.fML, R.drawable.btn_icon_play_live_on_n);
        this.gqJ = (ProgressBar) this.mRootView.findViewById(R.id.auto_video_loading_progress);
        bAu();
    }

    public void setData(by byVar) {
        if (byVar != null && byVar.bpj() != null && byVar.boP() != null) {
            AlaInfoData bpj = byVar.bpj();
            this.gqC.startLoad(bpj.cover, 10, false);
            AlaUserInfoData alaUserInfoData = bpj.user_info;
            if (alaUserInfoData != null && !StringUtils.isNull(alaUserInfoData.portrait) && alaUserInfoData.ala_id > 0) {
                this.gqD.setVisibility(0);
                this.gqE.startLoad(alaUserInfoData.portrait, 10, false);
                this.eBQ.setText(byVar.boP().getName_show());
                this.gqF.setText(String.format(this.mContext.getString(R.string.square_recommend_top_card_ala_host_id), String.valueOf(alaUserInfoData.ala_id)));
            } else {
                this.gqD.setVisibility(8);
            }
            this.gqG.setText(byVar.getTitle());
            this.gqH.setText(this.mContext.getResources().getString(R.string.square_sub_live_audience_label, String.valueOf(bpj.audience_count)));
            if (!this.gqL) {
                this.gqI.startPlayAnimation();
            }
        }
    }

    public void bAu() {
        ap.setViewTextColor(this.gqH, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.eBQ, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gqF, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gqG, (int) R.color.CAM_X0101);
    }

    public void bRP() {
        if (this.gqL) {
            this.fML.setVisibility(8);
            this.gqJ.setVisibility(8);
            this.gqI.setVisibility(8);
        }
        this.gqK.startAnimation(this.cbR);
    }

    public void bRQ() {
        this.gqK.clearAnimation();
    }

    public void bRR() {
        if (!this.gqL) {
            this.gqI.startPlayAnimation();
        }
    }

    public void onDestroy() {
        if (!this.gqL) {
            this.gqI.Vo();
        }
        this.gqK.clearAnimation();
    }
}

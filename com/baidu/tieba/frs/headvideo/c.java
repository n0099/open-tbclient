package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int IT;
    private aj aRZ;
    private QuickVideoView aSL;
    private ImageView aSP;
    private String aTZ;
    private TextView amc;
    private View bXP;
    private View bXQ;
    private TbImageView bXR;
    private TextView bXS;
    private TextView bXT;
    private View bXU;
    private TextView bXV;
    private View bXW;
    private ProgressBar bXX;
    private View bXY;
    private View bXZ;
    private ClickableHeaderImageView bYa;
    private View bYb;
    private View bYc;
    private View bYd;
    private String bYe;
    private int bYf;
    private int bYg;
    private bj bYh;
    private int bYi;
    private AudioAnimationView bsU;
    private ImageView bsW;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bj getThreadInfo() {
        return this.bYh;
    }

    public String getVideoUrl() {
        return this.aTZ;
    }

    public boolean isPlaying() {
        return this.aSL != null && this.aSL.isPlaying();
    }

    public int getBgResId() {
        return this.bYg;
    }

    public View getVideoContainer() {
        return this.bXP;
    }

    public c(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bYf = 1;
        this.bYi = 0;
        this.mOnClickListener = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(w.j.forum_head_video_item, this);
        View view = this.mRootView;
        this.bXP = view.findViewById(w.h.video_view_layout);
        this.bXQ = view.findViewById(w.h.black_mask);
        this.bXR = (TbImageView) view.findViewById(w.h.video_thumbnail);
        this.bXR.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aSL = (QuickVideoView) view.findViewById(w.h.videoView);
        this.aRZ = new aj(this.mContext);
        this.aRZ.aXR();
        this.aSL.setBusiness(this.aRZ);
        this.bsW = (ImageView) view.findViewById(w.h.video_list_loading_image);
        this.bXX = (ProgressBar) view.findViewById(w.h.loading_progress);
        this.bXW = view.findViewById(w.h.video_list_layout_loading);
        this.bsU = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bsU.setCertainColumnCount(4);
        this.bsU.setColumnColor(w.e.cp_cont_i);
        this.bXU = view.findViewById(w.h.video_view_error_layout);
        this.bXV = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bXZ = view.findViewById(w.h.video_info_container);
        this.bXY = view.findViewById(w.h.video_info_layout);
        this.amc = (TextView) view.findViewById(w.h.user_name);
        this.bYa = (ClickableHeaderImageView) view.findViewById(w.h.iv_user_avatar);
        this.bYa.setClickable(false);
        this.bYa.setIsGod(false);
        this.bYa.setBorderWidth(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        this.aSP = (ImageView) view.findViewById(w.h.img_play);
        this.bXS = (TextView) view.findViewById(w.h.tv_video_info);
        this.bXT = (TextView) view.findViewById(w.h.tv_play_count);
        this.bYb = view.findViewById(w.h.blur_bg);
        this.bYc = view.findViewById(w.h.divider_1);
        this.bYd = view.findViewById(w.h.divider_2);
        this.aSP.setOnClickListener(this.mOnClickListener);
        this.aSP.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (this.mSkinType != i) {
            aq.k(this.bXP, w.e.cp_bg_line_k);
            aq.k(this.bXQ, w.e.cp_bg_line_k);
            aq.k(this.bYc, w.e.cp_bg_line_k_alpha5);
            aq.k(this.bYd, w.e.cp_bg_line_k_alpha10);
            aq.i((View) this.bXS, w.e.cp_cont_b);
            aq.i((View) this.amc, w.e.cp_cont_b);
            aq.i((View) this.bXT, w.e.cp_cont_d);
            aq.c(this.aSP, w.g.btn_icon_play_video_n);
            aq.c(this.bsW, w.g.btn_icon_video_n);
            aq.k(this.bXU, w.e.common_color_10014);
            aq.i((View) this.bXV, w.e.cp_cont_i);
            acp();
            this.mSkinType = i;
        }
    }

    public void aco() {
        if (this.bXR != null) {
            this.bXR.c(this.bYe, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.bYb != null) {
            this.bYb.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.bYg = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        aq.k(this.bXZ, i);
    }

    private void acp() {
        if (this.bYa != null) {
            this.bYa.setBorderColor(aq.getColor(w.e.cp_bg_line_d_alpha70));
        }
        if (this.bXT != null) {
            this.bXT.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bXV != null) {
            this.bXV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.bXR != null) {
            this.bXR.setDefaultErrorResource(0);
            this.bXR.setDefaultBgResource(w.g.pic_bg_video_frs);
        }
        if (this.bsU != null) {
            this.bsU.setColumnColor(w.e.cp_cont_i);
        }
    }

    public void acq() {
        if (this.bXT != null) {
            this.bYi++;
            if (this.bYi > 0) {
                this.bXT.setVisibility(0);
                this.bXT.setText(au.t(this.bYi));
                return;
            }
            this.bXT.setVisibility(8);
        }
    }

    public void a(v.d dVar, v.a aVar, v.b bVar) {
        this.aSL.setOnPreparedListener(dVar);
        this.aSL.setOnCompletionListener(aVar);
        this.aSL.setOnErrorListener(bVar);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.bYf = 1;
            this.bXR.setVisibility(0);
            this.bXQ.setVisibility(0);
            this.aSP.setVisibility(0);
            this.bXW.setVisibility(8);
            this.bXU.setVisibility(8);
            this.bsU.setVisibility(8);
            this.bsU.blA();
        } else if (i == 2) {
            this.bYf = 2;
            this.bXR.setVisibility(0);
            this.bXQ.setVisibility(0);
            this.aSP.setVisibility(8);
            this.bXW.setVisibility(0);
            this.bXU.setVisibility(8);
            this.bsU.setVisibility(8);
            this.bsU.blA();
        } else if (i == 3) {
            this.bYf = 3;
            this.bXR.setVisibility(8);
            this.bXQ.setVisibility(8);
            this.aSP.setVisibility(8);
            this.bXW.setVisibility(8);
            this.bXU.setVisibility(8);
            this.bsU.setVisibility(0);
            this.bsU.start();
        } else if (i == 4) {
            this.bYf = 4;
            this.bXR.setVisibility(0);
            this.bXQ.setVisibility(0);
            this.aSP.setVisibility(0);
            this.bXW.setVisibility(8);
            this.bXU.setVisibility(0);
            this.bsU.setVisibility(8);
            this.bsU.blA();
        }
    }

    public void stopPlayback() {
        if (this.aSL != null) {
            setVideoPlayState(1);
            this.aSL.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aSL != null && this.aSL.isPlaying()) {
            setVideoPlayState(1);
            this.aSL.pause();
        }
    }

    public void startPlay() {
        if (this.aSL != null) {
            setVideoPlayState(2);
            this.aSL.setVideoPath(this.aTZ);
            this.aSL.start();
        }
    }

    public void acr() {
        if (this.bYh != null) {
            as asVar = new as("c11717");
            asVar.g("fid", this.bYh.getFid());
            asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bYh.Zh);
            asVar.Z("obj_param2", this.bYh.Zi);
            asVar.Z("obj_param1", this.bYh.Zm);
            asVar.s("obj_locate", 2);
            asVar.Z("tid", this.bYh.getTid());
            cc.Sv().a(asVar);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0037: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bq : 0x0033: INVOKE  (r2v0 com.baidu.tbadk.core.data.bq A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bj) type: VIRTUAL call: com.baidu.tbadk.core.data.bj.sU():com.baidu.tbadk.core.data.bq)
     com.baidu.tbadk.core.data.bq.channelId long)] */
    private bb j(bj bjVar) {
        bb bbVar = null;
        if (bjVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "4";
            bbVar.bqC = String.valueOf(bjVar.getFid());
            bbVar.bqB = bjVar.getTid();
            if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
                bbVar.Vy = new StringBuilder().append(bjVar.sU().channelId).toString();
            }
        }
        return bbVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bj bjVar;
        if (bannerThreadInfoData != null && (bjVar = bannerThreadInfoData.threadData) != null && bjVar.sh() != null && bjVar.getAuthor() != null) {
            if (this.aRZ != null) {
                this.aRZ.a(j(bjVar));
                if (this.aRZ.aXS() != null) {
                    this.aRZ.aXS().c(bjVar.sh());
                }
            }
            this.bYh = bjVar;
            VideoInfo sh = bjVar.sh();
            this.aTZ = sh.video_url;
            this.IT = sh.video_duration.intValue();
            this.bYe = sh.thumbnail_url;
            MetaData author = bjVar.getAuthor();
            this.bXR.setVisibility(0);
            this.bXQ.setVisibility(0);
            this.aSP.setVisibility(0);
            this.bXW.setVisibility(8);
            this.aSL.stopPlayback();
            this.bYi = sh.play_count.intValue();
            if (this.bYi > 0) {
                this.bXT.setVisibility(0);
                this.bXT.setText(au.t(this.bYi));
            } else {
                this.bXT.setVisibility(8);
            }
            this.bXS.setText(bjVar.getTitle());
            if (this.bYh.rT()) {
                this.bYa.setIsGod(true);
            } else {
                this.bYa.setIsGod(false);
            }
            this.bYa.setData(this.bYh);
            this.amc.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.bXR != null) {
            this.bXR.setImageBitmap(null);
        }
        if (this.bYa != null) {
            this.bYa.setImageBitmap(null);
        }
        if (this.aSL != null) {
            this.aSL.stopPlayback();
        }
    }

    public void setLooping(boolean z) {
        if (this.aSL != null) {
            this.aSL.setLooping(z);
        }
    }
}

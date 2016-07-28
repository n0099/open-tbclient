package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends RelativeLayout {
    private int Ae;
    private TextureVideoView aKC;
    private TbImageView aKD;
    private ImageView aKE;
    private String aKF;
    private View aKG;
    private View aKP;
    private AudioAnimationView aUg;
    private ImageView aUi;
    private TextView aeS;
    private View bQc;
    private TextView bQd;
    private TextView bQe;
    private View bQf;
    private TextView bQg;
    private ProgressBar bQh;
    private View bQi;
    private View bQj;
    private ClickableHeaderImageView bQk;
    private View bQl;
    private View bQm;
    private View bQn;
    private String bQo;
    private int bQp;
    private int bQq;
    private be bQr;
    private int bQs;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public be getThreadInfo() {
        return this.bQr;
    }

    public String getVideoUrl() {
        return this.aKF;
    }

    public boolean isPlaying() {
        return this.aKC != null && this.aKC.isPlaying();
    }

    public int getBgResId() {
        return this.bQq;
    }

    public View getVideoContainer() {
        return this.bQc;
    }

    public e(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bQp = 1;
        this.bQs = 0;
        this.mOnClickListener = new f(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(u.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.bQc = view.findViewById(u.g.video_view_layout);
        this.aKP = view.findViewById(u.g.black_mask);
        this.aKD = (TbImageView) view.findViewById(u.g.video_thumbnail);
        this.aKD.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aKC = (TextureVideoView) view.findViewById(u.g.videoView);
        this.aKC.setAutoDownload(false);
        this.aUi = (ImageView) view.findViewById(u.g.video_list_loading_image);
        this.bQh = (ProgressBar) view.findViewById(u.g.loading_progress);
        this.aKG = view.findViewById(u.g.video_list_layout_loading);
        this.aUg = (AudioAnimationView) view.findViewById(u.g.auto_video_play_state);
        this.aUg.setCertainColumnCount(4);
        this.aUg.setColumnColor(u.d.cp_cont_i);
        this.bQf = view.findViewById(u.g.video_view_error_layout);
        this.bQg = (TextView) view.findViewById(u.g.auto_video_error_tips);
        this.bQj = view.findViewById(u.g.video_info_container);
        this.bQi = view.findViewById(u.g.video_info_layout);
        this.aeS = (TextView) view.findViewById(u.g.user_name);
        this.bQk = (ClickableHeaderImageView) view.findViewById(u.g.iv_user_avatar);
        this.bQk.setClickable(false);
        this.bQk.setIsGod(false);
        this.bQk.setBorderWidth(com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4));
        this.aKE = (ImageView) view.findViewById(u.g.img_play);
        this.bQd = (TextView) view.findViewById(u.g.tv_video_info);
        this.bQe = (TextView) view.findViewById(u.g.tv_play_count);
        this.bQl = view.findViewById(u.g.blur_bg);
        this.bQm = view.findViewById(u.g.divider_1);
        this.bQn = view.findViewById(u.g.divider_2);
        this.aKE.setOnClickListener(this.mOnClickListener);
        this.aKE.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            av.l(this.bQc, u.d.cp_bg_line_k);
            av.l(this.aKP, u.d.cp_bg_line_k);
            av.l(this.bQm, u.d.cp_bg_line_k_alpha5);
            av.l(this.bQn, u.d.cp_bg_line_k_alpha10);
            av.j((View) this.bQd, u.d.cp_cont_b);
            av.j((View) this.aeS, u.d.cp_cont_b);
            av.j((View) this.bQe, u.d.cp_cont_d);
            av.c(this.aKE, u.f.btn_icon_play_video_n);
            av.c(this.aUi, u.f.btn_icon_video_n);
            av.l(this.bQf, u.d.common_color_10014);
            av.j((View) this.bQg, u.d.cp_cont_i);
            Zz();
            this.mSkinType = i;
        }
    }

    public void Zy() {
        if (this.aKD != null) {
            this.aKD.c(this.bQo, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.bQl != null) {
            this.bQl.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.bQq = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        av.l(this.bQj, i);
    }

    private void Zz() {
        if (this.bQk != null) {
            this.bQk.setBorderColor(av.getColor(u.d.cp_bg_line_d_alpha70));
        }
        if (this.bQe != null) {
            this.bQe.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bQg != null) {
            this.bQg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aKD != null) {
            this.aKD.setDefaultErrorResource(0);
            this.aKD.setDefaultBgResource(u.f.pic_bg_video_frs);
        }
        if (this.aUg != null) {
            this.aUg.setColumnColor(u.d.cp_cont_i);
        }
    }

    public void ZA() {
        if (this.bQe != null) {
            this.bQs++;
            if (this.bQs > 0) {
                this.bQe.setVisibility(0);
                this.bQe.setText(ba.w(this.bQs));
                return;
            }
            this.bQe.setVisibility(8);
        }
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        this.aKC.setOnPreparedListener(onPreparedListener);
        this.aKC.setOnCompletionListener(onCompletionListener);
        this.aKC.setOnErrorListener(onErrorListener);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.bQp = 1;
            this.aKD.setVisibility(0);
            this.aKP.setVisibility(0);
            this.aKE.setVisibility(0);
            this.aKG.setVisibility(8);
            this.bQf.setVisibility(8);
            this.aUg.setVisibility(8);
            this.aUg.bmz();
        } else if (i == 2) {
            this.bQp = 2;
            this.aKD.setVisibility(0);
            this.aKP.setVisibility(0);
            this.aKE.setVisibility(8);
            this.aKG.setVisibility(0);
            this.bQf.setVisibility(8);
            this.aUg.setVisibility(8);
            this.aUg.bmz();
        } else if (i == 3) {
            this.bQp = 3;
            this.aKD.setVisibility(8);
            this.aKP.setVisibility(8);
            this.aKE.setVisibility(8);
            this.aKG.setVisibility(8);
            this.bQf.setVisibility(8);
            this.aUg.setVisibility(0);
            this.aUg.start();
        } else if (i == 4) {
            this.bQp = 4;
            this.aKD.setVisibility(0);
            this.aKP.setVisibility(0);
            this.aKE.setVisibility(0);
            this.aKG.setVisibility(8);
            this.bQf.setVisibility(0);
            this.aUg.setVisibility(8);
            this.aUg.bmz();
        }
    }

    public void stopPlayback() {
        if (this.aKC != null) {
            setVideoPlayState(1);
            this.aKC.stopPlayback();
        }
    }

    public void ZB() {
        if (this.aKC != null && this.aKC.isPlaying()) {
            setVideoPlayState(1);
            this.aKC.pause();
        }
    }

    public void Iz() {
        if (this.aKC != null) {
            setVideoPlayState(2);
            this.aKC.u(this.aKF, this.Ae);
            this.aKC.start();
        }
    }

    private TextureVideoView.c h(be beVar) {
        if (beVar == null) {
            return null;
        }
        TextureVideoView.c cVar = new TextureVideoView.c();
        cVar.mLocate = "4";
        cVar.aeq = String.valueOf(beVar.getFid());
        cVar.aep = beVar.getTid();
        return cVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        be beVar;
        if (bannerThreadInfoData != null && (beVar = bannerThreadInfoData.threadData) != null && beVar.qM() != null && beVar.getAuthor() != null) {
            this.aKC.setVideoStatsData(h(beVar));
            this.bQr = beVar;
            VideoInfo qM = beVar.qM();
            this.aKF = qM.video_url;
            this.Ae = qM.video_duration.intValue();
            this.bQo = qM.thumbnail_url;
            MetaData author = beVar.getAuthor();
            this.aKD.setVisibility(0);
            this.aKP.setVisibility(0);
            this.aKE.setVisibility(0);
            this.aKG.setVisibility(8);
            this.aKC.stopPlayback();
            this.bQs = qM.play_count.intValue();
            if (this.bQs > 0) {
                this.bQe.setVisibility(0);
                this.bQe.setText(ba.w(this.bQs));
            } else {
                this.bQe.setVisibility(8);
            }
            this.bQd.setText(beVar.getTitle());
            if (this.bQr.qy()) {
                this.bQk.setIsGod(true);
            } else {
                this.bQk.setIsGod(false);
            }
            this.bQk.setData(this.bQr);
            this.aeS.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aKD != null) {
            this.aKD.setImageBitmap(null);
        }
        if (this.bQk != null) {
            this.bQk.setImageBitmap(null);
        }
        if (this.aKC != null) {
            this.aKC.stopPlayback();
        }
    }
}

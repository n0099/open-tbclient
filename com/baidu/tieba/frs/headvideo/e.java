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
import com.baidu.tbadk.core.data.az;
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
    private TextureVideoView aJJ;
    private TbImageView aJK;
    private ImageView aJL;
    private String aJM;
    private View aJN;
    private View aJW;
    private AudioAnimationView aTk;
    private ImageView aTm;
    private TextView aee;
    private View bOA;
    private View bOB;
    private String bOC;
    private int bOD;
    private int bOE;
    private az bOF;
    private int bOG;
    private View bOq;
    private TextView bOr;
    private TextView bOs;
    private View bOt;
    private TextView bOu;
    private ProgressBar bOv;
    private View bOw;
    private View bOx;
    private ClickableHeaderImageView bOy;
    private View bOz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;
    private int zC;

    public az getThreadInfo() {
        return this.bOF;
    }

    public String getVideoUrl() {
        return this.aJM;
    }

    public boolean isPlaying() {
        return this.aJJ != null && this.aJJ.isPlaying();
    }

    public int getBgResId() {
        return this.bOE;
    }

    public View getVideoContainer() {
        return this.bOq;
    }

    public e(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bOD = 1;
        this.bOG = 0;
        this.mOnClickListener = new f(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(u.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.bOq = view.findViewById(u.g.video_view_layout);
        this.aJW = view.findViewById(u.g.black_mask);
        this.aJK = (TbImageView) view.findViewById(u.g.video_thumbnail);
        this.aJK.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aJJ = (TextureVideoView) view.findViewById(u.g.videoView);
        this.aJJ.setAutoDownload(false);
        this.aTm = (ImageView) view.findViewById(u.g.video_list_loading_image);
        this.bOv = (ProgressBar) view.findViewById(u.g.loading_progress);
        this.aJN = view.findViewById(u.g.video_list_layout_loading);
        this.aTk = (AudioAnimationView) view.findViewById(u.g.auto_video_play_state);
        this.aTk.setCertainColumnCount(4);
        this.aTk.setColumnColor(u.d.cp_cont_i);
        this.bOt = view.findViewById(u.g.video_view_error_layout);
        this.bOu = (TextView) view.findViewById(u.g.auto_video_error_tips);
        this.bOx = view.findViewById(u.g.video_info_container);
        this.bOw = view.findViewById(u.g.video_info_layout);
        this.aee = (TextView) view.findViewById(u.g.user_name);
        this.bOy = (ClickableHeaderImageView) view.findViewById(u.g.iv_user_avatar);
        this.bOy.setClickable(false);
        this.bOy.setIsGod(false);
        this.bOy.setBorderWidth(com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4));
        this.aJL = (ImageView) view.findViewById(u.g.img_play);
        this.bOr = (TextView) view.findViewById(u.g.tv_video_info);
        this.bOs = (TextView) view.findViewById(u.g.tv_play_count);
        this.bOz = view.findViewById(u.g.blur_bg);
        this.bOA = view.findViewById(u.g.divider_1);
        this.bOB = view.findViewById(u.g.divider_2);
        this.aJL.setOnClickListener(this.mOnClickListener);
        this.aJL.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            av.l(this.bOq, u.d.cp_bg_line_k);
            av.l(this.aJW, u.d.cp_bg_line_k);
            av.l(this.bOA, u.d.cp_bg_line_k_alpha5);
            av.l(this.bOB, u.d.cp_bg_line_k_alpha10);
            av.j((View) this.bOr, u.d.cp_cont_b);
            av.j((View) this.aee, u.d.cp_cont_b);
            av.j((View) this.bOs, u.d.cp_cont_d);
            av.c(this.aJL, u.f.btn_icon_play_video_n);
            av.c(this.aTm, u.f.btn_icon_video_n);
            av.l(this.bOt, u.d.common_color_10014);
            av.j((View) this.bOu, u.d.cp_cont_i);
            Zd();
            this.mSkinType = i;
        }
    }

    public void Zc() {
        if (this.aJK != null) {
            this.aJK.c(this.bOC, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.bOz != null) {
            this.bOz.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.bOE = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        av.l(this.bOx, i);
    }

    private void Zd() {
        if (this.bOy != null) {
            this.bOy.setBorderColor(av.getColor(u.d.cp_bg_line_d_alpha70));
        }
        if (this.bOs != null) {
            this.bOs.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bOu != null) {
            this.bOu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aJK != null) {
            this.aJK.setDefaultErrorResource(0);
            this.aJK.setDefaultBgResource(u.f.pic_bg_video_frs);
        }
        if (this.aTk != null) {
            this.aTk.setColumnColor(u.d.cp_cont_i);
        }
    }

    public void Ze() {
        if (this.bOs != null) {
            this.bOG++;
            if (this.bOG > 0) {
                this.bOs.setVisibility(0);
                this.bOs.setText(ba.B(this.bOG));
                return;
            }
            this.bOs.setVisibility(8);
        }
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        this.aJJ.setOnPreparedListener(onPreparedListener);
        this.aJJ.setOnCompletionListener(onCompletionListener);
        this.aJJ.setOnErrorListener(onErrorListener);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.bOD = 1;
            this.aJK.setVisibility(0);
            this.aJW.setVisibility(0);
            this.aJL.setVisibility(0);
            this.aJN.setVisibility(8);
            this.bOt.setVisibility(8);
            this.aTk.setVisibility(8);
            this.aTk.bjm();
        } else if (i == 2) {
            this.bOD = 2;
            this.aJK.setVisibility(0);
            this.aJW.setVisibility(0);
            this.aJL.setVisibility(8);
            this.aJN.setVisibility(0);
            this.bOt.setVisibility(8);
            this.aTk.setVisibility(8);
            this.aTk.bjm();
        } else if (i == 3) {
            this.bOD = 3;
            this.aJK.setVisibility(8);
            this.aJW.setVisibility(8);
            this.aJL.setVisibility(8);
            this.aJN.setVisibility(8);
            this.bOt.setVisibility(8);
            this.aTk.setVisibility(0);
            this.aTk.start();
        } else if (i == 4) {
            this.bOD = 4;
            this.aJK.setVisibility(0);
            this.aJW.setVisibility(0);
            this.aJL.setVisibility(0);
            this.aJN.setVisibility(8);
            this.bOt.setVisibility(0);
            this.aTk.setVisibility(8);
            this.aTk.bjm();
        }
    }

    public void stopPlayback() {
        if (this.aJJ != null) {
            setVideoPlayState(1);
            this.aJJ.stopPlayback();
        }
    }

    public void Zf() {
        if (this.aJJ != null && this.aJJ.isPlaying()) {
            setVideoPlayState(1);
            this.aJJ.pause();
        }
    }

    public void IA() {
        if (this.aJJ != null) {
            setVideoPlayState(2);
            this.aJJ.u(this.aJM, this.zC);
            this.aJJ.start();
        }
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        az azVar;
        if (bannerThreadInfoData != null && (azVar = bannerThreadInfoData.threadData) != null && azVar.qW() != null && azVar.getAuthor() != null) {
            this.bOF = azVar;
            VideoInfo qW = azVar.qW();
            this.aJM = qW.video_url;
            this.zC = qW.video_duration.intValue();
            this.bOC = qW.thumbnail_url;
            MetaData author = azVar.getAuthor();
            this.aJK.setVisibility(0);
            this.aJW.setVisibility(0);
            this.aJL.setVisibility(0);
            this.aJN.setVisibility(8);
            this.aJJ.stopPlayback();
            this.bOG = qW.play_count.intValue();
            if (this.bOG > 0) {
                this.bOs.setVisibility(0);
                this.bOs.setText(ba.B(this.bOG));
            } else {
                this.bOs.setVisibility(8);
            }
            this.bOr.setText(azVar.getTitle());
            if (this.bOF.qJ()) {
                this.bOy.setIsGod(true);
            } else {
                this.bOy.setIsGod(false);
            }
            this.bOy.setData(this.bOF);
            this.aee.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aJK != null) {
            this.aJK.setImageBitmap(null);
        }
        if (this.bOy != null) {
            this.bOy.setImageBitmap(null);
        }
        if (this.aJJ != null) {
            this.aJJ.stopPlayback();
        }
    }
}

package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ah;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.t;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int Ct;
    private QuickVideoView aNV;
    private ImageView aNZ;
    private ah aNk;
    private String aPj;
    private TbImageView aRV;
    private TextView ahw;
    private View bKA;
    private View bKB;
    private View bKC;
    private String bKD;
    private int bKE;
    private int bKF;
    private bg bKG;
    private int bKH;
    private View bKp;
    private View bKq;
    private TextView bKr;
    private TextView bKs;
    private View bKt;
    private TextView bKu;
    private View bKv;
    private ProgressBar bKw;
    private View bKx;
    private View bKy;
    private ClickableHeaderImageView bKz;
    private AudioAnimationView bcl;
    private ImageView bcn;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bg getThreadInfo() {
        return this.bKG;
    }

    public String getVideoUrl() {
        return this.aPj;
    }

    public boolean isPlaying() {
        return this.aNV != null && this.aNV.isPlaying();
    }

    public int getBgResId() {
        return this.bKF;
    }

    public View getVideoContainer() {
        return this.bKp;
    }

    public c(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bKE = 1;
        this.bKH = 0;
        this.mOnClickListener = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(r.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.bKp = view.findViewById(r.g.video_view_layout);
        this.bKq = view.findViewById(r.g.black_mask);
        this.aRV = (TbImageView) view.findViewById(r.g.video_thumbnail);
        this.aRV.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.aNV = (QuickVideoView) view.findViewById(r.g.videoView);
        this.aNk = new ah(this.mContext);
        this.aNk.aWz();
        this.aNV.setBusiness(this.aNk);
        this.bcn = (ImageView) view.findViewById(r.g.video_list_loading_image);
        this.bKw = (ProgressBar) view.findViewById(r.g.loading_progress);
        this.bKv = view.findViewById(r.g.video_list_layout_loading);
        this.bcl = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcl.setCertainColumnCount(4);
        this.bcl.setColumnColor(r.d.cp_cont_i);
        this.bKt = view.findViewById(r.g.video_view_error_layout);
        this.bKu = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.bKy = view.findViewById(r.g.video_info_container);
        this.bKx = view.findViewById(r.g.video_info_layout);
        this.ahw = (TextView) view.findViewById(r.g.user_name);
        this.bKz = (ClickableHeaderImageView) view.findViewById(r.g.iv_user_avatar);
        this.bKz.setClickable(false);
        this.bKz.setIsGod(false);
        this.bKz.setBorderWidth(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        this.aNZ = (ImageView) view.findViewById(r.g.img_play);
        this.bKr = (TextView) view.findViewById(r.g.tv_video_info);
        this.bKs = (TextView) view.findViewById(r.g.tv_play_count);
        this.bKA = view.findViewById(r.g.blur_bg);
        this.bKB = view.findViewById(r.g.divider_1);
        this.bKC = view.findViewById(r.g.divider_2);
        this.aNZ.setOnClickListener(this.mOnClickListener);
        this.aNZ.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            ar.l(this.bKp, r.d.cp_bg_line_k);
            ar.l(this.bKq, r.d.cp_bg_line_k);
            ar.l(this.bKB, r.d.cp_bg_line_k_alpha5);
            ar.l(this.bKC, r.d.cp_bg_line_k_alpha10);
            ar.j((View) this.bKr, r.d.cp_cont_b);
            ar.j((View) this.ahw, r.d.cp_cont_b);
            ar.j((View) this.bKs, r.d.cp_cont_d);
            ar.c(this.aNZ, r.f.btn_icon_play_video_n);
            ar.c(this.bcn, r.f.btn_icon_video_n);
            ar.l(this.bKt, r.d.common_color_10014);
            ar.j((View) this.bKu, r.d.cp_cont_i);
            aan();
            this.mSkinType = i;
        }
    }

    public void aam() {
        if (this.aRV != null) {
            this.aRV.c(this.bKD, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.bKA != null) {
            this.bKA.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.bKF = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        ar.l(this.bKy, i);
    }

    private void aan() {
        if (this.bKz != null) {
            this.bKz.setBorderColor(ar.getColor(r.d.cp_bg_line_d_alpha70));
        }
        if (this.bKs != null) {
            this.bKs.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bKu != null) {
            this.bKu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aRV != null) {
            this.aRV.setDefaultErrorResource(0);
            this.aRV.setDefaultBgResource(r.f.pic_bg_video_frs);
        }
        if (this.bcl != null) {
            this.bcl.setColumnColor(r.d.cp_cont_i);
        }
    }

    public void aao() {
        if (this.bKs != null) {
            this.bKH++;
            if (this.bKH > 0) {
                this.bKs.setVisibility(0);
                this.bKs.setText(av.v(this.bKH));
                return;
            }
            this.bKs.setVisibility(8);
        }
    }

    public void a(t.d dVar, t.a aVar, t.b bVar) {
        this.aNV.setOnPreparedListener(dVar);
        this.aNV.setOnCompletionListener(aVar);
        this.aNV.setOnErrorListener(bVar);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.bKE = 1;
            this.aRV.setVisibility(0);
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(0);
            this.bKv.setVisibility(8);
            this.bKt.setVisibility(8);
            this.bcl.setVisibility(8);
            this.bcl.bkg();
        } else if (i == 2) {
            this.bKE = 2;
            this.aRV.setVisibility(0);
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(8);
            this.bKv.setVisibility(0);
            this.bKt.setVisibility(8);
            this.bcl.setVisibility(8);
            this.bcl.bkg();
        } else if (i == 3) {
            this.bKE = 3;
            this.aRV.setVisibility(8);
            this.bKq.setVisibility(8);
            this.aNZ.setVisibility(8);
            this.bKv.setVisibility(8);
            this.bKt.setVisibility(8);
            this.bcl.setVisibility(0);
            this.bcl.start();
        } else if (i == 4) {
            this.bKE = 4;
            this.aRV.setVisibility(0);
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(0);
            this.bKv.setVisibility(8);
            this.bKt.setVisibility(0);
            this.bcl.setVisibility(8);
            this.bcl.bkg();
        }
    }

    public void stopPlayback() {
        if (this.aNV != null) {
            setVideoPlayState(1);
            this.aNV.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aNV != null && this.aNV.isPlaying()) {
            setVideoPlayState(1);
            this.aNV.pause();
        }
    }

    public void startPlay() {
        if (this.aNV != null) {
            setVideoPlayState(2);
            this.aNV.setVideoPath(this.aPj);
            this.aNV.start();
        }
    }

    public void aap() {
        if (this.bKG != null) {
            at atVar = new at("c11717");
            atVar.g("fid", this.bKG.getFid());
            atVar.ab("obj_source", this.bKG.UJ);
            atVar.ab("obj_param2", this.bKG.UK);
            atVar.ab("obj_param1", this.bKG.UO);
            atVar.s("obj_locate", 2);
            atVar.ab("tid", this.bKG.getTid());
            bz.OH().a(atVar);
        }
    }

    private ax j(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.mLocate = "4";
        axVar.aRe = String.valueOf(bgVar.getFid());
        axVar.aRf = bgVar.getTid();
        return axVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bg bgVar;
        if (bannerThreadInfoData != null && (bgVar = bannerThreadInfoData.threadData) != null && bgVar.rW() != null && bgVar.getAuthor() != null) {
            if (this.aNk != null) {
                this.aNk.a(j(bgVar));
                if (this.aNk.aWA() != null) {
                    this.aNk.aWA().c(bgVar.rW());
                }
            }
            this.bKG = bgVar;
            VideoInfo rW = bgVar.rW();
            this.aPj = rW.video_url;
            this.Ct = rW.video_duration.intValue();
            this.bKD = rW.thumbnail_url;
            MetaData author = bgVar.getAuthor();
            this.aRV.setVisibility(0);
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(0);
            this.bKv.setVisibility(8);
            this.aNV.stopPlayback();
            this.bKH = rW.play_count.intValue();
            if (this.bKH > 0) {
                this.bKs.setVisibility(0);
                this.bKs.setText(av.v(this.bKH));
            } else {
                this.bKs.setVisibility(8);
            }
            this.bKr.setText(bgVar.getTitle());
            if (this.bKG.rH()) {
                this.bKz.setIsGod(true);
            } else {
                this.bKz.setIsGod(false);
            }
            this.bKz.setData(this.bKG);
            this.ahw.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aRV != null) {
            this.aRV.setImageBitmap(null);
        }
        if (this.bKz != null) {
            this.bKz.setImageBitmap(null);
        }
        if (this.aNV != null) {
            this.aNV.stopPlayback();
        }
    }

    public void setLooping(boolean z) {
        if (this.aNV != null) {
            this.aNV.setLooping(z);
        }
    }
}

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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends RelativeLayout {
    private int Cs;
    private String aMC;
    private TextureVideoView aPh;
    private TbImageView aPj;
    private ImageView aPk;
    private View aPl;
    private View aPt;
    private AudioAnimationView aZo;
    private ImageView aZq;
    private TextView ahN;
    private int cbA;
    private View cbk;
    private TextView cbl;
    private TextView cbm;
    private View cbn;
    private TextView cbo;
    private ProgressBar cbp;
    private View cbq;
    private View cbr;
    private ClickableHeaderImageView cbs;
    private View cbt;
    private View cbu;
    private View cbv;
    private String cbw;
    private int cbx;
    private int cby;
    private bg cbz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bg getThreadInfo() {
        return this.cbz;
    }

    public String getVideoUrl() {
        return this.aMC;
    }

    public boolean isPlaying() {
        return this.aPh != null && this.aPh.isPlaying();
    }

    public int getBgResId() {
        return this.cby;
    }

    public View getVideoContainer() {
        return this.cbk;
    }

    public e(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cbx = 1;
        this.cbA = 0;
        this.mOnClickListener = new f(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(t.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.cbk = view.findViewById(t.g.video_view_layout);
        this.aPt = view.findViewById(t.g.black_mask);
        this.aPj = (TbImageView) view.findViewById(t.g.video_thumbnail);
        this.aPj.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aPh = (TextureVideoView) view.findViewById(t.g.videoView);
        this.aPh.setAutoDownload(false);
        this.aZq = (ImageView) view.findViewById(t.g.video_list_loading_image);
        this.cbp = (ProgressBar) view.findViewById(t.g.loading_progress);
        this.aPl = view.findViewById(t.g.video_list_layout_loading);
        this.aZo = (AudioAnimationView) view.findViewById(t.g.auto_video_play_state);
        this.aZo.setCertainColumnCount(4);
        this.aZo.setColumnColor(t.d.cp_cont_i);
        this.cbn = view.findViewById(t.g.video_view_error_layout);
        this.cbo = (TextView) view.findViewById(t.g.auto_video_error_tips);
        this.cbr = view.findViewById(t.g.video_info_container);
        this.cbq = view.findViewById(t.g.video_info_layout);
        this.ahN = (TextView) view.findViewById(t.g.user_name);
        this.cbs = (ClickableHeaderImageView) view.findViewById(t.g.iv_user_avatar);
        this.cbs.setClickable(false);
        this.cbs.setIsGod(false);
        this.cbs.setBorderWidth(com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds4));
        this.aPk = (ImageView) view.findViewById(t.g.img_play);
        this.cbl = (TextView) view.findViewById(t.g.tv_video_info);
        this.cbm = (TextView) view.findViewById(t.g.tv_play_count);
        this.cbt = view.findViewById(t.g.blur_bg);
        this.cbu = view.findViewById(t.g.divider_1);
        this.cbv = view.findViewById(t.g.divider_2);
        this.aPk.setOnClickListener(this.mOnClickListener);
        this.aPk.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            av.l(this.cbk, t.d.cp_bg_line_k);
            av.l(this.aPt, t.d.cp_bg_line_k);
            av.l(this.cbu, t.d.cp_bg_line_k_alpha5);
            av.l(this.cbv, t.d.cp_bg_line_k_alpha10);
            av.j((View) this.cbl, t.d.cp_cont_b);
            av.j((View) this.ahN, t.d.cp_cont_b);
            av.j((View) this.cbm, t.d.cp_cont_d);
            av.c(this.aPk, t.f.btn_icon_play_video_n);
            av.c(this.aZq, t.f.btn_icon_video_n);
            av.l(this.cbn, t.d.common_color_10014);
            av.j((View) this.cbo, t.d.cp_cont_i);
            ael();
            this.mSkinType = i;
        }
    }

    public void aek() {
        if (this.aPj != null) {
            this.aPj.c(this.cbw, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.cbt != null) {
            this.cbt.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.cby = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        av.l(this.cbr, i);
    }

    private void ael() {
        if (this.cbs != null) {
            this.cbs.setBorderColor(av.getColor(t.d.cp_bg_line_d_alpha70));
        }
        if (this.cbm != null) {
            this.cbm.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cbo != null) {
            this.cbo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aPj != null) {
            this.aPj.setDefaultErrorResource(0);
            this.aPj.setDefaultBgResource(t.f.pic_bg_video_frs);
        }
        if (this.aZo != null) {
            this.aZo.setColumnColor(t.d.cp_cont_i);
        }
    }

    public void aem() {
        if (this.cbm != null) {
            this.cbA++;
            if (this.cbA > 0) {
                this.cbm.setVisibility(0);
                this.cbm.setText(ba.w(this.cbA));
                return;
            }
            this.cbm.setVisibility(8);
        }
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        this.aPh.setOnPreparedListener(onPreparedListener);
        this.aPh.setOnCompletionListener(onCompletionListener);
        this.aPh.setOnErrorListener(onErrorListener);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.cbx = 1;
            this.aPj.setVisibility(0);
            this.aPt.setVisibility(0);
            this.aPk.setVisibility(0);
            this.aPl.setVisibility(8);
            this.cbn.setVisibility(8);
            this.aZo.setVisibility(8);
            this.aZo.bqi();
        } else if (i == 2) {
            this.cbx = 2;
            this.aPj.setVisibility(0);
            this.aPt.setVisibility(0);
            this.aPk.setVisibility(8);
            this.aPl.setVisibility(0);
            this.cbn.setVisibility(8);
            this.aZo.setVisibility(8);
            this.aZo.bqi();
        } else if (i == 3) {
            this.cbx = 3;
            this.aPj.setVisibility(8);
            this.aPt.setVisibility(8);
            this.aPk.setVisibility(8);
            this.aPl.setVisibility(8);
            this.cbn.setVisibility(8);
            this.aZo.setVisibility(0);
            this.aZo.start();
        } else if (i == 4) {
            this.cbx = 4;
            this.aPj.setVisibility(0);
            this.aPt.setVisibility(0);
            this.aPk.setVisibility(0);
            this.aPl.setVisibility(8);
            this.cbn.setVisibility(0);
            this.aZo.setVisibility(8);
            this.aZo.bqi();
        }
    }

    public void stopPlayback() {
        if (this.aPh != null) {
            setVideoPlayState(1);
            this.aPh.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aPh != null && this.aPh.isPlaying()) {
            setVideoPlayState(1);
            this.aPh.pause();
        }
    }

    public void Kz() {
        if (this.aPh != null) {
            setVideoPlayState(2);
            this.aPh.setVideoPathNoCache(this.aMC);
            this.aPh.start();
        }
    }

    private TextureVideoView.c h(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        TextureVideoView.c cVar = new TextureVideoView.c();
        cVar.mLocate = "4";
        cVar.ahj = String.valueOf(bgVar.getFid());
        cVar.ahi = bgVar.getTid();
        return cVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bg bgVar;
        if (bannerThreadInfoData != null && (bgVar = bannerThreadInfoData.threadData) != null && bgVar.rR() != null && bgVar.getAuthor() != null) {
            this.aPh.setVideoStatsData(h(bgVar));
            this.cbz = bgVar;
            VideoInfo rR = bgVar.rR();
            this.aMC = rR.video_url;
            this.Cs = rR.video_duration.intValue();
            this.cbw = rR.thumbnail_url;
            MetaData author = bgVar.getAuthor();
            this.aPj.setVisibility(0);
            this.aPt.setVisibility(0);
            this.aPk.setVisibility(0);
            this.aPl.setVisibility(8);
            this.aPh.stopPlayback();
            this.cbA = rR.play_count.intValue();
            if (this.cbA > 0) {
                this.cbm.setVisibility(0);
                this.cbm.setText(ba.w(this.cbA));
            } else {
                this.cbm.setVisibility(8);
            }
            this.cbl.setText(bgVar.getTitle());
            if (this.cbz.rD()) {
                this.cbs.setIsGod(true);
            } else {
                this.cbs.setIsGod(false);
            }
            this.cbs.setData(this.cbz);
            this.ahN.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aPj != null) {
            this.aPj.setImageBitmap(null);
        }
        if (this.cbs != null) {
            this.cbs.setImageBitmap(null);
        }
        if (this.aPh != null) {
            this.aPh.stopPlayback();
        }
    }
}

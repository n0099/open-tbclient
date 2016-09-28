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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ad;
import com.baidu.tieba.play.e;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends RelativeLayout {
    private int Cs;
    private com.baidu.tieba.play.s aLZ;
    private QuickVideoView aMF;
    private ImageView aMJ;
    private String aNM;
    private View aQH;
    private TbImageView aQx;
    private View aQy;
    private AudioAnimationView aZJ;
    private ImageView aZL;
    private TextView ahv;
    private int cbA;
    private bi cbB;
    private int cbC;
    private View cbm;
    private TextView cbn;
    private TextView cbo;
    private View cbp;
    private TextView cbq;
    private ProgressBar cbr;
    private View cbs;
    private View cbt;
    private ClickableHeaderImageView cbu;
    private View cbv;
    private View cbw;
    private View cbx;
    private String cby;
    private int cbz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bi getThreadInfo() {
        return this.cbB;
    }

    public String getVideoUrl() {
        return this.aNM;
    }

    public boolean isPlaying() {
        return this.aMF != null && this.aMF.isPlaying();
    }

    public int getBgResId() {
        return this.cbA;
    }

    public View getVideoContainer() {
        return this.cbm;
    }

    public e(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cbz = 1;
        this.cbC = 0;
        this.mOnClickListener = new f(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(r.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.cbm = view.findViewById(r.g.video_view_layout);
        this.aQH = view.findViewById(r.g.black_mask);
        this.aQx = (TbImageView) view.findViewById(r.g.video_thumbnail);
        this.aQx.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.aMF = (QuickVideoView) view.findViewById(r.g.videoView);
        this.aLZ = new com.baidu.tieba.play.s(this.mContext);
        this.aLZ.bau();
        this.aMF.setBusiness(this.aLZ);
        this.aZL = (ImageView) view.findViewById(r.g.video_list_loading_image);
        this.cbr = (ProgressBar) view.findViewById(r.g.loading_progress);
        this.aQy = view.findViewById(r.g.video_list_layout_loading);
        this.aZJ = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.aZJ.setCertainColumnCount(4);
        this.aZJ.setColumnColor(r.d.cp_cont_i);
        this.cbp = view.findViewById(r.g.video_view_error_layout);
        this.cbq = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.cbt = view.findViewById(r.g.video_info_container);
        this.cbs = view.findViewById(r.g.video_info_layout);
        this.ahv = (TextView) view.findViewById(r.g.user_name);
        this.cbu = (ClickableHeaderImageView) view.findViewById(r.g.iv_user_avatar);
        this.cbu.setClickable(false);
        this.cbu.setIsGod(false);
        this.cbu.setBorderWidth(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        this.aMJ = (ImageView) view.findViewById(r.g.img_play);
        this.cbn = (TextView) view.findViewById(r.g.tv_video_info);
        this.cbo = (TextView) view.findViewById(r.g.tv_play_count);
        this.cbv = view.findViewById(r.g.blur_bg);
        this.cbw = view.findViewById(r.g.divider_1);
        this.cbx = view.findViewById(r.g.divider_2);
        this.aMJ.setOnClickListener(this.mOnClickListener);
        this.aMJ.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            av.l(this.cbm, r.d.cp_bg_line_k);
            av.l(this.aQH, r.d.cp_bg_line_k);
            av.l(this.cbw, r.d.cp_bg_line_k_alpha5);
            av.l(this.cbx, r.d.cp_bg_line_k_alpha10);
            av.j((View) this.cbn, r.d.cp_cont_b);
            av.j((View) this.ahv, r.d.cp_cont_b);
            av.j((View) this.cbo, r.d.cp_cont_d);
            av.c(this.aMJ, r.f.btn_icon_play_video_n);
            av.c(this.aZL, r.f.btn_icon_video_n);
            av.l(this.cbp, r.d.common_color_10014);
            av.j((View) this.cbq, r.d.cp_cont_i);
            aeA();
            this.mSkinType = i;
        }
    }

    public void aez() {
        if (this.aQx != null) {
            this.aQx.c(this.cby, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.cbv != null) {
            this.cbv.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.cbA = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        av.l(this.cbt, i);
    }

    private void aeA() {
        if (this.cbu != null) {
            this.cbu.setBorderColor(av.getColor(r.d.cp_bg_line_d_alpha70));
        }
        if (this.cbo != null) {
            this.cbo.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.cbq != null) {
            this.cbq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aQx != null) {
            this.aQx.setDefaultErrorResource(0);
            this.aQx.setDefaultBgResource(r.f.pic_bg_video_frs);
        }
        if (this.aZJ != null) {
            this.aZJ.setColumnColor(r.d.cp_cont_i);
        }
    }

    public void aeB() {
        if (this.cbo != null) {
            this.cbC++;
            if (this.cbC > 0) {
                this.cbo.setVisibility(0);
                this.cbo.setText(az.w(this.cbC));
                return;
            }
            this.cbo.setVisibility(8);
        }
    }

    public void a(e.d dVar, e.a aVar, e.b bVar) {
        this.aMF.setOnPreparedListener(dVar);
        this.aMF.setOnCompletionListener(aVar);
        this.aMF.setOnErrorListener(bVar);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.cbz = 1;
            this.aQx.setVisibility(0);
            this.aQH.setVisibility(0);
            this.aMJ.setVisibility(0);
            this.aQy.setVisibility(8);
            this.cbp.setVisibility(8);
            this.aZJ.setVisibility(8);
            this.aZJ.bqM();
        } else if (i == 2) {
            this.cbz = 2;
            this.aQx.setVisibility(0);
            this.aQH.setVisibility(0);
            this.aMJ.setVisibility(8);
            this.aQy.setVisibility(0);
            this.cbp.setVisibility(8);
            this.aZJ.setVisibility(8);
            this.aZJ.bqM();
        } else if (i == 3) {
            this.cbz = 3;
            this.aQx.setVisibility(8);
            this.aQH.setVisibility(8);
            this.aMJ.setVisibility(8);
            this.aQy.setVisibility(8);
            this.cbp.setVisibility(8);
            this.aZJ.setVisibility(0);
            this.aZJ.start();
        } else if (i == 4) {
            this.cbz = 4;
            this.aQx.setVisibility(0);
            this.aQH.setVisibility(0);
            this.aMJ.setVisibility(0);
            this.aQy.setVisibility(8);
            this.cbp.setVisibility(0);
            this.aZJ.setVisibility(8);
            this.aZJ.bqM();
        }
    }

    public void stopPlayback() {
        if (this.aMF != null) {
            setVideoPlayState(1);
            this.aMF.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aMF != null && this.aMF.isPlaying()) {
            setVideoPlayState(1);
            this.aMF.pause();
        }
    }

    public void Js() {
        if (this.aMF != null) {
            setVideoPlayState(2);
            this.aMF.setVideoPath(this.aNM);
            this.aMF.start();
        }
    }

    private ad i(bi biVar) {
        if (biVar == null) {
            return null;
        }
        ad adVar = new ad();
        adVar.mLocate = "4";
        adVar.aPG = String.valueOf(biVar.getFid());
        adVar.aPH = biVar.getTid();
        return adVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bi biVar;
        if (bannerThreadInfoData != null && (biVar = bannerThreadInfoData.threadData) != null && biVar.sd() != null && biVar.getAuthor() != null) {
            if (this.aLZ != null) {
                this.aLZ.a(i(biVar));
                if (this.aLZ.bav() != null) {
                    this.aLZ.bav().c(biVar.sd());
                }
            }
            this.cbB = biVar;
            VideoInfo sd = biVar.sd();
            this.aNM = sd.video_url;
            this.Cs = sd.video_duration.intValue();
            this.cby = sd.thumbnail_url;
            MetaData author = biVar.getAuthor();
            this.aQx.setVisibility(0);
            this.aQH.setVisibility(0);
            this.aMJ.setVisibility(0);
            this.aQy.setVisibility(8);
            this.aMF.stopPlayback();
            this.cbC = sd.play_count.intValue();
            if (this.cbC > 0) {
                this.cbo.setVisibility(0);
                this.cbo.setText(az.w(this.cbC));
            } else {
                this.cbo.setVisibility(8);
            }
            this.cbn.setText(biVar.getTitle());
            if (this.cbB.rP()) {
                this.cbu.setIsGod(true);
            } else {
                this.cbu.setIsGod(false);
            }
            this.cbu.setData(this.cbB);
            this.ahv.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aQx != null) {
            this.aQx.setImageBitmap(null);
        }
        if (this.cbu != null) {
            this.cbu.setImageBitmap(null);
        }
        if (this.aMF != null) {
            this.aMF.stopPlayback();
        }
    }
}

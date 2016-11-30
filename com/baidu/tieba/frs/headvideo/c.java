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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ah;
import com.baidu.tieba.play.t;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int Cs;
    private ah aNT;
    private QuickVideoView aOE;
    private ImageView aOI;
    private String aPS;
    private TbImageView aSE;
    private TextView ahV;
    private AudioAnimationView bcT;
    private ImageView bcV;
    private View ceG;
    private View ceH;
    private TextView ceI;
    private TextView ceJ;
    private View ceK;
    private TextView ceL;
    private View ceM;
    private ProgressBar ceN;
    private View ceO;
    private View ceP;
    private ClickableHeaderImageView ceQ;
    private View ceR;
    private View ceS;
    private View ceT;
    private String ceU;
    private int ceV;
    private int ceW;
    private bk ceX;
    private int ceY;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bk getThreadInfo() {
        return this.ceX;
    }

    public String getVideoUrl() {
        return this.aPS;
    }

    public boolean isPlaying() {
        return this.aOE != null && this.aOE.isPlaying();
    }

    public int getBgResId() {
        return this.ceW;
    }

    public View getVideoContainer() {
        return this.ceG;
    }

    public c(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ceV = 1;
        this.ceY = 0;
        this.mOnClickListener = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(r.h.forum_head_video_item, this);
        View view = this.mRootView;
        this.ceG = view.findViewById(r.g.video_view_layout);
        this.ceH = view.findViewById(r.g.black_mask);
        this.aSE = (TbImageView) view.findViewById(r.g.video_thumbnail);
        this.aSE.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.aOE = (QuickVideoView) view.findViewById(r.g.videoView);
        this.aNT = new ah(this.mContext);
        this.aNT.bcS();
        this.aOE.setBusiness(this.aNT);
        this.bcV = (ImageView) view.findViewById(r.g.video_list_loading_image);
        this.ceN = (ProgressBar) view.findViewById(r.g.loading_progress);
        this.ceM = view.findViewById(r.g.video_list_layout_loading);
        this.bcT = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcT.setCertainColumnCount(4);
        this.bcT.setColumnColor(r.d.cp_cont_i);
        this.ceK = view.findViewById(r.g.video_view_error_layout);
        this.ceL = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.ceP = view.findViewById(r.g.video_info_container);
        this.ceO = view.findViewById(r.g.video_info_layout);
        this.ahV = (TextView) view.findViewById(r.g.user_name);
        this.ceQ = (ClickableHeaderImageView) view.findViewById(r.g.iv_user_avatar);
        this.ceQ.setClickable(false);
        this.ceQ.setIsGod(false);
        this.ceQ.setBorderWidth(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        this.aOI = (ImageView) view.findViewById(r.g.img_play);
        this.ceI = (TextView) view.findViewById(r.g.tv_video_info);
        this.ceJ = (TextView) view.findViewById(r.g.tv_play_count);
        this.ceR = view.findViewById(r.g.blur_bg);
        this.ceS = view.findViewById(r.g.divider_1);
        this.ceT = view.findViewById(r.g.divider_2);
        this.aOI.setOnClickListener(this.mOnClickListener);
        this.aOI.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (this.mSkinType != i) {
            at.l(this.ceG, r.d.cp_bg_line_k);
            at.l(this.ceH, r.d.cp_bg_line_k);
            at.l(this.ceS, r.d.cp_bg_line_k_alpha5);
            at.l(this.ceT, r.d.cp_bg_line_k_alpha10);
            at.j((View) this.ceI, r.d.cp_cont_b);
            at.j((View) this.ahV, r.d.cp_cont_b);
            at.j((View) this.ceJ, r.d.cp_cont_d);
            at.c(this.aOI, r.f.btn_icon_play_video_n);
            at.c(this.bcV, r.f.btn_icon_video_n);
            at.l(this.ceK, r.d.common_color_10014);
            at.j((View) this.ceL, r.d.cp_cont_i);
            afR();
            this.mSkinType = i;
        }
    }

    public void afQ() {
        if (this.aSE != null) {
            this.aSE.c(this.ceU, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.ceR != null) {
            this.ceR.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.ceW = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        at.l(this.ceP, i);
    }

    private void afR() {
        if (this.ceQ != null) {
            this.ceQ.setBorderColor(at.getColor(r.d.cp_bg_line_d_alpha70));
        }
        if (this.ceJ != null) {
            this.ceJ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.ceL != null) {
            this.ceL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.aSE != null) {
            this.aSE.setDefaultErrorResource(0);
            this.aSE.setDefaultBgResource(r.f.pic_bg_video_frs);
        }
        if (this.bcT != null) {
            this.bcT.setColumnColor(r.d.cp_cont_i);
        }
    }

    public void afS() {
        if (this.ceJ != null) {
            this.ceY++;
            if (this.ceY > 0) {
                this.ceJ.setVisibility(0);
                this.ceJ.setText(ax.v(this.ceY));
                return;
            }
            this.ceJ.setVisibility(8);
        }
    }

    public void a(t.d dVar, t.a aVar, t.b bVar) {
        this.aOE.setOnPreparedListener(dVar);
        this.aOE.setOnCompletionListener(aVar);
        this.aOE.setOnErrorListener(bVar);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.ceV = 1;
            this.aSE.setVisibility(0);
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(0);
            this.ceM.setVisibility(8);
            this.ceK.setVisibility(8);
            this.bcT.setVisibility(8);
            this.bcT.btg();
        } else if (i == 2) {
            this.ceV = 2;
            this.aSE.setVisibility(0);
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(8);
            this.ceM.setVisibility(0);
            this.ceK.setVisibility(8);
            this.bcT.setVisibility(8);
            this.bcT.btg();
        } else if (i == 3) {
            this.ceV = 3;
            this.aSE.setVisibility(8);
            this.ceH.setVisibility(8);
            this.aOI.setVisibility(8);
            this.ceM.setVisibility(8);
            this.ceK.setVisibility(8);
            this.bcT.setVisibility(0);
            this.bcT.start();
        } else if (i == 4) {
            this.ceV = 4;
            this.aSE.setVisibility(0);
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(0);
            this.ceM.setVisibility(8);
            this.ceK.setVisibility(0);
            this.bcT.setVisibility(8);
            this.bcT.btg();
        }
    }

    public void stopPlayback() {
        if (this.aOE != null) {
            setVideoPlayState(1);
            this.aOE.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aOE != null && this.aOE.isPlaying()) {
            setVideoPlayState(1);
            this.aOE.pause();
        }
    }

    public void JT() {
        if (this.aOE != null) {
            setVideoPlayState(2);
            this.aOE.setVideoPath(this.aPS);
            this.aOE.start();
        }
    }

    public void afT() {
        if (this.ceX != null) {
            av avVar = new av("c11717");
            avVar.g("fid", this.ceX.getFid());
            avVar.ab("obj_source", this.ceX.Vl);
            avVar.ab("obj_param2", this.ceX.Vm);
            avVar.ab("obj_param1", this.ceX.Vq);
            avVar.s("obj_locate", 2);
            avVar.ab("tid", this.ceX.getTid());
            bx.Pl().a(avVar);
        }
    }

    private com.baidu.tieba.play.ax e(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        com.baidu.tieba.play.ax axVar = new com.baidu.tieba.play.ax();
        axVar.mLocate = "4";
        axVar.aRN = String.valueOf(bkVar.getFid());
        axVar.aRO = bkVar.getTid();
        return axVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bk bkVar;
        if (bannerThreadInfoData != null && (bkVar = bannerThreadInfoData.threadData) != null && bkVar.sf() != null && bkVar.getAuthor() != null) {
            if (this.aNT != null) {
                this.aNT.a(e(bkVar));
                if (this.aNT.bcT() != null) {
                    this.aNT.bcT().c(bkVar.sf());
                }
            }
            this.ceX = bkVar;
            VideoInfo sf = bkVar.sf();
            this.aPS = sf.video_url;
            this.Cs = sf.video_duration.intValue();
            this.ceU = sf.thumbnail_url;
            MetaData author = bkVar.getAuthor();
            this.aSE.setVisibility(0);
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(0);
            this.ceM.setVisibility(8);
            this.aOE.stopPlayback();
            this.ceY = sf.play_count.intValue();
            if (this.ceY > 0) {
                this.ceJ.setVisibility(0);
                this.ceJ.setText(ax.v(this.ceY));
            } else {
                this.ceJ.setVisibility(8);
            }
            this.ceI.setText(bkVar.getTitle());
            if (this.ceX.rR()) {
                this.ceQ.setIsGod(true);
            } else {
                this.ceQ.setIsGod(false);
            }
            this.ceQ.setData(this.ceX);
            this.ahV.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.aSE != null) {
            this.aSE.setImageBitmap(null);
        }
        if (this.ceQ != null) {
            this.ceQ.setImageBitmap(null);
        }
        if (this.aOE != null) {
            this.aOE.stopPlayback();
        }
    }

    public void setLooping(boolean z) {
        if (this.aOE != null) {
            this.aOE.setLooping(z);
        }
    }
}

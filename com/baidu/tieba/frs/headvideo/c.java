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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.v;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int BF;
    private QuickVideoView aMY;
    private aj aMm;
    private ImageView aNc;
    private String aOm;
    private TextView agJ;
    private View bQH;
    private View bQI;
    private TbImageView bQJ;
    private TextView bQK;
    private TextView bQL;
    private View bQM;
    private TextView bQN;
    private View bQO;
    private ProgressBar bQP;
    private View bQQ;
    private View bQR;
    private ClickableHeaderImageView bQS;
    private View bQT;
    private View bQU;
    private View bQV;
    private String bQW;
    private int bQX;
    private int bQY;
    private bh bQZ;
    private int bRa;
    private AudioAnimationView bma;
    private ImageView bmc;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public bh getThreadInfo() {
        return this.bQZ;
    }

    public String getVideoUrl() {
        return this.aOm;
    }

    public boolean isPlaying() {
        return this.aMY != null && this.aMY.isPlaying();
    }

    public int getBgResId() {
        return this.bQY;
    }

    public View getVideoContainer() {
        return this.bQH;
    }

    public c(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bQX = 1;
        this.bRa = 0;
        this.mOnClickListener = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(r.j.forum_head_video_item, this);
        View view = this.mRootView;
        this.bQH = view.findViewById(r.h.video_view_layout);
        this.bQI = view.findViewById(r.h.black_mask);
        this.bQJ = (TbImageView) view.findViewById(r.h.video_thumbnail);
        this.bQJ.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.aMY = (QuickVideoView) view.findViewById(r.h.videoView);
        this.aMm = new aj(this.mContext);
        this.aMm.aYm();
        this.aMY.setBusiness(this.aMm);
        this.bmc = (ImageView) view.findViewById(r.h.video_list_loading_image);
        this.bQP = (ProgressBar) view.findViewById(r.h.loading_progress);
        this.bQO = view.findViewById(r.h.video_list_layout_loading);
        this.bma = (AudioAnimationView) view.findViewById(r.h.auto_video_play_state);
        this.bma.setCertainColumnCount(4);
        this.bma.setColumnColor(r.e.cp_cont_i);
        this.bQM = view.findViewById(r.h.video_view_error_layout);
        this.bQN = (TextView) view.findViewById(r.h.auto_video_error_tips);
        this.bQR = view.findViewById(r.h.video_info_container);
        this.bQQ = view.findViewById(r.h.video_info_layout);
        this.agJ = (TextView) view.findViewById(r.h.user_name);
        this.bQS = (ClickableHeaderImageView) view.findViewById(r.h.iv_user_avatar);
        this.bQS.setClickable(false);
        this.bQS.setIsGod(false);
        this.bQS.setBorderWidth(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds4));
        this.aNc = (ImageView) view.findViewById(r.h.img_play);
        this.bQK = (TextView) view.findViewById(r.h.tv_video_info);
        this.bQL = (TextView) view.findViewById(r.h.tv_play_count);
        this.bQT = view.findViewById(r.h.blur_bg);
        this.bQU = view.findViewById(r.h.divider_1);
        this.bQV = view.findViewById(r.h.divider_2);
        this.aNc.setOnClickListener(this.mOnClickListener);
        this.aNc.setClickable(false);
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        if (this.mSkinType != i) {
            ap.k(this.bQH, r.e.cp_bg_line_k);
            ap.k(this.bQI, r.e.cp_bg_line_k);
            ap.k(this.bQU, r.e.cp_bg_line_k_alpha5);
            ap.k(this.bQV, r.e.cp_bg_line_k_alpha10);
            ap.i((View) this.bQK, r.e.cp_cont_b);
            ap.i((View) this.agJ, r.e.cp_cont_b);
            ap.i((View) this.bQL, r.e.cp_cont_d);
            ap.c(this.aNc, r.g.btn_icon_play_video_n);
            ap.c(this.bmc, r.g.btn_icon_video_n);
            ap.k(this.bQM, r.e.common_color_10014);
            ap.i((View) this.bQN, r.e.cp_cont_i);
            abs();
            this.mSkinType = i;
        }
    }

    public void abr() {
        if (this.bQJ != null) {
            this.bQJ.c(this.bQW, 10, false);
        }
    }

    public void setVideoBlurViewBackgroundDrawable(Drawable drawable) {
        if (this.bQT != null) {
            this.bQT.setBackgroundDrawable(drawable);
        }
    }

    public void setVideoBlurViewBackgroundResId(int i) {
        this.bQY = i;
    }

    public void setVideoBlurViewMaskColor(int i) {
        ap.k(this.bQR, i);
    }

    private void abs() {
        if (this.bQS != null) {
            this.bQS.setBorderColor(ap.getColor(r.e.cp_bg_line_d_alpha70));
        }
        if (this.bQL != null) {
            this.bQL.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_video_num_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bQN != null) {
            this.bQN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        if (this.bQJ != null) {
            this.bQJ.setDefaultErrorResource(0);
            this.bQJ.setDefaultBgResource(r.g.pic_bg_video_frs);
        }
        if (this.bma != null) {
            this.bma.setColumnColor(r.e.cp_cont_i);
        }
    }

    public void abt() {
        if (this.bQL != null) {
            this.bRa++;
            if (this.bRa > 0) {
                this.bQL.setVisibility(0);
                this.bQL.setText(at.u(this.bRa));
                return;
            }
            this.bQL.setVisibility(8);
        }
    }

    public void a(v.d dVar, v.a aVar, v.b bVar) {
        this.aMY.setOnPreparedListener(dVar);
        this.aMY.setOnCompletionListener(aVar);
        this.aMY.setOnErrorListener(bVar);
    }

    public void setVideoPlayState(int i) {
        if (i == 1) {
            this.bQX = 1;
            this.bQJ.setVisibility(0);
            this.bQI.setVisibility(0);
            this.aNc.setVisibility(0);
            this.bQO.setVisibility(8);
            this.bQM.setVisibility(8);
            this.bma.setVisibility(8);
            this.bma.blL();
        } else if (i == 2) {
            this.bQX = 2;
            this.bQJ.setVisibility(0);
            this.bQI.setVisibility(0);
            this.aNc.setVisibility(8);
            this.bQO.setVisibility(0);
            this.bQM.setVisibility(8);
            this.bma.setVisibility(8);
            this.bma.blL();
        } else if (i == 3) {
            this.bQX = 3;
            this.bQJ.setVisibility(8);
            this.bQI.setVisibility(8);
            this.aNc.setVisibility(8);
            this.bQO.setVisibility(8);
            this.bQM.setVisibility(8);
            this.bma.setVisibility(0);
            this.bma.start();
        } else if (i == 4) {
            this.bQX = 4;
            this.bQJ.setVisibility(0);
            this.bQI.setVisibility(0);
            this.aNc.setVisibility(0);
            this.bQO.setVisibility(8);
            this.bQM.setVisibility(0);
            this.bma.setVisibility(8);
            this.bma.blL();
        }
    }

    public void stopPlayback() {
        if (this.aMY != null) {
            setVideoPlayState(1);
            this.aMY.stopPlayback();
        }
    }

    public void pausePlay() {
        if (this.aMY != null && this.aMY.isPlaying()) {
            setVideoPlayState(1);
            this.aMY.pause();
        }
    }

    public void startPlay() {
        if (this.aMY != null) {
            setVideoPlayState(2);
            this.aMY.setVideoPath(this.aOm);
            this.aMY.start();
        }
    }

    public void abu() {
        if (this.bQZ != null) {
            ar arVar = new ar("c11717");
            arVar.g("fid", this.bQZ.getFid());
            arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bQZ.TW);
            arVar.ab("obj_param2", this.bQZ.TX);
            arVar.ab("obj_param1", this.bQZ.Ub);
            arVar.s("obj_locate", 2);
            arVar.ab("tid", this.bQZ.getTid());
            cc.Rx().a(arVar);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0037: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bo : 0x0033: INVOKE  (r2v0 com.baidu.tbadk.core.data.bo A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bh) type: VIRTUAL call: com.baidu.tbadk.core.data.bh.sz():com.baidu.tbadk.core.data.bo)
     com.baidu.tbadk.core.data.bo.channelId long)] */
    private bb j(bh bhVar) {
        bb bbVar = null;
        if (bhVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "4";
            bbVar.bjT = String.valueOf(bhVar.getFid());
            bbVar.bjS = bhVar.getTid();
            if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
                bbVar.Ql = new StringBuilder().append(bhVar.sz().channelId).toString();
            }
        }
        return bbVar;
    }

    public void a(BannerThreadInfoData bannerThreadInfoData) {
        bh bhVar;
        if (bannerThreadInfoData != null && (bhVar = bannerThreadInfoData.threadData) != null && bhVar.rN() != null && bhVar.getAuthor() != null) {
            if (this.aMm != null) {
                this.aMm.a(j(bhVar));
                if (this.aMm.aYn() != null) {
                    this.aMm.aYn().c(bhVar.rN());
                }
            }
            this.bQZ = bhVar;
            VideoInfo rN = bhVar.rN();
            this.aOm = rN.video_url;
            this.BF = rN.video_duration.intValue();
            this.bQW = rN.thumbnail_url;
            MetaData author = bhVar.getAuthor();
            this.bQJ.setVisibility(0);
            this.bQI.setVisibility(0);
            this.aNc.setVisibility(0);
            this.bQO.setVisibility(8);
            this.aMY.stopPlayback();
            this.bRa = rN.play_count.intValue();
            if (this.bRa > 0) {
                this.bQL.setVisibility(0);
                this.bQL.setText(at.u(this.bRa));
            } else {
                this.bQL.setVisibility(8);
            }
            this.bQK.setText(bhVar.getTitle());
            if (this.bQZ.rz()) {
                this.bQS.setIsGod(true);
            } else {
                this.bQS.setIsGod(false);
            }
            this.bQS.setData(this.bQZ);
            this.agJ.setText(author.getName_show());
        }
    }

    public void onDestory() {
        if (this.bQJ != null) {
            this.bQJ.setImageBitmap(null);
        }
        if (this.bQS != null) {
            this.bQS.setImageBitmap(null);
        }
        if (this.aMY != null) {
            this.aMY.stopPlayback();
        }
    }

    public void setLooping(boolean z) {
        if (this.aMY != null) {
            this.aMY.setLooping(z);
        }
    }
}

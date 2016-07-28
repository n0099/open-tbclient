package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class z extends a<com.baidu.tieba.card.a.o> {
    private TbPageContext<?> DQ;
    private String aKF;
    private boolean aKR;
    public ViewStub aSW;
    public TbImageView aSX;
    public ClickableHeaderImageView aTU;
    public ThreadCommentAndPraiseInfoLayout aTV;
    public FrameLayout aTW;
    public UserIconLayout aTX;
    protected LinearLayout aTY;
    private RelativeLayout aTZ;
    private View aUa;
    private TbImageView aUb;
    private ImageView aUc;
    private TextureVideoView aUd;
    private TextView aUe;
    private View aUf;
    private AudioAnimationView aUg;
    private ProgressBar aUh;
    private ImageView aUi;
    private com.baidu.tieba.card.a.o aUj;
    private View aUk;
    private int aUl;
    private int aUm;
    private boolean aUn;
    private Handler aUo;
    private TbImageView.a aUp;
    private Runnable aUq;
    private Runnable aUr;
    private CustomMessageListener aUs;
    private CustomMessageListener aUt;
    private MediaPlayer.OnPreparedListener adP;
    private MediaPlayer.OnErrorListener adR;
    private TextureVideoView.b adX;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    private int mSkinType;
    private TextView mTextTitle;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aUl = 0;
        this.aUm = 1;
        this.aKR = false;
        this.aUn = false;
        this.aUo = new aa(this, Looper.getMainLooper());
        this.adP = new ad(this);
        this.adR = new ae(this);
        this.aUp = new af(this);
        this.aUq = new ag(this);
        this.aUr = new ah(this);
        this.adX = new ai(this);
        this.aeW = new aj(this);
        this.aUs = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aUt = new ab(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.aez = new ac(this);
        this.DQ = tbPageContext;
        View view = getView();
        this.aTZ = (RelativeLayout) view.findViewById(u.g.layout_root);
        this.aUa = view.findViewById(u.g.divider);
        this.aTU = (ClickableHeaderImageView) view.findViewById(u.g.image_user);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aTU.setDefaultResource(17170445);
        this.aTU.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aTU.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aTU.setRadius(com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds70));
        this.aTX = (UserIconLayout) view.findViewById(u.g.text_user_name);
        this.aUh = (ProgressBar) view.findViewById(u.g.auto_video_loading_progress);
        this.aUi = (ImageView) view.findViewById(u.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.aTV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aTW = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aUb = (TbImageView) view.findViewById(u.g.image_video);
        this.aUb.setDefaultErrorResource(0);
        this.aUb.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aUb.setEvent(this.aUp);
        this.aUc = (ImageView) view.findViewById(u.g.image_video_play);
        this.aUg = (AudioAnimationView) view.findViewById(u.g.auto_video_play_state);
        this.aUg.setCertainColumnCount(4);
        this.aUg.setColumnColor(u.d.cp_cont_i);
        this.aTZ.setOnClickListener(this);
        this.aTW.setOnClickListener(this);
        this.aUd = (TextureVideoView) view.findViewById(u.g.texture_video_view);
        this.aUd.setEnableRefresh(true);
        this.aUd.setOnPreparedListener(this.adP);
        this.aUd.setOnErrorListener(this.adR);
        this.aUd.setOnSurfaceDestroyedListener(this.adX);
        this.aUk = view.findViewById(u.g.auto_video_black_mask);
        this.aUe = (TextView) view.findViewById(u.g.auto_video_error_tips);
        this.aUf = view.findViewById(u.g.auto_video_error_background);
        this.aTY = (LinearLayout) view.findViewById(u.g.video_card_content_layout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aTZ) {
            U(view);
        } else if (view == this.aTW) {
            V(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aTV != null) {
            this.aTV.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (KN() != null) {
            KN().a(view, this.aUj);
        }
        if (this.aUj != null && this.aUj.aWa != null) {
            if (!KT()) {
                at.hb(this.aUj.aWa.getId());
            }
            this.DQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DQ.getPageActivity()).createFromThreadCfg(this.aUj.aWa, null, at.La(), 18003, true, false, false).addLocateParam(this.aUj.Lh())));
        }
    }

    private boolean KT() {
        return this.aUj.aWs && !this.aUj.aWE;
    }

    private void V(View view) {
        if (this.aUj != null && this.aUj.aWa != null && this.aUj.aWa.qM() != null) {
            bx<com.baidu.tieba.card.a.o> KN = KN();
            if (KN != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                KN.a(view, this.aUj);
            }
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.DQ.getPageActivity()).createNormalCfg(String.valueOf(this.aUj.aWa.getFid()), this.aUj.aWa.getTid(), "index")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_auto_video_view;
    }

    public void a(com.baidu.tieba.card.a.o oVar) {
        this.aUj = oVar;
        KW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        this.aUo.removeMessages(202);
        if (this.aUd.getCurrentPosition() > 0) {
            e(true, 3);
            this.aUo.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aUo.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aUo.removeMessages(203);
        int currentPosition = this.aUd.getCurrentPosition();
        if (currentPosition != this.aUl) {
            this.aUl = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aUo.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.aUc != null && this.aUb != null && this.aUk != null && this.aUg != null && this.aUh != null && this.aUi != null && this.aUf != null && this.aUe != null) {
            if (z || this.aUm != i) {
                this.aUm = i;
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUr);
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUq);
                if (i == 2) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(0);
                    this.aUk.setVisibility(0);
                    this.aUh.setVisibility(0);
                    this.aUi.setVisibility(0);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aUr, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(8);
                    this.aUk.setVisibility(8);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(0);
                    this.aUg.start();
                } else if (i == 4) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(8);
                    this.aUk.setVisibility(8);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(0);
                    this.aUe.setVisibility(0);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aUq, 2000L);
                } else {
                    this.aUc.setVisibility(0);
                    this.aUb.setVisibility(0);
                    this.aUk.setVisibility(0);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                }
            }
        }
    }

    private void KW() {
        if (this.aUj == null || this.aUj.aWa == null || this.aUj.aWa.getAuthor() == null) {
            this.aTZ.setVisibility(8);
            return;
        }
        this.aTZ.setVisibility(0);
        KY();
        if (this.aUj.aWs) {
            this.aTU.setVisibility(8);
            this.aTX.setVisibility(8);
        } else {
            this.aTX.setVisibility(0);
            this.aTU.setVisibility(0);
            this.aTU.setData(this.aUj.aWa);
            this.aTU.setAfterClickListener(this.aeW);
            UserTbVipInfoData qx = this.aUj.Iw().qx();
            if (qx != null && qx.getvipV_url() != null && this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.aTU.setIsBigV(true);
            }
        }
        this.aTX.setData(this.aUj.aWa);
        this.aTX.setUserAfterClickListener(this.aeW);
        this.mTextTitle.setText(this.aUj.aWa.getTitle());
        this.aTV.setData(this.aUj.aWa);
        this.aTV.setStType(at.La());
        this.aTV.setYuelaouLocate("feed#" + this.aUj.Lg());
        this.aTV.setForumAfterClickListener(this.aez);
        d(this.DQ, TbadkCoreApplication.m10getInst().getSkinType());
        if (at.hc(this.aUj.aWa.getId())) {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, u.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, u.d.cp_cont_c, 1);
        }
        if (this.aUj.aWE) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void KX() {
        this.aUo.removeMessages(202);
        this.aUo.removeMessages(203);
    }

    private void Ky() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUq);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUr);
    }

    private void KY() {
        Ky();
        KX();
        if (this.aUb != null && this.aTW != null && this.aUd != null) {
            if (com.baidu.tbadk.core.l.nL().nR() && this.aUj != null && this.aUj.aWa != null && this.aUj.aWa.qM() != null) {
                this.aUb.setDefaultBgResource(u.f.pic_bg_video_frs);
                this.aUb.c(this.aUj.aWa.qM().thumbnail_url, 10, false);
                this.aTW.setVisibility(0);
                stopPlay();
                this.aKF = this.aUj.aWa.qM().video_url;
                if (StringUtils.isNull(this.aUj.aWa.qM().video_url)) {
                    e(true, 4);
                }
            } else {
                this.aTW.setVisibility(8);
            }
            this.aTW.setClickable(true);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aTZ, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(this.aUc, u.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.j((View) this.mTextTitle, u.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.j((View) this.aUe, u.d.cp_cont_i);
            com.baidu.tbadk.core.util.av.l(this.aUa, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.aUf, u.d.common_color_10014);
            com.baidu.tbadk.core.util.av.l(this.aTW, u.d.cp_bg_line_k);
            com.baidu.tbadk.core.util.av.l(this.aUk, u.d.cp_bg_line_k);
            if (this.aUe != null) {
                this.aUe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.aTX.sd();
            this.aTV.sd();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTV != null && this.aUs != null) {
            this.aTV.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            this.aUt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
            MessageManager.getInstance().registerListener(this.aUt);
        }
    }

    public boolean IA() {
        return this.aKR;
    }

    public boolean isPlaying() {
        if (this.aUd == null) {
            return false;
        }
        return this.aUd.isPlaying();
    }

    public void Iz() {
        if (!this.aKR && this.aUj != null && this.aUj.aWa != null && this.aUj.aWa.qM() != null && this.aUd != null && com.baidu.tbadk.util.x.eX(1)) {
            e(true, 2);
            this.aUd.u(this.aKF, this.aUj.aWa.qM().video_duration.intValue());
            this.aUd.start();
            this.aKR = true;
            com.baidu.tieba.play.e.k(this.aUj.aWa.qM().video_md5, this.aUj.aWa.getTid(), new StringBuilder(String.valueOf(this.aUj.aWa.getFid())).toString(), "index");
        }
    }

    public void stopPlay() {
        Ky();
        KX();
        e(true, 1);
        if (this.aUd != null) {
            this.aUd.vr();
        }
        this.aKR = false;
    }

    public View getVideoContainer() {
        return this.aTW;
    }

    public String getPlayUrl() {
        return this.aKF;
    }

    public int getCurrentPosition() {
        if (this.aUd == null) {
            return 0;
        }
        return this.aUd.getCurrentPosition();
    }

    public void setVideoStatsData(TextureVideoView.c cVar) {
        if (this.aUd != null) {
            this.aUd.setVideoStatsData(cVar);
        }
    }
}

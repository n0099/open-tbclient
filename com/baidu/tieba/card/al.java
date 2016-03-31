package com.baidu.tieba.card;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
import com.baidu.location.a0;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class al extends a<com.baidu.tieba.card.a.v> {
    private TbPageContext<?> MX;
    private View aTA;
    private AudioAnimationView aTB;
    private ProgressBar aTC;
    private com.baidu.tieba.card.a.v aTD;
    private View aTE;
    private int aTF;
    private boolean aTG;
    private Handler aTH;
    private CustomMessageListener aTI;
    private CustomMessageListener aTJ;
    public ClickableHeaderImageView aTo;
    public ThreadCommentAndPraiseInfoLayout aTp;
    public FrameLayout aTq;
    public UserIconLayout aTr;
    protected LinearLayout aTs;
    private RelativeLayout aTt;
    private View aTu;
    private TbImageView aTv;
    private ImageView aTw;
    private TextureVideoView aTx;
    private TextView aTy;
    private View aTz;
    private MediaPlayer.OnCompletionListener agV;
    private MediaPlayer.OnPreparedListener agW;
    private MediaPlayer.OnErrorListener agY;
    private final View.OnClickListener ahQ;
    private final View.OnClickListener ahw;
    private int mSkinType;
    private TextView mTextTitle;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTF = 0;
        this.aTH = new am(this, Looper.getMainLooper());
        this.agW = new an(this);
        this.agY = new ao(this);
        this.agV = new ap(this);
        this.ahQ = new aq(this);
        this.aTI = new ar(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTJ = new as(this, CmdConfigCustom.CMD_PERSONALIZE_VIDEO_CONTROL);
        this.ahw = new at(this);
        this.MX = tbPageContext;
        View view = getView();
        this.aTt = (RelativeLayout) view.findViewById(t.g.layout_root);
        this.aTu = view.findViewById(t.g.divider);
        this.aTA = view.findViewById(t.g.auto_video_state_group);
        this.aTo = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aTo.setDefaultResource(17170445);
        this.aTo.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aTo.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aTo.setRadius(com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds70));
        this.aTr = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aTC = (ProgressBar) view.findViewById(t.g.auto_video_progress_state);
        this.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aTp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aTq = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aTv = (TbImageView) view.findViewById(t.g.image_video);
        this.aTv.setDefaultErrorResource(0);
        this.aTv.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aTw = (ImageView) view.findViewById(t.g.image_video_play);
        this.aTB = (AudioAnimationView) view.findViewById(t.g.auto_video_play_state);
        this.aTB.setCertainColumnCount(4);
        this.aTB.setColumnColor(t.d.cp_cont_i);
        this.aTt.setOnClickListener(this);
        this.aTq.setOnClickListener(this);
        this.aTx = (TextureVideoView) view.findViewById(t.g.texture_video_view);
        this.aTx.setEnableRefresh(true);
        this.aTx.setOnPreparedListener(this.agW);
        this.aTx.setOnErrorListener(this.agY);
        this.aTx.setOnCompletionListener(this.agV);
        this.aTE = view.findViewById(t.g.auto_video_black_mask);
        this.aTy = (TextView) view.findViewById(t.g.auto_video_error_tips);
        this.aTz = view.findViewById(t.g.auto_video_error_background);
        this.aTs = (LinearLayout) view.findViewById(t.g.video_card_content_layout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aTt) {
            R(view);
        } else if (view == this.aTq) {
            S(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aTp != null) {
            this.aTp.setBarNameClickEnabled(z);
        }
    }

    private void R(View view) {
        if (Ld() != null) {
            Ld().a(view, this.aTD);
        }
        if (this.aTD != null && this.aTD.aWf != null) {
            if (!Lm()) {
                bc.ha(this.aTD.aWf.getId());
            }
            this.MX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.MX.getPageActivity()).createFromThreadCfg(this.aTD.aWf, this.aTD.aWf.tr(), bc.Ls(), 18003, true, false, false).addLocateParam(this.aTD.Lz())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lm() {
        return this.aTD.aWe && !this.aTD.aWr;
    }

    private void S(View view) {
        if (this.aTD != null && this.aTD.aWf != null && this.aTD.aWf.tC() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = Ld();
            if (Ld != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                Ld.a(view, this.aTD);
            }
            if (!com.baidu.adp.lib.util.i.jf()) {
                com.baidu.adp.lib.util.k.l(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.MX.getPageActivity(), this.aTD.aWf.tC().video_url, this.aTD.aWf.tC().video_width.intValue(), this.aTD.aWf.tC().video_height.intValue(), this.aTD.aWf.tC().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_home_page_auto_video_view;
    }

    public void a(com.baidu.tieba.card.a.v vVar) {
        this.aTD = vVar;
        Lp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        this.aTH.removeMessages(a0.f37long);
        if (this.aTx.getCurrentPosition() > 0) {
            ca(false);
            bZ(true);
            this.aTH.sendEmptyMessageDelayed(a0.f35if, 1000L);
            return;
        }
        this.aTH.sendEmptyMessageDelayed(a0.f37long, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lo() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTH.removeMessages(a0.f35if);
        int currentPosition = this.aTx.getCurrentPosition();
        if (currentPosition != this.aTF) {
            this.aTF = currentPosition;
            bZ(true);
        } else {
            bZ(false);
        }
        this.aTH.sendEmptyMessageDelayed(a0.f35if, 1000L);
    }

    private void bZ(boolean z) {
        i(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, boolean z2) {
        if (z || this.aTG != z2) {
            this.aTG = z2;
            if (z2) {
                this.aTv.setVisibility(8);
                this.aTE.setVisibility(8);
                this.aTB.setVisibility(0);
                this.aTB.start();
                this.aTC.setIndeterminate(false);
                return;
            }
            this.aTv.setVisibility(0);
            this.aTE.setVisibility(0);
            this.aTB.aYB();
            this.aTB.setVisibility(8);
            this.aTC.setIndeterminate(true);
        }
    }

    private void Lp() {
        if (this.aTD == null || this.aTD.aWf == null || this.aTD.aWf.getAuthor() == null) {
            this.aTt.setVisibility(8);
            return;
        }
        this.aTt.setVisibility(0);
        Lq();
        if (this.aTD.aWe) {
            this.aTo.setVisibility(8);
            this.aTr.setVisibility(8);
        } else {
            this.aTr.setVisibility(0);
            this.aTo.setVisibility(0);
            this.aTo.setData(this.aTD.aWf);
            this.aTo.setAfterClickListener(this.ahQ);
        }
        this.aTr.setData(this.aTD.aWf);
        this.aTr.setUserAfterClickListener(this.ahQ);
        this.mTextTitle.setText(this.aTD.aWf.getTitle());
        this.aTp.setData(this.aTD.aWf);
        this.aTp.setStType(bc.Ls());
        this.aTp.setYuelaouLocate("feed#" + this.aTD.Ly());
        this.aTp.setForumAfterClickListener(this.ahw);
        d(this.MX, TbadkCoreApplication.m411getInst().getSkinType());
        if (bc.hb(this.aTD.aWf.getId())) {
            com.baidu.tbadk.core.util.at.b(this.mTextTitle, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.b(this.mTextTitle, t.d.cp_cont_c, 1);
        }
        if (this.aTD.aWr) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (z) {
            this.aTz.setVisibility(0);
            this.aTy.setVisibility(0);
            this.aTA.setVisibility(8);
            this.aTB.aYB();
            return;
        }
        this.aTz.setVisibility(8);
        this.aTy.setVisibility(8);
        this.aTA.setVisibility(0);
    }

    public void stopPlay() {
        this.aTG = false;
        this.aTH.removeMessages(a0.f37long);
        this.aTH.removeMessages(a0.f35if);
        this.aTB.aYB();
        this.aTC.setIndeterminate(false);
        if (this.aTx != null) {
            this.aTx.stopPlayback();
        }
    }

    private void Lq() {
        if (com.baidu.tbadk.core.l.qE().qK() && this.aTD.aWf.tC() != null) {
            this.aTv.setVisibility(0);
            this.aTE.setVisibility(0);
            this.aTv.c(this.aTD.aWf.tC().thumbnail_url, 10, false);
            this.aTq.setVisibility(0);
            if (StringUtils.isNull(this.aTD.aWf.tC().video_url)) {
                this.aTw.setVisibility(8);
                ca(true);
                this.aTx.dT(null);
            } else {
                ca(false);
                if (com.baidu.adp.lib.util.i.jg()) {
                    i(true, false);
                    this.aTw.setVisibility(8);
                    this.aTx.dT(this.aTD.aWf.tC().video_url);
                } else {
                    this.aTA.setVisibility(8);
                    this.aTw.setVisibility(0);
                    this.aTx.stopPlayback();
                }
            }
        } else {
            this.aTq.setVisibility(8);
        }
        this.aTq.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.aTt, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aTu, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.mTextTitle, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.c(this.aTw, t.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.j((View) this.aTy, t.d.cp_cont_i);
            this.aTr.uA();
            this.aTp.uA();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTp != null && this.aTI != null) {
            this.aTp.h(bdUniqueId);
            this.aTI.setTag(bdUniqueId);
            this.aTJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
            MessageManager.getInstance().registerListener(this.aTJ);
        }
    }
}

package com.baidu.tieba.frs.entelechy.c;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<ax> {
    private final CustomMessageListener Dc;
    private TbPageContext<?> Do;
    public ClickableHeaderImageView aPC;
    public ThreadCommentAndPraiseInfoLayout aPD;
    public FrameLayout aPE;
    public UserIconLayout aPF;
    protected LinearLayout aPG;
    private RelativeLayout aPH;
    private View aPI;
    private TbImageView aPJ;
    private ImageView aPK;
    private TextureVideoView aPL;
    private TextView aPM;
    private View aPN;
    private View aPO;
    private AudioAnimationView aPP;
    private ProgressBar aPQ;
    private View aPS;
    private int aPT;
    private boolean aPU;
    private int aPV;
    private int aPW;
    private com.baidu.tieba.play.a aPY;
    private Handler aPZ;
    private Runnable aQa;
    private Runnable aQb;
    private CustomMessageListener aQc;
    private Runnable aQd;
    private ax aab;
    private MediaPlayer.OnPreparedListener acJ;
    private MediaPlayer.OnErrorListener acL;
    private TextureVideoView.b acR;
    private TextureVideoView.a acW;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    private ViewTreeObserver.OnGlobalLayoutListener bpF;
    private int mScreenHeight;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aPT = 0;
        this.mScreenHeight = 0;
        this.aPU = false;
        this.aPV = 1;
        this.aPW = 0;
        this.aPZ = new b(this, Looper.getMainLooper());
        this.acJ = new g(this);
        this.acL = new h(this);
        this.bpF = new i(this);
        this.aQa = new j(this);
        this.aQb = new k(this);
        this.acR = new l(this);
        this.acW = new m(this);
        this.adK = new n(this);
        this.aQc = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.Dc = new d(this, 2000994);
        this.adn = new e(this);
        this.aQd = new f(this);
        this.Do = tbPageContext;
        View view = getView();
        this.aPH = (RelativeLayout) view.findViewById(t.g.layout_root);
        this.aPI = view.findViewById(t.g.divider);
        this.aPO = view.findViewById(t.g.auto_video_state_group);
        this.aPC = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aPC.setDefaultResource(17170445);
        this.aPC.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aPC.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aPC.setRadius(com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds70));
        this.aPF = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aPF.adJ = true;
        this.aPF.setEntelechyEnabled(true);
        this.aPQ = (ProgressBar) view.findViewById(t.g.auto_video_progress_state);
        this.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aPD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aPD.setLocationEnabled(true);
        this.aPD.setCommentNumClickListener(this);
        this.aPE = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aPE.getViewTreeObserver().addOnGlobalLayoutListener(this.bpF);
        this.aPJ = (TbImageView) view.findViewById(t.g.image_video);
        this.aPJ.setDefaultErrorResource(0);
        this.aPJ.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aPK = (ImageView) view.findViewById(t.g.image_video_play);
        this.aPP = (AudioAnimationView) view.findViewById(t.g.auto_video_play_state);
        this.aPP.setCertainColumnCount(4);
        this.aPP.setColumnColor(t.d.cp_cont_i);
        this.aPH.setOnClickListener(this);
        this.aPE.setOnClickListener(this);
        this.aPL = (TextureVideoView) view.findViewById(t.g.texture_video_view);
        this.aPL.setEnableRefresh(true);
        this.aPL.setOnPreparedListener(this.acJ);
        this.aPL.setOnErrorListener(this.acL);
        this.aPL.setOnSurfaceDestroyedListener(this.acR);
        this.aPL.setOnSurfaceAvailableListener(this.acW);
        this.aPS = view.findViewById(t.g.auto_video_black_mask);
        this.aPM = (TextView) view.findViewById(t.g.auto_video_error_tips);
        this.aPN = view.findViewById(t.g.auto_video_error_background);
        this.aPG = (LinearLayout) view.findViewById(t.g.video_card_content_layout);
        this.mScreenHeight = com.baidu.adp.lib.util.k.C(this.Do.getPageActivity());
        this.aPW = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.aPY = new com.baidu.tieba.play.a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPH || view == this.aPD.getCommentNumView()) {
            T(this.aPH);
        } else if (view == this.aPE) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aPD != null) {
            this.aPD.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (this.aab != null) {
            if (this.aab.rt()) {
                TiebaStatic.log(new aw("c10242").ac("fid", String.valueOf(this.aab.getFid())).s("obj_type", 2));
            } else {
                aw awVar = new aw("c11100");
                awVar.ac("tid", this.aab.getId());
                awVar.ac("fid", new StringBuilder(String.valueOf(this.aab.getFid())).toString());
                TiebaStatic.log(awVar);
            }
            if (this.aab.getAuthor() != null && this.aab.getAuthor().getGodUserData() != null && this.aab.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aw("c10806").s("obj_locate", 3).ac("tid", this.aab.getId()));
            }
        }
        if (JM() != null) {
            JM().a(view, this.aab);
        }
        if (this.aab != null) {
            com.baidu.tieba.card.au.hb(this.aab.getId());
            this.Do.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Do.getPageActivity()).createFromThreadCfg(this.aab, this.aab.qP(), com.baidu.tieba.card.au.Kb(), 18003, true, false, false)));
        }
    }

    private void U(View view) {
        if (this.aab != null && this.aab != null && this.aab.ra() != null) {
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.l(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.Do.getPageActivity(), this.aab.ra().video_url, this.aab.ra().video_width.intValue(), this.aab.ra().video_height.intValue(), this.aab.ra().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_home_page_auto_video_view;
    }

    public void h(ax axVar) {
        this.aab = axVar;
        JW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        this.aPZ.removeMessages(202);
        if (this.aPL.getCurrentPosition() > 0) {
            e(true, 3);
            this.aPZ.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aPZ.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aPZ.removeMessages(203);
        int currentPosition = this.aPL.getCurrentPosition();
        if (currentPosition != this.aPT) {
            this.aPT = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aPZ.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.aPK != null && this.aPJ != null && this.aPS != null && this.aPO != null && this.aPP != null && this.aPQ != null && this.aPN != null && this.aPM != null) {
            if (z || this.aPV != i) {
                this.aPV = i;
                this.aPK.setVisibility(8);
                this.aPJ.setVisibility(8);
                this.aPS.setVisibility(8);
                this.aPO.setVisibility(8);
                this.aPP.setVisibility(8);
                this.aPP.baS();
                this.aPQ.setVisibility(8);
                this.aPQ.setIndeterminate(false);
                this.aPN.setVisibility(8);
                this.aPM.setVisibility(8);
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQb);
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQa);
                if (i == 2) {
                    this.aPJ.setVisibility(0);
                    this.aPS.setVisibility(0);
                    this.aPO.setVisibility(0);
                    this.aPQ.setVisibility(0);
                    this.aPQ.setIndeterminate(true);
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aQb, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aPO.setVisibility(0);
                    this.aPP.setVisibility(0);
                    this.aPP.start();
                } else if (i == 4) {
                    this.aPJ.setVisibility(0);
                    this.aPS.setVisibility(0);
                    this.aPN.setVisibility(0);
                    this.aPM.setVisibility(0);
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aQa, 2000L);
                } else {
                    this.aPJ.setVisibility(0);
                    this.aPS.setVisibility(0);
                    this.aPK.setVisibility(0);
                }
            }
        }
    }

    private void JW() {
        if (this.aab == null || this.aab == null || this.aab.getAuthor() == null) {
            this.aPH.setVisibility(8);
            return;
        }
        this.aPH.setVisibility(0);
        JX();
        this.aPF.setVisibility(0);
        this.aPC.setVisibility(0);
        this.aPC.setData(this.aab);
        this.aPC.setAfterClickListener(this.adK);
        this.aPF.setData(this.aab);
        this.aPF.setUserAfterClickListener(this.adK);
        this.mTextTitle.setText(this.aab.getTitle());
        this.aPD.setData(this.aab);
        this.aPD.setStType(com.baidu.tieba.card.au.Kb());
        this.aPD.setForumAfterClickListener(this.adn);
        this.aPD.setCommentNumClickListener(this);
        d(this.Do, TbadkCoreApplication.m11getInst().getSkinType());
        if (com.baidu.tieba.card.au.hc(this.aab.getId())) {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, t.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SL() {
        this.aPZ.removeMessages(202);
        this.aPZ.removeMessages(203);
    }

    private void Jz() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQa);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQd);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQb);
    }

    public void stopPlay() {
        Jz();
        SL();
        e(true, 1);
        if (this.aPL != null) {
            this.aPL.stopPlayback();
        }
    }

    private void JX() {
        Jz();
        SL();
        this.aPU = false;
        if (this.aPJ != null && this.aPE != null && this.aPL != null) {
            if (com.baidu.tbadk.core.l.ob().oh() && this.aab != null && this.aab.ra() != null) {
                this.aPJ.c(this.aab.ra().thumbnail_url, 10, false);
                this.aPE.setVisibility(0);
                stopPlay();
                if (StringUtils.isNull(this.aab.ra().video_url)) {
                    e(true, 4);
                } else if (com.baidu.adp.lib.util.i.fr() && com.baidu.tbadk.core.view.at.vD().vH()) {
                    cg(false);
                }
            } else {
                this.aPE.setVisibility(8);
            }
            this.aPE.setClickable(false);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.aPH, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aPI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.mTextTitle, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.c(this.aPK, t.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.j((View) this.aPM, t.d.cp_cont_i);
            this.aPF.sf();
            this.aPD.sf();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aPD != null && this.aQc != null) {
            this.aPD.h(bdUniqueId);
            this.aQc.setTag(bdUniqueId);
            this.Dc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
            MessageManager.getInstance().registerListener(this.Dc);
        }
    }

    public void cg(boolean z) {
        if (z) {
            stopPlay();
        } else if (com.baidu.adp.lib.util.i.fr()) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aQd);
            if (JY()) {
                com.baidu.adp.lib.h.h.dL().postDelayed(this.aQd, 800L);
            } else {
                stopPlay();
            }
        }
    }

    public void ch(boolean z) {
        this.aPU = z;
        cg(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JY() {
        if (this.aPL == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.aPL.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.aPL.getMeasuredHeight() / 2);
        return measuredHeight > this.aPW && measuredHeight < this.mScreenHeight;
    }

    public void JZ() {
        cg(false);
    }
}

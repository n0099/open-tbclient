package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<m> {
    private TbPageContext<?> aRG;
    private final View.OnClickListener bdE;
    private ThreadGodReplyLayout cVu;
    private TbImageView.a cWC;
    private final View.OnClickListener cWF;
    private final View.OnClickListener cWG;
    private TbImageView cWd;
    private TextView cWe;
    public FrameLayout cWk;
    private TextView cWn;
    private LinearLayout cWo;
    private m cWs;
    private ImageView cax;
    private View chL;
    private RelativeLayout clV;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    public ConcernThreadUserInfoLayout egE;
    private LinearLayout egJ;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && c.this.cWd != null) {
                    c.this.cWd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view, c.this.cWs);
                }
            }
        };
        this.cWG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view, c.this.cWs);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cWs != null) {
                    if (c.this.akO() != null) {
                        c.this.akO().a(view, c.this.cWs);
                    }
                    if (c.this.cWs.bZf != null && view != c.this.cmL.bel) {
                        j.kr(c.this.cWs.bZf.getId());
                        c.this.akT();
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.clV = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmI = (HeadPendantClickableView) this.clV.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(l.t(this.aRG.getPageActivity(), d.e.ds70));
        }
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.egE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.egJ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setIsBarViewVisible(false);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setFrom(9);
        this.clX.setShareReportFrom(4);
        this.clX.setForumAfterClickListener(this.bdE);
        this.clX.aQt = this.currentPageType;
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this);
        this.cmL.setShareReportFrom(4);
        this.cmL.setFrom(9);
        this.cmL.bem.aQt = this.currentPageType;
        this.cmL.setForumAfterClickListener(this.bdE);
        this.clV.setOnClickListener(this);
        this.cWk = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWk.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWk.getLayoutParams();
        layoutParams2.width = l.ao(this.aRG.getPageActivity()) - l.t(this.aRG.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWk.setLayoutParams(layoutParams2);
        this.cWd = (TbImageView) view.findViewById(d.g.image_video);
        this.cWd.setDefaultErrorResource(0);
        this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWd.setGifIconSupport(false);
        this.cWd.setEvent(this.cWC);
        this.cax = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWn = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWo = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWe = (TextView) view.findViewById(d.g.text_video_play_count);
        this.chL = view.findViewById(d.g.divider_line);
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clV, d.f.addresslist_item_bg);
            aj.c(this.cax, d.f.btn_icon_play_video_n);
            this.egE.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.cmL.onChangeSkinType();
            aj.s(this.chL, d.C0141d.cp_bg_line_e);
            aj.r(this.cWn, d.C0141d.cp_cont_i);
            aj.r(this.cWe, d.C0141d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(m mVar) {
        this.cWs = mVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clV || view == this.cVu) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWk) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bN(View view) {
        if (akO() != null) {
            akO().a(view, this.cWs);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            l.showToast(this.aRG.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
            aVar.dk(this.aRG.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.akY();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.mTbPageContext).AU();
        } else {
            akY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.cWs != null && this.cWs.bZf != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWs.bZf);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cWd.getX() + this.egJ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cWd.getY() + this.egJ.getY());
            videoCardViewInfo.cardViewWidth = this.cWd.getWidth();
            videoCardViewInfo.cardViewHeight = this.cWd.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRG.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cWs.bZf.getTid(), j.zd(), this.cWs.alB(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean akS() {
        return this.cWs.cZZ && !this.cWs.dan;
    }

    private void bC(View view) {
        if (akO() != null) {
            akO().a(view, this.cWs);
        }
        if (this.cWs != null && this.cWs.bZf != null) {
            if (!akS()) {
                j.kr(this.cWs.bZf.getId());
                j.a(this.mTextTitle, this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRG.getPageActivity()).createFromThreadCfg(this.cWs.bZf, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWs.alB());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cWs.bZf.getFid()));
            addLocateParam.setForumName(this.cWs.bZf.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVu) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRG.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cWs == null || this.cWs.bZf == null || this.cWs.bZf.zn() == null || this.cWs.bZf.zF() == null) {
            this.clV.setVisibility(8);
            return;
        }
        this.clV.setVisibility(0);
        ald();
        if (!akS() && j.ks(this.cWs.bZf.getId())) {
            j.a(this.mTextTitle, this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVu.getGodReplyContent(), this.cWs.WD().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cWs.WD().zW();
        SpannableStringBuilder zN = this.cWs.WD().zN();
        if (this.cWs.WD().zT() && !StringUtils.isNull(this.cWs.WD().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWs.WD().getTid();
            zN.append((CharSequence) this.cWs.WD().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
        this.mTextTitle.setText(zN);
        this.egE.setData(this.cWs.WD());
        this.egE.setUserAfterClickListener(this.cWF);
        if (this.egE.getHeaderImg() != null) {
            this.egE.getHeaderImg().setAfterClickListener(this.cWG);
            if (this.egE.getIsSimpleThread()) {
                this.egE.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (this.cWs.WD() == null || this.cWs.WD().zn() == null || this.cWs.WD().zn().getPendantData() == null || StringUtils.isNull(this.cWs.WD().zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.egE.getHeaderImg().setVisibility(0);
                this.egE.getHeaderImg().setData(this.cWs.WD());
            } else {
                this.egE.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(this.cWs.WD());
            }
        }
        this.cWn.setText(am.fV(this.cWs.bZf.zF().video_duration.intValue() * 1000));
        this.cWe.setText(String.format(this.aRG.getResources().getString(d.j.play_count), am.J(this.cWs.bZf.zF().play_count.intValue())));
        this.cVu.setData(this.cWs.WD().AA());
        this.cVu.onChangeSkinType();
        d(this.aRG, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWs.bZf.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        jX(this.cWs.bZf.aQo);
    }

    private void ald() {
        if (this.cWd != null && this.cWk != null) {
            if (i.xo().xu() && this.cWs != null && this.cWs.bZf != null && this.cWs.bZf.zF() != null) {
                this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWd.startLoad(this.cWs.bZf.zF().thumbnail_url, 10, false);
                this.cWk.setVisibility(0);
                return;
            }
            this.cWk.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.egE != null) {
            this.egE.setPageUniqueId(bdUniqueId);
        }
        if (this.cWd != null) {
            this.cWd.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akT() {
        if (this.cWs != null && this.cWs.bZf != null) {
            j.a(this.mTextTitle, this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVu.getGodReplyContent(), this.cWs.WD().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egE != null) {
            return this.egE.getHeaderImg();
        }
        return null;
    }

    public View akR() {
        if (this.egE != null) {
            return this.egE.bdM;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cWs != null && this.cWs.bZf != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setStType(j.zd());
                this.cmL.setData(this.cWs.bZf);
                this.egE.showForumNameView(false);
                return;
            }
            this.clX.setData(this.cWs.bZf);
            this.clX.setStType(j.zd());
            this.cmL.setVisibility(8);
            this.egE.showForumNameView(true);
        }
    }
}

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
    private TbPageContext<?> aRI;
    private final View.OnClickListener bdG;
    private ThreadGodReplyLayout cVx;
    private TbImageView.a cWF;
    private final View.OnClickListener cWI;
    private final View.OnClickListener cWJ;
    private TbImageView cWg;
    private TextView cWh;
    public FrameLayout cWn;
    private TextView cWq;
    private LinearLayout cWr;
    private m cWv;
    private ImageView caA;
    private View chO;
    private RelativeLayout clY;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    public ConcernThreadUserInfoLayout egU;
    private LinearLayout egZ;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && c.this.cWg != null) {
                    c.this.cWg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cWv);
                }
            }
        };
        this.cWJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cWv);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cWv != null) {
                    if (c.this.akP() != null) {
                        c.this.akP().a(view, c.this.cWv);
                    }
                    if (c.this.cWv.bZi != null && view != c.this.cmO.beo) {
                        j.kr(c.this.cWv.bZi.getId());
                        c.this.akU();
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.clY = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmL = (HeadPendantClickableView) this.clY.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(l.t(this.aRI.getPageActivity(), d.e.ds70));
        }
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.egU = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.egZ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setIsBarViewVisible(false);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setFrom(9);
        this.cma.setShareReportFrom(4);
        this.cma.setForumAfterClickListener(this.bdG);
        this.cma.aQv = this.currentPageType;
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this);
        this.cmO.setShareReportFrom(4);
        this.cmO.setFrom(9);
        this.cmO.bep.aQv = this.currentPageType;
        this.cmO.setForumAfterClickListener(this.bdG);
        this.clY.setOnClickListener(this);
        this.cWn = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWn.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWn.getLayoutParams();
        layoutParams2.width = l.ao(this.aRI.getPageActivity()) - l.t(this.aRI.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWn.setLayoutParams(layoutParams2);
        this.cWg = (TbImageView) view.findViewById(d.g.image_video);
        this.cWg.setDefaultErrorResource(0);
        this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWg.setGifIconSupport(false);
        this.cWg.setEvent(this.cWF);
        this.caA = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWq = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWr = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWh = (TextView) view.findViewById(d.g.text_video_play_count);
        this.chO = view.findViewById(d.g.divider_line);
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clY, d.f.addresslist_item_bg);
            aj.c(this.caA, d.f.btn_icon_play_video_n);
            this.egU.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.cmO.onChangeSkinType();
            aj.s(this.chO, d.C0141d.cp_bg_line_e);
            aj.r(this.cWq, d.C0141d.cp_cont_i);
            aj.r(this.cWh, d.C0141d.cp_cont_i);
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
        this.cWv = mVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clY || view == this.cVx) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWn) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bN(View view) {
        if (akP() != null) {
            akP().a(view, this.cWv);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            l.showToast(this.aRI.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
            aVar.dk(this.aRI.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.akZ();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.mTbPageContext).AV();
        } else {
            akZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.cWv != null && this.cWv.bZi != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWv.bZi);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cWg.getX() + this.egZ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cWg.getY() + this.egZ.getY());
            videoCardViewInfo.cardViewWidth = this.cWg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cWg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRI.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cWv.bZi.getTid(), j.zd(), this.cWv.alC(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean akT() {
        return this.cWv.dac && !this.cWv.daq;
    }

    private void bC(View view) {
        if (akP() != null) {
            akP().a(view, this.cWv);
        }
        if (this.cWv != null && this.cWv.bZi != null) {
            if (!akT()) {
                j.kr(this.cWv.bZi.getId());
                j.a(this.mTextTitle, this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRI.getPageActivity()).createFromThreadCfg(this.cWv.bZi, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWv.alC());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cWv.bZi.getFid()));
            addLocateParam.setForumName(this.cWv.bZi.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVx) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRI.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cWv == null || this.cWv.bZi == null || this.cWv.bZi.zn() == null || this.cWv.bZi.zF() == null) {
            this.clY.setVisibility(8);
            return;
        }
        this.clY.setVisibility(0);
        ale();
        if (!akT() && j.ks(this.cWv.bZi.getId())) {
            j.a(this.mTextTitle, this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVx.getGodReplyContent(), this.cWv.WE().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cWv.WE().zW();
        SpannableStringBuilder zN = this.cWv.WE().zN();
        if (this.cWv.WE().zT() && !StringUtils.isNull(this.cWv.WE().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWv.WE().getTid();
            zN.append((CharSequence) this.cWv.WE().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.4
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
        this.egU.setData(this.cWv.WE());
        this.egU.setUserAfterClickListener(this.cWI);
        if (this.egU.getHeaderImg() != null) {
            this.egU.getHeaderImg().setAfterClickListener(this.cWJ);
            if (this.egU.getIsSimpleThread()) {
                this.egU.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (this.cWv.WE() == null || this.cWv.WE().zn() == null || this.cWv.WE().zn().getPendantData() == null || StringUtils.isNull(this.cWv.WE().zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.egU.getHeaderImg().setVisibility(0);
                this.egU.getHeaderImg().setData(this.cWv.WE());
            } else {
                this.egU.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(this.cWv.WE());
            }
        }
        this.cWq.setText(am.fV(this.cWv.bZi.zF().video_duration.intValue() * 1000));
        this.cWh.setText(String.format(this.aRI.getResources().getString(d.j.play_count), am.J(this.cWv.bZi.zF().play_count.intValue())));
        this.cVx.setData(this.cWv.WE().AA());
        this.cVx.onChangeSkinType();
        d(this.aRI, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWv.bZi.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        jX(this.cWv.bZi.aQp);
    }

    private void ale() {
        if (this.cWg != null && this.cWn != null) {
            if (i.xo().xu() && this.cWv != null && this.cWv.bZi != null && this.cWv.bZi.zF() != null) {
                this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWg.startLoad(this.cWv.bZi.zF().thumbnail_url, 10, false);
                this.cWn.setVisibility(0);
                return;
            }
            this.cWn.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.egU != null) {
            this.egU.setPageUniqueId(bdUniqueId);
        }
        if (this.cWg != null) {
            this.cWg.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akU() {
        if (this.cWv != null && this.cWv.bZi != null) {
            j.a(this.mTextTitle, this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVx.getGodReplyContent(), this.cWv.WE().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egU != null) {
            return this.egU.getHeaderImg();
        }
        return null;
    }

    public View akS() {
        if (this.egU != null) {
            return this.egU.bdP;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cWv != null && this.cWv.bZi != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setStType(j.zd());
                this.cmO.setData(this.cWv.bZi);
                this.egU.showForumNameView(false);
                return;
            }
            this.cma.setData(this.cWv.bZi);
            this.cma.setStType(j.zd());
            this.cmO.setVisibility(8);
            this.egU.showForumNameView(true);
        }
    }
}

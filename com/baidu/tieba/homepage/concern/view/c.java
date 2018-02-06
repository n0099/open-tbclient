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
    private TbPageContext<?> aRR;
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVG;
    private LinearLayout cWA;
    private m cWE;
    private TbImageView.a cWO;
    private final View.OnClickListener cWR;
    private final View.OnClickListener cWS;
    private TbImageView cWp;
    private TextView cWq;
    public FrameLayout cWw;
    private TextView cWz;
    private ImageView caJ;
    private View chX;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    private RelativeLayout cmi;
    public ThreadCommentAndPraiseInfoLayout cmk;
    public ConcernThreadUserInfoLayout egQ;
    private LinearLayout egV;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.cWp != null) {
                    c.this.cWp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cWE);
                }
            }
        };
        this.cWS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cWE);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cWE != null) {
                    if (c.this.akP() != null) {
                        c.this.akP().a(view, c.this.cWE);
                    }
                    if (c.this.cWE.bZr != null && view != c.this.cmX.bey) {
                        j.kr(c.this.cWE.bZr.getId());
                        c.this.akU();
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.cmi = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmU = (HeadPendantClickableView) this.cmi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(l.t(this.aRR.getPageActivity(), d.e.ds70));
        }
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.egQ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.egV = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setFrom(9);
        this.cmk.setShareReportFrom(4);
        this.cmk.setForumAfterClickListener(this.bdQ);
        this.cmk.aQE = this.currentPageType;
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this);
        this.cmX.setShareReportFrom(4);
        this.cmX.setFrom(9);
        this.cmX.bez.aQE = this.currentPageType;
        this.cmX.setForumAfterClickListener(this.bdQ);
        this.cmi.setOnClickListener(this);
        this.cWw = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWw.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWw.getLayoutParams();
        layoutParams2.width = l.ao(this.aRR.getPageActivity()) - l.t(this.aRR.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWw.setLayoutParams(layoutParams2);
        this.cWp = (TbImageView) view.findViewById(d.g.image_video);
        this.cWp.setDefaultErrorResource(0);
        this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWp.setGifIconSupport(false);
        this.cWp.setEvent(this.cWO);
        this.caJ = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWz = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWA = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWq = (TextView) view.findViewById(d.g.text_video_play_count);
        this.chX = view.findViewById(d.g.divider_line);
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cmi, d.f.addresslist_item_bg);
            aj.c(this.caJ, d.f.btn_icon_play_video_n);
            this.egQ.onChangeSkinType();
            this.cmk.onChangeSkinType();
            this.cmX.onChangeSkinType();
            aj.s(this.chX, d.C0140d.cp_bg_line_e);
            aj.r(this.cWz, d.C0140d.cp_cont_i);
            aj.r(this.cWq, d.C0140d.cp_cont_i);
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
        this.cWE = mVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cmi || view == this.cVG) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWw) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bN(View view) {
        if (akP() != null) {
            akP().a(view, this.cWE);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            l.showToast(this.aRR.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
            aVar.dk(this.aRR.getString(d.j.enter_video_center_page_no_wifi_tip));
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
            aVar.b(this.mTbPageContext).AU();
        } else {
            akZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.cWE != null && this.cWE.bZr != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWE.bZr);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cWp.getX() + this.egV.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cWp.getY() + this.egV.getY());
            videoCardViewInfo.cardViewWidth = this.cWp.getWidth();
            videoCardViewInfo.cardViewHeight = this.cWp.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRR.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cWE.bZr.getTid(), j.zd(), this.cWE.alC(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean akT() {
        return this.cWE.dal && !this.cWE.daB;
    }

    private void bC(View view) {
        if (akP() != null) {
            akP().a(view, this.cWE);
        }
        if (this.cWE != null && this.cWE.bZr != null) {
            if (!akT()) {
                j.kr(this.cWE.bZr.getId());
                j.a(this.mTextTitle, this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRR.getPageActivity()).createFromThreadCfg(this.cWE.bZr, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWE.alC());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cWE.bZr.getFid()));
            addLocateParam.setForumName(this.cWE.bZr.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVG) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRR.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cWE == null || this.cWE.bZr == null || this.cWE.bZr.zn() == null || this.cWE.bZr.zF() == null) {
            this.cmi.setVisibility(8);
            return;
        }
        this.cmi.setVisibility(0);
        ale();
        if (!akT() && j.ks(this.cWE.bZr.getId())) {
            j.a(this.mTextTitle, this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            j.a(this.cVG.getGodReplyContent(), this.cWE.WE().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.cWE.WE().zW();
        SpannableStringBuilder zN = this.cWE.WE().zN();
        if (this.cWE.WE().zT() && !StringUtils.isNull(this.cWE.WE().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWE.WE().getTid();
            zN.append((CharSequence) this.cWE.WE().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
        this.mTextTitle.setText(zN);
        this.egQ.setData(this.cWE.WE());
        this.egQ.setUserAfterClickListener(this.cWR);
        if (this.egQ.getHeaderImg() != null) {
            this.egQ.getHeaderImg().setAfterClickListener(this.cWS);
            if (this.egQ.getIsSimpleThread()) {
                this.egQ.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (this.cWE.WE() == null || this.cWE.WE().zn() == null || this.cWE.WE().zn().getPendantData() == null || StringUtils.isNull(this.cWE.WE().zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.egQ.getHeaderImg().setVisibility(0);
                this.egQ.getHeaderImg().setData(this.cWE.WE());
            } else {
                this.egQ.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(this.cWE.WE());
            }
        }
        this.cWz.setText(am.fV(this.cWE.bZr.zF().video_duration.intValue() * 1000));
        this.cWq.setText(String.format(this.aRR.getResources().getString(d.j.play_count), am.J(this.cWE.bZr.zF().play_count.intValue())));
        this.cVG.setData(this.cWE.WE().AA());
        this.cVG.onChangeSkinType();
        d(this.aRR, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWE.bZr.getId())) {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        jX(this.cWE.bZr.aQz);
    }

    private void ale() {
        if (this.cWp != null && this.cWw != null) {
            if (i.xo().xu() && this.cWE != null && this.cWE.bZr != null && this.cWE.bZr.zF() != null) {
                this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWp.startLoad(this.cWE.bZr.zF().thumbnail_url, 10, false);
                this.cWw.setVisibility(0);
                return;
            }
            this.cWw.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.egQ != null) {
            this.egQ.setPageUniqueId(bdUniqueId);
        }
        if (this.cWp != null) {
            this.cWp.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akU() {
        if (this.cWE != null && this.cWE.bZr != null) {
            j.a(this.mTextTitle, this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            j.a(this.cVG.getGodReplyContent(), this.cWE.WE().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egQ != null) {
            return this.egQ.getHeaderImg();
        }
        return null;
    }

    public View akS() {
        if (this.egQ != null) {
            return this.egQ.bdY;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cWE != null && this.cWE.bZr != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setStType(j.zd());
                this.cmX.setData(this.cWE.bZr);
                this.egQ.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cWE.bZr);
            this.cmk.setStType(j.zd());
            this.cmX.setVisibility(8);
            this.egQ.showForumNameView(true);
        }
    }
}

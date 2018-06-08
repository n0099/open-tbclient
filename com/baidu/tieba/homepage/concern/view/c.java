package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axg;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    private RelativeLayout bFc;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private View bFh;
    private ImageView bsT;
    private ThreadGodReplyLayout cvM;
    private TbImageView cxQ;
    private TextView cxR;
    public FrameLayout cxX;
    private TextView cya;
    private LinearLayout cyb;
    private l cyf;
    private TbImageView.a cyq;
    private final View.OnClickListener cyt;
    private final View.OnClickListener cyu;
    public ConcernThreadUserInfoLayout dNK;
    public ConcernForumThreadUserInfoLayout dNN;
    public com.baidu.tbadk.core.view.b dNO;
    private LinearLayout dNR;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && c.this.cxQ != null) {
                    c.this.cxQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cyt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.cyf);
                }
            }
        };
        this.cyu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.cyf);
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cyf != null) {
                    if (c.this.aiI() != null) {
                        c.this.aiI().a(view, c.this.cyf);
                    }
                    if (c.this.cyf.brC != null && view != c.this.bFT.axM) {
                        o.lb(c.this.cyf.brC.getId());
                        c.this.aiN();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bFc = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bFP = (HeadPendantClickableView) this.bFc.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dNR = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setFrom(9);
        this.bFe.setShareReportFrom(4);
        this.bFe.setForumAfterClickListener(this.axg);
        this.bFe.aka = this.currentPageType;
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this);
        this.bFT.setShareReportFrom(4);
        this.bFT.setFrom(9);
        this.bFT.axN.aka = this.currentPageType;
        this.bFT.setForumAfterClickListener(this.axg);
        this.bFc.setOnClickListener(this);
        this.cxX = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cxX.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cxX.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cxX.setLayoutParams(layoutParams2);
        this.cxQ = (TbImageView) view.findViewById(d.g.image_video);
        this.cxQ.setDefaultErrorResource(0);
        this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cxQ.setGifIconSupport(false);
        this.cxQ.setEvent(this.cyq);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.cya = (TextView) view.findViewById(d.g.text_video_duration);
        this.cyb = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cxR = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bFh = view.findViewById(d.g.divider_line);
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cvM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bFc, d.f.addresslist_item_bg);
            al.c(this.bsT, d.f.btn_icon_play_video_n);
            this.bFe.onChangeSkinType();
            this.bFT.onChangeSkinType();
            al.i(this.bFh, d.C0141d.cp_bg_line_e);
            al.h(this.cya, d.C0141d.cp_cont_i);
            al.h(this.cxR, d.C0141d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.dNK != null && this.dNK.getVisibility() == 0) {
            this.dNK.onChangeSkinType(i);
        }
        if (this.dNN != null && this.dNN.getVisibility() == 0) {
            this.dNN.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cyf = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFc || view == this.cvM) {
            ah(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cxX) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(getView());
            } else {
                ah(getView());
            }
        }
    }

    private void as(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cyf);
        }
        if (!j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!j.jE() && !com.baidu.tieba.video.f.bBb().bBc()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.mContext.getPageActivity(), c.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aiT();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(1);
            aVar.cd(d.C0141d.cp_cont_b);
            aVar.au(true);
            aVar.b(this.mTbPageContext).xa();
        } else {
            aiT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiT() {
        if (this.cyf != null && this.cyf.brC != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyf.brC);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cxQ.getX() + this.dNR.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cxQ.getY() + this.dNR.getY());
            videoCardViewInfo.cardViewWidth = this.cxQ.getWidth();
            videoCardViewInfo.cardViewHeight = this.cxQ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cyf.brC.getTid(), o.vb(), this.cyf.ajq(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aiM() {
        return this.cyf.cBM && !this.cyf.cBW;
    }

    private void ah(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cyf);
        }
        if (this.cyf != null && this.cyf.brC != null) {
            if (!aiM()) {
                o.lb(this.cyf.brC.getId());
                o.a(this.mTextTitle, this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyf.brC, null, o.vb(), 18003, true, false, false).addLocateParam(this.cyf.ajq());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cyf.brC.getFid()));
            addLocateParam.setForumName(this.cyf.brC.vr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cvM) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aCi() {
        if (this.dNK == null) {
            this.dNK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aCj() {
        if (this.dNN == null) {
            this.dNN = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.dNN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.cyf);
                }
                if (c.this.cyf != null && c.this.cyf.brC != null) {
                    o.lb(c.this.cyf.brC.getId());
                    c.this.aiN();
                }
            }
        });
    }

    private void refreshView() {
        if (this.cyf == null || this.cyf.brC == null || this.cyf.brC.vm() == null || this.cyf.brC.vD() == null) {
            this.bFc.setVisibility(8);
            return;
        }
        this.bFc.setVisibility(0);
        if (this.cyf.ajv()) {
            aCj();
            this.dNO = this.dNN;
            this.dNN.setVisibility(0);
            if (this.dNK != null) {
                this.dNK.setVisibility(8);
            }
        } else {
            aCi();
            this.dNO = this.dNK;
            this.dNK.setVisibility(0);
            if (this.dNN != null) {
                this.dNN.setVisibility(8);
            }
        }
        aiW();
        if (!aiM() && o.lc(this.cyf.brC.getId())) {
            o.a(this.mTextTitle, this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.cyf.Sz().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cyf.Sz().vT();
        SpannableStringBuilder vK = this.cyf.Sz().vK();
        if (this.cyf.Sz().vQ() && !StringUtils.isNull(this.cyf.Sz().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyf.Sz().getTid();
            vK.append((CharSequence) this.cyf.Sz().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.6
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vK));
        this.mTextTitle.setText(vK);
        if (this.dNO.getHeaderImg() != null) {
            this.dNO.getHeaderImg().setAfterClickListener(this.cyu);
            if (this.dNO.getIsSimpleThread()) {
                this.dNO.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (this.cyf.Sz() == null || this.cyf.Sz().vm() == null || this.cyf.Sz().vm().getPendantData() == null || StringUtils.isNull(this.cyf.Sz().vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.dNO.getHeaderImg().setVisibility(0);
                this.dNO.getHeaderImg().setData(this.cyf.Sz(), !this.cyf.ajv());
            } else {
                this.dNO.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(this.cyf.Sz());
            }
        }
        this.dNO.setData(this.cyf.brC);
        this.dNO.setUserAfterClickListener(this.cyt);
        this.cya.setText(ao.cX(this.cyf.brC.vD().video_duration.intValue() * 1000));
        this.cxR.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ao.E(this.cyf.brC.vD().play_count.intValue())));
        this.cvM.setData(this.cyf.Sz().wy());
        this.cvM.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lc(this.cyf.brC.getId())) {
            al.c(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        hd(go(1));
    }

    private void aiW() {
        if (this.cxQ != null && this.cxX != null) {
            if (i.tt().tz() && this.cyf != null && this.cyf.brC != null && this.cyf.brC.vD() != null) {
                this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cxQ.startLoad(this.cyf.brC.vD().thumbnail_url, 10, false);
                this.cxX.setVisibility(0);
                return;
            }
            this.cxX.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dNO != null) {
            this.dNO.setPageUniqueId(bdUniqueId);
        }
        if (this.cxQ != null) {
            this.cxQ.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.cyf != null && this.cyf.brC != null) {
            o.a(this.mTextTitle, this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.cyf.Sz().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dNO != null) {
            return this.dNO.getHeaderImg();
        }
        return null;
    }

    public View aiL() {
        if (this.dNO != null) {
            return this.dNO.getUserName();
        }
        return null;
    }

    public void hd(int i) {
        if (this.cyf != null && this.cyf.brC != null) {
            if (!this.cyf.ajv() && i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setStType(o.vb());
                this.bFT.setData(this.cyf.brC);
                this.dNO.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.cyf.brC);
            this.bFe.setStType(o.vb());
            this.bFT.setVisibility(8);
            this.dNO.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}

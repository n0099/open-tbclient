package com.baidu.tieba.homepage.concern.view;

import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
import com.baidu.tieba.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener azz;
    private RelativeLayout bNB;
    public ThreadCommentAndPraiseInfoLayout bND;
    private View bNG;
    private String bNq;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    public FrameLayout bgl;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private TextView bgv;
    private TbImageView.a bgx;
    private ThreadGodReplyLayout cCi;
    private TextView cEB;
    private final View.OnClickListener cEE;
    private final View.OnClickListener cEF;
    private LinearLayout cEs;
    private l cEu;
    public ConcernThreadUserInfoLayout ebd;
    public ConcernForumThreadUserInfoLayout ebf;
    public com.baidu.tbadk.core.view.f ebg;
    private LinearLayout ebj;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && c.this.bgn != null) {
                    c.this.bgn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cEE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.cEu);
                }
            }
        };
        this.cEF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.cEu);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cEu != null) {
                    if (c.this.akm() != null) {
                        c.this.akm().a(view, c.this.cEu);
                    }
                    if (c.this.cEu.bzB != null && view != c.this.bOr.aBk) {
                        o.lA(c.this.cEu.bzB.getId());
                        c.this.akr();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bNB = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bOo = (HeadPendantClickableView) this.bNB.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.ds70));
        }
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ebj = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setIsBarViewVisible(false);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setFrom(9);
        this.bND.setDisPraiseFrom(4);
        this.bND.setShareReportFrom(4);
        this.bND.setForumAfterClickListener(this.azz);
        this.bND.amD = this.currentPageType;
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this);
        this.bOr.setShareReportFrom(4);
        this.bOr.setFrom(9);
        this.bOr.aBl.amD = this.currentPageType;
        this.bOr.setForumAfterClickListener(this.azz);
        this.bNB.setOnClickListener(this);
        this.bgl = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bgl.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgl.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bgl.setLayoutParams(layoutParams2);
        this.bgn = (TbImageView) view.findViewById(e.g.image_video);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setGifIconSupport(false);
        this.bgn.setEvent(this.bgx);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.bgm = (TextView) view.findViewById(e.g.text_video_duration);
        this.cEs = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bgv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.bNG = view.findViewById(e.g.divider_line);
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cCi.setOnClickListener(this);
        this.cEB = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bNB, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            this.bND.onChangeSkinType();
            this.bOr.onChangeSkinType();
            al.i(this.bNG, e.d.cp_bg_line_e);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.bgv, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.ebd != null && this.ebd.getVisibility() == 0) {
            this.ebd.onChangeSkinType(i);
        }
        if (this.ebf != null && this.ebf.getVisibility() == 0) {
            this.ebf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cEu = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bNB || view == this.cCi) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bgl) {
            if (this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null) {
                z = this.cEu.bzB.wE().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(getView());
            } else {
                aA(getView());
            }
        }
    }

    private void ay(View view) {
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (!j.kK()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akw();
        }
    }

    private void akw() {
        if (this.cEu != null && this.cEu.bzB != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cEu.bzB);
            videoItemData.mRecomExtra = this.cEu.getExtra();
            videoItemData.mRecomAbTag = this.cEu.akY();
            videoItemData.mRecomSource = this.cEu.getSource();
            videoItemData.mRecomWeight = this.cEu.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cEu.akX(), "concern_tab")));
        }
    }

    private void aL(View view) {
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (!j.kK()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akx();
        }
    }

    private void akx() {
        if (this.cEu != null && this.cEu.bzB != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cEu.bzB);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bgn.getX() + this.ebj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bgn.getY() + this.ebj.getY());
            videoCardViewInfo.cardViewWidth = this.bgn.getWidth();
            videoCardViewInfo.cardViewHeight = this.bgn.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cEu.bzB.getTid(), o.wa(), this.cEu.akX(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean akq() {
        return this.cEu.cIa && !this.cEu.cIj;
    }

    private void aA(View view) {
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (this.cEu != null && this.cEu.bzB != null) {
            if (!akq()) {
                o.lA(this.cEu.bzB.getId());
                o.a(this.mTextTitle, this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cEu.bzB, null, o.wa(), 18003, true, false, false).addLocateParam(this.cEu.akX());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cEu.bzB.getFid()));
            addLocateParam.setForumName(this.cEu.bzB.ws());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cCi) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aFE() {
        if (this.ebd == null) {
            this.ebd = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aFF() {
        if (this.ebf == null) {
            this.ebf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.ebf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.cEu);
                }
                if (c.this.cEu != null && c.this.cEu.bzB != null) {
                    o.lA(c.this.cEu.bzB.getId());
                    c.this.akr();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cEu == null || this.cEu.bzB == null || this.cEu.bzB.wm() == null || this.cEu.bzB.wE() == null) {
            this.bNB.setVisibility(8);
            return;
        }
        this.bNB.setVisibility(0);
        if (this.cEu.alc()) {
            aFF();
            this.ebg = this.ebf;
            this.ebf.setVisibility(0);
            if (this.ebd != null) {
                this.ebd.setVisibility(8);
            }
        } else {
            aFE();
            this.ebg = this.ebd;
            this.ebd.setVisibility(0);
            if (this.ebf != null) {
                this.ebf.setVisibility(8);
            }
        }
        akA();
        if (!akq() && o.lB(this.cEu.bzB.getId())) {
            o.a(this.mTextTitle, this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.cEu.UT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cEu.UT().wW();
        SpannableStringBuilder wM = this.cEu.UT().wM();
        if (this.cEu.UT().wT() && !StringUtils.isNull(this.cEu.UT().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cEu.UT().getTid();
            wM.append((CharSequence) this.cEu.UT().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(wM));
        this.mTextTitle.setText(wM);
        if (this.ebg.getHeaderImg() != null) {
            this.ebg.getHeaderImg().setAfterClickListener(this.cEF);
            if (this.ebg.getIsSimpleThread()) {
                this.ebg.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (this.cEu.UT() == null || this.cEu.UT().wm() == null || this.cEu.UT().wm().getPendantData() == null || StringUtils.isNull(this.cEu.UT().wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.ebg.getHeaderImg().setVisibility(0);
                this.ebg.getHeaderImg().setData(this.cEu.UT(), !this.cEu.alc());
            } else {
                this.ebg.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(this.cEu.UT());
            }
        }
        this.ebg.setData(this.cEu.bzB);
        this.ebg.setUserAfterClickListener(this.cEE);
        this.bgm.setText(ao.dj(this.cEu.bzB.wE().video_duration.intValue() * 1000));
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.L(this.cEu.bzB.wE().play_count.intValue())));
        this.cCi.setData(this.cEu.UT().xD());
        this.cCi.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lB(this.cEu.bzB.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        hM(gT(1));
        if (this.cEu == null || this.cEu.bzB == null || this.cEu.bzB.wE() == null) {
            z = false;
        } else if (this.cEu.bzB.wE().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cEB.setVisibility(0);
        } else {
            this.cEB.setVisibility(8);
        }
    }

    private void akA() {
        if (this.bgn != null && this.bgl != null) {
            if (i.uj().un() && this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null) {
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(this.cEu.bzB.wE().thumbnail_url, 10, false);
                this.bgl.setVisibility(0);
                return;
            }
            this.bgl.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ebg != null) {
            this.ebg.setPageUniqueId(bdUniqueId);
        }
        if (this.bgn != null) {
            this.bgn.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        if (this.cEu != null && this.cEu.bzB != null) {
            o.a(this.mTextTitle, this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.cEu.UT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ebg != null) {
            return this.ebg.getHeaderImg();
        }
        return null;
    }

    public View akp() {
        if (this.ebg != null) {
            return this.ebg.getUserName();
        }
        return null;
    }

    public void hM(int i) {
        if (this.cEu != null && this.cEu.bzB != null) {
            if (!this.cEu.alc() && i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setStType(o.wa());
                this.bOr.setData(this.cEu.bzB);
                this.ebg.showForumNameView(false);
                return;
            }
            this.bND.setData(this.cEu.bzB);
            this.bND.setStType(o.wa());
            this.bOr.setVisibility(8);
            this.ebg.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bgn.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bgn.setOnDrawListener(null);
        }
    }
}

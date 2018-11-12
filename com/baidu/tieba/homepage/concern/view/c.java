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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aEX;
    private String bWE;
    private RelativeLayout bWP;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    public FrameLayout blm;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private TextView blv;
    private TbImageView.a blx;
    private ThreadGodReplyLayout cLJ;
    private LinearLayout cNS;
    private l cNU;
    private TextView cOb;
    private final View.OnClickListener cOe;
    private final View.OnClickListener cOf;
    public ConcernThreadUserInfoLayout ekr;
    public ConcernForumThreadUserInfoLayout ekt;
    public com.baidu.tbadk.core.view.f eku;
    private LinearLayout ekx;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.blo != null) {
                    c.this.blo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cOe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.cNU);
                }
            }
        };
        this.cOf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.cNU);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cNU != null) {
                    if (c.this.anq() != null) {
                        c.this.anq().a(view, c.this.cNU);
                    }
                    if (c.this.cNU.bIU != null && view != c.this.bXE.aGH) {
                        o.me(c.this.cNU.bIU.getId());
                        c.this.anv();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bWP = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bXB = (HeadPendantClickableView) this.bWP.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.ds70));
        }
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ekx = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setFrom(9);
        this.bWR.setDisPraiseFrom(4);
        this.bWR.setShareReportFrom(4);
        this.bWR.setForumAfterClickListener(this.aEX);
        this.bWR.asl = this.currentPageType;
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this);
        this.bXE.setShareReportFrom(4);
        this.bXE.setFrom(9);
        this.bXE.aGI.asl = this.currentPageType;
        this.bXE.setForumAfterClickListener(this.aEX);
        this.bWP.setOnClickListener(this);
        this.blm = (FrameLayout) view.findViewById(e.g.frame_video);
        this.blm.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.blm.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.blm.setLayoutParams(layoutParams2);
        this.blo = (TbImageView) view.findViewById(e.g.image_video);
        this.blo.setDefaultErrorResource(0);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setGifIconSupport(false);
        this.blo.setEvent(this.blx);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.bln = (TextView) view.findViewById(e.g.text_video_duration);
        this.cNS = (LinearLayout) view.findViewById(e.g.duration_container);
        this.blv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cLJ.setOnClickListener(this);
        this.cOb = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWP, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            this.bWR.onChangeSkinType();
            this.bXE.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.blv, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.ekr != null && this.ekr.getVisibility() == 0) {
            this.ekr.onChangeSkinType(i);
        }
        if (this.ekt != null && this.ekt.getVisibility() == 0) {
            this.ekt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cNU = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bWP || view == this.cLJ) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.blm) {
            if (this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null) {
                z = this.cNU.bIU.yU().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(getView());
            } else {
                aC(getView());
            }
        }
    }

    private void aA(View view) {
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anA();
        }
    }

    private void anA() {
        if (this.cNU != null && this.cNU.bIU != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cNU.bIU);
            videoItemData.mRecomExtra = this.cNU.getExtra();
            videoItemData.mRecomAbTag = this.cNU.aoc();
            videoItemData.mRecomSource = this.cNU.getSource();
            videoItemData.mRecomWeight = this.cNU.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cNU.aob(), "concern_tab")));
        }
    }

    private void aN(View view) {
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anB();
        }
    }

    private void anB() {
        if (this.cNU != null && this.cNU.bIU != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cNU.bIU);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.blo.getX() + this.ekx.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.blo.getY() + this.ekx.getY());
            videoCardViewInfo.cardViewWidth = this.blo.getWidth();
            videoCardViewInfo.cardViewHeight = this.blo.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cNU.bIU.getTid(), o.yq(), this.cNU.aob(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean anu() {
        return this.cNU.cRz && !this.cNU.cRI;
    }

    private void aC(View view) {
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (this.cNU != null && this.cNU.bIU != null) {
            if (!anu()) {
                o.me(this.cNU.bIU.getId());
                o.a(this.mTextTitle, this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cNU.bIU, null, o.yq(), 18003, true, false, false).addLocateParam(this.cNU.aob());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cNU.bIU.getFid()));
            addLocateParam.setForumName(this.cNU.bIU.yI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cLJ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aIu() {
        if (this.ekr == null) {
            this.ekr = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aIv() {
        if (this.ekt == null) {
            this.ekt = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.ekt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.cNU);
                }
                if (c.this.cNU != null && c.this.cNU.bIU != null) {
                    o.me(c.this.cNU.bIU.getId());
                    c.this.anv();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cNU == null || this.cNU.bIU == null || this.cNU.bIU.yC() == null || this.cNU.bIU.yU() == null) {
            this.bWP.setVisibility(8);
            return;
        }
        this.bWP.setVisibility(0);
        if (this.cNU.aog()) {
            aIv();
            this.eku = this.ekt;
            this.ekt.setVisibility(0);
            if (this.ekr != null) {
                this.ekr.setVisibility(8);
            }
        } else {
            aIu();
            this.eku = this.ekr;
            this.ekr.setVisibility(0);
            if (this.ekt != null) {
                this.ekt.setVisibility(8);
            }
        }
        anE();
        if (!anu() && o.mf(this.cNU.bIU.getId())) {
            o.a(this.mTextTitle, this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.cNU.YL().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cNU.YL().zm();
        SpannableStringBuilder zc = this.cNU.YL().zc();
        if (this.cNU.YL().zj() && !StringUtils.isNull(this.cNU.YL().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cNU.YL().getTid();
            zc.append((CharSequence) this.cNU.YL().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(zc));
        this.mTextTitle.setText(zc);
        if (this.eku.getHeaderImg() != null) {
            this.eku.getHeaderImg().setAfterClickListener(this.cOf);
            if (this.eku.getIsSimpleThread()) {
                this.eku.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (this.cNU.YL() == null || this.cNU.YL().yC() == null || this.cNU.YL().yC().getPendantData() == null || StringUtils.isNull(this.cNU.YL().yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.eku.getHeaderImg().setVisibility(0);
                this.eku.getHeaderImg().setData(this.cNU.YL(), !this.cNU.aog());
            } else {
                this.eku.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(this.cNU.YL());
            }
        }
        this.eku.setData(this.cNU.bIU);
        this.eku.setUserAfterClickListener(this.cOe);
        this.bln.setText(ao.dH(this.cNU.bIU.yU().video_duration.intValue() * 1000));
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.P(this.cNU.bIU.yU().play_count.intValue())));
        this.cLJ.setData(this.cNU.YL().zT());
        this.cLJ.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mf(this.cNU.bIU.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        ix(ho(1));
        if (this.cNU == null || this.cNU.bIU == null || this.cNU.bIU.yU() == null) {
            z = false;
        } else if (this.cNU.bIU.yU().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cOb.setVisibility(0);
        } else {
            this.cOb.setVisibility(8);
        }
    }

    private void anE() {
        if (this.blo != null && this.blm != null) {
            if (i.wA().wE() && this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null) {
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(this.cNU.bIU.yU().thumbnail_url, 10, false);
                this.blm.setVisibility(0);
                return;
            }
            this.blm.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eku != null) {
            this.eku.setPageUniqueId(bdUniqueId);
        }
        if (this.blo != null) {
            this.blo.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (this.cNU != null && this.cNU.bIU != null) {
            o.a(this.mTextTitle, this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.cNU.YL().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eku != null) {
            return this.eku.getHeaderImg();
        }
        return null;
    }

    public View ant() {
        if (this.eku != null) {
            return this.eku.getUserName();
        }
        return null;
    }

    public void ix(int i) {
        if (this.cNU != null && this.cNU.bIU != null) {
            if (!this.cNU.aog() && i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setStType(o.yq());
                this.bXE.setData(this.cNU.bIU);
                this.eku.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.cNU.bIU);
            this.bWR.setStType(o.yq());
            this.bXE.setVisibility(8);
            this.eku.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.blo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.blo.setOnDrawListener(null);
        }
    }
}

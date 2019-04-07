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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private String YA;
    private View aLe;
    private final View.OnClickListener bRB;
    public FrameLayout cAd;
    private TextView cAe;
    private TbImageView cAf;
    private ImageView cAg;
    private TextView cAl;
    private TbImageView.a cAn;
    private RelativeLayout dqw;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public ThreadSourceShareAndPraiseLayout drn;
    private l ehA;
    private TextView ehH;
    private final View.OnClickListener ehL;
    private final View.OnClickListener ehM;
    private ThreadGodReplyLayout ehv;
    private HeadPendantClickableView ehw;
    private LinearLayout ehy;
    public ConcernThreadUserInfoLayout fGV;
    public ConcernForumThreadUserInfoLayout fGX;
    public com.baidu.tbadk.core.view.d fGY;
    private LinearLayout fHb;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAf != null) {
                    c.this.cAf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ehL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.ehA);
                }
            }
        };
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.ehA);
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ehA != null) {
                    if (c.this.aQf() != null) {
                        c.this.aQf().a(view, c.this.ehA);
                    }
                    if (c.this.ehA.cZC != null && view != c.this.drn.bSS) {
                        n.tz(c.this.ehA.cZC.getId());
                        c.this.blx();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dqw = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehw = (HeadPendantClickableView) this.dqw.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.fHb = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqy.setLayoutParams(layoutParams);
        }
        this.dqy.setOnClickListener(this);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setIsBarViewVisible(false);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setShareVisible(true);
        this.dqy.setFrom(9);
        this.dqy.setDisPraiseFrom(4);
        this.dqy.setShareReportFrom(4);
        this.dqy.setForumAfterClickListener(this.bRB);
        this.dqy.bSJ = this.currentPageType;
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.drn.bTB.setOnClickListener(this);
        this.drn.setShareReportFrom(4);
        this.drn.setFrom(9);
        this.drn.bTB.bSJ = this.currentPageType;
        this.drn.setForumAfterClickListener(this.bRB);
        this.dqw.setOnClickListener(this);
        this.cAd = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAd.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAd.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAd.setLayoutParams(layoutParams2);
        this.cAf = (TbImageView) view.findViewById(d.g.image_video);
        this.cAf.setDefaultErrorResource(0);
        this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAf.setGifIconSupport(false);
        this.cAf.setEvent(this.cAn);
        this.cAf.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAf;
        TbImageView tbImageView2 = this.cAf;
        tbImageView.setConrers(15);
        this.cAf.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAf.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAf.setBorderSurroundContent(true);
        this.cAf.setDrawBorder(true);
        this.cAg = (ImageView) view.findViewById(d.g.image_video_play);
        this.cAe = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehy = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAl = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aLe = view.findViewById(d.g.divider_line);
        this.ehv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehv.setOnClickListener(this);
        this.ehH = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqw, d.f.addresslist_item_bg);
            al.c(this.cAg, d.f.btn_icon_play_video_n);
            this.dqy.onChangeSkinType();
            this.drn.onChangeSkinType();
            al.k(this.aLe, d.C0277d.cp_bg_line_e);
            al.j(this.cAe, d.C0277d.cp_btn_a);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.fGV != null && this.fGV.getVisibility() == 0) {
            this.fGV.onChangeSkinType(i);
        }
        if (this.fGX != null && this.fGX.getVisibility() == 0) {
            this.fGX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.ehA = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqw || view == this.ehv) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAd) {
            if (this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null) {
                z = this.ehA.cZC.Zf().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(getView());
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.ehA != null && this.ehA.cZC != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehA.cZC);
            videoItemData.mRecomExtra = this.ehA.getExtra();
            videoItemData.mRecomAbTag = this.ehA.aQO();
            videoItemData.mRecomSource = this.ehA.getSource();
            videoItemData.mRecomWeight = this.ehA.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.ehA.WR(), "concern_tab")));
        }
    }

    private void bI(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQo() {
        if (this.ehA != null && this.ehA.cZC != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehA.cZC);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAf.getX() + this.fHb.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAf.getY() + this.fHb.getY());
            videoCardViewInfo.cardViewWidth = this.cAf.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAf.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.ehA.cZC.getTid(), n.YB(), this.ehA.WR(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aQp() {
        return this.ehA.elu && !this.ehA.elC;
    }

    private void bz(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (this.ehA != null && this.ehA.cZC != null) {
            if (!aQp()) {
                n.tz(this.ehA.cZC.getId());
                n.a(this.mTextTitle, this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehA.cZC, null, n.YB(), 18003, true, false, false).addLocateParam(this.ehA.WR());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.ehA.cZC.getFid()));
            addLocateParam.setForumName(this.ehA.cZC.YT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehv) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bly() {
        if (this.fGV == null) {
            this.fGV = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void blz() {
        if (this.fGX == null) {
            this.fGX = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.fGX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.ehA);
                }
                if (c.this.ehA != null && c.this.ehA.cZC != null) {
                    n.tz(c.this.ehA.cZC.getId());
                    c.this.blx();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.ehA == null || this.ehA.cZC == null || this.ehA.cZC.YO() == null || this.ehA.cZC.Zf() == null) {
            this.dqw.setVisibility(8);
            return;
        }
        this.dqw.setVisibility(0);
        if (this.ehA.aQS()) {
            blz();
            this.fGY = this.fGX;
            this.fGX.setVisibility(0);
            if (this.fGV != null) {
                this.fGV.setVisibility(8);
            }
        } else {
            bly();
            this.fGY = this.fGV;
            this.fGV.setVisibility(0);
            if (this.fGX != null) {
                this.fGX.setVisibility(8);
            }
        }
        aQt();
        if (!aQp() && n.tA(this.ehA.cZC.getId())) {
            n.a(this.mTextTitle, this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehv.getGodReplyContent(), this.ehA.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehA.WO().ZE();
        SpannableStringBuilder Zu = this.ehA.WO().Zu();
        if (this.ehA.WO().ZB() && !StringUtils.isNull(this.ehA.WO().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehA.WO().getTid();
            Zu.append((CharSequence) this.ehA.WO().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(Zu));
        this.mTextTitle.setText(Zu);
        if (this.fGY.getHeaderImg() != null) {
            this.fGY.getHeaderImg().setAfterClickListener(this.ehM);
            if (this.fGY.getIsSimpleThread()) {
                this.fGY.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (this.ehA.WO() == null || this.ehA.WO().YO() == null || this.ehA.WO().YO().getPendantData() == null || StringUtils.isNull(this.ehA.WO().YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.fGY.getHeaderImg().setVisibility(0);
                this.fGY.getHeaderImg().setData(this.ehA.WO(), !this.ehA.aQS());
            } else {
                this.fGY.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(this.ehA.WO());
            }
        }
        this.fGY.setData(this.ehA.cZC);
        this.fGY.setUserAfterClickListener(this.ehL);
        this.cAe.setText(ap.hy(this.ehA.cZC.Zf().video_duration.intValue() * 1000));
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehA.cZC.Zf().play_count.intValue())));
        this.ehv.setData(this.ehA.WO().aam());
        this.ehv.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehA.cZC.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        mE(ls(1));
        if (this.ehA == null || this.ehA.cZC == null || this.ehA.cZC.Zf() == null) {
            z = false;
        } else if (this.ehA.cZC.Zf().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.ehH.setVisibility(0);
        } else {
            this.ehH.setVisibility(8);
        }
    }

    private void aQt() {
        if (this.cAf != null && this.cAd != null) {
            if (i.Wv().Wz() && this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null) {
                this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAf.startLoad(this.ehA.cZC.Zf().thumbnail_url, 10, false);
                this.cAd.setVisibility(0);
                return;
            }
            this.cAd.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGY != null) {
            this.fGY.setPageUniqueId(bdUniqueId);
        }
        if (this.cAf != null) {
            this.cAf.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (this.ehA != null && this.ehA.cZC != null) {
            n.a(this.mTextTitle, this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehv.getGodReplyContent(), this.ehA.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fGY != null) {
            return this.fGY.getHeaderImg();
        }
        return null;
    }

    public View aQk() {
        if (this.fGY != null) {
            return this.fGY.getUserName();
        }
        return null;
    }

    public void mE(int i) {
        if (this.ehA != null && this.ehA.cZC != null) {
            if (!this.ehA.aQS() && i == 1) {
                this.dqy.setVisibility(8);
                this.drn.setStType(n.YB());
                this.drn.setData(this.ehA.cZC);
                this.fGY.dN(false);
                return;
            }
            this.dqy.setData(this.ehA.cZC);
            this.dqy.setStType(n.YB());
            this.drn.setVisibility(8);
            this.fGY.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAf.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAf.setOnDrawListener(null);
        }
    }
}

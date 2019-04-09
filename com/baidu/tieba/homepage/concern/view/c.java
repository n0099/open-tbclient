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
    private String YB;
    private View aLf;
    private final View.OnClickListener bRC;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAm;
    private TbImageView.a cAo;
    private RelativeLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private l ehB;
    private TextView ehI;
    private final View.OnClickListener ehM;
    private final View.OnClickListener ehN;
    private ThreadGodReplyLayout ehw;
    private HeadPendantClickableView ehx;
    private LinearLayout ehz;
    public ConcernThreadUserInfoLayout fGV;
    public ConcernForumThreadUserInfoLayout fGX;
    public com.baidu.tbadk.core.view.d fGY;
    private LinearLayout fHb;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAg != null) {
                    c.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.ehB);
                }
            }
        };
        this.ehN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.ehB);
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ehB != null) {
                    if (c.this.aQf() != null) {
                        c.this.aQf().a(view, c.this.ehB);
                    }
                    if (c.this.ehB.cZD != null && view != c.this.dro.bST) {
                        n.tz(c.this.ehB.cZD.getId());
                        c.this.blx();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dqx = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehx = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehx.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.fHb = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.setShareReportFrom(4);
        this.dqz.setForumAfterClickListener(this.bRC);
        this.dqz.bSK = this.currentPageType;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTC.bSK = this.currentPageType;
        this.dro.setForumAfterClickListener(this.bRC);
        this.dqx.setOnClickListener(this);
        this.cAe = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAe.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAe.setLayoutParams(layoutParams2);
        this.cAg = (TbImageView) view.findViewById(d.g.image_video);
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAg.setGifIconSupport(false);
        this.cAg.setEvent(this.cAo);
        this.cAg.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAg;
        TbImageView tbImageView2 = this.cAg;
        tbImageView.setConrers(15);
        this.cAg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAg.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.cAh = (ImageView) view.findViewById(d.g.image_video_play);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehz = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aLf = view.findViewById(d.g.divider_line);
        this.ehw = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehw.setOnClickListener(this);
        this.ehI = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqx, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
            al.k(this.aLf, d.C0277d.cp_bg_line_e);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAm, d.C0277d.cp_btn_a);
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
        this.ehB = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqx || view == this.ehw) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAe) {
            if (this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null) {
                z = this.ehB.cZD.Zf().is_vertical.intValue() == 1;
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
            aQf().a(view, this.ehB);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.ehB != null && this.ehB.cZD != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehB.cZD);
            videoItemData.mRecomExtra = this.ehB.getExtra();
            videoItemData.mRecomAbTag = this.ehB.aQO();
            videoItemData.mRecomSource = this.ehB.getSource();
            videoItemData.mRecomWeight = this.ehB.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.ehB.WR(), "concern_tab")));
        }
    }

    private void bI(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehB);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQo() {
        if (this.ehB != null && this.ehB.cZD != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehB.cZD);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAg.getX() + this.fHb.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAg.getY() + this.fHb.getY());
            videoCardViewInfo.cardViewWidth = this.cAg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.ehB.cZD.getTid(), n.YB(), this.ehB.WR(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aQp() {
        return this.ehB.elv && !this.ehB.elD;
    }

    private void bz(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehB);
        }
        if (this.ehB != null && this.ehB.cZD != null) {
            if (!aQp()) {
                n.tz(this.ehB.cZD.getId());
                n.a(this.mTextTitle, this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehB.cZD, null, n.YB(), 18003, true, false, false).addLocateParam(this.ehB.WR());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.ehB.cZD.getFid()));
            addLocateParam.setForumName(this.ehB.cZD.YT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehw) {
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
                    c.this.aQf().a(view, c.this.ehB);
                }
                if (c.this.ehB != null && c.this.ehB.cZD != null) {
                    n.tz(c.this.ehB.cZD.getId());
                    c.this.blx();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.ehB == null || this.ehB.cZD == null || this.ehB.cZD.YO() == null || this.ehB.cZD.Zf() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        if (this.ehB.aQS()) {
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
        if (!aQp() && n.tA(this.ehB.cZD.getId())) {
            n.a(this.mTextTitle, this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehw.getGodReplyContent(), this.ehB.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehB.WO().ZE();
        SpannableStringBuilder Zu = this.ehB.WO().Zu();
        if (this.ehB.WO().ZB() && !StringUtils.isNull(this.ehB.WO().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehB.WO().getTid();
            Zu.append((CharSequence) this.ehB.WO().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
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
            this.fGY.getHeaderImg().setAfterClickListener(this.ehN);
            if (this.fGY.getIsSimpleThread()) {
                this.fGY.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (this.ehB.WO() == null || this.ehB.WO().YO() == null || this.ehB.WO().YO().getPendantData() == null || StringUtils.isNull(this.ehB.WO().YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.fGY.getHeaderImg().setVisibility(0);
                this.fGY.getHeaderImg().setData(this.ehB.WO(), !this.ehB.aQS());
            } else {
                this.fGY.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(this.ehB.WO());
            }
        }
        this.fGY.setData(this.ehB.cZD);
        this.fGY.setUserAfterClickListener(this.ehM);
        this.cAf.setText(ap.hy(this.ehB.cZD.Zf().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehB.cZD.Zf().play_count.intValue())));
        this.ehw.setData(this.ehB.WO().aam());
        this.ehw.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehB.cZD.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        mE(ls(1));
        if (this.ehB == null || this.ehB.cZD == null || this.ehB.cZD.Zf() == null) {
            z = false;
        } else if (this.ehB.cZD.Zf().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.ehI.setVisibility(0);
        } else {
            this.ehI.setVisibility(8);
        }
    }

    private void aQt() {
        if (this.cAg != null && this.cAe != null) {
            if (i.Wv().Wz() && this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null) {
                this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAg.startLoad(this.ehB.cZD.Zf().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                return;
            }
            this.cAe.setVisibility(8);
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
        if (this.cAg != null) {
            this.cAg.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (this.ehB != null && this.ehB.cZD != null) {
            n.a(this.mTextTitle, this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehw.getGodReplyContent(), this.ehB.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
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
        if (this.ehB != null && this.ehB.cZD != null) {
            if (!this.ehB.aQS() && i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(n.YB());
                this.dro.setData(this.ehB.cZD);
                this.fGY.dN(false);
                return;
            }
            this.dqz.setData(this.ehB.cZD);
            this.dqz.setStType(n.YB());
            this.dro.setVisibility(8);
            this.fGY.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAg.setOnDrawListener(null);
        }
    }
}

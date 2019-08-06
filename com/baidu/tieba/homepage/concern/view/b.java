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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<l> implements e {
    private String WN;
    private View aNH;
    public FrameLayout cJO;
    private TextView cJP;
    private TbImageView cJQ;
    private ImageView cJR;
    private TextView cJW;
    private TbImageView.a cJY;
    private final View.OnClickListener caC;
    private RelativeLayout dEG;
    public ThreadCommentAndPraiseInfoLayout dEI;
    public ThreadSourceShareAndPraiseLayout dFv;
    private TextView eCB;
    private final View.OnClickListener eCF;
    private final View.OnClickListener eCG;
    private ThreadGodReplyLayout eCq;
    private HeadPendantClickableView eCr;
    private LinearLayout eCs;
    private l eCu;
    public ConcernThreadUserInfoLayout gdU;
    public ConcernForumThreadUserInfoLayout gdV;
    public d gdW;
    private LinearLayout gdZ;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && b.this.cJQ != null) {
                    b.this.cJQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eCF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZq() != null) {
                    b.this.aZq().a(view, b.this.eCu);
                }
            }
        };
        this.eCG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZq() != null) {
                    b.this.aZq().a(view, b.this.eCu);
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eCu != null) {
                    if (b.this.aZq() != null) {
                        b.this.aZq().a(view, b.this.eCu);
                    }
                    if (b.this.eCu.threadData != null && view != b.this.dFv.cbV) {
                        n.vx(b.this.eCu.threadData.getId());
                        b.this.bvm();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dEG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eCr = (HeadPendantClickableView) this.dEG.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eCr.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gdZ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dEI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEI.setLayoutParams(layoutParams);
        }
        this.dEI.setOnClickListener(this);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setIsBarViewVisible(false);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setShareVisible(true);
        this.dEI.setFrom(9);
        this.dEI.setDisPraiseFrom(4);
        this.dEI.setShareReportFrom(4);
        this.dEI.setForumAfterClickListener(this.caC);
        this.dEI.cbM = this.currentPageType;
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dFv.ccH.setOnClickListener(this);
        this.dFv.setShareReportFrom(4);
        this.dFv.setFrom(9);
        this.dFv.ccH.cbM = this.currentPageType;
        this.dFv.setForumAfterClickListener(this.caC);
        this.dEG.setOnClickListener(this);
        this.cJO = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cJO.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cJO.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cJO.setLayoutParams(layoutParams2);
        this.cJQ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJQ.setDefaultErrorResource(0);
        this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJQ.setGifIconSupport(false);
        this.cJQ.setEvent(this.cJY);
        this.cJQ.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJQ;
        TbImageView tbImageView2 = this.cJQ;
        tbImageView.setConrers(15);
        this.cJQ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJQ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJQ.setBorderSurroundContent(true);
        this.cJQ.setDrawBorder(true);
        this.cJR = (ImageView) view.findViewById(R.id.image_video_play);
        this.cJP = (TextView) view.findViewById(R.id.text_video_duration);
        this.eCs = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cJW = (TextView) view.findViewById(R.id.text_video_play_count);
        this.aNH = view.findViewById(R.id.divider_line);
        this.eCq = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCq.setOnClickListener(this);
        this.eCB = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEG, R.drawable.addresslist_item_bg);
            am.c(this.cJR, (int) R.drawable.btn_icon_play_video_n);
            this.dEI.onChangeSkinType();
            this.dFv.onChangeSkinType();
            am.k(this.aNH, R.color.cp_bg_line_e);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.cJW, R.color.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.gdU != null && this.gdU.getVisibility() == 0) {
            this.gdU.onChangeSkinType(i);
        }
        if (this.gdV != null && this.gdV.getVisibility() == 0) {
            this.gdV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.eCu = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dEG || view == this.eCq) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cJO) {
            if (this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null) {
                z = this.eCu.threadData.aeP().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bT(getView());
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZy();
        }
    }

    private void aZy() {
        if (this.eCu != null && this.eCu.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eCu.threadData);
            videoItemData.mRecomExtra = this.eCu.bac();
            videoItemData.mRecomAbTag = this.eCu.baa();
            videoItemData.mRecomSource = this.eCu.getSource();
            videoItemData.mRecomWeight = this.eCu.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.eCu.acB(), "concern_tab")));
        }
    }

    private void bT(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZz();
        }
    }

    private void aZz() {
        if (this.eCu != null && this.eCu.threadData != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eCu.threadData);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cJQ.getX() + this.gdZ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cJQ.getY() + this.gdZ.getY());
            videoCardViewInfo.cardViewWidth = this.cJQ.getWidth();
            videoCardViewInfo.cardViewHeight = this.cJQ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.eCu.threadData.getTid(), n.ael(), this.eCu.acB(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aZA() {
        return this.eCu.eGn && !this.eCu.eGu;
    }

    private void bI(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (this.eCu != null && this.eCu.threadData != null) {
            if (!aZA()) {
                n.vx(this.eCu.threadData.getId());
                n.a(this.mTextTitle, this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eCu.threadData, null, n.ael(), 18003, true, false, false).addLocateParam(this.eCu.acB());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.eCu.threadData.getFid()));
            addLocateParam.setForumName(this.eCu.threadData.aeD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eCq) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bvn() {
        if (this.gdU == null) {
            this.gdU = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bvo() {
        if (this.gdV == null) {
            this.gdV = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gdV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZq() != null) {
                    b.this.aZq().a(view, b.this.eCu);
                }
                if (b.this.eCu != null && b.this.eCu.threadData != null) {
                    n.vx(b.this.eCu.threadData.getId());
                    b.this.bvm();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.eCu == null || this.eCu.threadData == null || this.eCu.threadData.aey() == null || this.eCu.threadData.aeP() == null) {
            this.dEG.setVisibility(8);
            return;
        }
        this.dEG.setVisibility(0);
        if (this.eCu.baf()) {
            bvo();
            this.gdW = this.gdV;
            this.gdV.setVisibility(0);
            if (this.gdU != null) {
                this.gdU.setVisibility(8);
            }
        } else {
            bvn();
            this.gdW = this.gdU;
            this.gdU.setVisibility(0);
            if (this.gdV != null) {
                this.gdV.setVisibility(8);
            }
        }
        aZE();
        if (!aZA() && n.vy(this.eCu.threadData.getId())) {
            n.a(this.mTextTitle, this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCq.getGodReplyContent(), this.eCu.acy().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eCu.acy().afo();
        SpannableStringBuilder afe = this.eCu.acy().afe();
        if (this.eCu.acy().afl() && !StringUtils.isNull(this.eCu.acy().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eCu.acy().getTid();
            afe.append((CharSequence) this.eCu.acy().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(afe));
        this.mTextTitle.setText(afe);
        if (this.gdW.getHeaderImg() != null) {
            this.gdW.getHeaderImg().setAfterClickListener(this.eCG);
            if (this.gdW.getIsSimpleThread()) {
                this.gdW.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (this.eCu.acy() == null || this.eCu.acy().aey() == null || this.eCu.acy().aey().getPendantData() == null || StringUtils.isNull(this.eCu.acy().aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.gdW.getHeaderImg().setVisibility(0);
                this.gdW.getHeaderImg().setData(this.eCu.acy(), !this.eCu.baf());
            } else {
                this.gdW.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(this.eCu.acy());
            }
        }
        this.gdW.setData(this.eCu.threadData);
        this.gdW.setUserAfterClickListener(this.eCF);
        this.cJP.setText(aq.is(this.eCu.threadData.aeP().video_duration.intValue() * 1000));
        this.cJW.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eCu.threadData.aeP().play_count.intValue())));
        this.eCq.setData(this.eCu.acy().afW());
        this.eCq.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vy(this.eCu.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        nF(mp(1));
        if (this.eCu == null || this.eCu.threadData == null || this.eCu.threadData.aeP() == null) {
            z = false;
        } else if (this.eCu.threadData.aeP().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.eCB.setVisibility(0);
        } else {
            this.eCB.setVisibility(8);
        }
    }

    private void aZE() {
        if (this.cJQ != null && this.cJO != null) {
            if (i.aca().ace() && this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null) {
                this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJQ.startLoad(this.eCu.threadData.aeP().thumbnail_url, 10, false);
                this.cJO.setVisibility(0);
                return;
            }
            this.cJO.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdW != null) {
            this.gdW.setPageUniqueId(bdUniqueId);
        }
        if (this.cJQ != null) {
            this.cJQ.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (this.eCu != null && this.eCu.threadData != null) {
            n.a(this.mTextTitle, this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCq.getGodReplyContent(), this.eCu.acy().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gdW != null) {
            return this.gdW.getHeaderImg();
        }
        return null;
    }

    public View aZv() {
        if (this.gdW != null) {
            return this.gdW.getUserName();
        }
        return null;
    }

    public void nF(int i) {
        if (this.eCu != null && this.eCu.threadData != null) {
            if (!this.eCu.baf() && i == 1) {
                this.dEI.setVisibility(8);
                this.dFv.setStType(n.ael());
                this.dFv.setData(this.eCu.threadData);
                this.gdW.en(false);
                return;
            }
            this.dEI.setData(this.eCu.threadData);
            this.dEI.setStType(n.ael());
            this.dFv.setVisibility(8);
            this.gdW.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJQ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJQ.setOnDrawListener(null);
        }
    }
}

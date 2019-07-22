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
    public FrameLayout cJH;
    private TextView cJI;
    private TbImageView cJJ;
    private ImageView cJK;
    private TextView cJP;
    private TbImageView.a cJR;
    private final View.OnClickListener caw;
    public ThreadCommentAndPraiseInfoLayout dEB;
    private RelativeLayout dEz;
    public ThreadSourceShareAndPraiseLayout dFo;
    private ThreadGodReplyLayout eCj;
    private HeadPendantClickableView eCk;
    private LinearLayout eCl;
    private l eCn;
    private TextView eCu;
    private final View.OnClickListener eCy;
    private final View.OnClickListener eCz;
    public ConcernThreadUserInfoLayout gde;
    public ConcernForumThreadUserInfoLayout gdf;
    public d gdg;
    private LinearLayout gdj;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && b.this.cJJ != null) {
                    b.this.cJJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eCy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZo() != null) {
                    b.this.aZo().a(view, b.this.eCn);
                }
            }
        };
        this.eCz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZo() != null) {
                    b.this.aZo().a(view, b.this.eCn);
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eCn != null) {
                    if (b.this.aZo() != null) {
                        b.this.aZo().a(view, b.this.eCn);
                    }
                    if (b.this.eCn.threadData != null && view != b.this.dFo.cbO) {
                        n.vw(b.this.eCn.threadData.getId());
                        b.this.buZ();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dEz = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eCk = (HeadPendantClickableView) this.dEz.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eCk.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gdj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dEB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEB.setLayoutParams(layoutParams);
        }
        this.dEB.setOnClickListener(this);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setIsBarViewVisible(false);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setShareVisible(true);
        this.dEB.setFrom(9);
        this.dEB.setDisPraiseFrom(4);
        this.dEB.setShareReportFrom(4);
        this.dEB.setForumAfterClickListener(this.caw);
        this.dEB.cbF = this.currentPageType;
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dFo.ccA.setOnClickListener(this);
        this.dFo.setShareReportFrom(4);
        this.dFo.setFrom(9);
        this.dFo.ccA.cbF = this.currentPageType;
        this.dFo.setForumAfterClickListener(this.caw);
        this.dEz.setOnClickListener(this);
        this.cJH = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cJH.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cJH.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cJH.setLayoutParams(layoutParams2);
        this.cJJ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJJ.setDefaultErrorResource(0);
        this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJJ.setGifIconSupport(false);
        this.cJJ.setEvent(this.cJR);
        this.cJJ.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJJ;
        TbImageView tbImageView2 = this.cJJ;
        tbImageView.setConrers(15);
        this.cJJ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJJ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJJ.setBorderSurroundContent(true);
        this.cJJ.setDrawBorder(true);
        this.cJK = (ImageView) view.findViewById(R.id.image_video_play);
        this.cJI = (TextView) view.findViewById(R.id.text_video_duration);
        this.eCl = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cJP = (TextView) view.findViewById(R.id.text_video_play_count);
        this.aNH = view.findViewById(R.id.divider_line);
        this.eCj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCj.setOnClickListener(this);
        this.eCu = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEz, R.drawable.addresslist_item_bg);
            am.c(this.cJK, (int) R.drawable.btn_icon_play_video_n);
            this.dEB.onChangeSkinType();
            this.dFo.onChangeSkinType();
            am.k(this.aNH, R.color.cp_bg_line_e);
            am.j(this.cJI, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.gde != null && this.gde.getVisibility() == 0) {
            this.gde.onChangeSkinType(i);
        }
        if (this.gdf != null && this.gdf.getVisibility() == 0) {
            this.gdf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.eCn = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dEz || view == this.eCj) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cJH) {
            if (this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null) {
                z = this.eCn.threadData.aeO().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bS(getView());
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZw();
        }
    }

    private void aZw() {
        if (this.eCn != null && this.eCn.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eCn.threadData);
            videoItemData.mRecomExtra = this.eCn.baa();
            videoItemData.mRecomAbTag = this.eCn.aZY();
            videoItemData.mRecomSource = this.eCn.getSource();
            videoItemData.mRecomWeight = this.eCn.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.eCn.acA(), "concern_tab")));
        }
    }

    private void bS(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZx();
        }
    }

    private void aZx() {
        if (this.eCn != null && this.eCn.threadData != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eCn.threadData);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cJJ.getX() + this.gdj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cJJ.getY() + this.gdj.getY());
            videoCardViewInfo.cardViewWidth = this.cJJ.getWidth();
            videoCardViewInfo.cardViewHeight = this.cJJ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.eCn.threadData.getTid(), n.aek(), this.eCn.acA(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aZy() {
        return this.eCn.eGg && !this.eCn.eGn;
    }

    private void bI(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (this.eCn != null && this.eCn.threadData != null) {
            if (!aZy()) {
                n.vw(this.eCn.threadData.getId());
                n.a(this.mTextTitle, this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eCn.threadData, null, n.aek(), 18003, true, false, false).addLocateParam(this.eCn.acA());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.eCn.threadData.getFid()));
            addLocateParam.setForumName(this.eCn.threadData.aeC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eCj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bva() {
        if (this.gde == null) {
            this.gde = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bvb() {
        if (this.gdf == null) {
            this.gdf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gdf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZo() != null) {
                    b.this.aZo().a(view, b.this.eCn);
                }
                if (b.this.eCn != null && b.this.eCn.threadData != null) {
                    n.vw(b.this.eCn.threadData.getId());
                    b.this.buZ();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.eCn == null || this.eCn.threadData == null || this.eCn.threadData.aex() == null || this.eCn.threadData.aeO() == null) {
            this.dEz.setVisibility(8);
            return;
        }
        this.dEz.setVisibility(0);
        if (this.eCn.bad()) {
            bvb();
            this.gdg = this.gdf;
            this.gdf.setVisibility(0);
            if (this.gde != null) {
                this.gde.setVisibility(8);
            }
        } else {
            bva();
            this.gdg = this.gde;
            this.gde.setVisibility(0);
            if (this.gdf != null) {
                this.gdf.setVisibility(8);
            }
        }
        aZC();
        if (!aZy() && n.vx(this.eCn.threadData.getId())) {
            n.a(this.mTextTitle, this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCj.getGodReplyContent(), this.eCn.acx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eCn.acx().afn();
        SpannableStringBuilder afd = this.eCn.acx().afd();
        if (this.eCn.acx().afk() && !StringUtils.isNull(this.eCn.acx().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eCn.acx().getTid();
            afd.append((CharSequence) this.eCn.acx().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new k(afd));
        this.mTextTitle.setText(afd);
        if (this.gdg.getHeaderImg() != null) {
            this.gdg.getHeaderImg().setAfterClickListener(this.eCz);
            if (this.gdg.getIsSimpleThread()) {
                this.gdg.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (this.eCn.acx() == null || this.eCn.acx().aex() == null || this.eCn.acx().aex().getPendantData() == null || StringUtils.isNull(this.eCn.acx().aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.gdg.getHeaderImg().setVisibility(0);
                this.gdg.getHeaderImg().setData(this.eCn.acx(), !this.eCn.bad());
            } else {
                this.gdg.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(this.eCn.acx());
            }
        }
        this.gdg.setData(this.eCn.threadData);
        this.gdg.setUserAfterClickListener(this.eCy);
        this.cJI.setText(aq.is(this.eCn.threadData.aeO().video_duration.intValue() * 1000));
        this.cJP.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eCn.threadData.aeO().play_count.intValue())));
        this.eCj.setData(this.eCn.acx().afV());
        this.eCj.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vx(this.eCn.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        nE(mo(1));
        if (this.eCn == null || this.eCn.threadData == null || this.eCn.threadData.aeO() == null) {
            z = false;
        } else if (this.eCn.threadData.aeO().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.eCu.setVisibility(0);
        } else {
            this.eCu.setVisibility(8);
        }
    }

    private void aZC() {
        if (this.cJJ != null && this.cJH != null) {
            if (i.aca().ace() && this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null) {
                this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJJ.startLoad(this.eCn.threadData.aeO().thumbnail_url, 10, false);
                this.cJH.setVisibility(0);
                return;
            }
            this.cJH.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdg != null) {
            this.gdg.setPageUniqueId(bdUniqueId);
        }
        if (this.cJJ != null) {
            this.cJJ.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (this.eCn != null && this.eCn.threadData != null) {
            n.a(this.mTextTitle, this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCj.getGodReplyContent(), this.eCn.acx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gdg != null) {
            return this.gdg.getHeaderImg();
        }
        return null;
    }

    public View aZt() {
        if (this.gdg != null) {
            return this.gdg.getUserName();
        }
        return null;
    }

    public void nE(int i) {
        if (this.eCn != null && this.eCn.threadData != null) {
            if (!this.eCn.bad() && i == 1) {
                this.dEB.setVisibility(8);
                this.dFo.setStType(n.aek());
                this.dFo.setData(this.eCn.threadData);
                this.gdg.en(false);
                return;
            }
            this.dEB.setData(this.eCn.threadData);
            this.dEB.setStType(n.aek());
            this.dFo.setVisibility(8);
            this.gdg.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJJ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJJ.setOnDrawListener(null);
        }
    }
}

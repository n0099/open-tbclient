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
    private String WM;
    private View aOf;
    public FrameLayout cKE;
    private TextView cKF;
    private TbImageView cKG;
    private ImageView cKH;
    private TextView cKM;
    private TbImageView.a cKO;
    private final View.OnClickListener cbv;
    private RelativeLayout dGr;
    public ThreadCommentAndPraiseInfoLayout dGt;
    public ThreadSourceShareAndPraiseLayout dHg;
    private ThreadGodReplyLayout eDZ;
    private HeadPendantClickableView eEa;
    private LinearLayout eEc;
    private l eEd;
    private TextView eEk;
    private final View.OnClickListener eEo;
    private final View.OnClickListener eEp;
    public ConcernThreadUserInfoLayout gfM;
    public ConcernForumThreadUserInfoLayout gfN;
    public d gfO;
    private LinearLayout gfR;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && b.this.cKG != null) {
                    b.this.cKG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eEo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZU() != null) {
                    b.this.aZU().a(view, b.this.eEd);
                }
            }
        };
        this.eEp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZU() != null) {
                    b.this.aZU().a(view, b.this.eEd);
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eEd != null) {
                    if (b.this.aZU() != null) {
                        b.this.aZU().a(view, b.this.eEd);
                    }
                    if (b.this.eEd.threadData != null && view != b.this.dHg.ccP) {
                        n.vW(b.this.eEd.threadData.getId());
                        b.this.bwa();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dGr = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eEa = (HeadPendantClickableView) this.dGr.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eEa.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gfR = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dGt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dGt.setLayoutParams(layoutParams);
        }
        this.dGt.setOnClickListener(this);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setIsBarViewVisible(false);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setShareVisible(true);
        this.dGt.setFrom(9);
        this.dGt.setDisPraiseFrom(4);
        this.dGt.setShareReportFrom(4);
        this.dGt.setForumAfterClickListener(this.cbv);
        this.dGt.ccG = this.currentPageType;
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dHg.cdA.setOnClickListener(this);
        this.dHg.setShareReportFrom(4);
        this.dHg.setFrom(9);
        this.dHg.cdA.ccG = this.currentPageType;
        this.dHg.setForumAfterClickListener(this.cbv);
        this.dGr.setOnClickListener(this);
        this.cKE = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cKE.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKE.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cKE.setLayoutParams(layoutParams2);
        this.cKG = (TbImageView) view.findViewById(R.id.image_video);
        this.cKG.setDefaultErrorResource(0);
        this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cKG.setGifIconSupport(false);
        this.cKG.setEvent(this.cKO);
        this.cKG.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cKG;
        TbImageView tbImageView2 = this.cKG;
        tbImageView.setConrers(15);
        this.cKG.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cKG.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cKG.setBorderSurroundContent(true);
        this.cKG.setDrawBorder(true);
        this.cKH = (ImageView) view.findViewById(R.id.image_video_play);
        this.cKF = (TextView) view.findViewById(R.id.text_video_duration);
        this.eEc = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cKM = (TextView) view.findViewById(R.id.text_video_play_count);
        this.aOf = view.findViewById(R.id.divider_line);
        this.eDZ = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eDZ.setOnClickListener(this);
        this.eEk = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dGr, R.drawable.addresslist_item_bg);
            am.c(this.cKH, (int) R.drawable.btn_icon_play_video_n);
            this.dGt.onChangeSkinType();
            this.dHg.onChangeSkinType();
            am.k(this.aOf, R.color.cp_bg_line_c);
            am.j(this.cKF, R.color.cp_cont_a);
            am.j(this.cKM, R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gfM != null && this.gfM.getVisibility() == 0) {
            this.gfM.onChangeSkinType(i);
        }
        if (this.gfN != null && this.gfN.getVisibility() == 0) {
            this.gfN.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.eEd = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dGr || view == this.eDZ) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cKE) {
            if (this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null) {
                z = this.eEd.threadData.aeT().is_vertical.intValue() == 1;
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
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bac();
        }
    }

    private void bac() {
        if (this.eEd != null && this.eEd.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eEd.threadData);
            videoItemData.mRecomExtra = this.eEd.baG();
            videoItemData.mRecomAbTag = this.eEd.baE();
            videoItemData.mRecomSource = this.eEd.getSource();
            videoItemData.mRecomWeight = this.eEd.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.eEd.acF(), "concern_tab")));
        }
    }

    private void bT(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (!j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bad() {
        if (this.eEd != null && this.eEd.threadData != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eEd.threadData);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cKG.getX() + this.gfR.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cKG.getY() + this.gfR.getY());
            videoCardViewInfo.cardViewWidth = this.cKG.getWidth();
            videoCardViewInfo.cardViewHeight = this.cKG.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.eEd.threadData.getTid(), n.aep(), this.eEd.acF(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean bae() {
        return this.eEd.eHW && !this.eEd.eId;
    }

    private void bI(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (this.eEd != null && this.eEd.threadData != null) {
            if (!bae()) {
                n.vW(this.eEd.threadData.getId());
                n.a(this.mTextTitle, this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eEd.threadData, null, n.aep(), 18003, true, false, false).addLocateParam(this.eEd.acF());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.eEd.threadData.getFid()));
            addLocateParam.setForumName(this.eEd.threadData.aeH());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eDZ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bwb() {
        if (this.gfM == null) {
            this.gfM = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bwc() {
        if (this.gfN == null) {
            this.gfN = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gfN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZU() != null) {
                    b.this.aZU().a(view, b.this.eEd);
                }
                if (b.this.eEd != null && b.this.eEd.threadData != null) {
                    n.vW(b.this.eEd.threadData.getId());
                    b.this.bwa();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.eEd == null || this.eEd.threadData == null || this.eEd.threadData.aeC() == null || this.eEd.threadData.aeT() == null) {
            this.dGr.setVisibility(8);
            return;
        }
        this.dGr.setVisibility(0);
        if (this.eEd.baJ()) {
            bwc();
            this.gfO = this.gfN;
            this.gfN.setVisibility(0);
            if (this.gfM != null) {
                this.gfM.setVisibility(8);
            }
        } else {
            bwb();
            this.gfO = this.gfM;
            this.gfM.setVisibility(0);
            if (this.gfN != null) {
                this.gfN.setVisibility(8);
            }
        }
        bai();
        if (!bae() && n.vX(this.eEd.threadData.getId())) {
            n.a(this.mTextTitle, this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eDZ.getGodReplyContent(), this.eEd.acC().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eEd.acC().afs();
        SpannableStringBuilder afi = this.eEd.acC().afi();
        if (this.eEd.acC().afp() && !StringUtils.isNull(this.eEd.acC().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eEd.acC().getTid();
            afi.append((CharSequence) this.eEd.acC().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new k(afi));
        this.mTextTitle.setText(afi);
        if (this.gfO.getHeaderImg() != null) {
            this.gfO.getHeaderImg().setAfterClickListener(this.eEp);
            if (this.gfO.getIsSimpleThread()) {
                this.gfO.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (this.eEd.acC() == null || this.eEd.acC().aeC() == null || this.eEd.acC().aeC().getPendantData() == null || StringUtils.isNull(this.eEd.acC().aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.gfO.getHeaderImg().setVisibility(0);
                this.gfO.getHeaderImg().setData(this.eEd.acC(), !this.eEd.baJ());
            } else {
                this.gfO.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(this.eEd.acC());
            }
        }
        this.gfO.setData(this.eEd.threadData);
        this.gfO.setUserAfterClickListener(this.eEo);
        this.cKF.setText(aq.it(this.eEd.threadData.aeT().video_duration.intValue() * 1000));
        this.cKM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eEd.threadData.aeT().play_count.intValue())));
        this.eDZ.setData(this.eEd.acC().aga());
        this.eDZ.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vX(this.eEd.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        nJ(mt(1));
        if (this.eEd == null || this.eEd.threadData == null || this.eEd.threadData.aeT() == null) {
            z = false;
        } else if (this.eEd.threadData.aeT().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.eEk.setVisibility(0);
        } else {
            this.eEk.setVisibility(8);
        }
    }

    private void bai() {
        if (this.cKG != null && this.cKE != null) {
            if (i.ace().aci() && this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null) {
                this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cKG.startLoad(this.eEd.threadData.aeT().thumbnail_url, 10, false);
                this.cKE.setVisibility(0);
                return;
            }
            this.cKE.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gfO != null) {
            this.gfO.setPageUniqueId(bdUniqueId);
        }
        if (this.cKG != null) {
            this.cKG.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (this.eEd != null && this.eEd.threadData != null) {
            n.a(this.mTextTitle, this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eDZ.getGodReplyContent(), this.eEd.acC().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gfO != null) {
            return this.gfO.getHeaderImg();
        }
        return null;
    }

    public View aZZ() {
        if (this.gfO != null) {
            return this.gfO.getUserName();
        }
        return null;
    }

    public void nJ(int i) {
        if (this.eEd != null && this.eEd.threadData != null) {
            if (!this.eEd.baJ() && i == 1) {
                this.dGt.setVisibility(8);
                this.dHg.setStType(n.aep());
                this.dHg.setData(this.eEd.threadData);
                this.gfO.eq(false);
                return;
            }
            this.dGt.setData(this.eEd.threadData);
            this.dGt.setStType(n.aep());
            this.dHg.setVisibility(8);
            this.gfO.eq(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cKG.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cKG.setOnDrawListener(null);
        }
    }
}

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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.i;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<l> implements e {
    private String aeB;
    private final View.OnClickListener dIj;
    private TbPageContext<?> duK;
    private TextView emC;
    private TbImageView.a emE;
    public FrameLayout emu;
    private TextView emv;
    private TbImageView emw;
    private ImageView emx;
    private RelativeLayout fsu;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public ThreadSourceShareAndPraiseLayout fti;
    private ThreadGodReplyLayout goV;
    private HeadPendantClickableView goW;
    private LinearLayout goY;
    private l goZ;
    private TextView gpg;
    private final View.OnClickListener gpk;
    private final View.OnClickListener gpl;
    public ConcernThreadUserInfoLayout hJH;
    public ConcernForumThreadUserInfoLayout hJI;
    public com.baidu.tbadk.core.view.c hJJ;
    private LinearLayout hJM;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.emw != null) {
                    b.this.emw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.gpk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEx() != null) {
                    b.this.bEx().a(view, b.this.goZ);
                }
            }
        };
        this.gpl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEx() != null) {
                    b.this.bEx().a(view, b.this.goZ);
                }
            }
        };
        this.dIj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.goZ != null) {
                    if (b.this.bEx() != null) {
                        b.this.bEx().a(view, b.this.goZ);
                    }
                    if (b.this.goZ.dqE != null && view != b.this.fti.dIt) {
                        com.baidu.tieba.card.l.BE(b.this.goZ.dqE.getId());
                        b.this.bYe();
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.fsu = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.goW = (HeadPendantClickableView) this.fsu.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setPlaceHolder(1);
            this.goW.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.ds70));
        }
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hJM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setFrom(9);
        this.fsw.setShareReportFrom(4);
        this.fsw.setForumAfterClickListener(this.dIj);
        this.fsw.dIg = this.currentPageType;
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.fti.dJe.setOnClickListener(this);
        this.fti.setShareReportFrom(4);
        this.fti.setFrom(9);
        this.fti.dJe.dIg = this.currentPageType;
        this.fti.setForumAfterClickListener(this.dIj);
        this.fsu.setOnClickListener(this);
        this.emu = (FrameLayout) view.findViewById(R.id.frame_video);
        this.emu.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.emu.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duK.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.emu.setLayoutParams(layoutParams2);
        this.emw = (TbImageView) view.findViewById(R.id.image_video);
        this.emw.setDefaultErrorResource(0);
        this.emw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.emw.setGifIconSupport(false);
        this.emw.setEvent(this.emE);
        this.emw.setRadius(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.emw;
        TbImageView tbImageView2 = this.emw;
        tbImageView.setConrers(15);
        this.emw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emw.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emw.setBorderSurroundContent(true);
        this.emw.setDrawBorder(true);
        this.emx = (ImageView) view.findViewById(R.id.image_video_play);
        this.emv = (TextView) view.findViewById(R.id.text_video_duration);
        this.goY = (LinearLayout) view.findViewById(R.id.duration_container);
        this.emC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.goV = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goV.setOnClickListener(this);
        this.gpg = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsu, R.drawable.addresslist_item_bg);
            am.setImageResource(this.emx, R.drawable.btn_icon_play_video_n);
            this.fsw.onChangeSkinType();
            this.fti.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.emv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.hJH != null && this.hJH.getVisibility() == 0) {
            this.hJH.onChangeSkinType(i);
        }
        if (this.hJI != null && this.hJI.getVisibility() == 0) {
            this.hJI.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.goZ = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fsu || view == this.goV) {
            bM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.emu) {
            if (this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null) {
                z = this.goZ.dqE.aKT().is_vertical.intValue() == 1;
            }
            if (z) {
                bK(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bY(getView());
                } else {
                    bM(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bY(getView());
            } else {
                bM(getView());
            }
        }
    }

    private void bK(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEG();
        }
    }

    private void bEG() {
        if (this.goZ != null && this.goZ.dqE != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.goZ.dqE);
            videoItemData.mRecomExtra = this.goZ.getExtra();
            videoItemData.mRecomAbTag = this.goZ.bFh();
            videoItemData.mRecomSource = this.goZ.getSource();
            videoItemData.mRecomWeight = this.goZ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.goZ.aIx(), "concern_tab");
            if (this.goZ.dqE.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.goZ.dqE.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bY(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEH();
        }
    }

    private void bEH() {
        if (this.goZ != null && this.goZ.dqE != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.goZ.dqE);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.emw.getX() + this.hJM.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.emw.getY() + this.hJM.getY());
            videoCardViewInfo.cardViewWidth = this.emw.getWidth();
            videoCardViewInfo.cardViewHeight = this.emw.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duK.getPageActivity(), "concern_tab", this.goZ.dqE.getTid(), com.baidu.tieba.card.l.aKo(), this.goZ.aIx(), videoSerializeVideoThreadInfo);
            if (this.goZ.aIu() != null && this.goZ.aIu().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.goZ.aIu().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean bEI() {
        return this.goZ.gsV && !this.goZ.gtc;
    }

    private void bM(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (this.goZ != null && this.goZ.dqE != null) {
            if (!bEI()) {
                com.baidu.tieba.card.l.BE(this.goZ.dqE.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duK.getPageActivity()).createFromThreadCfg(this.goZ.dqE, null, com.baidu.tieba.card.l.aKo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.goZ.aIx());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.goZ.dqE.getFid()));
            addLocateParam.setForumName(this.goZ.dqE.aKH());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.goV) {
                addLocateParam.setJumpGodReply(true);
            }
            this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bYf() {
        if (this.hJH == null) {
            this.hJH = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bYg() {
        if (this.hJI == null) {
            this.hJI = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.hJI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEx() != null) {
                    b.this.bEx().a(view, b.this.goZ);
                }
                if (b.this.goZ != null && b.this.goZ.dqE != null) {
                    com.baidu.tieba.card.l.BE(b.this.goZ.dqE.getId());
                    b.this.bYe();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.goZ == null || this.goZ.dqE == null || this.goZ.dqE.aKC() == null || this.goZ.dqE.aKT() == null) {
            this.fsu.setVisibility(8);
            return;
        }
        this.fsu.setVisibility(0);
        if (this.goZ.bFl()) {
            bYg();
            this.hJJ = this.hJI;
            this.hJI.setVisibility(0);
            if (this.hJH != null) {
                this.hJH.setVisibility(8);
            }
        } else {
            bYf();
            this.hJJ = this.hJH;
            this.hJH.setVisibility(0);
            if (this.hJI != null) {
                this.hJI.setVisibility(8);
            }
        }
        bEM();
        if (!bEI() && com.baidu.tieba.card.l.BF(this.goZ.dqE.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goV.getGodReplyContent(), this.goZ.aIu().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.goZ.aIu().aLx();
        SpannableStringBuilder aLj = this.goZ.aIu().aLj();
        if (this.goZ.aIu().aLp() && !StringUtils.isNull(this.goZ.aIu().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.goZ.aIu().getTid();
            aLj.append((CharSequence) this.goZ.aIu().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cI("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new i(aLj));
        this.mTextTitle.setText(aLj);
        if (this.hJJ.getHeaderImg() != null) {
            this.hJJ.getHeaderImg().setAfterClickListener(this.gpl);
            if (this.hJJ.getIsSimpleThread()) {
                this.hJJ.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (this.goZ.aIu() == null || this.goZ.aIu().aKC() == null || this.goZ.aIu().aKC().getPendantData() == null || StringUtils.isNull(this.goZ.aIu().aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.hJJ.getHeaderImg().setVisibility(0);
                this.hJJ.getHeaderImg().setData(this.goZ.aIu(), !this.goZ.bFl());
            } else {
                this.hJJ.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(this.goZ.aIu());
            }
        }
        this.hJJ.setData(this.goZ.dqE);
        this.hJJ.setUserAfterClickListener(this.gpk);
        this.emv.setText(aq.stringForVideoTime(this.goZ.dqE.aKT().video_duration.intValue() * 1000));
        this.emC.setText(String.format(this.duK.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.goZ.dqE.aKT().play_count.intValue())));
        this.goV.setData(this.goZ.aIu().aMc());
        this.goV.onChangeSkinType();
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.BF(this.goZ.dqE.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pX(or(1));
        if (this.goZ == null || this.goZ.dqE == null || this.goZ.dqE.aKT() == null) {
            z = false;
        } else if (this.goZ.dqE.aKT().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.gpg.setVisibility(0);
        } else {
            this.gpg.setVisibility(8);
        }
    }

    private void bEM() {
        if (this.emw != null && this.emu != null) {
            if (com.baidu.tbadk.core.i.aIc().isShowImages() && this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null) {
                this.emw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.emw.startLoad(this.goZ.dqE.aKT().thumbnail_url, 10, false);
                this.emu.setVisibility(0);
                return;
            }
            this.emu.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hJJ != null) {
            this.hJJ.setPageUniqueId(bdUniqueId);
        }
        if (this.emw != null) {
            this.emw.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYe() {
        if (this.goZ != null && this.goZ.dqE != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goV.getGodReplyContent(), this.goZ.aIu().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pX(int i) {
        if (this.goZ != null && this.goZ.dqE != null) {
            if (!this.goZ.bFl() && i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setStType(com.baidu.tieba.card.l.aKo());
                this.fti.setData(this.goZ.dqE);
                this.hJJ.gQ(false);
                return;
            }
            this.fsw.setData(this.goZ.dqE);
            this.fsw.setStType(com.baidu.tieba.card.l.aKo());
            this.fti.setVisibility(8);
            this.hJJ.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emw.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emw.setOnDrawListener(null);
        }
    }
}

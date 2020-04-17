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
    private String aey;
    private final View.OnClickListener dIf;
    private TbPageContext<?> duG;
    public FrameLayout emp;
    private TextView emq;
    private TbImageView emr;
    private ImageView ems;
    private TextView emx;
    private TbImageView.a emz;
    private RelativeLayout fsp;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public ThreadSourceShareAndPraiseLayout ftd;
    private ThreadGodReplyLayout goP;
    private HeadPendantClickableView goQ;
    private LinearLayout goS;
    private l goT;
    private TextView gpa;
    private final View.OnClickListener gpe;
    private final View.OnClickListener gpf;
    public ConcernThreadUserInfoLayout hJB;
    public ConcernForumThreadUserInfoLayout hJC;
    public com.baidu.tbadk.core.view.c hJD;
    private LinearLayout hJG;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.emr != null) {
                    b.this.emr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.gpe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEy() != null) {
                    b.this.bEy().a(view, b.this.goT);
                }
            }
        };
        this.gpf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEy() != null) {
                    b.this.bEy().a(view, b.this.goT);
                }
            }
        };
        this.dIf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.goT != null) {
                    if (b.this.bEy() != null) {
                        b.this.bEy().a(view, b.this.goT);
                    }
                    if (b.this.goT.dqA != null && view != b.this.ftd.dIp) {
                        com.baidu.tieba.card.l.BB(b.this.goT.dqA.getId());
                        b.this.bYf();
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.fsp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.goQ = (HeadPendantClickableView) this.fsp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setPlaceHolder(1);
            this.goQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.ds70));
        }
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hJG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setFrom(9);
        this.fsr.setShareReportFrom(4);
        this.fsr.setForumAfterClickListener(this.dIf);
        this.fsr.dIc = this.currentPageType;
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.setShareReportFrom(4);
        this.ftd.setFrom(9);
        this.ftd.dJa.dIc = this.currentPageType;
        this.ftd.setForumAfterClickListener(this.dIf);
        this.fsp.setOnClickListener(this);
        this.emp = (FrameLayout) view.findViewById(R.id.frame_video);
        this.emp.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.emp.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duG.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.emp.setLayoutParams(layoutParams2);
        this.emr = (TbImageView) view.findViewById(R.id.image_video);
        this.emr.setDefaultErrorResource(0);
        this.emr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.emr.setGifIconSupport(false);
        this.emr.setEvent(this.emz);
        this.emr.setRadius(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.emr;
        TbImageView tbImageView2 = this.emr;
        tbImageView.setConrers(15);
        this.emr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emr.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emr.setBorderSurroundContent(true);
        this.emr.setDrawBorder(true);
        this.ems = (ImageView) view.findViewById(R.id.image_video_play);
        this.emq = (TextView) view.findViewById(R.id.text_video_duration);
        this.goS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.emx = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.goP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goP.setOnClickListener(this);
        this.gpa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.ems, R.drawable.btn_icon_play_video_n);
            this.fsr.onChangeSkinType();
            this.ftd.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.hJB != null && this.hJB.getVisibility() == 0) {
            this.hJB.onChangeSkinType(i);
        }
        if (this.hJC != null && this.hJC.getVisibility() == 0) {
            this.hJC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.goT = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fsp || view == this.goP) {
            bM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.emp) {
            if (this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null) {
                z = this.goT.dqA.aKV().is_vertical.intValue() == 1;
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
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEH();
        }
    }

    private void bEH() {
        if (this.goT != null && this.goT.dqA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.goT.dqA);
            videoItemData.mRecomExtra = this.goT.getExtra();
            videoItemData.mRecomAbTag = this.goT.bFi();
            videoItemData.mRecomSource = this.goT.getSource();
            videoItemData.mRecomWeight = this.goT.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.goT.aIz(), "concern_tab");
            if (this.goT.dqA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.goT.dqA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bY(View view) {
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEI();
        }
    }

    private void bEI() {
        if (this.goT != null && this.goT.dqA != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.goT.dqA);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.emr.getX() + this.hJG.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.emr.getY() + this.hJG.getY());
            videoCardViewInfo.cardViewWidth = this.emr.getWidth();
            videoCardViewInfo.cardViewHeight = this.emr.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duG.getPageActivity(), "concern_tab", this.goT.dqA.getTid(), com.baidu.tieba.card.l.aKq(), this.goT.aIz(), videoSerializeVideoThreadInfo);
            if (this.goT.aIw() != null && this.goT.aIw().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.goT.aIw().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean bEJ() {
        return this.goT.gsP && !this.goT.gsW;
    }

    private void bM(View view) {
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (this.goT != null && this.goT.dqA != null) {
            if (!bEJ()) {
                com.baidu.tieba.card.l.BB(this.goT.dqA.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duG.getPageActivity()).createFromThreadCfg(this.goT.dqA, null, com.baidu.tieba.card.l.aKq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.goT.aIz());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.goT.dqA.getFid()));
            addLocateParam.setForumName(this.goT.dqA.aKJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.goP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bYg() {
        if (this.hJB == null) {
            this.hJB = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bYh() {
        if (this.hJC == null) {
            this.hJC = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.hJC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bEy() != null) {
                    b.this.bEy().a(view, b.this.goT);
                }
                if (b.this.goT != null && b.this.goT.dqA != null) {
                    com.baidu.tieba.card.l.BB(b.this.goT.dqA.getId());
                    b.this.bYf();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.goT == null || this.goT.dqA == null || this.goT.dqA.aKE() == null || this.goT.dqA.aKV() == null) {
            this.fsp.setVisibility(8);
            return;
        }
        this.fsp.setVisibility(0);
        if (this.goT.bFm()) {
            bYh();
            this.hJD = this.hJC;
            this.hJC.setVisibility(0);
            if (this.hJB != null) {
                this.hJB.setVisibility(8);
            }
        } else {
            bYg();
            this.hJD = this.hJB;
            this.hJB.setVisibility(0);
            if (this.hJC != null) {
                this.hJC.setVisibility(8);
            }
        }
        bEN();
        if (!bEJ() && com.baidu.tieba.card.l.BC(this.goT.dqA.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goP.getGodReplyContent(), this.goT.aIw().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.goT.aIw().aLz();
        SpannableStringBuilder aLl = this.goT.aIw().aLl();
        if (this.goT.aIw().aLr() && !StringUtils.isNull(this.goT.aIw().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.goT.aIw().getTid();
            aLl.append((CharSequence) this.goT.aIw().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new i(aLl));
        this.mTextTitle.setText(aLl);
        if (this.hJD.getHeaderImg() != null) {
            this.hJD.getHeaderImg().setAfterClickListener(this.gpf);
            if (this.hJD.getIsSimpleThread()) {
                this.hJD.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (this.goT.aIw() == null || this.goT.aIw().aKE() == null || this.goT.aIw().aKE().getPendantData() == null || StringUtils.isNull(this.goT.aIw().aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.hJD.getHeaderImg().setVisibility(0);
                this.hJD.getHeaderImg().setData(this.goT.aIw(), !this.goT.bFm());
            } else {
                this.hJD.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(this.goT.aIw());
            }
        }
        this.hJD.setData(this.goT.dqA);
        this.hJD.setUserAfterClickListener(this.gpe);
        this.emq.setText(aq.stringForVideoTime(this.goT.dqA.aKV().video_duration.intValue() * 1000));
        this.emx.setText(String.format(this.duG.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.goT.dqA.aKV().play_count.intValue())));
        this.goP.setData(this.goT.aIw().aMe());
        this.goP.onChangeSkinType();
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.BC(this.goT.dqA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pX(or(1));
        if (this.goT == null || this.goT.dqA == null || this.goT.dqA.aKV() == null) {
            z = false;
        } else if (this.goT.dqA.aKV().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.gpa.setVisibility(0);
        } else {
            this.gpa.setVisibility(8);
        }
    }

    private void bEN() {
        if (this.emr != null && this.emp != null) {
            if (com.baidu.tbadk.core.i.aIe().isShowImages() && this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null) {
                this.emr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.emr.startLoad(this.goT.dqA.aKV().thumbnail_url, 10, false);
                this.emp.setVisibility(0);
                return;
            }
            this.emp.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hJD != null) {
            this.hJD.setPageUniqueId(bdUniqueId);
        }
        if (this.emr != null) {
            this.emr.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYf() {
        if (this.goT != null && this.goT.dqA != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goP.getGodReplyContent(), this.goT.aIw().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pX(int i) {
        if (this.goT != null && this.goT.dqA != null) {
            if (!this.goT.bFm() && i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setStType(com.baidu.tieba.card.l.aKq());
                this.ftd.setData(this.goT.dqA);
                this.hJD.gQ(false);
                return;
            }
            this.fsr.setData(this.goT.dqA);
            this.fsr.setStType(com.baidu.tieba.card.l.aKq());
            this.ftd.setVisibility(8);
            this.hJD.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emr.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emr.setOnDrawListener(null);
        }
    }
}

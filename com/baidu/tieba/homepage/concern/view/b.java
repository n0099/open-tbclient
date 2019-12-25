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
import com.baidu.tbadk.core.i;
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
import com.baidu.tieba.view.h;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<l> implements e {
    private String La;
    private TbPageContext<?> cQU;
    public FrameLayout dHG;
    private TextView dHH;
    private TbImageView dHI;
    private ImageView dHJ;
    private TextView dHO;
    private TbImageView.a dHQ;
    private final View.OnClickListener ddt;
    public ThreadSourceShareAndPraiseLayout eIU;
    private RelativeLayout eIf;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private ThreadGodReplyLayout fDF;
    private HeadPendantClickableView fDG;
    private LinearLayout fDI;
    private l fDJ;
    private TextView fDQ;
    private final View.OnClickListener fDU;
    private final View.OnClickListener fDV;
    public ConcernThreadUserInfoLayout gSV;
    public ConcernForumThreadUserInfoLayout gSW;
    public com.baidu.tbadk.core.view.c gSX;
    private LinearLayout gTa;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dHI != null) {
                    b.this.dHI.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fDU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.brY() != null) {
                    b.this.brY().a(view, b.this.fDJ);
                }
            }
        };
        this.fDV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.brY() != null) {
                    b.this.brY().a(view, b.this.fDJ);
                }
            }
        };
        this.ddt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fDJ != null) {
                    if (b.this.brY() != null) {
                        b.this.brY().a(view, b.this.fDJ);
                    }
                    if (b.this.fDJ.cMR != null && view != b.this.eIU.ddE) {
                        com.baidu.tieba.card.l.zs(b.this.fDJ.cMR.getId());
                        b.this.bKF();
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eIf = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fDG = (HeadPendantClickableView) this.eIf.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setPlaceHolder(1);
            this.fDG.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.ds70));
        }
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTa = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setFrom(9);
        this.eIh.setShareReportFrom(4);
        this.eIh.setForumAfterClickListener(this.ddt);
        this.eIh.ddq = this.currentPageType;
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.setShareReportFrom(4);
        this.eIU.setFrom(9);
        this.eIU.dep.ddq = this.currentPageType;
        this.eIU.setForumAfterClickListener(this.ddt);
        this.eIf.setOnClickListener(this);
        this.dHG = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dHG.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHG.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cQU.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dHG.setLayoutParams(layoutParams2);
        this.dHI = (TbImageView) view.findViewById(R.id.image_video);
        this.dHI.setDefaultErrorResource(0);
        this.dHI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dHI.setGifIconSupport(false);
        this.dHI.setEvent(this.dHQ);
        this.dHI.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHI;
        TbImageView tbImageView2 = this.dHI;
        tbImageView.setConrers(15);
        this.dHI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHI.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHI.setBorderSurroundContent(true);
        this.dHI.setDrawBorder(true);
        this.dHJ = (ImageView) view.findViewById(R.id.image_video_play);
        this.dHH = (TextView) view.findViewById(R.id.text_video_duration);
        this.fDI = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dHO = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fDF = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fDF.setOnClickListener(this);
        this.fDQ = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIf, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHJ, R.drawable.btn_icon_play_video_n);
            this.eIh.onChangeSkinType();
            this.eIU.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dHH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gSV != null && this.gSV.getVisibility() == 0) {
            this.gSV.onChangeSkinType(i);
        }
        if (this.gSW != null && this.gSW.getVisibility() == 0) {
            this.gSW.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fDJ = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eIf || view == this.fDF) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dHG) {
            if (this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null) {
                z = this.fDJ.cMR.azV().is_vertical.intValue() == 1;
            }
            if (z) {
                bA(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bL(getView());
                } else {
                    bC(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bL(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bA(View view) {
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bsh();
        }
    }

    private void bsh() {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fDJ.cMR);
            videoItemData.mRecomExtra = this.fDJ.getExtra();
            videoItemData.mRecomAbTag = this.fDJ.bsJ();
            videoItemData.mRecomSource = this.fDJ.getSource();
            videoItemData.mRecomWeight = this.fDJ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fDJ.axA(), "concern_tab");
            if (this.fDJ.cMR.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fDJ.cMR.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bL(View view) {
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bsi();
        }
    }

    private void bsi() {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fDJ.cMR);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dHI.getX() + this.gTa.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dHI.getY() + this.gTa.getY());
            videoCardViewInfo.cardViewWidth = this.dHI.getWidth();
            videoCardViewInfo.cardViewHeight = this.dHI.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cQU.getPageActivity(), "concern_tab", this.fDJ.cMR.getTid(), com.baidu.tieba.card.l.azq(), this.fDJ.axA(), videoSerializeVideoThreadInfo);
            if (this.fDJ.axx() != null && this.fDJ.axx().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fDJ.axx().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean bsj() {
        return this.fDJ.fHF && !this.fDJ.fHM;
    }

    private void bC(View view) {
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (this.fDJ != null && this.fDJ.cMR != null) {
            if (!bsj()) {
                com.baidu.tieba.card.l.zs(this.fDJ.cMR.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cQU.getPageActivity()).createFromThreadCfg(this.fDJ.cMR, null, com.baidu.tieba.card.l.azq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fDJ.axA());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fDJ.cMR.getFid()));
            addLocateParam.setForumName(this.fDJ.cMR.azJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fDF) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bKG() {
        if (this.gSV == null) {
            this.gSV = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bKH() {
        if (this.gSW == null) {
            this.gSW = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gSW.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.brY() != null) {
                    b.this.brY().a(view, b.this.fDJ);
                }
                if (b.this.fDJ != null && b.this.fDJ.cMR != null) {
                    com.baidu.tieba.card.l.zs(b.this.fDJ.cMR.getId());
                    b.this.bKF();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fDJ == null || this.fDJ.cMR == null || this.fDJ.cMR.azE() == null || this.fDJ.cMR.azV() == null) {
            this.eIf.setVisibility(8);
            return;
        }
        this.eIf.setVisibility(0);
        if (this.fDJ.bsN()) {
            bKH();
            this.gSX = this.gSW;
            this.gSW.setVisibility(0);
            if (this.gSV != null) {
                this.gSV.setVisibility(8);
            }
        } else {
            bKG();
            this.gSX = this.gSV;
            this.gSV.setVisibility(0);
            if (this.gSW != null) {
                this.gSW.setVisibility(8);
            }
        }
        bsn();
        if (!bsj() && com.baidu.tieba.card.l.zt(this.fDJ.cMR.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fDF.getGodReplyContent(), this.fDJ.axx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fDJ.axx().aAA();
        SpannableStringBuilder aAl = this.fDJ.axx().aAl();
        if (this.fDJ.axx().aAr() && !StringUtils.isNull(this.fDJ.axx().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fDJ.axx().getTid();
            aAl.append((CharSequence) this.fDJ.axx().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cp("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aAl));
        this.mTextTitle.setText(aAl);
        if (this.gSX.getHeaderImg() != null) {
            this.gSX.getHeaderImg().setAfterClickListener(this.fDV);
            if (this.gSX.getIsSimpleThread()) {
                this.gSX.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (this.fDJ.axx() == null || this.fDJ.axx().azE() == null || this.fDJ.axx().azE().getPendantData() == null || StringUtils.isNull(this.fDJ.axx().azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.gSX.getHeaderImg().setVisibility(0);
                this.gSX.getHeaderImg().setData(this.fDJ.axx(), !this.fDJ.bsN());
            } else {
                this.gSX.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(this.fDJ.axx());
            }
        }
        this.gSX.setData(this.fDJ.cMR);
        this.gSX.setUserAfterClickListener(this.fDU);
        this.dHH.setText(aq.stringForVideoTime(this.fDJ.cMR.azV().video_duration.intValue() * 1000));
        this.dHO.setText(String.format(this.cQU.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fDJ.cMR.azV().play_count.intValue())));
        this.fDF.setData(this.fDJ.axx().aBe());
        this.fDF.onChangeSkinType();
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zt(this.fDJ.cMR.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pp(nL(1));
        if (this.fDJ == null || this.fDJ.cMR == null || this.fDJ.cMR.azV() == null) {
            z = false;
        } else if (this.fDJ.cMR.azV().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fDQ.setVisibility(0);
        } else {
            this.fDQ.setVisibility(8);
        }
    }

    private void bsn() {
        if (this.dHI != null && this.dHG != null) {
            if (i.axf().isShowImages() && this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null) {
                this.dHI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dHI.startLoad(this.fDJ.cMR.azV().thumbnail_url, 10, false);
                this.dHG.setVisibility(0);
                return;
            }
            this.dHG.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gSX != null) {
            this.gSX.setPageUniqueId(bdUniqueId);
        }
        if (this.dHI != null) {
            this.dHI.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKF() {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fDF.getGodReplyContent(), this.fDJ.axx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pp(int i) {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            if (!this.fDJ.bsN() && i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setStType(com.baidu.tieba.card.l.azq());
                this.eIU.setData(this.fDJ.cMR);
                this.gSX.fF(false);
                return;
            }
            this.eIh.setData(this.fDJ.cMR);
            this.eIh.setStType(com.baidu.tieba.card.l.azq());
            this.eIU.setVisibility(8);
            this.gSX.fF(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHI.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHI.setOnDrawListener(null);
        }
    }
}

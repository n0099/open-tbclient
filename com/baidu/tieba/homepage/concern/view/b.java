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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.a<l> implements e {
    private String Lg;
    private TbPageContext<?> cRe;
    public FrameLayout dHP;
    private TextView dHQ;
    private TbImageView dHR;
    private ImageView dHS;
    private TextView dHX;
    private TbImageView.a dHZ;
    private final View.OnClickListener ddE;
    private RelativeLayout eJp;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public ThreadSourceShareAndPraiseLayout eKe;
    private ThreadGodReplyLayout fGP;
    private HeadPendantClickableView fGQ;
    private LinearLayout fGS;
    private l fGT;
    private TextView fHa;
    private final View.OnClickListener fHe;
    private final View.OnClickListener fHf;
    public ConcernThreadUserInfoLayout gWp;
    public ConcernForumThreadUserInfoLayout gWq;
    public com.baidu.tbadk.core.view.c gWr;
    private LinearLayout gWu;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dHR != null) {
                    b.this.dHR.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fHe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bta() != null) {
                    b.this.bta().a(view, b.this.fGT);
                }
            }
        };
        this.fHf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bta() != null) {
                    b.this.bta().a(view, b.this.fGT);
                }
            }
        };
        this.ddE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fGT != null) {
                    if (b.this.bta() != null) {
                        b.this.bta().a(view, b.this.fGT);
                    }
                    if (b.this.fGT.cNb != null && view != b.this.eKe.ddO) {
                        com.baidu.tieba.card.l.zC(b.this.fGT.cNb.getId());
                        b.this.bLK();
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eJp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fGQ = (HeadPendantClickableView) this.eJp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setPlaceHolder(1);
            this.fGQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.ds70));
        }
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gWu = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setFrom(9);
        this.eJr.setShareReportFrom(4);
        this.eJr.setForumAfterClickListener(this.ddE);
        this.eJr.ddB = this.currentPageType;
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.setShareReportFrom(4);
        this.eKe.setFrom(9);
        this.eKe.deA.ddB = this.currentPageType;
        this.eKe.setForumAfterClickListener(this.ddE);
        this.eJp.setOnClickListener(this);
        this.dHP = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dHP.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHP.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cRe.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dHP.setLayoutParams(layoutParams2);
        this.dHR = (TbImageView) view.findViewById(R.id.image_video);
        this.dHR.setDefaultErrorResource(0);
        this.dHR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dHR.setGifIconSupport(false);
        this.dHR.setEvent(this.dHZ);
        this.dHR.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHR;
        TbImageView tbImageView2 = this.dHR;
        tbImageView.setConrers(15);
        this.dHR.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHR.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHR.setBorderSurroundContent(true);
        this.dHR.setDrawBorder(true);
        this.dHS = (ImageView) view.findViewById(R.id.image_video_play);
        this.dHQ = (TextView) view.findViewById(R.id.text_video_duration);
        this.fGS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dHX = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fGP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fGP.setOnClickListener(this);
        this.fHa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHS, R.drawable.btn_icon_play_video_n);
            this.eJr.onChangeSkinType();
            this.eKe.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dHQ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gWp != null && this.gWp.getVisibility() == 0) {
            this.gWp.onChangeSkinType(i);
        }
        if (this.gWq != null && this.gWq.getVisibility() == 0) {
            this.gWq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fGT = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eJp || view == this.fGP) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dHP) {
            if (this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null) {
                z = this.fGT.cNb.aAo().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            btj();
        }
    }

    private void btj() {
        if (this.fGT != null && this.fGT.cNb != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fGT.cNb);
            videoItemData.mRecomExtra = this.fGT.getExtra();
            videoItemData.mRecomAbTag = this.fGT.btL();
            videoItemData.mRecomSource = this.fGT.getSource();
            videoItemData.mRecomWeight = this.fGT.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fGT.axT(), "concern_tab");
            if (this.fGT.cNb.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fGT.cNb.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            btk();
        }
    }

    private void btk() {
        if (this.fGT != null && this.fGT.cNb != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fGT.cNb);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dHR.getX() + this.gWu.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dHR.getY() + this.gWu.getY());
            videoCardViewInfo.cardViewWidth = this.dHR.getWidth();
            videoCardViewInfo.cardViewHeight = this.dHR.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cRe.getPageActivity(), "concern_tab", this.fGT.cNb.getTid(), com.baidu.tieba.card.l.azJ(), this.fGT.axT(), videoSerializeVideoThreadInfo);
            if (this.fGT.axQ() != null && this.fGT.axQ().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fGT.axQ().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean btl() {
        return this.fGT.fKP && !this.fGT.fKW;
    }

    private void bH(View view) {
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (this.fGT != null && this.fGT.cNb != null) {
            if (!btl()) {
                com.baidu.tieba.card.l.zC(this.fGT.cNb.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cRe.getPageActivity()).createFromThreadCfg(this.fGT.cNb, null, com.baidu.tieba.card.l.azJ(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fGT.axT());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fGT.cNb.getFid()));
            addLocateParam.setForumName(this.fGT.cNb.aAc());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fGP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bLL() {
        if (this.gWp == null) {
            this.gWp = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bLM() {
        if (this.gWq == null) {
            this.gWq = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gWq.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bta() != null) {
                    b.this.bta().a(view, b.this.fGT);
                }
                if (b.this.fGT != null && b.this.fGT.cNb != null) {
                    com.baidu.tieba.card.l.zC(b.this.fGT.cNb.getId());
                    b.this.bLK();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fGT == null || this.fGT.cNb == null || this.fGT.cNb.azX() == null || this.fGT.cNb.aAo() == null) {
            this.eJp.setVisibility(8);
            return;
        }
        this.eJp.setVisibility(0);
        if (this.fGT.btP()) {
            bLM();
            this.gWr = this.gWq;
            this.gWq.setVisibility(0);
            if (this.gWp != null) {
                this.gWp.setVisibility(8);
            }
        } else {
            bLL();
            this.gWr = this.gWp;
            this.gWp.setVisibility(0);
            if (this.gWq != null) {
                this.gWq.setVisibility(8);
            }
        }
        btp();
        if (!btl() && com.baidu.tieba.card.l.zD(this.fGT.cNb.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fGP.getGodReplyContent(), this.fGT.axQ().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fGT.axQ().aAT();
        SpannableStringBuilder aAE = this.fGT.axQ().aAE();
        if (this.fGT.axQ().aAK() && !StringUtils.isNull(this.fGT.axQ().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fGT.axQ().getTid();
            aAE.append((CharSequence) this.fGT.axQ().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new h(aAE));
        this.mTextTitle.setText(aAE);
        if (this.gWr.getHeaderImg() != null) {
            this.gWr.getHeaderImg().setAfterClickListener(this.fHf);
            if (this.gWr.getIsSimpleThread()) {
                this.gWr.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (this.fGT.axQ() == null || this.fGT.axQ().azX() == null || this.fGT.axQ().azX().getPendantData() == null || StringUtils.isNull(this.fGT.axQ().azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.gWr.getHeaderImg().setVisibility(0);
                this.gWr.getHeaderImg().setData(this.fGT.axQ(), !this.fGT.btP());
            } else {
                this.gWr.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(this.fGT.axQ());
            }
        }
        this.gWr.setData(this.fGT.cNb);
        this.gWr.setUserAfterClickListener(this.fHe);
        this.dHQ.setText(aq.stringForVideoTime(this.fGT.cNb.aAo().video_duration.intValue() * 1000));
        this.dHX.setText(String.format(this.cRe.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fGT.cNb.aAo().play_count.intValue())));
        this.fGP.setData(this.fGT.axQ().aBx());
        this.fGP.onChangeSkinType();
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zD(this.fGT.cNb.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pq(nL(1));
        if (this.fGT == null || this.fGT.cNb == null || this.fGT.cNb.aAo() == null) {
            z = false;
        } else if (this.fGT.cNb.aAo().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fHa.setVisibility(0);
        } else {
            this.fHa.setVisibility(8);
        }
    }

    private void btp() {
        if (this.dHR != null && this.dHP != null) {
            if (i.axy().isShowImages() && this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null) {
                this.dHR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dHR.startLoad(this.fGT.cNb.aAo().thumbnail_url, 10, false);
                this.dHP.setVisibility(0);
                return;
            }
            this.dHP.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gWr != null) {
            this.gWr.setPageUniqueId(bdUniqueId);
        }
        if (this.dHR != null) {
            this.dHR.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLK() {
        if (this.fGT != null && this.fGT.cNb != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fGP.getGodReplyContent(), this.fGT.axQ().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pq(int i) {
        if (this.fGT != null && this.fGT.cNb != null) {
            if (!this.fGT.btP() && i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setStType(com.baidu.tieba.card.l.azJ());
                this.eKe.setData(this.fGT.cNb);
                this.gWr.fK(false);
                return;
            }
            this.eJr.setData(this.fGT.cNb);
            this.eJr.setStType(com.baidu.tieba.card.l.azJ());
            this.eKe.setVisibility(8);
            this.gWr.fK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHR.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHR.setOnDrawListener(null);
        }
    }
}

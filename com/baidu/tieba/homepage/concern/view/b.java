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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<l> implements e {
    private String LC;
    private TbPageContext<?> cVg;
    public FrameLayout dLU;
    private TextView dLV;
    private TbImageView dLW;
    private ImageView dLX;
    private TextView dMc;
    private TbImageView.a dMe;
    private final View.OnClickListener dhI;
    public ThreadSourceShareAndPraiseLayout eNX;
    private RelativeLayout eNj;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private final View.OnClickListener fJB;
    private final View.OnClickListener fJC;
    private ThreadGodReplyLayout fJm;
    private HeadPendantClickableView fJn;
    private LinearLayout fJp;
    private l fJq;
    private TextView fJx;
    public ConcernThreadUserInfoLayout gYq;
    public ConcernForumThreadUserInfoLayout gYr;
    public com.baidu.tbadk.core.view.c gYs;
    private LinearLayout gYv;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dLW != null) {
                    b.this.dLW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fJB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buE() != null) {
                    b.this.buE().a(view, b.this.fJq);
                }
            }
        };
        this.fJC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buE() != null) {
                    b.this.buE().a(view, b.this.fJq);
                }
            }
        };
        this.dhI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fJq != null) {
                    if (b.this.buE() != null) {
                        b.this.buE().a(view, b.this.fJq);
                    }
                    if (b.this.fJq.cRe != null && view != b.this.eNX.dhS) {
                        com.baidu.tieba.card.l.zS(b.this.fJq.cRe.getId());
                        b.this.bNn();
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eNj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJn = (HeadPendantClickableView) this.eNj.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setPlaceHolder(1);
            this.fJn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.ds70));
        }
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gYv = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setFrom(9);
        this.eNl.setShareReportFrom(4);
        this.eNl.setForumAfterClickListener(this.dhI);
        this.eNl.dhF = this.currentPageType;
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.setShareReportFrom(4);
        this.eNX.setFrom(9);
        this.eNX.diG.dhF = this.currentPageType;
        this.eNX.setForumAfterClickListener(this.dhI);
        this.eNj.setOnClickListener(this);
        this.dLU = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dLU.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLU.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVg.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dLU.setLayoutParams(layoutParams2);
        this.dLW = (TbImageView) view.findViewById(R.id.image_video);
        this.dLW.setDefaultErrorResource(0);
        this.dLW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dLW.setGifIconSupport(false);
        this.dLW.setEvent(this.dMe);
        this.dLW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLW;
        TbImageView tbImageView2 = this.dLW;
        tbImageView.setConrers(15);
        this.dLW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLW.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLW.setBorderSurroundContent(true);
        this.dLW.setDrawBorder(true);
        this.dLX = (ImageView) view.findViewById(R.id.image_video_play);
        this.dLV = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJp = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fJm = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJm.setOnClickListener(this);
        this.fJx = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNj, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLX, R.drawable.btn_icon_play_video_n);
            this.eNl.onChangeSkinType();
            this.eNX.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dLV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gYq != null && this.gYq.getVisibility() == 0) {
            this.gYq.onChangeSkinType(i);
        }
        if (this.gYr != null && this.gYr.getVisibility() == 0) {
            this.gYr.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fJq = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNj || view == this.fJm) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dLU) {
            if (this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null) {
                z = this.fJq.cRe.aCD().is_vertical.intValue() == 1;
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
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buN();
        }
    }

    private void buN() {
        if (this.fJq != null && this.fJq.cRe != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJq.cRe);
            videoItemData.mRecomExtra = this.fJq.getExtra();
            videoItemData.mRecomAbTag = this.fJq.bvp();
            videoItemData.mRecomSource = this.fJq.getSource();
            videoItemData.mRecomWeight = this.fJq.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fJq.aAh(), "concern_tab");
            if (this.fJq.cRe.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJq.cRe.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buO();
        }
    }

    private void buO() {
        if (this.fJq != null && this.fJq.cRe != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJq.cRe);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dLW.getX() + this.gYv.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dLW.getY() + this.gYv.getY());
            videoCardViewInfo.cardViewWidth = this.dLW.getWidth();
            videoCardViewInfo.cardViewHeight = this.dLW.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVg.getPageActivity(), "concern_tab", this.fJq.cRe.getTid(), com.baidu.tieba.card.l.aBY(), this.fJq.aAh(), videoSerializeVideoThreadInfo);
            if (this.fJq.aAe() != null && this.fJq.aAe().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJq.aAe().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean buP() {
        return this.fJq.fNl && !this.fJq.fNs;
    }

    private void bH(View view) {
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (this.fJq != null && this.fJq.cRe != null) {
            if (!buP()) {
                com.baidu.tieba.card.l.zS(this.fJq.cRe.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVg.getPageActivity()).createFromThreadCfg(this.fJq.cRe, null, com.baidu.tieba.card.l.aBY(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJq.aAh());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fJq.cRe.getFid()));
            addLocateParam.setForumName(this.fJq.cRe.aCr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJm) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bNo() {
        if (this.gYq == null) {
            this.gYq = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bNp() {
        if (this.gYr == null) {
            this.gYr = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gYr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buE() != null) {
                    b.this.buE().a(view, b.this.fJq);
                }
                if (b.this.fJq != null && b.this.fJq.cRe != null) {
                    com.baidu.tieba.card.l.zS(b.this.fJq.cRe.getId());
                    b.this.bNn();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fJq == null || this.fJq.cRe == null || this.fJq.cRe.aCm() == null || this.fJq.cRe.aCD() == null) {
            this.eNj.setVisibility(8);
            return;
        }
        this.eNj.setVisibility(0);
        if (this.fJq.bvt()) {
            bNp();
            this.gYs = this.gYr;
            this.gYr.setVisibility(0);
            if (this.gYq != null) {
                this.gYq.setVisibility(8);
            }
        } else {
            bNo();
            this.gYs = this.gYq;
            this.gYq.setVisibility(0);
            if (this.gYr != null) {
                this.gYr.setVisibility(8);
            }
        }
        buT();
        if (!buP() && com.baidu.tieba.card.l.zT(this.fJq.cRe.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJm.getGodReplyContent(), this.fJq.aAe().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJq.aAe().aDh();
        SpannableStringBuilder aCT = this.fJq.aAe().aCT();
        if (this.fJq.aAe().aCZ() && !StringUtils.isNull(this.fJq.aAe().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJq.aAe().getTid();
            aCT.append((CharSequence) this.fJq.aAe().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cy("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aCT));
        this.mTextTitle.setText(aCT);
        if (this.gYs.getHeaderImg() != null) {
            this.gYs.getHeaderImg().setAfterClickListener(this.fJC);
            if (this.gYs.getIsSimpleThread()) {
                this.gYs.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (this.fJq.aAe() == null || this.fJq.aAe().aCm() == null || this.fJq.aAe().aCm().getPendantData() == null || StringUtils.isNull(this.fJq.aAe().aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.gYs.getHeaderImg().setVisibility(0);
                this.gYs.getHeaderImg().setData(this.fJq.aAe(), !this.fJq.bvt());
            } else {
                this.gYs.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(this.fJq.aAe());
            }
        }
        this.gYs.setData(this.fJq.cRe);
        this.gYs.setUserAfterClickListener(this.fJB);
        this.dLV.setText(aq.stringForVideoTime(this.fJq.cRe.aCD().video_duration.intValue() * 1000));
        this.dMc.setText(String.format(this.cVg.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJq.cRe.aCD().play_count.intValue())));
        this.fJm.setData(this.fJq.aAe().aDK());
        this.fJm.onChangeSkinType();
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zT(this.fJq.cRe.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pB(oc(1));
        if (this.fJq == null || this.fJq.cRe == null || this.fJq.cRe.aCD() == null) {
            z = false;
        } else if (this.fJq.cRe.aCD().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fJx.setVisibility(0);
        } else {
            this.fJx.setVisibility(8);
        }
    }

    private void buT() {
        if (this.dLW != null && this.dLU != null) {
            if (i.azM().isShowImages() && this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null) {
                this.dLW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dLW.startLoad(this.fJq.cRe.aCD().thumbnail_url, 10, false);
                this.dLU.setVisibility(0);
                return;
            }
            this.dLU.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYs != null) {
            this.gYs.setPageUniqueId(bdUniqueId);
        }
        if (this.dLW != null) {
            this.dLW.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        if (this.fJq != null && this.fJq.cRe != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJm.getGodReplyContent(), this.fJq.aAe().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pB(int i) {
        if (this.fJq != null && this.fJq.cRe != null) {
            if (!this.fJq.bvt() && i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setStType(com.baidu.tieba.card.l.aBY());
                this.eNX.setData(this.fJq.cRe);
                this.gYs.fR(false);
                return;
            }
            this.eNl.setData(this.fJq.cRe);
            this.eNl.setStType(com.baidu.tieba.card.l.aBY());
            this.eNX.setVisibility(8);
            this.gYs.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLW.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLW.setOnDrawListener(null);
        }
    }
}

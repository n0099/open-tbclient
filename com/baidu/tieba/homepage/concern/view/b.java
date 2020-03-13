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
    private TbPageContext<?> cVi;
    public FrameLayout dMi;
    private TextView dMj;
    private TbImageView dMk;
    private ImageView dMl;
    private TextView dMq;
    private TbImageView.a dMs;
    private final View.OnClickListener dhW;
    private RelativeLayout eNx;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public ThreadSourceShareAndPraiseLayout eOl;
    private ThreadGodReplyLayout fJB;
    private HeadPendantClickableView fJC;
    private LinearLayout fJE;
    private l fJF;
    private TextView fJM;
    private final View.OnClickListener fJQ;
    private final View.OnClickListener fJR;
    public ConcernThreadUserInfoLayout gYE;
    public ConcernForumThreadUserInfoLayout gYF;
    public com.baidu.tbadk.core.view.c gYG;
    private LinearLayout gYJ;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dMk != null) {
                    b.this.dMk.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fJQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buH() != null) {
                    b.this.buH().a(view, b.this.fJF);
                }
            }
        };
        this.fJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buH() != null) {
                    b.this.buH().a(view, b.this.fJF);
                }
            }
        };
        this.dhW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fJF != null) {
                    if (b.this.buH() != null) {
                        b.this.buH().a(view, b.this.fJF);
                    }
                    if (b.this.fJF.cRg != null && view != b.this.eOl.dih) {
                        com.baidu.tieba.card.l.zT(b.this.fJF.cRg.getId());
                        b.this.bNq();
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eNx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJC = (HeadPendantClickableView) this.eNx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJC.getHeadView() != null) {
            this.fJC.getHeadView().setIsRound(true);
            this.fJC.getHeadView().setDrawBorder(false);
            this.fJC.getHeadView().setDefaultResource(17170445);
            this.fJC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJC.getHeadView().setPlaceHolder(1);
            this.fJC.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.ds70));
        }
        if (this.fJC.getPendantView() != null) {
            this.fJC.getPendantView().setIsRound(true);
            this.fJC.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gYJ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setIsBarViewVisible(false);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setShareVisible(true);
        this.eNz.setFrom(9);
        this.eNz.setShareReportFrom(4);
        this.eNz.setForumAfterClickListener(this.dhW);
        this.eNz.dhT = this.currentPageType;
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.setShareReportFrom(4);
        this.eOl.setFrom(9);
        this.eOl.diU.dhT = this.currentPageType;
        this.eOl.setForumAfterClickListener(this.dhW);
        this.eNx.setOnClickListener(this);
        this.dMi = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dMi.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dMi.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVi.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dMi.setLayoutParams(layoutParams2);
        this.dMk = (TbImageView) view.findViewById(R.id.image_video);
        this.dMk.setDefaultErrorResource(0);
        this.dMk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dMk.setGifIconSupport(false);
        this.dMk.setEvent(this.dMs);
        this.dMk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMk;
        TbImageView tbImageView2 = this.dMk;
        tbImageView.setConrers(15);
        this.dMk.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMk.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMk.setBorderSurroundContent(true);
        this.dMk.setDrawBorder(true);
        this.dMl = (ImageView) view.findViewById(R.id.image_video_play);
        this.dMj = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJE = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMq = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fJB = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJB.setOnClickListener(this);
        this.fJM = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNx, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMl, R.drawable.btn_icon_play_video_n);
            this.eNz.onChangeSkinType();
            this.eOl.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dMj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gYE != null && this.gYE.getVisibility() == 0) {
            this.gYE.onChangeSkinType(i);
        }
        if (this.gYF != null && this.gYF.getVisibility() == 0) {
            this.gYF.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fJF = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNx || view == this.fJB) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dMi) {
            if (this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null) {
                z = this.fJF.cRg.aCF().is_vertical.intValue() == 1;
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
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buQ();
        }
    }

    private void buQ() {
        if (this.fJF != null && this.fJF.cRg != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJF.cRg);
            videoItemData.mRecomExtra = this.fJF.getExtra();
            videoItemData.mRecomAbTag = this.fJF.bvs();
            videoItemData.mRecomSource = this.fJF.getSource();
            videoItemData.mRecomWeight = this.fJF.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fJF.aAj(), "concern_tab");
            if (this.fJF.cRg.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJF.cRg.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buR();
        }
    }

    private void buR() {
        if (this.fJF != null && this.fJF.cRg != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJF.cRg);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dMk.getX() + this.gYJ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dMk.getY() + this.gYJ.getY());
            videoCardViewInfo.cardViewWidth = this.dMk.getWidth();
            videoCardViewInfo.cardViewHeight = this.dMk.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVi.getPageActivity(), "concern_tab", this.fJF.cRg.getTid(), com.baidu.tieba.card.l.aCa(), this.fJF.aAj(), videoSerializeVideoThreadInfo);
            if (this.fJF.aAg() != null && this.fJF.aAg().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJF.aAg().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean buS() {
        return this.fJF.fNA && !this.fJF.fNH;
    }

    private void bH(View view) {
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (this.fJF != null && this.fJF.cRg != null) {
            if (!buS()) {
                com.baidu.tieba.card.l.zT(this.fJF.cRg.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVi.getPageActivity()).createFromThreadCfg(this.fJF.cRg, null, com.baidu.tieba.card.l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJF.aAj());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fJF.cRg.getFid()));
            addLocateParam.setForumName(this.fJF.cRg.aCt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJB) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bNr() {
        if (this.gYE == null) {
            this.gYE = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bNs() {
        if (this.gYF == null) {
            this.gYF = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gYF.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buH() != null) {
                    b.this.buH().a(view, b.this.fJF);
                }
                if (b.this.fJF != null && b.this.fJF.cRg != null) {
                    com.baidu.tieba.card.l.zT(b.this.fJF.cRg.getId());
                    b.this.bNq();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fJF == null || this.fJF.cRg == null || this.fJF.cRg.aCo() == null || this.fJF.cRg.aCF() == null) {
            this.eNx.setVisibility(8);
            return;
        }
        this.eNx.setVisibility(0);
        if (this.fJF.bvw()) {
            bNs();
            this.gYG = this.gYF;
            this.gYF.setVisibility(0);
            if (this.gYE != null) {
                this.gYE.setVisibility(8);
            }
        } else {
            bNr();
            this.gYG = this.gYE;
            this.gYE.setVisibility(0);
            if (this.gYF != null) {
                this.gYF.setVisibility(8);
            }
        }
        buW();
        if (!buS() && com.baidu.tieba.card.l.zU(this.fJF.cRg.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJB.getGodReplyContent(), this.fJF.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJF.aAg().aDj();
        SpannableStringBuilder aCV = this.fJF.aAg().aCV();
        if (this.fJF.aAg().aDb() && !StringUtils.isNull(this.fJF.aAg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJF.aAg().getTid();
            aCV.append((CharSequence) this.fJF.aAg().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new h(aCV));
        this.mTextTitle.setText(aCV);
        if (this.gYG.getHeaderImg() != null) {
            this.gYG.getHeaderImg().setAfterClickListener(this.fJR);
            if (this.gYG.getIsSimpleThread()) {
                this.gYG.getHeaderImg().setVisibility(8);
                this.fJC.setVisibility(8);
            } else if (this.fJF.aAg() == null || this.fJF.aAg().aCo() == null || this.fJF.aAg().aCo().getPendantData() == null || StringUtils.isNull(this.fJF.aAg().aCo().getPendantData().aAG())) {
                this.fJC.setVisibility(8);
                this.gYG.getHeaderImg().setVisibility(0);
                this.gYG.getHeaderImg().setData(this.fJF.aAg(), !this.fJF.bvw());
            } else {
                this.gYG.getHeaderImg().setVisibility(4);
                this.fJC.setVisibility(0);
                this.fJC.setData(this.fJF.aAg());
            }
        }
        this.gYG.setData(this.fJF.cRg);
        this.gYG.setUserAfterClickListener(this.fJQ);
        this.dMj.setText(aq.stringForVideoTime(this.fJF.cRg.aCF().video_duration.intValue() * 1000));
        this.dMq.setText(String.format(this.cVi.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJF.cRg.aCF().play_count.intValue())));
        this.fJB.setData(this.fJF.aAg().aDM());
        this.fJB.onChangeSkinType();
        onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zU(this.fJF.cRg.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pB(oc(1));
        if (this.fJF == null || this.fJF.cRg == null || this.fJF.cRg.aCF() == null) {
            z = false;
        } else if (this.fJF.cRg.aCF().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fJM.setVisibility(0);
        } else {
            this.fJM.setVisibility(8);
        }
    }

    private void buW() {
        if (this.dMk != null && this.dMi != null) {
            if (i.azO().isShowImages() && this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null) {
                this.dMk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dMk.startLoad(this.fJF.cRg.aCF().thumbnail_url, 10, false);
                this.dMi.setVisibility(0);
                return;
            }
            this.dMi.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYG != null) {
            this.gYG.setPageUniqueId(bdUniqueId);
        }
        if (this.dMk != null) {
            this.dMk.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNq() {
        if (this.fJF != null && this.fJF.cRg != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJB.getGodReplyContent(), this.fJF.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pB(int i) {
        if (this.fJF != null && this.fJF.cRg != null) {
            if (!this.fJF.bvw() && i == 1) {
                this.eNz.setVisibility(8);
                this.eOl.setStType(com.baidu.tieba.card.l.aCa());
                this.eOl.setData(this.fJF.cRg);
                this.gYG.fR(false);
                return;
            }
            this.eNz.setData(this.fJF.cRg);
            this.eNz.setStType(com.baidu.tieba.card.l.aCa());
            this.eOl.setVisibility(8);
            this.gYG.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMk.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMk.setOnDrawListener(null);
        }
    }
}

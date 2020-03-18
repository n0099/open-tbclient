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
    private TbPageContext<?> cVv;
    private TbImageView dMA;
    private ImageView dMB;
    private TextView dMG;
    private TbImageView.a dMI;
    public FrameLayout dMy;
    private TextView dMz;
    private final View.OnClickListener dik;
    private RelativeLayout eNV;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public ThreadSourceShareAndPraiseLayout eOJ;
    private ThreadGodReplyLayout fKj;
    private HeadPendantClickableView fKk;
    private LinearLayout fKm;
    private l fKn;
    private TextView fKu;
    private final View.OnClickListener fKy;
    private final View.OnClickListener fKz;
    public ConcernThreadUserInfoLayout gZL;
    public ConcernForumThreadUserInfoLayout gZM;
    public com.baidu.tbadk.core.view.c gZN;
    private LinearLayout gZQ;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dMA != null) {
                    b.this.dMA.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fKy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buM() != null) {
                    b.this.buM().a(view, b.this.fKn);
                }
            }
        };
        this.fKz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buM() != null) {
                    b.this.buM().a(view, b.this.fKn);
                }
            }
        };
        this.dik = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fKn != null) {
                    if (b.this.buM() != null) {
                        b.this.buM().a(view, b.this.fKn);
                    }
                    if (b.this.fKn.cRt != null && view != b.this.eOJ.diw) {
                        com.baidu.tieba.card.l.zU(b.this.fKn.cRt.getId());
                        b.this.bNE();
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eNV = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fKk = (HeadPendantClickableView) this.eNV.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setPlaceHolder(1);
            this.fKk.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.ds70));
        }
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gZQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setFrom(9);
        this.eNX.setShareReportFrom(4);
        this.eNX.setForumAfterClickListener(this.dik);
        this.eNX.dih = this.currentPageType;
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.setShareReportFrom(4);
        this.eOJ.setFrom(9);
        this.eOJ.djh.dih = this.currentPageType;
        this.eOJ.setForumAfterClickListener(this.dik);
        this.eNV.setOnClickListener(this);
        this.dMy = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dMy.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dMy.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVv.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dMy.setLayoutParams(layoutParams2);
        this.dMA = (TbImageView) view.findViewById(R.id.image_video);
        this.dMA.setDefaultErrorResource(0);
        this.dMA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dMA.setGifIconSupport(false);
        this.dMA.setEvent(this.dMI);
        this.dMA.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMA;
        TbImageView tbImageView2 = this.dMA;
        tbImageView.setConrers(15);
        this.dMA.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMA.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMA.setBorderSurroundContent(true);
        this.dMA.setDrawBorder(true);
        this.dMB = (ImageView) view.findViewById(R.id.image_video_play);
        this.dMz = (TextView) view.findViewById(R.id.text_video_duration);
        this.fKm = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMG = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fKj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fKj.setOnClickListener(this);
        this.fKu = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNV, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMB, R.drawable.btn_icon_play_video_n);
            this.eNX.onChangeSkinType();
            this.eOJ.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dMz, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gZL != null && this.gZL.getVisibility() == 0) {
            this.gZL.onChangeSkinType(i);
        }
        if (this.gZM != null && this.gZM.getVisibility() == 0) {
            this.gZM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fKn = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNV || view == this.fKj) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dMy) {
            if (this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null) {
                z = this.fKn.cRt.aCI().is_vertical.intValue() == 1;
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
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buV();
        }
    }

    private void buV() {
        if (this.fKn != null && this.fKn.cRt != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fKn.cRt);
            videoItemData.mRecomExtra = this.fKn.getExtra();
            videoItemData.mRecomAbTag = this.fKn.bvx();
            videoItemData.mRecomSource = this.fKn.getSource();
            videoItemData.mRecomWeight = this.fKn.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fKn.aAm(), "concern_tab");
            if (this.fKn.cRt.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fKn.cRt.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buW();
        }
    }

    private void buW() {
        if (this.fKn != null && this.fKn.cRt != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fKn.cRt);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dMA.getX() + this.gZQ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dMA.getY() + this.gZQ.getY());
            videoCardViewInfo.cardViewWidth = this.dMA.getWidth();
            videoCardViewInfo.cardViewHeight = this.dMA.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVv.getPageActivity(), "concern_tab", this.fKn.cRt.getTid(), com.baidu.tieba.card.l.aCd(), this.fKn.aAm(), videoSerializeVideoThreadInfo);
            if (this.fKn.aAj() != null && this.fKn.aAj().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fKn.aAj().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean buX() {
        return this.fKn.fOi && !this.fKn.fOp;
    }

    private void bH(View view) {
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (this.fKn != null && this.fKn.cRt != null) {
            if (!buX()) {
                com.baidu.tieba.card.l.zU(this.fKn.cRt.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVv.getPageActivity()).createFromThreadCfg(this.fKn.cRt, null, com.baidu.tieba.card.l.aCd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fKn.aAm());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fKn.cRt.getFid()));
            addLocateParam.setForumName(this.fKn.cRt.aCw());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fKj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bNF() {
        if (this.gZL == null) {
            this.gZL = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bNG() {
        if (this.gZM == null) {
            this.gZM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gZM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buM() != null) {
                    b.this.buM().a(view, b.this.fKn);
                }
                if (b.this.fKn != null && b.this.fKn.cRt != null) {
                    com.baidu.tieba.card.l.zU(b.this.fKn.cRt.getId());
                    b.this.bNE();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fKn == null || this.fKn.cRt == null || this.fKn.cRt.aCr() == null || this.fKn.cRt.aCI() == null) {
            this.eNV.setVisibility(8);
            return;
        }
        this.eNV.setVisibility(0);
        if (this.fKn.bvB()) {
            bNG();
            this.gZN = this.gZM;
            this.gZM.setVisibility(0);
            if (this.gZL != null) {
                this.gZL.setVisibility(8);
            }
        } else {
            bNF();
            this.gZN = this.gZL;
            this.gZL.setVisibility(0);
            if (this.gZM != null) {
                this.gZM.setVisibility(8);
            }
        }
        bvb();
        if (!buX() && com.baidu.tieba.card.l.zV(this.fKn.cRt.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fKj.getGodReplyContent(), this.fKn.aAj().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fKn.aAj().aDm();
        SpannableStringBuilder aCY = this.fKn.aAj().aCY();
        if (this.fKn.aAj().aDe() && !StringUtils.isNull(this.fKn.aAj().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fKn.aAj().getTid();
            aCY.append((CharSequence) this.fKn.aAj().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cx("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aCY));
        this.mTextTitle.setText(aCY);
        if (this.gZN.getHeaderImg() != null) {
            this.gZN.getHeaderImg().setAfterClickListener(this.fKz);
            if (this.gZN.getIsSimpleThread()) {
                this.gZN.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (this.fKn.aAj() == null || this.fKn.aAj().aCr() == null || this.fKn.aAj().aCr().getPendantData() == null || StringUtils.isNull(this.fKn.aAj().aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.gZN.getHeaderImg().setVisibility(0);
                this.gZN.getHeaderImg().setData(this.fKn.aAj(), !this.fKn.bvB());
            } else {
                this.gZN.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(this.fKn.aAj());
            }
        }
        this.gZN.setData(this.fKn.cRt);
        this.gZN.setUserAfterClickListener(this.fKy);
        this.dMz.setText(aq.stringForVideoTime(this.fKn.cRt.aCI().video_duration.intValue() * 1000));
        this.dMG.setText(String.format(this.cVv.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fKn.cRt.aCI().play_count.intValue())));
        this.fKj.setData(this.fKn.aAj().aDQ());
        this.fKj.onChangeSkinType();
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zV(this.fKn.cRt.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pD(oe(1));
        if (this.fKn == null || this.fKn.cRt == null || this.fKn.cRt.aCI() == null) {
            z = false;
        } else if (this.fKn.cRt.aCI().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fKu.setVisibility(0);
        } else {
            this.fKu.setVisibility(8);
        }
    }

    private void bvb() {
        if (this.dMA != null && this.dMy != null) {
            if (i.azR().isShowImages() && this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null) {
                this.dMA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dMA.startLoad(this.fKn.cRt.aCI().thumbnail_url, 10, false);
                this.dMy.setVisibility(0);
                return;
            }
            this.dMy.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gZN != null) {
            this.gZN.setPageUniqueId(bdUniqueId);
        }
        if (this.dMA != null) {
            this.dMA.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        if (this.fKn != null && this.fKn.cRt != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fKj.getGodReplyContent(), this.fKn.aAj().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pD(int i) {
        if (this.fKn != null && this.fKn.cRt != null) {
            if (!this.fKn.bvB() && i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setStType(com.baidu.tieba.card.l.aCd());
                this.eOJ.setData(this.fKn.cRt);
                this.gZN.fS(false);
                return;
            }
            this.eNX.setData(this.fKn.cRt);
            this.eNX.setStType(com.baidu.tieba.card.l.aCd());
            this.eOJ.setVisibility(8);
            this.gZN.fS(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMA.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMA.setOnDrawListener(null);
        }
    }
}

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
    private TbPageContext<?> cVh;
    public FrameLayout dLV;
    private TextView dLW;
    private TbImageView dLX;
    private ImageView dLY;
    private TextView dMd;
    private TbImageView.a dMf;
    private final View.OnClickListener dhJ;
    public ThreadSourceShareAndPraiseLayout eNY;
    private RelativeLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNm;
    private final View.OnClickListener fJD;
    private final View.OnClickListener fJE;
    private ThreadGodReplyLayout fJo;
    private HeadPendantClickableView fJp;
    private LinearLayout fJr;
    private l fJs;
    private TextView fJz;
    public ConcernThreadUserInfoLayout gYs;
    public ConcernForumThreadUserInfoLayout gYt;
    public com.baidu.tbadk.core.view.c gYu;
    private LinearLayout gYx;
    private View mDivider;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.dLX != null) {
                    b.this.dLX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fJD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buG() != null) {
                    b.this.buG().a(view, b.this.fJs);
                }
            }
        };
        this.fJE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buG() != null) {
                    b.this.buG().a(view, b.this.fJs);
                }
            }
        };
        this.dhJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fJs != null) {
                    if (b.this.buG() != null) {
                        b.this.buG().a(view, b.this.fJs);
                    }
                    if (b.this.fJs.cRf != null && view != b.this.eNY.dhT) {
                        com.baidu.tieba.card.l.zS(b.this.fJs.cRf.getId());
                        b.this.bNp();
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.eNk = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJp = (HeadPendantClickableView) this.eNk.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setPlaceHolder(1);
            this.fJp.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.ds70));
        }
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gYx = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNm.setLayoutParams(layoutParams);
        }
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setIsBarViewVisible(false);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setShareVisible(true);
        this.eNm.setFrom(9);
        this.eNm.setShareReportFrom(4);
        this.eNm.setForumAfterClickListener(this.dhJ);
        this.eNm.dhG = this.currentPageType;
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.setShareReportFrom(4);
        this.eNY.setFrom(9);
        this.eNY.diH.dhG = this.currentPageType;
        this.eNY.setForumAfterClickListener(this.dhJ);
        this.eNk.setOnClickListener(this);
        this.dLV = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dLV.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLV.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVh.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dLV.setLayoutParams(layoutParams2);
        this.dLX = (TbImageView) view.findViewById(R.id.image_video);
        this.dLX.setDefaultErrorResource(0);
        this.dLX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dLX.setGifIconSupport(false);
        this.dLX.setEvent(this.dMf);
        this.dLX.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLX;
        TbImageView tbImageView2 = this.dLX;
        tbImageView.setConrers(15);
        this.dLX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLX.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLX.setBorderSurroundContent(true);
        this.dLX.setDrawBorder(true);
        this.dLY = (ImageView) view.findViewById(R.id.image_video_play);
        this.dLW = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJr = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMd = (TextView) view.findViewById(R.id.text_video_play_count);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fJo = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJo.setOnClickListener(this);
        this.fJz = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNk, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLY, R.drawable.btn_icon_play_video_n);
            this.eNm.onChangeSkinType();
            this.eNY.onChangeSkinType();
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dLW, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gYs != null && this.gYs.getVisibility() == 0) {
            this.gYs.onChangeSkinType(i);
        }
        if (this.gYt != null && this.gYt.getVisibility() == 0) {
            this.gYt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.fJs = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNk || view == this.fJo) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.dLV) {
            if (this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null) {
                z = this.fJs.cRf.aCF().is_vertical.intValue() == 1;
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
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buP();
        }
    }

    private void buP() {
        if (this.fJs != null && this.fJs.cRf != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJs.cRf);
            videoItemData.mRecomExtra = this.fJs.getExtra();
            videoItemData.mRecomAbTag = this.fJs.bvr();
            videoItemData.mRecomSource = this.fJs.getSource();
            videoItemData.mRecomWeight = this.fJs.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.fJs.aAj(), "concern_tab");
            if (this.fJs.cRf.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJs.cRf.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buQ();
        }
    }

    private void buQ() {
        if (this.fJs != null && this.fJs.cRf != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJs.cRf);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.dLX.getX() + this.gYx.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dLX.getY() + this.gYx.getY());
            videoCardViewInfo.cardViewWidth = this.dLX.getWidth();
            videoCardViewInfo.cardViewHeight = this.dLX.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVh.getPageActivity(), "concern_tab", this.fJs.cRf.getTid(), com.baidu.tieba.card.l.aCa(), this.fJs.aAj(), videoSerializeVideoThreadInfo);
            if (this.fJs.aAg() != null && this.fJs.aAg().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJs.aAg().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private boolean buR() {
        return this.fJs.fNn && !this.fJs.fNu;
    }

    private void bH(View view) {
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (this.fJs != null && this.fJs.cRf != null) {
            if (!buR()) {
                com.baidu.tieba.card.l.zS(this.fJs.cRf.getId());
                com.baidu.tieba.card.l.a(this.mTextTitle, this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVh.getPageActivity()).createFromThreadCfg(this.fJs.cRf, null, com.baidu.tieba.card.l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJs.aAj());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.fJs.cRf.getFid()));
            addLocateParam.setForumName(this.fJs.cRf.aCt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJo) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bNq() {
        if (this.gYs == null) {
            this.gYs = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bNr() {
        if (this.gYt == null) {
            this.gYt = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gYt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buG() != null) {
                    b.this.buG().a(view, b.this.fJs);
                }
                if (b.this.fJs != null && b.this.fJs.cRf != null) {
                    com.baidu.tieba.card.l.zS(b.this.fJs.cRf.getId());
                    b.this.bNp();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.fJs == null || this.fJs.cRf == null || this.fJs.cRf.aCo() == null || this.fJs.cRf.aCF() == null) {
            this.eNk.setVisibility(8);
            return;
        }
        this.eNk.setVisibility(0);
        if (this.fJs.bvv()) {
            bNr();
            this.gYu = this.gYt;
            this.gYt.setVisibility(0);
            if (this.gYs != null) {
                this.gYs.setVisibility(8);
            }
        } else {
            bNq();
            this.gYu = this.gYs;
            this.gYs.setVisibility(0);
            if (this.gYt != null) {
                this.gYt.setVisibility(8);
            }
        }
        buV();
        if (!buR() && com.baidu.tieba.card.l.zT(this.fJs.cRf.getId())) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJo.getGodReplyContent(), this.fJs.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJs.aAg().aDj();
        SpannableStringBuilder aCV = this.fJs.aAg().aCV();
        if (this.fJs.aAg().aDb() && !StringUtils.isNull(this.fJs.aAg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJs.aAg().getTid();
            aCV.append((CharSequence) this.fJs.aAg().a(new f(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        if (this.gYu.getHeaderImg() != null) {
            this.gYu.getHeaderImg().setAfterClickListener(this.fJE);
            if (this.gYu.getIsSimpleThread()) {
                this.gYu.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (this.fJs.aAg() == null || this.fJs.aAg().aCo() == null || this.fJs.aAg().aCo().getPendantData() == null || StringUtils.isNull(this.fJs.aAg().aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.gYu.getHeaderImg().setVisibility(0);
                this.gYu.getHeaderImg().setData(this.fJs.aAg(), !this.fJs.bvv());
            } else {
                this.gYu.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(this.fJs.aAg());
            }
        }
        this.gYu.setData(this.fJs.cRf);
        this.gYu.setUserAfterClickListener(this.fJD);
        this.dLW.setText(aq.stringForVideoTime(this.fJs.cRf.aCF().video_duration.intValue() * 1000));
        this.dMd.setText(String.format(this.cVh.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJs.cRf.aCF().play_count.intValue())));
        this.fJo.setData(this.fJs.aAg().aDM());
        this.fJo.onChangeSkinType();
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.l.zT(this.fJs.cRf.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        pB(oc(1));
        if (this.fJs == null || this.fJs.cRf == null || this.fJs.cRf.aCF() == null) {
            z = false;
        } else if (this.fJs.cRf.aCF().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.fJz.setVisibility(0);
        } else {
            this.fJz.setVisibility(8);
        }
    }

    private void buV() {
        if (this.dLX != null && this.dLV != null) {
            if (i.azO().isShowImages() && this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null) {
                this.dLX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dLX.startLoad(this.fJs.cRf.aCF().thumbnail_url, 10, false);
                this.dLV.setVisibility(0);
                return;
            }
            this.dLV.setVisibility(8);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYu != null) {
            this.gYu.setPageUniqueId(bdUniqueId);
        }
        if (this.dLX != null) {
            this.dLX.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        if (this.fJs != null && this.fJs.cRf != null) {
            com.baidu.tieba.card.l.a(this.mTextTitle, this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJo.getGodReplyContent(), this.fJs.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public void pB(int i) {
        if (this.fJs != null && this.fJs.cRf != null) {
            if (!this.fJs.bvv() && i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setStType(com.baidu.tieba.card.l.aCa());
                this.eNY.setData(this.fJs.cRf);
                this.gYu.fR(false);
                return;
            }
            this.eNm.setData(this.fJs.cRf);
            this.eNm.setStType(com.baidu.tieba.card.l.aCa());
            this.eNY.setVisibility(8);
            this.gYu.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLX.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLX.setOnDrawListener(null);
        }
    }
}

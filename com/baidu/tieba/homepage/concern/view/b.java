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
    private String Gc;
    private View bgU;
    public FrameLayout cTn;
    private TextView cTo;
    private TbImageView cTp;
    private ImageView cTq;
    private TextView cTv;
    private TbImageView.a cTx;
    private TbPageContext<?> ceu;
    private final View.OnClickListener coV;
    public ThreadCommentAndPraiseInfoLayout dSA;
    private RelativeLayout dSy;
    public ThreadSourceShareAndPraiseLayout dTo;
    private ThreadGodReplyLayout eLP;
    private HeadPendantClickableView eLQ;
    private LinearLayout eLS;
    private l eLT;
    private TextView eMa;
    private final View.OnClickListener eMe;
    private final View.OnClickListener eMf;
    public ConcernThreadUserInfoLayout ges;
    public ConcernForumThreadUserInfoLayout get;
    public d geu;
    private LinearLayout gex;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.cTp != null) {
                    b.this.cTp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eMe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZV() != null) {
                    b.this.aZV().a(view, b.this.eLT);
                }
            }
        };
        this.eMf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZV() != null) {
                    b.this.aZV().a(view, b.this.eLT);
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eLT != null) {
                    if (b.this.aZV() != null) {
                        b.this.aZV().a(view, b.this.eLT);
                    }
                    if (b.this.eLT.caz != null && view != b.this.dTo.cql) {
                        n.uz(b.this.eLT.caz.getId());
                        b.this.btd();
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dSy = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eLQ = (HeadPendantClickableView) this.dSy.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eLQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.ds70));
        }
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gex = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dSA.setLayoutParams(layoutParams);
        }
        this.dSA.setOnClickListener(this);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setIsBarViewVisible(false);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setShareVisible(true);
        this.dSA.setFrom(9);
        this.dSA.setDisPraiseFrom(4);
        this.dSA.setShareReportFrom(4);
        this.dSA.setForumAfterClickListener(this.coV);
        this.dSA.cqc = this.currentPageType;
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.setShareReportFrom(4);
        this.dTo.setFrom(9);
        this.dTo.cqW.cqc = this.currentPageType;
        this.dTo.setForumAfterClickListener(this.coV);
        this.dSy.setOnClickListener(this);
        this.cTn = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cTn.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTn.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ceu.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTn.setLayoutParams(layoutParams2);
        this.cTp = (TbImageView) view.findViewById(R.id.image_video);
        this.cTp.setDefaultErrorResource(0);
        this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cTp.setGifIconSupport(false);
        this.cTp.setEvent(this.cTx);
        this.cTp.setRadius(com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cTp;
        TbImageView tbImageView2 = this.cTp;
        tbImageView.setConrers(15);
        this.cTp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cTp.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cTp.setBorderSurroundContent(true);
        this.cTp.setDrawBorder(true);
        this.cTq = (ImageView) view.findViewById(R.id.image_video_play);
        this.cTo = (TextView) view.findViewById(R.id.text_video_duration);
        this.eLS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cTv = (TextView) view.findViewById(R.id.text_video_play_count);
        this.bgU = view.findViewById(R.id.divider_line);
        this.eLP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eLP.setOnClickListener(this);
        this.eMa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSy, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cTq, R.drawable.btn_icon_play_video_n);
            this.dSA.onChangeSkinType();
            this.dTo.onChangeSkinType();
            am.setBackgroundResource(this.bgU, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cTo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.ges != null && this.ges.getVisibility() == 0) {
            this.ges.onChangeSkinType(i);
        }
        if (this.get != null && this.get.getVisibility() == 0) {
            this.get.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.eLT = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dSy || view == this.eLP) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTn) {
            if (this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null) {
                z = this.eLT.caz.aiV().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(getView());
            } else {
                bF(getView());
            }
        }
    }

    private void bD(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bad() {
        if (this.eLT != null && this.eLT.caz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eLT.caz);
            videoItemData.mRecomExtra = this.eLT.getExtra();
            videoItemData.mRecomAbTag = this.eLT.baF();
            videoItemData.mRecomSource = this.eLT.getSource();
            videoItemData.mRecomWeight = this.eLT.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.eLT.agJ(), "concern_tab")));
        }
    }

    private void bQ(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bae();
        }
    }

    private void bae() {
        if (this.eLT != null && this.eLT.caz != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eLT.caz);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cTp.getX() + this.gex.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cTp.getY() + this.gex.getY());
            videoCardViewInfo.cardViewWidth = this.cTp.getWidth();
            videoCardViewInfo.cardViewHeight = this.cTp.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.ceu.getPageActivity(), "concern_tab", this.eLT.caz.getTid(), n.air(), this.eLT.agJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean baf() {
        return this.eLT.ePK && !this.eLT.ePR;
    }

    private void bF(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (this.eLT != null && this.eLT.caz != null) {
            if (!baf()) {
                n.uz(this.eLT.caz.getId());
                n.a(this.mTextTitle, this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ceu.getPageActivity()).createFromThreadCfg(this.eLT.caz, null, n.air(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.eLT.agJ());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.eLT.caz.getFid()));
            addLocateParam.setForumName(this.eLT.caz.aiJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eLP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bte() {
        if (this.ges == null) {
            this.ges = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void btf() {
        if (this.get == null) {
            this.get = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.get.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZV() != null) {
                    b.this.aZV().a(view, b.this.eLT);
                }
                if (b.this.eLT != null && b.this.eLT.caz != null) {
                    n.uz(b.this.eLT.caz.getId());
                    b.this.btd();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.eLT == null || this.eLT.caz == null || this.eLT.caz.aiE() == null || this.eLT.caz.aiV() == null) {
            this.dSy.setVisibility(8);
            return;
        }
        this.dSy.setVisibility(0);
        if (this.eLT.baJ()) {
            btf();
            this.geu = this.get;
            this.get.setVisibility(0);
            if (this.ges != null) {
                this.ges.setVisibility(8);
            }
        } else {
            bte();
            this.geu = this.ges;
            this.ges.setVisibility(0);
            if (this.get != null) {
                this.get.setVisibility(8);
            }
        }
        baj();
        if (!baf() && n.uA(this.eLT.caz.getId())) {
            n.a(this.mTextTitle, this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eLP.getGodReplyContent(), this.eLT.agG().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eLT.agG().aju();
        SpannableStringBuilder ajk = this.eLT.agG().ajk();
        if (this.eLT.agG().ajr() && !StringUtils.isNull(this.eLT.agG().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eLT.agG().getTid();
            ajk.append((CharSequence) this.eLT.agG().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bS("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(ajk));
        this.mTextTitle.setText(ajk);
        if (this.geu.getHeaderImg() != null) {
            this.geu.getHeaderImg().setAfterClickListener(this.eMf);
            if (this.geu.getIsSimpleThread()) {
                this.geu.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (this.eLT.agG() == null || this.eLT.agG().aiE() == null || this.eLT.agG().aiE().getPendantData() == null || StringUtils.isNull(this.eLT.agG().aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.geu.getHeaderImg().setVisibility(0);
                this.geu.getHeaderImg().setData(this.eLT.agG(), !this.eLT.baJ());
            } else {
                this.geu.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(this.eLT.agG());
            }
        }
        this.geu.setData(this.eLT.caz);
        this.geu.setUserAfterClickListener(this.eMe);
        this.cTo.setText(aq.stringForVideoTime(this.eLT.caz.aiV().video_duration.intValue() * 1000));
        this.cTv.setText(String.format(this.ceu.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eLT.caz.aiV().play_count.intValue())));
        this.eLP.setData(this.eLT.agG().akb());
        this.eLP.onChangeSkinType();
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eLT.caz.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        mY(lx(1));
        if (this.eLT == null || this.eLT.caz == null || this.eLT.caz.aiV() == null) {
            z = false;
        } else if (this.eLT.caz.aiV().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.eMa.setVisibility(0);
        } else {
            this.eMa.setVisibility(8);
        }
    }

    private void baj() {
        if (this.cTp != null && this.cTn != null) {
            if (i.ago().isShowImages() && this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null) {
                this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cTp.startLoad(this.eLT.caz.aiV().thumbnail_url, 10, false);
                this.cTn.setVisibility(0);
                return;
            }
            this.cTn.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.geu != null) {
            this.geu.setPageUniqueId(bdUniqueId);
        }
        if (this.cTp != null) {
            this.cTp.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (this.eLT != null && this.eLT.caz != null) {
            n.a(this.mTextTitle, this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eLP.getGodReplyContent(), this.eLT.agG().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.geu != null) {
            return this.geu.getHeaderImg();
        }
        return null;
    }

    public View baa() {
        if (this.geu != null) {
            return this.geu.getUserName();
        }
        return null;
    }

    public void mY(int i) {
        if (this.eLT != null && this.eLT.caz != null) {
            if (!this.eLT.baJ() && i == 1) {
                this.dSA.setVisibility(8);
                this.dTo.setStType(n.air());
                this.dTo.setData(this.eLT.caz);
                this.geu.et(false);
                return;
            }
            this.dSA.setData(this.eLT.caz);
            this.dSA.setStType(n.air());
            this.dTo.setVisibility(8);
            this.geu.et(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cTp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cTp.setOnDrawListener(null);
        }
    }
}

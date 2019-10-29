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
    private String GC;
    private View bhm;
    public FrameLayout cUe;
    private TextView cUf;
    private TbImageView cUg;
    private ImageView cUh;
    private TextView cUm;
    private TbImageView.a cUo;
    private TbPageContext<?> cfl;
    private final View.OnClickListener cpN;
    private RelativeLayout dTp;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public ThreadSourceShareAndPraiseLayout dUf;
    private ThreadGodReplyLayout eMG;
    private HeadPendantClickableView eMH;
    private LinearLayout eMJ;
    private l eMK;
    private TextView eMR;
    private final View.OnClickListener eMV;
    private final View.OnClickListener eMW;
    public ConcernThreadUserInfoLayout gfj;
    public ConcernForumThreadUserInfoLayout gfk;
    public d gfl;
    private LinearLayout gfo;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.cUg != null) {
                    b.this.cUg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eMV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZX() != null) {
                    b.this.aZX().a(view, b.this.eMK);
                }
            }
        };
        this.eMW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZX() != null) {
                    b.this.aZX().a(view, b.this.eMK);
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eMK != null) {
                    if (b.this.aZX() != null) {
                        b.this.aZX().a(view, b.this.eMK);
                    }
                    if (b.this.eMK.cbq != null && view != b.this.dUf.crd) {
                        n.uz(b.this.eMK.cbq.getId());
                        b.this.btf();
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dTp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eMH = (HeadPendantClickableView) this.dTp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eMH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.ds70));
        }
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gfo = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dTr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTr.setLayoutParams(layoutParams);
        }
        this.dTr.setOnClickListener(this);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setIsBarViewVisible(false);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setShareVisible(true);
        this.dTr.setFrom(9);
        this.dTr.setDisPraiseFrom(4);
        this.dTr.setShareReportFrom(4);
        this.dTr.setForumAfterClickListener(this.cpN);
        this.dTr.cqT = this.currentPageType;
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.setShareReportFrom(4);
        this.dUf.setFrom(9);
        this.dUf.crO.cqT = this.currentPageType;
        this.dUf.setForumAfterClickListener(this.cpN);
        this.dTp.setOnClickListener(this);
        this.cUe = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cUe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUe.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cfl.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cUe.setLayoutParams(layoutParams2);
        this.cUg = (TbImageView) view.findViewById(R.id.image_video);
        this.cUg.setDefaultErrorResource(0);
        this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cUg.setGifIconSupport(false);
        this.cUg.setEvent(this.cUo);
        this.cUg.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cUg;
        TbImageView tbImageView2 = this.cUg;
        tbImageView.setConrers(15);
        this.cUg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cUg.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cUg.setBorderSurroundContent(true);
        this.cUg.setDrawBorder(true);
        this.cUh = (ImageView) view.findViewById(R.id.image_video_play);
        this.cUf = (TextView) view.findViewById(R.id.text_video_duration);
        this.eMJ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cUm = (TextView) view.findViewById(R.id.text_video_play_count);
        this.bhm = view.findViewById(R.id.divider_line);
        this.eMG = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eMG.setOnClickListener(this);
        this.eMR = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cUh, R.drawable.btn_icon_play_video_n);
            this.dTr.onChangeSkinType();
            this.dUf.onChangeSkinType();
            am.setBackgroundResource(this.bhm, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cUf, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
        if (this.gfj != null && this.gfj.getVisibility() == 0) {
            this.gfj.onChangeSkinType(i);
        }
        if (this.gfk != null && this.gfk.getVisibility() == 0) {
            this.gfk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.eMK = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dTp || view == this.eMG) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cUe) {
            if (this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null) {
                z = this.eMK.cbq.aiX().is_vertical.intValue() == 1;
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
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            baf();
        }
    }

    private void baf() {
        if (this.eMK != null && this.eMK.cbq != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eMK.cbq);
            videoItemData.mRecomExtra = this.eMK.getExtra();
            videoItemData.mRecomAbTag = this.eMK.baH();
            videoItemData.mRecomSource = this.eMK.getSource();
            videoItemData.mRecomWeight = this.eMK.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.eMK.agL(), "concern_tab")));
        }
    }

    private void bQ(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (!j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bag();
        }
    }

    private void bag() {
        if (this.eMK != null && this.eMK.cbq != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eMK.cbq);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cUg.getX() + this.gfo.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cUg.getY() + this.gfo.getY());
            videoCardViewInfo.cardViewWidth = this.cUg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cUg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.cfl.getPageActivity(), "concern_tab", this.eMK.cbq.getTid(), n.ait(), this.eMK.agL(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean bah() {
        return this.eMK.eQB && !this.eMK.eQI;
    }

    private void bF(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (this.eMK != null && this.eMK.cbq != null) {
            if (!bah()) {
                n.uz(this.eMK.cbq.getId());
                n.a(this.mTextTitle, this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cfl.getPageActivity()).createFromThreadCfg(this.eMK.cbq, null, n.ait(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.eMK.agL());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.eMK.cbq.getFid()));
            addLocateParam.setForumName(this.eMK.cbq.aiL());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eMG) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void btg() {
        if (this.gfj == null) {
            this.gfj = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bth() {
        if (this.gfk == null) {
            this.gfk = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.gfk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aZX() != null) {
                    b.this.aZX().a(view, b.this.eMK);
                }
                if (b.this.eMK != null && b.this.eMK.cbq != null) {
                    n.uz(b.this.eMK.cbq.getId());
                    b.this.btf();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.eMK == null || this.eMK.cbq == null || this.eMK.cbq.aiG() == null || this.eMK.cbq.aiX() == null) {
            this.dTp.setVisibility(8);
            return;
        }
        this.dTp.setVisibility(0);
        if (this.eMK.baL()) {
            bth();
            this.gfl = this.gfk;
            this.gfk.setVisibility(0);
            if (this.gfj != null) {
                this.gfj.setVisibility(8);
            }
        } else {
            btg();
            this.gfl = this.gfj;
            this.gfj.setVisibility(0);
            if (this.gfk != null) {
                this.gfk.setVisibility(8);
            }
        }
        bal();
        if (!bah() && n.uA(this.eMK.cbq.getId())) {
            n.a(this.mTextTitle, this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eMG.getGodReplyContent(), this.eMK.agI().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eMK.agI().ajw();
        SpannableStringBuilder ajm = this.eMK.agI().ajm();
        if (this.eMK.agI().ajt() && !StringUtils.isNull(this.eMK.agI().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eMK.agI().getTid();
            ajm.append((CharSequence) this.eMK.agI().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
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
        this.mTextTitle.setOnTouchListener(new k(ajm));
        this.mTextTitle.setText(ajm);
        if (this.gfl.getHeaderImg() != null) {
            this.gfl.getHeaderImg().setAfterClickListener(this.eMW);
            if (this.gfl.getIsSimpleThread()) {
                this.gfl.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (this.eMK.agI() == null || this.eMK.agI().aiG() == null || this.eMK.agI().aiG().getPendantData() == null || StringUtils.isNull(this.eMK.agI().aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.gfl.getHeaderImg().setVisibility(0);
                this.gfl.getHeaderImg().setData(this.eMK.agI(), !this.eMK.baL());
            } else {
                this.gfl.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(this.eMK.agI());
            }
        }
        this.gfl.setData(this.eMK.cbq);
        this.gfl.setUserAfterClickListener(this.eMV);
        this.cUf.setText(aq.stringForVideoTime(this.eMK.cbq.aiX().video_duration.intValue() * 1000));
        this.cUm.setText(String.format(this.cfl.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eMK.cbq.aiX().play_count.intValue())));
        this.eMG.setData(this.eMK.agI().akd());
        this.eMG.onChangeSkinType();
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eMK.cbq.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        mZ(ly(1));
        if (this.eMK == null || this.eMK.cbq == null || this.eMK.cbq.aiX() == null) {
            z = false;
        } else if (this.eMK.cbq.aiX().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.eMR.setVisibility(0);
        } else {
            this.eMR.setVisibility(8);
        }
    }

    private void bal() {
        if (this.cUg != null && this.cUe != null) {
            if (i.agq().isShowImages() && this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null) {
                this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cUg.startLoad(this.eMK.cbq.aiX().thumbnail_url, 10, false);
                this.cUe.setVisibility(0);
                return;
            }
            this.cUe.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gfl != null) {
            this.gfl.setPageUniqueId(bdUniqueId);
        }
        if (this.cUg != null) {
            this.cUg.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        if (this.eMK != null && this.eMK.cbq != null) {
            n.a(this.mTextTitle, this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eMG.getGodReplyContent(), this.eMK.agI().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gfl != null) {
            return this.gfl.getHeaderImg();
        }
        return null;
    }

    public View bac() {
        if (this.gfl != null) {
            return this.gfl.getUserName();
        }
        return null;
    }

    public void mZ(int i) {
        if (this.eMK != null && this.eMK.cbq != null) {
            if (!this.eMK.baL() && i == 1) {
                this.dTr.setVisibility(8);
                this.dUf.setStType(n.ait());
                this.dUf.setData(this.eMK.cbq);
                this.gfl.et(false);
                return;
            }
            this.dTr.setData(this.eMK.cbq);
            this.dTr.setStType(n.ait());
            this.dUf.setVisibility(8);
            this.gfl.et(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cUg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cUg.setOnDrawListener(null);
        }
    }
}

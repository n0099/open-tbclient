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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private String Wt;
    private View aMY;
    private final View.OnClickListener bZt;
    public FrameLayout cIm;
    private TextView cIn;
    private TbImageView cIo;
    private ImageView cIp;
    private TextView cIu;
    private TbImageView.a cIw;
    public ThreadSourceShareAndPraiseLayout dBT;
    private RelativeLayout dBd;
    public ThreadCommentAndPraiseInfoLayout dBf;
    private final View.OnClickListener exA;
    private final View.OnClickListener exB;
    private ThreadGodReplyLayout exk;
    private HeadPendantClickableView exl;
    private LinearLayout exm;
    private l exo;
    private TextView exw;
    public ConcernThreadUserInfoLayout fYf;
    public ConcernForumThreadUserInfoLayout fYg;
    public d fYh;
    private LinearLayout fYk;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && b.this.cIo != null) {
                    b.this.cIo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.exA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aXr() != null) {
                    b.this.aXr().a(view, b.this.exo);
                }
            }
        };
        this.exB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aXr() != null) {
                    b.this.aXr().a(view, b.this.exo);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.exo != null) {
                    if (b.this.aXr() != null) {
                        b.this.aXr().a(view, b.this.exo);
                    }
                    if (b.this.exo.threadData != null && view != b.this.dBT.caL) {
                        n.uS(b.this.exo.threadData.getId());
                        b.this.bsW();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dBd = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.exl = (HeadPendantClickableView) this.dBd.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.exl.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fYk = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dBf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBf.setLayoutParams(layoutParams);
        }
        this.dBf.setOnClickListener(this);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setIsBarViewVisible(false);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setShareVisible(true);
        this.dBf.setFrom(9);
        this.dBf.setDisPraiseFrom(4);
        this.dBf.setShareReportFrom(4);
        this.dBf.setForumAfterClickListener(this.bZt);
        this.dBf.caC = this.currentPageType;
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dBT.cbw.setOnClickListener(this);
        this.dBT.setShareReportFrom(4);
        this.dBT.setFrom(9);
        this.dBT.cbw.caC = this.currentPageType;
        this.dBT.setForumAfterClickListener(this.bZt);
        this.dBd.setOnClickListener(this);
        this.cIm = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cIm.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cIm.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cIm.setLayoutParams(layoutParams2);
        this.cIo = (TbImageView) view.findViewById(R.id.image_video);
        this.cIo.setDefaultErrorResource(0);
        this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIo.setGifIconSupport(false);
        this.cIo.setEvent(this.cIw);
        this.cIo.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIo;
        TbImageView tbImageView2 = this.cIo;
        tbImageView.setConrers(15);
        this.cIo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIo.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIo.setBorderSurroundContent(true);
        this.cIo.setDrawBorder(true);
        this.cIp = (ImageView) view.findViewById(R.id.image_video_play);
        this.cIn = (TextView) view.findViewById(R.id.text_video_duration);
        this.exm = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cIu = (TextView) view.findViewById(R.id.text_video_play_count);
        this.aMY = view.findViewById(R.id.divider_line);
        this.exk = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.exk.setOnClickListener(this);
        this.exw = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dBd, R.drawable.addresslist_item_bg);
            al.c(this.cIp, (int) R.drawable.btn_icon_play_video_n);
            this.dBf.onChangeSkinType();
            this.dBT.onChangeSkinType();
            al.k(this.aMY, R.color.cp_bg_line_e);
            al.j(this.cIn, R.color.cp_btn_a);
            al.j(this.cIu, R.color.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.fYf != null && this.fYf.getVisibility() == 0) {
            this.fYf.onChangeSkinType(i);
        }
        if (this.fYg != null && this.fYg.getVisibility() == 0) {
            this.fYg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.exo = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dBd || view == this.exk) {
            bG(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cIm) {
            if (this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                z = this.exo.threadData.adM().is_vertical.intValue() == 1;
            }
            if (z) {
                bE(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(getView());
            } else {
                bG(getView());
            }
        }
    }

    private void bE(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (!j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXz();
        }
    }

    private void aXz() {
        if (this.exo != null && this.exo.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.exo.threadData);
            videoItemData.mRecomExtra = this.exo.getExtra();
            videoItemData.mRecomAbTag = this.exo.aYa();
            videoItemData.mRecomSource = this.exo.getSource();
            videoItemData.mRecomWeight = this.exo.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.exo.aby(), "concern_tab")));
        }
    }

    private void bQ(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (!j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXA();
        }
    }

    private void aXA() {
        if (this.exo != null && this.exo.threadData != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.exo.threadData);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cIo.getX() + this.fYk.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cIo.getY() + this.fYk.getY());
            videoCardViewInfo.cardViewWidth = this.cIo.getWidth();
            videoCardViewInfo.cardViewHeight = this.cIo.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.exo.threadData.getTid(), n.adi(), this.exo.aby(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aXB() {
        return this.exo.eBk && !this.exo.eBr;
    }

    private void bG(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (this.exo != null && this.exo.threadData != null) {
            if (!aXB()) {
                n.uS(this.exo.threadData.getId());
                n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.exo.threadData, null, n.adi(), 18003, true, false, false).addLocateParam(this.exo.aby());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.exo.threadData.getFid()));
            addLocateParam.setForumName(this.exo.threadData.adA());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.exk) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bsX() {
        if (this.fYf == null) {
            this.fYf = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bsY() {
        if (this.fYg == null) {
            this.fYg = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.fYg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aXr() != null) {
                    b.this.aXr().a(view, b.this.exo);
                }
                if (b.this.exo != null && b.this.exo.threadData != null) {
                    n.uS(b.this.exo.threadData.getId());
                    b.this.bsW();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.exo == null || this.exo.threadData == null || this.exo.threadData.adv() == null || this.exo.threadData.adM() == null) {
            this.dBd.setVisibility(8);
            return;
        }
        this.dBd.setVisibility(0);
        if (this.exo.aYe()) {
            bsY();
            this.fYh = this.fYg;
            this.fYg.setVisibility(0);
            if (this.fYf != null) {
                this.fYf.setVisibility(8);
            }
        } else {
            bsX();
            this.fYh = this.fYf;
            this.fYf.setVisibility(0);
            if (this.fYg != null) {
                this.fYg.setVisibility(8);
            }
        }
        aXF();
        if (!aXB() && n.uT(this.exo.threadData.getId())) {
            n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.exo.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.exo.abv().ael();
        SpannableStringBuilder aeb = this.exo.abv().aeb();
        if (this.exo.abv().aei() && !StringUtils.isNull(this.exo.abv().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.exo.abv().getTid();
            aeb.append((CharSequence) this.exo.abv().a(new c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.b.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(aeb));
        this.mTextTitle.setText(aeb);
        if (this.fYh.getHeaderImg() != null) {
            this.fYh.getHeaderImg().setAfterClickListener(this.exB);
            if (this.fYh.getIsSimpleThread()) {
                this.fYh.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (this.exo.abv() == null || this.exo.abv().adv() == null || this.exo.abv().adv().getPendantData() == null || StringUtils.isNull(this.exo.abv().adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.fYh.getHeaderImg().setVisibility(0);
                this.fYh.getHeaderImg().setData(this.exo.abv(), !this.exo.aYe());
            } else {
                this.fYh.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(this.exo.abv());
            }
        }
        this.fYh.setData(this.exo.threadData);
        this.fYh.setUserAfterClickListener(this.exA);
        this.cIn.setText(ap.im(this.exo.threadData.adM().video_duration.intValue() * 1000));
        this.cIu.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.exo.threadData.adM().play_count.intValue())));
        this.exk.setData(this.exo.abv().aeT());
        this.exk.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uT(this.exo.threadData.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        nv(mh(1));
        if (this.exo == null || this.exo.threadData == null || this.exo.threadData.adM() == null) {
            z = false;
        } else if (this.exo.threadData.adM().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.exw.setVisibility(0);
        } else {
            this.exw.setVisibility(8);
        }
    }

    private void aXF() {
        if (this.cIo != null && this.cIm != null) {
            if (i.abb().abf() && this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIo.startLoad(this.exo.threadData.adM().thumbnail_url, 10, false);
                this.cIm.setVisibility(0);
                return;
            }
            this.cIm.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYh != null) {
            this.fYh.setPageUniqueId(bdUniqueId);
        }
        if (this.cIo != null) {
            this.cIo.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsW() {
        if (this.exo != null && this.exo.threadData != null) {
            n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.exo.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fYh != null) {
            return this.fYh.getHeaderImg();
        }
        return null;
    }

    public View aXw() {
        if (this.fYh != null) {
            return this.fYh.getUserName();
        }
        return null;
    }

    public void nv(int i) {
        if (this.exo != null && this.exo.threadData != null) {
            if (!this.exo.aYe() && i == 1) {
                this.dBf.setVisibility(8);
                this.dBT.setStType(n.adi());
                this.dBT.setData(this.exo.threadData);
                this.fYh.ej(false);
                return;
            }
            this.dBf.setData(this.exo.threadData);
            this.dBf.setStType(n.adi());
            this.dBT.setVisibility(8);
            this.fYh.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Wt, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cIo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cIo.setOnDrawListener(null);
        }
    }
}

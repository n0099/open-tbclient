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
    private String Ws;
    private View aMY;
    private final View.OnClickListener bZu;
    public FrameLayout cIn;
    private TextView cIo;
    private TbImageView cIp;
    private ImageView cIq;
    private TextView cIv;
    private TbImageView.a cIx;
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
    public ConcernThreadUserInfoLayout fYh;
    public ConcernForumThreadUserInfoLayout fYi;
    public d fYj;
    private LinearLayout fYm;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cIx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && b.this.cIp != null) {
                    b.this.cIp.setDefaultBgResource(0);
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
        this.bZu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.exo != null) {
                    if (b.this.aXr() != null) {
                        b.this.aXr().a(view, b.this.exo);
                    }
                    if (b.this.exo.threadData != null && view != b.this.dBT.caM) {
                        n.uR(b.this.exo.threadData.getId());
                        b.this.bsX();
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
        this.fYm = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
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
        this.dBf.setForumAfterClickListener(this.bZu);
        this.dBf.caD = this.currentPageType;
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_video_source_read_share_layout);
        this.dBT.cbx.setOnClickListener(this);
        this.dBT.setShareReportFrom(4);
        this.dBT.setFrom(9);
        this.dBT.cbx.caD = this.currentPageType;
        this.dBT.setForumAfterClickListener(this.bZu);
        this.dBd.setOnClickListener(this);
        this.cIn = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cIn.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cIn.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cIn.setLayoutParams(layoutParams2);
        this.cIp = (TbImageView) view.findViewById(R.id.image_video);
        this.cIp.setDefaultErrorResource(0);
        this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIp.setGifIconSupport(false);
        this.cIp.setEvent(this.cIx);
        this.cIp.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIp;
        TbImageView tbImageView2 = this.cIp;
        tbImageView.setConrers(15);
        this.cIp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIp.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIp.setBorderSurroundContent(true);
        this.cIp.setDrawBorder(true);
        this.cIq = (ImageView) view.findViewById(R.id.image_video_play);
        this.cIo = (TextView) view.findViewById(R.id.text_video_duration);
        this.exm = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cIv = (TextView) view.findViewById(R.id.text_video_play_count);
        this.aMY = view.findViewById(R.id.divider_line);
        this.exk = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.exk.setOnClickListener(this);
        this.exw = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dBd, R.drawable.addresslist_item_bg);
            al.c(this.cIq, (int) R.drawable.btn_icon_play_video_n);
            this.dBf.onChangeSkinType();
            this.dBT.onChangeSkinType();
            al.k(this.aMY, R.color.cp_bg_line_e);
            al.j(this.cIo, R.color.cp_btn_a);
            al.j(this.cIv, R.color.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.fYh != null && this.fYh.getVisibility() == 0) {
            this.fYh.onChangeSkinType(i);
        }
        if (this.fYi != null && this.fYi.getVisibility() == 0) {
            this.fYi.onChangeSkinType(i);
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
        if (view == this.cIn) {
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
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cIp.getX() + this.fYm.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cIp.getY() + this.fYm.getY());
            videoCardViewInfo.cardViewWidth = this.cIp.getWidth();
            videoCardViewInfo.cardViewHeight = this.cIp.getHeight();
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
                n.uR(this.exo.threadData.getId());
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

    private void bsY() {
        if (this.fYh == null) {
            this.fYh = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void bsZ() {
        if (this.fYi == null) {
            this.fYi = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.fYi.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aXr() != null) {
                    b.this.aXr().a(view, b.this.exo);
                }
                if (b.this.exo != null && b.this.exo.threadData != null) {
                    n.uR(b.this.exo.threadData.getId());
                    b.this.bsX();
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
            bsZ();
            this.fYj = this.fYi;
            this.fYi.setVisibility(0);
            if (this.fYh != null) {
                this.fYh.setVisibility(8);
            }
        } else {
            bsY();
            this.fYj = this.fYh;
            this.fYh.setVisibility(0);
            if (this.fYi != null) {
                this.fYi.setVisibility(8);
            }
        }
        aXF();
        if (!aXB() && n.uS(this.exo.threadData.getId())) {
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
        if (this.fYj.getHeaderImg() != null) {
            this.fYj.getHeaderImg().setAfterClickListener(this.exB);
            if (this.fYj.getIsSimpleThread()) {
                this.fYj.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (this.exo.abv() == null || this.exo.abv().adv() == null || this.exo.abv().adv().getPendantData() == null || StringUtils.isNull(this.exo.abv().adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.fYj.getHeaderImg().setVisibility(0);
                this.fYj.getHeaderImg().setData(this.exo.abv(), !this.exo.aYe());
            } else {
                this.fYj.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(this.exo.abv());
            }
        }
        this.fYj.setData(this.exo.threadData);
        this.fYj.setUserAfterClickListener(this.exA);
        this.cIo.setText(ap.im(this.exo.threadData.adM().video_duration.intValue() * 1000));
        this.cIv.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.exo.threadData.adM().play_count.intValue())));
        this.exk.setData(this.exo.abv().aeT());
        this.exk.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uS(this.exo.threadData.getId())) {
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
        if (this.cIp != null && this.cIn != null) {
            if (i.abb().abf() && this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIp.startLoad(this.exo.threadData.adM().thumbnail_url, 10, false);
                this.cIn.setVisibility(0);
                return;
            }
            this.cIn.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYj != null) {
            this.fYj.setPageUniqueId(bdUniqueId);
        }
        if (this.cIp != null) {
            this.cIp.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsX() {
        if (this.exo != null && this.exo.threadData != null) {
            n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.exo.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fYj != null) {
            return this.fYj.getHeaderImg();
        }
        return null;
    }

    public View aXw() {
        if (this.fYj != null) {
            return this.fYj.getUserName();
        }
        return null;
    }

    public void nv(int i) {
        if (this.exo != null && this.exo.threadData != null) {
            if (!this.exo.aYe() && i == 1) {
                this.dBf.setVisibility(8);
                this.dBT.setStType(n.adi());
                this.dBT.setData(this.exo.threadData);
                this.fYj.ej(false);
                return;
            }
            this.dBf.setData(this.exo.threadData);
            this.dBf.setStType(n.adi());
            this.dBT.setVisibility(8);
            this.fYj.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Ws, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cIp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.b.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cIp.setOnDrawListener(null);
        }
    }
}

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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private String YA;
    private View aLb;
    private final View.OnClickListener bRz;
    public FrameLayout cAb;
    private TextView cAc;
    private TbImageView cAd;
    private ImageView cAe;
    private TextView cAj;
    private TbImageView.a cAl;
    private RelativeLayout dqt;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    private ThreadGodReplyLayout ehJ;
    private HeadPendantClickableView ehK;
    private LinearLayout ehM;
    private l ehO;
    private TextView ehV;
    private final View.OnClickListener ehZ;
    private final View.OnClickListener eia;
    public ConcernThreadUserInfoLayout fHh;
    public ConcernForumThreadUserInfoLayout fHj;
    public com.baidu.tbadk.core.view.d fHk;
    private LinearLayout fHn;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAd != null) {
                    c.this.cAd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.ehO);
                }
            }
        };
        this.eia = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.ehO);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ehO != null) {
                    if (c.this.aQh() != null) {
                        c.this.aQh().a(view, c.this.ehO);
                    }
                    if (c.this.ehO.cZz != null && view != c.this.drk.bSQ) {
                        n.tA(c.this.ehO.cZz.getId());
                        c.this.blA();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dqt = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehK = (HeadPendantClickableView) this.dqt.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehK.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.fHn = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        this.dqv.setOnClickListener(this);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.setFrom(9);
        this.dqv.setDisPraiseFrom(4);
        this.dqv.setShareReportFrom(4);
        this.dqv.setForumAfterClickListener(this.bRz);
        this.dqv.bSH = this.currentPageType;
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this);
        this.drk.setShareReportFrom(4);
        this.drk.setFrom(9);
        this.drk.bTz.bSH = this.currentPageType;
        this.drk.setForumAfterClickListener(this.bRz);
        this.dqt.setOnClickListener(this);
        this.cAb = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAb.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAb.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAb.setLayoutParams(layoutParams2);
        this.cAd = (TbImageView) view.findViewById(d.g.image_video);
        this.cAd.setDefaultErrorResource(0);
        this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAd.setGifIconSupport(false);
        this.cAd.setEvent(this.cAl);
        this.cAd.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAd;
        TbImageView tbImageView2 = this.cAd;
        tbImageView.setConrers(15);
        this.cAd.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAd.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAd.setBorderSurroundContent(true);
        this.cAd.setDrawBorder(true);
        this.cAe = (ImageView) view.findViewById(d.g.image_video_play);
        this.cAc = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehM = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAj = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aLb = view.findViewById(d.g.divider_line);
        this.ehJ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehJ.setOnClickListener(this);
        this.ehV = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqt, d.f.addresslist_item_bg);
            al.c(this.cAe, d.f.btn_icon_play_video_n);
            this.dqv.onChangeSkinType();
            this.drk.onChangeSkinType();
            al.k(this.aLb, d.C0277d.cp_bg_line_e);
            al.j(this.cAc, d.C0277d.cp_btn_a);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.fHh != null && this.fHh.getVisibility() == 0) {
            this.fHh.onChangeSkinType(i);
        }
        if (this.fHj != null && this.fHj.getVisibility() == 0) {
            this.fHj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.ehO = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqt || view == this.ehJ) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAb) {
            if (this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null) {
                z = this.ehO.cZz.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(getView());
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQp();
        }
    }

    private void aQp() {
        if (this.ehO != null && this.ehO.cZz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehO.cZz);
            videoItemData.mRecomExtra = this.ehO.getExtra();
            videoItemData.mRecomAbTag = this.ehO.aQQ();
            videoItemData.mRecomSource = this.ehO.getSource();
            videoItemData.mRecomWeight = this.ehO.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.ehO.WU(), "concern_tab")));
        }
    }

    private void bI(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQq() {
        if (this.ehO != null && this.ehO.cZz != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehO.cZz);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAd.getX() + this.fHn.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAd.getY() + this.fHn.getY());
            videoCardViewInfo.cardViewWidth = this.cAd.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAd.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.ehO.cZz.getTid(), n.YE(), this.ehO.WU(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aQr() {
        return this.ehO.elI && !this.ehO.elQ;
    }

    private void bz(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (this.ehO != null && this.ehO.cZz != null) {
            if (!aQr()) {
                n.tA(this.ehO.cZz.getId());
                n.a(this.mTextTitle, this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehO.cZz, null, n.YE(), 18003, true, false, false).addLocateParam(this.ehO.WU());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.ehO.cZz.getFid()));
            addLocateParam.setForumName(this.ehO.cZz.YW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehJ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void blB() {
        if (this.fHh == null) {
            this.fHh = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void blC() {
        if (this.fHj == null) {
            this.fHj = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.fHj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.ehO);
                }
                if (c.this.ehO != null && c.this.ehO.cZz != null) {
                    n.tA(c.this.ehO.cZz.getId());
                    c.this.blA();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.ehO == null || this.ehO.cZz == null || this.ehO.cZz.YR() == null || this.ehO.cZz.Zi() == null) {
            this.dqt.setVisibility(8);
            return;
        }
        this.dqt.setVisibility(0);
        if (this.ehO.aQU()) {
            blC();
            this.fHk = this.fHj;
            this.fHj.setVisibility(0);
            if (this.fHh != null) {
                this.fHh.setVisibility(8);
            }
        } else {
            blB();
            this.fHk = this.fHh;
            this.fHh.setVisibility(0);
            if (this.fHj != null) {
                this.fHj.setVisibility(8);
            }
        }
        aQv();
        if (!aQr() && n.tB(this.ehO.cZz.getId())) {
            n.a(this.mTextTitle, this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehJ.getGodReplyContent(), this.ehO.WR().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehO.WR().ZH();
        SpannableStringBuilder Zx = this.ehO.WR().Zx();
        if (this.ehO.WR().ZE() && !StringUtils.isNull(this.ehO.WR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehO.WR().getTid();
            Zx.append((CharSequence) this.ehO.WR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(Zx));
        this.mTextTitle.setText(Zx);
        if (this.fHk.getHeaderImg() != null) {
            this.fHk.getHeaderImg().setAfterClickListener(this.eia);
            if (this.fHk.getIsSimpleThread()) {
                this.fHk.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (this.ehO.WR() == null || this.ehO.WR().YR() == null || this.ehO.WR().YR().getPendantData() == null || StringUtils.isNull(this.ehO.WR().YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.fHk.getHeaderImg().setVisibility(0);
                this.fHk.getHeaderImg().setData(this.ehO.WR(), !this.ehO.aQU());
            } else {
                this.fHk.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(this.ehO.WR());
            }
        }
        this.fHk.setData(this.ehO.cZz);
        this.fHk.setUserAfterClickListener(this.ehZ);
        this.cAc.setText(ap.hz(this.ehO.cZz.Zi().video_duration.intValue() * 1000));
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehO.cZz.Zi().play_count.intValue())));
        this.ehJ.setData(this.ehO.WR().aap());
        this.ehJ.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tB(this.ehO.cZz.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        mF(lt(1));
        if (this.ehO == null || this.ehO.cZz == null || this.ehO.cZz.Zi() == null) {
            z = false;
        } else if (this.ehO.cZz.Zi().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.ehV.setVisibility(0);
        } else {
            this.ehV.setVisibility(8);
        }
    }

    private void aQv() {
        if (this.cAd != null && this.cAb != null) {
            if (i.Wy().WC() && this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null) {
                this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAd.startLoad(this.ehO.cZz.Zi().thumbnail_url, 10, false);
                this.cAb.setVisibility(0);
                return;
            }
            this.cAb.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fHk != null) {
            this.fHk.setPageUniqueId(bdUniqueId);
        }
        if (this.cAd != null) {
            this.cAd.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blA() {
        if (this.ehO != null && this.ehO.cZz != null) {
            n.a(this.mTextTitle, this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehJ.getGodReplyContent(), this.ehO.WR().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHk != null) {
            return this.fHk.getHeaderImg();
        }
        return null;
    }

    public View aQm() {
        if (this.fHk != null) {
            return this.fHk.getUserName();
        }
        return null;
    }

    public void mF(int i) {
        if (this.ehO != null && this.ehO.cZz != null) {
            if (!this.ehO.aQU() && i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setStType(n.YE());
                this.drk.setData(this.ehO.cZz);
                this.fHk.dN(false);
                return;
            }
            this.dqv.setData(this.ehO.cZz);
            this.dqv.setStType(n.YE());
            this.drk.setVisibility(8);
            this.fHk.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAd.setOnDrawListener(null);
        }
    }
}

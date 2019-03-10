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
    private String Yz;
    private View aLa;
    private final View.OnClickListener bRy;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAm;
    private TbImageView.a cAo;
    private RelativeLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private ThreadGodReplyLayout ehN;
    private HeadPendantClickableView ehO;
    private LinearLayout ehQ;
    private l ehS;
    private TextView ehZ;
    private final View.OnClickListener eid;
    private final View.OnClickListener eie;
    public ConcernThreadUserInfoLayout fHi;
    public ConcernForumThreadUserInfoLayout fHk;
    public com.baidu.tbadk.core.view.d fHl;
    private LinearLayout fHo;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAg != null) {
                    c.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eid = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.ehS);
                }
            }
        };
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.ehS);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ehS != null) {
                    if (c.this.aQi() != null) {
                        c.this.aQi().a(view, c.this.ehS);
                    }
                    if (c.this.ehS.cZD != null && view != c.this.dro.bSP) {
                        n.tC(c.this.ehS.cZD.getId());
                        c.this.blB();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.dqx = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehO = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.ehO.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.fHo = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.setShareReportFrom(4);
        this.dqz.setForumAfterClickListener(this.bRy);
        this.dqz.bSG = this.currentPageType;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTy.bSG = this.currentPageType;
        this.dro.setForumAfterClickListener(this.bRy);
        this.dqx.setOnClickListener(this);
        this.cAe = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAe.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAe.setLayoutParams(layoutParams2);
        this.cAg = (TbImageView) view.findViewById(d.g.image_video);
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAg.setGifIconSupport(false);
        this.cAg.setEvent(this.cAo);
        this.cAg.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAg;
        TbImageView tbImageView2 = this.cAg;
        tbImageView.setConrers(15);
        this.cAg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAg.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.cAh = (ImageView) view.findViewById(d.g.image_video_play);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehQ = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aLa = view.findViewById(d.g.divider_line);
        this.ehN = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehN.setOnClickListener(this);
        this.ehZ = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqx, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
            al.k(this.aLa, d.C0236d.cp_bg_line_e);
            al.j(this.cAf, d.C0236d.cp_btn_a);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            this.mSkinType = i;
        }
        if (this.fHi != null && this.fHi.getVisibility() == 0) {
            this.fHi.onChangeSkinType(i);
        }
        if (this.fHk != null && this.fHk.getVisibility() == 0) {
            this.fHk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.ehS = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqx || view == this.ehN) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAe) {
            if (this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null) {
                z = this.ehS.cZD.Zi().is_vertical.intValue() == 1;
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
        if (aQi() != null) {
            aQi().a(view, this.ehS);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQq() {
        if (this.ehS != null && this.ehS.cZD != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehS.cZD);
            videoItemData.mRecomExtra = this.ehS.getExtra();
            videoItemData.mRecomAbTag = this.ehS.aQR();
            videoItemData.mRecomSource = this.ehS.getSource();
            videoItemData.mRecomWeight = this.ehS.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.ehS.WU(), "concern_tab")));
        }
    }

    private void bI(View view) {
        if (aQi() != null) {
            aQi().a(view, this.ehS);
        }
        if (!j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQr();
        }
    }

    private void aQr() {
        if (this.ehS != null && this.ehS.cZD != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehS.cZD);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAg.getX() + this.fHo.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAg.getY() + this.fHo.getY());
            videoCardViewInfo.cardViewWidth = this.cAg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.ehS.cZD.getTid(), n.YE(), this.ehS.WU(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aQs() {
        return this.ehS.elM && !this.ehS.elU;
    }

    private void bz(View view) {
        if (aQi() != null) {
            aQi().a(view, this.ehS);
        }
        if (this.ehS != null && this.ehS.cZD != null) {
            if (!aQs()) {
                n.tC(this.ehS.cZD.getId());
                n.a(this.mTextTitle, this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehS.cZD, null, n.YE(), 18003, true, false, false).addLocateParam(this.ehS.WU());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.ehS.cZD.getFid()));
            addLocateParam.setForumName(this.ehS.cZD.YW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehN) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void blC() {
        if (this.fHi == null) {
            this.fHi = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void blD() {
        if (this.fHk == null) {
            this.fHk = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.fHk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.ehS);
                }
                if (c.this.ehS != null && c.this.ehS.cZD != null) {
                    n.tC(c.this.ehS.cZD.getId());
                    c.this.blB();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.ehS == null || this.ehS.cZD == null || this.ehS.cZD.YR() == null || this.ehS.cZD.Zi() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        if (this.ehS.aQV()) {
            blD();
            this.fHl = this.fHk;
            this.fHk.setVisibility(0);
            if (this.fHi != null) {
                this.fHi.setVisibility(8);
            }
        } else {
            blC();
            this.fHl = this.fHi;
            this.fHi.setVisibility(0);
            if (this.fHk != null) {
                this.fHk.setVisibility(8);
            }
        }
        aQw();
        if (!aQs() && n.tD(this.ehS.cZD.getId())) {
            n.a(this.mTextTitle, this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.ehN.getGodReplyContent(), this.ehS.WR().getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
        }
        this.ehS.WR().ZH();
        SpannableStringBuilder Zx = this.ehS.WR().Zx();
        if (this.ehS.WR().ZE() && !StringUtils.isNull(this.ehS.WR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehS.WR().getTid();
            Zx.append((CharSequence) this.ehS.WR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(Zx));
        this.mTextTitle.setText(Zx);
        if (this.fHl.getHeaderImg() != null) {
            this.fHl.getHeaderImg().setAfterClickListener(this.eie);
            if (this.fHl.getIsSimpleThread()) {
                this.fHl.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (this.ehS.WR() == null || this.ehS.WR().YR() == null || this.ehS.WR().YR().getPendantData() == null || StringUtils.isNull(this.ehS.WR().YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.fHl.getHeaderImg().setVisibility(0);
                this.fHl.getHeaderImg().setData(this.ehS.WR(), !this.ehS.aQV());
            } else {
                this.fHl.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(this.ehS.WR());
            }
        }
        this.fHl.setData(this.ehS.cZD);
        this.fHl.setUserAfterClickListener(this.eid);
        this.cAf.setText(ap.hz(this.ehS.cZD.Zi().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehS.cZD.Zi().play_count.intValue())));
        this.ehN.setData(this.ehS.WR().aap());
        this.ehN.onChangeSkinType();
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tD(this.ehS.cZD.getId())) {
            al.d(this.mTextTitle, d.C0236d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0236d.cp_cont_b, 1);
        }
        mF(lt(1));
        if (this.ehS == null || this.ehS.cZD == null || this.ehS.cZD.Zi() == null) {
            z = false;
        } else if (this.ehS.cZD.Zi().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.ehZ.setVisibility(0);
        } else {
            this.ehZ.setVisibility(8);
        }
    }

    private void aQw() {
        if (this.cAg != null && this.cAe != null) {
            if (i.Wy().WC() && this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null) {
                this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAg.startLoad(this.ehS.cZD.Zi().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                return;
            }
            this.cAe.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fHl != null) {
            this.fHl.setPageUniqueId(bdUniqueId);
        }
        if (this.cAg != null) {
            this.cAg.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blB() {
        if (this.ehS != null && this.ehS.cZD != null) {
            n.a(this.mTextTitle, this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.ehN.getGodReplyContent(), this.ehS.WR().getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHl != null) {
            return this.fHl.getHeaderImg();
        }
        return null;
    }

    public View aQn() {
        if (this.fHl != null) {
            return this.fHl.getUserName();
        }
        return null;
    }

    public void mF(int i) {
        if (this.ehS != null && this.ehS.cZD != null) {
            if (!this.ehS.aQV() && i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(n.YE());
                this.dro.setData(this.ehS.cZD);
                this.fHl.dN(false);
                return;
            }
            this.dqz.setData(this.ehS.cZD);
            this.dqz.setStType(n.YE());
            this.dro.setVisibility(8);
            this.fHl.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awl().ak(this.Yz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAg.setOnDrawListener(null);
        }
    }
}

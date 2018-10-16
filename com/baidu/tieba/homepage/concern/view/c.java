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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aEh;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    private RelativeLayout bWd;
    public ThreadCommentAndPraiseInfoLayout bWf;
    public FrameLayout bkB;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private TextView bkK;
    private TbImageView.a bkM;
    private ThreadGodReplyLayout cKD;
    private LinearLayout cMM;
    private l cMO;
    private TextView cMV;
    private final View.OnClickListener cMY;
    private final View.OnClickListener cMZ;
    public ConcernThreadUserInfoLayout eiW;
    public ConcernForumThreadUserInfoLayout eiY;
    public com.baidu.tbadk.core.view.f eiZ;
    private LinearLayout ejc;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.bkD != null) {
                    c.this.bkD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cMY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anO() != null) {
                    c.this.anO().a(view, c.this.cMO);
                }
            }
        };
        this.cMZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anO() != null) {
                    c.this.anO().a(view, c.this.cMO);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cMO != null) {
                    if (c.this.anO() != null) {
                        c.this.anO().a(view, c.this.cMO);
                    }
                    if (c.this.cMO.bIj != null && view != c.this.bWS.aFR) {
                        o.md(c.this.cMO.bIj.getId());
                        c.this.anT();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bWd = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bWP = (HeadPendantClickableView) this.bWd.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.ds70));
        }
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ejc = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setFrom(9);
        this.bWf.setDisPraiseFrom(4);
        this.bWf.setShareReportFrom(4);
        this.bWf.setForumAfterClickListener(this.aEh);
        this.bWf.ary = this.currentPageType;
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this);
        this.bWS.setShareReportFrom(4);
        this.bWS.setFrom(9);
        this.bWS.aFS.ary = this.currentPageType;
        this.bWS.setForumAfterClickListener(this.aEh);
        this.bWd.setOnClickListener(this);
        this.bkB = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bkB.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bkB.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bkB.setLayoutParams(layoutParams2);
        this.bkD = (TbImageView) view.findViewById(e.g.image_video);
        this.bkD.setDefaultErrorResource(0);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setGifIconSupport(false);
        this.bkD.setEvent(this.bkM);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bkC = (TextView) view.findViewById(e.g.text_video_duration);
        this.cMM = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bkK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cKD.setOnClickListener(this);
        this.cMV = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWd, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            this.bWf.onChangeSkinType();
            this.bWS.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.bkK, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.eiW != null && this.eiW.getVisibility() == 0) {
            this.eiW.onChangeSkinType(i);
        }
        if (this.eiY != null && this.eiY.getVisibility() == 0) {
            this.eiY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cMO = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bWd || view == this.cKD) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bkB) {
            if (this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null) {
                z = this.cMO.bIj.yN().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(getView());
            } else {
                aA(getView());
            }
        }
    }

    private void ay(View view) {
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (!j.kX()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anY();
        }
    }

    private void anY() {
        if (this.cMO != null && this.cMO.bIj != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cMO.bIj);
            videoItemData.mRecomExtra = this.cMO.getExtra();
            videoItemData.mRecomAbTag = this.cMO.aoA();
            videoItemData.mRecomSource = this.cMO.getSource();
            videoItemData.mRecomWeight = this.cMO.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cMO.aoz(), "concern_tab")));
        }
    }

    private void aL(View view) {
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (!j.kX()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anZ();
        }
    }

    private void anZ() {
        if (this.cMO != null && this.cMO.bIj != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cMO.bIj);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bkD.getX() + this.ejc.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bkD.getY() + this.ejc.getY());
            videoCardViewInfo.cardViewWidth = this.bkD.getWidth();
            videoCardViewInfo.cardViewHeight = this.bkD.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cMO.bIj.getTid(), o.yj(), this.cMO.aoz(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean anS() {
        return this.cMO.cQt && !this.cMO.cQC;
    }

    private void aA(View view) {
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (this.cMO != null && this.cMO.bIj != null) {
            if (!anS()) {
                o.md(this.cMO.bIj.getId());
                o.a(this.mTextTitle, this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cMO.bIj, null, o.yj(), 18003, true, false, false).addLocateParam(this.cMO.aoz());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cMO.bIj.getFid()));
            addLocateParam.setForumName(this.cMO.bIj.yB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cKD) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aIW() {
        if (this.eiW == null) {
            this.eiW = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aIX() {
        if (this.eiY == null) {
            this.eiY = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.eiY.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anO() != null) {
                    c.this.anO().a(view, c.this.cMO);
                }
                if (c.this.cMO != null && c.this.cMO.bIj != null) {
                    o.md(c.this.cMO.bIj.getId());
                    c.this.anT();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cMO == null || this.cMO.bIj == null || this.cMO.bIj.yv() == null || this.cMO.bIj.yN() == null) {
            this.bWd.setVisibility(8);
            return;
        }
        this.bWd.setVisibility(0);
        if (this.cMO.aoE()) {
            aIX();
            this.eiZ = this.eiY;
            this.eiY.setVisibility(0);
            if (this.eiW != null) {
                this.eiW.setVisibility(8);
            }
        } else {
            aIW();
            this.eiZ = this.eiW;
            this.eiW.setVisibility(0);
            if (this.eiY != null) {
                this.eiY.setVisibility(8);
            }
        }
        aoc();
        if (!anS() && o.me(this.cMO.bIj.getId())) {
            o.a(this.mTextTitle, this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.cMO.YA().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cMO.YA().zf();
        SpannableStringBuilder yV = this.cMO.YA().yV();
        if (this.cMO.YA().zc() && !StringUtils.isNull(this.cMO.YA().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cMO.YA().getTid();
            yV.append((CharSequence) this.cMO.YA().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(yV));
        this.mTextTitle.setText(yV);
        if (this.eiZ.getHeaderImg() != null) {
            this.eiZ.getHeaderImg().setAfterClickListener(this.cMZ);
            if (this.eiZ.getIsSimpleThread()) {
                this.eiZ.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (this.cMO.YA() == null || this.cMO.YA().yv() == null || this.cMO.YA().yv().getPendantData() == null || StringUtils.isNull(this.cMO.YA().yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.eiZ.getHeaderImg().setVisibility(0);
                this.eiZ.getHeaderImg().setData(this.cMO.YA(), !this.cMO.aoE());
            } else {
                this.eiZ.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(this.cMO.YA());
            }
        }
        this.eiZ.setData(this.cMO.bIj);
        this.eiZ.setUserAfterClickListener(this.cMY);
        this.bkC.setText(ao.dt(this.cMO.bIj.yN().video_duration.intValue() * 1000));
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.N(this.cMO.bIj.yN().play_count.intValue())));
        this.cKD.setData(this.cMO.YA().zM());
        this.cKD.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.me(this.cMO.bIj.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        ik(hb(1));
        if (this.cMO == null || this.cMO.bIj == null || this.cMO.bIj.yN() == null) {
            z = false;
        } else if (this.cMO.bIj.yN().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cMV.setVisibility(0);
        } else {
            this.cMV.setVisibility(8);
        }
    }

    private void aoc() {
        if (this.bkD != null && this.bkB != null) {
            if (i.ws().ww() && this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null) {
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(this.cMO.bIj.yN().thumbnail_url, 10, false);
                this.bkB.setVisibility(0);
                return;
            }
            this.bkB.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eiZ != null) {
            this.eiZ.setPageUniqueId(bdUniqueId);
        }
        if (this.bkD != null) {
            this.bkD.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        if (this.cMO != null && this.cMO.bIj != null) {
            o.a(this.mTextTitle, this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.cMO.YA().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eiZ != null) {
            return this.eiZ.getHeaderImg();
        }
        return null;
    }

    public View anR() {
        if (this.eiZ != null) {
            return this.eiZ.getUserName();
        }
        return null;
    }

    public void ik(int i) {
        if (this.cMO != null && this.cMO.bIj != null) {
            if (!this.cMO.aoE() && i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setStType(o.yj());
                this.bWS.setData(this.cMO.bIj);
                this.eiZ.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.cMO.bIj);
            this.bWf.setStType(o.yj());
            this.bWS.setVisibility(8);
            this.eiZ.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bkD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bkD.setOnDrawListener(null);
        }
    }
}

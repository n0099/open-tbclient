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
    private final View.OnClickListener aJb;
    public FrameLayout bpC;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private TextView bpL;
    private TbImageView.a bpN;
    private ThreadGodReplyLayout cVS;
    private LinearLayout cYb;
    private l cYd;
    private TextView cYk;
    private final View.OnClickListener cYn;
    private final View.OnClickListener cYo;
    private String cbl;
    private RelativeLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    public ConcernThreadUserInfoLayout euK;
    public ConcernForumThreadUserInfoLayout euM;
    public com.baidu.tbadk.core.view.f euN;
    private LinearLayout euQ;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bpE != null) {
                    c.this.bpE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYd);
                }
            }
        };
        this.cYo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYd);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cYd != null) {
                    if (c.this.aqp() != null) {
                        c.this.aqp().a(view, c.this.cYd);
                    }
                    if (c.this.cYd.bNA != null && view != c.this.ccl.aKM) {
                        o.mW(c.this.cYd.bNA.getId());
                        c.this.aqu();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.cbw = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cci = (HeadPendantClickableView) this.cbw.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.euQ = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setIsBarViewVisible(false);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setFrom(9);
        this.cby.setDisPraiseFrom(4);
        this.cby.setShareReportFrom(4);
        this.cby.setForumAfterClickListener(this.aJb);
        this.cby.awp = this.currentPageType;
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this);
        this.ccl.setShareReportFrom(4);
        this.ccl.setFrom(9);
        this.ccl.aKN.awp = this.currentPageType;
        this.ccl.setForumAfterClickListener(this.aJb);
        this.cbw.setOnClickListener(this);
        this.bpC = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bpC.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bpC.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bpC.setLayoutParams(layoutParams2);
        this.bpE = (TbImageView) view.findViewById(e.g.image_video);
        this.bpE.setDefaultErrorResource(0);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setGifIconSupport(false);
        this.bpE.setEvent(this.bpN);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpD = (TextView) view.findViewById(e.g.text_video_duration);
        this.cYb = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bpL = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVS.setOnClickListener(this);
        this.cYk = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbw, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            this.cby.onChangeSkinType();
            this.ccl.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.bpL, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.euK != null && this.euK.getVisibility() == 0) {
            this.euK.onChangeSkinType(i);
        }
        if (this.euM != null && this.euM.getVisibility() == 0) {
            this.euM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cYd = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.cbw || view == this.cVS) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpC) {
            if (this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null) {
                z = this.cYd.bNA.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aQ(getView());
            } else {
                aF(getView());
            }
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.cYd != null && this.cYd.bNA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cYd.bNA);
            videoItemData.mRecomExtra = this.cYd.getExtra();
            videoItemData.mRecomAbTag = this.cYd.arb();
            videoItemData.mRecomSource = this.cYd.getSource();
            videoItemData.mRecomWeight = this.cYd.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cYd.ara(), "concern_tab")));
        }
    }

    private void aQ(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqA() {
        if (this.cYd != null && this.cYd.bNA != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cYd.bNA);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bpE.getX() + this.euQ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bpE.getY() + this.euQ.getY());
            videoCardViewInfo.cardViewWidth = this.bpE.getWidth();
            videoCardViewInfo.cardViewHeight = this.bpE.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cYd.bNA.getTid(), o.zH(), this.cYd.ara(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aqt() {
        return this.cYd.dbK && !this.cYd.dbU;
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (this.cYd != null && this.cYd.bNA != null) {
            if (!aqt()) {
                o.mW(this.cYd.bNA.getId());
                o.a(this.mTextTitle, this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cYd.bNA, null, o.zH(), 18003, true, false, false).addLocateParam(this.cYd.ara());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cYd.bNA.getFid()));
            addLocateParam.setForumName(this.cYd.bNA.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVS) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aLy() {
        if (this.euK == null) {
            this.euK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aLz() {
        if (this.euM == null) {
            this.euM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.euM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYd);
                }
                if (c.this.cYd != null && c.this.cYd.bNA != null) {
                    o.mW(c.this.cYd.bNA.getId());
                    c.this.aqu();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cYd == null || this.cYd.bNA == null || this.cYd.bNA.zT() == null || this.cYd.bNA.Al() == null) {
            this.cbw.setVisibility(8);
            return;
        }
        this.cbw.setVisibility(0);
        if (this.cYd.arf()) {
            aLz();
            this.euN = this.euM;
            this.euM.setVisibility(0);
            if (this.euK != null) {
                this.euK.setVisibility(8);
            }
        } else {
            aLy();
            this.euN = this.euK;
            this.euK.setVisibility(0);
            if (this.euM != null) {
                this.euM.setVisibility(8);
            }
        }
        aqD();
        if (!aqt() && o.mX(this.cYd.bNA.getId())) {
            o.a(this.mTextTitle, this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.cYd.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cYd.aaq().AD();
        SpannableStringBuilder At = this.cYd.aaq().At();
        if (this.cYd.aaq().AA() && !StringUtils.isNull(this.cYd.aaq().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cYd.aaq().getTid();
            At.append((CharSequence) this.cYd.aaq().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(At));
        this.mTextTitle.setText(At);
        if (this.euN.getHeaderImg() != null) {
            this.euN.getHeaderImg().setAfterClickListener(this.cYo);
            if (this.euN.getIsSimpleThread()) {
                this.euN.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (this.cYd.aaq() == null || this.cYd.aaq().zT() == null || this.cYd.aaq().zT().getPendantData() == null || StringUtils.isNull(this.cYd.aaq().zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.euN.getHeaderImg().setVisibility(0);
                this.euN.getHeaderImg().setData(this.cYd.aaq(), !this.cYd.arf());
            } else {
                this.euN.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(this.cYd.aaq());
            }
        }
        this.euN.setData(this.cYd.bNA);
        this.euN.setUserAfterClickListener(this.cYn);
        this.bpD.setText(ao.dV(this.cYd.bNA.Al().video_duration.intValue() * 1000));
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cYd.bNA.Al().play_count.intValue())));
        this.cVS.setData(this.cYd.aaq().Bk());
        this.cVS.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cYd.bNA.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        iM(hD(1));
        if (this.cYd == null || this.cYd.bNA == null || this.cYd.bNA.Al() == null) {
            z = false;
        } else if (this.cYd.bNA.Al().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cYk.setVisibility(0);
        } else {
            this.cYk.setVisibility(8);
        }
    }

    private void aqD() {
        if (this.bpE != null && this.bpC != null) {
            if (i.xR().xV() && this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null) {
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(this.cYd.bNA.Al().thumbnail_url, 10, false);
                this.bpC.setVisibility(0);
                return;
            }
            this.bpC.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euN != null) {
            this.euN.setPageUniqueId(bdUniqueId);
        }
        if (this.bpE != null) {
            this.bpE.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (this.cYd != null && this.cYd.bNA != null) {
            o.a(this.mTextTitle, this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.cYd.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euN != null) {
            return this.euN.getHeaderImg();
        }
        return null;
    }

    public View aqs() {
        if (this.euN != null) {
            return this.euN.getUserName();
        }
        return null;
    }

    public void iM(int i) {
        if (this.cYd != null && this.cYd.bNA != null) {
            if (!this.cYd.arf() && i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setStType(o.zH());
                this.ccl.setData(this.cYd.bNA);
                this.euN.showForumNameView(false);
                return;
            }
            this.cby.setData(this.cYd.bNA);
            this.cby.setStType(o.zH());
            this.ccl.setVisibility(8);
            this.euN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpE.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpE.setOnDrawListener(null);
        }
    }
}

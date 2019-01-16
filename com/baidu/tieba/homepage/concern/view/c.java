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
    private final View.OnClickListener aJa;
    public FrameLayout bpB;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private TextView bpK;
    private TbImageView.a bpM;
    private ThreadGodReplyLayout cVR;
    private LinearLayout cYa;
    private l cYc;
    private TextView cYj;
    private final View.OnClickListener cYm;
    private final View.OnClickListener cYn;
    private String cbk;
    private RelativeLayout cbv;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    public ConcernThreadUserInfoLayout euJ;
    public ConcernForumThreadUserInfoLayout euL;
    public com.baidu.tbadk.core.view.f euM;
    private LinearLayout euP;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bpD != null) {
                    c.this.bpD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cYm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYc);
                }
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYc);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cYc != null) {
                    if (c.this.aqp() != null) {
                        c.this.aqp().a(view, c.this.cYc);
                    }
                    if (c.this.cYc.bNz != null && view != c.this.cck.aKL) {
                        o.mW(c.this.cYc.bNz.getId());
                        c.this.aqu();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.cbv = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cch = (HeadPendantClickableView) this.cbv.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.euP = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setFrom(9);
        this.cbx.setDisPraiseFrom(4);
        this.cbx.setShareReportFrom(4);
        this.cbx.setForumAfterClickListener(this.aJa);
        this.cbx.awo = this.currentPageType;
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this);
        this.cck.setShareReportFrom(4);
        this.cck.setFrom(9);
        this.cck.aKM.awo = this.currentPageType;
        this.cck.setForumAfterClickListener(this.aJa);
        this.cbv.setOnClickListener(this);
        this.bpB = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bpB.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bpB.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bpB.setLayoutParams(layoutParams2);
        this.bpD = (TbImageView) view.findViewById(e.g.image_video);
        this.bpD.setDefaultErrorResource(0);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setGifIconSupport(false);
        this.bpD.setEvent(this.bpM);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpC = (TextView) view.findViewById(e.g.text_video_duration);
        this.cYa = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bpK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVR.setOnClickListener(this);
        this.cYj = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbv, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            this.cbx.onChangeSkinType();
            this.cck.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.bpK, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.euJ != null && this.euJ.getVisibility() == 0) {
            this.euJ.onChangeSkinType(i);
        }
        if (this.euL != null && this.euL.getVisibility() == 0) {
            this.euL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cYc = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.cbv || view == this.cVR) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpB) {
            if (this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null) {
                z = this.cYc.bNz.Al().is_vertical.intValue() == 1;
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
            aqp().a(view, this.cYc);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.cYc != null && this.cYc.bNz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cYc.bNz);
            videoItemData.mRecomExtra = this.cYc.getExtra();
            videoItemData.mRecomAbTag = this.cYc.arb();
            videoItemData.mRecomSource = this.cYc.getSource();
            videoItemData.mRecomWeight = this.cYc.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cYc.ara(), "concern_tab")));
        }
    }

    private void aQ(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYc);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqA() {
        if (this.cYc != null && this.cYc.bNz != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cYc.bNz);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bpD.getX() + this.euP.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bpD.getY() + this.euP.getY());
            videoCardViewInfo.cardViewWidth = this.bpD.getWidth();
            videoCardViewInfo.cardViewHeight = this.bpD.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cYc.bNz.getTid(), o.zH(), this.cYc.ara(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aqt() {
        return this.cYc.dbJ && !this.cYc.dbT;
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYc);
        }
        if (this.cYc != null && this.cYc.bNz != null) {
            if (!aqt()) {
                o.mW(this.cYc.bNz.getId());
                o.a(this.mTextTitle, this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cYc.bNz, null, o.zH(), 18003, true, false, false).addLocateParam(this.cYc.ara());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cYc.bNz.getFid()));
            addLocateParam.setForumName(this.cYc.bNz.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVR) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aLy() {
        if (this.euJ == null) {
            this.euJ = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aLz() {
        if (this.euL == null) {
            this.euL = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.euL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cYc);
                }
                if (c.this.cYc != null && c.this.cYc.bNz != null) {
                    o.mW(c.this.cYc.bNz.getId());
                    c.this.aqu();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cYc == null || this.cYc.bNz == null || this.cYc.bNz.zT() == null || this.cYc.bNz.Al() == null) {
            this.cbv.setVisibility(8);
            return;
        }
        this.cbv.setVisibility(0);
        if (this.cYc.arf()) {
            aLz();
            this.euM = this.euL;
            this.euL.setVisibility(0);
            if (this.euJ != null) {
                this.euJ.setVisibility(8);
            }
        } else {
            aLy();
            this.euM = this.euJ;
            this.euJ.setVisibility(0);
            if (this.euL != null) {
                this.euL.setVisibility(8);
            }
        }
        aqD();
        if (!aqt() && o.mX(this.cYc.bNz.getId())) {
            o.a(this.mTextTitle, this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.cYc.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cYc.aaq().AD();
        SpannableStringBuilder At = this.cYc.aaq().At();
        if (this.cYc.aaq().AA() && !StringUtils.isNull(this.cYc.aaq().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cYc.aaq().getTid();
            At.append((CharSequence) this.cYc.aaq().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
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
        if (this.euM.getHeaderImg() != null) {
            this.euM.getHeaderImg().setAfterClickListener(this.cYn);
            if (this.euM.getIsSimpleThread()) {
                this.euM.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (this.cYc.aaq() == null || this.cYc.aaq().zT() == null || this.cYc.aaq().zT().getPendantData() == null || StringUtils.isNull(this.cYc.aaq().zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.euM.getHeaderImg().setVisibility(0);
                this.euM.getHeaderImg().setData(this.cYc.aaq(), !this.cYc.arf());
            } else {
                this.euM.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(this.cYc.aaq());
            }
        }
        this.euM.setData(this.cYc.bNz);
        this.euM.setUserAfterClickListener(this.cYm);
        this.bpC.setText(ao.dV(this.cYc.bNz.Al().video_duration.intValue() * 1000));
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cYc.bNz.Al().play_count.intValue())));
        this.cVR.setData(this.cYc.aaq().Bk());
        this.cVR.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cYc.bNz.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        iM(hD(1));
        if (this.cYc == null || this.cYc.bNz == null || this.cYc.bNz.Al() == null) {
            z = false;
        } else if (this.cYc.bNz.Al().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cYj.setVisibility(0);
        } else {
            this.cYj.setVisibility(8);
        }
    }

    private void aqD() {
        if (this.bpD != null && this.bpB != null) {
            if (i.xR().xV() && this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null) {
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(this.cYc.bNz.Al().thumbnail_url, 10, false);
                this.bpB.setVisibility(0);
                return;
            }
            this.bpB.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euM != null) {
            this.euM.setPageUniqueId(bdUniqueId);
        }
        if (this.bpD != null) {
            this.bpD.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (this.cYc != null && this.cYc.bNz != null) {
            o.a(this.mTextTitle, this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.cYc.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euM != null) {
            return this.euM.getHeaderImg();
        }
        return null;
    }

    public View aqs() {
        if (this.euM != null) {
            return this.euM.getUserName();
        }
        return null;
    }

    public void iM(int i) {
        if (this.cYc != null && this.cYc.bNz != null) {
            if (!this.cYc.arf() && i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setStType(o.zH());
                this.cck.setData(this.cYc.bNz);
                this.euM.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.cYc.bNz);
            this.cbx.setStType(o.zH());
            this.cck.setVisibility(8);
            this.euM.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpD.setOnDrawListener(null);
        }
    }
}

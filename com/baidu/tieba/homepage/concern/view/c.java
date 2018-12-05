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
    private final View.OnClickListener aIx;
    public FrameLayout boK;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private TextView boT;
    private TbImageView.a boV;
    private ThreadGodReplyLayout cSq;
    private l cUB;
    private TextView cUI;
    private final View.OnClickListener cUL;
    private final View.OnClickListener cUM;
    private LinearLayout cUz;
    private RelativeLayout caH;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    public ConcernThreadUserInfoLayout erl;
    public ConcernForumThreadUserInfoLayout ern;
    public com.baidu.tbadk.core.view.f ero;
    private LinearLayout ers;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.boM != null) {
                    c.this.boM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.cUB);
                }
            }
        };
        this.cUM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.cUB);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cUB != null) {
                    if (c.this.apc() != null) {
                        c.this.apc().a(view, c.this.cUB);
                    }
                    if (c.this.cUB.bMJ != null && view != c.this.cbw.aKh) {
                        o.mD(c.this.cUB.bMJ.getId());
                        c.this.aph();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.caH = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cbt = (HeadPendantClickableView) this.caH.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ers = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setFrom(9);
        this.caJ.setDisPraiseFrom(4);
        this.caJ.setShareReportFrom(4);
        this.caJ.setForumAfterClickListener(this.aIx);
        this.caJ.avL = this.currentPageType;
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this);
        this.cbw.setShareReportFrom(4);
        this.cbw.setFrom(9);
        this.cbw.aKi.avL = this.currentPageType;
        this.cbw.setForumAfterClickListener(this.aIx);
        this.caH.setOnClickListener(this);
        this.boK = (FrameLayout) view.findViewById(e.g.frame_video);
        this.boK.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.boK.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.boK.setLayoutParams(layoutParams2);
        this.boM = (TbImageView) view.findViewById(e.g.image_video);
        this.boM.setDefaultErrorResource(0);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setGifIconSupport(false);
        this.boM.setEvent(this.boV);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.boL = (TextView) view.findViewById(e.g.text_video_duration);
        this.cUz = (LinearLayout) view.findViewById(e.g.duration_container);
        this.boT = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cSq.setOnClickListener(this);
        this.cUI = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caH, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            this.caJ.onChangeSkinType();
            this.cbw.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.boT, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.erl != null && this.erl.getVisibility() == 0) {
            this.erl.onChangeSkinType(i);
        }
        if (this.ern != null && this.ern.getVisibility() == 0) {
            this.ern.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cUB = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.caH || view == this.cSq) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boK) {
            if (this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null) {
                z = this.cUB.bMJ.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(getView());
            } else {
                aC(getView());
            }
        }
    }

    private void aA(View view) {
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apn();
        }
    }

    private void apn() {
        if (this.cUB != null && this.cUB.bMJ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cUB.bMJ);
            videoItemData.mRecomExtra = this.cUB.getExtra();
            videoItemData.mRecomAbTag = this.cUB.apP();
            videoItemData.mRecomSource = this.cUB.getSource();
            videoItemData.mRecomWeight = this.cUB.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cUB.apO(), "concern_tab")));
        }
    }

    private void aN(View view) {
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apo();
        }
    }

    private void apo() {
        if (this.cUB != null && this.cUB.bMJ != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cUB.bMJ);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.boM.getX() + this.ers.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.boM.getY() + this.ers.getY());
            videoCardViewInfo.cardViewWidth = this.boM.getWidth();
            videoCardViewInfo.cardViewHeight = this.boM.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cUB.bMJ.getTid(), o.zu(), this.cUB.apO(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean apg() {
        return this.cUB.cYg && !this.cUB.cYp;
    }

    private void aC(View view) {
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (this.cUB != null && this.cUB.bMJ != null) {
            if (!apg()) {
                o.mD(this.cUB.bMJ.getId());
                o.a(this.mTextTitle, this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cUB.bMJ, null, o.zu(), 18003, true, false, false).addLocateParam(this.cUB.apO());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cUB.bMJ.getFid()));
            addLocateParam.setForumName(this.cUB.bMJ.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSq) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aKl() {
        if (this.erl == null) {
            this.erl = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aKm() {
        if (this.ern == null) {
            this.ern = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.ern.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.cUB);
                }
                if (c.this.cUB != null && c.this.cUB.bMJ != null) {
                    o.mD(c.this.cUB.bMJ.getId());
                    c.this.aph();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cUB == null || this.cUB.bMJ == null || this.cUB.bMJ.zG() == null || this.cUB.bMJ.zY() == null) {
            this.caH.setVisibility(8);
            return;
        }
        this.caH.setVisibility(0);
        if (this.cUB.apT()) {
            aKm();
            this.ero = this.ern;
            this.ern.setVisibility(0);
            if (this.erl != null) {
                this.erl.setVisibility(8);
            }
        } else {
            aKl();
            this.ero = this.erl;
            this.erl.setVisibility(0);
            if (this.ern != null) {
                this.ern.setVisibility(8);
            }
        }
        apr();
        if (!apg() && o.mE(this.cUB.bMJ.getId())) {
            o.a(this.mTextTitle, this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.cUB.ZR().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cUB.ZR().Aq();
        SpannableStringBuilder Ag = this.cUB.ZR().Ag();
        if (this.cUB.ZR().An() && !StringUtils.isNull(this.cUB.ZR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cUB.ZR().getTid();
            Ag.append((CharSequence) this.cUB.ZR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(Ag));
        this.mTextTitle.setText(Ag);
        if (this.ero.getHeaderImg() != null) {
            this.ero.getHeaderImg().setAfterClickListener(this.cUM);
            if (this.ero.getIsSimpleThread()) {
                this.ero.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (this.cUB.ZR() == null || this.cUB.ZR().zG() == null || this.cUB.ZR().zG().getPendantData() == null || StringUtils.isNull(this.cUB.ZR().zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.ero.getHeaderImg().setVisibility(0);
                this.ero.getHeaderImg().setData(this.cUB.ZR(), !this.cUB.apT());
            } else {
                this.ero.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(this.cUB.ZR());
            }
        }
        this.ero.setData(this.cUB.bMJ);
        this.ero.setUserAfterClickListener(this.cUL);
        this.boL.setText(ao.dV(this.cUB.bMJ.zY().video_duration.intValue() * 1000));
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.W(this.cUB.bMJ.zY().play_count.intValue())));
        this.cSq.setData(this.cUB.ZR().AX());
        this.cSq.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mE(this.cUB.bMJ.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        iL(hC(1));
        if (this.cUB == null || this.cUB.bMJ == null || this.cUB.bMJ.zY() == null) {
            z = false;
        } else if (this.cUB.bMJ.zY().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cUI.setVisibility(0);
        } else {
            this.cUI.setVisibility(8);
        }
    }

    private void apr() {
        if (this.boM != null && this.boK != null) {
            if (i.xE().xI() && this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null) {
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(this.cUB.bMJ.zY().thumbnail_url, 10, false);
                this.boK.setVisibility(0);
                return;
            }
            this.boK.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ero != null) {
            this.ero.setPageUniqueId(bdUniqueId);
        }
        if (this.boM != null) {
            this.boM.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aph() {
        if (this.cUB != null && this.cUB.bMJ != null) {
            o.a(this.mTextTitle, this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.cUB.ZR().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ero != null) {
            return this.ero.getHeaderImg();
        }
        return null;
    }

    public View apf() {
        if (this.ero != null) {
            return this.ero.getUserName();
        }
        return null;
    }

    public void iL(int i) {
        if (this.cUB != null && this.cUB.bMJ != null) {
            if (!this.cUB.apT() && i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setStType(o.zu());
                this.cbw.setData(this.cUB.bMJ);
                this.ero.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.cUB.bMJ);
            this.caJ.setStType(o.zu());
            this.cbw.setVisibility(8);
            this.ero.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boM.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boM.setOnDrawListener(null);
        }
    }
}

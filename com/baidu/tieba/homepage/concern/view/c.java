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
    private final View.OnClickListener aIy;
    public FrameLayout boN;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private TextView boW;
    private TbImageView.a boY;
    private ThreadGodReplyLayout cVg;
    private final View.OnClickListener cXB;
    private final View.OnClickListener cXC;
    private LinearLayout cXp;
    private l cXr;
    private TextView cXy;
    private RelativeLayout caK;
    public ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    public ConcernThreadUserInfoLayout eud;
    public ConcernForumThreadUserInfoLayout euf;
    public com.baidu.tbadk.core.view.f eug;
    private LinearLayout euj;
    private TbPageContext<?> mContext;
    private View mDivider;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.boP != null) {
                    c.this.boP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cXB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.cXr);
                }
            }
        };
        this.cXC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.cXr);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cXr != null) {
                    if (c.this.apS() != null) {
                        c.this.apS().a(view, c.this.cXr);
                    }
                    if (c.this.cXr.bMM != null && view != c.this.cbz.aKj) {
                        o.mG(c.this.cXr.bMM.getId());
                        c.this.apX();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.caK = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cbw = (HeadPendantClickableView) this.caK.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.euj = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setIsBarViewVisible(false);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setFrom(9);
        this.caM.setDisPraiseFrom(4);
        this.caM.setShareReportFrom(4);
        this.caM.setForumAfterClickListener(this.aIy);
        this.caM.avM = this.currentPageType;
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_video_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this);
        this.cbz.setShareReportFrom(4);
        this.cbz.setFrom(9);
        this.cbz.aKk.avM = this.currentPageType;
        this.cbz.setForumAfterClickListener(this.aIy);
        this.caK.setOnClickListener(this);
        this.boN = (FrameLayout) view.findViewById(e.g.frame_video);
        this.boN.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.boN.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.boN.setLayoutParams(layoutParams2);
        this.boP = (TbImageView) view.findViewById(e.g.image_video);
        this.boP.setDefaultErrorResource(0);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setGifIconSupport(false);
        this.boP.setEvent(this.boY);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.boO = (TextView) view.findViewById(e.g.text_video_duration);
        this.cXp = (LinearLayout) view.findViewById(e.g.duration_container);
        this.boW = (TextView) view.findViewById(e.g.text_video_play_count);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVg.setOnClickListener(this);
        this.cXy = (TextView) view.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caK, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            this.caM.onChangeSkinType();
            this.cbz.onChangeSkinType();
            al.i(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.boW, e.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.eud != null && this.eud.getVisibility() == 0) {
            this.eud.onChangeSkinType(i);
        }
        if (this.euf != null && this.euf.getVisibility() == 0) {
            this.euf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cXr = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.caK || view == this.cVg) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boN) {
            if (this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null) {
                z = this.cXr.bMM.zY().is_vertical.intValue() == 1;
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
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqc();
        }
    }

    private void aqc() {
        if (this.cXr != null && this.cXr.bMM != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cXr.bMM);
            videoItemData.mRecomExtra = this.cXr.getExtra();
            videoItemData.mRecomAbTag = this.cXr.aqE();
            videoItemData.mRecomSource = this.cXr.getSource();
            videoItemData.mRecomWeight = this.cXr.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cXr.aqD(), "concern_tab")));
        }
    }

    private void aQ(View view) {
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (!j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqd();
        }
    }

    private void aqd() {
        if (this.cXr != null && this.cXr.bMM != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cXr.bMM);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.boP.getX() + this.euj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.boP.getY() + this.euj.getY());
            videoCardViewInfo.cardViewWidth = this.boP.getWidth();
            videoCardViewInfo.cardViewHeight = this.boP.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cXr.bMM.getTid(), o.zu(), this.cXr.aqD(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean apW() {
        return this.cXr.daY && !this.cXr.dbh;
    }

    private void aF(View view) {
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (this.cXr != null && this.cXr.bMM != null) {
            if (!apW()) {
                o.mG(this.cXr.bMM.getId());
                o.a(this.mTextTitle, this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cXr.bMM, null, o.zu(), 18003, true, false, false).addLocateParam(this.cXr.aqD());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cXr.bMM.getFid()));
            addLocateParam.setForumName(this.cXr.bMM.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVg) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aLa() {
        if (this.eud == null) {
            this.eud = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aLb() {
        if (this.euf == null) {
            this.euf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.euf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.cXr);
                }
                if (c.this.cXr != null && c.this.cXr.bMM != null) {
                    o.mG(c.this.cXr.bMM.getId());
                    c.this.apX();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cXr == null || this.cXr.bMM == null || this.cXr.bMM.zG() == null || this.cXr.bMM.zY() == null) {
            this.caK.setVisibility(8);
            return;
        }
        this.caK.setVisibility(0);
        if (this.cXr.aqI()) {
            aLb();
            this.eug = this.euf;
            this.euf.setVisibility(0);
            if (this.eud != null) {
                this.eud.setVisibility(8);
            }
        } else {
            aLa();
            this.eug = this.eud;
            this.eud.setVisibility(0);
            if (this.euf != null) {
                this.euf.setVisibility(8);
            }
        }
        aqg();
        if (!apW() && o.mH(this.cXr.bMM.getId())) {
            o.a(this.mTextTitle, this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.cXr.ZT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cXr.ZT().Aq();
        SpannableStringBuilder Ag = this.cXr.ZT().Ag();
        if (this.cXr.ZT().An() && !StringUtils.isNull(this.cXr.ZT().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cXr.ZT().getTid();
            Ag.append((CharSequence) this.cXr.ZT().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.3
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
        if (this.eug.getHeaderImg() != null) {
            this.eug.getHeaderImg().setAfterClickListener(this.cXC);
            if (this.eug.getIsSimpleThread()) {
                this.eug.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (this.cXr.ZT() == null || this.cXr.ZT().zG() == null || this.cXr.ZT().zG().getPendantData() == null || StringUtils.isNull(this.cXr.ZT().zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.eug.getHeaderImg().setVisibility(0);
                this.eug.getHeaderImg().setData(this.cXr.ZT(), !this.cXr.aqI());
            } else {
                this.eug.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(this.cXr.ZT());
            }
        }
        this.eug.setData(this.cXr.bMM);
        this.eug.setUserAfterClickListener(this.cXB);
        this.boO.setText(ao.dV(this.cXr.bMM.zY().video_duration.intValue() * 1000));
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cXr.bMM.zY().play_count.intValue())));
        this.cVg.setData(this.cXr.ZT().AX());
        this.cVg.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mH(this.cXr.bMM.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        iM(hD(1));
        if (this.cXr == null || this.cXr.bMM == null || this.cXr.bMM.zY() == null) {
            z = false;
        } else if (this.cXr.bMM.zY().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cXy.setVisibility(0);
        } else {
            this.cXy.setVisibility(8);
        }
    }

    private void aqg() {
        if (this.boP != null && this.boN != null) {
            if (i.xE().xI() && this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null) {
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(this.cXr.bMM.zY().thumbnail_url, 10, false);
                this.boN.setVisibility(0);
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eug != null) {
            this.eug.setPageUniqueId(bdUniqueId);
        }
        if (this.boP != null) {
            this.boP.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apX() {
        if (this.cXr != null && this.cXr.bMM != null) {
            o.a(this.mTextTitle, this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.cXr.ZT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eug != null) {
            return this.eug.getHeaderImg();
        }
        return null;
    }

    public View apV() {
        if (this.eug != null) {
            return this.eug.getUserName();
        }
        return null;
    }

    public void iM(int i) {
        if (this.cXr != null && this.cXr.bMM != null) {
            if (!this.cXr.aqI() && i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setStType(o.zu());
                this.cbz.setData(this.cXr.bMM);
                this.eug.showForumNameView(false);
                return;
            }
            this.caM.setData(this.cXr.bMM);
            this.caM.setStType(o.zu());
            this.cbz.setVisibility(8);
            this.eug.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boP.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.concern.view.c.7
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boP.setOnDrawListener(null);
        }
    }
}

package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axz;
    private String bHB;
    private RelativeLayout bHM;
    public ThreadCommentAndPraiseInfoLayout bHO;
    private View bHR;
    public ThreadSourceShareAndPraiseLayout bIC;
    private HeadPendantClickableView bIz;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private TextView bcZ;
    private TbImageView.a bdc;
    private ThreadGodReplyLayout cwv;
    private LinearLayout cyF;
    private l cyH;
    private TextView cyN;
    private final View.OnClickListener cyQ;
    private final View.OnClickListener cyR;
    public ConcernThreadUserInfoLayout dTP;
    public ConcernForumThreadUserInfoLayout dTR;
    public com.baidu.tbadk.core.view.c dTS;
    private LinearLayout dTV;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && c.this.bcS != null) {
                    c.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cyQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.cyH);
                }
            }
        };
        this.cyR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.cyH);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cyH != null) {
                    if (c.this.aiz() != null) {
                        c.this.aiz().a(view, c.this.cyH);
                    }
                    if (c.this.cyH.btJ != null && view != c.this.bIC.ayq) {
                        o.kW(c.this.cyH.btJ.getId());
                        c.this.aiE();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bHM = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dTV = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setFrom(9);
        this.bHO.setShareReportFrom(4);
        this.bHO.setForumAfterClickListener(this.axz);
        this.bHO.ajY = this.currentPageType;
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayr.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(this.axz);
        this.bHM.setOnClickListener(this);
        this.bcQ = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bcQ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcQ.setLayoutParams(layoutParams2);
        this.bcS = (TbImageView) view.findViewById(d.g.image_video);
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcR = (TextView) view.findViewById(d.g.text_video_duration);
        this.cyF = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bcZ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bHR = view.findViewById(d.g.divider_line);
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cwv.setOnClickListener(this);
        this.cyN = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bHM, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            this.bHO.onChangeSkinType();
            this.bIC.onChangeSkinType();
            am.i(this.bHR, d.C0140d.cp_bg_line_e);
            am.h(this.bcR, d.C0140d.cp_cont_i);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.dTP != null && this.dTP.getVisibility() == 0) {
            this.dTP.onChangeSkinType(i);
        }
        if (this.dTR != null && this.dTR.getVisibility() == 0) {
            this.dTR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cyH = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bHM || view == this.cwv) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcQ) {
            if (this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null) {
                z = this.cyH.btJ.vC().is_vertical.intValue() == 1;
            }
            if (z) {
                ak(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ax(getView());
            } else {
                am(getView());
            }
        }
    }

    private void ak(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (!j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aiJ();
        }
    }

    private void aiJ() {
        if (this.cyH != null && this.cyH.btJ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cyH.btJ);
            videoItemData.mRecomExtra = this.cyH.getExtra();
            videoItemData.mRecomAbTag = this.cyH.ajk();
            videoItemData.mRecomSource = this.cyH.getSource();
            videoItemData.mRecomWeight = this.cyH.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cyH.ajj(), "concern_tab")));
        }
    }

    private void ax(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (!j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else if (!j.jF() && !g.bAi().bAj()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.mContext.getPageActivity(), c.this.mContext.getPageActivity().getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aiK();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(d.C0140d.cp_cont_b);
            aVar.au(true);
            aVar.b(this.mTbPageContext).xf();
        } else {
            aiK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.cyH != null && this.cyH.btJ != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyH.btJ);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bcS.getX() + this.dTV.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bcS.getY() + this.dTV.getY());
            videoCardViewInfo.cardViewWidth = this.bcS.getWidth();
            videoCardViewInfo.cardViewHeight = this.bcS.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cyH.btJ.getTid(), o.uY(), this.cyH.ajj(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aiD() {
        return this.cyH.cCm && !this.cyH.cCv;
    }

    private void am(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (this.cyH != null && this.cyH.btJ != null) {
            if (!aiD()) {
                o.kW(this.cyH.btJ.getId());
                o.a(this.mTextTitle, this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyH.btJ, null, o.uY(), 18003, true, false, false).addLocateParam(this.cyH.ajj());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cyH.btJ.getFid()));
            addLocateParam.setForumName(this.cyH.btJ.vq());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cwv) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aDu() {
        if (this.dTP == null) {
            this.dTP = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aDv() {
        if (this.dTR == null) {
            this.dTR = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.dTR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.cyH);
                }
                if (c.this.cyH != null && c.this.cyH.btJ != null) {
                    o.kW(c.this.cyH.btJ.getId());
                    c.this.aiE();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cyH == null || this.cyH.btJ == null || this.cyH.btJ.vk() == null || this.cyH.btJ.vC() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        if (this.cyH.ajo()) {
            aDv();
            this.dTS = this.dTR;
            this.dTR.setVisibility(0);
            if (this.dTP != null) {
                this.dTP.setVisibility(8);
            }
        } else {
            aDu();
            this.dTS = this.dTP;
            this.dTP.setVisibility(0);
            if (this.dTR != null) {
                this.dTR.setVisibility(8);
            }
        }
        aiN();
        if (!aiD() && o.kX(this.cyH.btJ.getId())) {
            o.a(this.mTextTitle, this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.cyH.Td().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.cyH.Td().vS();
        SpannableStringBuilder vJ = this.cyH.Td().vJ();
        if (this.cyH.Td().vP() && !StringUtils.isNull(this.cyH.Td().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyH.Td().getTid();
            vJ.append((CharSequence) this.cyH.Td().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.6
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vJ));
        this.mTextTitle.setText(vJ);
        if (this.dTS.getHeaderImg() != null) {
            this.dTS.getHeaderImg().setAfterClickListener(this.cyR);
            if (this.dTS.getIsSimpleThread()) {
                this.dTS.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.cyH.Td() == null || this.cyH.Td().vk() == null || this.cyH.Td().vk().getPendantData() == null || StringUtils.isNull(this.cyH.Td().vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.dTS.getHeaderImg().setVisibility(0);
                this.dTS.getHeaderImg().setData(this.cyH.Td(), !this.cyH.ajo());
            } else {
                this.dTS.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.cyH.Td());
            }
        }
        this.dTS.setData(this.cyH.btJ);
        this.dTS.setUserAfterClickListener(this.cyQ);
        this.bcR.setText(ap.da(this.cyH.btJ.vC().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.H(this.cyH.btJ.vC().play_count.intValue())));
        this.cwv.setData(this.cyH.Td().wx());
        this.cwv.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kX(this.cyH.btJ.getId())) {
            am.c(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        hn(gu(1));
        if (this.cyH == null || this.cyH.btJ == null || this.cyH.btJ.vC() == null) {
            z = false;
        } else if (this.cyH.btJ.vC().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cyN.setVisibility(0);
        } else {
            this.cyN.setVisibility(8);
        }
    }

    private void aiN() {
        if (this.bcS != null && this.bcQ != null) {
            if (i.te().tk() && this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null) {
                this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcS.startLoad(this.cyH.btJ.vC().thumbnail_url, 10, false);
                this.bcQ.setVisibility(0);
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dTS != null) {
            this.dTS.setPageUniqueId(bdUniqueId);
        }
        if (this.bcS != null) {
            this.bcS.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiE() {
        if (this.cyH != null && this.cyH.btJ != null) {
            o.a(this.mTextTitle, this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.cyH.Td().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTS != null) {
            return this.dTS.getHeaderImg();
        }
        return null;
    }

    public View aiC() {
        if (this.dTS != null) {
            return this.dTS.getUserName();
        }
        return null;
    }

    public void hn(int i) {
        if (this.cyH != null && this.cyH.btJ != null) {
            if (!this.cyH.ajo() && i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(o.uY());
                this.bIC.setData(this.cyH.btJ);
                this.dTS.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cyH.btJ);
            this.bHO.setStType(o.uY());
            this.bIC.setVisibility(8);
            this.dTS.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}

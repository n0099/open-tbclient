package com.baidu.tieba.homepage.concern.view;

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
import com.baidu.tieba.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axw;
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
    private ThreadGodReplyLayout cws;
    private LinearLayout cyC;
    private l cyE;
    private TextView cyK;
    private final View.OnClickListener cyN;
    private final View.OnClickListener cyO;
    public ConcernThreadUserInfoLayout dTK;
    public ConcernForumThreadUserInfoLayout dTM;
    public com.baidu.tbadk.core.view.c dTN;
    private LinearLayout dTQ;
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
        this.cyN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.cyE);
                }
            }
        };
        this.cyO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.cyE);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cyE != null) {
                    if (c.this.aiC() != null) {
                        c.this.aiC().a(view, c.this.cyE);
                    }
                    if (c.this.cyE.btL != null && view != c.this.bIC.ayn) {
                        o.kY(c.this.cyE.btL.getId());
                        c.this.aiH();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bHM = (RelativeLayout) view.findViewById(f.g.layout_root);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(f.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.ds70));
        }
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(f.g.text_title);
        this.dTQ = (LinearLayout) view.findViewById(f.g.video_card_content_layout);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.text_bottom);
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
        this.bHO.setForumAfterClickListener(this.axw);
        this.bHO.ajY = this.currentPageType;
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_concern_video_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayo.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(this.axw);
        this.bHM.setOnClickListener(this);
        this.bcQ = (FrameLayout) view.findViewById(f.g.frame_video);
        this.bcQ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcQ.setLayoutParams(layoutParams2);
        this.bcS = (TbImageView) view.findViewById(f.g.image_video);
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.bcR = (TextView) view.findViewById(f.g.text_video_duration);
        this.cyC = (LinearLayout) view.findViewById(f.g.duration_container);
        this.bcZ = (TextView) view.findViewById(f.g.text_video_play_count);
        this.bHR = view.findViewById(f.g.divider_line);
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_god_reply_layout);
        this.cws.setOnClickListener(this);
        this.cyK = (TextView) view.findViewById(f.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bHM, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            this.bHO.onChangeSkinType();
            this.bIC.onChangeSkinType();
            am.i(this.bHR, f.d.cp_bg_line_e);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.bcZ, f.d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.dTK != null && this.dTK.getVisibility() == 0) {
            this.dTK.onChangeSkinType(i);
        }
        if (this.dTM != null && this.dTM.getVisibility() == 0) {
            this.dTM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cyE = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bHM || view == this.cws) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcQ) {
            if (this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null) {
                z = this.cyE.btL.vB().is_vertical.intValue() == 1;
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
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (!j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
        } else {
            aiM();
        }
    }

    private void aiM() {
        if (this.cyE != null && this.cyE.btL != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cyE.btL);
            videoItemData.mRecomExtra = this.cyE.getExtra();
            videoItemData.mRecomAbTag = this.cyE.ajn();
            videoItemData.mRecomSource = this.cyE.getSource();
            videoItemData.mRecomWeight = this.cyE.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", this.cyE.ajm(), "concern_tab")));
        }
    }

    private void ax(View view) {
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (!j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
        } else if (!j.jF() && !g.bAk().bAl()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(f.g.tv_title)).setText(f.j.confirm_title);
            ((TextView) inflate.findViewById(f.g.tv_msg)).setText(f.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(f.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, c.this.mContext.getPageActivity(), c.this.mContext.getPageActivity().getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aiN();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(f.d.cp_cont_b);
            aVar.av(true);
            aVar.b(this.mTbPageContext).xe();
        } else {
            aiN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.cyE != null && this.cyE.btL != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyE.btL);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bcS.getX() + this.dTQ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bcS.getY() + this.dTQ.getY());
            videoCardViewInfo.cardViewWidth = this.bcS.getWidth();
            videoCardViewInfo.cardViewHeight = this.bcS.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "concern_tab", this.cyE.btL.getTid(), o.uX(), this.cyE.ajm(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aiG() {
        return this.cyE.cCj && !this.cyE.cCs;
    }

    private void am(View view) {
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (this.cyE != null && this.cyE.btL != null) {
            if (!aiG()) {
                o.kY(this.cyE.btL.getId());
                o.a(this.mTextTitle, this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyE.btL, null, o.uX(), 18003, true, false, false).addLocateParam(this.cyE.ajm());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cyE.btL.getFid()));
            addLocateParam.setForumName(this.cyE.btL.vp());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cws) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aDr() {
        if (this.dTK == null) {
            this.dTK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(f.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aDs() {
        if (this.dTM == null) {
            this.dTM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(f.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.dTM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.cyE);
                }
                if (c.this.cyE != null && c.this.cyE.btL != null) {
                    o.kY(c.this.cyE.btL.getId());
                    c.this.aiH();
                }
            }
        });
    }

    private void refreshView() {
        boolean z = true;
        if (this.cyE == null || this.cyE.btL == null || this.cyE.btL.vj() == null || this.cyE.btL.vB() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        if (this.cyE.ajr()) {
            aDs();
            this.dTN = this.dTM;
            this.dTM.setVisibility(0);
            if (this.dTK != null) {
                this.dTK.setVisibility(8);
            }
        } else {
            aDr();
            this.dTN = this.dTK;
            this.dTK.setVisibility(0);
            if (this.dTM != null) {
                this.dTM.setVisibility(8);
            }
        }
        aiQ();
        if (!aiG() && o.kZ(this.cyE.btL.getId())) {
            o.a(this.mTextTitle, this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.cyE.Tg().getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        }
        this.cyE.Tg().vR();
        SpannableStringBuilder vI = this.cyE.Tg().vI();
        if (this.cyE.Tg().vO() && !StringUtils.isNull(this.cyE.Tg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyE.Tg().getTid();
            vI.append((CharSequence) this.cyE.Tg().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.6
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vI));
        this.mTextTitle.setText(vI);
        if (this.dTN.getHeaderImg() != null) {
            this.dTN.getHeaderImg().setAfterClickListener(this.cyO);
            if (this.dTN.getIsSimpleThread()) {
                this.dTN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.cyE.Tg() == null || this.cyE.Tg().vj() == null || this.cyE.Tg().vj().getPendantData() == null || StringUtils.isNull(this.cyE.Tg().vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.dTN.getHeaderImg().setVisibility(0);
                this.dTN.getHeaderImg().setData(this.cyE.Tg(), !this.cyE.ajr());
            } else {
                this.dTN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.cyE.Tg());
            }
        }
        this.dTN.setData(this.cyE.btL);
        this.dTN.setUserAfterClickListener(this.cyN);
        this.bcR.setText(ap.da(this.cyE.btL.vB().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.play_count), ap.H(this.cyE.btL.vB().play_count.intValue())));
        this.cws.setData(this.cyE.Tg().ww());
        this.cws.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cyE.btL.getId())) {
            am.c(this.mTextTitle, f.d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, f.d.cp_cont_b, 1);
        }
        hm(gt(1));
        if (this.cyE == null || this.cyE.btL == null || this.cyE.btL.vB() == null) {
            z = false;
        } else if (this.cyE.btL.vB().is_vertical.intValue() != 1) {
            z = false;
        }
        if (z) {
            this.cyK.setVisibility(0);
        } else {
            this.cyK.setVisibility(8);
        }
    }

    private void aiQ() {
        if (this.bcS != null && this.bcQ != null) {
            if (i.td().tj() && this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null) {
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(this.cyE.btL.vB().thumbnail_url, 10, false);
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
        if (this.dTN != null) {
            this.dTN.setPageUniqueId(bdUniqueId);
        }
        if (this.bcS != null) {
            this.bcS.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cyE != null && this.cyE.btL != null) {
            o.a(this.mTextTitle, this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.cyE.Tg().getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTN != null) {
            return this.dTN.getHeaderImg();
        }
        return null;
    }

    public View aiF() {
        if (this.dTN != null) {
            return this.dTN.getUserName();
        }
        return null;
    }

    public void hm(int i) {
        if (this.cyE != null && this.cyE.btL != null) {
            if (!this.cyE.ajr() && i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(o.uX());
                this.bIC.setData(this.cyE.btL);
                this.dTN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cyE.btL);
            this.bHO.setStType(o.uX());
            this.bIC.setVisibility(8);
            this.dTN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}

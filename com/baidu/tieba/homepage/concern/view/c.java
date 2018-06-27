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
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axT;
    private String bGM;
    private RelativeLayout bGX;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    private View bHc;
    public FrameLayout bcH;
    private TextView bcI;
    private TbImageView bcJ;
    private ImageView bcK;
    private TextView bcQ;
    private TbImageView.a bcT;
    private ThreadGodReplyLayout ctS;
    private LinearLayout cwd;
    private l cwe;
    private final View.OnClickListener cwn;
    private final View.OnClickListener cwo;
    public ConcernThreadUserInfoLayout dRc;
    public ConcernForumThreadUserInfoLayout dRe;
    public com.baidu.tbadk.core.view.c dRf;
    private LinearLayout dRi;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && c.this.bcJ != null) {
                    c.this.bcJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cwn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.cwe);
                }
            }
        };
        this.cwo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.cwe);
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cwe != null) {
                    if (c.this.aia() != null) {
                        c.this.aia().a(view, c.this.cwe);
                    }
                    if (c.this.cwe.btc != null && view != c.this.bHN.ayD) {
                        o.kY(c.this.cwe.btc.getId());
                        c.this.aif();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bGX = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bHK = (HeadPendantClickableView) this.bGX.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dRi = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setFrom(9);
        this.bGZ.setShareReportFrom(4);
        this.bGZ.setForumAfterClickListener(this.axT);
        this.bGZ.akz = this.currentPageType;
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this);
        this.bHN.setShareReportFrom(4);
        this.bHN.setFrom(9);
        this.bHN.ayE.akz = this.currentPageType;
        this.bHN.setForumAfterClickListener(this.axT);
        this.bGX.setOnClickListener(this);
        this.bcH = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bcH.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcH.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcH.setLayoutParams(layoutParams2);
        this.bcJ = (TbImageView) view.findViewById(d.g.image_video);
        this.bcJ.setDefaultErrorResource(0);
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setGifIconSupport(false);
        this.bcJ.setEvent(this.bcT);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcI = (TextView) view.findViewById(d.g.text_video_duration);
        this.cwd = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bcQ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bHc = view.findViewById(d.g.divider_line);
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ctS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bGX, d.f.addresslist_item_bg);
            am.c(this.bcK, d.f.btn_icon_play_video_n);
            this.bGZ.onChangeSkinType();
            this.bHN.onChangeSkinType();
            am.i(this.bHc, d.C0142d.cp_bg_line_e);
            am.h(this.bcI, d.C0142d.cp_cont_i);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            this.mSkinType = i;
        }
        if (this.dRc != null && this.dRc.getVisibility() == 0) {
            this.dRc.onChangeSkinType(i);
        }
        if (this.dRe != null && this.dRe.getVisibility() == 0) {
            this.dRe.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cwe = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGX || view == this.ctS) {
            aj(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcH) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                au(getView());
            } else {
                aj(getView());
            }
        }
    }

    private void au(View view) {
        if (aia() != null) {
            aia().a(view, this.cwe);
        }
        if (!j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!j.jE() && !com.baidu.tieba.video.f.bBB().bBC()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.mContext.getPageActivity(), c.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.ail();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cf(1);
            aVar.ce(d.C0142d.cp_cont_b);
            aVar.aw(true);
            aVar.b(this.mTbPageContext).xn();
        } else {
            ail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        if (this.cwe != null && this.cwe.btc != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cwe.btc);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bcJ.getX() + this.dRi.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bcJ.getY() + this.dRi.getY());
            videoCardViewInfo.cardViewWidth = this.bcJ.getWidth();
            videoCardViewInfo.cardViewHeight = this.bcJ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cwe.btc.getTid(), o.vk(), this.cwe.aiK(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean aie() {
        return this.cwe.czG && !this.cwe.czQ;
    }

    private void aj(View view) {
        if (aia() != null) {
            aia().a(view, this.cwe);
        }
        if (this.cwe != null && this.cwe.btc != null) {
            if (!aie()) {
                o.kY(this.cwe.btc.getId());
                o.a(this.mTextTitle, this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cwe.btc, null, o.vk(), 18003, true, false, false).addLocateParam(this.cwe.aiK());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cwe.btc.getFid()));
            addLocateParam.setForumName(this.cwe.btc.vB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ctS) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void aCM() {
        if (this.dRc == null) {
            this.dRc = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_thread_user_info_layout)).inflate();
        }
    }

    private void aCN() {
        if (this.dRe == null) {
            this.dRe = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_video_forum_thread_user_info_layout)).inflate();
        }
        this.dRe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.cwe);
                }
                if (c.this.cwe != null && c.this.cwe.btc != null) {
                    o.kY(c.this.cwe.btc.getId());
                    c.this.aif();
                }
            }
        });
    }

    private void refreshView() {
        if (this.cwe == null || this.cwe.btc == null || this.cwe.btc.vw() == null || this.cwe.btc.vN() == null) {
            this.bGX.setVisibility(8);
            return;
        }
        this.bGX.setVisibility(0);
        if (this.cwe.aiP()) {
            aCN();
            this.dRf = this.dRe;
            this.dRe.setVisibility(0);
            if (this.dRc != null) {
                this.dRc.setVisibility(8);
            }
        } else {
            aCM();
            this.dRf = this.dRc;
            this.dRc.setVisibility(0);
            if (this.dRe != null) {
                this.dRe.setVisibility(8);
            }
        }
        aio();
        if (!aie() && o.kZ(this.cwe.btc.getId())) {
            o.a(this.mTextTitle, this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.cwe.SV().getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        }
        this.cwe.SV().wd();
        SpannableStringBuilder vU = this.cwe.SV().vU();
        if (this.cwe.SV().wa() && !StringUtils.isNull(this.cwe.SV().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cwe.SV().getTid();
            vU.append((CharSequence) this.cwe.SV().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.6
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0142d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vU));
        this.mTextTitle.setText(vU);
        if (this.dRf.getHeaderImg() != null) {
            this.dRf.getHeaderImg().setAfterClickListener(this.cwo);
            if (this.dRf.getIsSimpleThread()) {
                this.dRf.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (this.cwe.SV() == null || this.cwe.SV().vw() == null || this.cwe.SV().vw().getPendantData() == null || StringUtils.isNull(this.cwe.SV().vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.dRf.getHeaderImg().setVisibility(0);
                this.dRf.getHeaderImg().setData(this.cwe.SV(), !this.cwe.aiP());
            } else {
                this.dRf.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(this.cwe.SV());
            }
        }
        this.dRf.setData(this.cwe.btc);
        this.dRf.setUserAfterClickListener(this.cwn);
        this.bcI.setText(ap.cY(this.cwe.btc.vN().video_duration.intValue() * 1000));
        this.bcQ.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ap.F(this.cwe.btc.vN().play_count.intValue())));
        this.ctS.setData(this.cwe.SV().wI());
        this.ctS.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cwe.btc.getId())) {
            am.c(this.mTextTitle, d.C0142d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0142d.cp_cont_b, 1);
        }
        hh(gp(1));
    }

    private void aio() {
        if (this.bcJ != null && this.bcH != null) {
            if (i.tt().tz() && this.cwe != null && this.cwe.btc != null && this.cwe.btc.vN() != null) {
                this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcJ.startLoad(this.cwe.btc.vN().thumbnail_url, 10, false);
                this.bcH.setVisibility(0);
                return;
            }
            this.bcH.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dRf != null) {
            this.dRf.setPageUniqueId(bdUniqueId);
        }
        if (this.bcJ != null) {
            this.bcJ.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        if (this.cwe != null && this.cwe.btc != null) {
            o.a(this.mTextTitle, this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.cwe.SV().getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dRf != null) {
            return this.dRf.getHeaderImg();
        }
        return null;
    }

    public View aid() {
        if (this.dRf != null) {
            return this.dRf.getUserName();
        }
        return null;
    }

    public void hh(int i) {
        if (this.cwe != null && this.cwe.btc != null) {
            if (!this.cwe.aiP() && i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setStType(o.vk());
                this.bHN.setData(this.cwe.btc);
                this.dRf.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.cwe.btc);
            this.bGZ.setStType(o.vk());
            this.bHN.setVisibility(8);
            this.dRf.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}

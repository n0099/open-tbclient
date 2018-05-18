package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aoY;
    private ImageView bkP;
    private String bwO;
    private RelativeLayout bwZ;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private View bxe;
    private ThreadGodReplyLayout cnh;
    private l cpC;
    private TbImageView.a cpN;
    private final View.OnClickListener cpQ;
    private final View.OnClickListener cpR;
    private TbImageView cpm;
    private TextView cpn;
    public FrameLayout cpt;
    private TextView cpx;
    private LinearLayout cpy;
    public ConcernThreadUserInfoLayout dCE;
    private LinearLayout dCJ;
    private TbPageContext<?> mContext;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && c.this.cpm != null) {
                    c.this.cpm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cpQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cpC);
                }
            }
        };
        this.cpR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cpC);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cpC != null) {
                    if (c.this.aeZ() != null) {
                        c.this.aeZ().a(view2, c.this.cpC);
                    }
                    if (c.this.cpC.bjy != null && view2 != c.this.bxQ.apF) {
                        o.ky(c.this.cpC.bjy.getId());
                        c.this.afe();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.currentPageType = 1;
        View view2 = getView();
        this.bwZ = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.bxM = (HeadPendantClickableView) this.bwZ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.dCE = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_video_user_info_layout);
        this.dCJ = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setFrom(9);
        this.bxb.setShareReportFrom(4);
        this.bxb.setForumAfterClickListener(this.aoY);
        this.bxb.abW = this.currentPageType;
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this);
        this.bxQ.setShareReportFrom(4);
        this.bxQ.setFrom(9);
        this.bxQ.apG.abW = this.currentPageType;
        this.bxQ.setForumAfterClickListener(this.aoY);
        this.bwZ.setOnClickListener(this);
        this.cpt = (FrameLayout) view2.findViewById(d.g.frame_video);
        this.cpt.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cpt.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cpt.setLayoutParams(layoutParams2);
        this.cpm = (TbImageView) view2.findViewById(d.g.image_video);
        this.cpm.setDefaultErrorResource(0);
        this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cpm.setGifIconSupport(false);
        this.cpm.setEvent(this.cpN);
        this.bkP = (ImageView) view2.findViewById(d.g.image_video_play);
        this.cpx = (TextView) view2.findViewById(d.g.text_video_duration);
        this.cpy = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.cpn = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.bxe = view2.findViewById(d.g.divider_line);
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.cnh.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwZ, d.f.addresslist_item_bg);
            ak.c(this.bkP, d.f.btn_icon_play_video_n);
            this.dCE.onChangeSkinType();
            this.bxb.onChangeSkinType();
            this.bxQ.onChangeSkinType();
            ak.i(this.bxe, d.C0126d.cp_bg_line_e);
            ak.h(this.cpx, d.C0126d.cp_cont_i);
            ak.h(this.cpn, d.C0126d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cpC = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.bwZ || view2 == this.cnh) {
            ah(view2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view2 == this.cpt) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(getView());
            } else {
                ah(getView());
            }
        }
    }

    private void as(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpC);
        }
        if (!j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!j.gQ() && !com.baidu.tieba.video.f.bvU().bvV()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.mContext.getPageActivity(), c.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.afk();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cc(1);
            aVar.cb(d.C0126d.cp_cont_b);
            aVar.ar(true);
            aVar.b(this.mTbPageContext).tC();
        } else {
            afk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.cpC != null && this.cpC.bjy != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cpC.bjy);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cpm.getX() + this.dCJ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cpm.getY() + this.dCJ.getY());
            videoCardViewInfo.cardViewWidth = this.cpm.getWidth();
            videoCardViewInfo.cardViewHeight = this.cpm.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cpC.bjy.getTid(), o.rF(), this.cpC.afJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean afd() {
        return this.cpC.cth && !this.cpC.ctr;
    }

    private void ah(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpC);
        }
        if (this.cpC != null && this.cpC.bjy != null) {
            if (!afd()) {
                o.ky(this.cpC.bjy.getId());
                o.a(this.mTextTitle, this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cpC.bjy, null, o.rF(), 18003, true, false, false).addLocateParam(this.cpC.afJ());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cpC.bjy.getFid()));
            addLocateParam.setForumName(this.cpC.bjy.rU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view2 == this.cnh) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cpC == null || this.cpC.bjy == null || this.cpC.bjy.rP() == null || this.cpC.bjy.sg() == null) {
            this.bwZ.setVisibility(8);
            return;
        }
        this.bwZ.setVisibility(0);
        afn();
        if (!afd() && o.kz(this.cpC.bjy.getId())) {
            o.a(this.mTextTitle, this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.cpC.Pb().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.cpC.Pb().sw();
        SpannableStringBuilder sn = this.cpC.Pb().sn();
        if (this.cpC.Pb().st() && !StringUtils.isNull(this.cpC.Pb().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cpC.Pb().getTid();
            sn.append((CharSequence) this.cpC.Pb().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new al("c12841").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.j(sn));
        this.mTextTitle.setText(sn);
        this.dCE.setData(this.cpC.Pb());
        this.dCE.setUserAfterClickListener(this.cpQ);
        if (this.dCE.getHeaderImg() != null) {
            this.dCE.getHeaderImg().setAfterClickListener(this.cpR);
            if (this.dCE.getIsSimpleThread()) {
                this.dCE.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (this.cpC.Pb() == null || this.cpC.Pb().rP() == null || this.cpC.Pb().rP().getPendantData() == null || StringUtils.isNull(this.cpC.Pb().rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.dCE.getHeaderImg().setVisibility(0);
                this.dCE.getHeaderImg().setData(this.cpC.Pb());
            } else {
                this.dCE.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(this.cpC.Pb());
            }
        }
        this.cpx.setText(an.cV(this.cpC.bjy.sg().video_duration.intValue() * 1000));
        this.cpn.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.cpC.bjy.sg().play_count.intValue())));
        this.cnh.setData(this.cpC.Pb().tb());
        this.cnh.onChangeSkinType();
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kz(this.cpC.bjy.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        hc(gn(1));
    }

    private void afn() {
        if (this.cpm != null && this.cpt != null) {
            if (i.pX().qd() && this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.sg() != null) {
                this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cpm.startLoad(this.cpC.bjy.sg().thumbnail_url, 10, false);
                this.cpt.setVisibility(0);
                return;
            }
            this.cpt.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dCE != null) {
            this.dCE.setPageUniqueId(bdUniqueId);
        }
        if (this.cpm != null) {
            this.cpm.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.cpC != null && this.cpC.bjy != null) {
            o.a(this.mTextTitle, this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.cpC.Pb().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dCE != null) {
            return this.dCE.getHeaderImg();
        }
        return null;
    }

    public View afc() {
        if (this.dCE != null) {
            return this.dCE.apg;
        }
        return null;
    }

    public void hc(int i) {
        if (this.cpC != null && this.cpC.bjy != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setStType(o.rF());
                this.bxQ.setData(this.cpC.bjy);
                this.dCE.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.cpC.bjy);
            this.bxb.setStType(o.rF());
            this.bxQ.setVisibility(8);
            this.dCE.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}

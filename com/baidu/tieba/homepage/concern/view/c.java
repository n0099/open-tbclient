package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<n> {
    private TbPageContext<?> aQs;
    private ImageView bYB;
    private final View.OnClickListener bbZ;
    private ThreadGodReplyLayout cSK;
    private TbImageView cTG;
    private TextView cTH;
    public FrameLayout cTN;
    private TextView cTQ;
    private LinearLayout cTR;
    private n cTV;
    private TbImageView.a cUf;
    private final View.OnClickListener cUi;
    private final View.OnClickListener cUj;
    private View cef;
    private RelativeLayout ciR;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    public ConcernThreadUserInfoLayout ecE;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.cTG != null) {
                    c.this.cTG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view, c.this.cTV);
                }
            }
        };
        this.cUj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view, c.this.cTV);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cTV != null) {
                    if (c.this.akg() != null) {
                        c.this.akg().a(view, c.this.cTV);
                    }
                    if (c.this.cTV.bXi != null) {
                        k.kj(c.this.cTV.bXi.getId());
                        c.this.akl();
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.ciR = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cjC = (HeadPendantClickableView) this.ciR.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(l.s(this.aQs.getPageActivity(), d.e.ds70));
        }
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ecE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(4);
        this.ciT.setForumAfterClickListener(this.bbZ);
        this.ciT.bbX = this.currentPageType;
        this.ciR.setOnClickListener(this);
        this.cTN = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cTN.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTN.getLayoutParams();
        layoutParams2.width = l.ao(this.aQs.getPageActivity()) - l.s(this.aQs.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTN.setLayoutParams(layoutParams2);
        this.cTG = (TbImageView) view.findViewById(d.g.image_video);
        this.cTG.setDefaultErrorResource(0);
        this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTG.setGifIconSupport(false);
        this.cTG.setEvent(this.cUf);
        this.bYB = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTQ = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTR = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cTH = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cef = view.findViewById(d.g.divider_line);
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSK.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciR, d.f.addresslist_item_bg);
            aj.c(this.bYB, d.f.btn_icon_play_video_n);
            this.ecE.onChangeSkinType();
            this.ciT.onChangeSkinType();
            aj.s(this.cef, d.C0108d.cp_bg_line_e);
            aj.r(this.cTQ, d.C0108d.cp_cont_i);
            aj.r(this.cTH, d.C0108d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cTV = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciR || view == this.cSK) {
            bD(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTN) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bO(getView());
            } else {
                bD(getView());
            }
        }
    }

    private void bO(View view) {
        if (akg() != null) {
            akg().a(view, this.cTV);
        }
        if (!j.oJ()) {
            l.showToast(this.aQs.getPageActivity(), d.j.no_network_guide);
        } else if (!j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQs.getPageActivity());
            aVar.cZ(this.aQs.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.akq();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(this.mTbPageContext).AB();
        } else {
            akq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        if (this.cTV != null && this.cTV.bXi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQs.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cTV.bXi.getTid(), k.yJ(), this.cTV.akT())));
        }
    }

    private boolean akk() {
        return this.cTV.cXy && !this.cTV.cXM;
    }

    private void bD(View view) {
        if (akg() != null) {
            akg().a(view, this.cTV);
        }
        if (this.cTV != null && this.cTV.bXi != null) {
            if (!akk()) {
                k.kj(this.cTV.bXi.getId());
                k.a(this.mTextTitle, this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQs.getPageActivity()).createFromThreadCfg(this.cTV.bXi, null, k.yJ(), 18003, true, false, false).addLocateParam(this.cTV.akT());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cTV.bXi.getFid()));
            addLocateParam.setForumName(this.cTV.bXi.yZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSK) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cTV == null || this.cTV.bXi == null || this.cTV.bXi.yT() == null || this.cTV.bXi.zl() == null) {
            this.ciR.setVisibility(8);
            return;
        }
        this.ciR.setVisibility(0);
        akv();
        if (!akk() && k.kk(this.cTV.bXi.getId())) {
            k.a(this.mTextTitle, this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cSK.getGodReplyContent(), this.cTV.VM().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.cTV.VM().zC();
        SpannableStringBuilder zt = this.cTV.VM().zt();
        if (this.cTV.VM().zz() && !StringUtils.isNull(this.cTV.VM().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cTV.VM().getTid();
            zt.append((CharSequence) this.cTV.VM().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0108d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new m(zt));
        this.mTextTitle.setText(zt);
        this.ecE.setData(this.cTV.VM());
        this.ecE.setUserAfterClickListener(this.cUi);
        if (this.ecE.getHeaderImg() != null) {
            this.ecE.getHeaderImg().setAfterClickListener(this.cUj);
            if (this.ecE.getIsSimpleThread()) {
                this.ecE.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (this.cTV.VM() == null || this.cTV.VM().yT() == null || this.cTV.VM().yT().getPendantData() == null || StringUtils.isNull(this.cTV.VM().yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ecE.getHeaderImg().setVisibility(0);
                this.ecE.getHeaderImg().setData(this.cTV.VM());
            } else {
                this.ecE.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(this.cTV.VM());
            }
        }
        this.cTQ.setText(am.fV(this.cTV.bXi.zl().video_duration.intValue() * 1000));
        this.cTH.setText(String.format(this.aQs.getResources().getString(d.j.play_count), am.J(this.cTV.bXi.zl().play_count.intValue())));
        this.ciT.setData(this.cTV.bXi);
        this.cSK.setData(this.cTV.VM().Ah());
        this.cSK.onChangeSkinType();
        d(this.aQs, TbadkCoreApplication.getInst().getSkinType());
        if (k.kk(this.cTV.bXi.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
    }

    private void akv() {
        if (this.cTG != null && this.cTN != null) {
            if (i.wB().wH() && this.cTV != null && this.cTV.bXi != null && this.cTV.bXi.zl() != null) {
                this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTG.startLoad(this.cTV.bXi.zl().thumbnail_url, 10, false);
                this.cTN.setVisibility(0);
                return;
            }
            this.cTN.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ecE != null) {
            this.ecE.setPageUniqueId(bdUniqueId);
        }
        if (this.cTG != null) {
            this.cTG.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.cTV != null && this.cTV.bXi != null) {
            k.a(this.mTextTitle, this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cSK.getGodReplyContent(), this.cTV.VM().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecE != null) {
            return this.ecE.getHeaderImg();
        }
        return null;
    }

    public View akj() {
        if (this.ecE != null) {
            return this.ecE.bci;
        }
        return null;
    }
}

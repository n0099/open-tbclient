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
    private TbPageContext<?> aQp;
    private ImageView bYt;
    private final View.OnClickListener bbR;
    private ThreadGodReplyLayout cSp;
    private n cTA;
    private TbImageView.a cTK;
    private final View.OnClickListener cTN;
    private final View.OnClickListener cTO;
    private TbImageView cTl;
    private TextView cTm;
    public FrameLayout cTs;
    private TextView cTv;
    private LinearLayout cTw;
    private View cdX;
    private RelativeLayout ciJ;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private HeadPendantClickableView cju;
    public ConcernThreadUserInfoLayout ecj;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.cTl != null) {
                    c.this.cTl.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cTN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view, c.this.cTA);
                }
            }
        };
        this.cTO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view, c.this.cTA);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cTA != null) {
                    if (c.this.akb() != null) {
                        c.this.akb().a(view, c.this.cTA);
                    }
                    if (c.this.cTA.bXa != null) {
                        k.kc(c.this.cTA.bXa.getId());
                        c.this.akg();
                    }
                }
            }
        };
        this.aQp = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.ciJ = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cju = (HeadPendantClickableView) this.ciJ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(l.s(this.aQp.getPageActivity(), d.e.ds70));
        }
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ecj = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(4);
        this.ciL.setForumAfterClickListener(this.bbR);
        this.ciL.bbP = this.currentPageType;
        this.ciJ.setOnClickListener(this);
        this.cTs = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cTs.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTs.getLayoutParams();
        layoutParams2.width = l.ao(this.aQp.getPageActivity()) - l.s(this.aQp.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTs.setLayoutParams(layoutParams2);
        this.cTl = (TbImageView) view.findViewById(d.g.image_video);
        this.cTl.setDefaultErrorResource(0);
        this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTl.setGifIconSupport(false);
        this.cTl.setEvent(this.cTK);
        this.bYt = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTv = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTw = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cTm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cdX = view.findViewById(d.g.divider_line);
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSp.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciJ, d.f.addresslist_item_bg);
            aj.c(this.bYt, d.f.btn_icon_play_video_n);
            this.ecj.onChangeSkinType();
            this.ciL.onChangeSkinType();
            aj.s(this.cdX, d.C0107d.cp_bg_line_e);
            aj.r(this.cTv, d.C0107d.cp_cont_i);
            aj.r(this.cTm, d.C0107d.cp_cont_i);
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
        this.cTA = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciJ || view == this.cSp) {
            bD(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTs) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bO(getView());
            } else {
                bD(getView());
            }
        }
    }

    private void bO(View view) {
        if (akb() != null) {
            akb().a(view, this.cTA);
        }
        if (!j.oI()) {
            l.showToast(this.aQp.getPageActivity(), d.j.no_network_guide);
        } else if (!j.oJ()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQp.getPageActivity());
            aVar.cZ(this.aQp.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.akl();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.mTbPageContext).AA();
        } else {
            akl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.cTA != null && this.cTA.bXa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQp.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cTA.bXa.getTid(), k.yI(), this.cTA.akO())));
        }
    }

    private boolean akf() {
        return this.cTA.cXd && !this.cTA.cXr;
    }

    private void bD(View view) {
        if (akb() != null) {
            akb().a(view, this.cTA);
        }
        if (this.cTA != null && this.cTA.bXa != null) {
            if (!akf()) {
                k.kc(this.cTA.bXa.getId());
                k.a(this.mTextTitle, this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQp.getPageActivity()).createFromThreadCfg(this.cTA.bXa, null, k.yI(), 18003, true, false, false).addLocateParam(this.cTA.akO());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cTA.bXa.getFid()));
            addLocateParam.setForumName(this.cTA.bXa.yY());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSp) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cTA == null || this.cTA.bXa == null || this.cTA.bXa.yS() == null || this.cTA.bXa.zk() == null) {
            this.ciJ.setVisibility(8);
            return;
        }
        this.ciJ.setVisibility(0);
        akq();
        if (!akf() && k.kd(this.cTA.bXa.getId())) {
            k.a(this.mTextTitle, this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            k.a(this.cSp.getGodReplyContent(), this.cTA.VK().getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        }
        this.cTA.VK().zB();
        SpannableStringBuilder zs = this.cTA.VK().zs();
        if (this.cTA.VK().zy() && !StringUtils.isNull(this.cTA.VK().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cTA.VK().getTid();
            zs.append((CharSequence) this.cTA.VK().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0107d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new m(zs));
        this.mTextTitle.setText(zs);
        this.ecj.setData(this.cTA.VK());
        this.ecj.setUserAfterClickListener(this.cTN);
        if (this.ecj.getHeaderImg() != null) {
            this.ecj.getHeaderImg().setAfterClickListener(this.cTO);
            if (this.ecj.getIsSimpleThread()) {
                this.ecj.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (this.cTA.VK() == null || this.cTA.VK().yS() == null || this.cTA.VK().yS().getPendantData() == null || StringUtils.isNull(this.cTA.VK().yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ecj.getHeaderImg().setVisibility(0);
                this.ecj.getHeaderImg().setData(this.cTA.VK());
            } else {
                this.ecj.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(this.cTA.VK());
            }
        }
        this.cTv.setText(am.fV(this.cTA.bXa.zk().video_duration.intValue() * 1000));
        this.cTm.setText(String.format(this.aQp.getResources().getString(d.j.play_count), am.J(this.cTA.bXa.zk().play_count.intValue())));
        this.ciL.setData(this.cTA.bXa);
        this.cSp.setData(this.cTA.VK().Ag());
        this.cSp.onChangeSkinType();
        d(this.aQp, TbadkCoreApplication.getInst().getSkinType());
        if (k.kd(this.cTA.bXa.getId())) {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_b, 1);
        }
    }

    private void akq() {
        if (this.cTl != null && this.cTs != null) {
            if (i.wA().wG() && this.cTA != null && this.cTA.bXa != null && this.cTA.bXa.zk() != null) {
                this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTl.startLoad(this.cTA.bXa.zk().thumbnail_url, 10, false);
                this.cTs.setVisibility(0);
                return;
            }
            this.cTs.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ecj != null) {
            this.ecj.setPageUniqueId(bdUniqueId);
        }
        if (this.cTl != null) {
            this.cTl.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akg() {
        if (this.cTA != null && this.cTA.bXa != null) {
            k.a(this.mTextTitle, this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            k.a(this.cSp.getGodReplyContent(), this.cTA.VK().getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecj != null) {
            return this.ecj.getHeaderImg();
        }
        return null;
    }

    public View ake() {
        if (this.ecj != null) {
            return this.ecj.bca;
        }
        return null;
    }
}

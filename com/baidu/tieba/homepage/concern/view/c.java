package com.baidu.tieba.homepage.concern.view;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<n> {
    private TbPageContext<?> aQq;
    private ImageView bYm;
    private final View.OnClickListener bbR;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private TbImageView cOK;
    private TextView cOL;
    public FrameLayout cOR;
    private TextView cOU;
    private LinearLayout cOV;
    private n cOZ;
    private TbImageView.a cPj;
    private final View.OnClickListener cPm;
    private final View.OnClickListener cPn;
    private View cdQ;
    private RelativeLayout ciC;
    public ThreadCommentAndPraiseInfoLayout ciE;
    public ConcernThreadUserInfoLayout eaZ;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.cOK != null) {
                    c.this.cOK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cPm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view, c.this.cOZ);
                }
            }
        };
        this.cPn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view, c.this.cOZ);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cOZ != null) {
                    if (c.this.aiY() != null) {
                        c.this.aiY().a(view, c.this.cOZ);
                    }
                    if (c.this.cOZ.bWT != null) {
                        k.jT(c.this.cOZ.bWT.getId());
                        c.this.ajd();
                    }
                }
            }
        };
        this.aQq = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.ciC = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cNO = (HeadPendantClickableView) this.ciC.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(l.s(this.aQq.getPageActivity(), d.e.ds70));
        }
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.eaZ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(4);
        this.ciE.setForumAfterClickListener(this.bbR);
        this.ciE.bbP = this.currentPageType;
        this.ciC.setOnClickListener(this);
        this.cOR = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cOR.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOR.getLayoutParams();
        layoutParams2.width = l.ao(this.aQq.getPageActivity()) - l.s(this.aQq.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cOR.setLayoutParams(layoutParams2);
        this.cOK = (TbImageView) view.findViewById(d.g.image_video);
        this.cOK.setDefaultErrorResource(0);
        this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cOK.setGifIconSupport(false);
        this.cOK.setEvent(this.cPj);
        this.bYm = (ImageView) view.findViewById(d.g.image_video_play);
        this.cOU = (TextView) view.findViewById(d.g.text_video_duration);
        this.cOV = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cOL = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cdQ = view.findViewById(d.g.divider_line);
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cNP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciC, d.f.addresslist_item_bg);
            aj.c(this.bYm, d.f.btn_icon_play_video_n);
            this.eaZ.onChangeSkinType();
            this.ciE.onChangeSkinType();
            aj.s(this.cdQ, d.C0108d.cp_bg_line_e);
            aj.r(this.cOU, d.C0108d.cp_cont_i);
            aj.r(this.cOL, d.C0108d.cp_cont_i);
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
        this.cOZ = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciC || view == this.cNP) {
            bB(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cOR) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bM(getView());
            } else {
                bB(getView());
            }
        }
    }

    private void bM(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cOZ);
        }
        if (!j.oI()) {
            l.showToast(this.aQq.getPageActivity(), d.j.no_network_guide);
        } else if (!j.oJ()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
            aVar.cZ(this.aQq.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aji();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.mTbPageContext).AI();
        } else {
            aji();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        if (this.cOZ != null && this.cOZ.bWT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQq.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cOZ.bWT.getTid(), k.yN(), this.cOZ.ajL())));
        }
    }

    private boolean ajc() {
        return this.cOZ.cSB && !this.cOZ.cSP;
    }

    private void bB(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cOZ);
        }
        if (this.cOZ != null && this.cOZ.bWT != null) {
            if (!ajc()) {
                k.jT(this.cOZ.bWT.getId());
                k.a(this.mTextTitle, this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQq.getPageActivity()).createFromThreadCfg(this.cOZ.bWT, null, k.yN(), 18003, true, false, false).addLocateParam(this.cOZ.ajL());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cOZ.bWT.getFid()));
            addLocateParam.setForumName(this.cOZ.bWT.zd());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cNP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cOZ == null || this.cOZ.bWT == null || this.cOZ.bWT.yX() == null || this.cOZ.bWT.zp() == null) {
            this.ciC.setVisibility(8);
            return;
        }
        this.ciC.setVisibility(0);
        ajn();
        if (!ajc() && k.jU(this.cOZ.bWT.getId())) {
            k.a(this.mTextTitle, this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cNP.getGodReplyContent(), this.cOZ.VW().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.cOZ.VW().zF();
        this.mTextTitle.setText(this.cOZ.VW().zx());
        this.eaZ.setData(this.cOZ.VW());
        this.eaZ.setUserAfterClickListener(this.cPm);
        if (this.eaZ.getHeaderImg() != null) {
            this.eaZ.getHeaderImg().setAfterClickListener(this.cPn);
            if (this.eaZ.getIsSimpleThread()) {
                this.eaZ.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (this.cOZ.VW() == null || this.cOZ.VW().yX() == null || this.cOZ.VW().yX().getPendantData() == null || StringUtils.isNull(this.cOZ.VW().yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.eaZ.getHeaderImg().setVisibility(0);
                this.eaZ.getHeaderImg().setData(this.cOZ.VW());
            } else {
                this.eaZ.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(this.cOZ.VW());
            }
        }
        this.cOU.setText(am.fX(this.cOZ.bWT.zp().video_duration.intValue() * 1000));
        this.cOL.setText(String.format(this.aQq.getResources().getString(d.j.play_count), am.I(this.cOZ.bWT.zp().play_count.intValue())));
        this.ciE.setData(this.cOZ.bWT);
        this.cNP.setData(this.cOZ.VW().Ao());
        this.cNP.onChangeSkinType();
        d(this.aQq, TbadkCoreApplication.getInst().getSkinType());
        if (k.jU(this.cOZ.bWT.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
    }

    private void ajn() {
        if (this.cOK != null && this.cOR != null) {
            if (i.wB().wH() && this.cOZ != null && this.cOZ.bWT != null && this.cOZ.bWT.zp() != null) {
                this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cOK.startLoad(this.cOZ.bWT.zp().thumbnail_url, 10, false);
                this.cOR.setVisibility(0);
                return;
            }
            this.cOR.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eaZ != null) {
            this.eaZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cOK != null) {
            this.cOK.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (this.cOZ != null && this.cOZ.bWT != null) {
            k.a(this.mTextTitle, this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cNP.getGodReplyContent(), this.cOZ.VW().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eaZ != null) {
            return this.eaZ.getHeaderImg();
        }
        return null;
    }

    public View ajb() {
        if (this.eaZ != null) {
            return this.eaZ.bca;
        }
        return null;
    }
}

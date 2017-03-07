package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> aaI;
    private View.OnClickListener alM;
    private View.OnClickListener amj;
    public View baD;
    public ClickableHeaderImageView bbg;
    public ViewStub bbh;
    public TbImageView bbi;
    public ThreadCommentAndPraiseInfoLayout bbj;
    public UserIconLayout bbk;
    private com.baidu.tieba.card.data.m bsE;
    public View bsF;
    public FrameLayout bsG;
    public TbImageView bsH;
    public TextView bsI;
    public ImageView bsJ;
    private com.baidu.tbadk.core.view.o bsK;
    private CustomMessageListener bsL;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsK = null;
        this.amj = new u(this);
        this.alM = new v(this);
        this.bsL = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aaI = tbPageContext;
        W(getView());
    }

    private void W(View view) {
        this.bsF = view.findViewById(w.h.layout_root);
        this.baD = view.findViewById(w.h.divider);
        this.bbg = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbg.setDefaultResource(17170445);
        this.bbg.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbg.setRadius(com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds70));
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bbk = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bsG = (FrameLayout) view.findViewById(w.h.frame_video);
        this.bsH = (TbImageView) view.findViewById(w.h.image_video);
        this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsH.setDefaultResource(0);
        this.bsH.setDefaultErrorResource(0);
        this.bsI = (TextView) view.findViewById(w.h.tv_ala_inlive);
        this.bsJ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bbj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsF.setOnClickListener(this);
    }

    public void Sk() {
        if (this.bsK == null) {
            this.bsK = new com.baidu.tbadk.core.view.o(this.aaI);
            this.bsK.wu();
            this.bbj.addView(this.bsK);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bsF, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.baD, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i((View) this.mTextTitle, w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.c(this.bsJ, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.k(this.bsG, w.e.cp_bg_line_k);
            this.bbk.tD();
            this.bbj.tD();
            if (this.bsK != null) {
                this.bsK.tD();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_ala_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.m mVar) {
        this.bsE = mVar;
        MR();
    }

    private void MR() {
        if (this.bsE == null || this.bsE.JN() == null) {
            this.bsF.setVisibility(8);
            return;
        }
        this.bsF.setVisibility(0);
        this.bbg.setVisibility(0);
        this.bbg.setData(this.bsE.JN());
        this.bbg.setAfterClickListener(this.amj);
        UserTbVipInfoData rR = this.bsE.JN().rR();
        if (rR != null && rR.getvipV_url() != null && this.bbh != null) {
            if (this.bbi == null) {
                this.bbh.inflate();
                this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.bbi.c(rR.getvipV_url(), 10, false);
            this.bbg.setIsBigV(true);
        }
        this.bbk.setVisibility(0);
        this.bbk.setData(this.bsE.JN());
        this.bbk.setUserAfterClickListener(this.amj);
        this.mTextTitle.setText(this.bsE.bbv.getTitle());
        this.bbj.a(this.bsE.JN());
        this.bbj.setStType(at.rH());
        this.bbj.setYuelaouLocate("feed#" + this.bsE.Sx());
        this.bbj.setForumAfterClickListener(this.alM);
        if (this.bsK != null && this.bsE.JN() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.ci(this.bsE.JN().getTid());
            amVar.setFid(this.bsE.JN().getFid());
            amVar.a(this.bsE.WE);
            this.bsK.setData(amVar);
        }
        onChangeSkinType(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.hV(this.bsE.bbv.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_c, 1);
        }
        Sl();
        this.bbj.setBarNameClickEnabled(true);
    }

    public void Sl() {
        if (com.baidu.tbadk.core.l.oQ().oW() && this.bsE != null && this.bsE.JN() != null && this.bsE.JN().si() != null) {
            this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.bsH.c(this.bsE.JN().si().cover, 10, false);
            this.bsG.setVisibility(0);
            return;
        }
        this.bsG.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.bsK != null) {
            this.bsK.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsF) {
            X(view);
        }
    }

    private void X(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bsE);
        }
        if (this.bsE != null && this.bsE.JN() != null && this.bsE.JN().si() != null) {
            at.hU(this.bsE.bbv.getId());
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bsE.JN().si().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aaI.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbj != null && this.bsL != null) {
            this.bbj.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }
}

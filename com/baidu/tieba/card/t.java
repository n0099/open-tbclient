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
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> Fp;
    public ClickableHeaderImageView aUT;
    public ViewStub aUU;
    public TbImageView aUV;
    public ThreadCommentAndPraiseInfoLayout aUW;
    public UserIconLayout aUX;
    public View aUq;
    private View.OnClickListener agO;
    private View.OnClickListener agt;
    private com.baidu.tieba.card.data.m blL;
    public View blM;
    public FrameLayout blN;
    public TbImageView blO;
    public TextView blP;
    public ImageView blQ;
    private CustomMessageListener blR;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.agO = new u(this);
        this.agt = new v(this);
        this.blR = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.Fp = tbPageContext;
        Y(getView());
    }

    private void Y(View view) {
        this.blM = view.findViewById(r.h.layout_root);
        this.aUq = view.findViewById(r.h.divider);
        this.aUT = (ClickableHeaderImageView) view.findViewById(r.h.image_user);
        this.aUT.setDefaultResource(17170445);
        this.aUT.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.aUT.setDefaultBgResource(r.e.cp_bg_line_e);
        this.aUT.setRadius(com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds70));
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.aUX = (UserIconLayout) view.findViewById(r.h.text_user_name);
        this.mTextTitle = (TextView) view.findViewById(r.h.text_title);
        this.blN = (FrameLayout) view.findViewById(r.h.frame_video);
        this.blO = (TbImageView) view.findViewById(r.h.image_video);
        this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.blO.setDefaultResource(0);
        this.blO.setDefaultErrorResource(0);
        this.blP = (TextView) view.findViewById(r.h.tv_ala_inlive);
        this.blQ = (ImageView) view.findViewById(r.h.image_video_play);
        this.aUW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.text_bottom);
        this.blM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(this.blM, r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.k(this.aUq, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.i((View) this.mTextTitle, r.e.cp_cont_c);
            com.baidu.tbadk.core.util.ap.c(this.blQ, r.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.ap.k(this.blN, r.e.cp_bg_line_k);
            this.aUX.tg();
            this.aUW.tg();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_ala_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.m mVar) {
        this.blL = mVar;
        Mf();
    }

    private void Mf() {
        if (this.blL == null || this.blL.Ji() == null) {
            this.blM.setVisibility(8);
            return;
        }
        this.blM.setVisibility(0);
        this.aUT.setVisibility(0);
        this.aUT.setData(this.blL.Ji());
        this.aUT.setAfterClickListener(this.agO);
        UserTbVipInfoData rx = this.blL.Ji().rx();
        if (rx != null && rx.getvipV_url() != null && this.aUU != null) {
            if (this.aUV == null) {
                this.aUU.inflate();
                this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
            }
            this.aUV.c(rx.getvipV_url(), 10, false);
            this.aUT.setIsBigV(true);
        }
        this.aUX.setVisibility(0);
        this.aUX.setData(this.blL.Ji());
        this.aUX.setUserAfterClickListener(this.agO);
        this.mTextTitle.setText(this.blL.aVi.getTitle());
        this.aUW.a(this.blL.Ji());
        this.aUW.setStType(at.Mt());
        this.aUW.setYuelaouLocate("feed#" + this.blL.Rz());
        this.aUW.setForumAfterClickListener(this.agt);
        onChangeSkinType(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.m13if(this.blL.aVi.getId())) {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_c, 1);
        }
        Rn();
        this.aUW.setBarNameClickEnabled(true);
    }

    public void Rn() {
        if (com.baidu.tbadk.core.l.oC().oI() && this.blL != null && this.blL.Ji() != null && this.blL.Ji().rO() != null) {
            this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
            this.blO.c(this.blL.Ji().rO().cover, 10, false);
            this.blN.setVisibility(0);
            return;
        }
        this.blN.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.blM) {
            Z(view);
        }
    }

    private void Z(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.blL);
        }
        if (this.blL != null && this.blL.Ji() != null && this.blL.Ji().rO() != null) {
            at.ie(this.blL.aVi.getId());
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.blL.Ji().rO().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.Fp.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aUW != null && this.blR != null) {
            this.aUW.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }
}

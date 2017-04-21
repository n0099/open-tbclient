package com.baidu.tieba.card;

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
    private TbPageContext<?> aaY;
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    public View baz;
    public ClickableHeaderImageView bbV;
    public ViewStub bbW;
    public TbImageView bbX;
    public ThreadCommentAndPraiseInfoLayout bbY;
    public UserIconLayout bbZ;
    private com.baidu.tieba.card.data.m buP;
    public View buQ;
    public FrameLayout buR;
    public TbImageView buS;
    public TextView buT;
    public ImageView buU;
    private com.baidu.tbadk.core.view.o buV;
    private CustomMessageListener buW;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buV = null;
        this.amx = new u(this);
        this.ama = new v(this);
        this.buW = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aaY = tbPageContext;
        W(getView());
    }

    private void W(View view) {
        this.buQ = view.findViewById(w.h.layout_root);
        this.baz = view.findViewById(w.h.divider);
        this.bbV = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbV.setDefaultResource(17170445);
        this.bbV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbV.setRadius(com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds70));
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bbZ = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.buR = (FrameLayout) view.findViewById(w.h.frame_video);
        this.buS = (TbImageView) view.findViewById(w.h.image_video);
        this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buS.setDefaultResource(0);
        this.buS.setDefaultErrorResource(0);
        this.buT = (TextView) view.findViewById(w.h.tv_ala_inlive);
        this.buU = (ImageView) view.findViewById(w.h.image_video_play);
        this.bbY = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.buQ.setOnClickListener(this);
    }

    public void TK() {
        if (this.buV == null) {
            this.buV = new com.baidu.tbadk.core.view.o(this.aaY);
            this.buV.wQ();
            this.bbY.addView(this.buV);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.buQ, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.baz, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.mTextTitle, w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.c(this.buU, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.k(this.buR, w.e.cp_bg_line_k);
            this.bbZ.onChangeSkinType();
            this.bbY.onChangeSkinType();
            if (this.buV != null) {
                this.buV.onChangeSkinType();
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
        this.buP = mVar;
        Ny();
    }

    private void Ny() {
        if (this.buP == null || this.buP.Kn() == null) {
            this.buQ.setVisibility(8);
            return;
        }
        this.buQ.setVisibility(0);
        this.bbV.setVisibility(0);
        this.bbV.setData(this.buP.Kn());
        this.bbV.setAfterClickListener(this.amx);
        UserTbVipInfoData sp = this.buP.Kn().sp();
        if (sp != null && sp.getvipV_url() != null && this.bbW != null) {
            if (this.bbX == null) {
                this.bbW.inflate();
                this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.bbX.c(sp.getvipV_url(), 10, false);
            this.bbV.setIsBigV(true);
        }
        this.bbZ.setVisibility(0);
        this.bbZ.setData(this.buP.Kn());
        this.bbZ.setUserAfterClickListener(this.amx);
        this.mTextTitle.setText(this.buP.bck.getTitle());
        this.bbY.a(this.buP.Kn());
        this.bbY.setStType(at.sf());
        this.bbY.setYuelaouLocate("feed#" + this.buP.TX());
        this.bbY.setForumAfterClickListener(this.ama);
        if (this.buV != null && this.buP.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.buP.Kn().getTid());
            alVar.setFid(this.buP.Kn().getFid());
            alVar.a(this.buP.WU);
            this.buV.setData(alVar);
        }
        onChangeSkinType(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.ia(this.buP.bck.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_c, 1);
        }
        TL();
        this.bbY.setBarNameClickEnabled(true);
    }

    public void TL() {
        if (com.baidu.tbadk.core.q.po().pu() && this.buP != null && this.buP.Kn() != null && this.buP.Kn().sG() != null) {
            this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.buS.c(this.buP.Kn().sG().cover, 10, false);
            this.buR.setVisibility(0);
            return;
        }
        this.buR.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.buV != null) {
            this.buV.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.buQ) {
            X(view);
        }
    }

    private void X(View view) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.showToast(this.aaY.getPageActivity(), w.l.no_network_guide);
            return;
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.buP);
        }
        if (this.buP != null && this.buP.Kn() != null && this.buP.Kn().sG() != null) {
            at.hZ(this.buP.bck.getId());
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.buP.Kn().sG().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.aaY.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbY != null && this.buW != null) {
            this.bbY.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }
}

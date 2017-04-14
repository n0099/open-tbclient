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
    private TbPageContext<?> aaX;
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    public ClickableHeaderImageView baZ;
    public View baw;
    public ViewStub bba;
    public TbImageView bbb;
    public ThreadCommentAndPraiseInfoLayout bbc;
    public UserIconLayout bbd;
    public TextView bsA;
    public ImageView bsB;
    private com.baidu.tbadk.core.view.o bsC;
    private CustomMessageListener bsD;
    private com.baidu.tieba.card.data.m bsw;
    public View bsx;
    public FrameLayout bsy;
    public TbImageView bsz;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsC = null;
        this.amx = new u(this);
        this.ama = new v(this);
        this.bsD = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aaX = tbPageContext;
        W(getView());
    }

    private void W(View view) {
        this.bsx = view.findViewById(w.h.layout_root);
        this.baw = view.findViewById(w.h.divider);
        this.baZ = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.baZ.setDefaultResource(17170445);
        this.baZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.baZ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.baZ.setRadius(com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds70));
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bbd = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bsy = (FrameLayout) view.findViewById(w.h.frame_video);
        this.bsz = (TbImageView) view.findViewById(w.h.image_video);
        this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsz.setDefaultResource(0);
        this.bsz.setDefaultErrorResource(0);
        this.bsA = (TextView) view.findViewById(w.h.tv_ala_inlive);
        this.bsB = (ImageView) view.findViewById(w.h.image_video_play);
        this.bbc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsx.setOnClickListener(this);
    }

    public void SI() {
        if (this.bsC == null) {
            this.bsC = new com.baidu.tbadk.core.view.o(this.aaX);
            this.bsC.wQ();
            this.bbc.addView(this.bsC);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bsx, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.baw, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.mTextTitle, w.e.cp_cont_c);
            com.baidu.tbadk.core.util.aq.c(this.bsB, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.k(this.bsy, w.e.cp_bg_line_k);
            this.bbd.onChangeSkinType();
            this.bbc.onChangeSkinType();
            if (this.bsC != null) {
                this.bsC.onChangeSkinType();
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
        this.bsw = mVar;
        Nq();
    }

    private void Nq() {
        if (this.bsw == null || this.bsw.Kn() == null) {
            this.bsx.setVisibility(8);
            return;
        }
        this.bsx.setVisibility(0);
        this.baZ.setVisibility(0);
        this.baZ.setData(this.bsw.Kn());
        this.baZ.setAfterClickListener(this.amx);
        UserTbVipInfoData sp = this.bsw.Kn().sp();
        if (sp != null && sp.getvipV_url() != null && this.bba != null) {
            if (this.bbb == null) {
                this.bba.inflate();
                this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.bbb.c(sp.getvipV_url(), 10, false);
            this.baZ.setIsBigV(true);
        }
        this.bbd.setVisibility(0);
        this.bbd.setData(this.bsw.Kn());
        this.bbd.setUserAfterClickListener(this.amx);
        this.mTextTitle.setText(this.bsw.bbo.getTitle());
        this.bbc.a(this.bsw.Kn());
        this.bbc.setStType(at.sf());
        this.bbc.setYuelaouLocate("feed#" + this.bsw.SV());
        this.bbc.setForumAfterClickListener(this.ama);
        if (this.bsC != null && this.bsw.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.bsw.Kn().getTid());
            alVar.setFid(this.bsw.Kn().getFid());
            alVar.a(this.bsw.WT);
            this.bsC.setData(alVar);
        }
        onChangeSkinType(this.aaX, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.hZ(this.bsw.bbo.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_c, 1);
        }
        SJ();
        this.bbc.setBarNameClickEnabled(true);
    }

    public void SJ() {
        if (com.baidu.tbadk.core.q.po().pu() && this.bsw != null && this.bsw.Kn() != null && this.bsw.Kn().sG() != null) {
            this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.bsz.c(this.bsw.Kn().sG().cover, 10, false);
            this.bsy.setVisibility(0);
            return;
        }
        this.bsy.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.bsC != null) {
            this.bsC.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsx) {
            X(view);
        }
    }

    private void X(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bsw);
        }
        if (this.bsw != null && this.bsw.Kn() != null && this.bsw.Kn().sG() != null) {
            at.hY(this.bsw.bbo.getId());
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bsw.Kn().sG().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aaX.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbc != null && this.bsD != null) {
            this.bbc.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }
}

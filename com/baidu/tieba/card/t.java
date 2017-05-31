package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aas;
    private View.OnClickListener alO;
    private View.OnClickListener alR;
    private View.OnClickListener ama;
    private CustomMessageListener bAA;
    private com.baidu.tieba.card.data.k bAy;
    public View bAz;
    public View bck;
    private ThreadUserInfoLayout bdH;
    public ThreadCommentAndPraiseInfoLayout bdI;
    public FrameLayout bvY;
    public TbImageView bvZ;
    public ImageView bwa;
    private View bzE;
    private com.baidu.tbadk.core.view.o bzF;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzF = null;
        this.ama = new u(this);
        this.alO = new v(this);
        this.bAA = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.alR = new x(this);
        this.aas = tbPageContext;
        R(getView());
    }

    private void R(View view) {
        this.bAz = view.findViewById(w.h.layout_root);
        this.bck = view.findViewById(w.h.divider_line);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_ala_video_user_info_layout);
        this.bzF = new com.baidu.tbadk.core.view.o(this.aas);
        this.bzF.wa();
        this.bzF.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bdH.addView(this.bzF);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bvY = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvY.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aas.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds80);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bvY.setLayoutParams(layoutParams);
        this.bvZ = (TbImageView) view.findViewById(w.h.image_video);
        this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bvZ.setDefaultResource(0);
        this.bvZ.setDefaultErrorResource(0);
        this.bwa = (ImageView) view.findViewById(w.h.image_video_play);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bdI.setOnClickListener(this);
        this.bdI.setReplyTimeVisible(false);
        this.bdI.setShowPraiseNum(true);
        this.bdI.setNeedAddPraiseIcon(true);
        this.bdI.setNeedAddReplyIcon(true);
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bAz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bAz, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.bck, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.mTextTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.c(this.bwa, w.g.home_ic_video);
            com.baidu.tbadk.core.util.aq.k(this.bvY, w.e.cp_bg_line_k);
            this.bdH.onChangeSkinType();
            this.bdI.onChangeSkinType();
            if (this.bzF != null) {
                this.bzF.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.bAy = kVar;
        MU();
    }

    private void MU() {
        if (this.bAy == null || this.bAy.LH() == null) {
            this.bAz.setVisibility(8);
            return;
        }
        this.bAz.setVisibility(0);
        this.bdH.a(this.bAy.LH());
        this.bdH.setUserAfterClickListener(this.ama);
        if (this.bdH.getHeaderImg() != null) {
            this.bdH.getHeaderImg().setData(this.bAy.LH());
        }
        this.bAy.LH().sc();
        String string = this.aas.getResources().getString(w.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + ((Object) this.bAy.LH().rU()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bdI.a(this.bAy.aYA)) {
            this.bzE.setVisibility(8);
        } else {
            this.bzE.setVisibility(0);
        }
        if (this.bzF != null && this.bAy.LH() != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.co(this.bAy.LH().getTid());
            anVar.setFid(this.bAy.LH().getFid());
            anVar.a(this.bAy.Wh);
            this.bzF.setData(anVar);
        }
        d(this.aas, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.ic(this.bAy.aYA.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        Uk();
    }

    public void Uk() {
        if (com.baidu.tbadk.core.r.oN().oT() && this.bAy != null && this.bAy.LH() != null && this.bAy.LH().rM() != null) {
            this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.bvZ.c(this.bAy.LH().rM().cover, 10, false);
            this.bvY.setVisibility(0);
            return;
        }
        this.bvY.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.bzF != null) {
            this.bzF.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAz) {
            V(view);
        }
    }

    private void V(View view) {
        if (Ud() != null) {
            Ud().a(view, this.bAy);
        }
        if (this.bAy != null && this.bAy.LH() != null && this.bAy.LH().rM() != null) {
            at.ib(this.bAy.aYA.getId());
            at.a(this.mTextTitle, this.bAy.aYA.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bAy.LH().rM().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aas.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdI != null && this.bAA != null) {
            if (this.bdH != null) {
                this.bdH.setPageUniqueId(bdUniqueId);
            }
            this.bAA.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bzF != null) {
                this.bzF.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bAA);
        }
    }
}

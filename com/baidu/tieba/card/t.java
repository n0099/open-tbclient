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
    private TbPageContext<?> aat;
    private View.OnClickListener amF;
    private View.OnClickListener amJ;
    private View.OnClickListener amS;
    private View bAx;
    private com.baidu.tbadk.core.view.o bAy;
    private com.baidu.tieba.card.data.k bBr;
    public View bBs;
    private CustomMessageListener bBt;
    public View ben;
    private ThreadUserInfoLayout bgE;
    public ThreadCommentAndPraiseInfoLayout bgF;
    public FrameLayout byJ;
    public TbImageView byK;
    public ImageView byL;
    public TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAy = null;
        this.amS = new u(this);
        this.amF = new v(this);
        this.bBt = new w(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amJ = new x(this);
        this.aat = tbPageContext;
        S(getView());
    }

    private void S(View view) {
        this.bBs = view.findViewById(w.h.layout_root);
        this.ben = view.findViewById(w.h.divider_line);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_ala_video_user_info_layout);
        this.bAy = new com.baidu.tbadk.core.view.o(this.aat);
        this.bAy.wr();
        this.bAy.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bgE.addView(this.bAy);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.byJ = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.byJ.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds80);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.byJ.setLayoutParams(layoutParams);
        this.byK = (TbImageView) view.findViewById(w.h.image_video);
        this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.byK.setDefaultResource(0);
        this.byK.setDefaultErrorResource(0);
        this.byL = (ImageView) view.findViewById(w.h.image_video_play);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bgF.setOnClickListener(this);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(false);
        this.bgF.setCommentNumEnable(false);
        this.bgF.setLiveAudienceEnable(true);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bgF.setLiveAudienceIcon(w.g.icon_home_card_live_n);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bBs.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(this.bBs, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.as.k(this.ben, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.i(this.mTextTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.c(this.byL, w.g.home_ic_video);
            com.baidu.tbadk.core.util.as.k(this.byJ, w.e.cp_bg_line_k);
            this.bgE.onChangeSkinType();
            this.bgF.onChangeSkinType();
            if (this.bAy != null) {
                this.bAy.onChangeSkinType();
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
        this.bBr = kVar;
        Oh();
    }

    private void Oh() {
        if (this.bBr == null || this.bBr.Mv() == null) {
            this.bBs.setVisibility(8);
            return;
        }
        this.bBs.setVisibility(0);
        this.bgE.a(this.bBr.Mv());
        this.bgE.setUserAfterClickListener(this.amS);
        if (this.bgE.getHeaderImg() != null) {
            this.bgE.getHeaderImg().setData(this.bBr.Mv());
        }
        this.bBr.Mv().rZ();
        String string = this.aat.getResources().getString(w.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + ((Object) this.bBr.Mv().rR()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bgF.a(this.bBr.bai)) {
            this.bAx.setVisibility(8);
        } else {
            this.bAx.setVisibility(0);
        }
        if (this.bAy != null && this.bBr.Mv() != null) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.cu(this.bBr.Mv().getTid());
            aoVar.setFid(this.bBr.Mv().getFid());
            aoVar.a(this.bBr.Wh);
            this.bAy.setData(aoVar);
        }
        d(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.iJ(this.bBr.bai.getId())) {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        Vz();
    }

    public void Vz() {
        if (com.baidu.tbadk.core.r.oK().oQ() && this.bBr != null && this.bBr.Mv() != null && this.bBr.Mv().rJ() != null) {
            this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.byK.c(this.bBr.Mv().rJ().cover, 10, false);
            this.byJ.setVisibility(0);
            return;
        }
        this.byJ.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.bAy != null) {
            this.bAy.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBs) {
            W(view);
        }
    }

    private void W(View view) {
        if (Vs() != null) {
            Vs().a(view, this.bBr);
        }
        if (this.bBr != null && this.bBr.Mv() != null && this.bBr.Mv().rJ() != null) {
            at.iI(this.bBr.bai.getId());
            at.a(this.mTextTitle, this.bBr.bai.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bBr.Mv().rJ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aat.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bgF != null && this.bBt != null) {
            if (this.bgE != null) {
                this.bgE.setPageUniqueId(bdUniqueId);
            }
            this.bBt.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bAy != null) {
                this.bAy.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bBt);
        }
    }
}

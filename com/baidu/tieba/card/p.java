package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
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
public class p extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aat;
    private View.OnClickListener alY;
    private View.OnClickListener amb;
    private View.OnClickListener amk;
    public View baV;
    private ThreadUserInfoLayout bcp;
    public ThreadCommentAndPraiseInfoLayout bcq;
    private com.baidu.tieba.card.data.k buM;
    public View buN;
    public FrameLayout buO;
    public TbImageView buP;
    public ImageView buQ;
    private View buR;
    private com.baidu.tbadk.core.view.o buS;
    private CustomMessageListener buT;
    public TextView mTextTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buS = null;
        this.amk = new q(this);
        this.alY = new r(this);
        this.buT = new s(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amb = new t(this);
        this.aat = tbPageContext;
        V(getView());
    }

    private void V(View view) {
        this.buN = view.findViewById(w.h.layout_root);
        this.baV = view.findViewById(w.h.divider_line);
        this.bcp = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_ala_video_user_info_layout);
        this.buS = new com.baidu.tbadk.core.view.o(this.aat);
        this.buS.wd();
        this.buS.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bcp.addView(this.buS);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.buO = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.buO.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds80);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.buO.setLayoutParams(layoutParams);
        this.buP = (TbImageView) view.findViewById(w.h.image_video);
        this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buP.setDefaultResource(0);
        this.buP.setDefaultErrorResource(0);
        this.buQ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bcq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bcq.setOnClickListener(this);
        this.bcq.setReplyTimeVisible(false);
        this.bcq.setShowPraiseNum(true);
        this.bcq.setNeedAddPraiseIcon(true);
        this.bcq.setNeedAddReplyIcon(true);
        this.bcq.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bcq.setPraiseIcon(w.g.icon_home_card_like_n);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
        this.buN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.buN, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.baV, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.mTextTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.c(this.buQ, w.g.home_ic_video);
            com.baidu.tbadk.core.util.aq.k(this.buO, w.e.cp_bg_line_k);
            this.bcp.onChangeSkinType();
            this.bcq.onChangeSkinType();
            if (this.buS != null) {
                this.buS.onChangeSkinType();
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
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.k kVar) {
        this.buM = kVar;
        MM();
    }

    private void MM() {
        if (this.buM == null || this.buM.JB() == null) {
            this.buN.setVisibility(8);
            return;
        }
        this.buN.setVisibility(0);
        this.bcp.a(this.buM.JB());
        this.bcp.setUserAfterClickListener(this.amk);
        if (this.bcp.getHeaderImg() != null) {
            this.bcp.getHeaderImg().setData(this.buM.JB());
        }
        this.mTextTitle.setText(new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.ala_live_title_prefix)) + this.buM.bcB.getTitle()));
        if (this.bcq.a(this.buM.bcB)) {
            this.buR.setVisibility(8);
        } else {
            this.buR.setVisibility(0);
        }
        if (this.buS != null && this.buM.JB() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.cp(this.buM.JB().getTid());
            amVar.setFid(this.buM.JB().getFid());
            amVar.a(this.buM.Wm);
            this.buS.setData(amVar);
        }
        onChangeSkinType(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        if (ap.hZ(this.buM.bcB.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        Td();
    }

    public void Td() {
        if (com.baidu.tbadk.core.r.oV().pb() && this.buM != null && this.buM.JB() != null && this.buM.JB().rQ() != null) {
            this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.buP.c(this.buM.JB().rQ().cover, 10, false);
            this.buO.setVisibility(0);
            return;
        }
        this.buO.setVisibility(8);
    }

    public void a(o.a aVar) {
        if (this.buS != null) {
            this.buS.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.buN) {
            W(view);
        }
    }

    private void W(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.buM);
        }
        if (this.buM != null && this.buM.JB() != null && this.buM.JB().rQ() != null) {
            ap.hY(this.buM.bcB.getId());
            ap.a(this.mTextTitle, this.buM.bcB.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.buM.JB().rQ().live_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aat.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcq != null && this.buT != null) {
            if (this.bcp != null) {
                this.bcp.setPageUniqueId(bdUniqueId);
            }
            this.buT.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.buS != null) {
                this.buS.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.buT);
        }
    }
}

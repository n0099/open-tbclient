package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> acp;
    private View.OnClickListener aoG;
    private View.OnClickListener aoM;
    private View.OnClickListener aoW;
    public TbImageView bEa;
    public ImageView bEb;
    private View bFO;
    private com.baidu.tbadk.core.view.h bFP;
    private com.baidu.tieba.card.data.k bGH;
    public View bGI;
    public RelativeLayout bGJ;
    private CustomMessageListener bGK;
    public View bhj;
    private ThreadUserInfoLayout bkV;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFP = null;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.We() != null) {
                    i.this.We().a(view, i.this.bGH);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.We() != null) {
                    i.this.We().a(view, i.this.bGH);
                }
            }
        };
        this.bGK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bGH != null && i.this.bGH.threadData != null && i.this.bGH.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bGH.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bGH.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bGH != null && !StringUtils.isNull(i.this.bGH.threadData.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bGH.threadData.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.aoG != null) {
                        i.this.aoG.onClick(view);
                    }
                }
            }
        };
        this.acp = tbPageContext;
        S(getView());
    }

    private void S(View view) {
        this.bGI = view.findViewById(d.h.layout_root);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bFP = new com.baidu.tbadk.core.view.h(this.acp);
        this.bFP.wK();
        this.bFP.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkV.addView(this.bFP);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bGJ = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGJ.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ag(this.acp.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bGJ.setLayoutParams(layoutParams);
        this.bEa = (TbImageView) view.findViewById(d.h.image_video);
        this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEa.setDefaultResource(0);
        this.bEa.setDefaultErrorResource(0);
        this.bEb = (ImageView) view.findViewById(d.h.image_video_play);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bkZ.setOnClickListener(this);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(false);
        this.bkZ.setNeedAddPraiseIcon(false);
        this.bkZ.setNeedAddReplyIcon(false);
        this.bkZ.setCommentNumEnable(false);
        this.bkZ.setLiveShareEnable(true);
        this.bkZ.setLiveAudienceEnable(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.bkZ.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bkZ.setFrom(1);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bGI.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bGI, d.g.addresslist_item_bg);
            ai.k(this.bhj, d.e.cp_bg_line_c);
            ai.i(this.mTextTitle, d.e.cp_cont_b);
            ai.c(this.bEb, d.g.btn_icon_play_live);
            ai.k(this.bGJ, d.e.cp_bg_line_k);
            this.bkV.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            if (this.bFP != null) {
                this.bFP.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.bGH = kVar;
        Oy();
    }

    private void Oy() {
        if (this.bGH == null || this.bGH.MF() == null) {
            this.bGI.setVisibility(8);
            return;
        }
        this.bGI.setVisibility(0);
        this.bkV.a(this.bGH.MF());
        this.bkV.setUserAfterClickListener(this.aoW);
        if (this.bkV.getHeaderImg() != null) {
            this.bkV.getHeaderImg().setData(this.bGH.MF());
        }
        this.bGH.MF().sn();
        String string = this.acp.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bGH.MF().sf()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bkZ.a(this.bGH.threadData)) {
            this.bFO.setVisibility(8);
        } else {
            this.bFO.setVisibility(0);
        }
        if (this.bFP != null && this.bGH.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bGH.MF().getTid());
            anVar.setFid(this.bGH.MF().getFid());
            anVar.a(this.bGH.XT);
            this.bFP.setData(anVar);
            this.bFP.setFirstRowSingleColumn(true);
        }
        d(this.acp, TbadkCoreApplication.getInst().getSkinType());
        if (m.je(this.bGH.threadData.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        Wl();
    }

    public void Wl() {
        if (com.baidu.tbadk.core.h.oX().pd() && this.bGH != null && this.bGH.MF() != null && this.bGH.MF().rX() != null) {
            this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bEa.c(this.bGH.MF().rX().cover, 10, false);
            this.bGJ.setVisibility(0);
            return;
        }
        this.bGJ.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bFP != null) {
            this.bFP.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGI) {
            W(view);
        }
    }

    private void W(View view) {
        if (We() != null) {
            We().a(view, this.bGH);
        }
        if (this.bGH != null && this.bGH.MF() != null && this.bGH.MF().rX() != null) {
            m.jd(this.bGH.threadData.getId());
            m.a(this.mTextTitle, this.bGH.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bGH.MF().rX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.acp.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkZ != null && this.bGK != null) {
            if (this.bkV != null) {
                this.bkV.setPageUniqueId(bdUniqueId);
            }
            this.bGK.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bFP != null) {
                this.bFP.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bGK);
        }
    }
}

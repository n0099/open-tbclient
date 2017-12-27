package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aQq;
    public ImageView bYm;
    private View.OnClickListener bbR;
    private View.OnClickListener bce;
    private com.baidu.tieba.card.data.k cOH;
    public FrameLayout cOI;
    public RelativeLayout cOJ;
    public TbImageView cOK;
    private TextView cOL;
    private View cOM;
    private AlaPlayAnimationView cON;
    private CustomMessageListener cOO;
    private View.OnClickListener cOP;
    public View cdQ;
    private ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private com.baidu.tieba.NEGFeedBack.c ciP;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciP = null;
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aiY() != null) {
                    i.this.aiY().a(view, i.this.cOH);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aiY() != null) {
                    i.this.aiY().a(view, i.this.cOH);
                }
            }
        };
        this.cOO = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.cOH != null && i.this.cOH.threadData != null && i.this.cOH.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.cOH.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.cOH.threadData.getId(), d.C0108d.cp_cont_d, d.C0108d.cp_cont_d);
                }
            }
        };
        this.cOP = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cOH != null && !StringUtils.isNull(i.this.cOH.threadData.zd())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.cOH.threadData.zd(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.bbR != null) {
                        i.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.aQq = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cOI = (FrameLayout) view.findViewById(d.g.layout_root);
        this.cdQ = view.findViewById(d.g.divider_line);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(this.aQq);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(aiX());
        this.ciP.a(this.cOI, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cOJ = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOJ.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aQq.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cOJ.setLayoutParams(layoutParams);
        this.cOK = (TbImageView) view.findViewById(d.g.image_video);
        this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cOK.setDefaultResource(0);
        this.cOK.setDefaultErrorResource(0);
        this.cON = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bYm = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciE.setOnClickListener(this);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setNeedAddPraiseIcon(true);
        if (this.ciE.getCommentContainer() != null) {
            this.ciE.getCommentContainer().setOnClickListener(this);
        }
        this.ciE.setShareVisible(true);
        this.ciE.setFrom(1);
        this.cOL = (TextView) view.findViewById(d.g.play_count);
        this.cOM = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cOI.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cOI, d.f.addresslist_item_bg);
            aj.t(this.cdQ, d.C0108d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0108d.cp_cont_b);
            aj.r(this.cOL, d.C0108d.cp_cont_i);
            aj.c(this.bYm, d.f.btn_icon_play_live_on_n);
            aj.t(this.cOJ, d.C0108d.cp_bg_line_k);
            this.ciD.onChangeSkinType();
            this.ciE.onChangeSkinType();
            if (this.ciP != null) {
                this.ciP.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.cOH = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cOH == null || this.cOH.VW() == null) {
            this.cOI.setVisibility(8);
            return;
        }
        this.cOI.setVisibility(0);
        this.ciD.setData(this.cOH.VW());
        this.ciD.setUserAfterClickListener(this.bce);
        if (this.ciD.getHeaderImg() != null) {
            this.ciD.getHeaderImg().setData(this.cOH.VW());
        }
        this.cOH.VW().zF();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cOH.VW().zx()));
        if (this.ciE.setData(this.cOH.threadData)) {
            this.cOM.setVisibility(8);
        } else {
            this.cOM.setVisibility(0);
        }
        this.cOL.setText(String.format(this.aQq.getResources().getString(d.j.ala_audience_count_prefix), am.I(this.cOH.threadData.zq().audience_count)));
        if (this.ciP != null && this.cOH.VW() != null) {
            ai aiVar = new ai();
            aiVar.cK(this.cOH.VW().getTid());
            aiVar.setFid(this.cOH.VW().getFid());
            aiVar.a(this.cOH.aLZ);
            this.ciP.setData(aiVar);
            this.ciP.setFirstRowSingleColumn(true);
        }
        d(this.aQq, TbadkCoreApplication.getInst().getSkinType());
        if (k.jU(this.cOH.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
        ajf();
        this.cON.startPlayAnimation();
    }

    public void ajf() {
        if (com.baidu.tbadk.core.i.wB().wH() && this.cOH != null && this.cOH.VW() != null && this.cOH.VW().zq() != null) {
            this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cOK.startLoad(this.cOH.VW().zq().cover, 10, false);
            this.cOJ.setVisibility(0);
            return;
        }
        this.cOJ.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.ciP != null) {
            this.ciP.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cOI || view == this.ciE.getCommentContainer()) {
            bz(view);
        }
    }

    private void bz(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cOH);
        }
        if (this.cOH != null && this.cOH.VW() != null && this.cOH.VW().zq() != null) {
            k.jT(this.cOH.threadData.getId());
            k.a(this.mTextTitle, this.cOH.threadData.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cOH.VW().zq());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.aQq.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciE != null && this.cOO != null) {
            if (this.ciD != null) {
                this.ciD.setPageUniqueId(bdUniqueId);
            }
            this.cOO.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.ciP != null) {
                this.ciP.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cOO);
        }
    }
}

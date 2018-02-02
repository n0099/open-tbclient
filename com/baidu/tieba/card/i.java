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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aQs;
    public ImageView bYB;
    private View.OnClickListener bbZ;
    private View.OnClickListener bcm;
    public ThreadSourceShareAndPraiseLayout cSM;
    private com.baidu.tieba.card.data.k cTD;
    public FrameLayout cTE;
    public RelativeLayout cTF;
    public TbImageView cTG;
    private TextView cTH;
    private View cTI;
    private AlaPlayAnimationView cTJ;
    private CustomMessageListener cTK;
    private View.OnClickListener cTL;
    public View cef;
    private ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private com.baidu.tieba.NEGFeedBack.c cje;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cje = null;
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akg() != null) {
                    i.this.akg().a(view, i.this.cTD);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akg() != null) {
                    i.this.akg().a(view, i.this.cTD);
                }
            }
        };
        this.cTK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.cTD != null && i.this.cTD.threadData != null && i.this.cTD.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.cTD.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.cTD.threadData.getId(), d.C0108d.cp_cont_d, d.C0108d.cp_cont_d);
                }
            }
        };
        this.cTL = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cTD != null && !StringUtils.isNull(i.this.cTD.threadData.yZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.cTD.threadData.yZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.bbZ != null) {
                        i.this.bbZ.onClick(view);
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cTE = (FrameLayout) view.findViewById(d.g.layout_root);
        this.cef = view.findViewById(d.g.divider_line);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(this.aQs);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(akf());
        this.cje.a(this.cTE, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cTF = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cTF.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aQs.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cTF.setLayoutParams(layoutParams);
        this.cTG = (TbImageView) view.findViewById(d.g.image_video);
        this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTG.setDefaultResource(0);
        this.cTG.setDefaultErrorResource(0);
        this.cTJ = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bYB = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciT.setOnClickListener(this);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setNeedAddPraiseIcon(true);
        if (this.ciT.getCommentContainer() != null) {
            this.ciT.getCommentContainer().setOnClickListener(this);
        }
        this.ciT.setShareVisible(true);
        this.ciT.setFrom(7);
        this.ciT.setShareReportFrom(3);
        this.cSM = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.cSM.bcI.setOnClickListener(this);
        this.cSM.setFrom(7);
        this.cSM.setShareReportFrom(3);
        if (this.cSM.bcI.getCommentContainer() != null) {
            this.cSM.bcI.getCommentContainer().setOnClickListener(this);
        }
        this.cTH = (TextView) view.findViewById(d.g.play_count);
        this.cTI = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cTE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cTE, d.f.addresslist_item_bg);
            aj.t(this.cef, d.C0108d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0108d.cp_cont_b);
            aj.r(this.cTH, d.C0108d.cp_cont_i);
            aj.c(this.bYB, d.f.btn_icon_play_live_on_n);
            aj.t(this.cTF, d.C0108d.cp_bg_line_k);
            this.ciS.onChangeSkinType();
            this.ciT.onChangeSkinType();
            if (this.cje != null) {
                this.cje.onChangeSkinType();
            }
            this.cSM.onChangeSkinType();
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
        this.cTD = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cTD == null || this.cTD.VM() == null) {
            this.cTE.setVisibility(8);
            return;
        }
        this.cTE.setVisibility(0);
        this.ciS.setData(this.cTD.VM());
        this.ciS.setUserAfterClickListener(this.bcm);
        if (this.ciS.getHeaderImg() != null) {
            this.ciS.getHeaderImg().setData(this.cTD.VM());
        }
        this.cTD.VM().zC();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cTD.VM().zt()));
        this.cTH.setText(String.format(this.aQs.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cTD.threadData.zm().audience_count)));
        if (this.cje != null && this.cTD.VM() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cTD.VM().getTid());
            ahVar.setFid(this.cTD.VM().getFid());
            ahVar.a(this.cTD.aLY);
            this.cje.setData(ahVar);
            this.cje.setFirstRowSingleColumn(true);
        }
        lD(this.cTD.VM().aPd);
        d(this.aQs, TbadkCoreApplication.getInst().getSkinType());
        if (k.kl(this.cTD.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
        akn();
        this.cTJ.startPlayAnimation();
    }

    public void akn() {
        if (com.baidu.tbadk.core.i.wB().wH() && this.cTD != null && this.cTD.VM() != null && this.cTD.VM().zm() != null) {
            this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cTG.startLoad(this.cTD.VM().zm().cover, 10, false);
            this.cTF.setVisibility(0);
            return;
        }
        this.cTF.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.cje != null) {
            this.cje.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cTE || view == this.ciT.getCommentContainer() || view == this.cSM.bcI.getCommentContainer()) {
            bB(view);
        }
    }

    private void bB(View view) {
        if (akg() != null) {
            akg().a(view, this.cTD);
        }
        if (this.cTD != null && this.cTD.VM() != null && this.cTD.VM().zm() != null) {
            k.kk(this.cTD.threadData.getId());
            k.a(this.mTextTitle, this.cTD.threadData.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cTD.VM().zm());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.aQs.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciT != null && this.cTK != null) {
            if (this.ciS != null) {
                this.ciS.setPageUniqueId(bdUniqueId);
            }
            this.cTK.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cje != null) {
                this.cje.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cTK);
        }
    }

    public void lD(int i) {
        if (this.cTD != null && this.cTD.threadData != null) {
            if (i == 1) {
                this.ciT.setVisibility(8);
                this.cSM.setData(this.cTD.threadData);
                this.ciS.showForumNameView(false);
                return;
            }
            this.cSM.setVisibility(8);
            this.ciS.showForumNameView(true);
            if (this.ciT.setData(this.cTD.threadData)) {
                this.cTI.setVisibility(8);
            } else {
                this.cTI.setVisibility(0);
            }
        }
    }
}

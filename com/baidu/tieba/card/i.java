package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.al;
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
    private TbPageContext<?> abI;
    private View.OnClickListener anA;
    private View.OnClickListener anS;
    public View aom;
    private com.baidu.tieba.NEGFeedBack.c bQR;
    private com.baidu.tieba.card.data.k bRK;
    public View bRL;
    public RelativeLayout bRM;
    public TbImageView bRN;
    public ImageView bRO;
    private TextView bRP;
    private View bRQ;
    private AlaPlayAnimationView bRR;
    private CustomMessageListener bRS;
    private View.OnClickListener bRT;
    public ThreadCommentAndPraiseInfoLayout boD;
    private ThreadUserInfoLayout boz;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQR = null;
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Zx() != null) {
                    i.this.Zx().a(view, i.this.bRK);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Zx() != null) {
                    i.this.Zx().a(view, i.this.bRK);
                }
            }
        };
        this.bRS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bRK != null && i.this.bRK.blk != null && i.this.bRK.blk.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bRK.blk.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bRK.blk.getId(), d.C0080d.cp_cont_d, d.C0080d.cp_cont_d);
                }
            }
        };
        this.bRT = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bRK != null && !StringUtils.isNull(i.this.bRK.blk.rz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bRK.blk.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anA != null) {
                        i.this.anA.onClick(view);
                    }
                }
            }
        };
        this.abI = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bRL = view.findViewById(d.g.layout_root);
        this.aom = view.findViewById(d.g.divider_line);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bQR = new com.baidu.tieba.NEGFeedBack.c(this.abI);
        this.bQR.Ku();
        this.bQR.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boz.addView(this.bQR);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bRM = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRM.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bRM.setLayoutParams(layoutParams);
        this.bRN = (TbImageView) view.findViewById(d.g.image_video);
        this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bRN.setDefaultResource(0);
        this.bRN.setDefaultErrorResource(0);
        this.bRR = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bRO = (ImageView) view.findViewById(d.g.image_video_play);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.boD.setOnClickListener(this);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setCommentNumEnable(false);
        this.boD.setLiveAudienceEnable(false);
        this.boD.setShareVisible(true);
        this.boD.setFrom(1);
        this.bRP = (TextView) view.findViewById(d.g.play_count);
        this.bRQ = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bRL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bRL, d.f.addresslist_item_bg);
            aj.k(this.aom, d.C0080d.cp_bg_line_e);
            aj.i(this.mTextTitle, d.C0080d.cp_cont_b);
            aj.i(this.bRP, d.C0080d.cp_cont_i);
            aj.c(this.bRO, d.f.btn_icon_play_live_on_n);
            aj.k(this.bRM, d.C0080d.cp_bg_line_k);
            this.boz.onChangeSkinType();
            this.boD.onChangeSkinType();
            if (this.bQR != null) {
                this.bQR.onChangeSkinType();
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
        this.bRK = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bRK == null || this.bRK.Np() == null) {
            this.bRL.setVisibility(8);
            return;
        }
        this.bRL.setVisibility(0);
        this.boz.setData(this.bRK.Np());
        this.boz.setUserAfterClickListener(this.anS);
        if (this.boz.getHeaderImg() != null) {
            this.boz.getHeaderImg().setData(this.bRK.Np());
        }
        this.bRK.Np().sc();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bRK.Np().rU()));
        if (this.boD.setData(this.bRK.blk)) {
            this.bRQ.setVisibility(8);
        } else {
            this.bRQ.setVisibility(0);
        }
        this.bRP.setText(String.format(this.abI.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bRK.blk.rM().audience_count)));
        if (this.bQR != null && this.bRK.Np() != null) {
            al alVar = new al();
            alVar.cD(this.bRK.Np().getTid());
            alVar.setFid(this.bRK.Np().getFid());
            alVar.a(this.bRK.Xm);
            this.bQR.setData(alVar);
            this.bQR.setFirstRowSingleColumn(true);
        }
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jL(this.bRK.blk.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
        ZE();
        this.bRR.ZZ();
    }

    public void ZE() {
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bRK != null && this.bRK.Np() != null && this.bRK.Np().rM() != null) {
            this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.bRN.startLoad(this.bRK.Np().rM().cover, 10, false);
            this.bRM.setVisibility(0);
            return;
        }
        this.bRM.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bQR != null) {
            this.bQR.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRL) {
            af(view);
        }
    }

    private void af(View view) {
        if (Zx() != null) {
            Zx().a(view, this.bRK);
        }
        if (this.bRK != null && this.bRK.Np() != null && this.bRK.Np().rM() != null) {
            m.jK(this.bRK.blk.getId());
            m.a(this.mTextTitle, this.bRK.blk.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bRK.Np().rM());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.abI.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boD != null && this.bRS != null) {
            if (this.boz != null) {
                this.boz.setPageUniqueId(bdUniqueId);
            }
            this.bRS.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bQR != null) {
                this.bQR.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bRS);
        }
    }
}

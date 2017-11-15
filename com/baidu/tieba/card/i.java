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
    private View.OnClickListener anR;
    private View.OnClickListener anz;
    public View aol;
    private com.baidu.tieba.card.data.k bRX;
    public View bRY;
    public RelativeLayout bRZ;
    private com.baidu.tieba.NEGFeedBack.c bRe;
    public TbImageView bSa;
    public ImageView bSb;
    private TextView bSc;
    private View bSd;
    private AlaPlayAnimationView bSe;
    private CustomMessageListener bSf;
    private View.OnClickListener bSg;
    private ThreadUserInfoLayout boI;
    public ThreadCommentAndPraiseInfoLayout boM;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bRe = null;
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.ZJ() != null) {
                    i.this.ZJ().a(view, i.this.bRX);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.ZJ() != null) {
                    i.this.ZJ().a(view, i.this.bRX);
                }
            }
        };
        this.bSf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bRX != null && i.this.bRX.blt != null && i.this.bRX.blt.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bRX.blt.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bRX.blt.getId(), d.C0080d.cp_cont_d, d.C0080d.cp_cont_d);
                }
            }
        };
        this.bSg = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bRX != null && !StringUtils.isNull(i.this.bRX.blt.rz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bRX.blt.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anz != null) {
                        i.this.anz.onClick(view);
                    }
                }
            }
        };
        this.abI = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bRY = view.findViewById(d.g.layout_root);
        this.aol = view.findViewById(d.g.divider_line);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bRe = new com.baidu.tieba.NEGFeedBack.c(this.abI);
        this.bRe.KF();
        this.bRe.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boI.addView(this.bRe);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bRZ = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRZ.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bRZ.setLayoutParams(layoutParams);
        this.bSa = (TbImageView) view.findViewById(d.g.image_video);
        this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bSa.setDefaultResource(0);
        this.bSa.setDefaultErrorResource(0);
        this.bSe = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bSb = (ImageView) view.findViewById(d.g.image_video_play);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.boM.setOnClickListener(this);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setCommentNumEnable(false);
        this.boM.setLiveAudienceEnable(false);
        this.boM.setShareVisible(true);
        this.boM.setFrom(1);
        this.bSc = (TextView) view.findViewById(d.g.play_count);
        this.bSd = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bRY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bRY, d.f.addresslist_item_bg);
            aj.k(this.aol, d.C0080d.cp_bg_line_e);
            aj.i(this.mTextTitle, d.C0080d.cp_cont_b);
            aj.i(this.bSc, d.C0080d.cp_cont_i);
            aj.c(this.bSb, d.f.btn_icon_play_live_on_n);
            aj.k(this.bRZ, d.C0080d.cp_bg_line_k);
            this.boI.onChangeSkinType();
            this.boM.onChangeSkinType();
            if (this.bRe != null) {
                this.bRe.onChangeSkinType();
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
        this.bRX = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bRX == null || this.bRX.NA() == null) {
            this.bRY.setVisibility(8);
            return;
        }
        this.bRY.setVisibility(0);
        this.boI.setData(this.bRX.NA());
        this.boI.setUserAfterClickListener(this.anR);
        if (this.boI.getHeaderImg() != null) {
            this.boI.getHeaderImg().setData(this.bRX.NA());
        }
        this.bRX.NA().sc();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bRX.NA().rU()));
        if (this.boM.setData(this.bRX.blt)) {
            this.bSd.setVisibility(8);
        } else {
            this.bSd.setVisibility(0);
        }
        this.bSc.setText(String.format(this.abI.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bRX.blt.rM().audience_count)));
        if (this.bRe != null && this.bRX.NA() != null) {
            al alVar = new al();
            alVar.cD(this.bRX.NA().getTid());
            alVar.setFid(this.bRX.NA().getFid());
            alVar.a(this.bRX.Xm);
            this.bRe.setData(alVar);
            this.bRe.setFirstRowSingleColumn(true);
        }
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jM(this.bRX.blt.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
        ZQ();
        this.bSe.aal();
    }

    public void ZQ() {
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bRX != null && this.bRX.NA() != null && this.bRX.NA().rM() != null) {
            this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.bSa.startLoad(this.bRX.NA().rM().cover, 10, false);
            this.bRZ.setVisibility(0);
            return;
        }
        this.bRZ.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bRe != null) {
            this.bRe.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRY) {
            af(view);
        }
    }

    private void af(View view) {
        if (ZJ() != null) {
            ZJ().a(view, this.bRX);
        }
        if (this.bRX != null && this.bRX.NA() != null && this.bRX.NA().rM() != null) {
            m.jL(this.bRX.blt.getId());
            m.a(this.mTextTitle, this.bRX.blt.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bRX.NA().rM());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.abI.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boM != null && this.bSf != null) {
            if (this.boI != null) {
                this.boI.setPageUniqueId(bdUniqueId);
            }
            this.bSf.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bRe != null) {
                this.bRe.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bSf);
        }
    }
}

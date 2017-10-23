package com.baidu.tieba.card;

import android.content.Context;
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
    private TbPageContext<?> abm;
    public View anR;
    private View.OnClickListener anf;
    private View.OnClickListener anx;
    private com.baidu.tieba.NEGFeedBack.c bJl;
    private com.baidu.tieba.card.data.k bKe;
    public View bKf;
    public RelativeLayout bKg;
    public TbImageView bKh;
    public ImageView bKi;
    private TextView bKj;
    private View bKk;
    private AlaPlayAnimationView bKl;
    private CustomMessageListener bKm;
    private View.OnClickListener bKn;
    private ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJl = null;
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xn() != null) {
                    i.this.Xn().a(view, i.this.bKe);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xn() != null) {
                    i.this.Xn().a(view, i.this.bKe);
                }
            }
        };
        this.bKm = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bKe != null && i.this.bKe.threadData != null && i.this.bKe.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bKe.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bKe.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bKe != null && !StringUtils.isNull(i.this.bKe.threadData.rt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bKe.threadData.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anf != null) {
                        i.this.anf.onClick(view);
                    }
                }
            }
        };
        this.abm = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bKf = view.findViewById(d.h.layout_root);
        this.anR = view.findViewById(d.h.divider_line);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bJl = new com.baidu.tieba.NEGFeedBack.c(this.abm);
        this.bJl.Kl();
        this.bJl.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bmR.addView(this.bJl);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bKg = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKg.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ad(this.abm.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bKg.setLayoutParams(layoutParams);
        this.bKh = (TbImageView) view.findViewById(d.h.image_video);
        this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKh.setDefaultResource(0);
        this.bKh.setDefaultErrorResource(0);
        this.bKl = (AlaPlayAnimationView) view.findViewById(d.h.ala_play);
        this.bKi = (ImageView) view.findViewById(d.h.image_video_play);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bmV.setOnClickListener(this);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setCommentNumEnable(false);
        this.bmV.setLiveAudienceEnable(false);
        this.bmV.setShareVisible(true);
        this.bmV.setFrom(1);
        this.bKj = (TextView) view.findViewById(d.h.play_count);
        this.bKk = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKf.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bKf, d.g.addresslist_item_bg);
            aj.k(this.anR, d.e.cp_bg_line_e);
            aj.i(this.mTextTitle, d.e.cp_cont_b);
            aj.i(this.bKj, d.e.cp_cont_i);
            aj.c(this.bKi, d.g.btn_icon_play_live_on_n);
            aj.k(this.bKg, d.e.cp_bg_line_k);
            this.bmR.onChangeSkinType();
            this.bmV.onChangeSkinType();
            if (this.bJl != null) {
                this.bJl.onChangeSkinType();
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
        this.bKe = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bKe == null || this.bKe.Nd() == null) {
            this.bKf.setVisibility(8);
            return;
        }
        this.bKf.setVisibility(0);
        this.bmR.setData(this.bKe.Nd());
        this.bmR.setUserAfterClickListener(this.anx);
        if (this.bmR.getHeaderImg() != null) {
            this.bmR.getHeaderImg().setData(this.bKe.Nd());
        }
        this.bKe.Nd().rW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bKe.Nd().rO()));
        if (this.bmV.setData(this.bKe.threadData)) {
            this.bKk.setVisibility(8);
        } else {
            this.bKk.setVisibility(0);
        }
        this.bKj.setText(String.format(this.abm.getResources().getString(d.l.ala_audience_count_prefix), am.A(this.bKe.threadData.rG().audience_count)));
        if (this.bJl != null && this.bKe.Nd() != null) {
            al alVar = new al();
            alVar.cx(this.bKe.Nd().getTid());
            alVar.setFid(this.bKe.Nd().getFid());
            alVar.a(this.bKe.WU);
            this.bJl.setData(alVar);
            this.bJl.setFirstRowSingleColumn(true);
        }
        d(this.abm, TbadkCoreApplication.getInst().getSkinType());
        if (m.jm(this.bKe.threadData.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        Xu();
        this.bKl.XP();
    }

    public void Xu() {
        if (com.baidu.tbadk.core.h.oM().oS() && this.bKe != null && this.bKe.Nd() != null && this.bKe.Nd().rG() != null) {
            this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bKh.c(this.bKe.Nd().rG().cover, 10, false);
            this.bKg.setVisibility(0);
            return;
        }
        this.bKg.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bJl != null) {
            this.bJl.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKf) {
            ac(view);
        }
    }

    private void ac(View view) {
        if (Xn() != null) {
            Xn().a(view, this.bKe);
        }
        if (this.bKe != null && this.bKe.Nd() != null && this.bKe.Nd().rG() != null) {
            m.jl(this.bKe.threadData.getId());
            m.a(this.mTextTitle, this.bKe.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKe.Nd().rG());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.abm.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bmV != null && this.bKm != null) {
            if (this.bmR != null) {
                this.bmR.setPageUniqueId(bdUniqueId);
            }
            this.bKm.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bJl != null) {
                this.bJl.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bKm);
        }
    }
}

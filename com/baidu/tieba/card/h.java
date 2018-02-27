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
public class h extends a<com.baidu.tieba.card.data.j> {
    private TbPageContext<?> aRG;
    private View.OnClickListener bdE;
    private View.OnClickListener bdQ;
    private com.baidu.tieba.card.data.j cWa;
    public FrameLayout cWb;
    public RelativeLayout cWc;
    public TbImageView cWd;
    private TextView cWe;
    private View cWf;
    private AlaPlayAnimationView cWg;
    private CustomMessageListener cWh;
    private View.OnClickListener cWi;
    public ImageView cax;
    public View chL;
    private ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    public ThreadSourceShareAndPraiseLayout cmL;
    private com.baidu.tieba.NEGFeedBack.c cmj;
    public TextView mTextTitle;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmj = null;
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akO() != null) {
                    h.this.akO().a(view, h.this.cWa);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akO() != null) {
                    h.this.akO().a(view, h.this.cWa);
                }
            }
        };
        this.cWh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cWa != null && h.this.cWa.threadData != null && h.this.cWa.threadData.getTid() != null && h.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(h.this.cWa.threadData.getTid())) {
                    j.a(h.this.mTextTitle, h.this.cWa.threadData.getId(), d.C0141d.cp_cont_d, d.C0141d.cp_cont_d);
                }
            }
        };
        this.cWi = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cWa != null && !StringUtils.isNull(h.this.cWa.threadData.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(h.this.getContext()).createNormalCfg(h.this.cWa.threadData.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (h.this.bdE != null) {
                        h.this.bdE.onClick(view);
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cWb = (FrameLayout) view.findViewById(d.g.layout_root);
        this.chL = view.findViewById(d.g.divider_line);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(this.aRG);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(akN());
        this.cmj.a(this.cWb, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cWc = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWc.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aRG.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cWc.setLayoutParams(layoutParams);
        this.cWd = (TbImageView) view.findViewById(d.g.image_video);
        this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWd.setDefaultResource(0);
        this.cWd.setDefaultErrorResource(0);
        this.cWg = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.cax = (ImageView) view.findViewById(d.g.image_video_play);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.clX.setOnClickListener(this);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setNeedAddPraiseIcon(true);
        if (this.clX.getCommentContainer() != null) {
            this.clX.getCommentContainer().setOnClickListener(this);
        }
        this.clX.setShareVisible(true);
        this.clX.setFrom(7);
        this.clX.setShareReportFrom(3);
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this);
        this.cmL.setFrom(7);
        this.cmL.setShareReportFrom(3);
        if (this.cmL.bem.getCommentContainer() != null) {
            this.cmL.bem.getCommentContainer().setOnClickListener(this);
        }
        this.cWe = (TextView) view.findViewById(d.g.play_count);
        this.cWf = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cWb, d.f.addresslist_item_bg);
            aj.t(this.chL, d.C0141d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0141d.cp_cont_b);
            aj.r(this.cWe, d.C0141d.cp_cont_i);
            aj.c(this.cax, d.f.btn_icon_play_live_on_n);
            aj.t(this.cWc, d.C0141d.cp_bg_line_k);
            this.clW.onChangeSkinType();
            this.clX.onChangeSkinType();
            if (this.cmj != null) {
                this.cmj.onChangeSkinType();
            }
            this.cmL.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.cWa = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cWa == null || this.cWa.WD() == null) {
            this.cWb.setVisibility(8);
            return;
        }
        this.cWb.setVisibility(0);
        this.clW.setData(this.cWa.WD());
        this.clW.setUserAfterClickListener(this.bdQ);
        if (this.clW.getHeaderImg() != null) {
            this.clW.getHeaderImg().setData(this.cWa.WD());
        }
        this.cWa.WD().zW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cWa.WD().zN()));
        this.cWe.setText(String.format(this.aRG.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWa.threadData.zG().audience_count)));
        if (this.cmj != null && this.cWa.WD() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWa.WD().getTid());
            ahVar.setFid(this.cWa.WD().getFid());
            ahVar.a(this.cWa.aNg);
            this.cmj.setData(ahVar);
            this.cmj.setFirstRowSingleColumn(true);
        }
        jX(this.cWa.WD().aQo);
        d(this.aRG, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWa.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        akV();
        this.cWg.startPlayAnimation();
    }

    public void akV() {
        if (com.baidu.tbadk.core.i.xo().xu() && this.cWa != null && this.cWa.WD() != null && this.cWa.WD().zG() != null) {
            this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cWd.startLoad(this.cWa.WD().zG().cover, 10, false);
            this.cWc.setVisibility(0);
            return;
        }
        this.cWc.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.cmj != null) {
            this.cmj.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWb || view == this.clX.getCommentContainer() || view == this.cmL.bem.getCommentContainer()) {
            bA(view);
        }
    }

    private void bA(View view) {
        if (akO() != null) {
            akO().a(view, this.cWa);
        }
        if (this.cWa != null && this.cWa.WD() != null && this.cWa.WD().zG() != null) {
            j.kr(this.cWa.threadData.getId());
            j.a(this.mTextTitle, this.cWa.threadData.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWa.WD().zG());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.aRG.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.clX != null && this.cWh != null) {
            if (this.clW != null) {
                this.clW.setPageUniqueId(bdUniqueId);
            }
            this.cWh.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cmj != null) {
                this.cmj.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cWh);
        }
    }

    public void jX(int i) {
        if (this.cWa != null && this.cWa.threadData != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.cWa.threadData);
                this.clW.showForumNameView(false);
                return;
            }
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
            if (this.clX.setData(this.cWa.threadData)) {
                this.cWf.setVisibility(8);
            } else {
                this.cWf.setVisibility(0);
            }
        }
    }
}

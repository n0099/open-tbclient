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
    private TbPageContext<?> aRI;
    private View.OnClickListener bdG;
    private View.OnClickListener bdT;
    private com.baidu.tieba.card.data.j cWd;
    public FrameLayout cWe;
    public RelativeLayout cWf;
    public TbImageView cWg;
    private TextView cWh;
    private View cWi;
    private AlaPlayAnimationView cWj;
    private CustomMessageListener cWk;
    private View.OnClickListener cWl;
    public ImageView caA;
    public View chO;
    private ThreadUserInfoLayout clZ;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private com.baidu.tieba.NEGFeedBack.c cmm;
    public TextView mTextTitle;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmm = null;
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.cWd);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.cWd);
                }
            }
        };
        this.cWk = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cWd != null && h.this.cWd.threadData != null && h.this.cWd.threadData.getTid() != null && h.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(h.this.cWd.threadData.getTid())) {
                    j.a(h.this.mTextTitle, h.this.cWd.threadData.getId(), d.C0141d.cp_cont_d, d.C0141d.cp_cont_d);
                }
            }
        };
        this.cWl = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cWd != null && !StringUtils.isNull(h.this.cWd.threadData.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(h.this.getContext()).createNormalCfg(h.this.cWd.threadData.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (h.this.bdG != null) {
                        h.this.bdG.onClick(view);
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cWe = (FrameLayout) view.findViewById(d.g.layout_root);
        this.chO = view.findViewById(d.g.divider_line);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(this.aRI);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(akO());
        this.cmm.a(this.cWe, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cWf = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWf.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aRI.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cWf.setLayoutParams(layoutParams);
        this.cWg = (TbImageView) view.findViewById(d.g.image_video);
        this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWg.setDefaultResource(0);
        this.cWg.setDefaultErrorResource(0);
        this.cWj = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.caA = (ImageView) view.findViewById(d.g.image_video_play);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.cma.setOnClickListener(this);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setNeedAddPraiseIcon(true);
        if (this.cma.getCommentContainer() != null) {
            this.cma.getCommentContainer().setOnClickListener(this);
        }
        this.cma.setShareVisible(true);
        this.cma.setFrom(7);
        this.cma.setShareReportFrom(3);
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this);
        this.cmO.setFrom(7);
        this.cmO.setShareReportFrom(3);
        if (this.cmO.bep.getCommentContainer() != null) {
            this.cmO.bep.getCommentContainer().setOnClickListener(this);
        }
        this.cWh = (TextView) view.findViewById(d.g.play_count);
        this.cWi = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cWe, d.f.addresslist_item_bg);
            aj.t(this.chO, d.C0141d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0141d.cp_cont_b);
            aj.r(this.cWh, d.C0141d.cp_cont_i);
            aj.c(this.caA, d.f.btn_icon_play_live_on_n);
            aj.t(this.cWf, d.C0141d.cp_bg_line_k);
            this.clZ.onChangeSkinType();
            this.cma.onChangeSkinType();
            if (this.cmm != null) {
                this.cmm.onChangeSkinType();
            }
            this.cmO.onChangeSkinType();
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
        this.cWd = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cWd == null || this.cWd.WE() == null) {
            this.cWe.setVisibility(8);
            return;
        }
        this.cWe.setVisibility(0);
        this.clZ.setData(this.cWd.WE());
        this.clZ.setUserAfterClickListener(this.bdT);
        if (this.clZ.getHeaderImg() != null) {
            this.clZ.getHeaderImg().setData(this.cWd.WE());
        }
        this.cWd.WE().zW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cWd.WE().zN()));
        this.cWh.setText(String.format(this.aRI.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWd.threadData.zG().audience_count)));
        if (this.cmm != null && this.cWd.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWd.WE().getTid());
            ahVar.setFid(this.cWd.WE().getFid());
            ahVar.a(this.cWd.aNh);
            this.cmm.setData(ahVar);
            this.cmm.setFirstRowSingleColumn(true);
        }
        jX(this.cWd.WE().aQp);
        d(this.aRI, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWd.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        akW();
        this.cWj.startPlayAnimation();
    }

    public void akW() {
        if (com.baidu.tbadk.core.i.xo().xu() && this.cWd != null && this.cWd.WE() != null && this.cWd.WE().zG() != null) {
            this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cWg.startLoad(this.cWd.WE().zG().cover, 10, false);
            this.cWf.setVisibility(0);
            return;
        }
        this.cWf.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.cmm != null) {
            this.cmm.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWe || view == this.cma.getCommentContainer() || view == this.cmO.bep.getCommentContainer()) {
            bA(view);
        }
    }

    private void bA(View view) {
        if (akP() != null) {
            akP().a(view, this.cWd);
        }
        if (this.cWd != null && this.cWd.WE() != null && this.cWd.WE().zG() != null) {
            j.kr(this.cWd.threadData.getId());
            j.a(this.mTextTitle, this.cWd.threadData.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWd.WE().zG());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.aRI.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cma != null && this.cWk != null) {
            if (this.clZ != null) {
                this.clZ.setPageUniqueId(bdUniqueId);
            }
            this.cWk.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cmm != null) {
                this.cmm.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cWk);
        }
    }

    public void jX(int i) {
        if (this.cWd != null && this.cWd.threadData != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.cWd.threadData);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
            if (this.cma.setData(this.cWd.threadData)) {
                this.cWi.setVisibility(8);
            } else {
                this.cWi.setVisibility(0);
            }
        }
    }
}

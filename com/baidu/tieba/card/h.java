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
    private TbPageContext<?> aRR;
    private View.OnClickListener bdQ;
    private View.OnClickListener bec;
    private com.baidu.tieba.card.data.j cWm;
    public FrameLayout cWn;
    public RelativeLayout cWo;
    public TbImageView cWp;
    private TextView cWq;
    private View cWr;
    private AlaPlayAnimationView cWs;
    private CustomMessageListener cWt;
    private View.OnClickListener cWu;
    public ImageView caJ;
    public View chX;
    public ThreadSourceShareAndPraiseLayout cmX;
    private ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private com.baidu.tieba.NEGFeedBack.c cmv;
    public TextView mTextTitle;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmv = null;
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.cWm);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.cWm);
                }
            }
        };
        this.cWt = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cWm != null && h.this.cWm.threadData != null && h.this.cWm.threadData.getTid() != null && h.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(h.this.cWm.threadData.getTid())) {
                    j.a(h.this.mTextTitle, h.this.cWm.threadData.getId(), d.C0140d.cp_cont_d, d.C0140d.cp_cont_d);
                }
            }
        };
        this.cWu = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cWm != null && !StringUtils.isNull(h.this.cWm.threadData.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(h.this.getContext()).createNormalCfg(h.this.cWm.threadData.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (h.this.bdQ != null) {
                        h.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cWn = (FrameLayout) view.findViewById(d.g.layout_root);
        this.chX = view.findViewById(d.g.divider_line);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(this.aRR);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(akO());
        this.cmv.a(this.cWn, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cWo = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWo.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aRR.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cWo.setLayoutParams(layoutParams);
        this.cWp = (TbImageView) view.findViewById(d.g.image_video);
        this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWp.setDefaultResource(0);
        this.cWp.setDefaultErrorResource(0);
        this.cWs = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.caJ = (ImageView) view.findViewById(d.g.image_video_play);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.cmk.setOnClickListener(this);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setNeedAddPraiseIcon(true);
        if (this.cmk.getCommentContainer() != null) {
            this.cmk.getCommentContainer().setOnClickListener(this);
        }
        this.cmk.setShareVisible(true);
        this.cmk.setFrom(7);
        this.cmk.setShareReportFrom(3);
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this);
        this.cmX.setFrom(7);
        this.cmX.setShareReportFrom(3);
        if (this.cmX.bez.getCommentContainer() != null) {
            this.cmX.bez.getCommentContainer().setOnClickListener(this);
        }
        this.cWq = (TextView) view.findViewById(d.g.play_count);
        this.cWr = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWn.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cWn, d.f.addresslist_item_bg);
            aj.t(this.chX, d.C0140d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0140d.cp_cont_b);
            aj.r(this.cWq, d.C0140d.cp_cont_i);
            aj.c(this.caJ, d.f.btn_icon_play_live_on_n);
            aj.t(this.cWo, d.C0140d.cp_bg_line_k);
            this.cmj.onChangeSkinType();
            this.cmk.onChangeSkinType();
            if (this.cmv != null) {
                this.cmv.onChangeSkinType();
            }
            this.cmX.onChangeSkinType();
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
        this.cWm = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cWm == null || this.cWm.WE() == null) {
            this.cWn.setVisibility(8);
            return;
        }
        this.cWn.setVisibility(0);
        this.cmj.setData(this.cWm.WE());
        this.cmj.setUserAfterClickListener(this.bec);
        if (this.cmj.getHeaderImg() != null) {
            this.cmj.getHeaderImg().setData(this.cWm.WE());
        }
        this.cWm.WE().zW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cWm.WE().zN()));
        this.cWq.setText(String.format(this.aRR.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWm.threadData.zG().audience_count)));
        if (this.cmv != null && this.cWm.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWm.WE().getTid());
            ahVar.setFid(this.cWm.WE().getFid());
            ahVar.a(this.cWm.aNr);
            this.cmv.setData(ahVar);
            this.cmv.setFirstRowSingleColumn(true);
        }
        jX(this.cWm.WE().aQz);
        d(this.aRR, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWm.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        akW();
        this.cWs.startPlayAnimation();
    }

    public void akW() {
        if (com.baidu.tbadk.core.i.xo().xu() && this.cWm != null && this.cWm.WE() != null && this.cWm.WE().zG() != null) {
            this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cWp.startLoad(this.cWm.WE().zG().cover, 10, false);
            this.cWo.setVisibility(0);
            return;
        }
        this.cWo.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.cmv != null) {
            this.cmv.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWn || view == this.cmk.getCommentContainer() || view == this.cmX.bez.getCommentContainer()) {
            bA(view);
        }
    }

    private void bA(View view) {
        if (akP() != null) {
            akP().a(view, this.cWm);
        }
        if (this.cWm != null && this.cWm.WE() != null && this.cWm.WE().zG() != null) {
            j.kr(this.cWm.threadData.getId());
            j.a(this.mTextTitle, this.cWm.threadData.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWm.WE().zG());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.aRR.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cmk != null && this.cWt != null) {
            if (this.cmj != null) {
                this.cmj.setPageUniqueId(bdUniqueId);
            }
            this.cWt.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cmv != null) {
                this.cmv.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cWt);
        }
    }

    public void jX(int i) {
        if (this.cWm != null && this.cWm.threadData != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.cWm.threadData);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
            if (this.cmk.setData(this.cWm.threadData)) {
                this.cWr.setVisibility(8);
            } else {
                this.cWr.setVisibility(0);
            }
        }
    }
}

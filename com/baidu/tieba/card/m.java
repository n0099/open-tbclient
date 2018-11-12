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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes6.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener aEX;
    private View.OnClickListener aHa;
    private String bWE;
    private ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    public ThreadSourceShareAndPraiseLayout bXE;
    public LinearLayout bXP;
    private NEGFeedBackView bXc;
    public TbImageView blo;
    public ImageView blp;
    private TextView blv;
    private com.baidu.tieba.card.data.j cNJ;
    public FrameLayout cNK;
    public RelativeLayout cNL;
    private View cNM;
    private AlaPlayAnimationView cNN;
    private CustomMessageListener cNO;
    private View.OnClickListener cNP;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bXc = null;
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.anq() != null) {
                    m.this.anq().a(view, m.this.cNJ);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.anq() != null) {
                    m.this.anq().a(view, m.this.cNJ);
                }
            }
        };
        this.cNO = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cNJ != null && m.this.cNJ.threadData != null && m.this.cNJ.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cNJ.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cNJ.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cNP = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cNJ != null && !StringUtils.isNull(m.this.cNJ.threadData.yI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cNJ.threadData.yI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aEX != null) {
                        m.this.aEX.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cNK = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.bXP = (LinearLayout) view.findViewById(e.g.content_layout);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.bXc = new NEGFeedBackView(this.mContext);
        this.bXc = new NEGFeedBackView(getTbPageContext());
        this.bXc.a(this.cNK, com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cNL = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNL.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cNL.setLayoutParams(layoutParams);
        this.blo = (TbImageView) view.findViewById(e.g.image_video);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setDefaultResource(0);
        this.blo.setDefaultErrorResource(0);
        this.cNN = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bWR.setOnClickListener(this);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setNeedAddPraiseIcon(true);
        if (this.bWR.getCommentContainer() != null) {
            this.bWR.getCommentContainer().setOnClickListener(this);
        }
        this.bWR.setShareVisible(true);
        this.bWR.setFrom(7);
        this.bWR.setShareReportFrom(3);
        this.bWR.setDisPraiseFrom(1);
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this);
        this.bXE.setFrom(7);
        this.bXE.setShareReportFrom(3);
        if (this.bXE.aGI.getCommentContainer() != null) {
            this.bXE.aGI.getCommentContainer().setOnClickListener(this);
        }
        this.blv = (TextView) view.findViewById(e.g.play_count);
        this.cNM = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bXP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cNK, e.f.addresslist_item_bg);
            al.i(this.bXP, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.blv, e.d.cp_cont_i);
            al.c(this.blp, e.f.btn_icon_play_live_on_n);
            al.j(this.cNL, e.d.cp_bg_line_k);
            this.bWQ.onChangeSkinType();
            this.bWR.onChangeSkinType();
            if (this.bXc != null) {
                this.bXc.onChangeSkinType();
            }
            this.bXE.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.cNJ = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cNJ == null || this.cNJ.YL() == null) {
            this.cNK.setVisibility(8);
            return;
        }
        this.cNK.setVisibility(0);
        this.bWQ.setData(this.cNJ.YL());
        this.bWQ.setUserAfterClickListener(this.aHa);
        if (this.bWQ.getHeaderImg() != null) {
            this.bWQ.getHeaderImg().setData(this.cNJ.YL());
        }
        this.cNJ.YL().zm();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cNJ.YL().zc()));
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.P(this.cNJ.threadData.yW().audience_count)));
        if (this.bXc != null && this.cNJ.YL() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cNJ.YL().getTid());
            ahVar.setFid(this.cNJ.YL().getFid());
            ahVar.a(this.cNJ.aoB);
            this.bXc.setData(ahVar);
            this.bXc.setFirstRowSingleColumn(true);
        }
        ix(ho(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mf(this.cNJ.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        anx();
        this.cNN.startPlayAnimation();
    }

    public void anx() {
        if (com.baidu.tbadk.core.i.wA().wE() && this.cNJ != null && this.cNJ.YL() != null && this.cNJ.YL().yW() != null) {
            this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.blo.startLoad(this.cNJ.YL().yW().cover, 10, false);
            this.cNL.setVisibility(0);
            return;
        }
        this.cNL.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bXc != null) {
            this.bXc.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXP || view == this.bWR.getCommentContainer() || view == this.bXE.aGI.getCommentContainer()) {
            az(view);
        }
    }

    private void az(View view) {
        if (anq() != null) {
            anq().a(view, this.cNJ);
        }
        if (this.cNJ != null && this.cNJ.YL() != null && this.cNJ.YL().yW() != null) {
            o.me(this.cNJ.threadData.getId());
            o.a(this.mTextTitle, this.cNJ.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cNJ.YL().yW());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWR != null && this.cNO != null) {
            if (this.bWQ != null) {
                this.bWQ.setPageUniqueId(bdUniqueId);
            }
            this.cNO.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bXc != null) {
                this.bXc.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cNO);
        }
    }

    public void ix(int i) {
        if (this.cNJ != null && this.cNJ.threadData != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setData(this.cNJ.threadData);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
            if (this.bWR.setData(this.cNJ.threadData)) {
                this.cNM.setVisibility(8);
            } else {
                this.cNM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}

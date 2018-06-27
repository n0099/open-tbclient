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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener axT;
    private View.OnClickListener ayi;
    private String bGM;
    private ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    public ThreadSourceShareAndPraiseLayout bHN;
    public LinearLayout bHY;
    public View bHc;
    private NEGFeedBackView bHl;
    public TbImageView bcJ;
    public ImageView bcK;
    private TextView bcQ;
    private com.baidu.tieba.card.data.j cvU;
    public FrameLayout cvV;
    public RelativeLayout cvW;
    private View cvX;
    private AlaPlayAnimationView cvY;
    private CustomMessageListener cvZ;
    private View.OnClickListener cwa;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aia() != null) {
                    m.this.aia().a(view, m.this.cvU);
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aia() != null) {
                    m.this.aia().a(view, m.this.cvU);
                }
            }
        };
        this.cvZ = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cvU != null && m.this.cvU.threadData != null && m.this.cvU.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cvU.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cvU.threadData.getId(), d.C0142d.cp_cont_d, d.C0142d.cp_cont_d);
                }
            }
        };
        this.cwa = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cvU != null && !StringUtils.isNull(m.this.cvU.threadData.vB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cvU.threadData.vB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.axT != null) {
                        m.this.axT.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cvV = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bHc = view.findViewById(d.g.divider_line);
        this.bHY = (LinearLayout) view.findViewById(d.g.content_layout);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bHl = new NEGFeedBackView(this.mContext);
        this.bHl = new NEGFeedBackView(ahZ());
        this.bHl.a(this.cvV, com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cvW = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvW.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cvW.setLayoutParams(layoutParams);
        this.bcJ = (TbImageView) view.findViewById(d.g.image_video);
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setDefaultResource(0);
        this.bcJ.setDefaultErrorResource(0);
        this.cvY = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bGZ.setOnClickListener(this);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        if (this.bGZ.getCommentContainer() != null) {
            this.bGZ.getCommentContainer().setOnClickListener(this);
        }
        this.bGZ.setShareVisible(true);
        this.bGZ.setFrom(7);
        this.bGZ.setShareReportFrom(3);
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this);
        this.bHN.setFrom(7);
        this.bHN.setShareReportFrom(3);
        if (this.bHN.ayE.getCommentContainer() != null) {
            this.bHN.ayE.getCommentContainer().setOnClickListener(this);
        }
        this.bcQ = (TextView) view.findViewById(d.g.play_count);
        this.cvX = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bHY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.cvV, d.f.addresslist_item_bg);
            am.i(this.bHY, d.f.addresslist_item_bg);
            am.j(this.bHc, d.C0142d.cp_bg_line_e);
            am.h(this.mTextTitle, d.C0142d.cp_cont_b);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            am.c(this.bcK, d.f.btn_icon_play_live_on_n);
            am.j(this.cvW, d.C0142d.cp_bg_line_k);
            this.bGY.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            if (this.bHl != null) {
                this.bHl.onChangeSkinType();
            }
            this.bHN.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.cvU = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cvU == null || this.cvU.SV() == null) {
            this.cvV.setVisibility(8);
            return;
        }
        this.cvV.setVisibility(0);
        this.bGY.setData(this.cvU.SV());
        this.bGY.setUserAfterClickListener(this.ayi);
        if (this.bGY.getHeaderImg() != null) {
            this.bGY.getHeaderImg().setData(this.cvU.SV());
        }
        this.cvU.SV().wd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cvU.SV().vU()));
        this.bcQ.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ap.F(this.cvU.threadData.vO().audience_count)));
        if (this.bHl != null && this.cvU.SV() != null) {
            ai aiVar = new ai();
            aiVar.dk(this.cvU.SV().getTid());
            aiVar.setFid(this.cvU.SV().getFid());
            aiVar.a(this.cvU.agZ);
            this.bHl.setData(aiVar);
            this.bHl.setFirstRowSingleColumn(true);
        }
        hh(gp(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cvU.threadData.getId())) {
            am.c(this.mTextTitle, d.C0142d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0142d.cp_cont_b, 1);
        }
        aih();
        this.cvY.startPlayAnimation();
    }

    public void aih() {
        if (com.baidu.tbadk.core.i.tt().tz() && this.cvU != null && this.cvU.SV() != null && this.cvU.SV().vO() != null) {
            this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.bcJ.startLoad(this.cvU.SV().vO().cover, 10, false);
            this.cvW.setVisibility(0);
            return;
        }
        this.cvW.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bHl != null) {
            this.bHl.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bHY || view == this.bGZ.getCommentContainer() || view == this.bHN.ayE.getCommentContainer()) {
            ag(view);
        }
    }

    private void ag(View view) {
        if (aia() != null) {
            aia().a(view, this.cvU);
        }
        if (this.cvU != null && this.cvU.SV() != null && this.cvU.SV().vO() != null) {
            o.kY(this.cvU.threadData.getId());
            o.a(this.mTextTitle, this.cvU.threadData.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cvU.SV().vO());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGZ != null && this.cvZ != null) {
            if (this.bGY != null) {
                this.bGY.setPageUniqueId(bdUniqueId);
            }
            this.cvZ.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bHl != null) {
                this.bHl.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cvZ);
        }
    }

    public void hh(int i) {
        if (this.cvU != null && this.cvU.threadData != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setData(this.cvU.threadData);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bHN.setVisibility(8);
            this.bGY.showForumNameView(true);
            if (this.bGZ.setData(this.cvU.threadData)) {
                this.cvX.setVisibility(8);
            } else {
                this.cvX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}

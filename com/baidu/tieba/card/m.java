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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener axg;
    private View.OnClickListener axr;
    private String bER;
    public ThreadSourceShareAndPraiseLayout bFT;
    private ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    public View bFh;
    private NEGFeedBackView bFq;
    public ImageView bsT;
    private com.baidu.tieba.card.data.j cxN;
    public FrameLayout cxO;
    public RelativeLayout cxP;
    public TbImageView cxQ;
    private TextView cxR;
    private View cxS;
    private AlaPlayAnimationView cxT;
    private CustomMessageListener cxU;
    private View.OnClickListener cxV;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFq = null;
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiI() != null) {
                    m.this.aiI().a(view, m.this.cxN);
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiI() != null) {
                    m.this.aiI().a(view, m.this.cxN);
                }
            }
        };
        this.cxU = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cxN != null && m.this.cxN.threadData != null && m.this.cxN.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cxN.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cxN.threadData.getId(), d.C0141d.cp_cont_d, d.C0141d.cp_cont_d);
                }
            }
        };
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cxN != null && !StringUtils.isNull(m.this.cxN.threadData.vr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cxN.threadData.vr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.axg != null) {
                        m.this.axg.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cxO = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bFh = view.findViewById(d.g.divider_line);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bFq = new NEGFeedBackView(this.mContext);
        this.bFq = new NEGFeedBackView(aiH());
        this.bFq.a(this.cxO, com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cxP = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxP.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cxP.setLayoutParams(layoutParams);
        this.cxQ = (TbImageView) view.findViewById(d.g.image_video);
        this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cxQ.setDefaultResource(0);
        this.cxQ.setDefaultErrorResource(0);
        this.cxT = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bFe.setOnClickListener(this);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setNeedAddPraiseIcon(true);
        if (this.bFe.getCommentContainer() != null) {
            this.bFe.getCommentContainer().setOnClickListener(this);
        }
        this.bFe.setShareVisible(true);
        this.bFe.setFrom(7);
        this.bFe.setShareReportFrom(3);
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this);
        this.bFT.setFrom(7);
        this.bFT.setShareReportFrom(3);
        if (this.bFT.axN.getCommentContainer() != null) {
            this.bFT.axN.getCommentContainer().setOnClickListener(this);
        }
        this.cxR = (TextView) view.findViewById(d.g.play_count);
        this.cxS = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cxO.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cxO, d.f.addresslist_item_bg);
            al.j(this.bFh, d.C0141d.cp_bg_line_e);
            al.h(this.mTextTitle, d.C0141d.cp_cont_b);
            al.h(this.cxR, d.C0141d.cp_cont_i);
            al.c(this.bsT, d.f.btn_icon_play_live_on_n);
            al.j(this.cxP, d.C0141d.cp_bg_line_k);
            this.bFd.onChangeSkinType();
            this.bFe.onChangeSkinType();
            if (this.bFq != null) {
                this.bFq.onChangeSkinType();
            }
            this.bFT.onChangeSkinType();
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
        this.cxN = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cxN == null || this.cxN.Sz() == null) {
            this.cxO.setVisibility(8);
            return;
        }
        this.cxO.setVisibility(0);
        this.bFd.setData(this.cxN.Sz());
        this.bFd.setUserAfterClickListener(this.axr);
        if (this.bFd.getHeaderImg() != null) {
            this.bFd.getHeaderImg().setData(this.cxN.Sz());
        }
        this.cxN.Sz().vT();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cxN.Sz().vK()));
        this.cxR.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ao.E(this.cxN.threadData.vE().audience_count)));
        if (this.bFq != null && this.cxN.Sz() != null) {
            ai aiVar = new ai();
            aiVar.dh(this.cxN.Sz().getTid());
            aiVar.setFid(this.cxN.Sz().getFid());
            aiVar.a(this.cxN.agK);
            this.bFq.setData(aiVar);
            this.bFq.setFirstRowSingleColumn(true);
        }
        hd(go(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lc(this.cxN.threadData.getId())) {
            al.c(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        aiP();
        this.cxT.startPlayAnimation();
    }

    public void aiP() {
        if (com.baidu.tbadk.core.i.tt().tz() && this.cxN != null && this.cxN.Sz() != null && this.cxN.Sz().vE() != null) {
            this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cxQ.startLoad(this.cxN.Sz().vE().cover, 10, false);
            this.cxP.setVisibility(0);
            return;
        }
        this.cxP.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bFq != null) {
            this.bFq.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxO || view == this.bFe.getCommentContainer() || view == this.bFT.axN.getCommentContainer()) {
            ae(view);
        }
    }

    private void ae(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cxN);
        }
        if (this.cxN != null && this.cxN.Sz() != null && this.cxN.Sz().vE() != null) {
            o.lb(this.cxN.threadData.getId());
            o.a(this.mTextTitle, this.cxN.threadData.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cxN.Sz().vE());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bFe != null && this.cxU != null) {
            if (this.bFd != null) {
                this.bFd.setPageUniqueId(bdUniqueId);
            }
            this.cxU.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bFq != null) {
                this.bFq.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cxU);
        }
    }

    public void hd(int i) {
        if (this.cxN != null && this.cxN.threadData != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setData(this.cxN.threadData);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
            if (this.bFe.setData(this.cxN.threadData)) {
                this.cxS.setVisibility(8);
            } else {
                this.cxS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener aoY;
    private View.OnClickListener apj;
    public ImageView bkP;
    private String bwO;
    public ThreadSourceShareAndPraiseLayout bxQ;
    private ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    public View bxe;
    private NEGFeedBackView bxn;
    private com.baidu.tieba.card.data.j cpj;
    public FrameLayout cpk;
    public RelativeLayout cpl;
    public TbImageView cpm;
    private TextView cpn;
    private View cpo;
    private AlaPlayAnimationView cpp;
    private CustomMessageListener cpq;
    private View.OnClickListener cpr;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bxn = null;
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.cpj);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.cpj);
                }
            }
        };
        this.cpq = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cpj != null && m.this.cpj.threadData != null && m.this.cpj.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cpj.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cpj.threadData.getId(), d.C0126d.cp_cont_d, d.C0126d.cp_cont_d);
                }
            }
        };
        this.cpr = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.cpj != null && !StringUtils.isNull(m.this.cpj.threadData.rU())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cpj.threadData.rU(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aoY != null) {
                        m.this.aoY.onClick(view2);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view2) {
        this.cpk = (FrameLayout) view2.findViewById(d.g.layout_root);
        this.bxe = view2.findViewById(d.g.divider_line);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bxn = new NEGFeedBackView(this.mContext);
        this.bxn = new NEGFeedBackView(aeY());
        this.bxn.a(this.cpk, com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.cpl = (RelativeLayout) view2.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpl.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cpl.setLayoutParams(layoutParams);
        this.cpm = (TbImageView) view2.findViewById(d.g.image_video);
        this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cpm.setDefaultResource(0);
        this.cpm.setDefaultErrorResource(0);
        this.cpp = (AlaPlayAnimationView) view2.findViewById(d.g.ala_play);
        this.bkP = (ImageView) view2.findViewById(d.g.image_video_play);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        this.bxb.setOnClickListener(this);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setNeedAddPraiseIcon(true);
        if (this.bxb.getCommentContainer() != null) {
            this.bxb.getCommentContainer().setOnClickListener(this);
        }
        this.bxb.setShareVisible(true);
        this.bxb.setFrom(7);
        this.bxb.setShareReportFrom(3);
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_ala_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this);
        this.bxQ.setFrom(7);
        this.bxQ.setShareReportFrom(3);
        if (this.bxQ.apG.getCommentContainer() != null) {
            this.bxQ.apG.getCommentContainer().setOnClickListener(this);
        }
        this.cpn = (TextView) view2.findViewById(d.g.play_count);
        this.cpo = view2.findViewById(d.g.divider_below_reply_number_layout);
        this.cpk.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.cpk, d.f.addresslist_item_bg);
            ak.j(this.bxe, d.C0126d.cp_bg_line_e);
            ak.h(this.mTextTitle, d.C0126d.cp_cont_b);
            ak.h(this.cpn, d.C0126d.cp_cont_i);
            ak.c(this.bkP, d.f.btn_icon_play_live_on_n);
            ak.j(this.cpl, d.C0126d.cp_bg_line_k);
            this.bxa.onChangeSkinType();
            this.bxb.onChangeSkinType();
            if (this.bxn != null) {
                this.bxn.onChangeSkinType();
            }
            this.bxQ.onChangeSkinType();
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
        this.cpj = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cpj == null || this.cpj.Pb() == null) {
            this.cpk.setVisibility(8);
            return;
        }
        this.cpk.setVisibility(0);
        this.bxa.setData(this.cpj.Pb());
        this.bxa.setUserAfterClickListener(this.apj);
        if (this.bxa.getHeaderImg() != null) {
            this.bxa.getHeaderImg().setData(this.cpj.Pb());
        }
        this.cpj.Pb().sw();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cpj.Pb().sn()));
        this.cpn.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cpj.threadData.sh().audience_count)));
        if (this.bxn != null && this.cpj.Pb() != null) {
            ai aiVar = new ai();
            aiVar.cJ(this.cpj.Pb().getTid());
            aiVar.setFid(this.cpj.Pb().getFid());
            aiVar.a(this.cpj.YI);
            this.bxn.setData(aiVar);
            this.bxn.setFirstRowSingleColumn(true);
        }
        hc(gn(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kz(this.cpj.threadData.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        afg();
        this.cpp.startPlayAnimation();
    }

    public void afg() {
        if (com.baidu.tbadk.core.i.pX().qd() && this.cpj != null && this.cpj.Pb() != null && this.cpj.Pb().sh() != null) {
            this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cpm.startLoad(this.cpj.Pb().sh().cover, 10, false);
            this.cpl.setVisibility(0);
            return;
        }
        this.cpl.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bxn != null) {
            this.bxn.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cpk || view2 == this.bxb.getCommentContainer() || view2 == this.bxQ.apG.getCommentContainer()) {
            ae(view2);
        }
    }

    private void ae(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpj);
        }
        if (this.cpj != null && this.cpj.Pb() != null && this.cpj.Pb().sh() != null) {
            o.ky(this.cpj.threadData.getId());
            o.a(this.mTextTitle, this.cpj.threadData.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cpj.Pb().sh());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bxb != null && this.cpq != null) {
            if (this.bxa != null) {
                this.bxa.setPageUniqueId(bdUniqueId);
            }
            this.cpq.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bxn != null) {
                this.bxn.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cpq);
        }
    }

    public void hc(int i) {
        if (this.cpj != null && this.cpj.threadData != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setData(this.cpj.threadData);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
            if (this.bxb.setData(this.cpj.threadData)) {
                this.cpo.setVisibility(8);
            } else {
                this.cpo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}

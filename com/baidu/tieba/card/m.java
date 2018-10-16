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
    private View.OnClickListener aEh;
    private View.OnClickListener aGk;
    private String bVS;
    public ThreadSourceShareAndPraiseLayout bWS;
    private ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private NEGFeedBackView bWq;
    public LinearLayout bXd;
    public TbImageView bkD;
    public ImageView bkE;
    private TextView bkK;
    private com.baidu.tieba.card.data.j cMD;
    public FrameLayout cME;
    public RelativeLayout cMF;
    private View cMG;
    private AlaPlayAnimationView cMH;
    private CustomMessageListener cMI;
    private View.OnClickListener cMJ;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bWq = null;
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.anO() != null) {
                    m.this.anO().a(view, m.this.cMD);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.anO() != null) {
                    m.this.anO().a(view, m.this.cMD);
                }
            }
        };
        this.cMI = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cMD != null && m.this.cMD.threadData != null && m.this.cMD.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cMD.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cMD.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cMJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cMD != null && !StringUtils.isNull(m.this.cMD.threadData.yB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cMD.threadData.yB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aEh != null) {
                        m.this.aEh.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cME = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.bXd = (LinearLayout) view.findViewById(e.g.content_layout);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.bWq = new NEGFeedBackView(this.mContext);
        this.bWq = new NEGFeedBackView(getTbPageContext());
        this.bWq.a(this.cME, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cMF = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cMF.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cMF.setLayoutParams(layoutParams);
        this.bkD = (TbImageView) view.findViewById(e.g.image_video);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setDefaultResource(0);
        this.bkD.setDefaultErrorResource(0);
        this.cMH = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bWf.setOnClickListener(this);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setNeedAddPraiseIcon(true);
        if (this.bWf.getCommentContainer() != null) {
            this.bWf.getCommentContainer().setOnClickListener(this);
        }
        this.bWf.setShareVisible(true);
        this.bWf.setFrom(7);
        this.bWf.setShareReportFrom(3);
        this.bWf.setDisPraiseFrom(1);
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this);
        this.bWS.setFrom(7);
        this.bWS.setShareReportFrom(3);
        if (this.bWS.aFS.getCommentContainer() != null) {
            this.bWS.aFS.getCommentContainer().setOnClickListener(this);
        }
        this.bkK = (TextView) view.findViewById(e.g.play_count);
        this.cMG = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bXd.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cME, e.f.addresslist_item_bg);
            al.i(this.bXd, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.bkK, e.d.cp_cont_i);
            al.c(this.bkE, e.f.btn_icon_play_live_on_n);
            al.j(this.cMF, e.d.cp_bg_line_k);
            this.bWe.onChangeSkinType();
            this.bWf.onChangeSkinType();
            if (this.bWq != null) {
                this.bWq.onChangeSkinType();
            }
            this.bWS.onChangeSkinType();
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
        this.cMD = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cMD == null || this.cMD.YA() == null) {
            this.cME.setVisibility(8);
            return;
        }
        this.cME.setVisibility(0);
        this.bWe.setData(this.cMD.YA());
        this.bWe.setUserAfterClickListener(this.aGk);
        if (this.bWe.getHeaderImg() != null) {
            this.bWe.getHeaderImg().setData(this.cMD.YA());
        }
        this.cMD.YA().zf();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cMD.YA().yV()));
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.N(this.cMD.threadData.yP().audience_count)));
        if (this.bWq != null && this.cMD.YA() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cMD.YA().getTid());
            ahVar.setFid(this.cMD.YA().getFid());
            ahVar.a(this.cMD.anO);
            this.bWq.setData(ahVar);
            this.bWq.setFirstRowSingleColumn(true);
        }
        ik(hb(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.me(this.cMD.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        anV();
        this.cMH.startPlayAnimation();
    }

    public void anV() {
        if (com.baidu.tbadk.core.i.ws().ww() && this.cMD != null && this.cMD.YA() != null && this.cMD.YA().yP() != null) {
            this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.bkD.startLoad(this.cMD.YA().yP().cover, 10, false);
            this.cMF.setVisibility(0);
            return;
        }
        this.cMF.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bWq != null) {
            this.bWq.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXd || view == this.bWf.getCommentContainer() || view == this.bWS.aFS.getCommentContainer()) {
            ax(view);
        }
    }

    private void ax(View view) {
        if (anO() != null) {
            anO().a(view, this.cMD);
        }
        if (this.cMD != null && this.cMD.YA() != null && this.cMD.YA().yP() != null) {
            o.md(this.cMD.threadData.getId());
            o.a(this.mTextTitle, this.cMD.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cMD.YA().yP());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWf != null && this.cMI != null) {
            if (this.bWe != null) {
                this.bWe.setPageUniqueId(bdUniqueId);
            }
            this.cMI.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bWq != null) {
                this.bWq.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cMI);
        }
    }

    public void ik(int i) {
        if (this.cMD != null && this.cMD.threadData != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setData(this.cMD.threadData);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
            if (this.bWf.setData(this.cMD.threadData)) {
                this.cMG.setVisibility(8);
            } else {
                this.cMG.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}

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
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes6.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener aJb;
    private View.OnClickListener aLf;
    public TbImageView bpE;
    public ImageView bpF;
    private TextView bpL;
    private com.baidu.tieba.card.data.j cXS;
    public FrameLayout cXT;
    public RelativeLayout cXU;
    private View cXV;
    private AlaPlayAnimationView cXW;
    private CustomMessageListener cXX;
    private View.OnClickListener cXY;
    private NEGFeedBackView cbJ;
    private String cbl;
    private ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    public ThreadSourceShareAndPraiseLayout ccl;
    public LinearLayout ccx;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbJ = null;
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aqp() != null) {
                    m.this.aqp().a(view, m.this.cXS);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aqp() != null) {
                    m.this.aqp().a(view, m.this.cXS);
                }
            }
        };
        this.cXX = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cXS != null && m.this.cXS.threadData != null && m.this.cXS.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cXS.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cXS.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cXY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cXS != null && !StringUtils.isNull(m.this.cXS.threadData.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cXS.threadData.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aJb != null) {
                        m.this.aJb.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cXT = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.ccx = (LinearLayout) view.findViewById(e.g.content_layout);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.cbJ = new NEGFeedBackView(this.mContext);
        this.cbJ = new NEGFeedBackView(getTbPageContext());
        this.cbJ.a(this.cXT, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cXU = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXU.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cXU.setLayoutParams(layoutParams);
        this.bpE = (TbImageView) view.findViewById(e.g.image_video);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setDefaultResource(0);
        this.bpE.setDefaultErrorResource(0);
        this.cXW = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.cby.setOnClickListener(this);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setNeedAddPraiseIcon(true);
        if (this.cby.getCommentContainer() != null) {
            this.cby.getCommentContainer().setOnClickListener(this);
        }
        this.cby.setShareVisible(true);
        this.cby.setFrom(7);
        this.cby.setShareReportFrom(3);
        this.cby.setDisPraiseFrom(1);
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this);
        this.ccl.setFrom(7);
        this.ccl.setShareReportFrom(3);
        if (this.ccl.aKN.getCommentContainer() != null) {
            this.ccl.aKN.getCommentContainer().setOnClickListener(this);
        }
        this.bpL = (TextView) view.findViewById(e.g.play_count);
        this.cXV = view.findViewById(e.g.divider_below_reply_number_layout);
        this.ccx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cXT, e.f.addresslist_item_bg);
            al.i(this.ccx, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.bpL, e.d.cp_cont_i);
            al.c(this.bpF, e.f.btn_icon_play_live_on_n);
            al.j(this.cXU, e.d.cp_bg_line_k);
            this.cbx.onChangeSkinType();
            this.cby.onChangeSkinType();
            if (this.cbJ != null) {
                this.cbJ.onChangeSkinType();
            }
            this.ccl.onChangeSkinType();
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
        this.cXS = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXS == null || this.cXS.aaq() == null) {
            this.cXT.setVisibility(8);
            return;
        }
        this.cXT.setVisibility(0);
        this.cbx.setData(this.cXS.aaq());
        this.cbx.setUserAfterClickListener(this.aLf);
        if (this.cbx.getHeaderImg() != null) {
            this.cbx.getHeaderImg().setData(this.cXS.aaq());
        }
        this.cXS.aaq().AD();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cXS.aaq().At()));
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXS.threadData.An().audience_count)));
        if (this.cbJ != null && this.cXS.aaq() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cXS.aaq().getTid());
            ahVar.setFid(this.cXS.aaq().getFid());
            ahVar.a(this.cXS.asF);
            this.cbJ.setData(ahVar);
            this.cbJ.setFirstRowSingleColumn(true);
        }
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cXS.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        aqw();
        this.cXW.startPlayAnimation();
    }

    public void aqw() {
        if (com.baidu.tbadk.core.i.xR().xV() && this.cXS != null && this.cXS.aaq() != null && this.cXS.aaq().An() != null) {
            this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.bpE.startLoad(this.cXS.aaq().An().cover, 10, false);
            this.cXU.setVisibility(0);
            return;
        }
        this.cXU.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbJ != null) {
            this.cbJ.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbx != null) {
            return this.cbx.aKS;
        }
        return null;
    }

    public View aqs() {
        if (this.cbx != null) {
            return this.cbx.aKU;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccx || view == this.cby.getCommentContainer() || view == this.ccl.aKN.getCommentContainer()) {
            aC(view);
        }
    }

    private void aC(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cXS);
        }
        if (this.cXS != null && this.cXS.aaq() != null && this.cXS.aaq().An() != null) {
            o.mW(this.cXS.threadData.getId());
            o.a(this.mTextTitle, this.cXS.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXS.aaq().An());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cby != null && this.cXX != null) {
            if (this.cbx != null) {
                this.cbx.setPageUniqueId(bdUniqueId);
            }
            this.cXX.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cbJ != null) {
                this.cbJ.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cXX);
        }
    }

    public void iM(int i) {
        if (this.cXS != null && this.cXS.threadData != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setData(this.cXS.threadData);
                this.cbx.showForumNameView(false);
                return;
            }
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
            if (this.cby.setData(this.cXS.threadData)) {
                this.cXV.setVisibility(8);
            } else {
                this.cXV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    public void kL(int i) {
        if (this.cby != null) {
            this.cby.aKg = String.valueOf(i);
        }
    }
}

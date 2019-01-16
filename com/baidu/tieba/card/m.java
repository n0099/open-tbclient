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
    private View.OnClickListener aJa;
    private View.OnClickListener aLe;
    public TbImageView bpD;
    public ImageView bpE;
    private TextView bpK;
    private com.baidu.tieba.card.data.j cXR;
    public FrameLayout cXS;
    public RelativeLayout cXT;
    private View cXU;
    private AlaPlayAnimationView cXV;
    private CustomMessageListener cXW;
    private View.OnClickListener cXX;
    private NEGFeedBackView cbI;
    private String cbk;
    private ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    public ThreadSourceShareAndPraiseLayout cck;
    public LinearLayout ccw;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbI = null;
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aqp() != null) {
                    m.this.aqp().a(view, m.this.cXR);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aqp() != null) {
                    m.this.aqp().a(view, m.this.cXR);
                }
            }
        };
        this.cXW = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cXR != null && m.this.cXR.threadData != null && m.this.cXR.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cXR.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cXR.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cXX = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cXR != null && !StringUtils.isNull(m.this.cXR.threadData.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cXR.threadData.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aJa != null) {
                        m.this.aJa.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cXS = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.ccw = (LinearLayout) view.findViewById(e.g.content_layout);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.cbI = new NEGFeedBackView(this.mContext);
        this.cbI = new NEGFeedBackView(getTbPageContext());
        this.cbI.a(this.cXS, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cXT = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXT.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cXT.setLayoutParams(layoutParams);
        this.bpD = (TbImageView) view.findViewById(e.g.image_video);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setDefaultResource(0);
        this.bpD.setDefaultErrorResource(0);
        this.cXV = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.cbx.setOnClickListener(this);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setNeedAddPraiseIcon(true);
        if (this.cbx.getCommentContainer() != null) {
            this.cbx.getCommentContainer().setOnClickListener(this);
        }
        this.cbx.setShareVisible(true);
        this.cbx.setFrom(7);
        this.cbx.setShareReportFrom(3);
        this.cbx.setDisPraiseFrom(1);
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this);
        this.cck.setFrom(7);
        this.cck.setShareReportFrom(3);
        if (this.cck.aKM.getCommentContainer() != null) {
            this.cck.aKM.getCommentContainer().setOnClickListener(this);
        }
        this.bpK = (TextView) view.findViewById(e.g.play_count);
        this.cXU = view.findViewById(e.g.divider_below_reply_number_layout);
        this.ccw.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cXS, e.f.addresslist_item_bg);
            al.i(this.ccw, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.bpK, e.d.cp_cont_i);
            al.c(this.bpE, e.f.btn_icon_play_live_on_n);
            al.j(this.cXT, e.d.cp_bg_line_k);
            this.cbw.onChangeSkinType();
            this.cbx.onChangeSkinType();
            if (this.cbI != null) {
                this.cbI.onChangeSkinType();
            }
            this.cck.onChangeSkinType();
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
        this.cXR = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXR == null || this.cXR.aaq() == null) {
            this.cXS.setVisibility(8);
            return;
        }
        this.cXS.setVisibility(0);
        this.cbw.setData(this.cXR.aaq());
        this.cbw.setUserAfterClickListener(this.aLe);
        if (this.cbw.getHeaderImg() != null) {
            this.cbw.getHeaderImg().setData(this.cXR.aaq());
        }
        this.cXR.aaq().AD();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cXR.aaq().At()));
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXR.threadData.An().audience_count)));
        if (this.cbI != null && this.cXR.aaq() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cXR.aaq().getTid());
            ahVar.setFid(this.cXR.aaq().getFid());
            ahVar.a(this.cXR.asE);
            this.cbI.setData(ahVar);
            this.cbI.setFirstRowSingleColumn(true);
        }
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cXR.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        aqw();
        this.cXV.startPlayAnimation();
    }

    public void aqw() {
        if (com.baidu.tbadk.core.i.xR().xV() && this.cXR != null && this.cXR.aaq() != null && this.cXR.aaq().An() != null) {
            this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.bpD.startLoad(this.cXR.aaq().An().cover, 10, false);
            this.cXT.setVisibility(0);
            return;
        }
        this.cXT.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbI != null) {
            this.cbI.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbw != null) {
            return this.cbw.aKR;
        }
        return null;
    }

    public View aqs() {
        if (this.cbw != null) {
            return this.cbw.aKT;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccw || view == this.cbx.getCommentContainer() || view == this.cck.aKM.getCommentContainer()) {
            aC(view);
        }
    }

    private void aC(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cXR);
        }
        if (this.cXR != null && this.cXR.aaq() != null && this.cXR.aaq().An() != null) {
            o.mW(this.cXR.threadData.getId());
            o.a(this.mTextTitle, this.cXR.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXR.aaq().An());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cbx != null && this.cXW != null) {
            if (this.cbw != null) {
                this.cbw.setPageUniqueId(bdUniqueId);
            }
            this.cXW.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.cbI != null) {
                this.cbI.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cXW);
        }
    }

    public void iM(int i) {
        if (this.cXR != null && this.cXR.threadData != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setData(this.cXR.threadData);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
            if (this.cbx.setData(this.cXR.threadData)) {
                this.cXU.setVisibility(8);
            } else {
                this.cXU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    public void kL(int i) {
        if (this.cbx != null) {
            this.cbx.aKf = String.valueOf(i);
        }
    }
}

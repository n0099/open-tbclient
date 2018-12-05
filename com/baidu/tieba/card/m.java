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
    private View.OnClickListener aIx;
    private View.OnClickListener aKA;
    public TbImageView boM;
    public ImageView boN;
    private TextView boT;
    private com.baidu.tieba.card.data.j cUq;
    public FrameLayout cUr;
    public RelativeLayout cUs;
    private View cUt;
    private AlaPlayAnimationView cUu;
    private CustomMessageListener cUv;
    private View.OnClickListener cUw;
    private ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private NEGFeedBackView caU;
    private String caw;
    public LinearLayout cbH;
    public ThreadSourceShareAndPraiseLayout cbw;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = null;
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.apc() != null) {
                    m.this.apc().a(view, m.this.cUq);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.apc() != null) {
                    m.this.apc().a(view, m.this.cUq);
                }
            }
        };
        this.cUv = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cUq != null && m.this.cUq.threadData != null && m.this.cUq.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cUq.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cUq.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cUw = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cUq != null && !StringUtils.isNull(m.this.cUq.threadData.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cUq.threadData.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aIx != null) {
                        m.this.aIx.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cUr = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cbH = (LinearLayout) view.findViewById(e.g.content_layout);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.caU = new NEGFeedBackView(this.mContext);
        this.caU = new NEGFeedBackView(getTbPageContext());
        this.caU.a(this.cUr, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cUs = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUs.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cUs.setLayoutParams(layoutParams);
        this.boM = (TbImageView) view.findViewById(e.g.image_video);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setDefaultResource(0);
        this.boM.setDefaultErrorResource(0);
        this.cUu = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.caJ.setOnClickListener(this);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setNeedAddPraiseIcon(true);
        if (this.caJ.getCommentContainer() != null) {
            this.caJ.getCommentContainer().setOnClickListener(this);
        }
        this.caJ.setShareVisible(true);
        this.caJ.setFrom(7);
        this.caJ.setShareReportFrom(3);
        this.caJ.setDisPraiseFrom(1);
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this);
        this.cbw.setFrom(7);
        this.cbw.setShareReportFrom(3);
        if (this.cbw.aKi.getCommentContainer() != null) {
            this.cbw.aKi.getCommentContainer().setOnClickListener(this);
        }
        this.boT = (TextView) view.findViewById(e.g.play_count);
        this.cUt = view.findViewById(e.g.divider_below_reply_number_layout);
        this.cbH.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cUr, e.f.addresslist_item_bg);
            al.i(this.cbH, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.boT, e.d.cp_cont_i);
            al.c(this.boN, e.f.btn_icon_play_live_on_n);
            al.j(this.cUs, e.d.cp_bg_line_k);
            this.caI.onChangeSkinType();
            this.caJ.onChangeSkinType();
            if (this.caU != null) {
                this.caU.onChangeSkinType();
            }
            this.cbw.onChangeSkinType();
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
        this.cUq = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cUq == null || this.cUq.ZR() == null) {
            this.cUr.setVisibility(8);
            return;
        }
        this.cUr.setVisibility(0);
        this.caI.setData(this.cUq.ZR());
        this.caI.setUserAfterClickListener(this.aKA);
        if (this.caI.getHeaderImg() != null) {
            this.caI.getHeaderImg().setData(this.cUq.ZR());
        }
        this.cUq.ZR().Aq();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cUq.ZR().Ag()));
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.W(this.cUq.threadData.Aa().audience_count)));
        if (this.caU != null && this.cUq.ZR() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cUq.ZR().getTid());
            ahVar.setFid(this.cUq.ZR().getFid());
            ahVar.a(this.cUq.asc);
            this.caU.setData(ahVar);
            this.caU.setFirstRowSingleColumn(true);
        }
        iL(hC(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mE(this.cUq.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        apk();
        this.cUu.startPlayAnimation();
    }

    public void apk() {
        if (com.baidu.tbadk.core.i.xE().xI() && this.cUq != null && this.cUq.ZR() != null && this.cUq.ZR().Aa() != null) {
            this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.boM.startLoad(this.cUq.ZR().Aa().cover, 10, false);
            this.cUs.setVisibility(0);
            return;
        }
        this.cUs.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caU != null) {
            this.caU.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cbH || view == this.caJ.getCommentContainer() || view == this.cbw.aKi.getCommentContainer()) {
            az(view);
        }
    }

    private void az(View view) {
        if (apc() != null) {
            apc().a(view, this.cUq);
        }
        if (this.cUq != null && this.cUq.ZR() != null && this.cUq.ZR().Aa() != null) {
            o.mD(this.cUq.threadData.getId());
            o.a(this.mTextTitle, this.cUq.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cUq.ZR().Aa());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caJ != null && this.cUv != null) {
            if (this.caI != null) {
                this.caI.setPageUniqueId(bdUniqueId);
            }
            this.cUv.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.caU != null) {
                this.caU.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cUv);
        }
    }

    public void iL(int i) {
        if (this.cUq != null && this.cUq.threadData != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setData(this.cUq.threadData);
                this.caI.showForumNameView(false);
                return;
            }
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
            if (this.caJ.setData(this.cUq.threadData)) {
                this.cUt.setVisibility(8);
            } else {
                this.cUt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}

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
    private View.OnClickListener axO;
    private View.OnClickListener axz;
    private String bHB;
    private ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public View bHR;
    public ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    private NEGFeedBackView bIa;
    public TbImageView bcS;
    public ImageView bcT;
    private TextView bcZ;
    private AlaPlayAnimationView cyA;
    private CustomMessageListener cyB;
    private View.OnClickListener cyC;
    private com.baidu.tieba.card.data.j cyw;
    public FrameLayout cyx;
    public RelativeLayout cyy;
    private View cyz;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiz() != null) {
                    m.this.aiz().a(view, m.this.cyw);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiz() != null) {
                    m.this.aiz().a(view, m.this.cyw);
                }
            }
        };
        this.cyB = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cyw != null && m.this.cyw.threadData != null && m.this.cyw.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cyw.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cyw.threadData.getId(), d.C0140d.cp_cont_d, d.C0140d.cp_cont_d);
                }
            }
        };
        this.cyC = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cyw != null && !StringUtils.isNull(m.this.cyw.threadData.vq())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cyw.threadData.vq(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.axz != null) {
                        m.this.axz.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cyx = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bHR = view.findViewById(d.g.divider_line);
        this.bIN = (LinearLayout) view.findViewById(d.g.content_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mContext);
        this.bIa = new NEGFeedBackView(aiy());
        this.bIa.a(this.cyx, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cyy = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyy.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cyy.setLayoutParams(layoutParams);
        this.bcS = (TbImageView) view.findViewById(d.g.image_video);
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setDefaultResource(0);
        this.bcS.setDefaultErrorResource(0);
        this.cyA = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setNeedAddPraiseIcon(true);
        if (this.bHO.getCommentContainer() != null) {
            this.bHO.getCommentContainer().setOnClickListener(this);
        }
        this.bHO.setShareVisible(true);
        this.bHO.setFrom(7);
        this.bHO.setShareReportFrom(3);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this);
        this.bIC.setFrom(7);
        this.bIC.setShareReportFrom(3);
        if (this.bIC.ayr.getCommentContainer() != null) {
            this.bIC.ayr.getCommentContainer().setOnClickListener(this);
        }
        this.bcZ = (TextView) view.findViewById(d.g.play_count);
        this.cyz = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bIN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.cyx, d.f.addresslist_item_bg);
            am.i(this.bIN, d.f.addresslist_item_bg);
            am.j(this.bHR, d.C0140d.cp_bg_line_e);
            am.h(this.mTextTitle, d.C0140d.cp_cont_b);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            am.c(this.bcT, d.f.btn_icon_play_live_on_n);
            am.j(this.cyy, d.C0140d.cp_bg_line_k);
            this.bHN.onChangeSkinType();
            this.bHO.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            this.bIC.onChangeSkinType();
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
        this.cyw = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cyw == null || this.cyw.Td() == null) {
            this.cyx.setVisibility(8);
            return;
        }
        this.cyx.setVisibility(0);
        this.bHN.setData(this.cyw.Td());
        this.bHN.setUserAfterClickListener(this.axO);
        if (this.bHN.getHeaderImg() != null) {
            this.bHN.getHeaderImg().setData(this.cyw.Td());
        }
        this.cyw.Td().vS();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cyw.Td().vJ()));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.H(this.cyw.threadData.vD().audience_count)));
        if (this.bIa != null && this.cyw.Td() != null) {
            ah ahVar = new ah();
            ahVar.dh(this.cyw.Td().getTid());
            ahVar.setFid(this.cyw.Td().getFid());
            ahVar.a(this.cyw.agt);
            this.bIa.setData(ahVar);
            this.bIa.setFirstRowSingleColumn(true);
        }
        hn(gu(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kX(this.cyw.threadData.getId())) {
            am.c(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        aiG();
        this.cyA.startPlayAnimation();
    }

    public void aiG() {
        if (com.baidu.tbadk.core.i.te().tk() && this.cyw != null && this.cyw.Td() != null && this.cyw.Td().vD() != null) {
            this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.bcS.startLoad(this.cyw.Td().vD().cover, 10, false);
            this.cyy.setVisibility(0);
            return;
        }
        this.cyy.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIN || view == this.bHO.getCommentContainer() || view == this.bIC.ayr.getCommentContainer()) {
            aj(view);
        }
    }

    private void aj(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyw);
        }
        if (this.cyw != null && this.cyw.Td() != null && this.cyw.Td().vD() != null) {
            o.kW(this.cyw.threadData.getId());
            o.a(this.mTextTitle, this.cyw.threadData.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cyw.Td().vD());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null && this.cyB != null) {
            if (this.bHN != null) {
                this.bHN.setPageUniqueId(bdUniqueId);
            }
            this.cyB.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bIa != null) {
                this.bIa.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cyB);
        }
    }

    public void hn(int i) {
        if (this.cyw != null && this.cyw.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.cyw.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
            if (this.bHO.setData(this.cyw.threadData)) {
                this.cyz.setVisibility(8);
            } else {
                this.cyz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}

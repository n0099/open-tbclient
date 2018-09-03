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
import com.baidu.tieba.f;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener axL;
    private View.OnClickListener axw;
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
    private com.baidu.tieba.card.data.j cyt;
    public FrameLayout cyu;
    public RelativeLayout cyv;
    private View cyw;
    private AlaPlayAnimationView cyx;
    private CustomMessageListener cyy;
    private View.OnClickListener cyz;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiC() != null) {
                    m.this.aiC().a(view, m.this.cyt);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiC() != null) {
                    m.this.aiC().a(view, m.this.cyt);
                }
            }
        };
        this.cyy = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cyt != null && m.this.cyt.threadData != null && m.this.cyt.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cyt.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cyt.threadData.getId(), f.d.cp_cont_d, f.d.cp_cont_d);
                }
            }
        };
        this.cyz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cyt != null && !StringUtils.isNull(m.this.cyt.threadData.vp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cyt.threadData.vp(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.axw != null) {
                        m.this.axw.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cyu = (FrameLayout) view.findViewById(f.g.layout_root);
        this.bHR = view.findViewById(f.g.divider_line);
        this.bIN = (LinearLayout) view.findViewById(f.g.content_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_ala_video_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mContext);
        this.bIa = new NEGFeedBackView(aiB());
        this.bIa.a(this.cyu, com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(f.g.text_title);
        this.cyv = (RelativeLayout) view.findViewById(f.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyv.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cyv.setLayoutParams(layoutParams);
        this.bcS = (TbImageView) view.findViewById(f.g.image_video);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setDefaultResource(0);
        this.bcS.setDefaultErrorResource(0);
        this.cyx = (AlaPlayAnimationView) view.findViewById(f.g.ala_play);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.text_bottom);
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
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_ala_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this);
        this.bIC.setFrom(7);
        this.bIC.setShareReportFrom(3);
        if (this.bIC.ayo.getCommentContainer() != null) {
            this.bIC.ayo.getCommentContainer().setOnClickListener(this);
        }
        this.bcZ = (TextView) view.findViewById(f.g.play_count);
        this.cyw = view.findViewById(f.g.divider_below_reply_number_layout);
        this.bIN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.cyu, f.C0146f.addresslist_item_bg);
            am.i(this.bIN, f.C0146f.addresslist_item_bg);
            am.j(this.bHR, f.d.cp_bg_line_e);
            am.h(this.mTextTitle, f.d.cp_cont_b);
            am.h(this.bcZ, f.d.cp_cont_i);
            am.c(this.bcT, f.C0146f.btn_icon_play_live_on_n);
            am.j(this.cyv, f.d.cp_bg_line_k);
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
        return f.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.cyt = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cyt == null || this.cyt.Tg() == null) {
            this.cyu.setVisibility(8);
            return;
        }
        this.cyu.setVisibility(0);
        this.bHN.setData(this.cyt.Tg());
        this.bHN.setUserAfterClickListener(this.axL);
        if (this.bHN.getHeaderImg() != null) {
            this.bHN.getHeaderImg().setData(this.cyt.Tg());
        }
        this.cyt.Tg().vR();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cyt.Tg().vI()));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.ala_audience_count_prefix), ap.H(this.cyt.threadData.vC().audience_count)));
        if (this.bIa != null && this.cyt.Tg() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cyt.Tg().getTid());
            ahVar.setFid(this.cyt.Tg().getFid());
            ahVar.a(this.cyt.agt);
            this.bIa.setData(ahVar);
            this.bIa.setFirstRowSingleColumn(true);
        }
        hm(gt(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cyt.threadData.getId())) {
            am.c(this.mTextTitle, f.d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, f.d.cp_cont_b, 1);
        }
        aiJ();
        this.cyx.startPlayAnimation();
    }

    public void aiJ() {
        if (com.baidu.tbadk.core.i.td().tj() && this.cyt != null && this.cyt.Tg() != null && this.cyt.Tg().vC() != null) {
            this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
            this.bcS.startLoad(this.cyt.Tg().vC().cover, 10, false);
            this.cyv.setVisibility(0);
            return;
        }
        this.cyv.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIN || view == this.bHO.getCommentContainer() || view == this.bIC.ayo.getCommentContainer()) {
            aj(view);
        }
    }

    private void aj(View view) {
        if (aiC() != null) {
            aiC().a(view, this.cyt);
        }
        if (this.cyt != null && this.cyt.Tg() != null && this.cyt.Tg().vC() != null) {
            o.kY(this.cyt.threadData.getId());
            o.a(this.mTextTitle, this.cyt.threadData.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cyt.Tg().vC());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null && this.cyy != null) {
            if (this.bHN != null) {
                this.bHN.setPageUniqueId(bdUniqueId);
            }
            this.cyy.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bIa != null) {
                this.bIa.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cyy);
        }
    }

    public void hm(int i) {
        if (this.cyt != null && this.cyt.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.cyt.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
            if (this.bHO.setData(this.cyt.threadData)) {
                this.cyw.setVisibility(8);
            } else {
                this.cyw.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}

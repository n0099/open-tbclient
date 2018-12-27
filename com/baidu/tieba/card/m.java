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
    private View.OnClickListener aIy;
    private View.OnClickListener aKC;
    public TbImageView boP;
    public ImageView boQ;
    private TextView boW;
    private com.baidu.tieba.card.data.j cXg;
    public FrameLayout cXh;
    public RelativeLayout cXi;
    private View cXj;
    private AlaPlayAnimationView cXk;
    private CustomMessageListener cXl;
    private View.OnClickListener cXm;
    private ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private NEGFeedBackView caX;
    private String caz;
    public LinearLayout cbK;
    public ThreadSourceShareAndPraiseLayout cbz;
    private TbPageContext<?> mContext;
    public View mDivider;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caX = null;
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.apS() != null) {
                    m.this.apS().a(view, m.this.cXg);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.apS() != null) {
                    m.this.apS().a(view, m.this.cXg);
                }
            }
        };
        this.cXl = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cXg != null && m.this.cXg.threadData != null && m.this.cXg.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cXg.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cXg.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cXm = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cXg != null && !StringUtils.isNull(m.this.cXg.threadData.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cXg.threadData.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aIy != null) {
                        m.this.aIy.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cXh = (FrameLayout) view.findViewById(e.g.layout_root);
        this.mDivider = view.findViewById(e.g.divider_line);
        this.cbK = (LinearLayout) view.findViewById(e.g.content_layout);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.caX = new NEGFeedBackView(this.mContext);
        this.caX = new NEGFeedBackView(getTbPageContext());
        this.caX.a(this.cXh, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cXi = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXi.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cXi.setLayoutParams(layoutParams);
        this.boP = (TbImageView) view.findViewById(e.g.image_video);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setDefaultResource(0);
        this.boP.setDefaultErrorResource(0);
        this.cXk = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.caM.setOnClickListener(this);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setNeedAddPraiseIcon(true);
        if (this.caM.getCommentContainer() != null) {
            this.caM.getCommentContainer().setOnClickListener(this);
        }
        this.caM.setShareVisible(true);
        this.caM.setFrom(7);
        this.caM.setShareReportFrom(3);
        this.caM.setDisPraiseFrom(1);
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this);
        this.cbz.setFrom(7);
        this.cbz.setShareReportFrom(3);
        if (this.cbz.aKk.getCommentContainer() != null) {
            this.cbz.aKk.getCommentContainer().setOnClickListener(this);
        }
        this.boW = (TextView) view.findViewById(e.g.play_count);
        this.cXj = view.findViewById(e.g.divider_below_reply_number_layout);
        this.cbK.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cXh, e.f.addresslist_item_bg);
            al.i(this.cbK, e.f.addresslist_item_bg);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.boW, e.d.cp_cont_i);
            al.c(this.boQ, e.f.btn_icon_play_live_on_n);
            al.j(this.cXi, e.d.cp_bg_line_k);
            this.caL.onChangeSkinType();
            this.caM.onChangeSkinType();
            if (this.caX != null) {
                this.caX.onChangeSkinType();
            }
            this.cbz.onChangeSkinType();
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
        this.cXg = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXg == null || this.cXg.ZT() == null) {
            this.cXh.setVisibility(8);
            return;
        }
        this.cXh.setVisibility(0);
        this.caL.setData(this.cXg.ZT());
        this.caL.setUserAfterClickListener(this.aKC);
        if (this.caL.getHeaderImg() != null) {
            this.caL.getHeaderImg().setData(this.cXg.ZT());
        }
        this.cXg.ZT().Aq();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cXg.ZT().Ag()));
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXg.threadData.Aa().audience_count)));
        if (this.caX != null && this.cXg.ZT() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cXg.ZT().getTid());
            ahVar.setFid(this.cXg.ZT().getFid());
            ahVar.a(this.cXg.asc);
            this.caX.setData(ahVar);
            this.caX.setFirstRowSingleColumn(true);
        }
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mH(this.cXg.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        apZ();
        this.cXk.startPlayAnimation();
    }

    public void apZ() {
        if (com.baidu.tbadk.core.i.xE().xI() && this.cXg != null && this.cXg.ZT() != null && this.cXg.ZT().Aa() != null) {
            this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.boP.startLoad(this.cXg.ZT().Aa().cover, 10, false);
            this.cXi.setVisibility(0);
            return;
        }
        this.cXi.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caX != null) {
            this.caX.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caL != null) {
            return this.caL.aKp;
        }
        return null;
    }

    public View apV() {
        if (this.caL != null) {
            return this.caL.aKr;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cbK || view == this.caM.getCommentContainer() || view == this.cbz.aKk.getCommentContainer()) {
            aC(view);
        }
    }

    private void aC(View view) {
        if (apS() != null) {
            apS().a(view, this.cXg);
        }
        if (this.cXg != null && this.cXg.ZT() != null && this.cXg.ZT().Aa() != null) {
            o.mG(this.cXg.threadData.getId());
            o.a(this.mTextTitle, this.cXg.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXg.ZT().Aa());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caM != null && this.cXl != null) {
            if (this.caL != null) {
                this.caL.setPageUniqueId(bdUniqueId);
            }
            this.cXl.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.caX != null) {
                this.caX.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cXl);
        }
    }

    public void iM(int i) {
        if (this.cXg != null && this.cXg.threadData != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setData(this.cXg.threadData);
                this.caL.showForumNameView(false);
                return;
            }
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
            if (this.caM.setData(this.cXg.threadData)) {
                this.cXj.setVisibility(8);
            } else {
                this.cXj.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    public void kL(int i) {
        if (this.caM != null) {
            this.caM.aJD = String.valueOf(i);
        }
    }
}

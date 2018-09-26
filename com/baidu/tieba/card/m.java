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
/* loaded from: classes2.dex */
public class m extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private View.OnClickListener aBE;
    private View.OnClickListener azz;
    private ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    public View bNG;
    private NEGFeedBackView bNP;
    private String bNq;
    public LinearLayout bOC;
    public ThreadSourceShareAndPraiseLayout bOr;
    public TbImageView bgn;
    public ImageView bgo;
    private TextView bgv;
    private com.baidu.tieba.card.data.j cEj;
    public FrameLayout cEk;
    public RelativeLayout cEl;
    private View cEm;
    private AlaPlayAnimationView cEn;
    private CustomMessageListener cEo;
    private View.OnClickListener cEp;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNP = null;
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akm() != null) {
                    m.this.akm().a(view, m.this.cEj);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akm() != null) {
                    m.this.akm().a(view, m.this.cEj);
                }
            }
        };
        this.cEo = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cEj != null && m.this.cEj.threadData != null && m.this.cEj.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cEj.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cEj.threadData.getId(), e.d.cp_cont_d, e.d.cp_cont_d);
                }
            }
        };
        this.cEp = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cEj != null && !StringUtils.isNull(m.this.cEj.threadData.ws())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cEj.threadData.ws(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.azz != null) {
                        m.this.azz.onClick(view);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cEk = (FrameLayout) view.findViewById(e.g.layout_root);
        this.bNG = view.findViewById(e.g.divider_line);
        this.bOC = (LinearLayout) view.findViewById(e.g.content_layout);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_ala_video_user_info_layout);
        this.bNP = new NEGFeedBackView(this.mContext);
        this.bNP = new NEGFeedBackView(getTbPageContext());
        this.bNP.a(this.cEk, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cEl = (RelativeLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cEl.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cEl.setLayoutParams(layoutParams);
        this.bgn = (TbImageView) view.findViewById(e.g.image_video);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setDefaultResource(0);
        this.bgn.setDefaultErrorResource(0);
        this.cEn = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bND.setOnClickListener(this);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setNeedAddPraiseIcon(true);
        if (this.bND.getCommentContainer() != null) {
            this.bND.getCommentContainer().setOnClickListener(this);
        }
        this.bND.setShareVisible(true);
        this.bND.setFrom(7);
        this.bND.setShareReportFrom(3);
        this.bND.setDisPraiseFrom(1);
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_ala_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this);
        this.bOr.setFrom(7);
        this.bOr.setShareReportFrom(3);
        if (this.bOr.aBl.getCommentContainer() != null) {
            this.bOr.aBl.getCommentContainer().setOnClickListener(this);
        }
        this.bgv = (TextView) view.findViewById(e.g.play_count);
        this.cEm = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bOC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cEk, e.f.addresslist_item_bg);
            al.i(this.bOC, e.f.addresslist_item_bg);
            al.j(this.bNG, e.d.cp_bg_line_e);
            al.h(this.mTextTitle, e.d.cp_cont_b);
            al.h(this.bgv, e.d.cp_cont_i);
            al.c(this.bgo, e.f.btn_icon_play_live_on_n);
            al.j(this.cEl, e.d.cp_bg_line_k);
            this.bNC.onChangeSkinType();
            this.bND.onChangeSkinType();
            if (this.bNP != null) {
                this.bNP.onChangeSkinType();
            }
            this.bOr.onChangeSkinType();
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
        this.cEj = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cEj == null || this.cEj.UT() == null) {
            this.cEk.setVisibility(8);
            return;
        }
        this.cEk.setVisibility(0);
        this.bNC.setData(this.cEj.UT());
        this.bNC.setUserAfterClickListener(this.aBE);
        if (this.bNC.getHeaderImg() != null) {
            this.bNC.getHeaderImg().setData(this.cEj.UT());
        }
        this.cEj.UT().wW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cEj.UT().wM()));
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.L(this.cEj.threadData.wG().audience_count)));
        if (this.bNP != null && this.cEj.UT() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cEj.UT().getTid());
            ahVar.setFid(this.cEj.UT().getFid());
            ahVar.a(this.cEj.aiT);
            this.bNP.setData(ahVar);
            this.bNP.setFirstRowSingleColumn(true);
        }
        hM(gT(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lB(this.cEj.threadData.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        akt();
        this.cEn.startPlayAnimation();
    }

    public void akt() {
        if (com.baidu.tbadk.core.i.uj().un() && this.cEj != null && this.cEj.UT() != null && this.cEj.UT().wG() != null) {
            this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.bgn.startLoad(this.cEj.UT().wG().cover, 10, false);
            this.cEl.setVisibility(0);
            return;
        }
        this.cEl.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bNP != null) {
            this.bNP.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bOC || view == this.bND.getCommentContainer() || view == this.bOr.aBl.getCommentContainer()) {
            ax(view);
        }
    }

    private void ax(View view) {
        if (akm() != null) {
            akm().a(view, this.cEj);
        }
        if (this.cEj != null && this.cEj.UT() != null && this.cEj.UT().wG() != null) {
            o.lA(this.cEj.threadData.getId());
            o.a(this.mTextTitle, this.cEj.threadData.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cEj.UT().wG());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bND != null && this.cEo != null) {
            if (this.bNC != null) {
                this.bNC.setPageUniqueId(bdUniqueId);
            }
            this.cEo.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bNP != null) {
                this.bNP.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cEo);
        }
    }

    public void hM(int i) {
        if (this.cEj != null && this.cEj.threadData != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setData(this.cEj.threadData);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
            if (this.bND.setData(this.cEj.threadData)) {
                this.cEm.setVisibility(8);
            } else {
                this.cEm.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}

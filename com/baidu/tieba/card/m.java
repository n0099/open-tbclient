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
    private TbPageContext<?> adf;
    private View.OnClickListener aoY;
    private View.OnClickListener apj;
    public ImageView bkA;
    private String bvX;
    public ThreadSourceShareAndPraiseLayout bwZ;
    private ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    public View bwn;
    private NEGFeedBackView bww;
    private com.baidu.tieba.card.data.j cod;
    public FrameLayout coe;
    public RelativeLayout cof;
    public TbImageView cog;
    private TextView coh;
    private View coi;
    private AlaPlayAnimationView coj;
    private CustomMessageListener cok;
    private View.OnClickListener col;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.cod);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.cod);
                }
            }
        };
        this.cok = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cod != null && m.this.cod.threadData != null && m.this.cod.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.cod.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.cod.threadData.getId(), d.C0126d.cp_cont_d, d.C0126d.cp_cont_d);
                }
            }
        };
        this.col = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.cod != null && !StringUtils.isNull(m.this.cod.threadData.rV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.cod.threadData.rV(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (m.this.aoY != null) {
                        m.this.aoY.onClick(view2);
                    }
                }
            }
        };
        this.adf = tbPageContext;
        init(getView());
    }

    private void init(View view2) {
        this.coe = (FrameLayout) view2.findViewById(d.g.layout_root);
        this.bwn = view2.findViewById(d.g.divider_line);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bww = new NEGFeedBackView(this.adf);
        this.bww = new NEGFeedBackView(aeY());
        this.bww.a(this.coe, com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.cof = (RelativeLayout) view2.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cof.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cof.setLayoutParams(layoutParams);
        this.cog = (TbImageView) view2.findViewById(d.g.image_video);
        this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cog.setDefaultResource(0);
        this.cog.setDefaultErrorResource(0);
        this.coj = (AlaPlayAnimationView) view2.findViewById(d.g.ala_play);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        this.bwk.setOnClickListener(this);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setNeedAddPraiseIcon(true);
        if (this.bwk.getCommentContainer() != null) {
            this.bwk.getCommentContainer().setOnClickListener(this);
        }
        this.bwk.setShareVisible(true);
        this.bwk.setFrom(7);
        this.bwk.setShareReportFrom(3);
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_ala_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this);
        this.bwZ.setFrom(7);
        this.bwZ.setShareReportFrom(3);
        if (this.bwZ.apG.getCommentContainer() != null) {
            this.bwZ.apG.getCommentContainer().setOnClickListener(this);
        }
        this.coh = (TextView) view2.findViewById(d.g.play_count);
        this.coi = view2.findViewById(d.g.divider_below_reply_number_layout);
        this.coe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.coe, d.f.addresslist_item_bg);
            ak.j(this.bwn, d.C0126d.cp_bg_line_e);
            ak.h(this.mTextTitle, d.C0126d.cp_cont_b);
            ak.h(this.coh, d.C0126d.cp_cont_i);
            ak.c(this.bkA, d.f.btn_icon_play_live_on_n);
            ak.j(this.cof, d.C0126d.cp_bg_line_k);
            this.bwj.onChangeSkinType();
            this.bwk.onChangeSkinType();
            if (this.bww != null) {
                this.bww.onChangeSkinType();
            }
            this.bwZ.onChangeSkinType();
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
        this.cod = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cod == null || this.cod.Pe() == null) {
            this.coe.setVisibility(8);
            return;
        }
        this.coe.setVisibility(0);
        this.bwj.setData(this.cod.Pe());
        this.bwj.setUserAfterClickListener(this.apj);
        if (this.bwj.getHeaderImg() != null) {
            this.bwj.getHeaderImg().setData(this.cod.Pe());
        }
        this.cod.Pe().sx();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cod.Pe().so()));
        this.coh.setText(String.format(this.adf.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cod.threadData.si().audience_count)));
        if (this.bww != null && this.cod.Pe() != null) {
            ai aiVar = new ai();
            aiVar.cJ(this.cod.Pe().getTid());
            aiVar.setFid(this.cod.Pe().getFid());
            aiVar.a(this.cod.YI);
            this.bww.setData(aiVar);
            this.bww.setFirstRowSingleColumn(true);
        }
        hc(gn(1));
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        if (o.kw(this.cod.threadData.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        afg();
        this.coj.startPlayAnimation();
    }

    public void afg() {
        if (com.baidu.tbadk.core.i.pY().qe() && this.cod != null && this.cod.Pe() != null && this.cod.Pe().si() != null) {
            this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cog.startLoad(this.cod.Pe().si().cover, 10, false);
            this.cof.setVisibility(0);
            return;
        }
        this.cof.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.coe || view2 == this.bwk.getCommentContainer() || view2 == this.bwZ.apG.getCommentContainer()) {
            ae(view2);
        }
    }

    private void ae(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cod);
        }
        if (this.cod != null && this.cod.Pe() != null && this.cod.Pe().si() != null) {
            o.kv(this.cod.threadData.getId());
            o.a(this.mTextTitle, this.cod.threadData.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cod.Pe().si());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.adf.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null && this.cok != null) {
            if (this.bwj != null) {
                this.bwj.setPageUniqueId(bdUniqueId);
            }
            this.cok.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bww != null) {
                this.bww.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cok);
        }
    }

    public void hc(int i) {
        if (this.cod != null && this.cod.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.cod.threadData);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
            if (this.bwk.setData(this.cod.threadData)) {
                this.coi.setVisibility(8);
            } else {
                this.coi.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}

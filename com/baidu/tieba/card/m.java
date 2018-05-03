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
    private com.baidu.tieba.card.data.j coa;
    public FrameLayout cob;
    public RelativeLayout coc;
    public TbImageView cod;
    private TextView coe;
    private View cof;
    private AlaPlayAnimationView cog;
    private CustomMessageListener coh;
    private View.OnClickListener coi;
    public TextView mTextTitle;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.coa);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.aeZ() != null) {
                    m.this.aeZ().a(view2, m.this.coa);
                }
            }
        };
        this.coh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.coa != null && m.this.coa.threadData != null && m.this.coa.threadData.getTid() != null && m.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(m.this.coa.threadData.getTid())) {
                    o.a(m.this.mTextTitle, m.this.coa.threadData.getId(), d.C0126d.cp_cont_d, d.C0126d.cp_cont_d);
                }
            }
        };
        this.coi = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.coa != null && !StringUtils.isNull(m.this.coa.threadData.rV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(m.this.getContext()).createNormalCfg(m.this.coa.threadData.rV(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
        this.cob = (FrameLayout) view2.findViewById(d.g.layout_root);
        this.bwn = view2.findViewById(d.g.divider_line);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bww = new NEGFeedBackView(this.adf);
        this.bww = new NEGFeedBackView(aeY());
        this.bww.a(this.cob, com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.coc = (RelativeLayout) view2.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coc.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.coc.setLayoutParams(layoutParams);
        this.cod = (TbImageView) view2.findViewById(d.g.image_video);
        this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cod.setDefaultResource(0);
        this.cod.setDefaultErrorResource(0);
        this.cog = (AlaPlayAnimationView) view2.findViewById(d.g.ala_play);
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
        this.coe = (TextView) view2.findViewById(d.g.play_count);
        this.cof = view2.findViewById(d.g.divider_below_reply_number_layout);
        this.cob.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.cob, d.f.addresslist_item_bg);
            ak.j(this.bwn, d.C0126d.cp_bg_line_e);
            ak.h(this.mTextTitle, d.C0126d.cp_cont_b);
            ak.h(this.coe, d.C0126d.cp_cont_i);
            ak.c(this.bkA, d.f.btn_icon_play_live_on_n);
            ak.j(this.coc, d.C0126d.cp_bg_line_k);
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
        this.coa = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.coa == null || this.coa.Pe() == null) {
            this.cob.setVisibility(8);
            return;
        }
        this.cob.setVisibility(0);
        this.bwj.setData(this.coa.Pe());
        this.bwj.setUserAfterClickListener(this.apj);
        if (this.bwj.getHeaderImg() != null) {
            this.bwj.getHeaderImg().setData(this.coa.Pe());
        }
        this.coa.Pe().sx();
        this.mTextTitle.setText(new SpannableStringBuilder(this.coa.Pe().so()));
        this.coe.setText(String.format(this.adf.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.coa.threadData.si().audience_count)));
        if (this.bww != null && this.coa.Pe() != null) {
            ai aiVar = new ai();
            aiVar.cJ(this.coa.Pe().getTid());
            aiVar.setFid(this.coa.Pe().getFid());
            aiVar.a(this.coa.YI);
            this.bww.setData(aiVar);
            this.bww.setFirstRowSingleColumn(true);
        }
        hb(gm(1));
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        if (o.kw(this.coa.threadData.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        afg();
        this.cog.startPlayAnimation();
    }

    public void afg() {
        if (com.baidu.tbadk.core.i.pY().qe() && this.coa != null && this.coa.Pe() != null && this.coa.Pe().si() != null) {
            this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cod.startLoad(this.coa.Pe().si().cover, 10, false);
            this.coc.setVisibility(0);
            return;
        }
        this.coc.setVisibility(8);
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cob || view2 == this.bwk.getCommentContainer() || view2 == this.bwZ.apG.getCommentContainer()) {
            ae(view2);
        }
    }

    private void ae(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.coa);
        }
        if (this.coa != null && this.coa.Pe() != null && this.coa.Pe().si() != null) {
            o.kv(this.coa.threadData.getId());
            o.a(this.mTextTitle, this.coa.threadData.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.coa.Pe().si());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.adf.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null && this.coh != null) {
            if (this.bwj != null) {
                this.bwj.setPageUniqueId(bdUniqueId);
            }
            this.coh.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bww != null) {
                this.bww.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.coh);
        }
    }

    public void hb(int i) {
        if (this.coa != null && this.coa.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.coa.threadData);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
            if (this.bwk.setData(this.coa.threadData)) {
                this.cof.setVisibility(8);
            } else {
                this.cof.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}

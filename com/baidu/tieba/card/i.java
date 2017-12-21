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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aca;
    private View.OnClickListener anT;
    private View.OnClickListener aog;
    private com.baidu.tieba.NEGFeedBack.c bZk;
    public ImageView blb;
    public View bqw;
    private ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private com.baidu.tieba.card.data.k cac;
    public FrameLayout cad;
    public RelativeLayout cae;
    public TbImageView caf;
    private TextView cag;
    private View cah;
    private AlaPlayAnimationView cai;
    private CustomMessageListener caj;
    private View.OnClickListener cak;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZk = null;
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.cac);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.cac);
                }
            }
        };
        this.caj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.cac != null && i.this.cac.threadData != null && i.this.cac.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.cac.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.cac.threadData.getId(), d.C0095d.cp_cont_d, d.C0095d.cp_cont_d);
                }
            }
        };
        this.cak = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cac != null && !StringUtils.isNull(i.this.cac.threadData.rB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.cac.threadData.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anT != null) {
                        i.this.anT.onClick(view);
                    }
                }
            }
        };
        this.aca = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cad = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bqw = view.findViewById(d.g.divider_line);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(this.aca);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(abs());
        this.bZk.a(this.cad, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cae = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cae.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ac(this.aca.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cae.setLayoutParams(layoutParams);
        this.caf = (TbImageView) view.findViewById(d.g.image_video);
        this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.caf.setDefaultResource(0);
        this.caf.setDefaultErrorResource(0);
        this.cai = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.blb = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvM.setOnClickListener(this);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setNeedAddPraiseIcon(true);
        if (this.bvM.getCommentContainer() != null) {
            this.bvM.getCommentContainer().setOnClickListener(this);
        }
        this.bvM.setShareVisible(true);
        this.bvM.setFrom(1);
        this.cag = (TextView) view.findViewById(d.g.play_count);
        this.cah = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cad.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.cad, d.f.addresslist_item_bg);
            aj.k(this.bqw, d.C0095d.cp_bg_line_e);
            aj.i(this.mTextTitle, d.C0095d.cp_cont_b);
            aj.i(this.cag, d.C0095d.cp_cont_i);
            aj.c(this.blb, d.f.btn_icon_play_live_on_n);
            aj.k(this.cae, d.C0095d.cp_bg_line_k);
            this.bvI.onChangeSkinType();
            this.bvM.onChangeSkinType();
            if (this.bZk != null) {
                this.bZk.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.cac = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cac == null || this.cac.Ox() == null) {
            this.cad.setVisibility(8);
            return;
        }
        this.cad.setVisibility(0);
        this.bvI.setData(this.cac.Ox());
        this.bvI.setUserAfterClickListener(this.aog);
        if (this.bvI.getHeaderImg() != null) {
            this.bvI.getHeaderImg().setData(this.cac.Ox());
        }
        this.cac.Ox().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cac.Ox().rV()));
        if (this.bvM.setData(this.cac.threadData)) {
            this.cah.setVisibility(8);
        } else {
            this.cah.setVisibility(0);
        }
        this.cag.setText(String.format(this.aca.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.cac.threadData.rO().audience_count)));
        if (this.bZk != null && this.cac.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.cac.Ox().getTid());
            ahVar.setFid(this.cac.Ox().getFid());
            ahVar.a(this.cac.XB);
            this.bZk.setData(ahVar);
            this.bZk.setFirstRowSingleColumn(true);
        }
        d(this.aca, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.cac.threadData.getId())) {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_b, 1);
        }
        abA();
        this.cai.startPlayAnimation();
    }

    public void abA() {
        if (com.baidu.tbadk.core.h.oY().pe() && this.cac != null && this.cac.Ox() != null && this.cac.Ox().rO() != null) {
            this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.caf.startLoad(this.cac.Ox().rO().cover, 10, false);
            this.cae.setVisibility(0);
            return;
        }
        this.cae.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bZk != null) {
            this.bZk.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cad || view == this.bvM.getCommentContainer()) {
            ah(view);
        }
    }

    private void ah(View view) {
        if (abt() != null) {
            abt().a(view, this.cac);
        }
        if (this.cac != null && this.cac.Ox() != null && this.cac.Ox().rO() != null) {
            k.jO(this.cac.threadData.getId());
            k.a(this.mTextTitle, this.cac.threadData.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cac.Ox().rO());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.aca.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvM != null && this.caj != null) {
            if (this.bvI != null) {
                this.bvI.setPageUniqueId(bdUniqueId);
            }
            this.caj.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bZk != null) {
                this.bZk.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.caj);
        }
    }
}

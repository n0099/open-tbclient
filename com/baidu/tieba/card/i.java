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
    private TbPageContext<?> abX;
    private View.OnClickListener anQ;
    private View.OnClickListener aod;
    private com.baidu.tieba.card.data.k bZY;
    public FrameLayout bZZ;
    private com.baidu.tieba.NEGFeedBack.c bZg;
    public ImageView bkX;
    public View bqs;
    private ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    public RelativeLayout caa;
    public TbImageView cab;
    private TextView cac;
    private View cad;
    private AlaPlayAnimationView cae;
    private CustomMessageListener caf;
    private View.OnClickListener cag;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZg = null;
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.bZY);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.bZY);
                }
            }
        };
        this.caf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bZY != null && i.this.bZY.threadData != null && i.this.bZY.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bZY.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.bZY.threadData.getId(), d.C0096d.cp_cont_d, d.C0096d.cp_cont_d);
                }
            }
        };
        this.cag = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bZY != null && !StringUtils.isNull(i.this.bZY.threadData.rB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bZY.threadData.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anQ != null) {
                        i.this.anQ.onClick(view);
                    }
                }
            }
        };
        this.abX = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bZZ = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bqs = view.findViewById(d.g.divider_line);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(this.abX);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(abs());
        this.bZg.a(this.bZZ, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.caa = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caa.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ac(this.abX.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.caa.setLayoutParams(layoutParams);
        this.cab = (TbImageView) view.findViewById(d.g.image_video);
        this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cab.setDefaultResource(0);
        this.cab.setDefaultErrorResource(0);
        this.cae = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bkX = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvI.setOnClickListener(this);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setNeedAddPraiseIcon(true);
        if (this.bvI.getCommentContainer() != null) {
            this.bvI.getCommentContainer().setOnClickListener(this);
        }
        this.bvI.setShareVisible(true);
        this.bvI.setFrom(1);
        this.cac = (TextView) view.findViewById(d.g.play_count);
        this.cad = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bZZ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bZZ, d.f.addresslist_item_bg);
            aj.k(this.bqs, d.C0096d.cp_bg_line_e);
            aj.i(this.mTextTitle, d.C0096d.cp_cont_b);
            aj.i(this.cac, d.C0096d.cp_cont_i);
            aj.c(this.bkX, d.f.btn_icon_play_live_on_n);
            aj.k(this.caa, d.C0096d.cp_bg_line_k);
            this.bvE.onChangeSkinType();
            this.bvI.onChangeSkinType();
            if (this.bZg != null) {
                this.bZg.onChangeSkinType();
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
        this.bZY = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bZY == null || this.bZY.Ox() == null) {
            this.bZZ.setVisibility(8);
            return;
        }
        this.bZZ.setVisibility(0);
        this.bvE.setData(this.bZY.Ox());
        this.bvE.setUserAfterClickListener(this.aod);
        if (this.bvE.getHeaderImg() != null) {
            this.bvE.getHeaderImg().setData(this.bZY.Ox());
        }
        this.bZY.Ox().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bZY.Ox().rV()));
        if (this.bvI.setData(this.bZY.threadData)) {
            this.cad.setVisibility(8);
        } else {
            this.cad.setVisibility(0);
        }
        this.cac.setText(String.format(this.abX.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bZY.threadData.rO().audience_count)));
        if (this.bZg != null && this.bZY.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.bZY.Ox().getTid());
            ahVar.setFid(this.bZY.Ox().getFid());
            ahVar.a(this.bZY.Xy);
            this.bZg.setData(ahVar);
            this.bZg.setFirstRowSingleColumn(true);
        }
        d(this.abX, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.bZY.threadData.getId())) {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_b, 1);
        }
        abA();
        this.cae.startPlayAnimation();
    }

    public void abA() {
        if (com.baidu.tbadk.core.h.oY().pe() && this.bZY != null && this.bZY.Ox() != null && this.bZY.Ox().rO() != null) {
            this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cab.startLoad(this.bZY.Ox().rO().cover, 10, false);
            this.caa.setVisibility(0);
            return;
        }
        this.caa.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bZg != null) {
            this.bZg.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bZZ || view == this.bvI.getCommentContainer()) {
            ah(view);
        }
    }

    private void ah(View view) {
        if (abt() != null) {
            abt().a(view, this.bZY);
        }
        if (this.bZY != null && this.bZY.Ox() != null && this.bZY.Ox().rO() != null) {
            k.jO(this.bZY.threadData.getId());
            k.a(this.mTextTitle, this.bZY.threadData.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bZY.Ox().rO());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.abX.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvI != null && this.caf != null) {
            if (this.bvE != null) {
                this.bvE.setPageUniqueId(bdUniqueId);
            }
            this.caf.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bZg != null) {
                this.bZg.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.caf);
        }
    }
}

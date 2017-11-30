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
    private TbPageContext<?> acd;
    private View.OnClickListener anO;
    private View.OnClickListener aob;
    private com.baidu.tieba.card.data.k bZU;
    public FrameLayout bZV;
    public RelativeLayout bZW;
    public TbImageView bZX;
    private TextView bZY;
    private View bZZ;
    private com.baidu.tieba.NEGFeedBack.c bZc;
    public ImageView bkW;
    public View bqr;
    private ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    private AlaPlayAnimationView caa;
    private CustomMessageListener cab;
    private View.OnClickListener cac;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZc = null;
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abs() != null) {
                    i.this.abs().a(view, i.this.bZU);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abs() != null) {
                    i.this.abs().a(view, i.this.bZU);
                }
            }
        };
        this.cab = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bZU != null && i.this.bZU.threadData != null && i.this.bZU.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bZU.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.bZU.threadData.getId(), d.C0082d.cp_cont_d, d.C0082d.cp_cont_d);
                }
            }
        };
        this.cac = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bZU != null && !StringUtils.isNull(i.this.bZU.threadData.rD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bZU.threadData.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anO != null) {
                        i.this.anO.onClick(view);
                    }
                }
            }
        };
        this.acd = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bZV = (FrameLayout) view.findViewById(d.g.layout_root);
        this.bqr = view.findViewById(d.g.divider_line);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(this.acd);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(abr());
        this.bZc.a(this.bZV, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bZW = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZW.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ac(this.acd.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.acd.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bZW.setLayoutParams(layoutParams);
        this.bZX = (TbImageView) view.findViewById(d.g.image_video);
        this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bZX.setDefaultResource(0);
        this.bZX.setDefaultErrorResource(0);
        this.caa = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bkW = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvH.setOnClickListener(this);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setNeedAddPraiseIcon(true);
        if (this.bvH.getCommentContainer() != null) {
            this.bvH.getCommentContainer().setOnClickListener(this);
        }
        this.bvH.setShareVisible(true);
        this.bvH.setFrom(1);
        this.bZY = (TextView) view.findViewById(d.g.play_count);
        this.bZZ = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bZV.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bZV, d.f.addresslist_item_bg);
            aj.k(this.bqr, d.C0082d.cp_bg_line_e);
            aj.i(this.mTextTitle, d.C0082d.cp_cont_b);
            aj.i(this.bZY, d.C0082d.cp_cont_i);
            aj.c(this.bkW, d.f.btn_icon_play_live_on_n);
            aj.k(this.bZW, d.C0082d.cp_bg_line_k);
            this.bvD.onChangeSkinType();
            this.bvH.onChangeSkinType();
            if (this.bZc != null) {
                this.bZc.onChangeSkinType();
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
        this.bZU = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bZU == null || this.bZU.Ox() == null) {
            this.bZV.setVisibility(8);
            return;
        }
        this.bZV.setVisibility(0);
        this.bvD.setData(this.bZU.Ox());
        this.bvD.setUserAfterClickListener(this.aob);
        if (this.bvD.getHeaderImg() != null) {
            this.bvD.getHeaderImg().setData(this.bZU.Ox());
        }
        this.bZU.Ox().sf();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bZU.Ox().rX()));
        if (this.bvH.setData(this.bZU.threadData)) {
            this.bZZ.setVisibility(8);
        } else {
            this.bZZ.setVisibility(0);
        }
        this.bZY.setText(String.format(this.acd.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bZU.threadData.rQ().audience_count)));
        if (this.bZc != null && this.bZU.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.bZU.Ox().getTid());
            ahVar.setFid(this.bZU.Ox().getFid());
            ahVar.a(this.bZU.XE);
            this.bZc.setData(ahVar);
            this.bZc.setFirstRowSingleColumn(true);
        }
        d(this.acd, TbadkCoreApplication.getInst().getSkinType());
        if (k.jR(this.bZU.threadData.getId())) {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_b, 1);
        }
        abz();
        this.caa.startPlayAnimation();
    }

    public void abz() {
        if (com.baidu.tbadk.core.h.pa().pg() && this.bZU != null && this.bZU.Ox() != null && this.bZU.Ox().rQ() != null) {
            this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.bZX.startLoad(this.bZU.Ox().rQ().cover, 10, false);
            this.bZW.setVisibility(0);
            return;
        }
        this.bZW.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bZc != null) {
            this.bZc.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bZV || view == this.bvH.getCommentContainer()) {
            ag(view);
        }
    }

    private void ag(View view) {
        if (abs() != null) {
            abs().a(view, this.bZU);
        }
        if (this.bZU != null && this.bZU.Ox() != null && this.bZU.Ox().rQ() != null) {
            k.jQ(this.bZU.threadData.getId());
            k.a(this.mTextTitle, this.bZU.threadData.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bZU.Ox().rQ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.acd.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvH != null && this.cab != null) {
            if (this.bvD != null) {
                this.bvD.setPageUniqueId(bdUniqueId);
            }
            this.cab.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bZc != null) {
                this.bZc.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cab);
        }
    }
}

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
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aQp;
    public ImageView bYt;
    private View.OnClickListener bbR;
    private View.OnClickListener bce;
    public ThreadSourceShareAndPraiseLayout cSr;
    private com.baidu.tieba.card.data.k cTi;
    public FrameLayout cTj;
    public RelativeLayout cTk;
    public TbImageView cTl;
    private TextView cTm;
    private View cTn;
    private AlaPlayAnimationView cTo;
    private CustomMessageListener cTp;
    private View.OnClickListener cTq;
    public View cdX;
    private ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private com.baidu.tieba.NEGFeedBack.c ciW;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciW = null;
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akb() != null) {
                    i.this.akb().a(view, i.this.cTi);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akb() != null) {
                    i.this.akb().a(view, i.this.cTi);
                }
            }
        };
        this.cTp = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.cTi != null && i.this.cTi.threadData != null && i.this.cTi.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.cTi.threadData.getTid())) {
                    k.a(i.this.mTextTitle, i.this.cTi.threadData.getId(), d.C0107d.cp_cont_d, d.C0107d.cp_cont_d);
                }
            }
        };
        this.cTq = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cTi != null && !StringUtils.isNull(i.this.cTi.threadData.yY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.cTi.threadData.yY(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.bbR != null) {
                        i.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.aQp = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.cTj = (FrameLayout) view.findViewById(d.g.layout_root);
        this.cdX = view.findViewById(d.g.divider_line);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(this.aQp);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(aka());
        this.ciW.a(this.cTj, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cTk = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cTk.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ao(this.aQp.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.cTk.setLayoutParams(layoutParams);
        this.cTl = (TbImageView) view.findViewById(d.g.image_video);
        this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTl.setDefaultResource(0);
        this.cTl.setDefaultErrorResource(0);
        this.cTo = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
        this.bYt = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciL.setOnClickListener(this);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setNeedAddPraiseIcon(true);
        if (this.ciL.getCommentContainer() != null) {
            this.ciL.getCommentContainer().setOnClickListener(this);
        }
        this.ciL.setShareVisible(true);
        this.ciL.setFrom(7);
        this.ciL.setShareReportFrom(3);
        this.cSr = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.cSr.bcA.setOnClickListener(this);
        this.cSr.setFrom(7);
        this.cSr.setShareReportFrom(3);
        if (this.cSr.bcA.getCommentContainer() != null) {
            this.cSr.bcA.getCommentContainer().setOnClickListener(this);
        }
        this.cTm = (TextView) view.findViewById(d.g.play_count);
        this.cTn = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cTj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cTj, d.f.addresslist_item_bg);
            aj.t(this.cdX, d.C0107d.cp_bg_line_e);
            aj.r(this.mTextTitle, d.C0107d.cp_cont_b);
            aj.r(this.cTm, d.C0107d.cp_cont_i);
            aj.c(this.bYt, d.f.btn_icon_play_live_on_n);
            aj.t(this.cTk, d.C0107d.cp_bg_line_k);
            this.ciK.onChangeSkinType();
            this.ciL.onChangeSkinType();
            if (this.ciW != null) {
                this.ciW.onChangeSkinType();
            }
            this.cSr.onChangeSkinType();
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
        this.cTi = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cTi == null || this.cTi.VK() == null) {
            this.cTj.setVisibility(8);
            return;
        }
        this.cTj.setVisibility(0);
        this.ciK.setData(this.cTi.VK());
        this.ciK.setUserAfterClickListener(this.bce);
        if (this.ciK.getHeaderImg() != null) {
            this.ciK.getHeaderImg().setData(this.cTi.VK());
        }
        this.cTi.VK().zB();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cTi.VK().zs()));
        this.cTm.setText(String.format(this.aQp.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cTi.threadData.zl().audience_count)));
        if (this.ciW != null && this.cTi.VK() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cTi.VK().getTid());
            ahVar.setFid(this.cTi.VK().getFid());
            ahVar.a(this.cTi.aLV);
            this.ciW.setData(ahVar);
            this.ciW.setFirstRowSingleColumn(true);
        }
        lD(this.cTi.VK().aPa);
        d(this.aQp, TbadkCoreApplication.getInst().getSkinType());
        if (k.kd(this.cTi.threadData.getId())) {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_b, 1);
        }
        aki();
        this.cTo.startPlayAnimation();
    }

    public void aki() {
        if (com.baidu.tbadk.core.i.wA().wG() && this.cTi != null && this.cTi.VK() != null && this.cTi.VK().zl() != null) {
            this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.cTl.startLoad(this.cTi.VK().zl().cover, 10, false);
            this.cTk.setVisibility(0);
            return;
        }
        this.cTk.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.ciW != null) {
            this.ciW.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cTj || view == this.ciL.getCommentContainer() || view == this.cSr.bcA.getCommentContainer()) {
            bB(view);
        }
    }

    private void bB(View view) {
        if (akb() != null) {
            akb().a(view, this.cTi);
        }
        if (this.cTi != null && this.cTi.VK() != null && this.cTi.VK().zl() != null) {
            k.kc(this.cTi.threadData.getId());
            k.a(this.mTextTitle, this.cTi.threadData.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cTi.VK().zl());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.aQp.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciL != null && this.cTp != null) {
            if (this.ciK != null) {
                this.ciK.setPageUniqueId(bdUniqueId);
            }
            this.cTp.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.ciW != null) {
                this.ciW.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cTp);
        }
    }

    public void lD(int i) {
        if (this.cTi != null && this.cTi.threadData != null) {
            if (i == 1) {
                this.ciL.setVisibility(8);
                this.cSr.setData(this.cTi.threadData);
                this.ciK.showForumNameView(false);
                return;
            }
            this.cSr.setVisibility(8);
            this.ciK.showForumNameView(true);
            if (this.ciL.setData(this.cTi.threadData)) {
                this.cTn.setVisibility(8);
            } else {
                this.cTn.setVisibility(0);
            }
        }
    }
}

package com.baidu.tieba.ala.livecard.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<by> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout agP;
    private String aiw;
    private final View.OnClickListener akI;
    private HeadImageView gui;
    private LinearLayout gyL;
    private RelativeLayout hbJ;
    private View hbM;
    public AlaVideoContainer hbN;
    private LinearLayout hct;
    private TextView hcu;
    private TextView hcv;
    private RelativeLayout hcw;
    private ThreadSourceShareAndPraiseLayout hcx;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.crI() != null) {
                    c.this.crI().a(view, c.this.agJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.eNx = tbPageContext;
        View view = getView();
        this.hbJ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hbJ.setOnClickListener(this);
        this.hct = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hct.setOnClickListener(this);
        this.hcw = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gyL = (LinearLayout) this.hcw.findViewById(R.id.challenge_root);
        this.agP = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agP.setShowFlag(6141);
        this.gui = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gui.setIsRound(true);
        this.gui.setDrawBorder(false);
        this.gui.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gui.setAutoChangeStyle(false);
        this.hcv = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hcu = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hbN = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hbN.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hbL);
        this.hbL.setSelectVisible(false);
        this.hbL.setIsBarViewVisible(false);
        this.hbL.setCommentNumEnable(true);
        this.hbL.setLiveShareEnable(false);
        this.hbL.setFrom(2);
        this.hbL.getCommentContainer().setOnClickListener(this);
        this.hbL.hideDisagree();
        this.hbL.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEP = 2;
        this.hbL.setAgreeStatisticData(dVar);
        this.igV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.igV);
        this.igV.setFrom(2);
        this.igV.setShareReportFrom(1);
        this.hcx = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hcx.feb.setOnClickListener(this);
        this.hcx.feb.getCommentContainer().setOnClickListener(this);
        this.hcx.setFrom(2);
        this.hcx.setShareReportFrom(1);
        this.hcx.setSourceFromForPb(3);
        this.hcx.setStType("frs_page");
        this.hcx.setHideBarName(true);
        this.hbM = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hbN.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.hbJ).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).aP(R.color.CAM_X0205, R.color.CAM_X0206);
            ap.setBackgroundColor(this.hcw, R.color.CAM_X0204);
            if (this.hbN != null) {
                this.hbN.onChangeSkinType(i);
            }
            this.agP.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hbL.onChangeSkinType();
            this.mSkinType = i;
            if (this.gui != null) {
                this.gui.setPlaceHolder(1);
            }
            if (this.hcx != null && this.hcx.getVisibility() == 0) {
                this.hcx.onChangeSkinType();
            }
        }
        if (this.agJ != 0 && n.Jr(((by) this.agJ).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.hcu, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.hcv, (int) R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.hcu, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.hcv, (int) R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        this.agJ = byVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    private void refreshView() {
        if (this.agJ == 0 || ((by) this.agJ).boP() == null) {
            this.hbJ.setVisibility(8);
            return;
        }
        this.hbJ.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hbJ.getLayoutParams();
        if (com.baidu.tbadk.a.d.bkA()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
        }
        this.agP.setData((by) this.agJ);
        this.agP.setUserAfterClickListener(this.akI);
        this.hbN.getController().a((by) this.agJ, this.mForumName, "", false);
        this.hbN.getController().startPlayAnimation();
        if (((by) this.agJ).bpj() != null && ((by) this.agJ).bpj().share_info != null && !StringUtils.isNull(((by) this.agJ).bpj().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((by) this.agJ).bpj().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((by) this.agJ).bpj() != null && ((by) this.agJ).bpj().user_info != null) {
            String str = ((by) this.agJ).bpj().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.hcv.setText(str + ":");
            if (TextUtils.isEmpty(((by) this.agJ).bpj().user_info.portrait)) {
                this.gui.setPlaceHolder(1);
            } else {
                this.gui.startLoad(((by) this.agJ).bpj().user_info.portrait, 10, false, false);
            }
        }
        String title = ((by) this.agJ).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hcu.setText(title);
            this.hcu.setVisibility(0);
        } else {
            this.hcu.setVisibility(8);
        }
        wk(ul(1));
        if (((by) this.agJ).bpj().mChallengeInfoData != null && ((by) this.agJ).bpj().mChallengeInfoData.challenge_id > 0) {
            this.gyL.setVisibility(0);
        } else {
            this.gyL.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) ? 0 : 8);
        aO(this.hbJ);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ud();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbL != null) {
            if (this.agP != null) {
                this.agP.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void ud() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcw.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hcw.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBd().cAX() && !com.baidu.tieba.frs.a.cAW().cAX()) {
            if (view == this.hbJ || view == this.hbL.getCommentContainer() || this.hct == view || view == this.hcx.feb.getCommentContainer() || view == this.igV.getCommentContainer()) {
                if (this.agJ != 0) {
                    n.Jq(((by) this.agJ).getId());
                }
                if (crI() != null) {
                    crI().a(this.hbJ, this.agJ);
                }
                TiebaStatic.log(new ar("c12323"));
                int i = 5;
                if (((by) this.agJ).bpj().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hbL.getCommentContainer() || view == this.hcx.feb.getCommentContainer()) {
                    ar arVar = new ar("c12942");
                    arVar.al("obj_locate", 2);
                    arVar.dY("tid", ((by) this.agJ).getTid());
                    arVar.al("obj_type", i);
                    arVar.dY("nid", ((by) this.agJ).getNid());
                    com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                    if (bM != null) {
                        arVar.dY("obj_cur_page", bM.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                        arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                    }
                    TiebaStatic.log(arVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (crI() != null) {
                    crI().a(view, this.agJ);
                }
                TiebaStatic.log(new ar("c12323"));
                if (((by) this.agJ).bpj().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agJ != 0 && ((by) this.agJ).bpj() != null && ((by) this.agJ).bpj().share_info != null) {
            if (((by) this.agJ).bpj().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((by) this.agJ).bpj().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((by) this.agJ).bqa() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((by) this.agJ).bqg());
            createNormalCfg.setSmartFrsPosition(((by) this.agJ).bqm());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agJ != 0 && ((by) this.agJ).bpj() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((by) this.agJ).bpj());
            if (((by) this.agJ).bpj().user_info != null) {
                alaLiveInfoCoreData.userName = ((by) this.agJ).bpj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void wk(int i) {
        if (this.agJ != 0) {
            if (i == 1) {
                this.hbL.setVisibility(8);
                this.hcx.setData((by) this.agJ);
                return;
            }
            this.hbL.setData((by) this.agJ);
            this.hcx.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLT().ax(this.aiw, i);
    }

    public ThreadCommentAndPraiseInfoLayout bZb() {
        return this.hbL;
    }

    public ThreadCommentAndPraiseInfoLayout bZc() {
        if (this.hcx != null) {
            return this.hcx.feb;
        }
        return null;
    }
}

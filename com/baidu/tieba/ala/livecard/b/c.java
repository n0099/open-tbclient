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
    private HeadImageView guk;
    private LinearLayout gyN;
    private RelativeLayout hbL;
    private View hbO;
    public AlaVideoContainer hbP;
    private LinearLayout hcv;
    private TextView hcw;
    private TextView hcx;
    private RelativeLayout hcy;
    private ThreadSourceShareAndPraiseLayout hcz;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.crJ() != null) {
                    c.this.crJ().a(view, c.this.agJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.eNx = tbPageContext;
        View view = getView();
        this.hbL = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hbL.setOnClickListener(this);
        this.hcv = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hcv.setOnClickListener(this);
        this.hcy = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gyN = (LinearLayout) this.hcy.findViewById(R.id.challenge_root);
        this.agP = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agP.setShowFlag(6141);
        this.guk = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.guk.setIsRound(true);
        this.guk.setDrawBorder(false);
        this.guk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guk.setAutoChangeStyle(false);
        this.hcx = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hcw = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hbP = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hbP.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hbN);
        this.hbN.setSelectVisible(false);
        this.hbN.setIsBarViewVisible(false);
        this.hbN.setCommentNumEnable(true);
        this.hbN.setLiveShareEnable(false);
        this.hbN.setFrom(2);
        this.hbN.getCommentContainer().setOnClickListener(this);
        this.hbN.hideDisagree();
        this.hbN.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEP = 2;
        this.hbN.setAgreeStatisticData(dVar);
        this.igX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.igX);
        this.igX.setFrom(2);
        this.igX.setShareReportFrom(1);
        this.hcz = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hcz.feb.setOnClickListener(this);
        this.hcz.feb.getCommentContainer().setOnClickListener(this);
        this.hcz.setFrom(2);
        this.hcz.setShareReportFrom(1);
        this.hcz.setSourceFromForPb(3);
        this.hcz.setStType("frs_page");
        this.hcz.setHideBarName(true);
        this.hbO = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hbP.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.hbL).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).aP(R.color.CAM_X0205, R.color.CAM_X0206);
            ap.setBackgroundColor(this.hcy, R.color.CAM_X0204);
            if (this.hbP != null) {
                this.hbP.onChangeSkinType(i);
            }
            this.agP.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hbN.onChangeSkinType();
            this.mSkinType = i;
            if (this.guk != null) {
                this.guk.setPlaceHolder(1);
            }
            if (this.hcz != null && this.hcz.getVisibility() == 0) {
                this.hcz.onChangeSkinType();
            }
        }
        if (this.agJ != 0 && n.Jr(((by) this.agJ).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.hcw, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.hcx, (int) R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.hcw, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.hcx, (int) R.color.CAM_X0105);
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
            this.hbL.setVisibility(8);
            return;
        }
        this.hbL.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hbL.getLayoutParams();
        if (com.baidu.tbadk.a.d.bkA()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
        }
        this.agP.setData((by) this.agJ);
        this.agP.setUserAfterClickListener(this.akI);
        this.hbP.getController().a((by) this.agJ, this.mForumName, "", false);
        this.hbP.getController().startPlayAnimation();
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
            this.hcx.setText(str + ":");
            if (TextUtils.isEmpty(((by) this.agJ).bpj().user_info.portrait)) {
                this.guk.setPlaceHolder(1);
            } else {
                this.guk.startLoad(((by) this.agJ).bpj().user_info.portrait, 10, false, false);
            }
        }
        String title = ((by) this.agJ).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hcw.setText(title);
            this.hcw.setVisibility(0);
        } else {
            this.hcw.setVisibility(8);
        }
        wk(ul(1));
        if (((by) this.agJ).bpj().mChallengeInfoData != null && ((by) this.agJ).bpj().mChallengeInfoData.challenge_id > 0) {
            this.gyN.setVisibility(0);
        } else {
            this.gyN.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) ? 0 : 8);
        aO(this.hbL);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ud();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbN != null) {
            if (this.agP != null) {
                this.agP.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void ud() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcy.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hcy.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBe().cAY() && !com.baidu.tieba.frs.a.cAX().cAY()) {
            if (view == this.hbL || view == this.hbN.getCommentContainer() || this.hcv == view || view == this.hcz.feb.getCommentContainer() || view == this.igX.getCommentContainer()) {
                if (this.agJ != 0) {
                    n.Jq(((by) this.agJ).getId());
                }
                if (crJ() != null) {
                    crJ().a(this.hbL, this.agJ);
                }
                TiebaStatic.log(new ar("c12323"));
                int i = 5;
                if (((by) this.agJ).bpj().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hbN.getCommentContainer() || view == this.hcz.feb.getCommentContainer()) {
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
                if (crJ() != null) {
                    crJ().a(view, this.agJ);
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
                this.hbN.setVisibility(8);
                this.hcz.setData((by) this.agJ);
                return;
            }
            this.hbN.setData((by) this.agJ);
            this.hcz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLU().ax(this.aiw, i);
    }

    public ThreadCommentAndPraiseInfoLayout bZc() {
        return this.hbN;
    }

    public ThreadCommentAndPraiseInfoLayout bZd() {
        if (this.hcz != null) {
            return this.hcz.feb;
        }
        return null;
    }
}

package com.baidu.tieba.ala.livecard.a;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.a<bz> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout aho;
    private String aji;
    private final View.OnClickListener alk;
    private HeadImageView gFj;
    private LinearLayout gJQ;
    private View hnA;
    public AlaVideoContainer hnB;
    private RelativeLayout hnx;
    private LinearLayout hoh;
    private TextView hoi;
    private TextView hoj;
    private RelativeLayout hok;
    private ThreadSourceShareAndPraiseLayout hol;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cuD() != null) {
                    c.this.cuD().a(view, c.this.ahi);
                }
            }
        };
        setTag(bdUniqueId);
        this.eXu = tbPageContext;
        View view = getView();
        this.hnx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hnx.setOnClickListener(this);
        this.hoh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hoh.setOnClickListener(this);
        this.hok = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gJQ = (LinearLayout) this.hok.findViewById(R.id.challenge_root);
        this.aho = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.aho.setShowFlag(6141);
        this.gFj = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gFj.setIsRound(true);
        this.gFj.setDrawBorder(false);
        this.gFj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFj.setAutoChangeStyle(false);
        this.hoj = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hoi = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hnB = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hnB.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hnz);
        this.hnz.setSelectVisible(false);
        this.hnz.setIsBarViewVisible(false);
        this.hnz.setCommentNumEnable(true);
        this.hnz.setLiveShareEnable(false);
        this.hnz.setFrom(2);
        this.hnz.getCommentContainer().setOnClickListener(this);
        this.hnz.hideDisagree();
        this.hnz.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = 2;
        dVar.eOF = 2;
        this.hnz.setAgreeStatisticData(dVar);
        this.its = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.its);
        this.its.setFrom(2);
        this.its.setShareReportFrom(1);
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hol.fnK.setOnClickListener(this);
        this.hol.fnK.getCommentContainer().setOnClickListener(this);
        this.hol.setFrom(2);
        this.hol.setShareReportFrom(1);
        this.hol.setSourceFromForPb(3);
        this.hol.setStType("frs_page");
        this.hol.setHideBarName(true);
        this.hnA = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hnB.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hnx).pK(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            ao.setBackgroundColor(this.hok, R.color.CAM_X0204);
            if (this.hnB != null) {
                this.hnB.onChangeSkinType(i);
            }
            this.aho.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hnz.onChangeSkinType();
            this.mSkinType = i;
            if (this.gFj != null) {
                this.gFj.setPlaceHolder(1);
            }
            if (this.hol != null && this.hol.getVisibility() == 0) {
                this.hol.onChangeSkinType();
            }
        }
        if (this.ahi != 0 && m.Jo(((bz) this.ahi).getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
            ao.setViewTextColor(this.hoi, R.color.CAM_X0109);
            ao.setViewTextColor(this.hoj, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.hoi, R.color.CAM_X0106);
            ao.setViewTextColor(this.hoj, R.color.CAM_X0105);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.ahi = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
    }

    private void refreshView() {
        if (this.ahi == 0 || ((bz) this.ahi).brr() == null) {
            this.hnx.setVisibility(8);
            return;
        }
        this.hnx.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hnx.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.aho.setData((bz) this.ahi);
        this.aho.setUserAfterClickListener(this.alk);
        this.hnB.getController().a((bz) this.ahi, this.mForumName, "", false);
        this.hnB.getController().startPlayAnimation();
        if (((bz) this.ahi).brK() != null && ((bz) this.ahi).brK().share_info != null && !StringUtils.isNull(((bz) this.ahi).brK().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((bz) this.ahi).brK().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bz) this.ahi).brK() != null && ((bz) this.ahi).brK().user_info != null) {
            String str = ((bz) this.ahi).brK().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.hoj.setText(str + ":");
            if (TextUtils.isEmpty(((bz) this.ahi).brK().user_info.portrait)) {
                this.gFj.setPlaceHolder(1);
            } else {
                this.gFj.startLoad(((bz) this.ahi).brK().user_info.portrait, 10, false, false);
            }
        }
        String title = ((bz) this.ahi).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hoi.setText(title);
            this.hoi.setVisibility(0);
        } else {
            this.hoi.setVisibility(8);
        }
        wv(ux(1));
        if (((bz) this.ahi).brK().mChallengeInfoData != null && ((bz) this.ahi).brK().mChallengeInfoData.challenge_id > 0) {
            this.gJQ.setVisibility(0);
        } else {
            this.gJQ.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) ? 0 : 8);
        ba(this.hnx);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tC();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null) {
            if (this.aho != null) {
                this.aho.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void tC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hok.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hok.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cDY().cDS() && !com.baidu.tieba.frs.a.cDR().cDS()) {
            if (view == this.hnx || view == this.hnz.getCommentContainer() || this.hoh == view || view == this.hol.fnK.getCommentContainer() || view == this.its.getCommentContainer()) {
                if (this.ahi != 0) {
                    m.Jn(((bz) this.ahi).getId());
                }
                if (cuD() != null) {
                    cuD().a(this.hnx, this.ahi);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (((bz) this.ahi).brK().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hnz.getCommentContainer() || view == this.hol.fnK.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.an("obj_locate", 2);
                    aqVar.dX("tid", ((bz) this.ahi).getTid());
                    aqVar.an("obj_type", i);
                    aqVar.dX(IntentConfig.NID, ((bz) this.ahi).bpP());
                    com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                    if (bV != null) {
                        aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                        aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
                    }
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cuD() != null) {
                    cuD().a(view, this.ahi);
                }
                TiebaStatic.log(new aq("c12323"));
                if (((bz) this.ahi).brK().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.ahi != 0 && ((bz) this.ahi).brK() != null && ((bz) this.ahi).brK().share_info != null) {
            if (((bz) this.ahi).brK().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((bz) this.ahi).brK().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((bz) this.ahi).bsC() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((bz) this.ahi).bsJ());
            createNormalCfg.setSmartFrsPosition(((bz) this.ahi).bsP());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ahi != 0 && ((bz) this.ahi).brK() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((bz) this.ahi).brK());
            if (((bz) this.ahi).brK().user_info != null) {
                alaLiveInfoCoreData.userName = ((bz) this.ahi).brK().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void wv(int i) {
        if (this.ahi != 0) {
            if (i == 1) {
                this.hnz.setVisibility(8);
                this.hol.setData((bz) this.ahi);
                return;
            }
            this.hnz.setData((bz) this.ahi);
            this.hol.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOn().az(this.aji, i);
    }

    public ThreadCommentAndPraiseInfoLayout cbK() {
        return this.hnz;
    }

    public ThreadCommentAndPraiseInfoLayout cbL() {
        if (this.hol != null) {
            return this.hol.fnK;
        }
        return null;
    }
}

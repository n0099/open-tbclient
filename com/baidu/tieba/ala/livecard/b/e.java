package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private bh FT;
    private CardUserInfoLayout Fv;
    private String GC;
    private final View.OnClickListener HO;
    private View bhm;
    private TbPageContext<?> cfl;
    private RelativeLayout dTp;
    private View dTs;
    public AlaVideoContainer dTt;
    public NewThreadCommentAndPraiseInfoLayout dUe;
    protected ThreadSourceShareAndPraiseLayout dUf;
    private com.baidu.tieba.ala.livecard.vc.a dUm;
    public LinearLayout dUq;
    public ThreadSkinView dUr;
    private TbImageView dUs;
    private boolean dUt;
    private boolean dUu;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.dUt = false;
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aZX() != null) {
                    e.this.aZX().a(view, e.this.FT);
                }
            }
        };
        setTag(bdUniqueId);
        this.cfl = tbPageContext;
        View view = getView();
        this.dTp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.dUq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dTp.setOnClickListener(this);
        this.dUs = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.dUs.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.dUs.setDefaultBgResource(R.color.transparent);
        this.Fv = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Fv.setUserAfterClickListener(this.HO);
        this.Fv.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dUe = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dUe.setOnClickListener(this);
        this.dUe.setReplyTimeVisible(false);
        this.dUe.setSelectVisible(false);
        this.dUe.setNeedAddReplyIcon(true);
        this.dUe.setIsBarViewVisible(false);
        this.dUe.setCommentNumEnable(false);
        this.dUe.setLiveShareEnable(false);
        this.dUe.setShowPraiseNum(true);
        this.dUe.setNeedAddPraiseIcon(true);
        this.dUe.setShareVisible(true);
        this.dUe.setFrom(2);
        this.dUe.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXQ = 2;
        dVar.bXV = 2;
        this.dUe.setAgreeStatisticData(dVar);
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.crO.getCommentContainer().setOnClickListener(this);
        this.dUf.setFrom(2);
        this.dUf.setShareReportFrom(1);
        this.dUf.setSourceFromForPb(3);
        this.dUf.setStType("frs_page");
        this.dUf.setHideBarName(true);
        this.dTs = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dUr = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.dTt = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.dTt.setOnVideoClickListener(this);
        this.dTt.setLigvingLogLayoutVisible(8);
        this.bhm = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.dUm = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.Fv.getSuffixContainer());
        this.dUm.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            if (this.dTt != null) {
                this.dTt.onChangeSkinType(i);
            }
            this.Fv.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dUe.onChangeSkinType();
            this.mSkinType = i;
            if (this.dUf != null && this.dUf.getVisibility() == 0) {
                this.dUf.onChangeSkinType();
            }
        }
        if (this.FT != null && n.uA(this.FT.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.dUm.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.FT = bhVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.biW().biX()) {
            if (view == this.dTp || view == this.dUe.getCommentContainer() || view == this.dUq || view == this.dUf.crO.getCommentContainer()) {
                if (this.FT != null) {
                    n.uz(this.FT.getId());
                }
                if (aZX() != null) {
                    aZX().a(this.dTp, this.FT);
                }
                c(getContext(), this.FT);
                if (this.FT != null) {
                    if (view == this.dUe.getCommentContainer() || view == this.dUf.crO.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.O("obj_locate", 2);
                        anVar.O("obj_type", 5);
                        anVar.bS("tid", this.FT.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (aZX() != null) {
                    aZX().a(view, this.FT);
                }
                c(getContext(), this.FT);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.FT == null || this.FT.aiG() == null || this.dTt == null || this.dTt.getController() == null) {
            this.dTp.setVisibility(8);
            return;
        }
        this.dTt.getController().a(this.FT, this.mForumName, "", false);
        this.dTt.getController().startPlayAnimation();
        this.dTp.setVisibility(0);
        if (this.FT.aiZ() != null && this.FT.aiZ().user_info != null && this.FT.aiZ().user_info.is_official == 2) {
            this.dUu = true;
            SparseArray<String> sparseArray2 = this.FT.aiZ().dislikeInfo;
            this.dUs.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.dUs.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.dUs.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.FT.aiZ().liveStagePicUrl)) {
                this.dUs.startLoad(this.FT.aiZ().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Fv.getLayoutParams();
            marginLayoutParams.topMargin = this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.Fv.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.dUu = false;
            this.dUs.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.Fv.getLayoutParams();
            marginLayoutParams2.topMargin = this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.Fv.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.dUu && sparseArray != null && sparseArray.size() > 0) {
            this.dUm.c(this.FT, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.dUm.aMN() != null) {
            this.dUm.aMN().setVisibility(8);
        }
        this.FT.q(false, true);
        this.Fv.setData(this.FT);
        SpannableStringBuilder ajm = this.FT.ajm();
        if (ajm != null && !StringUtils.isNull(ajm.toString())) {
            this.mTextTitle.setText(this.FT.ajm());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        mZ(ly(1));
        P(this.FT);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.biW().biX() ? 0 : 8);
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dUe != null && this.Fv != null) {
            this.Fv.setPageUniqueId(bdUniqueId);
        }
    }

    public void hj(boolean z) {
        this.dUt = z;
    }

    private void P(bh bhVar) {
        if (bhVar != null) {
            TiebaStatic.log(new an("c12125").bS("tid", bhVar.getId()).O("obj_locate", this.dUt ? 2 : 1).p("obj_id", bhVar.aiZ().live_id).O("obj_type", 2));
            if (bhVar.aiZ() != null && bhVar.aiZ().user_info != null && bhVar.aiZ().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").bS("tid", bhVar.getId()));
            }
        }
    }

    private void d(bh bhVar, String str) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", this.dUt ? 2 : 1).p("obj_id", bhVar.aiZ().live_id).O("obj_type", 2));
        if (bhVar.aiZ() != null && bhVar.aiZ().user_info != null && bhVar.aiZ().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").bS("tid", bhVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bhVar.aiL().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").bS("uid", currentAccount).p("fid", bhVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").bS("uid", currentAccount).p("fid", bhVar.getFid()));
            }
        }
    }

    public void c(Context context, bh bhVar) {
        if (context != null && bhVar != null && bhVar.aiZ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String ait = bhVar.ait() != null ? bhVar.ait() : this.dUu ? "frs_live_stage_live" : "frs_play";
            d(bhVar, ait);
            AlaInfoData aiZ = bhVar.aiZ();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bhVar.aiG() != null) {
                z = TextUtils.equals(bhVar.aiG().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aiZ);
            if (aiZ.user_info != null) {
                alaLiveInfoCoreData.userName = aiZ.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, ait, "", z, this.mForumName)));
        }
    }

    public void mZ(int i) {
        if (this.FT != null) {
            if (i == 1) {
                this.dUe.setVisibility(8);
                this.dUf.setData(this.FT);
                return;
            }
            this.dTs.setVisibility(this.dUe.setData(this.FT) ? 8 : 0);
            this.dUf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }
}

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
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.l;
import com.baidu.tieba.card.x;
import com.baidu.tieba.pb.ThreadSkinView;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private bj KJ;
    private CardUserInfoLayout Kj;
    private String LC;
    private final View.OnClickListener Nx;
    private TbPageContext<?> cVv;
    private RelativeLayout eNV;
    public ThreadCommentAndPraiseInfoLayout eNX;
    private View eNY;
    public AlaVideoContainer eNZ;
    protected ThreadSourceShareAndPraiseLayout eOJ;
    private com.baidu.tieba.ala.livecard.vc.a eOQ;
    public ThreadSkinView eOU;
    private TbImageView eOV;
    private boolean eOW;
    private boolean eOX;
    public LinearLayout ehj;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eOW = false;
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.buM() != null) {
                    e.this.buM().a(view, e.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.cVv = tbPageContext;
        View view = getView();
        this.eNV = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ehj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNV.setOnClickListener(this);
        this.eOV = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.eOV.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.eOV.setDefaultBgResource(R.color.transparent);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setUserAfterClickListener(this.Nx);
        this.Kj.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setSelectVisible(false);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setCommentNumEnable(false);
        this.eNX.setLiveShareEnable(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setFrom(2);
        this.eNX.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 2;
        dVar.cNV = 2;
        this.eNX.setAgreeStatisticData(dVar);
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.djh.getCommentContainer().setOnClickListener(this);
        this.eOJ.setFrom(2);
        this.eOJ.setShareReportFrom(1);
        this.eOJ.setSourceFromForPb(3);
        this.eOJ.setStType("frs_page");
        this.eOJ.setHideBarName(true);
        this.eNY = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eOU = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.eNZ = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNZ.setOnVideoClickListener(this);
        this.eNZ.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eOQ = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.Kj.getSuffixContainer());
        this.eOQ.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNV, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.eNZ != null) {
                this.eNZ.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNX.onChangeSkinType();
            this.mSkinType = i;
            if (this.eOJ != null && this.eOJ.getVisibility() == 0) {
                this.eOJ.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zV(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.eOQ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.KJ = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bDd().bDe()) {
            if (view == this.eNV || view == this.eNX.getCommentContainer() || view == this.ehj || view == this.eOJ.djh.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zU(this.KJ.getId());
                }
                if (buM() != null) {
                    buM().a(this.eNV, this.KJ);
                }
                b(getContext(), this.KJ);
                if (this.KJ != null) {
                    if (view == this.eNX.getCommentContainer() || view == this.eOJ.djh.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 2);
                        anVar.X("obj_type", 5);
                        anVar.cx("tid", this.KJ.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (buM() != null) {
                    buM().a(view, this.KJ);
                }
                b(getContext(), this.KJ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.KJ == null || this.KJ.aCr() == null || this.eNZ == null || this.eNZ.getController() == null) {
            this.eNV.setVisibility(8);
            return;
        }
        this.eNZ.getController().a(this.KJ, this.mForumName, "", false);
        this.eNZ.getController().startPlayAnimation();
        this.eNV.setVisibility(0);
        if (this.KJ.aCK() != null && this.KJ.aCK().user_info != null && this.KJ.aCK().user_info.is_official == 2) {
            this.eOX = true;
            SparseArray<String> sparseArray2 = this.KJ.aCK().dislikeInfo;
            this.eOV.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.eOV.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.eOV.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.KJ.aCK().liveStagePicUrl)) {
                this.eOV.startLoad(this.KJ.aCK().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams.topMargin = this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.Kj.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.eOX = false;
            this.eOV.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams2.topMargin = this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.Kj.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.eOX && sparseArray != null && sparseArray.size() > 0) {
            this.eOQ.e(this.KJ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.eOQ.bhd() != null) {
            this.eOQ.bhd().setVisibility(8);
        }
        this.KJ.t(false, true);
        this.Kj.setData(this.KJ);
        SpannableStringBuilder aCY = this.KJ.aCY();
        if (aCY != null && !StringUtils.isNull(aCY.toString())) {
            this.mTextTitle.setText(this.KJ.aCY());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pD(oe(1));
        W(this.KJ);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bDd().bDe() ? 0 : 8);
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNX != null && this.Kj != null) {
            this.Kj.setPageUniqueId(bdUniqueId);
        }
    }

    public void iM(boolean z) {
        this.eOW = z;
    }

    private void W(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cx("tid", bjVar.getId()).X("obj_locate", this.eOW ? 2 : 1).s("obj_id", bjVar.aCK().live_id).X("obj_type", 2));
            if (bjVar.aCK() != null && bjVar.aCK().user_info != null && bjVar.aCK().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cx("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cx("tid", bjVar.getId()).X("obj_locate", this.eOW ? 2 : 1).s("obj_id", bjVar.aCK().live_id).X("obj_type", 2));
        if (bjVar.aCK() != null && bjVar.aCK().user_info != null && bjVar.aCK().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cx("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aCw().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cx("uid", currentAccount).s("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cx("uid", currentAccount).s("fid", bjVar.getFid()));
            }
        }
    }

    public void b(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aCK() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String aCd = bjVar.aCd() != null ? bjVar.aCd() : this.eOX ? "frs_live_stage_live" : "frs_play";
            f(bjVar, aCd);
            AlaInfoData aCK = bjVar.aCK();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.aCr() != null) {
                z = TextUtils.equals(bjVar.aCr().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aCK);
            if (aCK.user_info != null) {
                alaLiveInfoCoreData.userName = aCK.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, aCd, "", z, this.mForumName)));
        }
    }

    public void pD(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setData(this.KJ);
                return;
            }
            this.eNY.setVisibility(this.eNX.setData(this.KJ) ? 8 : 0);
            this.eOJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }
}

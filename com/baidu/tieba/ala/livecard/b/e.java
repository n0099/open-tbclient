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
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private CardUserInfoLayout JN;
    private bj Kn;
    private String Lg;
    private final View.OnClickListener MX;
    private TbPageContext<?> cRe;
    private RelativeLayout eJp;
    public ThreadCommentAndPraiseInfoLayout eJr;
    private View eJs;
    public AlaVideoContainer eJt;
    protected ThreadSourceShareAndPraiseLayout eKe;
    private com.baidu.tieba.ala.livecard.vc.a eKl;
    public ThreadSkinView eKp;
    private TbImageView eKq;
    private boolean eKr;
    private boolean eKs;
    public LinearLayout ecC;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eKr = false;
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bta() != null) {
                    e.this.bta().a(view, e.this.Kn);
                }
            }
        };
        setTag(bdUniqueId);
        this.cRe = tbPageContext;
        View view = getView();
        this.eJp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ecC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eJp.setOnClickListener(this);
        this.eKq = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.eKq.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.eKq.setDefaultBgResource(R.color.transparent);
        this.JN = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.JN.setUserAfterClickListener(this.MX);
        this.JN.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setSelectVisible(false);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setCommentNumEnable(false);
        this.eJr.setLiveShareEnable(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setFrom(2);
        this.eJr.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 2;
        dVar.cJD = 2;
        this.eJr.setAgreeStatisticData(dVar);
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.deA.getCommentContainer().setOnClickListener(this);
        this.eKe.setFrom(2);
        this.eKe.setShareReportFrom(1);
        this.eKe.setSourceFromForPb(3);
        this.eKe.setStType("frs_page");
        this.eKe.setHideBarName(true);
        this.eJs = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eKp = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.eJt = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eJt.setOnVideoClickListener(this);
        this.eJt.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eKl = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.JN.getSuffixContainer());
        this.eKl.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.eJt != null) {
                this.eJt.onChangeSkinType(i);
            }
            this.JN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eJr.onChangeSkinType();
            this.mSkinType = i;
            if (this.eKe != null && this.eKe.getVisibility() == 0) {
                this.eKe.onChangeSkinType();
            }
        }
        if (this.Kn != null && l.zD(this.Kn.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.eKl.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.Kn = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bBr().bBs()) {
            if (view == this.eJp || view == this.eJr.getCommentContainer() || view == this.ecC || view == this.eKe.deA.getCommentContainer()) {
                if (this.Kn != null) {
                    l.zC(this.Kn.getId());
                }
                if (bta() != null) {
                    bta().a(this.eJp, this.Kn);
                }
                c(getContext(), this.Kn);
                if (this.Kn != null) {
                    if (view == this.eJr.getCommentContainer() || view == this.eKe.deA.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.Z("obj_locate", 2);
                        anVar.Z("obj_type", 5);
                        anVar.cp("tid", this.Kn.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bta() != null) {
                    bta().a(view, this.Kn);
                }
                c(getContext(), this.Kn);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.Kn == null || this.Kn.azX() == null || this.eJt == null || this.eJt.getController() == null) {
            this.eJp.setVisibility(8);
            return;
        }
        this.eJt.getController().a(this.Kn, this.mForumName, "", false);
        this.eJt.getController().startPlayAnimation();
        this.eJp.setVisibility(0);
        if (this.Kn.aAq() != null && this.Kn.aAq().user_info != null && this.Kn.aAq().user_info.is_official == 2) {
            this.eKs = true;
            SparseArray<String> sparseArray2 = this.Kn.aAq().dislikeInfo;
            this.eKq.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.eKq.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.eKq.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.Kn.aAq().liveStagePicUrl)) {
                this.eKq.startLoad(this.Kn.aAq().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.JN.getLayoutParams();
            marginLayoutParams.topMargin = this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.JN.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.eKs = false;
            this.eKq.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.JN.getLayoutParams();
            marginLayoutParams2.topMargin = this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.JN.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.eKs && sparseArray != null && sparseArray.size() > 0) {
            this.eKl.e(this.Kn, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.eKl.beL() != null) {
            this.eKl.beL().setVisibility(8);
        }
        this.Kn.p(false, true);
        this.JN.setData(this.Kn);
        SpannableStringBuilder aAE = this.Kn.aAE();
        if (aAE != null && !StringUtils.isNull(aAE.toString())) {
            this.mTextTitle.setText(this.Kn.aAE());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pq(nL(1));
        U(this.Kn);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bBr().bBs() ? 0 : 8);
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eJr != null && this.JN != null) {
            this.JN.setPageUniqueId(bdUniqueId);
        }
    }

    public void iD(boolean z) {
        this.eKr = z;
    }

    private void U(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cp("tid", bjVar.getId()).Z("obj_locate", this.eKr ? 2 : 1).s("obj_id", bjVar.aAq().live_id).Z("obj_type", 2));
            if (bjVar.aAq() != null && bjVar.aAq().user_info != null && bjVar.aAq().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cp("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", this.eKr ? 2 : 1).s("obj_id", bjVar.aAq().live_id).Z("obj_type", 2));
        if (bjVar.aAq() != null && bjVar.aAq().user_info != null && bjVar.aAq().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cp("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aAc().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cp("uid", currentAccount).s("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cp("uid", currentAccount).s("fid", bjVar.getFid()));
            }
        }
    }

    public void c(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aAq() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String azJ = bjVar.azJ() != null ? bjVar.azJ() : this.eKs ? "frs_live_stage_live" : "frs_play";
            f(bjVar, azJ);
            AlaInfoData aAq = bjVar.aAq();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.azX() != null) {
                z = TextUtils.equals(bjVar.azX().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aAq);
            if (aAq.user_info != null) {
                alaLiveInfoCoreData.userName = aAq.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, azJ, "", z, this.mForumName)));
        }
    }

    public void pq(int i) {
        if (this.Kn != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setData(this.Kn);
                return;
            }
            this.eJs.setVisibility(this.eJr.setData(this.Kn) ? 8 : 0);
            this.eKe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }
}

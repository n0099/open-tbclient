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
    private final View.OnClickListener Nw;
    private TbPageContext<?> cVh;
    protected ThreadSourceShareAndPraiseLayout eNY;
    private RelativeLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNm;
    private View eNn;
    public AlaVideoContainer eNo;
    private com.baidu.tieba.ala.livecard.vc.a eOf;
    public ThreadSkinView eOj;
    private TbImageView eOk;
    private boolean eOl;
    private boolean eOm;
    public LinearLayout egG;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eOl = false;
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.buG() != null) {
                    e.this.buG().a(view, e.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.cVh = tbPageContext;
        View view = getView();
        this.eNk = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.egG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNk.setOnClickListener(this);
        this.eOk = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.eOk.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.eOk.setDefaultBgResource(R.color.transparent);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setUserAfterClickListener(this.Nw);
        this.Kj.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setSelectVisible(false);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setIsBarViewVisible(false);
        this.eNm.setCommentNumEnable(false);
        this.eNm.setLiveShareEnable(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setShareVisible(true);
        this.eNm.setFrom(2);
        this.eNm.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 2;
        dVar.cNH = 2;
        this.eNm.setAgreeStatisticData(dVar);
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.diH.getCommentContainer().setOnClickListener(this);
        this.eNY.setFrom(2);
        this.eNY.setShareReportFrom(1);
        this.eNY.setSourceFromForPb(3);
        this.eNY.setStType("frs_page");
        this.eNY.setHideBarName(true);
        this.eNn = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eOj = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.eNo = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNo.setOnVideoClickListener(this);
        this.eNo.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eOf = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.Kj.getSuffixContainer());
        this.eOf.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNk, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.eNo != null) {
                this.eNo.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNm.onChangeSkinType();
            this.mSkinType = i;
            if (this.eNY != null && this.eNY.getVisibility() == 0) {
                this.eNY.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.eOf.onChangeSkinType();
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
    public void pz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bCV().bCW()) {
            if (view == this.eNk || view == this.eNm.getCommentContainer() || view == this.egG || view == this.eNY.diH.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zS(this.KJ.getId());
                }
                if (buG() != null) {
                    buG().a(this.eNk, this.KJ);
                }
                b(getContext(), this.KJ);
                if (this.KJ != null) {
                    if (view == this.eNm.getCommentContainer() || view == this.eNY.diH.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 2);
                        anVar.X("obj_type", 5);
                        anVar.cy("tid", this.KJ.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (buG() != null) {
                    buG().a(view, this.KJ);
                }
                b(getContext(), this.KJ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.KJ == null || this.KJ.aCo() == null || this.eNo == null || this.eNo.getController() == null) {
            this.eNk.setVisibility(8);
            return;
        }
        this.eNo.getController().a(this.KJ, this.mForumName, "", false);
        this.eNo.getController().startPlayAnimation();
        this.eNk.setVisibility(0);
        if (this.KJ.aCH() != null && this.KJ.aCH().user_info != null && this.KJ.aCH().user_info.is_official == 2) {
            this.eOm = true;
            SparseArray<String> sparseArray2 = this.KJ.aCH().dislikeInfo;
            this.eOk.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.eOk.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.eOk.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.KJ.aCH().liveStagePicUrl)) {
                this.eOk.startLoad(this.KJ.aCH().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams.topMargin = this.cVh.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.Kj.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.eOm = false;
            this.eOk.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams2.topMargin = this.cVh.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.Kj.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.eOm && sparseArray != null && sparseArray.size() > 0) {
            this.eOf.e(this.KJ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.eOf.bgX() != null) {
            this.eOf.bgX().setVisibility(8);
        }
        this.KJ.s(false, true);
        this.Kj.setData(this.KJ);
        SpannableStringBuilder aCV = this.KJ.aCV();
        if (aCV != null && !StringUtils.isNull(aCV.toString())) {
            this.mTextTitle.setText(this.KJ.aCV());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pB(oc(1));
        V(this.KJ);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bCV().bCW() ? 0 : 8);
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNm != null && this.Kj != null) {
            this.Kj.setPageUniqueId(bdUniqueId);
        }
    }

    public void iK(boolean z) {
        this.eOl = z;
    }

    private void V(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cy("tid", bjVar.getId()).X("obj_locate", this.eOl ? 2 : 1).s("obj_id", bjVar.aCH().live_id).X("obj_type", 2));
            if (bjVar.aCH() != null && bjVar.aCH().user_info != null && bjVar.aCH().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cy("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", this.eOl ? 2 : 1).s("obj_id", bjVar.aCH().live_id).X("obj_type", 2));
        if (bjVar.aCH() != null && bjVar.aCH().user_info != null && bjVar.aCH().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cy("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aCt().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cy("uid", currentAccount).s("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cy("uid", currentAccount).s("fid", bjVar.getFid()));
            }
        }
    }

    public void b(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aCH() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String aCa = bjVar.aCa() != null ? bjVar.aCa() : this.eOm ? "frs_live_stage_live" : "frs_play";
            f(bjVar, aCa);
            AlaInfoData aCH = bjVar.aCH();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.aCo() != null) {
                z = TextUtils.equals(bjVar.aCo().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aCH);
            if (aCH.user_info != null) {
                alaLiveInfoCoreData.userName = aCH.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, aCa, "", z, this.mForumName)));
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setData(this.KJ);
                return;
            }
            this.eNn.setVisibility(this.eNm.setData(this.KJ) ? 8 : 0);
            this.eNY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }
}

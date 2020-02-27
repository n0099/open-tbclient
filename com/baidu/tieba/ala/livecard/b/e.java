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
    private TbPageContext<?> cVg;
    protected ThreadSourceShareAndPraiseLayout eNX;
    private RelativeLayout eNj;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private View eNm;
    public AlaVideoContainer eNn;
    private com.baidu.tieba.ala.livecard.vc.a eOe;
    public ThreadSkinView eOi;
    private TbImageView eOj;
    private boolean eOk;
    private boolean eOl;
    public LinearLayout egF;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eOk = false;
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.buE() != null) {
                    e.this.buE().a(view, e.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.cVg = tbPageContext;
        View view = getView();
        this.eNj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.egF = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNj.setOnClickListener(this);
        this.eOj = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.eOj.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.eOj.setDefaultBgResource(R.color.transparent);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setUserAfterClickListener(this.Nw);
        this.Kj.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setSelectVisible(false);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setCommentNumEnable(false);
        this.eNl.setLiveShareEnable(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setFrom(2);
        this.eNl.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 2;
        dVar.cNG = 2;
        this.eNl.setAgreeStatisticData(dVar);
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.diG.getCommentContainer().setOnClickListener(this);
        this.eNX.setFrom(2);
        this.eNX.setShareReportFrom(1);
        this.eNX.setSourceFromForPb(3);
        this.eNX.setStType("frs_page");
        this.eNX.setHideBarName(true);
        this.eNm = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eOi = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.eNn = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNn.setOnVideoClickListener(this);
        this.eNn.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eOe = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.Kj.getSuffixContainer());
        this.eOe.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNj, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.eNn != null) {
                this.eNn.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNl.onChangeSkinType();
            this.mSkinType = i;
            if (this.eNX != null && this.eNX.getVisibility() == 0) {
                this.eNX.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.eOe.onChangeSkinType();
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
        if (!com.baidu.tieba.frs.a.bCT().bCU()) {
            if (view == this.eNj || view == this.eNl.getCommentContainer() || view == this.egF || view == this.eNX.diG.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zS(this.KJ.getId());
                }
                if (buE() != null) {
                    buE().a(this.eNj, this.KJ);
                }
                b(getContext(), this.KJ);
                if (this.KJ != null) {
                    if (view == this.eNl.getCommentContainer() || view == this.eNX.diG.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 2);
                        anVar.X("obj_type", 5);
                        anVar.cy("tid", this.KJ.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (buE() != null) {
                    buE().a(view, this.KJ);
                }
                b(getContext(), this.KJ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.KJ == null || this.KJ.aCm() == null || this.eNn == null || this.eNn.getController() == null) {
            this.eNj.setVisibility(8);
            return;
        }
        this.eNn.getController().a(this.KJ, this.mForumName, "", false);
        this.eNn.getController().startPlayAnimation();
        this.eNj.setVisibility(0);
        if (this.KJ.aCF() != null && this.KJ.aCF().user_info != null && this.KJ.aCF().user_info.is_official == 2) {
            this.eOl = true;
            SparseArray<String> sparseArray2 = this.KJ.aCF().dislikeInfo;
            this.eOj.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.eOj.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.eOj.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.KJ.aCF().liveStagePicUrl)) {
                this.eOj.startLoad(this.KJ.aCF().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams.topMargin = this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.Kj.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.eOl = false;
            this.eOj.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.Kj.getLayoutParams();
            marginLayoutParams2.topMargin = this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.Kj.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.eOl && sparseArray != null && sparseArray.size() > 0) {
            this.eOe.e(this.KJ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.eOe.bgV() != null) {
            this.eOe.bgV().setVisibility(8);
        }
        this.KJ.s(false, true);
        this.Kj.setData(this.KJ);
        SpannableStringBuilder aCT = this.KJ.aCT();
        if (aCT != null && !StringUtils.isNull(aCT.toString())) {
            this.mTextTitle.setText(this.KJ.aCT());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pB(oc(1));
        V(this.KJ);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bCT().bCU() ? 0 : 8);
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNl != null && this.Kj != null) {
            this.Kj.setPageUniqueId(bdUniqueId);
        }
    }

    public void iK(boolean z) {
        this.eOk = z;
    }

    private void V(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cy("tid", bjVar.getId()).X("obj_locate", this.eOk ? 2 : 1).s("obj_id", bjVar.aCF().live_id).X("obj_type", 2));
            if (bjVar.aCF() != null && bjVar.aCF().user_info != null && bjVar.aCF().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cy("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", this.eOk ? 2 : 1).s("obj_id", bjVar.aCF().live_id).X("obj_type", 2));
        if (bjVar.aCF() != null && bjVar.aCF().user_info != null && bjVar.aCF().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cy("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aCr().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cy("uid", currentAccount).s("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cy("uid", currentAccount).s("fid", bjVar.getFid()));
            }
        }
    }

    public void b(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aCF() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String aBY = bjVar.aBY() != null ? bjVar.aBY() : this.eOl ? "frs_live_stage_live" : "frs_play";
            f(bjVar, aBY);
            AlaInfoData aCF = bjVar.aCF();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.aCm() != null) {
                z = TextUtils.equals(bjVar.aCm().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aCF);
            if (aCF.user_info != null) {
                alaLiveInfoCoreData.userName = aCF.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, aBY, "", z, this.mForumName)));
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setData(this.KJ);
                return;
            }
            this.eNm.setVisibility(this.eNl.setData(this.KJ) ? 8 : 0);
            this.eNX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }
}

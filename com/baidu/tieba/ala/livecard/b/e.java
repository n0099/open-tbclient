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
    private bj adG;
    private CardUserInfoLayout adh;
    private String aey;
    private final View.OnClickListener agi;
    private TbPageContext<?> duG;
    public LinearLayout eGZ;
    private RelativeLayout fsp;
    public ThreadCommentAndPraiseInfoLayout fsr;
    private View fss;
    public AlaVideoContainer fst;
    protected ThreadSourceShareAndPraiseLayout ftd;
    private com.baidu.tieba.ala.livecard.vc.a ftk;
    public ThreadSkinView fto;
    private TbImageView ftp;
    private boolean ftq;
    private boolean ftr;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ftq = false;
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bEy() != null) {
                    e.this.bEy().a(view, e.this.adG);
                }
            }
        };
        setTag(bdUniqueId);
        this.duG = tbPageContext;
        View view = getView();
        this.fsp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eGZ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsp.setOnClickListener(this);
        this.ftp = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.ftp.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.ftp.setDefaultBgResource(R.color.transparent);
        this.adh = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adh.setUserAfterClickListener(this.agi);
        this.adh.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setSelectVisible(false);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setCommentNumEnable(false);
        this.fsr.setLiveShareEnable(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setFrom(2);
        this.fsr.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 2;
        dVar.dmZ = 2;
        this.fsr.setAgreeStatisticData(dVar);
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.dJa.getCommentContainer().setOnClickListener(this);
        this.ftd.setFrom(2);
        this.ftd.setShareReportFrom(1);
        this.ftd.setSourceFromForPb(3);
        this.ftd.setStType("frs_page");
        this.ftd.setHideBarName(true);
        this.fss = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fto = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.fst = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fst.setOnVideoClickListener(this);
        this.fst.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.ftk = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.adh.getSuffixContainer());
        this.ftk.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.fst != null) {
                this.fst.onChangeSkinType(i);
            }
            this.adh.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsr.onChangeSkinType();
            this.mSkinType = i;
            if (this.ftd != null && this.ftd.getVisibility() == 0) {
                this.ftd.onChangeSkinType();
            }
        }
        if (this.adG != null && l.BC(this.adG.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.ftk.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.adG = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bND().bNE()) {
            if (view == this.fsp || view == this.fsr.getCommentContainer() || view == this.eGZ || view == this.ftd.dJa.getCommentContainer()) {
                if (this.adG != null) {
                    l.BB(this.adG.getId());
                }
                if (bEy() != null) {
                    bEy().a(this.fsp, this.adG);
                }
                b(getContext(), this.adG);
                if (this.adG != null) {
                    if (view == this.fsr.getCommentContainer() || view == this.ftd.dJa.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.af("obj_locate", 2);
                        anVar.af("obj_type", 5);
                        anVar.cI("tid", this.adG.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bEy() != null) {
                    bEy().a(view, this.adG);
                }
                b(getContext(), this.adG);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.adG == null || this.adG.aKE() == null || this.fst == null || this.fst.getController() == null) {
            this.fsp.setVisibility(8);
            return;
        }
        this.fst.getController().a(this.adG, this.mForumName, "", false);
        this.fst.getController().startPlayAnimation();
        this.fsp.setVisibility(0);
        if (this.adG.aKX() != null && this.adG.aKX().user_info != null && this.adG.aKX().user_info.is_official == 2) {
            this.ftr = true;
            SparseArray<String> sparseArray2 = this.adG.aKX().dislikeInfo;
            this.ftp.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.ftp.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.ftp.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.adG.aKX().liveStagePicUrl)) {
                this.ftp.startLoad(this.adG.aKX().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.adh.getLayoutParams();
            marginLayoutParams.topMargin = this.duG.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.adh.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.ftr = false;
            this.ftp.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.adh.getLayoutParams();
            marginLayoutParams2.topMargin = this.duG.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.adh.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.ftr && sparseArray != null && sparseArray.size() > 0) {
            this.ftk.e(this.adG, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.ftk.bqu() != null) {
            this.ftk.bqu().setVisibility(8);
        }
        this.adG.s(false, true);
        this.adh.setData(this.adG);
        SpannableStringBuilder aLl = this.adG.aLl();
        if (aLl != null && !StringUtils.isNull(aLl.toString())) {
            this.mTextTitle.setText(this.adG.aLl());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pX(or(1));
        W(this.adG);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bND().bNE() ? 0 : 8);
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsr != null && this.adh != null) {
            this.adh.setPageUniqueId(bdUniqueId);
        }
    }

    public void jN(boolean z) {
        this.ftq = z;
    }

    private void W(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cI("tid", bjVar.getId()).af("obj_locate", this.ftq ? 2 : 1).t("obj_id", bjVar.aKX().live_id).af("obj_type", 2));
            if (bjVar.aKX() != null && bjVar.aKX().user_info != null && bjVar.aKX().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cI("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", this.ftq ? 2 : 1).t("obj_id", bjVar.aKX().live_id).af("obj_type", 2));
        if (bjVar.aKX() != null && bjVar.aKX().user_info != null && bjVar.aKX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cI("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aKJ().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cI("uid", currentAccount).t("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cI("uid", currentAccount).t("fid", bjVar.getFid()));
            }
        }
    }

    public void b(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aKX() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String aKq = bjVar.aKq() != null ? bjVar.aKq() : this.ftr ? "frs_live_stage_live" : "frs_play";
            f(bjVar, aKq);
            AlaInfoData aKX = bjVar.aKX();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.aKE() != null) {
                z = TextUtils.equals(bjVar.aKE().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aKX);
            if (aKX.user_info != null) {
                alaLiveInfoCoreData.userName = aKX.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, aKq, "", z, this.mForumName)));
        }
    }

    public void pX(int i) {
        if (this.adG != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setData(this.adG);
                return;
            }
            this.fss.setVisibility(this.fsr.setData(this.adG) ? 8 : 0);
            this.ftd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }
}

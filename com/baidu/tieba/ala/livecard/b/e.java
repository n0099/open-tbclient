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
    private bj adJ;
    private CardUserInfoLayout adk;
    private String aeB;
    private final View.OnClickListener agl;
    private TbPageContext<?> duK;
    public LinearLayout eHe;
    private RelativeLayout fsu;
    public ThreadCommentAndPraiseInfoLayout fsw;
    private View fsx;
    public AlaVideoContainer fsy;
    protected ThreadSourceShareAndPraiseLayout fti;
    private com.baidu.tieba.ala.livecard.vc.a ftp;
    public ThreadSkinView ftt;
    private TbImageView ftu;
    private boolean ftw;
    private boolean ftx;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ftw = false;
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bEx() != null) {
                    e.this.bEx().a(view, e.this.adJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.duK = tbPageContext;
        View view = getView();
        this.fsu = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eHe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsu.setOnClickListener(this);
        this.ftu = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.ftu.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.ftu.setDefaultBgResource(R.color.transparent);
        this.adk = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adk.setUserAfterClickListener(this.agl);
        this.adk.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setSelectVisible(false);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setCommentNumEnable(false);
        this.fsw.setLiveShareEnable(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setFrom(2);
        this.fsw.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 2;
        dVar.dnd = 2;
        this.fsw.setAgreeStatisticData(dVar);
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fti.dJe.setOnClickListener(this);
        this.fti.dJe.getCommentContainer().setOnClickListener(this);
        this.fti.setFrom(2);
        this.fti.setShareReportFrom(1);
        this.fti.setSourceFromForPb(3);
        this.fti.setStType("frs_page");
        this.fti.setHideBarName(true);
        this.fsx = view.findViewById(R.id.divider_below_reply_number_layout);
        this.ftt = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.fsy = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fsy.setOnVideoClickListener(this);
        this.fsy.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.ftp = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.adk.getSuffixContainer());
        this.ftp.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsu, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.fsy != null) {
                this.fsy.onChangeSkinType(i);
            }
            this.adk.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsw.onChangeSkinType();
            this.mSkinType = i;
            if (this.fti != null && this.fti.getVisibility() == 0) {
                this.fti.onChangeSkinType();
            }
        }
        if (this.adJ != null && l.BF(this.adJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.ftp.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.adJ = bjVar;
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
        if (!com.baidu.tieba.frs.a.bNC().bND()) {
            if (view == this.fsu || view == this.fsw.getCommentContainer() || view == this.eHe || view == this.fti.dJe.getCommentContainer()) {
                if (this.adJ != null) {
                    l.BE(this.adJ.getId());
                }
                if (bEx() != null) {
                    bEx().a(this.fsu, this.adJ);
                }
                b(getContext(), this.adJ);
                if (this.adJ != null) {
                    if (view == this.fsw.getCommentContainer() || view == this.fti.dJe.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.af("obj_locate", 2);
                        anVar.af("obj_type", 5);
                        anVar.cI("tid", this.adJ.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bEx() != null) {
                    bEx().a(view, this.adJ);
                }
                b(getContext(), this.adJ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.adJ == null || this.adJ.aKC() == null || this.fsy == null || this.fsy.getController() == null) {
            this.fsu.setVisibility(8);
            return;
        }
        this.fsy.getController().a(this.adJ, this.mForumName, "", false);
        this.fsy.getController().startPlayAnimation();
        this.fsu.setVisibility(0);
        if (this.adJ.aKV() != null && this.adJ.aKV().user_info != null && this.adJ.aKV().user_info.is_official == 2) {
            this.ftx = true;
            SparseArray<String> sparseArray2 = this.adJ.aKV().dislikeInfo;
            this.ftu.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.ftu.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.ftu.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.adJ.aKV().liveStagePicUrl)) {
                this.ftu.startLoad(this.adJ.aKV().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.adk.getLayoutParams();
            marginLayoutParams.topMargin = this.duK.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.adk.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.ftx = false;
            this.ftu.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.adk.getLayoutParams();
            marginLayoutParams2.topMargin = this.duK.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.adk.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.ftx && sparseArray != null && sparseArray.size() > 0) {
            this.ftp.e(this.adJ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.ftp.bqs() != null) {
            this.ftp.bqs().setVisibility(8);
        }
        this.adJ.s(false, true);
        this.adk.setData(this.adJ);
        SpannableStringBuilder aLj = this.adJ.aLj();
        if (aLj != null && !StringUtils.isNull(aLj.toString())) {
            this.mTextTitle.setText(this.adJ.aLj());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pX(or(1));
        W(this.adJ);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bNC().bND() ? 0 : 8);
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsw != null && this.adk != null) {
            this.adk.setPageUniqueId(bdUniqueId);
        }
    }

    public void jN(boolean z) {
        this.ftw = z;
    }

    private void W(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cI("tid", bjVar.getId()).af("obj_locate", this.ftw ? 2 : 1).t("obj_id", bjVar.aKV().live_id).af("obj_type", 2));
            if (bjVar.aKV() != null && bjVar.aKV().user_info != null && bjVar.aKV().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cI("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", this.ftw ? 2 : 1).t("obj_id", bjVar.aKV().live_id).af("obj_type", 2));
        if (bjVar.aKV() != null && bjVar.aKV().user_info != null && bjVar.aKV().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cI("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.aKH().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cI("uid", currentAccount).t("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cI("uid", currentAccount).t("fid", bjVar.getFid()));
            }
        }
    }

    public void b(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.aKV() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String aKo = bjVar.aKo() != null ? bjVar.aKo() : this.ftx ? "frs_live_stage_live" : "frs_play";
            f(bjVar, aKo);
            AlaInfoData aKV = bjVar.aKV();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.aKC() != null) {
                z = TextUtils.equals(bjVar.aKC().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aKV);
            if (aKV.user_info != null) {
                alaLiveInfoCoreData.userName = aKV.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, aKo, "", z, this.mForumName)));
        }
    }

    public void pX(int i) {
        if (this.adJ != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setData(this.adJ);
                return;
            }
            this.fsx.setVisibility(this.fsw.setData(this.adJ) ? 8 : 0);
            this.fti.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }
}

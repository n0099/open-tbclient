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
    private CardUserInfoLayout JH;
    private bj Ki;
    private String La;
    private final View.OnClickListener MT;
    private TbPageContext<?> cQU;
    protected ThreadSourceShareAndPraiseLayout eIU;
    private RelativeLayout eIf;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private View eIi;
    public AlaVideoContainer eIj;
    private com.baidu.tieba.ala.livecard.vc.a eJb;
    public ThreadSkinView eJf;
    private TbImageView eJg;
    private boolean eJh;
    private boolean eJi;
    public LinearLayout ect;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eJh = false;
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.brY() != null) {
                    e.this.brY().a(view, e.this.Ki);
                }
            }
        };
        setTag(bdUniqueId);
        this.cQU = tbPageContext;
        View view = getView();
        this.eIf = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ect = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eIf.setOnClickListener(this);
        this.eJg = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.eJg.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.eJg.setDefaultBgResource(R.color.transparent);
        this.JH = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.JH.setUserAfterClickListener(this.MT);
        this.JH.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setSelectVisible(false);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setCommentNumEnable(false);
        this.eIh.setLiveShareEnable(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setFrom(2);
        this.eIh.getCommentContainer().setOnClickListener(this);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 2;
        dVar.cJs = 2;
        this.eIh.setAgreeStatisticData(dVar);
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.dep.getCommentContainer().setOnClickListener(this);
        this.eIU.setFrom(2);
        this.eIU.setShareReportFrom(1);
        this.eIU.setSourceFromForPb(3);
        this.eIU.setStType("frs_page");
        this.eIU.setHideBarName(true);
        this.eIi = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eJf = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.eIj = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eIj.setOnVideoClickListener(this);
        this.eIj.setLigvingLogLayoutVisible(8);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eJb = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.JH.getSuffixContainer());
        this.eJb.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIf, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            if (this.eIj != null) {
                this.eIj.onChangeSkinType(i);
            }
            this.JH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eIh.onChangeSkinType();
            this.mSkinType = i;
            if (this.eIU != null && this.eIU.getVisibility() == 0) {
                this.eIU.onChangeSkinType();
            }
        }
        if (this.Ki != null && l.zt(this.Ki.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.eJb.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.Ki = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bAp().bAq()) {
            if (view == this.eIf || view == this.eIh.getCommentContainer() || view == this.ect || view == this.eIU.dep.getCommentContainer()) {
                if (this.Ki != null) {
                    l.zs(this.Ki.getId());
                }
                if (brY() != null) {
                    brY().a(this.eIf, this.Ki);
                }
                c(getContext(), this.Ki);
                if (this.Ki != null) {
                    if (view == this.eIh.getCommentContainer() || view == this.eIU.dep.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.Z("obj_locate", 2);
                        anVar.Z("obj_type", 5);
                        anVar.cp("tid", this.Ki.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (brY() != null) {
                    brY().a(view, this.Ki);
                }
                c(getContext(), this.Ki);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.Ki == null || this.Ki.azE() == null || this.eIj == null || this.eIj.getController() == null) {
            this.eIf.setVisibility(8);
            return;
        }
        this.eIj.getController().a(this.Ki, this.mForumName, "", false);
        this.eIj.getController().startPlayAnimation();
        this.eIf.setVisibility(0);
        if (this.Ki.azX() != null && this.Ki.azX().user_info != null && this.Ki.azX().user_info.is_official == 2) {
            this.eJi = true;
            SparseArray<String> sparseArray2 = this.Ki.azX().dislikeInfo;
            this.eJg.setVisibility(0);
            int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.eJg.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.eJg.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.Ki.azX().liveStagePicUrl)) {
                this.eJg.startLoad(this.Ki.azX().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.JH.getLayoutParams();
            marginLayoutParams.topMargin = this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.JH.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.eJi = false;
            this.eJg.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.JH.getLayoutParams();
            marginLayoutParams2.topMargin = this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.JH.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.eJi && sparseArray != null && sparseArray.size() > 0) {
            this.eJb.e(this.Ki, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.eJb.beq() != null) {
            this.eJb.beq().setVisibility(8);
        }
        this.Ki.q(false, true);
        this.JH.setData(this.Ki);
        SpannableStringBuilder aAl = this.Ki.aAl();
        if (aAl != null && !StringUtils.isNull(aAl.toString())) {
            this.mTextTitle.setText(this.Ki.aAl());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        pp(nL(1));
        T(this.Ki);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bAp().bAq() ? 0 : 8);
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eIh != null && this.JH != null) {
            this.JH.setPageUniqueId(bdUniqueId);
        }
    }

    public void it(boolean z) {
        this.eJh = z;
    }

    private void T(bj bjVar) {
        if (bjVar != null) {
            TiebaStatic.log(new an("c12125").cp("tid", bjVar.getId()).Z("obj_locate", this.eJh ? 2 : 1).s("obj_id", bjVar.azX().live_id).Z("obj_type", 2));
            if (bjVar.azX() != null && bjVar.azX().user_info != null && bjVar.azX().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").cp("tid", bjVar.getId()));
            }
        }
    }

    private void f(bj bjVar, String str) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", this.eJh ? 2 : 1).s("obj_id", bjVar.azX().live_id).Z("obj_type", 2));
        if (bjVar.azX() != null && bjVar.azX().user_info != null && bjVar.azX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").cp("tid", bjVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bjVar.azJ().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").cp("uid", currentAccount).s("fid", bjVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").cp("uid", currentAccount).s("fid", bjVar.getFid()));
            }
        }
    }

    public void c(Context context, bj bjVar) {
        if (context != null && bjVar != null && bjVar.azX() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String azq = bjVar.azq() != null ? bjVar.azq() : this.eJi ? "frs_live_stage_live" : "frs_play";
            f(bjVar, azq);
            AlaInfoData azX = bjVar.azX();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bjVar.azE() != null) {
                z = TextUtils.equals(bjVar.azE().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(azX);
            if (azX.user_info != null) {
                alaLiveInfoCoreData.userName = azX.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, azq, "", z, this.mForumName)));
        }
    }

    public void pp(int i) {
        if (this.Ki != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setData(this.Ki);
                return;
            }
            this.eIi.setVisibility(this.eIh.setData(this.Ki) ? 8 : 0);
            this.eIU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }
}

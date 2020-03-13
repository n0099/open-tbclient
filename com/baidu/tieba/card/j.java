package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout Kj;
    private String LC;
    private UnfollowedDecorView Mz;
    private View.OnClickListener Nw;
    private TbPageContext<?> cVi;
    public TbImageView dMk;
    private TextView dMq;
    private View.OnClickListener dhW;
    public boolean djh;
    private NEGFeedBackView eNK;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public ThreadSourceShareAndPraiseLayout eOl;
    public LinearLayout egT;
    private com.baidu.tieba.card.data.j fJr;
    public FrameLayout fJs;
    public RelativeLayout fJt;
    private TBLottieAnimationView fJu;
    private View fJv;
    private ThreadForumEnterButton fJw;
    private View.OnClickListener fJx;
    private CustomMessageListener fJy;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eNK = null;
        this.Mz = null;
        this.djh = false;
        this.mLastScreenWidth = 0;
        this.fJx = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buH() != null) {
                    j.this.buH().a(view, j.this.fJr);
                }
            }
        };
        this.dhW = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buH() != null) {
                    j.this.buH().a(view, j.this.fJr);
                }
            }
        };
        this.fJy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fJr != null && j.this.fJr.cRg != null && j.this.fJr.cRg.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fJr.cRg.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fJr.cRg.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cVi = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.fJs = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.egT = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.Kj.setPageContext(this.cVi);
        this.Kj.setPageUniqueId(this.mBdUniqueId);
        this.eNK = new NEGFeedBackView(getTbPageContext());
        this.eNK.a(this.fJs, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        buN();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fJt = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dMk = (TbImageView) view.findViewById(R.id.image_video);
        this.dMk.setDrawCorner(true);
        this.dMk.setPlaceHolder(3);
        this.dMk.setDefaultResource(0);
        this.dMk.setDefaultErrorResource(0);
        this.dMk.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMk;
        TbImageView tbImageView2 = this.dMk;
        tbImageView.setConrers(15);
        this.dMk.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMk.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMk.setBorderSurroundContent(true);
        this.dMk.setDrawBorder(true);
        this.fJu = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fJu.loop(true);
        am.a(this.fJu, R.raw.ala_live2);
        this.fJu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fJu.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fJu.cancelAnimation();
            }
        });
        this.fJw = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setNeedAddPraiseIcon(true);
        if (this.eNz.getCommentContainer() != null) {
            this.eNz.getCommentContainer().setOnClickListener(this);
        }
        this.eNz.setShareVisible(true);
        this.eNz.setFrom(7);
        this.eNz.setShareReportFrom(3);
        this.eNz.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 7;
        dVar.cNI = 1;
        this.eNz.setAgreeStatisticData(dVar);
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.setFrom(7);
        this.eOl.setShareReportFrom(3);
        if (this.eOl.diU.getCommentContainer() != null) {
            this.eOl.diU.getCommentContainer().setOnClickListener(this);
        }
        this.dMq = (TextView) view.findViewById(R.id.play_count);
        this.fJv = view.findViewById(R.id.divider_below_reply_number_layout);
        this.egT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fJs, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.egT, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.fJt, R.drawable.bg_ala_shape);
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNz.onChangeSkinType();
            if (this.eNK != null) {
                this.eNK.onChangeSkinType();
            }
            this.Mz.onChangeSkinType();
            this.fJw.onChangeSkinType();
            this.eOl.onChangeSkinType();
            this.dMk.setPlaceHolder(3);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.fJr = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fJr == null || this.fJr.aAg() == null) {
            this.fJs.setVisibility(8);
            return;
        }
        this.fJs.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVi.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJt.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fJt.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.fJr.aAg().aCH() != null && this.fJr.aAg().aCH().isChushou) {
            this.eNz.setShowFlag(10);
            this.eNz.hideShareContainer();
        } else {
            this.eNz.setShowFlag(11);
            this.eNz.resetShareContainer();
        }
        this.Kj.setVisibility(0);
        this.Kj.setData(this.fJr.aAg());
        this.Kj.setUserAfterClickListener(this.Nw);
        this.fJr.aAg().aDj();
        this.mTextTitle.setText(new SpannableStringBuilder(this.fJr.aAg().aCV()));
        if (this.fJr.cRg.aCH().audience_count > 0) {
            this.dMq.setVisibility(0);
            this.dMq.setText(String.format(this.cVi.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fJr.cRg.aCH().audience_count)));
        } else {
            this.dMq.setVisibility(8);
        }
        if (this.djh) {
            this.fJw.q(this.fJr.aAg());
        }
        this.Mz.q(this.fJr.aAg());
        if (this.djh) {
            this.eNK.setVisibility(8);
            if (!au.u(this.fJr.aAg())) {
                this.Mz.setVisibility(0);
            } else {
                this.Mz.setVisibility(8);
            }
        } else {
            if (this.eNK != null && this.fJr.aAg() != null) {
                al alVar = new al();
                alVar.setTid(this.fJr.aAg().getTid());
                alVar.setFid(this.fJr.aAg().getFid());
                alVar.setFeedBackReasonMap(this.fJr.feedBackReasonMap);
                this.eNK.setData(alVar);
                this.eNK.setFirstRowSingleColumn(true);
            }
            this.Mz.setVisibility(8);
        }
        pB(oc(1));
        onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        if (l.zU(this.fJr.cRg.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        buK();
        this.fJu.playAnimation();
    }

    public void buK() {
        if (com.baidu.tbadk.core.i.azO().isShowImages() && this.fJr != null && this.fJr.aAg() != null && this.fJr.aAg().aCH() != null) {
            this.dMk.setPlaceHolder(3);
            this.dMk.startLoad(this.fJr.aAg().aCH().cover, 10, false);
            this.fJt.setVisibility(0);
            return;
        }
        this.fJt.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eNK != null) {
            this.eNK.setEventCallback(aVar);
        }
    }

    public View buL() {
        if (this.Kj != null) {
            return this.Kj.getAvatar();
        }
        return null;
    }

    public View buM() {
        if (this.djh) {
            if (this.Kj != null) {
                return this.Kj.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egT || view == this.eNz.getCommentContainer() || view == this.eOl.diU.getCommentContainer()) {
            if (this.fJr.aAg().aCH() != null && this.fJr.aAg().aCH().isChushou) {
                da(this.fJr.aAg().aCH().thirdRoomId, this.fJr.aAg().aCH().thirdLiveType);
            } else {
                bE(view);
            }
        }
    }

    private void da(String str, String str2) {
        ba.aGG().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bE(View view) {
        if (buH() != null) {
            buH().a(view, this.fJr);
        }
        if (this.fJr != null && this.fJr.aAg() != null && this.fJr.aAg().aCH() != null) {
            l.zT(this.fJr.cRg.getId());
            l.a(this.mTextTitle, this.fJr.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fJr.aAg().aCH());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cVi.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNz != null && this.fJy != null) {
            if (this.Kj != null) {
                this.Kj.setPageUniqueId(bdUniqueId);
            }
            this.fJy.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eNK != null) {
                this.eNK.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fJy);
        }
    }

    public void pB(int i) {
        if (this.fJr != null && this.fJr.cRg != null) {
            if (i == 1) {
                this.eNz.setVisibility(8);
                this.eOl.setData(this.fJr.cRg);
                return;
            }
            this.eOl.setVisibility(8);
            if (this.eNz.setData(this.fJr.cRg)) {
                this.fJv.setVisibility(8);
            } else {
                this.fJv.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    public void rp(int i) {
        if (this.eNz != null) {
            this.eNz.dhU = String.valueOf(i);
        }
    }

    public void fE(boolean z) {
        this.djh = z;
    }

    private void buN() {
        this.Mz = new UnfollowedDecorView(this.cVi.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fJs.addView(this.Mz, layoutParams);
    }
}

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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout EV;
    private String Gc;
    private View.OnClickListener Ho;
    public View bgU;
    public TbImageView cTp;
    private TextView cTv;
    private TbPageContext<?> ceu;
    private View.OnClickListener coV;
    public boolean cri;
    private NEGFeedBackView dSM;
    public NewThreadCommentAndPraiseInfoLayout dTn;
    public ThreadSourceShareAndPraiseLayout dTo;
    public LinearLayout dTz;
    private com.baidu.tieba.card.data.j eLG;
    public FrameLayout eLH;
    public RelativeLayout eLI;
    public TBLottieAnimationView eLJ;
    private View eLK;
    private ThreadForumEnterButton eLL;
    private CustomMessageListener eLM;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dSM = null;
        this.cri = false;
        this.mLastScreenWidth = 0;
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZV() != null) {
                    l.this.aZV().a(view, l.this.eLG);
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZV() != null) {
                    l.this.aZV().a(view, l.this.eLG);
                }
            }
        };
        this.eLM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.eLG != null && l.this.eLG.caz != null && l.this.eLG.caz.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.eLG.caz.getTid())) {
                    n.a(l.this.mTextTitle, l.this.eLG.caz.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.ceu = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eLH = (FrameLayout) view.findViewById(R.id.layout_root);
        this.bgU = view.findViewById(R.id.divider_line);
        this.dTz = (LinearLayout) view.findViewById(R.id.content_layout);
        this.EV = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dSM = new NEGFeedBackView(this.ceu);
        this.dSM = new NEGFeedBackView(getTbPageContext());
        this.dSM.a(this.eLH, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eLI = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cTp = (TbImageView) view.findViewById(R.id.image_video);
        this.cTp.setDrawCorner(true);
        this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        this.cTp.setDefaultResource(0);
        this.cTp.setDefaultErrorResource(0);
        this.cTp.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cTp;
        TbImageView tbImageView2 = this.cTp;
        tbImageView.setConrers(15);
        this.cTp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cTp.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cTp.setBorderSurroundContent(true);
        this.cTp.setDrawBorder(true);
        this.eLJ = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.eLJ.loop(true);
        am.a(this.eLJ, R.raw.ala_play);
        this.eLJ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.eLJ.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.eLJ.cancelAnimation();
            }
        });
        this.eLL = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dTn = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dTn.setOnClickListener(this);
        this.dTn.setReplyTimeVisible(false);
        this.dTn.setShowPraiseNum(true);
        this.dTn.setNeedAddReplyIcon(true);
        this.dTn.setNeedAddPraiseIcon(true);
        if (this.dTn.getCommentContainer() != null) {
            this.dTn.getCommentContainer().setOnClickListener(this);
        }
        this.dTn.setShareVisible(true);
        this.dTn.setFrom(7);
        this.dTn.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bWZ = 7;
        dVar.bXe = 1;
        this.dTn.setAgreeStatisticData(dVar);
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.setFrom(7);
        this.dTo.setShareReportFrom(3);
        if (this.dTo.cqW.getCommentContainer() != null) {
            this.dTo.cqW.getCommentContainer().setOnClickListener(this);
        }
        this.cTv = (TextView) view.findViewById(R.id.play_count);
        this.eLK = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dTz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eLH, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.dTz, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            am.a(this.eLJ, R.raw.ala_play);
            am.setBackgroundResource(this.eLI, R.drawable.bg_ala_shape);
            this.EV.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dTn.onChangeSkinType();
            if (this.dSM != null) {
                this.dSM.onChangeSkinType();
            }
            this.eLL.onChangeSkinType();
            this.dTo.onChangeSkinType();
            this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
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
        this.eLG = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.eLG == null || this.eLG.agG() == null) {
            this.eLH.setVisibility(8);
            return;
        }
        this.eLH.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ceu.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLI.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eLI.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.EV.setData(this.eLG.agG());
        this.EV.setUserAfterClickListener(this.Ho);
        this.eLG.agG().aju();
        this.mTextTitle.setText(new SpannableStringBuilder(this.eLG.agG().ajk()));
        this.cTv.setText(String.format(this.ceu.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.eLG.caz.aiX().audience_count)));
        this.eLL.y(this.eLG.agG());
        if (this.cri) {
            this.dSM.setVisibility(8);
        } else if (this.dSM != null && this.eLG.agG() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eLG.agG().getTid());
            ajVar.setFid(this.eLG.agG().getFid());
            ajVar.setFeedBackReasonMap(this.eLG.feedBackReasonMap);
            this.dSM.setData(ajVar);
            this.dSM.setFirstRowSingleColumn(true);
        }
        mY(lx(1));
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eLG.caz.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aZY();
        this.eLJ.playAnimation();
    }

    public void aZY() {
        if (com.baidu.tbadk.core.i.ago().isShowImages() && this.eLG != null && this.eLG.agG() != null && this.eLG.agG().aiX() != null) {
            this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.cTp.startLoad(this.eLG.agG().aiX().cover, 10, false);
            this.eLI.setVisibility(0);
            return;
        }
        this.eLI.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dSM != null) {
            this.dSM.setEventCallback(aVar);
        }
    }

    public View aZZ() {
        if (this.EV != null) {
            return this.EV.getAvatar();
        }
        return null;
    }

    public View baa() {
        if (this.EV != null) {
            return this.EV.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dTz || view == this.dTn.getCommentContainer() || view == this.dTo.cqW.getCommentContainer()) {
            bC(view);
        }
    }

    private void bC(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLG);
        }
        if (this.eLG != null && this.eLG.agG() != null && this.eLG.agG().aiX() != null) {
            n.uz(this.eLG.caz.getId());
            n.a(this.mTextTitle, this.eLG.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eLG.agG().aiX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.ceu.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dTn != null && this.eLM != null) {
            if (this.EV != null) {
                this.EV.setPageUniqueId(bdUniqueId);
            }
            this.eLM.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dSM != null) {
                this.dSM.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eLM);
        }
    }

    public void mY(int i) {
        if (this.eLG != null && this.eLG.caz != null) {
            if (i == 1) {
                this.dTn.setVisibility(8);
                this.dTo.setData(this.eLG.caz);
                return;
            }
            this.dTo.setVisibility(8);
            if (this.dTn.setData(this.eLG.caz)) {
                this.eLK.setVisibility(8);
            } else {
                this.eLK.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    public void oK(int i) {
        if (this.dTn != null) {
            this.dTn.cqd = String.valueOf(i);
        }
    }

    public void ef(boolean z) {
        this.cri = z;
    }
}

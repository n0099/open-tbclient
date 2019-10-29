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
    private CardUserInfoLayout Fv;
    private String GC;
    private View.OnClickListener HO;
    public View bhm;
    public TbImageView cUg;
    private TextView cUm;
    private TbPageContext<?> cfl;
    private View.OnClickListener cpN;
    public boolean crZ;
    private NEGFeedBackView dTD;
    public NewThreadCommentAndPraiseInfoLayout dUe;
    public ThreadSourceShareAndPraiseLayout dUf;
    public LinearLayout dUq;
    public TBLottieAnimationView eMA;
    private View eMB;
    private ThreadForumEnterButton eMC;
    private CustomMessageListener eMD;
    private com.baidu.tieba.card.data.j eMx;
    public FrameLayout eMy;
    public RelativeLayout eMz;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTD = null;
        this.crZ = false;
        this.mLastScreenWidth = 0;
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZX() != null) {
                    l.this.aZX().a(view, l.this.eMx);
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZX() != null) {
                    l.this.aZX().a(view, l.this.eMx);
                }
            }
        };
        this.eMD = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.eMx != null && l.this.eMx.cbq != null && l.this.eMx.cbq.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.eMx.cbq.getTid())) {
                    n.a(l.this.mTextTitle, l.this.eMx.cbq.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cfl = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eMy = (FrameLayout) view.findViewById(R.id.layout_root);
        this.bhm = view.findViewById(R.id.divider_line);
        this.dUq = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Fv = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dTD = new NEGFeedBackView(this.cfl);
        this.dTD = new NEGFeedBackView(getTbPageContext());
        this.dTD.a(this.eMy, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eMz = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cUg = (TbImageView) view.findViewById(R.id.image_video);
        this.cUg.setDrawCorner(true);
        this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        this.cUg.setDefaultResource(0);
        this.cUg.setDefaultErrorResource(0);
        this.cUg.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cUg;
        TbImageView tbImageView2 = this.cUg;
        tbImageView.setConrers(15);
        this.cUg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cUg.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cUg.setBorderSurroundContent(true);
        this.cUg.setDrawBorder(true);
        this.eMA = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.eMA.loop(true);
        am.a(this.eMA, R.raw.ala_play);
        this.eMA.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.eMA.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.eMA.cancelAnimation();
            }
        });
        this.eMC = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dUe = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dUe.setOnClickListener(this);
        this.dUe.setReplyTimeVisible(false);
        this.dUe.setShowPraiseNum(true);
        this.dUe.setNeedAddReplyIcon(true);
        this.dUe.setNeedAddPraiseIcon(true);
        if (this.dUe.getCommentContainer() != null) {
            this.dUe.getCommentContainer().setOnClickListener(this);
        }
        this.dUe.setShareVisible(true);
        this.dUe.setFrom(7);
        this.dUe.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXQ = 7;
        dVar.bXV = 1;
        this.dUe.setAgreeStatisticData(dVar);
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.setFrom(7);
        this.dUf.setShareReportFrom(3);
        if (this.dUf.crO.getCommentContainer() != null) {
            this.dUf.crO.getCommentContainer().setOnClickListener(this);
        }
        this.cUm = (TextView) view.findViewById(R.id.play_count);
        this.eMB = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dUq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eMy, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.dUq, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            am.a(this.eMA, R.raw.ala_play);
            am.setBackgroundResource(this.eMz, R.drawable.bg_ala_shape);
            this.Fv.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dUe.onChangeSkinType();
            if (this.dTD != null) {
                this.dTD.onChangeSkinType();
            }
            this.eMC.onChangeSkinType();
            this.dUf.onChangeSkinType();
            this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
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
        this.eMx = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.eMx == null || this.eMx.agI() == null) {
            this.eMy.setVisibility(8);
            return;
        }
        this.eMy.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cfl.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMz.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eMz.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Fv.setData(this.eMx.agI());
        this.Fv.setUserAfterClickListener(this.HO);
        this.eMx.agI().ajw();
        this.mTextTitle.setText(new SpannableStringBuilder(this.eMx.agI().ajm()));
        this.cUm.setText(String.format(this.cfl.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.eMx.cbq.aiZ().audience_count)));
        this.eMC.y(this.eMx.agI());
        if (this.crZ) {
            this.dTD.setVisibility(8);
        } else if (this.dTD != null && this.eMx.agI() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eMx.agI().getTid());
            ajVar.setFid(this.eMx.agI().getFid());
            ajVar.setFeedBackReasonMap(this.eMx.feedBackReasonMap);
            this.dTD.setData(ajVar);
            this.dTD.setFirstRowSingleColumn(true);
        }
        mZ(ly(1));
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eMx.cbq.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        baa();
        this.eMA.playAnimation();
    }

    public void baa() {
        if (com.baidu.tbadk.core.i.agq().isShowImages() && this.eMx != null && this.eMx.agI() != null && this.eMx.agI().aiZ() != null) {
            this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.cUg.startLoad(this.eMx.agI().aiZ().cover, 10, false);
            this.eMz.setVisibility(0);
            return;
        }
        this.eMz.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dTD != null) {
            this.dTD.setEventCallback(aVar);
        }
    }

    public View bab() {
        if (this.Fv != null) {
            return this.Fv.getAvatar();
        }
        return null;
    }

    public View bac() {
        if (this.Fv != null) {
            return this.Fv.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUq || view == this.dUe.getCommentContainer() || view == this.dUf.crO.getCommentContainer()) {
            bC(view);
        }
    }

    private void bC(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eMx);
        }
        if (this.eMx != null && this.eMx.agI() != null && this.eMx.agI().aiZ() != null) {
            n.uz(this.eMx.cbq.getId());
            n.a(this.mTextTitle, this.eMx.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eMx.agI().aiZ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cfl.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dUe != null && this.eMD != null) {
            if (this.Fv != null) {
                this.Fv.setPageUniqueId(bdUniqueId);
            }
            this.eMD.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dTD != null) {
                this.dTD.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eMD);
        }
    }

    public void mZ(int i) {
        if (this.eMx != null && this.eMx.cbq != null) {
            if (i == 1) {
                this.dUe.setVisibility(8);
                this.dUf.setData(this.eMx.cbq);
                return;
            }
            this.dUf.setVisibility(8);
            if (this.dUe.setData(this.eMx.cbq)) {
                this.eMB.setVisibility(8);
            } else {
                this.eMB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    public void oL(int i) {
        if (this.dUe != null) {
            this.dUe.cqU = String.valueOf(i);
        }
    }

    public void ef(boolean z) {
        this.crZ = z;
    }
}

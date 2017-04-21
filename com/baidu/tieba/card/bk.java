package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> ajU;
    private CustomMessageListener buW;
    private com.baidu.tieba.card.data.o bvT;
    public a bvU;
    private View.OnClickListener bvV;
    private View.OnClickListener bvW;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvV = new bl(this);
        this.bvW = new bm(this);
        this.buW = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajU = tbPageContext;
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bvU = new a();
        this.bvU.mRootView = view.findViewById(w.h.card_root_view);
        this.bvU.bvZ = view.findViewById(w.h.top_line);
        this.bvU.bbV = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bvU.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bvU.bvG = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bvU.aRW = (TextView) view.findViewById(w.h.thread_title);
        this.bvU.bwa = (TextView) view.findViewById(w.h.fans_num);
        this.bvU.bwb = (TbImageView) view.findViewById(w.h.thread_image);
        this.bvU.bwc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bvU.bwd = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bvU.mRootView.setOnClickListener(this);
        this.bvU.bwc.setOnClickListener(this);
        this.bvU.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.bvU.bbV.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bvU.bbV.setDefaultResource(17170445);
        this.bvU.bbV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bvU.bbV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bvU.bwc.setShowPraiseNum(false);
        this.bvU.bwb.setDrawBorder(true);
        this.bvU.bwb.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.bvT = oVar;
        Ny();
    }

    private void Ny() {
        if (this.bvT == null || this.bvT.bck == null) {
            this.bvU.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData sp = this.bvT.Kn().sp();
        if (sp != null && sp.getvipV_url() != null && this.bvU.bbW != null) {
            if (this.bvU.bbX == null) {
                this.bvU.bbW.inflate();
                this.bvU.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.bvU.bbX.c(sp.getvipV_url(), 10, false);
            this.bvU.bbV.setIsBigV(true);
        }
        this.bvU.bbV.setData(this.bvT.bck);
        this.bvU.bbV.setAfterClickListener(this.bvV);
        this.bvU.bvG.setData(this.bvT.bck);
        this.bvU.bvG.setUserNameTextSizeRid(w.f.fontsize24);
        this.bvU.bvG.setUserAfterClickListener(this.bvV);
        Resources resources = this.ajU.getResources();
        String string = resources.getString(w.l.photo_live_tips);
        new SpannableStringBuilder(String.valueOf(string) + this.bvT.bck.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bvU.aRW.setText(e(this.bvT.bck.getTitle()));
        String fansNickName = this.bvT.bck.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bvU.bwa.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bvT.bck.getAuthor().getFansNum()));
        if (this.bvU.bwc.a(this.bvT.bck)) {
            this.bvU.bwd.setVisibility(8);
        } else {
            this.bvU.bwd.setVisibility(0);
        }
        this.bvU.bwc.setForumAfterClickListener(this.bvW);
        this.bvU.bwc.setStType(at.sf());
        this.bvU.bwc.setYuelaouLocate("feed#" + this.bvT.TX());
        if (this.bvU.buV != null && this.bvT.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.bvT.Kn().getTid());
            alVar.setFid(this.bvT.Kn().getFid());
            alVar.a(this.bvT.WU);
            this.bvU.buV.setData(alVar);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.q.po().pu() && this.bvT.bck.getPhotoLiveCover() != null && this.bvT.bck.getPhotoLiveCover().length() != 0) {
            this.bvU.bwb.setVisibility(0);
            this.bvU.bwb.c(this.bvT.bck.getPhotoLiveCover(), 10, false);
        } else {
            this.bvU.bwb.setVisibility(8);
        }
        com.baidu.tbadk.core.util.aq.c(this.bvU.bwa, w.e.cp_cont_d, 1);
        if (at.ia(this.bvT.bck.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.bvU.aRW, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.bvU.aRW, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvU.mRootView || view == this.bvU.bwc.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bvU.mRootView, this.bvT);
            }
            TT();
        }
    }

    public void TS() {
        this.bvU.buV = new com.baidu.tbadk.core.view.o(this.ajU);
        this.bvU.buV.wQ();
        this.bvU.bwc.addView(this.bvU.buV);
        if (this.bvU.bwc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvU.bwc.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvU.bwc.setLayoutParams(layoutParams);
        }
    }

    private void TT() {
        if (this.bvT != null && this.bvT.bck != null) {
            at.hZ(this.bvT.bck.getId());
            if (!TU()) {
                UtilHelper.showToast(this.ajU.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajU.getPageActivity(), this.bvT.bck.getTid()).ci(this.bvT.bck.sE()).cl(this.bvT.TY()).cj(at.sf()).pE()));
            ib(this.bvT.bck.getTid());
        }
    }

    public void ib(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bvU.mRootView);
            this.bvU.bvG.onChangeSkinType();
            this.bvU.bwc.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.bvU.bvZ, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bvU.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bvU.buV != null) {
                this.bvU.buV.onChangeSkinType();
            }
            if (this.bvU.buD != null) {
                this.bvU.buD.onChangeSkinType();
            }
        }
    }

    private boolean TU() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.buW != null) {
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajU.getResources().getString(w.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajU.getPageActivity(), com.baidu.tbadk.core.util.aq.cO(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bvU == null || this.bvU.buV == null) {
            return;
        }
        this.bvU.buV.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRW;
        public ClickableHeaderImageView bbV;
        public ViewStub bbW;
        public TbImageView bbX;
        public CardGroupDividerView buD;
        private com.baidu.tbadk.core.view.o buV = null;
        public UserIconLayout bvG;
        public View bvZ;
        public TextView bwa;
        public TbImageView bwb;
        public ThreadCommentAndPraiseInfoLayout bwc;
        public View bwd;
        public View mRootView;

        public a() {
        }
    }
}

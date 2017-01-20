package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> FY;
    private CustomMessageListener blR;
    private com.baidu.tieba.card.data.o bmO;
    public a bmP;
    private View.OnClickListener bmQ;
    private View.OnClickListener bmR;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bmQ = new bl(this);
        this.bmR = new bm(this);
        this.blR = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.FY = tbPageContext;
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.bmP = new a();
        this.bmP.mRootView = view.findViewById(r.h.card_root_view);
        this.bmP.bmU = view.findViewById(r.h.top_line);
        this.bmP.aUT = (ClickableHeaderImageView) view.findViewById(r.h.avatar);
        this.bmP.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.bmP.bmB = (UserIconLayout) view.findViewById(r.h.user_icon);
        this.bmP.aLR = (TextView) view.findViewById(r.h.thread_title);
        this.bmP.bmV = (TextView) view.findViewById(r.h.fans_num);
        this.bmP.bmW = (TbImageView) view.findViewById(r.h.thread_image);
        this.bmP.bmX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.thread_more_info);
        this.bmP.bmY = view.findViewById(r.h.divider_below_reply_number_layout);
        this.bmP.mRootView.setOnClickListener(this);
        this.bmP.bmX.setOnClickListener(this);
        this.bmP.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
    }

    private void initUI() {
        this.bmP.aUT.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.bmP.aUT.setDefaultResource(17170445);
        this.bmP.aUT.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bmP.aUT.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bmP.bmX.setShowPraiseNum(false);
        this.bmP.bmW.setDrawBorder(true);
        this.bmP.bmW.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.bmO = oVar;
        Mf();
    }

    private void Mf() {
        if (this.bmO == null || this.bmO.aVi == null) {
            this.bmP.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rx = this.bmO.Ji().rx();
        if (rx != null && rx.getvipV_url() != null && this.bmP.aUU != null) {
            if (this.bmP.aUV == null) {
                this.bmP.aUU.inflate();
                this.bmP.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
            }
            this.bmP.aUV.c(rx.getvipV_url(), 10, false);
            this.bmP.aUT.setIsBigV(true);
        }
        this.bmP.aUT.setData(this.bmO.aVi);
        this.bmP.aUT.setAfterClickListener(this.bmQ);
        this.bmP.bmB.setData(this.bmO.aVi);
        this.bmP.bmB.setUserNameTextSizeRid(r.f.fontsize24);
        this.bmP.bmB.setUserAfterClickListener(this.bmQ);
        Resources resources = this.FY.getResources();
        String string = resources.getString(r.l.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.bmO.aVi.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bmP.aLR.setText(e(this.bmO.aVi.getTitle()));
        String fansNickName = this.bmO.aVi.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.l.fans_default_name);
        }
        this.bmP.bmV.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.at.u(this.bmO.aVi.getAuthor().getFansNum()));
        if (this.bmP.bmX.a(this.bmO.aVi)) {
            this.bmP.bmY.setVisibility(8);
        } else {
            this.bmP.bmY.setVisibility(0);
        }
        this.bmP.bmX.setForumAfterClickListener(this.bmR);
        this.bmP.bmX.setStType(at.Mt());
        this.bmP.bmX.setYuelaouLocate("feed#" + this.bmO.Rz());
        if (this.bmP.blU != null) {
            this.bmP.blU.setData(this.bmO);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oC().oI() && this.bmO.aVi.getPhotoLiveCover() != null && this.bmO.aVi.getPhotoLiveCover().length() != 0) {
            this.bmP.bmW.setVisibility(0);
            this.bmP.bmW.c(this.bmO.aVi.getPhotoLiveCover(), 10, false);
        } else {
            this.bmP.bmW.setVisibility(8);
        }
        com.baidu.tbadk.core.util.ap.c(this.bmP.bmV, r.e.cp_cont_d, 1);
        if (at.m13if(this.bmO.aVi.getId())) {
            com.baidu.tbadk.core.util.ap.c(this.bmP.aLR, r.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ap.c(this.bmP.aLR, r.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmP.mRootView || view == this.bmP.bmX.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bmP.mRootView, this.bmO);
            }
            Rv();
        }
    }

    public void Ru() {
        this.bmP.blU = new com.baidu.tbadk.core.view.o(this.FY);
        this.bmP.blU.vX();
        this.bmP.bmX.addView(this.bmP.blU);
        this.bmP.blU.vY();
    }

    private void Rv() {
        if (this.bmO != null && this.bmO.aVi != null) {
            at.ie(this.bmO.aVi.getId());
            if (!Rw()) {
                UtilHelper.showToast(this.FY.getPageActivity(), r.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.FY.getPageActivity(), this.bmO.aVi.getTid()).ci(this.bmO.aVi.rM()).cl(this.bmO.RA()).cj(at.Mt()).oS()));
            ig(this.bmO.aVi.getTid());
        }
    }

    public void ig(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bmP.mRootView);
            this.bmP.bmB.tg();
            this.bmP.bmX.tg();
            com.baidu.tbadk.core.util.ap.k(this.bmP.bmU, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.j(this.bmP.mRootView, r.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bmP.blU != null) {
                this.bmP.blU.tg();
            }
            if (this.bmP.blz != null) {
                this.bmP.blz.tg();
            }
        }
    }

    private boolean Rw() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.blR != null) {
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.FY.getResources().getString(r.l.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.FY.getPageActivity(), com.baidu.tbadk.core.util.ap.cP(r.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bmP == null || this.bmP.blU == null) {
            return;
        }
        this.bmP.blU.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aLR;
        public ClickableHeaderImageView aUT;
        public ViewStub aUU;
        public TbImageView aUV;
        private com.baidu.tbadk.core.view.o blU = null;
        public CardGroupDividerView blz;
        public UserIconLayout bmB;
        public View bmU;
        public TextView bmV;
        public TbImageView bmW;
        public ThreadCommentAndPraiseInfoLayout bmX;
        public View bmY;
        public View mRootView;

        public a() {
        }
    }
}

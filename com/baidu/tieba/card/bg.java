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
public class bg extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> GO;
    private com.baidu.tieba.card.data.n bcZ;
    private CustomMessageListener bct;
    public a bda;
    private View.OnClickListener bdb;
    private View.OnClickListener bdc;

    public bg(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdb = new bh(this);
        this.bdc = new bi(this);
        this.bct = new bj(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GO = tbPageContext;
        S(getView());
        initUI();
    }

    private void S(View view) {
        this.bda = new a();
        this.bda.mRootView = view.findViewById(r.g.card_root_view);
        this.bda.bdf = view.findViewById(r.g.top_line);
        this.bda.bbY = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.bda.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bda.bcM = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.bda.aMQ = (TextView) view.findViewById(r.g.thread_title);
        this.bda.bdg = (TextView) view.findViewById(r.g.fans_num);
        this.bda.bdh = (TbImageView) view.findViewById(r.g.thread_image);
        this.bda.bdi = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.bda.bdj = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bda.mRootView.setOnClickListener(this);
        this.bda.bdi.setOnClickListener(this);
        this.bda.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
    }

    private void initUI() {
        this.bda.bbY.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bda.bbY.setDefaultResource(17170445);
        this.bda.bbY.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bda.bbY.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bda.bdi.setShowPraiseNum(false);
        this.bda.bdh.setDrawBorder(true);
        this.bda.bdh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        this.bcZ = nVar;
        Ox();
    }

    private void Ox() {
        if (this.bcZ == null || this.bcZ.beB == null) {
            this.bda.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rF = this.bcZ.IU().rF();
        if (rF != null && rF.getvipV_url() != null && this.bda.baW != null) {
            if (this.bda.baX == null) {
                this.bda.baW.inflate();
                this.bda.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
            }
            this.bda.baX.c(rF.getvipV_url(), 10, false);
            this.bda.bbY.setIsBigV(true);
        }
        this.bda.bbY.setData(this.bcZ.beB);
        this.bda.bbY.setAfterClickListener(this.bdb);
        this.bda.bcM.setData(this.bcZ.beB);
        this.bda.bcM.setUserNameTextSizeRid(r.e.fontsize24);
        this.bda.bcM.setUserAfterClickListener(this.bdb);
        Resources resources = this.GO.getResources();
        String string = resources.getString(r.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.bcZ.beB.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        this.bda.aMQ.setText(e(this.bcZ.beB.getTitle()));
        String fansNickName = this.bcZ.beB.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.bda.bdg.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.av.v(this.bcZ.beB.getAuthor().getFansNum()));
        if (this.bda.bdi.a(this.bcZ.beB)) {
            this.bda.bdj.setVisibility(8);
        } else {
            this.bda.bdj.setVisibility(0);
        }
        this.bda.bdi.setForumAfterClickListener(this.bdc);
        this.bda.bdi.setStType(ap.OB());
        this.bda.bdi.setYuelaouLocate("feed#" + this.bcZ.OJ());
        if (this.bda.bce != null) {
            this.bda.bce.setData(this.bcZ);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oJ().oP() && this.bcZ.beB.getPhotoLiveCover() != null && this.bcZ.beB.getPhotoLiveCover().length() != 0) {
            this.bda.bdh.setVisibility(0);
            this.bda.bdh.c(this.bcZ.beB.getPhotoLiveCover(), 10, false);
        } else {
            this.bda.bdh.setVisibility(8);
        }
        com.baidu.tbadk.core.util.ar.c(this.bda.bdg, r.d.cp_cont_d, 1);
        if (ap.hM(this.bcZ.beB.getId())) {
            com.baidu.tbadk.core.util.ar.c(this.bda.aMQ, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ar.c(this.bda.aMQ, r.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bda.mRootView || view == this.bda.bdi.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bda.mRootView, this.bcZ);
            }
            OF();
        }
    }

    public void OE() {
        this.bda.bce = new com.baidu.tbadk.core.view.o(this.GO.getPageActivity());
        this.bda.bce.wd();
        this.bda.bdi.addView(this.bda.bce);
    }

    private void OF() {
        if (this.bcZ != null && this.bcZ.beB != null) {
            ap.hL(this.bcZ.beB.getId());
            if (!OG()) {
                UtilHelper.showToast(this.GO.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.bcZ.beB.getTid()).ck(this.bcZ.beB.rV()).cn(this.bcZ.OK()).cl(ap.OB()).oZ()));
            hN(this.bcZ.beB.getTid());
        }
    }

    public void hN(String str) {
        new Handler().postDelayed(new bk(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bda.mRootView);
            this.bda.bcM.tm();
            this.bda.bdi.tm();
            com.baidu.tbadk.core.util.ar.l(this.bda.bdf, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.k(this.bda.mRootView, r.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bda.bce != null) {
                this.bda.bce.tm();
            }
            if (this.bda.bbM != null) {
                this.bda.bbM.tm();
            }
        }
    }

    private boolean OG() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bct != null) {
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GO.getResources().getString(r.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.GO.getPageActivity(), com.baidu.tbadk.core.util.ar.cQ(r.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bda == null || this.bda.bce == null) {
            return;
        }
        this.bda.bce.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aMQ;
        public ViewStub baW;
        public TbImageView baX;
        public CardGroupDividerView bbM;
        public ClickableHeaderImageView bbY;
        public UserIconLayout bcM;
        private com.baidu.tbadk.core.view.o bce = null;
        public View bdf;
        public TextView bdg;
        public TbImageView bdh;
        public ThreadCommentAndPraiseInfoLayout bdi;
        public View bdj;
        public View mRootView;

        public a() {
        }
    }
}

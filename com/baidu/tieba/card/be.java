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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class be extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> GO;
    private com.baidu.tieba.card.data.n bdH;
    public a bdI;
    private View.OnClickListener bdJ;
    private View.OnClickListener bdK;
    private CustomMessageListener bdb;

    public be(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdJ = new bf(this);
        this.bdK = new bg(this);
        this.bdb = new bh(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GO = tbPageContext;
        S(getView());
        initUI();
    }

    private void S(View view) {
        this.bdI = new a();
        this.bdI.mRootView = view.findViewById(r.g.card_root_view);
        this.bdI.bdN = view.findViewById(r.g.top_line);
        this.bdI.bcF = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.bdI.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bdI.bdu = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.bdI.aNz = (TextView) view.findViewById(r.g.thread_title);
        this.bdI.bdO = (TextView) view.findViewById(r.g.fans_num);
        this.bdI.bdP = (TbImageView) view.findViewById(r.g.thread_image);
        this.bdI.bdQ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.bdI.bdR = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bdI.mRootView.setOnClickListener(this);
        this.bdI.bdQ.setOnClickListener(this);
    }

    private void initUI() {
        this.bdI.bcF.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bdI.bcF.setDefaultResource(17170445);
        this.bdI.bcF.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bdI.bcF.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bdI.bdQ.setShowPraiseNum(false);
        this.bdI.bdP.setDrawBorder(true);
        this.bdI.bdP.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        this.bdH = nVar;
        Pb();
    }

    private void Pb() {
        if (this.bdH == null || this.bdH.beS == null) {
            this.bdI.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rQ = this.bdH.Jz().rQ();
        if (rQ != null && rQ.getvipV_url() != null && this.bdI.bbQ != null) {
            if (this.bdI.bbR == null) {
                this.bdI.bbQ.inflate();
                this.bdI.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
            }
            this.bdI.bbR.c(rQ.getvipV_url(), 10, false);
            this.bdI.bcF.setIsBigV(true);
        }
        this.bdI.bcF.setData(this.bdH.beS);
        this.bdI.bcF.setAfterClickListener(this.bdJ);
        this.bdI.bdu.setData(this.bdH.beS);
        this.bdI.bdu.setUserNameTextSizeRid(r.e.fontsize24);
        this.bdI.bdu.setUserAfterClickListener(this.bdJ);
        Resources resources = this.GO.getResources();
        String string = resources.getString(r.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.bdH.beS.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        this.bdI.aNz.setText(e(this.bdH.beS.getTitle()));
        String fansNickName = this.bdH.beS.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.bdI.bdO.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ax.v(this.bdH.beS.getAuthor().getFansNum()));
        if (this.bdI.bdQ.a(this.bdH.beS)) {
            this.bdI.bdR.setVisibility(8);
        } else {
            this.bdI.bdR.setVisibility(0);
        }
        this.bdI.bdQ.setForumAfterClickListener(this.bdK);
        this.bdI.bdQ.setStType(an.Pf());
        this.bdI.bdQ.setYuelaouLocate("feed#" + this.bdH.Pn());
        if (this.bdI.bcL != null) {
            this.bdI.bcL.setData(this.bdH);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oJ().oP() && this.bdH.beS.getPhotoLiveCover() != null && this.bdH.beS.getPhotoLiveCover().length() != 0) {
            this.bdI.bdP.setVisibility(0);
            this.bdI.bdP.c(this.bdH.beS.getPhotoLiveCover(), 10, false);
        } else {
            this.bdI.bdP.setVisibility(8);
        }
        com.baidu.tbadk.core.util.at.c(this.bdI.bdO, r.d.cp_cont_d, 1);
        if (an.hS(this.bdH.beS.getId())) {
            com.baidu.tbadk.core.util.at.c(this.bdI.aNz, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.c(this.bdI.aNz, r.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdI.mRootView || view == this.bdI.bdQ.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bdI.mRootView, this.bdH);
            }
            Pj();
        }
    }

    public void Pi() {
        this.bdI.bcL = new com.baidu.tbadk.core.view.o(this.GO.getPageActivity());
        this.bdI.bcL.wt();
        this.bdI.bdQ.addView(this.bdI.bcL);
    }

    private void Pj() {
        if (this.bdH != null && this.bdH.beS != null) {
            an.hR(this.bdH.beS.getId());
            if (!Pk()) {
                UtilHelper.showToast(this.GO.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.bdH.beS.getTid()).cj(this.bdH.beS.se()).cm(this.bdH.Po()).ck(an.Pf()).oZ()));
            hT(this.bdH.beS.getTid());
        }
    }

    public void hT(String str) {
        new Handler().postDelayed(new bi(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bdI.mRootView);
            this.bdI.bdu.tB();
            this.bdI.bdQ.tB();
            com.baidu.tbadk.core.util.at.l(this.bdI.bdN, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.bdI.mRootView, r.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bdI.bcL == null) {
                return;
            }
            this.bdI.bcL.tB();
        }
    }

    private boolean Pk() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bdb != null) {
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GO.getResources().getString(r.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.GO.getPageActivity(), com.baidu.tbadk.core.util.at.cO(r.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bdI == null || this.bdI.bcL == null) {
            return;
        }
        this.bdI.bcL.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aNz;
        public ViewStub bbQ;
        public TbImageView bbR;
        public ClickableHeaderImageView bcF;
        private com.baidu.tbadk.core.view.o bcL = null;
        public View bdN;
        public TextView bdO;
        public TbImageView bdP;
        public ThreadCommentAndPraiseInfoLayout bdQ;
        public View bdR;
        public UserIconLayout bdu;
        public View mRootView;

        public a() {
        }
    }
}

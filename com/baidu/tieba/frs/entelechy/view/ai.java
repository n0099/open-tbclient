package com.baidu.tieba.frs.entelechy.view;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.aw> {
    private TbPageContext<?> ajr;
    private int avA;
    private int avB;
    private int avC;
    private int avD;
    private int avE;
    private int avF;
    private int avj;
    private ArrayList<Integer> avk;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private com.baidu.tbadk.core.data.aw bTM;
    public a bTN;
    private com.baidu.tieba.frs.e.ae bTy;
    private CustomMessageListener buT;
    private View.OnClickListener bvX;
    private View.OnClickListener bvY;

    public ai(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.avk = new ArrayList<>();
        this.avj = 0;
        this.bvX = new aj(this);
        this.bvY = new ak(this);
        this.buT = new al(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        setTag(bdUniqueId);
        this.ajr = tbPageContext;
        this.avv = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.avw = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.avx = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.avy = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.avz = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.avA = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.avB = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.avC = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.avD = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.avE = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.avF = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.bTN = new a();
        this.bTN.mRootView = view.findViewById(w.h.card_root_view);
        this.bTN.bTP = view.findViewById(w.h.top_line);
        this.bTN.bTQ = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.bTN.bTS = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bTN.bTR = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.bTN.amh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bTN.bcs = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.bTN.bvQ = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bTN.aSr = (TextView) view.findViewById(w.h.thread_title);
        this.bTN.bTT = (TextView) view.findViewById(w.h.thread_context);
        this.bTN.bTU = (TextView) view.findViewById(w.h.fans_num);
        this.bTN.bwb = (TbImageView) view.findViewById(w.h.thread_image);
        this.bTN.bwb.setPageId(getTag());
        this.bTN.bTV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bTN.bwd = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bTN.bTW = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.bTN.bTX = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.bTN.bTY = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.bTN.bQf = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.bTN.bQf.setPageId(getTag());
        this.bTN.bct = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.bTN.bTV.setCommentNumClickListener(this);
        this.bTN.buA = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bTN.buA.setTitleClickListener(this);
        this.bTN.bTV.setViewNumEnabled(true);
        this.bTy = new com.baidu.tieba.frs.e.ae(this.ajr, this.bTN.bTV);
        this.bTy.setUniqueId(getTag());
    }

    private void initUI() {
        this.bTN.bTS.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        this.bTN.bTS.setDefaultResource(17170445);
        this.bTN.bTS.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTN.bTS.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTN.bTR.vY();
        this.bTN.bTR.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        this.bTN.bTR.getHeadView().setDefaultResource(17170445);
        this.bTN.bTR.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTN.bTR.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTN.bTR.getHeadView().setIsRound(true);
        this.bTN.bTR.getHeadView().setDrawBorder(false);
        this.bTN.bTR.getPendantView().setIsRound(true);
        this.bTN.bTR.getPendantView().setDrawBorder(false);
        this.bTN.bTV.setShowPraiseNum(false);
        this.bTN.bwb.setDrawBorder(true);
        this.bTN.bwb.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.aw awVar) {
        this.bTM = awVar;
        MM();
    }

    private void MM() {
        boolean z;
        if (this.bTM == null) {
            this.bTN.mRootView.setVisibility(8);
            return;
        }
        if (this.bTM.getAuthor() == null || this.bTM.getAuthor().getPendantData() == null || StringUtils.isNull(this.bTM.getAuthor().getPendantData().pT())) {
            if (this.bTM.getAuthor() != null && this.bTM.getAuthor().getGodUserData() != null && this.bTM.getAuthor().getGodUserData().getType() == 2) {
                this.bTN.bTS.setGodIconMargin(0);
            } else {
                this.bTN.bTS.setIsGod(false);
            }
            UserTbVipInfoData rz = this.bTM.rz();
            if (rz != null && rz.getvipV_url() != null) {
                if (this.bTN.amh != null) {
                    if (this.bTN.ami == null) {
                        this.bTN.amh.inflate();
                        this.bTN.ami = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bTN.ami.setPageId(getTag());
                    this.bTN.ami.setVisibility(0);
                    this.bTN.ami.c(rz.getvipV_url(), 10, false);
                    this.bTN.bTS.setIsBigV(true);
                }
            } else {
                this.bTN.bTS.setIsBigV(false);
                if (this.bTN.ami != null) {
                    this.bTN.ami.setVisibility(8);
                }
            }
            this.bTN.bTS.setData(this.bTM);
            this.bTN.bTS.setAfterClickListener(this.bvX);
            this.bTN.bTS.setVisibility(0);
            this.bTN.bTR.setVisibility(8);
        } else {
            this.bTN.bTS.setIsGod(false);
            this.bTN.bTS.setIsBigV(false);
            if (this.bTN.ami != null) {
                this.bTN.ami.setVisibility(8);
            }
            this.bTN.bTS.setVisibility(4);
            this.bTN.bTR.setVisibility(0);
            this.bTN.bTR.setData(this.bTM);
        }
        if (this.bTM.getAuthor() != null && !StringUtils.isNull(this.bTM.getAuthor().getSealPrefix())) {
            this.bTN.bvQ.aP(true);
        }
        this.bTN.bvQ.setData(this.bTM);
        this.bTN.bvQ.setUserNameTextSizeRid(w.f.fontsize24);
        this.bTN.bvQ.setUserAfterClickListener(this.bvX);
        this.bTN.bvQ.setPageName(1);
        Resources resources = this.ajr.getResources();
        if (!StringUtils.isNull(this.bTM.getTitle())) {
            int length = this.bTM.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bTM.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bTN.aSr.setSingleLine(true);
        } else {
            this.bTN.aSr.setMaxLines(2);
        }
        this.bTM.e(false, true);
        this.bTN.aSr.setText(this.bTM.rY());
        String fansNickName = this.bTM.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bTN.bTU.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bTM.getAuthor().getFansNum()));
        if (this.bTN.bTV.a(this.bTM)) {
            this.bTN.bwd.setVisibility(8);
        } else {
            this.bTN.bwd.setVisibility(0);
        }
        this.bTN.bTV.setForumAfterClickListener(this.bvY);
        this.bTN.bTV.setStType(com.baidu.tieba.card.ap.rp());
        w(this.bTM);
        this.bTy.F(this.bTM);
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oV().pb() && this.bTM.getPhotoLiveCover() != null && this.bTM.getPhotoLiveCover().length() != 0) {
            this.bTN.bwb.setVisibility(0);
            this.bTN.bTT.setVisibility(8);
            this.bTN.bwb.c(this.bTM.getPhotoLiveCover(), 10, false);
            b(this.bTM);
        } else {
            this.bTN.bwb.setVisibility(8);
            this.bTN.bTW.setVisibility(8);
            this.bTN.bTX.setVisibility(8);
            this.bTN.bTY.setVisibility(8);
            String rG = this.bTM.rG();
            this.bTN.bTT.setText(rG);
            this.bTN.bTT.setVisibility(StringUtils.isNull(rG) ? 8 : 0);
        }
        p.a(this.bTM, this.bTN.buA);
        com.baidu.tbadk.core.util.aq.c(this.bTN.bTU, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.ap.hZ(this.bTM.getTid())) {
            com.baidu.tbadk.core.util.aq.c(this.bTN.aSr, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bTN.bTT, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.bTN.aSr, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.bTN.bTT, w.e.cp_cont_j, 1);
    }

    private void w(bk bkVar) {
        MetaData author;
        if (bkVar != null && (author = bkVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rT = bkVar.rT();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bTN.bTS.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bTN.bcs.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bTN.bQf.setVisibility(8);
                if (this.bTN.bct != null) {
                    if (rT != null) {
                        this.bTN.bct.a(this.ajr, rT, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bkVar.getFid()), bkVar.rD(), bkVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds16);
                    } else {
                        this.bTN.bct.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bTN.bQf.setVisibility(0);
                this.bTN.bQf.setImageBitmap(null);
                this.bTN.bQf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bTN.bQf.setOnClickListener(new am(this, themeCard));
                this.bTN.bct.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds30);
            }
            this.bTN.bTS.setLayoutParams(layoutParams);
            this.bTN.bcs.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTN != null) {
            if (view == this.bTN.mRootView || view == this.bTN.bTV.getCommentNumView() || view == this.bTN.buA) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bTN.mRootView, this.bTM);
                }
                Tl();
            }
        }
    }

    private void Tl() {
        PhotoLiveActivityConfig pl;
        if (this.bTM != null) {
            com.baidu.tieba.card.ap.hY(this.bTM.getTid());
            if (!Tm()) {
                UtilHelper.showToast(this.ajr.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.bTM.rU() > 0 && com.baidu.tieba.tbadkCore.util.s.bhK()) {
                pl = new PhotoLiveActivityConfig.a(this.ajr.getPageActivity(), this.bTM.getTid()).ck("from_frs").bz(18003).ci(String.valueOf(this.bTM.rU())).pl();
            } else {
                pl = new PhotoLiveActivityConfig.a(this.ajr.getPageActivity(), this.bTM.getTid()).ck("from_frs").bz(18003).pl();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pl));
            ia(this.bTM.getTid());
        }
    }

    public void ia(String str) {
        new Handler().postDelayed(new an(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bTN.mRootView);
            this.bTN.bvQ.onChangeSkinType();
            this.bTN.bTV.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.bTN.bTP, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bTN.mRootView, w.g.addresslist_item_bg);
            if (this.bTN.buA != null) {
                this.bTN.buA.onChangeSkinType();
            }
            this.bTy.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean Tm() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.buT != null) {
            this.buT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buT);
        }
    }

    private void b(com.baidu.tbadk.core.data.aw awVar) {
        this.avk.clear();
        AV();
        if (awVar != null && awVar.rR() != null) {
            int size = awVar.rR().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = awVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, awVar.rR(), i);
                }
            }
            AU();
        }
    }

    private void AV() {
        this.bTN.bTW.setText("");
        this.bTN.bTX.setText("");
        this.bTN.bTY.setText("");
        if (this.bTN.bTW.getVisibility() == 8) {
            this.bTN.bTW.setVisibility(0);
        }
        if (this.bTN.bTX.getVisibility() == 8) {
            this.bTN.bTX.setVisibility(0);
        }
        if (this.bTN.bTY.getVisibility() == 8) {
            this.bTN.bTY.setVisibility(0);
        }
        this.avk.add(Integer.valueOf(this.bTN.bTW.getId()));
        this.avk.add(Integer.valueOf(this.bTN.bTX.getId()));
        this.avk.add(Integer.valueOf(this.bTN.bTY.getId()));
    }

    private void AU() {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i = 0; i < size; i++) {
                if (this.avk.get(i).intValue() == this.bTN.bTW.getId()) {
                    this.bTN.bTW.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.bTN.bTX.getId()) {
                    this.bTN.bTX.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.bTN.bTY.getId()) {
                    this.bTN.bTY.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avj) {
                case 0:
                    a(this.avv, this.avw, this.bTN.bTW);
                    a(this.avx, this.avy, this.bTN.bTX);
                    a(this.avz, this.avA, this.bTN.bTY);
                    break;
                case 1:
                    a(this.avA, this.avB, this.bTN.bTW);
                    a(this.avC, this.avA, this.bTN.bTX);
                    a(this.avD, this.avy, this.bTN.bTY);
                    break;
                case 2:
                    a(this.avA, this.avE, this.bTN.bTW);
                    a(this.avF, this.avA, this.bTN.bTX);
                    a(this.avD, this.avy, this.bTN.bTY);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bTN.bTW);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bTN.bTX);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bTN.bTY);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AH())));
            eg(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void eg(int i) {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avk.get(i2).intValue() == i) {
                    this.avk.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aSr;
        public ViewStub amh;
        public TbImageView ami;
        public TbImageView bQf;
        public View bTP;
        public RelativeLayout bTQ;
        public HeadPendantClickableView bTR;
        public ClickableHeaderImageView bTS;
        public TextView bTT;
        public TextView bTU;
        public ThreadCommentAndPraiseInfoLayout bTV;
        public TextView bTW;
        public TextView bTX;
        public TextView bTY;
        public LinearLayout bcs;
        public ThreadSkinView bct;
        public CardGroupDividerView buA;
        public UserIconLayout bvQ;
        public TbImageView bwb;
        public View bwd;
        public View mRootView;

        public a() {
        }
    }
}

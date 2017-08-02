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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<ax> {
    private TbPageContext<?> ako;
    private int awO;
    private ArrayList<Integer> awP;
    private int axa;
    private int axb;
    private int axc;
    private int axd;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private CustomMessageListener bFA;
    private View.OnClickListener bGH;
    private View.OnClickListener bGI;
    private ax cnK;
    public a cnL;
    private com.baidu.tieba.frs.h.g cnw;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.awP = new ArrayList<>();
        this.awO = 0;
        this.bGH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.VZ() != null) {
                    h.this.VZ().a(view, h.this.cnK);
                }
            }
        };
        this.bGI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.VZ() != null) {
                    h.this.VZ().a(view, h.this.cnK);
                }
            }
        };
        this.bFA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cnK != null && h.this.cnK != null && h.this.cnK.getTid() != null && h.this.cnL != null && h.this.cnL.bEn != null && h.this.cnL.cnS != null && ((String) customResponsedMessage.getData()).equals(h.this.cnK.getTid())) {
                    m.a(h.this.cnL.bEn, h.this.cnK.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cnL.cnS, h.this.cnK.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.ako = tbPageContext;
        this.axa = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.axb = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.axc = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.axd = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.axe = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.axf = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.axg = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.axh = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.axi = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.axj = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.axk = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.cnL = new a();
        this.cnL.mRootView = view.findViewById(d.h.card_root_view);
        this.cnL.cnN = view.findViewById(d.h.top_line);
        this.cnL.cnO = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cnL.cnQ = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cnL.cnP = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cnL.anA = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cnL.bjT = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cnL.bGA = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cnL.bEn = (TextView) view.findViewById(d.h.thread_title);
        this.cnL.cnR = (TextView) view.findViewById(d.h.thread_context);
        this.cnL.cnS = (TextView) view.findViewById(d.h.fans_num);
        this.cnL.bGL = (TbImageView) view.findViewById(d.h.thread_image);
        this.cnL.bGL.setPageId(getTag());
        this.cnL.cnT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cnL.bGN = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cnL.cnU = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cnL.cnV = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cnL.cnW = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cnL.cjQ = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cnL.cjQ.setPageId(getTag());
        this.cnL.bjU = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cnL.cnT.setCommentNumClickListener(this);
        this.cnL.bFn = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cnL.bFn.setTitleClickListener(this);
        this.cnL.cnT.setViewNumEnabled(true);
        this.cnw = new com.baidu.tieba.frs.h.g(this.ako, this.cnL.cnT);
        this.cnw.setUniqueId(getTag());
    }

    private void initUI() {
        this.cnL.cnQ.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        this.cnL.cnQ.setDefaultResource(17170445);
        this.cnL.cnQ.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cnL.cnQ.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cnL.cnP.wt();
        this.cnL.cnP.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        this.cnL.cnP.getHeadView().setDefaultResource(17170445);
        this.cnL.cnP.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cnL.cnP.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cnL.cnP.getHeadView().setIsRound(true);
        this.cnL.cnP.getHeadView().setDrawBorder(false);
        this.cnL.cnP.getPendantView().setIsRound(true);
        this.cnL.cnP.getPendantView().setDrawBorder(false);
        this.cnL.cnT.setShowPraiseNum(false);
        this.cnL.bGL.setDrawBorder(true);
        this.cnL.bGL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.cnK = axVar;
        Ot();
    }

    private void Ot() {
        boolean z;
        if (this.cnK == null) {
            this.cnL.mRootView.setVisibility(8);
            return;
        }
        if (this.cnK.getAuthor() == null || this.cnK.getAuthor().getPendantData() == null || StringUtils.isNull(this.cnK.getAuthor().getPendantData().pL())) {
            if (this.cnK.getAuthor() != null && this.cnK.getAuthor().getGodUserData() != null && this.cnK.getAuthor().getGodUserData().getType() == 2) {
                this.cnL.cnQ.setGodIconMargin(0);
            } else {
                this.cnL.cnQ.setIsGod(false);
            }
            UserTbVipInfoData rv = this.cnK.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.cnL.anA != null) {
                    if (this.cnL.anB == null) {
                        this.cnL.anA.inflate();
                        this.cnL.anB = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cnL.anB.setPageId(getTag());
                    this.cnL.anB.setVisibility(0);
                    this.cnL.anB.c(rv.getvipV_url(), 10, false);
                    this.cnL.cnQ.setIsBigV(true);
                }
            } else {
                this.cnL.cnQ.setIsBigV(false);
                if (this.cnL.anB != null) {
                    this.cnL.anB.setVisibility(8);
                }
            }
            this.cnL.cnQ.setData(this.cnK);
            this.cnL.cnQ.setAfterClickListener(this.bGH);
            this.cnL.cnQ.setVisibility(0);
            this.cnL.cnP.setVisibility(8);
        } else {
            this.cnL.cnQ.setIsGod(false);
            this.cnL.cnQ.setIsBigV(false);
            if (this.cnL.anB != null) {
                this.cnL.anB.setVisibility(8);
            }
            this.cnL.cnQ.setVisibility(4);
            this.cnL.cnP.setVisibility(0);
            this.cnL.cnP.setData(this.cnK);
        }
        if (this.cnK.getAuthor() != null && !StringUtils.isNull(this.cnK.getAuthor().getSealPrefix())) {
            this.cnL.bGA.aP(true);
        }
        this.cnL.bGA.setData(this.cnK);
        this.cnL.bGA.setUserNameTextSizeRid(d.f.fontsize24);
        this.cnL.bGA.setUserAfterClickListener(this.bGH);
        this.cnL.bGA.setPageName(1);
        Resources resources = this.ako.getResources();
        if (!StringUtils.isNull(this.cnK.getTitle())) {
            int length = this.cnK.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cnK.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cnL.bEn.setSingleLine(true);
        } else {
            this.cnL.bEn.setMaxLines(2);
        }
        this.cnK.e(false, true);
        this.cnL.bEn.setText(this.cnK.rV());
        String fansNickName = this.cnK.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cnL.cnS.setText(fansNickName + ": " + al.u(this.cnK.getAuthor().getFansNum()));
        if (this.cnL.cnT.a(this.cnK)) {
            this.cnL.bGN.setVisibility(8);
        } else {
            this.cnL.bGN.setVisibility(0);
        }
        this.cnL.cnT.setForumAfterClickListener(this.bGI);
        this.cnL.cnT.setStType(m.rm());
        G(this.cnK);
        this.cnw.P(this.cnK);
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oN().oT() && this.cnK.getPhotoLiveCover() != null && this.cnK.getPhotoLiveCover().length() != 0) {
            this.cnL.bGL.setVisibility(0);
            this.cnL.cnR.setVisibility(8);
            this.cnL.bGL.c(this.cnK.getPhotoLiveCover(), 10, false);
            b(this.cnK);
        } else {
            this.cnL.bGL.setVisibility(8);
            this.cnL.cnU.setVisibility(8);
            this.cnL.cnV.setVisibility(8);
            this.cnL.cnW.setVisibility(8);
            String rD = this.cnK.rD();
            this.cnL.cnR.setText(rD);
            this.cnL.cnR.setVisibility(StringUtils.isNull(rD) ? 8 : 0);
        }
        b.a(this.cnK, this.cnL.bFn);
        ai.c(this.cnL.cnS, d.e.cp_cont_d, 1);
        if (m.iZ(this.cnK.getTid())) {
            ai.c(this.cnL.bEn, d.e.cp_cont_d, 1);
            ai.c(this.cnL.cnR, d.e.cp_cont_d, 1);
            return;
        }
        ai.c(this.cnL.bEn, d.e.cp_cont_b, 1);
        ai.c(this.cnL.cnR, d.e.cp_cont_j, 1);
    }

    private void G(bl blVar) {
        MetaData author;
        if (blVar != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rQ = blVar.rQ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cnL.cnQ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cnL.bjT.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cnL.cjQ.setVisibility(8);
                if (this.cnL.bjU != null) {
                    if (rQ != null) {
                        this.cnL.bjU.a(this.ako, rQ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rA(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds16);
                    } else {
                        this.cnL.bjU.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cnL.cjQ.setVisibility(0);
                this.cnL.cjQ.setImageBitmap(null);
                this.cnL.cjQ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cnL.cjQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.ako.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cnL.bjU.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds30);
            }
            this.cnL.cnQ.setLayoutParams(layoutParams);
            this.cnL.bjT.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cnL != null) {
            if (view == this.cnL.mRootView || view == this.cnL.cnT.getCommentNumView() || view == this.cnL.bFn) {
                if (VZ() != null) {
                    VZ().a(this.cnL.mRootView, this.cnK);
                }
                Wr();
            }
        }
    }

    private void Wr() {
        PhotoLiveActivityConfig pd;
        if (this.cnK != null) {
            m.iY(this.cnK.getTid());
            if (!Ws()) {
                UtilHelper.showToast(this.ako.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cnK.rR() > 0 && com.baidu.tieba.tbadkCore.util.g.btp()) {
                pd = new PhotoLiveActivityConfig.a(this.ako.getPageActivity(), this.cnK.getTid()).cv("from_frs").bz(18003).ct(String.valueOf(this.cnK.rR())).pd();
            } else {
                pd = new PhotoLiveActivityConfig.a(this.ako.getPageActivity(), this.cnK.getTid()).cv("from_frs").bz(18003).pd();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pd));
            ja(this.cnK.getTid());
        }
    }

    public void ja(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.o.a.a(tbPageContext, this.cnL.mRootView);
            this.cnL.bGA.onChangeSkinType();
            this.cnL.cnT.onChangeSkinType();
            ai.k(this.cnL.cnN, d.e.cp_bg_line_c);
            ai.j(this.cnL.mRootView, d.g.addresslist_item_bg);
            if (this.cnL.bFn != null) {
                this.cnL.bFn.onChangeSkinType();
            }
            this.cnw.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean Ws() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bFA != null) {
            this.bFA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bFA);
        }
    }

    private void b(ax axVar) {
        this.awP.clear();
        Bu();
        if (axVar != null && axVar.rO() != null) {
            int size = axVar.rO().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rO(), i);
                }
            }
            Bt();
        }
    }

    private void Bu() {
        this.cnL.cnU.setText("");
        this.cnL.cnV.setText("");
        this.cnL.cnW.setText("");
        if (this.cnL.cnU.getVisibility() == 8) {
            this.cnL.cnU.setVisibility(0);
        }
        if (this.cnL.cnV.getVisibility() == 8) {
            this.cnL.cnV.setVisibility(0);
        }
        if (this.cnL.cnW.getVisibility() == 8) {
            this.cnL.cnW.setVisibility(0);
        }
        this.awP.add(Integer.valueOf(this.cnL.cnU.getId()));
        this.awP.add(Integer.valueOf(this.cnL.cnV.getId()));
        this.awP.add(Integer.valueOf(this.cnL.cnW.getId()));
    }

    private void Bt() {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i = 0; i < size; i++) {
                if (this.awP.get(i).intValue() == this.cnL.cnU.getId()) {
                    this.cnL.cnU.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.cnL.cnV.getId()) {
                    this.cnL.cnV.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.cnL.cnW.getId()) {
                    this.cnL.cnW.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awO) {
                case 0:
                    a(this.axa, this.axb, this.cnL.cnU);
                    a(this.axc, this.axd, this.cnL.cnV);
                    a(this.axe, this.axf, this.cnL.cnW);
                    break;
                case 1:
                    a(this.axf, this.axg, this.cnL.cnU);
                    a(this.axh, this.axf, this.cnL.cnV);
                    a(this.axi, this.axd, this.cnL.cnW);
                    break;
                case 2:
                    a(this.axf, this.axj, this.cnL.cnU);
                    a(this.axk, this.axf, this.cnL.cnV);
                    a(this.axi, this.axd, this.cnL.cnW);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cnL.cnU);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cnL.cnV);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cnL.cnW);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bg())));
            el(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void el(int i) {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awP.get(i2).intValue() == i) {
                    this.awP.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anA;
        public TbImageView anB;
        public TextView bEn;
        public CardGroupDividerView bFn;
        public UserIconLayout bGA;
        public TbImageView bGL;
        public View bGN;
        public LinearLayout bjT;
        public ThreadSkinView bjU;
        public TbImageView cjQ;
        public View cnN;
        public RelativeLayout cnO;
        public HeadPendantClickableView cnP;
        public ClickableHeaderImageView cnQ;
        public TextView cnR;
        public TextView cnS;
        public ThreadCommentAndPraiseInfoLayout cnT;
        public TextView cnU;
        public TextView cnV;
        public TextView cnW;
        public View mRootView;

        public a() {
        }
    }
}

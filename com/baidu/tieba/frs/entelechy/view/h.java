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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<ar> {
    private int axB;
    private ArrayList<Integer> axC;
    private int axN;
    private int axO;
    private int axP;
    private int axQ;
    private int axR;
    private int axS;
    private int axT;
    private int axU;
    private int axV;
    private int axW;
    private int axX;
    private com.baidu.tieba.frs.g.g cOW;
    private ar cPr;
    public a cPs;
    private CustomMessageListener caj;
    private View.OnClickListener cbc;
    private View.OnClickListener cbd;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.axC = new ArrayList<>();
        this.axB = 0;
        this.cbc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abt() != null) {
                    h.this.abt().a(view, h.this.cPr);
                }
            }
        };
        this.cbd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abt() != null) {
                    h.this.abt().a(view, h.this.cPr);
                }
            }
        };
        this.caj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cPr != null && h.this.cPr != null && h.this.cPr.getTid() != null && h.this.cPs != null && h.this.cPs.bZY != null && h.this.cPs.cPz != null && ((String) customResponsedMessage.getData()).equals(h.this.cPr.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.cPs.bZY, h.this.cPr.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.cPs.cPz, h.this.cPr.getId(), d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.axN = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.axO = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.axP = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.axQ = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.axR = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.axS = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.axT = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.axU = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.axV = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.axW = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.axX = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        ab(getView());
        initUI();
    }

    private void ab(View view) {
        this.cPs = new a();
        this.cPs.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.cPs.cPu = view.findViewById(d.g.top_line);
        this.cPs.cPv = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.cPs.cPx = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.cPs.cPw = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.cPs.aod = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.cPs.bvP = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.cPs.cPh = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.cPs.bZY = (TextView) view.findViewById(d.g.thread_title);
        this.cPs.cPy = (TextView) view.findViewById(d.g.thread_context);
        this.cPs.cPz = (TextView) view.findViewById(d.g.fans_num);
        this.cPs.cbg = (TbImageView) view.findViewById(d.g.thread_image);
        this.cPs.cbg.setPageId(getTag());
        this.cPs.cPA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.cPs.cbi = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cPs.cPB = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.cPs.cPC = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.cPs.cPD = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.cPs.ccL = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.cPs.ccL.setPageId(getTag());
        this.cPs.bvQ = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.cPs.bZR = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cPs.bZR.setTitleClickListener(this);
        this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPs.mRootView);
        this.cOW.setUniqueId(getTag());
    }

    private void initUI() {
        this.cPs.cPx.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPs.cPx.setDefaultResource(17170445);
        this.cPs.cPx.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPs.cPx.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.cPs.cPw.wi();
        this.cPs.cPw.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPs.cPw.getHeadView().setDefaultResource(17170445);
        this.cPs.cPw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPs.cPw.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.cPs.cPw.getHeadView().setIsRound(true);
        this.cPs.cPw.getHeadView().setDrawBorder(false);
        this.cPs.cPw.getPendantView().setIsRound(true);
        this.cPs.cPw.getPendantView().setDrawBorder(false);
        this.cPs.cPA.setShowPraiseNum(false);
        this.cPs.cPA.setFrom(2);
        this.cPs.cbg.setDrawBorder(true);
        this.cPs.cbg.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.cPr = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cPr == null) {
            this.cPs.mRootView.setVisibility(8);
            return;
        }
        if (this.cPr.rv() == null || this.cPr.rv().getPendantData() == null || StringUtils.isNull(this.cPr.rv().getPendantData().pR())) {
            if (this.cPr.rv() != null && this.cPr.rv().getGodUserData() != null && this.cPr.rv().getGodUserData().getType() == 2) {
                this.cPs.cPx.setGodIconMargin(0);
            } else {
                this.cPs.cPx.setIsGod(false);
            }
            UserTbVipInfoData rw = this.cPr.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.cPs.aod != null) {
                    if (this.cPs.aoe == null) {
                        this.cPs.aod.inflate();
                        this.cPs.aoe = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.cPs.aoe.setPageId(getTag());
                    this.cPs.aoe.setVisibility(0);
                    this.cPs.aoe.startLoad(rw.getvipV_url(), 10, false);
                    this.cPs.cPx.setIsBigV(true);
                }
            } else {
                this.cPs.cPx.setIsBigV(false);
                if (this.cPs.aoe != null) {
                    this.cPs.aoe.setVisibility(8);
                }
            }
            this.cPs.cPx.setData(this.cPr);
            this.cPs.cPx.setAfterClickListener(this.cbc);
            this.cPs.cPx.setVisibility(0);
            this.cPs.cPw.setVisibility(8);
        } else {
            this.cPs.cPx.setIsGod(false);
            this.cPs.cPx.setIsBigV(false);
            if (this.cPs.aoe != null) {
                this.cPs.aoe.setVisibility(8);
            }
            this.cPs.cPx.setVisibility(4);
            this.cPs.cPw.setVisibility(0);
            this.cPs.cPw.setData(this.cPr);
        }
        if (this.cPr.rv() != null && !StringUtils.isNull(this.cPr.rv().getSealPrefix())) {
            this.cPs.cPh.aM(true);
        }
        this.cPs.cPh.setData(this.cPr);
        this.cPs.cPh.setUserNameTextSizeRid(d.e.fontsize24);
        this.cPs.cPh.setUserAfterClickListener(this.cbc);
        this.cPs.cPh.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.cPr.getTitle())) {
            int length = this.cPr.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cPr.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cPs.bZY.setSingleLine(true);
        } else {
            this.cPs.bZY.setMaxLines(2);
        }
        this.cPr.e(false, true);
        this.cPs.bZY.setText(this.cPr.rV());
        String fansNickName = this.cPr.rv().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.cPs.cPz.setText(fansNickName + ": " + am.u(this.cPr.rv().getFansNum()));
        if (this.cPs.cPA.setData(this.cPr)) {
            this.cPs.cbi.setVisibility(8);
        } else {
            this.cPs.cbi.setVisibility(0);
        }
        this.cPs.cPA.setForumAfterClickListener(this.cbd);
        this.cPs.cPA.setStType("frs_page");
        D(this.cPr);
        this.cOW.U(this.cPr);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.cPr.getPhotoLiveCover() != null && this.cPr.getPhotoLiveCover().length() != 0) {
            this.cPs.cbg.setVisibility(0);
            this.cPs.cPy.setVisibility(8);
            this.cPs.cbg.startLoad(this.cPr.getPhotoLiveCover(), 10, false);
            b(this.cPr);
        } else {
            this.cPs.cbg.setVisibility(8);
            this.cPs.cPB.setVisibility(8);
            this.cPs.cPC.setVisibility(8);
            this.cPs.cPD.setVisibility(8);
            String str = this.cPr.getAbstract();
            this.cPs.cPy.setText(str);
            this.cPs.cPy.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.cPr, this.cPs.bZR);
        aj.c(this.cPs.cPz, d.C0095d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.jP(this.cPr.getTid())) {
            aj.c(this.cPs.bZY, d.C0095d.cp_cont_d, 1);
            aj.c(this.cPs.cPy, d.C0095d.cp_cont_d, 1);
            return;
        }
        aj.c(this.cPs.bZY, d.C0095d.cp_cont_b, 1);
        aj.c(this.cPs.cPy, d.C0095d.cp_cont_j, 1);
    }

    private void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            SkinInfo rR = bdVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPs.cPx.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cPs.bvP.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cPs.ccL.setVisibility(8);
                if (this.cPs.bvQ != null) {
                    if (rR != null) {
                        this.cPs.bvQ.a(this.mPageContext, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rB(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cPs.bvQ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cPs.ccL.setVisibility(0);
                this.cPs.ccL.setImageBitmap(null);
                this.cPs.ccL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cPs.ccL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cPs.bvQ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.cPs.cPx.setLayoutParams(layoutParams);
            this.cPs.bvP.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPs != null) {
            if (view == this.cPs.mRootView || view == this.cPs.cPA.getCommentNumView() || view == this.cPs.bZR) {
                if (abt() != null) {
                    abt().a(this.cPs.mRootView, this.cPr);
                }
                abO();
            }
        }
    }

    private void abO() {
        PhotoLiveActivityConfig pn;
        if (this.cPr != null) {
            com.baidu.tieba.card.k.jO(this.cPr.getTid());
            if (!abP()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.cPr.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                pn = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPr.getTid()).cz("from_frs").bD(18003).cx(String.valueOf(this.cPr.rS())).pn();
            } else {
                pn = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPr.getTid()).cz("from_frs").bD(18003).pn();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pn));
            jQ(this.cPr.getTid());
        }
    }

    public void jQ(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cPs.mRootView);
            this.cPs.cPh.onChangeSkinType();
            this.cPs.cPA.onChangeSkinType();
            aj.k(this.cPs.cPu, d.C0095d.cp_bg_line_c);
            aj.j(this.cPs.mRootView, d.f.addresslist_item_bg);
            if (this.cPs.bZR != null) {
                this.cPs.bZR.onChangeSkinType();
            }
            this.cOW.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean abP() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.caj != null) {
            this.caj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caj);
        }
    }

    private void b(ar arVar) {
        this.axC.clear();
        Bv();
        if (arVar != null && arVar.rP() != null) {
            int size = arVar.rP().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.rP(), i);
                }
            }
            Bu();
        }
    }

    private void Bv() {
        this.cPs.cPB.setText("");
        this.cPs.cPC.setText("");
        this.cPs.cPD.setText("");
        if (this.cPs.cPB.getVisibility() == 8) {
            this.cPs.cPB.setVisibility(0);
        }
        if (this.cPs.cPC.getVisibility() == 8) {
            this.cPs.cPC.setVisibility(0);
        }
        if (this.cPs.cPD.getVisibility() == 8) {
            this.cPs.cPD.setVisibility(0);
        }
        this.axC.add(Integer.valueOf(this.cPs.cPB.getId()));
        this.axC.add(Integer.valueOf(this.cPs.cPC.getId()));
        this.axC.add(Integer.valueOf(this.cPs.cPD.getId()));
    }

    private void Bu() {
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i = 0; i < size; i++) {
                if (this.axC.get(i).intValue() == this.cPs.cPB.getId()) {
                    this.cPs.cPB.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.cPs.cPC.getId()) {
                    this.cPs.cPC.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.cPs.cPD.getId()) {
                    this.cPs.cPD.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axB) {
                case 0:
                    a(this.axN, this.axO, this.cPs.cPB);
                    a(this.axP, this.axQ, this.cPs.cPC);
                    a(this.axR, this.axS, this.cPs.cPD);
                    break;
                case 1:
                    a(this.axS, this.axT, this.cPs.cPB);
                    a(this.axU, this.axS, this.cPs.cPC);
                    a(this.axV, this.axQ, this.cPs.cPD);
                    break;
                case 2:
                    a(this.axS, this.axW, this.cPs.cPB);
                    a(this.axX, this.axS, this.cPs.cPC);
                    a(this.axV, this.axQ, this.cPs.cPD);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cPs.cPB);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cPs.cPC);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cPs.cPD);
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
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bh())));
            ex(textView.getId());
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

    private void ex(int i) {
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axC.get(i2).intValue() == i) {
                    this.axC.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aod;
        public TbImageView aoe;
        public CardGroupDividerView bZR;
        public TextView bZY;
        public LinearLayout bvP;
        public ThreadSkinView bvQ;
        public ThreadCommentAndPraiseInfoLayout cPA;
        public TextView cPB;
        public TextView cPC;
        public TextView cPD;
        public UserIconLayout cPh;
        public View cPu;
        public RelativeLayout cPv;
        public HeadPendantClickableView cPw;
        public ClickableHeaderImageView cPx;
        public TextView cPy;
        public TextView cPz;
        public TbImageView cbg;
        public View cbi;
        public TbImageView ccL;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

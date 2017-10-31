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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<av> {
    private int awK;
    private ArrayList<Integer> awL;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;
    private int axa;
    private int axb;
    private int axc;
    private int axd;
    private int axe;
    private int axf;
    private int axg;
    private CustomMessageListener bRS;
    private View.OnClickListener bTb;
    private View.OnClickListener bTc;
    private com.baidu.tieba.frs.g.g cFi;
    private av cFy;
    public a cFz;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.awL = new ArrayList<>();
        this.awK = 0;
        this.bTb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Zx() != null) {
                    h.this.Zx().a(view, h.this.cFy);
                }
            }
        };
        this.bTc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Zx() != null) {
                    h.this.Zx().a(view, h.this.cFy);
                }
            }
        };
        this.bRS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cFy != null && h.this.cFy != null && h.this.cFy.getTid() != null && h.this.cFz != null && h.this.cFz.bRF != null && h.this.cFz.cFG != null && ((String) customResponsedMessage.getData()).equals(h.this.cFy.getTid())) {
                    m.a(h.this.cFz.bRF, h.this.cFy.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                    m.a(h.this.cFz.cFG, h.this.cFy.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.awW = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.awX = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.awY = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.awZ = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.axa = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.axb = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.axc = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.axd = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.axe = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.axf = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.axg = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        Z(getView());
        initUI();
    }

    private void Z(View view) {
        this.cFz = new a();
        this.cFz.mRootView = view.findViewById(d.g.card_root_view);
        this.cFz.cFB = view.findViewById(d.g.top_line);
        this.cFz.cFC = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.cFz.cFE = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.cFz.cFD = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.cFz.anP = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.cFz.boH = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.cFz.bSU = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.cFz.bRF = (TextView) view.findViewById(d.g.thread_title);
        this.cFz.cFF = (TextView) view.findViewById(d.g.thread_context);
        this.cFz.cFG = (TextView) view.findViewById(d.g.fans_num);
        this.cFz.bTe = (TbImageView) view.findViewById(d.g.thread_image);
        this.cFz.bTe.setPageId(getTag());
        this.cFz.cFH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.cFz.bTg = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cFz.cFI = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.cFz.cFJ = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.cFz.cFK = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.cFz.czF = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.cFz.czF.setPageId(getTag());
        this.cFz.boI = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.cFz.cFH.setCommentNumClickListener(this);
        this.cFz.bRy = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cFz.bRy.setTitleClickListener(this);
        this.cFz.cFH.setViewNumEnabled(true);
        this.cFi = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cFz.cFH);
        this.cFi.setUniqueId(getTag());
    }

    private void initUI() {
        this.cFz.cFE.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cFz.cFE.setDefaultResource(17170445);
        this.cFz.cFE.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cFz.cFE.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cFz.cFD.wg();
        this.cFz.cFD.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cFz.cFD.getHeadView().setDefaultResource(17170445);
        this.cFz.cFD.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cFz.cFD.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cFz.cFD.getHeadView().setIsRound(true);
        this.cFz.cFD.getHeadView().setDrawBorder(false);
        this.cFz.cFD.getPendantView().setIsRound(true);
        this.cFz.cFD.getPendantView().setDrawBorder(false);
        this.cFz.cFH.setShowPraiseNum(false);
        this.cFz.cFH.setFrom(2);
        this.cFz.bTe.setDrawBorder(true);
        this.cFz.bTe.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(av avVar) {
        this.cFy = avVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cFy == null) {
            this.cFz.mRootView.setVisibility(8);
            return;
        }
        if (this.cFy.rt() == null || this.cFy.rt().getPendantData() == null || StringUtils.isNull(this.cFy.rt().getPendantData().pQ())) {
            if (this.cFy.rt() != null && this.cFy.rt().getGodUserData() != null && this.cFy.rt().getGodUserData().getType() == 2) {
                this.cFz.cFE.setGodIconMargin(0);
            } else {
                this.cFz.cFE.setIsGod(false);
            }
            UserTbVipInfoData ru = this.cFy.ru();
            if (ru != null && ru.getvipV_url() != null) {
                if (this.cFz.anP != null) {
                    if (this.cFz.anQ == null) {
                        this.cFz.anP.inflate();
                        this.cFz.anQ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.cFz.anQ.setPageId(getTag());
                    this.cFz.anQ.setVisibility(0);
                    this.cFz.anQ.startLoad(ru.getvipV_url(), 10, false);
                    this.cFz.cFE.setIsBigV(true);
                }
            } else {
                this.cFz.cFE.setIsBigV(false);
                if (this.cFz.anQ != null) {
                    this.cFz.anQ.setVisibility(8);
                }
            }
            this.cFz.cFE.setData(this.cFy);
            this.cFz.cFE.setAfterClickListener(this.bTb);
            this.cFz.cFE.setVisibility(0);
            this.cFz.cFD.setVisibility(8);
        } else {
            this.cFz.cFE.setIsGod(false);
            this.cFz.cFE.setIsBigV(false);
            if (this.cFz.anQ != null) {
                this.cFz.anQ.setVisibility(8);
            }
            this.cFz.cFE.setVisibility(4);
            this.cFz.cFD.setVisibility(0);
            this.cFz.cFD.setData(this.cFy);
        }
        if (this.cFy.rt() != null && !StringUtils.isNull(this.cFy.rt().getSealPrefix())) {
            this.cFz.bSU.aL(true);
        }
        this.cFz.bSU.setData(this.cFy);
        this.cFz.bSU.setUserNameTextSizeRid(d.e.fontsize24);
        this.cFz.bSU.setUserAfterClickListener(this.bTb);
        this.cFz.bSU.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.cFy.getTitle())) {
            int length = this.cFy.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cFy.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cFz.bRF.setSingleLine(true);
        } else {
            this.cFz.bRF.setMaxLines(2);
        }
        this.cFy.e(false, true);
        this.cFz.bRF.setText(this.cFy.rU());
        String fansNickName = this.cFy.rt().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.cFz.cFG.setText(fansNickName + ": " + am.u(this.cFy.rt().getFansNum()));
        if (this.cFz.cFH.setData(this.cFy)) {
            this.cFz.bTg.setVisibility(8);
        } else {
            this.cFz.bTg.setVisibility(0);
        }
        this.cFz.cFH.setForumAfterClickListener(this.bTc);
        this.cFz.cFH.setStType("frs_page");
        G(this.cFy);
        this.cFi.Q(this.cFy);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.cFy.getPhotoLiveCover() != null && this.cFy.getPhotoLiveCover().length() != 0) {
            this.cFz.bTe.setVisibility(0);
            this.cFz.cFF.setVisibility(8);
            this.cFz.bTe.startLoad(this.cFy.getPhotoLiveCover(), 10, false);
            b(this.cFy);
        } else {
            this.cFz.bTe.setVisibility(8);
            this.cFz.cFI.setVisibility(8);
            this.cFz.cFJ.setVisibility(8);
            this.cFz.cFK.setVisibility(8);
            String str = this.cFy.getAbstract();
            this.cFz.cFF.setText(str);
            this.cFz.cFF.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.cFy, this.cFz.bRy);
        aj.c(this.cFz.cFG, d.C0080d.cp_cont_d, 1);
        if (m.jL(this.cFy.getTid())) {
            aj.c(this.cFz.bRF, d.C0080d.cp_cont_d, 1);
            aj.c(this.cFz.cFF, d.C0080d.cp_cont_d, 1);
            return;
        }
        aj.c(this.cFz.bRF, d.C0080d.cp_cont_b, 1);
        aj.c(this.cFz.cFF, d.C0080d.cp_cont_j, 1);
    }

    private void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            SkinInfo rP = bhVar.rP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cFz.cFE.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cFz.boH.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cFz.czF.setVisibility(8);
                if (this.cFz.boI != null) {
                    if (rP != null) {
                        this.cFz.boI.a(this.mPageContext, rP, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rz(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cFz.boI.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cFz.czF.setVisibility(0);
                this.cFz.czF.setImageBitmap(null);
                this.cFz.czF.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cFz.czF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cFz.boI.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.cFz.cFE.setLayoutParams(layoutParams);
            this.cFz.boH.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cFz != null) {
            if (view == this.cFz.mRootView || view == this.cFz.cFH.getCommentNumView() || view == this.cFz.bRy) {
                if (Zx() != null) {
                    Zx().a(this.cFz.mRootView, this.cFy);
                }
                ZS();
            }
        }
    }

    private void ZS() {
        PhotoLiveActivityConfig pi;
        if (this.cFy != null) {
            m.jK(this.cFy.getTid());
            if (!ZT()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.cFy.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvs()) {
                pi = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cFy.getTid()).cz("from_frs").bC(18003).cx(String.valueOf(this.cFy.rQ())).pi();
            } else {
                pi = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cFy.getTid()).cz("from_frs").bC(18003).pi();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pi));
            jM(this.cFy.getTid());
        }
    }

    public void jM(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.cFz.mRootView);
            this.cFz.bSU.onChangeSkinType();
            this.cFz.cFH.onChangeSkinType();
            aj.k(this.cFz.cFB, d.C0080d.cp_bg_line_c);
            aj.j(this.cFz.mRootView, d.f.addresslist_item_bg);
            if (this.cFz.bRy != null) {
                this.cFz.bRy.onChangeSkinType();
            }
            this.cFi.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean ZT() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bRS != null) {
            this.bRS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bRS);
        }
    }

    private void b(av avVar) {
        this.awL.clear();
        AY();
        if (avVar != null && avVar.rN() != null) {
            int size = avVar.rN().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = avVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, avVar.rN(), i);
                }
            }
            AX();
        }
    }

    private void AY() {
        this.cFz.cFI.setText("");
        this.cFz.cFJ.setText("");
        this.cFz.cFK.setText("");
        if (this.cFz.cFI.getVisibility() == 8) {
            this.cFz.cFI.setVisibility(0);
        }
        if (this.cFz.cFJ.getVisibility() == 8) {
            this.cFz.cFJ.setVisibility(0);
        }
        if (this.cFz.cFK.getVisibility() == 8) {
            this.cFz.cFK.setVisibility(0);
        }
        this.awL.add(Integer.valueOf(this.cFz.cFI.getId()));
        this.awL.add(Integer.valueOf(this.cFz.cFJ.getId()));
        this.awL.add(Integer.valueOf(this.cFz.cFK.getId()));
    }

    private void AX() {
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i = 0; i < size; i++) {
                if (this.awL.get(i).intValue() == this.cFz.cFI.getId()) {
                    this.cFz.cFI.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.cFz.cFJ.getId()) {
                    this.cFz.cFJ.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.cFz.cFK.getId()) {
                    this.cFz.cFK.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awK) {
                case 0:
                    a(this.awW, this.awX, this.cFz.cFI);
                    a(this.awY, this.awZ, this.cFz.cFJ);
                    a(this.axa, this.axb, this.cFz.cFK);
                    break;
                case 1:
                    a(this.axb, this.axc, this.cFz.cFI);
                    a(this.axd, this.axb, this.cFz.cFJ);
                    a(this.axe, this.awZ, this.cFz.cFK);
                    break;
                case 2:
                    a(this.axb, this.axf, this.cFz.cFI);
                    a(this.axg, this.axb, this.cFz.cFJ);
                    a(this.axe, this.awZ, this.cFz.cFK);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cFz.cFI);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cFz.cFJ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cFz.cFK);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AK())));
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
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awL.get(i2).intValue() == i) {
                    this.awL.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anP;
        public TbImageView anQ;
        public TextView bRF;
        public CardGroupDividerView bRy;
        public UserIconLayout bSU;
        public TbImageView bTe;
        public View bTg;
        public LinearLayout boH;
        public ThreadSkinView boI;
        public View cFB;
        public RelativeLayout cFC;
        public HeadPendantClickableView cFD;
        public ClickableHeaderImageView cFE;
        public TextView cFF;
        public TextView cFG;
        public ThreadCommentAndPraiseInfoLayout cFH;
        public TextView cFI;
        public TextView cFJ;
        public TextView cFK;
        public TbImageView czF;
        public View mRootView;

        public a() {
        }
    }
}

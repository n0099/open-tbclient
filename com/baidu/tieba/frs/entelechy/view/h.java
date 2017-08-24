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
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private int ayh;
    private ArrayList<Integer> ayi;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private CustomMessageListener bHu;
    private View.OnClickListener bIB;
    private View.OnClickListener bIC;
    private ax cpE;
    public a cpF;
    private com.baidu.tieba.frs.g.g cpq;
    private TbPageContext<?> oW;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ayi = new ArrayList<>();
        this.ayh = 0;
        this.bIB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Wx() != null) {
                    h.this.Wx().a(view, h.this.cpE);
                }
            }
        };
        this.bIC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Wx() != null) {
                    h.this.Wx().a(view, h.this.cpE);
                }
            }
        };
        this.bHu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cpE != null && h.this.cpE != null && h.this.cpE.getTid() != null && h.this.cpF != null && h.this.cpF.bGh != null && h.this.cpF.cpM != null && ((String) customResponsedMessage.getData()).equals(h.this.cpE.getTid())) {
                    m.a(h.this.cpF.bGh, h.this.cpE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cpF.cpM, h.this.cpE.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.oW = tbPageContext;
        this.ayt = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.ayu = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.ayv = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.ayw = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.ayx = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.ayy = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.ayz = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.ayA = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.ayB = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.ayC = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.ayD = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.cpF = new a();
        this.cpF.mRootView = view.findViewById(d.h.card_root_view);
        this.cpF.cpH = view.findViewById(d.h.top_line);
        this.cpF.cpI = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cpF.cpK = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cpF.cpJ = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cpF.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cpF.bli = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cpF.bIu = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cpF.bGh = (TextView) view.findViewById(d.h.thread_title);
        this.cpF.cpL = (TextView) view.findViewById(d.h.thread_context);
        this.cpF.cpM = (TextView) view.findViewById(d.h.fans_num);
        this.cpF.bIF = (TbImageView) view.findViewById(d.h.thread_image);
        this.cpF.bIF.setPageId(getTag());
        this.cpF.cpN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cpF.bIH = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cpF.cpO = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cpF.cpP = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cpF.cpQ = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cpF.clK = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cpF.clK.setPageId(getTag());
        this.cpF.blj = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cpF.cpN.setCommentNumClickListener(this);
        this.cpF.bHh = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cpF.bHh.setTitleClickListener(this);
        this.cpF.cpN.setViewNumEnabled(true);
        this.cpq = new com.baidu.tieba.frs.g.g(this.oW, this.cpF.cpN);
        this.cpq.setUniqueId(getTag());
    }

    private void initUI() {
        this.cpF.cpK.setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        this.cpF.cpK.setDefaultResource(17170445);
        this.cpF.cpK.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpF.cpK.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpF.cpJ.wE();
        this.cpF.cpJ.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        this.cpF.cpJ.getHeadView().setDefaultResource(17170445);
        this.cpF.cpJ.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpF.cpJ.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpF.cpJ.getHeadView().setIsRound(true);
        this.cpF.cpJ.getHeadView().setDrawBorder(false);
        this.cpF.cpJ.getPendantView().setIsRound(true);
        this.cpF.cpJ.getPendantView().setDrawBorder(false);
        this.cpF.cpN.setShowPraiseNum(false);
        this.cpF.bIF.setDrawBorder(true);
        this.cpF.bIF.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.cpE = axVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cpE == null) {
            this.cpF.mRootView.setVisibility(8);
            return;
        }
        if (this.cpE.getAuthor() == null || this.cpE.getAuthor().getPendantData() == null || StringUtils.isNull(this.cpE.getAuthor().getPendantData().pW())) {
            if (this.cpE.getAuthor() != null && this.cpE.getAuthor().getGodUserData() != null && this.cpE.getAuthor().getGodUserData().getType() == 2) {
                this.cpF.cpK.setGodIconMargin(0);
            } else {
                this.cpF.cpK.setIsGod(false);
            }
            UserTbVipInfoData rG = this.cpE.rG();
            if (rG != null && rG.getvipV_url() != null) {
                if (this.cpF.aoU != null) {
                    if (this.cpF.aoV == null) {
                        this.cpF.aoU.inflate();
                        this.cpF.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cpF.aoV.setPageId(getTag());
                    this.cpF.aoV.setVisibility(0);
                    this.cpF.aoV.c(rG.getvipV_url(), 10, false);
                    this.cpF.cpK.setIsBigV(true);
                }
            } else {
                this.cpF.cpK.setIsBigV(false);
                if (this.cpF.aoV != null) {
                    this.cpF.aoV.setVisibility(8);
                }
            }
            this.cpF.cpK.setData(this.cpE);
            this.cpF.cpK.setAfterClickListener(this.bIB);
            this.cpF.cpK.setVisibility(0);
            this.cpF.cpJ.setVisibility(8);
        } else {
            this.cpF.cpK.setIsGod(false);
            this.cpF.cpK.setIsBigV(false);
            if (this.cpF.aoV != null) {
                this.cpF.aoV.setVisibility(8);
            }
            this.cpF.cpK.setVisibility(4);
            this.cpF.cpJ.setVisibility(0);
            this.cpF.cpJ.setData(this.cpE);
        }
        if (this.cpE.getAuthor() != null && !StringUtils.isNull(this.cpE.getAuthor().getSealPrefix())) {
            this.cpF.bIu.aP(true);
        }
        this.cpF.bIu.setData(this.cpE);
        this.cpF.bIu.setUserNameTextSizeRid(d.f.fontsize24);
        this.cpF.bIu.setUserAfterClickListener(this.bIB);
        this.cpF.bIu.setPageName(1);
        Resources resources = this.oW.getResources();
        if (!StringUtils.isNull(this.cpE.getTitle())) {
            int length = this.cpE.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cpE.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cpF.bGh.setSingleLine(true);
        } else {
            this.cpF.bGh.setMaxLines(2);
        }
        this.cpE.e(false, true);
        this.cpF.bGh.setText(this.cpE.sg());
        String fansNickName = this.cpE.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cpF.cpM.setText(fansNickName + ": " + al.u(this.cpE.getAuthor().getFansNum()));
        if (this.cpF.cpN.a(this.cpE)) {
            this.cpF.bIH.setVisibility(8);
        } else {
            this.cpF.bIH.setVisibility(0);
        }
        this.cpF.cpN.setForumAfterClickListener(this.bIC);
        this.cpF.cpN.setStType(m.rx());
        G(this.cpE);
        this.cpq.P(this.cpE);
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.cpE.getPhotoLiveCover() != null && this.cpE.getPhotoLiveCover().length() != 0) {
            this.cpF.bIF.setVisibility(0);
            this.cpF.cpL.setVisibility(8);
            this.cpF.bIF.c(this.cpE.getPhotoLiveCover(), 10, false);
            b(this.cpE);
        } else {
            this.cpF.bIF.setVisibility(8);
            this.cpF.cpO.setVisibility(8);
            this.cpF.cpP.setVisibility(8);
            this.cpF.cpQ.setVisibility(8);
            String rO = this.cpE.rO();
            this.cpF.cpL.setText(rO);
            this.cpF.cpL.setVisibility(StringUtils.isNull(rO) ? 8 : 0);
        }
        b.a(this.cpE, this.cpF.bHh);
        ai.c(this.cpF.cpM, d.e.cp_cont_d, 1);
        if (m.ji(this.cpE.getTid())) {
            ai.c(this.cpF.bGh, d.e.cp_cont_d, 1);
            ai.c(this.cpF.cpL, d.e.cp_cont_d, 1);
            return;
        }
        ai.c(this.cpF.bGh, d.e.cp_cont_b, 1);
        ai.c(this.cpF.cpL, d.e.cp_cont_j, 1);
    }

    private void G(bl blVar) {
        MetaData author;
        if (blVar != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sb = blVar.sb();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cpF.cpK.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cpF.bli.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cpF.clK.setVisibility(8);
                if (this.cpF.blj != null) {
                    if (sb != null) {
                        this.cpF.blj.a(this.oW, sb, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rL(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds16);
                    } else {
                        this.cpF.blj.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cpF.clK.setVisibility(0);
                this.cpF.clK.setImageBitmap(null);
                this.cpF.clK.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cpF.clK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.oW.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cpF.blj.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds30);
            }
            this.cpF.cpK.setLayoutParams(layoutParams);
            this.cpF.bli.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cpF != null) {
            if (view == this.cpF.mRootView || view == this.cpF.cpN.getCommentNumView() || view == this.cpF.bHh) {
                if (Wx() != null) {
                    Wx().a(this.cpF.mRootView, this.cpE);
                }
                WP();
            }
        }
    }

    private void WP() {
        PhotoLiveActivityConfig po;
        if (this.cpE != null) {
            m.jh(this.cpE.getTid());
            if (!WQ()) {
                UtilHelper.showToast(this.oW.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cpE.sc() > 0 && com.baidu.tieba.tbadkCore.util.g.btX()) {
                po = new PhotoLiveActivityConfig.a(this.oW.getPageActivity(), this.cpE.getTid()).cE("from_frs").bB(18003).cC(String.valueOf(this.cpE.sc())).po();
            } else {
                po = new PhotoLiveActivityConfig.a(this.oW.getPageActivity(), this.cpE.getTid()).cE("from_frs").bB(18003).po();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, po));
            jj(this.cpE.getTid());
        }
    }

    public void jj(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.cpF.mRootView);
            this.cpF.bIu.onChangeSkinType();
            this.cpF.cpN.onChangeSkinType();
            ai.k(this.cpF.cpH, d.e.cp_bg_line_c);
            ai.j(this.cpF.mRootView, d.g.addresslist_item_bg);
            if (this.cpF.bHh != null) {
                this.cpF.bHh.onChangeSkinType();
            }
            this.cpq.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean WQ() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bHu != null) {
            this.bHu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHu);
        }
    }

    private void b(ax axVar) {
        this.ayi.clear();
        BC();
        if (axVar != null && axVar.rZ() != null) {
            int size = axVar.rZ().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rZ(), i);
                }
            }
            BB();
        }
    }

    private void BC() {
        this.cpF.cpO.setText("");
        this.cpF.cpP.setText("");
        this.cpF.cpQ.setText("");
        if (this.cpF.cpO.getVisibility() == 8) {
            this.cpF.cpO.setVisibility(0);
        }
        if (this.cpF.cpP.getVisibility() == 8) {
            this.cpF.cpP.setVisibility(0);
        }
        if (this.cpF.cpQ.getVisibility() == 8) {
            this.cpF.cpQ.setVisibility(0);
        }
        this.ayi.add(Integer.valueOf(this.cpF.cpO.getId()));
        this.ayi.add(Integer.valueOf(this.cpF.cpP.getId()));
        this.ayi.add(Integer.valueOf(this.cpF.cpQ.getId()));
    }

    private void BB() {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i = 0; i < size; i++) {
                if (this.ayi.get(i).intValue() == this.cpF.cpO.getId()) {
                    this.cpF.cpO.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.cpF.cpP.getId()) {
                    this.cpF.cpP.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.cpF.cpQ.getId()) {
                    this.cpF.cpQ.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.ayh) {
                case 0:
                    a(this.ayt, this.ayu, this.cpF.cpO);
                    a(this.ayv, this.ayw, this.cpF.cpP);
                    a(this.ayx, this.ayy, this.cpF.cpQ);
                    break;
                case 1:
                    a(this.ayy, this.ayz, this.cpF.cpO);
                    a(this.ayA, this.ayy, this.cpF.cpP);
                    a(this.ayB, this.ayw, this.cpF.cpQ);
                    break;
                case 2:
                    a(this.ayy, this.ayC, this.cpF.cpO);
                    a(this.ayD, this.ayy, this.cpF.cpP);
                    a(this.ayB, this.ayw, this.cpF.cpQ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cpF.cpO);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cpF.cpP);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cpF.cpQ);
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
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bo())));
            en(textView.getId());
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

    private void en(int i) {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayi.get(i2).intValue() == i) {
                    this.ayi.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aoU;
        public TbImageView aoV;
        public TextView bGh;
        public CardGroupDividerView bHh;
        public TbImageView bIF;
        public View bIH;
        public UserIconLayout bIu;
        public LinearLayout bli;
        public ThreadSkinView blj;
        public TbImageView clK;
        public View cpH;
        public RelativeLayout cpI;
        public HeadPendantClickableView cpJ;
        public ClickableHeaderImageView cpK;
        public TextView cpL;
        public TextView cpM;
        public ThreadCommentAndPraiseInfoLayout cpN;
        public TextView cpO;
        public TextView cpP;
        public TextView cpQ;
        public View mRootView;

        public a() {
        }
    }
}

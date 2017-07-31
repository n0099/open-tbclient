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
    private TbPageContext<?> alI;
    private int ayA;
    private int ayB;
    private int ayf;
    private ArrayList<Integer> ayg;
    private int ayr;
    private int ays;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private CustomMessageListener bGK;
    private View.OnClickListener bHR;
    private View.OnClickListener bHS;
    private com.baidu.tieba.frs.g.g coH;
    private ax coV;
    public a coW;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ayg = new ArrayList<>();
        this.ayf = 0;
        this.bHR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.We() != null) {
                    h.this.We().a(view, h.this.coV);
                }
            }
        };
        this.bHS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.We() != null) {
                    h.this.We().a(view, h.this.coV);
                }
            }
        };
        this.bGK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.coV != null && h.this.coV != null && h.this.coV.getTid() != null && h.this.coW != null && h.this.coW.bFx != null && h.this.coW.cpd != null && ((String) customResponsedMessage.getData()).equals(h.this.coV.getTid())) {
                    m.a(h.this.coW.bFx, h.this.coV.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.coW.cpd, h.this.coV.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.alI = tbPageContext;
        this.ayr = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.ays = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.ayt = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.ayu = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.ayv = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.ayw = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.ayx = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.ayy = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.ayz = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.ayA = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.ayB = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.coW = new a();
        this.coW.mRootView = view.findViewById(d.h.card_root_view);
        this.coW.coY = view.findViewById(d.h.top_line);
        this.coW.coZ = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.coW.cpb = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.coW.cpa = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.coW.aoT = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.coW.bld = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.coW.bHK = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.coW.bFx = (TextView) view.findViewById(d.h.thread_title);
        this.coW.cpc = (TextView) view.findViewById(d.h.thread_context);
        this.coW.cpd = (TextView) view.findViewById(d.h.fans_num);
        this.coW.bHV = (TbImageView) view.findViewById(d.h.thread_image);
        this.coW.bHV.setPageId(getTag());
        this.coW.cpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.coW.bHX = view.findViewById(d.h.divider_below_reply_number_layout);
        this.coW.cpf = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.coW.cpg = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.coW.cph = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.coW.ckY = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.coW.ckY.setPageId(getTag());
        this.coW.ble = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.coW.cpe.setCommentNumClickListener(this);
        this.coW.bGx = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.coW.bGx.setTitleClickListener(this);
        this.coW.cpe.setViewNumEnabled(true);
        this.coH = new com.baidu.tieba.frs.g.g(this.alI, this.coW.cpe);
        this.coH.setUniqueId(getTag());
    }

    private void initUI() {
        this.coW.cpb.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        this.coW.cpb.setDefaultResource(17170445);
        this.coW.cpb.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.coW.cpb.setDefaultBgResource(d.e.cp_bg_line_e);
        this.coW.cpa.wD();
        this.coW.cpa.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        this.coW.cpa.getHeadView().setDefaultResource(17170445);
        this.coW.cpa.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.coW.cpa.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.coW.cpa.getHeadView().setIsRound(true);
        this.coW.cpa.getHeadView().setDrawBorder(false);
        this.coW.cpa.getPendantView().setIsRound(true);
        this.coW.cpa.getPendantView().setDrawBorder(false);
        this.coW.cpe.setShowPraiseNum(false);
        this.coW.bHV.setDrawBorder(true);
        this.coW.bHV.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.coV = axVar;
        Oy();
    }

    private void Oy() {
        boolean z;
        if (this.coV == null) {
            this.coW.mRootView.setVisibility(8);
            return;
        }
        if (this.coV.getAuthor() == null || this.coV.getAuthor().getPendantData() == null || StringUtils.isNull(this.coV.getAuthor().getPendantData().pV())) {
            if (this.coV.getAuthor() != null && this.coV.getAuthor().getGodUserData() != null && this.coV.getAuthor().getGodUserData().getType() == 2) {
                this.coW.cpb.setGodIconMargin(0);
            } else {
                this.coW.cpb.setIsGod(false);
            }
            UserTbVipInfoData rF = this.coV.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.coW.aoT != null) {
                    if (this.coW.aoU == null) {
                        this.coW.aoT.inflate();
                        this.coW.aoU = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.coW.aoU.setPageId(getTag());
                    this.coW.aoU.setVisibility(0);
                    this.coW.aoU.c(rF.getvipV_url(), 10, false);
                    this.coW.cpb.setIsBigV(true);
                }
            } else {
                this.coW.cpb.setIsBigV(false);
                if (this.coW.aoU != null) {
                    this.coW.aoU.setVisibility(8);
                }
            }
            this.coW.cpb.setData(this.coV);
            this.coW.cpb.setAfterClickListener(this.bHR);
            this.coW.cpb.setVisibility(0);
            this.coW.cpa.setVisibility(8);
        } else {
            this.coW.cpb.setIsGod(false);
            this.coW.cpb.setIsBigV(false);
            if (this.coW.aoU != null) {
                this.coW.aoU.setVisibility(8);
            }
            this.coW.cpb.setVisibility(4);
            this.coW.cpa.setVisibility(0);
            this.coW.cpa.setData(this.coV);
        }
        if (this.coV.getAuthor() != null && !StringUtils.isNull(this.coV.getAuthor().getSealPrefix())) {
            this.coW.bHK.aP(true);
        }
        this.coW.bHK.setData(this.coV);
        this.coW.bHK.setUserNameTextSizeRid(d.f.fontsize24);
        this.coW.bHK.setUserAfterClickListener(this.bHR);
        this.coW.bHK.setPageName(1);
        Resources resources = this.alI.getResources();
        if (!StringUtils.isNull(this.coV.getTitle())) {
            int length = this.coV.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.coV.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.coW.bFx.setSingleLine(true);
        } else {
            this.coW.bFx.setMaxLines(2);
        }
        this.coV.e(false, true);
        this.coW.bFx.setText(this.coV.sf());
        String fansNickName = this.coV.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.coW.cpd.setText(fansNickName + ": " + al.u(this.coV.getAuthor().getFansNum()));
        if (this.coW.cpe.a(this.coV)) {
            this.coW.bHX.setVisibility(8);
        } else {
            this.coW.bHX.setVisibility(0);
        }
        this.coW.cpe.setForumAfterClickListener(this.bHS);
        this.coW.cpe.setStType(m.rw());
        G(this.coV);
        this.coH.P(this.coV);
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oX().pd() && this.coV.getPhotoLiveCover() != null && this.coV.getPhotoLiveCover().length() != 0) {
            this.coW.bHV.setVisibility(0);
            this.coW.cpc.setVisibility(8);
            this.coW.bHV.c(this.coV.getPhotoLiveCover(), 10, false);
            b(this.coV);
        } else {
            this.coW.bHV.setVisibility(8);
            this.coW.cpf.setVisibility(8);
            this.coW.cpg.setVisibility(8);
            this.coW.cph.setVisibility(8);
            String rN = this.coV.rN();
            this.coW.cpc.setText(rN);
            this.coW.cpc.setVisibility(StringUtils.isNull(rN) ? 8 : 0);
        }
        b.a(this.coV, this.coW.bGx);
        ai.c(this.coW.cpd, d.e.cp_cont_d, 1);
        if (m.je(this.coV.getTid())) {
            ai.c(this.coW.bFx, d.e.cp_cont_d, 1);
            ai.c(this.coW.cpc, d.e.cp_cont_d, 1);
            return;
        }
        ai.c(this.coW.bFx, d.e.cp_cont_b, 1);
        ai.c(this.coW.cpc, d.e.cp_cont_j, 1);
    }

    private void G(bl blVar) {
        MetaData author;
        if (blVar != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sa = blVar.sa();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.coW.cpb.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.coW.bld.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.coW.ckY.setVisibility(8);
                if (this.coW.ble != null) {
                    if (sa != null) {
                        this.coW.ble.a(this.alI, sa, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rK(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds16);
                    } else {
                        this.coW.ble.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.coW.ckY.setVisibility(0);
                this.coW.ckY.setImageBitmap(null);
                this.coW.ckY.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.coW.ckY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.alI.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.coW.ble.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds30);
            }
            this.coW.cpb.setLayoutParams(layoutParams);
            this.coW.bld.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.coW != null) {
            if (view == this.coW.mRootView || view == this.coW.cpe.getCommentNumView() || view == this.coW.bGx) {
                if (We() != null) {
                    We().a(this.coW.mRootView, this.coV);
                }
                Ww();
            }
        }
    }

    private void Ww() {
        PhotoLiveActivityConfig pn;
        if (this.coV != null) {
            m.jd(this.coV.getTid());
            if (!Wx()) {
                UtilHelper.showToast(this.alI.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.coV.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.btw()) {
                pn = new PhotoLiveActivityConfig.a(this.alI.getPageActivity(), this.coV.getTid()).cB("from_frs").bB(18003).cz(String.valueOf(this.coV.sb())).pn();
            } else {
                pn = new PhotoLiveActivityConfig.a(this.alI.getPageActivity(), this.coV.getTid()).cB("from_frs").bB(18003).pn();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pn));
            jf(this.coV.getTid());
        }
    }

    public void jf(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.coW.mRootView);
            this.coW.bHK.onChangeSkinType();
            this.coW.cpe.onChangeSkinType();
            ai.k(this.coW.coY, d.e.cp_bg_line_c);
            ai.j(this.coW.mRootView, d.g.addresslist_item_bg);
            if (this.coW.bGx != null) {
                this.coW.bGx.onChangeSkinType();
            }
            this.coH.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean Wx() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bGK != null) {
            this.bGK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bGK);
        }
    }

    private void b(ax axVar) {
        this.ayg.clear();
        BC();
        if (axVar != null && axVar.rY() != null) {
            int size = axVar.rY().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rY(), i);
                }
            }
            BB();
        }
    }

    private void BC() {
        this.coW.cpf.setText("");
        this.coW.cpg.setText("");
        this.coW.cph.setText("");
        if (this.coW.cpf.getVisibility() == 8) {
            this.coW.cpf.setVisibility(0);
        }
        if (this.coW.cpg.getVisibility() == 8) {
            this.coW.cpg.setVisibility(0);
        }
        if (this.coW.cph.getVisibility() == 8) {
            this.coW.cph.setVisibility(0);
        }
        this.ayg.add(Integer.valueOf(this.coW.cpf.getId()));
        this.ayg.add(Integer.valueOf(this.coW.cpg.getId()));
        this.ayg.add(Integer.valueOf(this.coW.cph.getId()));
    }

    private void BB() {
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i = 0; i < size; i++) {
                if (this.ayg.get(i).intValue() == this.coW.cpf.getId()) {
                    this.coW.cpf.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.coW.cpg.getId()) {
                    this.coW.cpg.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.coW.cph.getId()) {
                    this.coW.cph.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.ayf) {
                case 0:
                    a(this.ayr, this.ays, this.coW.cpf);
                    a(this.ayt, this.ayu, this.coW.cpg);
                    a(this.ayv, this.ayw, this.coW.cph);
                    break;
                case 1:
                    a(this.ayw, this.ayx, this.coW.cpf);
                    a(this.ayy, this.ayw, this.coW.cpg);
                    a(this.ayz, this.ayu, this.coW.cph);
                    break;
                case 2:
                    a(this.ayw, this.ayA, this.coW.cpf);
                    a(this.ayB, this.ayw, this.coW.cpg);
                    a(this.ayz, this.ayu, this.coW.cph);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.coW.cpf);
            } else if (i == 1) {
                a(arrayList.get(i2), this.coW.cpg);
            } else if (i == 2) {
                a(arrayList.get(i2), this.coW.cph);
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
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayg.get(i2).intValue() == i) {
                    this.ayg.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aoT;
        public TbImageView aoU;
        public TextView bFx;
        public CardGroupDividerView bGx;
        public UserIconLayout bHK;
        public TbImageView bHV;
        public View bHX;
        public LinearLayout bld;
        public ThreadSkinView ble;
        public TbImageView ckY;
        public View coY;
        public RelativeLayout coZ;
        public HeadPendantClickableView cpa;
        public ClickableHeaderImageView cpb;
        public TextView cpc;
        public TextView cpd;
        public ThreadCommentAndPraiseInfoLayout cpe;
        public TextView cpf;
        public TextView cpg;
        public TextView cph;
        public View mRootView;

        public a() {
        }
    }
}

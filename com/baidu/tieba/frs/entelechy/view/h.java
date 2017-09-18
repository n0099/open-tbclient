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
import com.baidu.tbadk.core.data.bj;
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
public class h extends com.baidu.tieba.card.a<ax> {
    private int axB;
    private int axC;
    private int axD;
    private int axE;
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private int axp;
    private ArrayList<Integer> axq;
    private CustomMessageListener bLe;
    private View.OnClickListener bMm;
    private View.OnClickListener bMn;
    private com.baidu.tieba.frs.h.g cwN;
    private ax cxb;
    public a cxc;
    private TbPageContext<?> mF;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.axq = new ArrayList<>();
        this.axp = 0;
        this.bMm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.XL() != null) {
                    h.this.XL().a(view, h.this.cxb);
                }
            }
        };
        this.bMn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.XL() != null) {
                    h.this.XL().a(view, h.this.cxb);
                }
            }
        };
        this.bLe = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cxb != null && h.this.cxb != null && h.this.cxb.getTid() != null && h.this.cxc != null && h.this.cxc.bJS != null && h.this.cxc.cxj != null && ((String) customResponsedMessage.getData()).equals(h.this.cxb.getTid())) {
                    m.a(h.this.cxc.bJS, h.this.cxb.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cxc.cxj, h.this.cxb.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.axB = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.axC = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.axD = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.axE = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.axF = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.axG = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.axH = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.axI = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.axJ = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.axK = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.axL = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.cxc = new a();
        this.cxc.mRootView = view.findViewById(d.h.card_root_view);
        this.cxc.cxe = view.findViewById(d.h.top_line);
        this.cxc.cxf = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cxc.cxh = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cxc.cxg = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cxc.aor = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cxc.blC = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cxc.bMf = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cxc.bJS = (TextView) view.findViewById(d.h.thread_title);
        this.cxc.cxi = (TextView) view.findViewById(d.h.thread_context);
        this.cxc.cxj = (TextView) view.findViewById(d.h.fans_num);
        this.cxc.bMp = (TbImageView) view.findViewById(d.h.thread_image);
        this.cxc.bMp.setPageId(getTag());
        this.cxc.cxk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cxc.bMr = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cxc.cxl = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cxc.cxm = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cxc.cxn = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cxc.crX = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cxc.crX.setPageId(getTag());
        this.cxc.blD = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cxc.cxk.setCommentNumClickListener(this);
        this.cxc.bKR = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cxc.bKR.setTitleClickListener(this);
        this.cxc.cxk.setViewNumEnabled(true);
        this.cwN = new com.baidu.tieba.frs.h.g(this.mF, this.cxc.cxk);
        this.cwN.setUniqueId(getTag());
    }

    private void initUI() {
        this.cxc.cxh.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        this.cxc.cxh.setDefaultResource(17170445);
        this.cxc.cxh.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxc.cxh.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxc.cxg.wB();
        this.cxc.cxg.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        this.cxc.cxg.getHeadView().setDefaultResource(17170445);
        this.cxc.cxg.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxc.cxg.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxc.cxg.getHeadView().setIsRound(true);
        this.cxc.cxg.getHeadView().setDrawBorder(false);
        this.cxc.cxg.getPendantView().setIsRound(true);
        this.cxc.cxg.getPendantView().setDrawBorder(false);
        this.cxc.cxk.setShowPraiseNum(false);
        this.cxc.cxk.setFrom(2);
        this.cxc.bMp.setDrawBorder(true);
        this.cxc.bMp.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.cxb = axVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cxb == null) {
            this.cxc.mRootView.setVisibility(8);
            return;
        }
        if (this.cxb.getAuthor() == null || this.cxb.getAuthor().getPendantData() == null || StringUtils.isNull(this.cxb.getAuthor().getPendantData().pR())) {
            if (this.cxb.getAuthor() != null && this.cxb.getAuthor().getGodUserData() != null && this.cxb.getAuthor().getGodUserData().getType() == 2) {
                this.cxc.cxh.setGodIconMargin(0);
            } else {
                this.cxc.cxh.setIsGod(false);
            }
            UserTbVipInfoData rB = this.cxb.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.cxc.aor != null) {
                    if (this.cxc.aos == null) {
                        this.cxc.aor.inflate();
                        this.cxc.aos = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cxc.aos.setPageId(getTag());
                    this.cxc.aos.setVisibility(0);
                    this.cxc.aos.c(rB.getvipV_url(), 10, false);
                    this.cxc.cxh.setIsBigV(true);
                }
            } else {
                this.cxc.cxh.setIsBigV(false);
                if (this.cxc.aos != null) {
                    this.cxc.aos.setVisibility(8);
                }
            }
            this.cxc.cxh.setData(this.cxb);
            this.cxc.cxh.setAfterClickListener(this.bMm);
            this.cxc.cxh.setVisibility(0);
            this.cxc.cxg.setVisibility(8);
        } else {
            this.cxc.cxh.setIsGod(false);
            this.cxc.cxh.setIsBigV(false);
            if (this.cxc.aos != null) {
                this.cxc.aos.setVisibility(8);
            }
            this.cxc.cxh.setVisibility(4);
            this.cxc.cxg.setVisibility(0);
            this.cxc.cxg.setData(this.cxb);
        }
        if (this.cxb.getAuthor() != null && !StringUtils.isNull(this.cxb.getAuthor().getSealPrefix())) {
            this.cxc.bMf.aP(true);
        }
        this.cxc.bMf.setData(this.cxb);
        this.cxc.bMf.setUserNameTextSizeRid(d.f.fontsize24);
        this.cxc.bMf.setUserAfterClickListener(this.bMm);
        this.cxc.bMf.setPageName(1);
        Resources resources = this.mF.getResources();
        if (!StringUtils.isNull(this.cxb.getTitle())) {
            int length = this.cxb.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cxb.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cxc.bJS.setSingleLine(true);
        } else {
            this.cxc.bJS.setMaxLines(2);
        }
        this.cxb.e(false, true);
        this.cxc.bJS.setText(this.cxb.sb());
        String fansNickName = this.cxb.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cxc.cxj.setText(fansNickName + ": " + am.u(this.cxb.getAuthor().getFansNum()));
        if (this.cxc.cxk.c(this.cxb)) {
            this.cxc.bMr.setVisibility(8);
        } else {
            this.cxc.bMr.setVisibility(0);
        }
        this.cxc.cxk.setForumAfterClickListener(this.bMn);
        this.cxc.cxk.setStType(m.rs());
        K(this.cxb);
        this.cwN.T(this.cxb);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oS().oY() && this.cxb.getPhotoLiveCover() != null && this.cxb.getPhotoLiveCover().length() != 0) {
            this.cxc.bMp.setVisibility(0);
            this.cxc.cxi.setVisibility(8);
            this.cxc.bMp.c(this.cxb.getPhotoLiveCover(), 10, false);
            b(this.cxb);
        } else {
            this.cxc.bMp.setVisibility(8);
            this.cxc.cxl.setVisibility(8);
            this.cxc.cxm.setVisibility(8);
            this.cxc.cxn.setVisibility(8);
            String rJ = this.cxb.rJ();
            this.cxc.cxi.setText(rJ);
            this.cxc.cxi.setVisibility(StringUtils.isNull(rJ) ? 8 : 0);
        }
        b.a(this.cxb, this.cxc.bKR);
        aj.c(this.cxc.cxj, d.e.cp_cont_d, 1);
        if (m.jv(this.cxb.getTid())) {
            aj.c(this.cxc.bJS, d.e.cp_cont_d, 1);
            aj.c(this.cxc.cxi, d.e.cp_cont_d, 1);
            return;
        }
        aj.c(this.cxc.bJS, d.e.cp_cont_b, 1);
        aj.c(this.cxc.cxi, d.e.cp_cont_j, 1);
    }

    private void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rW = bjVar.rW();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cxc.cxh.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cxc.blC.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cxc.crX.setVisibility(8);
                if (this.cxc.blD != null) {
                    if (rW != null) {
                        this.cxc.blD.a(this.mF, rW, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rG(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds16);
                    } else {
                        this.cxc.blD.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cxc.crX.setVisibility(0);
                this.cxc.crX.setImageBitmap(null);
                this.cxc.crX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cxc.crX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mF.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cxc.blD.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds30);
            }
            this.cxc.cxh.setLayoutParams(layoutParams);
            this.cxc.blC.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cxc != null) {
            if (view == this.cxc.mRootView || view == this.cxc.cxk.getCommentNumView() || view == this.cxc.bKR) {
                if (XL() != null) {
                    XL().a(this.cxc.mRootView, this.cxb);
                }
                Ye();
            }
        }
    }

    private void Ye() {
        PhotoLiveActivityConfig pi;
        if (this.cxb != null) {
            m.ju(this.cxb.getTid());
            if (!Yf()) {
                UtilHelper.showToast(this.mF.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cxb.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                pi = new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.cxb.getTid()).cu("from_frs").bB(18003).cs(String.valueOf(this.cxb.rX())).pi();
            } else {
                pi = new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.cxb.getTid()).cu("from_frs").bB(18003).pi();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pi));
            jw(this.cxb.getTid());
        }
    }

    public void jw(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.cxc.mRootView);
            this.cxc.bMf.onChangeSkinType();
            this.cxc.cxk.onChangeSkinType();
            aj.k(this.cxc.cxe, d.e.cp_bg_line_c);
            aj.j(this.cxc.mRootView, d.g.addresslist_item_bg);
            if (this.cxc.bKR != null) {
                this.cxc.bKR.onChangeSkinType();
            }
            this.cwN.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean Yf() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bLe != null) {
            this.bLe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bLe);
        }
    }

    private void b(ax axVar) {
        this.axq.clear();
        Bx();
        if (axVar != null && axVar.rU() != null) {
            int size = axVar.rU().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rU(), i);
                }
            }
            Bw();
        }
    }

    private void Bx() {
        this.cxc.cxl.setText("");
        this.cxc.cxm.setText("");
        this.cxc.cxn.setText("");
        if (this.cxc.cxl.getVisibility() == 8) {
            this.cxc.cxl.setVisibility(0);
        }
        if (this.cxc.cxm.getVisibility() == 8) {
            this.cxc.cxm.setVisibility(0);
        }
        if (this.cxc.cxn.getVisibility() == 8) {
            this.cxc.cxn.setVisibility(0);
        }
        this.axq.add(Integer.valueOf(this.cxc.cxl.getId()));
        this.axq.add(Integer.valueOf(this.cxc.cxm.getId()));
        this.axq.add(Integer.valueOf(this.cxc.cxn.getId()));
    }

    private void Bw() {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i = 0; i < size; i++) {
                if (this.axq.get(i).intValue() == this.cxc.cxl.getId()) {
                    this.cxc.cxl.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.cxc.cxm.getId()) {
                    this.cxc.cxm.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.cxc.cxn.getId()) {
                    this.cxc.cxn.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axp) {
                case 0:
                    a(this.axB, this.axC, this.cxc.cxl);
                    a(this.axD, this.axE, this.cxc.cxm);
                    a(this.axF, this.axG, this.cxc.cxn);
                    break;
                case 1:
                    a(this.axG, this.axH, this.cxc.cxl);
                    a(this.axI, this.axG, this.cxc.cxm);
                    a(this.axJ, this.axE, this.cxc.cxn);
                    break;
                case 2:
                    a(this.axG, this.axK, this.cxc.cxl);
                    a(this.axL, this.axG, this.cxc.cxm);
                    a(this.axJ, this.axE, this.cxc.cxn);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cxc.cxl);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cxc.cxm);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cxc.cxn);
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
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bj())));
            em(textView.getId());
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

    private void em(int i) {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axq.get(i2).intValue() == i) {
                    this.axq.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aor;
        public TbImageView aos;
        public TextView bJS;
        public CardGroupDividerView bKR;
        public UserIconLayout bMf;
        public TbImageView bMp;
        public View bMr;
        public LinearLayout blC;
        public ThreadSkinView blD;
        public TbImageView crX;
        public View cxe;
        public RelativeLayout cxf;
        public HeadPendantClickableView cxg;
        public ClickableHeaderImageView cxh;
        public TextView cxi;
        public TextView cxj;
        public ThreadCommentAndPraiseInfoLayout cxk;
        public TextView cxl;
        public TextView cxm;
        public TextView cxn;
        public View mRootView;

        public a() {
        }
    }
}

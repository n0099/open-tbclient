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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.card.a<as> {
    private int blG;
    private ArrayList<Integer> blH;
    private int blS;
    private int blT;
    private int blU;
    private int blV;
    private int blW;
    private int blX;
    private int blY;
    private int blZ;
    private int bma;
    private int bmb;
    private int bmc;
    private CustomMessageListener cOO;
    private View.OnClickListener cPI;
    private View.OnClickListener cPJ;
    private com.baidu.tieba.frs.f.g dDM;
    private as dEi;
    public a dEj;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.blH = new ArrayList<>();
        this.blG = 0;
        this.cPI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.aiY() != null) {
                    h.this.aiY().a(view, h.this.dEi);
                }
            }
        };
        this.cPJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.aiY() != null) {
                    h.this.aiY().a(view, h.this.dEi);
                }
            }
        };
        this.cOO = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dEi != null && h.this.dEi != null && h.this.dEi.getTid() != null && h.this.dEj != null && h.this.dEj.cOD != null && h.this.dEj.dEq != null && ((String) customResponsedMessage.getData()).equals(h.this.dEi.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.dEj.cOD, h.this.dEi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.dEj.dEq, h.this.dEi.getId(), d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.blS = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.blT = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.blU = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.blV = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.blW = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.blX = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.blY = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.blZ = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.bma = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.bmb = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.bmc = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bt(getView());
        initUI();
    }

    private void bt(View view) {
        this.dEj = new a();
        this.dEj.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dEj.dEl = view.findViewById(d.g.top_line);
        this.dEj.dEm = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dEj.dEo = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dEj.dEn = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dEj.bcb = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dEj.cjA = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dEj.dDX = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dEj.cOD = (TextView) view.findViewById(d.g.thread_title);
        this.dEj.dEp = (TextView) view.findViewById(d.g.thread_context);
        this.dEj.dEq = (TextView) view.findViewById(d.g.fans_num);
        this.dEj.cPM = (TbImageView) view.findViewById(d.g.thread_image);
        this.dEj.cPM.setPageId(getTag());
        this.dEj.dEr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dEj.cPO = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dEj.dEs = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dEj.dEt = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dEj.dEu = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dEj.cRo = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dEj.cRo.setPageId(getTag());
        this.dEj.cjB = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dEj.cOw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dEj.cOw.setTitleClickListener(this);
        this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dEj.mRootView);
        this.dDM.setUniqueId(getTag());
    }

    private void initUI() {
        this.dEj.dEo.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dEj.dEo.setDefaultResource(17170445);
        this.dEj.dEo.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dEj.dEo.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dEj.dEn.DG();
        this.dEj.dEn.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dEj.dEn.getHeadView().setDefaultResource(17170445);
        this.dEj.dEn.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dEj.dEn.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dEj.dEn.getHeadView().setIsRound(true);
        this.dEj.dEn.getHeadView().setDrawBorder(false);
        this.dEj.dEn.getPendantView().setIsRound(true);
        this.dEj.dEn.getPendantView().setDrawBorder(false);
        this.dEj.dEr.setShowPraiseNum(false);
        this.dEj.dEr.setFrom(2);
        this.dEj.cPM.setDrawBorder(true);
        this.dEj.cPM.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(as asVar) {
        this.dEi = asVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dEi == null) {
            this.dEj.mRootView.setVisibility(8);
            return;
        }
        if (this.dEi.yX() == null || this.dEi.yX().getPendantData() == null || StringUtils.isNull(this.dEi.yX().getPendantData().xu())) {
            if (this.dEi.yX() != null && this.dEi.yX().getGodUserData() != null && this.dEi.yX().getGodUserData().getType() == 2) {
                this.dEj.dEo.setGodIconMargin(0);
            } else {
                this.dEj.dEo.setIsGod(false);
            }
            UserTbVipInfoData yY = this.dEi.yY();
            if (yY != null && yY.getvipV_url() != null) {
                if (this.dEj.bcb != null) {
                    if (this.dEj.bcc == null) {
                        this.dEj.bcb.inflate();
                        this.dEj.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dEj.bcc.setPageId(getTag());
                    this.dEj.bcc.setVisibility(0);
                    this.dEj.bcc.startLoad(yY.getvipV_url(), 10, false);
                    this.dEj.dEo.setIsBigV(true);
                }
            } else {
                this.dEj.dEo.setIsBigV(false);
                if (this.dEj.bcc != null) {
                    this.dEj.bcc.setVisibility(8);
                }
            }
            this.dEj.dEo.setData(this.dEi);
            this.dEj.dEo.setAfterClickListener(this.cPI);
            this.dEj.dEo.setVisibility(0);
            this.dEj.dEn.setVisibility(8);
        } else {
            this.dEj.dEo.setIsGod(false);
            this.dEj.dEo.setIsBigV(false);
            if (this.dEj.bcc != null) {
                this.dEj.bcc.setVisibility(8);
            }
            this.dEj.dEo.setVisibility(4);
            this.dEj.dEn.setVisibility(0);
            this.dEj.dEn.setData(this.dEi);
        }
        if (this.dEi.yX() != null && !StringUtils.isNull(this.dEi.yX().getSealPrefix())) {
            this.dEj.dDX.bs(true);
        }
        this.dEj.dDX.setData(this.dEi);
        this.dEj.dDX.setUserNameTextSizeRid(d.e.fontsize24);
        this.dEj.dDX.setUserAfterClickListener(this.cPI);
        this.dEj.dDX.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dEi.getTitle())) {
            int length = this.dEi.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dEi.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dEj.cOD.setSingleLine(true);
        } else {
            this.dEj.cOD.setMaxLines(2);
        }
        this.dEi.h(false, true);
        this.dEj.cOD.setText(this.dEi.zx());
        String fansNickName = this.dEi.yX().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dEj.dEq.setText(fansNickName + ": " + am.C(this.dEi.yX().getFansNum()));
        if (this.dEj.dEr.setData(this.dEi)) {
            this.dEj.cPO.setVisibility(8);
        } else {
            this.dEj.cPO.setVisibility(0);
        }
        this.dEj.dEr.setForumAfterClickListener(this.cPJ);
        this.dEj.dEr.setStType("frs_page");
        H(this.dEi);
        this.dDM.T(this.dEi);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wB().wH() && this.dEi.getPhotoLiveCover() != null && this.dEi.getPhotoLiveCover().length() != 0) {
            this.dEj.cPM.setVisibility(0);
            this.dEj.dEp.setVisibility(8);
            this.dEj.cPM.startLoad(this.dEi.getPhotoLiveCover(), 10, false);
            b(this.dEi);
        } else {
            this.dEj.cPM.setVisibility(8);
            this.dEj.dEs.setVisibility(8);
            this.dEj.dEt.setVisibility(8);
            this.dEj.dEu.setVisibility(8);
            String str = this.dEi.getAbstract();
            this.dEj.dEp.setText(str);
            this.dEj.dEp.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dEi, this.dEj.cOw);
        aj.e(this.dEj.dEq, d.C0108d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.jU(this.dEi.getTid())) {
            aj.e(this.dEj.cOD, d.C0108d.cp_cont_d, 1);
            aj.e(this.dEj.dEp, d.C0108d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dEj.cOD, d.C0108d.cp_cont_b, 1);
        aj.e(this.dEj.dEp, d.C0108d.cp_cont_j, 1);
    }

    private void H(be beVar) {
        MetaData yX;
        if (beVar != null && (yX = beVar.yX()) != null) {
            final ThemeCardInUserData themeCard = yX.getThemeCard();
            SkinInfo zt = beVar.zt();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEj.dEo.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dEj.cjA.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dEj.cRo.setVisibility(8);
                if (this.dEj.cjB != null) {
                    if (zt != null) {
                        this.dEj.cjB.a(this.mPageContext, zt, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(beVar.getFid()), beVar.zd(), beVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dEj.cjB.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dEj.cRo.setVisibility(0);
                this.dEj.cRo.setImageBitmap(null);
                this.dEj.cRo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dEj.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dEj.cjB.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dEj.dEo.setLayoutParams(layoutParams);
            this.dEj.cjA.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dEj != null) {
            if (view == this.dEj.mRootView || view == this.dEj.dEr.getCommentNumView() || view == this.dEj.cOw) {
                if (aiY() != null) {
                    aiY().a(this.dEj.mRootView, this.dEi);
                }
                aju();
            }
        }
    }

    private void aju() {
        PhotoLiveActivityConfig wQ;
        if (this.dEi != null) {
            com.baidu.tieba.card.k.jT(this.dEi.getTid());
            if (!ajv()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dEi.zu() > 0 && com.baidu.tieba.tbadkCore.util.f.bDl()) {
                wQ = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dEi.getTid()).cG("from_frs").eD(18003).cE(String.valueOf(this.dEi.zu())).wQ();
            } else {
                wQ = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dEi.getTid()).cG("from_frs").eD(18003).wQ();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, wQ));
            jV(this.dEi.getTid());
        }
    }

    public void jV(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.dEj.mRootView);
            this.dEj.dDX.onChangeSkinType();
            this.dEj.dEr.onChangeSkinType();
            aj.t(this.dEj.dEl, d.C0108d.cp_bg_line_c);
            aj.s(this.dEj.mRootView, d.f.addresslist_item_bg);
            if (this.dEj.cOw != null) {
                this.dEj.cOw.onChangeSkinType();
            }
            this.dDM.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean ajv() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cOO != null) {
            this.cOO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOO);
        }
    }

    private void b(as asVar) {
        this.blH.clear();
        IX();
        if (asVar != null && asVar.zr() != null) {
            int size = asVar.zr().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = asVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, asVar.zr(), i);
                }
            }
            IW();
        }
    }

    private void IX() {
        this.dEj.dEs.setText("");
        this.dEj.dEt.setText("");
        this.dEj.dEu.setText("");
        if (this.dEj.dEs.getVisibility() == 8) {
            this.dEj.dEs.setVisibility(0);
        }
        if (this.dEj.dEt.getVisibility() == 8) {
            this.dEj.dEt.setVisibility(0);
        }
        if (this.dEj.dEu.getVisibility() == 8) {
            this.dEj.dEu.setVisibility(0);
        }
        this.blH.add(Integer.valueOf(this.dEj.dEs.getId()));
        this.blH.add(Integer.valueOf(this.dEj.dEt.getId()));
        this.blH.add(Integer.valueOf(this.dEj.dEu.getId()));
    }

    private void IW() {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i = 0; i < size; i++) {
                if (this.blH.get(i).intValue() == this.dEj.dEs.getId()) {
                    this.dEj.dEs.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.dEj.dEt.getId()) {
                    this.dEj.dEt.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.dEj.dEu.getId()) {
                    this.dEj.dEu.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blG) {
                case 0:
                    a(this.blS, this.blT, this.dEj.dEs);
                    a(this.blU, this.blV, this.dEj.dEt);
                    a(this.blW, this.blX, this.dEj.dEu);
                    break;
                case 1:
                    a(this.blX, this.blY, this.dEj.dEs);
                    a(this.blZ, this.blX, this.dEj.dEt);
                    a(this.bma, this.blV, this.dEj.dEu);
                    break;
                case 2:
                    a(this.blX, this.bmb, this.dEj.dEs);
                    a(this.bmc, this.blX, this.dEj.dEt);
                    a(this.bma, this.blV, this.dEj.dEu);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dEj.dEs);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dEj.dEt);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dEj.dEu);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IJ())));
            hv(textView.getId());
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

    private void hv(int i) {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blH.get(i2).intValue() == i) {
                    this.blH.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bcb;
        public TbImageView bcc;
        public TextView cOD;
        public CardGroupDividerView cOw;
        public TbImageView cPM;
        public View cPO;
        public TbImageView cRo;
        public LinearLayout cjA;
        public ThreadSkinView cjB;
        public UserIconLayout dDX;
        public View dEl;
        public RelativeLayout dEm;
        public HeadPendantClickableView dEn;
        public ClickableHeaderImageView dEo;
        public TextView dEp;
        public TextView dEq;
        public ThreadCommentAndPraiseInfoLayout dEr;
        public TextView dEs;
        public TextView dEt;
        public TextView dEu;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

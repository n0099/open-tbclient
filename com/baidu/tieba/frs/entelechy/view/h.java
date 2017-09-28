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
    private ArrayList<Integer> awA;
    private int awL;
    private int awM;
    private int awN;
    private int awO;
    private int awP;
    private int awQ;
    private int awR;
    private int awS;
    private int awT;
    private int awU;
    private int awV;
    private int awz;
    private CustomMessageListener bKy;
    private View.OnClickListener bLJ;
    private View.OnClickListener bLK;
    private com.baidu.tieba.frs.h.g cxD;
    private av cxR;
    public a cxS;
    private TbPageContext<?> mG;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.awA = new ArrayList<>();
        this.awz = 0;
        this.bLJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Xr() != null) {
                    h.this.Xr().a(view, h.this.cxR);
                }
            }
        };
        this.bLK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Xr() != null) {
                    h.this.Xr().a(view, h.this.cxR);
                }
            }
        };
        this.bKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cxR != null && h.this.cxR != null && h.this.cxR.getTid() != null && h.this.cxS != null && h.this.cxS.bKl != null && h.this.cxS.cxZ != null && ((String) customResponsedMessage.getData()).equals(h.this.cxR.getTid())) {
                    m.a(h.this.cxS.bKl, h.this.cxR.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cxS.cxZ, h.this.cxR.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mG = tbPageContext;
        this.awL = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.awM = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.awN = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.awO = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.awP = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.awQ = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.awR = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.awS = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.awT = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.awU = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.awV = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.cxS = new a();
        this.cxS.mRootView = view.findViewById(d.h.card_root_view);
        this.cxS.cxU = view.findViewById(d.h.top_line);
        this.cxS.cxV = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cxS.cxX = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cxS.cxW = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cxS.anG = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cxS.bnn = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cxS.bLC = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cxS.bKl = (TextView) view.findViewById(d.h.thread_title);
        this.cxS.cxY = (TextView) view.findViewById(d.h.thread_context);
        this.cxS.cxZ = (TextView) view.findViewById(d.h.fans_num);
        this.cxS.bLM = (TbImageView) view.findViewById(d.h.thread_image);
        this.cxS.bLM.setPageId(getTag());
        this.cxS.cya = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cxS.bLO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cxS.cyb = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cxS.cyc = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cxS.cyd = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cxS.csu = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cxS.csu.setPageId(getTag());
        this.cxS.bno = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cxS.cya.setCommentNumClickListener(this);
        this.cxS.bKe = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cxS.bKe.setTitleClickListener(this);
        this.cxS.cya.setViewNumEnabled(true);
        this.cxD = new com.baidu.tieba.frs.h.g(this.mG, this.cxS.cya);
        this.cxD.setUniqueId(getTag());
    }

    private void initUI() {
        this.cxS.cxX.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        this.cxS.cxX.setDefaultResource(17170445);
        this.cxS.cxX.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxS.cxX.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxS.cxW.wg();
        this.cxS.cxW.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        this.cxS.cxW.getHeadView().setDefaultResource(17170445);
        this.cxS.cxW.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxS.cxW.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxS.cxW.getHeadView().setIsRound(true);
        this.cxS.cxW.getHeadView().setDrawBorder(false);
        this.cxS.cxW.getPendantView().setIsRound(true);
        this.cxS.cxW.getPendantView().setDrawBorder(false);
        this.cxS.cya.setShowPraiseNum(false);
        this.cxS.cya.setFrom(2);
        this.cxS.bLM.setDrawBorder(true);
        this.cxS.bLM.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(av avVar) {
        this.cxR = avVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cxR == null) {
            this.cxS.mRootView.setVisibility(8);
            return;
        }
        if (this.cxR.getAuthor() == null || this.cxR.getAuthor().getPendantData() == null || StringUtils.isNull(this.cxR.getAuthor().getPendantData().pS())) {
            if (this.cxR.getAuthor() != null && this.cxR.getAuthor().getGodUserData() != null && this.cxR.getAuthor().getGodUserData().getType() == 2) {
                this.cxS.cxX.setGodIconMargin(0);
            } else {
                this.cxS.cxX.setIsGod(false);
            }
            UserTbVipInfoData rv = this.cxR.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.cxS.anG != null) {
                    if (this.cxS.anH == null) {
                        this.cxS.anG.inflate();
                        this.cxS.anH = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cxS.anH.setPageId(getTag());
                    this.cxS.anH.setVisibility(0);
                    this.cxS.anH.c(rv.getvipV_url(), 10, false);
                    this.cxS.cxX.setIsBigV(true);
                }
            } else {
                this.cxS.cxX.setIsBigV(false);
                if (this.cxS.anH != null) {
                    this.cxS.anH.setVisibility(8);
                }
            }
            this.cxS.cxX.setData(this.cxR);
            this.cxS.cxX.setAfterClickListener(this.bLJ);
            this.cxS.cxX.setVisibility(0);
            this.cxS.cxW.setVisibility(8);
        } else {
            this.cxS.cxX.setIsGod(false);
            this.cxS.cxX.setIsBigV(false);
            if (this.cxS.anH != null) {
                this.cxS.anH.setVisibility(8);
            }
            this.cxS.cxX.setVisibility(4);
            this.cxS.cxW.setVisibility(0);
            this.cxS.cxW.setData(this.cxR);
        }
        if (this.cxR.getAuthor() != null && !StringUtils.isNull(this.cxR.getAuthor().getSealPrefix())) {
            this.cxS.bLC.aO(true);
        }
        this.cxS.bLC.setData(this.cxR);
        this.cxS.bLC.setUserNameTextSizeRid(d.f.fontsize24);
        this.cxS.bLC.setUserAfterClickListener(this.bLJ);
        this.cxS.bLC.setPageName(1);
        Resources resources = this.mG.getResources();
        if (!StringUtils.isNull(this.cxR.getTitle())) {
            int length = this.cxR.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cxR.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cxS.bKl.setSingleLine(true);
        } else {
            this.cxS.bKl.setMaxLines(2);
        }
        this.cxR.e(false, true);
        this.cxS.bKl.setText(this.cxR.rV());
        String fansNickName = this.cxR.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cxS.cxZ.setText(fansNickName + ": " + am.t(this.cxR.getAuthor().getFansNum()));
        if (this.cxS.cya.setData(this.cxR)) {
            this.cxS.bLO.setVisibility(8);
        } else {
            this.cxS.bLO.setVisibility(0);
        }
        this.cxS.cya.setForumAfterClickListener(this.bLK);
        this.cxS.cya.setStType(m.rm());
        F(this.cxR);
        this.cxD.O(this.cxR);
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.cxR.getPhotoLiveCover() != null && this.cxR.getPhotoLiveCover().length() != 0) {
            this.cxS.bLM.setVisibility(0);
            this.cxS.cxY.setVisibility(8);
            this.cxS.bLM.c(this.cxR.getPhotoLiveCover(), 10, false);
            b(this.cxR);
        } else {
            this.cxS.bLM.setVisibility(8);
            this.cxS.cyb.setVisibility(8);
            this.cxS.cyc.setVisibility(8);
            this.cxS.cyd.setVisibility(8);
            String rD = this.cxR.rD();
            this.cxS.cxY.setText(rD);
            this.cxS.cxY.setVisibility(StringUtils.isNull(rD) ? 8 : 0);
        }
        b.a(this.cxR, this.cxS.bKe);
        aj.c(this.cxS.cxZ, d.e.cp_cont_d, 1);
        if (m.jo(this.cxR.getTid())) {
            aj.c(this.cxS.bKl, d.e.cp_cont_d, 1);
            aj.c(this.cxS.cxY, d.e.cp_cont_d, 1);
            return;
        }
        aj.c(this.cxS.bKl, d.e.cp_cont_b, 1);
        aj.c(this.cxS.cxY, d.e.cp_cont_j, 1);
    }

    private void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rQ = bhVar.rQ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cxS.cxX.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cxS.bnn.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cxS.csu.setVisibility(8);
                if (this.cxS.bno != null) {
                    if (rQ != null) {
                        this.cxS.bno.a(this.mG, rQ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rA(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds16);
                    } else {
                        this.cxS.bno.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cxS.csu.setVisibility(0);
                this.cxS.csu.setImageBitmap(null);
                this.cxS.csu.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cxS.csu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mG.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cxS.bno.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds30);
            }
            this.cxS.cxX.setLayoutParams(layoutParams);
            this.cxS.bnn.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cxS != null) {
            if (view == this.cxS.mRootView || view == this.cxS.cya.getCommentNumView() || view == this.cxS.bKe) {
                if (Xr() != null) {
                    Xr().a(this.cxS.mRootView, this.cxR);
                }
                XM();
            }
        }
    }

    private void XM() {
        PhotoLiveActivityConfig pj;
        if (this.cxR != null) {
            m.jn(this.cxR.getTid());
            if (!XN()) {
                UtilHelper.showToast(this.mG.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cxR.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsw()) {
                pj = new PhotoLiveActivityConfig.a(this.mG.getPageActivity(), this.cxR.getTid()).cu("from_frs").bF(18003).cs(String.valueOf(this.cxR.rR())).pj();
            } else {
                pj = new PhotoLiveActivityConfig.a(this.mG.getPageActivity(), this.cxR.getTid()).cu("from_frs").bF(18003).pj();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pj));
            jp(this.cxR.getTid());
        }
    }

    public void jp(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cxS.mRootView);
            this.cxS.bLC.onChangeSkinType();
            this.cxS.cya.onChangeSkinType();
            aj.k(this.cxS.cxU, d.e.cp_bg_line_c);
            aj.j(this.cxS.mRootView, d.g.addresslist_item_bg);
            if (this.cxS.bKe != null) {
                this.cxS.bKe.onChangeSkinType();
            }
            this.cxD.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean XN() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bKy != null) {
            this.bKy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKy);
        }
    }

    private void b(av avVar) {
        this.awA.clear();
        AV();
        if (avVar != null && avVar.rO() != null) {
            int size = avVar.rO().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = avVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, avVar.rO(), i);
                }
            }
            AU();
        }
    }

    private void AV() {
        this.cxS.cyb.setText("");
        this.cxS.cyc.setText("");
        this.cxS.cyd.setText("");
        if (this.cxS.cyb.getVisibility() == 8) {
            this.cxS.cyb.setVisibility(0);
        }
        if (this.cxS.cyc.getVisibility() == 8) {
            this.cxS.cyc.setVisibility(0);
        }
        if (this.cxS.cyd.getVisibility() == 8) {
            this.cxS.cyd.setVisibility(0);
        }
        this.awA.add(Integer.valueOf(this.cxS.cyb.getId()));
        this.awA.add(Integer.valueOf(this.cxS.cyc.getId()));
        this.awA.add(Integer.valueOf(this.cxS.cyd.getId()));
    }

    private void AU() {
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i = 0; i < size; i++) {
                if (this.awA.get(i).intValue() == this.cxS.cyb.getId()) {
                    this.cxS.cyb.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.cxS.cyc.getId()) {
                    this.cxS.cyc.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.cxS.cyd.getId()) {
                    this.cxS.cyd.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awz) {
                case 0:
                    a(this.awL, this.awM, this.cxS.cyb);
                    a(this.awN, this.awO, this.cxS.cyc);
                    a(this.awP, this.awQ, this.cxS.cyd);
                    break;
                case 1:
                    a(this.awQ, this.awR, this.cxS.cyb);
                    a(this.awS, this.awQ, this.cxS.cyc);
                    a(this.awT, this.awO, this.cxS.cyd);
                    break;
                case 2:
                    a(this.awQ, this.awU, this.cxS.cyb);
                    a(this.awV, this.awQ, this.cxS.cyc);
                    a(this.awT, this.awO, this.cxS.cyd);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cxS.cyb);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cxS.cyc);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cxS.cyd);
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
            textView.setText(eVar.am(eVar.getLabelName(), String.valueOf(eVar.AH())));
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
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awA.get(i2).intValue() == i) {
                    this.awA.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anG;
        public TbImageView anH;
        public CardGroupDividerView bKe;
        public TextView bKl;
        public UserIconLayout bLC;
        public TbImageView bLM;
        public View bLO;
        public LinearLayout bnn;
        public ThreadSkinView bno;
        public TbImageView csu;
        public View cxU;
        public RelativeLayout cxV;
        public HeadPendantClickableView cxW;
        public ClickableHeaderImageView cxX;
        public TextView cxY;
        public TextView cxZ;
        public ThreadCommentAndPraiseInfoLayout cya;
        public TextView cyb;
        public TextView cyc;
        public TextView cyd;
        public View mRootView;

        public a() {
        }
    }
}

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
    private int awA;
    private int awB;
    private int awC;
    private int awD;
    private int awE;
    private int awF;
    private int awG;
    private int awH;
    private int awI;
    private int awJ;
    private int awn;
    private ArrayList<Integer> awo;
    private int awz;
    private CustomMessageListener bKm;
    private View.OnClickListener bLx;
    private View.OnClickListener bLy;
    private av cxF;
    public a cxG;
    private com.baidu.tieba.frs.h.g cxr;
    private TbPageContext<?> mH;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.awo = new ArrayList<>();
        this.awn = 0;
        this.bLx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Xn() != null) {
                    h.this.Xn().a(view, h.this.cxF);
                }
            }
        };
        this.bLy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.Xn() != null) {
                    h.this.Xn().a(view, h.this.cxF);
                }
            }
        };
        this.bKm = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cxF != null && h.this.cxF != null && h.this.cxF.getTid() != null && h.this.cxG != null && h.this.cxG.bJZ != null && h.this.cxG.cxN != null && ((String) customResponsedMessage.getData()).equals(h.this.cxF.getTid())) {
                    m.a(h.this.cxG.bJZ, h.this.cxF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cxG.cxN, h.this.cxF.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mH = tbPageContext;
        this.awz = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.awA = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.awB = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.awC = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.awD = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.awE = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.awF = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.awG = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.awH = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.awI = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.awJ = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.cxG = new a();
        this.cxG.mRootView = view.findViewById(d.h.card_root_view);
        this.cxG.cxI = view.findViewById(d.h.top_line);
        this.cxG.cxJ = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cxG.cxL = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cxG.cxK = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cxG.anu = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cxG.bmZ = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cxG.bLq = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cxG.bJZ = (TextView) view.findViewById(d.h.thread_title);
        this.cxG.cxM = (TextView) view.findViewById(d.h.thread_context);
        this.cxG.cxN = (TextView) view.findViewById(d.h.fans_num);
        this.cxG.bLA = (TbImageView) view.findViewById(d.h.thread_image);
        this.cxG.bLA.setPageId(getTag());
        this.cxG.cxO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cxG.bLC = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cxG.cxP = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cxG.cxQ = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cxG.cxR = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cxG.csi = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cxG.csi.setPageId(getTag());
        this.cxG.bna = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cxG.cxO.setCommentNumClickListener(this);
        this.cxG.bJS = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cxG.bJS.setTitleClickListener(this);
        this.cxG.cxO.setViewNumEnabled(true);
        this.cxr = new com.baidu.tieba.frs.h.g(this.mH, this.cxG.cxO);
        this.cxr.setUniqueId(getTag());
    }

    private void initUI() {
        this.cxG.cxL.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        this.cxG.cxL.setDefaultResource(17170445);
        this.cxG.cxL.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxG.cxL.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxG.cxK.vZ();
        this.cxG.cxK.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        this.cxG.cxK.getHeadView().setDefaultResource(17170445);
        this.cxG.cxK.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxG.cxK.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxG.cxK.getHeadView().setIsRound(true);
        this.cxG.cxK.getHeadView().setDrawBorder(false);
        this.cxG.cxK.getPendantView().setIsRound(true);
        this.cxG.cxK.getPendantView().setDrawBorder(false);
        this.cxG.cxO.setShowPraiseNum(false);
        this.cxG.cxO.setFrom(2);
        this.cxG.bLA.setDrawBorder(true);
        this.cxG.bLA.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(av avVar) {
        this.cxF = avVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cxF == null) {
            this.cxG.mRootView.setVisibility(8);
            return;
        }
        if (this.cxF.getAuthor() == null || this.cxF.getAuthor().getPendantData() == null || StringUtils.isNull(this.cxF.getAuthor().getPendantData().pL())) {
            if (this.cxF.getAuthor() != null && this.cxF.getAuthor().getGodUserData() != null && this.cxF.getAuthor().getGodUserData().getType() == 2) {
                this.cxG.cxL.setGodIconMargin(0);
            } else {
                this.cxG.cxL.setIsGod(false);
            }
            UserTbVipInfoData ro = this.cxF.ro();
            if (ro != null && ro.getvipV_url() != null) {
                if (this.cxG.anu != null) {
                    if (this.cxG.anv == null) {
                        this.cxG.anu.inflate();
                        this.cxG.anv = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cxG.anv.setPageId(getTag());
                    this.cxG.anv.setVisibility(0);
                    this.cxG.anv.c(ro.getvipV_url(), 10, false);
                    this.cxG.cxL.setIsBigV(true);
                }
            } else {
                this.cxG.cxL.setIsBigV(false);
                if (this.cxG.anv != null) {
                    this.cxG.anv.setVisibility(8);
                }
            }
            this.cxG.cxL.setData(this.cxF);
            this.cxG.cxL.setAfterClickListener(this.bLx);
            this.cxG.cxL.setVisibility(0);
            this.cxG.cxK.setVisibility(8);
        } else {
            this.cxG.cxL.setIsGod(false);
            this.cxG.cxL.setIsBigV(false);
            if (this.cxG.anv != null) {
                this.cxG.anv.setVisibility(8);
            }
            this.cxG.cxL.setVisibility(4);
            this.cxG.cxK.setVisibility(0);
            this.cxG.cxK.setData(this.cxF);
        }
        if (this.cxF.getAuthor() != null && !StringUtils.isNull(this.cxF.getAuthor().getSealPrefix())) {
            this.cxG.bLq.aN(true);
        }
        this.cxG.bLq.setData(this.cxF);
        this.cxG.bLq.setUserNameTextSizeRid(d.f.fontsize24);
        this.cxG.bLq.setUserAfterClickListener(this.bLx);
        this.cxG.bLq.setPageName(1);
        Resources resources = this.mH.getResources();
        if (!StringUtils.isNull(this.cxF.getTitle())) {
            int length = this.cxF.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cxF.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cxG.bJZ.setSingleLine(true);
        } else {
            this.cxG.bJZ.setMaxLines(2);
        }
        this.cxF.e(false, true);
        this.cxG.bJZ.setText(this.cxF.rO());
        String fansNickName = this.cxF.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cxG.cxN.setText(fansNickName + ": " + am.u(this.cxF.getAuthor().getFansNum()));
        if (this.cxG.cxO.setData(this.cxF)) {
            this.cxG.bLC.setVisibility(8);
        } else {
            this.cxG.bLC.setVisibility(0);
        }
        this.cxG.cxO.setForumAfterClickListener(this.bLy);
        this.cxG.cxO.setStType(m.rf());
        F(this.cxF);
        this.cxr.O(this.cxF);
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oM().oS() && this.cxF.getPhotoLiveCover() != null && this.cxF.getPhotoLiveCover().length() != 0) {
            this.cxG.bLA.setVisibility(0);
            this.cxG.cxM.setVisibility(8);
            this.cxG.bLA.c(this.cxF.getPhotoLiveCover(), 10, false);
            b(this.cxF);
        } else {
            this.cxG.bLA.setVisibility(8);
            this.cxG.cxP.setVisibility(8);
            this.cxG.cxQ.setVisibility(8);
            this.cxG.cxR.setVisibility(8);
            String rw = this.cxF.rw();
            this.cxG.cxM.setText(rw);
            this.cxG.cxM.setVisibility(StringUtils.isNull(rw) ? 8 : 0);
        }
        b.a(this.cxF, this.cxG.bJS);
        aj.c(this.cxG.cxN, d.e.cp_cont_d, 1);
        if (m.jm(this.cxF.getTid())) {
            aj.c(this.cxG.bJZ, d.e.cp_cont_d, 1);
            aj.c(this.cxG.cxM, d.e.cp_cont_d, 1);
            return;
        }
        aj.c(this.cxG.bJZ, d.e.cp_cont_b, 1);
        aj.c(this.cxG.cxM, d.e.cp_cont_j, 1);
    }

    private void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rJ = bhVar.rJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cxG.cxL.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cxG.bmZ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cxG.csi.setVisibility(8);
                if (this.cxG.bna != null) {
                    if (rJ != null) {
                        this.cxG.bna.a(this.mH, rJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rt(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds16);
                    } else {
                        this.cxG.bna.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cxG.csi.setVisibility(0);
                this.cxG.csi.setImageBitmap(null);
                this.cxG.csi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cxG.csi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mH.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cxG.bna.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds30);
            }
            this.cxG.cxL.setLayoutParams(layoutParams);
            this.cxG.bmZ.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cxG != null) {
            if (view == this.cxG.mRootView || view == this.cxG.cxO.getCommentNumView() || view == this.cxG.bJS) {
                if (Xn() != null) {
                    Xn().a(this.cxG.mRootView, this.cxF);
                }
                XI();
            }
        }
    }

    private void XI() {
        PhotoLiveActivityConfig pc;
        if (this.cxF != null) {
            m.jl(this.cxF.getTid());
            if (!XJ()) {
                UtilHelper.showToast(this.mH.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cxF.rK() > 0 && com.baidu.tieba.tbadkCore.util.f.bso()) {
                pc = new PhotoLiveActivityConfig.a(this.mH.getPageActivity(), this.cxF.getTid()).ct("from_frs").bE(18003).cr(String.valueOf(this.cxF.rK())).pc();
            } else {
                pc = new PhotoLiveActivityConfig.a(this.mH.getPageActivity(), this.cxF.getTid()).ct("from_frs").bE(18003).pc();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pc));
            jn(this.cxF.getTid());
        }
    }

    public void jn(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cxG.mRootView);
            this.cxG.bLq.onChangeSkinType();
            this.cxG.cxO.onChangeSkinType();
            aj.k(this.cxG.cxI, d.e.cp_bg_line_c);
            aj.j(this.cxG.mRootView, d.g.addresslist_item_bg);
            if (this.cxG.bJS != null) {
                this.cxG.bJS.onChangeSkinType();
            }
            this.cxr.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean XJ() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bKm != null) {
            this.bKm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKm);
        }
    }

    private void b(av avVar) {
        this.awo.clear();
        AP();
        if (avVar != null && avVar.rH() != null) {
            int size = avVar.rH().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = avVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, avVar.rH(), i);
                }
            }
            AO();
        }
    }

    private void AP() {
        this.cxG.cxP.setText("");
        this.cxG.cxQ.setText("");
        this.cxG.cxR.setText("");
        if (this.cxG.cxP.getVisibility() == 8) {
            this.cxG.cxP.setVisibility(0);
        }
        if (this.cxG.cxQ.getVisibility() == 8) {
            this.cxG.cxQ.setVisibility(0);
        }
        if (this.cxG.cxR.getVisibility() == 8) {
            this.cxG.cxR.setVisibility(0);
        }
        this.awo.add(Integer.valueOf(this.cxG.cxP.getId()));
        this.awo.add(Integer.valueOf(this.cxG.cxQ.getId()));
        this.awo.add(Integer.valueOf(this.cxG.cxR.getId()));
    }

    private void AO() {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i = 0; i < size; i++) {
                if (this.awo.get(i).intValue() == this.cxG.cxP.getId()) {
                    this.cxG.cxP.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.cxG.cxQ.getId()) {
                    this.cxG.cxQ.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.cxG.cxR.getId()) {
                    this.cxG.cxR.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awn) {
                case 0:
                    a(this.awz, this.awA, this.cxG.cxP);
                    a(this.awB, this.awC, this.cxG.cxQ);
                    a(this.awD, this.awE, this.cxG.cxR);
                    break;
                case 1:
                    a(this.awE, this.awF, this.cxG.cxP);
                    a(this.awG, this.awE, this.cxG.cxQ);
                    a(this.awH, this.awC, this.cxG.cxR);
                    break;
                case 2:
                    a(this.awE, this.awI, this.cxG.cxP);
                    a(this.awJ, this.awE, this.cxG.cxQ);
                    a(this.awH, this.awC, this.cxG.cxR);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cxG.cxP);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cxG.cxQ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cxG.cxR);
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
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.AB())));
            ew(textView.getId());
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

    private void ew(int i) {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awo.get(i2).intValue() == i) {
                    this.awo.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anu;
        public TbImageView anv;
        public CardGroupDividerView bJS;
        public TextView bJZ;
        public TbImageView bLA;
        public View bLC;
        public UserIconLayout bLq;
        public LinearLayout bmZ;
        public ThreadSkinView bna;
        public TbImageView csi;
        public View cxI;
        public RelativeLayout cxJ;
        public HeadPendantClickableView cxK;
        public ClickableHeaderImageView cxL;
        public TextView cxM;
        public TextView cxN;
        public ThreadCommentAndPraiseInfoLayout cxO;
        public TextView cxP;
        public TextView cxQ;
        public TextView cxR;
        public View mRootView;

        public a() {
        }
    }
}

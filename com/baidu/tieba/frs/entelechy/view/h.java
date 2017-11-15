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
    private int awS;
    private ArrayList<Integer> awT;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private int axl;
    private int axm;
    private int axn;
    private int axo;
    private CustomMessageListener bSf;
    private View.OnClickListener bTo;
    private View.OnClickListener bTp;
    private com.baidu.tieba.frs.g.g cFB;
    private av cFR;
    public a cFS;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.awT = new ArrayList<>();
        this.awS = 0;
        this.bTo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ZJ() != null) {
                    h.this.ZJ().a(view, h.this.cFR);
                }
            }
        };
        this.bTp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ZJ() != null) {
                    h.this.ZJ().a(view, h.this.cFR);
                }
            }
        };
        this.bSf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cFR != null && h.this.cFR != null && h.this.cFR.getTid() != null && h.this.cFS != null && h.this.cFS.bRS != null && h.this.cFS.cFZ != null && ((String) customResponsedMessage.getData()).equals(h.this.cFR.getTid())) {
                    m.a(h.this.cFS.bRS, h.this.cFR.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                    m.a(h.this.cFS.cFZ, h.this.cFR.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.axe = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.axf = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.axg = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.axh = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.axi = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.axj = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.axk = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.axl = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.axm = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.axn = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.axo = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        Z(getView());
        initUI();
    }

    private void Z(View view) {
        this.cFS = new a();
        this.cFS.mRootView = view.findViewById(d.g.card_root_view);
        this.cFS.cFU = view.findViewById(d.g.top_line);
        this.cFS.cFV = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.cFS.cFX = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.cFS.cFW = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.cFS.anO = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.cFS.boQ = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.cFS.bTh = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.cFS.bRS = (TextView) view.findViewById(d.g.thread_title);
        this.cFS.cFY = (TextView) view.findViewById(d.g.thread_context);
        this.cFS.cFZ = (TextView) view.findViewById(d.g.fans_num);
        this.cFS.bTr = (TbImageView) view.findViewById(d.g.thread_image);
        this.cFS.bTr.setPageId(getTag());
        this.cFS.cGa = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.cFS.bTt = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cFS.cGb = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.cFS.cGc = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.cFS.cGd = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.cFS.czY = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.cFS.czY.setPageId(getTag());
        this.cFS.boR = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.cFS.cGa.setCommentNumClickListener(this);
        this.cFS.bRL = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cFS.bRL.setTitleClickListener(this);
        this.cFS.cGa.setViewNumEnabled(true);
        this.cFB = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cFS.cGa);
        this.cFB.setUniqueId(getTag());
    }

    private void initUI() {
        this.cFS.cFX.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cFS.cFX.setDefaultResource(17170445);
        this.cFS.cFX.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cFS.cFX.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cFS.cFW.wg();
        this.cFS.cFW.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cFS.cFW.getHeadView().setDefaultResource(17170445);
        this.cFS.cFW.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cFS.cFW.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cFS.cFW.getHeadView().setIsRound(true);
        this.cFS.cFW.getHeadView().setDrawBorder(false);
        this.cFS.cFW.getPendantView().setIsRound(true);
        this.cFS.cFW.getPendantView().setDrawBorder(false);
        this.cFS.cGa.setShowPraiseNum(false);
        this.cFS.cGa.setFrom(2);
        this.cFS.bTr.setDrawBorder(true);
        this.cFS.bTr.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(av avVar) {
        this.cFR = avVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cFR == null) {
            this.cFS.mRootView.setVisibility(8);
            return;
        }
        if (this.cFR.rt() == null || this.cFR.rt().getPendantData() == null || StringUtils.isNull(this.cFR.rt().getPendantData().pQ())) {
            if (this.cFR.rt() != null && this.cFR.rt().getGodUserData() != null && this.cFR.rt().getGodUserData().getType() == 2) {
                this.cFS.cFX.setGodIconMargin(0);
            } else {
                this.cFS.cFX.setIsGod(false);
            }
            UserTbVipInfoData ru = this.cFR.ru();
            if (ru != null && ru.getvipV_url() != null) {
                if (this.cFS.anO != null) {
                    if (this.cFS.anP == null) {
                        this.cFS.anO.inflate();
                        this.cFS.anP = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.cFS.anP.setPageId(getTag());
                    this.cFS.anP.setVisibility(0);
                    this.cFS.anP.startLoad(ru.getvipV_url(), 10, false);
                    this.cFS.cFX.setIsBigV(true);
                }
            } else {
                this.cFS.cFX.setIsBigV(false);
                if (this.cFS.anP != null) {
                    this.cFS.anP.setVisibility(8);
                }
            }
            this.cFS.cFX.setData(this.cFR);
            this.cFS.cFX.setAfterClickListener(this.bTo);
            this.cFS.cFX.setVisibility(0);
            this.cFS.cFW.setVisibility(8);
        } else {
            this.cFS.cFX.setIsGod(false);
            this.cFS.cFX.setIsBigV(false);
            if (this.cFS.anP != null) {
                this.cFS.anP.setVisibility(8);
            }
            this.cFS.cFX.setVisibility(4);
            this.cFS.cFW.setVisibility(0);
            this.cFS.cFW.setData(this.cFR);
        }
        if (this.cFR.rt() != null && !StringUtils.isNull(this.cFR.rt().getSealPrefix())) {
            this.cFS.bTh.aL(true);
        }
        this.cFS.bTh.setData(this.cFR);
        this.cFS.bTh.setUserNameTextSizeRid(d.e.fontsize24);
        this.cFS.bTh.setUserAfterClickListener(this.bTo);
        this.cFS.bTh.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.cFR.getTitle())) {
            int length = this.cFR.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cFR.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cFS.bRS.setSingleLine(true);
        } else {
            this.cFS.bRS.setMaxLines(2);
        }
        this.cFR.e(false, true);
        this.cFS.bRS.setText(this.cFR.rU());
        String fansNickName = this.cFR.rt().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.cFS.cFZ.setText(fansNickName + ": " + am.u(this.cFR.rt().getFansNum()));
        if (this.cFS.cGa.setData(this.cFR)) {
            this.cFS.bTt.setVisibility(8);
        } else {
            this.cFS.bTt.setVisibility(0);
        }
        this.cFS.cGa.setForumAfterClickListener(this.bTp);
        this.cFS.cGa.setStType("frs_page");
        G(this.cFR);
        this.cFB.Q(this.cFR);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.cFR.getPhotoLiveCover() != null && this.cFR.getPhotoLiveCover().length() != 0) {
            this.cFS.bTr.setVisibility(0);
            this.cFS.cFY.setVisibility(8);
            this.cFS.bTr.startLoad(this.cFR.getPhotoLiveCover(), 10, false);
            b(this.cFR);
        } else {
            this.cFS.bTr.setVisibility(8);
            this.cFS.cGb.setVisibility(8);
            this.cFS.cGc.setVisibility(8);
            this.cFS.cGd.setVisibility(8);
            String str = this.cFR.getAbstract();
            this.cFS.cFY.setText(str);
            this.cFS.cFY.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.cFR, this.cFS.bRL);
        aj.c(this.cFS.cFZ, d.C0080d.cp_cont_d, 1);
        if (m.jM(this.cFR.getTid())) {
            aj.c(this.cFS.bRS, d.C0080d.cp_cont_d, 1);
            aj.c(this.cFS.cFY, d.C0080d.cp_cont_d, 1);
            return;
        }
        aj.c(this.cFS.bRS, d.C0080d.cp_cont_b, 1);
        aj.c(this.cFS.cFY, d.C0080d.cp_cont_j, 1);
    }

    private void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            SkinInfo rP = bhVar.rP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cFS.cFX.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cFS.boQ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cFS.czY.setVisibility(8);
                if (this.cFS.boR != null) {
                    if (rP != null) {
                        this.cFS.boR.a(this.mPageContext, rP, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rz(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cFS.boR.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cFS.czY.setVisibility(0);
                this.cFS.czY.setImageBitmap(null);
                this.cFS.czY.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cFS.czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cFS.boR.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.cFS.cFX.setLayoutParams(layoutParams);
            this.cFS.boQ.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cFS != null) {
            if (view == this.cFS.mRootView || view == this.cFS.cGa.getCommentNumView() || view == this.cFS.bRL) {
                if (ZJ() != null) {
                    ZJ().a(this.cFS.mRootView, this.cFR);
                }
                aae();
            }
        }
    }

    private void aae() {
        PhotoLiveActivityConfig pi;
        if (this.cFR != null) {
            m.jL(this.cFR.getTid());
            if (!aaf()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.cFR.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvE()) {
                pi = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cFR.getTid()).cz("from_frs").bC(18003).cx(String.valueOf(this.cFR.rQ())).pi();
            } else {
                pi = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cFR.getTid()).cz("from_frs").bC(18003).pi();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pi));
            jN(this.cFR.getTid());
        }
    }

    public void jN(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.cFS.mRootView);
            this.cFS.bTh.onChangeSkinType();
            this.cFS.cGa.onChangeSkinType();
            aj.k(this.cFS.cFU, d.C0080d.cp_bg_line_c);
            aj.j(this.cFS.mRootView, d.f.addresslist_item_bg);
            if (this.cFS.bRL != null) {
                this.cFS.bRL.onChangeSkinType();
            }
            this.cFB.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean aaf() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bSf != null) {
            this.bSf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSf);
        }
    }

    private void b(av avVar) {
        this.awT.clear();
        Bk();
        if (avVar != null && avVar.rN() != null) {
            int size = avVar.rN().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = avVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, avVar.rN(), i);
                }
            }
            Bj();
        }
    }

    private void Bk() {
        this.cFS.cGb.setText("");
        this.cFS.cGc.setText("");
        this.cFS.cGd.setText("");
        if (this.cFS.cGb.getVisibility() == 8) {
            this.cFS.cGb.setVisibility(0);
        }
        if (this.cFS.cGc.getVisibility() == 8) {
            this.cFS.cGc.setVisibility(0);
        }
        if (this.cFS.cGd.getVisibility() == 8) {
            this.cFS.cGd.setVisibility(0);
        }
        this.awT.add(Integer.valueOf(this.cFS.cGb.getId()));
        this.awT.add(Integer.valueOf(this.cFS.cGc.getId()));
        this.awT.add(Integer.valueOf(this.cFS.cGd.getId()));
    }

    private void Bj() {
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i = 0; i < size; i++) {
                if (this.awT.get(i).intValue() == this.cFS.cGb.getId()) {
                    this.cFS.cGb.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.cFS.cGc.getId()) {
                    this.cFS.cGc.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.cFS.cGd.getId()) {
                    this.cFS.cGd.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awS) {
                case 0:
                    a(this.axe, this.axf, this.cFS.cGb);
                    a(this.axg, this.axh, this.cFS.cGc);
                    a(this.axi, this.axj, this.cFS.cGd);
                    break;
                case 1:
                    a(this.axj, this.axk, this.cFS.cGb);
                    a(this.axl, this.axj, this.cFS.cGc);
                    a(this.axm, this.axh, this.cFS.cGd);
                    break;
                case 2:
                    a(this.axj, this.axn, this.cFS.cGb);
                    a(this.axo, this.axj, this.cFS.cGc);
                    a(this.axm, this.axh, this.cFS.cGd);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cFS.cGb);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cFS.cGc);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cFS.cGd);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AW())));
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
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awT.get(i2).intValue() == i) {
                    this.awT.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anO;
        public TbImageView anP;
        public CardGroupDividerView bRL;
        public TextView bRS;
        public UserIconLayout bTh;
        public TbImageView bTr;
        public View bTt;
        public LinearLayout boQ;
        public ThreadSkinView boR;
        public View cFU;
        public RelativeLayout cFV;
        public HeadPendantClickableView cFW;
        public ClickableHeaderImageView cFX;
        public TextView cFY;
        public TextView cFZ;
        public ThreadCommentAndPraiseInfoLayout cGa;
        public TextView cGb;
        public TextView cGc;
        public TextView cGd;
        public TbImageView czY;
        public View mRootView;

        public a() {
        }
    }
}

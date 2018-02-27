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
public class h extends com.baidu.tieba.card.a<ar> {
    private int bnY;
    private ArrayList<Integer> bnZ;
    private int bok;
    private int bol;
    private int bom;
    private int bon;
    private int boo;
    private int bop;
    private int boq;
    private int bor;
    private int bos;
    private int bot;
    private int bou;
    private CustomMessageListener cWh;
    private View.OnClickListener cXc;
    private View.OnClickListener cXd;
    private ar dLT;
    public a dLU;
    private com.baidu.tieba.frs.g.g dLx;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bnZ = new ArrayList<>();
        this.bnY = 0;
        this.cXc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akO() != null) {
                    h.this.akO().a(view, h.this.dLT);
                }
            }
        };
        this.cXd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akO() != null) {
                    h.this.akO().a(view, h.this.dLT);
                }
            }
        };
        this.cWh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dLT != null && h.this.dLT != null && h.this.dLT.getTid() != null && h.this.dLU != null && h.this.dLU.cXg != null && h.this.dLU.dMb != null && ((String) customResponsedMessage.getData()).equals(h.this.dLT.getTid())) {
                    com.baidu.tieba.card.j.a(h.this.dLU.cXg, h.this.dLT.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                    com.baidu.tieba.card.j.a(h.this.dLU.dMb, h.this.dLT.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.bok = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.bol = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.bom = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.bon = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.boo = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.bop = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.boq = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.bor = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.bos = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.bot = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.bou = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bu(getView());
        initUI();
    }

    private void bu(View view) {
        this.dLU = new a();
        this.dLU.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dLU.dLW = view.findViewById(d.g.top_line);
        this.dLU.dLX = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dLU.dLZ = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dLU.dLY = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dLU.bdN = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dLU.cmX = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dLU.dLI = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dLU.cXg = (TextView) view.findViewById(d.g.thread_title);
        this.dLU.dMa = (TextView) view.findViewById(d.g.thread_context);
        this.dLU.dMb = (TextView) view.findViewById(d.g.fans_num);
        this.dLU.cXh = (TbImageView) view.findViewById(d.g.thread_image);
        this.dLU.cXh.setPageId(getTag());
        this.dLU.dMc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dLU.cXj = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dLU.dMd = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dLU.dMe = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dLU.dMf = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dLU.cYK = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dLU.cYK.setPageId(getTag());
        this.dLU.cmY = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dLU.cXk = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dLU.cXk.setTitleClickListener(this);
        this.dLx = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLU.mRootView);
        this.dLx.setUniqueId(getTag());
    }

    private void initUI() {
        this.dLU.dLZ.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dLU.dLZ.setDefaultResource(17170445);
        this.dLU.dLZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dLU.dLZ.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dLU.dLY.DS();
        this.dLU.dLY.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dLU.dLY.getHeadView().setDefaultResource(17170445);
        this.dLU.dLY.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dLU.dLY.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dLU.dLY.getHeadView().setIsRound(true);
        this.dLU.dLY.getHeadView().setDrawBorder(false);
        this.dLU.dLY.getPendantView().setIsRound(true);
        this.dLU.dLY.getPendantView().setDrawBorder(false);
        this.dLU.dMc.setShowPraiseNum(false);
        this.dLU.dMc.setFrom(2);
        this.dLU.cXh.setDrawBorder(true);
        this.dLU.cXh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.dLT = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dLT == null) {
            this.dLU.mRootView.setVisibility(8);
            return;
        }
        if (this.dLT.zn() == null || this.dLT.zn().getPendantData() == null || StringUtils.isNull(this.dLT.zn().getPendantData().ya())) {
            if (this.dLT.zn() != null && this.dLT.zn().getGodUserData() != null && this.dLT.zn().getGodUserData().getType() == 2) {
                this.dLU.dLZ.setGodIconMargin(0);
            } else {
                this.dLU.dLZ.setIsGod(false);
            }
            UserTbVipInfoData zo = this.dLT.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.dLU.bdN != null) {
                    if (this.dLU.bdO == null) {
                        this.dLU.bdN.inflate();
                        this.dLU.bdO = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dLU.bdO.setPageId(getTag());
                    this.dLU.bdO.setVisibility(0);
                    this.dLU.bdO.startLoad(zo.getvipV_url(), 10, false);
                    this.dLU.dLZ.setIsBigV(true);
                }
            } else {
                this.dLU.dLZ.setIsBigV(false);
                if (this.dLU.bdO != null) {
                    this.dLU.bdO.setVisibility(8);
                }
            }
            this.dLU.dLZ.setData(this.dLT);
            this.dLU.dLZ.setAfterClickListener(this.cXc);
            this.dLU.dLZ.setVisibility(0);
            this.dLU.dLY.setVisibility(8);
        } else {
            this.dLU.dLZ.setIsGod(false);
            this.dLU.dLZ.setIsBigV(false);
            if (this.dLU.bdO != null) {
                this.dLU.bdO.setVisibility(8);
            }
            this.dLU.dLZ.setVisibility(4);
            this.dLU.dLY.setVisibility(0);
            this.dLU.dLY.setData(this.dLT);
        }
        if (this.dLT.zn() != null && !StringUtils.isNull(this.dLT.zn().getSealPrefix())) {
            this.dLU.dLI.by(true);
        }
        this.dLU.dLI.setData(this.dLT);
        this.dLU.dLI.setUserNameTextSizeRid(d.e.fontsize24);
        this.dLU.dLI.setUserAfterClickListener(this.cXc);
        this.dLU.dLI.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dLT.getTitle())) {
            int length = this.dLT.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dLT.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dLU.cXg.setSingleLine(true);
        } else {
            this.dLU.cXg.setMaxLines(2);
        }
        this.dLT.h(false, true);
        this.dLU.cXg.setText(this.dLT.zN());
        String fansNickName = this.dLT.zn().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dLU.dMb.setText(fansNickName + ": " + am.C(this.dLT.zn().getFansNum()));
        if (this.dLU.dMc.setData(this.dLT)) {
            this.dLU.cXj.setVisibility(8);
        } else {
            this.dLU.cXj.setVisibility(0);
        }
        this.dLU.dMc.setForumAfterClickListener(this.cXd);
        this.dLU.dMc.setStType("frs_page");
        K(this.dLT);
        this.dLx.W(this.dLT);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.dLT.getPhotoLiveCover() != null && this.dLT.getPhotoLiveCover().length() != 0) {
            this.dLU.cXh.setVisibility(0);
            this.dLU.dMa.setVisibility(8);
            this.dLU.cXh.startLoad(this.dLT.getPhotoLiveCover(), 10, false);
            b(this.dLT);
        } else {
            this.dLU.cXh.setVisibility(8);
            this.dLU.dMd.setVisibility(8);
            this.dLU.dMe.setVisibility(8);
            this.dLU.dMf.setVisibility(8);
            String str = this.dLT.getAbstract();
            this.dLU.dMa.setText(str);
            this.dLU.dMa.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dLT, this.dLU.cXk);
        aj.e(this.dLU.dMb, d.C0141d.cp_cont_d, 1);
        if (com.baidu.tieba.card.j.ks(this.dLT.getTid())) {
            aj.e(this.dLU.cXg, d.C0141d.cp_cont_d, 1);
            aj.e(this.dLU.dMa, d.C0141d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dLU.cXg, d.C0141d.cp_cont_b, 1);
        aj.e(this.dLU.dMa, d.C0141d.cp_cont_j, 1);
    }

    private void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            SkinInfo zJ = bdVar.zJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLU.dLZ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLU.cmX.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dLU.cYK.setVisibility(8);
                if (this.dLU.cmY != null) {
                    if (zJ != null) {
                        this.dLU.cmY.a(this.mPageContext, zJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dLU.cmY.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dLU.cYK.setVisibility(0);
                this.dLU.cYK.setImageBitmap(null);
                this.dLU.cYK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dLU.cYK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dLU.cmY.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dLU.dLZ.setLayoutParams(layoutParams);
            this.dLU.cmX.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dLU != null) {
            if (view == this.dLU.mRootView || view == this.dLU.dMc.getCommentNumView() || view == this.dLU.cXk) {
                if (akO() != null) {
                    akO().a(this.dLU.mRootView, this.dLT);
                }
                alk();
            }
        }
    }

    private void alk() {
        PhotoLiveActivityConfig xD;
        if (this.dLT != null) {
            com.baidu.tieba.card.j.kr(this.dLT.getTid());
            if (!all()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dLT.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxS()) {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dLT.getTid()).cR("from_frs").eC(18003).cP(String.valueOf(this.dLT.zK())).xD();
            } else {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dLT.getTid()).cR("from_frs").eC(18003).xD();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, xD));
            kt(this.dLT.getTid());
        }
    }

    public void kt(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.n.a.a(tbPageContext, this.dLU.mRootView);
            this.dLU.dLI.onChangeSkinType();
            this.dLU.dMc.onChangeSkinType();
            aj.t(this.dLU.dLW, d.C0141d.cp_bg_line_c);
            aj.s(this.dLU.mRootView, d.f.addresslist_item_bg);
            if (this.dLU.cXk != null) {
                this.dLU.cXk.onChangeSkinType();
            }
            this.dLx.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean all() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWh != null) {
            this.cWh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWh);
        }
    }

    private void b(ar arVar) {
        this.bnZ.clear();
        Jt();
        if (arVar != null && arVar.zH() != null) {
            int size = arVar.zH().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.zH(), i);
                }
            }
            Js();
        }
    }

    private void Jt() {
        this.dLU.dMd.setText("");
        this.dLU.dMe.setText("");
        this.dLU.dMf.setText("");
        if (this.dLU.dMd.getVisibility() == 8) {
            this.dLU.dMd.setVisibility(0);
        }
        if (this.dLU.dMe.getVisibility() == 8) {
            this.dLU.dMe.setVisibility(0);
        }
        if (this.dLU.dMf.getVisibility() == 8) {
            this.dLU.dMf.setVisibility(0);
        }
        this.bnZ.add(Integer.valueOf(this.dLU.dMd.getId()));
        this.bnZ.add(Integer.valueOf(this.dLU.dMe.getId()));
        this.bnZ.add(Integer.valueOf(this.dLU.dMf.getId()));
    }

    private void Js() {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i = 0; i < size; i++) {
                if (this.bnZ.get(i).intValue() == this.dLU.dMd.getId()) {
                    this.dLU.dMd.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.dLU.dMe.getId()) {
                    this.dLU.dMe.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.dLU.dMf.getId()) {
                    this.dLU.dMf.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bnY) {
                case 0:
                    a(this.bok, this.bol, this.dLU.dMd);
                    a(this.bom, this.bon, this.dLU.dMe);
                    a(this.boo, this.bop, this.dLU.dMf);
                    break;
                case 1:
                    a(this.bop, this.boq, this.dLU.dMd);
                    a(this.bor, this.bop, this.dLU.dMe);
                    a(this.bos, this.bon, this.dLU.dMf);
                    break;
                case 2:
                    a(this.bop, this.bot, this.dLU.dMd);
                    a(this.bou, this.bop, this.dLU.dMe);
                    a(this.bos, this.bon, this.dLU.dMf);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dLU.dMd);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dLU.dMe);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dLU.dMf);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jj())));
            hq(textView.getId());
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

    private void hq(int i) {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bnZ.get(i2).intValue() == i) {
                    this.bnZ.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bdN;
        public TbImageView bdO;
        public TextView cXg;
        public TbImageView cXh;
        public View cXj;
        public CardGroupDividerView cXk;
        public TbImageView cYK;
        public LinearLayout cmX;
        public ThreadSkinView cmY;
        public UserIconLayout dLI;
        public View dLW;
        public RelativeLayout dLX;
        public HeadPendantClickableView dLY;
        public ClickableHeaderImageView dLZ;
        public TextView dMa;
        public TextView dMb;
        public ThreadCommentAndPraiseInfoLayout dMc;
        public TextView dMd;
        public TextView dMe;
        public TextView dMf;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

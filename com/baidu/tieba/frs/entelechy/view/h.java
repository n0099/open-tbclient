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
    private int boA;
    private int boB;
    private int boC;
    private int boD;
    private int boE;
    private int boF;
    private int boG;
    private int boH;
    private int bol;
    private ArrayList<Integer> bom;
    private int box;
    private int boy;
    private int boz;
    private CustomMessageListener cWt;
    private View.OnClickListener cXo;
    private View.OnClickListener cXp;
    private com.baidu.tieba.frs.g.g dLJ;
    private ar dMf;
    public a dMg;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bom = new ArrayList<>();
        this.bol = 0;
        this.cXo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.dMf);
                }
            }
        };
        this.cXp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.dMf);
                }
            }
        };
        this.cWt = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dMf != null && h.this.dMf != null && h.this.dMf.getTid() != null && h.this.dMg != null && h.this.dMg.cXs != null && h.this.dMg.dMn != null && ((String) customResponsedMessage.getData()).equals(h.this.dMf.getTid())) {
                    com.baidu.tieba.card.j.a(h.this.dMg.cXs, h.this.dMf.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                    com.baidu.tieba.card.j.a(h.this.dMg.dMn, h.this.dMf.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.box = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.boy = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.boz = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.boA = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.boB = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.boC = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.boD = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.boE = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.boF = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.boG = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.boH = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bu(getView());
        initUI();
    }

    private void bu(View view) {
        this.dMg = new a();
        this.dMg.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dMg.dMi = view.findViewById(d.g.top_line);
        this.dMg.dMj = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dMg.dMl = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dMg.dMk = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dMg.bdZ = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dMg.cnj = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dMg.dLU = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dMg.cXs = (TextView) view.findViewById(d.g.thread_title);
        this.dMg.dMm = (TextView) view.findViewById(d.g.thread_context);
        this.dMg.dMn = (TextView) view.findViewById(d.g.fans_num);
        this.dMg.cXt = (TbImageView) view.findViewById(d.g.thread_image);
        this.dMg.cXt.setPageId(getTag());
        this.dMg.dMo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dMg.cXv = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dMg.dMp = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dMg.dMq = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dMg.dMr = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dMg.cYW = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dMg.cYW.setPageId(getTag());
        this.dMg.cnk = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dMg.cXw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dMg.cXw.setTitleClickListener(this);
        this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dMg.mRootView);
        this.dLJ.setUniqueId(getTag());
    }

    private void initUI() {
        this.dMg.dMl.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dMg.dMl.setDefaultResource(17170445);
        this.dMg.dMl.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMg.dMl.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dMg.dMk.DT();
        this.dMg.dMk.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dMg.dMk.getHeadView().setDefaultResource(17170445);
        this.dMg.dMk.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMg.dMk.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dMg.dMk.getHeadView().setIsRound(true);
        this.dMg.dMk.getHeadView().setDrawBorder(false);
        this.dMg.dMk.getPendantView().setIsRound(true);
        this.dMg.dMk.getPendantView().setDrawBorder(false);
        this.dMg.dMo.setShowPraiseNum(false);
        this.dMg.dMo.setFrom(2);
        this.dMg.cXt.setDrawBorder(true);
        this.dMg.cXt.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.dMf = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dMf == null) {
            this.dMg.mRootView.setVisibility(8);
            return;
        }
        if (this.dMf.zn() == null || this.dMf.zn().getPendantData() == null || StringUtils.isNull(this.dMf.zn().getPendantData().ya())) {
            if (this.dMf.zn() != null && this.dMf.zn().getGodUserData() != null && this.dMf.zn().getGodUserData().getType() == 2) {
                this.dMg.dMl.setGodIconMargin(0);
            } else {
                this.dMg.dMl.setIsGod(false);
            }
            UserTbVipInfoData zo = this.dMf.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.dMg.bdZ != null) {
                    if (this.dMg.bea == null) {
                        this.dMg.bdZ.inflate();
                        this.dMg.bea = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dMg.bea.setPageId(getTag());
                    this.dMg.bea.setVisibility(0);
                    this.dMg.bea.startLoad(zo.getvipV_url(), 10, false);
                    this.dMg.dMl.setIsBigV(true);
                }
            } else {
                this.dMg.dMl.setIsBigV(false);
                if (this.dMg.bea != null) {
                    this.dMg.bea.setVisibility(8);
                }
            }
            this.dMg.dMl.setData(this.dMf);
            this.dMg.dMl.setAfterClickListener(this.cXo);
            this.dMg.dMl.setVisibility(0);
            this.dMg.dMk.setVisibility(8);
        } else {
            this.dMg.dMl.setIsGod(false);
            this.dMg.dMl.setIsBigV(false);
            if (this.dMg.bea != null) {
                this.dMg.bea.setVisibility(8);
            }
            this.dMg.dMl.setVisibility(4);
            this.dMg.dMk.setVisibility(0);
            this.dMg.dMk.setData(this.dMf);
        }
        if (this.dMf.zn() != null && !StringUtils.isNull(this.dMf.zn().getSealPrefix())) {
            this.dMg.dLU.by(true);
        }
        this.dMg.dLU.setData(this.dMf);
        this.dMg.dLU.setUserNameTextSizeRid(d.e.fontsize24);
        this.dMg.dLU.setUserAfterClickListener(this.cXo);
        this.dMg.dLU.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dMf.getTitle())) {
            int length = this.dMf.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dMf.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dMg.cXs.setSingleLine(true);
        } else {
            this.dMg.cXs.setMaxLines(2);
        }
        this.dMf.h(false, true);
        this.dMg.cXs.setText(this.dMf.zN());
        String fansNickName = this.dMf.zn().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dMg.dMn.setText(fansNickName + ": " + am.C(this.dMf.zn().getFansNum()));
        if (this.dMg.dMo.setData(this.dMf)) {
            this.dMg.cXv.setVisibility(8);
        } else {
            this.dMg.cXv.setVisibility(0);
        }
        this.dMg.dMo.setForumAfterClickListener(this.cXp);
        this.dMg.dMo.setStType("frs_page");
        K(this.dMf);
        this.dLJ.W(this.dMf);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.dMf.getPhotoLiveCover() != null && this.dMf.getPhotoLiveCover().length() != 0) {
            this.dMg.cXt.setVisibility(0);
            this.dMg.dMm.setVisibility(8);
            this.dMg.cXt.startLoad(this.dMf.getPhotoLiveCover(), 10, false);
            b(this.dMf);
        } else {
            this.dMg.cXt.setVisibility(8);
            this.dMg.dMp.setVisibility(8);
            this.dMg.dMq.setVisibility(8);
            this.dMg.dMr.setVisibility(8);
            String str = this.dMf.getAbstract();
            this.dMg.dMm.setText(str);
            this.dMg.dMm.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dMf, this.dMg.cXw);
        aj.e(this.dMg.dMn, d.C0140d.cp_cont_d, 1);
        if (com.baidu.tieba.card.j.ks(this.dMf.getTid())) {
            aj.e(this.dMg.cXs, d.C0140d.cp_cont_d, 1);
            aj.e(this.dMg.dMm, d.C0140d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dMg.cXs, d.C0140d.cp_cont_b, 1);
        aj.e(this.dMg.dMm, d.C0140d.cp_cont_j, 1);
    }

    private void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            SkinInfo zJ = bdVar.zJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dMg.dMl.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dMg.cnj.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dMg.cYW.setVisibility(8);
                if (this.dMg.cnk != null) {
                    if (zJ != null) {
                        this.dMg.cnk.a(this.mPageContext, zJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dMg.cnk.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dMg.cYW.setVisibility(0);
                this.dMg.cYW.setImageBitmap(null);
                this.dMg.cYW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dMg.cYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dMg.cnk.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dMg.dMl.setLayoutParams(layoutParams);
            this.dMg.cnj.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dMg != null) {
            if (view == this.dMg.mRootView || view == this.dMg.dMo.getCommentNumView() || view == this.dMg.cXw) {
                if (akP() != null) {
                    akP().a(this.dMg.mRootView, this.dMf);
                }
                all();
            }
        }
    }

    private void all() {
        PhotoLiveActivityConfig xD;
        if (this.dMf != null) {
            com.baidu.tieba.card.j.kr(this.dMf.getTid());
            if (!alm()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dMf.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxT()) {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dMf.getTid()).cR("from_frs").eC(18003).cP(String.valueOf(this.dMf.zK())).xD();
            } else {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dMf.getTid()).cR("from_frs").eC(18003).xD();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, xD));
            kt(this.dMf.getTid());
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.dMg.mRootView);
            this.dMg.dLU.onChangeSkinType();
            this.dMg.dMo.onChangeSkinType();
            aj.t(this.dMg.dMi, d.C0140d.cp_bg_line_c);
            aj.s(this.dMg.mRootView, d.f.addresslist_item_bg);
            if (this.dMg.cXw != null) {
                this.dMg.cXw.onChangeSkinType();
            }
            this.dLJ.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean alm() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWt != null) {
            this.cWt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWt);
        }
    }

    private void b(ar arVar) {
        this.bom.clear();
        Ju();
        if (arVar != null && arVar.zH() != null) {
            int size = arVar.zH().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.zH(), i);
                }
            }
            Jt();
        }
    }

    private void Ju() {
        this.dMg.dMp.setText("");
        this.dMg.dMq.setText("");
        this.dMg.dMr.setText("");
        if (this.dMg.dMp.getVisibility() == 8) {
            this.dMg.dMp.setVisibility(0);
        }
        if (this.dMg.dMq.getVisibility() == 8) {
            this.dMg.dMq.setVisibility(0);
        }
        if (this.dMg.dMr.getVisibility() == 8) {
            this.dMg.dMr.setVisibility(0);
        }
        this.bom.add(Integer.valueOf(this.dMg.dMp.getId()));
        this.bom.add(Integer.valueOf(this.dMg.dMq.getId()));
        this.bom.add(Integer.valueOf(this.dMg.dMr.getId()));
    }

    private void Jt() {
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i = 0; i < size; i++) {
                if (this.bom.get(i).intValue() == this.dMg.dMp.getId()) {
                    this.dMg.dMp.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.dMg.dMq.getId()) {
                    this.dMg.dMq.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.dMg.dMr.getId()) {
                    this.dMg.dMr.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bol) {
                case 0:
                    a(this.box, this.boy, this.dMg.dMp);
                    a(this.boz, this.boA, this.dMg.dMq);
                    a(this.boB, this.boC, this.dMg.dMr);
                    break;
                case 1:
                    a(this.boC, this.boD, this.dMg.dMp);
                    a(this.boE, this.boC, this.dMg.dMq);
                    a(this.boF, this.boA, this.dMg.dMr);
                    break;
                case 2:
                    a(this.boC, this.boG, this.dMg.dMp);
                    a(this.boH, this.boC, this.dMg.dMq);
                    a(this.boF, this.boA, this.dMg.dMr);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dMg.dMp);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dMg.dMq);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dMg.dMr);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jk())));
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
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bom.get(i2).intValue() == i) {
                    this.bom.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bdZ;
        public TbImageView bea;
        public TextView cXs;
        public TbImageView cXt;
        public View cXv;
        public CardGroupDividerView cXw;
        public TbImageView cYW;
        public LinearLayout cnj;
        public ThreadSkinView cnk;
        public UserIconLayout dLU;
        public View dMi;
        public RelativeLayout dMj;
        public HeadPendantClickableView dMk;
        public ClickableHeaderImageView dMl;
        public TextView dMm;
        public TextView dMn;
        public ThreadCommentAndPraiseInfoLayout dMo;
        public TextView dMp;
        public TextView dMq;
        public TextView dMr;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

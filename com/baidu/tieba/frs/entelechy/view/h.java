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
    private int bob;
    private ArrayList<Integer> boc;
    private int bon;
    private int boo;
    private int bop;
    private int boq;
    private int bor;
    private int bos;
    private int bot;
    private int bou;
    private int bov;
    private int bow;
    private int box;
    private CustomMessageListener cWk;
    private View.OnClickListener cXf;
    private View.OnClickListener cXg;
    private com.baidu.tieba.frs.g.g dLC;
    private ar dLY;
    public a dLZ;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.boc = new ArrayList<>();
        this.bob = 0;
        this.cXf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.dLY);
                }
            }
        };
        this.cXg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akP() != null) {
                    h.this.akP().a(view, h.this.dLY);
                }
            }
        };
        this.cWk = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dLY != null && h.this.dLY != null && h.this.dLY.getTid() != null && h.this.dLZ != null && h.this.dLZ.cXj != null && h.this.dLZ.dMg != null && ((String) customResponsedMessage.getData()).equals(h.this.dLY.getTid())) {
                    com.baidu.tieba.card.j.a(h.this.dLZ.cXj, h.this.dLY.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                    com.baidu.tieba.card.j.a(h.this.dLZ.dMg, h.this.dLY.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.bon = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.boo = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.bop = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.boq = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.bor = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.bos = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.bot = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.bou = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.bov = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.bow = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.box = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bu(getView());
        initUI();
    }

    private void bu(View view) {
        this.dLZ = new a();
        this.dLZ.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dLZ.dMb = view.findViewById(d.g.top_line);
        this.dLZ.dMc = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dLZ.dMe = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dLZ.dMd = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dLZ.bdQ = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dLZ.cna = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dLZ.dLN = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dLZ.cXj = (TextView) view.findViewById(d.g.thread_title);
        this.dLZ.dMf = (TextView) view.findViewById(d.g.thread_context);
        this.dLZ.dMg = (TextView) view.findViewById(d.g.fans_num);
        this.dLZ.cXk = (TbImageView) view.findViewById(d.g.thread_image);
        this.dLZ.cXk.setPageId(getTag());
        this.dLZ.dMh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dLZ.cXm = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dLZ.dMi = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dLZ.dMj = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dLZ.dMk = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dLZ.cYN = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dLZ.cYN.setPageId(getTag());
        this.dLZ.cnb = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dLZ.cXn = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dLZ.cXn.setTitleClickListener(this);
        this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLZ.mRootView);
        this.dLC.setUniqueId(getTag());
    }

    private void initUI() {
        this.dLZ.dMe.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dLZ.dMe.setDefaultResource(17170445);
        this.dLZ.dMe.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dLZ.dMe.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dLZ.dMd.DT();
        this.dLZ.dMd.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dLZ.dMd.getHeadView().setDefaultResource(17170445);
        this.dLZ.dMd.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dLZ.dMd.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dLZ.dMd.getHeadView().setIsRound(true);
        this.dLZ.dMd.getHeadView().setDrawBorder(false);
        this.dLZ.dMd.getPendantView().setIsRound(true);
        this.dLZ.dMd.getPendantView().setDrawBorder(false);
        this.dLZ.dMh.setShowPraiseNum(false);
        this.dLZ.dMh.setFrom(2);
        this.dLZ.cXk.setDrawBorder(true);
        this.dLZ.cXk.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.dLY = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dLY == null) {
            this.dLZ.mRootView.setVisibility(8);
            return;
        }
        if (this.dLY.zn() == null || this.dLY.zn().getPendantData() == null || StringUtils.isNull(this.dLY.zn().getPendantData().ya())) {
            if (this.dLY.zn() != null && this.dLY.zn().getGodUserData() != null && this.dLY.zn().getGodUserData().getType() == 2) {
                this.dLZ.dMe.setGodIconMargin(0);
            } else {
                this.dLZ.dMe.setIsGod(false);
            }
            UserTbVipInfoData zo = this.dLY.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.dLZ.bdQ != null) {
                    if (this.dLZ.bdR == null) {
                        this.dLZ.bdQ.inflate();
                        this.dLZ.bdR = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dLZ.bdR.setPageId(getTag());
                    this.dLZ.bdR.setVisibility(0);
                    this.dLZ.bdR.startLoad(zo.getvipV_url(), 10, false);
                    this.dLZ.dMe.setIsBigV(true);
                }
            } else {
                this.dLZ.dMe.setIsBigV(false);
                if (this.dLZ.bdR != null) {
                    this.dLZ.bdR.setVisibility(8);
                }
            }
            this.dLZ.dMe.setData(this.dLY);
            this.dLZ.dMe.setAfterClickListener(this.cXf);
            this.dLZ.dMe.setVisibility(0);
            this.dLZ.dMd.setVisibility(8);
        } else {
            this.dLZ.dMe.setIsGod(false);
            this.dLZ.dMe.setIsBigV(false);
            if (this.dLZ.bdR != null) {
                this.dLZ.bdR.setVisibility(8);
            }
            this.dLZ.dMe.setVisibility(4);
            this.dLZ.dMd.setVisibility(0);
            this.dLZ.dMd.setData(this.dLY);
        }
        if (this.dLY.zn() != null && !StringUtils.isNull(this.dLY.zn().getSealPrefix())) {
            this.dLZ.dLN.by(true);
        }
        this.dLZ.dLN.setData(this.dLY);
        this.dLZ.dLN.setUserNameTextSizeRid(d.e.fontsize24);
        this.dLZ.dLN.setUserAfterClickListener(this.cXf);
        this.dLZ.dLN.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dLY.getTitle())) {
            int length = this.dLY.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dLY.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dLZ.cXj.setSingleLine(true);
        } else {
            this.dLZ.cXj.setMaxLines(2);
        }
        this.dLY.h(false, true);
        this.dLZ.cXj.setText(this.dLY.zN());
        String fansNickName = this.dLY.zn().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dLZ.dMg.setText(fansNickName + ": " + am.C(this.dLY.zn().getFansNum()));
        if (this.dLZ.dMh.setData(this.dLY)) {
            this.dLZ.cXm.setVisibility(8);
        } else {
            this.dLZ.cXm.setVisibility(0);
        }
        this.dLZ.dMh.setForumAfterClickListener(this.cXg);
        this.dLZ.dMh.setStType("frs_page");
        K(this.dLY);
        this.dLC.W(this.dLY);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.dLY.getPhotoLiveCover() != null && this.dLY.getPhotoLiveCover().length() != 0) {
            this.dLZ.cXk.setVisibility(0);
            this.dLZ.dMf.setVisibility(8);
            this.dLZ.cXk.startLoad(this.dLY.getPhotoLiveCover(), 10, false);
            b(this.dLY);
        } else {
            this.dLZ.cXk.setVisibility(8);
            this.dLZ.dMi.setVisibility(8);
            this.dLZ.dMj.setVisibility(8);
            this.dLZ.dMk.setVisibility(8);
            String str = this.dLY.getAbstract();
            this.dLZ.dMf.setText(str);
            this.dLZ.dMf.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dLY, this.dLZ.cXn);
        aj.e(this.dLZ.dMg, d.C0141d.cp_cont_d, 1);
        if (com.baidu.tieba.card.j.ks(this.dLY.getTid())) {
            aj.e(this.dLZ.cXj, d.C0141d.cp_cont_d, 1);
            aj.e(this.dLZ.dMf, d.C0141d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dLZ.cXj, d.C0141d.cp_cont_b, 1);
        aj.e(this.dLZ.dMf, d.C0141d.cp_cont_j, 1);
    }

    private void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            SkinInfo zJ = bdVar.zJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLZ.dMe.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLZ.cna.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dLZ.cYN.setVisibility(8);
                if (this.dLZ.cnb != null) {
                    if (zJ != null) {
                        this.dLZ.cnb.a(this.mPageContext, zJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dLZ.cnb.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dLZ.cYN.setVisibility(0);
                this.dLZ.cYN.changeGrayScaleMode(bdVar.AC());
                this.dLZ.cYN.setImageBitmap(null);
                this.dLZ.cYN.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dLZ.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dLZ.cnb.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dLZ.dMe.setLayoutParams(layoutParams);
            this.dLZ.cna.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dLZ != null) {
            if (view == this.dLZ.mRootView || view == this.dLZ.dMh.getCommentNumView() || view == this.dLZ.cXn) {
                if (akP() != null) {
                    akP().a(this.dLZ.mRootView, this.dLY);
                }
                all();
            }
        }
    }

    private void all() {
        PhotoLiveActivityConfig xD;
        if (this.dLY != null) {
            com.baidu.tieba.card.j.kr(this.dLY.getTid());
            if (!alm()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dLY.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxX()) {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dLY.getTid()).cR("from_frs").eC(18003).cP(String.valueOf(this.dLY.zK())).xD();
            } else {
                xD = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dLY.getTid()).cR("from_frs").eC(18003).xD();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, xD));
            kt(this.dLY.getTid());
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.dLZ.mRootView);
            this.dLZ.dLN.onChangeSkinType();
            this.dLZ.dMh.onChangeSkinType();
            aj.t(this.dLZ.dMb, d.C0141d.cp_bg_line_c);
            aj.s(this.dLZ.mRootView, d.f.addresslist_item_bg);
            if (this.dLZ.cXn != null) {
                this.dLZ.cXn.onChangeSkinType();
            }
            this.dLC.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean alm() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWk != null) {
            this.cWk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWk);
        }
    }

    private void b(ar arVar) {
        this.boc.clear();
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
        this.dLZ.dMi.setText("");
        this.dLZ.dMj.setText("");
        this.dLZ.dMk.setText("");
        if (this.dLZ.dMi.getVisibility() == 8) {
            this.dLZ.dMi.setVisibility(0);
        }
        if (this.dLZ.dMj.getVisibility() == 8) {
            this.dLZ.dMj.setVisibility(0);
        }
        if (this.dLZ.dMk.getVisibility() == 8) {
            this.dLZ.dMk.setVisibility(0);
        }
        this.boc.add(Integer.valueOf(this.dLZ.dMi.getId()));
        this.boc.add(Integer.valueOf(this.dLZ.dMj.getId()));
        this.boc.add(Integer.valueOf(this.dLZ.dMk.getId()));
    }

    private void Jt() {
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i = 0; i < size; i++) {
                if (this.boc.get(i).intValue() == this.dLZ.dMi.getId()) {
                    this.dLZ.dMi.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.dLZ.dMj.getId()) {
                    this.dLZ.dMj.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.dLZ.dMk.getId()) {
                    this.dLZ.dMk.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bob) {
                case 0:
                    a(this.bon, this.boo, this.dLZ.dMi);
                    a(this.bop, this.boq, this.dLZ.dMj);
                    a(this.bor, this.bos, this.dLZ.dMk);
                    break;
                case 1:
                    a(this.bos, this.bot, this.dLZ.dMi);
                    a(this.bou, this.bos, this.dLZ.dMj);
                    a(this.bov, this.boq, this.dLZ.dMk);
                    break;
                case 2:
                    a(this.bos, this.bow, this.dLZ.dMi);
                    a(this.box, this.bos, this.dLZ.dMj);
                    a(this.bov, this.boq, this.dLZ.dMk);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dLZ.dMi);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dLZ.dMj);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dLZ.dMk);
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
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.boc.get(i2).intValue() == i) {
                    this.boc.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bdQ;
        public TbImageView bdR;
        public TextView cXj;
        public TbImageView cXk;
        public View cXm;
        public CardGroupDividerView cXn;
        public TbImageView cYN;
        public LinearLayout cna;
        public ThreadSkinView cnb;
        public UserIconLayout dLN;
        public View dMb;
        public RelativeLayout dMc;
        public HeadPendantClickableView dMd;
        public ClickableHeaderImageView dMe;
        public TextView dMf;
        public TextView dMg;
        public ThreadCommentAndPraiseInfoLayout dMh;
        public TextView dMi;
        public TextView dMj;
        public TextView dMk;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

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
    private int axE;
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axs;
    private ArrayList<Integer> axt;
    private CustomMessageListener bKn;
    private View.OnClickListener bLv;
    private View.OnClickListener bLw;
    private com.baidu.tieba.frs.h.g cvV;
    private ax cwj;
    public a cwk;
    private TbPageContext<?> mF;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.axt = new ArrayList<>();
        this.axs = 0;
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.XA() != null) {
                    h.this.XA().a(view, h.this.cwj);
                }
            }
        };
        this.bLw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.XA() != null) {
                    h.this.XA().a(view, h.this.cwj);
                }
            }
        };
        this.bKn = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cwj != null && h.this.cwj != null && h.this.cwj.getTid() != null && h.this.cwk != null && h.this.cwk.bJb != null && h.this.cwk.cwr != null && ((String) customResponsedMessage.getData()).equals(h.this.cwj.getTid())) {
                    m.a(h.this.cwk.bJb, h.this.cwj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cwk.cwr, h.this.cwj.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.axE = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.axF = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.axG = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.axH = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.axI = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.axJ = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.axK = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.axL = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.axM = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.axN = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.axO = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.cwk = new a();
        this.cwk.mRootView = view.findViewById(d.h.card_root_view);
        this.cwk.cwm = view.findViewById(d.h.top_line);
        this.cwk.cwn = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cwk.cwp = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cwk.cwo = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cwk.aot = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cwk.blD = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cwk.bLo = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cwk.bJb = (TextView) view.findViewById(d.h.thread_title);
        this.cwk.cwq = (TextView) view.findViewById(d.h.thread_context);
        this.cwk.cwr = (TextView) view.findViewById(d.h.fans_num);
        this.cwk.bLy = (TbImageView) view.findViewById(d.h.thread_image);
        this.cwk.bLy.setPageId(getTag());
        this.cwk.cws = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cwk.bLA = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cwk.cwt = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cwk.cwu = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cwk.cwv = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cwk.crf = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cwk.crf.setPageId(getTag());
        this.cwk.blE = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cwk.cws.setCommentNumClickListener(this);
        this.cwk.bKa = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cwk.bKa.setTitleClickListener(this);
        this.cwk.cws.setViewNumEnabled(true);
        this.cvV = new com.baidu.tieba.frs.h.g(this.mF, this.cwk.cws);
        this.cvV.setUniqueId(getTag());
    }

    private void initUI() {
        this.cwk.cwp.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        this.cwk.cwp.setDefaultResource(17170445);
        this.cwk.cwp.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cwk.cwp.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cwk.cwo.wB();
        this.cwk.cwo.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        this.cwk.cwo.getHeadView().setDefaultResource(17170445);
        this.cwk.cwo.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cwk.cwo.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cwk.cwo.getHeadView().setIsRound(true);
        this.cwk.cwo.getHeadView().setDrawBorder(false);
        this.cwk.cwo.getPendantView().setIsRound(true);
        this.cwk.cwo.getPendantView().setDrawBorder(false);
        this.cwk.cws.setShowPraiseNum(false);
        this.cwk.cws.setFrom(2);
        this.cwk.bLy.setDrawBorder(true);
        this.cwk.bLy.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.cwj = axVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cwj == null) {
            this.cwk.mRootView.setVisibility(8);
            return;
        }
        if (this.cwj.getAuthor() == null || this.cwj.getAuthor().getPendantData() == null || StringUtils.isNull(this.cwj.getAuthor().getPendantData().pR())) {
            if (this.cwj.getAuthor() != null && this.cwj.getAuthor().getGodUserData() != null && this.cwj.getAuthor().getGodUserData().getType() == 2) {
                this.cwk.cwp.setGodIconMargin(0);
            } else {
                this.cwk.cwp.setIsGod(false);
            }
            UserTbVipInfoData rB = this.cwj.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.cwk.aot != null) {
                    if (this.cwk.aou == null) {
                        this.cwk.aot.inflate();
                        this.cwk.aou = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cwk.aou.setPageId(getTag());
                    this.cwk.aou.setVisibility(0);
                    this.cwk.aou.c(rB.getvipV_url(), 10, false);
                    this.cwk.cwp.setIsBigV(true);
                }
            } else {
                this.cwk.cwp.setIsBigV(false);
                if (this.cwk.aou != null) {
                    this.cwk.aou.setVisibility(8);
                }
            }
            this.cwk.cwp.setData(this.cwj);
            this.cwk.cwp.setAfterClickListener(this.bLv);
            this.cwk.cwp.setVisibility(0);
            this.cwk.cwo.setVisibility(8);
        } else {
            this.cwk.cwp.setIsGod(false);
            this.cwk.cwp.setIsBigV(false);
            if (this.cwk.aou != null) {
                this.cwk.aou.setVisibility(8);
            }
            this.cwk.cwp.setVisibility(4);
            this.cwk.cwo.setVisibility(0);
            this.cwk.cwo.setData(this.cwj);
        }
        if (this.cwj.getAuthor() != null && !StringUtils.isNull(this.cwj.getAuthor().getSealPrefix())) {
            this.cwk.bLo.aP(true);
        }
        this.cwk.bLo.setData(this.cwj);
        this.cwk.bLo.setUserNameTextSizeRid(d.f.fontsize24);
        this.cwk.bLo.setUserAfterClickListener(this.bLv);
        this.cwk.bLo.setPageName(1);
        Resources resources = this.mF.getResources();
        if (!StringUtils.isNull(this.cwj.getTitle())) {
            int length = this.cwj.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cwj.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cwk.bJb.setSingleLine(true);
        } else {
            this.cwk.bJb.setMaxLines(2);
        }
        this.cwj.e(false, true);
        this.cwk.bJb.setText(this.cwj.sb());
        String fansNickName = this.cwj.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cwk.cwr.setText(fansNickName + ": " + am.u(this.cwj.getAuthor().getFansNum()));
        if (this.cwk.cws.c(this.cwj)) {
            this.cwk.bLA.setVisibility(8);
        } else {
            this.cwk.bLA.setVisibility(0);
        }
        this.cwk.cws.setForumAfterClickListener(this.bLw);
        this.cwk.cws.setStType(m.rs());
        K(this.cwj);
        this.cvV.T(this.cwj);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oS().oY() && this.cwj.getPhotoLiveCover() != null && this.cwj.getPhotoLiveCover().length() != 0) {
            this.cwk.bLy.setVisibility(0);
            this.cwk.cwq.setVisibility(8);
            this.cwk.bLy.c(this.cwj.getPhotoLiveCover(), 10, false);
            b(this.cwj);
        } else {
            this.cwk.bLy.setVisibility(8);
            this.cwk.cwt.setVisibility(8);
            this.cwk.cwu.setVisibility(8);
            this.cwk.cwv.setVisibility(8);
            String rJ = this.cwj.rJ();
            this.cwk.cwq.setText(rJ);
            this.cwk.cwq.setVisibility(StringUtils.isNull(rJ) ? 8 : 0);
        }
        b.a(this.cwj, this.cwk.bKa);
        aj.c(this.cwk.cwr, d.e.cp_cont_d, 1);
        if (m.jt(this.cwj.getTid())) {
            aj.c(this.cwk.bJb, d.e.cp_cont_d, 1);
            aj.c(this.cwk.cwq, d.e.cp_cont_d, 1);
            return;
        }
        aj.c(this.cwk.bJb, d.e.cp_cont_b, 1);
        aj.c(this.cwk.cwq, d.e.cp_cont_j, 1);
    }

    private void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rW = bjVar.rW();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cwk.cwp.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cwk.blD.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cwk.crf.setVisibility(8);
                if (this.cwk.blE != null) {
                    if (rW != null) {
                        this.cwk.blE.a(this.mF, rW, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rG(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds16);
                    } else {
                        this.cwk.blE.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cwk.crf.setVisibility(0);
                this.cwk.crf.setImageBitmap(null);
                this.cwk.crf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cwk.crf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mF.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cwk.blE.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds30);
            }
            this.cwk.cwp.setLayoutParams(layoutParams);
            this.cwk.blD.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwk != null) {
            if (view == this.cwk.mRootView || view == this.cwk.cws.getCommentNumView() || view == this.cwk.bKa) {
                if (XA() != null) {
                    XA().a(this.cwk.mRootView, this.cwj);
                }
                XT();
            }
        }
    }

    private void XT() {
        PhotoLiveActivityConfig pi;
        if (this.cwj != null) {
            m.js(this.cwj.getTid());
            if (!XU()) {
                UtilHelper.showToast(this.mF.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cwj.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btm()) {
                pi = new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.cwj.getTid()).cu("from_frs").bB(18003).cs(String.valueOf(this.cwj.rX())).pi();
            } else {
                pi = new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.cwj.getTid()).cu("from_frs").bB(18003).pi();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pi));
            ju(this.cwj.getTid());
        }
    }

    public void ju(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.cwk.mRootView);
            this.cwk.bLo.onChangeSkinType();
            this.cwk.cws.onChangeSkinType();
            aj.k(this.cwk.cwm, d.e.cp_bg_line_c);
            aj.j(this.cwk.mRootView, d.g.addresslist_item_bg);
            if (this.cwk.bKa != null) {
                this.cwk.bKa.onChangeSkinType();
            }
            this.cvV.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean XU() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bKn != null) {
            this.bKn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKn);
        }
    }

    private void b(ax axVar) {
        this.axt.clear();
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
        this.cwk.cwt.setText("");
        this.cwk.cwu.setText("");
        this.cwk.cwv.setText("");
        if (this.cwk.cwt.getVisibility() == 8) {
            this.cwk.cwt.setVisibility(0);
        }
        if (this.cwk.cwu.getVisibility() == 8) {
            this.cwk.cwu.setVisibility(0);
        }
        if (this.cwk.cwv.getVisibility() == 8) {
            this.cwk.cwv.setVisibility(0);
        }
        this.axt.add(Integer.valueOf(this.cwk.cwt.getId()));
        this.axt.add(Integer.valueOf(this.cwk.cwu.getId()));
        this.axt.add(Integer.valueOf(this.cwk.cwv.getId()));
    }

    private void Bw() {
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i = 0; i < size; i++) {
                if (this.axt.get(i).intValue() == this.cwk.cwt.getId()) {
                    this.cwk.cwt.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.cwk.cwu.getId()) {
                    this.cwk.cwu.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.cwk.cwv.getId()) {
                    this.cwk.cwv.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axs) {
                case 0:
                    a(this.axE, this.axF, this.cwk.cwt);
                    a(this.axG, this.axH, this.cwk.cwu);
                    a(this.axI, this.axJ, this.cwk.cwv);
                    break;
                case 1:
                    a(this.axJ, this.axK, this.cwk.cwt);
                    a(this.axL, this.axJ, this.cwk.cwu);
                    a(this.axM, this.axH, this.cwk.cwv);
                    break;
                case 2:
                    a(this.axJ, this.axN, this.cwk.cwt);
                    a(this.axO, this.axJ, this.cwk.cwu);
                    a(this.axM, this.axH, this.cwk.cwv);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cwk.cwt);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cwk.cwu);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cwk.cwv);
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
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axt.get(i2).intValue() == i) {
                    this.axt.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aot;
        public TbImageView aou;
        public TextView bJb;
        public CardGroupDividerView bKa;
        public View bLA;
        public UserIconLayout bLo;
        public TbImageView bLy;
        public LinearLayout blD;
        public ThreadSkinView blE;
        public TbImageView crf;
        public View cwm;
        public RelativeLayout cwn;
        public HeadPendantClickableView cwo;
        public ClickableHeaderImageView cwp;
        public TextView cwq;
        public TextView cwr;
        public ThreadCommentAndPraiseInfoLayout cws;
        public TextView cwt;
        public TextView cwu;
        public TextView cwv;
        public View mRootView;

        public a() {
        }
    }
}

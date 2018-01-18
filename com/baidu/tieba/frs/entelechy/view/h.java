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
public class h extends com.baidu.tieba.card.a<ar> {
    private int blP;
    private ArrayList<Integer> blQ;
    private int bmb;
    private int bmc;
    private int bmd;
    private int bme;
    private int bmf;
    private int bmg;
    private int bmh;
    private int bmi;
    private int bmj;
    private int bmk;
    private int bml;
    private CustomMessageListener cTp;
    private View.OnClickListener cUk;
    private View.OnClickListener cUl;
    private ar dIJ;
    public a dIK;
    private com.baidu.tieba.frs.f.g dIn;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.blQ = new ArrayList<>();
        this.blP = 0;
        this.cUk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akb() != null) {
                    h.this.akb().a(view, h.this.dIJ);
                }
            }
        };
        this.cUl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akb() != null) {
                    h.this.akb().a(view, h.this.dIJ);
                }
            }
        };
        this.cTp = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dIJ != null && h.this.dIJ != null && h.this.dIJ.getTid() != null && h.this.dIK != null && h.this.dIK.cTe != null && h.this.dIK.dIR != null && ((String) customResponsedMessage.getData()).equals(h.this.dIJ.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.dIK.cTe, h.this.dIJ.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.dIK.dIR, h.this.dIJ.getId(), d.C0107d.cp_cont_j, d.C0107d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.bmb = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.bmc = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.bmd = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.bme = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.bmf = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.bmg = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.bmh = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.bmi = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.bmj = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.bmk = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.bml = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bv(getView());
        initUI();
    }

    private void bv(View view) {
        this.dIK = new a();
        this.dIK.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dIK.dIM = view.findViewById(d.g.top_line);
        this.dIK.dIN = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dIK.dIP = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dIK.dIO = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dIK.bcb = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dIK.cjI = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dIK.dIy = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dIK.cTe = (TextView) view.findViewById(d.g.thread_title);
        this.dIK.dIQ = (TextView) view.findViewById(d.g.thread_context);
        this.dIK.dIR = (TextView) view.findViewById(d.g.fans_num);
        this.dIK.cUo = (TbImageView) view.findViewById(d.g.thread_image);
        this.dIK.cUo.setPageId(getTag());
        this.dIK.dIS = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dIK.cUq = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dIK.dIT = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dIK.dIU = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dIK.dIV = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dIK.cVQ = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dIK.cVQ.setPageId(getTag());
        this.dIK.cjJ = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dIK.cSX = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dIK.cSX.setTitleClickListener(this);
        this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dIK.mRootView);
        this.dIn.setUniqueId(getTag());
    }

    private void initUI() {
        this.dIK.dIP.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dIK.dIP.setDefaultResource(17170445);
        this.dIK.dIP.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dIK.dIP.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.dIK.dIO.Dx();
        this.dIK.dIO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dIK.dIO.getHeadView().setDefaultResource(17170445);
        this.dIK.dIO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dIK.dIO.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.dIK.dIO.getHeadView().setIsRound(true);
        this.dIK.dIO.getHeadView().setDrawBorder(false);
        this.dIK.dIO.getPendantView().setIsRound(true);
        this.dIK.dIO.getPendantView().setDrawBorder(false);
        this.dIK.dIS.setShowPraiseNum(false);
        this.dIK.dIS.setFrom(2);
        this.dIK.cUo.setDrawBorder(true);
        this.dIK.cUo.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.dIJ = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dIJ == null) {
            this.dIK.mRootView.setVisibility(8);
            return;
        }
        if (this.dIJ.yS() == null || this.dIJ.yS().getPendantData() == null || StringUtils.isNull(this.dIJ.yS().getPendantData().xt())) {
            if (this.dIJ.yS() != null && this.dIJ.yS().getGodUserData() != null && this.dIJ.yS().getGodUserData().getType() == 2) {
                this.dIK.dIP.setGodIconMargin(0);
            } else {
                this.dIK.dIP.setIsGod(false);
            }
            UserTbVipInfoData yT = this.dIJ.yT();
            if (yT != null && yT.getvipV_url() != null) {
                if (this.dIK.bcb != null) {
                    if (this.dIK.bcc == null) {
                        this.dIK.bcb.inflate();
                        this.dIK.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dIK.bcc.setPageId(getTag());
                    this.dIK.bcc.setVisibility(0);
                    this.dIK.bcc.startLoad(yT.getvipV_url(), 10, false);
                    this.dIK.dIP.setIsBigV(true);
                }
            } else {
                this.dIK.dIP.setIsBigV(false);
                if (this.dIK.bcc != null) {
                    this.dIK.bcc.setVisibility(8);
                }
            }
            this.dIK.dIP.setData(this.dIJ);
            this.dIK.dIP.setAfterClickListener(this.cUk);
            this.dIK.dIP.setVisibility(0);
            this.dIK.dIO.setVisibility(8);
        } else {
            this.dIK.dIP.setIsGod(false);
            this.dIK.dIP.setIsBigV(false);
            if (this.dIK.bcc != null) {
                this.dIK.bcc.setVisibility(8);
            }
            this.dIK.dIP.setVisibility(4);
            this.dIK.dIO.setVisibility(0);
            this.dIK.dIO.setData(this.dIJ);
        }
        if (this.dIJ.yS() != null && !StringUtils.isNull(this.dIJ.yS().getSealPrefix())) {
            this.dIK.dIy.bs(true);
        }
        this.dIK.dIy.setData(this.dIJ);
        this.dIK.dIy.setUserNameTextSizeRid(d.e.fontsize24);
        this.dIK.dIy.setUserAfterClickListener(this.cUk);
        this.dIK.dIy.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dIJ.getTitle())) {
            int length = this.dIJ.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dIJ.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dIK.cTe.setSingleLine(true);
        } else {
            this.dIK.cTe.setMaxLines(2);
        }
        this.dIJ.h(false, true);
        this.dIK.cTe.setText(this.dIJ.zs());
        String fansNickName = this.dIJ.yS().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dIK.dIR.setText(fansNickName + ": " + am.C(this.dIJ.yS().getFansNum()));
        if (this.dIK.dIS.setData(this.dIJ)) {
            this.dIK.cUq.setVisibility(8);
        } else {
            this.dIK.cUq.setVisibility(0);
        }
        this.dIK.dIS.setForumAfterClickListener(this.cUl);
        this.dIK.dIS.setStType("frs_page");
        H(this.dIJ);
        this.dIn.T(this.dIJ);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wA().wG() && this.dIJ.getPhotoLiveCover() != null && this.dIJ.getPhotoLiveCover().length() != 0) {
            this.dIK.cUo.setVisibility(0);
            this.dIK.dIQ.setVisibility(8);
            this.dIK.cUo.startLoad(this.dIJ.getPhotoLiveCover(), 10, false);
            b(this.dIJ);
        } else {
            this.dIK.cUo.setVisibility(8);
            this.dIK.dIT.setVisibility(8);
            this.dIK.dIU.setVisibility(8);
            this.dIK.dIV.setVisibility(8);
            String str = this.dIJ.getAbstract();
            this.dIK.dIQ.setText(str);
            this.dIK.dIQ.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dIJ, this.dIK.cSX);
        aj.e(this.dIK.dIR, d.C0107d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.kd(this.dIJ.getTid())) {
            aj.e(this.dIK.cTe, d.C0107d.cp_cont_d, 1);
            aj.e(this.dIK.dIQ, d.C0107d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dIK.cTe, d.C0107d.cp_cont_b, 1);
        aj.e(this.dIK.dIQ, d.C0107d.cp_cont_j, 1);
    }

    private void H(bd bdVar) {
        MetaData yS;
        if (bdVar != null && (yS = bdVar.yS()) != null) {
            final ThemeCardInUserData themeCard = yS.getThemeCard();
            SkinInfo zo = bdVar.zo();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIK.dIP.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dIK.cjI.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dIK.cVQ.setVisibility(8);
                if (this.dIK.cjJ != null) {
                    if (zo != null) {
                        this.dIK.cjJ.a(this.mPageContext, zo, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.yY(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dIK.cjJ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dIK.cVQ.setVisibility(0);
                this.dIK.cVQ.setImageBitmap(null);
                this.dIK.cVQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dIK.cVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dIK.cjJ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dIK.dIP.setLayoutParams(layoutParams);
            this.dIK.cjI.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dIK != null) {
            if (view == this.dIK.mRootView || view == this.dIK.dIS.getCommentNumView() || view == this.dIK.cSX) {
                if (akb() != null) {
                    akb().a(this.dIK.mRootView, this.dIJ);
                }
                akx();
            }
        }
    }

    private void akx() {
        PhotoLiveActivityConfig wP;
        if (this.dIJ != null) {
            com.baidu.tieba.card.k.kc(this.dIJ.getTid());
            if (!aky()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dIJ.zp() > 0 && com.baidu.tieba.tbadkCore.util.f.bwI()) {
                wP = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dIJ.getTid()).cG("from_frs").eC(18003).cE(String.valueOf(this.dIJ.zp())).wP();
            } else {
                wP = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dIJ.getTid()).cG("from_frs").eC(18003).wP();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, wP));
            ke(this.dIJ.getTid());
        }
    }

    public void ke(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.dIK.mRootView);
            this.dIK.dIy.onChangeSkinType();
            this.dIK.dIS.onChangeSkinType();
            aj.t(this.dIK.dIM, d.C0107d.cp_bg_line_c);
            aj.s(this.dIK.mRootView, d.f.addresslist_item_bg);
            if (this.dIK.cSX != null) {
                this.dIK.cSX.onChangeSkinType();
            }
            this.dIn.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean aky() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cTp != null) {
            this.cTp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTp);
        }
    }

    private void b(ar arVar) {
        this.blQ.clear();
        IM();
        if (arVar != null && arVar.zm() != null) {
            int size = arVar.zm().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.zm(), i);
                }
            }
            IL();
        }
    }

    private void IM() {
        this.dIK.dIT.setText("");
        this.dIK.dIU.setText("");
        this.dIK.dIV.setText("");
        if (this.dIK.dIT.getVisibility() == 8) {
            this.dIK.dIT.setVisibility(0);
        }
        if (this.dIK.dIU.getVisibility() == 8) {
            this.dIK.dIU.setVisibility(0);
        }
        if (this.dIK.dIV.getVisibility() == 8) {
            this.dIK.dIV.setVisibility(0);
        }
        this.blQ.add(Integer.valueOf(this.dIK.dIT.getId()));
        this.blQ.add(Integer.valueOf(this.dIK.dIU.getId()));
        this.blQ.add(Integer.valueOf(this.dIK.dIV.getId()));
    }

    private void IL() {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i = 0; i < size; i++) {
                if (this.blQ.get(i).intValue() == this.dIK.dIT.getId()) {
                    this.dIK.dIT.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.dIK.dIU.getId()) {
                    this.dIK.dIU.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.dIK.dIV.getId()) {
                    this.dIK.dIV.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blP) {
                case 0:
                    a(this.bmb, this.bmc, this.dIK.dIT);
                    a(this.bmd, this.bme, this.dIK.dIU);
                    a(this.bmf, this.bmg, this.dIK.dIV);
                    break;
                case 1:
                    a(this.bmg, this.bmh, this.dIK.dIT);
                    a(this.bmi, this.bmg, this.dIK.dIU);
                    a(this.bmj, this.bme, this.dIK.dIV);
                    break;
                case 2:
                    a(this.bmg, this.bmk, this.dIK.dIT);
                    a(this.bml, this.bmg, this.dIK.dIU);
                    a(this.bmj, this.bme, this.dIK.dIV);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dIK.dIT);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dIK.dIU);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dIK.dIV);
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
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IC())));
            hr(textView.getId());
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

    private void hr(int i) {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blQ.get(i2).intValue() == i) {
                    this.blQ.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bcb;
        public TbImageView bcc;
        public CardGroupDividerView cSX;
        public TextView cTe;
        public TbImageView cUo;
        public View cUq;
        public TbImageView cVQ;
        public LinearLayout cjI;
        public ThreadSkinView cjJ;
        public View dIM;
        public RelativeLayout dIN;
        public HeadPendantClickableView dIO;
        public ClickableHeaderImageView dIP;
        public TextView dIQ;
        public TextView dIR;
        public ThreadCommentAndPraiseInfoLayout dIS;
        public TextView dIT;
        public TextView dIU;
        public TextView dIV;
        public UserIconLayout dIy;
        public ViewGroup mRootView;

        public a() {
        }
    }
}

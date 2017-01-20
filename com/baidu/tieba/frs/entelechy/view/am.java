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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.au> {
    private TbPageContext<?> FY;
    private int apF;
    private int apG;
    private int apH;
    private int apI;
    private int apJ;
    private int apK;
    private int apL;
    private int apM;
    private int apN;
    private int apO;
    private int apP;
    private int apt;
    private ArrayList<Integer> apu;
    private com.baidu.tbadk.core.data.au bMI;
    public a bMJ;
    private CustomMessageListener blR;
    private View.OnClickListener bmQ;
    private View.OnClickListener bmR;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.apu = new ArrayList<>();
        this.apt = 0;
        this.bmQ = new an(this);
        this.bmR = new ao(this);
        this.blR = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.FY = tbPageContext;
        this.apF = (int) tbPageContext.getResources().getDimension(r.f.ds80);
        this.apG = (int) tbPageContext.getResources().getDimension(r.f.ds280);
        this.apH = (int) tbPageContext.getResources().getDimension(r.f.ds170);
        this.apI = (int) tbPageContext.getResources().getDimension(r.f.ds320);
        this.apJ = (int) tbPageContext.getResources().getDimension(r.f.ds200);
        this.apK = (int) tbPageContext.getResources().getDimension(r.f.ds60);
        this.apL = (int) tbPageContext.getResources().getDimension(r.f.ds120);
        this.apM = (int) tbPageContext.getResources().getDimension(r.f.ds160);
        this.apN = (int) tbPageContext.getResources().getDimension(r.f.ds220);
        this.apO = (int) tbPageContext.getResources().getDimension(r.f.ds240);
        this.apP = (int) tbPageContext.getResources().getDimension(r.f.ds180);
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.bMJ = new a();
        this.bMJ.mRootView = view.findViewById(r.h.card_root_view);
        this.bMJ.bmU = view.findViewById(r.h.top_line);
        this.bMJ.aVa = (RelativeLayout) view.findViewById(r.h.live_card_content_root);
        this.bMJ.aUT = (ClickableHeaderImageView) view.findViewById(r.h.avatar);
        this.bMJ.aUS = (HeadPendantClickableView) view.findViewById(r.h.pendant_avatar);
        this.bMJ.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.bMJ.aUY = (LinearLayout) view.findViewById(r.h.live_card_content_layout);
        this.bMJ.bmB = (UserIconLayout) view.findViewById(r.h.user_icon);
        this.bMJ.aLR = (TextView) view.findViewById(r.h.thread_title);
        this.bMJ.bML = (TextView) view.findViewById(r.h.thread_context);
        this.bMJ.bmV = (TextView) view.findViewById(r.h.fans_num);
        this.bMJ.bmW = (TbImageView) view.findViewById(r.h.thread_image);
        this.bMJ.bmX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.thread_more_info);
        this.bMJ.bmY = view.findViewById(r.h.divider_below_reply_number_layout);
        this.bMJ.bMM = (TextView) view.findViewById(r.h.first_style_first_expression);
        this.bMJ.bMN = (TextView) view.findViewById(r.h.first_style_second_expression);
        this.bMJ.bMO = (TextView) view.findViewById(r.h.first_style_third_expression);
        this.bMJ.bHZ = (TbImageView) view.findViewById(r.h.frs_live_item_theme_card);
        this.bMJ.aUZ = (ThreadSkinView) view.findViewById(r.h.frs_live_skin);
        this.bMJ.bmX.setCommentNumClickListener(this);
        this.bMJ.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
        this.bMJ.blz.setTitleClickListener(this);
        this.bMJ.bmX.setViewNumEnabled(true);
    }

    private void initUI() {
        this.bMJ.aUT.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.bMJ.aUT.setDefaultResource(17170445);
        this.bMJ.aUT.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bMJ.aUT.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bMJ.aUS.vS();
        this.bMJ.aUS.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.bMJ.aUS.getHeadView().setDefaultResource(17170445);
        this.bMJ.aUS.getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bMJ.aUS.getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
        this.bMJ.aUS.getHeadView().setIsRound(true);
        this.bMJ.aUS.getHeadView().setDrawBorder(false);
        this.bMJ.aUS.getPendantView().setIsRound(true);
        this.bMJ.aUS.getPendantView().setDrawBorder(false);
        this.bMJ.bmX.setShowPraiseNum(false);
        this.bMJ.bmW.setDrawBorder(true);
        this.bMJ.bmW.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.au auVar) {
        this.bMI = auVar;
        Mf();
    }

    private void Mf() {
        boolean z;
        if (this.bMI == null) {
            this.bMJ.mRootView.setVisibility(8);
            return;
        }
        if (this.bMI.getAuthor() == null || this.bMI.getAuthor().getPendantData() == null || StringUtils.isNull(this.bMI.getAuthor().getPendantData().pL())) {
            if (this.bMI.getAuthor() != null && this.bMI.getAuthor().getGodUserData() != null && this.bMI.getAuthor().getGodUserData().getType() == 2) {
                this.bMJ.aUT.setGodIconMargin(0);
            } else {
                this.bMJ.aUT.setIsGod(false);
            }
            UserTbVipInfoData rx = this.bMI.rx();
            if (rx != null && rx.getvipV_url() != null) {
                if (this.bMJ.aUU != null) {
                    if (this.bMJ.aUV == null) {
                        this.bMJ.aUU.inflate();
                        this.bMJ.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                    }
                    this.bMJ.aUV.setVisibility(0);
                    this.bMJ.aUV.c(rx.getvipV_url(), 10, false);
                    this.bMJ.aUT.setIsBigV(true);
                }
            } else {
                this.bMJ.aUT.setIsBigV(false);
                if (this.bMJ.aUV != null) {
                    this.bMJ.aUV.setVisibility(8);
                }
            }
            this.bMJ.aUT.setData(this.bMI);
            this.bMJ.aUT.setAfterClickListener(this.bmQ);
            this.bMJ.aUT.setVisibility(0);
            this.bMJ.aUS.setVisibility(8);
        } else {
            this.bMJ.aUT.setIsGod(false);
            this.bMJ.aUT.setIsBigV(false);
            if (this.bMJ.aUV != null) {
                this.bMJ.aUV.setVisibility(8);
            }
            this.bMJ.aUT.setVisibility(4);
            this.bMJ.aUS.setVisibility(0);
            this.bMJ.aUS.setData(this.bMI);
        }
        if (this.bMI.getAuthor() != null && !StringUtils.isNull(this.bMI.getAuthor().getSealPrefix())) {
            this.bMJ.bmB.aO(true);
        }
        this.bMJ.bmB.setData(this.bMI);
        this.bMJ.bmB.setUserNameTextSizeRid(r.f.fontsize24);
        this.bMJ.bmB.setUserAfterClickListener(this.bmQ);
        this.bMJ.bmB.setPageName(1);
        Resources resources = this.FY.getResources();
        if (!StringUtils.isNull(this.bMI.getTitle())) {
            int length = this.bMI.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bMI.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bMJ.aLR.setSingleLine(true);
        } else {
            this.bMJ.aLR.setMaxLines(2);
        }
        this.bMI.e(false, true);
        this.bMJ.aLR.setText(this.bMI.rV());
        String fansNickName = this.bMI.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.l.fans_default_name);
        }
        this.bMJ.bmV.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.at.u(this.bMI.getAuthor().getFansNum()));
        if (this.bMJ.bmX.a(this.bMI)) {
            this.bMJ.bmY.setVisibility(8);
        } else {
            this.bMJ.bmY.setVisibility(0);
        }
        this.bMJ.bmX.setForumAfterClickListener(this.bmR);
        this.bMJ.bmX.setStType(com.baidu.tieba.card.at.Mt());
        s(this.bMI);
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oC().oI() && this.bMI.getPhotoLiveCover() != null && this.bMI.getPhotoLiveCover().length() != 0) {
            this.bMJ.bmW.setVisibility(0);
            this.bMJ.bML.setVisibility(8);
            this.bMJ.bmW.c(this.bMI.getPhotoLiveCover(), 10, false);
            b(this.bMI);
        } else {
            this.bMJ.bmW.setVisibility(8);
            this.bMJ.bMM.setVisibility(8);
            this.bMJ.bMN.setVisibility(8);
            this.bMJ.bMO.setVisibility(8);
            String rE = this.bMI.rE();
            this.bMJ.bML.setText(rE);
            this.bMJ.bML.setVisibility(StringUtils.isNull(rE) ? 8 : 0);
        }
        p.a(this.bMI, this.bMJ.blz);
        com.baidu.tbadk.core.util.ap.c(this.bMJ.bmV, r.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.m13if(this.bMI.getTid())) {
            com.baidu.tbadk.core.util.ap.c(this.bMJ.aLR, r.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.c(this.bMJ.bML, r.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.ap.c(this.bMJ.aLR, r.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ap.c(this.bMJ.bML, r.e.cp_cont_j, 1);
    }

    private void s(bh bhVar) {
        MetaData author;
        if (bhVar != null && (author = bhVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rR = bhVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bMJ.aUT.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bMJ.aUY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bMJ.bHZ.setVisibility(8);
                if (this.bMJ.aUZ != null) {
                    if (rR != null) {
                        this.bMJ.aUZ.a(this.FY, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rB(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds16);
                    } else {
                        this.bMJ.aUZ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds30);
                    }
                }
            } else {
                this.bMJ.bHZ.setVisibility(0);
                this.bMJ.bHZ.setImageBitmap(null);
                this.bMJ.bHZ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bMJ.bHZ.setOnClickListener(new aq(this, themeCard));
                this.bMJ.aUZ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds30);
            }
            this.bMJ.aUT.setLayoutParams(layoutParams);
            this.bMJ.aUY.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bMJ != null) {
            if (view == this.bMJ.mRootView || view == this.bMJ.bmX.getCommentNumView() || view == this.bMJ.blz) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bMJ.mRootView, this.bMI);
                }
                Rv();
            }
        }
    }

    private void Rv() {
        PhotoLiveActivityConfig oS;
        if (this.bMI != null) {
            com.baidu.tieba.card.at.ie(this.bMI.getTid());
            if (!Rw()) {
                UtilHelper.showToast(this.FY.getPageActivity(), r.l.plugin_config_not_found);
                return;
            }
            if (this.bMI.rS() > 0 && com.baidu.tieba.tbadkCore.util.s.biL()) {
                oS = new PhotoLiveActivityConfig.a(this.FY.getPageActivity(), this.bMI.getTid()).ck("from_frs").bF(18003).ci(String.valueOf(this.bMI.rS())).oS();
            } else {
                oS = new PhotoLiveActivityConfig.a(this.FY.getPageActivity(), this.bMI.getTid()).ck("from_frs").bF(18003).oS();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oS));
            ig(this.bMI.getTid());
        }
    }

    public void ig(String str) {
        new Handler().postDelayed(new ar(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bMJ.mRootView);
            this.bMJ.bmB.tg();
            this.bMJ.bmX.tg();
            com.baidu.tbadk.core.util.ap.k(this.bMJ.bmU, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.j(this.bMJ.mRootView, r.g.addresslist_item_bg);
            if (this.bMJ.blz != null) {
                this.bMJ.blz.tg();
            }
            this.mSkinType = i;
        }
    }

    private boolean Rw() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.blR != null) {
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    private void b(com.baidu.tbadk.core.data.au auVar) {
        this.apu.clear();
        AT();
        if (auVar != null && auVar.rP() != null) {
            int size = auVar.rP().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = auVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, auVar.rP(), i);
                }
            }
            AS();
        }
    }

    private void AT() {
        this.bMJ.bMM.setText("");
        this.bMJ.bMN.setText("");
        this.bMJ.bMO.setText("");
        if (this.bMJ.bMM.getVisibility() == 8) {
            this.bMJ.bMM.setVisibility(0);
        }
        if (this.bMJ.bMN.getVisibility() == 8) {
            this.bMJ.bMN.setVisibility(0);
        }
        if (this.bMJ.bMO.getVisibility() == 8) {
            this.bMJ.bMO.setVisibility(0);
        }
        this.apu.add(Integer.valueOf(this.bMJ.bMM.getId()));
        this.apu.add(Integer.valueOf(this.bMJ.bMN.getId()));
        this.apu.add(Integer.valueOf(this.bMJ.bMO.getId()));
    }

    private void AS() {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i = 0; i < size; i++) {
                if (this.apu.get(i).intValue() == this.bMJ.bMM.getId()) {
                    this.bMJ.bMM.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.bMJ.bMN.getId()) {
                    this.bMJ.bMN.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.bMJ.bMO.getId()) {
                    this.bMJ.bMO.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.apt) {
                case 0:
                    a(this.apF, this.apG, this.bMJ.bMM);
                    a(this.apH, this.apI, this.bMJ.bMN);
                    a(this.apJ, this.apK, this.bMJ.bMO);
                    break;
                case 1:
                    a(this.apK, this.apL, this.bMJ.bMM);
                    a(this.apM, this.apK, this.bMJ.bMN);
                    a(this.apN, this.apI, this.bMJ.bMO);
                    break;
                case 2:
                    a(this.apK, this.apO, this.bMJ.bMM);
                    a(this.apP, this.apK, this.bMJ.bMN);
                    a(this.apN, this.apI, this.bMJ.bMO);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bMJ.bMM);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bMJ.bMN);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bMJ.bMO);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AE())));
            ek(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void ek(int i) {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apu.get(i2).intValue() == i) {
                    this.apu.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aLR;
        public HeadPendantClickableView aUS;
        public ClickableHeaderImageView aUT;
        public ViewStub aUU;
        public TbImageView aUV;
        public LinearLayout aUY;
        public ThreadSkinView aUZ;
        public RelativeLayout aVa;
        public TbImageView bHZ;
        public TextView bML;
        public TextView bMM;
        public TextView bMN;
        public TextView bMO;
        public CardGroupDividerView blz;
        public UserIconLayout bmB;
        public View bmU;
        public TextView bmV;
        public TbImageView bmW;
        public ThreadCommentAndPraiseInfoLayout bmX;
        public View bmY;
        public View mRootView;

        public a() {
        }
    }
}

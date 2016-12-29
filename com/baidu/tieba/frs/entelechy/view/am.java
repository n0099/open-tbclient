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
import com.baidu.tbadk.core.data.bg;
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
public class am extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.at> {
    private TbPageContext<?> GO;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private int aqF;
    private int aqG;
    private int aqH;
    private int aqI;
    private int aqJ;
    private int aqn;
    private ArrayList<Integer> aqo;
    private int aqz;
    private com.baidu.tbadk.core.data.at bGt;
    public a bGu;
    private CustomMessageListener bct;
    private View.OnClickListener bdb;
    private View.OnClickListener bdc;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aqo = new ArrayList<>();
        this.aqn = 0;
        this.bdb = new an(this);
        this.bdc = new ao(this);
        this.bct = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GO = tbPageContext;
        this.aqz = (int) tbPageContext.getResources().getDimension(r.e.ds80);
        this.aqA = (int) tbPageContext.getResources().getDimension(r.e.ds280);
        this.aqB = (int) tbPageContext.getResources().getDimension(r.e.ds170);
        this.aqC = (int) tbPageContext.getResources().getDimension(r.e.ds320);
        this.aqD = (int) tbPageContext.getResources().getDimension(r.e.ds200);
        this.aqE = (int) tbPageContext.getResources().getDimension(r.e.ds60);
        this.aqF = (int) tbPageContext.getResources().getDimension(r.e.ds120);
        this.aqG = (int) tbPageContext.getResources().getDimension(r.e.ds160);
        this.aqH = (int) tbPageContext.getResources().getDimension(r.e.ds220);
        this.aqI = (int) tbPageContext.getResources().getDimension(r.e.ds240);
        this.aqJ = (int) tbPageContext.getResources().getDimension(r.e.ds180);
        S(getView());
        initUI();
    }

    private void S(View view) {
        this.bGu = new a();
        this.bGu.mRootView = view.findViewById(r.g.card_root_view);
        this.bGu.bdf = view.findViewById(r.g.top_line);
        this.bGu.bGd = (RelativeLayout) view.findViewById(r.g.live_card_content_root);
        this.bGu.bbY = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.bGu.bGc = (HeadPendantClickableView) view.findViewById(r.g.pendant_avatar);
        this.bGu.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bGu.bcd = (LinearLayout) view.findViewById(r.g.live_card_content_layout);
        this.bGu.bcM = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.bGu.aMQ = (TextView) view.findViewById(r.g.thread_title);
        this.bGu.bGw = (TextView) view.findViewById(r.g.thread_context);
        this.bGu.bdg = (TextView) view.findViewById(r.g.fans_num);
        this.bGu.bdh = (TbImageView) view.findViewById(r.g.thread_image);
        this.bGu.bdi = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.bGu.bdj = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bGu.bGx = (TextView) view.findViewById(r.g.first_style_first_expression);
        this.bGu.bGy = (TextView) view.findViewById(r.g.first_style_second_expression);
        this.bGu.bGz = (TextView) view.findViewById(r.g.first_style_third_expression);
        this.bGu.bAE = (TbImageView) view.findViewById(r.g.frs_live_item_theme_card);
        this.bGu.bAV = (ThreadSkinView) view.findViewById(r.g.frs_live_skin);
        this.bGu.bdi.setCommentNumClickListener(this);
        this.bGu.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
        this.bGu.bbM.setTitleClickListener(this);
        this.bGu.bdi.setViewNumEnabled(true);
    }

    private void initUI() {
        this.bGu.bbY.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bGu.bbY.setDefaultResource(17170445);
        this.bGu.bbY.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bGu.bbY.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bGu.bGc.vY();
        this.bGu.bGc.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bGu.bGc.getHeadView().setDefaultResource(17170445);
        this.bGu.bGc.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bGu.bGc.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        this.bGu.bGc.getHeadView().setIsRound(true);
        this.bGu.bGc.getHeadView().setDrawBorder(false);
        this.bGu.bGc.getPendantView().setIsRound(true);
        this.bGu.bGc.getPendantView().setDrawBorder(false);
        this.bGu.bdi.setShowPraiseNum(false);
        this.bGu.bdh.setDrawBorder(true);
        this.bGu.bdh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.at atVar) {
        this.bGt = atVar;
        Ox();
    }

    private void Ox() {
        boolean z;
        if (this.bGt == null) {
            this.bGu.mRootView.setVisibility(8);
            return;
        }
        if (this.bGt.getAuthor() == null || this.bGt.getAuthor().getPendantData() == null || StringUtils.isNull(this.bGt.getAuthor().getPendantData().pS())) {
            if (this.bGt.getAuthor() != null && this.bGt.getAuthor().getGodUserData() != null && this.bGt.getAuthor().getGodUserData().getType() == 2) {
                this.bGu.bbY.setGodIconMargin(0);
            } else {
                this.bGu.bbY.setIsGod(false);
            }
            UserTbVipInfoData rF = this.bGt.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.bGu.baW != null) {
                    if (this.bGu.baX == null) {
                        this.bGu.baW.inflate();
                        this.bGu.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.bGu.baX.setVisibility(0);
                    this.bGu.baX.c(rF.getvipV_url(), 10, false);
                    this.bGu.bbY.setIsBigV(true);
                }
            } else {
                this.bGu.bbY.setIsBigV(false);
                if (this.bGu.baX != null) {
                    this.bGu.baX.setVisibility(8);
                }
            }
            this.bGu.bbY.setData(this.bGt);
            this.bGu.bbY.setAfterClickListener(this.bdb);
            this.bGu.bbY.setVisibility(0);
            this.bGu.bGc.setVisibility(8);
        } else {
            this.bGu.bbY.setIsGod(false);
            this.bGu.bbY.setIsBigV(false);
            if (this.bGu.baX != null) {
                this.bGu.baX.setVisibility(8);
            }
            this.bGu.bbY.setVisibility(4);
            this.bGu.bGc.setVisibility(0);
            this.bGu.bGc.setData(this.bGt);
        }
        if (this.bGt.getAuthor() != null && !StringUtils.isNull(this.bGt.getAuthor().getSealPrefix())) {
            this.bGu.bcM.aO(true);
        }
        this.bGu.bcM.setData(this.bGt);
        this.bGu.bcM.setUserNameTextSizeRid(r.e.fontsize24);
        this.bGu.bcM.setUserAfterClickListener(this.bdb);
        this.bGu.bcM.setPageName(1);
        Resources resources = this.GO.getResources();
        if (!StringUtils.isNull(this.bGt.getTitle())) {
            int length = this.bGt.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bGt.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bGu.aMQ.setSingleLine(true);
        } else {
            this.bGu.aMQ.setMaxLines(2);
        }
        this.bGt.e(false, true);
        this.bGu.aMQ.setText(this.bGt.sd());
        String fansNickName = this.bGt.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.bGu.bdg.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.av.v(this.bGt.getAuthor().getFansNum()));
        if (this.bGu.bdi.a(this.bGt)) {
            this.bGu.bdj.setVisibility(8);
        } else {
            this.bGu.bdj.setVisibility(0);
        }
        this.bGu.bdi.setForumAfterClickListener(this.bdc);
        this.bGu.bdi.setStType(com.baidu.tieba.card.ap.OB());
        p(this.bGt);
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oJ().oP() && this.bGt.getPhotoLiveCover() != null && this.bGt.getPhotoLiveCover().length() != 0) {
            this.bGu.bdh.setVisibility(0);
            this.bGu.bGw.setVisibility(8);
            this.bGu.bdh.c(this.bGt.getPhotoLiveCover(), 10, false);
            b(this.bGt);
        } else {
            this.bGu.bdh.setVisibility(8);
            this.bGu.bGx.setVisibility(8);
            this.bGu.bGy.setVisibility(8);
            this.bGu.bGz.setVisibility(8);
            String rN = this.bGt.rN();
            this.bGu.bGw.setText(rN);
            this.bGu.bGw.setVisibility(StringUtils.isNull(rN) ? 8 : 0);
        }
        p.a(this.bGt, this.bGu.bbM);
        com.baidu.tbadk.core.util.ar.c(this.bGu.bdg, r.d.cp_cont_d, 1);
        if (com.baidu.tieba.card.ap.hM(this.bGt.getTid())) {
            com.baidu.tbadk.core.util.ar.c(this.bGu.aMQ, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.c(this.bGu.bGw, r.d.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.ar.c(this.bGu.aMQ, r.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ar.c(this.bGu.bGw, r.d.cp_cont_j, 1);
    }

    private void p(bg bgVar) {
        MetaData author;
        if (bgVar != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rZ = bgVar.rZ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bGu.bbY.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bGu.bcd.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bGu.bAE.setVisibility(8);
                if (this.bGu.bAV != null) {
                    if (rZ != null) {
                        this.bGu.bAV.a(this.GO, rZ, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.rK(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                    } else {
                        this.bGu.bAV.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bGu.bAE.setVisibility(0);
                this.bGu.bAE.setImageBitmap(null);
                this.bGu.bAE.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bGu.bAE.setOnClickListener(new aq(this, themeCard));
                this.bGu.bAV.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
            }
            this.bGu.bbY.setLayoutParams(layoutParams);
            this.bGu.bcd.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGu != null) {
            if (view == this.bGu.mRootView || view == this.bGu.bdi.getCommentNumView() || view == this.bGu.bbM) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bGu.mRootView, this.bGt);
                }
                OF();
            }
        }
    }

    private void OF() {
        PhotoLiveActivityConfig oZ;
        if (this.bGt != null) {
            com.baidu.tieba.card.ap.hL(this.bGt.getTid());
            if (!OG()) {
                UtilHelper.showToast(this.GO.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            if (this.bGt.sa() > 0 && com.baidu.tieba.tbadkCore.util.s.bha()) {
                oZ = new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.bGt.getTid()).cm("from_frs").bG(18003).ck(String.valueOf(this.bGt.sa())).oZ();
            } else {
                oZ = new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.bGt.getTid()).cm("from_frs").bG(18003).oZ();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oZ));
            hN(this.bGt.getTid());
        }
    }

    public void hN(String str) {
        new Handler().postDelayed(new ar(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bGu.mRootView);
            this.bGu.bcM.tm();
            this.bGu.bdi.tm();
            com.baidu.tbadk.core.util.ar.l(this.bGu.bdf, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.k(this.bGu.mRootView, r.f.addresslist_item_bg);
            if (this.bGu.bbM != null) {
                this.bGu.bbM.tm();
            }
            this.mSkinType = i;
        }
    }

    private boolean OG() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bct != null) {
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        this.aqo.clear();
        AY();
        if (atVar != null && atVar.rX() != null) {
            int size = atVar.rX().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = atVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, atVar.rX(), i);
                }
            }
            AX();
        }
    }

    private void AY() {
        this.bGu.bGx.setText("");
        this.bGu.bGy.setText("");
        this.bGu.bGz.setText("");
        if (this.bGu.bGx.getVisibility() == 8) {
            this.bGu.bGx.setVisibility(0);
        }
        if (this.bGu.bGy.getVisibility() == 8) {
            this.bGu.bGy.setVisibility(0);
        }
        if (this.bGu.bGz.getVisibility() == 8) {
            this.bGu.bGz.setVisibility(0);
        }
        this.aqo.add(Integer.valueOf(this.bGu.bGx.getId()));
        this.aqo.add(Integer.valueOf(this.bGu.bGy.getId()));
        this.aqo.add(Integer.valueOf(this.bGu.bGz.getId()));
    }

    private void AX() {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i = 0; i < size; i++) {
                if (this.aqo.get(i).intValue() == this.bGu.bGx.getId()) {
                    this.bGu.bGx.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.bGu.bGy.getId()) {
                    this.bGu.bGy.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.bGu.bGz.getId()) {
                    this.bGu.bGz.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqn) {
                case 0:
                    a(this.aqz, this.aqA, this.bGu.bGx);
                    a(this.aqB, this.aqC, this.bGu.bGy);
                    a(this.aqD, this.aqE, this.bGu.bGz);
                    break;
                case 1:
                    a(this.aqE, this.aqF, this.bGu.bGx);
                    a(this.aqG, this.aqE, this.bGu.bGy);
                    a(this.aqH, this.aqC, this.bGu.bGz);
                    break;
                case 2:
                    a(this.aqE, this.aqI, this.bGu.bGx);
                    a(this.aqJ, this.aqE, this.bGu.bGy);
                    a(this.aqH, this.aqC, this.bGu.bGz);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bGu.bGx);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bGu.bGy);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bGu.bGz);
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
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AJ())));
            ej(textView.getId());
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

    private void ej(int i) {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqo.get(i2).intValue() == i) {
                    this.aqo.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aMQ;
        public TbImageView bAE;
        public ThreadSkinView bAV;
        public HeadPendantClickableView bGc;
        public RelativeLayout bGd;
        public TextView bGw;
        public TextView bGx;
        public TextView bGy;
        public TextView bGz;
        public ViewStub baW;
        public TbImageView baX;
        public CardGroupDividerView bbM;
        public ClickableHeaderImageView bbY;
        public UserIconLayout bcM;
        public LinearLayout bcd;
        public View bdf;
        public TextView bdg;
        public TbImageView bdh;
        public ThreadCommentAndPraiseInfoLayout bdi;
        public View bdj;
        public View mRootView;

        public a() {
        }
    }
}

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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.w;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.card.a<aw> {
    private TbPageContext<?> ajF;
    private int auN;
    private ArrayList<Integer> auO;
    private int auZ;
    private int ava;
    private int avb;
    private int avc;
    private int avd;
    private int ave;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private aw bTQ;
    public a bTR;
    private com.baidu.tieba.frs.f.af bTz;
    private CustomMessageListener bsL;
    private View.OnClickListener btL;
    private View.OnClickListener btM;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.auO = new ArrayList<>();
        this.auN = 0;
        this.btL = new an(this);
        this.btM = new ao(this);
        this.bsL = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajF = tbPageContext;
        this.auZ = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.ava = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.avb = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.avc = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.avd = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.ave = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.avf = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.avg = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.avh = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.avi = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.avj = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bTR = new a();
        this.bTR.mRootView = view.findViewById(w.h.card_root_view);
        this.bTR.btP = view.findViewById(w.h.top_line);
        this.bTR.bbn = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.bTR.bbg = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bTR.bbf = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.bTR.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bTR.bbl = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.bTR.btw = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bTR.aRE = (TextView) view.findViewById(w.h.thread_title);
        this.bTR.bTT = (TextView) view.findViewById(w.h.thread_context);
        this.bTR.btQ = (TextView) view.findViewById(w.h.fans_num);
        this.bTR.btR = (TbImageView) view.findViewById(w.h.thread_image);
        this.bTR.btS = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bTR.btT = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bTR.bTU = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.bTR.bTV = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.bTR.bTW = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.bTR.bPi = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.bTR.bbm = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.bTR.btS.setCommentNumClickListener(this);
        this.bTR.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bTR.bss.setTitleClickListener(this);
        this.bTR.btS.setViewNumEnabled(true);
        this.bTz = new com.baidu.tieba.frs.f.af(this.ajF, this.bTR.btS);
    }

    private void initUI() {
        this.bTR.bbg.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.bTR.bbg.setDefaultResource(17170445);
        this.bTR.bbg.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTR.bbg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTR.bbf.wp();
        this.bTR.bbf.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.bTR.bbf.getHeadView().setDefaultResource(17170445);
        this.bTR.bbf.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTR.bbf.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTR.bbf.getHeadView().setIsRound(true);
        this.bTR.bbf.getHeadView().setDrawBorder(false);
        this.bTR.bbf.getPendantView().setIsRound(true);
        this.bTR.bbf.getPendantView().setDrawBorder(false);
        this.bTR.btS.setShowPraiseNum(false);
        this.bTR.btR.setDrawBorder(true);
        this.bTR.btR.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(aw awVar) {
        this.bTQ = awVar;
        MR();
    }

    private void MR() {
        boolean z;
        if (this.bTQ == null) {
            this.bTR.mRootView.setVisibility(8);
            return;
        }
        if (this.bTQ.getAuthor() == null || this.bTQ.getAuthor().getPendantData() == null || StringUtils.isNull(this.bTQ.getAuthor().getPendantData().qd())) {
            if (this.bTQ.getAuthor() != null && this.bTQ.getAuthor().getGodUserData() != null && this.bTQ.getAuthor().getGodUserData().getType() == 2) {
                this.bTR.bbg.setGodIconMargin(0);
            } else {
                this.bTR.bbg.setIsGod(false);
            }
            UserTbVipInfoData rR = this.bTQ.rR();
            if (rR != null && rR.getvipV_url() != null) {
                if (this.bTR.bbh != null) {
                    if (this.bTR.bbi == null) {
                        this.bTR.bbh.inflate();
                        this.bTR.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bTR.bbi.setVisibility(0);
                    this.bTR.bbi.c(rR.getvipV_url(), 10, false);
                    this.bTR.bbg.setIsBigV(true);
                }
            } else {
                this.bTR.bbg.setIsBigV(false);
                if (this.bTR.bbi != null) {
                    this.bTR.bbi.setVisibility(8);
                }
            }
            this.bTR.bbg.setData(this.bTQ);
            this.bTR.bbg.setAfterClickListener(this.btL);
            this.bTR.bbg.setVisibility(0);
            this.bTR.bbf.setVisibility(8);
        } else {
            this.bTR.bbg.setIsGod(false);
            this.bTR.bbg.setIsBigV(false);
            if (this.bTR.bbi != null) {
                this.bTR.bbi.setVisibility(8);
            }
            this.bTR.bbg.setVisibility(4);
            this.bTR.bbf.setVisibility(0);
            this.bTR.bbf.setData(this.bTQ);
        }
        if (this.bTQ.getAuthor() != null && !StringUtils.isNull(this.bTQ.getAuthor().getSealPrefix())) {
            this.bTR.btw.aN(true);
        }
        this.bTR.btw.setData(this.bTQ);
        this.bTR.btw.setUserNameTextSizeRid(w.f.fontsize24);
        this.bTR.btw.setUserAfterClickListener(this.btL);
        this.bTR.btw.setPageName(1);
        Resources resources = this.ajF.getResources();
        if (!StringUtils.isNull(this.bTQ.getTitle())) {
            int length = this.bTQ.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bTQ.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bTR.aRE.setSingleLine(true);
        } else {
            this.bTR.aRE.setMaxLines(2);
        }
        this.bTQ.e(false, true);
        this.bTR.aRE.setText(this.bTQ.sq());
        String fansNickName = this.bTQ.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bTR.btQ.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bTQ.getAuthor().getFansNum()));
        if (this.bTR.btS.a(this.bTQ)) {
            this.bTR.btT.setVisibility(8);
        } else {
            this.bTR.btT.setVisibility(0);
        }
        this.bTR.btS.setForumAfterClickListener(this.btM);
        this.bTR.btS.setStType(com.baidu.tieba.card.at.rH());
        s(this.bTQ);
        this.bTz.D(this.bTQ);
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oQ().oW() && this.bTQ.getPhotoLiveCover() != null && this.bTQ.getPhotoLiveCover().length() != 0) {
            this.bTR.btR.setVisibility(0);
            this.bTR.bTT.setVisibility(8);
            this.bTR.btR.c(this.bTQ.getPhotoLiveCover(), 10, false);
            b(this.bTQ);
        } else {
            this.bTR.btR.setVisibility(8);
            this.bTR.bTU.setVisibility(8);
            this.bTR.bTV.setVisibility(8);
            this.bTR.bTW.setVisibility(8);
            String rY = this.bTQ.rY();
            this.bTR.bTT.setText(rY);
            this.bTR.bTT.setVisibility(StringUtils.isNull(rY) ? 8 : 0);
        }
        p.a(this.bTQ, this.bTR.bss);
        com.baidu.tbadk.core.util.aq.c(this.bTR.btQ, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.hV(this.bTQ.getTid())) {
            com.baidu.tbadk.core.util.aq.c(this.bTR.aRE, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bTR.bTT, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.bTR.aRE, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.bTR.bTT, w.e.cp_cont_j, 1);
    }

    private void s(bj bjVar) {
        MetaData author;
        if (bjVar != null && (author = bjVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sl = bjVar.sl();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bTR.bbg.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bTR.bbl.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bTR.bPi.setVisibility(8);
                if (this.bTR.bbm != null) {
                    if (sl != null) {
                        this.bTR.bbm.a(this.ajF, sl, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rV(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds16);
                    } else {
                        this.bTR.bbm.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bTR.bPi.setVisibility(0);
                this.bTR.bPi.setImageBitmap(null);
                this.bTR.bPi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bTR.bPi.setOnClickListener(new aq(this, themeCard));
                this.bTR.bbm.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds30);
            }
            this.bTR.bbg.setLayoutParams(layoutParams);
            this.bTR.bbl.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTR != null) {
            if (view == this.bTR.mRootView || view == this.bTR.btS.getCommentNumView() || view == this.bTR.bss) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bTR.mRootView, this.bTQ);
                }
                St();
            }
        }
    }

    private void St() {
        PhotoLiveActivityConfig pg;
        if (this.bTQ != null) {
            com.baidu.tieba.card.at.hU(this.bTQ.getTid());
            if (!Su()) {
                UtilHelper.showToast(this.ajF.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.bTQ.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                pg = new PhotoLiveActivityConfig.a(this.ajF.getPageActivity(), this.bTQ.getTid()).cd("from_frs").bz(18003).cb(String.valueOf(this.bTQ.sm())).pg();
            } else {
                pg = new PhotoLiveActivityConfig.a(this.ajF.getPageActivity(), this.bTQ.getTid()).cd("from_frs").bz(18003).pg();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pg));
            hW(this.bTQ.getTid());
        }
    }

    public void hW(String str) {
        new Handler().postDelayed(new ar(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bTR.mRootView);
            this.bTR.btw.tD();
            this.bTR.btS.tD();
            com.baidu.tbadk.core.util.aq.k(this.bTR.btP, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bTR.mRootView, w.g.addresslist_item_bg);
            if (this.bTR.bss != null) {
                this.bTR.bss.tD();
            }
            this.bTz.tD();
            this.mSkinType = i;
        }
    }

    private boolean Su() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bsL != null) {
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    private void b(aw awVar) {
        this.auO.clear();
        Bm();
        if (awVar != null && awVar.sj() != null) {
            int size = awVar.sj().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = awVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, awVar.sj(), i);
                }
            }
            Bl();
        }
    }

    private void Bm() {
        this.bTR.bTU.setText("");
        this.bTR.bTV.setText("");
        this.bTR.bTW.setText("");
        if (this.bTR.bTU.getVisibility() == 8) {
            this.bTR.bTU.setVisibility(0);
        }
        if (this.bTR.bTV.getVisibility() == 8) {
            this.bTR.bTV.setVisibility(0);
        }
        if (this.bTR.bTW.getVisibility() == 8) {
            this.bTR.bTW.setVisibility(0);
        }
        this.auO.add(Integer.valueOf(this.bTR.bTU.getId()));
        this.auO.add(Integer.valueOf(this.bTR.bTV.getId()));
        this.auO.add(Integer.valueOf(this.bTR.bTW.getId()));
    }

    private void Bl() {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i = 0; i < size; i++) {
                if (this.auO.get(i).intValue() == this.bTR.bTU.getId()) {
                    this.bTR.bTU.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.bTR.bTV.getId()) {
                    this.bTR.bTV.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.bTR.bTW.getId()) {
                    this.bTR.bTW.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.auN) {
                case 0:
                    a(this.auZ, this.ava, this.bTR.bTU);
                    a(this.avb, this.avc, this.bTR.bTV);
                    a(this.avd, this.ave, this.bTR.bTW);
                    break;
                case 1:
                    a(this.ave, this.avf, this.bTR.bTU);
                    a(this.avg, this.ave, this.bTR.bTV);
                    a(this.avh, this.avc, this.bTR.bTW);
                    break;
                case 2:
                    a(this.ave, this.avi, this.bTR.bTU);
                    a(this.avj, this.ave, this.bTR.bTV);
                    a(this.avh, this.avc, this.bTR.bTW);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bTR.bTU);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bTR.bTV);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bTR.bTW);
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
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AX())));
            ef(textView.getId());
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

    private void ef(int i) {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auO.get(i2).intValue() == i) {
                    this.auO.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRE;
        public TbImageView bPi;
        public TextView bTT;
        public TextView bTU;
        public TextView bTV;
        public TextView bTW;
        public HeadPendantClickableView bbf;
        public ClickableHeaderImageView bbg;
        public ViewStub bbh;
        public TbImageView bbi;
        public LinearLayout bbl;
        public ThreadSkinView bbm;
        public RelativeLayout bbn;
        public CardGroupDividerView bss;
        public View btP;
        public TextView btQ;
        public TbImageView btR;
        public ThreadCommentAndPraiseInfoLayout btS;
        public View btT;
        public UserIconLayout btw;
        public View mRootView;

        public a() {
        }
    }
}

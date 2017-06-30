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
import com.baidu.tbadk.core.data.bm;
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
public class ai extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.ay> {
    private TbPageContext<?> ajP;
    private int avW;
    private ArrayList<Integer> avX;
    private int awi;
    private int awj;
    private int awk;
    private int awl;
    private int awm;
    private int awn;
    private int awo;
    private int awp;
    private int awq;
    private int awr;
    private int aws;
    private CustomMessageListener bBt;
    private View.OnClickListener bCA;
    private View.OnClickListener bCB;
    private com.baidu.tbadk.core.data.ay chN;
    public a chO;
    private com.baidu.tieba.frs.f.v chz;

    public ai(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.avX = new ArrayList<>();
        this.avW = 0;
        this.bCA = new aj(this);
        this.bCB = new ak(this);
        this.bBt = new al(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        setTag(bdUniqueId);
        this.ajP = tbPageContext;
        this.awi = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.awj = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.awk = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.awl = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.awm = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.awn = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.awo = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.awp = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.awq = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.awr = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.aws = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.chO = new a();
        this.chO.mRootView = view.findViewById(w.h.card_root_view);
        this.chO.chQ = view.findViewById(w.h.top_line);
        this.chO.chR = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.chO.chT = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.chO.chS = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.chO.amP = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.chO.bgH = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.chO.bCt = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.chO.bAg = (TextView) view.findViewById(w.h.thread_title);
        this.chO.chU = (TextView) view.findViewById(w.h.thread_context);
        this.chO.chV = (TextView) view.findViewById(w.h.fans_num);
        this.chO.bCE = (TbImageView) view.findViewById(w.h.thread_image);
        this.chO.bCE.setPageId(getTag());
        this.chO.chW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.chO.bCG = view.findViewById(w.h.divider_below_reply_number_layout);
        this.chO.chX = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.chO.chY = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.chO.chZ = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.chO.cee = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.chO.cee.setPageId(getTag());
        this.chO.bgI = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.chO.chW.setCommentNumClickListener(this);
        this.chO.bBg = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.chO.bBg.setTitleClickListener(this);
        this.chO.chW.setViewNumEnabled(true);
        this.chz = new com.baidu.tieba.frs.f.v(this.ajP, this.chO.chW);
        this.chz.setUniqueId(getTag());
    }

    private void initUI() {
        this.chO.chT.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        this.chO.chT.setDefaultResource(17170445);
        this.chO.chT.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.chO.chT.setDefaultBgResource(w.e.cp_bg_line_e);
        this.chO.chS.wm();
        this.chO.chS.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        this.chO.chS.getHeadView().setDefaultResource(17170445);
        this.chO.chS.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.chO.chS.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.chO.chS.getHeadView().setIsRound(true);
        this.chO.chS.getHeadView().setDrawBorder(false);
        this.chO.chS.getPendantView().setIsRound(true);
        this.chO.chS.getPendantView().setDrawBorder(false);
        this.chO.chW.setShowPraiseNum(false);
        this.chO.bCE.setDrawBorder(true);
        this.chO.bCE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tbadk.core.data.ay ayVar) {
        this.chN = ayVar;
        Oh();
    }

    private void Oh() {
        boolean z;
        if (this.chN == null) {
            this.chO.mRootView.setVisibility(8);
            return;
        }
        if (this.chN.getAuthor() == null || this.chN.getAuthor().getPendantData() == null || StringUtils.isNull(this.chN.getAuthor().getPendantData().pI())) {
            if (this.chN.getAuthor() != null && this.chN.getAuthor().getGodUserData() != null && this.chN.getAuthor().getGodUserData().getType() == 2) {
                this.chO.chT.setGodIconMargin(0);
            } else {
                this.chO.chT.setIsGod(false);
            }
            UserTbVipInfoData rr = this.chN.rr();
            if (rr != null && rr.getvipV_url() != null) {
                if (this.chO.amP != null) {
                    if (this.chO.amQ == null) {
                        this.chO.amP.inflate();
                        this.chO.amQ = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.chO.amQ.setPageId(getTag());
                    this.chO.amQ.setVisibility(0);
                    this.chO.amQ.c(rr.getvipV_url(), 10, false);
                    this.chO.chT.setIsBigV(true);
                }
            } else {
                this.chO.chT.setIsBigV(false);
                if (this.chO.amQ != null) {
                    this.chO.amQ.setVisibility(8);
                }
            }
            this.chO.chT.setData(this.chN);
            this.chO.chT.setAfterClickListener(this.bCA);
            this.chO.chT.setVisibility(0);
            this.chO.chS.setVisibility(8);
        } else {
            this.chO.chT.setIsGod(false);
            this.chO.chT.setIsBigV(false);
            if (this.chO.amQ != null) {
                this.chO.amQ.setVisibility(8);
            }
            this.chO.chT.setVisibility(4);
            this.chO.chS.setVisibility(0);
            this.chO.chS.setData(this.chN);
        }
        if (this.chN.getAuthor() != null && !StringUtils.isNull(this.chN.getAuthor().getSealPrefix())) {
            this.chO.bCt.aO(true);
        }
        this.chO.bCt.setData(this.chN);
        this.chO.bCt.setUserNameTextSizeRid(w.f.fontsize24);
        this.chO.bCt.setUserAfterClickListener(this.bCA);
        this.chO.bCt.setPageName(1);
        Resources resources = this.ajP.getResources();
        if (!StringUtils.isNull(this.chN.getTitle())) {
            int length = this.chN.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.chN.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.chO.bAg.setSingleLine(true);
        } else {
            this.chO.bAg.setMaxLines(2);
        }
        this.chN.e(false, true);
        this.chO.bAg.setText(this.chN.rR());
        String fansNickName = this.chN.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.chO.chV.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.aw.t(this.chN.getAuthor().getFansNum()));
        if (this.chO.chW.a(this.chN)) {
            this.chO.bCG.setVisibility(8);
        } else {
            this.chO.bCG.setVisibility(0);
        }
        this.chO.chW.setForumAfterClickListener(this.bCB);
        this.chO.chW.setStType(com.baidu.tieba.card.at.ri());
        C(this.chN);
        this.chz.L(this.chN);
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oK().oQ() && this.chN.getPhotoLiveCover() != null && this.chN.getPhotoLiveCover().length() != 0) {
            this.chO.bCE.setVisibility(0);
            this.chO.chU.setVisibility(8);
            this.chO.bCE.c(this.chN.getPhotoLiveCover(), 10, false);
            b(this.chN);
        } else {
            this.chO.bCE.setVisibility(8);
            this.chO.chX.setVisibility(8);
            this.chO.chY.setVisibility(8);
            this.chO.chZ.setVisibility(8);
            String rz = this.chN.rz();
            this.chO.chU.setText(rz);
            this.chO.chU.setVisibility(StringUtils.isNull(rz) ? 8 : 0);
        }
        p.a(this.chN, this.chO.bBg);
        com.baidu.tbadk.core.util.as.c(this.chO.chV, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.iJ(this.chN.getTid())) {
            com.baidu.tbadk.core.util.as.c(this.chO.bAg, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.as.c(this.chO.chU, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.c(this.chO.bAg, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.as.c(this.chO.chU, w.e.cp_cont_j, 1);
    }

    private void C(bm bmVar) {
        MetaData author;
        if (bmVar != null && (author = bmVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rM = bmVar.rM();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.chO.chT.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.chO.bgH.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.chO.cee.setVisibility(8);
                if (this.chO.bgI != null) {
                    if (rM != null) {
                        this.chO.bgI.a(this.ajP, rM, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bmVar.getFid()), bmVar.rw(), bmVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds16);
                    } else {
                        this.chO.bgI.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.chO.cee.setVisibility(0);
                this.chO.cee.setImageBitmap(null);
                this.chO.cee.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.chO.cee.setOnClickListener(new am(this, themeCard));
                this.chO.bgI.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds30);
            }
            this.chO.chT.setLayoutParams(layoutParams);
            this.chO.bgH.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.chO != null) {
            if (view == this.chO.mRootView || view == this.chO.chW.getCommentNumView() || view == this.chO.bBg) {
                if (Vs() != null) {
                    Vs().a(this.chO.mRootView, this.chN);
                }
                VK();
            }
        }
    }

    private void VK() {
        PhotoLiveActivityConfig pa;
        if (this.chN != null) {
            com.baidu.tieba.card.at.iI(this.chN.getTid());
            if (!VL()) {
                UtilHelper.showToast(this.ajP.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.chN.rN() > 0 && com.baidu.tieba.tbadkCore.util.s.bns()) {
                pa = new PhotoLiveActivityConfig.a(this.ajP.getPageActivity(), this.chN.getTid()).cq("from_frs").bA(18003).co(String.valueOf(this.chN.rN())).pa();
            } else {
                pa = new PhotoLiveActivityConfig.a(this.ajP.getPageActivity(), this.chN.getTid()).cq("from_frs").bA(18003).pa();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pa));
            iK(this.chN.getTid());
        }
    }

    public void iK(String str) {
        new Handler().postDelayed(new an(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.chO.mRootView);
            this.chO.bCt.onChangeSkinType();
            this.chO.chW.onChangeSkinType();
            com.baidu.tbadk.core.util.as.k(this.chO.chQ, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.j(this.chO.mRootView, w.g.addresslist_item_bg);
            if (this.chO.bBg != null) {
                this.chO.bBg.onChangeSkinType();
            }
            this.chz.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean VL() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bBt != null) {
            this.bBt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bBt);
        }
    }

    private void b(com.baidu.tbadk.core.data.ay ayVar) {
        this.avX.clear();
        Bj();
        if (ayVar != null && ayVar.rK() != null) {
            int size = ayVar.rK().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = ayVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, ayVar.rK(), i);
                }
            }
            Bi();
        }
    }

    private void Bj() {
        this.chO.chX.setText("");
        this.chO.chY.setText("");
        this.chO.chZ.setText("");
        if (this.chO.chX.getVisibility() == 8) {
            this.chO.chX.setVisibility(0);
        }
        if (this.chO.chY.getVisibility() == 8) {
            this.chO.chY.setVisibility(0);
        }
        if (this.chO.chZ.getVisibility() == 8) {
            this.chO.chZ.setVisibility(0);
        }
        this.avX.add(Integer.valueOf(this.chO.chX.getId()));
        this.avX.add(Integer.valueOf(this.chO.chY.getId()));
        this.avX.add(Integer.valueOf(this.chO.chZ.getId()));
    }

    private void Bi() {
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i = 0; i < size; i++) {
                if (this.avX.get(i).intValue() == this.chO.chX.getId()) {
                    this.chO.chX.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.chO.chY.getId()) {
                    this.chO.chY.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.chO.chZ.getId()) {
                    this.chO.chZ.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avW) {
                case 0:
                    a(this.awi, this.awj, this.chO.chX);
                    a(this.awk, this.awl, this.chO.chY);
                    a(this.awm, this.awn, this.chO.chZ);
                    break;
                case 1:
                    a(this.awn, this.awo, this.chO.chX);
                    a(this.awp, this.awn, this.chO.chY);
                    a(this.awq, this.awl, this.chO.chZ);
                    break;
                case 2:
                    a(this.awn, this.awr, this.chO.chX);
                    a(this.aws, this.awn, this.chO.chY);
                    a(this.awq, this.awl, this.chO.chZ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.chO.chX);
            } else if (i == 1) {
                a(arrayList.get(i2), this.chO.chY);
            } else if (i == 2) {
                a(arrayList.get(i2), this.chO.chZ);
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
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AV())));
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
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avX.get(i2).intValue() == i) {
                    this.avX.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub amP;
        public TbImageView amQ;
        public TextView bAg;
        public CardGroupDividerView bBg;
        public TbImageView bCE;
        public View bCG;
        public UserIconLayout bCt;
        public LinearLayout bgH;
        public ThreadSkinView bgI;
        public TbImageView cee;
        public View chQ;
        public RelativeLayout chR;
        public HeadPendantClickableView chS;
        public ClickableHeaderImageView chT;
        public TextView chU;
        public TextView chV;
        public ThreadCommentAndPraiseInfoLayout chW;
        public TextView chX;
        public TextView chY;
        public TextView chZ;
        public View mRootView;

        public a() {
        }
    }
}

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
import com.baidu.tbadk.core.data.bi;
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
public class am extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.av> {
    private TbPageContext<?> ajT;
    private int avd;
    private ArrayList<Integer> ave;
    private int avp;
    private int avq;
    private int avr;
    private int avs;
    private int avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private com.baidu.tbadk.core.data.av bTE;
    public a bTF;
    private com.baidu.tieba.frs.g.af bTn;
    private CustomMessageListener bsD;
    private View.OnClickListener btD;
    private View.OnClickListener btE;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ave = new ArrayList<>();
        this.avd = 0;
        this.btD = new an(this);
        this.btE = new ao(this);
        this.bsD = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajT = tbPageContext;
        this.avp = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.avq = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.avr = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.avs = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.avt = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.avu = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.avv = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.avw = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.avx = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.avy = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.avz = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bTF = new a();
        this.bTF.mRootView = view.findViewById(w.h.card_root_view);
        this.bTF.btH = view.findViewById(w.h.top_line);
        this.bTF.bbg = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.bTF.baZ = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bTF.baY = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.bTF.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bTF.bbe = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.bTF.bto = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bTF.aRU = (TextView) view.findViewById(w.h.thread_title);
        this.bTF.bTH = (TextView) view.findViewById(w.h.thread_context);
        this.bTF.btI = (TextView) view.findViewById(w.h.fans_num);
        this.bTF.btJ = (TbImageView) view.findViewById(w.h.thread_image);
        this.bTF.btK = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bTF.btL = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bTF.bTI = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.bTF.bTJ = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.bTF.bTK = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.bTF.bOX = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.bTF.bbf = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.bTF.btK.setCommentNumClickListener(this);
        this.bTF.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bTF.bsk.setTitleClickListener(this);
        this.bTF.btK.setViewNumEnabled(true);
        this.bTn = new com.baidu.tieba.frs.g.af(this.ajT, this.bTF.btK);
    }

    private void initUI() {
        this.bTF.baZ.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.bTF.baZ.setDefaultResource(17170445);
        this.bTF.baZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTF.baZ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTF.baY.wL();
        this.bTF.baY.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.bTF.baY.getHeadView().setDefaultResource(17170445);
        this.bTF.baY.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bTF.baY.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.bTF.baY.getHeadView().setIsRound(true);
        this.bTF.baY.getHeadView().setDrawBorder(false);
        this.bTF.baY.getPendantView().setIsRound(true);
        this.bTF.baY.getPendantView().setDrawBorder(false);
        this.bTF.btK.setShowPraiseNum(false);
        this.bTF.btJ.setDrawBorder(true);
        this.bTF.btJ.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.av avVar) {
        this.bTE = avVar;
        Nq();
    }

    private void Nq() {
        boolean z;
        if (this.bTE == null) {
            this.bTF.mRootView.setVisibility(8);
            return;
        }
        if (this.bTE.getAuthor() == null || this.bTE.getAuthor().getPendantData() == null || StringUtils.isNull(this.bTE.getAuthor().getPendantData().qB())) {
            if (this.bTE.getAuthor() != null && this.bTE.getAuthor().getGodUserData() != null && this.bTE.getAuthor().getGodUserData().getType() == 2) {
                this.bTF.baZ.setGodIconMargin(0);
            } else {
                this.bTF.baZ.setIsGod(false);
            }
            UserTbVipInfoData sp = this.bTE.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bTF.bba != null) {
                    if (this.bTF.bbb == null) {
                        this.bTF.bba.inflate();
                        this.bTF.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bTF.bbb.setVisibility(0);
                    this.bTF.bbb.c(sp.getvipV_url(), 10, false);
                    this.bTF.baZ.setIsBigV(true);
                }
            } else {
                this.bTF.baZ.setIsBigV(false);
                if (this.bTF.bbb != null) {
                    this.bTF.bbb.setVisibility(8);
                }
            }
            this.bTF.baZ.setData(this.bTE);
            this.bTF.baZ.setAfterClickListener(this.btD);
            this.bTF.baZ.setVisibility(0);
            this.bTF.baY.setVisibility(8);
        } else {
            this.bTF.baZ.setIsGod(false);
            this.bTF.baZ.setIsBigV(false);
            if (this.bTF.bbb != null) {
                this.bTF.bbb.setVisibility(8);
            }
            this.bTF.baZ.setVisibility(4);
            this.bTF.baY.setVisibility(0);
            this.bTF.baY.setData(this.bTE);
        }
        if (this.bTE.getAuthor() != null && !StringUtils.isNull(this.bTE.getAuthor().getSealPrefix())) {
            this.bTF.bto.aP(true);
        }
        this.bTF.bto.setData(this.bTE);
        this.bTF.bto.setUserNameTextSizeRid(w.f.fontsize24);
        this.bTF.bto.setUserAfterClickListener(this.btD);
        this.bTF.bto.setPageName(1);
        Resources resources = this.ajT.getResources();
        if (!StringUtils.isNull(this.bTE.getTitle())) {
            int length = this.bTE.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bTE.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bTF.aRU.setSingleLine(true);
        } else {
            this.bTF.aRU.setMaxLines(2);
        }
        this.bTE.e(false, true);
        this.bTF.aRU.setText(this.bTE.sO());
        String fansNickName = this.bTE.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bTF.btI.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bTE.getAuthor().getFansNum()));
        if (this.bTF.btK.a(this.bTE)) {
            this.bTF.btL.setVisibility(8);
        } else {
            this.bTF.btL.setVisibility(0);
        }
        this.bTF.btK.setForumAfterClickListener(this.btE);
        this.bTF.btK.setStType(com.baidu.tieba.card.at.sf());
        s(this.bTE);
        this.bTn.A(this.bTE);
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.q.po().pu() && this.bTE.getPhotoLiveCover() != null && this.bTE.getPhotoLiveCover().length() != 0) {
            this.bTF.btJ.setVisibility(0);
            this.bTF.bTH.setVisibility(8);
            this.bTF.btJ.c(this.bTE.getPhotoLiveCover(), 10, false);
            b(this.bTE);
        } else {
            this.bTF.btJ.setVisibility(8);
            this.bTF.bTI.setVisibility(8);
            this.bTF.bTJ.setVisibility(8);
            this.bTF.bTK.setVisibility(8);
            String sw = this.bTE.sw();
            this.bTF.bTH.setText(sw);
            this.bTF.bTH.setVisibility(StringUtils.isNull(sw) ? 8 : 0);
        }
        p.a(this.bTE, this.bTF.bsk);
        com.baidu.tbadk.core.util.aq.c(this.bTF.btI, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.hZ(this.bTE.getTid())) {
            com.baidu.tbadk.core.util.aq.c(this.bTF.aRU, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bTF.bTH, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.bTF.aRU, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.bTF.bTH, w.e.cp_cont_j, 1);
    }

    private void s(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bTF.baZ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bTF.bbe.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bTF.bOX.setVisibility(8);
                if (this.bTF.bbf != null) {
                    if (sJ != null) {
                        this.bTF.bbf.a(this.ajT, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds16);
                    } else {
                        this.bTF.bbf.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bTF.bOX.setVisibility(0);
                this.bTF.bOX.setImageBitmap(null);
                this.bTF.bOX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bTF.bOX.setOnClickListener(new aq(this, themeCard));
                this.bTF.bbf.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds30);
            }
            this.bTF.baZ.setLayoutParams(layoutParams);
            this.bTF.bbe.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTF != null) {
            if (view == this.bTF.mRootView || view == this.bTF.btK.getCommentNumView() || view == this.bTF.bsk) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bTF.mRootView, this.bTE);
                }
                SR();
            }
        }
    }

    private void SR() {
        PhotoLiveActivityConfig pE;
        if (this.bTE != null) {
            com.baidu.tieba.card.at.hY(this.bTE.getTid());
            if (!SS()) {
                UtilHelper.showToast(this.ajT.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.bTE.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bjm()) {
                pE = new PhotoLiveActivityConfig.a(this.ajT.getPageActivity(), this.bTE.getTid()).ck("from_frs").bC(18003).ci(String.valueOf(this.bTE.sK())).pE();
            } else {
                pE = new PhotoLiveActivityConfig.a(this.ajT.getPageActivity(), this.bTE.getTid()).ck("from_frs").bC(18003).pE();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pE));
            ia(this.bTE.getTid());
        }
    }

    public void ia(String str) {
        new Handler().postDelayed(new ar(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bTF.mRootView);
            this.bTF.bto.onChangeSkinType();
            this.bTF.btK.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.bTF.btH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bTF.mRootView, w.g.addresslist_item_bg);
            if (this.bTF.bsk != null) {
                this.bTF.bsk.onChangeSkinType();
            }
            this.bTn.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean SS() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bsD != null) {
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    private void b(com.baidu.tbadk.core.data.av avVar) {
        this.ave.clear();
        BK();
        if (avVar != null && avVar.sH() != null) {
            int size = avVar.sH().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = avVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, avVar.sH(), i);
                }
            }
            BJ();
        }
    }

    private void BK() {
        this.bTF.bTI.setText("");
        this.bTF.bTJ.setText("");
        this.bTF.bTK.setText("");
        if (this.bTF.bTI.getVisibility() == 8) {
            this.bTF.bTI.setVisibility(0);
        }
        if (this.bTF.bTJ.getVisibility() == 8) {
            this.bTF.bTJ.setVisibility(0);
        }
        if (this.bTF.bTK.getVisibility() == 8) {
            this.bTF.bTK.setVisibility(0);
        }
        this.ave.add(Integer.valueOf(this.bTF.bTI.getId()));
        this.ave.add(Integer.valueOf(this.bTF.bTJ.getId()));
        this.ave.add(Integer.valueOf(this.bTF.bTK.getId()));
    }

    private void BJ() {
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i = 0; i < size; i++) {
                if (this.ave.get(i).intValue() == this.bTF.bTI.getId()) {
                    this.bTF.bTI.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.bTF.bTJ.getId()) {
                    this.bTF.bTJ.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.bTF.bTK.getId()) {
                    this.bTF.bTK.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avd) {
                case 0:
                    a(this.avp, this.avq, this.bTF.bTI);
                    a(this.avr, this.avs, this.bTF.bTJ);
                    a(this.avt, this.avu, this.bTF.bTK);
                    break;
                case 1:
                    a(this.avu, this.avv, this.bTF.bTI);
                    a(this.avw, this.avu, this.bTF.bTJ);
                    a(this.avx, this.avs, this.bTF.bTK);
                    break;
                case 2:
                    a(this.avu, this.avy, this.bTF.bTI);
                    a(this.avz, this.avu, this.bTF.bTJ);
                    a(this.avx, this.avs, this.bTF.bTK);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bTF.bTI);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bTF.bTJ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bTF.bTK);
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
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.Bw())));
            ei(textView.getId());
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

    private void ei(int i) {
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ave.get(i2).intValue() == i) {
                    this.ave.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRU;
        public TbImageView bOX;
        public TextView bTH;
        public TextView bTI;
        public TextView bTJ;
        public TextView bTK;
        public HeadPendantClickableView baY;
        public ClickableHeaderImageView baZ;
        public ViewStub bba;
        public TbImageView bbb;
        public LinearLayout bbe;
        public ThreadSkinView bbf;
        public RelativeLayout bbg;
        public CardGroupDividerView bsk;
        public View btH;
        public TextView btI;
        public TbImageView btJ;
        public ThreadCommentAndPraiseInfoLayout btK;
        public View btL;
        public UserIconLayout bto;
        public View mRootView;

        public a() {
        }
    }
}

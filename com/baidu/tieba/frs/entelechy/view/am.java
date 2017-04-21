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
    private TbPageContext<?> ajU;
    private int avA;
    private int avB;
    private int avf;
    private ArrayList<Integer> avg;
    private int avr;
    private int avs;
    private int avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private com.baidu.tieba.frs.g.af bVE;
    private com.baidu.tbadk.core.data.av bVV;
    public a bVW;
    private CustomMessageListener buW;
    private View.OnClickListener bvV;
    private View.OnClickListener bvW;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.avg = new ArrayList<>();
        this.avf = 0;
        this.bvV = new an(this);
        this.bvW = new ao(this);
        this.buW = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajU = tbPageContext;
        this.avr = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.avs = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.avt = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.avu = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.avv = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.avw = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.avx = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.avy = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.avz = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.avA = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.avB = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bVW = new a();
        this.bVW.mRootView = view.findViewById(w.h.card_root_view);
        this.bVW.bvZ = view.findViewById(w.h.top_line);
        this.bVW.bcc = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.bVW.bbV = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bVW.bbU = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.bVW.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bVW.bca = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.bVW.bvG = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bVW.aRW = (TextView) view.findViewById(w.h.thread_title);
        this.bVW.bVY = (TextView) view.findViewById(w.h.thread_context);
        this.bVW.bwa = (TextView) view.findViewById(w.h.fans_num);
        this.bVW.bwb = (TbImageView) view.findViewById(w.h.thread_image);
        this.bVW.bwc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bVW.bwd = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bVW.bVZ = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.bVW.bWa = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.bVW.bWb = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.bVW.bRo = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.bVW.bcb = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.bVW.bwc.setCommentNumClickListener(this);
        this.bVW.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bVW.buD.setTitleClickListener(this);
        this.bVW.bwc.setViewNumEnabled(true);
        this.bVE = new com.baidu.tieba.frs.g.af(this.ajU, this.bVW.bwc);
    }

    private void initUI() {
        this.bVW.bbV.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bVW.bbV.setDefaultResource(17170445);
        this.bVW.bbV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bVW.bbV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bVW.bbU.wL();
        this.bVW.bbU.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bVW.bbU.getHeadView().setDefaultResource(17170445);
        this.bVW.bbU.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bVW.bbU.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.bVW.bbU.getHeadView().setIsRound(true);
        this.bVW.bbU.getHeadView().setDrawBorder(false);
        this.bVW.bbU.getPendantView().setIsRound(true);
        this.bVW.bbU.getPendantView().setDrawBorder(false);
        this.bVW.bwc.setShowPraiseNum(false);
        this.bVW.bwb.setDrawBorder(true);
        this.bVW.bwb.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.av avVar) {
        this.bVV = avVar;
        Ny();
    }

    private void Ny() {
        boolean z;
        if (this.bVV == null) {
            this.bVW.mRootView.setVisibility(8);
            return;
        }
        if (this.bVV.getAuthor() == null || this.bVV.getAuthor().getPendantData() == null || StringUtils.isNull(this.bVV.getAuthor().getPendantData().qB())) {
            if (this.bVV.getAuthor() != null && this.bVV.getAuthor().getGodUserData() != null && this.bVV.getAuthor().getGodUserData().getType() == 2) {
                this.bVW.bbV.setGodIconMargin(0);
            } else {
                this.bVW.bbV.setIsGod(false);
            }
            UserTbVipInfoData sp = this.bVV.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bVW.bbW != null) {
                    if (this.bVW.bbX == null) {
                        this.bVW.bbW.inflate();
                        this.bVW.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bVW.bbX.setVisibility(0);
                    this.bVW.bbX.c(sp.getvipV_url(), 10, false);
                    this.bVW.bbV.setIsBigV(true);
                }
            } else {
                this.bVW.bbV.setIsBigV(false);
                if (this.bVW.bbX != null) {
                    this.bVW.bbX.setVisibility(8);
                }
            }
            this.bVW.bbV.setData(this.bVV);
            this.bVW.bbV.setAfterClickListener(this.bvV);
            this.bVW.bbV.setVisibility(0);
            this.bVW.bbU.setVisibility(8);
        } else {
            this.bVW.bbV.setIsGod(false);
            this.bVW.bbV.setIsBigV(false);
            if (this.bVW.bbX != null) {
                this.bVW.bbX.setVisibility(8);
            }
            this.bVW.bbV.setVisibility(4);
            this.bVW.bbU.setVisibility(0);
            this.bVW.bbU.setData(this.bVV);
        }
        if (this.bVV.getAuthor() != null && !StringUtils.isNull(this.bVV.getAuthor().getSealPrefix())) {
            this.bVW.bvG.aP(true);
        }
        this.bVW.bvG.setData(this.bVV);
        this.bVW.bvG.setUserNameTextSizeRid(w.f.fontsize24);
        this.bVW.bvG.setUserAfterClickListener(this.bvV);
        this.bVW.bvG.setPageName(1);
        Resources resources = this.ajU.getResources();
        if (!StringUtils.isNull(this.bVV.getTitle())) {
            int length = this.bVV.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bVV.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bVW.aRW.setSingleLine(true);
        } else {
            this.bVW.aRW.setMaxLines(2);
        }
        this.bVV.e(false, true);
        this.bVW.aRW.setText(this.bVV.sO());
        String fansNickName = this.bVV.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bVW.bwa.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bVV.getAuthor().getFansNum()));
        if (this.bVW.bwc.a(this.bVV)) {
            this.bVW.bwd.setVisibility(8);
        } else {
            this.bVW.bwd.setVisibility(0);
        }
        this.bVW.bwc.setForumAfterClickListener(this.bvW);
        this.bVW.bwc.setStType(com.baidu.tieba.card.at.sf());
        s(this.bVV);
        this.bVE.A(this.bVV);
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.q.po().pu() && this.bVV.getPhotoLiveCover() != null && this.bVV.getPhotoLiveCover().length() != 0) {
            this.bVW.bwb.setVisibility(0);
            this.bVW.bVY.setVisibility(8);
            this.bVW.bwb.c(this.bVV.getPhotoLiveCover(), 10, false);
            b(this.bVV);
        } else {
            this.bVW.bwb.setVisibility(8);
            this.bVW.bVZ.setVisibility(8);
            this.bVW.bWa.setVisibility(8);
            this.bVW.bWb.setVisibility(8);
            String sw = this.bVV.sw();
            this.bVW.bVY.setText(sw);
            this.bVW.bVY.setVisibility(StringUtils.isNull(sw) ? 8 : 0);
        }
        p.a(this.bVV, this.bVW.buD);
        com.baidu.tbadk.core.util.aq.c(this.bVW.bwa, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.ia(this.bVV.getTid())) {
            com.baidu.tbadk.core.util.aq.c(this.bVW.aRW, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bVW.bVY, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.bVW.aRW, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.bVW.bVY, w.e.cp_cont_j, 1);
    }

    private void s(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVW.bbV.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bVW.bca.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bVW.bRo.setVisibility(8);
                if (this.bVW.bcb != null) {
                    if (sJ != null) {
                        this.bVW.bcb.a(this.ajU, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds16);
                    } else {
                        this.bVW.bcb.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bVW.bRo.setVisibility(0);
                this.bVW.bRo.setImageBitmap(null);
                this.bVW.bRo.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bVW.bRo.setOnClickListener(new aq(this, themeCard));
                this.bVW.bcb.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds30);
            }
            this.bVW.bbV.setLayoutParams(layoutParams);
            this.bVW.bca.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bVW != null) {
            if (view == this.bVW.mRootView || view == this.bVW.bwc.getCommentNumView() || view == this.bVW.buD) {
                if (getOnSubCardOnClickListenner() != null) {
                    getOnSubCardOnClickListenner().a(this.bVW.mRootView, this.bVV);
                }
                TT();
            }
        }
    }

    private void TT() {
        PhotoLiveActivityConfig pE;
        if (this.bVV != null) {
            com.baidu.tieba.card.at.hZ(this.bVV.getTid());
            if (!TU()) {
                UtilHelper.showToast(this.ajU.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.bVV.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bkn()) {
                pE = new PhotoLiveActivityConfig.a(this.ajU.getPageActivity(), this.bVV.getTid()).ck("from_frs").bC(18003).ci(String.valueOf(this.bVV.sK())).pE();
            } else {
                pE = new PhotoLiveActivityConfig.a(this.ajU.getPageActivity(), this.bVV.getTid()).ck("from_frs").bC(18003).pE();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pE));
            ib(this.bVV.getTid());
        }
    }

    public void ib(String str) {
        new Handler().postDelayed(new ar(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bVW.mRootView);
            this.bVW.bvG.onChangeSkinType();
            this.bVW.bwc.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.bVW.bvZ, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bVW.mRootView, w.g.addresslist_item_bg);
            if (this.bVW.buD != null) {
                this.bVW.buD.onChangeSkinType();
            }
            this.bVE.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean TU() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.buW != null) {
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    private void b(com.baidu.tbadk.core.data.av avVar) {
        this.avg.clear();
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
        this.bVW.bVZ.setText("");
        this.bVW.bWa.setText("");
        this.bVW.bWb.setText("");
        if (this.bVW.bVZ.getVisibility() == 8) {
            this.bVW.bVZ.setVisibility(0);
        }
        if (this.bVW.bWa.getVisibility() == 8) {
            this.bVW.bWa.setVisibility(0);
        }
        if (this.bVW.bWb.getVisibility() == 8) {
            this.bVW.bWb.setVisibility(0);
        }
        this.avg.add(Integer.valueOf(this.bVW.bVZ.getId()));
        this.avg.add(Integer.valueOf(this.bVW.bWa.getId()));
        this.avg.add(Integer.valueOf(this.bVW.bWb.getId()));
    }

    private void BJ() {
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i = 0; i < size; i++) {
                if (this.avg.get(i).intValue() == this.bVW.bVZ.getId()) {
                    this.bVW.bVZ.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.bVW.bWa.getId()) {
                    this.bVW.bWa.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.bVW.bWb.getId()) {
                    this.bVW.bWb.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avf) {
                case 0:
                    a(this.avr, this.avs, this.bVW.bVZ);
                    a(this.avt, this.avu, this.bVW.bWa);
                    a(this.avv, this.avw, this.bVW.bWb);
                    break;
                case 1:
                    a(this.avw, this.avx, this.bVW.bVZ);
                    a(this.avy, this.avw, this.bVW.bWa);
                    a(this.avz, this.avu, this.bVW.bWb);
                    break;
                case 2:
                    a(this.avw, this.avA, this.bVW.bVZ);
                    a(this.avB, this.avw, this.bVW.bWa);
                    a(this.avz, this.avu, this.bVW.bWb);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bVW.bVZ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bVW.bWa);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bVW.bWb);
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
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avg.get(i2).intValue() == i) {
                    this.avg.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRW;
        public TbImageView bRo;
        public TextView bVY;
        public TextView bVZ;
        public TextView bWa;
        public TextView bWb;
        public HeadPendantClickableView bbU;
        public ClickableHeaderImageView bbV;
        public ViewStub bbW;
        public TbImageView bbX;
        public LinearLayout bca;
        public ThreadSkinView bcb;
        public RelativeLayout bcc;
        public CardGroupDividerView buD;
        public UserIconLayout bvG;
        public View bvZ;
        public TextView bwa;
        public TbImageView bwb;
        public ThreadCommentAndPraiseInfoLayout bwc;
        public View bwd;
        public View mRootView;

        public a() {
        }
    }
}

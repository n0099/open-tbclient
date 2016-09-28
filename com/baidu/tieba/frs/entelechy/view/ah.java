package com.baidu.tieba.frs.entelechy.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.as> {
    private TbPageContext<?> GM;
    private CustomMessageListener aZT;
    private int apQ;
    private ArrayList<Integer> apR;
    private int aqc;
    private int aqd;
    private int aqe;
    private int aqf;
    private int aqg;
    private int aqh;
    private int aqi;
    private int aqj;
    private int aqk;
    private int aql;
    private int aqm;
    private com.baidu.tbadk.core.data.as bXp;
    public a bXq;
    private View.OnClickListener baA;
    private View.OnClickListener baB;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.apR = new ArrayList<>();
        this.apQ = 0;
        this.baA = new ai(this);
        this.baB = new aj(this);
        this.aZT = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GM = tbPageContext;
        this.aqc = (int) tbPageContext.getResources().getDimension(r.e.ds80);
        this.aqd = (int) tbPageContext.getResources().getDimension(r.e.ds280);
        this.aqe = (int) tbPageContext.getResources().getDimension(r.e.ds170);
        this.aqf = (int) tbPageContext.getResources().getDimension(r.e.ds320);
        this.aqg = (int) tbPageContext.getResources().getDimension(r.e.ds200);
        this.aqh = (int) tbPageContext.getResources().getDimension(r.e.ds60);
        this.aqi = (int) tbPageContext.getResources().getDimension(r.e.ds120);
        this.aqj = (int) tbPageContext.getResources().getDimension(r.e.ds160);
        this.aqk = (int) tbPageContext.getResources().getDimension(r.e.ds220);
        this.aql = (int) tbPageContext.getResources().getDimension(r.e.ds240);
        this.aqm = (int) tbPageContext.getResources().getDimension(r.e.ds180);
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.bXq = new a();
        this.bXq.mRootView = view.findViewById(r.g.card_root_view);
        this.bXq.baE = view.findViewById(r.g.top_line);
        this.bXq.bXe = (RelativeLayout) view.findViewById(r.g.live_card_content_root);
        this.bXq.aZw = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.bXq.bXb = (HeadPendantClickableView) view.findViewById(r.g.pendant_avatar);
        this.bXq.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bXq.aZA = (LinearLayout) view.findViewById(r.g.live_card_content_layout);
        this.bXq.bak = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.bXq.baF = (TextView) view.findViewById(r.g.thread_title);
        this.bXq.bXs = (TextView) view.findViewById(r.g.thread_context);
        this.bXq.baG = (TextView) view.findViewById(r.g.fans_num);
        this.bXq.baH = (TbImageView) view.findViewById(r.g.thread_image);
        this.bXq.baI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.bXq.bXt = (TextView) view.findViewById(r.g.first_style_first_expression);
        this.bXq.bXu = (TextView) view.findViewById(r.g.first_style_second_expression);
        this.bXq.bXv = (TextView) view.findViewById(r.g.first_style_third_expression);
        this.bXq.bSf = (TbImageView) view.findViewById(r.g.frs_live_item_theme_card);
        this.bXq.bSw = (ThreadSkinView) view.findViewById(r.g.frs_live_skin);
        this.bXq.baI.setCommentNumClickListener(this);
        this.bXq.bXw = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.bXq.bXx = view.findViewById(r.g.guess_your_like_bottom_line);
    }

    private void initUI() {
        this.bXq.aZw.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.bXq.aZw.setDefaultResource(17170445);
        this.bXq.aZw.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bXq.aZw.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bXq.bXb.wk();
        this.bXq.bXb.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.bXq.bXb.getHeadView().setDefaultResource(17170445);
        this.bXq.bXb.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bXq.bXb.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        this.bXq.bXb.getHeadView().setIsRound(true);
        this.bXq.bXb.getHeadView().setDrawBorder(false);
        this.bXq.bXb.getPendantView().setIsRound(true);
        this.bXq.bXb.getPendantView().setDrawBorder(false);
        this.bXq.baI.setShowPraiseNum(false);
        this.bXq.baH.setDrawBorder(true);
        this.bXq.baH.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.as asVar) {
        this.bXp = asVar;
        NZ();
    }

    private void NZ() {
        String string;
        boolean z;
        if (this.bXp == null) {
            this.bXq.mRootView.setVisibility(8);
            return;
        }
        if (this.bXp.getAuthor() == null || this.bXp.getAuthor().getPendantData() == null || StringUtils.isNull(this.bXp.getAuthor().getPendantData().pO())) {
            if (this.bXp.getAuthor() != null && this.bXp.getAuthor().getGodUserData() != null && this.bXp.getAuthor().getGodUserData().getType() == 2) {
                this.bXq.aZw.setGodIconMargin(0);
            } else {
                this.bXq.aZw.setIsGod(false);
            }
            UserTbVipInfoData rO = this.bXp.rO();
            if (rO != null && rO.getvipV_url() != null) {
                if (this.bXq.aYH != null) {
                    if (this.bXq.aYI == null) {
                        this.bXq.aYH.inflate();
                        this.bXq.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.bXq.aYI.setVisibility(0);
                    this.bXq.aYI.c(rO.getvipV_url(), 10, false);
                    this.bXq.aZw.setIsBigV(true);
                }
            } else {
                this.bXq.aZw.setIsBigV(false);
                if (this.bXq.aYI != null) {
                    this.bXq.aYI.setVisibility(8);
                }
            }
            this.bXq.aZw.setData(this.bXp);
            this.bXq.aZw.setAfterClickListener(this.baA);
            this.bXq.aZw.setVisibility(0);
            this.bXq.bXb.setVisibility(8);
        } else {
            this.bXq.aZw.setIsGod(false);
            this.bXq.aZw.setIsBigV(false);
            if (this.bXq.aYI != null) {
                this.bXq.aYI.setVisibility(8);
            }
            this.bXq.aZw.setVisibility(4);
            this.bXq.bXb.setVisibility(0);
            this.bXq.bXb.setData(this.bXp);
        }
        this.bXq.bak.setData(this.bXp);
        this.bXq.bak.setUserNameTextSizeRid(r.e.fontsize24);
        this.bXq.bak.setUserAfterClickListener(this.baA);
        this.bXq.bak.setPageName(1);
        Resources resources = this.GM.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.bXp.getTitle()).setSpan(new ForegroundColorSpan(av.getColor(r.d.cp_link_tip_a)), 0, resources.getString(r.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.bXp.getTitle())) {
            int length = this.bXp.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bXp.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bXq.baF.setSingleLine(true);
        } else {
            this.bXq.baF.setMaxLines(2);
        }
        this.bXq.baF.setText(e(this.bXp.getTitle()));
        String fansNickName = this.bXp.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.bXq.baG.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.az.w(this.bXp.getAuthor().getFansNum()));
        this.bXq.baI.setData(this.bXp);
        this.bXq.baI.setForumAfterClickListener(this.baB);
        this.bXq.baI.setStType(com.baidu.tieba.card.an.Od());
        l(this.bXp);
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oH().oN() && this.bXp.getPhotoLiveCover() != null && this.bXp.getPhotoLiveCover().length() != 0) {
            this.bXq.baH.setVisibility(0);
            this.bXq.bXs.setVisibility(8);
            this.bXq.baH.c(this.bXp.getPhotoLiveCover(), 10, false);
            b(this.bXp);
        } else {
            this.bXq.baH.setVisibility(8);
            this.bXq.bXt.setVisibility(8);
            this.bXq.bXu.setVisibility(8);
            this.bXq.bXv.setVisibility(8);
            String rU = this.bXp.rU();
            this.bXq.bXs.setText(rU);
            this.bXq.bXs.setVisibility(StringUtils.isNull(rU) ? 8 : 0);
        }
        if (this.bXq.bXw != null) {
            if ((this.bXp.sk() || this.bXp.sl()) && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                this.bXq.bXw.setTitleText(StringUtils.isNull(this.bXp.sj()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.bXp.sj());
                this.bXq.bXw.show();
                this.bXq.baE.setVisibility(8);
                if (this.bXq.bXx != null) {
                    this.bXq.bXx.setVisibility(0);
                }
                if (this.bXp.bbL) {
                    this.bXq.bXw.bqS();
                } else {
                    this.bXq.bXw.bqR();
                    if (this.bXp.bbM) {
                        this.bXq.baE.setVisibility(0);
                    }
                }
            } else {
                this.bXq.bXw.hide();
                this.bXq.baE.setVisibility(0);
                if (this.bXq.bXx != null) {
                    this.bXq.bXx.setVisibility(8);
                }
            }
        }
        av.c(this.bXq.baG, r.d.cp_cont_d, 1);
        if (com.baidu.tieba.card.an.hO(this.bXp.getTid())) {
            av.c(this.bXq.baF, r.d.cp_cont_d, 1);
            av.c(this.bXq.bXs, r.d.cp_cont_d, 1);
            return;
        }
        av.c(this.bXq.baF, r.d.cp_cont_b, 1);
        av.c(this.bXq.bXs, r.d.cp_cont_j, 1);
    }

    private void l(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sg = biVar.sg();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bXq.aZw.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bXq.aZA.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bXq.bSf.setVisibility(8);
                if (this.bXq.bSw != null) {
                    if (sg != null) {
                        this.bXq.bSw.a(this.GM, sg, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.getForum_name(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds16);
                    } else {
                        this.bXq.bSw.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bXq.bSf.setVisibility(0);
                this.bXq.bSf.setImageBitmap(null);
                this.bXq.bSf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bXq.bSf.setOnClickListener(new al(this, themeCard));
                this.bXq.bSw.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds30);
            }
            this.bXq.aZw.setLayoutParams(layoutParams);
            this.bXq.aZA.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXq.mRootView || view == this.bXq.baI.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bXq.mRootView, this.bXp);
            }
            Oh();
        }
    }

    private void Oh() {
        PhotoLiveActivityConfig oX;
        if (this.bXp != null) {
            com.baidu.tieba.card.an.hN(this.bXp.getTid());
            if (!Oi()) {
                UtilHelper.showToast(this.GM.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            if (this.bXp.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                oX = new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bXp.getTid()).ck("from_frs").bF(18003).ci(String.valueOf(this.bXp.sh())).oX();
            } else {
                oX = new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bXp.getTid()).ck("from_frs").bF(18003).oX();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oX));
            hP(this.bXp.getTid());
        }
    }

    public void hP(String str) {
        new Handler().postDelayed(new am(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bXq.mRootView);
            this.bXq.bak.tx();
            this.bXq.baI.tx();
            av.l(this.bXq.baE, r.d.cp_bg_line_c);
            av.k(this.bXq.mRootView, r.f.addresslist_item_bg);
            if (this.bXq.bXw != null) {
                this.bXq.bXw.tx();
            }
            av.l(this.bXq.bXx, r.d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    private boolean Oi() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aZT != null) {
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    private void b(com.baidu.tbadk.core.data.as asVar) {
        this.apR.clear();
        Be();
        if (asVar != null && asVar.se() != null) {
            int size = asVar.se().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = asVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, asVar.se(), i);
                }
            }
            Bd();
        }
    }

    private void Be() {
        this.bXq.bXt.setText("");
        this.bXq.bXu.setText("");
        this.bXq.bXv.setText("");
        if (this.bXq.bXt.getVisibility() == 8) {
            this.bXq.bXt.setVisibility(0);
        }
        if (this.bXq.bXu.getVisibility() == 8) {
            this.bXq.bXu.setVisibility(0);
        }
        if (this.bXq.bXv.getVisibility() == 8) {
            this.bXq.bXv.setVisibility(0);
        }
        this.apR.add(Integer.valueOf(this.bXq.bXt.getId()));
        this.apR.add(Integer.valueOf(this.bXq.bXu.getId()));
        this.apR.add(Integer.valueOf(this.bXq.bXv.getId()));
    }

    private void Bd() {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i = 0; i < size; i++) {
                if (this.apR.get(i).intValue() == this.bXq.bXt.getId()) {
                    this.bXq.bXt.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.bXq.bXu.getId()) {
                    this.bXq.bXu.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.bXq.bXv.getId()) {
                    this.bXq.bXv.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.apQ) {
                case 0:
                    a(this.aqc, this.aqd, this.bXq.bXt);
                    a(this.aqe, this.aqf, this.bXq.bXu);
                    a(this.aqg, this.aqh, this.bXq.bXv);
                    break;
                case 1:
                    a(this.aqh, this.aqi, this.bXq.bXt);
                    a(this.aqj, this.aqh, this.bXq.bXu);
                    a(this.aqk, this.aqf, this.bXq.bXv);
                    break;
                case 2:
                    a(this.aqh, this.aql, this.bXq.bXt);
                    a(this.aqm, this.aqh, this.bXq.bXu);
                    a(this.aqk, this.aqf, this.bXq.bXv);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bXq.bXt);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bXq.bXu);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bXq.bXv);
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
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AP())));
            eg(textView.getId());
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

    private void eg(int i) {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apR.get(i2).intValue() == i) {
                    this.apR.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GM.getResources().getString(r.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(av.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        Bitmap cN = av.cN(r.f.pic_dot_title);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        if (cN != null) {
            bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
        }
        spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.ag(bitmapDrawable), string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYH;
        public TbImageView aYI;
        public LinearLayout aZA;
        public ClickableHeaderImageView aZw;
        public TbImageView bSf;
        public ThreadSkinView bSw;
        public HeadPendantClickableView bXb;
        public RelativeLayout bXe;
        public TextView bXs;
        public TextView bXt;
        public TextView bXu;
        public TextView bXv;
        public GuessYourLikeHeaderView bXw;
        public View bXx;
        public View baE;
        public TextView baF;
        public TextView baG;
        public TbImageView baH;
        public ThreadCommentAndPraiseInfoLayout baI;
        public UserIconLayout bak;
        public View mRootView;

        public a() {
        }
    }
}

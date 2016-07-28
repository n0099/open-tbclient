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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.ao> {
    private TbPageContext<?> EA;
    private View.OnClickListener aUX;
    private View.OnClickListener aUY;
    private CustomMessageListener aUs;
    private int anb;
    private ArrayList<Integer> anc;
    private int ann;
    private int ano;
    private int anp;
    private int anq;
    private int anr;
    private int ans;
    private int ant;
    private int anu;
    private int anv;
    private int anw;
    private int anx;
    private com.baidu.tbadk.core.data.ao bMc;
    public a bMd;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anc = new ArrayList<>();
        this.anb = 0;
        this.aUX = new af(this);
        this.aUY = new ag(this);
        this.aUs = new ah(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.EA = tbPageContext;
        this.ann = (int) tbPageContext.getResources().getDimension(u.e.ds80);
        this.ano = (int) tbPageContext.getResources().getDimension(u.e.ds280);
        this.anp = (int) tbPageContext.getResources().getDimension(u.e.ds170);
        this.anq = (int) tbPageContext.getResources().getDimension(u.e.ds320);
        this.anr = (int) tbPageContext.getResources().getDimension(u.e.ds200);
        this.ans = (int) tbPageContext.getResources().getDimension(u.e.ds60);
        this.ant = (int) tbPageContext.getResources().getDimension(u.e.ds120);
        this.anu = (int) tbPageContext.getResources().getDimension(u.e.ds160);
        this.anv = (int) tbPageContext.getResources().getDimension(u.e.ds220);
        this.anw = (int) tbPageContext.getResources().getDimension(u.e.ds240);
        this.anx = (int) tbPageContext.getResources().getDimension(u.e.ds180);
        Q(getView());
        initUI();
    }

    private void Q(View view) {
        this.bMd = new a();
        this.bMd.mRootView = view.findViewById(u.g.card_root_view);
        this.bMd.aVa = view.findViewById(u.g.top_line);
        this.bMd.bLT = (RelativeLayout) view.findViewById(u.g.live_card_content_root);
        this.bMd.aTU = (ClickableHeaderImageView) view.findViewById(u.g.avatar);
        this.bMd.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.bMd.aTY = (LinearLayout) view.findViewById(u.g.live_card_content_layout);
        this.bMd.aUI = (UserIconLayout) view.findViewById(u.g.user_icon);
        this.bMd.aVb = (TextView) view.findViewById(u.g.thread_title);
        this.bMd.bMf = (TextView) view.findViewById(u.g.thread_context);
        this.bMd.aVc = (TextView) view.findViewById(u.g.fans_num);
        this.bMd.aVd = (TbImageView) view.findViewById(u.g.thread_image);
        this.bMd.aVe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.thread_more_info);
        this.bMd.bMg = (TextView) view.findViewById(u.g.first_style_first_expression);
        this.bMd.bMh = (TextView) view.findViewById(u.g.first_style_second_expression);
        this.bMd.bMi = (TextView) view.findViewById(u.g.first_style_third_expression);
        this.bMd.bHg = (TbImageView) view.findViewById(u.g.frs_live_item_theme_card);
        this.bMd.bHx = (ThreadSkinView) view.findViewById(u.g.frs_live_skin);
        this.bMd.aVe.setCommentNumClickListener(this);
        this.bMd.bMj = (GuessYourLikeHeaderView) view.findViewById(u.g.guess_your_like_header);
        this.bMd.bMk = view.findViewById(u.g.guess_your_like_bottom_line);
    }

    private void initUI() {
        this.bMd.aTU.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.bMd.aTU.setDefaultResource(17170445);
        this.bMd.aTU.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.bMd.aTU.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bMd.aVe.setShowPraiseNum(false);
        this.bMd.aVd.setDrawBorder(true);
        this.bMd.aVd.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        this.bMc = aoVar;
        KW();
    }

    private void KW() {
        String string;
        boolean z;
        if (this.bMc == null) {
            this.bMd.mRootView.setVisibility(8);
            return;
        }
        if (this.bMc.getAuthor() != null && this.bMc.getAuthor().getGodUserData() != null && this.bMc.getAuthor().getGodUserData().getType() == 2) {
            this.bMd.aTU.setGodIconMargin(0);
        } else {
            this.bMd.aTU.setIsGod(false);
        }
        UserTbVipInfoData qx = this.bMc.qx();
        if (qx != null && qx.getvipV_url() != null) {
            if (this.bMd.aSW != null) {
                if (this.bMd.aSX == null) {
                    this.bMd.aSW.inflate();
                    this.bMd.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.bMd.aSX.setVisibility(0);
                this.bMd.aSX.c(qx.getvipV_url(), 10, false);
                this.bMd.aTU.setIsBigV(true);
            }
        } else {
            this.bMd.aTU.setIsBigV(false);
            if (this.bMd.aSX != null) {
                this.bMd.aSX.setVisibility(8);
            }
        }
        this.bMd.aTU.setData(this.bMc);
        this.bMd.aTU.setAfterClickListener(this.aUX);
        this.bMd.aUI.setData(this.bMc);
        this.bMd.aUI.setUserNameTextSizeRid(u.e.fontsize24);
        this.bMd.aUI.setUserAfterClickListener(this.aUX);
        this.bMd.aUI.setPageName(1);
        Resources resources = this.EA.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.bMc.getTitle()).setSpan(new ForegroundColorSpan(av.getColor(u.d.cp_link_tip_a)), 0, resources.getString(u.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.bMc.getTitle())) {
            int length = this.bMc.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bMc.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bMd.aVb.setSingleLine(true);
        } else {
            this.bMd.aVb.setMaxLines(2);
        }
        this.bMd.aVb.setText(e(this.bMc.getTitle()));
        String fansNickName = this.bMc.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(u.j.fans_default_name);
        }
        this.bMd.aVc.setText(String.valueOf(fansNickName) + ": " + ba.w(this.bMc.getAuthor().getFansNum()));
        this.bMd.aVe.setData(this.bMc);
        this.bMd.aVe.setForumAfterClickListener(this.aUY);
        this.bMd.aVe.setStType(at.La());
        j(this.bMc);
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        if (com.baidu.tbadk.core.l.nL().nR() && this.bMc.getPhotoLiveCover() != null && this.bMc.getPhotoLiveCover().length() != 0) {
            this.bMd.aVd.setVisibility(0);
            this.bMd.bMf.setVisibility(8);
            this.bMd.aVd.c(this.bMc.getPhotoLiveCover(), 10, false);
            b(this.bMc);
        } else {
            this.bMd.aVd.setVisibility(8);
            this.bMd.bMg.setVisibility(8);
            this.bMd.bMh.setVisibility(8);
            this.bMd.bMi.setVisibility(8);
            String qD = this.bMc.qD();
            this.bMd.bMf.setText(qD);
            this.bMd.bMf.setVisibility(StringUtils.isNull(qD) ? 8 : 0);
        }
        if (this.bMd.bMj != null) {
            if ((this.bMc.qT() || this.bMc.qU()) && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                this.bMd.bMj.setTitleText(StringUtils.isNull(this.bMc.qS()) ? getContext().getResources().getString(u.j.group_fourm_recommend_title) : this.bMc.qS());
                this.bMd.bMj.show();
                this.bMd.aVa.setVisibility(8);
                if (this.bMd.bMk != null) {
                    this.bMd.bMk.setVisibility(0);
                }
                if (this.bMc.aVQ) {
                    this.bMd.bMj.bmD();
                } else {
                    this.bMd.bMj.bmC();
                    if (this.bMc.aVR) {
                        this.bMd.aVa.setVisibility(0);
                    }
                }
            } else {
                this.bMd.bMj.hide();
                this.bMd.aVa.setVisibility(0);
                if (this.bMd.bMk != null) {
                    this.bMd.bMk.setVisibility(8);
                }
            }
        }
        av.c(this.bMd.aVc, u.d.cp_cont_d, 1);
        if (at.hc(this.bMc.getTid())) {
            av.c(this.bMd.aVb, u.d.cp_cont_d, 1);
            av.c(this.bMd.bMf, u.d.cp_cont_d, 1);
            return;
        }
        av.c(this.bMd.aVb, u.d.cp_cont_b, 1);
        av.c(this.bMd.bMf, u.d.cp_cont_j, 1);
    }

    private void j(be beVar) {
        MetaData author;
        if (beVar != null && (author = beVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo qP = beVar.qP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bMd.aTU.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bMd.aTY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bMd.bHg.setVisibility(8);
                this.bMd.bLT.setPadding(this.bMd.bLT.getPaddingLeft(), 0, this.bMd.bLT.getPaddingRight(), this.bMd.bLT.getPaddingBottom());
                if (this.bMd.bHx != null) {
                    if (qP != null) {
                        this.bMd.bHx.a(this.EA, qP, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(beVar.getFid()), beVar.getForum_name(), beVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds16);
                    } else {
                        this.bMd.bHx.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds30);
                    }
                }
            } else {
                this.bMd.bHg.setVisibility(0);
                this.bMd.bHg.setImageBitmap(null);
                this.bMd.bHg.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bMd.bHg.setOnClickListener(new ai(this, themeCard));
                this.bMd.aTY.setPadding(this.bMd.aTY.getPaddingLeft(), com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds14), this.bMd.aTY.getPaddingRight(), this.bMd.aTY.getPaddingBottom());
                this.bMd.bHx.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds40);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds30);
            }
            this.bMd.aTU.setLayoutParams(layoutParams);
            this.bMd.aTY.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMd.mRootView || view == this.bMd.aVe.getCommentNumView()) {
            if (KN() != null) {
                KN().a(this.bMd.mRootView, this.bMc);
            }
            Ld();
        }
    }

    private void Ld() {
        PhotoLiveActivityConfig oa;
        if (this.bMc != null) {
            at.hb(this.bMc.getTid());
            if (!Le()) {
                UtilHelper.showToast(this.EA.getPageActivity(), u.j.plugin_config_not_found);
                return;
            }
            if (this.bMc.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                oa = new PhotoLiveActivityConfig.a(this.EA.getPageActivity(), this.bMc.getTid()).cj("from_frs").bs(18003).ch(String.valueOf(this.bMc.qQ())).oa();
            } else {
                oa = new PhotoLiveActivityConfig.a(this.EA.getPageActivity(), this.bMc.getTid()).cj("from_frs").bs(18003).oa();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oa));
            hd(this.bMc.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new aj(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bMd.mRootView);
            this.bMd.aUI.sd();
            this.bMd.aVe.sd();
            av.l(this.bMd.aVa, u.d.cp_bg_line_c);
            av.k(this.bMd.mRootView, u.f.addresslist_item_bg);
            if (this.bMd.bMj != null) {
                this.bMd.bMj.sd();
            }
            av.l(this.bMd.bMk, u.d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    private boolean Le() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aUs != null) {
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    private void b(com.baidu.tbadk.core.data.ao aoVar) {
        this.anc.clear();
        zM();
        if (aoVar != null && aoVar.qN() != null) {
            int size = aoVar.qN().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = aoVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, aoVar.qN(), i);
                }
            }
            zL();
        }
    }

    private void zM() {
        this.bMd.bMg.setText("");
        this.bMd.bMh.setText("");
        this.bMd.bMi.setText("");
        if (this.bMd.bMg.getVisibility() == 8) {
            this.bMd.bMg.setVisibility(0);
        }
        if (this.bMd.bMh.getVisibility() == 8) {
            this.bMd.bMh.setVisibility(0);
        }
        if (this.bMd.bMi.getVisibility() == 8) {
            this.bMd.bMi.setVisibility(0);
        }
        this.anc.add(Integer.valueOf(this.bMd.bMg.getId()));
        this.anc.add(Integer.valueOf(this.bMd.bMh.getId()));
        this.anc.add(Integer.valueOf(this.bMd.bMi.getId()));
    }

    private void zL() {
        if (this.anc.size() != 0) {
            int size = this.anc.size();
            for (int i = 0; i < size; i++) {
                if (this.anc.get(i).intValue() == this.bMd.bMg.getId()) {
                    this.bMd.bMg.setVisibility(8);
                } else if (this.anc.get(i).intValue() == this.bMd.bMh.getId()) {
                    this.bMd.bMh.setVisibility(8);
                } else if (this.anc.get(i).intValue() == this.bMd.bMi.getId()) {
                    this.bMd.bMi.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.anb) {
                case 0:
                    a(this.ann, this.ano, this.bMd.bMg);
                    a(this.anp, this.anq, this.bMd.bMh);
                    a(this.anr, this.ans, this.bMd.bMi);
                    break;
                case 1:
                    a(this.ans, this.ant, this.bMd.bMg);
                    a(this.anu, this.ans, this.bMd.bMh);
                    a(this.anv, this.anq, this.bMd.bMi);
                    break;
                case 2:
                    a(this.ans, this.anw, this.bMd.bMg);
                    a(this.anx, this.ans, this.bMd.bMh);
                    a(this.anv, this.anq, this.bMd.bMi);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bMd.bMg);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bMd.bMh);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bMd.bMi);
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
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.zx())));
            dS(textView.getId());
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

    private void dS(int i) {
        if (this.anc.size() != 0) {
            int size = this.anc.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.anc.get(i2).intValue() == i) {
                    this.anc.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.EA.getResources().getString(u.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(av.getColor(u.d.cp_link_tip_a)), 0, string.length(), 17);
        Bitmap cA = av.cA(u.f.pic_dot_title);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        if (cA != null) {
            bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
        }
        spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.ah(bitmapDrawable), string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aSW;
        public TbImageView aSX;
        public ClickableHeaderImageView aTU;
        public LinearLayout aTY;
        public UserIconLayout aUI;
        public View aVa;
        public TextView aVb;
        public TextView aVc;
        public TbImageView aVd;
        public ThreadCommentAndPraiseInfoLayout aVe;
        public TbImageView bHg;
        public ThreadSkinView bHx;
        public RelativeLayout bLT;
        public TextView bMf;
        public TextView bMg;
        public TextView bMh;
        public TextView bMi;
        public GuessYourLikeHeaderView bMj;
        public View bMk;
        public View mRootView;

        public a() {
        }
    }
}

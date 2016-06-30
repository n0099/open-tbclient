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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.aj> {
    private TbPageContext<?> Ea;
    private CustomMessageListener aTw;
    private View.OnClickListener aUb;
    private View.OnClickListener aUc;
    private int amA;
    private int amB;
    private int amC;
    private int amD;
    private int amE;
    private int amF;
    private int amG;
    private int amH;
    private int amI;
    private int amm;
    private ArrayList<Integer> amn;
    private int amy;
    private int amz;
    private com.baidu.tbadk.core.data.aj bKu;
    public a bKv;

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amn = new ArrayList<>();
        this.amm = 0;
        this.aUb = new ae(this);
        this.aUc = new af(this);
        this.aTw = new ag(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.Ea = tbPageContext;
        this.amy = (int) tbPageContext.getResources().getDimension(u.e.ds80);
        this.amz = (int) tbPageContext.getResources().getDimension(u.e.ds280);
        this.amA = (int) tbPageContext.getResources().getDimension(u.e.ds170);
        this.amB = (int) tbPageContext.getResources().getDimension(u.e.ds320);
        this.amC = (int) tbPageContext.getResources().getDimension(u.e.ds200);
        this.amD = (int) tbPageContext.getResources().getDimension(u.e.ds60);
        this.amE = (int) tbPageContext.getResources().getDimension(u.e.ds120);
        this.amF = (int) tbPageContext.getResources().getDimension(u.e.ds160);
        this.amG = (int) tbPageContext.getResources().getDimension(u.e.ds220);
        this.amH = (int) tbPageContext.getResources().getDimension(u.e.ds240);
        this.amI = (int) tbPageContext.getResources().getDimension(u.e.ds180);
        Q(getView());
        nl();
    }

    private void Q(View view) {
        this.bKv = new a();
        this.bKv.mRootView = view.findViewById(u.g.card_root_view);
        this.bKv.aUe = view.findViewById(u.g.top_line);
        this.bKv.aSY = (ClickableHeaderImageView) view.findViewById(u.g.avatar);
        this.bKv.aTM = (UserIconLayout) view.findViewById(u.g.user_icon);
        this.bKv.aUf = (TextView) view.findViewById(u.g.thread_title);
        this.bKv.bKx = (TextView) view.findViewById(u.g.thread_context);
        this.bKv.aUg = (TextView) view.findViewById(u.g.fans_num);
        this.bKv.aUh = (TbImageView) view.findViewById(u.g.thread_image);
        this.bKv.aUi = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.thread_more_info);
        this.bKv.bKy = (TextView) view.findViewById(u.g.first_style_first_expression);
        this.bKv.bKz = (TextView) view.findViewById(u.g.first_style_second_expression);
        this.bKv.bKA = (TextView) view.findViewById(u.g.first_style_third_expression);
        this.bKv.aUi.setCommentNumClickListener(this);
    }

    private void nl() {
        this.bKv.aSY.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.bKv.aSY.setDefaultResource(17170445);
        this.bKv.aSY.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.bKv.aSY.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bKv.aUi.setShowPraiseNum(false);
        this.bKv.aUh.setDrawBorder(true);
        this.bKv.aUh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        this.bKu = ajVar;
        KX();
    }

    private void KX() {
        String string;
        boolean z;
        if (this.bKu == null) {
            this.bKv.mRootView.setVisibility(8);
            return;
        }
        if (this.bKu.getAuthor() != null && this.bKu.getAuthor().getGodUserData() != null && this.bKu.getAuthor().getGodUserData().getType() == 2) {
            this.bKv.aSY.setGodIconMargin(0);
        } else {
            this.bKv.aSY.setIsGod(false);
        }
        this.bKv.aSY.setData(this.bKu);
        this.bKv.aSY.setAfterClickListener(this.aUb);
        this.bKv.aTM.setData(this.bKu);
        this.bKv.aTM.setUserNameTextSizeRid(u.e.fontsize24);
        this.bKv.aTM.setUserAfterClickListener(this.aUb);
        this.bKv.aTM.setPageName(1);
        Resources resources = this.Ea.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.bKu.getTitle()).setSpan(new ForegroundColorSpan(av.getColor(u.d.cp_link_tip_a)), 0, resources.getString(u.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.bKu.getTitle())) {
            int length = this.bKu.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bKu.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bKv.aUf.setSingleLine(true);
        } else {
            this.bKv.aUf.setMaxLines(2);
        }
        this.bKv.aUf.setText(e(this.bKu.getTitle()));
        String fansNickName = this.bKu.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(u.j.fans_default_name);
        }
        this.bKv.aUg.setText(String.valueOf(fansNickName) + ": " + ba.B(this.bKu.getAuthor().getFansNum()));
        this.bKv.aUi.setData(this.bKu);
        this.bKv.aUi.setForumAfterClickListener(this.aUc);
        this.bKv.aUi.setStType(at.Lb());
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.nW().oc() && this.bKu.getPhotoLiveCover() != null && this.bKu.getPhotoLiveCover().length() != 0) {
            this.bKv.aUh.setVisibility(0);
            this.bKv.bKx.setVisibility(8);
            this.bKv.aUh.c(this.bKu.getPhotoLiveCover(), 10, false);
            b(this.bKu);
        } else {
            this.bKv.aUh.setVisibility(8);
            this.bKv.bKy.setVisibility(8);
            this.bKv.bKz.setVisibility(8);
            this.bKv.bKA.setVisibility(8);
            String qO = this.bKu.qO();
            this.bKv.bKx.setText(qO);
            this.bKv.bKx.setVisibility(StringUtils.isNull(qO) ? 8 : 0);
        }
        av.c(this.bKv.aUg, u.d.cp_cont_d, 1);
        if (at.hc(this.bKu.getTid())) {
            av.c(this.bKv.aUf, u.d.cp_cont_d, 1);
            av.c(this.bKv.bKx, u.d.cp_cont_d, 1);
            return;
        }
        av.c(this.bKv.aUf, u.d.cp_cont_b, 1);
        av.c(this.bKv.bKx, u.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKv.mRootView || view == this.bKv.aUi.getCommentNumView()) {
            if (KO() != null) {
                KO().a(this.bKv.mRootView, this.bKu);
            }
            Le();
        }
    }

    private void Le() {
        if (this.bKu != null) {
            at.hb(this.bKu.getTid());
            if (!Lf()) {
                UtilHelper.showToast(this.Ea.getPageActivity(), u.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Ea.getPageActivity(), this.bKu.getTid()).ci("from_frs").bp(18003).ol()));
            hd(this.bKu.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new ah(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bKv.mRootView);
            this.bKv.aTM.se();
            this.bKv.aUi.se();
            av.l(this.bKv.aUe, u.d.cp_bg_line_c);
            av.k(this.bKv.mRootView, u.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Lf() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aTw != null) {
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    private void b(com.baidu.tbadk.core.data.aj ajVar) {
        this.amn.clear();
        zM();
        if (ajVar != null && ajVar.qX() != null) {
            int size = ajVar.qX().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = ajVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, ajVar.qX(), i);
                }
            }
            zL();
        }
    }

    private void zM() {
        this.bKv.bKy.setText("");
        this.bKv.bKz.setText("");
        this.bKv.bKA.setText("");
        if (this.bKv.bKy.getVisibility() == 8) {
            this.bKv.bKy.setVisibility(0);
        }
        if (this.bKv.bKz.getVisibility() == 8) {
            this.bKv.bKz.setVisibility(0);
        }
        if (this.bKv.bKA.getVisibility() == 8) {
            this.bKv.bKA.setVisibility(0);
        }
        this.amn.add(Integer.valueOf(this.bKv.bKy.getId()));
        this.amn.add(Integer.valueOf(this.bKv.bKz.getId()));
        this.amn.add(Integer.valueOf(this.bKv.bKA.getId()));
    }

    private void zL() {
        if (this.amn.size() != 0) {
            int size = this.amn.size();
            for (int i = 0; i < size; i++) {
                if (this.amn.get(i).intValue() == this.bKv.bKy.getId()) {
                    this.bKv.bKy.setVisibility(8);
                } else if (this.amn.get(i).intValue() == this.bKv.bKz.getId()) {
                    this.bKv.bKz.setVisibility(8);
                } else if (this.amn.get(i).intValue() == this.bKv.bKA.getId()) {
                    this.bKv.bKA.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.amm) {
                case 0:
                    a(this.amy, this.amz, this.bKv.bKy);
                    a(this.amA, this.amB, this.bKv.bKz);
                    a(this.amC, this.amD, this.bKv.bKA);
                    break;
                case 1:
                    a(this.amD, this.amE, this.bKv.bKy);
                    a(this.amF, this.amD, this.bKv.bKz);
                    a(this.amG, this.amB, this.bKv.bKA);
                    break;
                case 2:
                    a(this.amD, this.amH, this.bKv.bKy);
                    a(this.amI, this.amD, this.bKv.bKz);
                    a(this.amG, this.amB, this.bKv.bKA);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bKv.bKy);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bKv.bKz);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bKv.bKA);
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
        if (this.amn.size() != 0) {
            int size = this.amn.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.amn.get(i2).intValue() == i) {
                    this.amn.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.Ea.getResources().getString(u.j.recommend_live_title_prefix);
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
        public ClickableHeaderImageView aSY;
        public UserIconLayout aTM;
        public View aUe;
        public TextView aUf;
        public TextView aUg;
        public TbImageView aUh;
        public ThreadCommentAndPraiseInfoLayout aUi;
        public TextView bKA;
        public TextView bKx;
        public TextView bKy;
        public TextView bKz;
        public View mRootView;

        public a() {
        }
    }
}

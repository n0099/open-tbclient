package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected View MA;
    protected TextView Mt;
    protected TextView Mu;
    protected TextView Mv;
    protected TextView Mw;
    protected FrsActivity beB;
    protected br bfX;
    protected int bmM;
    protected TextView bnA;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bnB;
    protected TextView bnC;
    private Drawable bnD;
    protected LinearLayout bnE;
    protected aa bnF;
    protected ad bnG;
    protected U9InfoView bnH;
    protected PopupWindow bnI;
    protected View bnJ;
    protected TextView bnK;
    protected TextView bnL;
    protected ImageView bnM;
    protected PopupWindow bnN;
    protected BarImageView bnO;
    protected UserIconBox bnP;
    protected ArrayList<com.baidu.tbadk.core.data.c> bnQ;
    protected bg bnR;
    protected i bnS;
    protected w bnT;
    protected String bnU;
    protected String bnV;
    protected String bnW;
    protected com.baidu.tieba.tbadkCore.p bnX;
    protected z bnY;
    protected FrameLayout bnl;
    protected Button bnm;
    protected FrameLayout bnn;
    protected Button bno;
    protected TextView bnp;
    protected ProgressBar bnq;
    protected FrameLayout bnr;
    protected TextView bns;
    protected RelativeLayout bnt;
    protected TextView bnu;
    protected ImageView bnv;
    protected ImageView bnw;
    protected View bnx;
    protected LinearLayout bny;
    protected LinearLayout bnz;
    protected int boa;
    protected int bob;
    protected int boc;
    protected int bod;
    protected int boe;
    protected boolean bof;
    protected boolean bog;
    protected boolean boh;
    protected boolean boi;
    protected boolean boj;
    protected boolean bok;
    protected float bol;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bni = 0;
    protected int bnj = 0;
    protected int bnk = 0;
    protected String bnZ = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bom = new b(this);
    protected final View.OnClickListener bon = new c(this);
    protected final View.OnClickListener agX = new d(this);
    protected boolean boo = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean Qh() {
        return this.bof;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, (Animation.AnimationListener) null);
    }

    public void b(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new e(this, tbPageContextSupport, view, f2));
    }

    public boolean Qi() {
        int[] iArr = new int[2];
        try {
            this.bnM.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.MA;
    }

    public View Qj() {
        return this.bnx;
    }

    public BarImageView PV() {
        return this.bnO;
    }

    public TextView Qk() {
        return this.Mv;
    }

    public boolean K(View view) {
        return this.bnS.L(view);
    }

    public void Ql() {
        this.bnS.hide();
    }

    public void Qm() {
        this.bnS.show();
    }

    public boolean PT() {
        return this.boj;
    }

    public void cC(boolean z) {
        this.boi = z;
        if (this.boi) {
            this.bnn.setVisibility(0);
        } else {
            this.bnn.setVisibility(4);
        }
    }

    public View Qn() {
        return this.bnt;
    }

    public boolean PU() {
        return this.bok;
    }

    public ProgressBar Qo() {
        return this.bnq;
    }

    public void onDestory() {
        this.bog = true;
    }

    public void onStop() {
        if (this.bnN != null && this.bnN.isShowing()) {
            this.bnN.dismiss();
        }
        if (this.bnI != null && this.bnI.isShowing()) {
            this.bnI.dismiss();
        }
    }

    public void setIsFirstPage(boolean z) {
        this.boh = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bnU = str;
        this.boa = i2;
        if (i == 0) {
            this.bof = false;
            this.bnl.setVisibility(0);
            this.bnt.setVisibility(8);
            return;
        }
        this.bof = true;
        this.bnl.setVisibility(8);
        if (z) {
            this.bnR.G(this.bnl);
        }
        a(false, f);
        this.bnt.setVisibility(0);
    }

    public void gD(int i) {
        if (i == 0) {
            this.bof = false;
            this.bnl.setVisibility(0);
            this.bnt.setVisibility(8);
            if (this.bfX != null) {
                this.bfX.hide();
                return;
            }
            return;
        }
        this.bof = true;
        this.bnl.setVisibility(8);
        this.bnt.setVisibility(0);
    }

    public void gE(int i) {
        if (i == 0) {
            this.boj = false;
            this.bnr.setVisibility(8);
            this.bnn.setVisibility(0);
            as.i((View) this.bno, n.f.frs_btn_sign);
            return;
        }
        this.boj = true;
        this.bnn.setVisibility(8);
        if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
            this.bnr.setClickable(true);
        } else {
            this.bnr.setClickable(false);
        }
        as.b(this.bns, n.d.cp_link_tip_c, 1);
        if (this.bod > 0) {
            if (com.baidu.adp.lib.util.k.K(this.mContext.getPageActivity()) >= 480) {
                this.bns.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.bns.setText(String.format(this.mContext.getString(n.j.miss_sign_days), Integer.valueOf(this.bod)));
        } else {
            this.bns.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
            if (this.boc <= 0) {
                this.bns.setText(this.mContext.getString(n.j.signed));
            } else {
                this.bns.setText(String.format(this.mContext.getString(n.j.continuous_sign_days), Integer.valueOf(this.boc)));
            }
        }
        this.bnr.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void Qp() {
        if (this.mMemberType != 0) {
            as.c(this.bnM, n.f.icon_speed_orange);
        } else {
            as.c(this.bnM, n.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.boe));
        if (this.bmM >= 10000) {
            if (this.bmM % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(n.j.experience_divider)) + String.valueOf(this.bmM / 10000) + this.mContext.getString(n.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(n.j.experience_divider)) + String.valueOf(this.bmM / 10000.0f) + this.mContext.getString(n.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(n.j.experience_divider)) + String.valueOf(this.bmM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.mContext.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(List<com.baidu.tieba.tbadkCore.h> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.h> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.h next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void a(boolean z, float f) {
    }

    public void a(com.baidu.tbadk.core.data.h hVar) {
        if (this.bnB == null || hVar == null || hVar.rs() == null || hVar.rs().size() <= 0) {
            if (this.bnB != null) {
                this.bnB.setVisibility(8);
                return;
            }
            return;
        }
        this.bnD = as.getDrawable(n.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.e.ds10);
        this.bnB.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> rs = hVar.rs();
        List<com.baidu.tbadk.core.data.i> subList = rs.size() > 5 ? rs.subList(0, 5) : rs;
        if (subList.size() > 1) {
            this.bnB.setDisableParentEvent(true);
        } else {
            this.bnB.setDisableParentEvent(false);
        }
        this.bnB.setData(subList);
        if (this.bnC != null) {
            if (subList.size() > 2) {
                this.bnC.setPadding(this.bni, 0, this.bnk, 0);
            } else {
                this.bnC.setPadding(this.bni, 0, this.bnj, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rv()) {
                    this.bnC.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bnC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bnC.setText("");
                } else {
                    this.bnC.setCompoundDrawablePadding(this.drawablePadding);
                    this.bnC.setCompoundDrawablesWithIntrinsicBounds(this.bnD, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bnC.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.beB != null) {
                    str = this.beB.getForumId();
                }
                TiebaStatic.log(new av("c10132").aa(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void Qq() {
        if (this.bnB != null) {
            this.bnB.setCoverFlowFactory(new g(this));
            this.bnB.setCallback(new h(this));
        }
    }

    public boolean hw(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

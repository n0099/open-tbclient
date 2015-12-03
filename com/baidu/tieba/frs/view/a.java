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
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected TextView Md;
    protected TextView Me;
    protected TextView Mf;
    protected TextView Mg;
    protected View Mk;
    protected FrsActivity baC;
    protected bo bbY;
    protected int biV;
    protected FrameLayout bjA;
    protected TextView bjB;
    protected RelativeLayout bjC;
    protected TextView bjD;
    protected ImageView bjE;
    protected ImageView bjF;
    protected View bjG;
    protected LinearLayout bjH;
    protected LinearLayout bjI;
    protected TextView bjJ;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bjK;
    protected TextView bjL;
    private Drawable bjM;
    protected LinearLayout bjN;
    protected aa bjO;
    protected ad bjP;
    protected U9InfoView bjQ;
    protected PopupWindow bjR;
    protected View bjS;
    protected TextView bjT;
    protected TextView bjU;
    protected ImageView bjV;
    protected PopupWindow bjW;
    protected BarImageView bjX;
    protected UserIconBox bjY;
    protected ArrayList<com.baidu.tbadk.core.data.c> bjZ;
    protected FrameLayout bju;
    protected Button bjv;
    protected FrameLayout bjw;
    protected Button bjx;
    protected TextView bjy;
    protected ProgressBar bjz;
    protected bd bka;
    protected i bkb;
    protected w bkc;
    protected String bkd;
    protected String bke;
    protected String bkf;
    protected com.baidu.tieba.tbadkCore.p bkg;
    protected z bkh;
    protected int bkj;
    protected int bkk;
    protected int bkl;
    protected int bkm;
    protected boolean bkn;
    protected boolean bko;
    protected boolean bkp;
    protected boolean bkq;
    protected boolean bkr;
    protected boolean bks;
    protected float bkt;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bjr = 0;
    protected int bjs = 0;
    protected int bjt = 0;
    protected String bki = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bku = new b(this);
    protected final View.OnClickListener bkv = new c(this);
    protected final View.OnClickListener bkw = new d(this);
    protected boolean bkx = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean PP() {
        return this.bkn;
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

    public boolean PQ() {
        int[] iArr = new int[2];
        try {
            this.bjV.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.Mk;
    }

    public View PR() {
        return this.bjG;
    }

    public BarImageView PD() {
        return this.bjX;
    }

    public TextView PS() {
        return this.Mf;
    }

    public boolean J(View view) {
        return this.bkb.K(view);
    }

    public void PT() {
        this.bkb.hide();
    }

    public void PU() {
        this.bkb.show();
    }

    public boolean PB() {
        return this.bkr;
    }

    public void cB(boolean z) {
        this.bkq = z;
        if (this.bkq) {
            this.bjw.setVisibility(0);
        } else {
            this.bjw.setVisibility(4);
        }
    }

    public View PV() {
        return this.bjC;
    }

    public boolean PC() {
        return this.bks;
    }

    public ProgressBar PW() {
        return this.bjz;
    }

    public void onDestory() {
        this.bko = true;
    }

    public void onStop() {
        if (this.bjW != null && this.bjW.isShowing()) {
            this.bjW.dismiss();
        }
        if (this.bjR != null && this.bjR.isShowing()) {
            this.bjR.dismiss();
        }
    }

    public void setIsFirstPage(boolean z) {
        this.bkp = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bkd = str;
        this.bkj = i2;
        if (i == 0) {
            this.bkn = false;
            this.bju.setVisibility(0);
            this.bjC.setVisibility(8);
            return;
        }
        this.bkn = true;
        this.bju.setVisibility(8);
        if (z) {
            this.bka.F(this.bju);
        }
        a(false, f);
        this.bjC.setVisibility(0);
    }

    public void gK(int i) {
        if (i == 0) {
            this.bkn = false;
            this.bju.setVisibility(0);
            this.bjC.setVisibility(8);
            if (this.bbY != null) {
                this.bbY.hide();
                return;
            }
            return;
        }
        this.bkn = true;
        this.bju.setVisibility(8);
        this.bjC.setVisibility(0);
    }

    public void gL(int i) {
        if (i == 0) {
            this.bkr = false;
            this.bjA.setVisibility(8);
            this.bjw.setVisibility(0);
            as.i((View) this.bjx, n.e.frs_btn_sign);
            return;
        }
        this.bkr = true;
        this.bjw.setVisibility(8);
        this.bjB.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bkl <= 1) {
            this.bjB.setText(this.mContext.getString(n.i.signed));
        } else {
            this.bjB.setText(String.valueOf(this.mContext.getString(n.i.signed_less)) + String.valueOf(this.bkl) + this.mContext.getString(n.i.day));
        }
        this.bjA.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void PX() {
        if (this.mMemberType != 0) {
            as.c(this.bjV, n.e.icon_speed_orange);
        } else {
            as.c(this.bjV, n.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bkm));
        if (this.biV >= 10000) {
            if (this.biV % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(n.i.experience_divider)) + String.valueOf(this.biV / 10000) + this.mContext.getString(n.i.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(n.i.experience_divider)) + String.valueOf(this.biV / 10000.0f) + this.mContext.getString(n.i.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(n.i.experience_divider)) + String.valueOf(this.biV));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.mContext.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
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
        if (this.bjK == null || hVar == null || hVar.rJ() == null || hVar.rJ().size() <= 0) {
            if (this.bjK != null) {
                this.bjK.setVisibility(8);
                return;
            }
            return;
        }
        this.bjM = as.getDrawable(n.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.d.ds10);
        this.bjK.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> rJ = hVar.rJ();
        List<com.baidu.tbadk.core.data.i> subList = rJ.size() > 5 ? rJ.subList(0, 5) : rJ;
        if (subList.size() > 1) {
            this.bjK.setDisableParentEvent(true);
        } else {
            this.bjK.setDisableParentEvent(false);
        }
        this.bjK.setData(subList);
        if (this.bjL != null) {
            if (subList.size() > 2) {
                this.bjL.setPadding(this.bjr, 0, this.bjt, 0);
            } else {
                this.bjL.setPadding(this.bjr, 0, this.bjs, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rM()) {
                    this.bjL.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bjL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bjL.setText("");
                } else {
                    this.bjL.setCompoundDrawablePadding(this.drawablePadding);
                    this.bjL.setCompoundDrawablesWithIntrinsicBounds(this.bjM, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bjL.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.baC != null) {
                    str = this.baC.getForumId();
                }
                TiebaStatic.log(new av("c10132").ab(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void PY() {
        if (this.bjK != null) {
            this.bjK.setCoverFlowFactory(new g(this));
            this.bjK.setCallback(new h(this));
        }
    }

    public boolean hl(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

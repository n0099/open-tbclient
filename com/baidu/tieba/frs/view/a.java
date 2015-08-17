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
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected TextView LK;
    protected TextView LL;
    protected TextView LM;
    protected TextView LN;
    protected View LR;
    protected TbPageContext<FrsActivity> LS;
    protected FrsActivity aVx;
    protected FrameLayout bbM;
    protected Button bbN;
    protected FrameLayout bbO;
    protected Button bbP;
    protected TextView bbQ;
    protected ProgressBar bbR;
    protected FrameLayout bbS;
    protected TextView bbT;
    protected RelativeLayout bbU;
    protected TextView bbV;
    protected ImageView bbW;
    protected ImageView bbX;
    protected View bbY;
    protected LinearLayout bbZ;
    protected int bbn;
    protected int bcA;
    protected int bcB;
    protected int bcC;
    protected boolean bcD;
    protected boolean bcE;
    protected boolean bcF;
    protected boolean bcG;
    protected boolean bcH;
    protected boolean bcI;
    protected float bcJ;
    protected TextView bca;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bcb;
    protected TextView bcc;
    private Drawable bcd;
    protected LinearLayout bce;
    protected w bcf;
    protected z bcg;
    protected U9InfoView bch;
    protected PopupWindow bci;
    protected View bcj;
    protected TextView bck;
    protected TextView bcl;
    protected ImageView bcm;
    protected BarImageView bcn;
    protected UserIconBox bco;
    protected ArrayList<com.baidu.tbadk.core.data.d> bcp;
    protected av bcq;
    protected i bcr;
    protected v bcs;
    protected String bct;
    protected String bcu;
    protected String bcv;
    protected com.baidu.tieba.tbadkCore.n bcw;
    protected com.baidu.tbadk.core.data.v bcx;
    protected int bcz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bbJ = 0;
    protected int bbK = 0;
    protected int bbL = 0;
    protected String bcy = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bcK = new b(this);
    protected final View.OnClickListener bcL = new c(this);
    protected final View.OnClickListener bcM = new d(this);
    protected boolean bcN = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean NQ() {
        return this.bcD;
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

    public boolean NR() {
        int[] iArr = new int[2];
        try {
            this.bcm.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LR;
    }

    public View NS() {
        return this.bbY;
    }

    public BarImageView NE() {
        return this.bcn;
    }

    public TextView NT() {
        return this.LM;
    }

    public boolean E(View view) {
        return this.bcr.F(view);
    }

    public void NU() {
        this.bcr.hide();
    }

    public void NV() {
        this.bcr.show();
    }

    public boolean NC() {
        return this.bcH;
    }

    public void ck(boolean z) {
        this.bcG = z;
        if (this.bcG) {
            this.bbO.setVisibility(0);
        } else {
            this.bbO.setVisibility(4);
        }
    }

    public View NW() {
        return this.bbU;
    }

    public boolean ND() {
        return this.bcI;
    }

    public ProgressBar NX() {
        return this.bbR;
    }

    public void onDestory() {
        this.bcE = true;
    }

    public void setIsFirstPage(boolean z) {
        this.bcF = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bct = str;
        this.bcz = i2;
        if (i == 0) {
            this.bcD = false;
            this.bbM.setVisibility(0);
            this.bbU.setVisibility(8);
            return;
        }
        this.bcD = true;
        this.bbM.setVisibility(8);
        if (z) {
            this.bcq.z(this.bbM);
        }
        a(false, f);
        this.bbU.setVisibility(0);
    }

    public void fN(int i) {
        if (i == 0) {
            this.bcD = false;
            this.bbM.setVisibility(0);
            this.bbU.setVisibility(8);
            return;
        }
        this.bcD = true;
        this.bbM.setVisibility(8);
        this.bbU.setVisibility(0);
    }

    public void fO(int i) {
        if (i == 0) {
            this.bcH = false;
            this.bbS.setVisibility(8);
            this.bbO.setVisibility(0);
            al.i((View) this.bbP, i.e.frs_btn_sign);
            return;
        }
        this.bcH = true;
        this.bbO.setVisibility(8);
        this.bbT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bcB <= 1) {
            this.bbT.setText(this.LS.getString(i.C0057i.signed));
        } else {
            this.bbT.setText(String.valueOf(this.LS.getString(i.C0057i.signed_less)) + String.valueOf(this.bcB) + this.LS.getString(i.C0057i.day));
        }
        this.bbS.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void NY() {
        if (this.mMemberType != 0) {
            al.c(this.bcm, i.e.icon_speed_orange);
        } else {
            al.c(this.bcm, i.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bcC));
        if (this.bbn >= 10000) {
            if (this.bbn % 10000 == 0) {
                textView2.setText(String.valueOf(this.LS.getString(i.C0057i.experience_divider)) + String.valueOf(this.bbn / 10000) + this.LS.getString(i.C0057i.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.LS.getString(i.C0057i.experience_divider)) + String.valueOf(this.bbn / 10000.0f) + this.LS.getString(i.C0057i.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.LS.getString(i.C0057i.experience_divider)) + String.valueOf(this.bbn));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.LS.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LS.getLayoutMode().k(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(List<com.baidu.tieba.tbadkCore.g> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.g> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.g next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void a(boolean z, float f) {
    }

    public void a(com.baidu.tbadk.core.data.h hVar) {
        if (this.bcb == null || hVar == null || hVar.rD() == null || hVar.rD().size() <= 0) {
            if (this.bcb != null) {
                this.bcb.setVisibility(8);
                return;
            }
            return;
        }
        this.bcd = al.getDrawable(i.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.LS.getPageActivity(), i.d.ds10);
        this.bcb.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> rD = hVar.rD();
        List<com.baidu.tbadk.core.data.i> subList = rD.size() > 5 ? rD.subList(0, 5) : rD;
        if (subList.size() > 1) {
            this.bcb.setDisableParentEvent(true);
        } else {
            this.bcb.setDisableParentEvent(false);
        }
        this.bcb.setData(subList);
        if (this.bcc != null) {
            if (subList.size() > 2) {
                this.bcc.setPadding(this.bbJ, 0, this.bbL, 0);
            } else {
                this.bcc.setPadding(this.bbJ, 0, this.bbK, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rG()) {
                    this.bcc.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bcc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcc.setText("");
                } else {
                    this.bcc.setCompoundDrawablePadding(this.drawablePadding);
                    this.bcc.setCompoundDrawablesWithIntrinsicBounds(this.bcd, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcc.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.aVx != null) {
                    str = this.aVx.getForumId();
                }
                TiebaStatic.log(new ao("c10132").af(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void NZ() {
        if (this.bcb != null) {
            this.bcb.setCoverFlowFactory(new g(this));
            this.bcb.setCallback(new h(this));
        }
    }

    public boolean gG(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lT().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

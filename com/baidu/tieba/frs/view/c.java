package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> bvW = new HashMap<>();
    private static HashSet<Integer> bvX = new HashSet<>();
    protected TextView Dg;
    protected TextView Dh;
    protected TextView Di;
    protected TextView Dj;
    protected View Dn;
    protected TbPageContext<FrsActivity> Do;
    private String NS;
    protected by biT;
    protected FrsActivity bjB;
    protected com.baidu.tieba.tbadkCore.o bpp;
    protected FrameLayout buS;
    protected Button buT;
    protected FrameLayout buU;
    protected Button buV;
    protected TextView buW;
    protected ProgressBar buX;
    protected FrameLayout buY;
    protected TextView buZ;
    protected int bur;
    protected bj bvA;
    protected l bvB;
    protected w bvC;
    protected ForumMemberIconView bvD;
    protected com.baidu.tbadk.core.data.o bvE;
    protected String bvF;
    protected String bvG;
    protected String bvH;
    protected ax bvI;
    protected int bvK;
    protected int bvL;
    protected int bvM;
    protected int bvN;
    protected int bvO;
    protected boolean bvP;
    protected boolean bvQ;
    protected boolean bvR;
    protected boolean bvS;
    protected boolean bvT;
    protected boolean bvU;
    protected float bvV;
    private int bvY;
    protected RelativeLayout bva;
    protected TextView bvb;
    protected ImageView bvc;
    protected ImageView bvd;
    protected View bve;
    protected RelativeLayout bvf;
    protected TextView bvg;
    protected LinearLayout bvh;
    protected ViewGroup bvi;
    protected TextView bvj;
    protected CoverFlowView<com.baidu.tbadk.core.data.n> bvk;
    protected TextView bvl;
    private Drawable bvm;
    protected ForumHeadSdkView bvn;
    protected LinearLayout bvo;
    protected az bvp;
    protected bc bvq;
    protected PopupWindow bvr;
    protected View bvs;
    protected TextView bvt;
    protected TextView bvu;
    protected ImageView bvv;
    protected PopupWindow bvw;
    protected BarImageView bvx;
    protected UserIconBox bvy;
    protected ArrayList<com.baidu.tbadk.core.data.g> bvz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int buP = 0;
    protected int buQ = 0;
    protected int buR = 0;
    protected String bvJ = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected HashSet<String> bvZ = new HashSet<>();
    protected final Runnable bwa = new d(this);
    protected final View.OnClickListener bwb = new e(this);
    protected final View.OnClickListener adN = new f(this);
    protected final View.OnClickListener bwc = new g(this);
    protected boolean bwd = TbadkCoreApplication.m11getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void Ss();

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar);

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        bvW.put(1, "c0117");
        bvW.put(2, "c0124");
        bvW.put(3, "c0125");
        bvW.put(4, "c0126");
        bvW.put(5, "c0127");
    }

    public boolean Ub() {
        return this.bvP;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new h(this, tbPageContextSupport, view, f2));
    }

    public boolean Uc() {
        int[] iArr = new int[2];
        try {
            this.bvv.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.Dn;
    }

    public View Ud() {
        return this.bve;
    }

    public BarImageView TU() {
        return this.bvx;
    }

    public TextView Ue() {
        return this.Di;
    }

    public boolean ag(View view) {
        return this.bvB.ah(view);
    }

    public void Uf() {
        this.bvB.hide();
    }

    public void Ug() {
        this.bvB.show();
    }

    public boolean TS() {
        return this.bvT;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(boolean z) {
        this.bvS = z;
        if (this.bvS) {
            this.buU.setVisibility(0);
        } else {
            this.buU.setVisibility(4);
        }
    }

    public View Uh() {
        return this.bva;
    }

    public boolean TT() {
        return this.bvU;
    }

    public ProgressBar Ui() {
        return this.buX;
    }

    public void onDestory() {
        this.bvQ = true;
        bvX.clear();
    }

    public void onStop() {
        if (this.bvw != null && this.bvw.isShowing()) {
            this.bvw.dismiss();
        }
        if (this.bvr != null && this.bvr.isShowing()) {
            this.bvr.dismiss();
        }
    }

    public void dp(boolean z) {
        this.bvR = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bvF = str;
        this.bvK = i2;
        if (i == 0) {
            this.bvP = false;
            this.buS.setVisibility(0);
            this.bva.setVisibility(8);
            return;
        }
        this.bvP = true;
        this.buS.setVisibility(8);
        if (z) {
            St();
        }
        a(false, f);
        this.bva.setVisibility(0);
    }

    protected void St() {
    }

    public void gW(int i) {
        if (i == 0) {
            this.bvP = false;
            this.buS.setVisibility(0);
            this.bva.setVisibility(8);
            if (this.biT != null) {
                this.biT.hide();
                return;
            }
            return;
        }
        this.bvP = true;
        this.buS.setVisibility(8);
        this.bva.setVisibility(0);
    }

    public void gX(int i) {
        if (i == 0) {
            this.bvT = false;
            this.buY.setVisibility(8);
            this.buU.setVisibility(0);
            Sm();
            return;
        }
        this.bvT = true;
        this.buU.setVisibility(8);
        if (TbadkCoreApplication.m11getInst().getUseNewResign() == 1) {
            this.buY.setClickable(true);
        } else {
            this.buY.setClickable(false);
        }
        Sl();
    }

    protected void Sm() {
        at.k(this.buV, t.f.frs_btn_sign);
    }

    protected void Sl() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void Su() {
        if (this.mMemberType != 0) {
            at.c(this.bvv, t.f.icon_speed_orange);
        } else {
            at.c(this.bvv, t.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bvO));
        if (this.bur >= 10000) {
            if (this.bur % 10000 == 0) {
                textView2.setText(String.valueOf(this.Do.getString(t.j.experience_divider)) + String.valueOf(this.bur / 10000) + this.Do.getString(t.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Do.getString(t.j.experience_divider)) + String.valueOf(this.bur / 10000.0f) + this.Do.getString(t.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Do.getString(t.j.experience_divider)) + String.valueOf(this.bur));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.Do.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.Do.getLayoutMode().x(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (this.bvk == null || mVar == null || mVar.oS() == null || mVar.oS().size() <= 0) {
            if (this.bvk != null) {
                this.bvk.setVisibility(8);
                return;
            }
            return;
        }
        this.NS = mVar.oT();
        this.bvm = at.getDrawable(t.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds10);
        this.bvk.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.n> oS = mVar.oS();
        List<com.baidu.tbadk.core.data.n> subList = oS.size() > 5 ? oS.subList(0, 5) : oS;
        this.bvY = subList.size();
        if (subList.size() > 1) {
            this.bvk.setDisableParentEvent(true);
        } else {
            this.bvk.setDisableParentEvent(false);
        }
        this.bvk.setData(subList);
        if (this.bvl != null) {
            if (subList.size() > 2) {
                this.bvl.setPadding(this.buP, 0, this.buR, 0);
            } else {
                this.bvl.setPadding(this.buP, 0, this.buQ, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).oW()) {
                    this.bvl.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bvl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bvl.setText("");
                } else {
                    this.bvl.setCompoundDrawablePadding(this.drawablePadding);
                    this.bvl.setCompoundDrawablesWithIntrinsicBounds(this.bvm, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bvl.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bjB != null) {
                    str = this.bjB.getForumId();
                    str2 = this.bjB.getForumName();
                }
                if (bvX.add(1)) {
                    a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bvW.get(1), "ad_plat", "VIEW_TRUE", this.NS, str, str2, null);
                    a.bK("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            this.bvn.setData(qVar);
            this.bvn.setClickListener(this.bwc);
            this.bvn.show();
            this.bvn.setVisibility(0);
            if (this.bvk != null) {
                this.bvk.setVisibility(8);
            }
        }
    }

    public void Uj() {
        if (this.bvk != null) {
            this.bvk.setCoverFlowFactory(new j(this));
            this.bvk.setCallback(new k(this));
        }
    }

    public boolean hP(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.hF().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }

    public void Sf() {
    }
}

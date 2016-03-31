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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bk;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.U9InfoView;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static HashMap<Integer, String> bwj = new HashMap<>();
    private static HashSet<Integer> bwk = new HashSet<>();
    protected TextView MP;
    protected TextView MQ;
    protected TextView MR;
    protected TextView MS;
    protected View MW;
    protected TbPageContext<FrsActivity> MX;
    protected FrsActivity blH;
    protected bz bnq;
    protected int buC;
    protected at bvA;
    protected aw bvB;
    protected U9InfoView bvC;
    protected PopupWindow bvD;
    protected View bvE;
    protected TextView bvF;
    protected TextView bvG;
    protected ImageView bvH;
    protected PopupWindow bvI;
    protected BarImageView bvJ;
    protected UserIconBox bvK;
    protected ArrayList<com.baidu.tbadk.core.data.g> bvL;
    protected bk bvM;
    protected k bvN;
    protected ab bvO;
    protected ForumMemberIconView bvP;
    protected com.baidu.tbadk.core.data.o bvQ;
    protected String bvR;
    protected String bvS;
    protected String bvT;
    protected com.baidu.tieba.tbadkCore.o bvU;
    protected as bvV;
    protected int bvX;
    protected int bvY;
    protected int bvZ;
    protected FrameLayout bvd;
    protected Button bve;
    protected FrameLayout bvf;
    protected Button bvg;
    protected TextView bvh;
    protected ProgressBar bvi;
    protected FrameLayout bvj;
    protected TextView bvk;
    protected RelativeLayout bvl;
    protected TextView bvm;
    protected ImageView bvn;
    protected ImageView bvo;
    protected View bvp;
    protected RelativeLayout bvq;
    protected TextView bvr;
    protected LinearLayout bvs;
    protected LinearLayout bvt;
    protected TextView bvu;
    protected CoverFlowView<com.baidu.tbadk.core.data.n> bvv;
    protected TextView bvw;
    private Drawable bvx;
    protected ForumHeadSdkView bvy;
    protected LinearLayout bvz;
    protected int bwa;
    protected int bwb;
    protected boolean bwc;
    protected boolean bwd;
    protected boolean bwe;
    protected boolean bwf;
    protected boolean bwg;
    protected boolean bwh;
    protected float bwi;
    private int bwl;
    private String bwm;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bva = 0;
    protected int bvb = 0;
    protected int bvc = 0;
    protected String bvW = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bwn = new c(this);
    protected final View.OnClickListener bwo = new d(this);
    protected final View.OnClickListener ahR = new e(this);
    protected final View.OnClickListener bwp = new f(this);
    protected boolean bwq = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    static {
        bwj.put(1, "c0117");
        bwj.put(2, "c0124");
        bwj.put(3, "c0125");
        bwj.put(4, "c0126");
        bwj.put(5, "c0127");
    }

    public boolean Ua() {
        return this.bwc;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new g(this, tbPageContextSupport, view, f2));
    }

    public boolean Ub() {
        int[] iArr = new int[2];
        try {
            this.bvH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.MW;
    }

    public View Uc() {
        return this.bvp;
    }

    public BarImageView TN() {
        return this.bvJ;
    }

    public TextView Ud() {
        return this.MR;
    }

    public boolean ac(View view) {
        return this.bvN.ad(view);
    }

    public void Ue() {
        this.bvN.hide();
    }

    public void Uf() {
        this.bvN.show();
    }

    public boolean TL() {
        return this.bwg;
    }

    public void cO(boolean z) {
        this.bwf = z;
        if (this.bwf) {
            this.bvf.setVisibility(0);
        } else {
            this.bvf.setVisibility(4);
        }
    }

    public View Ug() {
        return this.bvl;
    }

    public boolean TM() {
        return this.bwh;
    }

    public ProgressBar Uh() {
        return this.bvi;
    }

    public void onDestory() {
        this.bwd = true;
        bwk.clear();
    }

    public void onStop() {
        if (this.bvI != null && this.bvI.isShowing()) {
            this.bvI.dismiss();
        }
        if (this.bvD != null && this.bvD.isShowing()) {
            this.bvD.dismiss();
        }
    }

    public void cP(boolean z) {
        this.bwe = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bvR = str;
        this.bvX = i2;
        if (i == 0) {
            this.bwc = false;
            this.bvd.setVisibility(0);
            this.bvl.setVisibility(8);
            return;
        }
        this.bwc = true;
        this.bvd.setVisibility(8);
        if (z) {
            this.bvM.Y(this.bvd);
        }
        a(false, f);
        this.bvl.setVisibility(0);
    }

    public void ht(int i) {
        if (i == 0) {
            this.bwc = false;
            this.bvd.setVisibility(0);
            this.bvl.setVisibility(8);
            if (this.bnq != null) {
                this.bnq.hide();
                return;
            }
            return;
        }
        this.bwc = true;
        this.bvd.setVisibility(8);
        this.bvl.setVisibility(0);
    }

    public void hu(int i) {
        if (i == 0) {
            this.bwg = false;
            this.bvj.setVisibility(8);
            this.bvf.setVisibility(0);
            com.baidu.tbadk.core.util.at.k(this.bvg, t.f.frs_btn_sign);
            return;
        }
        this.bwg = true;
        this.bvf.setVisibility(8);
        if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
            this.bvj.setClickable(true);
        } else {
            this.bvj.setClickable(false);
        }
        com.baidu.tbadk.core.util.at.b(this.bvk, t.d.cp_link_tip_c, 1);
        if (this.bwa > 0) {
            if (com.baidu.adp.lib.util.k.B(this.MX.getPageActivity()) >= 480) {
                this.bvk.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.bvk.setText(String.format(this.MX.getString(t.j.miss_sign_days), Integer.valueOf(this.bwa)));
        } else {
            this.bvk.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
            if (this.bvZ <= 0) {
                this.bvk.setText(this.MX.getString(t.j.signed));
            } else {
                this.bvk.setText(String.format(this.MX.getString(t.j.continuous_sign_days), Integer.valueOf(this.bvZ)));
            }
        }
        this.bvj.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void Ui() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.at.c(this.bvH, t.f.icon_speed_orange);
        } else {
            com.baidu.tbadk.core.util.at.c(this.bvH, t.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bwb));
        if (this.buC >= 10000) {
            if (this.buC % 10000 == 0) {
                textView2.setText(String.valueOf(this.MX.getString(t.j.experience_divider)) + String.valueOf(this.buC / 10000) + this.MX.getString(t.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.MX.getString(t.j.experience_divider)) + String.valueOf(this.buC / 10000.0f) + this.MX.getString(t.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.MX.getString(t.j.experience_divider)) + String.valueOf(this.buC));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.MX.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MX.getLayoutMode().x(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(List<com.baidu.tieba.tbadkCore.g> list) {
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
        if (this.bvv == null || mVar == null || mVar.ry() == null || mVar.ry().size() <= 0) {
            if (this.bvv != null) {
                this.bvv.setVisibility(8);
                return;
            }
            return;
        }
        this.bwm = mVar.rz();
        this.bvx = com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds10);
        this.bvv.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.n> ry = mVar.ry();
        List<com.baidu.tbadk.core.data.n> subList = ry.size() > 5 ? ry.subList(0, 5) : ry;
        this.bwl = subList.size();
        if (subList.size() > 1) {
            this.bvv.setDisableParentEvent(true);
        } else {
            this.bvv.setDisableParentEvent(false);
        }
        this.bvv.setData(subList);
        if (this.bvw != null) {
            if (subList.size() > 2) {
                this.bvw.setPadding(this.bva, 0, this.bvc, 0);
            } else {
                this.bvw.setPadding(this.bva, 0, this.bvb, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rC()) {
                    this.bvw.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bvw.setText("");
                } else {
                    this.bvw.setCompoundDrawablePadding(this.drawablePadding);
                    this.bvw.setCompoundDrawablesWithIntrinsicBounds(this.bvx, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bvw.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.blH != null) {
                    str = this.blH.getForumId();
                    str2 = this.blH.getForumName();
                }
                if (bwk.add(1)) {
                    a.C0083a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bwj.get(1), "ad_plat", "VIEW_TRUE", this.bwm, str, str2, null);
                    a.bF("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            this.bvy.setData(qVar);
            this.bvy.setClickListener(this.bwp);
            this.bvy.show();
        }
    }

    public void Uj() {
        if (this.bvv != null) {
            this.bvv.setCoverFlowFactory(new i(this));
            this.bvv.setCallback(new j(this));
        }
    }

    public boolean hM(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected TextView LM;
    protected TextView LN;
    protected TextView LO;
    protected TextView LP;
    protected View LT;
    protected FrsActivity aVn;
    protected FrameLayout bcQ;
    protected Button bcR;
    protected FrameLayout bcS;
    protected Button bcT;
    protected TextView bcU;
    protected ProgressBar bcV;
    protected FrameLayout bcW;
    protected TextView bcX;
    protected RelativeLayout bcY;
    protected TextView bcZ;
    protected int bcq;
    protected com.baidu.tieba.tbadkCore.o bdA;
    protected com.baidu.tbadk.core.data.w bdB;
    protected int bdD;
    protected int bdE;
    protected int bdF;
    protected int bdG;
    protected boolean bdH;
    protected boolean bdI;
    protected boolean bdJ;
    protected boolean bdK;
    protected boolean bdL;
    protected boolean bdM;
    protected float bdN;
    protected ImageView bda;
    protected ImageView bdb;
    protected View bdc;
    protected LinearLayout bdd;
    protected TextView bde;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bdf;
    protected TextView bdg;
    private Drawable bdh;
    protected LinearLayout bdi;
    protected x bdj;
    protected aa bdk;
    protected U9InfoView bdl;
    protected PopupWindow bdm;
    protected View bdn;
    protected TextView bdo;
    protected TextView bdp;
    protected ImageView bdq;
    protected BarImageView bdr;
    protected UserIconBox bds;
    protected ArrayList<com.baidu.tbadk.core.data.c> bdt;
    protected be bdu;
    protected i bdv;
    protected w bdw;
    protected String bdx;
    protected String bdy;
    protected String bdz;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bcN = 0;
    protected int bcO = 0;
    protected int bcP = 0;
    protected String bdC = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bdO = new b(this);
    protected final View.OnClickListener bdP = new c(this);
    protected final View.OnClickListener bdQ = new d(this);
    protected boolean bdR = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean Oj() {
        return this.bdH;
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

    public boolean Ok() {
        int[] iArr = new int[2];
        try {
            this.bdq.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LT;
    }

    public View Ol() {
        return this.bdc;
    }

    public BarImageView NX() {
        return this.bdr;
    }

    public TextView Om() {
        return this.LO;
    }

    public boolean F(View view) {
        return this.bdv.G(view);
    }

    public void On() {
        this.bdv.hide();
    }

    public void Oo() {
        this.bdv.show();
    }

    public boolean NV() {
        return this.bdL;
    }

    public void co(boolean z) {
        this.bdK = z;
        if (this.bdK) {
            this.bcS.setVisibility(0);
        } else {
            this.bcS.setVisibility(4);
        }
    }

    public View Op() {
        return this.bcY;
    }

    public boolean NW() {
        return this.bdM;
    }

    public ProgressBar Oq() {
        return this.bcV;
    }

    public void onDestory() {
        this.bdI = true;
    }

    public void setIsFirstPage(boolean z) {
        this.bdJ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bdx = str;
        this.bdD = i2;
        if (i == 0) {
            this.bdH = false;
            this.bcQ.setVisibility(0);
            this.bcY.setVisibility(8);
            return;
        }
        this.bdH = true;
        this.bcQ.setVisibility(8);
        if (z) {
            this.bdu.A(this.bcQ);
        }
        a(false, f);
        this.bcY.setVisibility(0);
    }

    public void go(int i) {
        if (i == 0) {
            this.bdH = false;
            this.bcQ.setVisibility(0);
            this.bcY.setVisibility(8);
            return;
        }
        this.bdH = true;
        this.bcQ.setVisibility(8);
        this.bcY.setVisibility(0);
    }

    public void gp(int i) {
        if (i == 0) {
            this.bdL = false;
            this.bcW.setVisibility(8);
            this.bcS.setVisibility(0);
            an.i((View) this.bcT, i.e.frs_btn_sign);
            return;
        }
        this.bdL = true;
        this.bcS.setVisibility(8);
        this.bcX.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bdF <= 1) {
            this.bcX.setText(this.mContext.getString(i.h.signed));
        } else {
            this.bcX.setText(String.valueOf(this.mContext.getString(i.h.signed_less)) + String.valueOf(this.bdF) + this.mContext.getString(i.h.day));
        }
        this.bcW.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void Or() {
        if (this.mMemberType != 0) {
            an.c(this.bdq, i.e.icon_speed_orange);
        } else {
            an.c(this.bdq, i.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bdG));
        if (this.bcq >= 10000) {
            if (this.bcq % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bcq / 10000) + this.mContext.getString(i.h.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bcq / 10000.0f) + this.mContext.getString(i.h.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bcq));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(List<com.baidu.tieba.tbadkCore.h> list) {
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
        if (this.bdf == null || hVar == null || hVar.rv() == null || hVar.rv().size() <= 0) {
            if (this.bdf != null) {
                this.bdf.setVisibility(8);
                return;
            }
            return;
        }
        this.bdh = an.getDrawable(i.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds10);
        this.bdf.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> rv = hVar.rv();
        List<com.baidu.tbadk.core.data.i> subList = rv.size() > 5 ? rv.subList(0, 5) : rv;
        if (subList.size() > 1) {
            this.bdf.setDisableParentEvent(true);
        } else {
            this.bdf.setDisableParentEvent(false);
        }
        this.bdf.setData(subList);
        if (this.bdg != null) {
            if (subList.size() > 2) {
                this.bdg.setPadding(this.bcN, 0, this.bcP, 0);
            } else {
                this.bdg.setPadding(this.bcN, 0, this.bcO, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).ry()) {
                    this.bdg.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bdg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bdg.setText("");
                } else {
                    this.bdg.setCompoundDrawablePadding(this.drawablePadding);
                    this.bdg.setCompoundDrawablesWithIntrinsicBounds(this.bdh, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bdg.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.aVn != null) {
                    str = this.aVn.getForumId();
                }
                TiebaStatic.log(new aq("c10132").ae(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void Os() {
        if (this.bdf != null) {
            this.bdf.setCoverFlowFactory(new g(this));
            this.bdf.setCallback(new h(this));
        }
    }

    public boolean gS(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lS().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

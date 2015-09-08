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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aw;
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
    protected FrsActivity aVM;
    protected int bbH;
    protected ab bcA;
    protected U9InfoView bcB;
    protected PopupWindow bcC;
    protected View bcD;
    protected TextView bcE;
    protected TextView bcF;
    protected ImageView bcG;
    protected BarImageView bcH;
    protected UserIconBox bcI;
    protected ArrayList<com.baidu.tbadk.core.data.d> bcJ;
    protected aw bcK;
    protected i bcL;
    protected v bcM;
    protected String bcN;
    protected String bcO;
    protected String bcP;
    protected com.baidu.tieba.tbadkCore.o bcQ;
    protected x bcR;
    protected int bcT;
    protected int bcU;
    protected int bcV;
    protected int bcW;
    protected boolean bcX;
    protected boolean bcY;
    protected boolean bcZ;
    protected FrameLayout bcg;
    protected Button bch;
    protected FrameLayout bci;
    protected Button bcj;
    protected TextView bck;
    protected ProgressBar bcl;
    protected FrameLayout bcm;
    protected TextView bcn;
    protected RelativeLayout bco;
    protected TextView bcp;
    protected ImageView bcq;
    protected ImageView bcr;
    protected View bcs;
    protected LinearLayout bct;
    protected TextView bcu;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bcv;
    protected TextView bcw;
    private Drawable bcx;
    protected LinearLayout bcy;
    protected y bcz;
    protected boolean bda;
    protected boolean bdb;
    protected boolean bdc;
    protected float bdd;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bcd = 0;
    protected int bce = 0;
    protected int bcf = 0;
    protected String bcS = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bde = new b(this);
    protected final View.OnClickListener bdf = new c(this);
    protected final View.OnClickListener bdg = new d(this);
    protected boolean bdh = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean NR() {
        return this.bcX;
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

    public boolean NS() {
        int[] iArr = new int[2];
        try {
            this.bcG.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LR;
    }

    public View NT() {
        return this.bcs;
    }

    public BarImageView NF() {
        return this.bcH;
    }

    public TextView NU() {
        return this.LM;
    }

    public boolean E(View view) {
        return this.bcL.F(view);
    }

    public void NV() {
        this.bcL.hide();
    }

    public void NW() {
        this.bcL.show();
    }

    public boolean ND() {
        return this.bdb;
    }

    public void cp(boolean z) {
        this.bda = z;
        if (this.bda) {
            this.bci.setVisibility(0);
        } else {
            this.bci.setVisibility(4);
        }
    }

    public View NX() {
        return this.bco;
    }

    public boolean NE() {
        return this.bdc;
    }

    public ProgressBar NY() {
        return this.bcl;
    }

    public void onDestory() {
        this.bcY = true;
    }

    public void setIsFirstPage(boolean z) {
        this.bcZ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bcN = str;
        this.bcT = i2;
        if (i == 0) {
            this.bcX = false;
            this.bcg.setVisibility(0);
            this.bco.setVisibility(8);
            return;
        }
        this.bcX = true;
        this.bcg.setVisibility(8);
        if (z) {
            this.bcK.z(this.bcg);
        }
        a(false, f);
        this.bco.setVisibility(0);
    }

    public void fW(int i) {
        if (i == 0) {
            this.bcX = false;
            this.bcg.setVisibility(0);
            this.bco.setVisibility(8);
            return;
        }
        this.bcX = true;
        this.bcg.setVisibility(8);
        this.bco.setVisibility(0);
    }

    public void fX(int i) {
        if (i == 0) {
            this.bdb = false;
            this.bcm.setVisibility(8);
            this.bci.setVisibility(0);
            al.h((View) this.bcj, i.e.frs_btn_sign);
            return;
        }
        this.bdb = true;
        this.bci.setVisibility(8);
        this.bcn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bcV <= 1) {
            this.bcn.setText(this.mContext.getString(i.h.signed));
        } else {
            this.bcn.setText(String.valueOf(this.mContext.getString(i.h.signed_less)) + String.valueOf(this.bcV) + this.mContext.getString(i.h.day));
        }
        this.bcm.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void NZ() {
        if (this.mMemberType != 0) {
            al.c(this.bcG, i.e.icon_speed_orange);
        } else {
            al.c(this.bcG, i.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bcW));
        if (this.bbH >= 10000) {
            if (this.bbH % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbH / 10000) + this.mContext.getString(i.h.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbH / 10000.0f) + this.mContext.getString(i.h.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbH));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(List<com.baidu.tieba.tbadkCore.h> list) {
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
        if (this.bcv == null || hVar == null || hVar.rC() == null || hVar.rC().size() <= 0) {
            if (this.bcv != null) {
                this.bcv.setVisibility(8);
                return;
            }
            return;
        }
        this.bcx = al.getDrawable(i.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds10);
        this.bcv.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> rC = hVar.rC();
        List<com.baidu.tbadk.core.data.i> subList = rC.size() > 5 ? rC.subList(0, 5) : rC;
        if (subList.size() > 1) {
            this.bcv.setDisableParentEvent(true);
        } else {
            this.bcv.setDisableParentEvent(false);
        }
        this.bcv.setData(subList);
        if (this.bcw != null) {
            if (subList.size() > 2) {
                this.bcw.setPadding(this.bcd, 0, this.bcf, 0);
            } else {
                this.bcw.setPadding(this.bcd, 0, this.bce, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rF()) {
                    this.bcw.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bcw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcw.setText("");
                } else {
                    this.bcw.setCompoundDrawablePadding(this.drawablePadding);
                    this.bcw.setCompoundDrawablesWithIntrinsicBounds(this.bcx, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcw.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.aVM != null) {
                    str = this.aVM.getForumId();
                }
                TiebaStatic.log(new ao("c10132").af(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void Oa() {
        if (this.bcv != null) {
            this.bcv.setCoverFlowFactory(new g(this));
            this.bcv.setCallback(new h(this));
        }
    }

    public boolean gN(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lQ().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mm().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

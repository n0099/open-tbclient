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
    protected TextView LL;
    protected TextView LM;
    protected TextView LN;
    protected TextView LO;
    protected View LS;
    protected FrsActivity aVf;
    protected int bbM;
    protected CoverFlowView<com.baidu.tbadk.core.data.i> bcA;
    protected TextView bcB;
    private Drawable bcC;
    protected LinearLayout bcD;
    protected x bcE;
    protected aa bcF;
    protected U9InfoView bcG;
    protected PopupWindow bcH;
    protected View bcI;
    protected TextView bcJ;
    protected TextView bcK;
    protected ImageView bcL;
    protected BarImageView bcM;
    protected UserIconBox bcN;
    protected ArrayList<com.baidu.tbadk.core.data.c> bcO;
    protected be bcP;
    protected i bcQ;
    protected w bcR;
    protected String bcS;
    protected String bcT;
    protected String bcU;
    protected com.baidu.tieba.tbadkCore.o bcV;
    protected com.baidu.tbadk.core.data.w bcW;
    protected int bcY;
    protected int bcZ;
    protected FrameLayout bcl;
    protected Button bcm;
    protected FrameLayout bcn;
    protected Button bco;
    protected TextView bcp;
    protected ProgressBar bcq;
    protected FrameLayout bcr;
    protected TextView bcs;
    protected RelativeLayout bct;
    protected TextView bcu;
    protected ImageView bcv;
    protected ImageView bcw;
    protected View bcx;
    protected LinearLayout bcy;
    protected TextView bcz;
    protected int bda;
    protected int bdb;
    protected boolean bdc;
    protected boolean bdd;
    protected boolean bde;
    protected boolean bdf;
    protected boolean bdg;
    protected boolean bdh;
    protected float bdi;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bci = 0;
    protected int bcj = 0;
    protected int bck = 0;
    protected String bcX = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bdj = new b(this);
    protected final View.OnClickListener bdk = new c(this);
    protected final View.OnClickListener bdl = new d(this);
    protected boolean bdm = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean NN() {
        return this.bdc;
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

    public boolean NO() {
        int[] iArr = new int[2];
        try {
            this.bcL.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LS;
    }

    public View NP() {
        return this.bcx;
    }

    public BarImageView NB() {
        return this.bcM;
    }

    public TextView NQ() {
        return this.LN;
    }

    public boolean E(View view) {
        return this.bcQ.F(view);
    }

    public void NR() {
        this.bcQ.hide();
    }

    public void NS() {
        this.bcQ.show();
    }

    public boolean Nz() {
        return this.bdg;
    }

    public void cm(boolean z) {
        this.bdf = z;
        if (this.bdf) {
            this.bcn.setVisibility(0);
        } else {
            this.bcn.setVisibility(4);
        }
    }

    public View NT() {
        return this.bct;
    }

    public boolean NA() {
        return this.bdh;
    }

    public ProgressBar NU() {
        return this.bcq;
    }

    public void onDestory() {
        this.bdd = true;
    }

    public void setIsFirstPage(boolean z) {
        this.bde = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bcS = str;
        this.bcY = i2;
        if (i == 0) {
            this.bdc = false;
            this.bcl.setVisibility(0);
            this.bct.setVisibility(8);
            return;
        }
        this.bdc = true;
        this.bcl.setVisibility(8);
        if (z) {
            this.bcP.z(this.bcl);
        }
        a(false, f);
        this.bct.setVisibility(0);
    }

    public void gb(int i) {
        if (i == 0) {
            this.bdc = false;
            this.bcl.setVisibility(0);
            this.bct.setVisibility(8);
            return;
        }
        this.bdc = true;
        this.bcl.setVisibility(8);
        this.bct.setVisibility(0);
    }

    public void gc(int i) {
        if (i == 0) {
            this.bdg = false;
            this.bcr.setVisibility(8);
            this.bcn.setVisibility(0);
            an.i((View) this.bco, i.e.frs_btn_sign);
            return;
        }
        this.bdg = true;
        this.bcn.setVisibility(8);
        this.bcs.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bda <= 1) {
            this.bcs.setText(this.mContext.getString(i.h.signed));
        } else {
            this.bcs.setText(String.valueOf(this.mContext.getString(i.h.signed_less)) + String.valueOf(this.bda) + this.mContext.getString(i.h.day));
        }
        this.bcr.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void NV() {
        if (this.mMemberType != 0) {
            an.c(this.bcL, i.e.icon_speed_orange);
        } else {
            an.c(this.bcL, i.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bdb));
        if (this.bbM >= 10000) {
            if (this.bbM % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbM / 10000) + this.mContext.getString(i.h.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbM / 10000.0f) + this.mContext.getString(i.h.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(List<com.baidu.tieba.tbadkCore.h> list) {
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
        if (this.bcA == null || hVar == null || hVar.ru() == null || hVar.ru().size() <= 0) {
            if (this.bcA != null) {
                this.bcA.setVisibility(8);
                return;
            }
            return;
        }
        this.bcC = an.getDrawable(i.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds10);
        this.bcA.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.i> ru = hVar.ru();
        List<com.baidu.tbadk.core.data.i> subList = ru.size() > 5 ? ru.subList(0, 5) : ru;
        if (subList.size() > 1) {
            this.bcA.setDisableParentEvent(true);
        } else {
            this.bcA.setDisableParentEvent(false);
        }
        this.bcA.setData(subList);
        if (this.bcB != null) {
            if (subList.size() > 2) {
                this.bcB.setPadding(this.bci, 0, this.bck, 0);
            } else {
                this.bcB.setPadding(this.bci, 0, this.bcj, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rx()) {
                    this.bcB.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bcB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcB.setText("");
                } else {
                    this.bcB.setCompoundDrawablePadding(this.drawablePadding);
                    this.bcB.setCompoundDrawablesWithIntrinsicBounds(this.bcC, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcB.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.aVf != null) {
                    str = this.aVf.getForumId();
                }
                TiebaStatic.log(new aq("c10132").ae(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void NW() {
        if (this.bcA != null) {
            this.bcA.setCoverFlowFactory(new g(this));
            this.bcA.setCallback(new h(this));
        }
    }

    public boolean gQ(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lR().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

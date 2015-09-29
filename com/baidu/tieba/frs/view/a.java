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
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    protected TextView LK;
    protected TextView LL;
    protected TextView LM;
    protected TextView LN;
    protected View LR;
    protected FrsActivity aUU;
    protected int bbB;
    protected ImageView bcA;
    protected BarImageView bcB;
    protected UserIconBox bcC;
    protected ArrayList<com.baidu.tbadk.core.data.c> bcD;
    protected be bcE;
    protected i bcF;
    protected w bcG;
    protected String bcH;
    protected String bcI;
    protected String bcJ;
    protected com.baidu.tieba.tbadkCore.o bcK;
    protected com.baidu.tbadk.core.data.v bcL;
    protected int bcN;
    protected int bcO;
    protected int bcP;
    protected int bcQ;
    protected boolean bcR;
    protected boolean bcS;
    protected boolean bcT;
    protected boolean bcU;
    protected boolean bcV;
    protected boolean bcW;
    protected float bcX;
    protected FrameLayout bca;
    protected Button bcb;
    protected FrameLayout bcc;
    protected Button bcd;
    protected TextView bce;
    protected ProgressBar bcf;
    protected FrameLayout bcg;
    protected TextView bch;
    protected RelativeLayout bci;
    protected TextView bcj;
    protected ImageView bck;
    protected ImageView bcl;
    protected View bcm;
    protected LinearLayout bcn;
    protected TextView bco;
    protected CoverFlowView<com.baidu.tbadk.core.data.h> bcp;
    protected TextView bcq;
    private Drawable bcr;
    protected LinearLayout bcs;
    protected com.baidu.tbadk.core.data.w bct;
    protected z bcu;
    protected U9InfoView bcv;
    protected PopupWindow bcw;
    protected View bcx;
    protected TextView bcy;
    protected TextView bcz;
    private int drawablePadding;
    protected TbPageContext<FrsActivity> mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bbX = 0;
    protected int bbY = 0;
    protected int bbZ = 0;
    protected String bcM = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable bcY = new b(this);
    protected final View.OnClickListener bcZ = new c(this);
    protected final View.OnClickListener bda = new d(this);
    protected boolean bdb = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean NR() {
        return this.bcR;
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
            this.bcA.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LR;
    }

    public View NT() {
        return this.bcm;
    }

    public BarImageView NF() {
        return this.bcB;
    }

    public TextView NU() {
        return this.LM;
    }

    public boolean E(View view) {
        return this.bcF.F(view);
    }

    public void NV() {
        this.bcF.hide();
    }

    public void NW() {
        this.bcF.show();
    }

    public boolean ND() {
        return this.bcV;
    }

    public void cm(boolean z) {
        this.bcU = z;
        if (this.bcU) {
            this.bcc.setVisibility(0);
        } else {
            this.bcc.setVisibility(4);
        }
    }

    public View NX() {
        return this.bci;
    }

    public boolean NE() {
        return this.bcW;
    }

    public ProgressBar NY() {
        return this.bcf;
    }

    public void onDestory() {
        this.bcS = true;
    }

    public void setIsFirstPage(boolean z) {
        this.bcT = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bcH = str;
        this.bcN = i2;
        if (i == 0) {
            this.bcR = false;
            this.bca.setVisibility(0);
            this.bci.setVisibility(8);
            return;
        }
        this.bcR = true;
        this.bca.setVisibility(8);
        if (z) {
            this.bcE.z(this.bca);
        }
        a(false, f);
        this.bci.setVisibility(0);
    }

    public void gb(int i) {
        if (i == 0) {
            this.bcR = false;
            this.bca.setVisibility(0);
            this.bci.setVisibility(8);
            return;
        }
        this.bcR = true;
        this.bca.setVisibility(8);
        this.bci.setVisibility(0);
    }

    public void gc(int i) {
        if (i == 0) {
            this.bcV = false;
            this.bcg.setVisibility(8);
            this.bcc.setVisibility(0);
            am.i((View) this.bcd, i.e.frs_btn_sign);
            return;
        }
        this.bcV = true;
        this.bcc.setVisibility(8);
        this.bch.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.bcP <= 1) {
            this.bch.setText(this.mContext.getString(i.h.signed));
        } else {
            this.bch.setText(String.valueOf(this.mContext.getString(i.h.signed_less)) + String.valueOf(this.bcP) + this.mContext.getString(i.h.day));
        }
        this.bcg.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void NZ() {
        if (this.mMemberType != 0) {
            am.c(this.bcA, i.e.icon_speed_orange);
        } else {
            am.c(this.bcA, i.e.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bcQ));
        if (this.bbB >= 10000) {
            if (this.bbB % 10000 == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbB / 10000) + this.mContext.getString(i.h.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbB / 10000.0f) + this.mContext.getString(i.h.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(i.h.experience_divider)) + String.valueOf(this.bbB));
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

    public void a(com.baidu.tbadk.core.data.g gVar) {
        if (this.bcp == null || gVar == null || gVar.rx() == null || gVar.rx().size() <= 0) {
            if (this.bcp != null) {
                this.bcp.setVisibility(8);
                return;
            }
            return;
        }
        this.bcr = am.getDrawable(i.e.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds10);
        this.bcp.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.h> rx = gVar.rx();
        List<com.baidu.tbadk.core.data.h> subList = rx.size() > 5 ? rx.subList(0, 5) : rx;
        if (subList.size() > 1) {
            this.bcp.setDisableParentEvent(true);
        } else {
            this.bcp.setDisableParentEvent(false);
        }
        this.bcp.setData(subList);
        if (this.bcq != null) {
            if (subList.size() > 2) {
                this.bcq.setPadding(this.bbX, 0, this.bbZ, 0);
            } else {
                this.bcq.setPadding(this.bbX, 0, this.bbY, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rA()) {
                    this.bcq.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bcq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcq.setText("");
                } else {
                    this.bcq.setCompoundDrawablePadding(this.drawablePadding);
                    this.bcq.setCompoundDrawablesWithIntrinsicBounds(this.bcr, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bcq.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.aUU != null) {
                    str = this.aUU.getForumId();
                }
                TiebaStatic.log(new ap("c10132").ae(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void Oa() {
        if (this.bcp != null) {
            this.bcp.setCoverFlowFactory(new g(this));
            this.bcp.setCallback(new h(this));
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

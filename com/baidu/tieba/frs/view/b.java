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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    protected TextView MJ;
    protected TextView MK;
    protected TextView ML;
    protected TextView MM;
    protected View MQ;
    protected TbPageContext<FrsActivity> MR;
    protected FrsActivity bgW;
    protected bx biF;
    protected int bpB;
    protected PopupWindow bqA;
    protected View bqB;
    protected TextView bqC;
    protected TextView bqD;
    protected ImageView bqE;
    protected PopupWindow bqF;
    protected BarImageView bqG;
    protected UserIconBox bqH;
    protected ArrayList<com.baidu.tbadk.core.data.e> bqI;
    protected bi bqJ;
    protected j bqK;
    protected aa bqL;
    protected ForumMemberIconView bqM;
    protected com.baidu.tbadk.core.data.l bqN;
    protected String bqO;
    protected String bqP;
    protected String bqQ;
    protected com.baidu.tieba.tbadkCore.o bqR;
    protected ah bqS;
    protected int bqU;
    protected int bqV;
    protected int bqW;
    protected int bqX;
    protected int bqY;
    protected boolean bqZ;
    protected FrameLayout bqb;
    protected Button bqc;
    protected FrameLayout bqd;
    protected Button bqe;
    protected TextView bqf;
    protected ProgressBar bqg;
    protected FrameLayout bqh;
    protected TextView bqi;
    protected RelativeLayout bqj;
    protected TextView bqk;
    protected ImageView bql;
    protected ImageView bqm;
    protected View bqn;
    protected RelativeLayout bqo;
    protected TextView bqp;
    protected LinearLayout bqq;
    protected LinearLayout bqr;
    protected TextView bqs;
    protected CoverFlowView<com.baidu.tbadk.core.data.k> bqt;
    protected TextView bqu;
    private Drawable bqv;
    protected LinearLayout bqw;
    protected ai bqx;
    protected al bqy;
    protected U9InfoView bqz;
    protected boolean bra;
    protected boolean brb;
    protected boolean brc;
    protected boolean brd;
    protected boolean bre;
    protected float brf;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bpY = 0;
    protected int bpZ = 0;
    protected int bqa = 0;
    protected String bqT = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable brg = new c(this);
    protected final View.OnClickListener brh = new d(this);
    protected final View.OnClickListener ahM = new e(this);
    protected boolean bri = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public boolean Sl() {
        return this.bqZ;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new f(this, tbPageContextSupport, view, f2));
    }

    public boolean Sm() {
        int[] iArr = new int[2];
        try {
            this.bqE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.MQ;
    }

    public View Sn() {
        return this.bqn;
    }

    public BarImageView RZ() {
        return this.bqG;
    }

    public TextView So() {
        return this.ML;
    }

    public boolean Y(View view) {
        return this.bqK.Z(view);
    }

    public void Sp() {
        this.bqK.hide();
    }

    public void Sq() {
        this.bqK.show();
    }

    public boolean RX() {
        return this.brd;
    }

    public void cC(boolean z) {
        this.brc = z;
        if (this.brc) {
            this.bqd.setVisibility(0);
        } else {
            this.bqd.setVisibility(4);
        }
    }

    public View Sr() {
        return this.bqj;
    }

    public boolean RY() {
        return this.bre;
    }

    public ProgressBar Ss() {
        return this.bqg;
    }

    public void onDestory() {
        this.bra = true;
    }

    public void onStop() {
        if (this.bqF != null && this.bqF.isShowing()) {
            this.bqF.dismiss();
        }
        if (this.bqA != null && this.bqA.isShowing()) {
            this.bqA.dismiss();
        }
    }

    public void cD(boolean z) {
        this.brb = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bqO = str;
        this.bqU = i2;
        if (i == 0) {
            this.bqZ = false;
            this.bqb.setVisibility(0);
            this.bqj.setVisibility(8);
            return;
        }
        this.bqZ = true;
        this.bqb.setVisibility(8);
        if (z) {
            this.bqJ.U(this.bqb);
        }
        a(false, f);
        this.bqj.setVisibility(0);
    }

    public void ha(int i) {
        if (i == 0) {
            this.bqZ = false;
            this.bqb.setVisibility(0);
            this.bqj.setVisibility(8);
            if (this.biF != null) {
                this.biF.hide();
                return;
            }
            return;
        }
        this.bqZ = true;
        this.bqb.setVisibility(8);
        this.bqj.setVisibility(0);
    }

    public void hb(int i) {
        if (i == 0) {
            this.brd = false;
            this.bqh.setVisibility(8);
            this.bqd.setVisibility(0);
            ar.k(this.bqe, t.f.frs_btn_sign);
            return;
        }
        this.brd = true;
        this.bqd.setVisibility(8);
        if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
            this.bqh.setClickable(true);
        } else {
            this.bqh.setClickable(false);
        }
        ar.b(this.bqi, t.d.cp_link_tip_c, 1);
        if (this.bqX > 0) {
            if (com.baidu.adp.lib.util.k.K(this.MR.getPageActivity()) >= 480) {
                this.bqi.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.bqi.setText(String.format(this.MR.getString(t.j.miss_sign_days), Integer.valueOf(this.bqX)));
        } else {
            this.bqi.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
            if (this.bqW <= 0) {
                this.bqi.setText(this.MR.getString(t.j.signed));
            } else {
                this.bqi.setText(String.format(this.MR.getString(t.j.continuous_sign_days), Integer.valueOf(this.bqW)));
            }
        }
        this.bqh.setVisibility(0);
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void St() {
        if (this.mMemberType != 0) {
            ar.c(this.bqE, t.f.icon_speed_orange);
        } else {
            ar.c(this.bqE, t.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bqY));
        if (this.bpB >= 10000) {
            if (this.bpB % 10000 == 0) {
                textView2.setText(String.valueOf(this.MR.getString(t.j.experience_divider)) + String.valueOf(this.bpB / 10000) + this.MR.getString(t.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.MR.getString(t.j.experience_divider)) + String.valueOf(this.bpB / 10000.0f) + this.MR.getString(t.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.MR.getString(t.j.experience_divider)) + String.valueOf(this.bpB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.MR.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MR.getLayoutMode().x(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void a(com.baidu.tbadk.core.data.j jVar) {
        if (this.bqt == null || jVar == null || jVar.rW() == null || jVar.rW().size() <= 0) {
            if (this.bqt != null) {
                this.bqt.setVisibility(8);
                return;
            }
            return;
        }
        this.bqv = ar.getDrawable(t.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.c(this.MR.getPageActivity(), t.e.ds10);
        this.bqt.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.k> rW = jVar.rW();
        List<com.baidu.tbadk.core.data.k> subList = rW.size() > 5 ? rW.subList(0, 5) : rW;
        if (subList.size() > 1) {
            this.bqt.setDisableParentEvent(true);
        } else {
            this.bqt.setDisableParentEvent(false);
        }
        this.bqt.setData(subList);
        if (this.bqu != null) {
            if (subList.size() > 2) {
                this.bqu.setPadding(this.bpY, 0, this.bqa, 0);
            } else {
                this.bqu.setPadding(this.bpY, 0, this.bpZ, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).rZ()) {
                    this.bqu.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bqu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bqu.setText("");
                } else {
                    this.bqu.setCompoundDrawablePadding(this.drawablePadding);
                    this.bqu.setCompoundDrawablesWithIntrinsicBounds(this.bqv, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bqu.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                if (this.bgW != null) {
                    str = this.bgW.getForumId();
                }
                TiebaStatic.log(new au("c10132").aa(ImageViewerConfig.FORUM_ID, str).r(ImageViewerConfig.INDEX, 0));
            }
        }
    }

    public void Su() {
        if (this.bqt != null) {
            this.bqt.setCoverFlowFactory(new h(this));
            this.bqt.setCallback(new i(this));
        }
    }

    public boolean hx(String str) {
        if (str != null && str.startsWith("homework:")) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lD().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1) {
                return true;
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(pluginConfig.package_name);
            if ((findPluginSetting != null && pluginConfig.newest != null && findPluginSetting.versionCode > pluginConfig.newest.version_code) || Build.VERSION.SDK_INT < 9) {
                return true;
            }
            TiebaStatic.log("c10102");
        }
        return false;
    }
}

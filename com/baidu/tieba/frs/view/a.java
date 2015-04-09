package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.U9InfoView;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected static final int[] aNX = {com.baidu.tieba.u.label_green, com.baidu.tieba.u.label_blue, com.baidu.tieba.u.label_orange, com.baidu.tieba.u.label_red, com.baidu.tieba.u.label_purple};
    protected TextView LI;
    protected TextView LJ;
    protected TextView LK;
    protected View LO;
    protected TbPageContext<FrsActivity> LP;
    protected int aNK;
    protected FrameLayout aNY;
    protected Button aNZ;
    protected ArrayList<com.baidu.tbadk.core.data.e> aOA;
    protected ao aOB;
    protected g aOC;
    protected w aOD;
    protected String aOE;
    protected String aOF;
    protected String aOG;
    protected String aOH;
    protected com.baidu.tieba.tbadkCore.w aOI;
    protected com.baidu.tbadk.core.data.w aOJ;
    protected int aOL;
    protected int aOM;
    protected int aON;
    protected int aOO;
    protected int aOP;
    protected int aOQ;
    protected int aOR;
    protected boolean aOS;
    protected boolean aOT;
    protected boolean aOU;
    protected boolean aOV;
    protected boolean aOW;
    protected boolean aOX;
    protected float aOY;
    protected FrameLayout aOa;
    protected Button aOb;
    protected TextView aOc;
    protected ProgressBar aOd;
    protected FrameLayout aOe;
    protected TextView aOf;
    protected RelativeLayout aOg;
    protected TextView aOh;
    protected ImageView aOi;
    protected ImageView aOj;
    protected LinearLayout aOk;
    protected TextView aOl;
    protected LinearLayout aOm;
    protected TextView aOn;
    protected LinearLayout aOo;
    protected x aOp;
    protected aa aOq;
    protected U9InfoView aOr;
    protected PopupWindow aOs;
    protected View aOt;
    protected TextView aOu;
    protected TextView aOv;
    protected ImageView aOw;
    protected BarImageView aOx;
    protected TextView aOy;
    protected UserIconBox aOz;
    protected boolean aPc;
    protected boolean aPd;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected TextView mTitleText;
    protected String aOK = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable aOZ = new b(this);
    protected final View.OnClickListener aPa = new c(this);
    protected final View.OnClickListener aPb = new d(this);

    public a() {
        this.aPc = TbadkCoreApplication.m411getInst().getIntentClass(FrsGroupActivityConfig.class) != null;
        this.aPd = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);
    }

    public boolean Lu() {
        return this.aOS;
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

    public boolean Lv() {
        int[] iArr = new int[2];
        try {
            this.aOw.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LO;
    }

    public BarImageView Lo() {
        return this.aOx;
    }

    public TextView Lw() {
        return this.mTitleText;
    }

    public boolean w(View view) {
        return this.aOC.x(view);
    }

    public void Lx() {
        this.aOC.hide();
    }

    public void Ly() {
        this.aOC.show();
    }

    public boolean Lm() {
        return this.aOW;
    }

    public void bY(boolean z) {
        this.aOV = z;
        if (this.aOV) {
            this.aOa.setVisibility(0);
        } else {
            this.aOa.setVisibility(4);
        }
    }

    public View Lz() {
        return this.aOg;
    }

    public boolean Ln() {
        return this.aOX;
    }

    public ProgressBar LA() {
        return this.aOd;
    }

    public void onDestory() {
        this.aOT = true;
    }

    public void bZ(boolean z) {
        this.aOU = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aOE = str;
        this.aOL = i2;
        if (i == 0) {
            this.aOS = false;
            this.aNY.setVisibility(0);
            this.aOg.setVisibility(8);
            return;
        }
        this.aOS = true;
        this.aNY.setVisibility(8);
        if (z) {
            this.aOB.t(this.aNY);
        }
        a(false, f);
        this.aOg.setVisibility(0);
    }

    public void fa(int i) {
        if (i == 0) {
            this.aOS = false;
            this.aNY.setVisibility(0);
            this.aOg.setVisibility(8);
            return;
        }
        this.aOS = true;
        this.aNY.setVisibility(8);
        this.aOg.setVisibility(0);
    }

    public void fb(int i) {
        if (i == 0) {
            this.aOW = false;
            this.aOe.setVisibility(8);
            this.aOa.setVisibility(0);
            ba.i((View) this.aOb, com.baidu.tieba.u.frs_btn_sign);
            return;
        }
        this.aOW = true;
        this.aOa.setVisibility(8);
        this.aOf.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aOO <= 1) {
            this.aOf.setText(this.LP.getString(y.signed));
        } else {
            this.aOf.setText(String.valueOf(this.LP.getString(y.signed_less)) + String.valueOf(this.aOO) + this.LP.getString(y.day));
        }
        this.aOe.setVisibility(0);
    }

    public void fc(int i) {
        this.aOQ = i;
    }

    public void LB() {
        if (this.aOQ != 0) {
            ba.c(this.aOw, com.baidu.tieba.u.icon_speed_orange);
        } else {
            ba.c(this.aOw, com.baidu.tieba.u.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aOP));
        if (this.aNK >= 10000) {
            if (this.aNK % 10000 == 0) {
                textView2.setText(String.valueOf(this.LP.getString(y.experience_divider)) + String.valueOf(this.aNK / 10000) + this.LP.getString(y.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.LP.getString(y.experience_divider)) + String.valueOf(this.aNK / 10000.0f) + this.LP.getString(y.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.LP.getString(y.experience_divider)) + String.valueOf(this.aNK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.LP.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LP.getLayoutMode().h(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(List<com.baidu.tieba.tbadkCore.o> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.o> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.o next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void a(boolean z, float f) {
    }
}

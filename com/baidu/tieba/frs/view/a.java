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
    protected static final int[] aNG = {com.baidu.tieba.u.label_green, com.baidu.tieba.u.label_blue, com.baidu.tieba.u.label_orange, com.baidu.tieba.u.label_red, com.baidu.tieba.u.label_purple};
    protected TextView LG;
    protected TextView LH;
    protected TextView LI;
    protected View LM;
    protected TbPageContext<FrsActivity> LN;
    protected FrameLayout aNH;
    protected Button aNI;
    protected FrameLayout aNJ;
    protected Button aNK;
    protected TextView aNL;
    protected ProgressBar aNM;
    protected FrameLayout aNN;
    protected TextView aNO;
    protected RelativeLayout aNP;
    protected TextView aNQ;
    protected ImageView aNR;
    protected ImageView aNS;
    protected LinearLayout aNT;
    protected TextView aNU;
    protected LinearLayout aNV;
    protected TextView aNW;
    protected LinearLayout aNX;
    protected x aNY;
    protected aa aNZ;
    protected int aNt;
    protected int aOA;
    protected boolean aOB;
    protected boolean aOC;
    protected boolean aOD;
    protected boolean aOE;
    protected boolean aOF;
    protected boolean aOG;
    protected float aOH;
    protected boolean aOL;
    protected boolean aOM;
    protected U9InfoView aOa;
    protected PopupWindow aOb;
    protected View aOc;
    protected TextView aOd;
    protected TextView aOe;
    protected ImageView aOf;
    protected BarImageView aOg;
    protected TextView aOh;
    protected UserIconBox aOi;
    protected ArrayList<com.baidu.tbadk.core.data.e> aOj;
    protected ao aOk;
    protected g aOl;
    protected w aOm;
    protected String aOn;
    protected String aOo;
    protected String aOp;
    protected String aOq;
    protected com.baidu.tieba.tbadkCore.w aOr;
    protected com.baidu.tbadk.core.data.w aOs;
    protected int aOu;
    protected int aOv;
    protected int aOw;
    protected int aOx;
    protected int aOy;
    protected int aOz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected TextView mTitleText;
    protected String aOt = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable aOI = new b(this);
    protected final View.OnClickListener aOJ = new c(this);
    protected final View.OnClickListener aOK = new d(this);

    public a() {
        this.aOL = TbadkCoreApplication.m411getInst().getIntentClass(FrsGroupActivityConfig.class) != null;
        this.aOM = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);
    }

    public boolean Li() {
        return this.aOB;
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

    public boolean Lj() {
        int[] iArr = new int[2];
        try {
            this.aOf.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LM;
    }

    public BarImageView Lc() {
        return this.aOg;
    }

    public TextView Lk() {
        return this.mTitleText;
    }

    public boolean w(View view) {
        return this.aOl.x(view);
    }

    public void Ll() {
        this.aOl.hide();
    }

    public void Lm() {
        this.aOl.show();
    }

    public boolean La() {
        return this.aOF;
    }

    public void ca(boolean z) {
        this.aOE = z;
        if (this.aOE) {
            this.aNJ.setVisibility(0);
        } else {
            this.aNJ.setVisibility(4);
        }
    }

    public View Ln() {
        return this.aNP;
    }

    public boolean Lb() {
        return this.aOG;
    }

    public ProgressBar Lo() {
        return this.aNM;
    }

    public void onDestory() {
        this.aOC = true;
    }

    public void cb(boolean z) {
        this.aOD = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aOn = str;
        this.aOu = i2;
        if (i == 0) {
            this.aOB = false;
            this.aNH.setVisibility(0);
            this.aNP.setVisibility(8);
            return;
        }
        this.aOB = true;
        this.aNH.setVisibility(8);
        if (z) {
            this.aOk.t(this.aNH);
        }
        a(false, f);
        this.aNP.setVisibility(0);
    }

    public void eZ(int i) {
        if (i == 0) {
            this.aOB = false;
            this.aNH.setVisibility(0);
            this.aNP.setVisibility(8);
            return;
        }
        this.aOB = true;
        this.aNH.setVisibility(8);
        this.aNP.setVisibility(0);
    }

    public void fa(int i) {
        if (i == 0) {
            this.aOF = false;
            this.aNN.setVisibility(8);
            this.aNJ.setVisibility(0);
            ba.i((View) this.aNK, com.baidu.tieba.u.frs_btn_sign);
            return;
        }
        this.aOF = true;
        this.aNJ.setVisibility(8);
        this.aNO.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aOx <= 1) {
            this.aNO.setText(this.LN.getString(y.signed));
        } else {
            this.aNO.setText(String.valueOf(this.LN.getString(y.signed_less)) + String.valueOf(this.aOx) + this.LN.getString(y.day));
        }
        this.aNN.setVisibility(0);
    }

    public void fb(int i) {
        this.aOz = i;
    }

    public void Lp() {
        if (this.aOz != 0) {
            ba.c(this.aOf, com.baidu.tieba.u.icon_speed_orange);
        } else {
            ba.c(this.aOf, com.baidu.tieba.u.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aOy));
        if (this.aNt >= 10000) {
            if (this.aNt % 10000 == 0) {
                textView2.setText(String.valueOf(this.LN.getString(y.experience_divider)) + String.valueOf(this.aNt / 10000) + this.LN.getString(y.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.LN.getString(y.experience_divider)) + String.valueOf(this.aNt / 10000.0f) + this.LN.getString(y.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.LN.getString(y.experience_divider)) + String.valueOf(this.aNt));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.LN.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LN.getLayoutMode().h(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(List<com.baidu.tieba.tbadkCore.o> list) {
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

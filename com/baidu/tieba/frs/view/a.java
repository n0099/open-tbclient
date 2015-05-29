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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    protected static final int[] aQi = {com.baidu.tieba.p.label_green, com.baidu.tieba.p.label_blue, com.baidu.tieba.p.label_orange, com.baidu.tieba.p.label_red, com.baidu.tieba.p.label_purple};
    protected TextView LA;
    protected TextView LB;
    protected View LG;
    protected TbPageContext<FrsActivity> LH;
    protected TextView Lz;
    protected FrsActivity aMk;
    protected int aPW;
    protected x aQA;
    protected aa aQB;
    protected U9InfoView aQC;
    protected PopupWindow aQD;
    protected View aQE;
    protected TextView aQF;
    protected TextView aQG;
    protected ImageView aQH;
    protected BarImageView aQI;
    protected TextView aQJ;
    protected UserIconBox aQK;
    protected ArrayList<com.baidu.tbadk.core.data.e> aQL;
    protected ao aQM;
    protected g aQN;
    protected w aQO;
    protected String aQP;
    protected String aQQ;
    protected String aQR;
    protected String aQS;
    protected com.baidu.tieba.tbadkCore.w aQT;
    protected com.baidu.tbadk.core.data.w aQU;
    protected int aQW;
    protected int aQX;
    protected int aQY;
    protected int aQZ;
    protected FrameLayout aQj;
    protected Button aQk;
    protected FrameLayout aQl;
    protected Button aQm;
    protected TextView aQn;
    protected ProgressBar aQo;
    protected FrameLayout aQp;
    protected TextView aQq;
    protected RelativeLayout aQr;
    protected TextView aQs;
    protected ImageView aQt;
    protected ImageView aQu;
    protected LinearLayout aQv;
    protected TextView aQw;
    protected LinearLayout aQx;
    protected TextView aQy;
    protected LinearLayout aQz;
    protected int aRa;
    protected int aRb;
    protected int aRc;
    protected boolean aRd;
    protected boolean aRe;
    protected boolean aRf;
    protected boolean aRg;
    protected boolean aRh;
    protected boolean aRi;
    protected float aRj;
    protected boolean aRn;
    protected boolean aRo;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected TextView mTitleText;
    protected String aQV = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable aRk = new b(this);
    protected final View.OnClickListener aRl = new c(this);
    protected final View.OnClickListener aRm = new d(this);

    public a() {
        this.aRn = TbadkCoreApplication.m411getInst().getIntentClass(FrsGroupActivityConfig.class) != null;
        this.aRo = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);
    }

    public boolean Mz() {
        return this.aRd;
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

    public boolean MA() {
        int[] iArr = new int[2];
        try {
            this.aQH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LG;
    }

    public BarImageView Mt() {
        return this.aQI;
    }

    public TextView MB() {
        return this.mTitleText;
    }

    public boolean z(View view) {
        return this.aQN.A(view);
    }

    public void MC() {
        this.aQN.hide();
    }

    public void MD() {
        this.aQN.show();
    }

    public boolean Mr() {
        return this.aRh;
    }

    public void ch(boolean z) {
        this.aRg = z;
        if (this.aRg) {
            this.aQl.setVisibility(0);
        } else {
            this.aQl.setVisibility(4);
        }
    }

    public View ME() {
        return this.aQr;
    }

    public boolean Ms() {
        return this.aRi;
    }

    public ProgressBar MF() {
        return this.aQo;
    }

    public void onDestory() {
        this.aRe = true;
    }

    public void setIsFirstPage(boolean z) {
        this.aRf = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aQP = str;
        this.aQW = i2;
        if (i == 0) {
            this.aRd = false;
            this.aQj.setVisibility(0);
            this.aQr.setVisibility(8);
            return;
        }
        this.aRd = true;
        this.aQj.setVisibility(8);
        if (z) {
            this.aQM.w(this.aQj);
        }
        a(false, f);
        this.aQr.setVisibility(0);
    }

    public void fo(int i) {
        if (i == 0) {
            this.aRd = false;
            this.aQj.setVisibility(0);
            this.aQr.setVisibility(8);
            return;
        }
        this.aRd = true;
        this.aQj.setVisibility(8);
        this.aQr.setVisibility(0);
    }

    public void fp(int i) {
        if (i == 0) {
            this.aRh = false;
            this.aQp.setVisibility(8);
            this.aQl.setVisibility(0);
            ay.i((View) this.aQm, com.baidu.tieba.p.frs_btn_sign);
            return;
        }
        this.aRh = true;
        this.aQl.setVisibility(8);
        this.aQq.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aQZ <= 1) {
            this.aQq.setText(this.LH.getString(com.baidu.tieba.t.signed));
        } else {
            this.aQq.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.signed_less)) + String.valueOf(this.aQZ) + this.LH.getString(com.baidu.tieba.t.day));
        }
        this.aQp.setVisibility(0);
    }

    public void fq(int i) {
        this.aRb = i;
    }

    public void MG() {
        if (this.aRb != 0) {
            ay.c(this.aQH, com.baidu.tieba.p.icon_speed_orange);
        } else {
            ay.c(this.aQH, com.baidu.tieba.p.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aRa));
        if (this.aPW >= 10000) {
            if (this.aPW % 10000 == 0) {
                textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPW / 10000) + this.LH.getString(com.baidu.tieba.t.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPW / 10000.0f) + this.LH.getString(com.baidu.tieba.t.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPW));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyNightMode(View view) {
        this.LH.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LH.getLayoutMode().j(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(List<com.baidu.tieba.tbadkCore.o> list) {
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

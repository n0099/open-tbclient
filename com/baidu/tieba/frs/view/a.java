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
    protected static final int[] aQj = {com.baidu.tieba.p.label_green, com.baidu.tieba.p.label_blue, com.baidu.tieba.p.label_orange, com.baidu.tieba.p.label_red, com.baidu.tieba.p.label_purple};
    protected TextView LA;
    protected TextView LB;
    protected View LG;
    protected TbPageContext<FrsActivity> LH;
    protected TextView Lz;
    protected FrsActivity aMl;
    protected int aPX;
    protected LinearLayout aQA;
    protected x aQB;
    protected aa aQC;
    protected U9InfoView aQD;
    protected PopupWindow aQE;
    protected View aQF;
    protected TextView aQG;
    protected TextView aQH;
    protected ImageView aQI;
    protected BarImageView aQJ;
    protected TextView aQK;
    protected UserIconBox aQL;
    protected ArrayList<com.baidu.tbadk.core.data.e> aQM;
    protected ao aQN;
    protected g aQO;
    protected w aQP;
    protected String aQQ;
    protected String aQR;
    protected String aQS;
    protected String aQT;
    protected com.baidu.tieba.tbadkCore.w aQU;
    protected com.baidu.tbadk.core.data.w aQV;
    protected int aQX;
    protected int aQY;
    protected int aQZ;
    protected FrameLayout aQk;
    protected Button aQl;
    protected FrameLayout aQm;
    protected Button aQn;
    protected TextView aQo;
    protected ProgressBar aQp;
    protected FrameLayout aQq;
    protected TextView aQr;
    protected RelativeLayout aQs;
    protected TextView aQt;
    protected ImageView aQu;
    protected ImageView aQv;
    protected LinearLayout aQw;
    protected TextView aQx;
    protected LinearLayout aQy;
    protected TextView aQz;
    protected int aRa;
    protected int aRb;
    protected int aRc;
    protected int aRd;
    protected boolean aRe;
    protected boolean aRf;
    protected boolean aRg;
    protected boolean aRh;
    protected boolean aRi;
    protected boolean aRj;
    protected float aRk;
    protected boolean aRo;
    protected boolean aRp;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected TextView mTitleText;
    protected String aQW = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected final Runnable aRl = new b(this);
    protected final View.OnClickListener aRm = new c(this);
    protected final View.OnClickListener aRn = new d(this);

    public a() {
        this.aRo = TbadkCoreApplication.m411getInst().getIntentClass(FrsGroupActivityConfig.class) != null;
        this.aRp = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameDetailActivityConfig.class);
    }

    public boolean MA() {
        return this.aRe;
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

    public boolean MB() {
        int[] iArr = new int[2];
        try {
            this.aQI.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.LG;
    }

    public BarImageView Mu() {
        return this.aQJ;
    }

    public TextView MC() {
        return this.mTitleText;
    }

    public boolean z(View view) {
        return this.aQO.A(view);
    }

    public void MD() {
        this.aQO.hide();
    }

    public void ME() {
        this.aQO.show();
    }

    public boolean Ms() {
        return this.aRi;
    }

    public void ch(boolean z) {
        this.aRh = z;
        if (this.aRh) {
            this.aQm.setVisibility(0);
        } else {
            this.aQm.setVisibility(4);
        }
    }

    public View MF() {
        return this.aQs;
    }

    public boolean Mt() {
        return this.aRj;
    }

    public ProgressBar MG() {
        return this.aQp;
    }

    public void onDestory() {
        this.aRf = true;
    }

    public void setIsFirstPage(boolean z) {
        this.aRg = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aQQ = str;
        this.aQX = i2;
        if (i == 0) {
            this.aRe = false;
            this.aQk.setVisibility(0);
            this.aQs.setVisibility(8);
            return;
        }
        this.aRe = true;
        this.aQk.setVisibility(8);
        if (z) {
            this.aQN.w(this.aQk);
        }
        a(false, f);
        this.aQs.setVisibility(0);
    }

    public void fo(int i) {
        if (i == 0) {
            this.aRe = false;
            this.aQk.setVisibility(0);
            this.aQs.setVisibility(8);
            return;
        }
        this.aRe = true;
        this.aQk.setVisibility(8);
        this.aQs.setVisibility(0);
    }

    public void fp(int i) {
        if (i == 0) {
            this.aRi = false;
            this.aQq.setVisibility(8);
            this.aQm.setVisibility(0);
            ay.i((View) this.aQn, com.baidu.tieba.p.frs_btn_sign);
            return;
        }
        this.aRi = true;
        this.aQm.setVisibility(8);
        this.aQr.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aRa <= 1) {
            this.aQr.setText(this.LH.getString(com.baidu.tieba.t.signed));
        } else {
            this.aQr.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.signed_less)) + String.valueOf(this.aRa) + this.LH.getString(com.baidu.tieba.t.day));
        }
        this.aQq.setVisibility(0);
    }

    public void fq(int i) {
        this.aRc = i;
    }

    public void MH() {
        if (this.aRc != 0) {
            ay.c(this.aQI, com.baidu.tieba.p.icon_speed_orange);
        } else {
            ay.c(this.aQI, com.baidu.tieba.p.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aRb));
        if (this.aPX >= 10000) {
            if (this.aPX % 10000 == 0) {
                textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPX / 10000) + this.LH.getString(com.baidu.tieba.t.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPX / 10000.0f) + this.LH.getString(com.baidu.tieba.t.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.LH.getString(com.baidu.tieba.t.experience_divider)) + String.valueOf(this.aPX));
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

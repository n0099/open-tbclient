package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.g;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cje = new HashMap<>();
    private static HashSet<Integer> cjf = new HashSet<>();
    protected View aVm;
    protected TbPageContext aas;
    protected TextView bPO;
    protected com.baidu.tieba.frs.r bVm;
    protected com.baidu.tieba.tbadkCore.n bZb;
    protected int biB;
    protected View bqy;
    protected int chM;
    protected LinearLayout ciA;
    protected bo ciB;
    protected br ciC;
    protected PopupWindow ciD;
    protected View ciE;
    protected TextView ciF;
    protected TextView ciG;
    protected ImageView ciH;
    protected PopupWindow ciI;
    protected BarImageView ciJ;
    protected UserIconBox ciK;
    protected ArrayList<g> ciL;
    protected com.baidu.tieba.frs.e.b ciM;
    protected j ciN;
    protected bw ciO;
    protected String ciP;
    protected String ciQ;
    protected String ciR;
    protected bl ciS;
    protected int ciT;
    protected int ciU;
    protected int ciV;
    protected int ciW;
    protected boolean ciX;
    protected boolean ciY;
    protected boolean ciZ;
    protected TextView cim;
    protected TextView cin;
    protected TextView cio;
    protected TextView cip;
    protected TextView ciq;
    protected ImageView cir;
    protected View cis;
    protected ViewGroup cit;
    protected TextView ciu;
    protected ViewGroup civ;
    protected TextView ciw;
    protected TextView cix;
    protected TbImageView ciy;
    protected LinearLayout ciz;
    protected boolean cja;
    protected boolean cjb;
    protected boolean cjc;
    protected float cjd;
    protected RelativeLayout cjj;
    protected RelativeLayout cjk;
    protected View cjl;
    protected TextView cjm;
    protected RelativeLayout cjn;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cij = 0;
    protected int cik = 0;
    protected int cil = 0;
    private boolean cjg = false;
    protected HashSet<String> cjh = new HashSet<>();
    protected final Runnable cji = new c(this);
    protected final View.OnClickListener cjo = new d(this);

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar);

    public abstract void abz();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cje.put(1, "c0117");
        cje.put(2, "c0124");
        cje.put(3, "c0125");
        cje.put(4, "c0126");
        cje.put(5, "c0127");
    }

    public boolean aei() {
        return this.ciX;
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

    public boolean aej() {
        int[] iArr = new int[2];
        try {
            this.ciH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aVm;
    }

    public View aek() {
        return this.cis;
    }

    public BarImageView aed() {
        return this.ciJ;
    }

    public TextView ael() {
        return this.bPO;
    }

    public boolean aeb() {
        return this.cjb;
    }

    public void eA(boolean z) {
        this.cja = z;
        if (this.cja) {
            this.cip.setVisibility(0);
        } else {
            this.cip.setVisibility(4);
        }
    }

    public boolean aec() {
        return this.cjc;
    }

    public void onDestory() {
        this.ciY = true;
        cjf.clear();
    }

    public void onStop() {
        if (this.ciI != null && this.ciI.isShowing()) {
            this.ciI.dismiss();
        }
        if (this.ciD != null && this.ciD.isShowing()) {
            this.ciD.dismiss();
        }
    }

    public void eB(boolean z) {
        this.ciZ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ciP = str;
        this.biB = i2;
        if (i == 0) {
            this.ciX = false;
            this.cjg = false;
            this.cjj.setVisibility(0);
            this.cjk.setVisibility(8);
            return;
        }
        this.ciX = true;
        this.cjj.setVisibility(8);
        this.cjk.setVisibility(0);
        if (z && !this.cjg) {
            abA();
            this.cjg = true;
        }
        c(false, f);
    }

    protected void abA() {
    }

    public void jg(int i) {
        if (i == 0) {
            this.ciX = false;
            this.cjg = false;
            this.cjj.setVisibility(0);
            this.cjk.setVisibility(8);
            return;
        }
        this.ciX = true;
        this.cjj.setVisibility(8);
        this.cjk.setVisibility(0);
    }

    public void jh(int i) {
        if (i == 0) {
            this.cjb = false;
            this.cip.setText(w.l.sign);
            abv();
            return;
        }
        this.cjb = true;
        this.cip.setText(w.l.signed);
        abu();
    }

    protected void abv() {
    }

    protected void abu() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void abB() {
        if (this.mMemberType != 0) {
            aq.c(this.ciH, w.g.icon_speed_orange);
        } else {
            aq.c(this.ciH, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ciW));
        if (this.chM >= 10000) {
            if (this.chM % 10000 == 0) {
                textView2.setText(String.valueOf(this.aas.getString(w.l.experience_divider)) + String.valueOf(this.chM / 10000) + this.aas.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aas.getString(w.l.experience_divider)) + String.valueOf(this.chM / 10000.0f) + this.aas.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aas.getString(w.l.experience_divider)) + String.valueOf(this.chM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(View view) {
        this.aas.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aas.getLayoutMode().t(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void c(boolean z, float f) {
    }

    public void abm() {
    }

    public void ji(int i) {
        if (this.cjn != null) {
            this.cjn.setPadding(0, i, 0, 0);
        }
    }
}

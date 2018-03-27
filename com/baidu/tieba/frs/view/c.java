package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class c {
    private static HashMap<Integer, String> dYu = new HashMap<>();
    private static HashSet<Integer> dYv = new HashSet<>();
    protected PopupWindow QE;
    protected TbPageContext aRI;
    protected View cLS;
    public TextView dDz;
    protected com.baidu.tieba.frs.i dFH;
    protected m dVO;
    protected int dVl;
    protected TextView dXC;
    protected TextView dXD;
    protected TextView dXE;
    protected TextView dXF;
    protected TextView dXG;
    protected ImageView dXH;
    protected View dXI;
    protected ViewGroup dXJ;
    protected TextView dXK;
    protected View dXL;
    protected a dXM;
    protected ViewGroup dXN;
    protected TextView dXO;
    protected TextView dXP;
    protected TbImageView dXQ;
    protected LinearLayout dXR;
    protected bf dXS;
    protected bi dXT;
    protected View dXU;
    protected TextView dXV;
    protected TextView dXW;
    protected ImageView dXX;
    protected PopupWindow dXY;
    protected BarImageView dXZ;
    protected RelativeLayout dYA;
    protected View dYB;
    protected TextView dYC;
    protected RelativeLayout dYD;
    protected TextView dYE;
    protected UserIconBox dYa;
    protected ArrayList<com.baidu.tbadk.core.data.g> dYb;
    protected com.baidu.tieba.frs.f.b dYc;
    protected g dYd;
    protected ai dYe;
    protected String dYf;
    protected String dYg;
    protected String dYh;
    protected bd dYi;
    protected int dYj;
    protected int dYk;
    protected int dYl;
    protected int dYm;
    protected boolean dYn;
    protected boolean dYo;
    protected boolean dYp;
    protected boolean dYq;
    protected boolean dYr;
    protected boolean dYs;
    protected float dYt;
    protected RelativeLayout dYz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dXz = 0;
    protected int dXA = 0;
    protected int dXB = 0;
    private boolean dYw = false;
    protected HashSet<String> dYx = new HashSet<>();
    protected final Runnable dYy = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QE != null && c.this.QE.isShowing() && !c.this.dYo) {
                com.baidu.adp.lib.g.g.a(c.this.QE, c.this.aRI.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dYF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.h hVar;
            if ((c.this.aRI == null || ay.ba(c.this.aRI.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.h) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null && !StringUtils.isNull(hVar.getUrl())) {
                String url = hVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(c.this.aRI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                aw.Du().c(c.this.aRI, new String[]{url});
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.buN(), c.this.dFH.getForumId(), c.this.dFH.getForumName(), null);
                b.ce("obj_url", hVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, m mVar);

    public abstract void axh();

    public abstract void changeSkinType(int i);

    public abstract void l(View.OnClickListener onClickListener);

    public abstract void p(View view, boolean z);

    static {
        dYu.put(1, "c0117");
        dYu.put(2, "c0124");
        dYu.put(3, "c0125");
        dYu.put(4, "c0126");
        dYu.put(5, "c0127");
    }

    public boolean aAN() {
        return this.dYn;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
                scaleAnimation2.setFillAfter(true);
                scaleAnimation2.setDuration(300L);
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.c.3.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, f2, 1.0f, 1.0f);
                        scaleAnimation3.setFillAfter(true);
                        scaleAnimation3.setDuration(300L);
                        view.startAnimation(scaleAnimation3);
                    }
                });
            }
        });
    }

    public boolean aAO() {
        int[] iArr = new int[2];
        try {
            this.dXX.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aAP() {
        return this.dXI;
    }

    public View aAQ() {
        return this.dXM;
    }

    public BarImageView aAR() {
        return this.dXZ;
    }

    public TextView aAS() {
        return this.mTitleText;
    }

    public TextView aAT() {
        return this.dDz;
    }

    public boolean aAq() {
        return this.dYr;
    }

    public void gB(boolean z) {
        this.dYq = z;
        if (this.dYq) {
            this.dXF.setVisibility(0);
        } else {
            this.dXF.setVisibility(4);
        }
    }

    public boolean aAr() {
        return this.dYs;
    }

    public void onDestory() {
        this.dYo = true;
        dYv.clear();
    }

    public void onStop() {
        aAU();
    }

    public void gt(boolean z) {
        if (!z) {
            aAU();
        }
    }

    private void aAU() {
        if (this.dXY != null && this.dXY.isShowing()) {
            this.dXY.dismiss();
        }
        if (this.QE != null && this.QE.isShowing()) {
            this.QE.dismiss();
        }
    }

    public void gC(boolean z) {
        this.dYp = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dYf = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dYn = false;
            this.dYw = false;
            this.dYz.setVisibility(0);
            this.dYA.setVisibility(8);
            return;
        }
        this.dYn = true;
        this.dYz.setVisibility(8);
        this.dYA.setVisibility(0);
        if (z && !this.dYw) {
            axi();
            this.dYw = true;
        }
        c(false, f);
    }

    protected void axi() {
    }

    public void od(int i) {
        if (i == 0) {
            this.dYn = false;
            this.dYw = false;
            this.dYz.setVisibility(0);
            this.dYA.setVisibility(8);
            return;
        }
        this.dYn = true;
        this.dYz.setVisibility(8);
        this.dYA.setVisibility(0);
    }

    public void oe(int i) {
        if (i == 0) {
            this.dYr = false;
            this.dXF.setText(d.j.sign);
            axd();
            return;
        }
        this.dYr = true;
        this.dXF.setText(d.j.signed);
        axc();
    }

    protected void axd() {
    }

    protected void axc() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void axj() {
        if (this.mMemberType != 0) {
            aj.c(this.dXX, d.f.icon_speed_orange);
        } else {
            aj.c(this.dXX, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dYm));
        if (this.dVl >= 10000) {
            if (this.dVl % 10000 == 0) {
                textView2.setText(this.aRI.getString(d.j.experience_divider) + String.valueOf(this.dVl / 10000) + this.aRI.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aRI.getString(d.j.experience_divider) + String.valueOf(this.dVl / 10000.0f) + this.aRI.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aRI.getString(d.j.experience_divider) + String.valueOf(this.dVl));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bz(List<com.baidu.tieba.tbadkCore.h> list) {
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

    public void c(boolean z, float f) {
    }

    public void awV() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dYD != null) {
            this.dYD.setPadding(i, i2, i3, i4);
        }
    }
}

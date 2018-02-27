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
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class c {
    private static HashMap<Integer, String> dYo = new HashMap<>();
    private static HashSet<Integer> dYp = new HashSet<>();
    protected PopupWindow QE;
    protected TbPageContext aRG;
    protected View cLP;
    public TextView dDw;
    protected com.baidu.tieba.frs.i dFD;
    protected l dVI;
    protected int dVf;
    protected TextView dXA;
    protected ImageView dXB;
    protected View dXC;
    protected ViewGroup dXD;
    protected TextView dXE;
    protected View dXF;
    protected a dXG;
    protected ViewGroup dXH;
    protected TextView dXI;
    protected TextView dXJ;
    protected TbImageView dXK;
    protected LinearLayout dXL;
    protected bf dXM;
    protected bi dXN;
    protected View dXO;
    protected TextView dXP;
    protected TextView dXQ;
    protected ImageView dXR;
    protected PopupWindow dXS;
    protected BarImageView dXT;
    protected UserIconBox dXU;
    protected ArrayList<com.baidu.tbadk.core.data.g> dXV;
    protected com.baidu.tieba.frs.f.b dXW;
    protected g dXX;
    protected ai dXY;
    protected String dXZ;
    protected TextView dXw;
    protected TextView dXx;
    protected TextView dXy;
    protected TextView dXz;
    protected String dYa;
    protected String dYb;
    protected bd dYc;
    protected int dYd;
    protected int dYe;
    protected int dYf;
    protected int dYg;
    protected boolean dYh;
    protected boolean dYi;
    protected boolean dYj;
    protected boolean dYk;
    protected boolean dYl;
    protected boolean dYm;
    protected float dYn;
    protected RelativeLayout dYt;
    protected RelativeLayout dYu;
    protected View dYv;
    protected TextView dYw;
    protected RelativeLayout dYx;
    protected TextView dYy;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dXt = 0;
    protected int dXu = 0;
    protected int dXv = 0;
    private boolean dYq = false;
    protected HashSet<String> dYr = new HashSet<>();
    protected final Runnable dYs = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QE != null && c.this.QE.isShowing() && !c.this.dYi) {
                com.baidu.adp.lib.g.g.a(c.this.QE, c.this.aRG.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dYz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((c.this.aRG == null || ay.ba(c.this.aRG.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(c.this.aRG.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                aw.Dt().c(c.this.aRG, new String[]{url});
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.buL(), c.this.dFD.getForumId(), c.this.dFD.getForumName(), null);
                b.ce("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void axf();

    public abstract void changeSkinType(int i);

    public abstract void l(View.OnClickListener onClickListener);

    public abstract void p(View view, boolean z);

    static {
        dYo.put(1, "c0117");
        dYo.put(2, "c0124");
        dYo.put(3, "c0125");
        dYo.put(4, "c0126");
        dYo.put(5, "c0127");
    }

    public boolean aAL() {
        return this.dYh;
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

    public boolean aAM() {
        int[] iArr = new int[2];
        try {
            this.dXR.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aAN() {
        return this.dXC;
    }

    public View aAO() {
        return this.dXG;
    }

    public BarImageView aAP() {
        return this.dXT;
    }

    public TextView aAQ() {
        return this.mTitleText;
    }

    public TextView aAR() {
        return this.dDw;
    }

    public boolean aAo() {
        return this.dYl;
    }

    public void gz(boolean z) {
        this.dYk = z;
        if (this.dYk) {
            this.dXz.setVisibility(0);
        } else {
            this.dXz.setVisibility(4);
        }
    }

    public boolean aAp() {
        return this.dYm;
    }

    public void onDestory() {
        this.dYi = true;
        dYp.clear();
    }

    public void onStop() {
        aAS();
    }

    public void gr(boolean z) {
        if (!z) {
            aAS();
        }
    }

    private void aAS() {
        if (this.dXS != null && this.dXS.isShowing()) {
            this.dXS.dismiss();
        }
        if (this.QE != null && this.QE.isShowing()) {
            this.QE.dismiss();
        }
    }

    public void gA(boolean z) {
        this.dYj = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dXZ = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dYh = false;
            this.dYq = false;
            this.dYt.setVisibility(0);
            this.dYu.setVisibility(8);
            return;
        }
        this.dYh = true;
        this.dYt.setVisibility(8);
        this.dYu.setVisibility(0);
        if (z && !this.dYq) {
            axg();
            this.dYq = true;
        }
        c(false, f);
    }

    protected void axg() {
    }

    public void od(int i) {
        if (i == 0) {
            this.dYh = false;
            this.dYq = false;
            this.dYt.setVisibility(0);
            this.dYu.setVisibility(8);
            return;
        }
        this.dYh = true;
        this.dYt.setVisibility(8);
        this.dYu.setVisibility(0);
    }

    public void oe(int i) {
        if (i == 0) {
            this.dYl = false;
            this.dXz.setText(d.j.sign);
            axb();
            return;
        }
        this.dYl = true;
        this.dXz.setText(d.j.signed);
        axa();
    }

    protected void axb() {
    }

    protected void axa() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void axh() {
        if (this.mMemberType != 0) {
            aj.c(this.dXR, d.f.icon_speed_orange);
        } else {
            aj.c(this.dXR, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dYg));
        if (this.dVf >= 10000) {
            if (this.dVf % 10000 == 0) {
                textView2.setText(this.aRG.getString(d.j.experience_divider) + String.valueOf(this.dVf / 10000) + this.aRG.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aRG.getString(d.j.experience_divider) + String.valueOf(this.dVf / 10000.0f) + this.aRG.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aRG.getString(d.j.experience_divider) + String.valueOf(this.dVf));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bz(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void awT() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dYx != null) {
            this.dYx.setPadding(i, i2, i3, i4);
        }
    }
}

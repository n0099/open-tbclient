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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> ddr = new HashMap<>();
    private static HashSet<Integer> dds = new HashSet<>();
    protected TbPageContext aca;
    protected View bSZ;
    protected View bev;
    public TextView cGD;
    protected com.baidu.tieba.frs.g cIC;
    protected k cOH;
    protected int daS;
    protected TextView dcA;
    protected TextView dcB;
    protected TextView dcC;
    protected TextView dcD;
    protected ImageView dcE;
    protected View dcF;
    protected ViewGroup dcG;
    protected TextView dcH;
    protected View dcI;
    protected ViewGroup dcJ;
    protected TextView dcK;
    protected TextView dcL;
    protected TbImageView dcM;
    protected LinearLayout dcN;
    protected bf dcO;
    protected bi dcP;
    protected PopupWindow dcQ;
    protected View dcR;
    protected TextView dcS;
    protected TextView dcT;
    protected ImageView dcU;
    protected PopupWindow dcV;
    protected BarImageView dcW;
    protected UserIconBox dcX;
    protected ArrayList<com.baidu.tbadk.core.data.g> dcY;
    protected com.baidu.tieba.frs.f.b dcZ;
    protected TextView dcz;
    protected TextView ddA;
    protected RelativeLayout ddB;
    protected TextView ddC;
    protected f dda;
    protected ai ddb;
    protected String ddc;
    protected String ddd;
    protected String dde;
    protected bd ddf;
    protected int ddg;
    protected int ddh;
    protected int ddi;
    protected int ddj;
    protected boolean ddk;
    protected boolean ddl;
    protected boolean ddm;
    protected boolean ddn;
    protected boolean ddo;
    protected boolean ddp;
    protected float ddq;
    protected RelativeLayout ddx;
    protected RelativeLayout ddy;
    protected View ddz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int dcw = 0;
    protected int dcx = 0;
    protected int dcy = 0;
    private boolean ddt = false;
    protected HashSet<String> ddv = new HashSet<>();
    protected final Runnable ddw = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dcQ != null && c.this.dcQ.isShowing() && !c.this.ddl) {
                com.baidu.adp.lib.g.g.a(c.this.dcQ, c.this.aca.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ddD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.f fVar;
            if ((c.this.aca == null || ax.aS(c.this.aca.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.f) && (fVar = (com.baidu.tieba.tbadkCore.f) view.getTag()) != null && !StringUtils.isNull(fVar.getUrl())) {
                String url = fVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(c.this.aca.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.vI().c(c.this.aca, new String[]{url});
                a.C0142a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.buM(), c.this.cIC.getForumId(), c.this.cIC.getForumName(), null);
                b.cg("obj_url", fVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, k kVar);

    public abstract void anv();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        ddr.put(1, "c0117");
        ddr.put(2, "c0124");
        ddr.put(3, "c0125");
        ddr.put(4, "c0126");
        ddr.put(5, "c0127");
    }

    public boolean arg() {
        return this.ddk;
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

    public boolean arh() {
        int[] iArr = new int[2];
        try {
            this.dcU.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.bev;
    }

    public View ari() {
        return this.dcF;
    }

    public BarImageView arj() {
        return this.dcW;
    }

    public TextView ark() {
        return this.mTitleText;
    }

    public TextView arl() {
        return this.cGD;
    }

    public boolean aqW() {
        return this.ddo;
    }

    public void fF(boolean z) {
        this.ddn = z;
        if (this.ddn) {
            this.dcC.setVisibility(0);
        } else {
            this.dcC.setVisibility(4);
        }
    }

    public boolean aqX() {
        return this.ddp;
    }

    public void onDestory() {
        this.ddl = true;
        dds.clear();
    }

    public void onStop() {
        arm();
    }

    public void fB(boolean z) {
        if (!z) {
            arm();
        }
    }

    private void arm() {
        if (this.dcV != null && this.dcV.isShowing()) {
            this.dcV.dismiss();
        }
        if (this.dcQ != null && this.dcQ.isShowing()) {
            this.dcQ.dismiss();
        }
    }

    public void fG(boolean z) {
        this.ddm = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ddc = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ddk = false;
            this.ddt = false;
            this.ddx.setVisibility(0);
            this.ddy.setVisibility(8);
            return;
        }
        this.ddk = true;
        this.ddx.setVisibility(8);
        this.ddy.setVisibility(0);
        if (z && !this.ddt) {
            anw();
            this.ddt = true;
        }
        c(false, f);
    }

    protected void anw() {
    }

    public void li(int i) {
        if (i == 0) {
            this.ddk = false;
            this.ddt = false;
            this.ddx.setVisibility(0);
            this.ddy.setVisibility(8);
            return;
        }
        this.ddk = true;
        this.ddx.setVisibility(8);
        this.ddy.setVisibility(0);
    }

    public void lj(int i) {
        if (i == 0) {
            this.ddo = false;
            this.dcC.setText(d.j.sign);
            anr();
            return;
        }
        this.ddo = true;
        this.dcC.setText(d.j.signed);
        anq();
    }

    protected void anr() {
    }

    protected void anq() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void anx() {
        if (this.mMemberType != 0) {
            aj.c(this.dcU, d.f.icon_speed_orange);
        } else {
            aj.c(this.dcU, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ddj));
        if (this.daS >= 10000) {
            if (this.daS % 10000 == 0) {
                textView2.setText(this.aca.getString(d.j.experience_divider) + String.valueOf(this.daS / 10000) + this.aca.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aca.getString(d.j.experience_divider) + String.valueOf(this.daS / 10000.0f) + this.aca.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aca.getString(d.j.experience_divider) + String.valueOf(this.daS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bo(List<com.baidu.tieba.tbadkCore.f> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.f> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.f next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void anh() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.ddB != null) {
            this.ddB.setPadding(i, i2, i3, i4);
        }
    }
}

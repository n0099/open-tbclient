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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cyo = new HashMap<>();
    private static HashSet<Integer> cyp = new HashSet<>();
    protected View aXV;
    protected TbPageContext aaS;
    protected int bpY;
    protected View byu;
    protected TextView cce;
    public TextView chf;
    protected com.baidu.tieba.frs.f cjg;
    protected i cng;
    protected int cwJ;
    protected TextView cxA;
    protected TextView cxB;
    protected ImageView cxC;
    protected View cxD;
    protected ViewGroup cxE;
    protected TextView cxF;
    protected ViewGroup cxG;
    protected TextView cxH;
    protected TextView cxI;
    protected TbImageView cxJ;
    protected LinearLayout cxK;
    protected bm cxL;
    protected bp cxM;
    protected PopupWindow cxN;
    protected View cxO;
    protected TextView cxP;
    protected TextView cxQ;
    protected ImageView cxR;
    protected PopupWindow cxS;
    protected BarImageView cxT;
    protected UserIconBox cxU;
    protected ArrayList<h> cxV;
    protected com.baidu.tieba.frs.g.b cxW;
    protected e cxX;
    protected ag cxY;
    protected String cxZ;
    protected TextView cxx;
    protected TextView cxy;
    protected TextView cxz;
    protected String cya;
    protected String cyb;
    protected bl cyc;
    protected int cyd;
    protected int cye;
    protected int cyf;
    protected int cyg;
    protected boolean cyh;
    protected boolean cyi;
    protected boolean cyj;
    protected boolean cyk;
    protected boolean cyl;
    protected boolean cym;
    protected float cyn;
    protected RelativeLayout cyt;
    protected RelativeLayout cyu;
    protected View cyv;
    protected TextView cyw;
    protected RelativeLayout cyx;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cxu = 0;
    protected int cxv = 0;
    protected int cxw = 0;
    private boolean cyq = false;
    protected HashSet<String> cyr = new HashSet<>();
    protected final Runnable cys = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cxN != null && b.this.cxN.isShowing() && !b.this.cyi) {
                g.a(b.this.cxN, b.this.aaS.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cyy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.aaS == null || aw.aN(b.this.aaS.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    k.showToast(b.this.aaS.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                at.vV().c(b.this.aaS, new String[]{url});
                a.C0121a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqo(), b.this.cjg.getForumId(), b.this.cjg.getForumName(), null);
                a.ch("obj_url", eVar.getUrl());
                a.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void agz();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cyo.put(1, "c0117");
        cyo.put(2, "c0124");
        cyo.put(3, "c0125");
        cyo.put(4, "c0126");
        cyo.put(5, "c0127");
    }

    public boolean ajy() {
        return this.cyh;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, (Animation.AnimationListener) null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3.1
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

    public boolean ajz() {
        int[] iArr = new int[2];
        try {
            this.cxR.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aXV;
    }

    public View ajA() {
        return this.cxD;
    }

    public BarImageView ajq() {
        return this.cxT;
    }

    public TextView ajB() {
        return this.cce;
    }

    public TextView ajC() {
        return this.chf;
    }

    public boolean ajo() {
        return this.cyl;
    }

    public void fc(boolean z) {
        this.cyk = z;
        if (this.cyk) {
            this.cxA.setVisibility(0);
        } else {
            this.cxA.setVisibility(4);
        }
    }

    public boolean ajp() {
        return this.cym;
    }

    public void onDestory() {
        this.cyi = true;
        cyp.clear();
    }

    public void onStop() {
        if (this.cxS != null && this.cxS.isShowing()) {
            this.cxS.dismiss();
        }
        if (this.cxN != null && this.cxN.isShowing()) {
            this.cxN.dismiss();
        }
    }

    public void fd(boolean z) {
        this.cyj = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cxZ = str;
        this.bpY = i2;
        if (i == 0) {
            this.cyh = false;
            this.cyq = false;
            this.cyt.setVisibility(0);
            this.cyu.setVisibility(8);
            return;
        }
        this.cyh = true;
        this.cyt.setVisibility(8);
        this.cyu.setVisibility(0);
        if (z && !this.cyq) {
            agA();
            this.cyq = true;
        }
        c(false, f);
    }

    protected void agA() {
    }

    public void jA(int i) {
        if (i == 0) {
            this.cyh = false;
            this.cyq = false;
            this.cyt.setVisibility(0);
            this.cyu.setVisibility(8);
            return;
        }
        this.cyh = true;
        this.cyt.setVisibility(8);
        this.cyu.setVisibility(0);
    }

    public void jB(int i) {
        if (i == 0) {
            this.cyl = false;
            this.cxA.setText(d.l.sign);
            agv();
            return;
        }
        this.cyl = true;
        this.cxA.setText(d.l.signed);
        agu();
    }

    protected void agv() {
    }

    protected void agu() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void agB() {
        if (this.mMemberType != 0) {
            ai.c(this.cxR, d.g.icon_speed_orange);
        } else {
            ai.c(this.cxR, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cyg));
        if (this.cwJ >= 10000) {
            if (this.cwJ % 10000 == 0) {
                textView2.setText(this.aaS.getString(d.l.experience_divider) + String.valueOf(this.cwJ / 10000) + this.aaS.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.aaS.getString(d.l.experience_divider) + String.valueOf(this.cwJ / 10000.0f) + this.aaS.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aaS.getString(d.l.experience_divider) + String.valueOf(this.cwJ));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(List<com.baidu.tieba.tbadkCore.e> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.e> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.e next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void agk() {
    }

    public void jC(int i) {
        if (this.cyx != null) {
            this.cyx.setPadding(0, i, 0, k.g(this.aaS.getPageActivity(), d.f.ds20));
        }
    }
}

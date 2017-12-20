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
    private static HashMap<Integer, String> ddn = new HashMap<>();
    private static HashSet<Integer> ddo = new HashSet<>();
    protected TbPageContext abX;
    protected View bSV;
    protected View beq;
    public TextView cGz;
    protected com.baidu.tieba.frs.g cIy;
    protected k cOD;
    protected int daO;
    protected ImageView dcA;
    protected View dcB;
    protected ViewGroup dcC;
    protected TextView dcD;
    protected View dcE;
    protected ViewGroup dcF;
    protected TextView dcG;
    protected TextView dcH;
    protected TbImageView dcI;
    protected LinearLayout dcJ;
    protected bf dcK;
    protected bi dcL;
    protected PopupWindow dcM;
    protected View dcN;
    protected TextView dcO;
    protected TextView dcP;
    protected ImageView dcQ;
    protected PopupWindow dcR;
    protected BarImageView dcS;
    protected UserIconBox dcT;
    protected ArrayList<com.baidu.tbadk.core.data.g> dcU;
    protected com.baidu.tieba.frs.f.b dcV;
    protected f dcW;
    protected ai dcX;
    protected String dcY;
    protected String dcZ;
    protected TextView dcv;
    protected TextView dcw;
    protected TextView dcx;
    protected TextView dcy;
    protected TextView dcz;
    protected String dda;
    protected bd ddb;
    protected int ddc;
    protected int ddd;
    protected int dde;
    protected int ddf;
    protected boolean ddg;
    protected boolean ddh;
    protected boolean ddi;
    protected boolean ddj;
    protected boolean ddk;
    protected boolean ddl;
    protected float ddm;
    protected RelativeLayout dds;
    protected RelativeLayout ddt;
    protected View ddv;
    protected TextView ddw;
    protected RelativeLayout ddx;
    protected TextView ddy;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int dcr = 0;
    protected int dcs = 0;
    protected int dct = 0;
    private boolean ddp = false;
    protected HashSet<String> ddq = new HashSet<>();
    protected final Runnable ddr = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dcM != null && c.this.dcM.isShowing() && !c.this.ddh) {
                com.baidu.adp.lib.g.g.a(c.this.dcM, c.this.abX.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ddz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.f fVar;
            if ((c.this.abX == null || ax.aS(c.this.abX.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.f) && (fVar = (com.baidu.tieba.tbadkCore.f) view.getTag()) != null && !StringUtils.isNull(fVar.getUrl())) {
                String url = fVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(c.this.abX.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.vI().c(c.this.abX, new String[]{url});
                a.C0143a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.buL(), c.this.cIy.getForumId(), c.this.cIy.getForumName(), null);
                b.cg("obj_url", fVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, k kVar);

    public abstract void anu();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        ddn.put(1, "c0117");
        ddn.put(2, "c0124");
        ddn.put(3, "c0125");
        ddn.put(4, "c0126");
        ddn.put(5, "c0127");
    }

    public boolean arf() {
        return this.ddg;
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

    public boolean arg() {
        int[] iArr = new int[2];
        try {
            this.dcQ.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.beq;
    }

    public View arh() {
        return this.dcB;
    }

    public BarImageView ari() {
        return this.dcS;
    }

    public TextView arj() {
        return this.mTitleText;
    }

    public TextView ark() {
        return this.cGz;
    }

    public boolean aqV() {
        return this.ddk;
    }

    public void fF(boolean z) {
        this.ddj = z;
        if (this.ddj) {
            this.dcy.setVisibility(0);
        } else {
            this.dcy.setVisibility(4);
        }
    }

    public boolean aqW() {
        return this.ddl;
    }

    public void onDestory() {
        this.ddh = true;
        ddo.clear();
    }

    public void onStop() {
        arl();
    }

    public void fB(boolean z) {
        if (!z) {
            arl();
        }
    }

    private void arl() {
        if (this.dcR != null && this.dcR.isShowing()) {
            this.dcR.dismiss();
        }
        if (this.dcM != null && this.dcM.isShowing()) {
            this.dcM.dismiss();
        }
    }

    public void fG(boolean z) {
        this.ddi = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dcY = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ddg = false;
            this.ddp = false;
            this.dds.setVisibility(0);
            this.ddt.setVisibility(8);
            return;
        }
        this.ddg = true;
        this.dds.setVisibility(8);
        this.ddt.setVisibility(0);
        if (z && !this.ddp) {
            anv();
            this.ddp = true;
        }
        c(false, f);
    }

    protected void anv() {
    }

    public void li(int i) {
        if (i == 0) {
            this.ddg = false;
            this.ddp = false;
            this.dds.setVisibility(0);
            this.ddt.setVisibility(8);
            return;
        }
        this.ddg = true;
        this.dds.setVisibility(8);
        this.ddt.setVisibility(0);
    }

    public void lj(int i) {
        if (i == 0) {
            this.ddk = false;
            this.dcy.setText(d.j.sign);
            anq();
            return;
        }
        this.ddk = true;
        this.dcy.setText(d.j.signed);
        anp();
    }

    protected void anq() {
    }

    protected void anp() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void anw() {
        if (this.mMemberType != 0) {
            aj.c(this.dcQ, d.f.icon_speed_orange);
        } else {
            aj.c(this.dcQ, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ddf));
        if (this.daO >= 10000) {
            if (this.daO % 10000 == 0) {
                textView2.setText(this.abX.getString(d.j.experience_divider) + String.valueOf(this.daO / 10000) + this.abX.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.abX.getString(d.j.experience_divider) + String.valueOf(this.daO / 10000.0f) + this.abX.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.abX.getString(d.j.experience_divider) + String.valueOf(this.daO));
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

    public void ang() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.ddx != null) {
            this.ddx.setPadding(i, i2, i3, i4);
        }
    }
}

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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> dcg = new HashMap<>();
    private static HashSet<Integer> dch = new HashSet<>();
    protected TbPageContext acd;
    protected View bSR;
    protected View bep;
    public TextView cGr;
    protected com.baidu.tieba.frs.f cIp;
    protected k cOs;
    protected int daA;
    protected TextView dbA;
    protected TbImageView dbB;
    protected LinearLayout dbC;
    protected bf dbD;
    protected bi dbE;
    protected PopupWindow dbF;
    protected View dbG;
    protected TextView dbH;
    protected TextView dbI;
    protected ImageView dbJ;
    protected PopupWindow dbK;
    protected BarImageView dbL;
    protected UserIconBox dbM;
    protected ArrayList<com.baidu.tbadk.core.data.g> dbN;
    protected com.baidu.tieba.frs.f.b dbO;
    protected e dbP;
    protected ah dbQ;
    protected String dbR;
    protected String dbS;
    protected String dbT;
    protected bd dbU;
    protected int dbV;
    protected int dbW;
    protected int dbX;
    protected int dbY;
    protected boolean dbZ;
    protected TextView dbo;
    protected TextView dbp;
    protected TextView dbq;
    protected TextView dbr;
    protected TextView dbs;
    protected ImageView dbt;
    protected View dbu;
    protected ViewGroup dbv;
    protected TextView dbw;
    protected View dbx;
    protected ViewGroup dby;
    protected TextView dbz;
    protected boolean dca;
    protected boolean dcb;
    protected boolean dcc;
    protected boolean dcd;
    protected boolean dce;
    protected float dcf;
    protected RelativeLayout dcl;
    protected RelativeLayout dcm;
    protected View dcn;
    protected TextView dco;
    protected RelativeLayout dcp;
    protected TextView dcq;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int dbl = 0;
    protected int dbm = 0;
    protected int dbn = 0;
    private boolean dci = false;
    protected HashSet<String> dcj = new HashSet<>();
    protected final Runnable dck = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dbF != null && b.this.dbF.isShowing() && !b.this.dca) {
                com.baidu.adp.lib.g.g.a(b.this.dbF, b.this.acd.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dcr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.f fVar;
            if ((b.this.acd == null || ax.aV(b.this.acd.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.f) && (fVar = (com.baidu.tieba.tbadkCore.f) view.getTag()) != null && !StringUtils.isNull(fVar.getUrl())) {
                String url = fVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(b.this.acd.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.vL().c(b.this.acd, new String[]{url});
                a.C0128a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.bug(), b.this.cIp.getForumId(), b.this.cIp.getForumName(), null);
                b.cf("obj_url", fVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, k kVar);

    public abstract void anm();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        dcg.put(1, "c0117");
        dcg.put(2, "c0124");
        dcg.put(3, "c0125");
        dcg.put(4, "c0126");
        dcg.put(5, "c0127");
    }

    public boolean aqW() {
        return this.dbZ;
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

    public boolean aqX() {
        int[] iArr = new int[2];
        try {
            this.dbJ.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.bep;
    }

    public View aqY() {
        return this.dbu;
    }

    public BarImageView aqZ() {
        return this.dbL;
    }

    public TextView ara() {
        return this.mTitleText;
    }

    public TextView arb() {
        return this.cGr;
    }

    public boolean aqN() {
        return this.dcd;
    }

    public void fE(boolean z) {
        this.dcc = z;
        if (this.dcc) {
            this.dbr.setVisibility(0);
        } else {
            this.dbr.setVisibility(4);
        }
    }

    public boolean aqO() {
        return this.dce;
    }

    public void onDestory() {
        this.dca = true;
        dch.clear();
    }

    public void onStop() {
        arc();
    }

    public void fA(boolean z) {
        if (!z) {
            arc();
        }
    }

    private void arc() {
        if (this.dbK != null && this.dbK.isShowing()) {
            this.dbK.dismiss();
        }
        if (this.dbF != null && this.dbF.isShowing()) {
            this.dbF.dismiss();
        }
    }

    public void fF(boolean z) {
        this.dcb = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dbR = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dbZ = false;
            this.dci = false;
            this.dcl.setVisibility(0);
            this.dcm.setVisibility(8);
            return;
        }
        this.dbZ = true;
        this.dcl.setVisibility(8);
        this.dcm.setVisibility(0);
        if (z && !this.dci) {
            ann();
            this.dci = true;
        }
        c(false, f);
    }

    protected void ann() {
    }

    public void lb(int i) {
        if (i == 0) {
            this.dbZ = false;
            this.dci = false;
            this.dcl.setVisibility(0);
            this.dcm.setVisibility(8);
            return;
        }
        this.dbZ = true;
        this.dcl.setVisibility(8);
        this.dcm.setVisibility(0);
    }

    public void lc(int i) {
        if (i == 0) {
            this.dcd = false;
            this.dbr.setText(d.j.sign);
            ani();
            return;
        }
        this.dcd = true;
        this.dbr.setText(d.j.signed);
        anh();
    }

    protected void ani() {
    }

    protected void anh() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void ano() {
        if (this.mMemberType != 0) {
            aj.c(this.dbJ, d.f.icon_speed_orange);
        } else {
            aj.c(this.dbJ, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dbY));
        if (this.daA >= 10000) {
            if (this.daA % 10000 == 0) {
                textView2.setText(this.acd.getString(d.j.experience_divider) + String.valueOf(this.daA / 10000) + this.acd.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.acd.getString(d.j.experience_divider) + String.valueOf(this.daA / 10000.0f) + this.acd.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.acd.getString(d.j.experience_divider) + String.valueOf(this.daA));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(List<com.baidu.tieba.tbadkCore.f> list) {
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

    public void amY() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.dcp != null) {
            this.dcp.setPadding(i, i2, i3, i4);
        }
    }
}

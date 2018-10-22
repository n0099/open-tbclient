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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public abstract class b {
    private static HashMap<Integer, String> dYW = new HashMap<>();
    private static HashSet<Integer> dYX = new HashSet<>();
    protected FrsFragment dBO;
    protected int dVy;
    protected l dWh;
    protected BarImageView dYA;
    protected UserIconBox dYB;
    protected ArrayList<h> dYC;
    protected com.baidu.tieba.frs.f.b dYD;
    protected e dYE;
    protected ag dYF;
    protected String dYG;
    protected String dYH;
    protected String dYI;
    protected bb dYJ;
    protected int dYK;
    protected int dYL;
    protected int dYM;
    protected int dYN;
    protected boolean dYO;
    protected boolean dYP;
    protected boolean dYQ;
    protected boolean dYR;
    protected boolean dYS;
    protected boolean dYT;
    protected float dYU;
    protected TextView dYV;
    protected TextView dYc;
    protected TextView dYd;
    protected TextView dYe;
    protected TextView dYf;
    protected TextView dYg;
    protected ImageView dYh;
    protected ImageView dYi;
    protected View dYj;
    protected ViewGroup dYk;
    protected TextView dYl;
    protected View dYm;
    protected AdapterLinearLayout dYn;
    protected ViewGroup dYo;
    protected TextView dYp;
    protected TextView dYq;
    protected TbImageView dYr;
    protected LinearLayout dYs;
    protected bd dYt;
    protected bg dYu;
    protected View dYv;
    protected TextView dYw;
    protected TextView dYx;
    protected ImageView dYy;
    protected PopupWindow dYz;
    protected RelativeLayout dZb;
    protected RelativeLayout dZc;
    protected View dZd;
    protected TextView dZe;
    protected RelativeLayout dZf;
    protected TextView dZg;
    protected TextView dma;
    public TextView dzk;
    protected TbPageContext mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int dXZ = 0;
    protected int dYa = 0;
    protected int dYb = 0;
    private boolean dYY = false;
    protected HashSet<String> dYZ = new HashSet<>();
    protected final Runnable dZa = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dZh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bI(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.CU().c(b.this.mContext, new String[]{url});
                a.C0277a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bzS(), b.this.dBO.getForumId(), b.this.dBO.getForumName(), null);
                b.cH("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void aCq();

    public abstract void aCr();

    public abstract void aCy();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dYW.put(1, "c0117");
        dYW.put(2, "c0124");
        dYW.put(3, "c0125");
        dYW.put(4, "c0126");
        dYW.put(5, "c0127");
    }

    public boolean aGH() {
        return this.dYO;
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

    public boolean aGI() {
        int[] iArr = new int[2];
        try {
            this.dYy.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aGJ() {
        return this.dYj;
    }

    public View aCl() {
        return this.dYn;
    }

    public BarImageView aGK() {
        return this.dYA;
    }

    public TextView aGL() {
        return this.dma;
    }

    public TextView aGM() {
        return this.dzk;
    }

    public boolean aGf() {
        return this.dYR;
    }

    public void hm(boolean z) {
        this.dYQ = z;
        if (this.dYQ) {
            this.dYf.setVisibility(0);
        } else {
            this.dYf.setVisibility(4);
        }
    }

    public boolean aGg() {
        return this.dYS;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dYX.clear();
    }

    public void onStop() {
        aGN();
    }

    public void gj(boolean z) {
        if (!z) {
            aGN();
        }
    }

    private void aGN() {
        if (this.dYz != null && this.dYz.isShowing()) {
            this.dYz.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hn(boolean z) {
        this.dYP = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dYG = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dYO = false;
            this.dYY = false;
            this.dZb.setVisibility(0);
            this.dZc.setVisibility(8);
            return;
        }
        this.dYO = true;
        this.dZb.setVisibility(8);
        this.dZc.setVisibility(0);
        if (z && !this.dYY) {
            aCz();
            this.dYY = true;
        }
        d(false, f);
    }

    protected void aCz() {
    }

    public void ne(int i) {
        if (i == 0) {
            this.dYO = false;
            this.dYY = false;
            this.dZb.setVisibility(0);
            this.dZc.setVisibility(8);
            return;
        }
        this.dYO = true;
        this.dZb.setVisibility(8);
        this.dZc.setVisibility(0);
    }

    public void nf(int i) {
        if (i == 0) {
            this.dYR = false;
            this.dYf.setText(e.j.sign);
            aCu();
            return;
        }
        this.dYR = true;
        this.dYf.setText(e.j.signed);
        aCt();
    }

    protected void aCu() {
    }

    protected void aCt() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aCA() {
        if (this.mMemberType != 0) {
            al.c(this.dYy, e.f.icon_speed_orange);
        } else {
            al.c(this.dYy, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dYN));
        if (this.dVy >= 10000) {
            if (this.dVy % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVy / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVy / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVy));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bT(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void d(boolean z, float f) {
    }

    public void aCi() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dZf != null) {
            this.dZf.setPadding(i, i2, i3, i4);
        }
    }
}

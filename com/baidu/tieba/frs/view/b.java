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
    private static HashMap<Integer, String> dYV = new HashMap<>();
    private static HashSet<Integer> dYW = new HashSet<>();
    protected FrsFragment dBO;
    protected int dVx;
    protected l dWg;
    protected UserIconBox dYA;
    protected ArrayList<h> dYB;
    protected com.baidu.tieba.frs.f.b dYC;
    protected e dYD;
    protected ag dYE;
    protected String dYF;
    protected String dYG;
    protected String dYH;
    protected bb dYI;
    protected int dYJ;
    protected int dYK;
    protected int dYL;
    protected int dYM;
    protected boolean dYN;
    protected boolean dYO;
    protected boolean dYP;
    protected boolean dYQ;
    protected boolean dYR;
    protected boolean dYS;
    protected float dYT;
    protected TextView dYU;
    protected TextView dYb;
    protected TextView dYc;
    protected TextView dYd;
    protected TextView dYe;
    protected TextView dYf;
    protected ImageView dYg;
    protected ImageView dYh;
    protected View dYi;
    protected ViewGroup dYj;
    protected TextView dYk;
    protected View dYl;
    protected AdapterLinearLayout dYm;
    protected ViewGroup dYn;
    protected TextView dYo;
    protected TextView dYp;
    protected TbImageView dYq;
    protected LinearLayout dYr;
    protected bd dYs;
    protected bg dYt;
    protected View dYu;
    protected TextView dYv;
    protected TextView dYw;
    protected ImageView dYx;
    protected PopupWindow dYy;
    protected BarImageView dYz;
    protected RelativeLayout dZa;
    protected RelativeLayout dZb;
    protected View dZc;
    protected TextView dZd;
    protected RelativeLayout dZe;
    protected TextView dZf;
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
    protected int dXY = 0;
    protected int dXZ = 0;
    protected int dYa = 0;
    private boolean dYX = false;
    protected HashSet<String> dYY = new HashSet<>();
    protected final Runnable dYZ = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dZg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
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

    public abstract void aCp();

    public abstract void aCq();

    public abstract void aCx();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dYV.put(1, "c0117");
        dYV.put(2, "c0124");
        dYV.put(3, "c0125");
        dYV.put(4, "c0126");
        dYV.put(5, "c0127");
    }

    public boolean aGH() {
        return this.dYN;
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
            this.dYx.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aGJ() {
        return this.dYi;
    }

    public View aCk() {
        return this.dYm;
    }

    public BarImageView aGK() {
        return this.dYz;
    }

    public TextView aGL() {
        return this.dma;
    }

    public TextView aGM() {
        return this.dzk;
    }

    public boolean aGf() {
        return this.dYQ;
    }

    public void hm(boolean z) {
        this.dYP = z;
        if (this.dYP) {
            this.dYe.setVisibility(0);
        } else {
            this.dYe.setVisibility(4);
        }
    }

    public boolean aGg() {
        return this.dYR;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dYW.clear();
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
        if (this.dYy != null && this.dYy.isShowing()) {
            this.dYy.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hn(boolean z) {
        this.dYO = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dYF = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dYN = false;
            this.dYX = false;
            this.dZa.setVisibility(0);
            this.dZb.setVisibility(8);
            return;
        }
        this.dYN = true;
        this.dZa.setVisibility(8);
        this.dZb.setVisibility(0);
        if (z && !this.dYX) {
            aCy();
            this.dYX = true;
        }
        d(false, f);
    }

    protected void aCy() {
    }

    public void ne(int i) {
        if (i == 0) {
            this.dYN = false;
            this.dYX = false;
            this.dZa.setVisibility(0);
            this.dZb.setVisibility(8);
            return;
        }
        this.dYN = true;
        this.dZa.setVisibility(8);
        this.dZb.setVisibility(0);
    }

    public void nf(int i) {
        if (i == 0) {
            this.dYQ = false;
            this.dYe.setText(e.j.sign);
            aCt();
            return;
        }
        this.dYQ = true;
        this.dYe.setText(e.j.signed);
        aCs();
    }

    protected void aCt() {
    }

    protected void aCs() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aCz() {
        if (this.mMemberType != 0) {
            al.c(this.dYx, e.f.icon_speed_orange);
        } else {
            al.c(this.dYx, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dYM));
        if (this.dVx >= 10000) {
            if (this.dVx % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVx / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVx / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dVx));
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

    public void aCh() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dZe != null) {
            this.dZe.setPadding(i, i2, i3, i4);
        }
    }
}

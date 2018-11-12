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
    private static HashMap<Integer, String> eap = new HashMap<>();
    private static HashSet<Integer> eaq = new HashSet<>();
    public TextView dAB;
    protected FrsFragment dDf;
    protected int dWE;
    protected l dXn;
    protected ImageView dZA;
    protected ImageView dZB;
    protected View dZC;
    protected ViewGroup dZD;
    protected TextView dZE;
    protected View dZF;
    protected AdapterLinearLayout dZG;
    protected ViewGroup dZH;
    protected TextView dZI;
    protected TextView dZJ;
    protected TbImageView dZK;
    protected LinearLayout dZL;
    protected bd dZM;
    protected bg dZN;
    protected View dZO;
    protected TextView dZP;
    protected TextView dZQ;
    protected ImageView dZR;
    protected PopupWindow dZS;
    protected BarImageView dZT;
    protected UserIconBox dZU;
    protected ArrayList<h> dZV;
    protected com.baidu.tieba.frs.f.b dZW;
    protected e dZX;
    protected ag dZY;
    protected String dZZ;
    protected TextView dZv;
    protected TextView dZw;
    protected TextView dZx;
    protected TextView dZy;
    protected TextView dZz;
    protected TextView dne;
    protected String eaa;
    protected String eab;
    protected bb eac;
    protected int ead;
    protected int eae;
    protected int eaf;
    protected int eag;
    protected boolean eah;
    protected boolean eai;
    protected boolean eaj;
    protected boolean eak;
    protected boolean eal;
    protected boolean eam;
    protected float ean;
    protected TextView eao;
    protected RelativeLayout eau;
    protected RelativeLayout eav;
    protected View eaw;
    protected TextView eax;
    protected RelativeLayout eay;
    protected TextView eaz;
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
    protected int dZs = 0;
    protected int dZt = 0;
    protected int dZu = 0;
    private boolean ear = false;
    protected HashSet<String> eas = new HashSet<>();
    protected final Runnable eat = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener eaA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bG(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.Db().c(b.this.mContext, new String[]{url});
                a.C0305a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bzo(), b.this.dDf.getForumId(), b.this.dDf.getForumName(), null);
                b.cH("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void aBK();

    public abstract void aBL();

    public abstract void aBS();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void s(View.OnClickListener onClickListener);

    static {
        eap.put(1, "c0117");
        eap.put(2, "c0124");
        eap.put(3, "c0125");
        eap.put(4, "c0126");
        eap.put(5, "c0127");
    }

    public boolean aGf() {
        return this.eah;
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

    public boolean aGg() {
        int[] iArr = new int[2];
        try {
            this.dZR.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aGh() {
        return this.dZC;
    }

    public View aBF() {
        return this.dZG;
    }

    public BarImageView aGi() {
        return this.dZT;
    }

    public TextView aGj() {
        return this.dne;
    }

    public TextView aGk() {
        return this.dAB;
    }

    public boolean aFB() {
        return this.eak;
    }

    public void hw(boolean z) {
        this.eaj = z;
        if (this.eaj) {
            this.dZy.setVisibility(0);
        } else {
            this.dZy.setVisibility(4);
        }
    }

    public boolean aFC() {
        return this.eal;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        eaq.clear();
    }

    public void onStop() {
        aGl();
    }

    public void gt(boolean z) {
        if (!z) {
            aGl();
        }
    }

    private void aGl() {
        if (this.dZS != null && this.dZS.isShowing()) {
            this.dZS.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hx(boolean z) {
        this.eai = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dZZ = str;
        this.mLevel = i2;
        if (i == 0) {
            this.eah = false;
            this.ear = false;
            this.eau.setVisibility(0);
            this.eav.setVisibility(8);
            return;
        }
        this.eah = true;
        this.eau.setVisibility(8);
        this.eav.setVisibility(0);
        if (z && !this.ear) {
            aBT();
            this.ear = true;
        }
        d(false, f);
    }

    protected void aBT() {
    }

    public void nw(int i) {
        if (i == 0) {
            this.eah = false;
            this.ear = false;
            this.eau.setVisibility(0);
            this.eav.setVisibility(8);
            return;
        }
        this.eah = true;
        this.eau.setVisibility(8);
        this.eav.setVisibility(0);
    }

    public void nx(int i) {
        if (i == 0) {
            this.eak = false;
            this.dZy.setText(e.j.sign);
            aBO();
            return;
        }
        this.eak = true;
        this.dZy.setText(e.j.signed);
        aBN();
    }

    protected void aBO() {
    }

    protected void aBN() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aBU() {
        if (this.mMemberType != 0) {
            al.c(this.dZR, e.f.icon_speed_orange);
        } else {
            al.c(this.dZR, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.eag));
        if (this.dWE >= 10000) {
            if (this.dWE % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dWE / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dWE / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dWE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bR(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void aBC() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.eay != null) {
            this.eay.setPadding(i, i2, i3, i4);
        }
    }
}

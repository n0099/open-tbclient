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
    private static HashMap<Integer, String> egS = new HashMap<>();
    private static HashSet<Integer> egT = new HashSet<>();
    public TextView dHa;
    protected FrsFragment dJE;
    protected TextView dtG;
    protected l edR;
    protected int edi;
    protected TextView efY;
    protected TextView efZ;
    protected e egA;
    protected ag egB;
    protected String egC;
    protected String egD;
    protected String egE;
    protected bb egF;
    protected int egG;
    protected int egH;
    protected int egI;
    protected int egJ;
    protected boolean egK;
    protected boolean egL;
    protected boolean egM;
    protected boolean egN;
    protected boolean egO;
    protected boolean egP;
    protected float egQ;
    protected TextView egR;
    protected RelativeLayout egX;
    protected RelativeLayout egY;
    protected View egZ;
    protected TextView ega;
    protected TextView egb;
    protected TextView egc;
    protected ImageView egd;
    protected ImageView ege;
    protected View egf;
    protected ViewGroup egg;
    protected TextView egh;
    protected View egi;
    protected AdapterLinearLayout egj;
    protected ViewGroup egk;
    protected TextView egl;
    protected TextView egm;
    protected TbImageView egn;
    protected LinearLayout ego;
    protected bd egp;
    protected bg egq;
    protected View egr;
    protected TextView egs;
    protected TextView egt;
    protected ImageView egu;
    protected PopupWindow egv;
    protected BarImageView egw;
    protected UserIconBox egx;
    protected ArrayList<h> egy;
    protected com.baidu.tieba.frs.f.b egz;
    protected TextView eha;
    protected RelativeLayout ehb;
    protected TextView ehc;
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
    protected int efV = 0;
    protected int efW = 0;
    protected int efX = 0;
    private boolean egU = false;
    protected HashSet<String> egV = new HashSet<>();
    protected final Runnable egW = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ehd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bJ(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.Ef().c(b.this.mContext, new String[]{url});
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bBi(), b.this.dJE.getForumId(), b.this.dJE.getForumName(), null);
                b.cM("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void aDE();

    public abstract void aDw();

    public abstract void aDx();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void s(View.OnClickListener onClickListener);

    static {
        egS.put(1, "c0117");
        egS.put(2, "c0124");
        egS.put(3, "c0125");
        egS.put(4, "c0126");
        egS.put(5, "c0127");
    }

    public boolean aHR() {
        return this.egK;
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

    public boolean aHS() {
        int[] iArr = new int[2];
        try {
            this.egu.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aHT() {
        return this.egf;
    }

    public View aDr() {
        return this.egj;
    }

    public BarImageView aHU() {
        return this.egw;
    }

    public TextView aHV() {
        return this.dtG;
    }

    public TextView aHW() {
        return this.dHa;
    }

    public boolean aHn() {
        return this.egN;
    }

    public void hy(boolean z) {
        this.egM = z;
        if (this.egM) {
            this.egb.setVisibility(0);
        } else {
            this.egb.setVisibility(4);
        }
    }

    public boolean aHo() {
        return this.egO;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        egT.clear();
    }

    public void onStop() {
        aHX();
    }

    public void gu(boolean z) {
        if (!z) {
            aHX();
        }
    }

    private void aHX() {
        if (this.egv != null && this.egv.isShowing()) {
            this.egv.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hz(boolean z) {
        this.egL = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.egC = str;
        this.mLevel = i2;
        if (i == 0) {
            this.egK = false;
            this.egU = false;
            this.egX.setVisibility(0);
            this.egY.setVisibility(8);
            return;
        }
        this.egK = true;
        this.egX.setVisibility(8);
        this.egY.setVisibility(0);
        if (z && !this.egU) {
            aDF();
            this.egU = true;
        }
        d(false, f);
    }

    protected void aDF() {
    }

    public void nM(int i) {
        if (i == 0) {
            this.egK = false;
            this.egU = false;
            this.egX.setVisibility(0);
            this.egY.setVisibility(8);
            return;
        }
        this.egK = true;
        this.egX.setVisibility(8);
        this.egY.setVisibility(0);
    }

    public void nN(int i) {
        if (i == 0) {
            this.egN = false;
            this.egb.setText(e.j.sign);
            aDA();
            return;
        }
        this.egN = true;
        this.egb.setText(e.j.signed);
        aDz();
    }

    protected void aDA() {
    }

    protected void aDz() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aDG() {
        if (this.mMemberType != 0) {
            al.c(this.egu, e.f.icon_speed_orange);
        } else {
            al.c(this.egu, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.egJ));
        if (this.edi >= 10000) {
            if (this.edi % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.edi / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.edi / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.edi));
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

    public void aDm() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.ehb != null) {
            this.ehb.setPadding(i, i2, i3, i4);
        }
    }
}

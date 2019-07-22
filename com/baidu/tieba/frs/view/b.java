package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class b {
    private static HashMap<Integer, String> fUY = new HashMap<>();
    private static HashSet<Integer> fUZ = new HashSet<>();
    protected boolean aDP;
    protected TbImageView eVP;
    protected LinearGradientView fQc;
    protected FrsViewData fRO;
    protected int fRk;
    protected FrsTopView fUA;
    protected View fUB;
    protected TextView fUC;
    protected TextView fUD;
    protected ImageView fUE;
    protected PopupWindow fUF;
    protected BarImageView fUG;
    protected UserIconBox fUH;
    protected ArrayList<j> fUI;
    protected com.baidu.tieba.frs.f.b fUJ;
    protected String fUK;
    protected String fUL;
    protected String fUM;
    protected bg fUN;
    protected int fUO;
    protected int fUP;
    protected int fUQ;
    protected int fUR;
    protected boolean fUS;
    protected boolean fUT;
    protected boolean fUU;
    protected boolean fUV;
    protected boolean fUW;
    protected float fUX;
    protected TextView fUn;
    protected TextView fUo;
    protected TextView fUp;
    protected TextView fUq;
    protected TextView fUr;
    protected View fUs;
    protected TextView fUt;
    protected RelativeLayout fUu;
    protected RelativeLayout fUv;
    protected View fUw;
    protected TextView fUx;
    protected RelativeLayout fUy;
    protected RelativeLayout fUz;
    protected TextView ffr;
    protected ImageView fqF;
    protected ImageView fqG;
    protected TextView fsH;
    protected FrsFragment fvH;
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
    protected int fUk = 0;
    protected int fUl = 0;
    protected int fUm = 0;
    private boolean fVa = false;
    protected HashSet<String> fVb = new HashSet<>();
    protected final Runnable fVc = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void boF();

    public abstract void boQ();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void v(View.OnClickListener onClickListener);

    static {
        fUY.put(1, "c0117");
        fUY.put(2, "c0124");
        fUY.put(3, "c0125");
        fUY.put(4, "c0126");
        fUY.put(5, "c0127");
    }

    public boolean btu() {
        return this.fUS;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.2
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.2.1
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

    public boolean btv() {
        int[] iArr = new int[2];
        try {
            this.fUE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View btw() {
        return this.fUs;
    }

    public BarImageView btx() {
        return this.fUG;
    }

    public TextView bty() {
        return this.ffr;
    }

    public TextView btz() {
        return this.fsH;
    }

    public boolean bsD() {
        return this.fUU;
    }

    public void kX(boolean z) {
        this.fUT = z;
        this.fUq.setVisibility(this.fUT ? 0 : 4);
    }

    public boolean bsE() {
        return this.fUV;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fUZ.clear();
    }

    public void onStop() {
        btA();
    }

    public void jS(boolean z) {
        if (!z) {
            btA();
        }
    }

    private void btA() {
        if (this.fUF != null && this.fUF.isShowing()) {
            this.fUF.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kY(boolean z) {
        this.aDP = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fUK = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fUS = false;
            this.fVa = false;
            this.fUu.setVisibility(0);
            this.fUv.setVisibility(8);
            return;
        }
        this.fUS = true;
        this.fUu.setVisibility(8);
        this.fUv.setVisibility(0);
        if (z && !this.fVa) {
            boR();
            this.fVa = true;
        }
        d(false, f);
    }

    protected void boR() {
    }

    public void tn(int i) {
        if (i == 0) {
            this.fUS = false;
            this.fVa = false;
            this.fUu.setVisibility(0);
            this.fUv.setVisibility(8);
            return;
        }
        this.fUS = true;
        this.fUu.setVisibility(8);
        this.fUv.setVisibility(0);
    }

    public void to(int i) {
        if (i == 0) {
            this.fUU = false;
            this.fUq.setText(R.string.sign);
            boI();
            return;
        }
        this.fUU = true;
        this.fUq.setText(R.string.signed);
        boH();
    }

    protected void boI() {
    }

    protected void boH() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void boS() {
        if (this.mMemberType != 0) {
            am.c(this.fUE, (int) R.drawable.icon_speed_orange);
        } else {
            am.c(this.fUE, (int) R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fUR));
        if (this.fRk >= 10000) {
            if (this.fRk % 10000 == 0) {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRk / 10000) + this.mContext.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRk / 10000.0f) + this.mContext.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRk));
    }

    public void d(boolean z, float f) {
    }

    public void boN() {
    }

    public void b(s sVar) {
    }
}

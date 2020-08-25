package com.baidu.tieba.frs.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.i;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public abstract class b {
    private static HashMap<Integer, String> iyw = new HashMap<>();
    private static HashSet<Integer> iyx = new HashSet<>();
    protected TextView bpx;
    protected boolean cDD;
    protected TbPageContext efn;
    protected ImageView hPj;
    protected ImageView hPk;
    protected TextView hRo;
    protected FrsFragment hVk;
    protected LinearGradientView ist;
    protected TBSpecificationBtn itP;
    protected TBSpecificationBtn itW;
    protected int itZ;
    protected com.baidu.tieba.frs.vc.g ium;
    protected com.baidu.tieba.frs.vc.f iun;
    protected FrsViewData ivb;
    protected TextView ixI;
    protected TextView ixJ;
    protected TextView ixK;
    protected View ixL;
    protected TextView ixM;
    protected RelativeLayout ixN;
    protected RelativeLayout ixO;
    protected View ixP;
    protected TextView ixQ;
    protected RelativeLayout ixR;
    protected RelativeLayout ixS;
    protected TbImageView ixT;
    protected ServiceAreaView ixU;
    protected FrameLayout ixV;
    protected com.baidu.tieba.frs.ad.g ixW;
    protected FrsTopView ixX;
    protected View ixY;
    protected View ixZ;
    protected TextView iya;
    protected TextView iyb;
    protected ImageView iyc;
    protected PopupWindow iyd;
    protected BarImageView iye;
    protected UserIconBox iyf;
    protected ArrayList<i> iyg;
    protected com.baidu.tieba.frs.f.b iyh;
    protected String iyi;
    protected String iyj;
    protected String iyk;
    protected bw iyl;
    protected int iym;
    protected int iyn;
    protected int iyo;
    protected int iyp;
    protected boolean iyq;
    protected boolean iyr;
    protected boolean iys;
    protected boolean iyt;
    protected boolean iyu;
    protected float iyv;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int ixF = 0;
    protected int ixG = 0;
    protected int ixH = 0;
    private boolean iyy = false;
    protected HashSet<String> iyz = new HashSet<>();
    protected final Runnable iyA = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.efn.getPageActivity());
            }
        }
    };
    private float iyB = -1.0f;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void changeSkinType(int i);

    public abstract void cpC();

    public abstract void cpp();

    public abstract void k(View view, boolean z);

    static {
        iyw.put(1, "c0117");
        iyw.put(2, "c0124");
        iyw.put(3, "c0125");
        iyw.put(4, "c0126");
        iyw.put(5, "c0127");
    }

    public boolean cuA() {
        return this.iyq;
    }

    public void b(View view, float f, float f2) {
        if (f != f2) {
            view.setPivotX(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
            ofFloat.setDuration(1000L);
            ofFloat.start();
        }
    }

    public void c(final View view, float f, final float f2) {
        view.setPivotX(0.0f);
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.view.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener2 = new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.view.b.2.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, f2);
                        ofFloat.setDuration(300L);
                        ofFloat.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }
                };
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(animatorListener2);
                ofFloat.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addListener(animatorListener);
        ofFloat.start();
    }

    public boolean cuB() {
        int[] iArr = new int[2];
        try {
            this.iyc.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cuC() {
        return this.ixL;
    }

    public BarImageView cuD() {
        return this.iye;
    }

    public TextView cuE() {
        return this.bpx;
    }

    public TextView cuF() {
        return this.hRo;
    }

    public boolean ctC() {
        return this.iys;
    }

    public void pf(boolean z) {
        this.iyr = z;
        this.itW.setVisibility(this.iyr ? 0 : 4);
        if (this.ium != null) {
            this.ium.pf(z);
        }
    }

    public boolean ctD() {
        return this.iyt;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        iyx.clear();
    }

    public void onStop() {
        cuG();
    }

    public void bJ(boolean z) {
        if (!z) {
            cuG();
        }
    }

    private void cuG() {
        if (this.iyd != null && this.iyd.isShowing()) {
            this.iyd.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void po(boolean z) {
        this.cDD = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.iyi = str;
        this.mLevel = i2;
        if (i == 0) {
            this.iyq = false;
            this.iyy = false;
            this.ixN.setVisibility(0);
            this.ixO.setVisibility(8);
            return;
        }
        this.iyq = true;
        this.ixN.setVisibility(8);
        this.ixO.setVisibility(0);
        if (z && !this.iyy) {
            cpD();
            this.iyy = true;
        }
    }

    public void ap(float f) {
        c(false, f);
    }

    protected void cpD() {
    }

    public void zk(int i) {
        if (i == 0) {
            this.iyq = false;
            this.iyy = false;
            this.ixN.setVisibility(0);
            this.ixO.setVisibility(8);
            return;
        }
        this.iyq = true;
        this.ixN.setVisibility(8);
        this.ixO.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            zl(signData.is_signed);
            if (signData.forum_rank == -2) {
                pf(false);
                return;
            }
            pf(true);
            zl(signData.is_signed);
        }
    }

    public void zl(int i) {
        if (i == 0) {
            this.iys = false;
            this.itW.setText(this.efn.getString(R.string.sign));
            cps();
            return;
        }
        this.iys = true;
        this.itW.setText(this.efn.getString(R.string.signed));
        cpr();
    }

    protected void cps() {
    }

    protected void cpr() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cpE() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iyc, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.iyc, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.iyp));
        String string = this.efn.getString(R.string.experience_divider);
        String string2 = this.efn.getString(R.string.member_count_unit);
        if (this.itZ >= 10000) {
            if (this.itZ % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.itZ / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.itZ / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.itZ));
    }

    public void c(boolean z, float f) {
    }

    public void cpz() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.ium = gVar;
            this.ium.e(this.itW);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.iun = fVar;
            this.iun.e(this.itP);
        }
    }
}

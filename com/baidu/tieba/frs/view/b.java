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
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class b {
    private static HashMap<Integer, String> jQD = new HashMap<>();
    private static HashSet<Integer> jQE = new HashSet<>();
    protected TextView bMg;
    protected boolean dnP;
    protected TbPageContext eUY;
    protected FrsViewData jGJ;
    protected LinearGradientView jIY;
    protected TBSpecificationBtn jKE;
    protected int jKH;
    protected boolean jKJ;
    protected g jKW;
    protected f jKX;
    protected TBSpecificationBtn jKx;
    protected TextView jPN;
    protected TextView jPO;
    protected TextView jPP;
    protected View jPQ;
    protected TextView jPR;
    protected RelativeLayout jPS;
    protected RelativeLayout jPT;
    protected View jPU;
    protected TextView jPV;
    protected RelativeLayout jPW;
    protected RelativeLayout jPX;
    protected TbImageView jPY;
    protected ServiceAreaView jPZ;
    protected boolean jQA;
    protected boolean jQB;
    protected float jQC;
    protected FrameLayout jQa;
    protected com.baidu.tieba.frs.ad.g jQb;
    protected FrsTopView jQc;
    protected View jQd;
    protected View jQe;
    protected EMTextView jQf;
    protected View jQg;
    protected TextView jQh;
    protected TextView jQi;
    protected ImageView jQj;
    protected PopupWindow jQk;
    protected BarImageView jQl;
    protected UserIconBox jQm;
    protected ArrayList<k> jQn;
    protected com.baidu.tieba.frs.d.b jQo;
    protected String jQp;
    protected String jQq;
    protected String jQr;
    protected cb jQs;
    protected int jQt;
    protected int jQu;
    protected int jQv;
    protected int jQw;
    protected boolean jQx;
    protected boolean jQy;
    protected boolean jQz;
    protected ImageView jcR;
    protected ImageView jcS;
    protected TextView jeW;
    protected FrsFragment jiS;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected SignActivityInfo mSignActivityInfo;
    protected int jPK = 0;
    protected int jPL = 0;
    protected int jPM = 0;
    private boolean jQF = false;
    protected final Runnable jQG = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eUY.getPageActivity());
            }
        }
    };

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cGb();

    public abstract boolean cGm();

    public abstract SignActivityInfo cGn();

    public abstract void cGq();

    public abstract void cGr();

    public abstract void cGs();

    public abstract void cGt();

    public abstract void changeSkinType(int i);

    public abstract String getActivityId();

    public abstract void l(View view, boolean z);

    static {
        jQD.put(1, "c0117");
        jQD.put(2, "c0124");
        jQD.put(3, "c0125");
        jQD.put(4, "c0126");
        jQD.put(5, "c0127");
    }

    public boolean cNc() {
        return this.jQx;
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

    public boolean cNd() {
        int[] iArr = new int[2];
        try {
            this.jQj.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cNe() {
        return this.jPQ;
    }

    public BarImageView cNf() {
        return this.jQl;
    }

    public TextView cNg() {
        return this.bMg;
    }

    public TextView cNh() {
        return this.jeW;
    }

    public boolean cLz() {
        return this.jQz;
    }

    public void rC(boolean z) {
        this.jQy = z;
        if (this.jKW != null) {
            this.jKW.rC(z);
        }
    }

    public boolean cLA() {
        return this.jQA;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jQE.clear();
    }

    public void onStop() {
        cNi();
        cGs();
    }

    public void cb(boolean z) {
        if (!z) {
            cNi();
            cGs();
        }
    }

    private void cNi() {
        if (this.jQk != null && this.jQk.isShowing()) {
            this.jQk.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rL(boolean z) {
        this.dnP = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jQp = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jQx = false;
            this.jQF = false;
            this.jPS.setVisibility(0);
            this.jPT.setVisibility(8);
            this.jKx.setVisibility(0);
            this.jKE.setVisibility(8);
            return;
        }
        this.jQx = true;
        this.jPS.setVisibility(8);
        this.jPT.setVisibility(0);
        this.jKx.setVisibility(8);
        this.jKE.setVisibility(0);
        if (z && !this.jQF) {
            cGu();
            this.jQF = true;
        }
    }

    public void aM(float f) {
        c(false, f);
    }

    protected void cGu() {
    }

    public void Bc(int i) {
        if (i == 0) {
            this.jQx = false;
            this.jQF = false;
            this.jPS.setVisibility(0);
            this.jPT.setVisibility(8);
            this.jKx.setVisibility(0);
            this.jKE.setVisibility(8);
            return;
        }
        this.jQx = true;
        this.jPS.setVisibility(8);
        this.jPT.setVisibility(0);
        this.jKx.setVisibility(8);
        this.jKE.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Bd(signData.is_signed);
            if (signData.forum_rank == -2) {
                rC(false);
                return;
            }
            rC(true);
            Bd(signData.is_signed);
        }
    }

    public void Bd(int i) {
        if (i == 0) {
            this.jQz = false;
            this.jKE.setText(this.eUY.getString(R.string.sign));
            cGe();
            return;
        }
        this.jQz = true;
        this.jKE.setText(this.eUY.getString(R.string.signed));
        cGd();
    }

    protected void cGe() {
    }

    protected void cGd() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cGv() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jQj, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jQj, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jQw));
        String string = this.eUY.getString(R.string.experience_divider);
        String string2 = this.eUY.getString(R.string.member_count_unit);
        if (this.jKH >= 10000) {
            if (this.jKH % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jKH / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jKH / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jKH));
    }

    public void c(boolean z, float f) {
    }

    public void cGl() {
    }

    public void c(w wVar) {
    }

    public void i(g gVar) {
        if (gVar != null) {
            this.jKW = gVar;
            this.jKW.e(this.jKE);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.jKX = fVar;
            this.jKX.e(this.jKx);
        }
    }
}

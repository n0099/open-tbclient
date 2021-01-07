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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ao;
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
    private static HashMap<Integer, String> jNY = new HashMap<>();
    private static HashSet<Integer> jNZ = new HashSet<>();
    protected TextView bNi;
    protected boolean dqu;
    protected TbPageContext eXu;
    protected int fCN;
    protected FrsViewData jFx;
    protected LinearGradientView jHM;
    protected g jJK;
    protected f jJL;
    protected TBSpecificationBtn jJl;
    protected TBSpecificationBtn jJs;
    protected int jJv;
    protected boolean jJx;
    protected EMTextView jNA;
    protected View jNB;
    protected TextView jNC;
    protected TextView jND;
    protected ImageView jNE;
    protected PopupWindow jNF;
    protected BarImageView jNG;
    protected UserIconBox jNH;
    protected ArrayList<j> jNI;
    protected com.baidu.tieba.frs.d.b jNJ;
    protected String jNK;
    protected String jNL;
    protected String jNM;
    protected bz jNN;
    protected int jNO;
    protected int jNP;
    protected int jNQ;
    protected int jNR;
    protected boolean jNS;
    protected boolean jNT;
    protected boolean jNU;
    protected boolean jNV;
    protected boolean jNW;
    protected float jNX;
    protected TextView jNi;
    protected TextView jNj;
    protected TextView jNk;
    protected View jNl;
    protected TextView jNm;
    protected RelativeLayout jNn;
    protected RelativeLayout jNo;
    protected View jNp;
    protected TextView jNq;
    protected RelativeLayout jNr;
    protected RelativeLayout jNs;
    protected TbImageView jNt;
    protected ServiceAreaView jNu;
    protected FrameLayout jNv;
    protected com.baidu.tieba.frs.ad.g jNw;
    protected FrsTopView jNx;
    protected View jNy;
    protected View jNz;
    protected ImageView jbD;
    protected ImageView jbE;
    protected TextView jdI;
    protected FrsFragment jhE;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected SignActivityInfo mSignActivityInfo;
    protected int jNf = 0;
    protected int jNg = 0;
    protected int jNh = 0;
    private boolean jOa = false;
    protected final Runnable jOb = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eXu.getPageActivity());
            }
        }
    };

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract boolean cIK();

    public abstract SignActivityInfo cIL();

    public abstract void cIO();

    public abstract void cIP();

    public abstract void cIQ();

    public abstract void cIR();

    public abstract void cIz();

    public abstract void changeSkinType(int i);

    public abstract String getActivityId();

    public abstract void l(View view, boolean z);

    static {
        jNY.put(1, "c0117");
        jNY.put(2, "c0124");
        jNY.put(3, "c0125");
        jNY.put(4, "c0126");
        jNY.put(5, "c0127");
    }

    public boolean cOY() {
        return this.jNS;
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

    public boolean cOZ() {
        int[] iArr = new int[2];
        try {
            this.jNE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cPa() {
        return this.jNl;
    }

    public BarImageView cPb() {
        return this.jNG;
    }

    public TextView cPc() {
        return this.bNi;
    }

    public TextView cPd() {
        return this.jdI;
    }

    public boolean cNW() {
        return this.jNU;
    }

    public void rw(boolean z) {
        this.jNT = z;
        if (this.jJK != null) {
            this.jJK.rw(z);
        }
    }

    public boolean cNX() {
        return this.jNV;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jNZ.clear();
    }

    public void onStop() {
        cPe();
        cIQ();
    }

    public void ca(boolean z) {
        if (!z) {
            cPe();
            cIQ();
        }
    }

    private void cPe() {
        if (this.jNF != null && this.jNF.isShowing()) {
            this.jNF.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rF(boolean z) {
        this.dqu = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jNK = str;
        this.fCN = i2;
        if (i == 0) {
            this.jNS = false;
            this.jOa = false;
            this.jNn.setVisibility(0);
            this.jNo.setVisibility(8);
            this.jJl.setVisibility(0);
            this.jJs.setVisibility(8);
            return;
        }
        this.jNS = true;
        this.jNn.setVisibility(8);
        this.jNo.setVisibility(0);
        this.jJl.setVisibility(8);
        this.jJs.setVisibility(0);
        if (z && !this.jOa) {
            cIS();
            this.jOa = true;
        }
    }

    public void aJ(float f) {
        c(false, f);
    }

    protected void cIS() {
    }

    public void Ct(int i) {
        if (i == 0) {
            this.jNS = false;
            this.jOa = false;
            this.jNn.setVisibility(0);
            this.jNo.setVisibility(8);
            this.jJl.setVisibility(0);
            this.jJs.setVisibility(8);
            return;
        }
        this.jNS = true;
        this.jNn.setVisibility(8);
        this.jNo.setVisibility(0);
        this.jJl.setVisibility(8);
        this.jJs.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Cu(signData.is_signed);
            if (signData.forum_rank == -2) {
                rw(false);
                return;
            }
            rw(true);
            Cu(signData.is_signed);
        }
    }

    public void Cu(int i) {
        if (i == 0) {
            this.jNU = false;
            this.jJs.setText(this.eXu.getString(R.string.sign));
            cIC();
            return;
        }
        this.jNU = true;
        this.jJs.setText(this.eXu.getString(R.string.signed));
        cIB();
    }

    protected void cIC() {
    }

    protected void cIB() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cIT() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.jNE, R.drawable.icon_speed_orange);
        } else {
            ao.setImageResource(this.jNE, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jNR));
        String string = this.eXu.getString(R.string.experience_divider);
        String string2 = this.eXu.getString(R.string.member_count_unit);
        if (this.jJv >= 10000) {
            if (this.jJv % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jJv / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jJv / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jJv));
    }

    public void c(boolean z, float f) {
    }

    public void cIJ() {
    }

    public void c(w wVar) {
    }

    public void i(g gVar) {
        if (gVar != null) {
            this.jJK = gVar;
            this.jJK.e(this.jJs);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.jJL = fVar;
            this.jJL.e(this.jJl);
        }
    }
}

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
    private static HashMap<Integer, String> jQp = new HashMap<>();
    private static HashSet<Integer> jQq = new HashSet<>();
    protected TextView bMg;
    protected boolean dnP;
    protected TbPageContext eUY;
    protected FrsViewData jGv;
    protected LinearGradientView jIK;
    protected g jKI;
    protected f jKJ;
    protected TBSpecificationBtn jKj;
    protected TBSpecificationBtn jKq;
    protected int jKt;
    protected boolean jKv;
    protected TextView jPA;
    protected TextView jPB;
    protected View jPC;
    protected TextView jPD;
    protected RelativeLayout jPE;
    protected RelativeLayout jPF;
    protected View jPG;
    protected TextView jPH;
    protected RelativeLayout jPI;
    protected RelativeLayout jPJ;
    protected TbImageView jPK;
    protected ServiceAreaView jPL;
    protected FrameLayout jPM;
    protected com.baidu.tieba.frs.ad.g jPN;
    protected FrsTopView jPO;
    protected View jPP;
    protected View jPQ;
    protected EMTextView jPR;
    protected View jPS;
    protected TextView jPT;
    protected TextView jPU;
    protected ImageView jPV;
    protected PopupWindow jPW;
    protected BarImageView jPX;
    protected UserIconBox jPY;
    protected ArrayList<k> jPZ;
    protected TextView jPz;
    protected com.baidu.tieba.frs.d.b jQa;
    protected String jQb;
    protected String jQc;
    protected String jQd;
    protected cb jQe;
    protected int jQf;
    protected int jQg;
    protected int jQh;
    protected int jQi;
    protected boolean jQj;
    protected boolean jQk;
    protected boolean jQl;
    protected boolean jQm;
    protected boolean jQn;
    protected float jQo;
    protected ImageView jcD;
    protected ImageView jcE;
    protected TextView jeI;
    protected FrsFragment jiE;
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
    protected int jPw = 0;
    protected int jPx = 0;
    protected int jPy = 0;
    private boolean jQr = false;
    protected final Runnable jQs = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eUY.getPageActivity());
            }
        }
    };

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cFU();

    public abstract boolean cGf();

    public abstract SignActivityInfo cGg();

    public abstract void cGj();

    public abstract void cGk();

    public abstract void cGl();

    public abstract void cGm();

    public abstract void changeSkinType(int i);

    public abstract String getActivityId();

    public abstract void l(View view, boolean z);

    static {
        jQp.put(1, "c0117");
        jQp.put(2, "c0124");
        jQp.put(3, "c0125");
        jQp.put(4, "c0126");
        jQp.put(5, "c0127");
    }

    public boolean cMV() {
        return this.jQj;
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

    public boolean cMW() {
        int[] iArr = new int[2];
        try {
            this.jPV.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cMX() {
        return this.jPC;
    }

    public BarImageView cMY() {
        return this.jPX;
    }

    public TextView cMZ() {
        return this.bMg;
    }

    public TextView cNa() {
        return this.jeI;
    }

    public boolean cLs() {
        return this.jQl;
    }

    public void rC(boolean z) {
        this.jQk = z;
        if (this.jKI != null) {
            this.jKI.rC(z);
        }
    }

    public boolean cLt() {
        return this.jQm;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jQq.clear();
    }

    public void onStop() {
        cNb();
        cGl();
    }

    public void cb(boolean z) {
        if (!z) {
            cNb();
            cGl();
        }
    }

    private void cNb() {
        if (this.jPW != null && this.jPW.isShowing()) {
            this.jPW.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rL(boolean z) {
        this.dnP = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jQb = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jQj = false;
            this.jQr = false;
            this.jPE.setVisibility(0);
            this.jPF.setVisibility(8);
            this.jKj.setVisibility(0);
            this.jKq.setVisibility(8);
            return;
        }
        this.jQj = true;
        this.jPE.setVisibility(8);
        this.jPF.setVisibility(0);
        this.jKj.setVisibility(8);
        this.jKq.setVisibility(0);
        if (z && !this.jQr) {
            cGn();
            this.jQr = true;
        }
    }

    public void aM(float f) {
        c(false, f);
    }

    protected void cGn() {
    }

    public void Bc(int i) {
        if (i == 0) {
            this.jQj = false;
            this.jQr = false;
            this.jPE.setVisibility(0);
            this.jPF.setVisibility(8);
            this.jKj.setVisibility(0);
            this.jKq.setVisibility(8);
            return;
        }
        this.jQj = true;
        this.jPE.setVisibility(8);
        this.jPF.setVisibility(0);
        this.jKj.setVisibility(8);
        this.jKq.setVisibility(0);
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
            this.jQl = false;
            this.jKq.setText(this.eUY.getString(R.string.sign));
            cFX();
            return;
        }
        this.jQl = true;
        this.jKq.setText(this.eUY.getString(R.string.signed));
        cFW();
    }

    protected void cFX() {
    }

    protected void cFW() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cGo() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jPV, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jPV, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jQi));
        String string = this.eUY.getString(R.string.experience_divider);
        String string2 = this.eUY.getString(R.string.member_count_unit);
        if (this.jKt >= 10000) {
            if (this.jKt % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jKt / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jKt / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jKt));
    }

    public void c(boolean z, float f) {
    }

    public void cGe() {
    }

    public void c(w wVar) {
    }

    public void i(g gVar) {
        if (gVar != null) {
            this.jKI = gVar;
            this.jKI.e(this.jKq);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.jKJ = fVar;
            this.jKJ.e(this.jKj);
        }
    }
}

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
    private static HashMap<Integer, String> jJs = new HashMap<>();
    private static HashSet<Integer> jJt = new HashSet<>();
    protected TextView bIw;
    protected boolean dlE;
    protected TbPageContext eSJ;
    protected int fyf;
    protected ImageView iWW;
    protected ImageView iWX;
    protected TextView iZb;
    protected FrsViewData jAR;
    protected LinearGradientView jDg;
    protected TBSpecificationBtn jEF;
    protected TBSpecificationBtn jEM;
    protected int jEP;
    protected boolean jER;
    protected g jFe;
    protected f jFf;
    protected TextView jIC;
    protected TextView jID;
    protected TextView jIE;
    protected View jIF;
    protected TextView jIG;
    protected RelativeLayout jIH;
    protected RelativeLayout jII;
    protected View jIJ;
    protected TextView jIK;
    protected RelativeLayout jIL;
    protected RelativeLayout jIM;
    protected TbImageView jIN;
    protected ServiceAreaView jIO;
    protected FrameLayout jIP;
    protected com.baidu.tieba.frs.ad.g jIQ;
    protected FrsTopView jIR;
    protected View jIS;
    protected View jIT;
    protected EMTextView jIU;
    protected View jIV;
    protected TextView jIW;
    protected TextView jIX;
    protected ImageView jIY;
    protected PopupWindow jIZ;
    protected BarImageView jJa;
    protected UserIconBox jJb;
    protected ArrayList<j> jJc;
    protected com.baidu.tieba.frs.d.b jJd;
    protected String jJe;
    protected String jJf;
    protected String jJg;
    protected bz jJh;
    protected int jJi;
    protected int jJj;
    protected int jJk;
    protected int jJl;
    protected boolean jJm;
    protected boolean jJn;
    protected boolean jJo;
    protected boolean jJp;
    protected boolean jJq;
    protected float jJr;
    protected FrsFragment jcX;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected SignActivityInfo mSignActivityInfo;
    protected int jIz = 0;
    protected int jIA = 0;
    protected int jIB = 0;
    private boolean jJu = false;
    protected final Runnable jJv = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eSJ.getPageActivity());
            }
        }
    };

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cEH();

    public abstract boolean cES();

    public abstract SignActivityInfo cET();

    public abstract void cEW();

    public abstract void cEX();

    public abstract void cEY();

    public abstract void cEZ();

    public abstract void changeSkinType(int i);

    public abstract String getActivityId();

    public abstract void l(View view, boolean z);

    static {
        jJs.put(1, "c0117");
        jJs.put(2, "c0124");
        jJs.put(3, "c0125");
        jJs.put(4, "c0126");
        jJs.put(5, "c0127");
    }

    public boolean cLg() {
        return this.jJm;
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

    public boolean cLh() {
        int[] iArr = new int[2];
        try {
            this.jIY.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cLi() {
        return this.jIF;
    }

    public BarImageView cLj() {
        return this.jJa;
    }

    public TextView cLk() {
        return this.bIw;
    }

    public TextView cLl() {
        return this.iZb;
    }

    public boolean cKe() {
        return this.jJo;
    }

    public void rs(boolean z) {
        this.jJn = z;
        if (this.jFe != null) {
            this.jFe.rs(z);
        }
    }

    public boolean cKf() {
        return this.jJp;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jJt.clear();
    }

    public void onStop() {
        cLm();
        cEY();
    }

    public void bW(boolean z) {
        if (!z) {
            cLm();
            cEY();
        }
    }

    private void cLm() {
        if (this.jIZ != null && this.jIZ.isShowing()) {
            this.jIZ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rB(boolean z) {
        this.dlE = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jJe = str;
        this.fyf = i2;
        if (i == 0) {
            this.jJm = false;
            this.jJu = false;
            this.jIH.setVisibility(0);
            this.jII.setVisibility(8);
            this.jEF.setVisibility(0);
            this.jEM.setVisibility(8);
            return;
        }
        this.jJm = true;
        this.jIH.setVisibility(8);
        this.jII.setVisibility(0);
        this.jEF.setVisibility(8);
        this.jEM.setVisibility(0);
        if (z && !this.jJu) {
            cFa();
            this.jJu = true;
        }
    }

    public void aJ(float f) {
        c(false, f);
    }

    protected void cFa() {
    }

    public void AN(int i) {
        if (i == 0) {
            this.jJm = false;
            this.jJu = false;
            this.jIH.setVisibility(0);
            this.jII.setVisibility(8);
            this.jEF.setVisibility(0);
            this.jEM.setVisibility(8);
            return;
        }
        this.jJm = true;
        this.jIH.setVisibility(8);
        this.jII.setVisibility(0);
        this.jEF.setVisibility(8);
        this.jEM.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            AO(signData.is_signed);
            if (signData.forum_rank == -2) {
                rs(false);
                return;
            }
            rs(true);
            AO(signData.is_signed);
        }
    }

    public void AO(int i) {
        if (i == 0) {
            this.jJo = false;
            this.jEM.setText(this.eSJ.getString(R.string.sign));
            cEK();
            return;
        }
        this.jJo = true;
        this.jEM.setText(this.eSJ.getString(R.string.signed));
        cEJ();
    }

    protected void cEK() {
    }

    protected void cEJ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cFb() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.jIY, R.drawable.icon_speed_orange);
        } else {
            ao.setImageResource(this.jIY, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jJl));
        String string = this.eSJ.getString(R.string.experience_divider);
        String string2 = this.eSJ.getString(R.string.member_count_unit);
        if (this.jEP >= 10000) {
            if (this.jEP % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jEP / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jEP / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jEP));
    }

    public void c(boolean z, float f) {
    }

    public void cER() {
    }

    public void c(w wVar) {
    }

    public void i(g gVar) {
        if (gVar != null) {
            this.jFe = gVar;
            this.jFe.e(this.jEM);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.jFf = fVar;
            this.jFf.e(this.jEF);
        }
    }
}

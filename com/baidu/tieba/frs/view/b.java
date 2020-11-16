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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.j;
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
/* loaded from: classes21.dex */
public abstract class b {
    private static HashMap<Integer, String> jnU = new HashMap<>();
    private static HashSet<Integer> jnV = new HashSet<>();
    protected TextView bDl;
    protected boolean dex;
    protected TbPageContext eGu;
    protected ImageView iEx;
    protected ImageView iEy;
    protected TextView iGC;
    protected FrsFragment iKx;
    protected FrsViewData jfx;
    protected LinearGradientView jhM;
    protected com.baidu.tieba.frs.vc.g jjJ;
    protected com.baidu.tieba.frs.vc.f jjK;
    protected TBSpecificationBtn jjm;
    protected TBSpecificationBtn jjt;
    protected int jjw;
    protected ImageView jnA;
    protected PopupWindow jnB;
    protected BarImageView jnC;
    protected UserIconBox jnD;
    protected ArrayList<j> jnE;
    protected com.baidu.tieba.frs.f.b jnF;
    protected String jnG;
    protected String jnH;
    protected String jnI;
    protected bx jnJ;
    protected int jnK;
    protected int jnL;
    protected int jnM;
    protected int jnN;
    protected boolean jnO;
    protected boolean jnP;
    protected boolean jnQ;
    protected boolean jnR;
    protected boolean jnS;
    protected float jnT;
    protected TextView jnf;
    protected TextView jng;
    protected TextView jnh;
    protected View jni;
    protected TextView jnj;
    protected RelativeLayout jnk;
    protected RelativeLayout jnl;
    protected View jnm;
    protected TextView jnn;
    protected RelativeLayout jno;
    protected RelativeLayout jnp;
    protected TbImageView jnq;
    protected ServiceAreaView jnr;
    protected FrameLayout jns;
    protected com.baidu.tieba.frs.ad.g jnt;
    protected FrsTopView jnu;
    protected View jnv;
    protected View jnw;
    protected View jnx;
    protected TextView jny;
    protected TextView jnz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int jnc = 0;
    protected int jnd = 0;
    protected int jne = 0;
    private boolean jnW = false;
    protected final Runnable jnX = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eGu.getPageActivity());
            }
        }
    };

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cBl();

    public abstract void cBy();

    public abstract void changeSkinType(int i);

    public abstract void m(View view, boolean z);

    static {
        jnU.put(1, "c0117");
        jnU.put(2, "c0124");
        jnU.put(3, "c0125");
        jnU.put(4, "c0126");
        jnU.put(5, "c0127");
    }

    public boolean cGE() {
        return this.jnO;
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

    public boolean cGF() {
        int[] iArr = new int[2];
        try {
            this.jnA.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cGG() {
        return this.jni;
    }

    public BarImageView cGH() {
        return this.jnC;
    }

    public TextView cGI() {
        return this.bDl;
    }

    public TextView cGJ() {
        return this.iGC;
    }

    public boolean cFE() {
        return this.jnQ;
    }

    public void qw(boolean z) {
        this.jnP = z;
        if (this.jjJ != null) {
            this.jjJ.qw(z);
        }
    }

    public boolean cFF() {
        return this.jnR;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jnV.clear();
    }

    public void onStop() {
        cGK();
    }

    public void bS(boolean z) {
        if (!z) {
            cGK();
        }
    }

    private void cGK() {
        if (this.jnB != null && this.jnB.isShowing()) {
            this.jnB.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void qF(boolean z) {
        this.dex = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jnG = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jnO = false;
            this.jnW = false;
            this.jnk.setVisibility(0);
            this.jnl.setVisibility(8);
            this.jjm.setVisibility(0);
            this.jjt.setVisibility(8);
            return;
        }
        this.jnO = true;
        this.jnk.setVisibility(8);
        this.jnl.setVisibility(0);
        this.jjm.setVisibility(8);
        this.jjt.setVisibility(0);
        if (z && !this.jnW) {
            cBz();
            this.jnW = true;
        }
    }

    public void aG(float f) {
        c(false, f);
    }

    protected void cBz() {
    }

    public void Bs(int i) {
        if (i == 0) {
            this.jnO = false;
            this.jnW = false;
            this.jnk.setVisibility(0);
            this.jnl.setVisibility(8);
            this.jjm.setVisibility(0);
            this.jjt.setVisibility(8);
            return;
        }
        this.jnO = true;
        this.jnk.setVisibility(8);
        this.jnl.setVisibility(0);
        this.jjm.setVisibility(8);
        this.jjt.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Bt(signData.is_signed);
            if (signData.forum_rank == -2) {
                qw(false);
                return;
            }
            qw(true);
            Bt(signData.is_signed);
        }
    }

    public void Bt(int i) {
        if (i == 0) {
            this.jnQ = false;
            this.jjt.setText(this.eGu.getString(R.string.sign));
            cBo();
            return;
        }
        this.jnQ = true;
        this.jjt.setText(this.eGu.getString(R.string.signed));
        cBn();
    }

    protected void cBo() {
    }

    protected void cBn() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cBA() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jnA, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jnA, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jnN));
        String string = this.eGu.getString(R.string.experience_divider);
        String string2 = this.eGu.getString(R.string.member_count_unit);
        if (this.jjw >= 10000) {
            if (this.jjw % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jjw / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jjw / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jjw));
    }

    public void c(boolean z, float f) {
    }

    public void cBv() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.jjJ = gVar;
            this.jjJ.e(this.jjt);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.jjK = fVar;
            this.jjK.e(this.jjm);
        }
    }
}

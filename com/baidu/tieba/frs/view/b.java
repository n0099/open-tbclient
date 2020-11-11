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
/* loaded from: classes22.dex */
public abstract class b {
    private static HashMap<Integer, String> jnj = new HashMap<>();
    private static HashSet<Integer> jnk = new HashSet<>();
    protected TextView bEW;
    protected boolean dge;
    protected TbPageContext eIc;
    protected ImageView iDJ;
    protected ImageView iDK;
    protected TextView iFO;
    protected FrsFragment iJK;
    protected LinearGradientView jhb;
    protected TBSpecificationBtn jiB;
    protected TBSpecificationBtn jiI;
    protected int jiL;
    protected com.baidu.tieba.frs.vc.g jiY;
    protected com.baidu.tieba.frs.vc.f jiZ;
    protected FrsViewData jjN;
    protected RelativeLayout jmA;
    protected RelativeLayout jmB;
    protected View jmC;
    protected TextView jmD;
    protected RelativeLayout jmE;
    protected RelativeLayout jmF;
    protected TbImageView jmG;
    protected ServiceAreaView jmH;
    protected FrameLayout jmI;
    protected com.baidu.tieba.frs.ad.g jmJ;
    protected FrsTopView jmK;
    protected View jmL;
    protected View jmM;
    protected TextView jmN;
    protected TextView jmO;
    protected ImageView jmP;
    protected PopupWindow jmQ;
    protected BarImageView jmR;
    protected UserIconBox jmS;
    protected ArrayList<i> jmT;
    protected com.baidu.tieba.frs.f.b jmU;
    protected String jmV;
    protected String jmW;
    protected String jmX;
    protected bw jmY;
    protected int jmZ;
    protected TextView jmv;
    protected TextView jmw;
    protected TextView jmx;
    protected View jmy;
    protected TextView jmz;
    protected int jna;
    protected int jnb;
    protected int jnc;
    protected boolean jnd;
    protected boolean jne;
    protected boolean jnf;
    protected boolean jng;
    protected boolean jnh;
    protected float jni;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int jms = 0;
    protected int jmt = 0;
    protected int jmu = 0;
    private boolean jnl = false;
    protected HashSet<String> jnm = new HashSet<>();
    protected final Runnable jnn = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eIc.getPageActivity());
            }
        }
    };
    private float jno = -1.0f;

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cBI();

    public abstract void cBV();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    static {
        jnj.put(1, "c0117");
        jnj.put(2, "c0124");
        jnj.put(3, "c0125");
        jnj.put(4, "c0126");
        jnj.put(5, "c0127");
    }

    public boolean cGZ() {
        return this.jnd;
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

    public boolean cHa() {
        int[] iArr = new int[2];
        try {
            this.jmP.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cHb() {
        return this.jmy;
    }

    public BarImageView cHc() {
        return this.jmR;
    }

    public TextView cHd() {
        return this.bEW;
    }

    public TextView cHe() {
        return this.iFO;
    }

    public boolean cFZ() {
        return this.jnf;
    }

    public void qt(boolean z) {
        this.jne = z;
        this.jiI.setVisibility(this.jne ? 0 : 4);
        if (this.jiY != null) {
            this.jiY.qt(z);
        }
    }

    public boolean cGa() {
        return this.jng;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jnk.clear();
    }

    public void onStop() {
        cHf();
    }

    public void bQ(boolean z) {
        if (!z) {
            cHf();
        }
    }

    private void cHf() {
        if (this.jmQ != null && this.jmQ.isShowing()) {
            this.jmQ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void qC(boolean z) {
        this.dge = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jmV = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jnd = false;
            this.jnl = false;
            this.jmA.setVisibility(0);
            this.jmB.setVisibility(8);
            return;
        }
        this.jnd = true;
        this.jmA.setVisibility(8);
        this.jmB.setVisibility(0);
        if (z && !this.jnl) {
            cBW();
            this.jnl = true;
        }
    }

    public void az(float f) {
        c(false, f);
    }

    protected void cBW() {
    }

    public void AU(int i) {
        if (i == 0) {
            this.jnd = false;
            this.jnl = false;
            this.jmA.setVisibility(0);
            this.jmB.setVisibility(8);
            return;
        }
        this.jnd = true;
        this.jmA.setVisibility(8);
        this.jmB.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            AV(signData.is_signed);
            if (signData.forum_rank == -2) {
                qt(false);
                return;
            }
            qt(true);
            AV(signData.is_signed);
        }
    }

    public void AV(int i) {
        if (i == 0) {
            this.jnf = false;
            this.jiI.setText(this.eIc.getString(R.string.sign));
            cBL();
            return;
        }
        this.jnf = true;
        this.jiI.setText(this.eIc.getString(R.string.signed));
        cBK();
    }

    protected void cBL() {
    }

    protected void cBK() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cBX() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jmP, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jmP, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jnc));
        String string = this.eIc.getString(R.string.experience_divider);
        String string2 = this.eIc.getString(R.string.member_count_unit);
        if (this.jiL >= 10000) {
            if (this.jiL % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jiL / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jiL / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jiL));
    }

    public void c(boolean z, float f) {
    }

    public void cBS() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.jiY = gVar;
            this.jiY.e(this.jiI);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.jiZ = fVar;
            this.jiZ.e(this.jiB);
        }
    }
}

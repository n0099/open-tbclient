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
    private static HashMap<Integer, String> jhk = new HashMap<>();
    private static HashSet<Integer> jhl = new HashSet<>();
    protected TextView byL;
    protected boolean dah;
    protected TbPageContext eCn;
    protected FrsFragment iDN;
    protected ImageView ixM;
    protected ImageView ixN;
    protected TextView izR;
    protected LinearGradientView jbe;
    protected TBSpecificationBtn jcD;
    protected TBSpecificationBtn jcK;
    protected int jcN;
    protected FrsViewData jdP;
    protected com.baidu.tieba.frs.vc.g jda;
    protected com.baidu.tieba.frs.vc.f jdb;
    protected TextView jgA;
    protected RelativeLayout jgB;
    protected RelativeLayout jgC;
    protected View jgD;
    protected TextView jgE;
    protected RelativeLayout jgF;
    protected RelativeLayout jgG;
    protected TbImageView jgH;
    protected ServiceAreaView jgI;
    protected FrameLayout jgJ;
    protected com.baidu.tieba.frs.ad.g jgK;
    protected FrsTopView jgL;
    protected View jgM;
    protected View jgN;
    protected TextView jgO;
    protected TextView jgP;
    protected ImageView jgQ;
    protected PopupWindow jgR;
    protected BarImageView jgS;
    protected UserIconBox jgT;
    protected ArrayList<i> jgU;
    protected com.baidu.tieba.frs.f.b jgV;
    protected String jgW;
    protected String jgX;
    protected String jgY;
    protected bw jgZ;
    protected TextView jgw;
    protected TextView jgx;
    protected TextView jgy;
    protected View jgz;
    protected int jha;
    protected int jhb;
    protected int jhc;
    protected int jhd;
    protected boolean jhe;
    protected boolean jhf;
    protected boolean jhg;
    protected boolean jhh;
    protected boolean jhi;
    protected float jhj;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int jgt = 0;
    protected int jgu = 0;
    protected int jgv = 0;
    private boolean jhm = false;
    protected HashSet<String> jhn = new HashSet<>();
    protected final Runnable jho = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eCn.getPageActivity());
            }
        }
    };
    private float jhp = -1.0f;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void changeSkinType(int i);

    public abstract void czh();

    public abstract void czu();

    public abstract void k(View view, boolean z);

    static {
        jhk.put(1, "c0117");
        jhk.put(2, "c0124");
        jhk.put(3, "c0125");
        jhk.put(4, "c0126");
        jhk.put(5, "c0127");
    }

    public boolean cEy() {
        return this.jhe;
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

    public boolean cEz() {
        int[] iArr = new int[2];
        try {
            this.jgQ.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cEA() {
        return this.jgz;
    }

    public BarImageView cEB() {
        return this.jgS;
    }

    public TextView cEC() {
        return this.byL;
    }

    public TextView cED() {
        return this.izR;
    }

    public boolean cDy() {
        return this.jhg;
    }

    public void qk(boolean z) {
        this.jhf = z;
        this.jcK.setVisibility(this.jhf ? 0 : 4);
        if (this.jda != null) {
            this.jda.qk(z);
        }
    }

    public boolean cDz() {
        return this.jhh;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jhl.clear();
    }

    public void onStop() {
        cEE();
    }

    public void bP(boolean z) {
        if (!z) {
            cEE();
        }
    }

    private void cEE() {
        if (this.jgR != null && this.jgR.isShowing()) {
            this.jgR.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void qt(boolean z) {
        this.dah = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jgW = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jhe = false;
            this.jhm = false;
            this.jgB.setVisibility(0);
            this.jgC.setVisibility(8);
            return;
        }
        this.jhe = true;
        this.jgB.setVisibility(8);
        this.jgC.setVisibility(0);
        if (z && !this.jhm) {
            czv();
            this.jhm = true;
        }
    }

    public void ax(float f) {
        c(false, f);
    }

    protected void czv() {
    }

    public void AH(int i) {
        if (i == 0) {
            this.jhe = false;
            this.jhm = false;
            this.jgB.setVisibility(0);
            this.jgC.setVisibility(8);
            return;
        }
        this.jhe = true;
        this.jgB.setVisibility(8);
        this.jgC.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            AI(signData.is_signed);
            if (signData.forum_rank == -2) {
                qk(false);
                return;
            }
            qk(true);
            AI(signData.is_signed);
        }
    }

    public void AI(int i) {
        if (i == 0) {
            this.jhg = false;
            this.jcK.setText(this.eCn.getString(R.string.sign));
            czk();
            return;
        }
        this.jhg = true;
        this.jcK.setText(this.eCn.getString(R.string.signed));
        czj();
    }

    protected void czk() {
    }

    protected void czj() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void czw() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jgQ, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jgQ, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jhd));
        String string = this.eCn.getString(R.string.experience_divider);
        String string2 = this.eCn.getString(R.string.member_count_unit);
        if (this.jcN >= 10000) {
            if (this.jcN % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jcN / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jcN / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jcN));
    }

    public void c(boolean z, float f) {
    }

    public void czr() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.jda = gVar;
            this.jda.e(this.jcK);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.jdb = fVar;
            this.jdb.e(this.jcD);
        }
    }
}

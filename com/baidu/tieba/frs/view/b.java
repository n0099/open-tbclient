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
    private static HashMap<Integer, String> iUO = new HashMap<>();
    private static HashSet<Integer> iUP = new HashSet<>();
    protected TextView bwx;
    protected boolean cRL;
    protected TbPageContext etO;
    protected LinearGradientView iOI;
    protected com.baidu.tieba.frs.vc.g iQE;
    protected com.baidu.tieba.frs.vc.f iQF;
    protected TBSpecificationBtn iQh;
    protected TBSpecificationBtn iQo;
    protected int iQr;
    protected FrsViewData iRt;
    protected String iUA;
    protected String iUB;
    protected String iUC;
    protected bw iUD;
    protected int iUE;
    protected int iUF;
    protected int iUG;
    protected int iUH;
    protected boolean iUI;
    protected boolean iUJ;
    protected boolean iUK;
    protected boolean iUL;
    protected boolean iUM;
    protected float iUN;
    protected TextView iUa;
    protected TextView iUb;
    protected TextView iUc;
    protected View iUd;
    protected TextView iUe;
    protected RelativeLayout iUf;
    protected RelativeLayout iUg;
    protected View iUh;
    protected TextView iUi;
    protected RelativeLayout iUj;
    protected RelativeLayout iUk;
    protected TbImageView iUl;
    protected ServiceAreaView iUm;
    protected FrameLayout iUn;
    protected com.baidu.tieba.frs.ad.g iUo;
    protected FrsTopView iUp;
    protected View iUq;
    protected View iUr;
    protected TextView iUs;
    protected TextView iUt;
    protected ImageView iUu;
    protected PopupWindow iUv;
    protected BarImageView iUw;
    protected UserIconBox iUx;
    protected ArrayList<i> iUy;
    protected com.baidu.tieba.frs.f.b iUz;
    protected ImageView ilo;
    protected ImageView ilp;
    protected TextView inv;
    protected FrsFragment irr;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int iTX = 0;
    protected int iTY = 0;
    protected int iTZ = 0;
    private boolean iUQ = false;
    protected HashSet<String> iUR = new HashSet<>();
    protected final Runnable iUS = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.etO.getPageActivity());
            }
        }
    };
    private float iUT = -1.0f;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void changeSkinType(int i);

    public abstract void cwa();

    public abstract void cwn();

    public abstract void k(View view, boolean z);

    static {
        iUO.put(1, "c0117");
        iUO.put(2, "c0124");
        iUO.put(3, "c0125");
        iUO.put(4, "c0126");
        iUO.put(5, "c0127");
    }

    public boolean cBr() {
        return this.iUI;
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

    public boolean cBs() {
        int[] iArr = new int[2];
        try {
            this.iUu.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cBt() {
        return this.iUd;
    }

    public BarImageView cBu() {
        return this.iUw;
    }

    public TextView cBv() {
        return this.bwx;
    }

    public TextView cBw() {
        return this.inv;
    }

    public boolean cAr() {
        return this.iUK;
    }

    public void pS(boolean z) {
        this.iUJ = z;
        this.iQo.setVisibility(this.iUJ ? 0 : 4);
        if (this.iQE != null) {
            this.iQE.pS(z);
        }
    }

    public boolean cAs() {
        return this.iUL;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        iUP.clear();
    }

    public void onStop() {
        cBx();
    }

    public void bO(boolean z) {
        if (!z) {
            cBx();
        }
    }

    private void cBx() {
        if (this.iUv != null && this.iUv.isShowing()) {
            this.iUv.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void qb(boolean z) {
        this.cRL = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.iUA = str;
        this.mLevel = i2;
        if (i == 0) {
            this.iUI = false;
            this.iUQ = false;
            this.iUf.setVisibility(0);
            this.iUg.setVisibility(8);
            return;
        }
        this.iUI = true;
        this.iUf.setVisibility(8);
        this.iUg.setVisibility(0);
        if (z && !this.iUQ) {
            cwo();
            this.iUQ = true;
        }
    }

    public void av(float f) {
        c(false, f);
    }

    protected void cwo() {
    }

    public void Ao(int i) {
        if (i == 0) {
            this.iUI = false;
            this.iUQ = false;
            this.iUf.setVisibility(0);
            this.iUg.setVisibility(8);
            return;
        }
        this.iUI = true;
        this.iUf.setVisibility(8);
        this.iUg.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Ap(signData.is_signed);
            if (signData.forum_rank == -2) {
                pS(false);
                return;
            }
            pS(true);
            Ap(signData.is_signed);
        }
    }

    public void Ap(int i) {
        if (i == 0) {
            this.iUK = false;
            this.iQo.setText(this.etO.getString(R.string.sign));
            cwd();
            return;
        }
        this.iUK = true;
        this.iQo.setText(this.etO.getString(R.string.signed));
        cwc();
    }

    protected void cwd() {
    }

    protected void cwc() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cwp() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iUu, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.iUu, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.iUH));
        String string = this.etO.getString(R.string.experience_divider);
        String string2 = this.etO.getString(R.string.member_count_unit);
        if (this.iQr >= 10000) {
            if (this.iQr % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.iQr / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.iQr / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.iQr));
    }

    public void c(boolean z, float f) {
    }

    public void cwk() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.iQE = gVar;
            this.iQE.e(this.iQo);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.iQF = fVar;
            this.iQF.e(this.iQh);
        }
    }
}

package com.baidu.tieba.frs.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public abstract class b {
    private static HashMap<Integer, String> gPU = new HashMap<>();
    private static HashSet<Integer> gPV = new HashSet<>();
    protected TextView aCS;
    protected boolean bFl;
    protected TbPageContext cVg;
    protected LinearGradientView gKI;
    protected TBSpecificationBtn gLT;
    protected FrsViewData gMH;
    protected TBSpecificationBtn gMa;
    protected int gMd;
    protected g gMq;
    protected f gMr;
    protected ImageView gPA;
    protected PopupWindow gPB;
    protected BarImageView gPC;
    protected UserIconBox gPD;
    protected ArrayList<j> gPE;
    protected com.baidu.tieba.frs.f.b gPF;
    protected String gPG;
    protected String gPH;
    protected String gPI;
    protected bj gPJ;
    protected int gPK;
    protected int gPL;
    protected int gPM;
    protected int gPN;
    protected boolean gPO;
    protected boolean gPP;
    protected boolean gPQ;
    protected boolean gPR;
    protected boolean gPS;
    protected float gPT;
    protected TextView gPk;
    protected TextView gPl;
    protected TextView gPm;
    protected View gPn;
    protected TextView gPo;
    protected RelativeLayout gPp;
    protected RelativeLayout gPq;
    protected View gPr;
    protected TextView gPs;
    protected RelativeLayout gPt;
    protected RelativeLayout gPu;
    protected TbImageView gPv;
    protected FrsTopView gPw;
    protected View gPx;
    protected TextView gPy;
    protected TextView gPz;
    protected ImageView gkV;
    protected ImageView gkW;
    protected TextView gmY;
    protected FrsFragment gpX;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gPh = 0;
    protected int gPi = 0;
    protected int gPj = 0;
    private boolean gPW = false;
    protected HashSet<String> gPX = new HashSet<>();
    protected final Runnable gPY = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cVg.getPageActivity());
            }
        }
    };
    private float gPZ = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bGH();

    public abstract void bGS();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        gPU.put(1, "c0117");
        gPU.put(2, "c0124");
        gPU.put(3, "c0125");
        gPU.put(4, "c0126");
        gPU.put(5, "c0127");
    }

    public boolean bLB() {
        return this.gPO;
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

    public boolean bLC() {
        int[] iArr = new int[2];
        try {
            this.gPA.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bLD() {
        return this.gPn;
    }

    public BarImageView bLE() {
        return this.gPC;
    }

    public TextView bLF() {
        return this.aCS;
    }

    public TextView bLG() {
        return this.gmY;
    }

    public boolean bKL() {
        return this.gPQ;
    }

    public void mf(boolean z) {
        this.gPP = z;
        this.gMa.setVisibility(this.gPP ? 0 : 4);
        if (this.gMq != null) {
            this.gMq.mf(z);
        }
    }

    public boolean bKM() {
        return this.gPR;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gPV.clear();
    }

    public void onStop() {
        bLH();
    }

    public void onPrimary(boolean z) {
        if (!z) {
            bLH();
        }
    }

    private void bLH() {
        if (this.gPB != null && this.gPB.isShowing()) {
            this.gPB.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mo(boolean z) {
        this.bFl = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gPG = str;
        this.mLevel = i2;
        if (i == 0) {
            this.gPO = false;
            this.gPW = false;
            this.gPp.setVisibility(0);
            this.gPq.setVisibility(8);
            return;
        }
        this.gPO = true;
        this.gPp.setVisibility(8);
        this.gPq.setVisibility(0);
        if (z && !this.gPW) {
            bGT();
            this.gPW = true;
        }
        c(false, f);
    }

    protected void bGT() {
    }

    public void uF(int i) {
        if (i == 0) {
            this.gPO = false;
            this.gPW = false;
            this.gPp.setVisibility(0);
            this.gPq.setVisibility(8);
            return;
        }
        this.gPO = true;
        this.gPp.setVisibility(8);
        this.gPq.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            uG(signData.is_signed);
            if (signData.forum_rank == -2) {
                mf(false);
                return;
            }
            mf(true);
            uG(signData.is_signed);
        }
    }

    public void uG(int i) {
        if (i == 0) {
            this.gPQ = false;
            this.gMa.setText(this.cVg.getString(R.string.sign));
            bGK();
            return;
        }
        this.gPQ = true;
        this.gMa.setText(this.cVg.getString(R.string.signed));
        bGJ();
    }

    protected void bGK() {
    }

    protected void bGJ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bGU() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gPA, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gPA, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gPN));
        String string = this.cVg.getString(R.string.experience_divider);
        String string2 = this.cVg.getString(R.string.member_count_unit);
        if (this.gMd >= 10000) {
            if (this.gMd % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gMd / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gMd / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gMd));
    }

    public void c(boolean z, float f) {
    }

    public void bGP() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gMq = gVar;
            this.gMq.e(this.gMa);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gMr = fVar;
            this.gMr.e(this.gLT);
        }
    }
}

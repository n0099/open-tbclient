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
    private static HashMap<Integer, String> gPW = new HashMap<>();
    private static HashSet<Integer> gPX = new HashSet<>();
    protected TextView aCT;
    protected boolean bFm;
    protected TbPageContext cVh;
    protected LinearGradientView gKK;
    protected TBSpecificationBtn gLV;
    protected FrsViewData gMJ;
    protected TBSpecificationBtn gMc;
    protected int gMf;
    protected g gMs;
    protected f gMt;
    protected TextView gPA;
    protected TextView gPB;
    protected ImageView gPC;
    protected PopupWindow gPD;
    protected BarImageView gPE;
    protected UserIconBox gPF;
    protected ArrayList<j> gPG;
    protected com.baidu.tieba.frs.f.b gPH;
    protected String gPI;
    protected String gPJ;
    protected String gPK;
    protected bj gPL;
    protected int gPM;
    protected int gPN;
    protected int gPO;
    protected int gPP;
    protected boolean gPQ;
    protected boolean gPR;
    protected boolean gPS;
    protected boolean gPT;
    protected boolean gPU;
    protected float gPV;
    protected TextView gPm;
    protected TextView gPn;
    protected TextView gPo;
    protected View gPp;
    protected TextView gPq;
    protected RelativeLayout gPr;
    protected RelativeLayout gPs;
    protected View gPt;
    protected TextView gPu;
    protected RelativeLayout gPv;
    protected RelativeLayout gPw;
    protected TbImageView gPx;
    protected FrsTopView gPy;
    protected View gPz;
    protected ImageView gkX;
    protected ImageView gkY;
    protected TextView gna;
    protected FrsFragment gpZ;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gPj = 0;
    protected int gPk = 0;
    protected int gPl = 0;
    private boolean gPY = false;
    protected HashSet<String> gPZ = new HashSet<>();
    protected final Runnable gQa = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cVh.getPageActivity());
            }
        }
    };
    private float gQb = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bGJ();

    public abstract void bGU();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        gPW.put(1, "c0117");
        gPW.put(2, "c0124");
        gPW.put(3, "c0125");
        gPW.put(4, "c0126");
        gPW.put(5, "c0127");
    }

    public boolean bLD() {
        return this.gPQ;
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

    public boolean bLE() {
        int[] iArr = new int[2];
        try {
            this.gPC.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bLF() {
        return this.gPp;
    }

    public BarImageView bLG() {
        return this.gPE;
    }

    public TextView bLH() {
        return this.aCT;
    }

    public TextView bLI() {
        return this.gna;
    }

    public boolean bKN() {
        return this.gPS;
    }

    public void mf(boolean z) {
        this.gPR = z;
        this.gMc.setVisibility(this.gPR ? 0 : 4);
        if (this.gMs != null) {
            this.gMs.mf(z);
        }
    }

    public boolean bKO() {
        return this.gPT;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gPX.clear();
    }

    public void onStop() {
        bLJ();
    }

    public void onPrimary(boolean z) {
        if (!z) {
            bLJ();
        }
    }

    private void bLJ() {
        if (this.gPD != null && this.gPD.isShowing()) {
            this.gPD.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mo(boolean z) {
        this.bFm = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gPI = str;
        this.mLevel = i2;
        if (i == 0) {
            this.gPQ = false;
            this.gPY = false;
            this.gPr.setVisibility(0);
            this.gPs.setVisibility(8);
            return;
        }
        this.gPQ = true;
        this.gPr.setVisibility(8);
        this.gPs.setVisibility(0);
        if (z && !this.gPY) {
            bGV();
            this.gPY = true;
        }
        c(false, f);
    }

    protected void bGV() {
    }

    public void uF(int i) {
        if (i == 0) {
            this.gPQ = false;
            this.gPY = false;
            this.gPr.setVisibility(0);
            this.gPs.setVisibility(8);
            return;
        }
        this.gPQ = true;
        this.gPr.setVisibility(8);
        this.gPs.setVisibility(0);
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
            this.gPS = false;
            this.gMc.setText(this.cVh.getString(R.string.sign));
            bGM();
            return;
        }
        this.gPS = true;
        this.gMc.setText(this.cVh.getString(R.string.signed));
        bGL();
    }

    protected void bGM() {
    }

    protected void bGL() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bGW() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gPC, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gPC, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gPP));
        String string = this.cVh.getString(R.string.experience_divider);
        String string2 = this.cVh.getString(R.string.member_count_unit);
        if (this.gMf >= 10000) {
            if (this.gMf % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gMf / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gMf / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gMf));
    }

    public void c(boolean z, float f) {
    }

    public void bGR() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gMs = gVar;
            this.gMs.e(this.gMc);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gMt = fVar;
            this.gMt.e(this.gLV);
        }
    }
}

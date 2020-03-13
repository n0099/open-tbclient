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
    private static HashMap<Integer, String> gQi = new HashMap<>();
    private static HashSet<Integer> gQj = new HashSet<>();
    protected TextView aCU;
    protected boolean bFn;
    protected TbPageContext cVi;
    protected LinearGradientView gKW;
    protected g gME;
    protected f gMF;
    protected FrsViewData gMV;
    protected TBSpecificationBtn gMh;
    protected TBSpecificationBtn gMo;
    protected int gMr;
    protected TextView gPA;
    protected View gPB;
    protected TextView gPC;
    protected RelativeLayout gPD;
    protected RelativeLayout gPE;
    protected View gPF;
    protected TextView gPG;
    protected RelativeLayout gPH;
    protected RelativeLayout gPI;
    protected TbImageView gPJ;
    protected FrsTopView gPK;
    protected View gPL;
    protected TextView gPM;
    protected TextView gPN;
    protected ImageView gPO;
    protected PopupWindow gPP;
    protected BarImageView gPQ;
    protected UserIconBox gPR;
    protected ArrayList<j> gPS;
    protected com.baidu.tieba.frs.f.b gPT;
    protected String gPU;
    protected String gPV;
    protected String gPW;
    protected bj gPX;
    protected int gPY;
    protected int gPZ;
    protected TextView gPy;
    protected TextView gPz;
    protected int gQa;
    protected int gQb;
    protected boolean gQc;
    protected boolean gQd;
    protected boolean gQe;
    protected boolean gQf;
    protected boolean gQg;
    protected float gQh;
    protected ImageView glk;
    protected ImageView gll;
    protected TextView gnn;
    protected FrsFragment gqm;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gPv = 0;
    protected int gPw = 0;
    protected int gPx = 0;
    private boolean gQk = false;
    protected HashSet<String> gQl = new HashSet<>();
    protected final Runnable gQm = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cVi.getPageActivity());
            }
        }
    };
    private float gQn = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bGK();

    public abstract void bGV();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        gQi.put(1, "c0117");
        gQi.put(2, "c0124");
        gQi.put(3, "c0125");
        gQi.put(4, "c0126");
        gQi.put(5, "c0127");
    }

    public boolean bLE() {
        return this.gQc;
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

    public boolean bLF() {
        int[] iArr = new int[2];
        try {
            this.gPO.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bLG() {
        return this.gPB;
    }

    public BarImageView bLH() {
        return this.gPQ;
    }

    public TextView bLI() {
        return this.aCU;
    }

    public TextView bLJ() {
        return this.gnn;
    }

    public boolean bKO() {
        return this.gQe;
    }

    public void mf(boolean z) {
        this.gQd = z;
        this.gMo.setVisibility(this.gQd ? 0 : 4);
        if (this.gME != null) {
            this.gME.mf(z);
        }
    }

    public boolean bKP() {
        return this.gQf;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gQj.clear();
    }

    public void onStop() {
        bLK();
    }

    public void onPrimary(boolean z) {
        if (!z) {
            bLK();
        }
    }

    private void bLK() {
        if (this.gPP != null && this.gPP.isShowing()) {
            this.gPP.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mo(boolean z) {
        this.bFn = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gPU = str;
        this.mLevel = i2;
        if (i == 0) {
            this.gQc = false;
            this.gQk = false;
            this.gPD.setVisibility(0);
            this.gPE.setVisibility(8);
            return;
        }
        this.gQc = true;
        this.gPD.setVisibility(8);
        this.gPE.setVisibility(0);
        if (z && !this.gQk) {
            bGW();
            this.gQk = true;
        }
        c(false, f);
    }

    protected void bGW() {
    }

    public void uF(int i) {
        if (i == 0) {
            this.gQc = false;
            this.gQk = false;
            this.gPD.setVisibility(0);
            this.gPE.setVisibility(8);
            return;
        }
        this.gQc = true;
        this.gPD.setVisibility(8);
        this.gPE.setVisibility(0);
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
            this.gQe = false;
            this.gMo.setText(this.cVi.getString(R.string.sign));
            bGN();
            return;
        }
        this.gQe = true;
        this.gMo.setText(this.cVi.getString(R.string.signed));
        bGM();
    }

    protected void bGN() {
    }

    protected void bGM() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bGX() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gPO, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gPO, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gQb));
        String string = this.cVi.getString(R.string.experience_divider);
        String string2 = this.cVi.getString(R.string.member_count_unit);
        if (this.gMr >= 10000) {
            if (this.gMr % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gMr / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gMr / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gMr));
    }

    public void c(boolean z, float f) {
    }

    public void bGS() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gME = gVar;
            this.gME.e(this.gMo);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gMF = fVar;
            this.gMF.e(this.gMh);
        }
    }
}

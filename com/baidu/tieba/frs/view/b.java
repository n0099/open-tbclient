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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public abstract class b {
    private static HashMap<Integer, String> jBy = new HashMap<>();
    private static HashSet<Integer> jBz = new HashSet<>();
    protected TextView bIt;
    protected boolean dlv;
    protected TbPageContext eNx;
    protected int fth;
    protected ImageView iPr;
    protected ImageView iPs;
    protected TextView iRw;
    protected FrsFragment iVs;
    protected TextView jAJ;
    protected TextView jAK;
    protected TextView jAL;
    protected View jAM;
    protected TextView jAN;
    protected RelativeLayout jAO;
    protected RelativeLayout jAP;
    protected View jAQ;
    protected TextView jAR;
    protected RelativeLayout jAS;
    protected RelativeLayout jAT;
    protected TbImageView jAU;
    protected ServiceAreaView jAV;
    protected FrameLayout jAW;
    protected com.baidu.tieba.frs.ad.g jAX;
    protected FrsTopView jAY;
    protected View jAZ;
    protected View jBa;
    protected View jBb;
    protected TextView jBc;
    protected TextView jBd;
    protected ImageView jBe;
    protected PopupWindow jBf;
    protected BarImageView jBg;
    protected UserIconBox jBh;
    protected ArrayList<j> jBi;
    protected com.baidu.tieba.frs.f.b jBj;
    protected String jBk;
    protected String jBl;
    protected String jBm;
    protected by jBn;
    protected int jBo;
    protected int jBp;
    protected int jBq;
    protected int jBr;
    protected boolean jBs;
    protected boolean jBt;
    protected boolean jBu;
    protected boolean jBv;
    protected boolean jBw;
    protected float jBx;
    protected FrsViewData jtc;
    protected LinearGradientView jvr;
    protected TBSpecificationBtn jwQ;
    protected TBSpecificationBtn jwX;
    protected int jxa;
    protected com.baidu.tieba.frs.vc.g jxn;
    protected com.baidu.tieba.frs.vc.f jxo;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int jAG = 0;
    protected int jAH = 0;
    protected int jAI = 0;
    private boolean jBA = false;
    protected final Runnable jBB = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eNx.getPageActivity());
            }
        }
    };

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cFC();

    public abstract void cFP();

    public abstract void cFQ();

    public abstract void cFR();

    public abstract void cFS();

    public abstract void changeSkinType(int i);

    public abstract void m(View view, boolean z);

    static {
        jBy.put(1, "c0117");
        jBy.put(2, "c0124");
        jBy.put(3, "c0125");
        jBy.put(4, "c0126");
        jBy.put(5, "c0127");
    }

    public boolean cLU() {
        return this.jBs;
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

    public boolean cLV() {
        int[] iArr = new int[2];
        try {
            this.jBe.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cLW() {
        return this.jAM;
    }

    public BarImageView cLX() {
        return this.jBg;
    }

    public TextView cLY() {
        return this.bIt;
    }

    public TextView cLZ() {
        return this.iRw;
    }

    public boolean cKU() {
        return this.jBu;
    }

    public void qX(boolean z) {
        this.jBt = z;
        if (this.jxn != null) {
            this.jxn.qX(z);
        }
    }

    public boolean cKV() {
        return this.jBv;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jBz.clear();
    }

    public void onStop() {
        cMa();
        cFR();
    }

    public void cb(boolean z) {
        if (!z) {
            cMa();
            cFR();
        }
    }

    private void cMa() {
        if (this.jBf != null && this.jBf.isShowing()) {
            this.jBf.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rg(boolean z) {
        this.dlv = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jBk = str;
        this.fth = i2;
        if (i == 0) {
            this.jBs = false;
            this.jBA = false;
            this.jAO.setVisibility(0);
            this.jAP.setVisibility(8);
            this.jwQ.setVisibility(0);
            this.jwX.setVisibility(8);
            return;
        }
        this.jBs = true;
        this.jAO.setVisibility(8);
        this.jAP.setVisibility(0);
        this.jwQ.setVisibility(8);
        this.jwX.setVisibility(0);
        if (z && !this.jBA) {
            cFT();
            this.jBA = true;
        }
    }

    public void aH(float f) {
        c(false, f);
    }

    protected void cFT() {
    }

    public void Ch(int i) {
        if (i == 0) {
            this.jBs = false;
            this.jBA = false;
            this.jAO.setVisibility(0);
            this.jAP.setVisibility(8);
            this.jwQ.setVisibility(0);
            this.jwX.setVisibility(8);
            return;
        }
        this.jBs = true;
        this.jAO.setVisibility(8);
        this.jAP.setVisibility(0);
        this.jwQ.setVisibility(8);
        this.jwX.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Ci(signData.is_signed);
            if (signData.forum_rank == -2) {
                qX(false);
                return;
            }
            qX(true);
            Ci(signData.is_signed);
        }
    }

    public void Ci(int i) {
        if (i == 0) {
            this.jBu = false;
            this.jwX.setText(this.eNx.getString(R.string.sign));
            cFF();
            return;
        }
        this.jBu = true;
        this.jwX.setText(this.eNx.getString(R.string.signed));
        cFE();
    }

    protected void cFF() {
    }

    protected void cFE() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cFU() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jBe, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jBe, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jBr));
        String string = this.eNx.getString(R.string.experience_divider);
        String string2 = this.eNx.getString(R.string.member_count_unit);
        if (this.jxa >= 10000) {
            if (this.jxa % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jxa / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jxa / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jxa));
    }

    public void c(boolean z, float f) {
    }

    public void cFM() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.jxn = gVar;
            this.jxn.e(this.jwX);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.jxo = fVar;
            this.jxo.e(this.jwQ);
        }
    }
}

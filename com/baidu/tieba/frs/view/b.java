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
    private static HashMap<Integer, String> jBw = new HashMap<>();
    private static HashSet<Integer> jBx = new HashSet<>();
    protected TextView bIt;
    protected boolean dlv;
    protected TbPageContext eNx;
    protected int fth;
    protected ImageView iPp;
    protected ImageView iPq;
    protected TextView iRu;
    protected FrsFragment iVq;
    protected TextView jAH;
    protected TextView jAI;
    protected TextView jAJ;
    protected View jAK;
    protected TextView jAL;
    protected RelativeLayout jAM;
    protected RelativeLayout jAN;
    protected View jAO;
    protected TextView jAP;
    protected RelativeLayout jAQ;
    protected RelativeLayout jAR;
    protected TbImageView jAS;
    protected ServiceAreaView jAT;
    protected FrameLayout jAU;
    protected com.baidu.tieba.frs.ad.g jAV;
    protected FrsTopView jAW;
    protected View jAX;
    protected View jAY;
    protected View jAZ;
    protected TextView jBa;
    protected TextView jBb;
    protected ImageView jBc;
    protected PopupWindow jBd;
    protected BarImageView jBe;
    protected UserIconBox jBf;
    protected ArrayList<j> jBg;
    protected com.baidu.tieba.frs.f.b jBh;
    protected String jBi;
    protected String jBj;
    protected String jBk;
    protected by jBl;
    protected int jBm;
    protected int jBn;
    protected int jBo;
    protected int jBp;
    protected boolean jBq;
    protected boolean jBr;
    protected boolean jBs;
    protected boolean jBt;
    protected boolean jBu;
    protected float jBv;
    protected FrsViewData jta;
    protected LinearGradientView jvp;
    protected TBSpecificationBtn jwO;
    protected TBSpecificationBtn jwV;
    protected int jwY;
    protected com.baidu.tieba.frs.vc.g jxl;
    protected com.baidu.tieba.frs.vc.f jxm;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int jAE = 0;
    protected int jAF = 0;
    protected int jAG = 0;
    private boolean jBy = false;
    protected final Runnable jBz = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eNx.getPageActivity());
            }
        }
    };

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cFB();

    public abstract void cFO();

    public abstract void cFP();

    public abstract void cFQ();

    public abstract void cFR();

    public abstract void changeSkinType(int i);

    public abstract void m(View view, boolean z);

    static {
        jBw.put(1, "c0117");
        jBw.put(2, "c0124");
        jBw.put(3, "c0125");
        jBw.put(4, "c0126");
        jBw.put(5, "c0127");
    }

    public boolean cLT() {
        return this.jBq;
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

    public boolean cLU() {
        int[] iArr = new int[2];
        try {
            this.jBc.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cLV() {
        return this.jAK;
    }

    public BarImageView cLW() {
        return this.jBe;
    }

    public TextView cLX() {
        return this.bIt;
    }

    public TextView cLY() {
        return this.iRu;
    }

    public boolean cKT() {
        return this.jBs;
    }

    public void qX(boolean z) {
        this.jBr = z;
        if (this.jxl != null) {
            this.jxl.qX(z);
        }
    }

    public boolean cKU() {
        return this.jBt;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jBx.clear();
    }

    public void onStop() {
        cLZ();
        cFQ();
    }

    public void cb(boolean z) {
        if (!z) {
            cLZ();
            cFQ();
        }
    }

    private void cLZ() {
        if (this.jBd != null && this.jBd.isShowing()) {
            this.jBd.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rg(boolean z) {
        this.dlv = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jBi = str;
        this.fth = i2;
        if (i == 0) {
            this.jBq = false;
            this.jBy = false;
            this.jAM.setVisibility(0);
            this.jAN.setVisibility(8);
            this.jwO.setVisibility(0);
            this.jwV.setVisibility(8);
            return;
        }
        this.jBq = true;
        this.jAM.setVisibility(8);
        this.jAN.setVisibility(0);
        this.jwO.setVisibility(8);
        this.jwV.setVisibility(0);
        if (z && !this.jBy) {
            cFS();
            this.jBy = true;
        }
    }

    public void aH(float f) {
        c(false, f);
    }

    protected void cFS() {
    }

    public void Ch(int i) {
        if (i == 0) {
            this.jBq = false;
            this.jBy = false;
            this.jAM.setVisibility(0);
            this.jAN.setVisibility(8);
            this.jwO.setVisibility(0);
            this.jwV.setVisibility(8);
            return;
        }
        this.jBq = true;
        this.jAM.setVisibility(8);
        this.jAN.setVisibility(0);
        this.jwO.setVisibility(8);
        this.jwV.setVisibility(0);
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
            this.jBs = false;
            this.jwV.setText(this.eNx.getString(R.string.sign));
            cFE();
            return;
        }
        this.jBs = true;
        this.jwV.setText(this.eNx.getString(R.string.signed));
        cFD();
    }

    protected void cFE() {
    }

    protected void cFD() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cFT() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jBc, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jBc, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jBp));
        String string = this.eNx.getString(R.string.experience_divider);
        String string2 = this.eNx.getString(R.string.member_count_unit);
        if (this.jwY >= 10000) {
            if (this.jwY % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jwY / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jwY / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jwY));
    }

    public void c(boolean z, float f) {
    }

    public void cFL() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.jxl = gVar;
            this.jxl.e(this.jwV);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.jxm = fVar;
            this.jxm.e(this.jwO);
        }
    }
}

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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
    private static HashMap<Integer, String> jSm = new HashMap<>();
    private static HashSet<Integer> jSn = new HashSet<>();
    protected TextView bNG;
    protected boolean dpt;
    protected TbPageContext eWx;
    protected FrsViewData jIs;
    protected LinearGradientView jKH;
    protected g jMF;
    protected f jMG;
    protected TBSpecificationBtn jMg;
    protected TBSpecificationBtn jMn;
    protected int jMq;
    protected boolean jMs;
    protected TextView jRA;
    protected RelativeLayout jRB;
    protected RelativeLayout jRC;
    protected View jRD;
    protected TextView jRE;
    protected RelativeLayout jRF;
    protected RelativeLayout jRG;
    protected TbImageView jRH;
    protected ServiceAreaView jRI;
    protected FrameLayout jRJ;
    protected com.baidu.tieba.frs.ad.g jRK;
    protected FrsTopView jRL;
    protected View jRM;
    protected View jRN;
    protected EMTextView jRO;
    protected View jRP;
    protected TextView jRQ;
    protected TextView jRR;
    protected ImageView jRS;
    protected PopupWindow jRT;
    protected BarImageView jRU;
    protected UserIconBox jRV;
    protected ArrayList<k> jRW;
    protected com.baidu.tieba.frs.d.b jRX;
    protected String jRY;
    protected String jRZ;
    protected TextView jRw;
    protected TextView jRx;
    protected TextView jRy;
    protected View jRz;
    protected String jSa;
    protected cb jSb;
    protected int jSc;
    protected int jSd;
    protected int jSe;
    protected int jSf;
    protected boolean jSg;
    protected boolean jSh;
    protected boolean jSi;
    protected boolean jSj;
    protected boolean jSk;
    protected float jSl;
    protected ImageView jeA;
    protected ImageView jeB;
    protected TextView jgF;
    protected FrsFragment jkB;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected SignActivityInfo mSignActivityInfo;
    protected int jRt = 0;
    protected int jRu = 0;
    protected int jRv = 0;
    private boolean jSo = false;
    protected final Runnable jSp = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.eWx.getPageActivity());
            }
        }
    };

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cGh();

    public abstract boolean cGs();

    public abstract SignActivityInfo cGt();

    public abstract void cGw();

    public abstract void cGx();

    public abstract void cGy();

    public abstract void cGz();

    public abstract void changeSkinType(int i);

    public abstract String getActivityId();

    public abstract void l(View view, boolean z);

    static {
        jSm.put(1, "c0117");
        jSm.put(2, "c0124");
        jSm.put(3, "c0125");
        jSm.put(4, "c0126");
        jSm.put(5, "c0127");
    }

    public boolean cNi() {
        return this.jSg;
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

    public boolean cNj() {
        int[] iArr = new int[2];
        try {
            this.jRS.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cNk() {
        return this.jRz;
    }

    public BarImageView cNl() {
        return this.jRU;
    }

    public TextView cNm() {
        return this.bNG;
    }

    public TextView cNn() {
        return this.jgF;
    }

    public boolean cLF() {
        return this.jSi;
    }

    public void rC(boolean z) {
        this.jSh = z;
        if (this.jMF != null) {
            this.jMF.rC(z);
        }
    }

    public boolean cLG() {
        return this.jSj;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        jSn.clear();
    }

    public void onStop() {
        cNo();
        cGy();
    }

    public void cb(boolean z) {
        if (!z) {
            cNo();
            cGy();
        }
    }

    private void cNo() {
        if (this.jRT != null && this.jRT.isShowing()) {
            this.jRT.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void rL(boolean z) {
        this.dpt = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.jRY = str;
        this.mLevel = i2;
        if (i == 0) {
            this.jSg = false;
            this.jSo = false;
            this.jRB.setVisibility(0);
            this.jRC.setVisibility(8);
            this.jMg.setVisibility(0);
            this.jMn.setVisibility(8);
            return;
        }
        this.jSg = true;
        this.jRB.setVisibility(8);
        this.jRC.setVisibility(0);
        this.jMg.setVisibility(8);
        this.jMn.setVisibility(0);
        if (z && !this.jSo) {
            cGA();
            this.jSo = true;
        }
    }

    public void aQ(float f) {
        c(false, f);
    }

    protected void cGA() {
    }

    public void Bd(int i) {
        if (i == 0) {
            this.jSg = false;
            this.jSo = false;
            this.jRB.setVisibility(0);
            this.jRC.setVisibility(8);
            this.jMg.setVisibility(0);
            this.jMn.setVisibility(8);
            return;
        }
        this.jSg = true;
        this.jRB.setVisibility(8);
        this.jRC.setVisibility(0);
        this.jMg.setVisibility(8);
        this.jMn.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            Be(signData.is_signed);
            if (signData.forum_rank == -2) {
                rC(false);
                return;
            }
            rC(true);
            Be(signData.is_signed);
        }
    }

    public void Be(int i) {
        if (i == 0) {
            this.jSi = false;
            this.jMn.setText(this.eWx.getString(R.string.sign));
            cGk();
            return;
        }
        this.jSi = true;
        this.jMn.setText(this.eWx.getString(R.string.signed));
        cGj();
    }

    protected void cGk() {
    }

    protected void cGj() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cGB() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jRS, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.jRS, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.jSf));
        String string = this.eWx.getString(R.string.experience_divider);
        String string2 = this.eWx.getString(R.string.member_count_unit);
        if (this.jMq >= 10000) {
            if (this.jMq % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.jMq / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.jMq / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.jMq));
    }

    public void c(boolean z, float f) {
    }

    public void cGr() {
    }

    public void c(w wVar) {
    }

    public void i(g gVar) {
        if (gVar != null) {
            this.jMF = gVar;
            this.jMF.e(this.jMn);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.jMG = fVar;
            this.jMG.e(this.jMg);
        }
    }
}

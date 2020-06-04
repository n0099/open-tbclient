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
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.i;
import com.baidu.tbadk.core.util.am;
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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public abstract class b {
    private static HashMap<Integer, String> hQX = new HashMap<>();
    private static HashSet<Integer> hQY = new HashSet<>();
    protected TextView bem;
    protected boolean coU;
    protected TbPageContext dIF;
    protected LinearGradientView hKZ;
    protected TBSpecificationBtn hMC;
    protected int hMF;
    protected g hMS;
    protected f hMT;
    protected TBSpecificationBtn hMv;
    protected FrsViewData hNH;
    protected View hQA;
    protected TextView hQB;
    protected TextView hQC;
    protected ImageView hQD;
    protected PopupWindow hQE;
    protected BarImageView hQF;
    protected UserIconBox hQG;
    protected ArrayList<i> hQH;
    protected com.baidu.tieba.frs.f.b hQI;
    protected String hQJ;
    protected String hQK;
    protected String hQL;
    protected bk hQM;
    protected int hQN;
    protected int hQO;
    protected int hQP;
    protected int hQQ;
    protected boolean hQR;
    protected boolean hQS;
    protected boolean hQT;
    protected boolean hQU;
    protected boolean hQV;
    protected float hQW;
    protected TextView hQj;
    protected TextView hQk;
    protected TextView hQl;
    protected View hQm;
    protected TextView hQn;
    protected RelativeLayout hQo;
    protected RelativeLayout hQp;
    protected View hQq;
    protected TextView hQr;
    protected RelativeLayout hQs;
    protected RelativeLayout hQt;
    protected TbImageView hQu;
    protected ServiceAreaView hQv;
    protected FrameLayout hQw;
    protected com.baidu.tieba.frs.ad.g hQx;
    protected FrsTopView hQy;
    protected View hQz;
    protected ImageView hkb;
    protected ImageView hkc;
    protected TextView hmf;
    protected FrsFragment hpm;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int hQg = 0;
    protected int hQh = 0;
    protected int hQi = 0;
    private boolean hQZ = false;
    protected HashSet<String> hRa = new HashSet<>();
    protected final Runnable hRb = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.dIF.getPageActivity());
            }
        }
    };
    private float hRc = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bXY();

    public abstract void bYl();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        hQX.put(1, "c0117");
        hQX.put(2, "c0124");
        hQX.put(3, "c0125");
        hQX.put(4, "c0126");
        hQX.put(5, "c0127");
    }

    public boolean cdd() {
        return this.hQR;
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

    public boolean cde() {
        int[] iArr = new int[2];
        try {
            this.hQD.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cdf() {
        return this.hQm;
    }

    public BarImageView cdg() {
        return this.hQF;
    }

    public TextView cdh() {
        return this.bem;
    }

    public TextView cdi() {
        return this.hmf;
    }

    public boolean ccg() {
        return this.hQT;
    }

    public void nK(boolean z) {
        this.hQS = z;
        this.hMC.setVisibility(this.hQS ? 0 : 4);
        if (this.hMS != null) {
            this.hMS.nK(z);
        }
    }

    public boolean cch() {
        return this.hQU;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        hQY.clear();
    }

    public void onStop() {
        cdj();
    }

    public void bB(boolean z) {
        if (!z) {
            cdj();
        }
    }

    private void cdj() {
        if (this.hQE != null && this.hQE.isShowing()) {
            this.hQE.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void nT(boolean z) {
        this.coU = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.hQJ = str;
        this.mLevel = i2;
        if (i == 0) {
            this.hQR = false;
            this.hQZ = false;
            this.hQo.setVisibility(0);
            this.hQp.setVisibility(8);
            return;
        }
        this.hQR = true;
        this.hQo.setVisibility(8);
        this.hQp.setVisibility(0);
        if (z && !this.hQZ) {
            bYm();
            this.hQZ = true;
        }
        c(false, f);
    }

    protected void bYm() {
    }

    public void vS(int i) {
        if (i == 0) {
            this.hQR = false;
            this.hQZ = false;
            this.hQo.setVisibility(0);
            this.hQp.setVisibility(8);
            return;
        }
        this.hQR = true;
        this.hQo.setVisibility(8);
        this.hQp.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            vT(signData.is_signed);
            if (signData.forum_rank == -2) {
                nK(false);
                return;
            }
            nK(true);
            vT(signData.is_signed);
        }
    }

    public void vT(int i) {
        if (i == 0) {
            this.hQT = false;
            this.hMC.setText(this.dIF.getString(R.string.sign));
            bYb();
            return;
        }
        this.hQT = true;
        this.hMC.setText(this.dIF.getString(R.string.signed));
        bYa();
    }

    protected void bYb() {
    }

    protected void bYa() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bYn() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hQD, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.hQD, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.hQQ));
        String string = this.dIF.getString(R.string.experience_divider);
        String string2 = this.dIF.getString(R.string.member_count_unit);
        if (this.hMF >= 10000) {
            if (this.hMF % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.hMF / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.hMF / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.hMF));
    }

    public void c(boolean z, float f) {
    }

    public void bYi() {
    }

    public void c(x xVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.hMS = gVar;
            this.hMS.e(this.hMC);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.hMT = fVar;
            this.hMT.e(this.hMv);
        }
    }
}

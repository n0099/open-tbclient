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
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public abstract class b {
    private static HashMap<Integer, String> hBr = new HashMap<>();
    private static HashSet<Integer> hBs = new HashSet<>();
    protected TextView aWP;
    protected boolean ceh;
    protected TbPageContext duG;
    protected ImageView gUY;
    protected ImageView gUZ;
    protected TextView gXc;
    protected TextView hAD;
    protected TextView hAE;
    protected TextView hAF;
    protected View hAG;
    protected TextView hAH;
    protected RelativeLayout hAI;
    protected RelativeLayout hAJ;
    protected View hAK;
    protected TextView hAL;
    protected RelativeLayout hAM;
    protected RelativeLayout hAN;
    protected TbImageView hAO;
    protected ServiceAreaView hAP;
    protected FrameLayout hAQ;
    protected g hAR;
    protected FrsTopView hAS;
    protected View hAT;
    protected View hAU;
    protected TextView hAV;
    protected TextView hAW;
    protected ImageView hAX;
    protected PopupWindow hAY;
    protected BarImageView hAZ;
    protected UserIconBox hBa;
    protected ArrayList<j> hBb;
    protected com.baidu.tieba.frs.f.b hBc;
    protected String hBd;
    protected String hBe;
    protected String hBf;
    protected bj hBg;
    protected int hBh;
    protected int hBi;
    protected int hBj;
    protected int hBk;
    protected boolean hBl;
    protected boolean hBm;
    protected boolean hBn;
    protected boolean hBo;
    protected boolean hBp;
    protected float hBq;
    protected FrsFragment hah;
    protected LinearGradientView hvt;
    protected TBSpecificationBtn hwP;
    protected TBSpecificationBtn hwW;
    protected int hwZ;
    protected com.baidu.tieba.frs.vc.g hxm;
    protected f hxn;
    protected FrsViewData hyb;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int hAA = 0;
    protected int hAB = 0;
    protected int hAC = 0;
    private boolean hBt = false;
    protected HashSet<String> hBu = new HashSet<>();
    protected final Runnable hBv = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.duG.getPageActivity());
            }
        }
    };
    private float hBw = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bRA();

    public abstract void bRN();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void z(View.OnClickListener onClickListener);

    static {
        hBr.put(1, "c0117");
        hBr.put(2, "c0124");
        hBr.put(3, "c0125");
        hBr.put(4, "c0126");
        hBr.put(5, "c0127");
    }

    public boolean bWy() {
        return this.hBl;
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

    public boolean bWz() {
        int[] iArr = new int[2];
        try {
            this.hAX.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bWA() {
        return this.hAG;
    }

    public BarImageView bWB() {
        return this.hAZ;
    }

    public TextView bWC() {
        return this.aWP;
    }

    public TextView bWD() {
        return this.gXc;
    }

    public boolean bVB() {
        return this.hBn;
    }

    public void np(boolean z) {
        this.hBm = z;
        this.hwW.setVisibility(this.hBm ? 0 : 4);
        if (this.hxm != null) {
            this.hxm.np(z);
        }
    }

    public boolean bVC() {
        return this.hBo;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        hBs.clear();
    }

    public void onStop() {
        bWE();
    }

    public void jb(boolean z) {
        if (!z) {
            bWE();
        }
    }

    private void bWE() {
        if (this.hAY != null && this.hAY.isShowing()) {
            this.hAY.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void ny(boolean z) {
        this.ceh = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.hBd = str;
        this.mLevel = i2;
        if (i == 0) {
            this.hBl = false;
            this.hBt = false;
            this.hAI.setVisibility(0);
            this.hAJ.setVisibility(8);
            return;
        }
        this.hBl = true;
        this.hAI.setVisibility(8);
        this.hAJ.setVisibility(0);
        if (z && !this.hBt) {
            bRO();
            this.hBt = true;
        }
        c(false, f);
    }

    protected void bRO() {
    }

    public void vk(int i) {
        if (i == 0) {
            this.hBl = false;
            this.hBt = false;
            this.hAI.setVisibility(0);
            this.hAJ.setVisibility(8);
            return;
        }
        this.hBl = true;
        this.hAI.setVisibility(8);
        this.hAJ.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            vl(signData.is_signed);
            if (signData.forum_rank == -2) {
                np(false);
                return;
            }
            np(true);
            vl(signData.is_signed);
        }
    }

    public void vl(int i) {
        if (i == 0) {
            this.hBn = false;
            this.hwW.setText(this.duG.getString(R.string.sign));
            bRD();
            return;
        }
        this.hBn = true;
        this.hwW.setText(this.duG.getString(R.string.signed));
        bRC();
    }

    protected void bRD() {
    }

    protected void bRC() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bRP() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hAX, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.hAX, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.hBk));
        String string = this.duG.getString(R.string.experience_divider);
        String string2 = this.duG.getString(R.string.member_count_unit);
        if (this.hwZ >= 10000) {
            if (this.hwZ % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.hwZ / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.hwZ / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.hwZ));
    }

    public void c(boolean z, float f) {
    }

    public void bRK() {
    }

    public void c(v vVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.hxm = gVar;
            this.hxm.e(this.hwW);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.hxn = fVar;
            this.hxn.e(this.hwP);
        }
    }
}

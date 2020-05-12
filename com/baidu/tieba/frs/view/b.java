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
    private static HashMap<Integer, String> hBx = new HashMap<>();
    private static HashSet<Integer> hBy = new HashSet<>();
    protected TextView aWU;
    protected boolean cen;
    protected TbPageContext duK;
    protected ImageView gVe;
    protected ImageView gVf;
    protected TextView gXi;
    protected TextView hAJ;
    protected TextView hAK;
    protected TextView hAL;
    protected View hAM;
    protected TextView hAN;
    protected RelativeLayout hAO;
    protected RelativeLayout hAP;
    protected View hAQ;
    protected TextView hAR;
    protected RelativeLayout hAS;
    protected RelativeLayout hAT;
    protected TbImageView hAU;
    protected ServiceAreaView hAV;
    protected FrameLayout hAW;
    protected g hAX;
    protected FrsTopView hAY;
    protected View hAZ;
    protected View hBa;
    protected TextView hBb;
    protected TextView hBc;
    protected ImageView hBd;
    protected PopupWindow hBe;
    protected BarImageView hBf;
    protected UserIconBox hBg;
    protected ArrayList<j> hBh;
    protected com.baidu.tieba.frs.f.b hBi;
    protected String hBj;
    protected String hBk;
    protected String hBl;
    protected bj hBm;
    protected int hBn;
    protected int hBo;
    protected int hBp;
    protected int hBq;
    protected boolean hBr;
    protected boolean hBs;
    protected boolean hBt;
    protected boolean hBu;
    protected boolean hBv;
    protected float hBw;
    protected FrsFragment han;
    protected LinearGradientView hvz;
    protected TBSpecificationBtn hwV;
    protected TBSpecificationBtn hxc;
    protected int hxf;
    protected com.baidu.tieba.frs.vc.g hxs;
    protected f hxt;
    protected FrsViewData hyh;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int hAG = 0;
    protected int hAH = 0;
    protected int hAI = 0;
    private boolean hBz = false;
    protected HashSet<String> hBA = new HashSet<>();
    protected final Runnable hBB = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.duK.getPageActivity());
            }
        }
    };
    private float hBC = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bRM();

    public abstract void bRz();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void z(View.OnClickListener onClickListener);

    static {
        hBx.put(1, "c0117");
        hBx.put(2, "c0124");
        hBx.put(3, "c0125");
        hBx.put(4, "c0126");
        hBx.put(5, "c0127");
    }

    public boolean bWx() {
        return this.hBr;
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

    public boolean bWy() {
        int[] iArr = new int[2];
        try {
            this.hBd.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bWz() {
        return this.hAM;
    }

    public BarImageView bWA() {
        return this.hBf;
    }

    public TextView bWB() {
        return this.aWU;
    }

    public TextView bWC() {
        return this.gXi;
    }

    public boolean bVA() {
        return this.hBt;
    }

    public void np(boolean z) {
        this.hBs = z;
        this.hxc.setVisibility(this.hBs ? 0 : 4);
        if (this.hxs != null) {
            this.hxs.np(z);
        }
    }

    public boolean bVB() {
        return this.hBu;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        hBy.clear();
    }

    public void onStop() {
        bWD();
    }

    public void jb(boolean z) {
        if (!z) {
            bWD();
        }
    }

    private void bWD() {
        if (this.hBe != null && this.hBe.isShowing()) {
            this.hBe.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void ny(boolean z) {
        this.cen = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.hBj = str;
        this.mLevel = i2;
        if (i == 0) {
            this.hBr = false;
            this.hBz = false;
            this.hAO.setVisibility(0);
            this.hAP.setVisibility(8);
            return;
        }
        this.hBr = true;
        this.hAO.setVisibility(8);
        this.hAP.setVisibility(0);
        if (z && !this.hBz) {
            bRN();
            this.hBz = true;
        }
        c(false, f);
    }

    protected void bRN() {
    }

    public void vk(int i) {
        if (i == 0) {
            this.hBr = false;
            this.hBz = false;
            this.hAO.setVisibility(0);
            this.hAP.setVisibility(8);
            return;
        }
        this.hBr = true;
        this.hAO.setVisibility(8);
        this.hAP.setVisibility(0);
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
            this.hBt = false;
            this.hxc.setText(this.duK.getString(R.string.sign));
            bRC();
            return;
        }
        this.hBt = true;
        this.hxc.setText(this.duK.getString(R.string.signed));
        bRB();
    }

    protected void bRC() {
    }

    protected void bRB() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bRO() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hBd, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.hBd, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.hBq));
        String string = this.duK.getString(R.string.experience_divider);
        String string2 = this.duK.getString(R.string.member_count_unit);
        if (this.hxf >= 10000) {
            if (this.hxf % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.hxf / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.hxf / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.hxf));
    }

    public void c(boolean z, float f) {
    }

    public void bRJ() {
    }

    public void c(v vVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.hxs = gVar;
            this.hxs.e(this.hxc);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.hxt = fVar;
            this.hxt.e(this.hwV);
        }
    }
}

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
/* loaded from: classes21.dex */
public abstract class b {
    private static HashMap<Integer, String> iFY = new HashMap<>();
    private static HashSet<Integer> iFZ = new HashSet<>();
    protected TextView bsJ;
    protected boolean cFH;
    protected TbPageContext ehG;
    protected ImageView hWp;
    protected ImageView hWq;
    protected TextView hYu;
    protected int iBB;
    protected com.baidu.tieba.frs.vc.g iBO;
    protected com.baidu.tieba.frs.vc.f iBP;
    protected TBSpecificationBtn iBr;
    protected TBSpecificationBtn iBy;
    protected FrsViewData iCD;
    protected View iFA;
    protected View iFB;
    protected TextView iFC;
    protected TextView iFD;
    protected ImageView iFE;
    protected PopupWindow iFF;
    protected BarImageView iFG;
    protected UserIconBox iFH;
    protected ArrayList<i> iFI;
    protected com.baidu.tieba.frs.f.b iFJ;
    protected String iFK;
    protected String iFL;
    protected String iFM;
    protected bw iFN;
    protected int iFO;
    protected int iFP;
    protected int iFQ;
    protected int iFR;
    protected boolean iFS;
    protected boolean iFT;
    protected boolean iFU;
    protected boolean iFV;
    protected boolean iFW;
    protected float iFX;
    protected TextView iFk;
    protected TextView iFl;
    protected TextView iFm;
    protected View iFn;
    protected TextView iFo;
    protected RelativeLayout iFp;
    protected RelativeLayout iFq;
    protected View iFr;
    protected TextView iFs;
    protected RelativeLayout iFt;
    protected RelativeLayout iFu;
    protected TbImageView iFv;
    protected ServiceAreaView iFw;
    protected FrameLayout iFx;
    protected com.baidu.tieba.frs.ad.g iFy;
    protected FrsTopView iFz;
    protected FrsFragment icq;
    protected LinearGradientView izP;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int iFh = 0;
    protected int iFi = 0;
    protected int iFj = 0;
    private boolean iGa = false;
    protected HashSet<String> iGb = new HashSet<>();
    protected final Runnable iGc = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.ehG.getPageActivity());
            }
        }
    };
    private float iGd = -1.0f;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void changeSkinType(int i);

    public abstract void csD();

    public abstract void csQ();

    public abstract void k(View view, boolean z);

    static {
        iFY.put(1, "c0117");
        iFY.put(2, "c0124");
        iFY.put(3, "c0125");
        iFY.put(4, "c0126");
        iFY.put(5, "c0127");
    }

    public boolean cxU() {
        return this.iFS;
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

    public boolean cxV() {
        int[] iArr = new int[2];
        try {
            this.iFE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cxW() {
        return this.iFn;
    }

    public BarImageView cxX() {
        return this.iFG;
    }

    public TextView cxY() {
        return this.bsJ;
    }

    public TextView cxZ() {
        return this.hYu;
    }

    public boolean cwU() {
        return this.iFU;
    }

    public void pn(boolean z) {
        this.iFT = z;
        this.iBy.setVisibility(this.iFT ? 0 : 4);
        if (this.iBO != null) {
            this.iBO.pn(z);
        }
    }

    public boolean cwV() {
        return this.iFV;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        iFZ.clear();
    }

    public void onStop() {
        cya();
    }

    public void bL(boolean z) {
        if (!z) {
            cya();
        }
    }

    private void cya() {
        if (this.iFF != null && this.iFF.isShowing()) {
            this.iFF.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void pw(boolean z) {
        this.cFH = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.iFK = str;
        this.mLevel = i2;
        if (i == 0) {
            this.iFS = false;
            this.iGa = false;
            this.iFp.setVisibility(0);
            this.iFq.setVisibility(8);
            return;
        }
        this.iFS = true;
        this.iFp.setVisibility(8);
        this.iFq.setVisibility(0);
        if (z && !this.iGa) {
            csR();
            this.iGa = true;
        }
    }

    public void ap(float f) {
        c(false, f);
    }

    protected void csR() {
    }

    public void zI(int i) {
        if (i == 0) {
            this.iFS = false;
            this.iGa = false;
            this.iFp.setVisibility(0);
            this.iFq.setVisibility(8);
            return;
        }
        this.iFS = true;
        this.iFp.setVisibility(8);
        this.iFq.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            zJ(signData.is_signed);
            if (signData.forum_rank == -2) {
                pn(false);
                return;
            }
            pn(true);
            zJ(signData.is_signed);
        }
    }

    public void zJ(int i) {
        if (i == 0) {
            this.iFU = false;
            this.iBy.setText(this.ehG.getString(R.string.sign));
            csG();
            return;
        }
        this.iFU = true;
        this.iBy.setText(this.ehG.getString(R.string.signed));
        csF();
    }

    protected void csG() {
    }

    protected void csF() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void csS() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iFE, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.iFE, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.iFR));
        String string = this.ehG.getString(R.string.experience_divider);
        String string2 = this.ehG.getString(R.string.member_count_unit);
        if (this.iBB >= 10000) {
            if (this.iBB % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.iBB / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.iBB / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.iBB));
    }

    public void c(boolean z, float f) {
    }

    public void csN() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.iBO = gVar;
            this.iBO.e(this.iBy);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.iBP = fVar;
            this.iBP.e(this.iBr);
        }
    }
}

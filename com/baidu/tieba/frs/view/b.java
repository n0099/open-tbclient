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
    private static HashMap<Integer, String> hQk = new HashMap<>();
    private static HashSet<Integer> hQl = new HashSet<>();
    protected TextView bem;
    protected boolean coU;
    protected TbPageContext dIF;
    protected LinearGradientView hKm;
    protected TBSpecificationBtn hLI;
    protected TBSpecificationBtn hLP;
    protected int hLS;
    protected FrsViewData hMU;
    protected g hMf;
    protected f hMg;
    protected TextView hPA;
    protected RelativeLayout hPB;
    protected RelativeLayout hPC;
    protected View hPD;
    protected TextView hPE;
    protected RelativeLayout hPF;
    protected RelativeLayout hPG;
    protected TbImageView hPH;
    protected ServiceAreaView hPI;
    protected FrameLayout hPJ;
    protected com.baidu.tieba.frs.ad.g hPK;
    protected FrsTopView hPL;
    protected View hPM;
    protected View hPN;
    protected TextView hPO;
    protected TextView hPP;
    protected ImageView hPQ;
    protected PopupWindow hPR;
    protected BarImageView hPS;
    protected UserIconBox hPT;
    protected ArrayList<i> hPU;
    protected com.baidu.tieba.frs.f.b hPV;
    protected String hPW;
    protected String hPX;
    protected String hPY;
    protected bk hPZ;
    protected TextView hPw;
    protected TextView hPx;
    protected TextView hPy;
    protected View hPz;
    protected int hQa;
    protected int hQb;
    protected int hQc;
    protected int hQd;
    protected boolean hQe;
    protected boolean hQf;
    protected boolean hQg;
    protected boolean hQh;
    protected boolean hQi;
    protected float hQj;
    protected ImageView hjQ;
    protected ImageView hjR;
    protected TextView hlU;
    protected FrsFragment hpb;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int hPt = 0;
    protected int hPu = 0;
    protected int hPv = 0;
    private boolean hQm = false;
    protected HashSet<String> hQn = new HashSet<>();
    protected final Runnable hQo = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.dIF.getPageActivity());
            }
        }
    };
    private float hQp = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bXV();

    public abstract void bYi();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        hQk.put(1, "c0117");
        hQk.put(2, "c0124");
        hQk.put(3, "c0125");
        hQk.put(4, "c0126");
        hQk.put(5, "c0127");
    }

    public boolean ccV() {
        return this.hQe;
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

    public boolean ccW() {
        int[] iArr = new int[2];
        try {
            this.hPQ.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View ccX() {
        return this.hPz;
    }

    public BarImageView ccY() {
        return this.hPS;
    }

    public TextView ccZ() {
        return this.bem;
    }

    public TextView cda() {
        return this.hlU;
    }

    public boolean cbY() {
        return this.hQg;
    }

    public void nK(boolean z) {
        this.hQf = z;
        this.hLP.setVisibility(this.hQf ? 0 : 4);
        if (this.hMf != null) {
            this.hMf.nK(z);
        }
    }

    public boolean cbZ() {
        return this.hQh;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        hQl.clear();
    }

    public void onStop() {
        cdb();
    }

    public void bB(boolean z) {
        if (!z) {
            cdb();
        }
    }

    private void cdb() {
        if (this.hPR != null && this.hPR.isShowing()) {
            this.hPR.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void nT(boolean z) {
        this.coU = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.hPW = str;
        this.mLevel = i2;
        if (i == 0) {
            this.hQe = false;
            this.hQm = false;
            this.hPB.setVisibility(0);
            this.hPC.setVisibility(8);
            return;
        }
        this.hQe = true;
        this.hPB.setVisibility(8);
        this.hPC.setVisibility(0);
        if (z && !this.hQm) {
            bYj();
            this.hQm = true;
        }
        c(false, f);
    }

    protected void bYj() {
    }

    public void vQ(int i) {
        if (i == 0) {
            this.hQe = false;
            this.hQm = false;
            this.hPB.setVisibility(0);
            this.hPC.setVisibility(8);
            return;
        }
        this.hQe = true;
        this.hPB.setVisibility(8);
        this.hPC.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            vR(signData.is_signed);
            if (signData.forum_rank == -2) {
                nK(false);
                return;
            }
            nK(true);
            vR(signData.is_signed);
        }
    }

    public void vR(int i) {
        if (i == 0) {
            this.hQg = false;
            this.hLP.setText(this.dIF.getString(R.string.sign));
            bXY();
            return;
        }
        this.hQg = true;
        this.hLP.setText(this.dIF.getString(R.string.signed));
        bXX();
    }

    protected void bXY() {
    }

    protected void bXX() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bYk() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hPQ, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.hPQ, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.hQd));
        String string = this.dIF.getString(R.string.experience_divider);
        String string2 = this.dIF.getString(R.string.member_count_unit);
        if (this.hLS >= 10000) {
            if (this.hLS % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.hLS / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.hLS / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.hLS));
    }

    public void c(boolean z, float f) {
    }

    public void bYf() {
    }

    public void c(x xVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.hMf = gVar;
            this.hMf.e(this.hLP);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.hMg = fVar;
            this.hMg.e(this.hLI);
        }
    }
}

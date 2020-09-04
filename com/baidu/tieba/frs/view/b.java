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
/* loaded from: classes16.dex */
public abstract class b {
    private static HashMap<Integer, String> iyC = new HashMap<>();
    private static HashSet<Integer> iyD = new HashSet<>();
    protected TextView bpA;
    protected boolean cDH;
    protected TbPageContext efr;
    protected ImageView hPp;
    protected ImageView hPq;
    protected TextView hRu;
    protected FrsFragment hVq;
    protected LinearGradientView isz;
    protected TBSpecificationBtn itV;
    protected TBSpecificationBtn iuc;
    protected int iuf;
    protected com.baidu.tieba.frs.vc.g ius;
    protected com.baidu.tieba.frs.vc.f iut;
    protected FrsViewData ivh;
    protected TextView ixO;
    protected TextView ixP;
    protected TextView ixQ;
    protected View ixR;
    protected TextView ixS;
    protected RelativeLayout ixT;
    protected RelativeLayout ixU;
    protected View ixV;
    protected TextView ixW;
    protected RelativeLayout ixX;
    protected RelativeLayout ixY;
    protected TbImageView ixZ;
    protected boolean iyA;
    protected float iyB;
    protected ServiceAreaView iya;
    protected FrameLayout iyb;
    protected com.baidu.tieba.frs.ad.g iyc;
    protected FrsTopView iyd;
    protected View iye;
    protected View iyf;
    protected TextView iyg;
    protected TextView iyh;
    protected ImageView iyi;
    protected PopupWindow iyj;
    protected BarImageView iyk;
    protected UserIconBox iyl;
    protected ArrayList<i> iym;
    protected com.baidu.tieba.frs.f.b iyn;
    protected String iyo;
    protected String iyp;
    protected String iyq;
    protected bw iyr;
    protected int iys;
    protected int iyt;
    protected int iyu;
    protected int iyv;
    protected boolean iyw;
    protected boolean iyx;
    protected boolean iyy;
    protected boolean iyz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int ixL = 0;
    protected int ixM = 0;
    protected int ixN = 0;
    private boolean iyE = false;
    protected HashSet<String> iyF = new HashSet<>();
    protected final Runnable iyG = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.efr.getPageActivity());
            }
        }
    };
    private float iyH = -1.0f;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void changeSkinType(int i);

    public abstract void cpD();

    public abstract void cpq();

    public abstract void k(View view, boolean z);

    static {
        iyC.put(1, "c0117");
        iyC.put(2, "c0124");
        iyC.put(3, "c0125");
        iyC.put(4, "c0126");
        iyC.put(5, "c0127");
    }

    public boolean cuB() {
        return this.iyw;
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

    public boolean cuC() {
        int[] iArr = new int[2];
        try {
            this.iyi.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cuD() {
        return this.ixR;
    }

    public BarImageView cuE() {
        return this.iyk;
    }

    public TextView cuF() {
        return this.bpA;
    }

    public TextView cuG() {
        return this.hRu;
    }

    public boolean ctD() {
        return this.iyy;
    }

    public void ph(boolean z) {
        this.iyx = z;
        this.iuc.setVisibility(this.iyx ? 0 : 4);
        if (this.ius != null) {
            this.ius.ph(z);
        }
    }

    public boolean ctE() {
        return this.iyz;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        iyD.clear();
    }

    public void onStop() {
        cuH();
    }

    public void bJ(boolean z) {
        if (!z) {
            cuH();
        }
    }

    private void cuH() {
        if (this.iyj != null && this.iyj.isShowing()) {
            this.iyj.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void pq(boolean z) {
        this.cDH = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.iyo = str;
        this.mLevel = i2;
        if (i == 0) {
            this.iyw = false;
            this.iyE = false;
            this.ixT.setVisibility(0);
            this.ixU.setVisibility(8);
            return;
        }
        this.iyw = true;
        this.ixT.setVisibility(8);
        this.ixU.setVisibility(0);
        if (z && !this.iyE) {
            cpE();
            this.iyE = true;
        }
    }

    public void ap(float f) {
        c(false, f);
    }

    protected void cpE() {
    }

    public void zk(int i) {
        if (i == 0) {
            this.iyw = false;
            this.iyE = false;
            this.ixT.setVisibility(0);
            this.ixU.setVisibility(8);
            return;
        }
        this.iyw = true;
        this.ixT.setVisibility(8);
        this.ixU.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            zl(signData.is_signed);
            if (signData.forum_rank == -2) {
                ph(false);
                return;
            }
            ph(true);
            zl(signData.is_signed);
        }
    }

    public void zl(int i) {
        if (i == 0) {
            this.iyy = false;
            this.iuc.setText(this.efr.getString(R.string.sign));
            cpt();
            return;
        }
        this.iyy = true;
        this.iuc.setText(this.efr.getString(R.string.signed));
        cps();
    }

    protected void cpt() {
    }

    protected void cps() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cpF() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iyi, R.drawable.icon_speed_orange);
        } else {
            ap.setImageResource(this.iyi, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.iyv));
        String string = this.efr.getString(R.string.experience_divider);
        String string2 = this.efr.getString(R.string.member_count_unit);
        if (this.iuf >= 10000) {
            if (this.iuf % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.iuf / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.iuf / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.iuf));
    }

    public void c(boolean z, float f) {
    }

    public void cpA() {
    }

    public void c(ab abVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.ius = gVar;
            this.ius.e(this.iuc);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.iut = fVar;
            this.iut.e(this.itV);
        }
    }
}

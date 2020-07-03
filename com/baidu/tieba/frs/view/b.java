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
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.i;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes9.dex */
public abstract class b {
    private static HashMap<Integer, String> ies = new HashMap<>();
    private static HashSet<Integer> iet = new HashSet<>();
    protected TextView bjy;
    protected boolean ctI;
    protected TbPageContext dPv;
    protected FrsFragment hBW;
    protected LinearGradientView hYl;
    protected TBSpecificationBtn hZH;
    protected TBSpecificationBtn hZO;
    protected int hZR;
    protected ImageView hwi;
    protected ImageView hwj;
    protected TextView hym;
    protected FrsViewData iaT;
    protected com.baidu.tieba.frs.vc.g iae;
    protected com.baidu.tieba.frs.vc.f iaf;
    protected TextView idE;
    protected TextView idF;
    protected TextView idG;
    protected View idH;
    protected TextView idI;
    protected RelativeLayout idJ;
    protected RelativeLayout idK;
    protected View idL;
    protected TextView idM;
    protected RelativeLayout idN;
    protected RelativeLayout idO;
    protected TbImageView idP;
    protected ServiceAreaView idQ;
    protected FrameLayout idR;
    protected com.baidu.tieba.frs.ad.g idS;
    protected FrsTopView idT;
    protected View idU;
    protected View idV;
    protected TextView idW;
    protected TextView idX;
    protected ImageView idY;
    protected PopupWindow idZ;
    protected BarImageView iea;
    protected UserIconBox ieb;
    protected ArrayList<i> iec;
    protected com.baidu.tieba.frs.f.b ied;
    protected String iee;
    protected String ief;
    protected String ieg;
    protected bu ieh;
    protected int iei;
    protected int iej;
    protected int iek;
    protected int iel;
    protected boolean iem;
    protected boolean ien;
    protected boolean ieo;
    protected boolean iep;
    protected boolean ieq;
    protected float ier;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int idB = 0;
    protected int idC = 0;
    protected int idD = 0;
    private boolean ieu = false;
    protected HashSet<String> iev = new HashSet<>();
    protected final Runnable iew = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.dPv.getPageActivity());
            }
        }
    };
    private float iex = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void cbm();

    public abstract void cbz();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    public abstract void z(View.OnClickListener onClickListener);

    static {
        ies.put(1, "c0117");
        ies.put(2, "c0124");
        ies.put(3, "c0125");
        ies.put(4, "c0126");
        ies.put(5, "c0127");
    }

    public boolean cgw() {
        return this.iem;
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

    public boolean cgx() {
        int[] iArr = new int[2];
        try {
            this.idY.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cgy() {
        return this.idH;
    }

    public BarImageView cgz() {
        return this.iea;
    }

    public TextView cgA() {
        return this.bjy;
    }

    public TextView cgB() {
        return this.hym;
    }

    public boolean cfy() {
        return this.ieo;
    }

    public void nW(boolean z) {
        this.ien = z;
        this.hZO.setVisibility(this.ien ? 0 : 4);
        if (this.iae != null) {
            this.iae.nW(z);
        }
    }

    public boolean cfz() {
        return this.iep;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        iet.clear();
    }

    public void onStop() {
        cgC();
    }

    public void bB(boolean z) {
        if (!z) {
            cgC();
        }
    }

    private void cgC() {
        if (this.idZ != null && this.idZ.isShowing()) {
            this.idZ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void of(boolean z) {
        this.ctI = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.iee = str;
        this.mLevel = i2;
        if (i == 0) {
            this.iem = false;
            this.ieu = false;
            this.idJ.setVisibility(0);
            this.idK.setVisibility(8);
            return;
        }
        this.iem = true;
        this.idJ.setVisibility(8);
        this.idK.setVisibility(0);
        if (z && !this.ieu) {
            cbA();
            this.ieu = true;
        }
    }

    public void aj(float f) {
        c(false, f);
    }

    protected void cbA() {
    }

    public void wy(int i) {
        if (i == 0) {
            this.iem = false;
            this.ieu = false;
            this.idJ.setVisibility(0);
            this.idK.setVisibility(8);
            return;
        }
        this.iem = true;
        this.idJ.setVisibility(8);
        this.idK.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            wz(signData.is_signed);
            if (signData.forum_rank == -2) {
                nW(false);
                return;
            }
            nW(true);
            wz(signData.is_signed);
        }
    }

    public void wz(int i) {
        if (i == 0) {
            this.ieo = false;
            this.hZO.setText(this.dPv.getString(R.string.sign));
            cbp();
            return;
        }
        this.ieo = true;
        this.hZO.setText(this.dPv.getString(R.string.signed));
        cbo();
    }

    protected void cbp() {
    }

    protected void cbo() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cbB() {
        if (this.mMemberType != 0) {
            an.setImageResource(this.idY, R.drawable.icon_speed_orange);
        } else {
            an.setImageResource(this.idY, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.iel));
        String string = this.dPv.getString(R.string.experience_divider);
        String string2 = this.dPv.getString(R.string.member_count_unit);
        if (this.hZR >= 10000) {
            if (this.hZR % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.hZR / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.hZR / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.hZR));
    }

    public void c(boolean z, float f) {
    }

    public void cbw() {
    }

    public void c(z zVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.iae = gVar;
            this.iae.e(this.hZO);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.iaf = fVar;
            this.iaf.e(this.hZH);
        }
    }
}

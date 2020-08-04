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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.i;
import com.baidu.tbadk.core.util.ao;
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
    private static HashMap<Integer, String> iks = new HashMap<>();
    private static HashSet<Integer> ikt = new HashSet<>();
    protected TextView bjS;
    protected boolean cvK;
    protected TbPageContext dVN;
    protected ImageView hBU;
    protected ImageView hBV;
    protected TextView hEa;
    protected FrsFragment hHU;
    protected LinearGradientView iep;
    protected TBSpecificationBtn ifL;
    protected TBSpecificationBtn ifS;
    protected int ifV;
    protected FrsViewData igX;
    protected com.baidu.tieba.frs.vc.g igi;
    protected com.baidu.tieba.frs.vc.f igj;
    protected TextView ijE;
    protected TextView ijF;
    protected TextView ijG;
    protected View ijH;
    protected TextView ijI;
    protected RelativeLayout ijJ;
    protected RelativeLayout ijK;
    protected View ijL;
    protected TextView ijM;
    protected RelativeLayout ijN;
    protected RelativeLayout ijO;
    protected TbImageView ijP;
    protected ServiceAreaView ijQ;
    protected FrameLayout ijR;
    protected com.baidu.tieba.frs.ad.g ijS;
    protected FrsTopView ijT;
    protected View ijU;
    protected View ijV;
    protected TextView ijW;
    protected TextView ijX;
    protected ImageView ijY;
    protected PopupWindow ijZ;
    protected BarImageView ika;
    protected UserIconBox ikb;
    protected ArrayList<i> ikc;
    protected com.baidu.tieba.frs.f.b ikd;
    protected String ike;
    protected String ikf;
    protected String ikg;
    protected bv ikh;
    protected int iki;
    protected int ikj;
    protected int ikk;
    protected int ikl;
    protected boolean ikm;
    protected boolean ikn;
    protected boolean iko;
    protected boolean ikp;
    protected boolean ikq;
    protected float ikr;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int ijB = 0;
    protected int ijC = 0;
    protected int ijD = 0;
    private boolean iku = false;
    protected HashSet<String> ikv = new HashSet<>();
    protected final Runnable ikw = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.dVN.getPageActivity());
            }
        }
    };
    private float ikx = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void ceL();

    public abstract void ceY();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    public abstract void z(View.OnClickListener onClickListener);

    static {
        iks.put(1, "c0117");
        iks.put(2, "c0124");
        iks.put(3, "c0125");
        iks.put(4, "c0126");
        iks.put(5, "c0127");
    }

    public boolean cjW() {
        return this.ikm;
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

    public boolean cjX() {
        int[] iArr = new int[2];
        try {
            this.ijY.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cjY() {
        return this.ijH;
    }

    public BarImageView cjZ() {
        return this.ika;
    }

    public TextView cka() {
        return this.bjS;
    }

    public TextView ckb() {
        return this.hEa;
    }

    public boolean ciY() {
        return this.iko;
    }

    public void oB(boolean z) {
        this.ikn = z;
        this.ifS.setVisibility(this.ikn ? 0 : 4);
        if (this.igi != null) {
            this.igi.oB(z);
        }
    }

    public boolean ciZ() {
        return this.ikp;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        ikt.clear();
    }

    public void onStop() {
        ckc();
    }

    public void bE(boolean z) {
        if (!z) {
            ckc();
        }
    }

    private void ckc() {
        if (this.ijZ != null && this.ijZ.isShowing()) {
            this.ijZ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void oK(boolean z) {
        this.cvK = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ike = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ikm = false;
            this.iku = false;
            this.ijJ.setVisibility(0);
            this.ijK.setVisibility(8);
            return;
        }
        this.ikm = true;
        this.ijJ.setVisibility(8);
        this.ijK.setVisibility(0);
        if (z && !this.iku) {
            ceZ();
            this.iku = true;
        }
    }

    public void aj(float f) {
        c(false, f);
    }

    protected void ceZ() {
    }

    public void wQ(int i) {
        if (i == 0) {
            this.ikm = false;
            this.iku = false;
            this.ijJ.setVisibility(0);
            this.ijK.setVisibility(8);
            return;
        }
        this.ikm = true;
        this.ijJ.setVisibility(8);
        this.ijK.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            wR(signData.is_signed);
            if (signData.forum_rank == -2) {
                oB(false);
                return;
            }
            oB(true);
            wR(signData.is_signed);
        }
    }

    public void wR(int i) {
        if (i == 0) {
            this.iko = false;
            this.ifS.setText(this.dVN.getString(R.string.sign));
            ceO();
            return;
        }
        this.iko = true;
        this.ifS.setText(this.dVN.getString(R.string.signed));
        ceN();
    }

    protected void ceO() {
    }

    protected void ceN() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void cfa() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.ijY, R.drawable.icon_speed_orange);
        } else {
            ao.setImageResource(this.ijY, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ikl));
        String string = this.dVN.getString(R.string.experience_divider);
        String string2 = this.dVN.getString(R.string.member_count_unit);
        if (this.ifV >= 10000) {
            if (this.ifV % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.ifV / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.ifV / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.ifV));
    }

    public void c(boolean z, float f) {
    }

    public void ceV() {
    }

    public void c(z zVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.igi = gVar;
            this.igi.e(this.ifS);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.igj = fVar;
            this.igj.e(this.ifL);
        }
    }
}

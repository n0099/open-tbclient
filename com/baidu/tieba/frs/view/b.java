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
    private static HashMap<Integer, String> ikq = new HashMap<>();
    private static HashSet<Integer> ikr = new HashSet<>();
    protected TextView bjS;
    protected boolean cvK;
    protected TbPageContext dVN;
    protected ImageView hBU;
    protected ImageView hBV;
    protected TextView hEa;
    protected FrsFragment hHU;
    protected LinearGradientView ien;
    protected TBSpecificationBtn ifJ;
    protected TBSpecificationBtn ifQ;
    protected int ifT;
    protected FrsViewData igV;
    protected com.baidu.tieba.frs.vc.g igg;
    protected com.baidu.tieba.frs.vc.f igh;
    protected TextView ijC;
    protected TextView ijD;
    protected TextView ijE;
    protected View ijF;
    protected TextView ijG;
    protected RelativeLayout ijH;
    protected RelativeLayout ijI;
    protected View ijJ;
    protected TextView ijK;
    protected RelativeLayout ijL;
    protected RelativeLayout ijM;
    protected TbImageView ijN;
    protected ServiceAreaView ijO;
    protected FrameLayout ijP;
    protected com.baidu.tieba.frs.ad.f ijQ;
    protected FrsTopView ijR;
    protected View ijS;
    protected View ijT;
    protected TextView ijU;
    protected TextView ijV;
    protected ImageView ijW;
    protected PopupWindow ijX;
    protected BarImageView ijY;
    protected UserIconBox ijZ;
    protected ArrayList<i> ika;
    protected com.baidu.tieba.frs.f.b ikb;
    protected String ikc;
    protected String ikd;
    protected String ike;
    protected bv ikf;
    protected int ikg;
    protected int ikh;
    protected int iki;
    protected int ikj;
    protected boolean ikk;
    protected boolean ikl;
    protected boolean ikm;
    protected boolean ikn;
    protected boolean iko;
    protected float ikp;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int ijz = 0;
    protected int ijA = 0;
    protected int ijB = 0;
    private boolean iks = false;
    protected HashSet<String> ikt = new HashSet<>();
    protected final Runnable iku = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.dVN.getPageActivity());
            }
        }
    };
    private float ikv = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void ceL();

    public abstract void ceY();

    public abstract void changeSkinType(int i);

    public abstract void l(View view, boolean z);

    public abstract void z(View.OnClickListener onClickListener);

    static {
        ikq.put(1, "c0117");
        ikq.put(2, "c0124");
        ikq.put(3, "c0125");
        ikq.put(4, "c0126");
        ikq.put(5, "c0127");
    }

    public boolean cjW() {
        return this.ikk;
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
            this.ijW.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View cjY() {
        return this.ijF;
    }

    public BarImageView cjZ() {
        return this.ijY;
    }

    public TextView cka() {
        return this.bjS;
    }

    public TextView ckb() {
        return this.hEa;
    }

    public boolean ciY() {
        return this.ikm;
    }

    public void oB(boolean z) {
        this.ikl = z;
        this.ifQ.setVisibility(this.ikl ? 0 : 4);
        if (this.igg != null) {
            this.igg.oB(z);
        }
    }

    public boolean ciZ() {
        return this.ikn;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        ikr.clear();
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
        if (this.ijX != null && this.ijX.isShowing()) {
            this.ijX.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void oK(boolean z) {
        this.cvK = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ikc = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ikk = false;
            this.iks = false;
            this.ijH.setVisibility(0);
            this.ijI.setVisibility(8);
            return;
        }
        this.ikk = true;
        this.ijH.setVisibility(8);
        this.ijI.setVisibility(0);
        if (z && !this.iks) {
            ceZ();
            this.iks = true;
        }
    }

    public void aj(float f) {
        c(false, f);
    }

    protected void ceZ() {
    }

    public void wQ(int i) {
        if (i == 0) {
            this.ikk = false;
            this.iks = false;
            this.ijH.setVisibility(0);
            this.ijI.setVisibility(8);
            return;
        }
        this.ikk = true;
        this.ijH.setVisibility(8);
        this.ijI.setVisibility(0);
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
            this.ikm = false;
            this.ifQ.setText(this.dVN.getString(R.string.sign));
            ceO();
            return;
        }
        this.ikm = true;
        this.ifQ.setText(this.dVN.getString(R.string.signed));
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
            ao.setImageResource(this.ijW, R.drawable.icon_speed_orange);
        } else {
            ao.setImageResource(this.ijW, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ikj));
        String string = this.dVN.getString(R.string.experience_divider);
        String string2 = this.dVN.getString(R.string.member_count_unit);
        if (this.ifT >= 10000) {
            if (this.ifT % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.ifT / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.ifT / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.ifT));
    }

    public void c(boolean z, float f) {
    }

    public void ceV() {
    }

    public void c(z zVar) {
    }

    public void f(com.baidu.tieba.frs.vc.g gVar) {
        if (gVar != null) {
            this.igg = gVar;
            this.igg.e(this.ifQ);
        }
    }

    public void g(com.baidu.tieba.frs.vc.f fVar) {
        if (fVar != null) {
            this.igh = fVar;
            this.igh.e(this.ifJ);
        }
    }
}

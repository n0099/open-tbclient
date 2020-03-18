package com.baidu.tieba.frs.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.s;
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
    private static HashMap<Integer, String> gRp = new HashMap<>();
    private static HashSet<Integer> gRq = new HashSet<>();
    protected TextView aDi;
    protected boolean bFy;
    protected TbPageContext cVv;
    protected LinearGradientView gMb;
    protected g gNJ;
    protected f gNK;
    protected TBSpecificationBtn gNm;
    protected TBSpecificationBtn gNt;
    protected int gNw;
    protected FrsViewData gOa;
    protected TextView gQF;
    protected TextView gQG;
    protected TextView gQH;
    protected View gQI;
    protected TextView gQJ;
    protected RelativeLayout gQK;
    protected RelativeLayout gQL;
    protected View gQM;
    protected TextView gQN;
    protected RelativeLayout gQO;
    protected RelativeLayout gQP;
    protected TbImageView gQQ;
    protected FrsTopView gQR;
    protected View gQS;
    protected TextView gQT;
    protected TextView gQU;
    protected ImageView gQV;
    protected PopupWindow gQW;
    protected BarImageView gQX;
    protected UserIconBox gQY;
    protected ArrayList<j> gQZ;
    protected com.baidu.tieba.frs.f.b gRa;
    protected String gRb;
    protected String gRc;
    protected String gRd;
    protected bj gRe;
    protected int gRf;
    protected int gRg;
    protected int gRh;
    protected int gRi;
    protected boolean gRj;
    protected boolean gRk;
    protected boolean gRl;
    protected boolean gRm;
    protected boolean gRn;
    protected float gRo;
    protected ImageView glS;
    protected ImageView glT;
    protected TextView gnW;
    protected FrsFragment gqW;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gQC = 0;
    protected int gQD = 0;
    protected int gQE = 0;
    private boolean gRr = false;
    protected HashSet<String> gRs = new HashSet<>();
    protected final Runnable gRt = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cVv.getPageActivity());
            }
        }
    };
    private float gRu = -1.0f;

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bGZ();

    public abstract void bHk();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        gRp.put(1, "c0117");
        gRp.put(2, "c0124");
        gRp.put(3, "c0125");
        gRp.put(4, "c0126");
        gRp.put(5, "c0127");
    }

    public boolean bLS() {
        return this.gRj;
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

    public boolean bLT() {
        int[] iArr = new int[2];
        try {
            this.gQV.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bLU() {
        return this.gQI;
    }

    public BarImageView bLV() {
        return this.gQX;
    }

    public TextView bLW() {
        return this.aDi;
    }

    public TextView bLX() {
        return this.gnW;
    }

    public boolean bLb() {
        return this.gRl;
    }

    public void ml(boolean z) {
        this.gRk = z;
        this.gNt.setVisibility(this.gRk ? 0 : 4);
        if (this.gNJ != null) {
            this.gNJ.ml(z);
        }
    }

    public boolean bLc() {
        return this.gRm;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gRq.clear();
    }

    public void onStop() {
        bLY();
    }

    public void onPrimary(boolean z) {
        if (!z) {
            bLY();
        }
    }

    private void bLY() {
        if (this.gQW != null && this.gQW.isShowing()) {
            this.gQW.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mu(boolean z) {
        this.bFy = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gRb = str;
        this.mLevel = i2;
        if (i == 0) {
            this.gRj = false;
            this.gRr = false;
            this.gQK.setVisibility(0);
            this.gQL.setVisibility(8);
            return;
        }
        this.gRj = true;
        this.gQK.setVisibility(8);
        this.gQL.setVisibility(0);
        if (z && !this.gRr) {
            bHl();
            this.gRr = true;
        }
        c(false, f);
    }

    protected void bHl() {
    }

    public void uM(int i) {
        if (i == 0) {
            this.gRj = false;
            this.gRr = false;
            this.gQK.setVisibility(0);
            this.gQL.setVisibility(8);
            return;
        }
        this.gRj = true;
        this.gQK.setVisibility(8);
        this.gQL.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            uN(signData.is_signed);
            if (signData.forum_rank == -2) {
                ml(false);
                return;
            }
            ml(true);
            uN(signData.is_signed);
        }
    }

    public void uN(int i) {
        if (i == 0) {
            this.gRl = false;
            this.gNt.setText(this.cVv.getString(R.string.sign));
            bHc();
            return;
        }
        this.gRl = true;
        this.gNt.setText(this.cVv.getString(R.string.signed));
        bHb();
    }

    protected void bHc() {
    }

    protected void bHb() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bHm() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gQV, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gQV, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gRi));
        String string = this.cVv.getString(R.string.experience_divider);
        String string2 = this.cVv.getString(R.string.member_count_unit);
        if (this.gNw >= 10000) {
            if (this.gNw % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gNw / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gNw / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gNw));
    }

    public void c(boolean z, float f) {
    }

    public void bHh() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gNJ = gVar;
            this.gNJ.e(this.gNt);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gNK = fVar;
            this.gNK.e(this.gNm);
        }
    }
}

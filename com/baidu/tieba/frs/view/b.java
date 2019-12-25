package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
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
/* loaded from: classes6.dex */
public abstract class b {
    private static HashMap<Integer, String> gKH = new HashMap<>();
    private static HashSet<Integer> gKI = new HashSet<>();
    protected TextView axT;
    protected int azk;
    protected boolean bAs;
    protected TbPageContext cQU;
    protected LinearGradientView gFu;
    protected TBSpecificationBtn gGF;
    protected TBSpecificationBtn gGM;
    protected int gGP;
    protected g gHc;
    protected f gHd;
    protected FrsViewData gHv;
    protected TextView gJX;
    protected TextView gJY;
    protected TextView gJZ;
    protected int gKA;
    protected boolean gKB;
    protected boolean gKC;
    protected boolean gKD;
    protected boolean gKE;
    protected boolean gKF;
    protected float gKG;
    protected View gKa;
    protected TextView gKb;
    protected RelativeLayout gKc;
    protected RelativeLayout gKd;
    protected View gKe;
    protected TextView gKf;
    protected RelativeLayout gKg;
    protected RelativeLayout gKh;
    protected TbImageView gKi;
    protected FrsTopView gKj;
    protected View gKk;
    protected TextView gKl;
    protected TextView gKm;
    protected ImageView gKn;
    protected PopupWindow gKo;
    protected BarImageView gKp;
    protected UserIconBox gKq;
    protected ArrayList<j> gKr;
    protected com.baidu.tieba.frs.f.b gKs;
    protected String gKt;
    protected String gKu;
    protected String gKv;
    protected bj gKw;
    protected int gKx;
    protected int gKy;
    protected int gKz;
    protected ImageView gfK;
    protected ImageView gfL;
    protected TextView ghN;
    protected FrsFragment gkN;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gJU = 0;
    protected int gJV = 0;
    protected int gJW = 0;
    private boolean gKJ = false;
    protected HashSet<String> gKK = new HashSet<>();
    protected final Runnable gKL = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cQU.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bEd();

    public abstract void bEo();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void y(View.OnClickListener onClickListener);

    static {
        gKH.put(1, "c0117");
        gKH.put(2, "c0124");
        gKH.put(3, "c0125");
        gKH.put(4, "c0126");
        gKH.put(5, "c0127");
    }

    public boolean bIX() {
        return this.gKB;
    }

    public void a(TbPageContextSupport tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport tbPageContextSupport, final View view, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
                scaleAnimation2.setFillAfter(true);
                scaleAnimation2.setDuration(300L);
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.2.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, f2, 1.0f, 1.0f);
                        scaleAnimation3.setFillAfter(true);
                        scaleAnimation3.setDuration(300L);
                        view.startAnimation(scaleAnimation3);
                    }
                });
            }
        });
    }

    public boolean bIY() {
        int[] iArr = new int[2];
        try {
            this.gKn.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bIZ() {
        return this.gKa;
    }

    public BarImageView bJa() {
        return this.gKp;
    }

    public TextView bJb() {
        return this.axT;
    }

    public TextView bJc() {
        return this.ghN;
    }

    public boolean bIi() {
        return this.gKD;
    }

    public void lS(boolean z) {
        this.gKC = z;
        this.gGM.setVisibility(this.gKC ? 0 : 4);
        if (this.gHc != null) {
            this.gHc.lS(z);
        }
    }

    public boolean bIj() {
        return this.gKE;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gKI.clear();
    }

    public void onStop() {
        bJd();
    }

    public void kV(boolean z) {
        if (!z) {
            bJd();
        }
    }

    private void bJd() {
        if (this.gKo != null && this.gKo.isShowing()) {
            this.gKo.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mb(boolean z) {
        this.bAs = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gKt = str;
        this.azk = i2;
        if (i == 0) {
            this.gKB = false;
            this.gKJ = false;
            this.gKc.setVisibility(0);
            this.gKd.setVisibility(8);
            return;
        }
        this.gKB = true;
        this.gKc.setVisibility(8);
        this.gKd.setVisibility(0);
        if (z && !this.gKJ) {
            bEp();
            this.gKJ = true;
        }
        c(false, f);
    }

    protected void bEp() {
    }

    public void uu(int i) {
        if (i == 0) {
            this.gKB = false;
            this.gKJ = false;
            this.gKc.setVisibility(0);
            this.gKd.setVisibility(8);
            return;
        }
        this.gKB = true;
        this.gKc.setVisibility(8);
        this.gKd.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            uv(signData.is_signed);
            if (signData.forum_rank == -2) {
                lS(false);
                return;
            }
            lS(true);
            uv(signData.is_signed);
        }
    }

    public void uv(int i) {
        if (i == 0) {
            this.gKD = false;
            this.gGM.setText(this.cQU.getString(R.string.sign));
            bEg();
            return;
        }
        this.gKD = true;
        this.gGM.setText(this.cQU.getString(R.string.signed));
        bEf();
    }

    protected void bEg() {
    }

    protected void bEf() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bEq() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gKn, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gKn, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gKA));
        String string = this.cQU.getString(R.string.experience_divider);
        String string2 = this.cQU.getString(R.string.member_count_unit);
        if (this.gGP >= 10000) {
            if (this.gGP % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gGP / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gGP / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gGP));
    }

    public void c(boolean z, float f) {
    }

    public void bEl() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gHc = gVar;
            this.gHc.e(this.gGM);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gHd = fVar;
            this.gHd.e(this.gGF);
        }
    }
}

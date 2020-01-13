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
/* loaded from: classes7.dex */
public abstract class b {
    private static HashMap<Integer, String> gNU = new HashMap<>();
    private static HashSet<Integer> gNV = new HashSet<>();
    protected TextView ayC;
    protected boolean bBf;
    protected TbPageContext cRe;
    protected LinearGradientView gIJ;
    protected TBSpecificationBtn gJU;
    protected FrsViewData gKI;
    protected TBSpecificationBtn gKb;
    protected int gKe;
    protected g gKr;
    protected f gKs;
    protected ImageView gNA;
    protected PopupWindow gNB;
    protected BarImageView gNC;
    protected UserIconBox gND;
    protected ArrayList<j> gNE;
    protected com.baidu.tieba.frs.f.b gNF;
    protected String gNG;
    protected String gNH;
    protected String gNI;
    protected bj gNJ;
    protected int gNK;
    protected int gNL;
    protected int gNM;
    protected int gNN;
    protected boolean gNO;
    protected boolean gNP;
    protected boolean gNQ;
    protected boolean gNR;
    protected boolean gNS;
    protected float gNT;
    protected TextView gNk;
    protected TextView gNl;
    protected TextView gNm;
    protected View gNn;
    protected TextView gNo;
    protected RelativeLayout gNp;
    protected RelativeLayout gNq;
    protected View gNr;
    protected TextView gNs;
    protected RelativeLayout gNt;
    protected RelativeLayout gNu;
    protected TbImageView gNv;
    protected FrsTopView gNw;
    protected View gNx;
    protected TextView gNy;
    protected TextView gNz;
    protected ImageView giU;
    protected ImageView giV;
    protected TextView gkX;
    protected FrsFragment gnW;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int gNh = 0;
    protected int gNi = 0;
    protected int gNj = 0;
    private boolean gNW = false;
    protected HashSet<String> gNX = new HashSet<>();
    protected final Runnable gNY = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.mPopup, b.this.cRe.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bFf();

    public abstract void bFq();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void x(View.OnClickListener onClickListener);

    static {
        gNU.put(1, "c0117");
        gNU.put(2, "c0124");
        gNU.put(3, "c0125");
        gNU.put(4, "c0126");
        gNU.put(5, "c0127");
    }

    public boolean bJZ() {
        return this.gNO;
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

    public boolean bKa() {
        int[] iArr = new int[2];
        try {
            this.gNA.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bKb() {
        return this.gNn;
    }

    public BarImageView bKc() {
        return this.gNC;
    }

    public TextView bKd() {
        return this.ayC;
    }

    public TextView bKe() {
        return this.gkX;
    }

    public boolean bJk() {
        return this.gNQ;
    }

    public void md(boolean z) {
        this.gNP = z;
        this.gKb.setVisibility(this.gNP ? 0 : 4);
        if (this.gKr != null) {
            this.gKr.md(z);
        }
    }

    public boolean bJl() {
        return this.gNR;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        gNV.clear();
    }

    public void onStop() {
        bKf();
    }

    public void lg(boolean z) {
        if (!z) {
            bKf();
        }
    }

    private void bKf() {
        if (this.gNB != null && this.gNB.isShowing()) {
            this.gNB.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void mm(boolean z) {
        this.bBf = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.gNG = str;
        this.mLevel = i2;
        if (i == 0) {
            this.gNO = false;
            this.gNW = false;
            this.gNp.setVisibility(0);
            this.gNq.setVisibility(8);
            return;
        }
        this.gNO = true;
        this.gNp.setVisibility(8);
        this.gNq.setVisibility(0);
        if (z && !this.gNW) {
            bFr();
            this.gNW = true;
        }
        c(false, f);
    }

    protected void bFr() {
    }

    public void uz(int i) {
        if (i == 0) {
            this.gNO = false;
            this.gNW = false;
            this.gNp.setVisibility(0);
            this.gNq.setVisibility(8);
            return;
        }
        this.gNO = true;
        this.gNp.setVisibility(8);
        this.gNq.setVisibility(0);
    }

    public void a(SignData signData) {
        if (signData != null) {
            uA(signData.is_signed);
            if (signData.forum_rank == -2) {
                md(false);
                return;
            }
            md(true);
            uA(signData.is_signed);
        }
    }

    public void uA(int i) {
        if (i == 0) {
            this.gNQ = false;
            this.gKb.setText(this.cRe.getString(R.string.sign));
            bFi();
            return;
        }
        this.gNQ = true;
        this.gKb.setText(this.cRe.getString(R.string.signed));
        bFh();
    }

    protected void bFi() {
    }

    protected void bFh() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bFs() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gNA, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.gNA, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.gNN));
        String string = this.cRe.getString(R.string.experience_divider);
        String string2 = this.cRe.getString(R.string.member_count_unit);
        if (this.gKe >= 10000) {
            if (this.gKe % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.gKe / 10000) + string2);
                return;
            } else {
                textView2.setText(string + String.valueOf(this.gKe / 10000.0f) + string2);
                return;
            }
        }
        textView2.setText(string + String.valueOf(this.gKe));
    }

    public void c(boolean z, float f) {
    }

    public void bFn() {
    }

    public void c(s sVar) {
    }

    public void f(g gVar) {
        if (gVar != null) {
            this.gKr = gVar;
            this.gKr.e(this.gKb);
        }
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.gKs = fVar;
            this.gKs.e(this.gJU);
        }
    }
}

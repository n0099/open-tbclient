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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class b {
    private static HashMap<Integer, String> fQb = new HashMap<>();
    private static HashSet<Integer> fQc = new HashSet<>();
    protected boolean aDh;
    protected TbImageView eQP;
    protected LinearGradientView fLe;
    protected FrsViewData fMR;
    protected int fMn;
    protected TextView fPA;
    protected RelativeLayout fPB;
    protected RelativeLayout fPC;
    protected FrsTopView fPD;
    protected View fPE;
    protected TextView fPF;
    protected TextView fPG;
    protected ImageView fPH;
    protected PopupWindow fPI;
    protected BarImageView fPJ;
    protected UserIconBox fPK;
    protected ArrayList<j> fPL;
    protected com.baidu.tieba.frs.f.b fPM;
    protected String fPN;
    protected String fPO;
    protected String fPP;
    protected bg fPQ;
    protected int fPR;
    protected int fPS;
    protected int fPT;
    protected int fPU;
    protected boolean fPV;
    protected boolean fPW;
    protected boolean fPX;
    protected boolean fPY;
    protected boolean fPZ;
    protected TextView fPq;
    protected TextView fPr;
    protected TextView fPs;
    protected TextView fPt;
    protected TextView fPu;
    protected View fPv;
    protected TextView fPw;
    protected RelativeLayout fPx;
    protected RelativeLayout fPy;
    protected View fPz;
    protected float fQa;
    protected TextView faq;
    protected ImageView flH;
    protected ImageView flI;
    protected TextView fnI;
    protected FrsFragment fqJ;
    protected TbPageContext mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int fPn = 0;
    protected int fPo = 0;
    protected int fPp = 0;
    private boolean fQd = false;
    protected HashSet<String> fQe = new HashSet<>();
    protected final Runnable fQf = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bmE();

    public abstract void bmP();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void v(View.OnClickListener onClickListener);

    static {
        fQb.put(1, "c0117");
        fQb.put(2, "c0124");
        fQb.put(3, "c0125");
        fQb.put(4, "c0126");
        fQb.put(5, "c0127");
    }

    public boolean brt() {
        return this.fPV;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view, float f, final float f2) {
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

    public boolean bru() {
        int[] iArr = new int[2];
        try {
            this.fPH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View brv() {
        return this.fPv;
    }

    public BarImageView brw() {
        return this.fPJ;
    }

    public TextView brx() {
        return this.faq;
    }

    public TextView bry() {
        return this.fnI;
    }

    public boolean bqC() {
        return this.fPX;
    }

    public void kN(boolean z) {
        this.fPW = z;
        this.fPt.setVisibility(this.fPW ? 0 : 4);
    }

    public boolean bqD() {
        return this.fPY;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fQc.clear();
    }

    public void onStop() {
        brz();
    }

    public void jI(boolean z) {
        if (!z) {
            brz();
        }
    }

    private void brz() {
        if (this.fPI != null && this.fPI.isShowing()) {
            this.fPI.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kO(boolean z) {
        this.aDh = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fPN = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fPV = false;
            this.fQd = false;
            this.fPx.setVisibility(0);
            this.fPy.setVisibility(8);
            return;
        }
        this.fPV = true;
        this.fPx.setVisibility(8);
        this.fPy.setVisibility(0);
        if (z && !this.fQd) {
            bmQ();
            this.fQd = true;
        }
        d(false, f);
    }

    protected void bmQ() {
    }

    public void sV(int i) {
        if (i == 0) {
            this.fPV = false;
            this.fQd = false;
            this.fPx.setVisibility(0);
            this.fPy.setVisibility(8);
            return;
        }
        this.fPV = true;
        this.fPx.setVisibility(8);
        this.fPy.setVisibility(0);
    }

    public void sW(int i) {
        if (i == 0) {
            this.fPX = false;
            this.fPt.setText(R.string.sign);
            bmH();
            return;
        }
        this.fPX = true;
        this.fPt.setText(R.string.signed);
        bmG();
    }

    protected void bmH() {
    }

    protected void bmG() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bmR() {
        if (this.mMemberType != 0) {
            al.c(this.fPH, (int) R.drawable.icon_speed_orange);
        } else {
            al.c(this.fPH, (int) R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fPU));
        if (this.fMn >= 10000) {
            if (this.fMn % 10000 == 0) {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMn / 10000) + this.mContext.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMn / 10000.0f) + this.mContext.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMn));
    }

    public void d(boolean z, float f) {
    }

    public void bmM() {
    }

    public void b(s sVar) {
    }
}

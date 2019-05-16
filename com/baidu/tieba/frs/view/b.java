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
    private static HashMap<Integer, String> fPY = new HashMap<>();
    private static HashSet<Integer> fPZ = new HashSet<>();
    protected boolean aDh;
    protected TbImageView eQO;
    protected LinearGradientView fLb;
    protected FrsViewData fMO;
    protected int fMk;
    protected FrsTopView fPA;
    protected View fPB;
    protected TextView fPC;
    protected TextView fPD;
    protected ImageView fPE;
    protected PopupWindow fPF;
    protected BarImageView fPG;
    protected UserIconBox fPH;
    protected ArrayList<j> fPI;
    protected com.baidu.tieba.frs.f.b fPJ;
    protected String fPK;
    protected String fPL;
    protected String fPM;
    protected bg fPN;
    protected int fPO;
    protected int fPP;
    protected int fPQ;
    protected int fPR;
    protected boolean fPS;
    protected boolean fPT;
    protected boolean fPU;
    protected boolean fPV;
    protected boolean fPW;
    protected float fPX;
    protected TextView fPn;
    protected TextView fPo;
    protected TextView fPp;
    protected TextView fPq;
    protected TextView fPr;
    protected View fPs;
    protected TextView fPt;
    protected RelativeLayout fPu;
    protected RelativeLayout fPv;
    protected View fPw;
    protected TextView fPx;
    protected RelativeLayout fPy;
    protected RelativeLayout fPz;
    protected TextView fap;
    protected ImageView flG;
    protected ImageView flH;
    protected TextView fnH;
    protected FrsFragment fqI;
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
    protected int fPk = 0;
    protected int fPl = 0;
    protected int fPm = 0;
    private boolean fQa = false;
    protected HashSet<String> fQb = new HashSet<>();
    protected final Runnable fQc = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bmB();

    public abstract void bmM();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void v(View.OnClickListener onClickListener);

    static {
        fPY.put(1, "c0117");
        fPY.put(2, "c0124");
        fPY.put(3, "c0125");
        fPY.put(4, "c0126");
        fPY.put(5, "c0127");
    }

    public boolean bro() {
        return this.fPS;
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

    public boolean brp() {
        int[] iArr = new int[2];
        try {
            this.fPE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View brq() {
        return this.fPs;
    }

    public BarImageView brr() {
        return this.fPG;
    }

    public TextView brs() {
        return this.fap;
    }

    public TextView brt() {
        return this.fnH;
    }

    public boolean bqx() {
        return this.fPU;
    }

    public void kM(boolean z) {
        this.fPT = z;
        this.fPq.setVisibility(this.fPT ? 0 : 4);
    }

    public boolean bqy() {
        return this.fPV;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fPZ.clear();
    }

    public void onStop() {
        bru();
    }

    public void jI(boolean z) {
        if (!z) {
            bru();
        }
    }

    private void bru() {
        if (this.fPF != null && this.fPF.isShowing()) {
            this.fPF.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kN(boolean z) {
        this.aDh = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fPK = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fPS = false;
            this.fQa = false;
            this.fPu.setVisibility(0);
            this.fPv.setVisibility(8);
            return;
        }
        this.fPS = true;
        this.fPu.setVisibility(8);
        this.fPv.setVisibility(0);
        if (z && !this.fQa) {
            bmN();
            this.fQa = true;
        }
        d(false, f);
    }

    protected void bmN() {
    }

    public void sV(int i) {
        if (i == 0) {
            this.fPS = false;
            this.fQa = false;
            this.fPu.setVisibility(0);
            this.fPv.setVisibility(8);
            return;
        }
        this.fPS = true;
        this.fPu.setVisibility(8);
        this.fPv.setVisibility(0);
    }

    public void sW(int i) {
        if (i == 0) {
            this.fPU = false;
            this.fPq.setText(R.string.sign);
            bmE();
            return;
        }
        this.fPU = true;
        this.fPq.setText(R.string.signed);
        bmD();
    }

    protected void bmE() {
    }

    protected void bmD() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bmO() {
        if (this.mMemberType != 0) {
            al.c(this.fPE, (int) R.drawable.icon_speed_orange);
        } else {
            al.c(this.fPE, (int) R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fPR));
        if (this.fMk >= 10000) {
            if (this.fMk % 10000 == 0) {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMk / 10000) + this.mContext.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMk / 10000.0f) + this.mContext.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fMk));
    }

    public void d(boolean z, float f) {
    }

    public void bmJ() {
    }

    public void b(s sVar) {
    }
}

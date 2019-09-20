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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.am;
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
    private static HashMap<Integer, String> fXF = new HashMap<>();
    private static HashSet<Integer> fXG = new HashSet<>();
    protected boolean aEn;
    protected TbImageView eXD;
    protected LinearGradientView fSH;
    protected int fTP;
    protected FrsViewData fUt;
    protected TextView fWU;
    protected TextView fWV;
    protected TextView fWW;
    protected TextView fWX;
    protected TextView fWY;
    protected View fWZ;
    protected boolean fXA;
    protected boolean fXB;
    protected boolean fXC;
    protected boolean fXD;
    protected float fXE;
    protected TextView fXa;
    protected RelativeLayout fXb;
    protected RelativeLayout fXc;
    protected View fXd;
    protected TextView fXe;
    protected RelativeLayout fXf;
    protected RelativeLayout fXg;
    protected FrsTopView fXh;
    protected View fXi;
    protected TextView fXj;
    protected TextView fXk;
    protected ImageView fXl;
    protected PopupWindow fXm;
    protected BarImageView fXn;
    protected UserIconBox fXo;
    protected ArrayList<j> fXp;
    protected com.baidu.tieba.frs.f.b fXq;
    protected String fXr;
    protected String fXs;
    protected String fXt;
    protected bh fXu;
    protected int fXv;
    protected int fXw;
    protected int fXx;
    protected int fXy;
    protected boolean fXz;
    protected TextView fhE;
    protected ImageView fsS;
    protected ImageView fsT;
    protected TextView fuT;
    protected FrsFragment fxT;
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
    protected int fWR = 0;
    protected int fWS = 0;
    protected int fWT = 0;
    private boolean fXH = false;
    protected HashSet<String> fXI = new HashSet<>();
    protected final Runnable fXJ = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bpD();

    public abstract void bpO();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void v(View.OnClickListener onClickListener);

    static {
        fXF.put(1, "c0117");
        fXF.put(2, "c0124");
        fXF.put(3, "c0125");
        fXF.put(4, "c0126");
        fXF.put(5, "c0127");
    }

    public boolean buv() {
        return this.fXz;
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

    public boolean buw() {
        int[] iArr = new int[2];
        try {
            this.fXl.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bux() {
        return this.fWZ;
    }

    public BarImageView buy() {
        return this.fXn;
    }

    public TextView buz() {
        return this.fhE;
    }

    public TextView buA() {
        return this.fuT;
    }

    public boolean btD() {
        return this.fXB;
    }

    public void la(boolean z) {
        this.fXA = z;
        this.fWX.setVisibility(this.fXA ? 0 : 4);
    }

    public boolean btE() {
        return this.fXC;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fXG.clear();
    }

    public void onStop() {
        buB();
    }

    public void jV(boolean z) {
        if (!z) {
            buB();
        }
    }

    private void buB() {
        if (this.fXm != null && this.fXm.isShowing()) {
            this.fXm.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void lb(boolean z) {
        this.aEn = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fXr = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fXz = false;
            this.fXH = false;
            this.fXb.setVisibility(0);
            this.fXc.setVisibility(8);
            return;
        }
        this.fXz = true;
        this.fXb.setVisibility(8);
        this.fXc.setVisibility(0);
        if (z && !this.fXH) {
            bpP();
            this.fXH = true;
        }
        d(false, f);
    }

    protected void bpP() {
    }

    public void tt(int i) {
        if (i == 0) {
            this.fXz = false;
            this.fXH = false;
            this.fXb.setVisibility(0);
            this.fXc.setVisibility(8);
            return;
        }
        this.fXz = true;
        this.fXb.setVisibility(8);
        this.fXc.setVisibility(0);
    }

    public void tu(int i) {
        if (i == 0) {
            this.fXB = false;
            this.fWX.setText(R.string.sign);
            bpG();
            return;
        }
        this.fXB = true;
        this.fWX.setText(R.string.signed);
        bpF();
    }

    protected void bpG() {
    }

    protected void bpF() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bpQ() {
        if (this.mMemberType != 0) {
            am.c(this.fXl, (int) R.drawable.icon_speed_orange);
        } else {
            am.c(this.fXl, (int) R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fXy));
        if (this.fTP >= 10000) {
            if (this.fTP % 10000 == 0) {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fTP / 10000) + this.mContext.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fTP / 10000.0f) + this.mContext.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fTP));
    }

    public void d(boolean z, float f) {
    }

    public void bpL() {
    }

    public void b(s sVar) {
    }
}

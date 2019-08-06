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
    private static HashMap<Integer, String> fVO = new HashMap<>();
    private static HashSet<Integer> fVP = new HashSet<>();
    protected boolean aDP;
    protected TbImageView eVX;
    protected LinearGradientView fQQ;
    protected int fRY;
    protected FrsViewData fSC;
    protected String fVA;
    protected String fVB;
    protected String fVC;
    protected bh fVD;
    protected int fVE;
    protected int fVF;
    protected int fVG;
    protected int fVH;
    protected boolean fVI;
    protected boolean fVJ;
    protected boolean fVK;
    protected boolean fVL;
    protected boolean fVM;
    protected float fVN;
    protected TextView fVd;
    protected TextView fVe;
    protected TextView fVf;
    protected TextView fVg;
    protected TextView fVh;
    protected View fVi;
    protected TextView fVj;
    protected RelativeLayout fVk;
    protected RelativeLayout fVl;
    protected View fVm;
    protected TextView fVn;
    protected RelativeLayout fVo;
    protected RelativeLayout fVp;
    protected FrsTopView fVq;
    protected View fVr;
    protected TextView fVs;
    protected TextView fVt;
    protected ImageView fVu;
    protected PopupWindow fVv;
    protected BarImageView fVw;
    protected UserIconBox fVx;
    protected ArrayList<j> fVy;
    protected com.baidu.tieba.frs.f.b fVz;
    protected TextView ffR;
    protected ImageView fre;
    protected ImageView frf;
    protected TextView ftg;
    protected FrsFragment fwg;
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
    protected int fVa = 0;
    protected int fVb = 0;
    protected int fVc = 0;
    private boolean fVQ = false;
    protected HashSet<String> fVR = new HashSet<>();
    protected final Runnable fVS = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void boS();

    public abstract void bpd();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void v(View.OnClickListener onClickListener);

    static {
        fVO.put(1, "c0117");
        fVO.put(2, "c0124");
        fVO.put(3, "c0125");
        fVO.put(4, "c0126");
        fVO.put(5, "c0127");
    }

    public boolean btH() {
        return this.fVI;
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

    public boolean btI() {
        int[] iArr = new int[2];
        try {
            this.fVu.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View btJ() {
        return this.fVi;
    }

    public BarImageView btK() {
        return this.fVw;
    }

    public TextView btL() {
        return this.ffR;
    }

    public TextView btM() {
        return this.ftg;
    }

    public boolean bsQ() {
        return this.fVK;
    }

    public void kX(boolean z) {
        this.fVJ = z;
        this.fVg.setVisibility(this.fVJ ? 0 : 4);
    }

    public boolean bsR() {
        return this.fVL;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fVP.clear();
    }

    public void onStop() {
        btN();
    }

    public void jS(boolean z) {
        if (!z) {
            btN();
        }
    }

    private void btN() {
        if (this.fVv != null && this.fVv.isShowing()) {
            this.fVv.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kY(boolean z) {
        this.aDP = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fVA = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fVI = false;
            this.fVQ = false;
            this.fVk.setVisibility(0);
            this.fVl.setVisibility(8);
            return;
        }
        this.fVI = true;
        this.fVk.setVisibility(8);
        this.fVl.setVisibility(0);
        if (z && !this.fVQ) {
            bpe();
            this.fVQ = true;
        }
        d(false, f);
    }

    protected void bpe() {
    }

    public void tp(int i) {
        if (i == 0) {
            this.fVI = false;
            this.fVQ = false;
            this.fVk.setVisibility(0);
            this.fVl.setVisibility(8);
            return;
        }
        this.fVI = true;
        this.fVk.setVisibility(8);
        this.fVl.setVisibility(0);
    }

    public void tq(int i) {
        if (i == 0) {
            this.fVK = false;
            this.fVg.setText(R.string.sign);
            boV();
            return;
        }
        this.fVK = true;
        this.fVg.setText(R.string.signed);
        boU();
    }

    protected void boV() {
    }

    protected void boU() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bpf() {
        if (this.mMemberType != 0) {
            am.c(this.fVu, (int) R.drawable.icon_speed_orange);
        } else {
            am.c(this.fVu, (int) R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fVH));
        if (this.fRY >= 10000) {
            if (this.fRY % 10000 == 0) {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRY / 10000) + this.mContext.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRY / 10000.0f) + this.mContext.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(R.string.experience_divider) + String.valueOf(this.fRY));
    }

    public void d(boolean z, float f) {
    }

    public void bpa() {
    }

    public void b(s sVar) {
    }
}

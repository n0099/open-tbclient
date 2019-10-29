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
    private static HashMap<Integer, String> fXa = new HashMap<>();
    private static HashSet<Integer> fXb = new HashSet<>();
    protected boolean aXC;
    protected TextView aqv;
    protected int arR;
    protected TbPageContext cfl;
    protected LinearGradientView fSa;
    protected FrsViewData fTN;
    protected int fTj;
    protected RelativeLayout fWA;
    protected RelativeLayout fWB;
    protected FrsTopView fWC;
    protected View fWD;
    protected TextView fWE;
    protected TextView fWF;
    protected ImageView fWG;
    protected PopupWindow fWH;
    protected BarImageView fWI;
    protected UserIconBox fWJ;
    protected ArrayList<j> fWK;
    protected com.baidu.tieba.frs.f.b fWL;
    protected String fWM;
    protected String fWN;
    protected String fWO;
    protected bh fWP;
    protected int fWQ;
    protected int fWR;
    protected int fWS;
    protected int fWT;
    protected boolean fWU;
    protected boolean fWV;
    protected boolean fWW;
    protected boolean fWX;
    protected boolean fWY;
    protected float fWZ;
    protected TextView fWp;
    protected TextView fWq;
    protected TextView fWr;
    protected TextView fWs;
    protected TextView fWt;
    protected View fWu;
    protected TextView fWv;
    protected RelativeLayout fWw;
    protected RelativeLayout fWx;
    protected View fWy;
    protected TextView fWz;
    protected TbImageView fap;
    protected ImageView fsf;
    protected ImageView fsg;
    protected TextView fug;
    protected FrsFragment fxh;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int fWm = 0;
    protected int fWn = 0;
    protected int fWo = 0;
    private boolean fXc = false;
    protected HashSet<String> fXd = new HashSet<>();
    protected final Runnable fXe = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.dismissPopupWindow(b.this.mPopup, b.this.cfl.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bmI();

    public abstract void bmT();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void w(View.OnClickListener onClickListener);

    static {
        fXa.put(1, "c0117");
        fXa.put(2, "c0124");
        fXa.put(3, "c0125");
        fXa.put(4, "c0126");
        fXa.put(5, "c0127");
    }

    public boolean brx() {
        return this.fWU;
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

    public boolean bry() {
        int[] iArr = new int[2];
        try {
            this.fWG.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View brz() {
        return this.fWu;
    }

    public BarImageView brA() {
        return this.fWI;
    }

    public TextView brB() {
        return this.aqv;
    }

    public TextView brC() {
        return this.fug;
    }

    public boolean bqG() {
        return this.fWW;
    }

    public void kN(boolean z) {
        this.fWV = z;
        this.fWs.setVisibility(this.fWV ? 0 : 4);
    }

    public boolean bqH() {
        return this.fWX;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fXb.clear();
    }

    public void onStop() {
        brD();
    }

    public void jJ(boolean z) {
        if (!z) {
            brD();
        }
    }

    private void brD() {
        if (this.fWH != null && this.fWH.isShowing()) {
            this.fWH.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kO(boolean z) {
        this.aXC = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fWM = str;
        this.arR = i2;
        if (i == 0) {
            this.fWU = false;
            this.fXc = false;
            this.fWw.setVisibility(0);
            this.fWx.setVisibility(8);
            return;
        }
        this.fWU = true;
        this.fWw.setVisibility(8);
        this.fWx.setVisibility(0);
        if (z && !this.fXc) {
            bmU();
            this.fXc = true;
        }
        d(false, f);
    }

    protected void bmU() {
    }

    public void sn(int i) {
        if (i == 0) {
            this.fWU = false;
            this.fXc = false;
            this.fWw.setVisibility(0);
            this.fWx.setVisibility(8);
            return;
        }
        this.fWU = true;
        this.fWw.setVisibility(8);
        this.fWx.setVisibility(0);
    }

    public void so(int i) {
        if (i == 0) {
            this.fWW = false;
            this.fWs.setText(R.string.sign);
            bmL();
            return;
        }
        this.fWW = true;
        this.fWs.setText(R.string.signed);
        bmK();
    }

    protected void bmL() {
    }

    protected void bmK() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bmV() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.fWG, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.fWG, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fWT));
        if (this.fTj >= 10000) {
            if (this.fTj % 10000 == 0) {
                textView2.setText(this.cfl.getString(R.string.experience_divider) + String.valueOf(this.fTj / 10000) + this.cfl.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.cfl.getString(R.string.experience_divider) + String.valueOf(this.fTj / 10000.0f) + this.cfl.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.cfl.getString(R.string.experience_divider) + String.valueOf(this.fTj));
    }

    public void d(boolean z, float f) {
    }

    public void bmQ() {
    }

    public void c(s sVar) {
    }
}

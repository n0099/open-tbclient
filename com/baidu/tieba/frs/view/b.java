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
    private static HashMap<Integer, String> fWj = new HashMap<>();
    private static HashSet<Integer> fWk = new HashSet<>();
    protected boolean aXk;
    protected TextView aqd;
    protected int arz;
    protected TbPageContext ceu;
    protected TbImageView eZy;
    protected LinearGradientView fRj;
    protected FrsViewData fSW;
    protected int fSs;
    protected TextView fVA;
    protected TextView fVB;
    protected TextView fVC;
    protected View fVD;
    protected TextView fVE;
    protected RelativeLayout fVF;
    protected RelativeLayout fVG;
    protected View fVH;
    protected TextView fVI;
    protected RelativeLayout fVJ;
    protected RelativeLayout fVK;
    protected FrsTopView fVL;
    protected View fVM;
    protected TextView fVN;
    protected TextView fVO;
    protected ImageView fVP;
    protected PopupWindow fVQ;
    protected BarImageView fVR;
    protected UserIconBox fVS;
    protected ArrayList<j> fVT;
    protected com.baidu.tieba.frs.f.b fVU;
    protected String fVV;
    protected String fVW;
    protected String fVX;
    protected bh fVY;
    protected int fVZ;
    protected TextView fVy;
    protected TextView fVz;
    protected int fWa;
    protected int fWb;
    protected int fWc;
    protected boolean fWd;
    protected boolean fWe;
    protected boolean fWf;
    protected boolean fWg;
    protected boolean fWh;
    protected float fWi;
    protected ImageView frn;
    protected ImageView fro;
    protected TextView ftp;
    protected FrsFragment fwq;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected int fVv = 0;
    protected int fVw = 0;
    protected int fVx = 0;
    private boolean fWl = false;
    protected HashSet<String> fWm = new HashSet<>();
    protected final Runnable fWn = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.dismissPopupWindow(b.this.mPopup, b.this.ceu.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bmG();

    public abstract void bmR();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void w(View.OnClickListener onClickListener);

    static {
        fWj.put(1, "c0117");
        fWj.put(2, "c0124");
        fWj.put(3, "c0125");
        fWj.put(4, "c0126");
        fWj.put(5, "c0127");
    }

    public boolean brv() {
        return this.fWd;
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

    public boolean brw() {
        int[] iArr = new int[2];
        try {
            this.fVP.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View brx() {
        return this.fVD;
    }

    public BarImageView bry() {
        return this.fVR;
    }

    public TextView brz() {
        return this.aqd;
    }

    public TextView brA() {
        return this.ftp;
    }

    public boolean bqE() {
        return this.fWf;
    }

    public void kN(boolean z) {
        this.fWe = z;
        this.fVB.setVisibility(this.fWe ? 0 : 4);
    }

    public boolean bqF() {
        return this.fWg;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fWk.clear();
    }

    public void onStop() {
        brB();
    }

    public void jJ(boolean z) {
        if (!z) {
            brB();
        }
    }

    private void brB() {
        if (this.fVQ != null && this.fVQ.isShowing()) {
            this.fVQ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void kO(boolean z) {
        this.aXk = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fVV = str;
        this.arz = i2;
        if (i == 0) {
            this.fWd = false;
            this.fWl = false;
            this.fVF.setVisibility(0);
            this.fVG.setVisibility(8);
            return;
        }
        this.fWd = true;
        this.fVF.setVisibility(8);
        this.fVG.setVisibility(0);
        if (z && !this.fWl) {
            bmS();
            this.fWl = true;
        }
        d(false, f);
    }

    protected void bmS() {
    }

    public void sm(int i) {
        if (i == 0) {
            this.fWd = false;
            this.fWl = false;
            this.fVF.setVisibility(0);
            this.fVG.setVisibility(8);
            return;
        }
        this.fWd = true;
        this.fVF.setVisibility(8);
        this.fVG.setVisibility(0);
    }

    public void sn(int i) {
        if (i == 0) {
            this.fWf = false;
            this.fVB.setText(R.string.sign);
            bmJ();
            return;
        }
        this.fWf = true;
        this.fVB.setText(R.string.signed);
        bmI();
    }

    protected void bmJ() {
    }

    protected void bmI() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bmT() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.fVP, R.drawable.icon_speed_orange);
        } else {
            am.setImageResource(this.fVP, R.drawable.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fWc));
        if (this.fSs >= 10000) {
            if (this.fSs % 10000 == 0) {
                textView2.setText(this.ceu.getString(R.string.experience_divider) + String.valueOf(this.fSs / 10000) + this.ceu.getString(R.string.member_count_unit));
                return;
            } else {
                textView2.setText(this.ceu.getString(R.string.experience_divider) + String.valueOf(this.fSs / 10000.0f) + this.ceu.getString(R.string.member_count_unit));
                return;
            }
        }
        textView2.setText(this.ceu.getString(R.string.experience_divider) + String.valueOf(this.fSs));
    }

    public void d(boolean z, float f) {
    }

    public void bmO() {
    }

    public void c(s sVar) {
    }
}

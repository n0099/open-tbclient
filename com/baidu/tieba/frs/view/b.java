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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class b {
    private static HashMap<Integer, String> fze = new HashMap<>();
    private static HashSet<Integer> fzf = new HashSet<>();
    protected boolean aBB;
    protected TbImageView eBi;
    protected TextView eKf;
    protected ImageView eVv;
    protected ImageView eVw;
    protected TextView eXA;
    protected FrsFragment fat;
    protected LinearGradientView fuk;
    protected FrsViewData fvY;
    protected int fvt;
    protected RelativeLayout fyA;
    protected RelativeLayout fyB;
    protected View fyC;
    protected TextView fyD;
    protected RelativeLayout fyE;
    protected RelativeLayout fyF;
    protected FrsTopView fyG;
    protected View fyH;
    protected TextView fyI;
    protected TextView fyJ;
    protected ImageView fyK;
    protected PopupWindow fyL;
    protected BarImageView fyM;
    protected UserIconBox fyN;
    protected ArrayList<j> fyO;
    protected com.baidu.tieba.frs.f.b fyP;
    protected String fyQ;
    protected String fyR;
    protected String fyS;
    protected bg fyT;
    protected int fyU;
    protected int fyV;
    protected int fyW;
    protected int fyX;
    protected boolean fyY;
    protected boolean fyZ;
    protected TextView fyt;
    protected TextView fyu;
    protected TextView fyv;
    protected TextView fyw;
    protected TextView fyx;
    protected View fyy;
    protected TextView fyz;
    protected boolean fza;
    protected boolean fzb;
    protected boolean fzc;
    protected float fzd;
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
    protected int fyq = 0;
    protected int fyr = 0;
    protected int fys = 0;
    private boolean fzg = false;
    protected HashSet<String> fzh = new HashSet<>();
    protected final Runnable fzi = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bfi();

    public abstract void bft();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void t(View.OnClickListener onClickListener);

    static {
        fze.put(1, "c0117");
        fze.put(2, "c0124");
        fze.put(3, "c0125");
        fze.put(4, "c0126");
        fze.put(5, "c0127");
    }

    public boolean bjW() {
        return this.fyY;
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

    public boolean bjX() {
        int[] iArr = new int[2];
        try {
            this.fyK.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bjY() {
        return this.fyy;
    }

    public BarImageView bjZ() {
        return this.fyM;
    }

    public TextView bka() {
        return this.eKf;
    }

    public TextView bkb() {
        return this.eXA;
    }

    public boolean bjf() {
        return this.fza;
    }

    public void jX(boolean z) {
        this.fyZ = z;
        this.fyw.setVisibility(this.fyZ ? 0 : 4);
    }

    public boolean bjg() {
        return this.fzb;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fzf.clear();
    }

    public void onStop() {
        bkc();
    }

    public void iY(boolean z) {
        if (!z) {
            bkc();
        }
    }

    private void bkc() {
        if (this.fyL != null && this.fyL.isShowing()) {
            this.fyL.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void jY(boolean z) {
        this.aBB = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fyQ = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fyY = false;
            this.fzg = false;
            this.fyA.setVisibility(0);
            this.fyB.setVisibility(8);
            return;
        }
        this.fyY = true;
        this.fyA.setVisibility(8);
        this.fyB.setVisibility(0);
        if (z && !this.fzg) {
            bfu();
            this.fzg = true;
        }
        d(false, f);
    }

    protected void bfu() {
    }

    public void rN(int i) {
        if (i == 0) {
            this.fyY = false;
            this.fzg = false;
            this.fyA.setVisibility(0);
            this.fyB.setVisibility(8);
            return;
        }
        this.fyY = true;
        this.fyA.setVisibility(8);
        this.fyB.setVisibility(0);
    }

    public void rO(int i) {
        if (i == 0) {
            this.fza = false;
            this.fyw.setText(d.j.sign);
            bfl();
            return;
        }
        this.fza = true;
        this.fyw.setText(d.j.signed);
        bfk();
    }

    protected void bfl() {
    }

    protected void bfk() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bfv() {
        if (this.mMemberType != 0) {
            al.c(this.fyK, d.f.icon_speed_orange);
        } else {
            al.c(this.fyK, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fyX));
        if (this.fvt >= 10000) {
            if (this.fvt % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvt / 10000) + this.mContext.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvt / 10000.0f) + this.mContext.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvt));
    }

    public void d(boolean z, float f) {
    }

    public void bfq() {
    }

    public void b(s sVar) {
    }
}

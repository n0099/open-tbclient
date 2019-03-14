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
    private static HashMap<Integer, String> fzq = new HashMap<>();
    private static HashSet<Integer> fzr = new HashSet<>();
    protected boolean aBy;
    protected TbImageView eBx;
    protected TextView eKt;
    protected ImageView eVJ;
    protected ImageView eVK;
    protected TextView eXO;
    protected FrsFragment faG;
    protected LinearGradientView fuy;
    protected int fvH;
    protected FrsViewData fwm;
    protected TextView fyF;
    protected TextView fyG;
    protected TextView fyH;
    protected TextView fyI;
    protected TextView fyJ;
    protected View fyK;
    protected TextView fyL;
    protected RelativeLayout fyM;
    protected RelativeLayout fyN;
    protected View fyO;
    protected TextView fyP;
    protected RelativeLayout fyQ;
    protected RelativeLayout fyR;
    protected FrsTopView fyS;
    protected View fyT;
    protected TextView fyU;
    protected TextView fyV;
    protected ImageView fyW;
    protected PopupWindow fyX;
    protected BarImageView fyY;
    protected UserIconBox fyZ;
    protected ArrayList<j> fza;
    protected com.baidu.tieba.frs.f.b fzb;
    protected String fzc;
    protected String fzd;
    protected String fze;
    protected bg fzf;
    protected int fzg;
    protected int fzh;
    protected int fzi;
    protected int fzj;
    protected boolean fzk;
    protected boolean fzl;
    protected boolean fzm;
    protected boolean fzn;
    protected boolean fzo;
    protected float fzp;
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
    protected int fyC = 0;
    protected int fyD = 0;
    protected int fyE = 0;
    private boolean fzs = false;
    protected HashSet<String> fzt = new HashSet<>();
    protected final Runnable fzu = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, FrsViewData frsViewData);

    public abstract void bfk();

    public abstract void bfv();

    public abstract void changeSkinType(int i);

    public abstract void k(View view, boolean z);

    public abstract void t(View.OnClickListener onClickListener);

    static {
        fzq.put(1, "c0117");
        fzq.put(2, "c0124");
        fzq.put(3, "c0125");
        fzq.put(4, "c0126");
        fzq.put(5, "c0127");
    }

    public boolean bjY() {
        return this.fzk;
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

    public boolean bjZ() {
        int[] iArr = new int[2];
        try {
            this.fyW.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bka() {
        return this.fyK;
    }

    public BarImageView bkb() {
        return this.fyY;
    }

    public TextView bkc() {
        return this.eKt;
    }

    public TextView bkd() {
        return this.eXO;
    }

    public boolean bjh() {
        return this.fzm;
    }

    public void jX(boolean z) {
        this.fzl = z;
        this.fyI.setVisibility(this.fzl ? 0 : 4);
    }

    public boolean bji() {
        return this.fzn;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fzr.clear();
    }

    public void onStop() {
        bke();
    }

    public void iY(boolean z) {
        if (!z) {
            bke();
        }
    }

    private void bke() {
        if (this.fyX != null && this.fyX.isShowing()) {
            this.fyX.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void jY(boolean z) {
        this.aBy = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fzc = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fzk = false;
            this.fzs = false;
            this.fyM.setVisibility(0);
            this.fyN.setVisibility(8);
            return;
        }
        this.fzk = true;
        this.fyM.setVisibility(8);
        this.fyN.setVisibility(0);
        if (z && !this.fzs) {
            bfw();
            this.fzs = true;
        }
        d(false, f);
    }

    protected void bfw() {
    }

    public void rR(int i) {
        if (i == 0) {
            this.fzk = false;
            this.fzs = false;
            this.fyM.setVisibility(0);
            this.fyN.setVisibility(8);
            return;
        }
        this.fzk = true;
        this.fyM.setVisibility(8);
        this.fyN.setVisibility(0);
    }

    public void rS(int i) {
        if (i == 0) {
            this.fzm = false;
            this.fyI.setText(d.j.sign);
            bfn();
            return;
        }
        this.fzm = true;
        this.fyI.setText(d.j.signed);
        bfm();
    }

    protected void bfn() {
    }

    protected void bfm() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void bfx() {
        if (this.mMemberType != 0) {
            al.c(this.fyW, d.f.icon_speed_orange);
        } else {
            al.c(this.fyW, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fzj));
        if (this.fvH >= 10000) {
            if (this.fvH % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvH / 10000) + this.mContext.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvH / 10000.0f) + this.mContext.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvH));
    }

    public void d(boolean z, float f) {
    }

    public void bfs() {
    }

    public void b(s sVar) {
    }
}

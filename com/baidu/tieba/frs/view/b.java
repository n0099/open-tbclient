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
    private static HashMap<Integer, String> fzr = new HashMap<>();
    private static HashSet<Integer> fzs = new HashSet<>();
    protected boolean aBx;
    protected TbImageView eBB;
    protected TextView eKx;
    protected ImageView eVN;
    protected ImageView eVO;
    protected TextView eXP;
    protected FrsFragment faH;
    protected LinearGradientView fuz;
    protected int fvI;
    protected FrsViewData fwn;
    protected TextView fyG;
    protected TextView fyH;
    protected TextView fyI;
    protected TextView fyJ;
    protected TextView fyK;
    protected View fyL;
    protected TextView fyM;
    protected RelativeLayout fyN;
    protected RelativeLayout fyO;
    protected View fyP;
    protected TextView fyQ;
    protected RelativeLayout fyR;
    protected RelativeLayout fyS;
    protected FrsTopView fyT;
    protected View fyU;
    protected TextView fyV;
    protected TextView fyW;
    protected ImageView fyX;
    protected PopupWindow fyY;
    protected BarImageView fyZ;
    protected UserIconBox fza;
    protected ArrayList<j> fzb;
    protected com.baidu.tieba.frs.f.b fzc;
    protected String fzd;
    protected String fze;
    protected String fzf;
    protected bg fzg;
    protected int fzh;
    protected int fzi;
    protected int fzj;
    protected int fzk;
    protected boolean fzl;
    protected boolean fzm;
    protected boolean fzn;
    protected boolean fzo;
    protected boolean fzp;
    protected float fzq;
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
    protected int fyD = 0;
    protected int fyE = 0;
    protected int fyF = 0;
    private boolean fzt = false;
    protected HashSet<String> fzu = new HashSet<>();
    protected final Runnable fzv = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
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
        fzr.put(1, "c0117");
        fzr.put(2, "c0124");
        fzr.put(3, "c0125");
        fzr.put(4, "c0126");
        fzr.put(5, "c0127");
    }

    public boolean bjY() {
        return this.fzl;
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
            this.fyX.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View bka() {
        return this.fyL;
    }

    public BarImageView bkb() {
        return this.fyZ;
    }

    public TextView bkc() {
        return this.eKx;
    }

    public TextView bkd() {
        return this.eXP;
    }

    public boolean bjh() {
        return this.fzn;
    }

    public void jX(boolean z) {
        this.fzm = z;
        this.fyJ.setVisibility(this.fzm ? 0 : 4);
    }

    public boolean bji() {
        return this.fzo;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        fzs.clear();
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
        if (this.fyY != null && this.fyY.isShowing()) {
            this.fyY.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void jY(boolean z) {
        this.aBx = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.fzd = str;
        this.mLevel = i2;
        if (i == 0) {
            this.fzl = false;
            this.fzt = false;
            this.fyN.setVisibility(0);
            this.fyO.setVisibility(8);
            return;
        }
        this.fzl = true;
        this.fyN.setVisibility(8);
        this.fyO.setVisibility(0);
        if (z && !this.fzt) {
            bfw();
            this.fzt = true;
        }
        d(false, f);
    }

    protected void bfw() {
    }

    public void rR(int i) {
        if (i == 0) {
            this.fzl = false;
            this.fzt = false;
            this.fyN.setVisibility(0);
            this.fyO.setVisibility(8);
            return;
        }
        this.fzl = true;
        this.fyN.setVisibility(8);
        this.fyO.setVisibility(0);
    }

    public void rS(int i) {
        if (i == 0) {
            this.fzn = false;
            this.fyJ.setText(d.j.sign);
            bfn();
            return;
        }
        this.fzn = true;
        this.fyJ.setText(d.j.signed);
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
            al.c(this.fyX, d.f.icon_speed_orange);
        } else {
            al.c(this.fyX, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.fzk));
        if (this.fvI >= 10000) {
            if (this.fvI % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvI / 10000) + this.mContext.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvI / 10000.0f) + this.mContext.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.fvI));
    }

    public void d(boolean z, float f) {
    }

    public void bfs() {
    }

    public void b(s sVar) {
    }
}

package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> czM = new HashMap<>();
    private static HashSet<Integer> czN = new HashSet<>();
    protected View aZg;
    protected TbPageContext acp;
    protected int bri;
    protected View bzE;
    protected TextView cdk;
    protected TextView cgo;
    protected com.baidu.tieba.frs.f ckn;
    protected i cos;
    protected TextView cyP;
    protected TextView cyQ;
    protected TextView cyR;
    protected TextView cyS;
    protected TextView cyT;
    protected ImageView cyU;
    protected FrameLayout cyV;
    protected TextView cyW;
    protected FrameLayout cyX;
    protected TextView cyY;
    protected FrameLayout cyZ;
    protected int cyd;
    protected bl czA;
    protected int czB;
    protected int czC;
    protected int czD;
    protected int czE;
    protected boolean czF;
    protected boolean czG;
    protected boolean czH;
    protected boolean czI;
    protected boolean czJ;
    protected boolean czK;
    protected float czL;
    protected ImageView czR;
    protected RelativeLayout czS;
    protected RelativeLayout cza;
    protected View czb;
    protected ViewGroup czc;
    protected TextView czd;
    protected ViewGroup cze;
    protected TextView czf;
    protected TextView czg;
    protected TbImageView czh;
    protected LinearLayout czi;
    protected bm czj;
    protected bp czk;
    protected PopupWindow czl;
    protected View czm;
    protected TextView czn;
    protected TextView czo;
    protected ImageView czp;
    protected PopupWindow czq;
    protected BarImageView czr;
    protected UserIconBox czs;
    protected ArrayList<h> czt;
    protected com.baidu.tieba.frs.f.b czu;
    protected e czv;
    protected ag czw;
    protected String czx;
    protected String czy;
    protected String czz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cyM = 0;
    protected int cyN = 0;
    protected int cyO = 0;
    private boolean czO = false;
    protected HashSet<String> czP = new HashSet<>();
    protected final Runnable czQ = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.czl != null && b.this.czl.isShowing() && !b.this.czG) {
                g.a(b.this.czl, b.this.acp.getPageActivity());
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void agG();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        czM.put(1, "c0117");
        czM.put(2, "c0124");
        czM.put(3, "c0125");
        czM.put(4, "c0126");
        czM.put(5, "c0127");
    }

    public boolean ajM() {
        return this.czF;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, (Animation.AnimationListener) null);
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

    public boolean ajN() {
        int[] iArr = new int[2];
        try {
            this.czp.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aZg;
    }

    public View ajO() {
        return this.czb;
    }

    public BarImageView ajD() {
        return this.czr;
    }

    public TextView ajP() {
        return this.cdk;
    }

    public boolean ajB() {
        return this.czJ;
    }

    public void fc(boolean z) {
        this.czI = z;
        if (this.czI) {
            this.cyX.setVisibility(0);
        } else {
            this.cyX.setVisibility(4);
        }
    }

    public boolean ajC() {
        return this.czK;
    }

    public void onDestory() {
        this.czG = true;
        czN.clear();
    }

    public void onStop() {
        if (this.czq != null && this.czq.isShowing()) {
            this.czq.dismiss();
        }
        if (this.czl != null && this.czl.isShowing()) {
            this.czl.dismiss();
        }
    }

    public void fd(boolean z) {
        this.czH = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.czx = str;
        this.bri = i2;
        if (i == 0) {
            this.czF = false;
            this.czO = false;
            this.cyZ.setVisibility(0);
            this.cza.setVisibility(8);
            return;
        }
        this.czF = true;
        this.cyZ.setVisibility(8);
        if (z && !this.czO) {
            agH();
            this.czO = true;
        }
        c(false, f);
        this.cza.setVisibility(0);
    }

    protected void agH() {
    }

    public void jA(int i) {
        if (i == 0) {
            this.czF = false;
            this.czO = false;
            this.cyZ.setVisibility(0);
            this.cza.setVisibility(8);
            if (this.czw != null) {
                this.czw.hide();
                return;
            }
            return;
        }
        this.czF = true;
        this.cyZ.setVisibility(8);
        this.cza.setVisibility(0);
    }

    public void jB(int i) {
        if (i == 0) {
            this.czJ = false;
            this.cyV.setVisibility(8);
            this.cyX.setVisibility(0);
            agC();
            return;
        }
        this.czJ = true;
        this.cyX.setVisibility(8);
        if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
            this.cyV.setClickable(true);
        } else {
            this.cyV.setClickable(false);
        }
        agB();
    }

    protected void agC() {
    }

    protected void agB() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void agI() {
        if (this.mMemberType != 0) {
            ai.c(this.czp, d.g.icon_speed_orange);
        } else {
            ai.c(this.czp, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.czE));
        if (this.cyd >= 10000) {
            if (this.cyd % 10000 == 0) {
                textView2.setText(this.acp.getString(d.l.experience_divider) + String.valueOf(this.cyd / 10000) + this.acp.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.acp.getString(d.l.experience_divider) + String.valueOf(this.cyd / 10000.0f) + this.acp.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.acp.getString(d.l.experience_divider) + String.valueOf(this.cyd));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(List<com.baidu.tieba.tbadkCore.e> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.e> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.e next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void agr() {
    }
}

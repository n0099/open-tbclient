package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cHW = new HashMap<>();
    private static HashSet<Integer> cHX = new HashSet<>();
    protected View aYU;
    protected TbPageContext aby;
    protected View bBg;
    protected int bsN;
    protected int cGt;
    protected PopupWindow cHA;
    protected BarImageView cHB;
    protected UserIconBox cHC;
    protected ArrayList<h> cHD;
    protected com.baidu.tieba.frs.g.b cHE;
    protected e cHF;
    protected ag cHG;
    protected String cHH;
    protected String cHI;
    protected String cHJ;
    protected bj cHK;
    protected int cHL;
    protected int cHM;
    protected int cHN;
    protected int cHO;
    protected boolean cHP;
    protected boolean cHQ;
    protected boolean cHR;
    protected boolean cHS;
    protected boolean cHT;
    protected boolean cHU;
    protected float cHV;
    protected TextView cHf;
    protected TextView cHg;
    protected TextView cHh;
    protected TextView cHi;
    protected TextView cHj;
    protected ImageView cHk;
    protected View cHl;
    protected ViewGroup cHm;
    protected TextView cHn;
    protected ViewGroup cHo;
    protected TextView cHp;
    protected TextView cHq;
    protected TbImageView cHr;
    protected LinearLayout cHs;
    protected bk cHt;
    protected bn cHu;
    protected PopupWindow cHv;
    protected View cHw;
    protected TextView cHx;
    protected TextView cHy;
    protected ImageView cHz;
    protected RelativeLayout cIb;
    protected RelativeLayout cIc;
    protected View cId;
    protected TextView cIe;
    protected RelativeLayout cIf;
    public TextView cot;
    protected com.baidu.tieba.frs.f cqt;
    protected i cvG;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cHc = 0;
    protected int cHd = 0;
    protected int cHe = 0;
    private boolean cHY = false;
    protected HashSet<String> cHZ = new HashSet<>();
    protected final Runnable cIa = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cHv != null && b.this.cHv.isShowing() && !b.this.cHQ) {
                g.a(b.this.cHv, b.this.aby.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cIg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.aby == null || ax.aT(b.this.aby.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    k.showToast(b.this.aby.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                au.wd().c(b.this.aby, new String[]{url});
                a.C0124a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bql(), b.this.cqt.getForumId(), b.this.cqt.getForumName(), null);
                b.cj("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void aiH();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cHW.put(1, "c0117");
        cHW.put(2, "c0124");
        cHW.put(3, "c0125");
        cHW.put(4, "c0126");
        cHW.put(5, "c0127");
    }

    public boolean alT() {
        return this.cHP;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3.1
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

    public boolean alU() {
        int[] iArr = new int[2];
        try {
            this.cHz.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aYU;
    }

    public View alV() {
        return this.cHl;
    }

    public BarImageView alL() {
        return this.cHB;
    }

    public TextView alW() {
        return this.mTitleText;
    }

    public TextView alX() {
        return this.cot;
    }

    public boolean alJ() {
        return this.cHT;
    }

    public void fn(boolean z) {
        this.cHS = z;
        if (this.cHS) {
            this.cHi.setVisibility(0);
        } else {
            this.cHi.setVisibility(4);
        }
    }

    public boolean alK() {
        return this.cHU;
    }

    public void onDestory() {
        this.cHQ = true;
        cHX.clear();
    }

    public void onStop() {
        if (this.cHA != null && this.cHA.isShowing()) {
            this.cHA.dismiss();
        }
        if (this.cHv != null && this.cHv.isShowing()) {
            this.cHv.dismiss();
        }
    }

    public void fo(boolean z) {
        this.cHR = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cHH = str;
        this.bsN = i2;
        if (i == 0) {
            this.cHP = false;
            this.cHY = false;
            this.cIb.setVisibility(0);
            this.cIc.setVisibility(8);
            return;
        }
        this.cHP = true;
        this.cIb.setVisibility(8);
        this.cIc.setVisibility(0);
        if (z && !this.cHY) {
            aiI();
            this.cHY = true;
        }
        c(false, f);
    }

    protected void aiI() {
    }

    public void jY(int i) {
        if (i == 0) {
            this.cHP = false;
            this.cHY = false;
            this.cIb.setVisibility(0);
            this.cIc.setVisibility(8);
            return;
        }
        this.cHP = true;
        this.cIb.setVisibility(8);
        this.cIc.setVisibility(0);
    }

    public void jZ(int i) {
        if (i == 0) {
            this.cHT = false;
            this.cHi.setText(d.l.sign);
            aiD();
            return;
        }
        this.cHT = true;
        this.cHi.setText(d.l.signed);
        aiC();
    }

    protected void aiD() {
    }

    protected void aiC() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aiJ() {
        if (this.mMemberType != 0) {
            aj.c(this.cHz, d.g.icon_speed_orange);
        } else {
            aj.c(this.cHz, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cHO));
        if (this.cGt >= 10000) {
            if (this.cGt % 10000 == 0) {
                textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cGt / 10000) + this.aby.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cGt / 10000.0f) + this.aby.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cGt));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aY(List<com.baidu.tieba.tbadkCore.e> list) {
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

    public void ais() {
    }

    public void l(int i, int i2, int i3, int i4) {
        if (this.cIf != null) {
            this.cIf.setPadding(i, i2, i3, i4);
        }
    }
}

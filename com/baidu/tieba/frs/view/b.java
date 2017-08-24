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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
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
    private static HashMap<Integer, String> cBG = new HashMap<>();
    private static HashSet<Integer> cBH = new HashSet<>();
    protected View aZi;
    protected TbPageContext acr;
    protected View bAo;
    protected int bsj;
    protected TextView cAP;
    protected TextView cAQ;
    protected TextView cAR;
    protected TextView cAS;
    protected TextView cAT;
    protected ImageView cAU;
    protected View cAV;
    protected ViewGroup cAW;
    protected TextView cAX;
    protected ViewGroup cAY;
    protected TextView cAZ;
    protected int cAb;
    protected boolean cBA;
    protected boolean cBB;
    protected boolean cBC;
    protected boolean cBD;
    protected boolean cBE;
    protected float cBF;
    protected RelativeLayout cBL;
    protected RelativeLayout cBM;
    protected View cBN;
    protected TextView cBO;
    protected RelativeLayout cBP;
    protected TextView cBa;
    protected TbImageView cBb;
    protected LinearLayout cBc;
    protected bm cBd;
    protected bp cBe;
    protected PopupWindow cBf;
    protected View cBg;
    protected TextView cBh;
    protected TextView cBi;
    protected ImageView cBj;
    protected PopupWindow cBk;
    protected BarImageView cBl;
    protected UserIconBox cBm;
    protected ArrayList<h> cBn;
    protected com.baidu.tieba.frs.f.b cBo;
    protected e cBp;
    protected ag cBq;
    protected String cBr;
    protected String cBs;
    protected String cBt;
    protected bl cBu;
    protected int cBv;
    protected int cBw;
    protected int cBx;
    protected int cBy;
    protected boolean cBz;
    protected TextView cdX;
    public TextView ciZ;
    protected com.baidu.tieba.frs.f cla;
    protected i cpb;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cAM = 0;
    protected int cAN = 0;
    protected int cAO = 0;
    private boolean cBI = false;
    protected HashSet<String> cBJ = new HashSet<>();
    protected final Runnable cBK = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cBf != null && b.this.cBf.isShowing() && !b.this.cBA) {
                g.a(b.this.cBf, b.this.acr.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cBQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.acr == null || aw.aO(b.this.acr.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    k.showToast(b.this.acr.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                at.wg().c(b.this.acr, new String[]{url});
                a.C0121a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqW(), b.this.cla.getForumId(), b.this.cla.getForumName(), null);
                a.ck("obj_url", eVar.getUrl());
                a.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void agV();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cBG.put(1, "c0117");
        cBG.put(2, "c0124");
        cBG.put(3, "c0125");
        cBG.put(4, "c0126");
        cBG.put(5, "c0127");
    }

    public boolean akl() {
        return this.cBz;
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

    public boolean akm() {
        int[] iArr = new int[2];
        try {
            this.cBj.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aZi;
    }

    public View akn() {
        return this.cAV;
    }

    public BarImageView akd() {
        return this.cBl;
    }

    public TextView ako() {
        return this.cdX;
    }

    public TextView akp() {
        return this.ciZ;
    }

    public boolean akb() {
        return this.cBD;
    }

    public void ff(boolean z) {
        this.cBC = z;
        if (this.cBC) {
            this.cAS.setVisibility(0);
        } else {
            this.cAS.setVisibility(4);
        }
    }

    public boolean akc() {
        return this.cBE;
    }

    public void onDestory() {
        this.cBA = true;
        cBH.clear();
    }

    public void onStop() {
        if (this.cBk != null && this.cBk.isShowing()) {
            this.cBk.dismiss();
        }
        if (this.cBf != null && this.cBf.isShowing()) {
            this.cBf.dismiss();
        }
    }

    public void fg(boolean z) {
        this.cBB = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cBr = str;
        this.bsj = i2;
        if (i == 0) {
            this.cBz = false;
            this.cBI = false;
            this.cBL.setVisibility(0);
            this.cBM.setVisibility(8);
            return;
        }
        this.cBz = true;
        this.cBL.setVisibility(8);
        this.cBM.setVisibility(0);
        if (z && !this.cBI) {
            agW();
            this.cBI = true;
        }
        c(false, f);
    }

    protected void agW() {
    }

    public void jK(int i) {
        if (i == 0) {
            this.cBz = false;
            this.cBI = false;
            this.cBL.setVisibility(0);
            this.cBM.setVisibility(8);
            return;
        }
        this.cBz = true;
        this.cBL.setVisibility(8);
        this.cBM.setVisibility(0);
    }

    public void jL(int i) {
        if (i == 0) {
            this.cBD = false;
            this.cAS.setText(d.l.sign);
            agR();
            return;
        }
        this.cBD = true;
        this.cAS.setText(d.l.signed);
        agQ();
    }

    protected void agR() {
    }

    protected void agQ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void agX() {
        if (this.mMemberType != 0) {
            ai.c(this.cBj, d.g.icon_speed_orange);
        } else {
            ai.c(this.cBj, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cBy));
        if (this.cAb >= 10000) {
            if (this.cAb % 10000 == 0) {
                textView2.setText(this.acr.getString(d.l.experience_divider) + String.valueOf(this.cAb / 10000) + this.acr.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.acr.getString(d.l.experience_divider) + String.valueOf(this.cAb / 10000.0f) + this.acr.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.acr.getString(d.l.experience_divider) + String.valueOf(this.cAb));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aU(List<com.baidu.tieba.tbadkCore.e> list) {
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

    public void agG() {
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cBP != null) {
            this.cBP.setPadding(i, i2, i3, i4);
        }
    }
}

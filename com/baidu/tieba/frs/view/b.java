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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cTa = new HashMap<>();
    private static HashSet<Integer> cTb = new HashSet<>();
    protected TbPageContext abI;
    protected View bKT;
    protected View bbf;
    protected j cFm;
    protected int cRw;
    protected View cSA;
    protected TextView cSB;
    protected TextView cSC;
    protected ImageView cSD;
    protected PopupWindow cSE;
    protected BarImageView cSF;
    protected UserIconBox cSG;
    protected ArrayList<h> cSH;
    protected com.baidu.tieba.frs.f.b cSI;
    protected e cSJ;
    protected ah cSK;
    protected String cSL;
    protected String cSM;
    protected String cSN;
    protected bh cSO;
    protected int cSP;
    protected int cSQ;
    protected int cSR;
    protected int cSS;
    protected boolean cST;
    protected boolean cSU;
    protected boolean cSV;
    protected boolean cSW;
    protected boolean cSX;
    protected boolean cSY;
    protected float cSZ;
    protected TextView cSj;
    protected TextView cSk;
    protected TextView cSl;
    protected TextView cSm;
    protected TextView cSn;
    protected ImageView cSo;
    protected View cSp;
    protected ViewGroup cSq;
    protected TextView cSr;
    protected ViewGroup cSs;
    protected TextView cSt;
    protected TextView cSu;
    protected TbImageView cSv;
    protected LinearLayout cSw;
    protected bi cSx;
    protected bl cSy;
    protected PopupWindow cSz;
    protected RelativeLayout cTf;
    protected RelativeLayout cTg;
    protected View cTh;
    protected TextView cTi;
    protected RelativeLayout cTj;
    public TextView cxl;
    protected com.baidu.tieba.frs.f czk;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cSg = 0;
    protected int cSh = 0;
    protected int cSi = 0;
    private boolean cTc = false;
    protected HashSet<String> cTd = new HashSet<>();
    protected final Runnable cTe = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cSz != null && b.this.cSz.isShowing() && !b.this.cSU) {
                com.baidu.adp.lib.g.g.a(b.this.cSz, b.this.abI.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cTk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.abI == null || ax.aT(b.this.abI.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(b.this.abI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.vI().c(b.this.abI, new String[]{url});
                a.C0129a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bsz(), b.this.czk.getForumId(), b.this.czk.getForumName(), null);
                b.ce("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, j jVar);

    public abstract void alr();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cTa.put(1, "c0117");
        cTa.put(2, "c0124");
        cTa.put(3, "c0125");
        cTa.put(4, "c0126");
        cTa.put(5, "c0127");
    }

    public boolean apd() {
        return this.cST;
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

    public boolean ape() {
        int[] iArr = new int[2];
        try {
            this.cSD.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.bbf;
    }

    public View apf() {
        return this.cSp;
    }

    public BarImageView aoV() {
        return this.cSF;
    }

    public TextView apg() {
        return this.mTitleText;
    }

    public TextView aph() {
        return this.cxl;
    }

    public boolean aoT() {
        return this.cSX;
    }

    public void fm(boolean z) {
        this.cSW = z;
        if (this.cSW) {
            this.cSm.setVisibility(0);
        } else {
            this.cSm.setVisibility(4);
        }
    }

    public boolean aoU() {
        return this.cSY;
    }

    public void onDestory() {
        this.cSU = true;
        cTb.clear();
    }

    public void onStop() {
        api();
    }

    public void fj(boolean z) {
        if (!z) {
            api();
        }
    }

    private void api() {
        if (this.cSE != null && this.cSE.isShowing()) {
            this.cSE.dismiss();
        }
        if (this.cSz != null && this.cSz.isShowing()) {
            this.cSz.dismiss();
        }
    }

    public void fn(boolean z) {
        this.cSV = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cSL = str;
        this.mLevel = i2;
        if (i == 0) {
            this.cST = false;
            this.cTc = false;
            this.cTf.setVisibility(0);
            this.cTg.setVisibility(8);
            return;
        }
        this.cST = true;
        this.cTf.setVisibility(8);
        this.cTg.setVisibility(0);
        if (z && !this.cTc) {
            als();
            this.cTc = true;
        }
        c(false, f);
    }

    protected void als() {
    }

    public void kD(int i) {
        if (i == 0) {
            this.cST = false;
            this.cTc = false;
            this.cTf.setVisibility(0);
            this.cTg.setVisibility(8);
            return;
        }
        this.cST = true;
        this.cTf.setVisibility(8);
        this.cTg.setVisibility(0);
    }

    public void kE(int i) {
        if (i == 0) {
            this.cSX = false;
            this.cSm.setText(d.j.sign);
            aln();
            return;
        }
        this.cSX = true;
        this.cSm.setText(d.j.signed);
        alm();
    }

    protected void aln() {
    }

    protected void alm() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void alt() {
        if (this.mMemberType != 0) {
            aj.c(this.cSD, d.f.icon_speed_orange);
        } else {
            aj.c(this.cSD, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cSS));
        if (this.cRw >= 10000) {
            if (this.cRw % 10000 == 0) {
                textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRw / 10000) + this.abI.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRw / 10000.0f) + this.abI.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRw));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bb(List<com.baidu.tieba.tbadkCore.e> list) {
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

    public void alc() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.cTj != null) {
            this.cTj.setPadding(i, i2, i3, i4);
        }
    }
}

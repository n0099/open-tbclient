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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class c {
    private static HashMap<Integer, String> dPC = new HashMap<>();
    private static HashSet<Integer> dPD = new HashSet<>();
    protected PopupWindow QK;
    protected TbPageContext aQq;
    protected View cHG;
    protected l dNG;
    protected int dNi;
    protected TextView dOK;
    protected TextView dOL;
    protected TextView dOM;
    protected TextView dON;
    protected TextView dOO;
    protected ImageView dOP;
    protected View dOQ;
    protected ViewGroup dOR;
    protected TextView dOS;
    protected View dOT;
    protected a dOU;
    protected ViewGroup dOV;
    protected TextView dOW;
    protected TextView dOX;
    protected TbImageView dOY;
    protected LinearLayout dOZ;
    protected boolean dPA;
    protected float dPB;
    protected RelativeLayout dPH;
    protected RelativeLayout dPI;
    protected View dPJ;
    protected TextView dPK;
    protected RelativeLayout dPL;
    protected TextView dPM;
    protected bg dPa;
    protected bj dPb;
    protected View dPc;
    protected TextView dPd;
    protected TextView dPe;
    protected ImageView dPf;
    protected PopupWindow dPg;
    protected BarImageView dPh;
    protected UserIconBox dPi;
    protected ArrayList<com.baidu.tbadk.core.data.g> dPj;
    protected com.baidu.tieba.frs.e.b dPk;
    protected f dPl;
    protected ai dPm;
    protected String dPn;
    protected String dPo;
    protected String dPp;
    protected be dPq;
    protected int dPr;
    protected int dPs;
    protected int dPt;
    protected int dPu;
    protected boolean dPv;
    protected boolean dPw;
    protected boolean dPx;
    protected boolean dPy;
    protected boolean dPz;
    public TextView dvT;
    protected i dxW;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dOH = 0;
    protected int dOI = 0;
    protected int dOJ = 0;
    private boolean dPE = false;
    protected HashSet<String> dPF = new HashSet<>();
    protected final Runnable dPG = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QK != null && c.this.QK.isShowing() && !c.this.dPw) {
                com.baidu.adp.lib.g.g.a(c.this.QK, c.this.aQq.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dPN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((c.this.aQq == null || ax.be(c.this.aQq.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(c.this.aQq.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.Di().c(c.this.aQq, new String[]{url});
                a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bzZ(), c.this.dxW.getForumId(), c.this.dxW.getForumName(), null);
                b.ch("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void auZ();

    public abstract void changeSkinType(int i);

    public abstract void p(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        dPC.put(1, "c0117");
        dPC.put(2, "c0124");
        dPC.put(3, "c0125");
        dPC.put(4, "c0126");
        dPC.put(5, "c0127");
    }

    public boolean ayl() {
        return this.dPv;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.c.3
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.c.3.1
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

    public boolean aym() {
        int[] iArr = new int[2];
        try {
            this.dPf.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View ayn() {
        return this.dOQ;
    }

    public View ayo() {
        return this.dOU;
    }

    public BarImageView ayp() {
        return this.dPh;
    }

    public TextView ayq() {
        return this.mTitleText;
    }

    public TextView ayr() {
        return this.dvT;
    }

    public boolean ayd() {
        return this.dPz;
    }

    public void ge(boolean z) {
        this.dPy = z;
        if (this.dPy) {
            this.dON.setVisibility(0);
        } else {
            this.dON.setVisibility(4);
        }
    }

    public boolean aye() {
        return this.dPA;
    }

    public void onDestory() {
        this.dPw = true;
        dPD.clear();
    }

    public void onStop() {
        ays();
    }

    public void gb(boolean z) {
        if (!z) {
            ays();
        }
    }

    private void ays() {
        if (this.dPg != null && this.dPg.isShowing()) {
            this.dPg.dismiss();
        }
        if (this.QK != null && this.QK.isShowing()) {
            this.QK.dismiss();
        }
    }

    public void gf(boolean z) {
        this.dPx = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dPn = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dPv = false;
            this.dPE = false;
            this.dPH.setVisibility(0);
            this.dPI.setVisibility(8);
            return;
        }
        this.dPv = true;
        this.dPH.setVisibility(8);
        this.dPI.setVisibility(0);
        if (z && !this.dPE) {
            ava();
            this.dPE = true;
        }
        c(false, f);
    }

    protected void ava() {
    }

    public void oa(int i) {
        if (i == 0) {
            this.dPv = false;
            this.dPE = false;
            this.dPH.setVisibility(0);
            this.dPI.setVisibility(8);
            return;
        }
        this.dPv = true;
        this.dPH.setVisibility(8);
        this.dPI.setVisibility(0);
    }

    public void ob(int i) {
        if (i == 0) {
            this.dPz = false;
            this.dON.setText(d.j.sign);
            auV();
            return;
        }
        this.dPz = true;
        this.dON.setText(d.j.signed);
        auU();
    }

    protected void auV() {
    }

    protected void auU() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void avb() {
        if (this.mMemberType != 0) {
            aj.c(this.dPf, d.f.icon_speed_orange);
        } else {
            aj.c(this.dPf, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dPu));
        if (this.dNi >= 10000) {
            if (this.dNi % 10000 == 0) {
                textView2.setText(this.aQq.getString(d.j.experience_divider) + String.valueOf(this.dNi / 10000) + this.aQq.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aQq.getString(d.j.experience_divider) + String.valueOf(this.dNi / 10000.0f) + this.aQq.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aQq.getString(d.j.experience_divider) + String.valueOf(this.dNi));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bz(List<com.baidu.tieba.tbadkCore.g> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.g> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.g next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void auN() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dPL != null) {
            this.dPL.setPadding(i, i2, i3, i4);
        }
    }
}

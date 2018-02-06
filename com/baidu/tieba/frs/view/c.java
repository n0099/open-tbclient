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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
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
    private static HashMap<Integer, String> dYA = new HashMap<>();
    private static HashSet<Integer> dYB = new HashSet<>();
    protected PopupWindow QJ;
    protected TbPageContext aRR;
    protected View cMb;
    public TextView dDI;
    protected com.baidu.tieba.frs.i dFP;
    protected l dVU;
    protected int dVr;
    protected TextView dXI;
    protected TextView dXJ;
    protected TextView dXK;
    protected TextView dXL;
    protected TextView dXM;
    protected ImageView dXN;
    protected View dXO;
    protected ViewGroup dXP;
    protected TextView dXQ;
    protected View dXR;
    protected a dXS;
    protected ViewGroup dXT;
    protected TextView dXU;
    protected TextView dXV;
    protected TbImageView dXW;
    protected LinearLayout dXX;
    protected bf dXY;
    protected bi dXZ;
    protected RelativeLayout dYF;
    protected RelativeLayout dYG;
    protected View dYH;
    protected TextView dYI;
    protected RelativeLayout dYJ;
    protected TextView dYK;
    protected View dYa;
    protected TextView dYb;
    protected TextView dYc;
    protected ImageView dYd;
    protected PopupWindow dYe;
    protected BarImageView dYf;
    protected UserIconBox dYg;
    protected ArrayList<com.baidu.tbadk.core.data.g> dYh;
    protected com.baidu.tieba.frs.f.b dYi;
    protected g dYj;
    protected ai dYk;
    protected String dYl;
    protected String dYm;
    protected String dYn;
    protected bd dYo;
    protected int dYp;
    protected int dYq;
    protected int dYr;
    protected int dYs;
    protected boolean dYt;
    protected boolean dYu;
    protected boolean dYv;
    protected boolean dYw;
    protected boolean dYx;
    protected boolean dYy;
    protected float dYz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dXF = 0;
    protected int dXG = 0;
    protected int dXH = 0;
    private boolean dYC = false;
    protected HashSet<String> dYD = new HashSet<>();
    protected final Runnable dYE = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QJ != null && c.this.QJ.isShowing() && !c.this.dYu) {
                com.baidu.adp.lib.g.g.a(c.this.QJ, c.this.aRR.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dYL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((c.this.aRR == null || ay.ba(c.this.aRR.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(c.this.aRR.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                aw.Du().c(c.this.aRR, new String[]{url});
                a.C0235a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.buM(), c.this.dFP.getForumId(), c.this.dFP.getForumName(), null);
                b.ce("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void axg();

    public abstract void changeSkinType(int i);

    public abstract void l(View.OnClickListener onClickListener);

    public abstract void p(View view, boolean z);

    static {
        dYA.put(1, "c0117");
        dYA.put(2, "c0124");
        dYA.put(3, "c0125");
        dYA.put(4, "c0126");
        dYA.put(5, "c0127");
    }

    public boolean aAM() {
        return this.dYt;
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

    public boolean aAN() {
        int[] iArr = new int[2];
        try {
            this.dYd.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aAO() {
        return this.dXO;
    }

    public View aAP() {
        return this.dXS;
    }

    public BarImageView aAQ() {
        return this.dYf;
    }

    public TextView aAR() {
        return this.mTitleText;
    }

    public TextView aAS() {
        return this.dDI;
    }

    public boolean aAp() {
        return this.dYx;
    }

    public void gz(boolean z) {
        this.dYw = z;
        if (this.dYw) {
            this.dXL.setVisibility(0);
        } else {
            this.dXL.setVisibility(4);
        }
    }

    public boolean aAq() {
        return this.dYy;
    }

    public void onDestory() {
        this.dYu = true;
        dYB.clear();
    }

    public void onStop() {
        aAT();
    }

    public void gr(boolean z) {
        if (!z) {
            aAT();
        }
    }

    private void aAT() {
        if (this.dYe != null && this.dYe.isShowing()) {
            this.dYe.dismiss();
        }
        if (this.QJ != null && this.QJ.isShowing()) {
            this.QJ.dismiss();
        }
    }

    public void gA(boolean z) {
        this.dYv = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dYl = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dYt = false;
            this.dYC = false;
            this.dYF.setVisibility(0);
            this.dYG.setVisibility(8);
            return;
        }
        this.dYt = true;
        this.dYF.setVisibility(8);
        this.dYG.setVisibility(0);
        if (z && !this.dYC) {
            axh();
            this.dYC = true;
        }
        c(false, f);
    }

    protected void axh() {
    }

    public void od(int i) {
        if (i == 0) {
            this.dYt = false;
            this.dYC = false;
            this.dYF.setVisibility(0);
            this.dYG.setVisibility(8);
            return;
        }
        this.dYt = true;
        this.dYF.setVisibility(8);
        this.dYG.setVisibility(0);
    }

    public void oe(int i) {
        if (i == 0) {
            this.dYx = false;
            this.dXL.setText(d.j.sign);
            axc();
            return;
        }
        this.dYx = true;
        this.dXL.setText(d.j.signed);
        axb();
    }

    protected void axc() {
    }

    protected void axb() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void axi() {
        if (this.mMemberType != 0) {
            aj.c(this.dYd, d.f.icon_speed_orange);
        } else {
            aj.c(this.dYd, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dYs));
        if (this.dVr >= 10000) {
            if (this.dVr % 10000 == 0) {
                textView2.setText(this.aRR.getString(d.j.experience_divider) + String.valueOf(this.dVr / 10000) + this.aRR.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aRR.getString(d.j.experience_divider) + String.valueOf(this.dVr / 10000.0f) + this.aRR.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aRR.getString(d.j.experience_divider) + String.valueOf(this.dVr));
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

    public void awU() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dYJ != null) {
            this.dYJ.setPadding(i, i2, i3, i4);
        }
    }
}

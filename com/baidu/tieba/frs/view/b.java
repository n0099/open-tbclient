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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class b {
    private static HashMap<Integer, String> dtu = new HashMap<>();
    private static HashSet<Integer> dtv = new HashSet<>();
    protected TbPageContext adf;
    public TextView cWr;
    protected FrsFragment cYC;
    protected View cbY;
    protected l dqL;
    protected int dqh;
    protected TextView dsD;
    protected TextView dsE;
    protected TextView dsF;
    protected TextView dsG;
    protected TextView dsH;
    protected ImageView dsI;
    protected View dsJ;
    protected ViewGroup dsK;
    protected TextView dsL;
    protected View dsM;
    protected AdapterLinearLayout dsN;
    protected ViewGroup dsO;
    protected TextView dsP;
    protected TextView dsQ;
    protected TbImageView dsR;
    protected LinearLayout dsS;
    protected bf dsT;
    protected bi dsU;
    protected View dsV;
    protected TextView dsW;
    protected TextView dsX;
    protected ImageView dsY;
    protected PopupWindow dsZ;
    protected RelativeLayout dtA;
    protected View dtB;
    protected TextView dtC;
    protected RelativeLayout dtD;
    protected TextView dtE;
    protected BarImageView dta;
    protected UserIconBox dtb;
    protected ArrayList<h> dtc;
    protected com.baidu.tieba.frs.f.b dtd;
    protected e dte;
    protected ae dtf;
    protected String dtg;
    protected String dth;
    protected String dti;
    protected bd dtj;
    protected int dtk;
    protected int dtl;
    protected int dtm;
    protected int dtn;
    protected boolean dto;
    protected boolean dtp;
    protected boolean dtq;
    protected boolean dtr;
    protected boolean dts;
    protected float dtt;
    protected RelativeLayout dtz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected TextView mTitleText;
    protected int dsA = 0;
    protected int dsB = 0;
    protected int dsC = 0;
    private boolean dtw = false;
    protected HashSet<String> dtx = new HashSet<>();
    protected final Runnable dty = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.adf.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dtF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.adf == null || az.aK(b.this.adf.getPageActivity())) && view2 != null && (view2.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view2.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.adf.getPageActivity(), d.k.book_plugin_not_install_tip);
                    return;
                }
                ax.wg().c(b.this.adf, new String[]{url});
                a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bpU(), b.this.cYC.getForumId(), b.this.cYC.getForumName(), null);
                b.cd("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void arE();

    public abstract void changeSkinType(int i);

    public abstract void j(View view2, boolean z);

    public abstract void n(View.OnClickListener onClickListener);

    static {
        dtu.put(1, "c0117");
        dtu.put(2, "c0124");
        dtu.put(3, "c0125");
        dtu.put(4, "c0126");
        dtu.put(5, "c0127");
    }

    public boolean avJ() {
        return this.dto;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view2, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view2, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3.1
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
                        view2.startAnimation(scaleAnimation3);
                    }
                });
            }
        });
    }

    public boolean avK() {
        int[] iArr = new int[2];
        try {
            this.dsY.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View avL() {
        return this.dsJ;
    }

    public View art() {
        return this.dsN;
    }

    public BarImageView avM() {
        return this.dta;
    }

    public TextView avN() {
        return this.mTitleText;
    }

    public TextView avO() {
        return this.cWr;
    }

    public boolean avm() {
        return this.dtr;
    }

    public void ge(boolean z) {
        this.dtq = z;
        if (this.dtq) {
            this.dsG.setVisibility(0);
        } else {
            this.dsG.setVisibility(4);
        }
    }

    public boolean avn() {
        return this.dts;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dtv.clear();
    }

    public void onStop() {
        avP();
    }

    public void fV(boolean z) {
        if (!z) {
            avP();
        }
    }

    private void avP() {
        if (this.dsZ != null && this.dsZ.isShowing()) {
            this.dsZ.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gf(boolean z) {
        this.dtp = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dtg = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dto = false;
            this.dtw = false;
            this.dtz.setVisibility(0);
            this.dtA.setVisibility(8);
            return;
        }
        this.dto = true;
        this.dtz.setVisibility(8);
        this.dtA.setVisibility(0);
        if (z && !this.dtw) {
            arF();
            this.dtw = true;
        }
        c(false, f);
    }

    protected void arF() {
    }

    public void lD(int i) {
        if (i == 0) {
            this.dto = false;
            this.dtw = false;
            this.dtz.setVisibility(0);
            this.dtA.setVisibility(8);
            return;
        }
        this.dto = true;
        this.dtz.setVisibility(8);
        this.dtA.setVisibility(0);
    }

    public void lE(int i) {
        if (i == 0) {
            this.dtr = false;
            this.dsG.setText(d.k.sign);
            arA();
            return;
        }
        this.dtr = true;
        this.dsG.setText(d.k.signed);
        arz();
    }

    protected void arA() {
    }

    protected void arz() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void arG() {
        if (this.mMemberType != 0) {
            ak.c(this.dsY, d.f.icon_speed_orange);
        } else {
            ak.c(this.dsY, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dtn));
        if (this.dqh >= 10000) {
            if (this.dqh % 10000 == 0) {
                textView2.setText(this.adf.getString(d.k.experience_divider) + String.valueOf(this.dqh / 10000) + this.adf.getString(d.k.member_count_unit));
                return;
            } else {
                textView2.setText(this.adf.getString(d.k.experience_divider) + String.valueOf(this.dqh / 10000.0f) + this.adf.getString(d.k.member_count_unit));
                return;
            }
        }
        textView2.setText(this.adf.getString(d.k.experience_divider) + String.valueOf(this.dqh));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bt(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void arq() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dtD != null) {
            this.dtD.setPadding(i, i2, i3, i4);
        }
    }
}

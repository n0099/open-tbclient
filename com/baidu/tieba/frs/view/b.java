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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
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
    private static HashMap<Integer, String> dHf = new HashMap<>();
    private static HashSet<Integer> dHg = new HashSet<>();
    protected TextView cVn;
    protected int dDN;
    protected l dEs;
    protected TbImageView dGA;
    protected LinearLayout dGB;
    protected be dGC;
    protected bh dGD;
    protected View dGE;
    protected TextView dGF;
    protected TextView dGG;
    protected ImageView dGH;
    protected PopupWindow dGI;
    protected BarImageView dGJ;
    protected UserIconBox dGK;
    protected ArrayList<h> dGL;
    protected com.baidu.tieba.frs.f.b dGM;
    protected e dGN;
    protected ag dGO;
    protected String dGP;
    protected String dGQ;
    protected String dGR;
    protected bc dGS;
    protected int dGT;
    protected int dGU;
    protected int dGV;
    protected int dGW;
    protected boolean dGX;
    protected boolean dGY;
    protected boolean dGZ;
    protected TextView dGl;
    protected TextView dGm;
    protected TextView dGn;
    protected TextView dGo;
    protected TextView dGp;
    protected ImageView dGq;
    protected ImageView dGr;
    protected View dGs;
    protected ViewGroup dGt;
    protected TextView dGu;
    protected View dGv;
    protected AdapterLinearLayout dGw;
    protected ViewGroup dGx;
    protected TextView dGy;
    protected TextView dGz;
    protected boolean dHa;
    protected boolean dHb;
    protected boolean dHc;
    protected float dHd;
    protected TextView dHe;
    protected RelativeLayout dHk;
    protected RelativeLayout dHl;
    protected View dHm;
    protected TextView dHn;
    protected RelativeLayout dHo;
    protected TextView dHp;
    public TextView diC;
    protected FrsFragment dla;
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
    protected int dGi = 0;
    protected int dGj = 0;
    protected int dGk = 0;
    private boolean dHh = false;
    protected HashSet<String> dHi = new HashSet<>();
    protected final Runnable dHj = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dHq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || bb.aU(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    return;
                }
                az.zV().c(b.this.mContext, new String[]{url});
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bvt(), b.this.dla.getForumId(), b.this.dla.getForumName(), null);
                b.cp("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void awe();

    public abstract void awf();

    public abstract void awm();

    public abstract void changeSkinType(int i);

    public abstract void j(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dHf.put(1, "c0117");
        dHf.put(2, "c0124");
        dHf.put(3, "c0125");
        dHf.put(4, "c0126");
        dHf.put(5, "c0127");
    }

    public boolean aAy() {
        return this.dGX;
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

    public boolean aAz() {
        int[] iArr = new int[2];
        try {
            this.dGH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aAA() {
        return this.dGs;
    }

    public View avZ() {
        return this.dGw;
    }

    public BarImageView aAB() {
        return this.dGJ;
    }

    public TextView aAC() {
        return this.cVn;
    }

    public TextView aAD() {
        return this.diC;
    }

    public boolean aAa() {
        return this.dHa;
    }

    public void gu(boolean z) {
        this.dGZ = z;
        if (this.dGZ) {
            this.dGo.setVisibility(0);
        } else {
            this.dGo.setVisibility(4);
        }
    }

    public boolean aAb() {
        return this.dHb;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dHg.clear();
    }

    public void onStop() {
        aAE();
    }

    public void fy(boolean z) {
        if (!z) {
            aAE();
        }
    }

    private void aAE() {
        if (this.dGI != null && this.dGI.isShowing()) {
            this.dGI.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gv(boolean z) {
        this.dGY = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dGP = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dGX = false;
            this.dHh = false;
            this.dHk.setVisibility(0);
            this.dHl.setVisibility(8);
            return;
        }
        this.dGX = true;
        this.dHk.setVisibility(8);
        this.dHl.setVisibility(0);
        if (z && !this.dHh) {
            awn();
            this.dHh = true;
        }
        d(false, f);
    }

    protected void awn() {
    }

    public void lQ(int i) {
        if (i == 0) {
            this.dGX = false;
            this.dHh = false;
            this.dHk.setVisibility(0);
            this.dHl.setVisibility(8);
            return;
        }
        this.dGX = true;
        this.dHk.setVisibility(8);
        this.dHl.setVisibility(0);
    }

    public void lR(int i) {
        if (i == 0) {
            this.dHa = false;
            this.dGo.setText(d.k.sign);
            awi();
            return;
        }
        this.dHa = true;
        this.dGo.setText(d.k.signed);
        awh();
    }

    protected void awi() {
    }

    protected void awh() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void awo() {
        if (this.mMemberType != 0) {
            am.c(this.dGH, d.f.icon_speed_orange);
        } else {
            am.c(this.dGH, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dGW));
        if (this.dDN >= 10000) {
            if (this.dDN % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dDN / 10000) + this.mContext.getString(d.k.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dDN / 10000.0f) + this.mContext.getString(d.k.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dDN));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void d(boolean z, float f) {
    }

    public void avW() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dHo != null) {
            this.dHo.setPadding(i, i2, i3, i4);
        }
    }
}

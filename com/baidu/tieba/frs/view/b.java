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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private static HashMap<Integer, String> dJU = new HashMap<>();
    private static HashSet<Integer> dJV = new HashSet<>();
    protected TextView cYc;
    protected int dGz;
    protected l dHe;
    protected ArrayList<h> dJA;
    protected com.baidu.tieba.frs.f.b dJB;
    protected e dJC;
    protected ag dJD;
    protected String dJE;
    protected String dJF;
    protected String dJG;
    protected bb dJH;
    protected int dJI;
    protected int dJJ;
    protected int dJK;
    protected int dJL;
    protected boolean dJM;
    protected boolean dJN;
    protected boolean dJO;
    protected boolean dJP;
    protected boolean dJQ;
    protected boolean dJR;
    protected float dJS;
    protected TextView dJT;
    protected RelativeLayout dJZ;
    protected TextView dJa;
    protected TextView dJb;
    protected TextView dJc;
    protected TextView dJd;
    protected TextView dJe;
    protected ImageView dJf;
    protected ImageView dJg;
    protected View dJh;
    protected ViewGroup dJi;
    protected TextView dJj;
    protected View dJk;
    protected AdapterLinearLayout dJl;
    protected ViewGroup dJm;
    protected TextView dJn;
    protected TextView dJo;
    protected TbImageView dJp;
    protected LinearLayout dJq;
    protected bd dJr;
    protected bg dJs;
    protected View dJt;
    protected TextView dJu;
    protected TextView dJv;
    protected ImageView dJw;
    protected PopupWindow dJx;
    protected BarImageView dJy;
    protected UserIconBox dJz;
    protected RelativeLayout dKa;
    protected View dKb;
    protected TextView dKc;
    protected RelativeLayout dKd;
    protected TextView dKe;
    public TextView dls;
    protected FrsFragment dnR;
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
    protected int dIX = 0;
    protected int dIY = 0;
    protected int dIZ = 0;
    private boolean dJW = false;
    protected HashSet<String> dJX = new HashSet<>();
    protected final Runnable dJY = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dKf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.aV(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                ay.zK().c(b.this.mContext, new String[]{url});
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btW(), b.this.dnR.getForumId(), b.this.dnR.getForumName(), null);
                b.cm("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void awJ();

    public abstract void awK();

    public abstract void awR();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dJU.put(1, "c0117");
        dJU.put(2, "c0124");
        dJU.put(3, "c0125");
        dJU.put(4, "c0126");
        dJU.put(5, "c0127");
    }

    public boolean aBh() {
        return this.dJM;
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

    public boolean aBi() {
        int[] iArr = new int[2];
        try {
            this.dJw.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aBj() {
        return this.dJh;
    }

    public View awE() {
        return this.dJl;
    }

    public BarImageView aBk() {
        return this.dJy;
    }

    public TextView aBl() {
        return this.cYc;
    }

    public TextView aBm() {
        return this.dls;
    }

    public boolean aAH() {
        return this.dJP;
    }

    public void gw(boolean z) {
        this.dJO = z;
        if (this.dJO) {
            this.dJd.setVisibility(0);
        } else {
            this.dJd.setVisibility(4);
        }
    }

    public boolean aAI() {
        return this.dJQ;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dJV.clear();
    }

    public void onStop() {
        aBn();
    }

    public void fA(boolean z) {
        if (!z) {
            aBn();
        }
    }

    private void aBn() {
        if (this.dJx != null && this.dJx.isShowing()) {
            this.dJx.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gx(boolean z) {
        this.dJN = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dJE = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dJM = false;
            this.dJW = false;
            this.dJZ.setVisibility(0);
            this.dKa.setVisibility(8);
            return;
        }
        this.dJM = true;
        this.dJZ.setVisibility(8);
        this.dKa.setVisibility(0);
        if (z && !this.dJW) {
            awS();
            this.dJW = true;
        }
        d(false, f);
    }

    protected void awS() {
    }

    public void mc(int i) {
        if (i == 0) {
            this.dJM = false;
            this.dJW = false;
            this.dJZ.setVisibility(0);
            this.dKa.setVisibility(8);
            return;
        }
        this.dJM = true;
        this.dJZ.setVisibility(8);
        this.dKa.setVisibility(0);
    }

    public void md(int i) {
        if (i == 0) {
            this.dJP = false;
            this.dJd.setText(d.j.sign);
            awN();
            return;
        }
        this.dJP = true;
        this.dJd.setText(d.j.signed);
        awM();
    }

    protected void awN() {
    }

    protected void awM() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void awT() {
        if (this.mMemberType != 0) {
            am.c(this.dJw, d.f.icon_speed_orange);
        } else {
            am.c(this.dJw, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dJL));
        if (this.dGz >= 10000) {
            if (this.dGz % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.dGz / 10000) + this.mContext.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.dGz / 10000.0f) + this.mContext.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.j.experience_divider) + String.valueOf(this.dGz));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void awB() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.dKd != null) {
            this.dKd.setPadding(i, i2, i3, i4);
        }
    }
}

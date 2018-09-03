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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
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
    private static HashMap<Integer, String> dJQ = new HashMap<>();
    private static HashSet<Integer> dJR = new HashSet<>();
    protected TextView cXY;
    protected int dGv;
    protected l dHa;
    protected TextView dIW;
    protected TextView dIX;
    protected TextView dIY;
    protected TextView dIZ;
    protected String dJA;
    protected String dJB;
    protected String dJC;
    protected bb dJD;
    protected int dJE;
    protected int dJF;
    protected int dJG;
    protected int dJH;
    protected boolean dJI;
    protected boolean dJJ;
    protected boolean dJK;
    protected boolean dJL;
    protected boolean dJM;
    protected boolean dJN;
    protected float dJO;
    protected TextView dJP;
    protected RelativeLayout dJV;
    protected RelativeLayout dJW;
    protected View dJX;
    protected TextView dJY;
    protected RelativeLayout dJZ;
    protected TextView dJa;
    protected ImageView dJb;
    protected ImageView dJc;
    protected View dJd;
    protected ViewGroup dJe;
    protected TextView dJf;
    protected View dJg;
    protected AdapterLinearLayout dJh;
    protected ViewGroup dJi;
    protected TextView dJj;
    protected TextView dJk;
    protected TbImageView dJl;
    protected LinearLayout dJm;
    protected bd dJn;
    protected bg dJo;
    protected View dJp;
    protected TextView dJq;
    protected TextView dJr;
    protected ImageView dJs;
    protected PopupWindow dJt;
    protected BarImageView dJu;
    protected UserIconBox dJv;
    protected ArrayList<h> dJw;
    protected com.baidu.tieba.frs.f.b dJx;
    protected e dJy;
    protected ag dJz;
    protected TextView dKa;
    public TextView dlq;
    protected FrsFragment dnP;
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
    protected int dIT = 0;
    protected int dIU = 0;
    protected int dIV = 0;
    private boolean dJS = false;
    protected HashSet<String> dJT = new HashSet<>();
    protected final Runnable dJU = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || com.baidu.tbadk.core.util.bb.aU(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), f.j.book_plugin_not_install_tip);
                    return;
                }
                az.zI().c(b.this.mContext, new String[]{url});
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btX(), b.this.dnP.getForumId(), b.this.dnP.getForumName(), null);
                b.cm("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void awI();

    public abstract void awJ();

    public abstract void awQ();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dJQ.put(1, "c0117");
        dJQ.put(2, "c0124");
        dJQ.put(3, "c0125");
        dJQ.put(4, "c0126");
        dJQ.put(5, "c0127");
    }

    public boolean aBe() {
        return this.dJI;
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

    public boolean aBf() {
        int[] iArr = new int[2];
        try {
            this.dJs.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aBg() {
        return this.dJd;
    }

    public View awD() {
        return this.dJh;
    }

    public BarImageView aBh() {
        return this.dJu;
    }

    public TextView aBi() {
        return this.cXY;
    }

    public TextView aBj() {
        return this.dlq;
    }

    public boolean aAE() {
        return this.dJL;
    }

    public void gw(boolean z) {
        this.dJK = z;
        if (this.dJK) {
            this.dIZ.setVisibility(0);
        } else {
            this.dIZ.setVisibility(4);
        }
    }

    public boolean aAF() {
        return this.dJM;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dJR.clear();
    }

    public void onStop() {
        aBk();
    }

    public void fA(boolean z) {
        if (!z) {
            aBk();
        }
    }

    private void aBk() {
        if (this.dJt != null && this.dJt.isShowing()) {
            this.dJt.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gx(boolean z) {
        this.dJJ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dJA = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dJI = false;
            this.dJS = false;
            this.dJV.setVisibility(0);
            this.dJW.setVisibility(8);
            return;
        }
        this.dJI = true;
        this.dJV.setVisibility(8);
        this.dJW.setVisibility(0);
        if (z && !this.dJS) {
            awR();
            this.dJS = true;
        }
        d(false, f);
    }

    protected void awR() {
    }

    public void mc(int i) {
        if (i == 0) {
            this.dJI = false;
            this.dJS = false;
            this.dJV.setVisibility(0);
            this.dJW.setVisibility(8);
            return;
        }
        this.dJI = true;
        this.dJV.setVisibility(8);
        this.dJW.setVisibility(0);
    }

    public void md(int i) {
        if (i == 0) {
            this.dJL = false;
            this.dIZ.setText(f.j.sign);
            awM();
            return;
        }
        this.dJL = true;
        this.dIZ.setText(f.j.signed);
        awL();
    }

    protected void awM() {
    }

    protected void awL() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void awS() {
        if (this.mMemberType != 0) {
            am.c(this.dJs, f.C0146f.icon_speed_orange);
        } else {
            am.c(this.dJs, f.C0146f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dJH));
        if (this.dGv >= 10000) {
            if (this.dGv % 10000 == 0) {
                textView2.setText(this.mContext.getString(f.j.experience_divider) + String.valueOf(this.dGv / 10000) + this.mContext.getString(f.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(f.j.experience_divider) + String.valueOf(this.dGv / 10000.0f) + this.mContext.getString(f.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(f.j.experience_divider) + String.valueOf(this.dGv));
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

    public void awA() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.dJZ != null) {
            this.dJZ.setPadding(i, i2, i3, i4);
        }
    }
}

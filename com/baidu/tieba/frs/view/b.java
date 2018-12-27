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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
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
/* loaded from: classes6.dex */
public abstract class b {
    private static HashMap<Integer, String> ejJ = new HashMap<>();
    private static HashSet<Integer> ejK = new HashSet<>();
    public TextView dJO;
    protected FrsFragment dMs;
    protected TextView dwu;
    protected int efZ;
    protected l egI;
    protected TextView eiP;
    protected TextView eiQ;
    protected TextView eiR;
    protected TextView eiS;
    protected TextView eiT;
    protected ImageView eiU;
    protected ImageView eiV;
    protected View eiW;
    protected ViewGroup eiX;
    protected TextView eiY;
    protected View eiZ;
    protected int ejA;
    protected boolean ejB;
    protected boolean ejC;
    protected boolean ejD;
    protected boolean ejE;
    protected boolean ejF;
    protected boolean ejG;
    protected float ejH;
    protected TextView ejI;
    protected RelativeLayout ejO;
    protected RelativeLayout ejP;
    protected View ejQ;
    protected TextView ejR;
    protected RelativeLayout ejS;
    protected TextView ejT;
    protected AdapterLinearLayout eja;
    protected ViewGroup ejb;
    protected TextView ejc;
    protected TextView ejd;
    protected TbImageView eje;
    protected LinearLayout ejf;
    protected bd ejg;
    protected bg ejh;
    protected View eji;
    protected TextView ejj;
    protected TextView ejk;
    protected ImageView ejl;
    protected PopupWindow ejm;
    protected BarImageView ejn;
    protected UserIconBox ejo;
    protected ArrayList<h> ejp;
    protected com.baidu.tieba.frs.f.b ejq;
    protected e ejr;
    protected ag ejs;
    protected String ejt;
    protected String eju;
    protected String ejv;
    protected bb ejw;
    protected int ejx;
    protected int ejy;
    protected int ejz;
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
    protected int eiM = 0;
    protected int eiN = 0;
    protected int eiO = 0;
    private boolean ejL = false;
    protected HashSet<String> ejM = new HashSet<>();
    protected final Runnable ejN = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ejU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bJ(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.Ef().c(b.this.mContext, new String[]{url});
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bBZ(), b.this.dMs.getForumId(), b.this.dMs.getForumName(), null);
                b.cM("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void aEl();

    public abstract void aEm();

    public abstract void aEt();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void s(View.OnClickListener onClickListener);

    static {
        ejJ.put(1, "c0117");
        ejJ.put(2, "c0124");
        ejJ.put(3, "c0125");
        ejJ.put(4, "c0126");
        ejJ.put(5, "c0127");
    }

    public boolean aIG() {
        return this.ejB;
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

    public boolean aIH() {
        int[] iArr = new int[2];
        try {
            this.ejl.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aII() {
        return this.eiW;
    }

    public View aEg() {
        return this.eja;
    }

    public BarImageView aIJ() {
        return this.ejn;
    }

    public TextView aIK() {
        return this.dwu;
    }

    public TextView aIL() {
        return this.dJO;
    }

    public boolean aIc() {
        return this.ejE;
    }

    public void hB(boolean z) {
        this.ejD = z;
        if (this.ejD) {
            this.eiS.setVisibility(0);
        } else {
            this.eiS.setVisibility(4);
        }
    }

    public boolean aId() {
        return this.ejF;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        ejK.clear();
    }

    public void onStop() {
        aIM();
    }

    public void gx(boolean z) {
        if (!z) {
            aIM();
        }
    }

    private void aIM() {
        if (this.ejm != null && this.ejm.isShowing()) {
            this.ejm.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hC(boolean z) {
        this.ejC = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ejt = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ejB = false;
            this.ejL = false;
            this.ejO.setVisibility(0);
            this.ejP.setVisibility(8);
            return;
        }
        this.ejB = true;
        this.ejO.setVisibility(8);
        this.ejP.setVisibility(0);
        if (z && !this.ejL) {
            aEu();
            this.ejL = true;
        }
        d(false, f);
    }

    protected void aEu() {
    }

    public void nZ(int i) {
        if (i == 0) {
            this.ejB = false;
            this.ejL = false;
            this.ejO.setVisibility(0);
            this.ejP.setVisibility(8);
            return;
        }
        this.ejB = true;
        this.ejO.setVisibility(8);
        this.ejP.setVisibility(0);
    }

    public void oa(int i) {
        if (i == 0) {
            this.ejE = false;
            this.eiS.setText(e.j.sign);
            aEp();
            return;
        }
        this.ejE = true;
        this.eiS.setText(e.j.signed);
        aEo();
    }

    protected void aEp() {
    }

    protected void aEo() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aEv() {
        if (this.mMemberType != 0) {
            al.c(this.ejl, e.f.icon_speed_orange);
        } else {
            al.c(this.ejl, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ejA));
        if (this.efZ >= 10000) {
            if (this.efZ % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.efZ / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.efZ / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.efZ));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bU(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void aEb() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.ejS != null) {
            this.ejS.setPadding(i, i2, i3, i4);
        }
    }
}

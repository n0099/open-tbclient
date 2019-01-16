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
    private static HashMap<Integer, String> ekp = new HashMap<>();
    private static HashSet<Integer> ekq = new HashSet<>();
    public TextView dKx;
    protected FrsFragment dNb;
    protected TextView dxd;
    protected int egF;
    protected l eho;
    protected ImageView ejA;
    protected ImageView ejB;
    protected View ejC;
    protected ViewGroup ejD;
    protected TextView ejE;
    protected View ejF;
    protected AdapterLinearLayout ejG;
    protected ViewGroup ejH;
    protected TextView ejI;
    protected TextView ejJ;
    protected TbImageView ejK;
    protected LinearLayout ejL;
    protected bd ejM;
    protected bg ejN;
    protected View ejO;
    protected TextView ejP;
    protected TextView ejQ;
    protected ImageView ejR;
    protected PopupWindow ejS;
    protected BarImageView ejT;
    protected UserIconBox ejU;
    protected ArrayList<h> ejV;
    protected com.baidu.tieba.frs.f.b ejW;
    protected e ejX;
    protected ag ejY;
    protected String ejZ;
    protected TextView ejv;
    protected TextView ejw;
    protected TextView ejx;
    protected TextView ejy;
    protected TextView ejz;
    protected String eka;
    protected String ekb;
    protected bb ekc;
    protected int ekd;
    protected int eke;
    protected int ekf;
    protected int ekg;
    protected boolean ekh;
    protected boolean eki;
    protected boolean ekj;
    protected boolean ekk;
    protected boolean ekl;
    protected boolean ekm;
    protected float ekn;
    protected TextView eko;
    protected RelativeLayout eku;
    protected RelativeLayout ekv;
    protected View ekw;
    protected TextView ekx;
    protected RelativeLayout eky;
    protected TextView ekz;
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
    protected int ejs = 0;
    protected int ejt = 0;
    protected int eju = 0;
    private boolean ekr = false;
    protected HashSet<String> eks = new HashSet<>();
    protected final Runnable ekt = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ekA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bJ(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.Es().c(b.this.mContext, new String[]{url});
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bCI(), b.this.dNb.getForumId(), b.this.dNb.getForumName(), null);
                b.cO("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void aEI();

    public abstract void aEJ();

    public abstract void aEQ();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void s(View.OnClickListener onClickListener);

    static {
        ekp.put(1, "c0117");
        ekp.put(2, "c0124");
        ekp.put(3, "c0125");
        ekp.put(4, "c0126");
        ekp.put(5, "c0127");
    }

    public boolean aJe() {
        return this.ekh;
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

    public boolean aJf() {
        int[] iArr = new int[2];
        try {
            this.ejR.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aJg() {
        return this.ejC;
    }

    public View aED() {
        return this.ejG;
    }

    public BarImageView aJh() {
        return this.ejT;
    }

    public TextView aJi() {
        return this.dxd;
    }

    public TextView aJj() {
        return this.dKx;
    }

    public boolean aIz() {
        return this.ekk;
    }

    public void hB(boolean z) {
        this.ekj = z;
        if (this.ekj) {
            this.ejy.setVisibility(0);
        } else {
            this.ejy.setVisibility(4);
        }
    }

    public boolean aIA() {
        return this.ekl;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        ekq.clear();
    }

    public void onStop() {
        aJk();
    }

    public void gA(boolean z) {
        if (!z) {
            aJk();
        }
    }

    private void aJk() {
        if (this.ejS != null && this.ejS.isShowing()) {
            this.ejS.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hC(boolean z) {
        this.eki = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ejZ = str;
        this.mLevel = i2;
        if (i == 0) {
            this.ekh = false;
            this.ekr = false;
            this.eku.setVisibility(0);
            this.ekv.setVisibility(8);
            return;
        }
        this.ekh = true;
        this.eku.setVisibility(8);
        this.ekv.setVisibility(0);
        if (z && !this.ekr) {
            aER();
            this.ekr = true;
        }
        d(false, f);
    }

    protected void aER() {
    }

    public void oa(int i) {
        if (i == 0) {
            this.ekh = false;
            this.ekr = false;
            this.eku.setVisibility(0);
            this.ekv.setVisibility(8);
            return;
        }
        this.ekh = true;
        this.eku.setVisibility(8);
        this.ekv.setVisibility(0);
    }

    public void ob(int i) {
        if (i == 0) {
            this.ekk = false;
            this.ejy.setText(e.j.sign);
            aEM();
            return;
        }
        this.ekk = true;
        this.ejy.setText(e.j.signed);
        aEL();
    }

    protected void aEM() {
    }

    protected void aEL() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aES() {
        if (this.mMemberType != 0) {
            al.c(this.ejR, e.f.icon_speed_orange);
        } else {
            al.c(this.ejR, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ekg));
        if (this.egF >= 10000) {
            if (this.egF % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egF / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egF / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egF));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bV(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void aEy() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.eky != null) {
            this.eky.setPadding(i, i2, i3, i4);
        }
    }
}

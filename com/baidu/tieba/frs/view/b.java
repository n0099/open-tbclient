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
    private static HashMap<Integer, String> ekq = new HashMap<>();
    private static HashSet<Integer> ekr = new HashSet<>();
    public TextView dKy;
    protected FrsFragment dNc;
    protected TextView dxe;
    protected int egG;
    protected l ehp;
    protected TextView ejA;
    protected ImageView ejB;
    protected ImageView ejC;
    protected View ejD;
    protected ViewGroup ejE;
    protected TextView ejF;
    protected View ejG;
    protected AdapterLinearLayout ejH;
    protected ViewGroup ejI;
    protected TextView ejJ;
    protected TextView ejK;
    protected TbImageView ejL;
    protected LinearLayout ejM;
    protected bd ejN;
    protected bg ejO;
    protected View ejP;
    protected TextView ejQ;
    protected TextView ejR;
    protected ImageView ejS;
    protected PopupWindow ejT;
    protected BarImageView ejU;
    protected UserIconBox ejV;
    protected ArrayList<h> ejW;
    protected com.baidu.tieba.frs.f.b ejX;
    protected e ejY;
    protected ag ejZ;
    protected TextView ejw;
    protected TextView ejx;
    protected TextView ejy;
    protected TextView ejz;
    protected TextView ekA;
    protected String eka;
    protected String ekb;
    protected String ekc;
    protected bb ekd;
    protected int eke;
    protected int ekf;
    protected int ekg;
    protected int ekh;
    protected boolean eki;
    protected boolean ekj;
    protected boolean ekk;
    protected boolean ekl;
    protected boolean ekm;
    protected boolean ekn;
    protected float eko;
    protected TextView ekp;
    protected RelativeLayout ekv;
    protected RelativeLayout ekw;
    protected View ekx;
    protected TextView eky;
    protected RelativeLayout ekz;
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
    protected int ejt = 0;
    protected int eju = 0;
    protected int ejv = 0;
    private boolean eks = false;
    protected HashSet<String> ekt = new HashSet<>();
    protected final Runnable eku = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener ekB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
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
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bCI(), b.this.dNc.getForumId(), b.this.dNc.getForumName(), null);
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
        ekq.put(1, "c0117");
        ekq.put(2, "c0124");
        ekq.put(3, "c0125");
        ekq.put(4, "c0126");
        ekq.put(5, "c0127");
    }

    public boolean aJe() {
        return this.eki;
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
            this.ejS.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aJg() {
        return this.ejD;
    }

    public View aED() {
        return this.ejH;
    }

    public BarImageView aJh() {
        return this.ejU;
    }

    public TextView aJi() {
        return this.dxe;
    }

    public TextView aJj() {
        return this.dKy;
    }

    public boolean aIz() {
        return this.ekl;
    }

    public void hB(boolean z) {
        this.ekk = z;
        if (this.ekk) {
            this.ejz.setVisibility(0);
        } else {
            this.ejz.setVisibility(4);
        }
    }

    public boolean aIA() {
        return this.ekm;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        ekr.clear();
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
        if (this.ejT != null && this.ejT.isShowing()) {
            this.ejT.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void hC(boolean z) {
        this.ekj = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.eka = str;
        this.mLevel = i2;
        if (i == 0) {
            this.eki = false;
            this.eks = false;
            this.ekv.setVisibility(0);
            this.ekw.setVisibility(8);
            return;
        }
        this.eki = true;
        this.ekv.setVisibility(8);
        this.ekw.setVisibility(0);
        if (z && !this.eks) {
            aER();
            this.eks = true;
        }
        d(false, f);
    }

    protected void aER() {
    }

    public void oa(int i) {
        if (i == 0) {
            this.eki = false;
            this.eks = false;
            this.ekv.setVisibility(0);
            this.ekw.setVisibility(8);
            return;
        }
        this.eki = true;
        this.ekv.setVisibility(8);
        this.ekw.setVisibility(0);
    }

    public void ob(int i) {
        if (i == 0) {
            this.ekl = false;
            this.ejz.setText(e.j.sign);
            aEM();
            return;
        }
        this.ekl = true;
        this.ejz.setText(e.j.signed);
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
            al.c(this.ejS, e.f.icon_speed_orange);
        } else {
            al.c(this.ejS, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ekh));
        if (this.egG >= 10000) {
            if (this.egG % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egG / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egG / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.egG));
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
        if (this.ekz != null) {
            this.ekz.setPadding(i, i2, i3, i4);
        }
    }
}

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
    private static HashMap<Integer, String> dUq = new HashMap<>();
    private static HashSet<Integer> dUr = new HashSet<>();
    protected PopupWindow QK;
    protected TbPageContext aQp;
    protected View cHQ;
    public TextView dAu;
    protected i dCx;
    protected int dRK;
    protected l dSi;
    protected TextView dTA;
    protected TextView dTB;
    protected TextView dTC;
    protected ImageView dTD;
    protected View dTE;
    protected ViewGroup dTF;
    protected TextView dTG;
    protected View dTH;
    protected a dTI;
    protected ViewGroup dTJ;
    protected TextView dTK;
    protected TextView dTL;
    protected TbImageView dTM;
    protected LinearLayout dTN;
    protected bf dTO;
    protected bi dTP;
    protected View dTQ;
    protected TextView dTR;
    protected TextView dTS;
    protected ImageView dTT;
    protected PopupWindow dTU;
    protected BarImageView dTV;
    protected UserIconBox dTW;
    protected ArrayList<com.baidu.tbadk.core.data.g> dTX;
    protected com.baidu.tieba.frs.e.b dTY;
    protected f dTZ;
    protected TextView dTy;
    protected TextView dTz;
    protected TextView dUA;
    protected ai dUa;
    protected String dUb;
    protected String dUc;
    protected String dUd;
    protected bd dUe;
    protected int dUf;
    protected int dUg;
    protected int dUh;
    protected int dUi;
    protected boolean dUj;
    protected boolean dUk;
    protected boolean dUl;
    protected boolean dUm;
    protected boolean dUn;
    protected boolean dUo;
    protected float dUp;
    protected RelativeLayout dUv;
    protected RelativeLayout dUw;
    protected View dUx;
    protected TextView dUy;
    protected RelativeLayout dUz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dTv = 0;
    protected int dTw = 0;
    protected int dTx = 0;
    private boolean dUs = false;
    protected HashSet<String> dUt = new HashSet<>();
    protected final Runnable dUu = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QK != null && c.this.QK.isShowing() && !c.this.dUk) {
                com.baidu.adp.lib.g.g.a(c.this.QK, c.this.aQp.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dUB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((c.this.aQp == null || ax.be(c.this.aQp.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(c.this.aQp.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.CZ().c(c.this.aQp, new String[]{url});
                a.C0154a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btv(), c.this.dCx.getForumId(), c.this.dCx.getForumName(), null);
                b.cd("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void awc();

    public abstract void changeSkinType(int i);

    public abstract void l(View.OnClickListener onClickListener);

    public abstract void p(View view, boolean z);

    static {
        dUq.put(1, "c0117");
        dUq.put(2, "c0124");
        dUq.put(3, "c0125");
        dUq.put(4, "c0126");
        dUq.put(5, "c0127");
    }

    public boolean azq() {
        return this.dUj;
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

    public boolean azr() {
        int[] iArr = new int[2];
        try {
            this.dTT.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View azs() {
        return this.dTE;
    }

    public View azt() {
        return this.dTI;
    }

    public BarImageView azu() {
        return this.dTV;
    }

    public TextView azv() {
        return this.mTitleText;
    }

    public TextView azw() {
        return this.dAu;
    }

    public boolean azg() {
        return this.dUn;
    }

    public void gm(boolean z) {
        this.dUm = z;
        if (this.dUm) {
            this.dTB.setVisibility(0);
        } else {
            this.dTB.setVisibility(4);
        }
    }

    public boolean azh() {
        return this.dUo;
    }

    public void onDestory() {
        this.dUk = true;
        dUr.clear();
    }

    public void onStop() {
        azx();
    }

    public void gf(boolean z) {
        if (!z) {
            azx();
        }
    }

    private void azx() {
        if (this.dTU != null && this.dTU.isShowing()) {
            this.dTU.dismiss();
        }
        if (this.QK != null && this.QK.isShowing()) {
            this.QK.dismiss();
        }
    }

    public void gn(boolean z) {
        this.dUl = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dUb = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dUj = false;
            this.dUs = false;
            this.dUv.setVisibility(0);
            this.dUw.setVisibility(8);
            return;
        }
        this.dUj = true;
        this.dUv.setVisibility(8);
        this.dUw.setVisibility(0);
        if (z && !this.dUs) {
            awd();
            this.dUs = true;
        }
        c(false, f);
    }

    protected void awd() {
    }

    public void od(int i) {
        if (i == 0) {
            this.dUj = false;
            this.dUs = false;
            this.dUv.setVisibility(0);
            this.dUw.setVisibility(8);
            return;
        }
        this.dUj = true;
        this.dUv.setVisibility(8);
        this.dUw.setVisibility(0);
    }

    public void oe(int i) {
        if (i == 0) {
            this.dUn = false;
            this.dTB.setText(d.j.sign);
            avY();
            return;
        }
        this.dUn = true;
        this.dTB.setText(d.j.signed);
        avX();
    }

    protected void avY() {
    }

    protected void avX() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void awe() {
        if (this.mMemberType != 0) {
            aj.c(this.dTT, d.f.icon_speed_orange);
        } else {
            aj.c(this.dTT, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dUi));
        if (this.dRK >= 10000) {
            if (this.dRK % 10000 == 0) {
                textView2.setText(this.aQp.getString(d.j.experience_divider) + String.valueOf(this.dRK / 10000) + this.aQp.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aQp.getString(d.j.experience_divider) + String.valueOf(this.dRK / 10000.0f) + this.aQp.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aQp.getString(d.j.experience_divider) + String.valueOf(this.dRK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bx(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void avQ() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dUz != null) {
            this.dUz.setPadding(i, i2, i3, i4);
        }
    }
}

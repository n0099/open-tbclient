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
    private static HashMap<Integer, String> dUL = new HashMap<>();
    private static HashSet<Integer> dUM = new HashSet<>();
    protected PopupWindow QK;
    protected TbPageContext aQs;
    protected View cId;
    public TextView dAP;
    protected i dCS;
    protected l dSD;
    protected int dSf;
    protected TextView dTT;
    protected TextView dTU;
    protected TextView dTV;
    protected TextView dTW;
    protected TextView dTX;
    protected ImageView dTY;
    protected View dTZ;
    protected int dUA;
    protected int dUB;
    protected int dUC;
    protected int dUD;
    protected boolean dUE;
    protected boolean dUF;
    protected boolean dUG;
    protected boolean dUH;
    protected boolean dUI;
    protected boolean dUJ;
    protected float dUK;
    protected RelativeLayout dUQ;
    protected RelativeLayout dUR;
    protected View dUS;
    protected TextView dUT;
    protected RelativeLayout dUU;
    protected TextView dUV;
    protected ViewGroup dUa;
    protected TextView dUb;
    protected View dUc;
    protected a dUd;
    protected ViewGroup dUe;
    protected TextView dUf;
    protected TextView dUg;
    protected TbImageView dUh;
    protected LinearLayout dUi;
    protected bf dUj;
    protected bi dUk;
    protected View dUl;
    protected TextView dUm;
    protected TextView dUn;
    protected ImageView dUo;
    protected PopupWindow dUp;
    protected BarImageView dUq;
    protected UserIconBox dUr;
    protected ArrayList<com.baidu.tbadk.core.data.g> dUs;
    protected com.baidu.tieba.frs.e.b dUt;
    protected f dUu;
    protected ai dUv;
    protected String dUw;
    protected String dUx;
    protected String dUy;
    protected bd dUz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected TextView mTitleText;
    protected int dTQ = 0;
    protected int dTR = 0;
    protected int dTS = 0;
    private boolean dUN = false;
    protected HashSet<String> dUO = new HashSet<>();
    protected final Runnable dUP = new Runnable() { // from class: com.baidu.tieba.frs.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.QK != null && c.this.QK.isShowing() && !c.this.dUF) {
                com.baidu.adp.lib.g.g.a(c.this.QK, c.this.aQs.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dUW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((c.this.aQs == null || ax.bb(c.this.aQs.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(c.this.aQs.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.Da().c(c.this.aQs, new String[]{url});
                a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btx(), c.this.dCS.getForumId(), c.this.dCS.getForumName(), null);
                b.cc("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void awh();

    public abstract void changeSkinType(int i);

    public abstract void l(View.OnClickListener onClickListener);

    public abstract void p(View view, boolean z);

    static {
        dUL.put(1, "c0117");
        dUL.put(2, "c0124");
        dUL.put(3, "c0125");
        dUL.put(4, "c0126");
        dUL.put(5, "c0127");
    }

    public boolean azv() {
        return this.dUE;
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

    public boolean azw() {
        int[] iArr = new int[2];
        try {
            this.dUo.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View azx() {
        return this.dTZ;
    }

    public View azy() {
        return this.dUd;
    }

    public BarImageView azz() {
        return this.dUq;
    }

    public TextView azA() {
        return this.mTitleText;
    }

    public TextView azB() {
        return this.dAP;
    }

    public boolean azl() {
        return this.dUI;
    }

    public void gp(boolean z) {
        this.dUH = z;
        if (this.dUH) {
            this.dTW.setVisibility(0);
        } else {
            this.dTW.setVisibility(4);
        }
    }

    public boolean azm() {
        return this.dUJ;
    }

    public void onDestory() {
        this.dUF = true;
        dUM.clear();
    }

    public void onStop() {
        azC();
    }

    public void gi(boolean z) {
        if (!z) {
            azC();
        }
    }

    private void azC() {
        if (this.dUp != null && this.dUp.isShowing()) {
            this.dUp.dismiss();
        }
        if (this.QK != null && this.QK.isShowing()) {
            this.QK.dismiss();
        }
    }

    public void gq(boolean z) {
        this.dUG = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dUw = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dUE = false;
            this.dUN = false;
            this.dUQ.setVisibility(0);
            this.dUR.setVisibility(8);
            return;
        }
        this.dUE = true;
        this.dUQ.setVisibility(8);
        this.dUR.setVisibility(0);
        if (z && !this.dUN) {
            awi();
            this.dUN = true;
        }
        c(false, f);
    }

    protected void awi() {
    }

    public void od(int i) {
        if (i == 0) {
            this.dUE = false;
            this.dUN = false;
            this.dUQ.setVisibility(0);
            this.dUR.setVisibility(8);
            return;
        }
        this.dUE = true;
        this.dUQ.setVisibility(8);
        this.dUR.setVisibility(0);
    }

    public void oe(int i) {
        if (i == 0) {
            this.dUI = false;
            this.dTW.setText(d.j.sign);
            awd();
            return;
        }
        this.dUI = true;
        this.dTW.setText(d.j.signed);
        awc();
    }

    protected void awd() {
    }

    protected void awc() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void awj() {
        if (this.mMemberType != 0) {
            aj.c(this.dUo, d.f.icon_speed_orange);
        } else {
            aj.c(this.dUo, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dUD));
        if (this.dSf >= 10000) {
            if (this.dSf % 10000 == 0) {
                textView2.setText(this.aQs.getString(d.j.experience_divider) + String.valueOf(this.dSf / 10000) + this.aQs.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.aQs.getString(d.j.experience_divider) + String.valueOf(this.dSf / 10000.0f) + this.aQs.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aQs.getString(d.j.experience_divider) + String.valueOf(this.dSf));
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

    public void avV() {
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.dUU != null) {
            this.dUU.setPadding(i, i2, i3, i4);
        }
    }
}

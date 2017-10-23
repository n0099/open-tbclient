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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cJu = new HashMap<>();
    private static HashSet<Integer> cJv = new HashSet<>();
    protected TbPageContext abm;
    protected View bDw;
    protected View baq;
    protected int buH;
    protected int cHS;
    protected TextView cID;
    protected TextView cIE;
    protected TextView cIF;
    protected TextView cIG;
    protected TextView cIH;
    protected ImageView cII;
    protected View cIJ;
    protected ViewGroup cIK;
    protected TextView cIL;
    protected ViewGroup cIM;
    protected TextView cIN;
    protected TextView cIO;
    protected TbImageView cIP;
    protected LinearLayout cIQ;
    protected bi cIR;
    protected bl cIS;
    protected PopupWindow cIT;
    protected View cIU;
    protected TextView cIV;
    protected TextView cIW;
    protected ImageView cIX;
    protected PopupWindow cIY;
    protected BarImageView cIZ;
    protected RelativeLayout cJA;
    protected View cJB;
    protected TextView cJC;
    protected RelativeLayout cJD;
    protected UserIconBox cJa;
    protected ArrayList<h> cJb;
    protected com.baidu.tieba.frs.g.b cJc;
    protected e cJd;
    protected ah cJe;
    protected String cJf;
    protected String cJg;
    protected String cJh;
    protected bh cJi;
    protected int cJj;
    protected int cJk;
    protected int cJl;
    protected int cJm;
    protected boolean cJn;
    protected boolean cJo;
    protected boolean cJp;
    protected boolean cJq;
    protected boolean cJr;
    protected boolean cJs;
    protected float cJt;
    protected RelativeLayout cJz;
    public TextView cpy;
    protected com.baidu.tieba.frs.f crw;
    protected i cxc;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cIA = 0;
    protected int cIB = 0;
    protected int cIC = 0;
    private boolean cJw = false;
    protected HashSet<String> cJx = new HashSet<>();
    protected final Runnable cJy = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cIT != null && b.this.cIT.isShowing() && !b.this.cJo) {
                com.baidu.adp.lib.g.g.a(b.this.cIT, b.this.abm.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cJE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.abm == null || ax.aT(b.this.abm.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(b.this.abm.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                av.vA().c(b.this.abm, new String[]{url});
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bpk(), b.this.crw.getForumId(), b.this.crw.getForumName(), null);
                b.cd("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void aiR();

    public abstract void changeSkinType(int i);

    public abstract void g(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cJu.put(1, "c0117");
        cJu.put(2, "c0124");
        cJu.put(3, "c0125");
        cJu.put(4, "c0126");
        cJu.put(5, "c0127");
    }

    public boolean amd() {
        return this.cJn;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, (Animation.AnimationListener) null);
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

    public boolean ame() {
        int[] iArr = new int[2];
        try {
            this.cIX.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.baq;
    }

    public View amf() {
        return this.cIJ;
    }

    public BarImageView alV() {
        return this.cIZ;
    }

    public TextView amg() {
        return this.mTitleText;
    }

    public TextView amh() {
        return this.cpy;
    }

    public boolean alT() {
        return this.cJr;
    }

    public void fh(boolean z) {
        this.cJq = z;
        if (this.cJq) {
            this.cIG.setVisibility(0);
        } else {
            this.cIG.setVisibility(4);
        }
    }

    public boolean alU() {
        return this.cJs;
    }

    public void onDestory() {
        this.cJo = true;
        cJv.clear();
    }

    public void onStop() {
        if (this.cIY != null && this.cIY.isShowing()) {
            this.cIY.dismiss();
        }
        if (this.cIT != null && this.cIT.isShowing()) {
            this.cIT.dismiss();
        }
    }

    public void fi(boolean z) {
        this.cJp = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cJf = str;
        this.buH = i2;
        if (i == 0) {
            this.cJn = false;
            this.cJw = false;
            this.cJz.setVisibility(0);
            this.cJA.setVisibility(8);
            return;
        }
        this.cJn = true;
        this.cJz.setVisibility(8);
        this.cJA.setVisibility(0);
        if (z && !this.cJw) {
            aiS();
            this.cJw = true;
        }
        c(false, f);
    }

    protected void aiS() {
    }

    public void kh(int i) {
        if (i == 0) {
            this.cJn = false;
            this.cJw = false;
            this.cJz.setVisibility(0);
            this.cJA.setVisibility(8);
            return;
        }
        this.cJn = true;
        this.cJz.setVisibility(8);
        this.cJA.setVisibility(0);
    }

    public void ki(int i) {
        if (i == 0) {
            this.cJr = false;
            this.cIG.setText(d.l.sign);
            aiN();
            return;
        }
        this.cJr = true;
        this.cIG.setText(d.l.signed);
        aiM();
    }

    protected void aiN() {
    }

    protected void aiM() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aiT() {
        if (this.mMemberType != 0) {
            aj.c(this.cIX, d.g.icon_speed_orange);
        } else {
            aj.c(this.cIX, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cJm));
        if (this.cHS >= 10000) {
            if (this.cHS % 10000 == 0) {
                textView2.setText(this.abm.getString(d.l.experience_divider) + String.valueOf(this.cHS / 10000) + this.abm.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.abm.getString(d.l.experience_divider) + String.valueOf(this.cHS / 10000.0f) + this.abm.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.abm.getString(d.l.experience_divider) + String.valueOf(this.cHS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aY(List<com.baidu.tieba.tbadkCore.e> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.e> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.e next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void aiC() {
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cJD != null) {
            this.cJD.setPadding(i, i2, i3, i4);
        }
    }
}

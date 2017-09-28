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
    private static HashMap<Integer, String> cJG = new HashMap<>();
    private static HashSet<Integer> cJH = new HashSet<>();
    protected TbPageContext abz;
    protected View bDI;
    protected View baE;
    protected int buT;
    protected TextView cIP;
    protected TextView cIQ;
    protected TextView cIR;
    protected TextView cIS;
    protected TextView cIT;
    protected ImageView cIU;
    protected View cIV;
    protected ViewGroup cIW;
    protected TextView cIX;
    protected ViewGroup cIY;
    protected TextView cIZ;
    protected int cIe;
    protected boolean cJA;
    protected boolean cJB;
    protected boolean cJC;
    protected boolean cJD;
    protected boolean cJE;
    protected float cJF;
    protected RelativeLayout cJL;
    protected RelativeLayout cJM;
    protected View cJN;
    protected TextView cJO;
    protected RelativeLayout cJP;
    protected TextView cJa;
    protected TbImageView cJb;
    protected LinearLayout cJc;
    protected bi cJd;
    protected bl cJe;
    protected PopupWindow cJf;
    protected View cJg;
    protected TextView cJh;
    protected TextView cJi;
    protected ImageView cJj;
    protected PopupWindow cJk;
    protected BarImageView cJl;
    protected UserIconBox cJm;
    protected ArrayList<h> cJn;
    protected com.baidu.tieba.frs.g.b cJo;
    protected e cJp;
    protected ah cJq;
    protected String cJr;
    protected String cJs;
    protected String cJt;
    protected bh cJu;
    protected int cJv;
    protected int cJw;
    protected int cJx;
    protected int cJy;
    protected boolean cJz;
    public TextView cpK;
    protected com.baidu.tieba.frs.f crI;
    protected i cxo;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cIM = 0;
    protected int cIN = 0;
    protected int cIO = 0;
    private boolean cJI = false;
    protected HashSet<String> cJJ = new HashSet<>();
    protected final Runnable cJK = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cJf != null && b.this.cJf.isShowing() && !b.this.cJA) {
                com.baidu.adp.lib.g.g.a(b.this.cJf, b.this.abz.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cJQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.abz == null || ax.aU(b.this.abz.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(b.this.abz.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                av.vH().c(b.this.abz, new String[]{url});
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bps(), b.this.crI.getForumId(), b.this.crI.getForumName(), null);
                b.ce("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void aiW();

    public abstract void changeSkinType(int i);

    public abstract void g(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cJG.put(1, "c0117");
        cJG.put(2, "c0124");
        cJG.put(3, "c0125");
        cJG.put(4, "c0126");
        cJG.put(5, "c0127");
    }

    public boolean ami() {
        return this.cJz;
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

    public boolean amj() {
        int[] iArr = new int[2];
        try {
            this.cJj.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.baE;
    }

    public View amk() {
        return this.cIV;
    }

    public BarImageView ama() {
        return this.cJl;
    }

    public TextView aml() {
        return this.mTitleText;
    }

    public TextView amm() {
        return this.cpK;
    }

    public boolean alY() {
        return this.cJD;
    }

    public void fi(boolean z) {
        this.cJC = z;
        if (this.cJC) {
            this.cIS.setVisibility(0);
        } else {
            this.cIS.setVisibility(4);
        }
    }

    public boolean alZ() {
        return this.cJE;
    }

    public void onDestory() {
        this.cJA = true;
        cJH.clear();
    }

    public void onStop() {
        if (this.cJk != null && this.cJk.isShowing()) {
            this.cJk.dismiss();
        }
        if (this.cJf != null && this.cJf.isShowing()) {
            this.cJf.dismiss();
        }
    }

    public void fj(boolean z) {
        this.cJB = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cJr = str;
        this.buT = i2;
        if (i == 0) {
            this.cJz = false;
            this.cJI = false;
            this.cJL.setVisibility(0);
            this.cJM.setVisibility(8);
            return;
        }
        this.cJz = true;
        this.cJL.setVisibility(8);
        this.cJM.setVisibility(0);
        if (z && !this.cJI) {
            aiX();
            this.cJI = true;
        }
        c(false, f);
    }

    protected void aiX() {
    }

    public void ki(int i) {
        if (i == 0) {
            this.cJz = false;
            this.cJI = false;
            this.cJL.setVisibility(0);
            this.cJM.setVisibility(8);
            return;
        }
        this.cJz = true;
        this.cJL.setVisibility(8);
        this.cJM.setVisibility(0);
    }

    public void kj(int i) {
        if (i == 0) {
            this.cJD = false;
            this.cIS.setText(d.l.sign);
            aiS();
            return;
        }
        this.cJD = true;
        this.cIS.setText(d.l.signed);
        aiR();
    }

    protected void aiS() {
    }

    protected void aiR() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aiY() {
        if (this.mMemberType != 0) {
            aj.c(this.cJj, d.g.icon_speed_orange);
        } else {
            aj.c(this.cJj, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cJy));
        if (this.cIe >= 10000) {
            if (this.cIe % 10000 == 0) {
                textView2.setText(this.abz.getString(d.l.experience_divider) + String.valueOf(this.cIe / 10000) + this.abz.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.abz.getString(d.l.experience_divider) + String.valueOf(this.cIe / 10000.0f) + this.abz.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.abz.getString(d.l.experience_divider) + String.valueOf(this.cIe));
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

    public void aiH() {
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cJP != null) {
            this.cJP.setPadding(i, i2, i3, i4);
        }
    }
}

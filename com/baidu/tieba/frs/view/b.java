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
import com.baidu.tieba.tbadkCore.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> cSG = new HashMap<>();
    private static HashSet<Integer> cSH = new HashSet<>();
    protected TbPageContext abI;
    protected View bKG;
    protected View baW;
    protected j cET;
    protected TextView cRP;
    protected TextView cRQ;
    protected TextView cRR;
    protected TextView cRS;
    protected TextView cRT;
    protected ImageView cRU;
    protected View cRV;
    protected ViewGroup cRW;
    protected TextView cRX;
    protected ViewGroup cRY;
    protected TextView cRZ;
    protected int cRc;
    protected boolean cSA;
    protected boolean cSB;
    protected boolean cSC;
    protected boolean cSD;
    protected boolean cSE;
    protected float cSF;
    protected RelativeLayout cSL;
    protected RelativeLayout cSM;
    protected View cSN;
    protected TextView cSO;
    protected RelativeLayout cSP;
    protected TextView cSa;
    protected TbImageView cSb;
    protected LinearLayout cSc;
    protected bi cSd;
    protected bl cSe;
    protected PopupWindow cSf;
    protected View cSg;
    protected TextView cSh;
    protected TextView cSi;
    protected ImageView cSj;
    protected PopupWindow cSk;
    protected BarImageView cSl;
    protected UserIconBox cSm;
    protected ArrayList<h> cSn;
    protected com.baidu.tieba.frs.f.b cSo;
    protected e cSp;
    protected ah cSq;
    protected String cSr;
    protected String cSs;
    protected String cSt;
    protected bh cSu;
    protected int cSv;
    protected int cSw;
    protected int cSx;
    protected int cSy;
    protected boolean cSz;
    public TextView cwS;
    protected com.baidu.tieba.frs.f cyR;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cRM = 0;
    protected int cRN = 0;
    protected int cRO = 0;
    private boolean cSI = false;
    protected HashSet<String> cSJ = new HashSet<>();
    protected final Runnable cSK = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cSf != null && b.this.cSf.isShowing() && !b.this.cSA) {
                com.baidu.adp.lib.g.g.a(b.this.cSf, b.this.abI.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cSQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.abI == null || ax.aT(b.this.abI.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.showToast(b.this.abI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    return;
                }
                av.vI().c(b.this.abI, new String[]{url});
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bso(), b.this.cyR.getForumId(), b.this.cyR.getForumName(), null);
                b.ca("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, j jVar);

    public abstract void ald();

    public abstract void changeSkinType(int i);

    public abstract void h(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cSG.put(1, "c0117");
        cSG.put(2, "c0124");
        cSG.put(3, "c0125");
        cSG.put(4, "c0126");
        cSG.put(5, "c0127");
    }

    public boolean aoO() {
        return this.cSz;
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

    public boolean aoP() {
        int[] iArr = new int[2];
        try {
            this.cSj.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.baW;
    }

    public View aoQ() {
        return this.cRV;
    }

    public BarImageView aoG() {
        return this.cSl;
    }

    public TextView aoR() {
        return this.mTitleText;
    }

    public TextView aoS() {
        return this.cwS;
    }

    public boolean aoE() {
        return this.cSD;
    }

    public void fg(boolean z) {
        this.cSC = z;
        if (this.cSC) {
            this.cRS.setVisibility(0);
        } else {
            this.cRS.setVisibility(4);
        }
    }

    public boolean aoF() {
        return this.cSE;
    }

    public void onDestory() {
        this.cSA = true;
        cSH.clear();
    }

    public void onStop() {
        if (this.cSk != null && this.cSk.isShowing()) {
            this.cSk.dismiss();
        }
        if (this.cSf != null && this.cSf.isShowing()) {
            this.cSf.dismiss();
        }
    }

    public void fh(boolean z) {
        this.cSB = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cSr = str;
        this.mLevel = i2;
        if (i == 0) {
            this.cSz = false;
            this.cSI = false;
            this.cSL.setVisibility(0);
            this.cSM.setVisibility(8);
            return;
        }
        this.cSz = true;
        this.cSL.setVisibility(8);
        this.cSM.setVisibility(0);
        if (z && !this.cSI) {
            ale();
            this.cSI = true;
        }
        c(false, f);
    }

    protected void ale() {
    }

    public void kD(int i) {
        if (i == 0) {
            this.cSz = false;
            this.cSI = false;
            this.cSL.setVisibility(0);
            this.cSM.setVisibility(8);
            return;
        }
        this.cSz = true;
        this.cSL.setVisibility(8);
        this.cSM.setVisibility(0);
    }

    public void kE(int i) {
        if (i == 0) {
            this.cSD = false;
            this.cRS.setText(d.j.sign);
            akZ();
            return;
        }
        this.cSD = true;
        this.cRS.setText(d.j.signed);
        akY();
    }

    protected void akZ() {
    }

    protected void akY() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void alf() {
        if (this.mMemberType != 0) {
            aj.c(this.cSj, d.f.icon_speed_orange);
        } else {
            aj.c(this.cSj, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cSy));
        if (this.cRc >= 10000) {
            if (this.cRc % 10000 == 0) {
                textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRc / 10000) + this.abI.getString(d.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRc / 10000.0f) + this.abI.getString(d.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.abI.getString(d.j.experience_divider) + String.valueOf(this.cRc));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bb(List<com.baidu.tieba.tbadkCore.e> list) {
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

    public void akO() {
    }

    public void p(int i, int i2, int i3, int i4) {
        if (this.cSP != null) {
            this.cSP.setPadding(i, i2, i3, i4);
        }
    }
}

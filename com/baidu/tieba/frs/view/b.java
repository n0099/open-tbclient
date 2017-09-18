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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
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
    private static HashMap<Integer, String> cIQ = new HashMap<>();
    private static HashSet<Integer> cIR = new HashSet<>();
    protected View aYR;
    protected TbPageContext aby;
    protected View bBX;
    protected int bth;
    protected TextView cHZ;
    protected int cHn;
    protected ag cIA;
    protected String cIB;
    protected String cIC;
    protected String cID;
    protected bj cIE;
    protected int cIF;
    protected int cIG;
    protected int cIH;
    protected int cII;
    protected boolean cIJ;
    protected boolean cIK;
    protected boolean cIL;
    protected boolean cIM;
    protected boolean cIN;
    protected boolean cIO;
    protected float cIP;
    protected RelativeLayout cIV;
    protected RelativeLayout cIW;
    protected View cIX;
    protected TextView cIY;
    protected RelativeLayout cIZ;
    protected TextView cIa;
    protected TextView cIb;
    protected TextView cIc;
    protected TextView cId;
    protected ImageView cIe;
    protected View cIf;
    protected ViewGroup cIg;
    protected TextView cIh;
    protected ViewGroup cIi;
    protected TextView cIj;
    protected TextView cIk;
    protected TbImageView cIl;
    protected LinearLayout cIm;
    protected bk cIn;
    protected bn cIo;
    protected PopupWindow cIp;
    protected View cIq;
    protected TextView cIr;
    protected TextView cIs;
    protected ImageView cIt;
    protected PopupWindow cIu;
    protected BarImageView cIv;
    protected UserIconBox cIw;
    protected ArrayList<h> cIx;
    protected com.baidu.tieba.frs.g.b cIy;
    protected e cIz;
    public TextView cpl;
    protected com.baidu.tieba.frs.f crm;
    protected i cwy;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected TextView mTitleText;
    protected int cHW = 0;
    protected int cHX = 0;
    protected int cHY = 0;
    private boolean cIS = false;
    protected HashSet<String> cIT = new HashSet<>();
    protected final Runnable cIU = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cIp != null && b.this.cIp.isShowing() && !b.this.cIK) {
                g.a(b.this.cIp, b.this.aby.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener cJa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((b.this.aby == null || ax.aU(b.this.aby.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) && (eVar = (com.baidu.tieba.tbadkCore.e) view.getTag()) != null && !StringUtils.isNull(eVar.getUrl())) {
                String url = eVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    k.showToast(b.this.aby.getPageActivity(), d.l.book_plugin_not_install_tip);
                    return;
                }
                au.wd().c(b.this.aby, new String[]{url});
                a.C0123a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqw(), b.this.crm.getForumId(), b.this.crm.getForumName(), null);
                b.cj("obj_url", eVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, i iVar);

    public abstract void aiS();

    public abstract void changeSkinType(int i);

    public abstract void g(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cIQ.put(1, "c0117");
        cIQ.put(2, "c0124");
        cIQ.put(3, "c0125");
        cIQ.put(4, "c0126");
        cIQ.put(5, "c0127");
    }

    public boolean ame() {
        return this.cIJ;
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

    public boolean amf() {
        int[] iArr = new int[2];
        try {
            this.cIt.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aYR;
    }

    public View amg() {
        return this.cIf;
    }

    public BarImageView alW() {
        return this.cIv;
    }

    public TextView amh() {
        return this.mTitleText;
    }

    public TextView ami() {
        return this.cpl;
    }

    public boolean alU() {
        return this.cIN;
    }

    public void fo(boolean z) {
        this.cIM = z;
        if (this.cIM) {
            this.cIc.setVisibility(0);
        } else {
            this.cIc.setVisibility(4);
        }
    }

    public boolean alV() {
        return this.cIO;
    }

    public void onDestory() {
        this.cIK = true;
        cIR.clear();
    }

    public void onStop() {
        if (this.cIu != null && this.cIu.isShowing()) {
            this.cIu.dismiss();
        }
        if (this.cIp != null && this.cIp.isShowing()) {
            this.cIp.dismiss();
        }
    }

    public void fp(boolean z) {
        this.cIL = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cIB = str;
        this.bth = i2;
        if (i == 0) {
            this.cIJ = false;
            this.cIS = false;
            this.cIV.setVisibility(0);
            this.cIW.setVisibility(8);
            return;
        }
        this.cIJ = true;
        this.cIV.setVisibility(8);
        this.cIW.setVisibility(0);
        if (z && !this.cIS) {
            aiT();
            this.cIS = true;
        }
        c(false, f);
    }

    protected void aiT() {
    }

    public void ka(int i) {
        if (i == 0) {
            this.cIJ = false;
            this.cIS = false;
            this.cIV.setVisibility(0);
            this.cIW.setVisibility(8);
            return;
        }
        this.cIJ = true;
        this.cIV.setVisibility(8);
        this.cIW.setVisibility(0);
    }

    public void kb(int i) {
        if (i == 0) {
            this.cIN = false;
            this.cIc.setText(d.l.sign);
            aiO();
            return;
        }
        this.cIN = true;
        this.cIc.setText(d.l.signed);
        aiN();
    }

    protected void aiO() {
    }

    protected void aiN() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aiU() {
        if (this.mMemberType != 0) {
            aj.c(this.cIt, d.g.icon_speed_orange);
        } else {
            aj.c(this.cIt, d.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cII));
        if (this.cHn >= 10000) {
            if (this.cHn % 10000 == 0) {
                textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cHn / 10000) + this.aby.getString(d.l.member_count_unit));
                return;
            } else {
                textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cHn / 10000.0f) + this.aby.getString(d.l.member_count_unit));
                return;
            }
        }
        textView2.setText(this.aby.getString(d.l.experience_divider) + String.valueOf(this.cHn));
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

    public void aiD() {
    }

    public void l(int i, int i2, int i3, int i4) {
        if (this.cIZ != null) {
            this.cIZ.setPadding(i, i2, i3, i4);
        }
    }
}

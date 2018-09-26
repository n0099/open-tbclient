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
/* loaded from: classes2.dex */
public abstract class b {
    private static HashMap<Integer, String> dRa = new HashMap<>();
    private static HashSet<Integer> dRb = new HashSet<>();
    protected int dNC;
    protected l dOl;
    protected TextView dQA;
    protected TextView dQB;
    protected ImageView dQC;
    protected PopupWindow dQD;
    protected BarImageView dQE;
    protected UserIconBox dQF;
    protected ArrayList<h> dQG;
    protected com.baidu.tieba.frs.f.b dQH;
    protected e dQI;
    protected ag dQJ;
    protected String dQK;
    protected String dQL;
    protected String dQM;
    protected bb dQN;
    protected int dQO;
    protected int dQP;
    protected int dQQ;
    protected int dQR;
    protected boolean dQS;
    protected boolean dQT;
    protected boolean dQU;
    protected boolean dQV;
    protected boolean dQW;
    protected boolean dQX;
    protected float dQY;
    protected TextView dQZ;
    protected TextView dQg;
    protected TextView dQh;
    protected TextView dQi;
    protected TextView dQj;
    protected TextView dQk;
    protected ImageView dQl;
    protected ImageView dQm;
    protected View dQn;
    protected ViewGroup dQo;
    protected TextView dQp;
    protected View dQq;
    protected AdapterLinearLayout dQr;
    protected ViewGroup dQs;
    protected TextView dQt;
    protected TextView dQu;
    protected TbImageView dQv;
    protected LinearLayout dQw;
    protected bd dQx;
    protected bg dQy;
    protected View dQz;
    protected RelativeLayout dRf;
    protected RelativeLayout dRg;
    protected View dRh;
    protected TextView dRi;
    protected RelativeLayout dRj;
    protected TextView dRk;
    protected TextView ddU;
    public TextView drj;
    protected FrsFragment dtN;
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
    protected int dQd = 0;
    protected int dQe = 0;
    protected int dQf = 0;
    private boolean dRc = false;
    protected HashSet<String> dRd = new HashSet<>();
    protected final Runnable dRe = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dRl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.bA(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    return;
                }
                ay.AN().c(b.this.mContext, new String[]{url});
                a.C0242a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bwD(), b.this.dtN.getForumId(), b.this.dtN.getForumName(), null);
                b.cw("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void ayW();

    public abstract void ayX();

    public abstract void aze();

    public abstract void changeSkinType(int i);

    public abstract void i(View view, boolean z);

    public abstract void q(View.OnClickListener onClickListener);

    static {
        dRa.put(1, "c0117");
        dRa.put(2, "c0124");
        dRa.put(3, "c0125");
        dRa.put(4, "c0126");
        dRa.put(5, "c0127");
    }

    public boolean aDp() {
        return this.dQS;
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

    public boolean aDq() {
        int[] iArr = new int[2];
        try {
            this.dQC.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View aDr() {
        return this.dQn;
    }

    public View ayR() {
        return this.dQr;
    }

    public BarImageView aDs() {
        return this.dQE;
    }

    public TextView aDt() {
        return this.ddU;
    }

    public TextView aDu() {
        return this.drj;
    }

    public boolean aCN() {
        return this.dQV;
    }

    public void gU(boolean z) {
        this.dQU = z;
        if (this.dQU) {
            this.dQj.setVisibility(0);
        } else {
            this.dQj.setVisibility(4);
        }
    }

    public boolean aCO() {
        return this.dQW;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dRb.clear();
    }

    public void onStop() {
        aDv();
    }

    public void fR(boolean z) {
        if (!z) {
            aDv();
        }
    }

    private void aDv() {
        if (this.dQD != null && this.dQD.isShowing()) {
            this.dQD.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gV(boolean z) {
        this.dQT = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dQK = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dQS = false;
            this.dRc = false;
            this.dRf.setVisibility(0);
            this.dRg.setVisibility(8);
            return;
        }
        this.dQS = true;
        this.dRf.setVisibility(8);
        this.dRg.setVisibility(0);
        if (z && !this.dRc) {
            azf();
            this.dRc = true;
        }
        d(false, f);
    }

    protected void azf() {
    }

    public void mG(int i) {
        if (i == 0) {
            this.dQS = false;
            this.dRc = false;
            this.dRf.setVisibility(0);
            this.dRg.setVisibility(8);
            return;
        }
        this.dQS = true;
        this.dRf.setVisibility(8);
        this.dRg.setVisibility(0);
    }

    public void mH(int i) {
        if (i == 0) {
            this.dQV = false;
            this.dQj.setText(e.j.sign);
            aza();
            return;
        }
        this.dQV = true;
        this.dQj.setText(e.j.signed);
        ayZ();
    }

    protected void aza() {
    }

    protected void ayZ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void azg() {
        if (this.mMemberType != 0) {
            al.c(this.dQC, e.f.icon_speed_orange);
        } else {
            al.c(this.dQC, e.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dQR));
        if (this.dNC >= 10000) {
            if (this.dNC % 10000 == 0) {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dNC / 10000) + this.mContext.getString(e.j.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dNC / 10000.0f) + this.mContext.getString(e.j.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(e.j.experience_divider) + String.valueOf(this.dNC));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void ayO() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dRj != null) {
            this.dRj.setPadding(i, i2, i3, i4);
        }
    }
}

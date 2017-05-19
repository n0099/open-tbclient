package com.baidu.tieba.frs.view;

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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.g;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> ccQ = new HashMap<>();
    private static HashSet<Integer> ccR = new HashSet<>();
    protected View aXK;
    protected TbPageContext aat;
    protected TextView bKb;
    protected com.baidu.tieba.frs.r bPw;
    protected com.baidu.tieba.tbadkCore.n bTj;
    protected int bhs;
    protected View bpr;
    protected int cbA;
    protected TextView cbY;
    protected TextView cbZ;
    protected bv ccA;
    protected String ccB;
    protected String ccC;
    protected String ccD;
    protected bk ccE;
    protected int ccF;
    protected int ccG;
    protected int ccH;
    protected int ccI;
    protected boolean ccJ;
    protected boolean ccK;
    protected boolean ccL;
    protected boolean ccM;
    protected boolean ccN;
    protected boolean ccO;
    protected float ccP;
    protected RelativeLayout ccV;
    protected RelativeLayout ccW;
    protected View ccX;
    protected TextView ccY;
    protected RelativeLayout ccZ;
    protected TextView cca;
    protected TextView ccb;
    protected TextView ccc;
    protected ImageView ccd;
    protected View cce;
    protected ViewGroup ccf;
    protected TextView ccg;
    protected ViewGroup cch;
    protected TextView cci;
    protected TextView ccj;
    protected TbImageView cck;
    protected LinearLayout ccl;
    protected LinearLayout ccm;
    protected bn ccn;
    protected bq cco;
    protected PopupWindow ccp;
    protected View ccq;
    protected TextView ccr;
    protected TextView ccs;
    protected ImageView cct;
    protected PopupWindow ccu;
    protected BarImageView ccv;
    protected UserIconBox ccw;
    protected ArrayList<g> ccx;
    protected com.baidu.tieba.frs.d.b ccy;
    protected j ccz;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cbV = 0;
    protected int cbW = 0;
    protected int cbX = 0;
    private boolean ccS = false;
    protected HashSet<String> ccT = new HashSet<>();
    protected final Runnable ccU = new c(this);
    protected final View.OnClickListener cda = new d(this);

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar);

    public abstract void aaw();

    public abstract void changeSkinType(int i);

    public abstract void d(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        ccQ.put(1, "c0117");
        ccQ.put(2, "c0124");
        ccQ.put(3, "c0125");
        ccQ.put(4, "c0126");
        ccQ.put(5, "c0127");
    }

    public boolean adf() {
        return this.ccJ;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, (Animation.AnimationListener) null);
    }

    public void b(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new e(this, tbPageContextSupport, view, f2));
    }

    public boolean adg() {
        int[] iArr = new int[2];
        try {
            this.cct.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aXK;
    }

    public View adh() {
        return this.cce;
    }

    public BarImageView ada() {
        return this.ccv;
    }

    public TextView adi() {
        return this.bKb;
    }

    public boolean acY() {
        return this.ccN;
    }

    public void ek(boolean z) {
        this.ccM = z;
        if (this.ccM) {
            this.ccb.setVisibility(0);
        } else {
            this.ccb.setVisibility(4);
        }
    }

    public boolean acZ() {
        return this.ccO;
    }

    public void onDestory() {
        this.ccK = true;
        ccR.clear();
    }

    public void onStop() {
        if (this.ccu != null && this.ccu.isShowing()) {
            this.ccu.dismiss();
        }
        if (this.ccp != null && this.ccp.isShowing()) {
            this.ccp.dismiss();
        }
    }

    public void el(boolean z) {
        this.ccL = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ccB = str;
        this.bhs = i2;
        if (i == 0) {
            this.ccJ = false;
            this.ccS = false;
            this.ccV.setVisibility(0);
            this.ccW.setVisibility(8);
            return;
        }
        this.ccJ = true;
        this.ccV.setVisibility(8);
        this.ccW.setVisibility(0);
        if (z && !this.ccS) {
            aax();
            this.ccS = true;
        }
        c(false, f);
    }

    protected void aax() {
    }

    public void iI(int i) {
        if (i == 0) {
            this.ccJ = false;
            this.ccS = false;
            this.ccV.setVisibility(0);
            this.ccW.setVisibility(8);
            return;
        }
        this.ccJ = true;
        this.ccV.setVisibility(8);
        this.ccW.setVisibility(0);
    }

    public void iJ(int i) {
        if (i == 0) {
            this.ccN = false;
            this.ccb.setText(w.l.sign);
            aas();
            return;
        }
        this.ccN = true;
        this.ccb.setText(w.l.signed);
        aar();
    }

    protected void aas() {
    }

    protected void aar() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aay() {
        if (this.mMemberType != 0) {
            aq.c(this.cct, w.g.icon_speed_orange);
        } else {
            aq.c(this.cct, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ccI));
        if (this.cbA >= 10000) {
            if (this.cbA % 10000 == 0) {
                textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cbA / 10000) + this.aat.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cbA / 10000.0f) + this.aat.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cbA));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(View view) {
        this.aat.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void aak() {
    }

    public void iK(int i) {
        if (this.ccZ != null) {
            this.ccZ.setPadding(0, i, 0, 0);
        }
    }
}

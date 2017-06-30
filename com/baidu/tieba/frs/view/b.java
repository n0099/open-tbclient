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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    private static HashMap<Integer, String> crf = new HashMap<>();
    private static HashSet<Integer> crg = new HashSet<>();
    protected View aWF;
    protected TbPageContext aat;
    protected TextView bWL;
    protected int bmb;
    protected View buk;
    protected r cdv;
    protected n chk;
    protected int cpN;
    protected LinearLayout cqA;
    protected bp cqB;
    protected bs cqC;
    protected PopupWindow cqD;
    protected View cqE;
    protected TextView cqF;
    protected TextView cqG;
    protected ImageView cqH;
    protected PopupWindow cqI;
    protected BarImageView cqJ;
    protected UserIconBox cqK;
    protected ArrayList<h> cqL;
    protected com.baidu.tieba.frs.e.b cqM;
    protected j cqN;
    protected bx cqO;
    protected String cqP;
    protected String cqQ;
    protected String cqR;
    protected bm cqS;
    protected int cqT;
    protected int cqU;
    protected int cqV;
    protected int cqW;
    protected boolean cqX;
    protected boolean cqY;
    protected boolean cqZ;
    protected TextView cqm;
    protected TextView cqn;
    protected TextView cqo;
    protected TextView cqp;
    protected TextView cqq;
    protected ImageView cqr;
    protected View cqs;
    protected ViewGroup cqt;
    protected TextView cqu;
    protected ViewGroup cqv;
    protected TextView cqw;
    protected TextView cqx;
    protected TbImageView cqy;
    protected LinearLayout cqz;
    protected boolean cra;
    protected boolean crb;
    protected boolean crd;
    protected float cre;
    protected RelativeLayout crk;
    protected RelativeLayout crl;
    protected View crm;
    protected TextView crn;
    protected RelativeLayout cro;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cqj = 0;
    protected int cqk = 0;
    protected int cql = 0;
    private boolean crh = false;
    protected HashSet<String> cri = new HashSet<>();
    protected final Runnable crj = new c(this);
    protected final View.OnClickListener crp = new d(this);

    public abstract void a(ForumData forumData, n nVar);

    public abstract void afq();

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        crf.put(1, "c0117");
        crf.put(2, "c0124");
        crf.put(3, "c0125");
        crf.put(4, "c0126");
        crf.put(5, "c0127");
    }

    public boolean ahW() {
        return this.cqX;
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

    public boolean ahX() {
        int[] iArr = new int[2];
        try {
            this.cqH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aWF;
    }

    public View ahY() {
        return this.cqs;
    }

    public BarImageView ahR() {
        return this.cqJ;
    }

    public TextView ahZ() {
        return this.bWL;
    }

    public boolean ahP() {
        return this.crb;
    }

    public void eR(boolean z) {
        this.cra = z;
        if (this.cra) {
            this.cqp.setVisibility(0);
        } else {
            this.cqp.setVisibility(4);
        }
    }

    public boolean ahQ() {
        return this.crd;
    }

    public void onDestory() {
        this.cqY = true;
        crg.clear();
    }

    public void onStop() {
        if (this.cqI != null && this.cqI.isShowing()) {
            this.cqI.dismiss();
        }
        if (this.cqD != null && this.cqD.isShowing()) {
            this.cqD.dismiss();
        }
    }

    public void eS(boolean z) {
        this.cqZ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cqP = str;
        this.bmb = i2;
        if (i == 0) {
            this.cqX = false;
            this.crh = false;
            this.crk.setVisibility(0);
            this.crl.setVisibility(8);
            return;
        }
        this.cqX = true;
        this.crk.setVisibility(8);
        this.crl.setVisibility(0);
        if (z && !this.crh) {
            afr();
            this.crh = true;
        }
        c(false, f);
    }

    protected void afr() {
    }

    public void jr(int i) {
        if (i == 0) {
            this.cqX = false;
            this.crh = false;
            this.crk.setVisibility(0);
            this.crl.setVisibility(8);
            return;
        }
        this.cqX = true;
        this.crk.setVisibility(8);
        this.crl.setVisibility(0);
    }

    public void js(int i) {
        if (i == 0) {
            this.crb = false;
            this.cqp.setText(w.l.sign);
            afm();
            return;
        }
        this.crb = true;
        this.cqp.setText(w.l.signed);
        afl();
    }

    protected void afm() {
    }

    protected void afl() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void afs() {
        if (this.mMemberType != 0) {
            as.c(this.cqH, w.g.icon_speed_orange);
        } else {
            as.c(this.cqH, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cqW));
        if (this.cpN >= 10000) {
            if (this.cpN % 10000 == 0) {
                textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cpN / 10000) + this.aat.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cpN / 10000.0f) + this.aat.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aat.getString(w.l.experience_divider)) + String.valueOf(this.cpN));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(View view) {
        this.aat.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aC(List<g> list) {
        if (list != null && list.size() != 0) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void c(boolean z, float f) {
    }

    public void afd() {
    }

    public void jt(int i) {
        if (this.cro != null) {
            this.cro.setPadding(0, i, 0, 0);
        }
    }
}

package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> cdF = new HashMap<>();
    private static HashSet<Integer> cdG = new HashSet<>();
    private String VP;
    protected View aXl;
    protected TbPageContext<FrsActivity> aaX;
    protected TextView bIG;
    protected FrsActivity bOf;
    protected n bSZ;
    protected int bfk;
    protected View bmE;
    protected int cby;
    protected TextView ccA;
    protected FrameLayout ccB;
    protected Button ccC;
    protected TextView ccD;
    protected ProgressBar ccE;
    protected FrameLayout ccF;
    protected TextView ccG;
    protected RelativeLayout ccH;
    protected TextView ccI;
    protected ImageView ccJ;
    protected ImageView ccK;
    protected View ccL;
    protected View ccM;
    protected ViewGroup ccN;
    protected TextView ccO;
    protected CoverFlowView<com.baidu.tbadk.core.data.t> ccP;
    protected TextView ccQ;
    private Drawable ccR;
    protected ForumHeadSdkView ccS;
    protected ViewGroup ccT;
    protected TextView ccU;
    protected TextView ccV;
    protected TbImageView ccW;
    protected LinearLayout ccX;
    protected LinearLayout ccY;
    protected bl ccZ;
    protected TextView ccw;
    protected TextView ccx;
    protected FrameLayout ccy;
    protected Button ccz;
    protected boolean cdA;
    protected boolean cdB;
    protected boolean cdC;
    protected boolean cdD;
    protected float cdE;
    private int cdH;
    protected bo cda;
    protected PopupWindow cdb;
    protected View cdc;
    protected TextView cdd;
    protected TextView cde;
    protected ImageView cdf;
    protected PopupWindow cdg;
    protected BarImageView cdh;
    protected UserIconBox cdi;
    protected ArrayList<com.baidu.tbadk.core.data.g> cdj;
    protected com.baidu.tieba.frs.f.b cdk;
    protected p cdl;
    protected cc cdm;
    protected ForumMemberIconView cdn;
    protected com.baidu.tbadk.core.data.v cdo;
    protected String cdp;
    protected String cdq;
    protected String cdr;
    protected bi cds;
    protected int cdu;
    protected int cdv;
    protected int cdw;
    protected int cdx;
    protected boolean cdy;
    protected boolean cdz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cct = 0;
    protected int ccu = 0;
    protected int ccv = 0;
    protected String cdt = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean cdI = false;
    protected HashSet<String> cdJ = new HashSet<>();
    protected final Runnable cdK = new d(this);
    protected final View.OnClickListener cdL = new e(this);
    protected final View.OnClickListener cdM = new f(this);
    protected final View.OnClickListener amB = new g(this);
    protected final View.OnClickListener cdN = new h(this);

    public abstract void a(ForumData forumData, n nVar);

    public abstract void abh();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cdF.put(1, "c0117");
        cdF.put(2, "c0124");
        cdF.put(3, "c0125");
        cdF.put(4, "c0126");
        cdF.put(5, "c0127");
    }

    public boolean aep() {
        return this.cdy;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new i(this, tbPageContextSupport, view, f2));
    }

    public boolean aeq() {
        int[] iArr = new int[2];
        try {
            this.cdf.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aXl;
    }

    public View aer() {
        return this.ccL;
    }

    public View aes() {
        return this.ccM;
    }

    public BarImageView aea() {
        return this.cdh;
    }

    public TextView aet() {
        return this.bIG;
    }

    public boolean adY() {
        return this.cdC;
    }

    public void eo(boolean z) {
        this.cdB = z;
        if (this.cdB) {
            this.ccB.setVisibility(0);
        } else {
            this.ccB.setVisibility(4);
        }
    }

    public View aeu() {
        return this.ccH;
    }

    public boolean adZ() {
        return this.cdD;
    }

    public ProgressBar aev() {
        return this.ccE;
    }

    public void onDestory() {
        this.cdz = true;
        cdG.clear();
    }

    public void onStop() {
        if (this.cdg != null && this.cdg.isShowing()) {
            this.cdg.dismiss();
        }
        if (this.cdb != null && this.cdb.isShowing()) {
            this.cdb.dismiss();
        }
    }

    public void ep(boolean z) {
        this.cdA = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cdp = str;
        this.bfk = i2;
        if (i == 0) {
            this.cdy = false;
            this.cdI = false;
            this.ccy.setVisibility(0);
            this.ccH.setVisibility(8);
            return;
        }
        this.cdy = true;
        this.ccy.setVisibility(8);
        if (z && !this.cdI) {
            abi();
            this.cdI = true;
        }
        c(false, f);
        this.ccH.setVisibility(0);
    }

    protected void abi() {
    }

    public void iK(int i) {
        if (i == 0) {
            this.cdy = false;
            this.cdI = false;
            this.ccy.setVisibility(0);
            this.ccH.setVisibility(8);
            if (this.cdm != null) {
                this.cdm.hide();
                return;
            }
            return;
        }
        this.cdy = true;
        this.ccy.setVisibility(8);
        this.ccH.setVisibility(0);
    }

    public void iL(int i) {
        if (i == 0) {
            this.cdC = false;
            this.ccF.setVisibility(8);
            this.ccB.setVisibility(0);
            abf();
            return;
        }
        this.cdC = true;
        this.ccB.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.ccF.setClickable(true);
        } else {
            this.ccF.setClickable(false);
        }
        abe();
    }

    protected void abf() {
        aq.j(this.ccC, w.g.frs_btn_sign);
    }

    protected void abe() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void abj() {
        if (this.mMemberType != 0) {
            aq.c(this.cdf, w.g.icon_speed_orange);
        } else {
            aq.c(this.cdf, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cdx));
        if (this.cby >= 10000) {
            if (this.cby % 10000 == 0) {
                textView2.setText(String.valueOf(this.aaX.getString(w.l.experience_divider)) + String.valueOf(this.cby / 10000) + this.aaX.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aaX.getString(w.l.experience_divider)) + String.valueOf(this.cby / 10000.0f) + this.aaX.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aaX.getString(w.l.experience_divider)) + String.valueOf(this.cby));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(View view) {
        this.aaX.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaX.getLayoutMode().t(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aw(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (this.ccP == null || rVar == null || rVar.qi() == null || rVar.qi().size() <= 0) {
            if (this.ccP != null) {
                this.ccP.setVisibility(8);
                return;
            }
            return;
        }
        this.VP = rVar.qj();
        this.ccR = aq.getDrawable(w.g.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds10);
        this.ccP.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.t> qi = rVar.qi();
        List<com.baidu.tbadk.core.data.t> subList = qi.size() > 5 ? qi.subList(0, 5) : qi;
        this.cdH = subList.size();
        if (subList.size() > 1) {
            this.ccP.setDisableParentEvent(true);
        } else {
            this.ccP.setDisableParentEvent(false);
        }
        this.ccP.setData(subList);
        if (this.ccQ != null) {
            if (subList.size() > 2) {
                this.ccQ.setPadding(this.cct, 0, this.ccv, 0);
            } else {
                this.ccQ.setPadding(this.cct, 0, this.ccu, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).qv()) {
                    this.ccQ.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.ccQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.ccQ.setText("");
                } else {
                    this.ccQ.setCompoundDrawablePadding(this.drawablePadding);
                    this.ccQ.setCompoundDrawablesWithIntrinsicBounds(this.ccR, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.ccQ.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bOf != null) {
                    str = this.bOf.getForumId();
                    str2 = this.bOf.getForumName();
                }
                if (cdG.add(1)) {
                    a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", cdF.get(1), "ad_plat", "VIEW_TRUE", this.VP, str, str2, null);
                    a.cc("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        if (this.ccS != null) {
            if (yVar == null) {
                this.ccS.setVisibility(8);
                return;
            }
            this.ccS.setData(yVar);
            this.ccS.setClickListener(this.cdN);
            this.ccS.show();
            this.ccS.setVisibility(0);
            if (this.ccP != null) {
                this.ccP.setVisibility(8);
            }
        }
    }

    public void aew() {
        if (this.ccP != null) {
            this.ccP.setCoverFlowFactory(new k(this));
            this.ccP.setCallback(new l(this));
        }
    }

    public void aaW() {
    }
}

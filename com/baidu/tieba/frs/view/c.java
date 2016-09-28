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
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> cgO = new HashMap<>();
    private static HashSet<Integer> cgP = new HashSet<>();
    protected TextView FV;
    protected TextView FW;
    protected TextView FX;
    protected TextView FY;
    protected View Gc;
    protected TbPageContext<FrsActivity> Gd;
    private String QJ;
    protected CoverFlowView<com.baidu.tbadk.core.data.r> bAe;
    protected FrsActivity bRi;
    protected com.baidu.tieba.tbadkCore.p bWN;
    protected ForumHeadVideoView cbI;
    protected FrameLayout cfI;
    protected Button cfJ;
    protected FrameLayout cfK;
    protected Button cfL;
    protected TextView cfM;
    protected ProgressBar cfN;
    protected FrameLayout cfO;
    protected TextView cfP;
    protected RelativeLayout cfQ;
    protected TextView cfR;
    protected ImageView cfS;
    protected ImageView cfT;
    protected View cfU;
    protected ViewGroup cfV;
    protected TextView cfW;
    protected View cfX;
    protected TextView cfY;
    private Drawable cfZ;
    protected int cfk;
    protected bi cgA;
    protected int cgC;
    protected int cgD;
    protected int cgE;
    protected int cgF;
    protected int cgG;
    protected boolean cgH;
    protected boolean cgI;
    protected boolean cgJ;
    protected boolean cgK;
    protected boolean cgL;
    protected boolean cgM;
    protected float cgN;
    private int cgQ;
    protected ForumHeadSdkView cga;
    protected ViewGroup cgb;
    protected TextView cgc;
    protected TextView cgd;
    protected TbImageView cge;
    protected LinearLayout cgg;
    protected bm cgh;
    protected bp cgi;
    protected PopupWindow cgj;
    protected View cgk;
    protected TextView cgl;
    protected TextView cgm;
    protected ImageView cgn;
    protected PopupWindow cgo;
    protected BarImageView cgp;
    protected UserIconBox cgq;
    protected ArrayList<com.baidu.tbadk.core.data.f> cgr;
    protected bb cgs;
    protected o cgt;
    protected df cgu;
    protected ForumMemberIconView cgv;
    protected com.baidu.tbadk.core.data.t cgw;
    protected String cgx;
    protected String cgy;
    protected String cgz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cfF = 0;
    protected int cfG = 0;
    protected int cfH = 0;
    protected boolean cgf = true;
    protected String cgB = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean cgR = false;
    protected HashSet<String> cgS = new HashSet<>();
    protected final Runnable cgT = new d(this);
    protected final View.OnClickListener cgU = new e(this);
    protected final View.OnClickListener ahC = new f(this);
    protected final View.OnClickListener cgV = new g(this);
    protected boolean cgW = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar);

    public abstract void ade();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cgO.put(1, "c0117");
        cgO.put(2, "c0124");
        cgO.put(3, "c0125");
        cgO.put(4, "c0126");
        cgO.put(5, "c0127");
    }

    public boolean afT() {
        return this.cgH;
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
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new h(this, tbPageContextSupport, view, f2));
    }

    public boolean afU() {
        int[] iArr = new int[2];
        try {
            this.cgn.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Gc.setTag(this.cbI);
        return this.Gc;
    }

    public View afV() {
        return this.cfU;
    }

    public BarImageView afO() {
        return this.cgp;
    }

    public TextView afW() {
        return this.FX;
    }

    public boolean afM() {
        return this.cgL;
    }

    public void el(boolean z) {
        this.cgK = z;
        if (this.cgK) {
            this.cfK.setVisibility(0);
        } else {
            this.cfK.setVisibility(4);
        }
    }

    public View afX() {
        return this.cfQ;
    }

    public boolean afN() {
        return this.cgM;
    }

    public ProgressBar afY() {
        return this.cfN;
    }

    public ForumHeadVideoView afZ() {
        return this.cbI;
    }

    public void onDestory() {
        this.cgI = true;
        cgP.clear();
    }

    public void onStop() {
        if (this.cgo != null && this.cgo.isShowing()) {
            this.cgo.dismiss();
        }
        if (this.cgj != null && this.cgj.isShowing()) {
            this.cgj.dismiss();
        }
    }

    public void em(boolean z) {
        this.cgJ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cgx = str;
        this.cgC = i2;
        if (i == 0) {
            this.cgH = false;
            this.cgR = false;
            this.cfI.setVisibility(0);
            this.cfQ.setVisibility(8);
            return;
        }
        this.cgH = true;
        this.cfI.setVisibility(8);
        if (z && !this.cgR) {
            adf();
            this.cgR = true;
        }
        a(false, f);
        this.cfQ.setVisibility(0);
    }

    protected void adf() {
    }

    public void iI(int i) {
        if (i == 0) {
            this.cgH = false;
            this.cgR = false;
            this.cfI.setVisibility(0);
            this.cfQ.setVisibility(8);
            if (this.cgu != null) {
                this.cgu.hide();
                return;
            }
            return;
        }
        this.cgH = true;
        this.cfI.setVisibility(8);
        this.cfQ.setVisibility(0);
    }

    public void iJ(int i) {
        if (i == 0) {
            this.cgL = false;
            this.cfO.setVisibility(8);
            this.cfK.setVisibility(0);
            ada();
            return;
        }
        this.cgL = true;
        this.cfK.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.cfO.setClickable(true);
        } else {
            this.cfO.setClickable(false);
        }
        acZ();
    }

    protected void ada() {
        av.k(this.cfL, r.f.frs_btn_sign);
    }

    protected void acZ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void adg() {
        if (this.mMemberType != 0) {
            av.c(this.cgn, r.f.icon_speed_orange);
        } else {
            av.c(this.cgn, r.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cgG));
        if (this.cfk >= 10000) {
            if (this.cfk % 10000 == 0) {
                textView2.setText(String.valueOf(this.Gd.getString(r.j.experience_divider)) + String.valueOf(this.cfk / 10000) + this.Gd.getString(r.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Gd.getString(r.j.experience_divider)) + String.valueOf(this.cfk / 10000.0f) + this.Gd.getString(r.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Gd.getString(r.j.experience_divider)) + String.valueOf(this.cfk));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aC(List<com.baidu.tieba.tbadkCore.h> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.h> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.h next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void a(boolean z, float f) {
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (this.bAe == null || pVar == null || pVar.pw() == null || pVar.pw().size() <= 0) {
            if (this.bAe != null) {
                this.bAe.setVisibility(8);
                return;
            }
            return;
        }
        this.QJ = pVar.px();
        this.cfZ = av.getDrawable(r.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds10);
        this.bAe.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.r> pw = pVar.pw();
        List<com.baidu.tbadk.core.data.r> subList = pw.size() > 5 ? pw.subList(0, 5) : pw;
        this.cgQ = subList.size();
        if (subList.size() > 1) {
            this.bAe.setDisableParentEvent(true);
        } else {
            this.bAe.setDisableParentEvent(false);
        }
        this.bAe.setData(subList);
        if (this.cfY != null) {
            if (subList.size() > 2) {
                this.cfY.setPadding(this.cfF, 0, this.cfH, 0);
            } else {
                this.cfY.setPadding(this.cfF, 0, this.cfG, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pI()) {
                    this.cfY.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.cfY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cfY.setText("");
                } else {
                    this.cfY.setCompoundDrawablePadding(this.drawablePadding);
                    this.cfY.setCompoundDrawablesWithIntrinsicBounds(this.cfZ, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cfY.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bRi != null) {
                    str = this.bRi.getForumId();
                    str2 = this.bRi.getForumName();
                }
                if (cgP.add(1)) {
                    a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", cgO.get(1), "ad_plat", "VIEW_TRUE", this.QJ, str, str2, null);
                    a.bT("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        if (this.cga != null) {
            if (vVar == null) {
                this.cga.setVisibility(8);
                return;
            }
            this.cga.setData(vVar);
            this.cga.setClickListener(this.cgV);
            this.cga.show();
            this.cga.setVisibility(0);
            if (this.bAe != null) {
                this.bAe.setVisibility(8);
            }
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.cbI != null && this.bRi != null) {
            if (!this.cgf) {
                this.cbI.setVisibility(8);
            } else if (com.baidu.tbadk.core.util.y.t(list)) {
                this.cbI.setVisibility(8);
            } else {
                if (this.cbI.getVisibility() != 0) {
                    this.cbI.setVisibility(0);
                }
                this.cbI.a(j, list, this.bRi.aaJ());
                if (this.bAe != null) {
                    this.bAe.setVisibility(8);
                }
                if (this.cga != null) {
                    this.cga.setVisibility(8);
                }
            }
        }
    }

    public void VE() {
        if (this.bAe != null) {
            this.bAe.setCoverFlowFactory(new j(this));
            this.bAe.setCallback(new k(this));
        }
    }

    public void acR() {
    }
}

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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> cgQ = new HashMap<>();
    private static HashSet<Integer> cgR = new HashSet<>();
    protected TextView FV;
    protected TextView FW;
    protected TextView FX;
    protected TextView FY;
    protected View Gc;
    protected TbPageContext<FrsActivity> Gd;
    private String QF;
    protected FrsActivity bRp;
    protected com.baidu.tieba.tbadkCore.p bWN;
    protected CoverFlowView<com.baidu.tbadk.core.data.r> bzS;
    protected ForumHeadVideoView cbG;
    protected FrameLayout cfL;
    protected Button cfM;
    protected FrameLayout cfN;
    protected Button cfO;
    protected TextView cfP;
    protected ProgressBar cfQ;
    protected FrameLayout cfR;
    protected TextView cfS;
    protected RelativeLayout cfT;
    protected TextView cfU;
    protected ImageView cfV;
    protected ImageView cfW;
    protected View cfX;
    protected ViewGroup cfY;
    protected TextView cfZ;
    protected int cfn;
    protected String cgA;
    protected String cgB;
    protected bg cgC;
    protected int cgE;
    protected int cgF;
    protected int cgG;
    protected int cgH;
    protected int cgI;
    protected boolean cgJ;
    protected boolean cgK;
    protected boolean cgL;
    protected boolean cgM;
    protected boolean cgN;
    protected boolean cgO;
    protected float cgP;
    private int cgS;
    protected View cga;
    protected TextView cgb;
    private Drawable cgc;
    protected ForumHeadSdkView cgd;
    protected ViewGroup cge;
    protected TextView cgf;
    protected TextView cgg;
    protected TbImageView cgh;
    protected LinearLayout cgi;
    protected bk cgj;
    protected bn cgk;
    protected PopupWindow cgl;
    protected View cgm;
    protected TextView cgn;
    protected TextView cgo;
    protected ImageView cgp;
    protected PopupWindow cgq;
    protected BarImageView cgr;
    protected UserIconBox cgs;
    protected ArrayList<com.baidu.tbadk.core.data.f> cgt;
    protected bb cgu;
    protected o cgv;
    protected df cgw;
    protected ForumMemberIconView cgx;
    protected com.baidu.tbadk.core.data.s cgy;
    protected String cgz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cfI = 0;
    protected int cfJ = 0;
    protected int cfK = 0;
    protected String cgD = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean cgT = false;
    protected HashSet<String> cgU = new HashSet<>();
    protected final Runnable cgV = new d(this);
    protected final View.OnClickListener cgW = new e(this);
    protected final View.OnClickListener ahU = new f(this);
    protected final View.OnClickListener cgX = new g(this);
    protected boolean cgY = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar);

    public abstract void acS();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cgQ.put(1, "c0117");
        cgQ.put(2, "c0124");
        cgQ.put(3, "c0125");
        cgQ.put(4, "c0126");
        cgQ.put(5, "c0127");
    }

    public boolean afF() {
        return this.cgJ;
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

    public boolean afG() {
        int[] iArr = new int[2];
        try {
            this.cgp.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Gc.setTag(this.cbG);
        return this.Gc;
    }

    public View afH() {
        return this.cfX;
    }

    public BarImageView afA() {
        return this.cgr;
    }

    public TextView afI() {
        return this.FX;
    }

    public boolean afy() {
        return this.cgN;
    }

    public void ek(boolean z) {
        this.cgM = z;
        if (this.cgM) {
            this.cfN.setVisibility(0);
        } else {
            this.cfN.setVisibility(4);
        }
    }

    public View afJ() {
        return this.cfT;
    }

    public boolean afz() {
        return this.cgO;
    }

    public ProgressBar afK() {
        return this.cfQ;
    }

    public ForumHeadVideoView afL() {
        return this.cbG;
    }

    public void onDestory() {
        this.cgK = true;
        cgR.clear();
    }

    public void onStop() {
        if (this.cgq != null && this.cgq.isShowing()) {
            this.cgq.dismiss();
        }
        if (this.cgl != null && this.cgl.isShowing()) {
            this.cgl.dismiss();
        }
    }

    public void el(boolean z) {
        this.cgL = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cgz = str;
        this.cgE = i2;
        if (i == 0) {
            this.cgJ = false;
            this.cgT = false;
            this.cfL.setVisibility(0);
            this.cfT.setVisibility(8);
            return;
        }
        this.cgJ = true;
        this.cfL.setVisibility(8);
        if (z && !this.cgT) {
            acT();
            this.cgT = true;
        }
        a(false, f);
        this.cfT.setVisibility(0);
    }

    protected void acT() {
    }

    public void iD(int i) {
        if (i == 0) {
            this.cgJ = false;
            this.cgT = false;
            this.cfL.setVisibility(0);
            this.cfT.setVisibility(8);
            if (this.cgw != null) {
                this.cgw.hide();
                return;
            }
            return;
        }
        this.cgJ = true;
        this.cfL.setVisibility(8);
        this.cfT.setVisibility(0);
    }

    public void iE(int i) {
        if (i == 0) {
            this.cgN = false;
            this.cfR.setVisibility(8);
            this.cfN.setVisibility(0);
            acO();
            return;
        }
        this.cgN = true;
        this.cfN.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.cfR.setClickable(true);
        } else {
            this.cfR.setClickable(false);
        }
        acN();
    }

    protected void acO() {
        av.k(this.cfO, t.f.frs_btn_sign);
    }

    protected void acN() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void acU() {
        if (this.mMemberType != 0) {
            av.c(this.cgp, t.f.icon_speed_orange);
        } else {
            av.c(this.cgp, t.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cgI));
        if (this.cfn >= 10000) {
            if (this.cfn % 10000 == 0) {
                textView2.setText(String.valueOf(this.Gd.getString(t.j.experience_divider)) + String.valueOf(this.cfn / 10000) + this.Gd.getString(t.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Gd.getString(t.j.experience_divider)) + String.valueOf(this.cfn / 10000.0f) + this.Gd.getString(t.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Gd.getString(t.j.experience_divider)) + String.valueOf(this.cfn));
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
        if (this.bzS == null || pVar == null || pVar.pv() == null || pVar.pv().size() <= 0) {
            if (this.bzS != null) {
                this.bzS.setVisibility(8);
                return;
            }
            return;
        }
        this.QF = pVar.pw();
        this.cgc = av.getDrawable(t.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds10);
        this.bzS.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.r> pv = pVar.pv();
        List<com.baidu.tbadk.core.data.r> subList = pv.size() > 5 ? pv.subList(0, 5) : pv;
        this.cgS = subList.size();
        if (subList.size() > 1) {
            this.bzS.setDisableParentEvent(true);
        } else {
            this.bzS.setDisableParentEvent(false);
        }
        this.bzS.setData(subList);
        if (this.cgb != null) {
            if (subList.size() > 2) {
                this.cgb.setPadding(this.cfI, 0, this.cfK, 0);
            } else {
                this.cgb.setPadding(this.cfI, 0, this.cfJ, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pF()) {
                    this.cgb.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.cgb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cgb.setText("");
                } else {
                    this.cgb.setCompoundDrawablePadding(this.drawablePadding);
                    this.cgb.setCompoundDrawablesWithIntrinsicBounds(this.cgc, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cgb.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bRp != null) {
                    str = this.bRp.getForumId();
                    str2 = this.bRp.getForumName();
                }
                if (cgR.add(1)) {
                    a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", cgQ.get(1), "ad_plat", "VIEW_TRUE", this.QF, str, str2, null);
                    a.bS("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        if (this.cgd != null) {
            if (uVar == null) {
                this.cgd.setVisibility(8);
                return;
            }
            this.cgd.setData(uVar);
            this.cgd.setClickListener(this.cgX);
            this.cgd.show();
            this.cgd.setVisibility(0);
            if (this.bzS != null) {
                this.bzS.setVisibility(8);
            }
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.cbG != null && this.bRp != null) {
            if (com.baidu.tbadk.core.util.y.t(list)) {
                this.cbG.setVisibility(8);
                return;
            }
            if (this.cbG.getVisibility() != 0) {
                this.cbG.setVisibility(0);
            }
            this.cbG.a(j, list, this.bRp.aav());
            if (this.bzS != null) {
                this.bzS.setVisibility(8);
            }
            if (this.cgd != null) {
                this.cgd.setVisibility(8);
            }
        }
    }

    public void Vl() {
        if (this.bzS != null) {
            this.bzS.setCoverFlowFactory(new j(this));
            this.bzS.setCallback(new k(this));
        }
    }

    public void acF() {
    }
}

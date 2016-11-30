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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
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
    private static HashMap<Integer, String> clT = new HashMap<>();
    private static HashSet<Integer> clU = new HashSet<>();
    protected TextView FX;
    protected TextView FY;
    protected TextView FZ;
    protected TextView Ga;
    protected View Ge;
    protected TbPageContext<FrsActivity> Gf;
    private String Rf;
    protected CoverFlowView<com.baidu.tbadk.core.data.s> bCZ;
    protected FrsActivity bTA;
    protected com.baidu.tieba.tbadkCore.p cae;
    protected ForumHeadVideoView cfe;
    protected int cjV;
    protected FrameLayout ckL;
    protected Button ckM;
    protected FrameLayout ckN;
    protected Button ckO;
    protected TextView ckP;
    protected ProgressBar ckQ;
    protected FrameLayout ckR;
    protected TextView ckS;
    protected RelativeLayout ckT;
    protected TextView ckU;
    protected ImageView ckV;
    protected ImageView ckW;
    protected View ckX;
    protected View ckY;
    protected ViewGroup ckZ;
    protected ForumMemberIconView clA;
    protected com.baidu.tbadk.core.data.u clB;
    protected String clC;
    protected String clD;
    protected String clE;
    protected bk clF;
    protected int clH;
    protected int clI;
    protected int clJ;
    protected int clK;
    protected int clL;
    protected boolean clM;
    protected boolean clN;
    protected boolean clO;
    protected boolean clP;
    protected boolean clQ;
    protected boolean clR;
    protected float clS;
    private int clV;
    protected TextView cla;
    protected View clb;
    protected TextView clc;
    private Drawable cld;
    protected ForumHeadSdkView cle;
    protected ViewGroup clf;
    protected TextView clg;
    protected TextView clh;
    protected TbImageView cli;
    protected LinearLayout clk;
    protected LinearLayout cll;
    protected bo clm;
    protected br cln;
    protected PopupWindow clo;
    protected View clp;
    protected TextView clq;
    protected TextView clr;
    protected ImageView cls;
    protected PopupWindow clt;
    protected BarImageView clu;
    protected UserIconBox clv;
    protected ArrayList<com.baidu.tbadk.core.data.g> clw;
    protected com.baidu.tieba.frs.utils.b clx;
    protected p cly;
    protected cd clz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int ckI = 0;
    protected int ckJ = 0;
    protected int ckK = 0;
    protected boolean clj = true;
    protected String clG = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean clW = false;
    protected HashSet<String> clX = new HashSet<>();
    protected final Runnable clY = new d(this);
    protected final View.OnClickListener clZ = new e(this);
    protected final View.OnClickListener cma = new f(this);
    protected final View.OnClickListener aid = new g(this);
    protected final View.OnClickListener cmb = new h(this);
    protected boolean cmc = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar);

    public abstract void aer();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        clT.put(1, "c0117");
        clT.put(2, "c0124");
        clT.put(3, "c0125");
        clT.put(4, "c0126");
        clT.put(5, "c0127");
    }

    public boolean ahO() {
        return this.clM;
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

    public boolean ahP() {
        int[] iArr = new int[2];
        try {
            this.cls.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Ge.setTag(this.cfe);
        return this.Ge;
    }

    public View ahQ() {
        return this.ckX;
    }

    public View ahR() {
        return this.ckY;
    }

    public BarImageView ahB() {
        return this.clu;
    }

    public TextView ahS() {
        return this.FZ;
    }

    public boolean ahz() {
        return this.clQ;
    }

    public void eA(boolean z) {
        this.clP = z;
        if (this.clP) {
            this.ckN.setVisibility(0);
        } else {
            this.ckN.setVisibility(4);
        }
    }

    public View ahT() {
        return this.ckT;
    }

    public boolean ahA() {
        return this.clR;
    }

    public ProgressBar ahU() {
        return this.ckQ;
    }

    public ForumHeadVideoView ahV() {
        return this.cfe;
    }

    public void onDestory() {
        this.clN = true;
        clU.clear();
    }

    public void onStop() {
        if (this.clt != null && this.clt.isShowing()) {
            this.clt.dismiss();
        }
        if (this.clo != null && this.clo.isShowing()) {
            this.clo.dismiss();
        }
    }

    public void eB(boolean z) {
        this.clO = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.clC = str;
        this.clH = i2;
        if (i == 0) {
            this.clM = false;
            this.clW = false;
            this.ckL.setVisibility(0);
            this.ckT.setVisibility(8);
            return;
        }
        this.clM = true;
        this.ckL.setVisibility(8);
        if (z && !this.clW) {
            aes();
            this.clW = true;
        }
        a(false, f);
        this.ckT.setVisibility(0);
    }

    protected void aes() {
    }

    public void iP(int i) {
        if (i == 0) {
            this.clM = false;
            this.clW = false;
            this.ckL.setVisibility(0);
            this.ckT.setVisibility(8);
            if (this.clz != null) {
                this.clz.hide();
                return;
            }
            return;
        }
        this.clM = true;
        this.ckL.setVisibility(8);
        this.ckT.setVisibility(0);
    }

    public void iQ(int i) {
        if (i == 0) {
            this.clQ = false;
            this.ckR.setVisibility(8);
            this.ckN.setVisibility(0);
            aen();
            return;
        }
        this.clQ = true;
        this.ckN.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.ckR.setClickable(true);
        } else {
            this.ckR.setClickable(false);
        }
        aem();
    }

    protected void aen() {
        at.k(this.ckO, r.f.frs_btn_sign);
    }

    protected void aem() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aet() {
        if (this.mMemberType != 0) {
            at.c(this.cls, r.f.icon_speed_orange);
        } else {
            at.c(this.cls, r.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.clL));
        if (this.cjV >= 10000) {
            if (this.cjV % 10000 == 0) {
                textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.cjV / 10000) + this.Gf.getString(r.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.cjV / 10000.0f) + this.Gf.getString(r.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.cjV));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aE(List<com.baidu.tieba.tbadkCore.h> list) {
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

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (this.bCZ == null || qVar == null || qVar.pz() == null || qVar.pz().size() <= 0) {
            if (this.bCZ != null) {
                this.bCZ.setVisibility(8);
                return;
            }
            return;
        }
        this.Rf = qVar.pA();
        this.cld = at.getDrawable(r.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds10);
        this.bCZ.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.s> pz = qVar.pz();
        List<com.baidu.tbadk.core.data.s> subList = pz.size() > 5 ? pz.subList(0, 5) : pz;
        this.clV = subList.size();
        if (subList.size() > 1) {
            this.bCZ.setDisableParentEvent(true);
        } else {
            this.bCZ.setDisableParentEvent(false);
        }
        this.bCZ.setData(subList);
        if (this.clc != null) {
            if (subList.size() > 2) {
                this.clc.setPadding(this.ckI, 0, this.ckK, 0);
            } else {
                this.clc.setPadding(this.ckI, 0, this.ckJ, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pL()) {
                    this.clc.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.clc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.clc.setText("");
                } else {
                    this.clc.setCompoundDrawablePadding(this.drawablePadding);
                    this.clc.setCompoundDrawablesWithIntrinsicBounds(this.cld, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.clc.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bTA != null) {
                    str = this.bTA.getForumId();
                    str2 = this.bTA.getForumName();
                }
                if (clU.add(1)) {
                    a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", clT.get(1), "ad_plat", "VIEW_TRUE", this.Rf, str, str2, null);
                    a.bV("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        if (this.cle != null) {
            if (xVar == null) {
                this.cle.setVisibility(8);
                return;
            }
            this.cle.setData(xVar);
            this.cle.setClickListener(this.cmb);
            this.cle.show();
            this.cle.setVisibility(0);
            if (this.bCZ != null) {
                this.bCZ.setVisibility(8);
            }
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.cfe != null && this.bTA != null) {
            if (!this.clj) {
                this.cfe.setVisibility(8);
            } else if (com.baidu.tbadk.core.util.x.t(list)) {
                this.cfe.setVisibility(8);
            } else {
                if (this.cfe.getVisibility() != 0) {
                    this.cfe.setVisibility(0);
                }
                this.cfe.a(j, list, this.bTA.abQ());
                if (this.bCZ != null) {
                    this.bCZ.setVisibility(8);
                }
                if (this.cle != null) {
                    this.cle.setVisibility(8);
                }
            }
        }
    }

    public void WG() {
        if (this.bCZ != null) {
            this.bCZ.setCoverFlowFactory(new k(this));
            this.bCZ.setCallback(new l(this));
        }
    }

    public void aee() {
    }
}

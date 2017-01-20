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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> bXI = new HashMap<>();
    private static HashSet<Integer> bXJ = new HashSet<>();
    protected TextView Fh;
    protected TextView Fi;
    protected TextView Fj;
    protected TextView Fk;
    protected View Fo;
    protected TbPageContext<FrsActivity> Fp;
    private String Ql;
    protected FrsActivity bHh;
    protected n bMf;
    protected ForumHeadVideoView bRg;
    protected int bVF;
    protected FrameLayout bWA;
    protected Button bWB;
    protected FrameLayout bWC;
    protected Button bWD;
    protected TextView bWE;
    protected ProgressBar bWF;
    protected FrameLayout bWG;
    protected TextView bWH;
    protected RelativeLayout bWI;
    protected TextView bWJ;
    protected ImageView bWK;
    protected ImageView bWL;
    protected View bWM;
    protected View bWN;
    protected ViewGroup bWO;
    protected TextView bWP;
    protected CoverFlowView<com.baidu.tbadk.core.data.s> bWQ;
    protected TextView bWR;
    private Drawable bWS;
    protected ForumHeadSdkView bWT;
    protected ViewGroup bWU;
    protected TextView bWV;
    protected TextView bWW;
    protected TbImageView bWX;
    protected LinearLayout bWZ;
    protected int bXA;
    protected boolean bXB;
    protected boolean bXC;
    protected boolean bXD;
    protected boolean bXE;
    protected boolean bXF;
    protected boolean bXG;
    protected float bXH;
    private int bXK;
    protected LinearLayout bXa;
    protected bk bXb;
    protected bn bXc;
    protected PopupWindow bXd;
    protected View bXe;
    protected TextView bXf;
    protected TextView bXg;
    protected ImageView bXh;
    protected PopupWindow bXi;
    protected BarImageView bXj;
    protected UserIconBox bXk;
    protected ArrayList<com.baidu.tbadk.core.data.h> bXl;
    protected com.baidu.tieba.frs.utils.b bXm;
    protected p bXn;
    protected ca bXo;
    protected ForumMemberIconView bXp;
    protected com.baidu.tbadk.core.data.u bXq;
    protected String bXr;
    protected String bXs;
    protected String bXt;
    protected bh bXu;
    protected int bXw;
    protected int bXx;
    protected int bXy;
    protected int bXz;
    protected View bfZ;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bWx = 0;
    protected int bWy = 0;
    protected int bWz = 0;
    protected boolean bWY = true;
    protected String bXv = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean bXL = false;
    protected HashSet<String> bXM = new HashSet<>();
    protected final Runnable bXN = new d(this);
    protected final View.OnClickListener bXO = new e(this);
    protected final View.OnClickListener bXP = new f(this);
    protected final View.OnClickListener agS = new g(this);
    protected final View.OnClickListener bXQ = new h(this);
    protected boolean bXR = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void ZM();

    public abstract void a(ForumData forumData, n nVar);

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        bXI.put(1, "c0117");
        bXI.put(2, "c0124");
        bXI.put(3, "c0125");
        bXI.put(4, "c0126");
        bXI.put(5, "c0127");
    }

    public boolean adu() {
        return this.bXB;
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

    public boolean adv() {
        int[] iArr = new int[2];
        try {
            this.bXh.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Fo.setTag(this.bRg);
        return this.Fo;
    }

    public View adw() {
        return this.bWM;
    }

    public View adx() {
        return this.bWN;
    }

    public BarImageView adf() {
        return this.bXj;
    }

    public TextView ady() {
        return this.Fj;
    }

    public boolean add() {
        return this.bXF;
    }

    public void eo(boolean z) {
        this.bXE = z;
        if (this.bXE) {
            this.bWC.setVisibility(0);
        } else {
            this.bWC.setVisibility(4);
        }
    }

    public View adz() {
        return this.bWI;
    }

    public boolean ade() {
        return this.bXG;
    }

    public ProgressBar adA() {
        return this.bWF;
    }

    public ForumHeadVideoView adB() {
        return this.bRg;
    }

    public void onDestory() {
        this.bXC = true;
        bXJ.clear();
    }

    public void onStop() {
        if (this.bXi != null && this.bXi.isShowing()) {
            this.bXi.dismiss();
        }
        if (this.bXd != null && this.bXd.isShowing()) {
            this.bXd.dismiss();
        }
    }

    public void ep(boolean z) {
        this.bXD = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bXr = str;
        this.bXw = i2;
        if (i == 0) {
            this.bXB = false;
            this.bXL = false;
            this.bWA.setVisibility(0);
            this.bWI.setVisibility(8);
            return;
        }
        this.bXB = true;
        this.bWA.setVisibility(8);
        if (z && !this.bXL) {
            ZN();
            this.bXL = true;
        }
        d(false, f);
        this.bWI.setVisibility(0);
    }

    protected void ZN() {
    }

    public void iN(int i) {
        if (i == 0) {
            this.bXB = false;
            this.bXL = false;
            this.bWA.setVisibility(0);
            this.bWI.setVisibility(8);
            if (this.bXo != null) {
                this.bXo.hide();
                return;
            }
            return;
        }
        this.bXB = true;
        this.bWA.setVisibility(8);
        this.bWI.setVisibility(0);
    }

    public void iO(int i) {
        if (i == 0) {
            this.bXF = false;
            this.bWG.setVisibility(8);
            this.bWC.setVisibility(0);
            ZK();
            return;
        }
        this.bXF = true;
        this.bWC.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.bWG.setClickable(true);
        } else {
            this.bWG.setClickable(false);
        }
        ZJ();
    }

    protected void ZK() {
        ap.j((View) this.bWD, r.g.frs_btn_sign);
    }

    protected void ZJ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void ZO() {
        if (this.mMemberType != 0) {
            ap.c(this.bXh, r.g.icon_speed_orange);
        } else {
            ap.c(this.bXh, r.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bXA));
        if (this.bVF >= 10000) {
            if (this.bVF % 10000 == 0) {
                textView2.setText(String.valueOf(this.Fp.getString(r.l.experience_divider)) + String.valueOf(this.bVF / 10000) + this.Fp.getString(r.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Fp.getString(r.l.experience_divider)) + String.valueOf(this.bVF / 10000.0f) + this.Fp.getString(r.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Fp.getString(r.l.experience_divider)) + String.valueOf(this.bVF));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(View view) {
        this.Fp.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Fp.getLayoutMode().v(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aA(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (this.bWQ == null || qVar == null || qVar.ps() == null || qVar.ps().size() <= 0) {
            if (this.bWQ != null) {
                this.bWQ.setVisibility(8);
                return;
            }
            return;
        }
        this.Ql = qVar.pt();
        this.bWS = ap.getDrawable(r.g.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds10);
        this.bWQ.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.s> ps = qVar.ps();
        List<com.baidu.tbadk.core.data.s> subList = ps.size() > 5 ? ps.subList(0, 5) : ps;
        this.bXK = subList.size();
        if (subList.size() > 1) {
            this.bWQ.setDisableParentEvent(true);
        } else {
            this.bWQ.setDisableParentEvent(false);
        }
        this.bWQ.setData(subList);
        if (this.bWR != null) {
            if (subList.size() > 2) {
                this.bWR.setPadding(this.bWx, 0, this.bWz, 0);
            } else {
                this.bWR.setPadding(this.bWx, 0, this.bWy, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pF()) {
                    this.bWR.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bWR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bWR.setText("");
                } else {
                    this.bWR.setCompoundDrawablePadding(this.drawablePadding);
                    this.bWR.setCompoundDrawablesWithIntrinsicBounds(this.bWS, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bWR.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bHh != null) {
                    str = this.bHh.getForumId();
                    str2 = this.bHh.getForumName();
                }
                if (bXJ.add(1)) {
                    a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bXI.get(1), "ad_plat", "VIEW_TRUE", this.Ql, str, str2, null);
                    a.ch("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        if (this.bWT != null) {
            if (xVar == null) {
                this.bWT.setVisibility(8);
                return;
            }
            this.bWT.setData(xVar);
            this.bWT.setClickListener(this.bXQ);
            this.bWT.show();
            this.bWT.setVisibility(0);
            if (this.bWQ != null) {
                this.bWQ.setVisibility(8);
            }
        }
    }

    public void b(long j, List<BannerThreadInfoData> list) {
        if (this.bRg != null && this.bHh != null) {
            if (!this.bWY) {
                this.bRg.setVisibility(8);
            } else if (com.baidu.tbadk.core.util.w.s(list)) {
                this.bRg.setVisibility(8);
            } else {
                if (this.bRg.getVisibility() != 0) {
                    this.bRg.setVisibility(0);
                }
                this.bRg.a(j, list, this.bHh.Xw());
                if (this.bWQ != null) {
                    this.bWQ.setVisibility(8);
                }
                if (this.bWT != null) {
                    this.bWT.setVisibility(8);
                }
            }
        }
    }

    public void adC() {
        if (this.bWQ != null) {
            this.bWQ.setCoverFlowFactory(new k(this));
            this.bWQ.setCallback(new l(this));
        }
    }

    public void ZB() {
    }
}

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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cc;
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
    private static HashMap<Integer, String> bRe = new HashMap<>();
    private static HashSet<Integer> bRf = new HashSet<>();
    protected TextView FX;
    protected TextView FY;
    protected TextView FZ;
    protected TextView Ga;
    protected View Ge;
    protected TbPageContext<FrsActivity> Gf;
    private String Rc;
    protected com.baidu.tieba.tbadkCore.o bFO;
    protected ForumHeadVideoView bKN;
    protected FrameLayout bPV;
    protected Button bPW;
    protected FrameLayout bPX;
    protected Button bPY;
    protected TextView bPZ;
    protected int bPe;
    protected View bQA;
    protected TextView bQB;
    protected TextView bQC;
    protected ImageView bQD;
    protected PopupWindow bQE;
    protected BarImageView bQF;
    protected UserIconBox bQG;
    protected ArrayList<com.baidu.tbadk.core.data.g> bQH;
    protected com.baidu.tieba.frs.utils.b bQI;
    protected p bQJ;
    protected cc bQK;
    protected ForumMemberIconView bQL;
    protected com.baidu.tbadk.core.data.t bQM;
    protected String bQN;
    protected String bQO;
    protected String bQP;
    protected bg bQQ;
    protected int bQS;
    protected int bQT;
    protected int bQU;
    protected int bQV;
    protected int bQW;
    protected boolean bQX;
    protected boolean bQY;
    protected boolean bQZ;
    protected ProgressBar bQa;
    protected FrameLayout bQb;
    protected TextView bQc;
    protected RelativeLayout bQd;
    protected TextView bQe;
    protected ImageView bQf;
    protected ImageView bQg;
    protected View bQh;
    protected View bQi;
    protected ViewGroup bQj;
    protected TextView bQk;
    protected View bQl;
    protected CoverFlowView<com.baidu.tbadk.core.data.r> bQm;
    protected TextView bQn;
    private Drawable bQo;
    protected ForumHeadSdkView bQp;
    protected ViewGroup bQq;
    protected TextView bQr;
    protected TextView bQs;
    protected TbImageView bQt;
    protected LinearLayout bQv;
    protected LinearLayout bQw;
    protected bj bQx;
    protected bm bQy;
    protected PopupWindow bQz;
    protected boolean bRa;
    protected boolean bRb;
    protected boolean bRc;
    protected float bRd;
    private int bRg;
    protected FrsActivity bzH;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bPS = 0;
    protected int bPT = 0;
    protected int bPU = 0;
    protected boolean bQu = true;
    protected String bQR = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean bRh = false;
    protected HashSet<String> bRi = new HashSet<>();
    protected final Runnable bRj = new d(this);
    protected final View.OnClickListener bRk = new e(this);
    protected final View.OnClickListener bRl = new f(this);
    protected final View.OnClickListener ahE = new g(this);
    protected final View.OnClickListener bRm = new h(this);
    protected boolean bRn = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void YK();

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar);

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        bRe.put(1, "c0117");
        bRe.put(2, "c0124");
        bRe.put(3, "c0125");
        bRe.put(4, "c0126");
        bRe.put(5, "c0127");
    }

    public boolean acl() {
        return this.bQX;
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

    public boolean acm() {
        int[] iArr = new int[2];
        try {
            this.bQD.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Ge.setTag(this.bKN);
        return this.Ge;
    }

    public View acn() {
        return this.bQh;
    }

    public View aco() {
        return this.bQi;
    }

    public BarImageView abY() {
        return this.bQF;
    }

    public TextView acp() {
        return this.FZ;
    }

    public boolean abW() {
        return this.bRb;
    }

    public void ek(boolean z) {
        this.bRa = z;
        if (this.bRa) {
            this.bPX.setVisibility(0);
        } else {
            this.bPX.setVisibility(4);
        }
    }

    public View acq() {
        return this.bQd;
    }

    public boolean abX() {
        return this.bRc;
    }

    public ProgressBar acr() {
        return this.bQa;
    }

    public ForumHeadVideoView acs() {
        return this.bKN;
    }

    public void onDestory() {
        this.bQY = true;
        bRf.clear();
    }

    public void onStop() {
        if (this.bQE != null && this.bQE.isShowing()) {
            this.bQE.dismiss();
        }
        if (this.bQz != null && this.bQz.isShowing()) {
            this.bQz.dismiss();
        }
    }

    public void el(boolean z) {
        this.bQZ = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bQN = str;
        this.bQS = i2;
        if (i == 0) {
            this.bQX = false;
            this.bRh = false;
            this.bPV.setVisibility(0);
            this.bQd.setVisibility(8);
            return;
        }
        this.bQX = true;
        this.bPV.setVisibility(8);
        if (z && !this.bRh) {
            YL();
            this.bRh = true;
        }
        a(false, f);
        this.bQd.setVisibility(0);
    }

    protected void YL() {
    }

    public void hZ(int i) {
        if (i == 0) {
            this.bQX = false;
            this.bRh = false;
            this.bPV.setVisibility(0);
            this.bQd.setVisibility(8);
            if (this.bQK != null) {
                this.bQK.hide();
                return;
            }
            return;
        }
        this.bQX = true;
        this.bPV.setVisibility(8);
        this.bQd.setVisibility(0);
    }

    public void ia(int i) {
        if (i == 0) {
            this.bRb = false;
            this.bQb.setVisibility(8);
            this.bPX.setVisibility(0);
            YG();
            return;
        }
        this.bRb = true;
        this.bPX.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.bQb.setClickable(true);
        } else {
            this.bQb.setClickable(false);
        }
        YF();
    }

    protected void YG() {
        ar.k(this.bPY, r.f.frs_btn_sign);
    }

    protected void YF() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void YM() {
        if (this.mMemberType != 0) {
            ar.c(this.bQD, r.f.icon_speed_orange);
        } else {
            ar.c(this.bQD, r.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bQW));
        if (this.bPe >= 10000) {
            if (this.bPe % 10000 == 0) {
                textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.bPe / 10000) + this.Gf.getString(r.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.bPe / 10000.0f) + this.Gf.getString(r.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Gf.getString(r.j.experience_divider)) + String.valueOf(this.bPe));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(view);
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

    public void a(boolean z, float f) {
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (this.bQm == null || pVar == null || pVar.pz() == null || pVar.pz().size() <= 0) {
            if (this.bQm != null) {
                this.bQm.setVisibility(8);
                return;
            }
            return;
        }
        this.Rc = pVar.pA();
        this.bQo = ar.getDrawable(r.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds10);
        this.bQm.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.r> pz = pVar.pz();
        List<com.baidu.tbadk.core.data.r> subList = pz.size() > 5 ? pz.subList(0, 5) : pz;
        this.bRg = subList.size();
        if (subList.size() > 1) {
            this.bQm.setDisableParentEvent(true);
        } else {
            this.bQm.setDisableParentEvent(false);
        }
        this.bQm.setData(subList);
        if (this.bQn != null) {
            if (subList.size() > 2) {
                this.bQn.setPadding(this.bPS, 0, this.bPU, 0);
            } else {
                this.bQn.setPadding(this.bPS, 0, this.bPT, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pM()) {
                    this.bQn.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bQn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bQn.setText("");
                } else {
                    this.bQn.setCompoundDrawablePadding(this.drawablePadding);
                    this.bQn.setCompoundDrawablesWithIntrinsicBounds(this.bQo, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bQn.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bzH != null) {
                    str = this.bzH.getForumId();
                    str2 = this.bzH.getForumName();
                }
                if (bRf.add(1)) {
                    a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bRe.get(1), "ad_plat", "VIEW_TRUE", this.Rc, str, str2, null);
                    a.bY("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        if (this.bQp != null) {
            if (wVar == null) {
                this.bQp.setVisibility(8);
                return;
            }
            this.bQp.setData(wVar);
            this.bQp.setClickListener(this.bRm);
            this.bQp.show();
            this.bQp.setVisibility(0);
            if (this.bQm != null) {
                this.bQm.setVisibility(8);
            }
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.bKN != null && this.bzH != null) {
            if (!this.bQu) {
                this.bKN.setVisibility(8);
            } else if (com.baidu.tbadk.core.util.x.t(list)) {
                this.bKN.setVisibility(8);
            } else {
                if (this.bKN.getVisibility() != 0) {
                    this.bKN.setVisibility(0);
                }
                this.bKN.a(j, list, this.bzH.Wf());
                if (this.bQm != null) {
                    this.bQm.setVisibility(8);
                }
                if (this.bQp != null) {
                    this.bQp.setVisibility(8);
                }
            }
        }
    }

    public void act() {
        if (this.bQm != null) {
            this.bQm.setCoverFlowFactory(new k(this));
            this.bQm.setCallback(new l(this));
        }
    }

    public void Yx() {
    }
}

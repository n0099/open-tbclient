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
    private static HashMap<Integer, String> cfW = new HashMap<>();
    private static HashSet<Integer> cfX = new HashSet<>();
    private String VR;
    protected View aXo;
    protected TbPageContext<FrsActivity> aaY;
    protected TextView bKX;
    protected FrsActivity bQw;
    protected n bVq;
    protected int bgX;
    protected View boU;
    protected int cdP;
    protected TextView ceN;
    protected TextView ceO;
    protected FrameLayout ceP;
    protected Button ceQ;
    protected TextView ceR;
    protected FrameLayout ceS;
    protected Button ceT;
    protected TextView ceU;
    protected ProgressBar ceV;
    protected FrameLayout ceW;
    protected TextView ceX;
    protected RelativeLayout ceY;
    protected TextView ceZ;
    protected ArrayList<com.baidu.tbadk.core.data.g> cfA;
    protected com.baidu.tieba.frs.f.b cfB;
    protected p cfC;
    protected cc cfD;
    protected ForumMemberIconView cfE;
    protected com.baidu.tbadk.core.data.v cfF;
    protected String cfG;
    protected String cfH;
    protected String cfI;
    protected bi cfJ;
    protected int cfL;
    protected int cfM;
    protected int cfN;
    protected int cfO;
    protected boolean cfP;
    protected boolean cfQ;
    protected boolean cfR;
    protected boolean cfS;
    protected boolean cfT;
    protected boolean cfU;
    protected float cfV;
    private int cfY;
    protected ImageView cfa;
    protected ImageView cfb;
    protected View cfc;
    protected View cfd;
    protected ViewGroup cfe;
    protected TextView cff;
    protected CoverFlowView<com.baidu.tbadk.core.data.t> cfg;
    protected TextView cfh;
    private Drawable cfi;
    protected ForumHeadSdkView cfj;
    protected ViewGroup cfk;
    protected TextView cfl;
    protected TextView cfm;
    protected TbImageView cfn;
    protected LinearLayout cfo;
    protected LinearLayout cfp;
    protected bl cfq;
    protected bo cfr;
    protected PopupWindow cfs;
    protected View cft;
    protected TextView cfu;
    protected TextView cfv;
    protected ImageView cfw;
    protected PopupWindow cfx;
    protected BarImageView cfy;
    protected UserIconBox cfz;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int ceK = 0;
    protected int ceL = 0;
    protected int ceM = 0;
    protected String cfK = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean cfZ = false;
    protected HashSet<String> cga = new HashSet<>();
    protected final Runnable cgb = new d(this);
    protected final View.OnClickListener cgc = new e(this);
    protected final View.OnClickListener cgd = new f(this);
    protected final View.OnClickListener amB = new g(this);
    protected final View.OnClickListener cge = new h(this);

    public abstract void a(ForumData forumData, n nVar);

    public abstract void aci();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cfW.put(1, "c0117");
        cfW.put(2, "c0124");
        cfW.put(3, "c0125");
        cfW.put(4, "c0126");
        cfW.put(5, "c0127");
    }

    public boolean afq() {
        return this.cfP;
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

    public boolean afr() {
        int[] iArr = new int[2];
        try {
            this.cfw.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.aXo;
    }

    public View afs() {
        return this.cfc;
    }

    public View aft() {
        return this.cfd;
    }

    public BarImageView afb() {
        return this.cfy;
    }

    public TextView afu() {
        return this.bKX;
    }

    public boolean aeZ() {
        return this.cfT;
    }

    public void ey(boolean z) {
        this.cfS = z;
        if (this.cfS) {
            this.ceS.setVisibility(0);
        } else {
            this.ceS.setVisibility(4);
        }
    }

    public View afv() {
        return this.ceY;
    }

    public boolean afa() {
        return this.cfU;
    }

    public ProgressBar afw() {
        return this.ceV;
    }

    public void onDestory() {
        this.cfQ = true;
        cfX.clear();
    }

    public void onStop() {
        if (this.cfx != null && this.cfx.isShowing()) {
            this.cfx.dismiss();
        }
        if (this.cfs != null && this.cfs.isShowing()) {
            this.cfs.dismiss();
        }
    }

    public void ez(boolean z) {
        this.cfR = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.cfG = str;
        this.bgX = i2;
        if (i == 0) {
            this.cfP = false;
            this.cfZ = false;
            this.ceP.setVisibility(0);
            this.ceY.setVisibility(8);
            return;
        }
        this.cfP = true;
        this.ceP.setVisibility(8);
        if (z && !this.cfZ) {
            acj();
            this.cfZ = true;
        }
        c(false, f);
        this.ceY.setVisibility(0);
    }

    protected void acj() {
    }

    public void iQ(int i) {
        if (i == 0) {
            this.cfP = false;
            this.cfZ = false;
            this.ceP.setVisibility(0);
            this.ceY.setVisibility(8);
            if (this.cfD != null) {
                this.cfD.hide();
                return;
            }
            return;
        }
        this.cfP = true;
        this.ceP.setVisibility(8);
        this.ceY.setVisibility(0);
    }

    public void iR(int i) {
        if (i == 0) {
            this.cfT = false;
            this.ceW.setVisibility(8);
            this.ceS.setVisibility(0);
            acg();
            return;
        }
        this.cfT = true;
        this.ceS.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.ceW.setClickable(true);
        } else {
            this.ceW.setClickable(false);
        }
        acf();
    }

    protected void acg() {
        aq.j(this.ceT, w.g.frs_btn_sign);
    }

    protected void acf() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void ack() {
        if (this.mMemberType != 0) {
            aq.c(this.cfw, w.g.icon_speed_orange);
        } else {
            aq.c(this.cfw, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.cfO));
        if (this.cdP >= 10000) {
            if (this.cdP % 10000 == 0) {
                textView2.setText(String.valueOf(this.aaY.getString(w.l.experience_divider)) + String.valueOf(this.cdP / 10000) + this.aaY.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aaY.getString(w.l.experience_divider)) + String.valueOf(this.cdP / 10000.0f) + this.aaY.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aaY.getString(w.l.experience_divider)) + String.valueOf(this.cdP));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(View view) {
        this.aaY.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaY.getLayoutMode().t(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ax(List<com.baidu.tieba.tbadkCore.g> list) {
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
        if (this.cfg == null || rVar == null || rVar.qi() == null || rVar.qi().size() <= 0) {
            if (this.cfg != null) {
                this.cfg.setVisibility(8);
                return;
            }
            return;
        }
        this.VR = rVar.qj();
        this.cfi = aq.getDrawable(w.g.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds10);
        this.cfg.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.t> qi = rVar.qi();
        List<com.baidu.tbadk.core.data.t> subList = qi.size() > 5 ? qi.subList(0, 5) : qi;
        this.cfY = subList.size();
        if (subList.size() > 1) {
            this.cfg.setDisableParentEvent(true);
        } else {
            this.cfg.setDisableParentEvent(false);
        }
        this.cfg.setData(subList);
        if (this.cfh != null) {
            if (subList.size() > 2) {
                this.cfh.setPadding(this.ceK, 0, this.ceM, 0);
            } else {
                this.cfh.setPadding(this.ceK, 0, this.ceL, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).qv()) {
                    this.cfh.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.cfh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cfh.setText("");
                } else {
                    this.cfh.setCompoundDrawablePadding(this.drawablePadding);
                    this.cfh.setCompoundDrawablesWithIntrinsicBounds(this.cfi, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cfh.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bQw != null) {
                    str = this.bQw.getForumId();
                    str2 = this.bQw.getForumName();
                }
                if (cfX.add(1)) {
                    a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", cfW.get(1), "ad_plat", "VIEW_TRUE", this.VR, str, str2, null);
                    a.cb("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        if (this.cfj != null) {
            if (yVar == null) {
                this.cfj.setVisibility(8);
                return;
            }
            this.cfj.setData(yVar);
            this.cfj.setClickListener(this.cge);
            this.cfj.show();
            this.cfj.setVisibility(0);
            if (this.cfg != null) {
                this.cfg.setVisibility(8);
            }
        }
    }

    public void afx() {
        if (this.cfg != null) {
            this.cfg.setCoverFlowFactory(new k(this));
            this.cfg.setCallback(new l(this));
        }
    }

    public void abX() {
    }
}

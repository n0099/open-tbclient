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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c {
    private static HashMap<Integer, String> bTH = new HashMap<>();
    private static HashSet<Integer> bTI = new HashSet<>();
    protected TextView Dh;
    protected TextView Di;
    protected TextView Dj;
    protected TextView Dk;
    protected View Do;
    protected TbPageContext<FrsActivity> Dp;
    private String NQ;
    protected FrsActivity bET;
    protected com.baidu.tieba.tbadkCore.p bJX;
    protected ForumHeadVideoView bOM;
    protected FrameLayout bSD;
    protected Button bSE;
    protected FrameLayout bSF;
    protected Button bSG;
    protected TextView bSH;
    protected ProgressBar bSI;
    protected FrameLayout bSJ;
    protected TextView bSK;
    protected RelativeLayout bSL;
    protected TextView bSM;
    protected ImageView bSN;
    protected ImageView bSO;
    protected View bSP;
    protected ViewGroup bSQ;
    protected TextView bSR;
    protected TextView bSS;
    private Drawable bST;
    protected ForumHeadSdkView bSU;
    protected ViewGroup bSV;
    protected TextView bSW;
    protected TextView bSX;
    protected TbImageView bSY;
    protected LinearLayout bSZ;
    protected int bSf;
    protected boolean bTA;
    protected boolean bTB;
    protected boolean bTC;
    protected boolean bTD;
    protected boolean bTE;
    protected boolean bTF;
    protected float bTG;
    private int bTJ;
    protected bb bTa;
    protected be bTb;
    protected PopupWindow bTc;
    protected View bTd;
    protected TextView bTe;
    protected TextView bTf;
    protected ImageView bTg;
    protected PopupWindow bTh;
    protected BarImageView bTi;
    protected UserIconBox bTj;
    protected ArrayList<com.baidu.tbadk.core.data.f> bTk;
    protected com.baidu.tieba.frs.bb bTl;
    protected o bTm;
    protected dj bTn;
    protected ForumMemberIconView bTo;
    protected com.baidu.tbadk.core.data.q bTp;
    protected String bTq;
    protected String bTr;
    protected String bTs;
    protected az bTt;
    protected int bTv;
    protected int bTw;
    protected int bTx;
    protected int bTy;
    protected int bTz;
    protected CoverFlowView<com.baidu.tbadk.core.data.p> bmX;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bSA = 0;
    protected int bSB = 0;
    protected int bSC = 0;
    protected String bTu = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected HashSet<String> bTK = new HashSet<>();
    protected final Runnable bTL = new d(this);
    protected final View.OnClickListener bTM = new e(this);
    protected final View.OnClickListener ael = new f(this);
    protected final View.OnClickListener bTN = new g(this);
    protected boolean bTO = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void XN();

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar);

    public abstract void changeSkinType(int i);

    public abstract void f(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        bTH.put(1, "c0117");
        bTH.put(2, "c0124");
        bTH.put(3, "c0125");
        bTH.put(4, "c0126");
        bTH.put(5, "c0127");
    }

    public boolean aas() {
        return this.bTA;
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

    public boolean aat() {
        int[] iArr = new int[2];
        try {
            this.bTg.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.Do.setTag(this.bOM);
        return this.Do;
    }

    public View aau() {
        return this.bSP;
    }

    public BarImageView aan() {
        return this.bTi;
    }

    public TextView aav() {
        return this.Dj;
    }

    public boolean aal() {
        return this.bTE;
    }

    public void dO(boolean z) {
        this.bTD = z;
        if (this.bTD) {
            this.bSF.setVisibility(0);
        } else {
            this.bSF.setVisibility(4);
        }
    }

    public View aaw() {
        return this.bSL;
    }

    public boolean aam() {
        return this.bTF;
    }

    public ProgressBar aax() {
        return this.bSI;
    }

    public ForumHeadVideoView aay() {
        return this.bOM;
    }

    public void onDestory() {
        this.bTB = true;
        bTI.clear();
    }

    public void onStop() {
        if (this.bTh != null && this.bTh.isShowing()) {
            this.bTh.dismiss();
        }
        if (this.bTc != null && this.bTc.isShowing()) {
            this.bTc.dismiss();
        }
    }

    public void dP(boolean z) {
        this.bTC = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bTq = str;
        this.bTv = i2;
        if (i == 0) {
            this.bTA = false;
            this.bSD.setVisibility(0);
            this.bSL.setVisibility(8);
            return;
        }
        this.bTA = true;
        this.bSD.setVisibility(8);
        if (z) {
            XO();
        }
        a(false, f);
        this.bSL.setVisibility(0);
    }

    protected void XO() {
    }

    public void ia(int i) {
        if (i == 0) {
            this.bTA = false;
            this.bSD.setVisibility(0);
            this.bSL.setVisibility(8);
            if (this.bTn != null) {
                this.bTn.hide();
                return;
            }
            return;
        }
        this.bTA = true;
        this.bSD.setVisibility(8);
        this.bSL.setVisibility(0);
    }

    public void ib(int i) {
        if (i == 0) {
            this.bTE = false;
            this.bSJ.setVisibility(8);
            this.bSF.setVisibility(0);
            XH();
            return;
        }
        this.bTE = true;
        this.bSF.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.bSJ.setClickable(true);
        } else {
            this.bSJ.setClickable(false);
        }
        XG();
    }

    protected void XH() {
        av.k(this.bSG, u.f.frs_btn_sign);
    }

    protected void XG() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void XP() {
        if (this.mMemberType != 0) {
            av.c(this.bTg, u.f.icon_speed_orange);
        } else {
            av.c(this.bTg, u.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bTz));
        if (this.bSf >= 10000) {
            if (this.bSf % 10000 == 0) {
                textView2.setText(String.valueOf(this.Dp.getString(u.j.experience_divider)) + String.valueOf(this.bSf / 10000) + this.Dp.getString(u.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.Dp.getString(u.j.experience_divider)) + String.valueOf(this.bSf / 10000.0f) + this.Dp.getString(u.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.Dp.getString(u.j.experience_divider)) + String.valueOf(this.bSf));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.Dp.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Dp.getLayoutMode().w(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aw(List<com.baidu.tieba.tbadkCore.h> list) {
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

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (this.bmX == null || oVar == null || oVar.oK() == null || oVar.oK().size() <= 0) {
            if (this.bmX != null) {
                this.bmX.setVisibility(8);
                return;
            }
            return;
        }
        this.NQ = oVar.oL();
        this.bST = av.getDrawable(u.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds10);
        this.bmX.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.p> oK = oVar.oK();
        List<com.baidu.tbadk.core.data.p> subList = oK.size() > 5 ? oK.subList(0, 5) : oK;
        this.bTJ = subList.size();
        if (subList.size() > 1) {
            this.bmX.setDisableParentEvent(true);
        } else {
            this.bmX.setDisableParentEvent(false);
        }
        this.bmX.setData(subList);
        if (this.bSS != null) {
            if (subList.size() > 2) {
                this.bSS.setPadding(this.bSA, 0, this.bSC, 0);
            } else {
                this.bSS.setPadding(this.bSA, 0, this.bSB, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).oN()) {
                    this.bSS.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bSS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bSS.setText("");
                } else {
                    this.bSS.setCompoundDrawablePadding(this.drawablePadding);
                    this.bSS.setCompoundDrawablesWithIntrinsicBounds(this.bST, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bSS.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bET != null) {
                    str = this.bET.getForumId();
                    str2 = this.bET.getForumName();
                }
                if (bTI.add(1)) {
                    a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bTH.get(1), "ad_plat", "VIEW_TRUE", this.NQ, str, str2, null);
                    a.bM("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar == null) {
            this.bSU.setVisibility(8);
            return;
        }
        this.bSU.setData(sVar);
        this.bSU.setClickListener(this.bTN);
        this.bSU.show();
        this.bSU.setVisibility(0);
        if (this.bmX != null) {
            this.bmX.setVisibility(8);
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.bOM != null && this.bET != null) {
            if (com.baidu.tbadk.core.util.y.t(list)) {
                this.bOM.setVisibility(8);
                return;
            }
            this.bOM.setVisibility(0);
            this.bOM.a(j, list, this.bET.Vk());
            if (this.bmX != null) {
                this.bmX.setVisibility(8);
            }
            if (this.bSU != null) {
                this.bSU.setVisibility(8);
            }
        }
    }

    public void PV() {
        if (this.bmX != null) {
            this.bmX.setCoverFlowFactory(new j(this));
            this.bmX.setCallback(new k(this));
        }
    }

    public void Xy() {
    }
}

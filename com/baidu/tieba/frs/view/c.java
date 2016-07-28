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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bb;
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
    private static HashMap<Integer, String> bVH = new HashMap<>();
    private static HashSet<Integer> bVI = new HashSet<>();
    protected TextView DI;
    protected TextView DJ;
    protected TextView DK;
    protected TextView DL;
    protected View DP;
    protected TbPageContext<FrsActivity> DQ;
    private String NX;
    protected FrsActivity bGh;
    protected com.baidu.tieba.tbadkCore.p bLD;
    protected ForumHeadVideoView bQy;
    protected FrameLayout bUD;
    protected Button bUE;
    protected FrameLayout bUF;
    protected Button bUG;
    protected TextView bUH;
    protected ProgressBar bUI;
    protected FrameLayout bUJ;
    protected TextView bUK;
    protected RelativeLayout bUL;
    protected TextView bUM;
    protected ImageView bUN;
    protected ImageView bUO;
    protected View bUP;
    protected ViewGroup bUQ;
    protected TextView bUR;
    protected TextView bUS;
    private Drawable bUT;
    protected ForumHeadSdkView bUU;
    protected ViewGroup bUV;
    protected TextView bUW;
    protected TextView bUX;
    protected TbImageView bUY;
    protected LinearLayout bUZ;
    protected int bUf;
    protected boolean bVA;
    protected boolean bVB;
    protected boolean bVC;
    protected boolean bVD;
    protected boolean bVE;
    protected boolean bVF;
    protected float bVG;
    private int bVJ;
    protected bg bVa;
    protected bj bVb;
    protected PopupWindow bVc;
    protected View bVd;
    protected TextView bVe;
    protected TextView bVf;
    protected ImageView bVg;
    protected PopupWindow bVh;
    protected BarImageView bVi;
    protected UserIconBox bVj;
    protected ArrayList<com.baidu.tbadk.core.data.f> bVk;
    protected bb bVl;
    protected o bVm;
    protected dj bVn;
    protected ForumMemberIconView bVo;
    protected com.baidu.tbadk.core.data.r bVp;
    protected String bVq;
    protected String bVr;
    protected String bVs;
    protected be bVt;
    protected int bVv;
    protected int bVw;
    protected int bVx;
    protected int bVy;
    protected int bVz;
    protected CoverFlowView<com.baidu.tbadk.core.data.q> boF;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int bUA = 0;
    protected int bUB = 0;
    protected int bUC = 0;
    protected String bVu = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected HashSet<String> bVK = new HashSet<>();
    protected final Runnable bVL = new d(this);
    protected final View.OnClickListener bVM = new e(this);
    protected final View.OnClickListener aeZ = new f(this);
    protected final View.OnClickListener bVN = new g(this);
    protected boolean bVO = TbadkCoreApplication.m10getInst().appResponseToIntentClass(GameDetailActivityConfig.class);

    public abstract void Yg();

    public abstract void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar);

    public abstract void changeSkinType(int i);

    public abstract void d(View view, boolean z);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        bVH.put(1, "c0117");
        bVH.put(2, "c0124");
        bVH.put(3, "c0125");
        bVH.put(4, "c0126");
        bVH.put(5, "c0127");
    }

    public boolean aaU() {
        return this.bVA;
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

    public boolean aaV() {
        int[] iArr = new int[2];
        try {
            this.bVg.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.DP.setTag(this.bQy);
        return this.DP;
    }

    public View aaW() {
        return this.bUP;
    }

    public BarImageView aaP() {
        return this.bVi;
    }

    public TextView aaX() {
        return this.DK;
    }

    public boolean aaN() {
        return this.bVE;
    }

    public void dO(boolean z) {
        this.bVD = z;
        if (this.bVD) {
            this.bUF.setVisibility(0);
        } else {
            this.bUF.setVisibility(4);
        }
    }

    public View aaY() {
        return this.bUL;
    }

    public boolean aaO() {
        return this.bVF;
    }

    public ProgressBar aaZ() {
        return this.bUI;
    }

    public ForumHeadVideoView aba() {
        return this.bQy;
    }

    public void onDestory() {
        this.bVB = true;
        bVI.clear();
    }

    public void onStop() {
        if (this.bVh != null && this.bVh.isShowing()) {
            this.bVh.dismiss();
        }
        if (this.bVc != null && this.bVc.isShowing()) {
            this.bVc.dismiss();
        }
    }

    public void dP(boolean z) {
        this.bVC = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.bVq = str;
        this.bVv = i2;
        if (i == 0) {
            this.bVA = false;
            this.bUD.setVisibility(0);
            this.bUL.setVisibility(8);
            return;
        }
        this.bVA = true;
        this.bUD.setVisibility(8);
        if (z) {
            Yh();
        }
        a(false, f);
        this.bUL.setVisibility(0);
    }

    protected void Yh() {
    }

    public void ib(int i) {
        if (i == 0) {
            this.bVA = false;
            this.bUD.setVisibility(0);
            this.bUL.setVisibility(8);
            if (this.bVn != null) {
                this.bVn.hide();
                return;
            }
            return;
        }
        this.bVA = true;
        this.bUD.setVisibility(8);
        this.bUL.setVisibility(0);
    }

    public void ic(int i) {
        if (i == 0) {
            this.bVE = false;
            this.bUJ.setVisibility(8);
            this.bUF.setVisibility(0);
            Ya();
            return;
        }
        this.bVE = true;
        this.bUF.setVisibility(8);
        if (TbadkCoreApplication.m10getInst().getUseNewResign() == 1) {
            this.bUJ.setClickable(true);
        } else {
            this.bUJ.setClickable(false);
        }
        XZ();
    }

    protected void Ya() {
        av.k(this.bUG, u.f.frs_btn_sign);
    }

    protected void XZ() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void Yi() {
        if (this.mMemberType != 0) {
            av.c(this.bVg, u.f.icon_speed_orange);
        } else {
            av.c(this.bVg, u.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.bVz));
        if (this.bUf >= 10000) {
            if (this.bUf % 10000 == 0) {
                textView2.setText(String.valueOf(this.DQ.getString(u.j.experience_divider)) + String.valueOf(this.bUf / 10000) + this.DQ.getString(u.j.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.DQ.getString(u.j.experience_divider)) + String.valueOf(this.bUf / 10000.0f) + this.DQ.getString(u.j.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.DQ.getString(u.j.experience_divider)) + String.valueOf(this.bUf));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        this.DQ.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.DQ.getLayoutMode().w(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aA(List<com.baidu.tieba.tbadkCore.h> list) {
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
        if (this.boF == null || pVar == null || pVar.oz() == null || pVar.oz().size() <= 0) {
            if (this.boF != null) {
                this.boF.setVisibility(8);
                return;
            }
            return;
        }
        this.NX = pVar.oA();
        this.bUT = av.getDrawable(u.f.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds10);
        this.boF.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.q> oz = pVar.oz();
        List<com.baidu.tbadk.core.data.q> subList = oz.size() > 5 ? oz.subList(0, 5) : oz;
        this.bVJ = subList.size();
        if (subList.size() > 1) {
            this.boF.setDisableParentEvent(true);
        } else {
            this.boF.setDisableParentEvent(false);
        }
        this.boF.setData(subList);
        if (this.bUS != null) {
            if (subList.size() > 2) {
                this.bUS.setPadding(this.bUA, 0, this.bUC, 0);
            } else {
                this.bUS.setPadding(this.bUA, 0, this.bUB, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).oC()) {
                    this.bUS.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.bUS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bUS.setText("");
                } else {
                    this.bUS.setCompoundDrawablePadding(this.drawablePadding);
                    this.bUS.setCompoundDrawablesWithIntrinsicBounds(this.bUT, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.bUS.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bGh != null) {
                    str = this.bGh.getForumId();
                    str2 = this.bGh.getForumName();
                }
                if (bVI.add(1)) {
                    a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", bVH.get(1), "ad_plat", "VIEW_TRUE", this.NX, str, str2, null);
                    a.bR("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar == null) {
            this.bUU.setVisibility(8);
            return;
        }
        this.bUU.setData(tVar);
        this.bUU.setClickListener(this.bVN);
        this.bUU.show();
        this.bUU.setVisibility(0);
        if (this.boF != null) {
            this.boF.setVisibility(8);
        }
    }

    public void c(long j, List<BannerThreadInfoData> list) {
        if (this.bQy != null && this.bGh != null) {
            if (com.baidu.tbadk.core.util.y.t(list)) {
                this.bQy.setVisibility(8);
                return;
            }
            this.bQy.setVisibility(0);
            this.bQy.a(j, list, this.bGh.VA());
            if (this.boF != null) {
                this.boF.setVisibility(8);
            }
            if (this.bUU != null) {
                this.bUU.setVisibility(8);
            }
        }
    }

    public void Qz() {
        if (this.boF != null) {
            this.boF.setCoverFlowFactory(new j(this));
            this.boF.setCallback(new k(this));
        }
    }

    public void XQ() {
    }
}

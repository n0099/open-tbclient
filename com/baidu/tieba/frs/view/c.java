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
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
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
    private static HashMap<Integer, String> cff = new HashMap<>();
    private static HashSet<Integer> cfg = new HashSet<>();
    private String Vy;
    protected View aWX;
    protected TbPageContext<FrsActivity> aaI;
    protected TextView bIN;
    protected FrsActivity bOq;
    protected n bTl;
    protected ForumHeadVideoView bYo;
    protected int bfq;
    protected View bmL;
    protected int ccX;
    protected TextView cdV;
    protected TextView cdW;
    protected FrameLayout cdX;
    protected Button cdY;
    protected TextView cdZ;
    protected bp ceA;
    protected PopupWindow ceB;
    protected View ceC;
    protected TextView ceD;
    protected TextView ceE;
    protected ImageView ceF;
    protected PopupWindow ceG;
    protected BarImageView ceH;
    protected UserIconBox ceI;
    protected ArrayList<com.baidu.tbadk.core.data.g> ceJ;
    protected com.baidu.tieba.frs.utils.b ceK;
    protected p ceL;
    protected ca ceM;
    protected ForumMemberIconView ceN;
    protected com.baidu.tbadk.core.data.v ceO;
    protected String ceP;
    protected String ceQ;
    protected String ceR;
    protected bj ceS;
    protected int ceU;
    protected int ceV;
    protected int ceW;
    protected int ceX;
    protected boolean ceY;
    protected boolean ceZ;
    protected FrameLayout cea;
    protected Button ceb;
    protected TextView cec;
    protected ProgressBar ced;
    protected FrameLayout cee;
    protected TextView cef;
    protected RelativeLayout ceg;
    protected TextView ceh;
    protected ImageView cei;
    protected ImageView cej;
    protected View cek;
    protected View cel;
    protected ViewGroup cem;
    protected TextView cen;
    protected CoverFlowView<com.baidu.tbadk.core.data.t> ceo;
    protected TextView cep;
    private Drawable ceq;
    protected ForumHeadSdkView cer;
    protected ViewGroup ces;
    protected TextView cet;
    protected TextView ceu;
    protected TbImageView cev;
    protected LinearLayout cex;
    protected LinearLayout cey;
    protected bm cez;
    protected boolean cfa;
    protected boolean cfb;
    protected boolean cfc;
    protected boolean cfd;
    protected float cfe;
    private int cfh;
    private int drawablePadding;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected int mMemberNum;
    protected int mMemberType;
    protected int cdS = 0;
    protected int cdT = 0;
    protected int cdU = 0;
    protected boolean cew = true;
    protected String ceT = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private boolean cfi = false;
    protected HashSet<String> cfj = new HashSet<>();
    protected final Runnable cfk = new d(this);
    protected final View.OnClickListener cfl = new e(this);
    protected final View.OnClickListener cfm = new f(this);
    protected final View.OnClickListener amn = new g(this);
    protected final View.OnClickListener cfn = new h(this);

    public abstract void a(ForumData forumData, n nVar);

    public abstract void aaJ();

    public abstract void c(View view, boolean z);

    public abstract void changeSkinType(int i);

    public abstract void setCommonClickListener(View.OnClickListener onClickListener);

    static {
        cff.put(1, "c0117");
        cff.put(2, "c0124");
        cff.put(3, "c0125");
        cff.put(4, "c0126");
        cff.put(5, "c0127");
    }

    public boolean aeu() {
        return this.ceY;
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

    public boolean aev() {
        int[] iArr = new int[2];
        try {
            this.ceF.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        this.aWX.setTag(this.bYo);
        return this.aWX;
    }

    public View aew() {
        return this.cek;
    }

    public View aex() {
        return this.cel;
    }

    public BarImageView aef() {
        return this.ceH;
    }

    public TextView aey() {
        return this.bIN;
    }

    public boolean aed() {
        return this.cfc;
    }

    public void eo(boolean z) {
        this.cfb = z;
        if (this.cfb) {
            this.cea.setVisibility(0);
        } else {
            this.cea.setVisibility(4);
        }
    }

    public View aez() {
        return this.ceg;
    }

    public boolean aee() {
        return this.cfd;
    }

    public ProgressBar aeA() {
        return this.ced;
    }

    public ForumHeadVideoView aeB() {
        return this.bYo;
    }

    public void onDestory() {
        this.ceZ = true;
        cfg.clear();
    }

    public void onStop() {
        if (this.ceG != null && this.ceG.isShowing()) {
            this.ceG.dismiss();
        }
        if (this.ceB != null && this.ceB.isShowing()) {
            this.ceB.dismiss();
        }
    }

    public void ep(boolean z) {
        this.cfa = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.ceP = str;
        this.bfq = i2;
        if (i == 0) {
            this.ceY = false;
            this.cfi = false;
            this.cdX.setVisibility(0);
            this.ceg.setVisibility(8);
            return;
        }
        this.ceY = true;
        this.cdX.setVisibility(8);
        if (z && !this.cfi) {
            aaK();
            this.cfi = true;
        }
        c(false, f);
        this.ceg.setVisibility(0);
    }

    protected void aaK() {
    }

    public void iJ(int i) {
        if (i == 0) {
            this.ceY = false;
            this.cfi = false;
            this.cdX.setVisibility(0);
            this.ceg.setVisibility(8);
            if (this.ceM != null) {
                this.ceM.hide();
                return;
            }
            return;
        }
        this.ceY = true;
        this.cdX.setVisibility(8);
        this.ceg.setVisibility(0);
    }

    public void iK(int i) {
        if (i == 0) {
            this.cfc = false;
            this.cee.setVisibility(8);
            this.cea.setVisibility(0);
            aaH();
            return;
        }
        this.cfc = true;
        this.cea.setVisibility(8);
        if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
            this.cee.setClickable(true);
        } else {
            this.cee.setClickable(false);
        }
        aaG();
    }

    protected void aaH() {
        aq.j(this.ceb, w.g.frs_btn_sign);
    }

    protected void aaG() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void aaL() {
        if (this.mMemberType != 0) {
            aq.c(this.ceF, w.g.icon_speed_orange);
        } else {
            aq.c(this.ceF, w.g.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ceX));
        if (this.ccX >= 10000) {
            if (this.ccX % 10000 == 0) {
                textView2.setText(String.valueOf(this.aaI.getString(w.l.experience_divider)) + String.valueOf(this.ccX / 10000) + this.aaI.getString(w.l.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aaI.getString(w.l.experience_divider)) + String.valueOf(this.ccX / 10000.0f) + this.aaI.getString(w.l.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aaI.getString(w.l.experience_divider)) + String.valueOf(this.ccX));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(View view) {
        this.aaI.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaI.getLayoutMode().t(view);
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
        if (this.ceo == null || rVar == null || rVar.pK() == null || rVar.pK().size() <= 0) {
            if (this.ceo != null) {
                this.ceo.setVisibility(8);
                return;
            }
            return;
        }
        this.Vy = rVar.pL();
        this.ceq = aq.getDrawable(w.g.icon_frs_notice);
        this.drawablePadding = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds10);
        this.ceo.setVisibility(0);
        ArrayList<com.baidu.tbadk.core.data.t> pK = rVar.pK();
        List<com.baidu.tbadk.core.data.t> subList = pK.size() > 5 ? pK.subList(0, 5) : pK;
        this.cfh = subList.size();
        if (subList.size() > 1) {
            this.ceo.setDisableParentEvent(true);
        } else {
            this.ceo.setDisableParentEvent(false);
        }
        this.ceo.setData(subList);
        if (this.cep != null) {
            if (subList.size() > 2) {
                this.cep.setPadding(this.cdS, 0, this.cdU, 0);
            } else {
                this.cep.setPadding(this.cdS, 0, this.cdT, 0);
            }
            if (subList.size() == 1 && subList.get(0) != null && subList.get(0).getTitle() != null) {
                if (subList.get(0).pX()) {
                    this.cep.setVisibility(8);
                    return;
                }
                if (StringUtils.isNull(subList.get(0).getTitle().trim(), true)) {
                    this.cep.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cep.setText("");
                } else {
                    this.cep.setCompoundDrawablePadding(this.drawablePadding);
                    this.cep.setCompoundDrawablesWithIntrinsicBounds(this.ceq, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.cep.setText(subList.get(0).getTitle().trim());
                }
                String str = "";
                String str2 = "";
                if (this.bOq != null) {
                    str = this.bOq.getForumId();
                    str2 = this.bOq.getForumName();
                }
                if (cfg.add(1)) {
                    a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", cff.get(1), "ad_plat", "VIEW_TRUE", this.Vy, str, str2, null);
                    a.cb("obj_url", subList.get(0).getLinkUrl());
                    a.save();
                }
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        if (this.cer != null) {
            if (yVar == null) {
                this.cer.setVisibility(8);
                return;
            }
            this.cer.setData(yVar);
            this.cer.setClickListener(this.cfn);
            this.cer.show();
            this.cer.setVisibility(0);
            if (this.ceo != null) {
                this.ceo.setVisibility(8);
            }
        }
    }

    public void b(long j, List<BannerThreadInfoData> list) {
        if (this.bYo != null && this.bOq != null) {
            if (!this.cew) {
                this.bYo.setVisibility(8);
            } else if (com.baidu.tbadk.core.util.x.q(list)) {
                this.bYo.setVisibility(8);
            } else {
                if (this.bYo.getVisibility() != 0) {
                    this.bYo.setVisibility(0);
                }
                this.bYo.a(j, list, this.bOq.Yv());
                if (this.ceo != null) {
                    this.ceo.setVisibility(8);
                }
                if (this.cer != null) {
                    this.cer.setVisibility(8);
                }
            }
        }
    }

    public void aeC() {
        if (this.ceo != null) {
            this.ceo.setCoverFlowFactory(new k(this));
            this.ceo.setCallback(new l(this));
        }
    }

    public void aay() {
    }
}

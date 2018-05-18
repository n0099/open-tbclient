package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class b {
    private static HashMap<Integer, String> duC = new HashMap<>();
    private static HashSet<Integer> duD = new HashSet<>();
    public TextView cXy;
    protected FrsFragment cZJ;
    protected View ccV;
    protected l drT;
    protected int drp;
    protected TextView dtL;
    protected TextView dtM;
    protected TextView dtN;
    protected TextView dtO;
    protected TextView dtP;
    protected ImageView dtQ;
    protected View dtR;
    protected ViewGroup dtS;
    protected TextView dtT;
    protected View dtU;
    protected AdapterLinearLayout dtV;
    protected ViewGroup dtW;
    protected TextView dtX;
    protected TextView dtY;
    protected TbImageView dtZ;
    protected boolean duA;
    protected float duB;
    protected RelativeLayout duH;
    protected RelativeLayout duI;
    protected View duJ;
    protected TextView duK;
    protected RelativeLayout duL;
    protected TextView duM;
    protected LinearLayout dua;
    protected bf dub;
    protected bi duc;
    protected View dud;
    protected TextView due;
    protected TextView duf;
    protected ImageView dug;
    protected PopupWindow duh;
    protected BarImageView dui;
    protected UserIconBox duj;
    protected ArrayList<h> duk;
    protected com.baidu.tieba.frs.f.b dul;
    protected e dum;
    protected ae dun;
    protected String duo;
    protected String dup;
    protected String duq;
    protected bd dur;
    protected int dus;
    protected int dut;
    protected int duu;
    protected int duv;
    protected boolean duw;
    protected boolean dux;
    protected boolean duy;
    protected boolean duz;
    protected TbPageContext mContext;
    protected String mForumId;
    protected String mForumName;
    protected Handler mHandler;
    protected boolean mIsDestroy;
    protected int mLevel;
    protected int mMemberNum;
    protected int mMemberType;
    protected View mParent;
    protected PopupWindow mPopup;
    protected TextView mTitleText;
    protected int dtI = 0;
    protected int dtJ = 0;
    protected int dtK = 0;
    private boolean duE = false;
    protected HashSet<String> duF = new HashSet<>();
    protected final Runnable duG = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener duN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || az.aK(b.this.mContext.getPageActivity())) && view2 != null && (view2.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view2.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    return;
                }
                ax.wf().c(b.this.mContext, new String[]{url});
                a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bpS(), b.this.cZJ.getForumId(), b.this.cZJ.getForumName(), null);
                b.cd("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void arD();

    public abstract void changeSkinType(int i);

    public abstract void j(View view2, boolean z);

    public abstract void n(View.OnClickListener onClickListener);

    static {
        duC.put(1, "c0117");
        duC.put(2, "c0124");
        duC.put(3, "c0125");
        duC.put(4, "c0126");
        duC.put(5, "c0127");
    }

    public boolean avI() {
        return this.duw;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view2, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view2, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
                scaleAnimation2.setFillAfter(true);
                scaleAnimation2.setDuration(300L);
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view2, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, f2, 1.0f, 1.0f);
                        scaleAnimation3.setFillAfter(true);
                        scaleAnimation3.setDuration(300L);
                        view2.startAnimation(scaleAnimation3);
                    }
                });
            }
        });
    }

    public boolean avJ() {
        int[] iArr = new int[2];
        try {
            this.dug.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View avK() {
        return this.dtR;
    }

    public View ars() {
        return this.dtV;
    }

    public BarImageView avL() {
        return this.dui;
    }

    public TextView avM() {
        return this.mTitleText;
    }

    public TextView avN() {
        return this.cXy;
    }

    public boolean avl() {
        return this.duz;
    }

    public void gf(boolean z) {
        this.duy = z;
        if (this.duy) {
            this.dtO.setVisibility(0);
        } else {
            this.dtO.setVisibility(4);
        }
    }

    public boolean avm() {
        return this.duA;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        duD.clear();
    }

    public void onStop() {
        avO();
    }

    public void fW(boolean z) {
        if (!z) {
            avO();
        }
    }

    private void avO() {
        if (this.duh != null && this.duh.isShowing()) {
            this.duh.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gg(boolean z) {
        this.dux = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.duo = str;
        this.mLevel = i2;
        if (i == 0) {
            this.duw = false;
            this.duE = false;
            this.duH.setVisibility(0);
            this.duI.setVisibility(8);
            return;
        }
        this.duw = true;
        this.duH.setVisibility(8);
        this.duI.setVisibility(0);
        if (z && !this.duE) {
            arE();
            this.duE = true;
        }
        c(false, f);
    }

    protected void arE() {
    }

    public void lC(int i) {
        if (i == 0) {
            this.duw = false;
            this.duE = false;
            this.duH.setVisibility(0);
            this.duI.setVisibility(8);
            return;
        }
        this.duw = true;
        this.duH.setVisibility(8);
        this.duI.setVisibility(0);
    }

    public void lD(int i) {
        if (i == 0) {
            this.duz = false;
            this.dtO.setText(d.k.sign);
            arz();
            return;
        }
        this.duz = true;
        this.dtO.setText(d.k.signed);
        ary();
    }

    protected void arz() {
    }

    protected void ary() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void arF() {
        if (this.mMemberType != 0) {
            ak.c(this.dug, d.f.icon_speed_orange);
        } else {
            ak.c(this.dug, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.duv));
        if (this.drp >= 10000) {
            if (this.drp % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.drp / 10000) + this.mContext.getString(d.k.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.drp / 10000.0f) + this.mContext.getString(d.k.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.drp));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void arp() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.duL != null) {
            this.duL.setPadding(i, i2, i3, i4);
        }
    }
}

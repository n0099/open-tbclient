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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private static HashMap<Integer, String> dDP = new HashMap<>();
    private static HashSet<Integer> dDQ = new HashSet<>();
    protected View ckY;
    protected int dAC;
    protected l dBg;
    protected TextView dCY;
    protected TextView dCZ;
    protected ae dDA;
    protected String dDB;
    protected String dDC;
    protected String dDD;
    protected bd dDE;
    protected int dDF;
    protected int dDG;
    protected int dDH;
    protected int dDI;
    protected boolean dDJ;
    protected boolean dDK;
    protected boolean dDL;
    protected boolean dDM;
    protected boolean dDN;
    protected float dDO;
    protected RelativeLayout dDU;
    protected RelativeLayout dDV;
    protected View dDW;
    protected TextView dDX;
    protected RelativeLayout dDY;
    protected TextView dDZ;
    protected TextView dDa;
    protected TextView dDb;
    protected TextView dDc;
    protected ImageView dDd;
    protected View dDe;
    protected ViewGroup dDf;
    protected TextView dDg;
    protected View dDh;
    protected AdapterLinearLayout dDi;
    protected ViewGroup dDj;
    protected TextView dDk;
    protected TextView dDl;
    protected TbImageView dDm;
    protected LinearLayout dDn;
    protected bf dDo;
    protected bi dDp;
    protected View dDq;
    protected TextView dDr;
    protected TextView dDs;
    protected ImageView dDt;
    protected PopupWindow dDu;
    protected BarImageView dDv;
    protected UserIconBox dDw;
    protected ArrayList<h> dDx;
    protected com.baidu.tieba.frs.f.b dDy;
    protected e dDz;
    public TextView dgL;
    protected FrsFragment diZ;
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
    protected int dCV = 0;
    protected int dCW = 0;
    protected int dCX = 0;
    private boolean dDR = false;
    protected HashSet<String> dDS = new HashSet<>();
    protected final Runnable dDT = new Runnable() { // from class: com.baidu.tieba.frs.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mPopup != null && b.this.mPopup.isShowing() && !b.this.mIsDestroy) {
                g.a(b.this.mPopup, b.this.mContext.getPageActivity());
            }
        }
    };
    protected final View.OnClickListener dEa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((b.this.mContext == null || ba.aU(b.this.mContext.getPageActivity())) && view != null && (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
                String url = gVar.getUrl();
                if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    com.baidu.adp.lib.util.l.showToast(b.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    return;
                }
                ay.zG().c(b.this.mContext, new String[]{url});
                a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.buT(), b.this.diZ.getForumId(), b.this.diZ.getForumName(), null);
                b.cl("obj_url", gVar.getUrl());
                b.save();
            }
        }
    };

    public abstract void a(ForumData forumData, l lVar);

    public abstract void avI();

    public abstract void changeSkinType(int i);

    public abstract void j(View view, boolean z);

    public abstract void n(View.OnClickListener onClickListener);

    static {
        dDP.put(1, "c0117");
        dDP.put(2, "c0124");
        dDP.put(3, "c0125");
        dDP.put(4, "c0126");
        dDP.put(5, "c0127");
    }

    public boolean azR() {
        return this.dDJ;
    }

    public void a(TbPageContextSupport<?> tbPageContextSupport, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, null);
    }

    public void b(final TbPageContextSupport<?> tbPageContextSupport, final View view, float f, final float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3
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
                com.baidu.tieba.tbadkCore.a.a(tbPageContextSupport, view, scaleAnimation2, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.b.3.1
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
                        view.startAnimation(scaleAnimation3);
                    }
                });
            }
        });
    }

    public boolean azS() {
        int[] iArr = new int[2];
        try {
            this.dDt.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public View getView() {
        return this.mParent;
    }

    public View azT() {
        return this.dDe;
    }

    public View avx() {
        return this.dDi;
    }

    public BarImageView azU() {
        return this.dDv;
    }

    public TextView azV() {
        return this.mTitleText;
    }

    public TextView azW() {
        return this.dgL;
    }

    public boolean azu() {
        return this.dDM;
    }

    public void gk(boolean z) {
        this.dDL = z;
        if (this.dDL) {
            this.dDb.setVisibility(0);
        } else {
            this.dDb.setVisibility(4);
        }
    }

    public boolean azv() {
        return this.dDN;
    }

    public void onDestory() {
        this.mIsDestroy = true;
        dDQ.clear();
    }

    public void onStop() {
        azX();
    }

    public void fw(boolean z) {
        if (!z) {
            azX();
        }
    }

    private void azX() {
        if (this.dDu != null && this.dDu.isShowing()) {
            this.dDu.dismiss();
        }
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void gl(boolean z) {
        this.dDK = z;
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.dDB = str;
        this.mLevel = i2;
        if (i == 0) {
            this.dDJ = false;
            this.dDR = false;
            this.dDU.setVisibility(0);
            this.dDV.setVisibility(8);
            return;
        }
        this.dDJ = true;
        this.dDU.setVisibility(8);
        this.dDV.setVisibility(0);
        if (z && !this.dDR) {
            avJ();
            this.dDR = true;
        }
        d(false, f);
    }

    protected void avJ() {
    }

    public void lJ(int i) {
        if (i == 0) {
            this.dDJ = false;
            this.dDR = false;
            this.dDU.setVisibility(0);
            this.dDV.setVisibility(8);
            return;
        }
        this.dDJ = true;
        this.dDU.setVisibility(8);
        this.dDV.setVisibility(0);
    }

    public void lK(int i) {
        if (i == 0) {
            this.dDM = false;
            this.dDb.setText(d.k.sign);
            avE();
            return;
        }
        this.dDM = true;
        this.dDb.setText(d.k.signed);
        avD();
    }

    protected void avE() {
    }

    protected void avD() {
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void avK() {
        if (this.mMemberType != 0) {
            al.c(this.dDt, d.f.icon_speed_orange);
        } else {
            al.c(this.dDt, d.f.icon_speed_gray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.dDI));
        if (this.dAC >= 10000) {
            if (this.dAC % 10000 == 0) {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dAC / 10000) + this.mContext.getString(d.k.member_count_unit));
                return;
            } else {
                textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dAC / 10000.0f) + this.mContext.getString(d.k.member_count_unit));
                return;
            }
        }
        textView2.setText(this.mContext.getString(d.k.experience_divider) + String.valueOf(this.dAC));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bz(List<com.baidu.tieba.tbadkCore.g> list) {
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

    public void avu() {
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dDY != null) {
            this.dDY.setPadding(i, i2, i3, i4);
        }
    }
}

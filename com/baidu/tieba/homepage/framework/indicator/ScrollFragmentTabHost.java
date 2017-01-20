package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.homepage.framework.indicator.r;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager XW;
    private final com.baidu.tbadk.widget.layout.i aFI;
    private BdUniqueId aUC;
    private View bAe;
    private NoNetworkView.a bpA;
    private NoNetworkView bsR;
    private PluginErrorTipView bxt;
    private o cuH;
    private a cuI;
    private List<TagInfo> cuJ;
    private FrameLayout cuK;
    private r cuL;
    public boolean cuM;
    private com.baidu.tieba.homepage.framework.b.e cuN;
    private CustomMessageListener cuO;
    private View.OnClickListener cuP;
    private r.a cuQ;
    private y cuR;
    private com.baidu.tieba.homepage.framework.y cuS;
    private com.baidu.tieba.homepage.framework.x cuT;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cuK;
    }

    public boolean ajD() {
        return this.cuL != null && this.cuL.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cuM = true;
        this.bAe = null;
        this.cuO = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cuP = new i(this);
        this.bpA = new j(this);
        this.cuQ = new k(this);
        this.aFI = new l(this);
        this.cuR = new y();
        this.cuS = new m(this);
        this.cuT = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuM = true;
        this.bAe = null;
        this.cuO = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cuP = new i(this);
        this.bpA = new j(this);
        this.cuQ = new k(this);
        this.aFI = new l(this);
        this.cuR = new y();
        this.cuS = new m(this);
        this.cuT = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cuK = (FrameLayout) findViewById(r.h.tab_widget_content_container);
        this.bsR = (NoNetworkView) findViewById(r.h.view_no_network);
        this.bsR.a(this.bpA);
        this.cuH = new o(context, findViewById(r.h.tab_container));
        this.cuH.q(this.cuP);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(r.h.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aFI);
        this.bAe = findViewById(r.h.statebar_view);
        this.cuN = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bAe);
        this.bxt = (PluginErrorTipView) observedChangeLinearLayout.findViewById(r.h.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cuN != null) {
            this.cuN.switchNaviBarStatus(z);
        }
    }

    public void vZ() {
        if (this.cuL == null) {
            this.cuL = new r(this.cuK);
            this.cuL.a(this.cuQ);
        }
        this.cuL.kf(this.topHeight);
        if (!this.cuL.isShowing()) {
            this.cuL.a(this.mContext, this.cuJ, this.XW.getCurrentItem());
            if (this.cuH != null) {
                this.cuH.ajL();
            }
        }
    }

    public void ajE() {
        if (this.cuL != null) {
            this.cuL.aW(this.mContext);
        }
    }

    public boolean ajF() {
        return com.baidu.tbadk.core.util.w.r(this.cuJ) <= 0;
    }

    public void bq(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.ajO().bt(list);
            this.cuJ = list;
            if (this.cuI != null) {
                this.cuI.aD(arrayList);
                if (this.cuH != null) {
                    this.cuH.setViewPager(this.XW);
                }
                this.cuR.a(this.cuS);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cuI != null) {
            this.cuI.c(j, dataRes, z);
        }
    }

    public void ajv() {
        if (this.cuI != null) {
            this.cuI.ajv();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cuI != null) {
            this.cuI.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.XW != null) {
            this.cuI.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.XW = (CustomViewPager) findViewById(r.h.tab_widget_view_pager);
        this.cuI = new a(this.mContext, bVar, cVar, this.aUC);
        this.cuI.setScrollFragmentTabHost(this);
        this.XW.setAdapter(this.cuI);
        if (this.cuN != null) {
            this.cuI.setRecommendFrsNavigationAnimDispatcher(this.cuN);
        }
    }

    public boolean ajG() {
        return this.cuI != null && this.cuI.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cuI.getCount()) {
            this.XW.setCurrentItem(i, false);
        }
    }

    public int bk(long j) {
        if (this.cuI == null) {
            return -1;
        }
        return this.cuI.bj(j);
    }

    public int getCurrentItem() {
        return this.XW.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cuH != null) {
            this.cuH.onChangeSkinType(i);
        }
        if (this.cuI != null) {
            this.cuI.dp(i);
        }
        if (this.cuL != null) {
            this.cuL.dp(i);
        }
        com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(getContext());
        if (this.bsR != null) {
            this.bsR.onChangeSkinType(C, i);
        }
        if (this.cuN != null) {
            this.cuN.onChangeSkinType(i);
        }
        if (this.bxt != null) {
            this.bxt.onChangeSkinType(C, i);
        }
        UtilHelper.setStatusBarBackground(this.bAe, i);
    }

    public void setItemForeGround(int i) {
        this.cuI.setItemForeGround(i);
        if (this.bsR != null) {
            if (com.baidu.adp.lib.util.i.fX()) {
                this.bsR.setVisibility(8);
            } else {
                this.bsR.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cuN != null) {
            this.cuN.onDestroy();
        }
        this.cuI.onDestroy();
        if (this.bAe != null) {
            this.bAe.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aUC = bdUniqueId;
        this.cuO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cuO);
        if (this.cuN != null) {
            this.cuN.setPageUniqueId(bdUniqueId);
        }
    }

    public void ajH() {
        if (this.cuI != null) {
            this.cuI.eX(false);
        }
    }

    public int bl(long j) {
        if (this.cuJ == null || this.cuJ.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cuJ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bm(long j) {
        if (this.cuJ == null || this.cuJ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cuJ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bn(long j) {
        if (this.cuJ == null || this.cuJ.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cuJ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.cuJ == null || this.cuJ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cuJ) {
            if (tagInfo != null) {
                String qt = com.baidu.tieba.tbadkCore.t.qt(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && qt.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eW(boolean z) {
        this.cuI.eW(z);
    }

    public void ajB() {
        this.cuI.ajB();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cuI != null) {
            return this.cuI.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cuI != null) {
            return this.cuI.getCurrentPageKey();
        }
        return null;
    }

    public boolean br(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.w.s(list) || com.baidu.tbadk.core.util.w.s(this.cuJ) || com.baidu.tbadk.core.util.w.r(list) != com.baidu.tbadk.core.util.w.r(this.cuJ)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.w.r(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.w.c(this.cuJ, i);
            TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.w.c(list, i);
            if (tagInfo != null && tagInfo2 != null) {
                if (tagInfo.tag_code == null || tagInfo2.tag_code == null) {
                    return true;
                }
                if (tagInfo.tag_code.longValue() != tagInfo2.tag_code.longValue() || tagInfo.lego_page_id.longValue() != tagInfo2.lego_page_id.longValue() || !TextUtils.equals(tagInfo.lego_qs, tagInfo2.lego_qs)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void onPause() {
        if (this.cuI != null) {
            this.cuI.completePullRefresh();
            this.cuI.onPause();
        }
    }

    public void onResume() {
        if (this.cuI != null) {
            this.cuI.onResume();
        }
    }

    public void ajI() {
        this.cuI.a(this.cuT);
    }

    public void ajJ() {
        this.cuR.b(this.cuS);
    }
}

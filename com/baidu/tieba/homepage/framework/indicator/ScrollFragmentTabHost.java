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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.homepage.framework.indicator.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final com.baidu.tbadk.widget.layout.h aLv;
    private CustomViewPager adz;
    private PluginErrorTipView bEs;
    private View bHd;
    private BdUniqueId baI;
    private NoNetworkView.a bwo;
    private NoNetworkView bzT;
    private o cuG;
    private a cuH;
    private List<TagInfo> cuI;
    private FrameLayout cuJ;
    private r cuK;
    public boolean cuL;
    private com.baidu.tieba.homepage.framework.b.e cuM;
    private CustomMessageListener cuN;
    private View.OnClickListener cuO;
    private r.a cuP;
    private y cuQ;
    private com.baidu.tieba.homepage.framework.y cuR;
    private com.baidu.tieba.homepage.framework.x cuS;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cuJ;
    }

    public boolean aiK() {
        return this.cuK != null && this.cuK.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cuL = true;
        this.bHd = null;
        this.cuN = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cuO = new i(this);
        this.bwo = new j(this);
        this.cuP = new k(this);
        this.aLv = new l(this);
        this.cuQ = new y();
        this.cuR = new m(this);
        this.cuS = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuL = true;
        this.bHd = null;
        this.cuN = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cuO = new i(this);
        this.bwo = new j(this);
        this.cuP = new k(this);
        this.aLv = new l(this);
        this.cuQ = new y();
        this.cuR = new m(this);
        this.cuS = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cuJ = (FrameLayout) findViewById(w.h.tab_widget_content_container);
        this.bzT = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bzT.a(this.bwo);
        this.cuG = new o(context, findViewById(w.h.tab_container));
        this.cuG.o(this.cuO);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(w.h.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aLv);
        this.bHd = findViewById(w.h.statebar_view);
        this.cuM = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bHd);
        this.bEs = (PluginErrorTipView) observedChangeLinearLayout.findViewById(w.h.view_plugin_error_tip);
        aq.j(this.cuJ, w.e.cp_bg_line_d);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cuM != null) {
            this.cuM.switchNaviBarStatus(z);
        }
    }

    public void wR() {
        if (this.cuK == null) {
            this.cuK = new r(this.cuJ);
            this.cuK.a(this.cuP);
        }
        this.cuK.jL(this.topHeight);
        if (!this.cuK.isShowing()) {
            this.cuK.a(this.mContext, this.cuI, this.adz.getCurrentItem());
            if (this.cuG != null) {
                this.cuG.aiR();
            }
        }
    }

    public void wS() {
        if (this.cuK != null) {
            this.cuK.bo(this.mContext);
        }
    }

    public boolean aiL() {
        return com.baidu.tbadk.core.util.x.p(this.cuI) <= 0;
    }

    public void aW(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.aiU().aZ(list);
            this.cuI = list;
            if (this.cuH != null) {
                this.cuH.aV(arrayList);
                if (this.cuG != null) {
                    this.cuG.setViewPager(this.adz);
                }
                this.cuQ.a(this.cuR);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cuH != null) {
            this.cuH.c(j, dataRes, z);
        }
    }

    public void aiC() {
        if (this.cuH != null) {
            this.cuH.aiC();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cuH != null) {
            this.cuH.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.adz != null) {
            this.cuH.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.adz = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.cuH = new a(this.mContext, bVar, cVar, this.baI);
        this.cuH.setScrollFragmentTabHost(this);
        this.adz.setAdapter(this.cuH);
        if (this.cuM != null) {
            this.cuH.setRecommendFrsNavigationAnimDispatcher(this.cuM);
        }
    }

    public boolean aiM() {
        return this.cuH != null && this.cuH.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cuH.getCount()) {
            this.adz.setCurrentItem(i, false);
        }
    }

    public int bk(long j) {
        if (this.cuH == null) {
            return -1;
        }
        return this.cuH.bj(j);
    }

    public int getCurrentItem() {
        return this.adz.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cuG != null) {
            this.cuG.onChangeSkinType(i);
        }
        if (this.cuH != null) {
            this.cuH.m19do(i);
        }
        if (this.cuK != null) {
            this.cuK.m20do(i);
        }
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (this.bzT != null) {
            this.bzT.onChangeSkinType(Z, i);
        }
        if (this.cuM != null) {
            this.cuM.onChangeSkinType(i);
        }
        if (this.bEs != null) {
            this.bEs.onChangeSkinType(Z, i);
        }
        UtilHelper.setStatusBarBackground(this.bHd, i);
    }

    public void setItemForeGround(int i) {
        this.cuH.setItemForeGround(i);
        if (this.bzT != null) {
            if (com.baidu.adp.lib.util.i.gX()) {
                this.bzT.setVisibility(8);
            } else {
                this.bzT.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cuM != null) {
            this.cuM.onDestroy();
        }
        this.cuH.onDestroy();
        if (this.bHd != null) {
            this.bHd.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.baI = bdUniqueId;
        this.cuN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cuN);
        if (this.cuM != null) {
            this.cuM.setPageUniqueId(bdUniqueId);
        }
    }

    public void aiN() {
        if (this.cuH != null) {
            this.cuH.eO(false);
        }
    }

    public int bl(long j) {
        if (this.cuI == null || this.cuI.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cuI) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bm(long j) {
        if (this.cuI == null || this.cuI.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cuI) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bn(long j) {
        if (this.cuI == null || this.cuI.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cuI) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.cuI == null || this.cuI.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cuI) {
            if (tagInfo != null) {
                String pT = com.baidu.tieba.tbadkCore.t.pT(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && pT.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eN(boolean z) {
        this.cuH.eN(z);
    }

    public void aiI() {
        this.cuH.aiI();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cuH != null) {
            return this.cuH.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cuH != null) {
            return this.cuH.getCurrentPageKey();
        }
        return null;
    }

    public boolean aX(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.q(list) || com.baidu.tbadk.core.util.x.q(this.cuI) || com.baidu.tbadk.core.util.x.p(list) != com.baidu.tbadk.core.util.x.p(this.cuI)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.x.p(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cuI, i);
            TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.x.c(list, i);
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
        if (this.cuH != null) {
            this.cuH.completePullRefresh();
            this.cuH.onPause();
        }
    }

    public void onResume() {
        if (this.cuH != null) {
            this.cuH.onResume();
        }
    }

    public void aiO() {
        this.cuH.a(this.cuS);
    }

    public void aiP() {
        this.cuQ.b(this.cuR);
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        if (this.cuM != null) {
            this.cuM.setPageContext(tbPageContext);
        }
    }
}

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
    private final com.baidu.tbadk.widget.layout.i aLf;
    private CustomViewPager adl;
    private NoNetworkView bAa;
    private PluginErrorTipView bEz;
    private View bHk;
    private BdUniqueId baP;
    private NoNetworkView.a bwv;
    private o cwg;
    private a cwh;
    private List<TagInfo> cwi;
    private FrameLayout cwj;
    private r cwk;
    public boolean cwl;
    private com.baidu.tieba.homepage.framework.b.e cwm;
    private CustomMessageListener cwn;
    private View.OnClickListener cwo;
    private r.a cwp;
    private y cwq;
    private com.baidu.tieba.homepage.framework.y cwr;
    private com.baidu.tieba.homepage.framework.x cws;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cwj;
    }

    public boolean aiQ() {
        return this.cwk != null && this.cwk.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cwl = true;
        this.bHk = null;
        this.cwn = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cwo = new i(this);
        this.bwv = new j(this);
        this.cwp = new k(this);
        this.aLf = new l(this);
        this.cwq = new y();
        this.cwr = new m(this);
        this.cws = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwl = true;
        this.bHk = null;
        this.cwn = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cwo = new i(this);
        this.bwv = new j(this);
        this.cwp = new k(this);
        this.aLf = new l(this);
        this.cwq = new y();
        this.cwr = new m(this);
        this.cws = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cwj = (FrameLayout) findViewById(w.h.tab_widget_content_container);
        this.bAa = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bAa.a(this.bwv);
        this.cwg = new o(context, findViewById(w.h.tab_container));
        this.cwg.o(this.cwo);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(w.h.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aLf);
        this.bHk = findViewById(w.h.statebar_view);
        this.cwm = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bHk);
        this.bEz = (PluginErrorTipView) observedChangeLinearLayout.findViewById(w.h.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cwm != null) {
            this.cwm.switchNaviBarStatus(z);
        }
    }

    public void wv() {
        if (this.cwk == null) {
            this.cwk = new r(this.cwj);
            this.cwk.a(this.cwp);
        }
        this.cwk.jK(this.topHeight);
        if (!this.cwk.isShowing()) {
            this.cwk.a(this.mContext, this.cwi, this.adl.getCurrentItem());
            if (this.cwg != null) {
                this.cwg.aiX();
            }
        }
    }

    public void ww() {
        if (this.cwk != null) {
            this.cwk.bv(this.mContext);
        }
    }

    public boolean aiR() {
        return com.baidu.tbadk.core.util.x.p(this.cwi) <= 0;
    }

    public void aX(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.aja().ba(list);
            this.cwi = list;
            if (this.cwh != null) {
                this.cwh.aW(arrayList);
                if (this.cwg != null) {
                    this.cwg.setViewPager(this.adl);
                }
                this.cwq.a(this.cwr);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cwh != null) {
            this.cwh.c(j, dataRes, z);
        }
    }

    public void aiI() {
        if (this.cwh != null) {
            this.cwh.aiI();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cwh != null) {
            this.cwh.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.adl != null) {
            this.cwh.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.adl = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.cwh = new a(this.mContext, bVar, cVar, this.baP);
        this.cwh.setScrollFragmentTabHost(this);
        this.adl.setAdapter(this.cwh);
        if (this.cwm != null) {
            this.cwh.setRecommendFrsNavigationAnimDispatcher(this.cwm);
        }
    }

    public boolean aiS() {
        return this.cwh != null && this.cwh.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cwh.getCount()) {
            this.adl.setCurrentItem(i, false);
        }
    }

    public int bk(long j) {
        if (this.cwh == null) {
            return -1;
        }
        return this.cwh.bj(j);
    }

    public int getCurrentItem() {
        return this.adl.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cwg != null) {
            this.cwg.onChangeSkinType(i);
        }
        if (this.cwh != null) {
            this.cwh.dl(i);
        }
        if (this.cwk != null) {
            this.cwk.dl(i);
        }
        com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(getContext());
        if (this.bAa != null) {
            this.bAa.onChangeSkinType(aa, i);
        }
        if (this.cwm != null) {
            this.cwm.onChangeSkinType(i);
        }
        if (this.bEz != null) {
            this.bEz.onChangeSkinType(aa, i);
        }
        UtilHelper.setStatusBarBackground(this.bHk, i);
    }

    public void setItemForeGround(int i) {
        this.cwh.setItemForeGround(i);
        if (this.bAa != null) {
            if (com.baidu.adp.lib.util.i.gS()) {
                this.bAa.setVisibility(8);
            } else {
                this.bAa.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cwm != null) {
            this.cwm.onDestroy();
        }
        this.cwh.onDestroy();
        if (this.bHk != null) {
            this.bHk.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.baP = bdUniqueId;
        this.cwn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cwn);
        if (this.cwm != null) {
            this.cwm.setPageUniqueId(bdUniqueId);
        }
    }

    public void aiT() {
        if (this.cwh != null) {
            this.cwh.eO(false);
        }
    }

    public int bl(long j) {
        if (this.cwi == null || this.cwi.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cwi) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bm(long j) {
        if (this.cwi == null || this.cwi.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cwi) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bn(long j) {
        if (this.cwi == null || this.cwi.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cwi) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.cwi == null || this.cwi.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cwi) {
            if (tagInfo != null) {
                String pC = com.baidu.tieba.tbadkCore.t.pC(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && pC.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eN(boolean z) {
        this.cwh.eN(z);
    }

    public void aiO() {
        this.cwh.aiO();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cwh != null) {
            return this.cwh.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cwh != null) {
            return this.cwh.getCurrentPageKey();
        }
        return null;
    }

    public boolean aY(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.q(list) || com.baidu.tbadk.core.util.x.q(this.cwi) || com.baidu.tbadk.core.util.x.p(list) != com.baidu.tbadk.core.util.x.p(this.cwi)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.x.p(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cwi, i);
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
        if (this.cwh != null) {
            this.cwh.completePullRefresh();
            this.cwh.onPause();
        }
    }

    public void onResume() {
        if (this.cwh != null) {
            this.cwh.onResume();
        }
    }

    public void aiU() {
        this.cwh.a(this.cws);
    }

    public void aiV() {
        this.cwq.b(this.cwr);
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        if (this.cwm != null) {
            this.cwm.setPageContext(tbPageContext);
        }
    }
}

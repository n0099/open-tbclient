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
    private final com.baidu.tbadk.widget.layout.h aLx;
    private CustomViewPager adA;
    private NoNetworkView bCk;
    private PluginErrorTipView bGJ;
    private View bJu;
    private BdUniqueId bbE;
    private NoNetworkView.a byF;
    private o cwX;
    private a cwY;
    private List<TagInfo> cwZ;
    private FrameLayout cxa;
    private r cxb;
    public boolean cxc;
    private com.baidu.tieba.homepage.framework.b.e cxd;
    private CustomMessageListener cxe;
    private View.OnClickListener cxf;
    private r.a cxg;
    private y cxh;
    private com.baidu.tieba.homepage.framework.y cxi;
    private com.baidu.tieba.homepage.framework.x cxj;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cxa;
    }

    public boolean ajL() {
        return this.cxb != null && this.cxb.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cxc = true;
        this.bJu = null;
        this.cxe = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cxf = new i(this);
        this.byF = new j(this);
        this.cxg = new k(this);
        this.aLx = new l(this);
        this.cxh = new y();
        this.cxi = new m(this);
        this.cxj = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxc = true;
        this.bJu = null;
        this.cxe = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cxf = new i(this);
        this.byF = new j(this);
        this.cxg = new k(this);
        this.aLx = new l(this);
        this.cxh = new y();
        this.cxi = new m(this);
        this.cxj = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cxa = (FrameLayout) findViewById(w.h.tab_widget_content_container);
        this.bCk = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bCk.a(this.byF);
        this.cwX = new o(context, findViewById(w.h.tab_container));
        this.cwX.o(this.cxf);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(w.h.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aLx);
        this.bJu = findViewById(w.h.statebar_view);
        this.cxd = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bJu);
        this.bGJ = (PluginErrorTipView) observedChangeLinearLayout.findViewById(w.h.view_plugin_error_tip);
        aq.j(this.cxa, w.e.cp_bg_line_d);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cxd != null) {
            this.cxd.switchNaviBarStatus(z);
        }
    }

    public void wR() {
        if (this.cxb == null) {
            this.cxb = new r(this.cxa);
            this.cxb.a(this.cxg);
        }
        this.cxb.jR(this.topHeight);
        if (!this.cxb.isShowing()) {
            this.cxb.a(this.mContext, this.cwZ, this.adA.getCurrentItem());
            if (this.cwX != null) {
                this.cwX.ajS();
            }
        }
    }

    public void wS() {
        if (this.cxb != null) {
            this.cxb.bo(this.mContext);
        }
    }

    public boolean ajM() {
        return com.baidu.tbadk.core.util.x.p(this.cwZ) <= 0;
    }

    public void aX(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.ajV().ba(list);
            this.cwZ = list;
            if (this.cwY != null) {
                this.cwY.aW(arrayList);
                if (this.cwX != null) {
                    this.cwX.setViewPager(this.adA);
                }
                this.cxh.a(this.cxi);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cwY != null) {
            this.cwY.c(j, dataRes, z);
        }
    }

    public void ajD() {
        if (this.cwY != null) {
            this.cwY.ajD();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cwY != null) {
            this.cwY.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.adA != null) {
            this.cwY.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.adA = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.cwY = new a(this.mContext, bVar, cVar, this.bbE);
        this.cwY.setScrollFragmentTabHost(this);
        this.adA.setAdapter(this.cwY);
        if (this.cxd != null) {
            this.cwY.setRecommendFrsNavigationAnimDispatcher(this.cxd);
        }
    }

    public boolean ajN() {
        return this.cwY != null && this.cwY.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cwY.getCount()) {
            this.adA.setCurrentItem(i, false);
        }
    }

    public int bk(long j) {
        if (this.cwY == null) {
            return -1;
        }
        return this.cwY.bj(j);
    }

    public int getCurrentItem() {
        return this.adA.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cwX != null) {
            this.cwX.onChangeSkinType(i);
        }
        if (this.cwY != null) {
            this.cwY.m20do(i);
        }
        if (this.cxb != null) {
            this.cxb.m21do(i);
        }
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (this.bCk != null) {
            this.bCk.onChangeSkinType(Z, i);
        }
        if (this.cxd != null) {
            this.cxd.onChangeSkinType(i);
        }
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(Z, i);
        }
        UtilHelper.setStatusBarBackground(this.bJu, i);
    }

    public void setItemForeGround(int i) {
        this.cwY.setItemForeGround(i);
        if (this.bCk != null) {
            if (com.baidu.adp.lib.util.i.gY()) {
                this.bCk.setVisibility(8);
            } else {
                this.bCk.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cxd != null) {
            this.cxd.onDestroy();
        }
        this.cwY.onDestroy();
        if (this.bJu != null) {
            this.bJu.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bbE = bdUniqueId;
        this.cxe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cxe);
        if (this.cxd != null) {
            this.cxd.setPageUniqueId(bdUniqueId);
        }
    }

    public void ajO() {
        if (this.cwY != null) {
            this.cwY.eY(false);
        }
    }

    public int bl(long j) {
        if (this.cwZ == null || this.cwZ.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cwZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bm(long j) {
        if (this.cwZ == null || this.cwZ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cwZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bn(long j) {
        if (this.cwZ == null || this.cwZ.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cwZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.cwZ == null || this.cwZ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cwZ) {
            if (tagInfo != null) {
                String pU = com.baidu.tieba.tbadkCore.t.pU(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && pU.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eX(boolean z) {
        this.cwY.eX(z);
    }

    public void ajJ() {
        this.cwY.ajJ();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cwY != null) {
            return this.cwY.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cwY != null) {
            return this.cwY.getCurrentPageKey();
        }
        return null;
    }

    public boolean aY(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.q(list) || com.baidu.tbadk.core.util.x.q(this.cwZ) || com.baidu.tbadk.core.util.x.p(list) != com.baidu.tbadk.core.util.x.p(this.cwZ)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.x.p(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cwZ, i);
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
        if (this.cwY != null) {
            this.cwY.completePullRefresh();
            this.cwY.onPause();
        }
    }

    public void onResume() {
        if (this.cwY != null) {
            this.cwY.onResume();
        }
    }

    public void ajP() {
        this.cwY.a(this.cxj);
    }

    public void ajQ() {
        this.cxh.b(this.cxi);
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        if (this.cxd != null) {
            this.cxd.setPageContext(tbPageContext);
        }
    }
}

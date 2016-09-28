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
    private CustomViewPager YQ;
    private final com.baidu.tbadk.widget.layout.i aGJ;
    private BdUniqueId aYW;
    private PluginErrorTipView bGJ;
    private View bJw;
    private NoNetworkView.a bKL;
    private NoNetworkView bdz;
    private o cCX;
    private a cCY;
    private List<TagInfo> cCZ;
    private FrameLayout cDa;
    private r cDb;
    public boolean cDc;
    private com.baidu.tieba.homepage.framework.b.e cDd;
    private CustomMessageListener cDe;
    private View.OnClickListener cDf;
    private r.a cDg;
    private y cDh;
    private com.baidu.tieba.homepage.framework.y cDi;
    private com.baidu.tieba.homepage.framework.x cDj;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cDa;
    }

    public boolean ama() {
        return this.cDb != null && this.cDb.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cDc = true;
        this.bJw = null;
        this.cDe = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cDf = new i(this);
        this.bKL = new j(this);
        this.cDg = new k(this);
        this.aGJ = new l(this);
        this.cDh = new y();
        this.cDi = new m(this);
        this.cDj = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDc = true;
        this.bJw = null;
        this.cDe = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cDf = new i(this);
        this.bKL = new j(this);
        this.cDg = new k(this);
        this.aGJ = new l(this);
        this.cDh = new y();
        this.cDi = new m(this);
        this.cDj = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cDa = (FrameLayout) findViewById(r.g.tab_widget_content_container);
        this.bdz = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bdz.a(this.bKL);
        this.cCX = new o(context, findViewById(r.g.tab_container));
        this.cCX.n(this.cDf);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(r.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aGJ);
        this.bJw = findViewById(r.g.statebar_view);
        this.cDd = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bJw);
        this.bGJ = (PluginErrorTipView) observedChangeLinearLayout.findViewById(r.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cDd != null) {
            this.cDd.switchNaviBarStatus(z);
        }
    }

    public void wq() {
        if (this.cDb == null) {
            this.cDb = new r(this.cDa);
            this.cDb.a(this.cDg);
        }
        this.cDb.ka(this.topHeight);
        if (!this.cDb.isShowing()) {
            this.cDb.a(this.mContext, this.cCZ, this.YQ.getCurrentItem());
            if (this.cCX != null) {
                this.cCX.ami();
            }
        }
    }

    public void amb() {
        if (this.cDb != null) {
            this.cDb.aI(this.mContext);
        }
    }

    public boolean amc() {
        return com.baidu.tbadk.core.util.y.s(this.cCZ) <= 0;
    }

    public void bq(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.aml().bt(list);
            this.cCZ = list;
            if (this.cCY != null) {
                this.cCY.aF(arrayList);
                if (this.cCX != null) {
                    this.cCX.setViewPager(this.YQ);
                }
                this.cDh.a(this.cDi);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cCY != null) {
            this.cCY.c(j, dataRes, z);
        }
    }

    public void alT() {
        if (this.cCY != null) {
            this.cCY.alT();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cCY != null) {
            this.cCY.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.YQ != null) {
            this.cCY.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.YQ = (CustomViewPager) findViewById(r.g.tab_widget_view_pager);
        this.cCY = new a(this.mContext, bVar, cVar, this.aYW);
        this.cCY.setScrollFragmentTabHost(this);
        this.YQ.setAdapter(this.cCY);
        if (this.cDd != null) {
            this.cCY.setRecommendFrsNavigationAnimDispatcher(this.cDd);
        }
    }

    public boolean amd() {
        return this.cCY != null && this.cCY.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cCY.getCount()) {
            this.YQ.setCurrentItem(i, false);
        }
    }

    public int bC(long j) {
        if (this.cCY == null) {
            return -1;
        }
        return this.cCY.bB(j);
    }

    public int getCurrentItem() {
        return this.YQ.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cCX != null) {
            this.cCX.onChangeSkinType(i);
        }
        if (this.cCY != null) {
            this.cCY.dl(i);
        }
        if (this.cDb != null) {
            this.cDb.dl(i);
        }
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (this.bdz != null) {
            this.bdz.onChangeSkinType(C, i);
        }
        if (this.cDd != null) {
            this.cDd.onChangeSkinType(i);
        }
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(C, i);
        }
        UtilHelper.setStatusBarBackground(this.bJw, i);
    }

    public void setItemForeGround(int i) {
        this.cCY.setItemForeGround(i);
        if (this.bdz != null) {
            if (com.baidu.adp.lib.util.i.fZ()) {
                this.bdz.setVisibility(8);
            } else {
                this.bdz.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cDd != null) {
            this.cDd.onDestroy();
        }
        this.cCY.onDestroy();
        if (this.bJw != null) {
            this.bJw.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYW = bdUniqueId;
        this.cDe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cDe);
        if (this.cDd != null) {
            this.cDd.setPageUniqueId(bdUniqueId);
        }
    }

    public void ame() {
        if (this.cCY != null) {
            this.cCY.eT(false);
        }
    }

    public int bD(long j) {
        if (this.cCZ == null || this.cCZ.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cCZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bE(long j) {
        if (this.cCZ == null || this.cCZ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cCZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bF(long j) {
        if (this.cCZ == null || this.cCZ.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cCZ) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long i(long j, String str) {
        if (this.cCZ == null || this.cCZ.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cCZ) {
            if (tagInfo != null) {
                String rb = com.baidu.tieba.tbadkCore.v.rb(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && rb.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eS(boolean z) {
        this.cCY.eS(z);
    }

    public void alY() {
        this.cCY.alY();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cCY != null) {
            return this.cCY.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cCY != null) {
            return this.cCY.getCurrentPageKey();
        }
        return null;
    }

    public boolean br(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.t(list) || com.baidu.tbadk.core.util.y.t(this.cCZ) || com.baidu.tbadk.core.util.y.s(list) != com.baidu.tbadk.core.util.y.s(this.cCZ)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(this.cCZ, i);
            TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(list, i);
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
        if (this.cCY != null) {
            this.cCY.ku();
            this.cCY.onPause();
        }
    }

    public void onResume() {
        if (this.cCY != null) {
            this.cCY.onResume();
        }
    }

    public void amf() {
        this.cCY.a(this.cDj);
    }

    public void amg() {
        this.cDh.b(this.cDi);
    }
}

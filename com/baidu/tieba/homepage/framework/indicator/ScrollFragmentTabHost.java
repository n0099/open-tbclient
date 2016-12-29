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
    private CustomViewPager YI;
    private final com.baidu.tbadk.widget.layout.i aGT;
    private BdUniqueId bbl;
    private NoNetworkView bfO;
    private PluginErrorTipView bpH;
    private View bst;
    private NoNetworkView.a btK;
    private o cnF;
    private a cnG;
    private List<TagInfo> cnH;
    private FrameLayout cnI;
    private r cnJ;
    public boolean cnK;
    private com.baidu.tieba.homepage.framework.b.e cnL;
    private CustomMessageListener cnM;
    private View.OnClickListener cnN;
    private r.a cnO;
    private y cnP;
    private com.baidu.tieba.homepage.framework.y cnQ;
    private com.baidu.tieba.homepage.framework.x cnR;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cnI;
    }

    public boolean aiv() {
        return this.cnJ != null && this.cnJ.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cnK = true;
        this.bst = null;
        this.cnM = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cnN = new i(this);
        this.btK = new j(this);
        this.cnO = new k(this);
        this.aGT = new l(this);
        this.cnP = new y();
        this.cnQ = new m(this);
        this.cnR = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnK = true;
        this.bst = null;
        this.cnM = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cnN = new i(this);
        this.btK = new j(this);
        this.cnO = new k(this);
        this.aGT = new l(this);
        this.cnP = new y();
        this.cnQ = new m(this);
        this.cnR = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cnI = (FrameLayout) findViewById(r.g.tab_widget_content_container);
        this.bfO = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bfO.a(this.btK);
        this.cnF = new o(context, findViewById(r.g.tab_container));
        this.cnF.n(this.cnN);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(r.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aGT);
        this.bst = findViewById(r.g.statebar_view);
        this.cnL = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bst);
        this.bpH = (PluginErrorTipView) observedChangeLinearLayout.findViewById(r.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cnL != null) {
            this.cnL.switchNaviBarStatus(z);
        }
    }

    public void we() {
        if (this.cnJ == null) {
            this.cnJ = new r(this.cnI);
            this.cnJ.a(this.cnO);
        }
        this.cnJ.js(this.topHeight);
        if (!this.cnJ.isShowing()) {
            this.cnJ.a(this.mContext, this.cnH, this.YI.getCurrentItem());
            if (this.cnF != null) {
                this.cnF.aiD();
            }
        }
    }

    public void aiw() {
        if (this.cnJ != null) {
            this.cnJ.aT(this.mContext);
        }
    }

    public boolean aix() {
        return com.baidu.tbadk.core.util.x.s(this.cnH) <= 0;
    }

    public void bk(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.aiG().bn(list);
            this.cnH = list;
            if (this.cnG != null) {
                this.cnG.az(arrayList);
                if (this.cnF != null) {
                    this.cnF.setViewPager(this.YI);
                }
                this.cnP.a(this.cnQ);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cnG != null) {
            this.cnG.c(j, dataRes, z);
        }
    }

    public void aio() {
        if (this.cnG != null) {
            this.cnG.aio();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cnG != null) {
            this.cnG.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.YI != null) {
            this.cnG.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.YI = (CustomViewPager) findViewById(r.g.tab_widget_view_pager);
        this.cnG = new a(this.mContext, bVar, cVar, this.bbl);
        this.cnG.setScrollFragmentTabHost(this);
        this.YI.setAdapter(this.cnG);
        if (this.cnL != null) {
            this.cnG.setRecommendFrsNavigationAnimDispatcher(this.cnL);
        }
    }

    public boolean aiy() {
        return this.cnG != null && this.cnG.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cnG.getCount()) {
            this.YI.setCurrentItem(i, false);
        }
    }

    public int bp(long j) {
        if (this.cnG == null) {
            return -1;
        }
        return this.cnG.bo(j);
    }

    public int getCurrentItem() {
        return this.YI.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cnF != null) {
            this.cnF.onChangeSkinType(i);
        }
        if (this.cnG != null) {
            this.cnG.m18do(i);
        }
        if (this.cnJ != null) {
            this.cnJ.m19do(i);
        }
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (this.bfO != null) {
            this.bfO.onChangeSkinType(C, i);
        }
        if (this.cnL != null) {
            this.cnL.onChangeSkinType(i);
        }
        if (this.bpH != null) {
            this.bpH.onChangeSkinType(C, i);
        }
        UtilHelper.setStatusBarBackground(this.bst, i);
    }

    public void setItemForeGround(int i) {
        this.cnG.setItemForeGround(i);
        if (this.bfO != null) {
            if (com.baidu.adp.lib.util.i.fZ()) {
                this.bfO.setVisibility(8);
            } else {
                this.bfO.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cnL != null) {
            this.cnL.onDestroy();
        }
        this.cnG.onDestroy();
        if (this.bst != null) {
            this.bst.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bbl = bdUniqueId;
        this.cnM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cnM);
        if (this.cnL != null) {
            this.cnL.setPageUniqueId(bdUniqueId);
        }
    }

    public void aiz() {
        if (this.cnG != null) {
            this.cnG.eT(false);
        }
    }

    public int bq(long j) {
        if (this.cnH == null || this.cnH.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cnH) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long br(long j) {
        if (this.cnH == null || this.cnH.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cnH) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bs(long j) {
        if (this.cnH == null || this.cnH.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cnH) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long i(long j, String str) {
        if (this.cnH == null || this.cnH.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cnH) {
            if (tagInfo != null) {
                String pZ = com.baidu.tieba.tbadkCore.u.pZ(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && pZ.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eS(boolean z) {
        this.cnG.eS(z);
    }

    public void ait() {
        this.cnG.ait();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cnG != null) {
            return this.cnG.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cnG != null) {
            return this.cnG.getCurrentPageKey();
        }
        return null;
    }

    public boolean bl(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.t(list) || com.baidu.tbadk.core.util.x.t(this.cnH) || com.baidu.tbadk.core.util.x.s(list) != com.baidu.tbadk.core.util.x.s(this.cnH)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.x.s(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cnH, i);
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
        if (this.cnG != null) {
            this.cnG.ku();
            this.cnG.onPause();
        }
    }

    public void onResume() {
        if (this.cnG != null) {
            this.cnG.onResume();
        }
    }

    public void aiA() {
        this.cnG.a(this.cnR);
    }

    public void aiB() {
        this.cnP.b(this.cnQ);
    }
}

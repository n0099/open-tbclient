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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.homepage.framework.indicator.m;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager Vh;
    private final com.baidu.tbadk.widget.layout.i aDj;
    private BdUniqueId aSq;
    private NoNetworkView aWo;
    private View bFz;
    private PluginErrorTipView bsW;
    private NoNetworkView.a bwU;
    private j coS;
    private a coT;
    private List<TagInfo> coU;
    private FrameLayout coV;
    private m coW;
    public boolean coX;
    private com.baidu.tieba.homepage.framework.b.e coY;
    private CustomMessageListener coZ;
    private View.OnClickListener cpa;
    private m.a cpb;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.coV;
    }

    public boolean agw() {
        return this.coW != null && this.coW.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.coX = true;
        this.bFz = null;
        this.coZ = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cpa = new f(this);
        this.bwU = new g(this);
        this.cpb = new h(this);
        this.aDj = new i(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coX = true;
        this.bFz = null;
        this.coZ = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cpa = new f(this);
        this.bwU = new g(this);
        this.cpb = new h(this);
        this.aDj = new i(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(u.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.coV = (FrameLayout) findViewById(u.g.tab_widget_content_container);
        this.aWo = (NoNetworkView) findViewById(u.g.view_no_network);
        this.aWo.a(this.bwU);
        this.coS = new j(context, findViewById(u.g.tab_container));
        this.coS.q(this.cpa);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(u.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aDj);
        this.bFz = findViewById(u.g.statebar_view);
        this.coY = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bFz);
        this.bsW = (PluginErrorTipView) observedChangeLinearLayout.findViewById(u.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.coY != null) {
            this.coY.switchNaviBarStatus(z);
        }
    }

    public void agx() {
        if (this.coW == null) {
            this.coW = new m(this.coV);
            this.coW.a(this.cpb);
        }
        this.coW.jn(this.topHeight);
        if (!this.coW.isShowing()) {
            this.coW.a(this.mContext, this.coU, this.Vh.getCurrentItem());
            if (this.coS != null) {
                this.coS.agD();
            }
        }
    }

    public void agy() {
        if (this.coW != null) {
            this.coW.ay(this.mContext);
        }
    }

    public boolean agz() {
        return y.s(this.coU) <= 0;
    }

    public void bk(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.agG().bn(list);
            this.coU = list;
            if (this.coT != null) {
                this.coT.az(arrayList);
                if (this.coS != null) {
                    this.coS.setViewPager(this.Vh);
                }
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.coT != null) {
            this.coT.c(j, dataRes, z);
        }
    }

    public void agr() {
        if (this.coT != null) {
            this.coT.agr();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.coT != null) {
            this.coT.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.Vh != null) {
            this.coT.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.Vh = (CustomViewPager) findViewById(u.g.tab_widget_view_pager);
        this.coT = new a(this.mContext, bVar, cVar, this.aSq);
        if (this.coY != null) {
            this.coT.setScrollFragmentTabHost(this);
            this.coT.a(this.coY.agH(), this.coY.agI(), this.coY.RX());
        }
        this.Vh.setAdapter(this.coT);
    }

    public boolean agA() {
        return this.coT != null && this.coT.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.coT.getCount()) {
            this.Vh.setCurrentItem(i, false);
        }
    }

    public int bl(long j) {
        if (this.coT == null) {
            return -1;
        }
        return this.coT.bk(j);
    }

    public int getCurrentItem() {
        return this.Vh.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.coS != null) {
            this.coS.onChangeSkinType(i);
        }
        if (this.coT != null) {
            this.coT.cX(i);
        }
        if (this.coW != null) {
            this.coW.cX(i);
        }
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (this.aWo != null) {
            this.aWo.onChangeSkinType(s, i);
        }
        if (this.coY != null) {
            this.coY.onChangeSkinType(i);
        }
        if (this.bsW != null) {
            this.bsW.onChangeSkinType(s, i);
        }
        UtilHelper.setStatusBarBackground(this.bFz, i);
    }

    public void setItemForeGround(int i) {
        this.coT.setItemForeGround(i);
        if (this.aWo != null) {
            if (com.baidu.adp.lib.util.i.ff()) {
                this.aWo.setVisibility(8);
            } else {
                this.aWo.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.coY != null) {
            this.coY.onDestroy();
        }
        this.coT.onDestroy();
        if (this.bFz != null) {
            this.bFz.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
        this.coZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.coZ);
        if (this.coY != null) {
            this.coY.setPageUniqueId(bdUniqueId);
        }
    }

    public void agB() {
        if (this.coT != null) {
            this.coT.ev(false);
        }
    }

    public int bm(long j) {
        if (this.coU == null || this.coU.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.coU) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bn(long j) {
        if (this.coU == null || this.coU.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.coU) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bo(long j) {
        if (this.coU == null || this.coU.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.coU) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.coU == null || this.coU.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.coU) {
            if (tagInfo != null) {
                String pt = w.pt(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && pt.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eu(boolean z) {
        this.coT.eu(z);
    }

    public void agv() {
        this.coT.agv();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.coT != null) {
            return this.coT.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.coT != null) {
            return this.coT.getCurrentPageKey();
        }
        return null;
    }

    public boolean bl(List<TagInfo> list) {
        if (y.t(list) || y.t(this.coU) || y.s(list) != y.s(this.coU)) {
            return false;
        }
        for (int i = 0; i < y.s(list); i++) {
            TagInfo tagInfo = (TagInfo) y.c(this.coU, i);
            TagInfo tagInfo2 = (TagInfo) y.c(list, i);
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
        if (this.coT != null) {
            this.coT.jA();
        }
    }
}

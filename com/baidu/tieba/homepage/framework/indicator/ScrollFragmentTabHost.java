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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager YD;
    private final com.baidu.tbadk.widget.layout.i aHk;
    private BdUniqueId aYu;
    private PluginErrorTipView bGy;
    private View bJv;
    private NoNetworkView.a bKK;
    private NoNetworkView bdf;
    private View.OnClickListener cCA;
    private r.a cCB;
    private y cCC;
    private com.baidu.tieba.homepage.framework.y cCD;
    private com.baidu.tieba.homepage.framework.x cCE;
    private o cCs;
    private a cCt;
    private List<TagInfo> cCu;
    private FrameLayout cCv;
    private r cCw;
    public boolean cCx;
    private com.baidu.tieba.homepage.framework.b.e cCy;
    private CustomMessageListener cCz;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cCv;
    }

    public boolean alL() {
        return this.cCw != null && this.cCw.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cCx = true;
        this.bJv = null;
        this.cCz = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cCA = new i(this);
        this.bKK = new j(this);
        this.cCB = new k(this);
        this.aHk = new l(this);
        this.cCC = new y();
        this.cCD = new m(this);
        this.cCE = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCx = true;
        this.bJv = null;
        this.cCz = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cCA = new i(this);
        this.bKK = new j(this);
        this.cCB = new k(this);
        this.aHk = new l(this);
        this.cCC = new y();
        this.cCD = new m(this);
        this.cCE = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cCv = (FrameLayout) findViewById(t.g.tab_widget_content_container);
        this.bdf = (NoNetworkView) findViewById(t.g.view_no_network);
        this.bdf.a(this.bKK);
        this.cCs = new o(context, findViewById(t.g.tab_container));
        this.cCs.o(this.cCA);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(t.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aHk);
        this.bJv = findViewById(t.g.statebar_view);
        this.cCy = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bJv);
        this.bGy = (PluginErrorTipView) observedChangeLinearLayout.findViewById(t.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cCy != null) {
            this.cCy.switchNaviBarStatus(z);
        }
    }

    public void alM() {
        if (this.cCw == null) {
            this.cCw = new r(this.cCv);
            this.cCw.a(this.cCB);
        }
        this.cCw.jU(this.topHeight);
        if (!this.cCw.isShowing()) {
            this.cCw.a(this.mContext, this.cCu, this.YD.getCurrentItem());
            if (this.cCs != null) {
                this.cCs.alU();
            }
        }
    }

    public void alN() {
        if (this.cCw != null) {
            this.cCw.aK(this.mContext);
        }
    }

    public boolean alO() {
        return com.baidu.tbadk.core.util.y.s(this.cCu) <= 0;
    }

    public void bq(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.alX().bt(list);
            this.cCu = list;
            if (this.cCt != null) {
                this.cCt.aF(arrayList);
                if (this.cCs != null) {
                    this.cCs.setViewPager(this.YD);
                }
                this.cCC.a(this.cCD);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cCt != null) {
            this.cCt.c(j, dataRes, z);
        }
    }

    public void alF() {
        if (this.cCt != null) {
            this.cCt.alF();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cCt != null) {
            this.cCt.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.YD != null) {
            this.cCt.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.YD = (CustomViewPager) findViewById(t.g.tab_widget_view_pager);
        this.cCt = new a(this.mContext, bVar, cVar, this.aYu);
        if (this.cCy != null) {
            this.cCt.setScrollFragmentTabHost(this);
            this.cCt.a(this.cCy.alY(), this.cCy.alZ(), this.cCy.Xr());
        }
        this.YD.setAdapter(this.cCt);
    }

    public boolean alP() {
        return this.cCt != null && this.cCt.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cCt.getCount()) {
            this.YD.setCurrentItem(i, false);
        }
    }

    public int bC(long j) {
        if (this.cCt == null) {
            return -1;
        }
        return this.cCt.bB(j);
    }

    public int getCurrentItem() {
        return this.YD.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cCs != null) {
            this.cCs.onChangeSkinType(i);
        }
        if (this.cCt != null) {
            this.cCt.dl(i);
        }
        if (this.cCw != null) {
            this.cCw.dl(i);
        }
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (this.bdf != null) {
            this.bdf.onChangeSkinType(C, i);
        }
        if (this.cCy != null) {
            this.cCy.onChangeSkinType(i);
        }
        if (this.bGy != null) {
            this.bGy.onChangeSkinType(C, i);
        }
        UtilHelper.setStatusBarBackground(this.bJv, i);
    }

    public void setItemForeGround(int i) {
        this.cCt.setItemForeGround(i);
        if (this.bdf != null) {
            if (com.baidu.adp.lib.util.i.fZ()) {
                this.bdf.setVisibility(8);
            } else {
                this.bdf.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cCy != null) {
            this.cCy.onDestroy();
        }
        this.cCt.onDestroy();
        if (this.bJv != null) {
            this.bJv.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYu = bdUniqueId;
        this.cCz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cCz);
        if (this.cCy != null) {
            this.cCy.setPageUniqueId(bdUniqueId);
        }
    }

    public void alQ() {
        if (this.cCt != null) {
            this.cCt.eS(false);
        }
    }

    public int bD(long j) {
        if (this.cCu == null || this.cCu.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cCu) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bE(long j) {
        if (this.cCu == null || this.cCu.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cCu) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bF(long j) {
        if (this.cCu == null || this.cCu.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cCu) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long i(long j, String str) {
        if (this.cCu == null || this.cCu.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cCu) {
            if (tagInfo != null) {
                String qN = com.baidu.tieba.tbadkCore.v.qN(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && qN.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void eR(boolean z) {
        this.cCt.eR(z);
    }

    public void alJ() {
        this.cCt.alJ();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cCt != null) {
            return this.cCt.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cCt != null) {
            return this.cCt.getCurrentPageKey();
        }
        return null;
    }

    public boolean br(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.t(list) || com.baidu.tbadk.core.util.y.t(this.cCu) || com.baidu.tbadk.core.util.y.s(list) != com.baidu.tbadk.core.util.y.s(this.cCu)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(this.cCu, i);
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
        if (this.cCt != null) {
            this.cCt.ku();
            this.cCt.onPause();
        }
    }

    public void onResume() {
        if (this.cCt != null) {
            this.cCt.onResume();
        }
    }

    public void alR() {
        this.cCt.a(this.cCE);
    }

    public void alS() {
        this.cCC.b(this.cCD);
    }
}

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
    private CustomViewPager Zo;
    private final com.baidu.tbadk.widget.layout.i aHz;
    private PluginErrorTipView bJD;
    private View bMp;
    private NoNetworkView.a bNE;
    private BdUniqueId bcf;
    private NoNetworkView bgz;
    private o cIk;
    private a cIl;
    private List<TagInfo> cIm;
    private FrameLayout cIn;
    private r cIo;
    public boolean cIp;
    private com.baidu.tieba.homepage.framework.b.e cIq;
    private CustomMessageListener cIr;
    private View.OnClickListener cIs;
    private r.a cIt;
    private y cIu;
    private com.baidu.tieba.homepage.framework.y cIv;
    private com.baidu.tieba.homepage.framework.x cIw;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cIn;
    }

    public boolean anV() {
        return this.cIo != null && this.cIo.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cIp = true;
        this.bMp = null;
        this.cIr = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cIs = new i(this);
        this.bNE = new j(this);
        this.cIt = new k(this);
        this.aHz = new l(this);
        this.cIu = new y();
        this.cIv = new m(this);
        this.cIw = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cIp = true;
        this.bMp = null;
        this.cIr = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.cIs = new i(this);
        this.bNE = new j(this);
        this.cIt = new k(this);
        this.aHz = new l(this);
        this.cIu = new y();
        this.cIv = new m(this);
        this.cIw = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cIn = (FrameLayout) findViewById(r.g.tab_widget_content_container);
        this.bgz = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bgz.a(this.bNE);
        this.cIk = new o(context, findViewById(r.g.tab_container));
        this.cIk.p(this.cIs);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(r.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aHz);
        this.bMp = findViewById(r.g.statebar_view);
        this.cIq = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bMp);
        this.bJD = (PluginErrorTipView) observedChangeLinearLayout.findViewById(r.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.cIq != null) {
            this.cIq.switchNaviBarStatus(z);
        }
    }

    public void wu() {
        if (this.cIo == null) {
            this.cIo = new r(this.cIn);
            this.cIo.a(this.cIt);
        }
        this.cIo.kh(this.topHeight);
        if (!this.cIo.isShowing()) {
            this.cIo.a(this.mContext, this.cIm, this.Zo.getCurrentItem());
            if (this.cIk != null) {
                this.cIk.aod();
            }
        }
    }

    public void anW() {
        if (this.cIo != null) {
            this.cIo.aU(this.mContext);
        }
    }

    public boolean anX() {
        return com.baidu.tbadk.core.util.x.s(this.cIm) <= 0;
    }

    public void bs(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.aog().bv(list);
            this.cIm = list;
            if (this.cIl != null) {
                this.cIl.aH(arrayList);
                if (this.cIk != null) {
                    this.cIk.setViewPager(this.Zo);
                }
                this.cIu.a(this.cIv);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.cIl != null) {
            this.cIl.c(j, dataRes, z);
        }
    }

    public void anO() {
        if (this.cIl != null) {
            this.cIl.anO();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cIl != null) {
            this.cIl.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.Zo != null) {
            this.cIl.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.Zo = (CustomViewPager) findViewById(r.g.tab_widget_view_pager);
        this.cIl = new a(this.mContext, bVar, cVar, this.bcf);
        this.cIl.setScrollFragmentTabHost(this);
        this.Zo.setAdapter(this.cIl);
        if (this.cIq != null) {
            this.cIl.setRecommendFrsNavigationAnimDispatcher(this.cIq);
        }
    }

    public boolean anY() {
        return this.cIl != null && this.cIl.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cIl.getCount()) {
            this.Zo.setCurrentItem(i, false);
        }
    }

    public int bB(long j) {
        if (this.cIl == null) {
            return -1;
        }
        return this.cIl.bA(j);
    }

    public int getCurrentItem() {
        return this.Zo.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.cIk != null) {
            this.cIk.onChangeSkinType(i);
        }
        if (this.cIl != null) {
            this.cIl.dm(i);
        }
        if (this.cIo != null) {
            this.cIo.dm(i);
        }
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (this.bgz != null) {
            this.bgz.onChangeSkinType(C, i);
        }
        if (this.cIq != null) {
            this.cIq.onChangeSkinType(i);
        }
        if (this.bJD != null) {
            this.bJD.onChangeSkinType(C, i);
        }
        UtilHelper.setStatusBarBackground(this.bMp, i);
    }

    public void setItemForeGround(int i) {
        this.cIl.setItemForeGround(i);
        if (this.bgz != null) {
            if (com.baidu.adp.lib.util.i.fZ()) {
                this.bgz.setVisibility(8);
            } else {
                this.bgz.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.cIq != null) {
            this.cIq.onDestroy();
        }
        this.cIl.onDestroy();
        if (this.bMp != null) {
            this.bMp.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bcf = bdUniqueId;
        this.cIr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cIr);
        if (this.cIq != null) {
            this.cIq.setPageUniqueId(bdUniqueId);
        }
    }

    public void anZ() {
        if (this.cIl != null) {
            this.cIl.fi(false);
        }
    }

    public int bC(long j) {
        if (this.cIm == null || this.cIm.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.cIm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bD(long j) {
        if (this.cIm == null || this.cIm.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cIm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bE(long j) {
        if (this.cIm == null || this.cIm.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.cIm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long i(long j, String str) {
        if (this.cIm == null || this.cIm.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.cIm) {
            if (tagInfo != null) {
                String rv = com.baidu.tieba.tbadkCore.v.rv(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && rv.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void fh(boolean z) {
        this.cIl.fh(z);
    }

    public void anT() {
        this.cIl.anT();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.cIl != null) {
            return this.cIl.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.cIl != null) {
            return this.cIl.getCurrentPageKey();
        }
        return null;
    }

    public boolean bt(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.t(list) || com.baidu.tbadk.core.util.x.t(this.cIm) || com.baidu.tbadk.core.util.x.s(list) != com.baidu.tbadk.core.util.x.s(this.cIm)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.x.s(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cIm, i);
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
        if (this.cIl != null) {
            this.cIl.ku();
            this.cIl.onPause();
        }
    }

    public void onResume() {
        if (this.cIl != null) {
            this.cIl.onResume();
        }
    }

    public void aoa() {
        this.cIl.a(this.cIw);
    }

    public void aob() {
        this.cIu.b(this.cIv);
    }
}

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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager VQ;
    private final com.baidu.tbadk.widget.layout.i aEa;
    private BdUniqueId aTm;
    private NoNetworkView aXm;
    private View bGN;
    private PluginErrorTipView bvl;
    private NoNetworkView.a bzi;
    private o crk;
    private a crl;
    private List<TagInfo> crm;
    private FrameLayout crn;
    private r cro;
    public boolean crp;
    private com.baidu.tieba.homepage.framework.b.e crq;
    private CustomMessageListener crr;
    private View.OnClickListener crs;
    private r.a crt;
    private y cru;
    private com.baidu.tieba.homepage.framework.y crv;
    private com.baidu.tieba.homepage.framework.x crw;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.crn;
    }

    public boolean aha() {
        return this.cro != null && this.cro.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.crp = true;
        this.bGN = null;
        this.crr = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.crs = new i(this);
        this.bzi = new j(this);
        this.crt = new k(this);
        this.aEa = new l(this);
        this.cru = new y();
        this.crv = new m(this);
        this.crw = new n(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crp = true;
        this.bGN = null;
        this.crr = new h(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.crs = new i(this);
        this.bzi = new j(this);
        this.crt = new k(this);
        this.aEa = new l(this);
        this.cru = new y();
        this.crv = new m(this);
        this.crw = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(u.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.crn = (FrameLayout) findViewById(u.g.tab_widget_content_container);
        this.aXm = (NoNetworkView) findViewById(u.g.view_no_network);
        this.aXm.a(this.bzi);
        this.crk = new o(context, findViewById(u.g.tab_container));
        this.crk.q(this.crs);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(u.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aEa);
        this.bGN = findViewById(u.g.statebar_view);
        this.crq = new com.baidu.tieba.homepage.framework.b.e(context, this, observedChangeLinearLayout, this.bGN);
        this.bvl = (PluginErrorTipView) observedChangeLinearLayout.findViewById(u.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.crq != null) {
            this.crq.switchNaviBarStatus(z);
        }
    }

    public void ahb() {
        if (this.cro == null) {
            this.cro = new r(this.crn);
            this.cro.a(this.crt);
        }
        this.cro.js(this.topHeight);
        if (!this.cro.isShowing()) {
            this.cro.a(this.mContext, this.crm, this.VQ.getCurrentItem());
            if (this.crk != null) {
                this.crk.ahj();
            }
        }
    }

    public void ahc() {
        if (this.cro != null) {
            this.cro.ay(this.mContext);
        }
    }

    public boolean ahd() {
        return com.baidu.tbadk.core.util.y.s(this.crm) <= 0;
    }

    public void bo(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.homepage.recommendfrs.data.a(tagInfo));
                }
            }
            com.baidu.tieba.homepage.framework.a.a.ahm().br(list);
            this.crm = list;
            if (this.crl != null) {
                this.crl.aD(arrayList);
                if (this.crk != null) {
                    this.crk.setViewPager(this.VQ);
                }
                this.cru.a(this.crv);
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.crl != null) {
            this.crl.c(j, dataRes, z);
        }
    }

    public void agU() {
        if (this.crl != null) {
            this.crl.agU();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.crl != null) {
            this.crl.a(z, j, cVar, z2);
        }
    }

    public void a(long j, String str, int i) {
        if (this.VQ != null) {
            this.crl.a(j, str, i);
        }
    }

    public void a(com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar) {
        this.VQ = (CustomViewPager) findViewById(u.g.tab_widget_view_pager);
        this.crl = new a(this.mContext, bVar, cVar, this.aTm);
        if (this.crq != null) {
            this.crl.setScrollFragmentTabHost(this);
            this.crl.a(this.crq.ahn(), this.crq.aho(), this.crq.SF());
        }
        this.VQ.setAdapter(this.crl);
    }

    public boolean ahe() {
        return this.crl != null && this.crl.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.crl.getCount()) {
            this.VQ.setCurrentItem(i, false);
        }
    }

    public int bg(long j) {
        if (this.crl == null) {
            return -1;
        }
        return this.crl.bf(j);
    }

    public int getCurrentItem() {
        return this.VQ.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.crk != null) {
            this.crk.onChangeSkinType(i);
        }
        if (this.crl != null) {
            this.crl.cX(i);
        }
        if (this.cro != null) {
            this.cro.cX(i);
        }
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (this.aXm != null) {
            this.aXm.onChangeSkinType(s, i);
        }
        if (this.crq != null) {
            this.crq.onChangeSkinType(i);
        }
        if (this.bvl != null) {
            this.bvl.onChangeSkinType(s, i);
        }
        UtilHelper.setStatusBarBackground(this.bGN, i);
    }

    public void setItemForeGround(int i) {
        this.crl.setItemForeGround(i);
        if (this.aXm != null) {
            if (com.baidu.adp.lib.util.i.fe()) {
                this.aXm.setVisibility(8);
            } else {
                this.aXm.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.crq != null) {
            this.crq.onDestroy();
        }
        this.crl.onDestroy();
        if (this.bGN != null) {
            this.bGN.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
        this.crr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.crr);
        if (this.crq != null) {
            this.crq.setPageUniqueId(bdUniqueId);
        }
    }

    public void ahf() {
        if (this.crl != null) {
            this.crl.ew(false);
        }
    }

    public int bh(long j) {
        if (this.crm == null || this.crm.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.crm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public long bi(long j) {
        if (this.crm == null || this.crm.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.crm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_page_id.longValue();
            }
        }
        return 0L;
    }

    public String bj(long j) {
        if (this.crm == null || this.crm.size() == 0) {
            return "";
        }
        for (TagInfo tagInfo : this.crm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.lego_qs;
            }
        }
        return "";
    }

    public long f(long j, String str) {
        if (this.crm == null || this.crm.size() == 0) {
            return 0L;
        }
        for (TagInfo tagInfo : this.crm) {
            if (tagInfo != null) {
                String qd = com.baidu.tieba.tbadkCore.w.qd(tagInfo.lego_qs);
                if (tagInfo.lego_page_id.longValue() == j && qd.equals(str)) {
                    return tagInfo.tag_code.longValue();
                }
            }
        }
        return 0L;
    }

    public void ev(boolean z) {
        this.crl.ev(z);
    }

    public void agY() {
        this.crl.agY();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.crl != null) {
            return this.crl.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.crl != null) {
            return this.crl.getCurrentPageKey();
        }
        return null;
    }

    public boolean bp(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.t(list) || com.baidu.tbadk.core.util.y.t(this.crm) || com.baidu.tbadk.core.util.y.s(list) != com.baidu.tbadk.core.util.y.s(this.crm)) {
            return false;
        }
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(list); i++) {
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(this.crm, i);
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
        if (this.crl != null) {
            this.crl.jz();
            this.crl.onPause();
        }
    }

    public void ahg() {
        this.crl.a(this.crw);
    }

    public void ahh() {
        this.cru.b(this.crv);
    }
}

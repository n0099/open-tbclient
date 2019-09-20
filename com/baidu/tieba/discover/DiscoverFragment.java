package com.baidu.tieba.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class DiscoverFragment extends BaseFragment implements ae {
    private a eUh;
    private boolean eUi;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean drA = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.eUh != null && DiscoverFragment.this.eUh.getWebView() != null && DiscoverFragment.this.eUh.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.eUh.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.eUh.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener eUj = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.aJP();
                } else {
                    DiscoverFragment.this.aJQ();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eUh = new a();
        return this.eUh.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eUh.l(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.eUj);
        ad.a(this.eUh.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.drA || StringUtils.isNull(this.eUh.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.eUh.loadUrl(uo(this.mUrl));
            } else {
                this.eUh.loadUrl(this.mUrl);
            }
            this.drA = false;
        }
    }

    private String uo(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        try {
            if (StringUtils.isNull(new URL(str).getQuery())) {
                str = str + "?isNightModel=1";
            } else {
                str = str + "&isNightModel=1";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eUh != null) {
            this.eUh.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a033";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.drA) {
            if (i == 1 || i == 4) {
                this.eUh.loadUrl(uo(this.mUrl));
            } else {
                this.eUh.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJO() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJP() {
        if (this.eUh != null && !this.eUi) {
            this.eUi = true;
            this.eUh.beJ();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJQ() {
        if (this.eUh != null && this.eUi) {
            this.eUi = false;
            this.eUh.beK();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akZ() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}

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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class DiscoverFragment extends BaseFragment implements ae {
    private a eyd;
    private boolean eye;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean ddc = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.eyd != null && DiscoverFragment.this.eyd.getWebView() != null && DiscoverFragment.this.eyd.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.eyd.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.eyd.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener eyf = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.aBv();
                } else {
                    DiscoverFragment.this.aBw();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eyd = new a();
        return this.eyd.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eyd.k(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.eyf);
        com.baidu.tbadk.util.ae.a(this.eyd.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ddc || StringUtils.isNull(this.eyd.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.eyd.loadUrl(sd(this.mUrl));
            } else {
                this.eyd.loadUrl(this.mUrl);
            }
            this.ddc = false;
        }
    }

    private String sd(String str) {
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
        if (this.eyd != null) {
            this.eyd.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
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
        if (!this.ddc) {
            if (i == 1) {
                this.eyd.loadUrl(sd(this.mUrl));
            } else {
                this.eyd.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBu() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
        if (this.eyd != null && !this.eye) {
            this.eye = true;
            this.eyd.aUT();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
        if (this.eyd != null && this.eye) {
            this.eye = false;
            this.eyd.aUU();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeK() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}

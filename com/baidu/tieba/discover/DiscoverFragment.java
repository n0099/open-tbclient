package com.baidu.tieba.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.af;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DiscoverFragment extends BaseFragment implements af {
    private a fQv;
    private boolean fQw;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean enU = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.fQv != null && DiscoverFragment.this.fQv.getWebView() != null && DiscoverFragment.this.fQv.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.fQv.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.fQv.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener fQx = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bcz();
                } else {
                    DiscoverFragment.this.bcA();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fQv = new a();
        return this.fQv.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fQv.n(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.fQx);
        ag.a(this.fQv.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.enU || StringUtils.isNull(this.fQv.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.fQv.loadUrl(yi(this.mUrl));
            } else {
                this.fQv.loadUrl(this.mUrl);
            }
            this.enU = false;
        }
    }

    private String yi(String str) {
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
        if (this.fQv != null) {
            this.fQv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.DISCOVER;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.enU) {
            if (i == 1 || i == 4) {
                this.fQv.loadUrl(yi(this.mUrl));
            } else {
                this.fQv.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bcz() {
        if (this.fQv != null && !this.fQw) {
            this.fQw = true;
            this.fQv.bwH();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
        if (this.fQv != null && this.fQw) {
            this.fQw = false;
            this.fQv.bwI();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.af
    public void aHN() {
    }
}

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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ag;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DiscoverFragment extends BaseFragment implements ag {
    private a fRr;
    private boolean fRs;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean eoz = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.fRr != null && DiscoverFragment.this.fRr.getWebView() != null && DiscoverFragment.this.fRr.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.fRr.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.fRr.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener fRt = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bcE();
                } else {
                    DiscoverFragment.this.bcF();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fRr = new a();
        return this.fRr.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fRr.o(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.fRt);
        com.baidu.tbadk.util.ag.a(this.fRr.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eoz || StringUtils.isNull(this.fRr.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.fRr.loadUrl(yj(this.mUrl));
            } else {
                this.fRr.loadUrl(this.mUrl);
            }
            this.eoz = false;
        }
    }

    private String yj(String str) {
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
        if (this.fRr != null) {
            this.fRr.onDestroy();
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
        if (!this.eoz) {
            if (i == 1 || i == 4) {
                this.fRr.loadUrl(yj(this.mUrl));
            } else {
                this.fRr.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void AJ() {
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcE() {
        if (this.fRr != null && !this.fRs) {
            this.fRs = true;
            this.fRr.bwN();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcF() {
        if (this.fRr != null && this.fRs) {
            this.fRs = false;
            this.fRr.bwO();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ag
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ag
    public void aHS() {
    }
}

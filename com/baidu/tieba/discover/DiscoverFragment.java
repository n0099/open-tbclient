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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.frs.ao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class DiscoverFragment extends BaseFragment implements ao {
    private a hdD;
    private boolean hdE;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean fvp = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.hdD != null && DiscoverFragment.this.hdD.getWebView() != null && DiscoverFragment.this.hdD.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.hdD.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.hdD.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener hdF = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bwZ();
                } else {
                    DiscoverFragment.this.bxa();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hdD = new a();
        return this.hdD.b(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hdD.r(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.hdF);
        ah.a(this.hdD.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fvp || StringUtils.isNull(this.hdD.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.hdD.loadUrl(CM(this.mUrl));
            } else {
                this.hdD.loadUrl(this.mUrl);
            }
            this.fvp = false;
        }
    }

    private String CM(String str) {
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
        if (this.hdD != null) {
            this.hdD.onDestroy();
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
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(x.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.fvp) {
            if (i == 1 || i == 4) {
                this.hdD.loadUrl(CM(this.mUrl));
            } else {
                this.hdD.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bwZ() {
        if (this.hdD != null && !this.hdE) {
            this.hdE = true;
            this.hdD.bTk();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
        if (this.hdD != null && this.hdE) {
            this.hdE = false;
            this.hdD.bTl();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
    }
}

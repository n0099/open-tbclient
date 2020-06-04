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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.frs.aj;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DiscoverFragment extends BaseFragment implements aj {
    private a gLb;
    private boolean gLc;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean feU = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.gLb != null && DiscoverFragment.this.gLb.getWebView() != null && DiscoverFragment.this.gLb.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.gLb.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.gLb.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener gLd = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bqS();
                } else {
                    DiscoverFragment.this.bqT();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gLb = new a();
        return this.gLb.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gLb.p(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.gLd);
        ah.a(this.gLb.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.feU || StringUtils.isNull(this.gLb.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.gLb.loadUrl(BC(this.mUrl));
            } else {
                this.gLb.loadUrl(this.mUrl);
            }
            this.feU = false;
        }
    }

    private String BC(String str) {
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
        if (this.gLb != null) {
            this.gLb.onDestroy();
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
        if (!this.feU) {
            if (i == 1 || i == 4) {
                this.gLb.loadUrl(BC(this.mUrl));
            } else {
                this.gLb.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
        if (this.gLb != null && !this.gLc) {
            this.gLc = true;
            this.gLb.bMT();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
        if (this.gLb != null && this.gLc) {
            this.gLc = false;
            this.gLb.bMU();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
    }
}

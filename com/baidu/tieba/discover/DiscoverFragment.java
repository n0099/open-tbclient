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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class DiscoverFragment extends BaseFragment implements ae {
    private a eWW;
    private boolean eWX;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean dyK = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.eWW != null && DiscoverFragment.this.eWW.getWebView() != null && DiscoverFragment.this.eWW.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.eWW.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.eWW.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener eWY = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.aJp();
                } else {
                    DiscoverFragment.this.aJq();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eWW = new a();
        return this.eWW.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eWW.l(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.eWY);
        ad.a(this.eWW.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dyK || StringUtils.isNull(this.eWW.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.eWW.loadUrl(sY(this.mUrl));
            } else {
                this.eWW.loadUrl(this.mUrl);
            }
            this.dyK = false;
        }
    }

    private String sY(String str) {
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
        if (this.eWW != null) {
            this.eWW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.DISCOVER;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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
        if (!this.dyK) {
            if (i == 1 || i == 4) {
                this.eWW.loadUrl(sY(this.mUrl));
            } else {
                this.eWW.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
        if (this.eWW != null && !this.eWX) {
            this.eWX = true;
            this.eWW.bcE();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
        if (this.eWW != null && this.eWX) {
            this.eWX = false;
            this.eWW.bcF();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}

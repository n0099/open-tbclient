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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.frs.aq;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class DiscoverFragment extends BaseFragment implements aq {
    private a hMD;
    private boolean hME;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean fWp = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.hMD != null && DiscoverFragment.this.hMD.getWebView() != null && DiscoverFragment.this.hMD.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.hMD.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.hMD.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener hMF = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bKa();
                } else {
                    DiscoverFragment.this.bKb();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hMD = new a();
        return this.hMD.b(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hMD.r(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.hMF);
        aj.a(this.hMD.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fWp || StringUtils.isNull(this.hMD.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.hMD.loadUrl(Gr(this.mUrl));
            } else {
                this.hMD.loadUrl(this.mUrl);
            }
            this.fWp = false;
        }
    }

    private String Gr(String str) {
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
        if (this.hMD != null) {
            this.hMD.onDestroy();
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
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(y.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.fWp) {
            if (i == 1 || i == 4) {
                this.hMD.loadUrl(Gr(this.mUrl));
            } else {
                this.hMD.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void Qi() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKa() {
        if (this.hMD != null && !this.hME) {
            this.hME = true;
            this.hMD.cki();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKb() {
        if (this.hMD != null && this.hME) {
            this.hME = false;
            this.hMD.ckj();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bok() {
    }
}

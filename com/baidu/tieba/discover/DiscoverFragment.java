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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ah;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DiscoverFragment extends BaseFragment implements ah {
    private a cOJ;
    private boolean cOK;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean byZ = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.cOJ != null && DiscoverFragment.this.cOJ.getWebView() != null && DiscoverFragment.this.cOJ.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.cOJ.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.cOJ.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener cOL = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.TQ();
                } else {
                    DiscoverFragment.this.TR();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cOJ = new a();
        return this.cOJ.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cOJ.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.cOL);
        z.a(this.cOJ.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.byZ || StringUtils.isNull(this.cOJ.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.cOJ.loadUrl(jC(this.mUrl));
            } else {
                this.cOJ.loadUrl(this.mUrl);
            }
            this.byZ = false;
        }
    }

    private String jC(String str) {
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
        if (this.cOJ != null) {
            this.cOJ.onDestroy();
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
        if (!"a001".equals(w.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.byZ) {
            if (i == 1) {
                this.cOJ.loadUrl(jC(this.mUrl));
            } else {
                this.cOJ.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TP() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TQ() {
        if (this.cOJ != null && !this.cOK) {
            this.cOK = true;
            this.cOJ.ant();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TR() {
        if (this.cOJ != null && this.cOK) {
            this.cOK = false;
            this.cOJ.anu();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void AD() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}

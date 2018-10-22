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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.ah;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class DiscoverFragment extends BaseFragment implements ah {
    private a dcS;
    private boolean dcT;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean bNr = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.dcS != null && DiscoverFragment.this.dcS.getWebView() != null && DiscoverFragment.this.dcS.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.dcS.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.dcS.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener dcU = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.Zl();
                } else {
                    DiscoverFragment.this.Zm();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dcS = new a();
        return this.dcS.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dcS.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.dcU);
        ab.a(this.dcS.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bNr || StringUtils.isNull(this.dcS.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.dcS.loadUrl(kI(this.mUrl));
            } else {
                this.dcS.loadUrl(this.mUrl);
            }
            this.bNr = false;
        }
    }

    private String kI(String str) {
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
        if (this.dcS != null) {
            this.dcS.onDestroy();
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
        if (!"a001".equals(v.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.bNr) {
            if (i == 1) {
                this.dcS.loadUrl(kI(this.mUrl));
            } else {
                this.dcS.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
        if (this.dcS != null && !this.dcT) {
            this.dcT = true;
            this.dcS.asE();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zm() {
        if (this.dcS != null && this.dcT) {
            this.dcT = false;
            this.dcS.asF();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void DV() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}

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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.af;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DiscoverFragment extends BaseFragment implements af {
    private a cOj;
    private boolean cOk;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean bEd = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.cOj != null && DiscoverFragment.this.cOj.getWebView() != null && DiscoverFragment.this.cOj.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.cOj.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.cOj.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener cOl = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.Tl();
                } else {
                    DiscoverFragment.this.Tm();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cOj = new a();
        return this.cOj.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cOj.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.cOl);
        aa.a(this.cOj.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bEd || StringUtils.isNull(this.cOj.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.cOj.loadUrl(jz(this.mUrl));
            } else {
                this.cOj.loadUrl(this.mUrl);
            }
            this.bEd = false;
        }
    }

    private String jz(String str) {
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
        if (this.cOj != null) {
            this.cOj.onDestroy();
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
        if (!"a001".equals(w.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.bEd) {
            if (i == 1) {
                this.cOj.loadUrl(jz(this.mUrl));
            } else {
                this.cOj.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void Tk() {
    }

    @Override // com.baidu.tieba.frs.af
    public void Tl() {
        if (this.cOj != null && !this.cOk) {
            this.cOk = true;
            this.cOj.any();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void Tm() {
        if (this.cOj != null && this.cOk) {
            this.cOk = false;
            this.cOj.anz();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.af
    public void Ay() {
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}

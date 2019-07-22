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
    private a eSt;
    private boolean eSu;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean dpI = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.eSt != null && DiscoverFragment.this.eSt.getWebView() != null && DiscoverFragment.this.eSt.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.eSt.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.eSt.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener eSv = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.aJj();
                } else {
                    DiscoverFragment.this.aJk();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eSt = new a();
        return this.eSt.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eSt.l(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.eSv);
        com.baidu.tbadk.util.ae.a(this.eSt.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dpI || StringUtils.isNull(this.eSt.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.eSt.loadUrl(tO(this.mUrl));
            } else {
                this.eSt.loadUrl(this.mUrl);
            }
            this.dpI = false;
        }
    }

    private String tO(String str) {
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
        if (this.eSt != null) {
            this.eSt.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a033";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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
        if (!this.dpI) {
            if (i == 1) {
                this.eSt.loadUrl(tO(this.mUrl));
            } else {
                this.eSt.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJj() {
        if (this.eSt != null && !this.eSu) {
            this.eSu = true;
            this.eSt.bed();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
        if (this.eSt != null && this.eSu) {
            this.eSu = false;
            this.eSt.bee();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}

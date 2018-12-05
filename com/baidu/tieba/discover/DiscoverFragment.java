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
    private a dkG;
    private boolean dkH;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean bRT = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.dkG != null && DiscoverFragment.this.dkG.getWebView() != null && DiscoverFragment.this.dkG.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.dkG.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.dkG.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener dkI = new CustomMessageListener(2921041) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.aaB();
                } else {
                    DiscoverFragment.this.aaC();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dkG = new a();
        return this.dkG.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dkG.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.dkI);
        ab.a(this.dkG.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bRT || StringUtils.isNull(this.dkG.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.dkG.loadUrl(le(this.mUrl));
            } else {
                this.dkG.loadUrl(this.mUrl);
            }
            this.bRT = false;
        }
    }

    private String le(String str) {
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
        if (this.dkG != null) {
            this.dkG.onDestroy();
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
        if (!this.bRT) {
            if (i == 1) {
                this.dkG.loadUrl(le(this.mUrl));
            } else {
                this.dkG.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaA() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaB() {
        if (this.dkG != null && !this.dkH) {
            this.dkH = true;
            this.dkG.atP();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
        if (this.dkG != null && this.dkH) {
            this.dkH = false;
            this.dkG.atQ();
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
    public void Fj() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}

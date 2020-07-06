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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.frs.ao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DiscoverFragment extends BaseFragment implements ao {
    private a gXY;
    private boolean gXZ;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean fqf = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.gXY != null && DiscoverFragment.this.gXY.getWebView() != null && DiscoverFragment.this.gXY.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.gXY.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.gXY.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener gYa = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.btQ();
                } else {
                    DiscoverFragment.this.btR();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gXY = new a();
        return this.gXY.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gXY.s(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.gYa);
        ah.a(this.gXY.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fqf || StringUtils.isNull(this.gXY.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.gXY.loadUrl(Ca(this.mUrl));
            } else {
                this.gXY.loadUrl(this.mUrl);
            }
            this.fqf = false;
        }
    }

    private String Ca(String str) {
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
        if (this.gXY != null) {
            this.gXY.onDestroy();
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
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(w.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.fqf) {
            if (i == 1 || i == 4) {
                this.gXY.loadUrl(Ca(this.mUrl));
            } else {
                this.gXY.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
        if (this.gXY != null && !this.gXZ) {
            this.gXZ = true;
            this.gXY.bPZ();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void btR() {
        if (this.gXY != null && this.gXZ) {
            this.gXZ = false;
            this.gXY.bQa();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
    }
}

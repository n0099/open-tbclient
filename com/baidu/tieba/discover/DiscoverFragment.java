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
    private a hZa;
    private boolean hZb;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean ggt = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.DiscoverFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && DiscoverFragment.this.hZa != null && DiscoverFragment.this.hZa.getWebView() != null && DiscoverFragment.this.hZa.getWebView().getUrl() != null) {
                if (DiscoverFragment.this.hZa.getWebView().getUrl().contains((String) customResponsedMessage.getData())) {
                    DiscoverFragment.this.hZa.hideLoadingView();
                }
            }
        }
    };
    private CustomMessageListener hZc = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.DiscoverFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    DiscoverFragment.this.bMC();
                } else {
                    DiscoverFragment.this.bMD();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hZa = new a();
        return this.hZa.b(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hZa.r(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.hZc);
        aj.a(this.hZa.getWebView(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ggt || StringUtils.isNull(this.hZa.getWebView().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.hZa.loadUrl(GP(this.mUrl));
            } else {
                this.hZa.loadUrl(this.mUrl);
            }
            this.ggt = false;
        }
    }

    private String GP(String str) {
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
        if (this.hZa != null) {
            this.hZa.onDestroy();
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
        if (!this.ggt) {
            if (i == 1 || i == 4) {
                this.hZa.loadUrl(GP(this.mUrl));
            } else {
                this.hZa.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void Rd() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMC() {
        if (this.hZa != null && !this.hZb) {
            this.hZb = true;
            this.hZa.cnp();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMD() {
        if (this.hZa != null && this.hZb) {
            this.hZb = false;
            this.hZa.cnq();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bqd() {
    }
}

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.aj;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements aj {
    private b deC;
    private boolean deD;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean chh = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && a.this.deC != null && a.this.deC.XY() != null && a.this.deC.XY().getUrl() != null) {
                if (a.this.deC.XY().getUrl().contains((String) customResponsedMessage.getData())) {
                    a.this.deC.Vn();
                }
            }
        }
    };
    private CustomMessageListener deE = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    a.this.WJ();
                } else {
                    a.this.WK();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.deC = new b();
        return this.deC.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.deC.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.deE);
        z.a(this.deC.XY(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.chh || StringUtils.isNull(this.deC.XY().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.deC.loadUrl(iB(this.mUrl));
            } else {
                this.deC.loadUrl(this.mUrl);
            }
            this.chh = false;
        }
    }

    private String iB(String str) {
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
        if (this.deC != null) {
            this.deC.onDestroy();
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
        if (!"a001".equals(v.f(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.chh) {
            if (i == 1) {
                this.deC.loadUrl(iB(this.mUrl));
            } else {
                this.deC.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void WI() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void WJ() {
        if (this.deC != null && !this.deD) {
            this.deD = true;
            this.deC.anw();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void WK() {
        if (this.deC != null && this.deD) {
            this.deD = false;
            this.deC.anx();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ea() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}

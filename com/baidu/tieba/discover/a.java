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
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ai;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment implements ai {
    private b bZj;
    private boolean bZk;
    private String mUrl = TbConfig.DISCOVER_PAGE;
    private boolean blo = true;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.discover.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String) && a.this.bZj != null && a.this.bZj.OW() != null && a.this.bZj.OW().getUrl() != null) {
                if (a.this.bZj.OW().getUrl().contains((String) customResponsedMessage.getData())) {
                    a.this.bZj.NT();
                }
            }
        }
    };
    private CustomMessageListener bZl = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE) { // from class: com.baidu.tieba.discover.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921041 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    a.this.ND();
                } else {
                    a.this.NE();
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bZj = new b();
        return this.bZj.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bZj.j(getPageContext());
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.bZl);
        x.a(this.bZj.OW(), getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.blo || StringUtils.isNull(this.bZj.OW().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.bZj.loadUrl(m12if(this.mUrl));
            } else {
                this.bZj.loadUrl(this.mUrl);
            }
            this.blo = false;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private String m12if(String str) {
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
        if (this.bZj != null) {
            this.bZj.onDestroy();
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
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.blo) {
            if (i == 1) {
                this.bZj.loadUrl(m12if(this.mUrl));
            } else {
                this.bZj.loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NC() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void ND() {
        if (this.bZj != null && !this.bZk) {
            this.bZk = true;
            this.bZj.abE();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NE() {
        if (this.bZj != null && this.bZk) {
            this.bZk = false;
            this.bZj.abF();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void wu() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}

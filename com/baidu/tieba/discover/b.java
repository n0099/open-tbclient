package com.baidu.tieba.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.net.URL;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private e bPK;
    private String mUrl = "https://tieba.baidu.com/n/apage-runtime/page/350";
    private boolean bHe = true;
    CustomMessageListener htmlLoadMessageListener = new c(this, CmdConfigCustom.CMD_HTML_LOADED);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bPK = new e();
        return this.bPK.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bPK.m(getPageContext());
        registerListener(this.htmlLoadMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bHe || StringUtils.isNull(this.bPK.UL().getUrl())) {
            if (TbadkApplication.getInst().getSkinType() == 1) {
                this.bPK.loadUrl(iY(this.mUrl));
            } else {
                this.bPK.loadUrl(this.mUrl);
            }
            this.bHe = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private String iY(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        try {
            if (StringUtils.isNull(new URL(str).getQuery())) {
                str = String.valueOf(str) + "?isNightModel=1";
            } else {
                str = String.valueOf(str) + "&isNightModel=1";
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
        if (this.bPK != null) {
            this.bPK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.bHe) {
            if (i == 1) {
                this.bPK.loadUrl(iY(this.mUrl));
            } else {
                this.bPK.loadUrl(this.mUrl);
            }
        }
    }
}

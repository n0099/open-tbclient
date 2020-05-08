package com.baidu.tieba.ala.gamefrslivetab.video;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.am;
import java.net.URL;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements am {
    private b fiD;
    private String forumId;
    private String forumName;
    private boolean fgT = false;
    private boolean eSb = true;
    private CustomMessageListener eVk = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 8 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        if (AlaGameFrsLiveTabVideoFragment.this.fiD != null) {
                            AlaGameFrsLiveTabVideoFragment.this.fiD.bml();
                        }
                    } else if ("FrsGameLiveLive".equals(split[0]) && 3 == com.baidu.adp.lib.f.b.toInt(split[1], 0) && AlaGameFrsLiveTabVideoFragment.this.fiD != null) {
                        AlaGameFrsLiveTabVideoFragment.this.fiD.bml();
                    }
                }
            }
        }
    };
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaGameFrsLiveTabVideoFragment.this.getVideoUrl().contains(str) || str.contains(AlaGameFrsLiveTabVideoFragment.this.getVideoUrl())) {
                    AlaGameFrsLiveTabVideoFragment.this.fiD.hideLoadingView();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.eVk, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fiD = new b(this.fgT);
        return this.fiD.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fiD.c(this);
        registerListener(this.htmlLoadMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eSb || StringUtils.isNull(this.fiD.getWebView().getUrl())) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.fiD.loadUrl(zV(getVideoUrl()));
            } else {
                this.fiD.loadUrl(getVideoUrl());
            }
            this.eSb = false;
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

    private String zV(String str) {
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
        if (this.fiD != null) {
            this.fiD.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.eSb) {
            if (i == 1) {
                this.fiD.loadUrl(zV(getVideoUrl()));
            } else {
                this.fiD.loadUrl(getVideoUrl());
            }
            this.fiD.onChangeSkinType(i);
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void jC(boolean z) {
        this.fgT = z;
    }

    public String getVideoUrl() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
        if (string != null) {
            StringBuilder sb = new StringBuilder(string);
            if (string.endsWith("?")) {
                sb.append("fid=");
                sb.append(this.forumId);
            } else {
                sb.append("?fid=");
                sb.append(this.forumId);
            }
            return sb.toString();
        }
        return "http://tieba.baidu.com/n/interact/video/game";
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bof() {
        return this.fiD.bof();
    }
}

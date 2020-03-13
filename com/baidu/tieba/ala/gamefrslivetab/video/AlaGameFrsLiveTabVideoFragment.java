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
import com.baidu.tieba.frs.ai;
import java.net.URL;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements ai {
    private b eDH;
    private String forumId;
    private String forumName;
    private boolean eBZ = false;
    private boolean eoi = true;
    private CustomMessageListener erm = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 8 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        if (AlaGameFrsLiveTabVideoFragment.this.eDH != null) {
                            AlaGameFrsLiveTabVideoFragment.this.eDH.bdr();
                        }
                    } else if ("FrsGameLiveLive".equals(split[0]) && 3 == com.baidu.adp.lib.f.b.toInt(split[1], 0) && AlaGameFrsLiveTabVideoFragment.this.eDH != null) {
                        AlaGameFrsLiveTabVideoFragment.this.eDH.bdr();
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
                    AlaGameFrsLiveTabVideoFragment.this.eDH.hideLoadingView();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.erm, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eDH = new b(this.eBZ);
        return this.eDH.a(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eDH.c(this);
        registerListener(this.htmlLoadMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eoi || StringUtils.isNull(this.eDH.getWebView().getUrl())) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eDH.loadUrl(yj(getVideoUrl()));
            } else {
                this.eDH.loadUrl(getVideoUrl());
            }
            this.eoi = false;
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

    private String yj(String str) {
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
        if (this.eDH != null) {
            this.eDH.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.eoi) {
            if (i == 1) {
                this.eDH.loadUrl(yj(getVideoUrl()));
            } else {
                this.eDH.loadUrl(getVideoUrl());
            }
            this.eDH.onChangeSkinType(i);
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void iz(boolean z) {
        this.eBZ = z;
    }

    public String getVideoUrl() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beM() {
        return this.eDH.beM();
    }
}

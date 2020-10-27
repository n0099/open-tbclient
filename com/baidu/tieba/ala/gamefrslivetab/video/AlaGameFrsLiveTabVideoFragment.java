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
import com.baidu.tieba.frs.at;
import java.net.URL;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements at {
    private String forumId;
    private String forumName;
    private b gyM;
    private boolean gxe = false;
    private boolean ggt = true;
    private CustomMessageListener gjF = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 8 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        if (AlaGameFrsLiveTabVideoFragment.this.gyM != null) {
                            AlaGameFrsLiveTabVideoFragment.this.gyM.bNv();
                        }
                    } else if ("FrsGameLiveLive".equals(split[0]) && 3 == com.baidu.adp.lib.f.b.toInt(split[1], 0) && AlaGameFrsLiveTabVideoFragment.this.gyM != null) {
                        AlaGameFrsLiveTabVideoFragment.this.gyM.bNv();
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
                    AlaGameFrsLiveTabVideoFragment.this.gyM.hideLoadingView();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gjF, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gyM = new b(this.gxe);
        return this.gyM.b(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gyM.b(this);
        registerListener(this.htmlLoadMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ggt || StringUtils.isNull(this.gyM.getWebView().getUrl())) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.gyM.loadUrl(GP(getVideoUrl()));
            } else {
                this.gyM.loadUrl(getVideoUrl());
            }
            this.ggt = false;
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
        if (this.gyM != null) {
            this.gyM.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.ggt) {
            if (i == 1) {
                this.gyM.loadUrl(GP(getVideoUrl()));
            } else {
                this.gyM.loadUrl(getVideoUrl());
            }
            this.gyM.onChangeSkinType(i);
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void mf(boolean z) {
        this.gxe = z;
    }

    public String getVideoUrl() {
        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
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

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bQh() {
        return this.gyM.bQh();
    }
}

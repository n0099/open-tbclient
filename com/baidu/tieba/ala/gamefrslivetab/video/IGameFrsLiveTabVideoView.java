package com.baidu.tieba.ala.gamefrslivetab.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
/* loaded from: classes5.dex */
public interface IGameFrsLiveTabVideoView extends WebViewLifeCycle {
    View C(LayoutInflater layoutInflater, ViewGroup viewGroup);

    String getUrl();

    void h();

    void hideLoadingView();

    void loadUrl(String str);

    NavigationBar o();

    void onChangeSkinType(int i);

    void t(BaseFragment baseFragment);
}

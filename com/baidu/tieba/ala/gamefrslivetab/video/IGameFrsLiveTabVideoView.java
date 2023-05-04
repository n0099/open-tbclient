package com.baidu.tieba.ala.gamefrslivetab.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
/* loaded from: classes3.dex */
public interface IGameFrsLiveTabVideoView extends WebViewLifeCycle {
    View L(LayoutInflater layoutInflater, ViewGroup viewGroup);

    void c();

    String getUrl();

    void h();

    void loadUrl(String str);

    NavigationBar n();

    void onChangeSkinType(int i);

    void y(BaseFragment baseFragment);
}

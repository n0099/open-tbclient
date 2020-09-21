package com.baidu.tieba.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.widget.FrameLayout;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterFragment;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes24.dex */
public class TbFlutterFragment extends FlutterFragment {
    private ContinuousAnimationView loadingView;
    private TbFlutterFragmentLifeCircleInterface mLifeCycleListener;
    private long beginTime = 0;
    private long creatTime = 0;
    private long flutterStartTime = 0;
    private CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.flutter.view.TbFlutterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                TbFlutterFragment.this.getFlutterDelegate().getBoostFlutterView().showSplash(TbFlutterFragment.this.provideSplashScreen());
            }
        }
    };

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, android.support.v4.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.loadingView = new ContinuousAnimationView(getActivity());
        Resources resources = g.lh().getResources();
        ap.a(this.loadingView, resources.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
        this.loadingView.setSpeed(1.2f);
        this.loadingView.setLayoutParams(new FrameLayout.LayoutParams(resources.getDimensionPixelSize(resources.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), resources.getDimensionPixelSize(resources.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
        int identifier = resources.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
        int i = TbadkCoreApplication.getInst().getSkinType() != 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
        if (identifier == 0) {
            frameLayout.setBackgroundColor(i);
        } else {
            frameLayout.setBackgroundColor(ap.getColor(identifier));
        }
        frameLayout.addView(this.loadingView);
        return new ViewSplashScreen(frameLayout);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        this.flutterStartTime = System.currentTimeMillis();
        if (this.loadingView != null) {
            if (z) {
                this.loadingView.playAnimation();
            } else {
                this.loadingView.cancelAnimation();
            }
        }
        super.setUserVisibleHint(z);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.flutterStartTime = System.currentTimeMillis();
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        super.onCreate(bundle);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public Map getContainerUrlParams() {
        Map<String, Object> map = ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("isShowWhenCreate", Boolean.valueOf(isPrimary()));
        map.put("native_view_cost", Long.valueOf(this.creatTime));
        map.put("native_start_time", Long.valueOf(this.beginTime));
        map.put("flutter_start_time", Long.valueOf(this.flutterStartTime));
        return map;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.mLifeCycleListener != null) {
            this.mLifeCycleListener.onPrimary();
        }
    }

    public final void setOnPrimaryListener(TbFlutterFragmentLifeCircleInterface tbFlutterFragmentLifeCircleInterface) {
        this.mLifeCycleListener = tbFlutterFragmentLifeCircleInterface;
    }
}

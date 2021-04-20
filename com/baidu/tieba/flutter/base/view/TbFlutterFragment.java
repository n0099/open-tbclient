package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterFragment;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import d.b.c.a.h;
import io.flutter.embedding.android.SplashScreen;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class TbFlutterFragment extends FlutterFragment {
    public ContinuousAnimationView loadingView;
    public TbFlutterFragmentLifeCircleInterface mLifeCycleListener;
    public long beginTime = 0;
    public long creatTime = 0;
    public long flutterStartTime = 0;
    public long removeDelay = 0;
    public boolean autoPlayWhenInit = false;
    public CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.flutter.base.view.TbFlutterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304) {
                return;
            }
            TbFlutterFragment.this.getFlutterDelegate().getBoostFlutterView().showSplash(TbFlutterFragment.this.provideSplashScreen());
        }
    };

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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.creatTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbFlutterFragmentLifeCircleInterface tbFlutterFragmentLifeCircleInterface = this.mLifeCycleListener;
        if (tbFlutterFragmentLifeCircleInterface != null) {
            tbFlutterFragmentLifeCircleInterface.onPrimary();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (this.removeDelay != 0 && getFlutterDelegate() != null && getFlutterDelegate().getBoostFlutterView() != null) {
            getFlutterDelegate().getBoostFlutterView().removeSplashDelay(this.removeDelay);
            this.removeDelay = 0L;
        }
        this.flutterStartTime = System.currentTimeMillis();
        super.onResume();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.loadingView = new ContinuousAnimationView(getActivity());
        Resources b2 = h.a().b();
        SkinManager.setLottieAnimation(this.loadingView, b2.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
        this.loadingView.setSpeed(1.2f);
        this.loadingView.setLayoutParams(new FrameLayout.LayoutParams(b2.getDimensionPixelSize(b2.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), b2.getDimensionPixelSize(b2.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
        int identifier = b2.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
        int i = TbadkCoreApplication.getInst().getSkinType() != 0 ? -16777216 : -1;
        if (identifier == 0) {
            frameLayout.setBackgroundColor(i);
        } else {
            frameLayout.setBackgroundColor(SkinManager.getColor(identifier));
        }
        frameLayout.addView(this.loadingView);
        if (this.autoPlayWhenInit) {
            this.loadingView.playAnimation();
            this.autoPlayWhenInit = false;
        }
        return new ViewSplashScreen(frameLayout);
    }

    public void removeSplashDelay(long j) {
        this.removeDelay = j;
    }

    public void setAutoPlayWhenInit(boolean z) {
        this.autoPlayWhenInit = z;
    }

    public final void setOnPrimaryListener(TbFlutterFragmentLifeCircleInterface tbFlutterFragmentLifeCircleInterface) {
        this.mLifeCycleListener = tbFlutterFragmentLifeCircleInterface;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        this.flutterStartTime = System.currentTimeMillis();
        ContinuousAnimationView continuousAnimationView = this.loadingView;
        if (continuousAnimationView != null) {
            if (z) {
                continuousAnimationView.playAnimation();
            } else {
                continuousAnimationView.cancelAnimation();
            }
        }
        super.setUserVisibleHint(z);
    }
}

package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingWindowController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.switchs.FlutterAttachSwitch;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.compatible.menukey.MenuKeyUtils;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import d.a.c.a.g;
import d.a.c.a.h;
import d.a.c.e.p.l;
import d.a.i0.a.r;
import d.a.i0.k0.a;
import d.a.i0.k0.b;
import d.a.i0.k0.d;
import d.a.i0.k0.e;
import d.a.i0.r.c;
import io.flutter.embedding.android.SplashScreen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FlutterPageActivity<T> extends BoostFlutterActivity implements TbPageContextSupport, a, g<T> {
    public static int flog = 1;
    public static Class<? extends TbPageContext> mClazz4GetPageContext = FlutterActivityPageContext.class;
    public long lastResumeTime;
    public d.a.i0.r.a mLayoutInflateFactory;
    public c mLayoutMode;
    public SwipeBackLayout mSwipeBackLayout;
    public TbPageContext<T> pageContext;
    public d pageStayDurationItem;
    public BdUniqueId mId = null;
    public int animationType = 1;
    public boolean isAddSwipeBackLayout = true;
    public boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    public long creatTime = 0;
    public long startTime = 0;
    public long flutterStartTime = 0;
    public final String[] ADJUST_PAN_PAGES = {"GameItemDetailsPage", "ItemRecommendList"};
    public CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.flutter.base.view.FlutterPageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FlutterActivityAndFragmentDelegate flutterDelegate;
            FlutterSplashView boostFlutterView;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || FlutterAttachSwitch.isOn() || (flutterDelegate = FlutterPageActivity.this.getFlutterDelegate()) == null || (boostFlutterView = flutterDelegate.getBoostFlutterView()) == null) {
                return;
            }
            boostFlutterView.showSplash(FlutterPageActivity.this.provideSplashScreen());
        }
    };

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), this.animationType);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        r.a(motionEvent, getPageId(), 0L);
        d.a.j0.i3.a.getInstance().behaviorRecordEvent(motionEvent, this);
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), this.animationType);
    }

    @Override // android.app.Activity
    public void finish() {
        l.x(getApplicationContext(), getWindow().getDecorView());
        super.finish();
        closeAnimation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public Map getContainerUrlParams() {
        Map<String, Object> hashMap = new HashMap<>();
        if (getIntent().hasExtra("params")) {
            hashMap = ((BoostFlutterActivity.SerializableMap) getIntent().getSerializableExtra("params")).getMap();
        }
        hashMap.put("native_view_cost", Long.valueOf(this.creatTime));
        hashMap.put("native_start_time", Long.valueOf(this.startTime));
        hashMap.put("flutter_start_time", Long.valueOf(this.flutterStartTime));
        hashMap.put("sorce_key_list", d.a.i0.k0.c.a(getCurrentPageSourceKeyList()));
        return hashMap;
    }

    @Override // d.a.i0.k0.a
    public String getCurrentPageKey() {
        return getContainerUrl();
    }

    @Override // d.a.i0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getStringArrayListExtra("obj_source");
        }
        return null;
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    @Override // d.a.i0.k0.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.addAll(arrayList2);
        }
        if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
            if (!StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            return arrayList;
        }
        return arrayList;
    }

    public int getPageId() {
        BdUniqueId uniqueId = getUniqueId();
        if (uniqueId != null) {
            return uniqueId.getId();
        }
        return 0;
    }

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new d();
        }
        return this.pageStayDurationItem;
    }

    @Override // d.a.i0.k0.a
    public b getPageStayFilter() {
        return new b() { // from class: com.baidu.tieba.flutter.base.view.FlutterPageActivity.2
            @Override // d.a.i0.k0.b
            public boolean canStat(d dVar) {
                return false;
            }

            @Override // d.a.i0.k0.b
            public int getMaxCost() {
                return e.b().c();
            }

            @Override // d.a.i0.k0.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }
        };
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources b2 = h.a().b();
        return (b2 == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : b2;
    }

    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    public void hideFloatingWindow() {
        KuangFloatingWindowController.getInstance().hideFloatingView();
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.startTime = System.currentTimeMillis();
        boolean z = true;
        if (!getIntent().getBooleanExtra("animated", true)) {
            this.animationType = 0;
        }
        String stringExtra = getIntent().getStringExtra("url");
        String[] strArr = this.ADJUST_PAN_PAGES;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (strArr[i2].equals(stringExtra) && Build.VERSION.SDK_INT >= 3) {
                    getWindow().setSoftInputMode(32);
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        boolean booleanExtra = getIntent().getBooleanExtra("swipeback", true);
        this.isAddSwipeBackLayout = booleanExtra;
        if (booleanExtra) {
            SwipeBackLayout swipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout = swipeBackLayout;
            swipeBackLayout.a(getPageContext().getPageActivity());
            this.mSwipeBackLayout.l(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        super.onCreate(bundle);
        this.mId = BdUniqueId.gen();
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkCoreApplication.getInst().setExitAppCloseWebSocket(false);
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        this.mLayoutMode = new c();
        d.a.i0.r.a aVar = new d.a.i0.r.a();
        this.mLayoutInflateFactory = aVar;
        aVar.a(this.mLayoutMode);
        TbadkCoreApplication.setIsAppRunning(true);
        TiebaStaticHelper.setCurrentActivity(FlutterPageActivity.class.getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        d.a.c.a.b.f().n(getPageContext().getPageActivity());
        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
            z = false;
        }
        UtilHelper.changeStatusBarIconAndTextColor(z, this);
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.creatTime = System.currentTimeMillis() - this.startTime;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onDestroy() {
        c cVar = this.mLayoutMode;
        if (cVar != null) {
            cVar.c();
        }
        MessageManager.getInstance().unRegisterListener(this.skinTypeChangeListener);
        super.onDestroy();
        d.a.c.a.b.f().l(getPageContext().getPageActivity());
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onPause() {
        d.a.j0.i3.a.getInstance().onPause(this);
        super.onPause();
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            hideFloatingWindow();
        }
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.v(currentTimeMillis);
            e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, null);
        }
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        flog = 0;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        this.flutterStartTime = System.currentTimeMillis();
        TbadkCoreApplication.getInst().AddResumeNum();
        super.onResume();
        d.a.j0.i3.a.getInstance().onResume(this);
        this.lastResumeTime = System.currentTimeMillis();
        TiebaStaticHelper.setCurrentActivity(FlutterPageActivity.class.getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        TbadkCoreApplication.isLogin();
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
        }
        TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        r.h(getPageId(), 0L);
        TbSingleton.getInstance().getClass();
        if (!"FlutterPageActivity".equals(TbSingleton.getInstance().isSwitchActivity)) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            TbSingleton.getInstance().getClass();
            tbSingleton.isSwitchActivity = "FlutterPageActivity";
            flog = 0;
        }
        if (this == TbadkCoreApplication.getInst().getCurrentActivity() && TbSingleton.getInstance().isShowBackLabel && KuangFloatingWindowController.getInstance().init() && flog == 0) {
            showFloatingWindow();
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        flog = 0;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            flog = 1;
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Resources b2 = h.a().b();
        if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.transparent) {
            frameLayout.setBackgroundColor(0);
        } else {
            int identifier = b2.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
            int i2 = TbadkCoreApplication.getInst().getSkinType() != 0 ? -16777216 : -1;
            if (identifier == 0) {
                frameLayout.setBackgroundColor(i2);
            } else {
                frameLayout.setBackgroundColor(SkinManager.getColor(identifier));
            }
        }
        if (getIntent() == null || getIntent().getBooleanExtra("showloading", true)) {
            ContinuousAnimationView continuousAnimationView = new ContinuousAnimationView(getActivity());
            SkinManager.setLottieAnimation(continuousAnimationView, b2.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
            continuousAnimationView.setSpeed(1.2f);
            continuousAnimationView.setLayoutParams(new FrameLayout.LayoutParams(b2.getDimensionPixelSize(b2.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), b2.getDimensionPixelSize(b2.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
            frameLayout.addView(continuousAnimationView);
            continuousAnimationView.playAnimation();
        }
        return new ViewSplashScreen(frameLayout);
    }

    public void registerListener(d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void sendMessage(Message<?> message) {
        if (message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
        this.mSwipeBackLayout.setSwipeBackEnabled(z);
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public void showFloatingWindow() {
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        if (KuangFloatingWindowController.getInstance().init()) {
            TbSingleton.getInstance().isShowBackLabel = true;
            KuangFloatingWindowController.getInstance().showFloatingView();
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d2) {
        this.mSwipeBackLayout.r(d2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.TbPageContextSupport, d.a.c.a.g
    public TbPageContext<T> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(FlutterPageActivity.class).newInstance(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.pageContext;
    }

    public void registerListener(int i2, d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, aVar);
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, messageListener);
    }
}

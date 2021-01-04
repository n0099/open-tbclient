package com.baidu.tieba.flutter.view;

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
import androidx.core.view.ViewCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.b;
import com.baidu.adp.base.g;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.r;
import com.baidu.tbadk.KuangFloatingWindowController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.m.a;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.switchs.FlutterAttachSwitch;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.compatible.menukey.MenuKeyUtils;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class FlutterPageActivity<T> extends BoostFlutterActivity implements g<T>, TbPageContextSupport, a {
    private long lastResumeTime;
    private com.baidu.tbadk.core.a mLayoutInflateFactory;
    private c mLayoutMode;
    protected SwipeBackLayout mSwipeBackLayout;
    private TbPageContext<T> pageContext;
    private d pageStayDurationItem;
    private static Class<? extends TbPageContext> mClazz4GetPageContext = FlutterActivityPageContext.class;
    private static int flog = 1;
    private BdUniqueId mId = null;
    private int animationType = 1;
    private boolean isAddSwipeBackLayout = true;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    private long creatTime = 0;
    private long startTime = 0;
    private long flutterStartTime = 0;
    private final String[] ADJUST_PAN_PAGES = {"GameItemDetailsPage", "ItemRecommendList"};
    private CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.flutter.view.FlutterPageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FlutterActivityAndFragmentDelegate flutterDelegate;
            FlutterSplashView boostFlutterView;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && !FlutterAttachSwitch.isOn() && (flutterDelegate = FlutterPageActivity.this.getFlutterDelegate()) != null && (boostFlutterView = flutterDelegate.getBoostFlutterView()) != null) {
                boostFlutterView.showSplash(FlutterPageActivity.this.provideSplashScreen());
            }
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.g
    public TbPageContext<T> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(FlutterPageActivity.class).newInstance(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.pageContext;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = h.kE().getResources();
        return (resources == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : resources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        this.startTime = System.currentTimeMillis();
        if (!getIntent().getBooleanExtra("animated", true)) {
            this.animationType = 0;
        }
        String stringExtra = getIntent().getStringExtra("url");
        String[] strArr = this.ADJUST_PAN_PAGES;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (!strArr[i].equals(stringExtra) || Build.VERSION.SDK_INT < 3) {
                    i++;
                } else {
                    getWindow().setSoftInputMode(32);
                    break;
                }
            } else {
                break;
            }
        }
        this.isAddSwipeBackLayout = getIntent().getBooleanExtra("swipeback", true);
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout.attachToActivity(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        super.onCreate(bundle);
        this.mId = BdUniqueId.gen();
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkCoreApplication.getInst().setExitAppCloseWebSocket(false);
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, false);
            BdSocketLinkService.startService(false, "app start");
        }
        this.mLayoutMode = new c();
        this.mLayoutInflateFactory = new com.baidu.tbadk.core.a();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        TbadkCoreApplication.setIsAppRunning(true);
        bc.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        b.kC().pushActivity(getPageContext().getPageActivity());
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            z = true;
        }
        UtilHelper.changeStatusBarIconAndTextColor(z, this);
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.creatTime = System.currentTimeMillis() - this.startTime;
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), this.animationType);
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), this.animationType);
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Resources resources = h.kE().getResources();
        if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.transparent) {
            frameLayout.setBackgroundColor(0);
        } else {
            int identifier = resources.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
            int i = TbadkCoreApplication.getInst().getSkinType() != 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
            if (identifier == 0) {
                frameLayout.setBackgroundColor(i);
            } else {
                frameLayout.setBackgroundColor(ao.getColor(identifier));
            }
        }
        if (getIntent() == null || getIntent().getBooleanExtra("showloading", true)) {
            ContinuousAnimationView continuousAnimationView = new ContinuousAnimationView(getActivity());
            ao.a(continuousAnimationView, resources.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
            continuousAnimationView.setSpeed(1.2f);
            continuousAnimationView.setLayoutParams(new FrameLayout.LayoutParams(resources.getDimensionPixelSize(resources.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), resources.getDimensionPixelSize(resources.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
            frameLayout.addView(continuousAnimationView);
            continuousAnimationView.playAnimation();
        }
        return new ViewSplashScreen(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        flog = 0;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        flog = 0;
    }

    @Override // android.app.Activity
    public void finish() {
        l.hideSoftKeyPad(getApplicationContext(), getWindow().getDecorView());
        super.finish();
        closeAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        this.flutterStartTime = System.currentTimeMillis();
        super.onResume();
        com.baidu.tieba.t.a.getInstance().onResume(this);
        this.lastResumeTime = System.currentTimeMillis();
        TbadkCoreApplication.getInst().AddResumeNum();
        bc.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        TbadkCoreApplication.isLogin();
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND, this));
        }
        TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        r.n(getPageId(), 0L);
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

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onPause() {
        com.baidu.tieba.t.a.getInstance().onPause(this);
        super.onPause();
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            hideFloatingWindow();
        }
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bHs().a(getPageContext().getPageActivity(), pageStayDurationItem, null);
        }
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND, this));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        r.a(motionEvent, getPageId(), 0L);
        com.baidu.tieba.t.a.getInstance().behaviorRecordEvent(motionEvent, this);
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            flog = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        MessageManager.getInstance().unRegisterListener(this.skinTypeChangeListener);
        super.onDestroy();
        b.kC().popActivity(getPageContext().getPageActivity());
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
        hashMap.put("sorce_key_list", com.baidu.tbadk.m.c.toSourceTraceString(getCurrentPageSourceKeyList()));
        return hashMap;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
        this.mSwipeBackLayout.setSwipeBackEnabled(z);
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d) {
        this.mSwipeBackLayout.swipeBackControl(d);
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return getContainerUrl();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("obj_source");
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (x.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new d();
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.flutter.view.FlutterPageActivity.2
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return e.bHs().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(d dVar) {
                return false;
            }
        };
    }

    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    public int getPageId() {
        BdUniqueId uniqueId = getUniqueId();
        if (uniqueId != null) {
            return uniqueId.getId();
        }
        return 0;
    }

    public void sendMessage(Message<?> message) {
        if (message != null) {
            if (message.getTag() == null) {
                message.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void registerListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public void showFloatingWindow() {
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        if (KuangFloatingWindowController.getInstance().init()) {
            TbSingleton.getInstance().isShowBackLabel = true;
            KuangFloatingWindowController.getInstance().showFloatingView();
        }
    }

    public void hideFloatingWindow() {
        KuangFloatingWindowController.getInstance().hideFloatingView();
    }
}

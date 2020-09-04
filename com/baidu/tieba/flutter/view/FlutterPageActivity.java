package com.baidu.tieba.flutter.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.compatible.menukey.MenuKeyUtils;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class FlutterPageActivity<T> extends BoostFlutterActivity implements TbPageContextSupport {
    private static Class<? extends TbPageContext> mClazz4GetPageContext = FlutterActivityPageContext.class;
    private long lastResumeTime;
    private a mLayoutInflateFactory;
    private c mLayoutMode;
    protected SwipeBackLayout mSwipeBackLayout;
    private TbPageContext<T> pageContext;
    private d pageStayDurationItem;
    private BdUniqueId mId = null;
    private int animationType = 1;
    private boolean isAddSwipeBackLayout = true;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    private long creatTime = 0;
    private long startTime = 0;
    private long flutterStartTime = 0;

    @Override // com.baidu.tbadk.TbPageContextSupport
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
        Resources resources = g.ld().getResources();
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
        this.mLayoutInflateFactory = new a();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        TbadkCoreApplication.setIsAppRunning(true);
        bc.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        com.baidu.adp.base.a.lb().pushActivity(getPageContext().getPageActivity());
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            z = true;
        }
        UtilHelper.changeStatusBarIconAndTextColor(z, this);
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
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
        Resources resources = g.ld().getResources();
        if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.transparent) {
            frameLayout.setBackgroundColor(0);
        } else {
            int identifier = resources.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
            int i = TbadkCoreApplication.getInst().getSkinType() != 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
            if (identifier == 0) {
                frameLayout.setBackgroundColor(i);
            } else {
                frameLayout.setBackgroundColor(ap.getColor(identifier));
            }
        }
        if (getIntent() == null || getIntent().getBooleanExtra("showloading", true)) {
            ContinuousAnimationView continuousAnimationView = new ContinuousAnimationView(getActivity());
            ap.a(continuousAnimationView, resources.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
            continuousAnimationView.setSpeed(1.2f);
            continuousAnimationView.setLayoutParams(new FrameLayout.LayoutParams(resources.getDimensionPixelSize(resources.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), resources.getDimensionPixelSize(resources.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
            frameLayout.addView(continuousAnimationView);
            continuousAnimationView.playAnimation();
        }
        return new ViewSplashScreen(frameLayout);
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
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bua().a(getPageContext().getPageActivity(), pageStayDurationItem, null);
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
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        super.onDestroy();
        com.baidu.adp.base.a.lb().popActivity(getPageContext().getPageActivity());
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

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new d();
        }
        return this.pageStayDurationItem;
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
}

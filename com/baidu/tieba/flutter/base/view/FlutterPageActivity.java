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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.g;
import c.a.d.a.h;
import c.a.d.f.p.m;
import c.a.r0.a.s;
import c.a.r0.p0.a;
import c.a.r0.p0.b;
import c.a.r0.p0.d;
import c.a.r0.p0.e;
import c.a.r0.s.c;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.IPermissionPolicy;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.switchs.FlutterAttachSwitch;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.flutter.base.view.splash.ViewSplashScreen;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.embedding.android.SplashScreen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class FlutterPageActivity<T> extends BoostFlutterActivity implements TbPageContextSupport, a, g<T>, IPermissionPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_ANIMATED = "animated";
    public static final String EXTRA_SHOW_LOADING = "showloading";
    public static final String EXTRA_SWIPEBACK = "swipeback";
    public static int flog = 1;
    public static Class<? extends TbPageContext> mClazz4GetPageContext;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] ADJUST_PAN_PAGES;
    public int animationType;
    public long creatTime;
    public String flutterPageName;
    public long flutterStartTime;
    public boolean isAddSwipeBackLayout;
    public long lastResumeTime;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public BdUniqueId mId;
    public c.a.r0.s.a mLayoutInflateFactory;
    public c mLayoutMode;
    public SwipeBackLayout mSwipeBackLayout;
    public boolean mUseStyleImmersiveSticky;
    public TbPageContext<T> pageContext;
    public d pageStayDurationItem;
    public CustomMessageListener removeFlutterPageListener;
    public CustomMessageListener skinTypeChangeListener;
    public long startTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1322148434, "Lcom/baidu/tieba/flutter/base/view/FlutterPageActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1322148434, "Lcom/baidu/tieba/flutter/base/view/FlutterPageActivity;");
                return;
            }
        }
        mClazz4GetPageContext = FlutterActivityPageContext.class;
    }

    public FlutterPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mId = null;
        this.animationType = 1;
        this.isAddSwipeBackLayout = true;
        this.mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        this.creatTime = 0L;
        this.startTime = 0L;
        this.flutterStartTime = 0L;
        this.ADJUST_PAN_PAGES = new String[]{"GameItemDetailsPage", "ItemRecommendList"};
        this.mCurrentPermissionJudgePolicy = null;
        this.skinTypeChangeListener = new CustomMessageListener(this, 2001304) { // from class: com.baidu.tieba.flutter.base.view.FlutterPageActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterPageActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            @RequiresApi(api = 19)
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                IFlutterViewContainer iFlutterViewContainer;
                FlutterSplashView boostFlutterView;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || FlutterAttachSwitch.isOn() || (iFlutterViewContainer = this.this$0.getIFlutterViewContainer()) == null || (boostFlutterView = iFlutterViewContainer.getBoostFlutterView()) == null) {
                    return;
                }
                boostFlutterView.showSplash(this.this$0.provideSplashScreen());
            }
        };
        this.removeFlutterPageListener = new CustomMessageListener(this, 2002016) { // from class: com.baidu.tieba.flutter.base.view.FlutterPageActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterPageActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2002016 && !FlutterAttachSwitch.isOn() && (customResponsedMessage.getData() instanceof Map)) {
                    Map map = (Map) customResponsedMessage.getData();
                    if (map.isEmpty() || (str = (String) map.get("name")) == null || !str.equals(this.this$0.flutterPageName)) {
                        return;
                    }
                    this.this$0.finish();
                }
            }
        };
    }

    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), this.animationType);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, display)) == null) ? super.createDisplayContext(display) : (Context) invokeL.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            s.a(motionEvent, getPageId(), 0L);
            c.a.s0.a4.a.getInstance().behaviorRecordEvent(motionEvent, this);
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), this.animationType);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            m.w(getApplicationContext(), getWindow().getDecorView());
            super.finish();
            closeAnimation();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public Map getContainerUrlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Map<String, Object> hashMap = new HashMap<>();
            if (getIntent().hasExtra("params")) {
                hashMap = ((BoostFlutterActivity.SerializableMap) getIntent().getSerializableExtra("params")).getMap();
            }
            hashMap.put("native_view_cost", Long.valueOf(this.creatTime));
            hashMap.put("native_start_time", Long.valueOf(this.startTime));
            hashMap.put("flutter_start_time", Long.valueOf(this.flutterStartTime));
            hashMap.put("sorce_key_list", c.a.r0.p0.c.a(getCurrentPageSourceKeyList()));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.r0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getContainerUrl() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.p0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                return intent.getStringArrayListExtra("obj_source");
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public c getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLayoutMode : (c) invokeV.objValue;
    }

    @Override // c.a.r0.p0.a
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    public int getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                return uniqueId.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.pageStayDurationItem == null) {
                this.pageStayDurationItem = new d();
            }
            return this.pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // c.a.r0.p0.a
    public b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new b(this) { // from class: com.baidu.tieba.flutter.base.view.FlutterPageActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterPageActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.r0.p0.b
            public boolean canStat(d dVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, dVar)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // c.a.r0.p0.b
            public int getMaxCost() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e.b().c() : invokeV2.intValue;
            }

            @Override // c.a.r0.p0.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV2.booleanValue;
            }
        } : (b) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Resources resources = h.a().getResources();
            return (resources == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : resources;
        }
        return (Resources) invokeV.objValue;
    }

    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mId : (BdUniqueId) invokeV.objValue;
    }

    public void hideFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            KuangFloatingWindowController.getInstance().hideFloatingView();
        }
    }

    public boolean isUseStyleImmersiveSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mUseStyleImmersiveSticky : invokeV.booleanValue;
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (c.a.r0.e1.a.c(i2, i3, intent)) {
            }
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            this.startTime = System.currentTimeMillis();
            boolean z = true;
            if (!getIntent().getBooleanExtra("animated", true)) {
                this.animationType = 0;
            }
            c.a.d.a.a.b(this);
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
            this.flutterPageName = stringExtra;
            boolean booleanExtra = getIntent().getBooleanExtra("swipeback", true);
            this.isAddSwipeBackLayout = booleanExtra;
            if (booleanExtra) {
                SwipeBackLayout swipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
                this.mSwipeBackLayout = swipeBackLayout;
                swipeBackLayout.attachToActivity(getPageContext().getPageActivity());
                this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
            c.a.r0.s.a aVar = new c.a.r0.s.a();
            this.mLayoutInflateFactory = aVar;
            aVar.a(this.mLayoutMode);
            TbadkCoreApplication.setIsAppRunning(true);
            TiebaStaticHelper.setCurrentActivity(FlutterPageActivity.class.getName());
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            c.a.d.a.b.g().o(getPageContext().getPageActivity());
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            UtilHelper.changeStatusBarIconAndTextColor(z, this);
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
            MessageManager.getInstance().registerListener(this.removeFlutterPageListener);
            enterExitAnimation();
            this.creatTime = System.currentTimeMillis() - this.startTime;
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c cVar = this.mLayoutMode;
            if (cVar != null) {
                cVar.c();
            }
            MessageManager.getInstance().unRegisterListener(this.skinTypeChangeListener);
            MessageManager.getInstance().unRegisterListener(this.removeFlutterPageListener);
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            super.onDestroy();
            c.a.d.a.b.g().m(getPageContext().getPageActivity());
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.s0.a4.a.getInstance().onPause(this);
            super.onPause();
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, null);
            }
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        PermissionJudgePolicy permissionJudgePolicy2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean z = false;
            if (iArr[0] != 0 && (permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy) != null) {
                permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
            }
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i3] != 0) {
                    break;
                } else {
                    i3++;
                }
            }
            if (!z || (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) == null) {
                return;
            }
            permissionJudgePolicy.onPermissionsGranted();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onRestart();
            flog = 0;
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            this.flutterStartTime = System.currentTimeMillis();
            TbadkCoreApplication.getInst().AddResumeNum();
            super.onResume();
            c.a.s0.a4.a.getInstance().onResume(this);
            this.lastResumeTime = System.currentTimeMillis();
            TiebaStaticHelper.setCurrentActivity(FlutterPageActivity.class.getName());
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            TbadkCoreApplication.isLogin();
            if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
            }
            TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
            s.h(getPageId(), 0L);
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
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStart();
            flog = 0;
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Resources resources = h.a().getResources();
            if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.transparent) {
                frameLayout.setBackgroundColor(0);
            } else {
                int identifier = resources.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
                int i2 = TbadkCoreApplication.getInst().getSkinType() != 0 ? -16777216 : -1;
                if (identifier == 0) {
                    frameLayout.setBackgroundColor(i2);
                } else {
                    frameLayout.setBackgroundColor(SkinManager.getColor(identifier));
                }
            }
            if (getIntent() == null || getIntent().getBooleanExtra("showloading", true)) {
                ContinuousAnimationView continuousAnimationView = new ContinuousAnimationView(getActivity());
                SkinManager.setLottieAnimation(continuousAnimationView, resources.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
                continuousAnimationView.setSpeed(1.2f);
                continuousAnimationView.setLayoutParams(new FrameLayout.LayoutParams(resources.getDimensionPixelSize(resources.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), resources.getDimensionPixelSize(resources.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
                frameLayout.addView(continuousAnimationView);
                continuousAnimationView.playAnimation();
            }
            return new ViewSplashScreen(frameLayout);
        }
        return (SplashScreen) invokeV.objValue;
    }

    public void registerListener(c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    @Override // com.baidu.tbadk.IPermissionPolicy
    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setLayoutMode(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, cVar) == null) {
            this.mLayoutMode = cVar;
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (c.a.d.a.a.d(this) && c.a.d.a.a.a(i2)) {
                return;
            }
            super.setRequestedOrientation(i2);
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mSwipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public void showFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            if (KuangFloatingWindowController.getInstance().init()) {
                TbSingleton.getInstance().isShowBackLabel = true;
                KuangFloatingWindowController.getInstance().showFloatingView();
            }
        }
    }

    @Override // com.idlefish.flutterboost.containers.BoostFlutterActivity, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mSwipeBackLayout.swipeBackControl(d2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.TbPageContextSupport, c.a.d.a.g
    public TbPageContext<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                if (this.pageContext == null && mClazz4GetPageContext != null) {
                    this.pageContext = mClazz4GetPageContext.getConstructor(FlutterPageActivity.class).newInstance(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void registerListener(int i2, c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i2, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, aVar);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i2, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, messageListener);
        }
    }
}

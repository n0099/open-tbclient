package com.baidu.tieba.flutter.base.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.flutter.base.util.OpenNative;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class FlutterBoostExtender {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DART_INIT_FINISH = "dataInitFinish";
    public static final String PAGE_LIFE_CYCLE = "pageLifeCycle";
    public static FlutterBoostExtender sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final FlutterBoostPlugin.EventListener splashEventListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1688425184, "Lcom/baidu/tieba/flutter/base/view/FlutterBoostExtender;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1688425184, "Lcom/baidu/tieba/flutter/base/view/FlutterBoostExtender;");
        }
    }

    public FlutterBoostExtender() {
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
        this.splashEventListener = new FlutterBoostPlugin.EventListener(this) { // from class: com.baidu.tieba.flutter.base.view.FlutterBoostExtender.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterBoostExtender this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, map) == null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -263576197) {
                        if (hashCode == -253456115 && str.equals(FlutterBoostExtender.DART_INIT_FINISH)) {
                            c2 = 0;
                        }
                        c2 = 65535;
                    } else {
                        if (str.equals(FlutterBoostExtender.PAGE_LIFE_CYCLE)) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    }
                    if (c2 == 0) {
                        FlutterBoost.instance().isCustomDartInitFinish = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921459));
                    } else if (c2 != 1) {
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921478, map));
                    }
                }
            }
        };
    }

    public static FlutterBoostExtender instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new FlutterBoostExtender();
            }
            return sInstance;
        }
        return (FlutterBoostExtender) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FlutterSplashView.isNeedCustomDartInitFinish = true;
            FlutterBoost.instance().isCustomDartInitFinish = true;
            FlutterBoost.instance().channel().addEventListener(DART_INIT_FINISH, this.splashEventListener);
            FlutterBoost.instance().channel().addEventListener(PAGE_LIFE_CYCLE, this.splashEventListener);
            FlutterBoost.instance().channel().setParseNativeResult(new FlutterBoostPlugin.ParseNativeResult(this) { // from class: com.baidu.tieba.flutter.base.view.FlutterBoostExtender.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterBoostExtender this$0;

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

                @Override // com.idlefish.flutterboost.FlutterBoostPlugin.ParseNativeResult
                public Map<String, Object> parseResult(String str, Map<String, Object> map) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, map)) == null) {
                        HashMap hashMap = new HashMap();
                        if (str.contains(OpenNative.kNativePageKeyEditProfile)) {
                            if (map.containsKey("data") && (map.get("data") instanceof PersonChangeData)) {
                                hashMap.put("intro", ((PersonChangeData) map.get("data")).getIntro());
                            }
                            return hashMap;
                        } else if (str.contains(OpenNative.kNativePageKeyItemEvaluatePage)) {
                            if (map.containsKey("post_write_callback_data") && (map.get("post_write_callback_data") instanceof PostWriteCallBackData)) {
                                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) map.get("post_write_callback_data");
                                hashMap.put("errorCode", Integer.valueOf(postWriteCallBackData.getErrorCode()));
                                hashMap.put("errorMsg", postWriteCallBackData.getErrorString());
                            }
                            return hashMap;
                        } else {
                            return map;
                        }
                    }
                    return (Map) invokeLL.objValue;
                }
            });
        }
    }
}

package com.baidu.tieba.flutter.plugin.tiebautility.android;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class UtilityNotification implements TiebaUtilityNotificationAuto.HostUtilityNotification {
    public static /* synthetic */ Interceptable $ic;
    public static NativeListeners mNativeListeners;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(171384571, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/UtilityNotification;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(171384571, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/UtilityNotification;");
                return;
            }
        }
        mNativeListeners = new NativeListeners();
    }

    public UtilityNotification(TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterUtilityNotification};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        mNativeListeners.addFlutterNotification(flutterUtilityNotification);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void addNotificationObserver(TiebaUtilityNotificationAuto.ObserverName observerName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observerName) == null) {
            mNativeListeners.addNotificationObserver(observerName.getResult());
        }
    }

    public void notifyFlutter(String str, HashMap hashMap, HashMap hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap, hashMap2) == null) {
            mNativeListeners.notifyFlutter(str, hashMap, hashMap2);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void postNotification(TiebaUtilityNotificationAuto.PostNotifyParam postNotifyParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postNotifyParam) == null) {
            mNativeListeners.postNotification(postNotifyParam.getNotificationName(), postNotifyParam.getPayload());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto.HostUtilityNotification
    public void removeNotificationObserver(TiebaUtilityNotificationAuto.ObserverName observerName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, observerName) == null) {
            mNativeListeners.removeNotificationObserver(observerName.getResult());
        }
    }
}

package com.baidu.tieba.flutter.plugin.commonPlatformView;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.e3.a;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonPlatformView implements PlatformView, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CommonPlatformView";
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mSelectForumCategoryListener;
    public a mSquareDelegate;
    public View mainView;
    public final MethodChannel methodChannel;
    public String persistentViewId;
    public int viewId;

    @TargetApi(17)
    public CommonPlatformView(Context context, BinaryMessenger binaryMessenger, int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, binaryMessenger, Integer.valueOf(i2), map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.persistentViewId = "-1";
        this.mSelectForumCategoryListener = new CustomMessageListener(this, 2921541) { // from class: com.baidu.tieba.flutter.plugin.commonPlatformView.CommonPlatformView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonPlatformView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921541 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (this.this$0.mSquareDelegate == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.this$0.mSquareDelegate.n(str);
                }
            }
        };
        creatMainView(context, map);
        this.viewId = i2;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "common_platform_view_" + this.persistentViewId);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    private void creatMainView(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, this, context, map) == null) && map != null && (map instanceof Map)) {
            Object obj = map.get("x");
            if (obj != null) {
                Double.valueOf(obj.toString()).doubleValue();
            }
            Object obj2 = map.get("y");
            if (obj2 != null) {
                Double.valueOf(obj2.toString()).doubleValue();
            }
            Object obj3 = map.get("width");
            if (obj3 != null) {
                Double.valueOf(obj3.toString()).doubleValue();
            }
            Object obj4 = map.get("height");
            if (obj4 != null) {
                Double.valueOf(obj4.toString()).doubleValue();
            }
            this.persistentViewId = String.valueOf(map.get("persistentViewId"));
            if ("BarSquare".equals(String.valueOf(map.get("nativeViewType")))) {
                a aVar = new a(TbadkApplication.getInst().getCurrentActivity(), ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext());
                this.mSquareDelegate = aVar;
                aVar.g();
                this.mSquareDelegate.o();
                this.mainView = this.mSquareDelegate.f56447d.d();
            }
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d(TAG, "dispose() called");
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mainView : (View) invokeV.objValue;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            MessageManager.getInstance().registerListener(this.mSelectForumCategoryListener);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mSelectForumCategoryListener);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, methodCall, result) == null) {
            if (methodCall.method.equals("getPlatformVersion")) {
                result.success("Android " + Build.VERSION.RELEASE);
            } else if (methodCall.method.equals("removePlatformView")) {
                CommonPlatformViewFactory.removePlatformViewByPersistentViewId(this.viewId);
                result.success(Boolean.TRUE);
            } else if (methodCall.method.equals("selectForumCategory")) {
                String str = (String) methodCall.arguments;
                if (this.mSquareDelegate != null && !TextUtils.isEmpty(str)) {
                    this.mSquareDelegate.n(str);
                }
                result.success(null);
            } else {
                result.notImplemented();
            }
        }
    }
}

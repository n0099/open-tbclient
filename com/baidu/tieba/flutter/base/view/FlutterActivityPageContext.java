package com.baidu.tieba.flutter.base.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.g.a;
import c.a.p0.s.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FlutterActivityPageContext<T> implements TbPageContext<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FlutterPageActivity<T> activity;

    public FlutterActivityPageContext(FlutterPageActivity<T> flutterPageActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterPageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.activity = flutterPageActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activity.getActivity() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.activity.getLayoutMode() : (c) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.flutter.base.view.FlutterPageActivity<T>, T] */
    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public T getOrignalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.activity : (T) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public Activity getPageActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.activity.getActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.activity.getResources() : (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public String getString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getResources().getString(i2) : (String) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.activity.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.activity.registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
            this.activity.sendMessage(message);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, animatable) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, view, animation, animationListener) == null) {
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            this.activity.registerListener(i2, aVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, netMessage) == null) {
            this.activity.sendMessage(netMessage);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.e.a.f
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageListener) == null) {
            this.activity.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, messageListener) == null) {
            this.activity.registerListener(i2, messageListener);
        }
    }
}

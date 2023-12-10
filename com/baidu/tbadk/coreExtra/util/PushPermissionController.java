package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.dga;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public class PushPermissionController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public TbPageContext<?> mContext;
    public CustomMessageListener mListener;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushPermissionController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PushPermissionController pushPermissionController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushPermissionController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushPermissionController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    this.a.showPushPermissionDialog(((Integer) data).intValue());
                }
            }
        }
    }

    public PushPermissionController(Activity activity, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = activity;
        this.mContext = tbPageContext;
    }

    public static boolean checkShouldShowUserFollowPushDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            dga j = PushGuideManager.j("user_follow");
            if (j == null) {
                return false;
            }
            return j.i();
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            unregisterListener();
        }
    }

    public void unregisterListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPushPermissionDialog(int i) {
        dga j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, this, i) == null) && this.mActivity != null && this.mContext != null && i == 10 && (j = PushGuideManager.j("user_follow")) != null) {
            j.j(this.mContext);
        }
    }

    public void registerListener(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.mActivity == null) {
            return;
        }
        if (this.mListener == null) {
            this.mListener = new a(this, i);
        }
        MessageManager.getInstance().registerListener(this.mListener);
    }
}

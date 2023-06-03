package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.l95;
import com.baidu.tieba.le5;
import com.baidu.tieba.nf5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.sf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@Keep
/* loaded from: classes4.dex */
public class PushPermissionController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public TbPageContext<?> mContext;
    public CustomMessageListener mListener;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements rz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ PushPermissionController c;

        @Override // com.baidu.tieba.rz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(PushPermissionController pushPermissionController, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushPermissionController, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pushPermissionController;
            this.a = z;
            this.b = z2;
        }

        @Override // com.baidu.tieba.rz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.c.mContext).Z(34, true, null);
                }
                if (this.b) {
                    sf5.m(this.c.mActivity);
                } else {
                    nf5.e(this.c.mContext);
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

    private void onSubscribeFriendSuccess(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && !l95.m().i("subcribe_friend_msg_update_flag", false)) {
            l95.m().w("subcribe_friend_msg_update_flag", true);
            BdToastData bdToastData = new BdToastData();
            ArrayList arrayList = new ArrayList(1);
            BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
            contentBean.setText(context.getString(R.string.subscribe_friend_msg_update));
            arrayList.add(contentBean);
            bdToastData.setContent(arrayList);
            bdToastData.setIconType(1);
            BdToastHelper.toast(bdToastData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPushPermissionDialog(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65541, this, i) == null) && (activity = this.mActivity) != null && this.mContext != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(activity).areNotificationsEnabled();
            if (i == 10) {
                boolean m = le5.d().m();
                if (areNotificationsEnabled && m) {
                    onSubscribeFriendSuccess(this.mActivity);
                    return;
                }
                b bVar = new b(this, m, areNotificationsEnabled);
                if (nf5.i(TbadkCoreApplication.getInst(), 7)) {
                    sf5.l(this.mContext, this.mActivity, 10, bVar);
                }
            }
        }
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
}

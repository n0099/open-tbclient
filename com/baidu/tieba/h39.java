package com.baidu.tieba;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h39 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h39 h39Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Integer.valueOf(i)};
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
            this.a = h39Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof int[]) && (iArr = (int[]) customResponsedMessage.getData()) != null && iArr.length == 2) {
                int i = iArr[0];
                int i2 = iArr[1];
                if (this.a.a.getPageContext() != null) {
                    this.a.d(i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.ru4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(h39 h39Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.ru4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).T(1, true, null);
                }
                if (this.c) {
                    PushOpenUtil.showPushPermissionSucToast(this.d);
                } else {
                    DialogUtil.jumpSystemNotificationSetting(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.ru4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(h39 h39Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.ru4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).T(2, true, null);
                }
                if (this.c) {
                    PushOpenUtil.showPushPermissionSucToast(this.d);
                } else {
                    DialogUtil.jumpSystemNotificationSetting(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.ru4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(h39 h39Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.ru4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).T(20, true, null);
                }
                if (this.c) {
                    PushOpenUtil.showPushPermissionSucToast(this.d);
                } else {
                    DialogUtil.jumpSystemNotificationSetting(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.ru4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(h39 h39Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.ru4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).T(3, true, null);
                }
                if (this.c) {
                    PushOpenUtil.showPushPermissionSucToast(this.d);
                } else {
                    DialogUtil.jumpSystemNotificationSetting(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ru4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.ru4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(h39 h39Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.ru4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).T(10, true, null);
                }
                if (this.c) {
                    PushOpenUtil.showPushPermissionSucToast(this.d);
                } else {
                    DialogUtil.jumpSystemNotificationSetting(this.b);
                }
            }
        }
    }

    public h39(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragment;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        this.a.registerListener(new a(this, 2921700));
    }

    public final void d(int i) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (baseFragment = this.a) == null) {
            return;
        }
        FragmentActivity fragmentActivity = baseFragment.getFragmentActivity();
        TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
        if (fragmentActivity != null && pageContext != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(fragmentActivity).areNotificationsEnabled();
            if (i == 3) {
                boolean B = z95.e().B();
                if (areNotificationsEnabled && B) {
                    return;
                }
                b bVar = new b(this, B, pageContext, areNotificationsEnabled, fragmentActivity);
                if (m39.e()) {
                    PushOpenUtil.showPushPermissionDialogV2(pageContext, 3, bVar);
                    gba.e().h("reply_message_bar");
                }
            }
            if (i == 6) {
                boolean w = z95.e().w();
                if (areNotificationsEnabled && w) {
                    return;
                }
                c cVar = new c(this, w, pageContext, areNotificationsEnabled, fragmentActivity);
                if (m39.b()) {
                    PushOpenUtil.showPushPermissionDialogV2(pageContext, 6, cVar);
                    gba.e().h("at_message_bar");
                }
            }
            if (i == 7) {
                boolean E = z95.e().E();
                if (areNotificationsEnabled && E) {
                    return;
                }
                d dVar = new d(this, E, pageContext, areNotificationsEnabled, fragmentActivity);
                if (m39.a()) {
                    PushOpenUtil.showPushPermissionDialogV2(pageContext, 7, dVar);
                    gba.e().h("agree_message_bar");
                }
            }
            if (i == 8) {
                boolean z = z95.e().z();
                if (areNotificationsEnabled && z) {
                    return;
                }
                e eVar = new e(this, z, pageContext, areNotificationsEnabled, fragmentActivity);
                if (m39.c()) {
                    PushOpenUtil.showPushPermissionDialogV2(pageContext, 8, eVar);
                    gba.e().h("fan_message_bar");
                }
            }
            if (i == 2) {
                boolean s = z95.e().s();
                if (areNotificationsEnabled && s) {
                    return;
                }
                f fVar = new f(this, s, pageContext, areNotificationsEnabled, fragmentActivity);
                if (m39.d()) {
                    PushOpenUtil.showPushPermissionDialogV2(pageContext, 2, fVar);
                    gba.e().h("im");
                }
            }
        }
    }
}

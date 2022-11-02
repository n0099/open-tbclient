package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cd7 extends bd7 {
    public static /* synthetic */ Interceptable $ic;
    public static cd7 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends gj5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ cd7 d;

        public a(cd7 cd7Var, String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var, str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cd7Var;
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gj5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GroupSettingItemData a = this.d.a(this.a, this.b);
                if (a != null && a.isAlreadyApply()) {
                    if (System.currentTimeMillis() - a.getLastApplyTimeStamp() <= this.c) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends gj5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cd7 c;

        public b(cd7 cd7Var, GroupSettingItemData groupSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var, groupSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cd7Var;
            this.a = groupSettingItemData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gj5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.b().g(this.b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends gj5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cd7 b;

        public c(cd7 cd7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cd7Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gj5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.b().remove(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947670995, "Lcom/baidu/tieba/cd7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947670995, "Lcom/baidu/tieba/cd7;");
                return;
            }
        }
        b = new cd7();
    }

    public cd7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static cd7 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (cd7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bd7
    public cf<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            hv4.f();
            return hv4.g("tb.im_group_setting");
        }
        return (cf) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.e(GroupSettingItemData.class);
        }
    }

    @Override // com.baidu.tieba.bd7
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                cf<String> b2 = b();
                String str = uid + "@" + gid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
                synchronized (this.a) {
                    this.a.put(str, groupSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // com.baidu.tieba.bd7
    public void i(ChatSetting chatSetting, li5<Void> li5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, li5Var) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                String str = uid + "@" + gid;
                synchronized (this.a) {
                    this.a.put(str, groupSettingItemData);
                }
                kj5.c(new b(this, groupSettingItemData, str), li5Var);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void j(String str, String str2, li5<Void> li5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, li5Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "@" + str2;
            synchronized (this.a) {
                this.a.remove(str3);
            }
            kj5.c(new c(this, str3), li5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bd7
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            GroupSettingItemData groupSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.a) {
                ChatSetting chatSetting = this.a.get(str3);
                if (chatSetting instanceof GroupSettingItemData) {
                    groupSettingItemData = (GroupSettingItemData) chatSetting;
                }
            }
            if (groupSettingItemData == null) {
                GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
                groupSettingItemData2.setUid(str);
                groupSettingItemData2.setGid(str2);
                groupSettingItemData2.setAcceptNotify(true);
                groupSettingItemData2.setInGroup(true);
                return groupSettingItemData2;
            }
            return groupSettingItemData;
        }
        return (GroupSettingItemData) invokeLL.objValue;
    }

    public void m(String str, String str2, long j, li5<Boolean> li5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j), li5Var}) == null) {
            kj5.c(new a(this, str, str2, j), li5Var);
        }
    }

    public void o(String str, String str2, boolean z, li5<Void> li5Var) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Boolean.valueOf(z), li5Var}) != null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAlreadyApply(z);
        a2.setLastApplyTimeStamp(System.currentTimeMillis());
        i(a2, li5Var);
    }

    public void p(String str, String str2, boolean z, li5<Void> li5Var) {
        GroupSettingItemData a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Boolean.valueOf(z), li5Var}) != null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setInGroup(z);
        i(a2, li5Var);
    }
}

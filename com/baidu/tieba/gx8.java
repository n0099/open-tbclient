package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gx8 extends cx8 {
    public static /* synthetic */ Interceptable $ic;
    public static gx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gx8 c;

        public a(gx8 gx8Var, PersonalSettingItemData personalSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx8Var, personalSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gx8Var;
            this.a = personalSettingItemData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.getSettingCache().g(this.b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947809410, "Lcom/baidu/tieba/gx8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947809410, "Lcom/baidu/tieba/gx8;");
                return;
            }
        }
        a = new gx8();
    }

    public gx8() {
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

    public static gx8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (gx8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cx8
    public da<String> getSettingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e05.k();
            return e05.l("tb.im_personal_chat_setting");
        }
        return (da) invokeV.objValue;
    }

    public void onAccountChangedInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAccountChangedInBackground(PersonalSettingItemData.class);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cx8
    /* renamed from: b */
    public PersonalSettingItemData getSetting(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            PersonalSettingItemData personalSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.memoryCachedSettings) {
                ChatSetting chatSetting = this.memoryCachedSettings.get(str3);
                if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
                    personalSettingItemData = (PersonalSettingItemData) chatSetting;
                }
            }
            if (personalSettingItemData == null) {
                PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
                personalSettingItemData2.setMyUid(str);
                personalSettingItemData2.setToUid(str2);
                personalSettingItemData2.setAcceptNotify(true);
                return personalSettingItemData2;
            }
            return personalSettingItemData;
        }
        return (PersonalSettingItemData) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cx8
    public void saveSetting(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                da<String> settingCache = getSettingCache();
                String str = myUid + "@" + toUid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, personalSettingItemData);
                }
                settingCache.g(str, jsonStrWithObject);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // com.baidu.tieba.cx8
    public void saveSettingAsync(ChatSetting chatSetting, st5<Void> st5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, chatSetting, st5Var) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                String str = myUid + "@" + toUid;
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, personalSettingItemData);
                }
                ru5.c(new a(this, personalSettingItemData, str), st5Var);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void saveToUserInfo(String str, String str2, UserData userData) {
        PersonalSettingItemData setting;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, userData) != null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (setting = getSetting(str, str2)) == null) {
            return;
        }
        setting.setToPortrait(userData.getPortrait());
        setting.setToName(userData.getUserName());
        saveSetting(setting);
    }
}

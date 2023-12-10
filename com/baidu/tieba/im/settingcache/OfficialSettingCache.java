package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.cx8;
import com.baidu.tieba.da;
import com.baidu.tieba.e05;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ru5;
import com.baidu.tieba.st5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class OfficialSettingCache extends cx8 {
    public static /* synthetic */ Interceptable $ic;
    public static OfficialSettingCache mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ OfficialSettingCache c;

        public a(OfficialSettingCache officialSettingCache, OfficialSettingItemData officialSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialSettingCache, officialSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = officialSettingCache;
            this.a = officialSettingItemData;
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

    /* loaded from: classes6.dex */
    public class b extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ OfficialSettingCache b;

        public b(OfficialSettingCache officialSettingCache, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialSettingCache, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = officialSettingCache;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.getSettingCache().remove(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1974659774, "Lcom/baidu/tieba/im/settingcache/OfficialSettingCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1974659774, "Lcom/baidu/tieba/im/settingcache/OfficialSettingCache;");
                return;
            }
        }
        mInstance = new OfficialSettingCache();
    }

    public OfficialSettingCache() {
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

    public static OfficialSettingCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return mInstance;
        }
        return (OfficialSettingCache) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cx8
    public da<String> getSettingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e05.k();
            return e05.l("tb.im_official_chat_setting");
        }
        return (da) invokeV.objValue;
    }

    public void onAccountChangedInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAccountChangedInBackground(OfficialSettingItemData.class);
        }
    }

    public void deleteAll(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.memoryCachedSettings != null && !TextUtils.isEmpty(str)) {
            synchronized (this.memoryCachedSettings) {
                Iterator<Map.Entry<String, ChatSetting>> it = this.memoryCachedSettings.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ChatSetting> next = it.next();
                    if (next.getValue() instanceof OfficialSettingItemData) {
                        it.remove();
                        ru5.c(new b(this, str + "@" + ((OfficialSettingItemData) next.getValue()).getToUid()), null);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx8
    public void saveSetting(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                da<String> settingCache = getSettingCache();
                String str = myUid + "@" + toUid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, officialSettingItemData);
                }
                settingCache.g(str, jsonStrWithObject);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cx8
    public OfficialSettingItemData getSetting(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            OfficialSettingItemData officialSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.memoryCachedSettings) {
                ChatSetting chatSetting = this.memoryCachedSettings.get(str3);
                if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
                    officialSettingItemData = (OfficialSettingItemData) chatSetting;
                }
            }
            if (officialSettingItemData == null) {
                OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
                officialSettingItemData2.setMyUid(str);
                officialSettingItemData2.setToUid(str2);
                officialSettingItemData2.setAcceptNotify(true);
                return officialSettingItemData2;
            }
            return officialSettingItemData;
        }
        return (OfficialSettingItemData) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cx8
    public void saveSettingAsync(ChatSetting chatSetting, st5<Void> st5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, chatSetting, st5Var) == null) && chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                String str = myUid + "@" + toUid;
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, officialSettingItemData);
                }
                ru5.c(new a(this, officialSettingItemData, str), st5Var);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    public void saveToUserInfo(String str, String str2, UserData userData) {
        OfficialSettingItemData setting;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, str, str2, userData) != null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (setting = getSetting(str, str2)) == null) {
            return;
        }
        setting.setToPortrait(userData.getPortrait());
        setting.setToName(userData.getUserName());
        saveSetting(setting);
    }
}

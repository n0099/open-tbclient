package com.baidu.tieba.flutter.plugin.globalStateSync;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.d.f.p.m;
import c.a.q0.c1.t0;
import c.a.q0.f1.b.c;
import c.a.q0.r.a0.a;
import c.a.q0.r.j0.b;
import c.a.r0.z0.a.b.g;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
import com.baidu.tbadk.abtest.group.ThreadCardGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class globalStateSyncPlugin implements FlutterPlugin, GlobalStateSyncAuto.HostGlobalStateSync {
    public static /* synthetic */ Interceptable $ic;
    public static boolean updatingLoginUserInfoByFlutter;
    public static boolean updatingSyncDataByFlutter;
    public static boolean updatingThemeDataByFlutter;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAccountChangeListener;
    public CustomMessageListener mAutoPaySettingChanged;
    public GlobalStateSyncAuto.FlutterGlobalStateSync mFlutterGlobalStateSync;
    public CustomMessageListener mPreviewServerChangedListener;
    public CustomMessageListener mSyncFinishListener;
    public CustomMessageListener mYoungsterModeChangeListener;
    public CustomMessageListener skinTypeChangeListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class GlobalStateSubType {
        public static final /* synthetic */ GlobalStateSubType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GlobalStateSubType kGlobalStateSubTypeAdsenseData;
        public static final GlobalStateSubType kGlobalStateSubTypeAppConfig;
        public static final GlobalStateSubType kGlobalStateSubTypeConfigInfo;
        public static final GlobalStateSubType kGlobalStateSubTypeCount;
        public static final GlobalStateSubType kGlobalStateSubTypeNone;
        public static final GlobalStateSubType kGlobalStateSubTypeNoticeConfig;
        public static final GlobalStateSubType kGlobalStateSubTypeSwitches;
        public static final GlobalStateSubType kGlobalStateSubTypeSyncAll;
        public static final GlobalStateSubType kGlobalStateSubTypeSyncData;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1653358662, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin$GlobalStateSubType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1653358662, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin$GlobalStateSubType;");
                    return;
                }
            }
            kGlobalStateSubTypeNone = new GlobalStateSubType("kGlobalStateSubTypeNone", 0);
            kGlobalStateSubTypeSyncAll = new GlobalStateSubType("kGlobalStateSubTypeSyncAll", 1);
            kGlobalStateSubTypeSyncData = new GlobalStateSubType("kGlobalStateSubTypeSyncData", 2);
            kGlobalStateSubTypeConfigInfo = new GlobalStateSubType("kGlobalStateSubTypeConfigInfo", 3);
            kGlobalStateSubTypeAppConfig = new GlobalStateSubType("kGlobalStateSubTypeAppConfig", 4);
            kGlobalStateSubTypeNoticeConfig = new GlobalStateSubType("kGlobalStateSubTypeNoticeConfig", 5);
            kGlobalStateSubTypeAdsenseData = new GlobalStateSubType("kGlobalStateSubTypeAdsenseData", 6);
            kGlobalStateSubTypeSwitches = new GlobalStateSubType("kGlobalStateSubTypeSwitches", 7);
            GlobalStateSubType globalStateSubType = new GlobalStateSubType("kGlobalStateSubTypeCount", 8);
            kGlobalStateSubTypeCount = globalStateSubType;
            $VALUES = new GlobalStateSubType[]{kGlobalStateSubTypeNone, kGlobalStateSubTypeSyncAll, kGlobalStateSubTypeSyncData, kGlobalStateSubTypeConfigInfo, kGlobalStateSubTypeAppConfig, kGlobalStateSubTypeNoticeConfig, kGlobalStateSubTypeAdsenseData, kGlobalStateSubTypeSwitches, globalStateSubType};
        }

        public GlobalStateSubType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static GlobalStateSubType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GlobalStateSubType) Enum.valueOf(GlobalStateSubType.class, str) : (GlobalStateSubType) invokeL.objValue;
        }

        public static GlobalStateSubType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GlobalStateSubType[]) $VALUES.clone() : (GlobalStateSubType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class GlobalStateType {
        public static final /* synthetic */ GlobalStateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GlobalStateType KGlobalStateNetData;
        public static final GlobalStateType kGlobalStateCommon;
        public static final GlobalStateType kGlobalStateLoginUserInfo;
        public static final GlobalStateType kGlobalStateSyncData;
        public static final GlobalStateType kGlobalStateTheme;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1254175748, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin$GlobalStateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1254175748, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin$GlobalStateType;");
                    return;
                }
            }
            kGlobalStateTheme = new GlobalStateType("kGlobalStateTheme", 0);
            kGlobalStateSyncData = new GlobalStateType("kGlobalStateSyncData", 1);
            KGlobalStateNetData = new GlobalStateType("KGlobalStateNetData", 2);
            kGlobalStateLoginUserInfo = new GlobalStateType("kGlobalStateLoginUserInfo", 3);
            GlobalStateType globalStateType = new GlobalStateType("kGlobalStateCommon", 4);
            kGlobalStateCommon = globalStateType;
            $VALUES = new GlobalStateType[]{kGlobalStateTheme, kGlobalStateSyncData, KGlobalStateNetData, kGlobalStateLoginUserInfo, globalStateType};
        }

        public GlobalStateType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static GlobalStateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GlobalStateType) Enum.valueOf(GlobalStateType.class, str) : (GlobalStateType) invokeL.objValue;
        }

        public static GlobalStateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GlobalStateType[]) $VALUES.clone() : (GlobalStateType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1894435904, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1894435904, "Lcom/baidu/tieba/flutter/plugin/globalStateSync/globalStateSyncPlugin;");
        }
    }

    public globalStateSyncPlugin() {
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
        this.skinTypeChangeListener = new CustomMessageListener(this, 2001304) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                    if (globalStateSyncPlugin.updatingThemeDataByFlutter) {
                        boolean unused = globalStateSyncPlugin.updatingThemeDataByFlutter = false;
                        return;
                    }
                    this.this$0.writeToFlutter(GlobalStateType.kGlobalStateTheme, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readThemeData());
                }
            }
        };
        this.mAccountChangeListener = new CustomMessageListener(this, 2005016) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                    this.this$0.writeToFlutter(GlobalStateType.kGlobalStateLoginUserInfo, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readLoginUserData());
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(this, 2001371) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    if (globalStateSyncPlugin.updatingSyncDataByFlutter) {
                        boolean unused = globalStateSyncPlugin.updatingSyncDataByFlutter = false;
                        return;
                    }
                    this.this$0.writeToFlutter(GlobalStateType.kGlobalStateSyncData, GlobalStateSubType.kGlobalStateSubTypeSyncAll, globalStateSyncPlugin.readSyncData());
                }
            }
        };
        this.mPreviewServerChangedListener = new CustomMessageListener(this, 2921508) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.writeToFlutter(GlobalStateType.KGlobalStateNetData, GlobalStateSubType.kGlobalStateSubTypeConfigInfo, globalStateSyncPlugin.readNetData());
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(this, 2921509) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.writeToFlutter(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readCommonData());
                }
            }
        };
        this.mAutoPaySettingChanged = new CustomMessageListener(this, 2921511) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ globalStateSyncPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.writeToFlutter(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readCommonData());
                }
            }
        };
    }

    public static String getExperimentID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            UsbAbTestSwitch ubsABTestByGroupKey = UbsABTestHelper.getUbsABTestByGroupKey(ThreadCardGroupUbsABTest.ABTEST_GROUP_KEY);
            if (ubsABTestByGroupKey == null || m.isEmpty(ubsABTestByGroupKey.uniquekey)) {
                return "";
            }
            String str = ubsABTestByGroupKey.uniquekey;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1688589) {
                switch (hashCode) {
                    case 1687628:
                        if (str.equals(ThreadCardGroupUbsABTest.SID_A)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1687629:
                        if (str.equals(ThreadCardGroupUbsABTest.SID_B)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1687630:
                        if (str.equals(ThreadCardGroupUbsABTest.SID_C)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1687631:
                        if (str.equals(ThreadCardGroupUbsABTest.SID_D)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1687632:
                        if (str.equals(ThreadCardGroupUbsABTest.SID_E)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
            } else if (str.equals(ThreadCardGroupUbsABTest.SID_F)) {
                c2 = 5;
            }
            return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? "" : "sid_f" : "sid_e" : "sid_d" : "sid_c" : "sid_b" : "sid_a";
        }
        return (String) invokeV.objValue;
    }

    public static HashMap<String, Object> readCommonData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("isOnLine", Boolean.valueOf(!BdBaseApplication.getInst().isDebugMode()));
            hashMap.put("isOfficial", Boolean.valueOf(TbadkCoreApplication.getInst().isOfficial()));
            hashMap.put("clientVersion", TbConfig.getVersion());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                hashMap.put("phoneImei", TbadkCoreApplication.getInst().getImei());
            }
            String clientId = TbadkCoreApplication.getClientId();
            if (clientId != null) {
                hashMap.put("clientID", clientId);
            }
            String subappType = TbConfig.getSubappType();
            if (!TextUtils.isEmpty(subappType)) {
                hashMap.put("subAppType", subappType);
            }
            String from = TbadkCoreApplication.getFrom();
            if (from != null && from.length() > 0) {
                hashMap.put("appFrom", from);
            }
            hashMap.put("isVideoAutoPlay", Boolean.valueOf(t0.e()));
            hashMap.put("cuid", TbadkCoreApplication.getInst().getCuid());
            hashMap.put("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            hashMap.put("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            hashMap.put(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            hashMap.put("z_id", TbadkCoreApplication.getInst().getZid());
            hashMap.put("hdid", TbadkCoreApplication.getInst().getHdid());
            hashMap.put("model", Build.MODEL);
            c.d();
            hashMap.put("teenMode", Boolean.FALSE);
            hashMap.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            hashMap.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            hashMap.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
            hashMap.put(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            hashMap.put("start_type", a.f12818f + "");
            hashMap.put("start_scheme", a.e());
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap<String, Object> readLoginUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            hashMap.put("isValidAccount", Boolean.valueOf(currentAccountInfo != null));
            hashMap.put("id", TbadkCoreApplication.getCurrentAccount());
            if (currentAccountInfo != null) {
                hashMap.put("name", currentAccountInfo.getDisplayName());
                hashMap.put("sToken", currentAccountInfo.getStoken());
                hashMap.put("genderInt", Integer.valueOf(currentAccountInfo.getSex()));
                hashMap.put("level", currentAccountInfo.getLiveLevel() + "");
            } else {
                hashMap.put("name", null);
                hashMap.put("sToken", null);
                hashMap.put("genderInt", 0);
                hashMap.put("level", null);
            }
            hashMap.put("nickName", TbadkCoreApplication.getCurrentAccountNameShow());
            hashMap.put("bduss", TbadkCoreApplication.getCurrentBduss());
            hashMap.put(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            hashMap.put("portrait", TbadkCoreApplication.getCurrentPortrait());
            hashMap.put("isMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() > 0));
            hashMap.put("isAdvancedMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() == 2));
            hashMap.put("memberInfo", TbadkCoreApplication.getCurrentMemberType() + "");
            hashMap.put("isVisitorMode", Boolean.valueOf(TbadkCoreApplication.isLogin() ^ true));
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap<String, Object> readNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String a = c.a.q0.s.b.a.b().a();
            hashMap.put("keepAliveWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveWifi()));
            hashMap.put("keepAliveNoWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveNonWifi()));
            hashMap.put("puEnvValue", TbSingleton.getInstance().getPubEnvValue());
            hashMap.put("isVisitPreviewServer", Boolean.valueOf(TbSingleton.getInstance().isVisitPreviewServer()));
            hashMap.put("sCookie", a);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap<String, Object> readSwitches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (baseSwitchs != null && baseSwitchs.size() > 0) {
                for (Map.Entry<String, Integer> entry : baseSwitchs.entrySet()) {
                    String key = entry.getKey();
                    boolean z = true;
                    if (entry.getValue().intValue() < 1) {
                        z = false;
                    }
                    hashMap.put(key, Boolean.valueOf(z));
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap<String, Object> readSyncData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            Object hashMap4 = new HashMap();
            Object hashMap5 = new HashMap();
            Object hashMap6 = new HashMap();
            hashMap2.put("financeURL", b.k().q("baidu_finance", null));
            hashMap2.put("personalCellText", TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText());
            hashMap2.put("loginAwardUrl", TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url());
            hashMap2.put("auditPackageSwitch", Integer.valueOf(b.k().h("audit_package_switch", false) ? 1 : 0));
            hashMap2.put("isLiteMode", "0");
            hashMap2.put("isShowShoubaiDynamicGuide", String.valueOf(b.k().l("key_is_show_shoubai_dynamic_guide", 0)));
            hashMap2.put("isShowBaiduFinanceEntrance", String.valueOf(b.k().l("baidu_financial_display", 1)));
            hashMap2.put("experimentID", getExperimentID());
            hashMap2.put("userSmallPhotoHost", TbConfig.getPhotoSmallAddress());
            hashMap2.put("userBigPhotoHost", TbConfig.getBigPhotoAdress());
            hashMap2.put("isYYUser", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
            hashMap2.put("videoWorksProgressBarWaitingTime", String.valueOf(b.k().l("key_video_works_progress_bar_waiting_time", 0)));
            hashMap2.put("experimentPersonalVideoTabID", UbsABTestHelper.isPersonalVideoTabFlowABTest() ? UsbAbTestConst.KEY_PERSONAL_VIDEO_TAB_FLOW : "");
            hashMap2.put("experimentNickNameID", UbsABTestHelper.isNickNameABTest() ? UsbAbTestConst.KEY_NICK_NAME : "");
            hashMap2.put("ubsConfigMap", UbsABTestDataManager.getInstance().getSwitchsClone());
            hashMap.put("syncData", hashMap2);
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                hashMap3.put("heatingSwitchOpen", TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen() ? "1" : "0");
                hashMap3.put("heatingWeburl", TbSingleton.getInstance().getTiebaPlusConfigData().getJumpUrl());
            }
            hashMap.put("configInfo", hashMap3);
            hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, hashMap4);
            hashMap.put("noticeConfig", hashMap5);
            hashMap.put("adsenseData", hashMap6);
            hashMap.put("switches", readSwitches());
            hashMap.put("experimentCommonFeedCardID", UbsABTestHelper.isCardAcr() ? "12_0_B_brand_level_a" : "12_0_B_brand_level");
            hashMap.put("proxyIp", TbadkCoreApplication.getInst().getProxyIp());
            hashMap.put("proxyPort", TbadkCoreApplication.getInst().getProxyPort());
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap<String, Object> readThemeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
            HashMap hashMap2 = new HashMap();
            hashMap.put("mode", currentSkinTypeString);
            hashMap.put("colors", hashMap2);
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            hashMap2.put("default", hashMap3);
            hashMap2.put(SkinManager.SKIN_TYPE_STR_NIGHT, hashMap4);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    private boolean writeLoginUserData(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, hashMap)) == null) {
            updatingLoginUserInfoByFlutter = true;
            if (hashMap.containsKey("memberType")) {
                TbadkCoreApplication.setCurrentMemberType(Integer.valueOf((String) hashMap.get("memberType")).intValue());
            }
            if (hashMap.containsKey("isVisitorMode") && ((Boolean) hashMap.get("isVisitorMode")).booleanValue()) {
                TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean writeSyncData(HashMap<String, Object> hashMap, long j2) {
        InterceptResult invokeLJ;
        boolean equals;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65556, this, hashMap, j2)) == null) {
            if (j2 == GlobalStateSubType.kGlobalStateSubTypeSwitches.ordinal() && hashMap != null && hashMap.size() > 0) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (entry.getValue() instanceof String) {
                        equals = "false".equals((String) entry.getValue());
                    } else if (entry.getValue() instanceof Boolean) {
                        equals = ((Boolean) entry.getValue()).booleanValue();
                    }
                    int i2 = !equals;
                    updatingSyncDataByFlutter = true;
                    SwitchManager.getInstance().turn(entry.getKey(), i2);
                }
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    private boolean writeThemeData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i2)) == null) {
            updatingThemeDataByFlutter = true;
            TbadkCoreApplication.getInst().setSkinType(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToFlutter(GlobalStateType globalStateType, GlobalStateSubType globalStateSubType, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65558, this, globalStateType, globalStateSubType, hashMap) == null) || hashMap == null || globalStateType.ordinal() < GlobalStateType.kGlobalStateTheme.ordinal() || globalStateType.ordinal() > GlobalStateType.kGlobalStateCommon.ordinal() || globalStateSubType.ordinal() < GlobalStateSubType.kGlobalStateSubTypeNone.ordinal() || globalStateSubType.ordinal() >= GlobalStateSubType.kGlobalStateSubTypeCount.ordinal()) {
            return;
        }
        GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData = new GlobalStateSyncAuto.SingleTypeStateData();
        singleTypeStateData.setType(Long.valueOf(globalStateType.ordinal()));
        singleTypeStateData.setSubType(Long.valueOf(globalStateSubType.ordinal()));
        singleTypeStateData.setData(hashMap);
        GlobalStateSyncAuto.FlutterGlobalStateSync flutterGlobalStateSync = this.mFlutterGlobalStateSync;
        if (flutterGlobalStateSync != null) {
            flutterGlobalStateSync.writeToFlutter(singleTypeStateData, new GlobalStateSyncAuto.FlutterGlobalStateSync.Reply<GlobalStateSyncAuto.WriteResult>(this) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ globalStateSyncPlugin this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.FlutterGlobalStateSync.Reply
                public void reply(GlobalStateSyncAuto.WriteResult writeResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, writeResult) == null) {
                        BdLog.i("writeToFlutter result:" + writeResult.getResult());
                    }
                }
            });
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            this.mFlutterGlobalStateSync = new GlobalStateSyncAuto.FlutterGlobalStateSync(flutterPluginBinding.getBinaryMessenger());
            g.f(flutterPluginBinding.getBinaryMessenger(), this);
            this.mAccountChangeListener.setPriority(Integer.MAX_VALUE);
            MessageManager.getInstance().registerListener(this.mAccountChangeListener);
            MessageManager.getInstance().registerListener(this.skinTypeChangeListener);
            MessageManager.getInstance().registerListener(this.mSyncFinishListener);
            MessageManager.getInstance().registerListener(this.mPreviewServerChangedListener);
            MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
            MessageManager.getInstance().registerListener(this.mAutoPaySettingChanged);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangeListener);
            MessageManager.getInstance().unRegisterListener(this.skinTypeChangeListener);
            MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
            MessageManager.getInstance().unRegisterListener(this.mPreviewServerChangedListener);
            MessageManager.getInstance().unRegisterListener(this.mYoungsterModeChangeListener);
            MessageManager.getInstance().unRegisterListener(this.mAutoPaySettingChanged);
            this.mFlutterGlobalStateSync = null;
            g.f(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void readAllState(GlobalStateSyncAuto.Result<GlobalStateSyncAuto.AllStateData> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, result) == null) {
            GlobalStateSyncAuto.AllStateData allStateData = new GlobalStateSyncAuto.AllStateData();
            allStateData.setThemeData(readThemeData());
            allStateData.setSyncData(readSyncData());
            allStateData.setLoginUserInfo(readLoginUserData());
            allStateData.setCommonStates(readCommonData());
            allStateData.setNetStates(readNetData());
            result.success(allStateData);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void readStateForType(GlobalStateSyncAuto.readParam readparam, GlobalStateSyncAuto.Result<GlobalStateSyncAuto.SingleTypeStateData> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, readparam, result) == null) {
            GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData = new GlobalStateSyncAuto.SingleTypeStateData();
            if (GlobalStateType.kGlobalStateTheme.ordinal() == readparam.getType().longValue()) {
                singleTypeStateData.setData(readThemeData());
            } else if (GlobalStateType.kGlobalStateSyncData.ordinal() == readparam.getType().longValue()) {
                singleTypeStateData.setData(readSyncData());
            } else if (GlobalStateType.kGlobalStateLoginUserInfo.ordinal() == readparam.getType().longValue()) {
                singleTypeStateData.setData(readLoginUserData());
            } else if (GlobalStateType.kGlobalStateCommon.ordinal() == readparam.getType().longValue()) {
                singleTypeStateData.setData(readCommonData());
            } else if (GlobalStateType.KGlobalStateNetData.ordinal() == readparam.getType().longValue()) {
                singleTypeStateData.setData(readNetData());
            }
            result.success(singleTypeStateData);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void write(GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, singleTypeStateData) == null) {
            long longValue = singleTypeStateData.getType().longValue();
            long longValue2 = singleTypeStateData.getSubType().longValue();
            HashMap data = singleTypeStateData.getData();
            if (GlobalStateType.kGlobalStateTheme.ordinal() == longValue) {
                writeThemeData(((Integer) data.get("mode")).intValue());
            } else if (GlobalStateType.kGlobalStateSyncData.ordinal() == longValue) {
                writeSyncData(data, longValue2);
            } else if (GlobalStateType.kGlobalStateLoginUserInfo.ordinal() == longValue) {
                writeLoginUserData(data);
            }
        }
    }
}

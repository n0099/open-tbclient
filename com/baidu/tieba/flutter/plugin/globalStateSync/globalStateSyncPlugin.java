package com.baidu.tieba.flutter.plugin.globalStateSync;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import d.a.c.e.p.k;
import d.a.n0.b.d;
import d.a.n0.b.e;
import d.a.n0.b.f.t;
import d.a.n0.r.d0.b;
import d.a.n0.s.b.a;
import d.a.n0.z0.m0;
import d.a.o0.n0.a.b.g;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class globalStateSyncPlugin implements FlutterPlugin, GlobalStateSyncAuto.HostGlobalStateSync {
    public static boolean updatingLoginUserInfoByFlutter = false;
    public static boolean updatingSyncDataByFlutter = false;
    public static boolean updatingThemeDataByFlutter = false;
    public GlobalStateSyncAuto.FlutterGlobalStateSync mFlutterGlobalStateSync;
    public CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304) {
                return;
            }
            if (globalStateSyncPlugin.updatingThemeDataByFlutter) {
                boolean unused = globalStateSyncPlugin.updatingThemeDataByFlutter = false;
                return;
            }
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.kGlobalStateTheme, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readThemeData());
        }
    };
    public CustomMessageListener mAccountChangeListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.kGlobalStateLoginUserInfo, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readLoginUserData());
        }
    };
    public CustomMessageListener mSyncFinishListener = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            if (globalStateSyncPlugin.updatingSyncDataByFlutter) {
                boolean unused = globalStateSyncPlugin.updatingSyncDataByFlutter = false;
                return;
            }
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.kGlobalStateSyncData, GlobalStateSubType.kGlobalStateSubTypeSyncAll, globalStateSyncPlugin.readSyncData());
        }
    };
    public CustomMessageListener mPreviewServerChangedListener = new CustomMessageListener(2921508) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.KGlobalStateNetData, GlobalStateSubType.kGlobalStateSubTypeConfigInfo, globalStateSyncPlugin.readNetData());
        }
    };
    public CustomMessageListener mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readCommonData());
        }
    };
    public CustomMessageListener mAutoPaySettingChanged = new CustomMessageListener(2921511) { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            globalStateSyncPlugin.this.writeToFlutter(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, globalStateSyncPlugin.readCommonData());
        }
    };

    /* loaded from: classes4.dex */
    public enum GlobalStateSubType {
        kGlobalStateSubTypeNone,
        kGlobalStateSubTypeSyncAll,
        kGlobalStateSubTypeSyncData,
        kGlobalStateSubTypeConfigInfo,
        kGlobalStateSubTypeAppConfig,
        kGlobalStateSubTypeNoticeConfig,
        kGlobalStateSubTypeAdsenseData,
        kGlobalStateSubTypeSwitches,
        kGlobalStateSubTypeCount
    }

    /* loaded from: classes4.dex */
    public enum GlobalStateType {
        kGlobalStateTheme,
        kGlobalStateSyncData,
        KGlobalStateNetData,
        kGlobalStateLoginUserInfo,
        kGlobalStateCommon
    }

    public static String getExperimentID() {
        e b2 = d.b(t.f52661c);
        if (b2 == null || k.isEmpty(b2.f52609a)) {
            return "";
        }
        String str = b2.f52609a;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 1688589) {
            switch (hashCode) {
                case 1687628:
                    if (str.equals("70_2")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1687629:
                    if (str.equals("70_3")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1687630:
                    if (str.equals("70_4")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1687631:
                    if (str.equals("70_5")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1687632:
                    if (str.equals("70_6")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
        } else if (str.equals("71_2")) {
            c2 = 5;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? "" : "sid_f" : "sid_e" : "sid_d" : "sid_c" : "sid_b" : "sid_a";
    }

    public static HashMap<String, Object> readCommonData() {
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
        hashMap.put("isVideoAutoPlay", Boolean.valueOf(m0.d()));
        hashMap.put("cuid", TbadkCoreApplication.getInst().getCuid());
        hashMap.put("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        hashMap.put("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        hashMap.put(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
        hashMap.put("z_id", TbadkCoreApplication.getInst().getZid());
        hashMap.put("model", Build.MODEL);
        hashMap.put("teenMode", Boolean.valueOf(d.a.n0.c1.b.e.d()));
        hashMap.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
        hashMap.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
        hashMap.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
        return hashMap;
    }

    public static HashMap<String, Object> readLoginUserData() {
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

    public static HashMap<String, Object> readNetData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String a2 = a.b().a();
        hashMap.put("keepAliveWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveWifi()));
        hashMap.put("keepAliveNoWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveNonWifi()));
        hashMap.put("puEnvValue", TbSingleton.getInstance().getPubEnvValue());
        hashMap.put("isVisitPreviewServer", Boolean.valueOf(TbSingleton.getInstance().isVisitPreviewServer()));
        hashMap.put("sCookie", a2);
        return hashMap;
    }

    public static HashMap<String, Object> readSwitches() {
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

    public static HashMap<String, Object> readSyncData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        Object hashMap3 = new HashMap();
        Object hashMap4 = new HashMap();
        Object hashMap5 = new HashMap();
        Object hashMap6 = new HashMap();
        hashMap2.put("financeURL", b.j().p("baidu_finance", null));
        hashMap2.put("personalCellText", TbadkCoreApplication.getInst().getActivityPrizeData().e());
        hashMap2.put("loginAwardUrl", TbadkCoreApplication.getInst().getActivityPrizeData().c());
        hashMap2.put("auditPackageSwitch", Integer.valueOf(b.j().g("audit_package_switch", false) ? 1 : 0));
        hashMap2.put("isLiteMode", "0");
        hashMap2.put("isShowShoubaiDynamicGuide", String.valueOf(b.j().k("key_is_show_shoubai_dynamic_guide", 0)));
        hashMap2.put("isShowBaiduFinanceEntrance", String.valueOf(b.j().k("baidu_financial_display", 1)));
        hashMap2.put("experimentID", getExperimentID());
        hashMap2.put("userSmallPhotoHost", TbConfig.getPhotoSmallAddress());
        hashMap2.put("userBigPhotoHost", TbConfig.getBigPhotoAdress());
        hashMap2.put("isYYUser", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
        hashMap.put("syncData", hashMap2);
        hashMap.put("configInfo", hashMap3);
        hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, hashMap4);
        hashMap.put("noticeConfig", hashMap5);
        hashMap.put("adsenseData", hashMap6);
        hashMap.put("switches", readSwitches());
        hashMap.put("experimentCommonFeedCardID", d.g() ? "12_0_B_brand_level_a" : "12_0_B_brand_level");
        hashMap.put("proxyIp", TbadkCoreApplication.getInst().getProxyIp());
        hashMap.put("proxyPort", TbadkCoreApplication.getInst().getProxyPort());
        return hashMap;
    }

    public static HashMap<String, Object> readThemeData() {
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

    private boolean writeLoginUserData(HashMap<String, Object> hashMap) {
        updatingLoginUserInfoByFlutter = true;
        if (hashMap.containsKey("memberType")) {
            TbadkCoreApplication.setCurrentMemberType(Integer.valueOf((String) hashMap.get("memberType")).intValue());
        }
        if (hashMap.containsKey("isVisitorMode") && ((Boolean) hashMap.get("isVisitorMode")).booleanValue()) {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean writeSyncData(HashMap<String, Object> hashMap, long j) {
        boolean equals;
        if (j == GlobalStateSubType.kGlobalStateSubTypeSwitches.ordinal() && hashMap != null && hashMap.size() > 0) {
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

    private boolean writeThemeData(int i2) {
        updatingThemeDataByFlutter = true;
        TbadkCoreApplication.getInst().setSkinType(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToFlutter(GlobalStateType globalStateType, GlobalStateSubType globalStateSubType, HashMap<String, Object> hashMap) {
        if (hashMap == null || globalStateType.ordinal() < GlobalStateType.kGlobalStateTheme.ordinal() || globalStateType.ordinal() > GlobalStateType.kGlobalStateCommon.ordinal() || globalStateSubType.ordinal() < GlobalStateSubType.kGlobalStateSubTypeNone.ordinal() || globalStateSubType.ordinal() >= GlobalStateSubType.kGlobalStateSubTypeCount.ordinal()) {
            return;
        }
        GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData = new GlobalStateSyncAuto.SingleTypeStateData();
        singleTypeStateData.setType(Long.valueOf(globalStateType.ordinal()));
        singleTypeStateData.setSubType(Long.valueOf(globalStateSubType.ordinal()));
        singleTypeStateData.setData(hashMap);
        GlobalStateSyncAuto.FlutterGlobalStateSync flutterGlobalStateSync = this.mFlutterGlobalStateSync;
        if (flutterGlobalStateSync != null) {
            flutterGlobalStateSync.writeToFlutter(singleTypeStateData, new GlobalStateSyncAuto.FlutterGlobalStateSync.Reply<GlobalStateSyncAuto.WriteResult>() { // from class: com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.FlutterGlobalStateSync.Reply
                public void reply(GlobalStateSyncAuto.WriteResult writeResult) {
                    BdLog.i("writeToFlutter result:" + writeResult.getResult());
                }
            });
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
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

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.mAccountChangeListener);
        MessageManager.getInstance().unRegisterListener(this.skinTypeChangeListener);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        MessageManager.getInstance().unRegisterListener(this.mPreviewServerChangedListener);
        MessageManager.getInstance().unRegisterListener(this.mYoungsterModeChangeListener);
        MessageManager.getInstance().unRegisterListener(this.mAutoPaySettingChanged);
        this.mFlutterGlobalStateSync = null;
        g.f(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void readAllState(GlobalStateSyncAuto.Result<GlobalStateSyncAuto.AllStateData> result) {
        GlobalStateSyncAuto.AllStateData allStateData = new GlobalStateSyncAuto.AllStateData();
        allStateData.setThemeData(readThemeData());
        allStateData.setSyncData(readSyncData());
        allStateData.setLoginUserInfo(readLoginUserData());
        allStateData.setCommonStates(readCommonData());
        allStateData.setNetStates(readNetData());
        result.success(allStateData);
    }

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void readStateForType(GlobalStateSyncAuto.readParam readparam, GlobalStateSyncAuto.Result<GlobalStateSyncAuto.SingleTypeStateData> result) {
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

    @Override // com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto.HostGlobalStateSync
    public void write(GlobalStateSyncAuto.SingleTypeStateData singleTypeStateData) {
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

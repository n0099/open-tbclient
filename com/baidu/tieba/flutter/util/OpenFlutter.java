package com.baidu.tieba.flutter.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.a.b;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.switchs.FlutterConcernForumEnableSwitch;
import com.baidu.tbadk.switchs.FlutterForumDetailEnableSwitch;
import com.baidu.tbadk.switchs.FlutterPersonAttentionEnableSwitch;
import com.baidu.tbadk.switchs.FlutterPersonCenterEnableSwitch;
import com.baidu.tbadk.switchs.FlutterSignAllEnableSwitch;
import com.baidu.tieba.flutter.view.FlutterPageActivity;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public class OpenFlutter {
    public static final String ACTIVITY_CONCERN_FORUM = "ConcernForum";
    public static final String ACTIVITY_FANS = "PersonFansList";
    public static final String ACTIVITY_FORUM_DETAIL = "ForumDetail";
    public static final String ACTIVITY_PERSON_CENTER = "PersonalCenter";
    public static final String ACTIVITY_SIGN_TOGETHER = "SignAllForum";
    private static final int DEFAULT_REQUEST_CODE = 10001;
    protected static final String EXTRA_ANIMATED = "animated";
    protected static final String EXTRA_BACKGROUND_MODE = "background_mode";
    protected static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    protected static final String EXTRA_PARAMS = "params";
    protected static final String EXTRA_REQUEST_CODE = "requestCode";
    protected static final String EXTRA_SHOW_LOADING = "showloading";
    protected static final String EXTRA_SWIPEBACK = "swipeback";
    protected static final String EXTRA_TRANSPARANT = "transparent";
    protected static final String EXTRA_URL = "url";
    private static final byte FALSE = 2;
    public static final String FRAGMENT_ENTER_FORUM = "BarEntryPage";
    public static final String FRAGMENT_MYTAB = "MyTab";
    public static final String FRAGMENT_NEWCATEGORY = "NewCategoryPage";
    private static final byte TRUE = 1;

    public static boolean openFlutterPage(Context context, String str, Map<String, Object> map) {
        int i;
        String name;
        if (checkSwitch(str)) {
            Intent intent = new Intent(context, FlutterPageActivity.class);
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(map);
            if (map.containsKey(EXTRA_ANIMATED) && (map.get(EXTRA_ANIMATED) instanceof Boolean)) {
                intent.putExtra(EXTRA_ANIMATED, (Boolean) map.get(EXTRA_ANIMATED));
            }
            if (map.containsKey(EXTRA_TRANSPARANT) && (map.get(EXTRA_TRANSPARANT) instanceof Boolean)) {
                if (((Boolean) map.get(EXTRA_TRANSPARANT)).booleanValue()) {
                    name = BoostFlutterActivity.BackgroundMode.transparent.name();
                } else {
                    name = BoostFlutterActivity.BackgroundMode.opaque.name();
                }
                intent.putExtra(EXTRA_BACKGROUND_MODE, name);
            }
            if (map.containsKey(EXTRA_SWIPEBACK) && (map.get(EXTRA_SWIPEBACK) instanceof Boolean)) {
                intent.putExtra(EXTRA_SWIPEBACK, (Boolean) map.get(EXTRA_SWIPEBACK));
            }
            if (map.containsKey(EXTRA_SHOW_LOADING) && (map.get(EXTRA_SHOW_LOADING) instanceof Boolean)) {
                intent.putExtra(EXTRA_SHOW_LOADING, (Boolean) map.get(EXTRA_SHOW_LOADING));
            }
            if (!map.containsKey("requestCode") || !(map.get("requestCode") instanceof Integer)) {
                i = 10001;
            } else {
                i = ((Integer) map.get("requestCode")).intValue();
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null && (entry.getValue() instanceof Boolean)) {
                        map.put(entry.getKey(), Byte.valueOf(((Boolean) entry.getValue()).booleanValue() ? (byte) 1 : (byte) 2));
                    }
                }
            }
            intent.putExtra(EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, false).putExtra("url", str).putExtra("params", serializableMap);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return true;
            }
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    public static HashMap parseParmes(IntentConfig intentConfig, String str) {
        HashMap hashMap = new HashMap();
        if (ACTIVITY_FANS.equals(str)) {
            hashMap.put(TbEnum.SystemMessage.KEY_USER_ID, intentConfig.getIntent().getStringExtra("user_id"));
            hashMap.put("userSex", String.valueOf(intentConfig.getIntent().getIntExtra("user_sex", 0)));
            hashMap.put("type", Integer.valueOf(intentConfig.getIntent().getBooleanExtra("follow", true) ? 1 : 2));
        } else if (ACTIVITY_FORUM_DETAIL.equals(str)) {
            hashMap.put("_forumId", intentConfig.getIntent().getStringExtra("forum_id"));
            if (intentConfig instanceof ForumDetailActivityConfig) {
                hashMap.put("forum_tabs", ((ForumDetailActivityConfig) intentConfig).tabs);
            }
        } else if (ACTIVITY_CONCERN_FORUM.equals(str)) {
            hashMap.put(TbEnum.SystemMessage.KEY_USER_ID, intentConfig.getIntent().getStringExtra("key_uid"));
            hashMap.put("userSex", String.valueOf(intentConfig.getIntent().getIntExtra("key_sex", 0)));
            hashMap.put("likeBarsCount", String.valueOf(intentConfig.getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0)));
            hashMap.put("currentTab", String.valueOf(intentConfig.getIntent().getIntExtra("key_current_tab", 0)));
            hashMap.put("isChooseBarMode", String.valueOf(intentConfig.getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false)));
            hashMap.put("requestCode", String.valueOf(intentConfig.getIntent().getIntExtra("tb_request_code", 0)));
            hashMap.put("barId", intentConfig.getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID));
        } else if (ACTIVITY_PERSON_CENTER.equals(str)) {
            String stringExtra = intentConfig.getIntent().getStringExtra("user_id");
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put("uid", stringExtra);
            } else {
                hashMap.put("uid", String.valueOf(intentConfig.getIntent().getLongExtra("user_id", 0L)));
            }
        }
        return hashMap;
    }

    public static boolean checkSwitch(String str) {
        if (str.contains(ACTIVITY_SIGN_TOGETHER)) {
            return !b.zy("flutter_page_test") && FlutterSignAllEnableSwitch.isOn();
        } else if (str.contains(ACTIVITY_FANS)) {
            return FlutterPersonAttentionEnableSwitch.isOn();
        } else {
            if (str.contains(ACTIVITY_FORUM_DETAIL)) {
                return FlutterForumDetailEnableSwitch.isOn();
            }
            if (str.contains(ACTIVITY_CONCERN_FORUM)) {
                return FlutterConcernForumEnableSwitch.isOn();
            }
            if (str.contains(ACTIVITY_PERSON_CENTER)) {
                return FlutterPersonCenterEnableSwitch.isOn() && d.bfo();
            }
            return true;
        }
    }

    public static CustomMessage<?> goToFlutter(CustomMessage<?> customMessage) {
        String str;
        String name;
        IntentConfig intentConfig = (IntentConfig) customMessage.getData();
        if (intentConfig instanceof SignAllForumActivityConfig) {
            str = ACTIVITY_SIGN_TOGETHER;
        } else if (intentConfig instanceof PersonListActivityConfig) {
            if (!intentConfig.getIntent().getBooleanExtra("follow", true)) {
                str = ACTIVITY_FANS;
            } else {
                return customMessage;
            }
        } else if (intentConfig instanceof ForumDetailActivityConfig) {
            str = ACTIVITY_FORUM_DETAIL;
        } else if (intentConfig instanceof PersonBarActivityConfig) {
            str = ACTIVITY_CONCERN_FORUM;
        } else if ((intentConfig instanceof PersonPolymericActivityConfig) || (intentConfig instanceof PersonInfoActivityConfig)) {
            str = ACTIVITY_PERSON_CENTER;
        } else {
            return customMessage;
        }
        if (checkSwitch(str)) {
            if (FlutterPageActivity.class != 0) {
                BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
                serializableMap.setMap(parseParmes(intentConfig, str));
                if (!intentConfig.getIntent().hasExtra(EXTRA_BACKGROUND_MODE)) {
                    Intent intent = intentConfig.getIntent();
                    if (intentConfig.getIntent().getBooleanExtra(EXTRA_TRANSPARANT, false)) {
                        name = BoostFlutterActivity.BackgroundMode.transparent.name();
                    } else {
                        name = BoostFlutterActivity.BackgroundMode.opaque.name();
                    }
                    intent.putExtra(EXTRA_BACKGROUND_MODE, name);
                }
                intentConfig.setComponentClass(FlutterPageActivity.class);
                intentConfig.getIntent().putExtra(EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, false).putExtra("url", str).putExtra("params", serializableMap);
                intentConfig.run();
            }
            return null;
        }
        return customMessage;
    }

    public static boolean checkPluginEnable(String str) {
        PluginSetting findPluginSetting = c.qv().findPluginSetting("com.baidu.tieba.pluginFlutter");
        if ((findPluginSetting == null || findPluginSetting.apkPath == null) && !TbadkCoreApplication.getInst().isDebugMode()) {
            a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("page", str);
            statsItem.append("staticversion", BdStatisticsManager.getInstance().getAppVersion());
            statsItem.append("version", TbConfig.getVersion());
            statsItem.append("sub_version", TbConfig.getSubVersion());
            statsItem.append("setting", PluginPackageManager.pT().qe());
            statsItem.append("pluginInit", PluginPackageManager.pT().qe());
            BdStatisticsManager.getInstance().debug("pluginproxy", statsItem);
            return false;
        }
        return true;
    }
}

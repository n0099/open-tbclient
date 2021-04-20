package com.baidu.tieba.flutter.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.FlutterConcernForumEnableSwitch;
import com.baidu.tbadk.switchs.FlutterForumDetailEnableSwitch;
import com.baidu.tbadk.switchs.FlutterPersonAttentionEnableSwitch;
import com.baidu.tbadk.switchs.FlutterPersonCenterEnableSwitch;
import com.baidu.tbadk.switchs.FlutterSignAllEnableSwitch;
import com.baidu.tieba.flutter.base.view.FlutterPageActivity;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import d.b.c.e.m.e;
import d.b.c.e.n.a;
import d.b.c.h.j.g.d;
import d.b.h0.a.f;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class OpenFlutter {
    public static final String ACTIVITY_CONCERN_FORUM = "ConcernForum";
    public static final String ACTIVITY_FANS = "PersonFansList";
    public static final String ACTIVITY_FORUM_DETAIL = "ForumDetail";
    public static final String ACTIVITY_PERSON_CENTER = "PersonalCenter";
    public static final String ACTIVITY_SIGN_TOGETHER = "SignAllForum";
    public static final int DEFAULT_REQUEST_CODE = 10001;
    public static final String EXTRA_ANIMATED = "animated";
    public static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_REQUEST_CODE = "requestCode";
    public static final String EXTRA_SHOW_LOADING = "showloading";
    public static final String EXTRA_SWIPEBACK = "swipeback";
    public static final String EXTRA_TRANSPARANT = "transparent";
    public static final String EXTRA_URL = "url";
    public static final byte FALSE = 2;
    public static final String FRAGMENT_ENTER_FORUM = "BarEntryPage";
    public static final String FRAGMENT_MYTAB = "MyTab";
    public static final String FRAGMENT_NEWCATEGORY = "NewCategoryPage";
    public static final byte TRUE = 1;

    public static boolean checkPluginEnable(String str) {
        PluginSetting h2 = d.k().h("com.baidu.tieba.pluginFlutter");
        if ((h2 == null || h2.apkPath == null) && !TbadkCoreApplication.getInst().isDebugMode()) {
            a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("page", str);
            statsItem.b("staticversion", BdStatisticsManager.getInstance().getAppVersion());
            statsItem.b("version", TbConfig.getVersion());
            statsItem.b("sub_version", TbConfig.getSubVersion());
            statsItem.b(com.alipay.sdk.sys.a.j, PluginPackageManager.O().M());
            statsItem.b("pluginInit", PluginPackageManager.O().M());
            BdStatisticsManager.getInstance().debug("pluginproxy", statsItem);
            return false;
        }
        return true;
    }

    public static boolean checkSwitch(String str) {
        if (str.contains(ACTIVITY_SIGN_TOGETHER)) {
            return FlutterSignAllEnableSwitch.isOn();
        }
        if (str.contains(ACTIVITY_FANS)) {
            return FlutterPersonAttentionEnableSwitch.isOn();
        }
        if (str.contains(ACTIVITY_FORUM_DETAIL)) {
            return FlutterForumDetailEnableSwitch.isOn();
        }
        if (str.contains(ACTIVITY_CONCERN_FORUM)) {
            return FlutterConcernForumEnableSwitch.isOn();
        }
        if (str.contains(ACTIVITY_PERSON_CENTER)) {
            return FlutterPersonCenterEnableSwitch.isOn();
        }
        return true;
    }

    public static CustomMessage<?> goToFlutter(CustomMessage<?> customMessage) {
        String str;
        String name;
        IntentConfig intentConfig = (IntentConfig) customMessage.getData();
        if (intentConfig instanceof SignAllForumActivityConfig) {
            str = ACTIVITY_SIGN_TOGETHER;
        } else if (intentConfig instanceof PersonListActivityConfig) {
            if (intentConfig.getIntent().getBooleanExtra("follow", true)) {
                return customMessage;
            }
            str = ACTIVITY_FANS;
        } else if (intentConfig instanceof ForumDetailActivityConfig) {
            str = ACTIVITY_FORUM_DETAIL;
        } else if (intentConfig instanceof PersonBarActivityConfig) {
            str = ACTIVITY_CONCERN_FORUM;
        } else if (!(intentConfig instanceof PersonPolymericActivityConfig) && !(intentConfig instanceof PersonInfoActivityConfig)) {
            return customMessage;
        } else {
            e.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.flutter.base.util.OpenFlutter.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921521, TbPageExtraHelper.m()));
                }
            }, 100L);
            str = ACTIVITY_PERSON_CENTER;
        }
        if (checkSwitch(str)) {
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(parseParmes(intentConfig, str));
            if (!intentConfig.getIntent().hasExtra("background_mode")) {
                Intent intent = intentConfig.getIntent();
                if (intentConfig.getIntent().getBooleanExtra(EXTRA_TRANSPARANT, false)) {
                    name = BoostFlutterActivity.BackgroundMode.transparent.name();
                } else {
                    name = BoostFlutterActivity.BackgroundMode.opaque.name();
                }
                intent.putExtra("background_mode", name);
            }
            intentConfig.setComponentClass(FlutterPageActivity.class);
            intentConfig.getIntent().putExtra("destroy_engine_with_activity", false).putExtra("url", str).putExtra("params", serializableMap);
            intentConfig.run();
            return null;
        }
        return customMessage;
    }

    public static boolean openFlutterPage(Context context, String str, Map<String, Object> map) {
        String name;
        if (checkSwitch(str)) {
            Intent intent = new Intent(context, FlutterPageActivity.class);
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(map);
            if (map.containsKey("animated") && (map.get("animated") instanceof Boolean)) {
                intent.putExtra("animated", (Boolean) map.get("animated"));
            }
            if (map.containsKey(EXTRA_TRANSPARANT) && (map.get(EXTRA_TRANSPARANT) instanceof Boolean)) {
                if (((Boolean) map.get(EXTRA_TRANSPARANT)).booleanValue()) {
                    name = BoostFlutterActivity.BackgroundMode.transparent.name();
                } else {
                    name = BoostFlutterActivity.BackgroundMode.opaque.name();
                }
                intent.putExtra("background_mode", name);
            }
            if (map.containsKey("swipeback") && (map.get("swipeback") instanceof Boolean)) {
                intent.putExtra("swipeback", (Boolean) map.get("swipeback"));
            }
            if (map.containsKey("showloading") && (map.get("showloading") instanceof Boolean)) {
                intent.putExtra("showloading", (Boolean) map.get("showloading"));
            }
            int i = 10001;
            if (map.containsKey("requestCode") && (map.get("requestCode") instanceof Integer)) {
                i = ((Integer) map.get("requestCode")).intValue();
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null && (entry.getValue() instanceof Boolean)) {
                        map.put(entry.getKey(), Byte.valueOf(((Boolean) entry.getValue()).booleanValue() ? (byte) 1 : (byte) 2));
                    }
                }
            }
            intent.putExtra("destroy_engine_with_activity", false).putExtra("url", str).putExtra("params", serializableMap);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
            } else {
                context.startActivity(intent);
            }
            return true;
        }
        return false;
    }

    public static HashMap parseParmes(IntentConfig intentConfig, String str) {
        HashMap hashMap = new HashMap();
        if (ACTIVITY_FANS.equals(str)) {
            hashMap.put("userId", intentConfig.getIntent().getStringExtra("user_id"));
            hashMap.put("userSex", String.valueOf(intentConfig.getIntent().getIntExtra("user_sex", 0)));
            hashMap.put("type", Integer.valueOf(intentConfig.getIntent().getBooleanExtra("follow", true) ? 1 : 2));
        } else if (ACTIVITY_FORUM_DETAIL.equals(str)) {
            hashMap.put("_forumId", intentConfig.getIntent().getStringExtra("forum_id"));
            if (intentConfig instanceof ForumDetailActivityConfig) {
                hashMap.put("forum_tabs", ((ForumDetailActivityConfig) intentConfig).tabs);
            }
        } else if (ACTIVITY_CONCERN_FORUM.equals(str)) {
            hashMap.put("userId", intentConfig.getIntent().getStringExtra("key_uid"));
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
            hashMap.put("abstatus", d.b.h0.b.d.a() ? "1" : "0");
        }
        if (intentConfig.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            parseUriParmes(str, hashMap, (Uri) intentConfig.getIntent().getParcelableExtra(IntentConfig.KEY_URI));
        }
        return hashMap;
    }

    public static void parseUriParmes(String str, final HashMap<String, Object> hashMap, Uri uri) {
        Map<String, String> paramPair;
        int i;
        String substring;
        if (ACTIVITY_PERSON_CENTER.equals(str)) {
            String uri2 = uri.toString();
            if (f.c(uri)) {
                f.b().h(uri, new f.b() { // from class: com.baidu.tieba.flutter.base.util.OpenFlutter.1
                    @Override // d.b.h0.a.f.b
                    public void onCallBack(HashMap<String, Object> hashMap2) {
                        if (hashMap2 != null && (hashMap2.get(f.t) instanceof String)) {
                            String str2 = (String) hashMap2.get(f.t);
                            if (StringUtils.isNull(str2)) {
                                return;
                            }
                            hashMap.put("portrait", str2);
                        }
                    }
                });
            } else if (StringUtils.isNull(uri2)) {
            } else {
                if (uri2.startsWith("tbusercenter://") || uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER)) {
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode)) {
                        return;
                    }
                    if (uri2.startsWith("tbusercenter://")) {
                        Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                        if (matcher.find()) {
                            substring = matcher.group(2);
                        } else {
                            int indexOf = decode.indexOf("portrait=");
                            if (indexOf < 0 || (i = indexOf + 9) > decode.length()) {
                                return;
                            }
                            substring = decode.substring(i);
                        }
                        if (StringUtils.isNull(substring)) {
                            return;
                        }
                        hashMap.put("portrait", substring);
                    } else if (uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_USER_CENTER)) {
                        if (decode.startsWith("//")) {
                            decode = decode.substring(2);
                        }
                        if (StringUtils.isNull(decode) || (paramPair = UrlManager.getParamPair(decode)) == null) {
                            return;
                        }
                        String str2 = paramPair.get("uid");
                        if (StringUtils.isNull(str2)) {
                            return;
                        }
                        hashMap.put("uid", str2);
                    }
                }
            }
        }
    }
}

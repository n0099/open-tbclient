package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.data.constant.PwLogConstant;
import com.baidu.searchbox.live.interfaces.LiveConstants;
import com.baidu.searchbox.live.interfaces.service.EventDispatcherService;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g79 implements EventDispatcherService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final void a(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public g79() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void g(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, arrayList) != null) || arrayList == null || arrayList.size() == 0) {
        }
    }

    public final void i(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            String str = (String) map.get("data");
            if (!TextUtils.isEmpty(str) && str != null) {
                try {
                    o49.o(new JSONObject(str));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public final void b(String str, Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) != null) || map == null || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        for (String str2 : map.keySet()) {
            Object obj = map.get(str2);
            if (obj != null) {
                statisticItem.addParam(str2, obj.toString());
            }
        }
        statisticItem.addParam("uid", BdStatisticsManager.getInstance().getUid());
        TiebaStatic.log(statisticItem);
    }

    public final void d(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("roomId", map.get("roomId"));
                jSONObject.put("isClosed", map.get("isClosed"));
                jSONObject.put("liveId", map.get("liveId"));
                jSONObject.put("type", map.get("type"));
                jSONObject.put("sid", map.get("sid"));
                jSONObject.put(YyLiveRoomConfig.KEY_SSID, map.get(YyLiveRoomConfig.KEY_SSID));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public void e(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, map) != null) || ei.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.param(str2, map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void f(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, map) != null) || map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String obj = map.remove("key").toString();
        for (String str : map.keySet()) {
            hashMap.put(str, map.get(str).toString());
        }
        e(obj, hashMap);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.live.interfaces.service.EventDispatcherService
    public void onEvent(String str, Map<String, ?> map) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map) == null) {
            switch (str.hashCode()) {
                case -2147386482:
                    if (str.equals("sync_webview_cookie")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1369745389:
                    if (str.equals("living_room_is_closed")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1326603888:
                    if (str.equals(LiveConstants.SdkToHostEvents.DO_LOG)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1284765503:
                    if (str.equals(PwLogConstant.PW_UBC_PLUGIN_DUR)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -841542404:
                    if (str.equals(LiveConstants.SdkToHostEvents.GO_FEEDBACK)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -807428011:
                    if (str.equals(PwLogConstant.PW_UBC_PLUGIN_START)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -442093365:
                    if (str.equals(PwLogConstant.PW_UBC_PLUGIN_FAIL)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 152519529:
                    if (str.equals("live_show_close")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1480780598:
                    if (str.equals(PwLogConstant.PW_UBC_PLUGIN_SUC)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1766660371:
                    if (str.equals(LiveConstants.SdkToHostEvents.BUY_TBEAN_RESULT)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1785162541:
                    if (str.equals(LiveConstants.SdkToHostEvents.KEY_PRE_DOWANLOAD_SWAN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    h();
                    return;
                case 1:
                    c();
                    return;
                case 2:
                    f(map);
                    return;
                case 3:
                    g((ArrayList) map.get(str));
                    return;
                case 4:
                    a(map);
                    return;
                case 5:
                    i(map);
                    return;
                case 6:
                    d(map);
                    return;
                case 7:
                    b("c15400", map);
                    return;
                case '\b':
                    b("c15401", map);
                    return;
                case '\t':
                    b("c15402", map);
                    return;
                case '\n':
                    b("c15403", map);
                    return;
                default:
                    return;
            }
        }
    }
}

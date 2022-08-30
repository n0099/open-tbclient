package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.business.model.data.LiveStatInfo;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.model.data.ThirdLabelInfo;
import com.baidu.live.business.util.GrParasmUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h80 {
    public static /* synthetic */ Interceptable $ic;
    public static final UBCManager a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777449, "Lcom/baidu/tieba/h80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777449, "Lcom/baidu/tieba/h80;");
                return;
            }
        }
        a = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static void A(Context context, String str, String str2, Boolean bool, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, context, str, str2, bool, str3) == null) {
            z(context, str2, n(str), bool.booleanValue(), str3);
        }
    }

    public static void B(Context context, String str, String str2, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Integer.valueOf(i), liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    String str3 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject3.put("gr_ext", new JSONObject(str3));
                    }
                    jSONObject2.put("ext", jSONObject3);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog clk      " + jSONObject.toString());
            a.onEvent("5635", jSONObject.toString());
        }
    }

    public static void C(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, str, str2, str3, str4) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void D(Context context, LiveSearchResultInfo liveSearchResultInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, liveSearchResultInfo, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str2);
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", str);
                e(liveSearchResultInfo.statInfo, jSONObject2);
                jSONObject2.put("bduid", liveSearchResultInfo.uk);
                jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveSearchResultInfo.roomId);
                jSONObject2.put("nid", liveSearchResultInfo.feedId);
                jSONObject2.put("status", "live");
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            if (str2.equals("show")) {
                a.onEvent("5142", jSONObject.toString());
            }
            if (str2.equals("clk")) {
                a.onEvent("5143", jSONObject.toString());
            }
        }
    }

    public static void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4788", jSONObject.toString());
        }
    }

    public static void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", str);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4808", jSONObject.toString());
        }
    }

    public static void G(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4792", jSONObject.toString());
        }
    }

    public static void H(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4793", jSONObject.toString());
        }
    }

    public static void I(Context context, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, context, i, liveRoomEntity) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5119", jSONObject.toString());
        }
    }

    public static void J(Context context, int i, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, context, i, liveRoomEntity) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (liveRoomEntity != null) {
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5121", jSONObject.toString());
        }
    }

    public static void K(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5120", jSONObject.toString());
        }
    }

    public static void L(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4791", jSONObject.toString());
        }
    }

    public static void M(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4789", jSONObject.toString());
        }
    }

    public static void N(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4790", jSONObject.toString());
        }
    }

    public static void O(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sousuoci", str);
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4797", jSONObject.toString());
        }
    }

    public static Flow P(Context context, boolean z, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Boolean.valueOf(z), flow})) == null) {
            if (z) {
                return a.beginFlow("4800");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "show");
                    jSONObject.put("from", "liveshow");
                    jSONObject.put("page", "neisou_page");
                    jSONObject.put("source", "yijitabzhibo");
                    b(context, null, new JSONObject());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void Q(Context context, LiveRoomEntity liveRoomEntity, LiveSearchResultInfo liveSearchResultInfo, Boolean bool, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, liveRoomEntity, liveSearchResultInfo, bool, Integer.valueOf(i), str}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject2.put("pos", i);
                if (bool.booleanValue()) {
                    e(liveSearchResultInfo.statInfo, jSONObject2);
                    jSONObject2.put("bduid", liveSearchResultInfo.uk);
                    jSONObject2.put("touxiangqu_mukuai", "1");
                    jSONObject2.put("ziyuanqu_mukuai", 0);
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveSearchResultInfo.roomId);
                } else {
                    e(liveRoomEntity.statInfo, jSONObject2);
                    jSONObject2.put("bduid", liveRoomEntity.hostInfo.uk);
                    jSONObject2.put("ziyuanqu_mukuai", 1);
                    jSONObject2.put("touxiangqu_mukuai", "");
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, liveRoomEntity.roomId);
                    jSONObject2.put("nid", liveRoomEntity.nid);
                    if (liveRoomEntity.liveStatus == 0) {
                        jSONObject2.put("status", "preview");
                    } else if (liveRoomEntity.liveStatus == 1) {
                        jSONObject2.put("status", "live");
                    } else {
                        jSONObject2.put("status", "record");
                    }
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            if (str.equals("show")) {
                a.onEvent("4785", jSONObject.toString());
            }
            if (str.equals("clk")) {
                a.onEvent("4784", jSONObject.toString());
            }
        }
    }

    public static void R(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4807", jSONObject.toString());
        }
    }

    public static void S(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, context, i, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "neisou_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos", i);
                jSONObject2.put("action", str);
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4786", jSONObject.toString());
        }
    }

    public static void T(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, context, i) == null) {
            S(context, i, StickerDataChangeType.REPLACE);
        }
    }

    public static void U(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, context, i) == null) {
            S(context, i, "search");
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65558, null, str, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("from", "liveshow");
            jSONObject.put("page", "main_page");
            if (pa0.a(str)) {
                return;
            }
            jSONObject.put("source", str);
        } catch (JSONException e) {
            LiveFeedPageSdk.liveLog(e.getMessage());
        }
    }

    public static void b(Context context, String str, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65559, null, context, str, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.put("host_suzhu", m());
        if (!pa0.a(str)) {
            jSONObject.put("position_changjing", str);
        }
        String yyhdid = LiveFeedPageSdk.getInstance().getYYHDID(context);
        if (!TextUtils.isEmpty(yyhdid)) {
            jSONObject.put("hdid", yyhdid);
        }
        String bdId = LiveFeedPageSdk.getInstance().getBdId();
        if (TextUtils.isEmpty(bdId)) {
            return;
        }
        jSONObject.put("yonghuid", bdId);
    }

    public static void c(LiveRoomEntity liveRoomEntity, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, liveRoomEntity, jSONObject) == null) {
            LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
            if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.dot)) {
                try {
                    jSONObject.put("lt_value", liveRoomEntity.leftLabel.dot);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
            if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.dot)) {
                try {
                    jSONObject.put("rt_value", liveRoomEntity.rightLabel.dot);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
            if (thirdLabelInfo == null || TextUtils.isEmpty(thirdLabelInfo.dot)) {
                return;
            }
            try {
                jSONObject.put("ld_value", liveRoomEntity.thirdLabel.dot);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void d(String str, String str2, int i, String str3, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{str, str2, Integer.valueOf(i), str3, jSONObject}) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("nid", str2);
        }
        String str4 = i == 0 ? "preview" : i == 1 ? "live" : i == 3 ? "record" : "";
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("status", str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        jSONObject.put("bduid", str3);
    }

    public static void e(LiveStatInfo liveStatInfo, JSONObject jSONObject) {
        long j;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, liveStatInfo, jSONObject) == null) || jSONObject == null || liveStatInfo == null) {
            return;
        }
        long j4 = 0;
        try {
            j = Long.parseLong(liveStatInfo.sid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            j = 0;
        }
        try {
            j2 = Long.parseLong(liveStatInfo.ssid);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            j2 = 0;
        }
        try {
            j3 = Long.parseLong(liveStatInfo.yyuid);
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            j3 = 0;
        }
        try {
            j4 = Integer.parseInt(liveStatInfo.tpl);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put(TiebaStatic.YYParams.YYSID, j);
            jSONObject.put(TiebaStatic.YYParams.YYSSID, j2);
            jSONObject.put(TiebaStatic.YYParams.YYUID, j3);
            if (liveStatInfo.isYY) {
                jSONObject.put("isyylive", 1);
            }
            jSONObject.put("yytpl_id", j4);
            jSONObject.put("template_id", liveStatInfo.templateId);
        } catch (JSONException e5) {
            LiveFeedPageSdk.liveLog(e5.getMessage());
        }
    }

    public static void f(Context context, String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "zhibopindao_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i);
                if (!pa0.a(str2)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str2);
                }
                if (!pa0.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i2);
                if (!pa0.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4222", jSONObject.toString());
        }
    }

    public static void g(Context context, String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "zhibopindao_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i);
                if (!pa0.a(str2)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str2);
                }
                if (!pa0.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i2);
                if (!pa0.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4221", jSONObject.toString());
        }
    }

    public static void h(Context context, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str4);
                jSONObject2.put("request_sanjisubtab", str5);
                jSONObject2.put("request_session_id", str6);
                jSONObject2.put("response_feed_real_num", i3);
                jSONObject2.put("response_feed_num", i2);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("refresh_type", String.valueOf(i4));
                jSONObject2.put("refresh_index", i5);
                if (context != null) {
                    jSONObject2.put("net_status", n80.f(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4358", jSONObject.toString());
        }
    }

    public static void i(Context context, String str, String str2, String str3, int i, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "follow_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i);
                jSONObject2.put("bduid", str2);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4223", jSONObject.toString());
        }
    }

    public static void j(Context context, String str, String str2, String str3, int i, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "follow_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i);
                jSONObject2.put("bduid", str2);
                e(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4224", jSONObject.toString());
        }
    }

    public static void k(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65568, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void l(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", "liveshow");
                jSONObject.put("page", "main_page");
                if (!pa0.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? "baidu".equals(LiveFeedPageSdk.getInstance().getHost()) ? "shoubai" : LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost()) ? LiveFeedPageSdk.HOST_HAOKAN : LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost()) ? LiveFeedPageSdk.HOST_QUANMIN : "tieba".equals(LiveFeedPageSdk.getInstance().getHost()) ? "tieba" : "" : (String) invokeV.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 1137617387) {
                if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 1333267023) {
                if (hashCode == 1418021314 && str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                    c = 2;
                }
                c = 65535;
            }
            return c != 0 ? c != 1 ? c != 2 ? "zhibopindao" : "videobar" : "chenjinshi" : "zhibopindao";
        }
        return (String) invokeL.objValue;
    }

    public static String o(LiveRoomEntity liveRoomEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, liveRoomEntity)) == null) {
            if (liveRoomEntity == null) {
                return "";
            }
            if (liveRoomEntity.isYYShow() && liveRoomEntity.isHorizontalScreen()) {
                int i = liveRoomEntity.showTpl;
                if (i == 1 || i == 2) {
                    return "y-1";
                }
                if (i == 3) {
                    return "y-2";
                }
            } else if (liveRoomEntity.isHorizontalScreen()) {
                int i2 = liveRoomEntity.showTpl;
                if (i2 == 1 || i2 == 2) {
                    return "h-1";
                }
                if (i2 == 3) {
                    return "h-2";
                }
            } else {
                int i3 = liveRoomEntity.showTpl;
                if (i3 == 1 || i3 == 2) {
                    return "v-1";
                }
                if (i3 == 3) {
                    return "v-2";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void p(Context context, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    String str5 = liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "";
                    String str6 = "1";
                    jSONObject2.put("is_preview", liveRoomEntity.fromReserve ? "1" : "0");
                    if (!liveRoomEntity.hasInterest) {
                        str6 = "0";
                    }
                    jSONObject2.put("charu", str6);
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str5, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                    c(liveRoomEntity, jSONObject2);
                    jSONObject2.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject3 = new JSONObject();
                    String str7 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str7)) {
                        jSONObject3.put("gr_ext", new JSONObject(str7));
                    }
                    jSONObject2.put("ext", jSONObject3);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog clk      " + jSONObject.toString());
            a.onEvent("4384", jSONObject.toString());
        }
    }

    public static void q(String str, String str2, Boolean bool, LiveRoomEntity liveRoomEntity, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{str, str2, bool, liveRoomEntity, context, Integer.valueOf(i)}) == null) {
            if (liveRoomEntity.needLogShow || !bool.booleanValue()) {
                GrParasmUtil.logGrParam(liveRoomEntity.nid, bool.booleanValue(), !bool.booleanValue());
                String n = n(str);
                if (bool.booleanValue()) {
                    y(context, str2, n, i + 1, liveRoomEntity.belongSubTab, liveRoomEntity.belongThirdTab, liveRoomEntity);
                } else {
                    p(context, str2, n, i + 1, liveRoomEntity.belongSubTab, liveRoomEntity.belongThirdTab, liveRoomEntity);
                }
                liveRoomEntity.needLogShow = false;
            }
        }
    }

    public static void r(Context context, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, long j, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                jSONObject2.put("resp_logid", str4);
                jSONObject2.put("resource", str5);
                jSONObject2.put("cache_item", str9);
                jSONObject2.put("cache_cause", i2);
                jSONObject2.put("cache_time", j);
                jSONObject2.put("cache_read_time", j2);
                jSONObject2.put("cache_availability", i3);
                if (context != null) {
                    jSONObject2.put("net_status", n80.f(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4359", jSONObject.toString());
        }
    }

    public static Flow s(Context context, boolean z, String str, String str2, String str3, String str4, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3, str4, flow})) == null) {
            if (z) {
                return a.beginFlow("3327");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void t(Context context, String str, String str2, long j, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{context, str, str2, Long.valueOf(j), Integer.valueOf(i), str3, str4, str5, str6, str7, str8, str9}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "liveshow");
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", m());
                jSONObject2.put("request_time", j);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_logid", str4);
                jSONObject2.put("request_resource", str5);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("response_tab_availability", str9);
                }
                if (context != null) {
                    jSONObject2.put("net_status", n80.f(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.getInstance().getInvoker().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.getInstance().getInvoker().getUK());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4298", jSONObject.toString());
        }
    }

    public static void u(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65578, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("4261", jSONObject.toString());
        }
    }

    public static Flow v(Context context, boolean z, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{context, Boolean.valueOf(z), str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity, flow})) == null) {
            if (z) {
                return a.beginFlow("4912");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "show");
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    jSONObject2.put("pos", i);
                    jSONObject2.put("kapianshipei", o(liveRoomEntity));
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    if (liveRoomEntity != null) {
                        String str5 = "";
                        d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                        jSONObject2.put("auto_play", liveRoomEntity.autoPlay);
                        if (!TextUtils.isEmpty(liveRoomEntity.beginTime)) {
                            str5 = liveRoomEntity.beginTime;
                        }
                        jSONObject2.put("live_union_id", str5);
                        e(liveRoomEntity.statInfo, jSONObject2);
                        jSONObject2.put("id", liveRoomEntity.nid);
                        JSONObject jSONObject3 = new JSONObject();
                        String str6 = liveRoomEntity.grExt;
                        if (!TextUtils.isEmpty(str6)) {
                            jSONObject3.put("gr_ext", new JSONObject(str6));
                        }
                        jSONObject2.put("ext", jSONObject3);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void w(Context context, String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{context, str, str2, Boolean.valueOf(z), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", z ? CriusAttrConstants.DISPLAY : "click");
                jSONObject.put("value", str3);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5516", jSONObject.toString());
        }
    }

    public static void x(Context context, String str, String str2, Boolean bool, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65581, null, context, str, str2, bool, str3) == null) {
            w(context, str2, n(str), bool.booleanValue(), str3);
        }
    }

    public static void y(Context context, String str, String str2, int i, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", CriusAttrConstants.DISPLAY);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    String str5 = liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "";
                    Object obj = "1";
                    jSONObject2.put("is_preview", liveRoomEntity.fromReserve ? "1" : "0");
                    if (!liveRoomEntity.hasInterest) {
                        obj = "0";
                    }
                    jSONObject2.put("charu", obj);
                    d(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, str5, jSONObject2);
                    e(liveRoomEntity.statInfo, jSONObject2);
                    c(liveRoomEntity, jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject4 = new JSONObject();
                    String str6 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject4.put("gr_ext", new JSONObject(str6));
                    }
                    jSONObject3.put("ext", jSONObject4);
                    jSONObject3.put("position_changjing ", str2);
                    jSONObject3.put("pos", i);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject2.put("item", jSONArray);
                    jSONObject2.put("topic_id", liveRoomEntity.getTopicId());
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            LiveFeedPageSdk.liveLog("grLog display      " + jSONObject.toString());
            a.onEvent("4383", jSONObject.toString());
        }
    }

    public static void z(Context context, String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{context, str, str2, Boolean.valueOf(z), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", z ? CriusAttrConstants.DISPLAY : "click");
                jSONObject.put("value", str3);
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                LiveFeedPageSdk.liveLog(e.getMessage());
            }
            a.onEvent("5504", jSONObject.toString());
        }
    }
}

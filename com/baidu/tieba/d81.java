package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.MPDParser;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d81 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658316, "Lcom/baidu/tieba/d81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658316, "Lcom/baidu/tieba/d81;");
                return;
            }
        }
        a = bu0.f();
    }

    public static String a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            try {
                SparseArray sparseArray = new SparseArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    sparseArray.put(jSONObject.optInt(MultiRatePlayUrlHelper.RANK), jSONObject.optString("url"));
                }
                if (sparseArray.size() <= 0) {
                    return null;
                }
                return (String) sparseArray.valueAt(0);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> e(String str) {
        InterceptResult invokeL;
        int indexOf;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (str != null && (indexOf = str.indexOf("#") + 1) > 0) {
                for (String str2 : str.substring(indexOf).split("#")) {
                    int indexOf2 = str2.indexOf("=");
                    if (indexOf2 >= 0) {
                        hashMap.put(str2.substring(0, indexOf2), str2.substring(indexOf2 + 1));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0498 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BdVideoSeries b(HashMap<Integer, String> hashMap) {
        InterceptResult invokeL;
        boolean z;
        int i;
        String str;
        ClarityUrlList clarityList;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap != null && hashMap.size() != 0) {
                BdVideoSeries bdVideoSeries = new BdVideoSeries();
                String str10 = hashMap.get(0);
                String str11 = hashMap.get(5);
                String str12 = hashMap.get(1);
                String str13 = hashMap.get(3);
                String str14 = hashMap.get(9);
                String str15 = hashMap.get(6);
                String str16 = hashMap.get(7);
                String str17 = hashMap.get(16);
                try {
                    z = Boolean.parseBoolean(hashMap.get(17));
                } catch (Exception e) {
                    f21.b("BdVideoNewParser", Log.getStackTraceString(e));
                    z = false;
                }
                String str18 = hashMap.get(105);
                String str19 = hashMap.get(106);
                String str20 = hashMap.get(107);
                String str21 = hashMap.get(108);
                String str22 = hashMap.get(109);
                String str23 = hashMap.get(110);
                String str24 = hashMap.get(112);
                boolean z2 = z;
                String str25 = hashMap.get(111);
                String str26 = hashMap.get(113);
                String str27 = hashMap.get(114);
                String str28 = hashMap.get(115);
                String str29 = hashMap.get(120);
                String str30 = hashMap.get(121);
                String str31 = hashMap.get(122);
                String str32 = hashMap.get(123);
                String str33 = hashMap.get(124);
                String str34 = hashMap.get(125);
                String str35 = hashMap.get(305);
                String str36 = hashMap.get(301);
                String str37 = hashMap.get(302);
                String str38 = hashMap.get(127);
                String str39 = hashMap.get(304);
                String str40 = hashMap.get(305);
                bdVideoSeries.setMPD(hashMap.get(350));
                bdVideoSeries.setMPDUrl(hashMap.get(351));
                bdVideoSeries.setMPDVid(hashMap.get(352));
                String str41 = hashMap.get(353);
                String str42 = hashMap.get(103);
                if (str42 != null) {
                    i = b21.c(str42);
                } else {
                    i = 101;
                }
                bdVideoSeries.setFrom(str36);
                bdVideoSeries.setPage(str33);
                if (!TextUtils.isEmpty(bdVideoSeries.getMPD())) {
                    bdVideoSeries.setClarityUrlList(bdVideoSeries.getMPD(), true);
                    bdVideoSeries.setHasDecodedMPD(true);
                } else {
                    String str43 = hashMap.get(303);
                    if (!TextUtils.isEmpty(str43)) {
                        bdVideoSeries.setClarityUrlList(str43);
                    }
                }
                if (!TextUtils.isEmpty(str21)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str21);
                        String optString = jSONObject.optString("preview_6s_url");
                        bdVideoSeries.setShareMode(jSONObject.optJSONObject("share"));
                        bdVideoSeries.setPreview6sUrl(optString);
                        if (bdVideoSeries.getClarityList() == null) {
                            bdVideoSeries.setClarityUrlList(jSONObject.optString(BasicVideoParserKt.CLARITY));
                        }
                        try {
                            String optString2 = jSONObject.optString("longVideo", null);
                            if (optString2 != null) {
                                bdVideoSeries.setLongVideo(new JSONObject(optString2).optString("cmd", null));
                            } else {
                                str = null;
                                try {
                                    bdVideoSeries.setLongVideo(null);
                                } catch (JSONException e2) {
                                    e = e2;
                                    bdVideoSeries.setLongVideo(str);
                                    f21.b("BdVideoNewParser", Log.getStackTraceString(e));
                                    if (!TextUtils.isEmpty(str25)) {
                                    }
                                    clarityList = bdVideoSeries.getClarityList();
                                    if (clarityList == null) {
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    if (!TextUtils.isEmpty(str13)) {
                                    }
                                    if (!TextUtils.isEmpty(str14)) {
                                    }
                                    if (!TextUtils.isEmpty(str16)) {
                                    }
                                    int parseDoubleSafe = (int) BdVideoSeries.parseDoubleSafe(str35, -1.0d);
                                    bdVideoSeries.setStartPosition(parseDoubleSafe);
                                    bdVideoSeries.setDuration(BdVideoSeries.parseIntSafe(str24, 0));
                                    bdVideoSeries.setHttpHeader(sb.toString());
                                    bdVideoSeries.setProxy(str15);
                                    if (str18 != null) {
                                    }
                                    bdVideoSeries.setRecommendList(str2);
                                    if (str20 != null) {
                                    }
                                    bdVideoSeries.setPoster(str3);
                                    bdVideoSeries.setExt(str21);
                                    if (str25 == null) {
                                    }
                                    bdVideoSeries.setExtLog(str25);
                                    bdVideoSeries.setNetToast(!TextUtils.equals(str22, "0"));
                                    if (str26 != null) {
                                    }
                                    bdVideoSeries.setVid(str4);
                                    if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                                    }
                                    if (str27 != null) {
                                    }
                                    bdVideoSeries.setFormat(str5);
                                    if (TextUtils.equals(str28, "1")) {
                                    }
                                    bdVideoSeries.setVideoFaceDetect(str37);
                                    bdVideoSeries.setFloatingDisable(str40);
                                    bdVideoSeries.setUrlExpireTime(str38);
                                    BdVideo bdVideo = new BdVideo();
                                    Map<String, String> e3 = e(str10);
                                    str6 = e3.get("title");
                                    if (!TextUtils.isEmpty(str6)) {
                                    }
                                    str7 = e3.get(PrefetchEvent.EVENT_KEY_PAGE_URL);
                                    str8 = e3.get("show_title");
                                    str9 = e3.get("show_share");
                                    if (TextUtils.isEmpty(str6)) {
                                    }
                                    bdVideo.setTitle(str6);
                                    bdVideo.setVideoId(str26);
                                    if (!TextUtils.isEmpty(str7)) {
                                    }
                                    bdVideo.setSourceUrl(str11);
                                    if (TextUtils.isEmpty(str8)) {
                                    }
                                    bdVideo.setShowTitle(str8);
                                    if (TextUtils.isEmpty(str9)) {
                                    }
                                    bdVideo.setShowShare(str9);
                                    bdVideo.setCurrentLength(parseDoubleSafe + "");
                                    bdVideo.setPlayUrl(str10);
                                    bdVideo.setType(i);
                                    bdVideo.setTotalLength(str24);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(bdVideo);
                                    bdVideoSeries.setTitle(str12);
                                    bdVideoSeries.setVideoList(arrayList);
                                    bdVideoSeries.setSelectedIndex(0);
                                    bdVideoSeries.setAnimLogoEnable("1".equals(str29));
                                    bdVideoSeries.setAnimLogoJumpScheme(str30);
                                    bdVideoSeries.setAnimLogoDownloadScheme(str31);
                                    bdVideoSeries.setAnimLogoDownloadToast(str32);
                                    bdVideoSeries.setWebPlayerExt(str17);
                                    if (!TextUtils.isEmpty(str34)) {
                                    }
                                    bdVideoSeries.setPlayConf(str39);
                                    bdVideoSeries.setResourceType(str41);
                                    bdVideoSeries.setStartOnPreparedEnable(z2);
                                    return bdVideoSeries;
                                }
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            str = null;
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        str = null;
                    }
                }
                if (!TextUtils.isEmpty(str25)) {
                    try {
                        bdVideoSeries.setPd(new JSONObject(str25).optString("pd"));
                    } catch (JSONException e6) {
                        f21.b("BdVideoNewParser", Log.getStackTraceString(e6));
                    }
                }
                clarityList = bdVideoSeries.getClarityList();
                if (clarityList == null) {
                    ClarityUrlList.c currentClarityUrl = clarityList.getCurrentClarityUrl();
                    if (currentClarityUrl != null) {
                        bdVideoSeries.setVideoBps(currentClarityUrl.h());
                        bdVideoSeries.setMoovSize(currentClarityUrl.d());
                        if (TextUtils.isEmpty(str14)) {
                            str14 = av0.c(currentClarityUrl.b(), currentClarityUrl.g(), str11);
                        }
                    }
                } else if (TextUtils.isEmpty(str14)) {
                    str14 = av0.c(null, str10, str11);
                }
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(str13)) {
                    sb2.append("Cookie:");
                    sb2.append(str13);
                    sb2.append("\r\n");
                }
                if (!TextUtils.isEmpty(str14)) {
                    sb2.append("Referer:");
                    sb2.append(str14);
                    sb2.append("\r\n");
                }
                if (!TextUtils.isEmpty(str16)) {
                    sb2.append(str16);
                }
                int parseDoubleSafe2 = (int) BdVideoSeries.parseDoubleSafe(str35, -1.0d);
                bdVideoSeries.setStartPosition(parseDoubleSafe2);
                bdVideoSeries.setDuration(BdVideoSeries.parseIntSafe(str24, 0));
                bdVideoSeries.setHttpHeader(sb2.toString());
                bdVideoSeries.setProxy(str15);
                if (str18 != null) {
                    str2 = "";
                } else {
                    str2 = str18;
                }
                bdVideoSeries.setRecommendList(str2);
                if (str20 != null) {
                    str3 = "";
                } else {
                    str3 = str20;
                }
                bdVideoSeries.setPoster(str3);
                bdVideoSeries.setExt(str21);
                if (str25 == null) {
                    str25 = "";
                }
                bdVideoSeries.setExtLog(str25);
                bdVideoSeries.setNetToast(!TextUtils.equals(str22, "0"));
                if (str26 != null) {
                    str4 = "";
                } else {
                    str4 = str26;
                }
                bdVideoSeries.setVid(str4);
                if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                    bdVideoSeries.setNid("sv_" + bdVideoSeries.getVid());
                }
                if (str27 != null) {
                    str5 = "";
                } else {
                    str5 = str27;
                }
                bdVideoSeries.setFormat(str5);
                if (TextUtils.equals(str28, "1")) {
                    bdVideoSeries.setPlayLoop(true);
                }
                bdVideoSeries.setVideoFaceDetect(str37);
                bdVideoSeries.setFloatingDisable(str40);
                bdVideoSeries.setUrlExpireTime(str38);
                BdVideo bdVideo2 = new BdVideo();
                Map<String, String> e32 = e(str10);
                str6 = e32.get("title");
                if (!TextUtils.isEmpty(str6)) {
                    try {
                        str6 = URLDecoder.decode(str6, "UTF-8");
                    } catch (UnsupportedEncodingException e7) {
                        f21.b("BdVideoNewParser", Log.getStackTraceString(e7));
                    }
                }
                str7 = e32.get(PrefetchEvent.EVENT_KEY_PAGE_URL);
                str8 = e32.get("show_title");
                str9 = e32.get("show_share");
                if (TextUtils.isEmpty(str6)) {
                    str6 = str12;
                }
                bdVideo2.setTitle(str6);
                bdVideo2.setVideoId(str26);
                if (!TextUtils.isEmpty(str7)) {
                    str11 = str7;
                }
                bdVideo2.setSourceUrl(str11);
                if (TextUtils.isEmpty(str8)) {
                    str8 = str19;
                }
                bdVideo2.setShowTitle(str8);
                if (TextUtils.isEmpty(str9)) {
                    str9 = str23;
                }
                bdVideo2.setShowShare(str9);
                bdVideo2.setCurrentLength(parseDoubleSafe2 + "");
                bdVideo2.setPlayUrl(str10);
                bdVideo2.setType(i);
                bdVideo2.setTotalLength(str24);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bdVideo2);
                bdVideoSeries.setTitle(str12);
                bdVideoSeries.setVideoList(arrayList2);
                bdVideoSeries.setSelectedIndex(0);
                bdVideoSeries.setAnimLogoEnable("1".equals(str29));
                bdVideoSeries.setAnimLogoJumpScheme(str30);
                bdVideoSeries.setAnimLogoDownloadScheme(str31);
                bdVideoSeries.setAnimLogoDownloadToast(str32);
                bdVideoSeries.setWebPlayerExt(str17);
                if (!TextUtils.isEmpty(str34)) {
                    try {
                        bdVideoSeries.setHotCommentList(n01.b(new JSONArray(str34)));
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                bdVideoSeries.setPlayConf(str39);
                bdVideoSeries.setResourceType(str41);
                bdVideoSeries.setStartOnPreparedEnable(z2);
                return bdVideoSeries;
            }
            return null;
        }
        return (BdVideoSeries) invokeL.objValue;
    }

    public static BdVideoSeries c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return d(f(str));
        }
        return (BdVideoSeries) invokeL.objValue;
    }

    public static BdVideoSeries d(HashMap<Integer, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap)) == null) {
            BdVideoSeries b = b(hashMap);
            if (b == null) {
                return null;
            }
            String str = hashMap.get(0);
            String str2 = hashMap.get(303);
            ClarityUrlList clarityList = b.getClarityList();
            if (TextUtils.isEmpty(str) && clarityList != null) {
                str = clarityList.getDefaultUrl();
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    str = a(new JSONArray(str2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String str3 = hashMap.get(108);
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                try {
                    str = a(new JSONObject(str3).getJSONArray(BasicVideoParserKt.CLARITY));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (b.getSelectedVideo() != null) {
                b.getSelectedVideo().setPlayUrl(str);
            }
            return b;
        }
        return (BdVideoSeries) invokeL.objValue;
    }

    public static HashMap<Integer, String> f(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap<Integer, String> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String optString = jSONObject2.optString("videoUrl");
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject2.optString("video_url");
                }
                hashMap.put(0, optString);
                hashMap.put(106, "false");
                hashMap.put(1, jSONObject2.optString("title"));
                hashMap.put(110, YYOption.IsLive.VALUE_TRUE);
                hashMap.put(124, jSONObject2.optString("page"));
                String optString2 = jSONObject2.optString(BasicVideoParserKt.EXT_LOG);
                if (!TextUtils.isEmpty(optString2)) {
                    jSONObject = new JSONObject(optString2);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("ext_page", jSONObject2.optString("page"));
                hashMap.put(111, jSONObject.toString());
                hashMap.put(108, jSONObject2.optString("ext"));
                String optString3 = jSONObject2.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = jSONObject2.optString("page_url");
                }
                hashMap.put(5, optString3);
                String optString4 = jSONObject2.optString("posterImage");
                if (TextUtils.isEmpty(optString4)) {
                    optString4 = jSONObject2.optString("poster_image");
                }
                hashMap.put(107, optString4);
                hashMap.put(112, jSONObject2.optString("duration"));
                hashMap.put(113, jSONObject2.optString("vid"));
                hashMap.put(103, "3");
                JSONObject optJSONObject = jSONObject2.optJSONObject("playerAnimation");
                if (optJSONObject != null) {
                    boolean equals = "1".equals(optJSONObject.optString("playerAnimationFlag"));
                    String optString5 = optJSONObject.optString("animationJumpScheme");
                    String optString6 = optJSONObject.optString("animationDownloadScheme");
                    String optString7 = optJSONObject.optString("downloadToast");
                    if (equals) {
                        hashMap.put(120, "1");
                        hashMap.put(121, optString5);
                        hashMap.put(122, optString6);
                        hashMap.put(123, optString7);
                    }
                }
                hashMap.put(105, jSONObject2.optString("recommend_list"));
                hashMap.put(301, jSONObject2.optString("from"));
                hashMap.put(305, jSONObject2.optString("seekSeconds"));
                hashMap.put(302, jSONObject2.optString("hasFaceDetect"));
                hashMap.put(127, String.valueOf(jSONObject2.optInt("urlExpireTs")));
                String optString8 = jSONObject2.optString(BasicVideoParserKt.CLARITY);
                if (!TextUtils.isEmpty(optString8)) {
                    hashMap.put(303, optString8);
                }
                String optString9 = jSONObject2.optString("play_conf");
                if (!TextUtils.isEmpty(optString9)) {
                    hashMap.put(304, optString9);
                }
                String optString10 = jSONObject2.optString("play_floating_conf");
                if (!TextUtils.isEmpty(optString10)) {
                    hashMap.put(305, optString10);
                }
                hashMap.put(350, jSONObject2.optString(MPDParser.MPD_SCHEME));
                hashMap.put(351, jSONObject2.optString("mpd_url"));
                hashMap.put(352, jSONObject2.optString("mpd_vid"));
                hashMap.put(353, jSONObject2.optString(BasicVideoParserKt.RESOURCE_TYPE));
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}

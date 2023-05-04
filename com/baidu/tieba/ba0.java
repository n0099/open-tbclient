package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.model.data.LiveErrorInfo;
import com.baidu.live.feed.search.model.data.LiveSearchHotRankData;
import com.baidu.live.feed.search.model.data.LiveSearchHotWordListData;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestionsBean;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ba0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public AppInfoService b;

    /* loaded from: classes3.dex */
    public interface a<T> {
        void onFail(int i, String str);

        void onSuccess(T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947638104, "Lcom/baidu/tieba/ba0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947638104, "Lcom/baidu/tieba/ba0;");
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements fb0<List<? extends LiveRoomEntity>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: b */
        public List<LiveRoomEntity> onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse)) == null) {
                if (netResponse == null || (str = netResponse.decodedResponseStr) == null) {
                    return null;
                }
                if (!netResponse.isSuccessful()) {
                    str = null;
                }
                if (str == null) {
                    return null;
                }
                return LiveSearchHotRankData.parse(str);
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: a */
        public void onNetResponse(NetResponse netResponse, List<? extends LiveRoomEntity> list, Map<String, String> map, List<String> list2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, netResponse, list, map, list2) == null) {
                if (netResponse != null && netResponse.isSuccessful() && list != null) {
                    this.a.onSuccess(list);
                } else if (netResponse == null) {
                    this.a.onFail(-111, "网络不给力，请稍后重试");
                } else {
                    this.a.onFail(netResponse.responseCode, netResponse.exception);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements fb0<LiveSearchHotWordListData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba0 a;
        public final /* synthetic */ a b;

        public c(ba0 ba0Var, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba0Var;
            this.b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: a */
        public void onNetResponse(NetResponse netResponse, LiveSearchHotWordListData liveSearchHotWordListData, Map<String, String> map, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, netResponse, liveSearchHotWordListData, map, list) == null) {
                this.a.a = false;
                if (netResponse != null && netResponse.isSuccessful() && liveSearchHotWordListData != null) {
                    this.b.onSuccess(liveSearchHotWordListData);
                } else if (netResponse == null) {
                    this.b.onFail(-111, "网络不给力，请稍后重试");
                } else {
                    this.b.onFail(netResponse.responseCode, netResponse.exception);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: b */
        public LiveSearchHotWordListData onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse)) == null) {
                this.a.a = false;
                if (netResponse == null || (str = netResponse.decodedResponseStr) == null) {
                    return null;
                }
                if (!netResponse.isSuccessful()) {
                    str = null;
                }
                if (str == null) {
                    return null;
                }
                LiveSearchHotWordListData liveSearchHotWordListData = new LiveSearchHotWordListData(null, 1, null);
                liveSearchHotWordListData.parseJson(str);
                return liveSearchHotWordListData;
            }
            return (LiveSearchHotWordListData) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements fb0<SearchResultBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: a */
        public void onNetResponse(NetResponse netResponse, SearchResultBean searchResultBean, Map<String, String> map, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, netResponse, searchResultBean, map, list) == null) {
                if (netResponse != null && netResponse.isSuccessful() && searchResultBean != null) {
                    this.a.onSuccess(searchResultBean);
                } else if (netResponse == null) {
                    this.a.onFail(-111, "网络不给力，请稍后重试");
                } else {
                    this.a.onFail(netResponse.responseCode, netResponse.exception);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: b */
        public SearchResultBean onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse)) == null) {
                JSONObject jSONObject = null;
                if (netResponse == null || !netResponse.isSuccessful()) {
                    return null;
                }
                try {
                    String str = netResponse.decodedResponseStr;
                    if (str == null) {
                        str = "";
                    }
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                }
                SearchResultBean searchResultBean = new SearchResultBean();
                if (jSONObject != null) {
                    searchResultBean.parse(jSONObject);
                }
                return searchResultBean;
            }
            return (SearchResultBean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements fb0<LiveSearchSuggestionsBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: a */
        public void onNetResponse(NetResponse netResponse, LiveSearchSuggestionsBean liveSearchSuggestionsBean, Map<String, String> map, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, netResponse, liveSearchSuggestionsBean, map, list) == null) {
                if (liveSearchSuggestionsBean == null) {
                    if (netResponse == null) {
                        this.a.onFail(-111, "网络不给力，请稍后重试");
                        return;
                    } else {
                        this.a.onFail(netResponse.responseCode, netResponse.exception);
                        return;
                    }
                }
                this.a.onSuccess(liveSearchSuggestionsBean);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: b */
        public LiveSearchSuggestionsBean onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse)) == null) {
                if (netResponse != null && netResponse.isSuccessful() && netResponse.netErrorCode == 0 && (str = netResponse.decodedResponseStr) != null && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    LiveSearchSuggestionsBean liveSearchSuggestionsBean = new LiveSearchSuggestionsBean();
                    liveSearchSuggestionsBean.parse(jSONObject);
                    LiveErrorInfo liveErrorInfo = liveSearchSuggestionsBean.liveErrorInfo;
                    if (liveErrorInfo != null && liveErrorInfo.errno == 0) {
                        return liveSearchSuggestionsBean;
                    }
                }
                return null;
            }
            return (LiveSearchSuggestionsBean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements fb0<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;

        public f(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: a */
        public void onNetResponse(NetResponse netResponse, Integer num, Map<String, String> map, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, netResponse, num, map, list) == null) {
                if (netResponse != null && !netResponse.isSuccessful()) {
                    this.a.onFail(netResponse.responseCode, netResponse.exception);
                } else if (num == null || num.intValue() != 0) {
                    if (netResponse == null) {
                        this.a.onFail(-111, "网络不给力，请稍后重试");
                    } else {
                        this.a.onFail(netResponse.responseCode, netResponse.exception);
                    }
                } else {
                    this.a.onSuccess(Boolean.valueOf(this.b));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fb0
        /* renamed from: b */
        public Integer onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse)) == null) {
                if (netResponse != null && netResponse.isSuccessful()) {
                    String str = netResponse.decodedResponseStr;
                    Intrinsics.checkExpressionValueIsNotNull(str, "res.decodedResponseStr");
                    if (!StringsKt__StringsJVMKt.isBlank(str)) {
                        int optInt = new JSONObject(netResponse.decodedResponseStr).optInt("errno");
                        int i = netResponse.netErrorCode;
                        return Integer.valueOf(optInt);
                    }
                    return null;
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public ba0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
    }

    public final void b(a<List<LiveRoomEntity>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("client_type", "2");
            AppInfoService appInfoService = this.b;
            pairArr[1] = TuplesKt.to("subapp_version", (appInfoService == null || (r1 = appInfoService.getVersionName()) == null) ? "" : "");
            pairArr[2] = TuplesKt.to("sdk_version", LiveFeedPageSdk.LIVE_SDK_VERSION);
            gb0.h("https://tiebac.baidu.com/bdlive/room/hot_rank", MapsKt__MapsKt.mapOf(pairArr), new b(aVar), 17, 223, null);
        }
    }

    public final void c(a<LiveSearchHotWordListData> aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) || this.a) {
            return;
        }
        this.a = true;
        gb0.h("https://tiebac.baidu.com/bdlive/search/hotWord", MapsKt__MapsKt.mapOf(TuplesKt.to("scene", "tab"), TuplesKt.to("sdk_version", LiveFeedPageSdk.LIVE_SDK_VERSION)), new c(this, aVar), 17, 223, null);
    }

    public final void d(String str, String str2, a<SearchResultBean> aVar, RequestSearchData requestSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, aVar, requestSearchData) == null) {
            gb0.g("https://tiebac.baidu.com/livefeed/search?", MapsKt__MapsKt.mapOf(TuplesKt.to("scene", "tab"), TuplesKt.to("tab", "rec"), TuplesKt.to("word", str), TuplesKt.to("pn", str2), TuplesKt.to("resource", requestSearchData.resource), TuplesKt.to("refresh_index", requestSearchData.refreshIndex), TuplesKt.to("refresh_type", requestSearchData.refreshType), TuplesKt.to("session_id", requestSearchData.sessionId), TuplesKt.to("upload_ids", requestSearchData.uploadIds), TuplesKt.to("channel_id", requestSearchData.channelId), TuplesKt.to("request_type", requestSearchData.requestType), TuplesKt.to("sdk_version", LiveFeedPageSdk.LIVE_SDK_VERSION)), new d(aVar), 17, PassFaceRecogManager.j, null, null, 64, null);
        }
    }

    public final void e(String str, a<LiveSearchSuggestionsBean> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            gb0.g("https://tiebac.baidu.com/livefeed/search/querysug", MapsKt__MapsKt.mapOf(TuplesKt.to(ActVideoSetting.WIFI_DISPLAY, str), TuplesKt.to("scene", "tab"), TuplesKt.to("sdk_version", LiveFeedPageSdk.LIVE_SDK_VERSION)), new e(aVar), 17, 225, null, null, 64, null);
        }
    }

    public final void f(String str, String str2, String str3, String str4, boolean z, String str5, a<Boolean> aVar) {
        boolean z2;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z), str5, aVar}) == null) {
            if (str5.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && !StringsKt__StringsJVMKt.startsWith$default(str5, "sv_", false, 2, null)) {
                str5 = "sv_" + str5;
            }
            Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uk", str3), TuplesKt.to("third_id", str2), TuplesKt.to("source", "star_live_float_android"), TuplesKt.to("room_id", str), TuplesKt.to("type", str4), TuplesKt.to("nid", str5), TuplesKt.to("scene", "tab"));
            if (z) {
                str6 = "https://tiebac.baidu.com/bdlive/user/follow";
            } else {
                str6 = "https://tiebac.baidu.com/bdlive/user/unfollow";
            }
            gb0.h(str6, mapOf, new f(aVar, z), 17, 112, null);
        }
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes5.dex */
public class an9 implements cn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public String d;
    public int e;
    public long f;
    public MetaData g;
    public HashMap<String, MetaData> h;
    public boolean i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public NegativeFeedBackData o;
    public YyExtData p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621085, "Lcom/baidu/tieba/an9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621085, "Lcom/baidu/tieba/an9;");
                return;
            }
        }
        q = BdUniqueId.gen();
    }

    public an9() {
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
        this.l = false;
        this.m = false;
        this.n = false;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0L;
            this.g = null;
            this.h = null;
            this.i = false;
            this.j = null;
            this.k = null;
            this.n = false;
            this.l = false;
        }
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return q;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        boolean z;
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, alaLiveInfo) == null) && alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.a = alaLiveInfo.user_info.user_name;
            this.c = alaLiveInfo.description;
            String str = alaLiveInfo.cover_wide;
            this.d = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.d = alaLiveInfo.cover;
            }
            this.b = alaLiveInfo.audience_count.intValue();
            this.e = alaLiveInfo.live_status.intValue();
            this.f = alaLiveInfo.live_id.longValue();
            if (alaLiveInfo.live_from.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.i = z;
            this.j = alaLiveInfo.third_live_type;
            this.k = alaLiveInfo.third_room_id;
            YyExtData yyExtData = new YyExtData();
            this.p = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            Long l = alaLiveInfo.user_info.user_id;
            if (l != null && l.longValue() > 0 && (hashMap = this.h) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.g = metaData;
                metaData.setIsLike(metaData.hadConcerned());
            }
            List<DislikeInfo> list = alaLiveInfo.dislike_info;
            if (ListUtils.getCount(list) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
                this.o = negativeFeedBackData;
                negativeFeedBackData.setFeedBackReasonMap(sparseArray);
                this.o.feedBackExtraMap = sparseArray2;
            } else {
                this.o = null;
            }
            this.l = true;
        }
    }

    public void c(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.h = hashMap;
        }
    }
}

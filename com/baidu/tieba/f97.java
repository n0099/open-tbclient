package com.baidu.tieba;

import com.baidu.tieba.feed.data.ThreadManageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.LayoutManageInfo;
/* loaded from: classes5.dex */
public final class f97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final q77 a(LayoutManageInfo layoutManageInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutManageInfo)) == null) {
            String str = layoutManageInfo.text;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            String text = layoutManageInfo.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            Integer type = layoutManageInfo.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            q77 q77Var = new q77(text, type.intValue());
            try {
                String ext = layoutManageInfo.ext;
                Intrinsics.checkNotNullExpressionValue(ext, "ext");
                Integer type2 = layoutManageInfo.type;
                Intrinsics.checkNotNullExpressionValue(type2, "type");
                Object c = c(ext, type2.intValue());
                if (c == null) {
                    return null;
                }
                q77Var.d(c);
                return q77Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (q77) invokeL.objValue;
    }

    public static final List<q77> b(List<LayoutManageInfo> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LayoutManageInfo layoutManageInfo : list) {
                q77 a = a(layoutManageInfo);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static final Object c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = 0;
            if (i == ThreadManageType.ID_DEL.getValue()) {
                JSONArray jSONArray = jSONObject.getJSONArray("reason_list");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                while (i2 < length) {
                    r57 a = s57.a(jSONArray.optJSONObject(i2));
                    if (a != null) {
                        arrayList.add(a);
                    }
                    i2++;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return q57.a(arrayList, ea7.a.b(jSONObject.optJSONArray("business_info")));
            } else if (i == ThreadManageType.ID_FORBID.getValue()) {
                return i67.a(ea7.a.b(jSONObject.optJSONArray("business_info")));
            } else {
                if (i == ThreadManageType.ID_TOP.getValue()) {
                    return t77.a(ea7.a.b(jSONObject.optJSONArray("business_info")));
                }
                if (i == ThreadManageType.ID_GOOD.getValue()) {
                    return l67.a(ea7.a.b(jSONObject.optJSONArray("business_info")));
                }
                if (i == ThreadManageType.ID_MULTI_DEL.getValue()) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("reason_list");
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = jSONArray2.length();
                    while (i2 < length2) {
                        r57 a2 = s57.a(jSONArray2.optJSONObject(i2));
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                        i2++;
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    return q57.a(arrayList2, ea7.a.b(jSONObject.optJSONArray("business_info")));
                } else if (i == ThreadManageType.ID_RECOMMEND.getValue()) {
                    return i77.a(a57.a(jSONObject.optJSONObject("bawu_thrones")), ea7.a.b(jSONObject.optJSONArray("business_info")));
                } else {
                    if (i == ThreadManageType.ID_MOVE_AREA.getValue()) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tab_list");
                        ArrayList arrayList3 = new ArrayList();
                        int length3 = jSONArray3.length();
                        while (i2 < length3) {
                            a77 a3 = z67.a(jSONArray3.optJSONObject(i2));
                            if (a3 != null) {
                                arrayList3.add(a3);
                            }
                            i2++;
                        }
                        if (arrayList3.isEmpty()) {
                            return null;
                        }
                        return b77.a(arrayList3, ea7.a.b(jSONObject.optJSONArray("business_info")));
                    } else if (i != ThreadManageType.ID_BROADCAST.getValue()) {
                        return null;
                    } else {
                        return c57.a(ea7.a.b(jSONObject.optJSONArray("business_info")));
                    }
                }
            }
        }
        return invokeLI.objValue;
    }
}

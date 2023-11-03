package com.baidu.tieba;

import com.baidu.tieba.ao1;
import com.baidu.tieba.ar2;
import com.baidu.tieba.ed2;
import com.baidu.tieba.fk3;
import com.baidu.tieba.g42;
import com.baidu.tieba.ga2;
import com.baidu.tieba.kx1;
import com.baidu.tieba.lf3;
import com.baidu.tieba.m93;
import com.baidu.tieba.og2;
import com.baidu.tieba.qe2;
import com.baidu.tieba.tb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HashMap<Class, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            HashMap<Class, Object> hashMap = new HashMap<>();
            hashMap.put(m93.b.class, new m93.b());
            hashMap.put(ed2.f.class, new ed2.f());
            hashMap.put(ed2.g.class, new ed2.g());
            hashMap.put(ga2.a.class, new ga2.a());
            hashMap.put(tb2.a.class, new tb2.a());
            hashMap.put(fk3.c.class, new fk3.c());
            hashMap.put(lf3.b.class, new lf3.b());
            hashMap.put(ar2.c.class, new ar2.c());
            hashMap.put(tx2.class, new tx2());
            hashMap.put(qt1.class, new qt1());
            hashMap.put(rt1.class, new rt1());
            hashMap.put(se3.class, new se3());
            hashMap.put(re3.class, new re3());
            hashMap.put(ve3.class, new ve3());
            hashMap.put(kf2.class, new kf2());
            hashMap.put(qe2.c.class, new qe2.c());
            hashMap.put(dw2.class, new dw2());
            hashMap.put(kx1.b.class, new kx1.b());
            hashMap.put(ao1.a.class, new ao1.a());
            hashMap.put(q42.class, new q42());
            hashMap.put(og2.a.class, new og2.a());
            hashMap.put(og2.b.class, new og2.b());
            hashMap.put(gz2.class, new gz2());
            hashMap.put(g42.b.class, new g42.b());
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ge4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae4 extends sc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae4(hb4 hb4Var, se4 se4Var) {
        super(hb4Var, se4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb4Var, se4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hb4) objArr2[0], (se4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: x */
    public ge4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return tg4.f(jSONObject);
        }
        return (ge4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: v */
    public boolean f(ge4 ge4Var) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ge4Var)) == null) {
            if (ge4Var == null || (list = ge4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (ge4.a aVar : ge4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    lc4 lc4Var = aVar.d;
                    if (lc4Var != null && !lc4Var.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.g;
                    if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: w */
    public gc4 t(ge4 ge4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ge4Var)) == null) {
            this.a.E();
            ug4 ug4Var = new ug4();
            Map v = jb4.i().v();
            ArrayList arrayList = new ArrayList();
            List list = null;
            for (ge4.a aVar : ge4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.v().o(aVar, (PMSAppInfo) v.get(aVar.b), new gc4(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<mc4> list2 = aVar.e;
                        if (list2 != null) {
                            for (mc4 mc4Var : list2) {
                                if (mc4Var != null) {
                                    mc4Var.o = aVar.b;
                                }
                            }
                            p(aVar.e, ug4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = g(aVar.f);
                        if (list != null) {
                            n(list, ug4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.v().l(aVar.g);
                            o(aVar.d, ug4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = (PMSAppInfo) v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo((mc4) aVar.e.get(0));
                                    }
                                    this.a.v().p(aVar.g, null);
                                } else {
                                    this.a.v().o(aVar, null, new gc4(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.v().p(aVar.g, pMSAppInfo3);
                            } else {
                                lc4 lc4Var = aVar.d;
                                if (lc4Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    o(lc4Var, ug4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (ug4Var.n() == 0) {
                this.a.F();
            } else {
                this.a.G(ug4Var);
                xc4.a(ge4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (gc4) invokeL.objValue;
    }
}

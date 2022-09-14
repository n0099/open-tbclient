package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ay6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<x05> c;
    public final List<x05> d;
    public boolean e;

    public ay6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.c = new ArrayList();
        this.d = new ArrayList();
        j();
    }

    public x05 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            x05 x05Var = new x05();
            x05Var.a = i;
            x05Var.b = str;
            x05Var.c = str2;
            x05Var.d = str3;
            return x05Var;
        }
        return (x05) invokeCommon.objValue;
    }

    public x05 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            x05 x05Var = new x05();
            x05Var.a = i;
            x05Var.b = str;
            x05Var.c = str2;
            x05Var.i(i == 5);
            return x05Var;
        }
        return (x05) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return false;
            }
            List<x05> i = i();
            int size = i.size();
            if (size != this.c.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (i.get(i2) != null && !i.get(i2).equals(this.c.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<x05> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, g(R.string.obfuscated_res_0x7f0f1374), ""));
            arrayList.add(b(6, g(R.string.obfuscated_res_0x7f0f1370), ""));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136f), "game"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136c), "digital"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136d), "entertainment"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136e), "films"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f136a), "campus"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1369), "animes"));
            arrayList.add(b(201, g(R.string.obfuscated_res_0x7f0f1373), "sports"));
            arrayList.add(a(202, g(R.string.obfuscated_res_0x7f0f1371), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    @NonNull
    public List<x05> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public List<x05> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final List<x05> i() {
        InterceptResult invokeV;
        x05 x05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(bx4.k().q("key_index_tab_info_list", "[]"));
                List<x05> arrayList2 = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    this.e = true;
                    arrayList2 = d();
                } else {
                    this.e = false;
                }
                boolean isHomeTabModifyABTestA = UbsABTestHelper.isHomeTabModifyABTestA();
                int size = this.e ? arrayList2.size() : jSONArray.length();
                for (int i = 0; i < size; i++) {
                    if (this.e) {
                        x05Var = arrayList2.get(i);
                    } else {
                        x05Var = new x05();
                        x05Var.h(jSONArray.getJSONObject(i));
                    }
                    if (!x05Var.e()) {
                        if (isHomeTabModifyABTestA) {
                            if (x05Var.f() && arrayList.size() < 2) {
                                arrayList.add(x05Var);
                            } else {
                                this.d.add(x05Var);
                            }
                        } else {
                            arrayList.add(x05Var);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<x05> i = i();
            if (ListUtils.isEmpty(i)) {
                return;
            }
            this.c.addAll(i);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<x05> list = this.c;
            if (list != null) {
                list.clear();
            }
            j();
        }
    }
}

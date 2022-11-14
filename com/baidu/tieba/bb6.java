package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bb6 extends qs4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<ab6> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639251, "Lcom/baidu/tieba/bb6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639251, "Lcom/baidu/tieba/bb6;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public bb6() {
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
        f(13);
        this.e = new ArrayList();
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public List<ab6> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0952), R.drawable.obfuscated_res_0x7f0807e6));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0948), R.drawable.obfuscated_res_0x7f0807e2));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0962), R.drawable.obfuscated_res_0x7f0807ee));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094a), R.drawable.obfuscated_res_0x7f0807e3));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094c), R.drawable.obfuscated_res_0x7f0807ef));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f095c), R.drawable.obfuscated_res_0x7f0807e9));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0946), R.drawable.obfuscated_res_0x7f0807e4));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f095a), R.drawable.obfuscated_res_0x7f0807e5));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0958), R.drawable.obfuscated_res_0x7f0807eb));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f095f), R.drawable.obfuscated_res_0x7f0807ea));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0953), R.drawable.obfuscated_res_0x7f0807e7));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f095e), R.drawable.obfuscated_res_0x7f0807e8));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0954), R.drawable.obfuscated_res_0x7f0807ed));
            this.e.add(new ab6(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f095d), R.drawable.obfuscated_res_0x7f0807ec));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}

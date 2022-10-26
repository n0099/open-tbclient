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
/* loaded from: classes4.dex */
public class f96 extends yr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947719014, "Lcom/baidu/tieba/f96;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947719014, "Lcom/baidu/tieba/f96;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public f96() {
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

    public List j() {
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
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0944), R.drawable.obfuscated_res_0x7f0807df));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f093a), R.drawable.obfuscated_res_0x7f0807db));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0954), R.drawable.obfuscated_res_0x7f0807e7));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f093c), R.drawable.obfuscated_res_0x7f0807dc));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f093e), R.drawable.obfuscated_res_0x7f0807e8));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094e), R.drawable.obfuscated_res_0x7f0807e2));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0938), R.drawable.obfuscated_res_0x7f0807dd));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094c), R.drawable.obfuscated_res_0x7f0807de));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094a), R.drawable.obfuscated_res_0x7f0807e4));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0951), R.drawable.obfuscated_res_0x7f0807e3));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0945), R.drawable.obfuscated_res_0x7f0807e0));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0950), R.drawable.obfuscated_res_0x7f0807e1));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0946), R.drawable.obfuscated_res_0x7f0807e6));
            this.e.add(new e96(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094f), R.drawable.obfuscated_res_0x7f0807e5));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}

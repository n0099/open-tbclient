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
public class ff6 extends dt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<ef6> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762259, "Lcom/baidu/tieba/ff6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762259, "Lcom/baidu/tieba/ff6;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public ff6() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public List<ef6> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_game), R.drawable.obfuscated_res_0x7f080814));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_comic), R.drawable.obfuscated_res_0x7f080810));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_sport), R.drawable.obfuscated_res_0x7f08081c));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_digita), R.drawable.obfuscated_res_0x7f080811));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_entertainment), R.drawable.obfuscated_res_0x7f08081d));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_moviezong), R.drawable.obfuscated_res_0x7f080817));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_campus), R.drawable.obfuscated_res_0x7f080812));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_motion), R.drawable.obfuscated_res_0x7f080813));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_local), R.drawable.obfuscated_res_0x7f080819));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_science), R.drawable.obfuscated_res_0x7f080818));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_history), R.drawable.obfuscated_res_0x7f080815));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_novel), R.drawable.obfuscated_res_0x7f080816));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_industry), R.drawable.obfuscated_res_0x7f08081b));
            this.e.add(new ef6(TbadkApplication.getInst().getString(R.string.interested_class_name_music), R.drawable.obfuscated_res_0x7f08081a));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}

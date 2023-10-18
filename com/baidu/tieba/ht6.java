package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.ManageInfo;
/* loaded from: classes6.dex */
public class ht6 implements yh {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId g;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    public static boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 3 || i == 4 : invokeI.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835295, "Lcom/baidu/tieba/ht6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835295, "Lcom/baidu/tieba/ht6;");
                return;
            }
        }
        g = BdUniqueId.gen();
    }

    public ht6() {
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
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.e = false;
        this.f = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public ht6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ht6 ht6Var = new ht6();
            ht6Var.a = this.a;
            ht6Var.b = this.b;
            ht6Var.c = this.c;
            ht6Var.d = this.d;
            ht6Var.e = this.e;
            ht6Var.f = this.f;
            return ht6Var;
        }
        return (ht6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return g;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static ht6 b(sb5 sb5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sb5Var)) == null) {
            ht6 ht6Var = new ht6();
            ht6Var.a = sb5Var.b;
            ht6Var.b = sb5Var.d;
            ht6Var.c = sb5Var.e;
            return ht6Var;
        }
        return (ht6) invokeL.objValue;
    }

    public static ht6 c(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            ht6 ht6Var = new ht6();
            ItemData itemData = new ItemData();
            ht6Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            ht6Var.b = manageInfo.item_source.intValue();
            return ht6Var;
        }
        return (ht6) invokeL.objValue;
    }

    public boolean d(ht6 ht6Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ht6Var)) == null) {
            if (this.b == ht6Var.b && this.c == ht6Var.c) {
                z = true;
            } else {
                z = false;
            }
            ItemData itemData3 = this.a;
            if (itemData3 != null && (itemData2 = ht6Var.a) != null) {
                z2 = itemData3.pkgName.equals(itemData2.pkgName);
            } else {
                z2 = false;
            }
            ItemData itemData4 = this.a;
            if (itemData4 != null && (itemData = ht6Var.a) != null && (apkDetail = itemData4.apkDetail) != null && (apkDetail2 = itemData.apkDetail) != null) {
                z3 = apkDetail.version_code.equals(apkDetail2.version_code);
            } else {
                z3 = false;
            }
            if (z && z2 && z3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

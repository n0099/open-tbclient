package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes5.dex */
public class af {
    public static /* synthetic */ Interceptable $ic = null;
    public static String e = "_crashtime";
    public static String f = "_crashtype";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public ze c;
    public xe d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448299560, "Lcom/baidu/tieba/af;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448299560, "Lcom/baidu/tieba/af;");
        }
    }

    public af(ze zeVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zeVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = null;
        this.d = (xe) ServiceManager.getService(xe.a);
        if (zeVar != null) {
            this.c = zeVar;
            if (zeVar.d() > 0 && this.c.c() != null) {
                int e2 = e();
                this.a = e2;
                if (e2 == -1) {
                    g();
                }
            }
            if (!zeVar.h()) {
                this.b = f();
            }
            this.c.a(this.b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            xe xeVar = this.d;
            if (xeVar == null || xeVar.isTypeSp() || this.d.isTypeDoubleKv() || this.d.isTypeDoubleSp()) {
                SharedPreferences.Editor edit = BdBaseApplication.getInst().getSharedPreferences("adp_feature_switch2", 0).edit();
                edit.putInt(this.c.e() + e, i);
                edit.commit();
            }
            xe xeVar2 = this.d;
            if (xeVar2 == null || xeVar2.isTypeDoubleSp() || this.d.isTypeDoubleKv()) {
                SharedPreferences.Editor edit2 = KVStorageFactory.getSharedPreferences("adp_feature_switch2", 0).edit();
                edit2.putInt(this.c.e() + e, i);
                edit2.commit();
            }
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            xe xeVar = this.d;
            if (xeVar == null || xeVar.isTypeSp() || this.d.isTypeDoubleKv() || this.d.isTypeDoubleSp()) {
                SharedPreferences.Editor edit = BdBaseApplication.getInst().getSharedPreferences("adp_feature_switch2", 0).edit();
                edit.putInt(this.c.e() + f, i);
                edit.commit();
            }
            xe xeVar2 = this.d;
            if (xeVar2 == null || xeVar2.isTypeDoubleSp() || this.d.isTypeDoubleKv()) {
                SharedPreferences.Editor edit2 = KVStorageFactory.getSharedPreferences("adp_feature_switch2", 0).edit();
                edit2.putInt(this.c.e() + f, i);
                edit2.commit();
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        String[] g;
        String[] c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null && this.c.d() > 0) {
                if (this.c.c() != null) {
                    for (String str2 : this.c.c()) {
                        if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                            int i = this.a + 1;
                            this.a = i;
                            j(i);
                            if (this.a >= this.c.d()) {
                                k(this.c.f());
                                this.b = this.c.f();
                                ze zeVar = this.c;
                                zeVar.a(zeVar.f(), false);
                            }
                            return true;
                        }
                    }
                }
                if (this.c.g() != null) {
                    for (String str3 : this.c.g()) {
                        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                            int i2 = this.a + 1;
                            this.a = i2;
                            j(i2);
                            if (this.a >= this.c.d()) {
                                k(this.c.f());
                                this.b = this.c.f();
                                ze zeVar2 = this.c;
                                zeVar2.a(zeVar2.f(), false);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ze b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ze) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.b();
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.e();
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = 0;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xe xeVar = this.d;
            if (xeVar != null && !xeVar.isTypeSp() && !this.d.isTypeDoubleSp()) {
                sharedPreferences = KVStorageFactory.getSharedPreferences("adp_feature_switch2", 0);
            } else {
                sharedPreferences = BdBaseApplication.getInst().getSharedPreferences("adp_feature_switch2", 0);
            }
            return sharedPreferences.getInt(this.c.e() + e, -1);
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            xe xeVar = this.d;
            if (xeVar != null && !xeVar.isTypeSp() && !this.d.isTypeDoubleSp()) {
                sharedPreferences = KVStorageFactory.getSharedPreferences("adp_feature_switch2", 0);
            } else {
                sharedPreferences = BdBaseApplication.getInst().getSharedPreferences("adp_feature_switch2", 0);
            }
            return sharedPreferences.getInt(this.c.e() + f, this.c.b());
        }
        return invokeV.intValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.c.d() >= 0 && this.a >= this.c.d() + 2) {
                i = this.c.f();
            }
            if (i == this.b) {
                return false;
            }
            this.b = i;
            this.c.a(i, false);
            k(i);
            return true;
        }
        return invokeI.booleanValue;
    }
}

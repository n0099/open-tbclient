package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d65 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "lottie_feed_new_agree/";
    public static final String c = "lottie_feed_new_agree/";
    public static final String d = "lottie_feed_new_agree/";
    public static final String e = "lottie_feed_new_agree/";
    public static final String f = "lottie_pb_new_double_tap_agree/";
    public static final String g = "lottie_pb_new_double_tap_agree_1/";
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeMaterial a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final d65 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-907846264, "Lcom/baidu/tieba/d65$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-907846264, "Lcom/baidu/tieba/d65$b;");
                    return;
                }
            }
            a = new d65(null);
        }
    }

    public d65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static d65 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (d65) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.doubleTapData) != null) {
                return data.activityId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
                return data.activityId;
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.singleTapData) != null) {
                return data.activityId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ d65(a aVar) {
        this();
    }

    public void a(AgreeMaterial agreeMaterial) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, agreeMaterial) == null) {
            this.a = agreeMaterial;
            if (agreeMaterial == null) {
                return;
            }
            AgreeMaterial.Data data = agreeMaterial.staticData;
            if (data != null) {
                data.z();
            }
            AgreeMaterial.Data data2 = agreeMaterial.singleTapData;
            if (data2 != null) {
                data2.z();
            }
            AgreeMaterial.Data data3 = agreeMaterial.doubleTapData;
            if (data3 != null) {
                data3.z();
            }
            AgreeMaterial.Data data4 = agreeMaterial.longPressData;
            if (data4 != null) {
                data4.z();
            }
        }
    }

    public void b(String str, String str2, c65 c65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, c65Var) == null) {
            d("", str, str2, true, 2, c65Var);
        }
    }

    public final void m(int i, String str, c65 c65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, str, c65Var) == null) {
            if (i != 1) {
                if (i != 2) {
                    c65Var.a(0, null);
                    return;
                } else {
                    j(c65Var);
                    return;
                }
            }
            n(c65Var, str);
        }
    }

    public void c(b65 b65Var) {
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b65Var) != null) || b65Var == null) {
            return;
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
            String B = data.B("", "", "");
            if (StringUtils.isNull(B)) {
                l(b65Var);
                return;
            } else {
                k(B, b65Var);
                return;
            }
        }
        l(b65Var);
    }

    public final void j(@NonNull c65 c65Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c65Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            if (z) {
                i = R.raw.obfuscated_res_0x7f110048;
            } else {
                i = R.raw.obfuscated_res_0x7f110047;
            }
            if (z) {
                str = g;
            } else {
                str = f;
            }
            c65Var.a(i, str);
        }
    }

    public final void d(String str, String str2, String str3, boolean z, int i, c65 c65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i), c65Var}) != null) || c65Var == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && z) {
            AgreeMaterial.Data data = null;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            data = agreeMaterial.longPressData;
                        }
                    } else {
                        data = agreeMaterial.doubleTapData;
                    }
                } else {
                    data = agreeMaterial.singleTapData;
                }
            } else {
                data = agreeMaterial.staticData;
            }
            if (data == null) {
                m(i, str, c65Var);
                return;
            }
            String B = data.B(str, str2, str3);
            if (StringUtils.isNull(B)) {
                m(i, str, c65Var);
                return;
            } else {
                c65Var.b(B);
                return;
            }
        }
        m(i, str, c65Var);
    }

    public void e(String str, String str2, String str3, boolean z, c65 c65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z), c65Var}) == null) {
            d(str, str2, str3, z, 1, c65Var);
        }
    }

    public final void k(String str, b65 b65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, b65Var) == null) {
            ArrayList arrayList = new ArrayList();
            File file = new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/" + str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        arrayList.add(BitmapFactory.decodeFile(file2.toString()));
                    }
                    b65Var.a(arrayList);
                    return;
                }
                l(b65Var);
                return;
            }
            l(b65Var);
        }
    }

    public final void n(@NonNull c65 c65Var, String str) {
        int i;
        String str2;
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, c65Var, str) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            if (skinType != 4 && skinType != 1) {
                z = false;
            }
            if ("/feed".equals(str)) {
                if (z) {
                    i2 = R.raw.obfuscated_res_0x7f11003c;
                } else {
                    i2 = R.raw.obfuscated_res_0x7f11003b;
                }
                if (z) {
                    str3 = d;
                } else {
                    str3 = b;
                }
                c65Var.a(i2, str3);
            } else if ("/duang1".equals(str)) {
                c65Var.a(R.raw.obfuscated_res_0x7f110039, "lottie_feed_firework_duang1/");
            } else if ("/duang2".equals(str)) {
                c65Var.a(R.raw.obfuscated_res_0x7f11003a, "lottie_feed_firework_duang2/");
            } else {
                if (z) {
                    i = R.raw.obfuscated_res_0x7f110046;
                } else {
                    i = R.raw.obfuscated_res_0x7f110045;
                }
                if (z) {
                    str2 = e;
                } else {
                    str2 = c;
                }
                c65Var.a(i, str2);
            }
        }
    }

    public final void l(b65 b65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b65Var) == null) {
            ArrayList arrayList = new ArrayList();
            Bitmap decodeResource = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08088c);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08088d);
            Bitmap decodeResource3 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08088e);
            Bitmap decodeResource4 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f08088f);
            Bitmap decodeResource5 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080890);
            arrayList.add(decodeResource);
            arrayList.add(decodeResource2);
            arrayList.add(decodeResource3);
            arrayList.add(decodeResource4);
            arrayList.add(decodeResource5);
            b65Var.a(arrayList);
        }
    }
}

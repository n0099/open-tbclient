package com.baidu.tieba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class hh3 {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);

    /* loaded from: classes4.dex */
    public class a extends hh3 {
        public static /* synthetic */ Interceptable $ic;
        public static ClipboardManager b;
        public static ClipData c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-747213223, "Lcom/baidu/tieba/hh3$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-747213223, "Lcom/baidu/tieba/hh3$a;");
            }
        }

        public a() {
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
            b = (ClipboardManager) hh3.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }

        @Override // com.baidu.tieba.hh3
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    c = b.getPrimaryClip();
                } catch (Exception e) {
                    if (wj1.a) {
                        throw e;
                    }
                }
                ClipData clipData = c;
                if (clipData != null && clipData.getItemCount() > 0) {
                    return c.getItemAt(0).getText();
                }
                return "";
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // com.baidu.tieba.hh3
        public void c(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
                c = newPlainText;
                try {
                    b.setPrimaryClip(newPlainText);
                } catch (RuntimeException e) {
                    if (wj1.a) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends hh3 {
        public static /* synthetic */ Interceptable $ic;
        public static android.text.ClipboardManager b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-747213192, "Lcom/baidu/tieba/hh3$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-747213192, "Lcom/baidu/tieba/hh3$b;");
            }
        }

        public b() {
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
            b = (android.text.ClipboardManager) hh3.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }

        @Override // com.baidu.tieba.hh3
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.getText();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // com.baidu.tieba.hh3
        public void c(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                b.setText(charSequence);
            }
        }
    }

    public hh3() {
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

    public static hh3 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            a = context.getApplicationContext();
            if (tf3.c()) {
                return new a();
            }
            return new b();
        }
        return (hh3) invokeL.objValue;
    }
}

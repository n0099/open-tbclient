package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class if4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947851570, "Lcom/baidu/tieba/if4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947851570, "Lcom/baidu/tieba/if4;");
        }
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return "popview";
                }
                return "list";
            }
            return "carousel";
        }
        return (String) invokeI.objValue;
    }

    public if4() {
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
        this.a = new ArrayList();
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            return String.format("%s_%s:%s", str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    public void b(int i, String str, String str2, String str3) {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String g = g(i);
            if (zb3.M() == null) {
                O = null;
            } else {
                O = zb3.M().O();
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "click";
            bj3Var.g = g;
            bj3Var.e = str;
            if (str2 != null) {
                bj3Var.a("target_appkey", str2);
            }
            bj3Var.a("current_appkey", O);
            if (!TextUtils.isEmpty(str3)) {
                bj3Var.a("location", str3);
            }
            si3.g(bj3Var);
        }
    }

    public void c(int i, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, of4Var) == null) {
            String g = g(i);
            JSONArray f = f(of4Var);
            bj3 bj3Var = new bj3();
            bj3Var.b = "show";
            bj3Var.g = g;
            if (f != null) {
                bj3Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            si3.g(bj3Var);
        }
    }

    public void e(int i, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, of4Var) == null) {
            String g = g(i);
            JSONArray f = f(of4Var);
            bj3 bj3Var = new bj3();
            bj3Var.b = "show";
            bj3Var.g = g;
            if (f != null) {
                bj3Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            si3.g(bj3Var);
            this.a.clear();
        }
    }

    public void d(int i, String str, String str2) {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            String g = g(i);
            String a = a(g, str, str2);
            if (this.a.contains(a)) {
                return;
            }
            if (zb3.M() == null) {
                O = null;
            } else {
                O = zb3.M().O();
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "click";
            bj3Var.g = g;
            bj3Var.e = str;
            if (str2 != null) {
                bj3Var.a("target_appkey", str2);
            }
            bj3Var.a("current_appkey", O);
            si3.g(bj3Var);
            this.a.add(a);
        }
    }

    public final JSONArray f(of4 of4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, of4Var)) == null) {
            if (of4Var != null && of4Var.b != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecommendItemModel recommendItemModel : of4Var.b) {
                    jSONArray.put(recommendItemModel.appKey);
                }
                return jSONArray;
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }
}

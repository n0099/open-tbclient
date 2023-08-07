package com.baidu.tbadk.mainTab;

import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.mainTab.dynamicIcon.DynamicIconData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FragmentTabStructure {
    public static /* synthetic */ Interceptable $ic = null;
    public static int SHOWBOTH = 3;
    public static int SHOWICON = 1;
    public static int SHOWLOTTIE = 4;
    public static int SHOWTEXT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int animationResId;
    public int backgroundId;
    public int drawableResId;
    public DynamicIconData dynamicIconData;
    public Fragment frag;
    public Pair<String, String> iconPair;
    public String imageIconUrl;
    public int showIconType;
    public String text;
    public int textResId;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1753863607, "Lcom/baidu/tbadk/mainTab/FragmentTabStructure;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1753863607, "Lcom/baidu/tbadk/mainTab/FragmentTabStructure;");
        }
    }

    public FragmentTabStructure() {
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
        this.showIconType = SHOWICON;
    }
}

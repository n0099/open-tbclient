package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.StateInfo;
import tbclient.VirtualImageInfo;
/* loaded from: classes4.dex */
public class g48 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g48 e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public w45 b;
    public List<w45> c;
    public boolean d;

    public g48() {
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

    public static g48 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (g48.class) {
                    e = new g48();
                }
            }
            return e;
        }
        return (g48) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void d(VirtualImageInfo virtualImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, virtualImageInfo) == null) || virtualImageInfo == null) {
            return;
        }
        this.a = virtualImageInfo.isset_virtual_image.intValue();
        String str = virtualImageInfo.virtual_image_url;
        virtualImageInfo.image_agree_count.intValue();
        virtualImageInfo.is_allow_agree.intValue();
        virtualImageInfo.virtual_background_type.intValue();
        String str2 = virtualImageInfo.virtual_background;
        virtualImageInfo.recent_incr_agree.intValue();
        virtualImageInfo.snapshoot_id.intValue();
        if (virtualImageInfo.personal_state != null) {
            w45 w45Var = new w45();
            this.b = w45Var;
            w45Var.d(virtualImageInfo.personal_state);
        }
        if (virtualImageInfo.state_list != null) {
            this.c = new ArrayList();
            for (int i = 0; i < virtualImageInfo.state_list.size(); i++) {
                StateInfo stateInfo = virtualImageInfo.state_list.get(i);
                if (stateInfo != null) {
                    w45 w45Var2 = new w45();
                    w45Var2.d(stateInfo);
                    this.c.add(w45Var2);
                }
            }
        }
        virtualImageInfo.allow_customize.intValue();
        this.d = true;
    }
}

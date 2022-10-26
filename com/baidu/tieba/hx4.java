package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindNormalConfigData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class hx4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hx4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindData a;
    public LiveRemindNormalConfigData b;
    public List c;

    public hx4() {
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

    public static hx4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (hx4.class) {
                    if (d == null) {
                        d = new hx4();
                    }
                }
            }
            return d;
        }
        return (hx4) invokeV.objValue;
    }

    public final void b() {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.c) != null && list.size() >= 1) {
            LiveRemindConfig.c().e((LiveRemindRecommendData) this.c.get(0));
        }
    }

    public LiveRemindRecommendData c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.c != null) {
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    if (this.c.get(i2) != null && ((LiveRemindRecommendData) this.c.get(i2)).getShowPage() == i) {
                        return (LiveRemindRecommendData) this.c.get(i2);
                    }
                }
            }
            return null;
        }
        return (LiveRemindRecommendData) invokeI.objValue;
    }

    public void d(LiveRemindData liveRemindData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveRemindData) != null) || liveRemindData == null) {
            return;
        }
        this.a = liveRemindData;
        this.b = liveRemindData.getNormalConfig();
        this.c = liveRemindData.getLiveRecommendList();
        b();
    }
}

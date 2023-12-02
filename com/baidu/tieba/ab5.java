package com.baidu.tieba;

import com.baidu.tbadk.core.view.spanGroup.DownKeyChecker;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tbadk.data.WebViewWhitePageList;
import com.baidu.tbadk.tracker.LogUploadConfig;
import com.baidu.tieba.ii8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ab5 implements pf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ab5() {
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

    @Override // com.baidu.tieba.pf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DownKeyChecker.a());
            arrayList.add(new PluginCheck.a());
            arrayList.add(new WebViewWhitePageList.a());
            arrayList.add(new LogUploadConfig());
            arrayList.add(new nc8());
            arrayList.add(new ii8.b());
            arrayList.add(new ac9());
            arrayList.add(new t4a());
            arrayList.add(new era());
            return arrayList;
        }
        return invokeV.objValue;
    }
}

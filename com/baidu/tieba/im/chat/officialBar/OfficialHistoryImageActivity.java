package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x77;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class OfficialHistoryImageActivity extends AbsMsgImageActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OfficialHistoryImageActivity() {
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

    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    public void queryAllBigImageUrls(String str, x77 x77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, x77Var) == null) {
            x77Var.a(new LinkedHashMap<>(), new HashMap<>());
        }
    }
}
